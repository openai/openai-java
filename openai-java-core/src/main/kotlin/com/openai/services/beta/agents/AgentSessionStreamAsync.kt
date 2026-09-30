package com.openai.services.beta.agents

import com.openai.core.RequestOptions
import com.openai.core.http.AsyncStreamResponse
import com.openai.core.http.StreamResponse
import com.openai.models.beta.agents.AgentSessionEvent
import com.openai.models.beta.agents.AgentSessionStreamParams
import com.openai.models.beta.agents.sessions.events.EventCreateParams
import com.openai.services.async.beta.agents.SessionServiceAsync
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.concurrent.atomic.AtomicBoolean

/** Async one-turn stream; uses the SDK executor and never allocates a thread pool. */
internal class AgentSessionStreamAsync(
    private val sessions: SessionServiceAsync,
    params: AgentSessionStreamParams,
    private val options: RequestOptions,
    private val defaultExecutor: Executor,
    private val sleeper: com.openai.core.Sleeper,
) : AsyncStreamResponse<AgentSessionEvent> {
    private val support = AgentSessionStreamSupport(params)
    private val subscribed = AtomicBoolean()
    private val closed = AtomicBoolean()
    private val submissionLock = Any()
    private val notified = AtomicBoolean()
    private val completion = CompletableFuture<Void?>()
    @Volatile
    private var openingResponse:
        com.openai.core.http.HttpResponseFor<StreamResponse<AgentSessionEvent>>? =
        null
    @Volatile private var source: StreamResponse<AgentSessionEvent>? = null
    @Volatile private var active: CompletableFuture<*>? = null
    private lateinit var iterator: Iterator<AgentSessionEvent>
    @Volatile private lateinit var handler: AsyncStreamResponse.Handler<AgentSessionEvent>
    @Volatile private lateinit var executor: Executor
    private val tasks = java.util.concurrent.ConcurrentLinkedQueue<() -> Unit>()
    private val executing = AtomicBoolean()

    init {
        completion.whenComplete { _, _ -> if (completion.isCancelled) close() }
    }

    override fun subscribe(handler: AsyncStreamResponse.Handler<AgentSessionEvent>) =
        subscribe(handler, defaultExecutor)

    override fun subscribe(
        handler: AsyncStreamResponse.Handler<AgentSessionEvent>,
        executor: Executor,
    ): AsyncStreamResponse<AgentSessionEvent> = apply {
        check(subscribed.compareAndSet(false, true) && !closed.get()) {
            "Cannot subscribe more than once or after close"
        }
        this.handler = handler
        this.executor = executor
        if (closed.get()) {
            execute { notifyComplete(null) }
            return@apply
        }
        await(sessions.retrieve(support.retrieveParams(), options), cancelOnClose = false) { session
            ->
            support.checkIdle(session)
            val opening =
                sessions.events().withRawResponse().streamStreaming(support.streamParams(), options)
            // Closing during an in-flight open must also close the eventual HTTP response.
            opening.whenComplete { response, _ ->
                openingResponse = response
                if (closed.get()) response?.close()
            }
            await(opening, cancelOnClose = false) { response ->
                openingResponse = response
                val stream =
                    try {
                        response.parse()
                    } catch (error: Throwable) {
                        response.close()
                        throw error
                    }
                source = stream
                if (closed.get()) {
                    stream.close()
                    return@await
                }
                iterator = stream.stream().iterator()
                create(support.inputParams())?.let { await(it) { pump() } }
            }
        }
    }

    private fun <T> await(
        future: CompletableFuture<T>,
        cancelOnClose: Boolean = true,
        next: (T) -> Unit,
    ) {
        active = if (cancelOnClose) future else null
        if (closed.get() && cancelOnClose) future.cancel(true)
        future.whenComplete { value, error ->
            execute {
                active = null
                if (closed.get()) {
                    notifyComplete(null)
                    return@execute
                }
                if (error != null) finish(unwrap(error))
                else {
                    try {
                        next(value)
                    } catch (failure: Throwable) {
                        finish(unwrap(failure))
                    }
                }
            }
        }
    }

    private fun execute(block: () -> Unit) {
        tasks.add(block)
        if (!executing.compareAndSet(false, true)) return
        try {
            executor.execute {
                do {
                    while (true) {
                        val task = tasks.poll() ?: break
                        try {
                            task()
                        } catch (error: Throwable) {
                            finish(error)
                        }
                    }
                    executing.set(false)
                } while (tasks.isNotEmpty() && executing.compareAndSet(false, true))
            }
        } catch (error: Throwable) {
            executing.set(false)
            tasks.clear()
            finish(error)
        }
    }

    private fun pump() {
        try {
            while (!closed.get()) {
                val hasNext =
                    try {
                        iterator.hasNext()
                    } catch (error: Throwable) {
                        if (closed.get()) {
                            notifyComplete(null)
                            return
                        }
                        throw error
                    }
                if (closed.get()) {
                    notifyComplete(null)
                    return
                }
                if (!hasNext) throw support.unexpectedEnd()
                val event = iterator.next()
                if (!support.accept(event)) continue
                val terminal = support.terminal(event)
                if (terminal) source?.close()
                handler.onNext(event)
                if (closed.get()) {
                    notifyComplete(null)
                    return
                }
                if (terminal) {
                    finish(null)
                    return
                }
                await(support.result(event)) { result ->
                    if (result == null) pump() else submit(result, 0)
                }
                return
            }
            notifyComplete(null)
        } catch (error: Throwable) {
            finish(unwrap(error))
        }
    }

    private fun create(params: EventCreateParams): CompletableFuture<Void?>? =
        synchronized(submissionLock) {
            if (closed.get()) return@synchronized null
            val response = sessions.events().withRawResponse().create(params, options)
            // Keep cleanup attached to the original future even if the consumer cancels its stage.
            response.whenComplete { value, _ -> value?.close() }
            response
                .thenApply<Void?> { value ->
                    value.close()
                    null
                }
                .also { active = it }
        }

    private fun submit(result: EventCreateParams, attempt: Int) {
        val future = create(result) ?: return
        future.whenComplete { _, error ->
            execute {
                active = null
                if (closed.get()) {
                    notifyComplete(null)
                    return@execute
                }
                if (error == null) pump()
                else if (attempt < 3 && support.pendingCallRace(error, result)) {
                    await(
                        sleeper
                            .sleepAsync(
                                java.time.Duration.ofMillis(longArrayOf(100, 300, 600)[attempt])
                            )
                            .thenApply { _: Void? -> Unit }
                    ) {
                        submit(result, attempt + 1)
                    }
                } else finish(unwrap(error))
            }
        }
    }

    private fun finish(error: Throwable?) {
        if (synchronized(submissionLock) { closed.compareAndSet(false, true) }) {
            try {
                try {
                    openingResponse?.close()
                } finally {
                    source?.close()
                }
            } finally {
                if (error == null) completion.complete(null)
                else completion.completeExceptionally(error)
            }
        }
        notifyComplete(error)
    }

    private fun notifyComplete(error: Throwable?) {
        if (notified.compareAndSet(false, true)) handler.onComplete(Optional.ofNullable(error))
    }

    override fun onCompleteFuture(): CompletableFuture<Void?> = completion

    override fun close() {
        if (synchronized(submissionLock) { closed.compareAndSet(false, true) }) {
            try {
                active?.cancel(true)
                try {
                    openingResponse?.close()
                } finally {
                    source?.close()
                }
            } finally {
                completion.complete(null)
                if (::handler.isInitialized && ::executor.isInitialized)
                    execute { notifyComplete(null) }
            }
        }
    }
}
