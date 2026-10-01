package com.openai.services.beta.agents

import com.openai.core.http.AsyncStreamResponse
import com.openai.models.beta.agents.AgentSessionEvent
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.concurrent.atomic.AtomicBoolean

internal class AgentTurnResultStreamAsync(
    private val source: AsyncStreamResponse<AgentSessionEvent>,
    private val collector: AgentTurnCollector,
) : AsyncStreamResponse<AgentSessionEvent> {
    private val subscribed = AtomicBoolean()
    private val closed = AtomicBoolean()
    private val requested = AtomicBoolean()
    private val result = CompletableFuture<AgentTurnResult>()
    private val lock = collector

    init {
        result.whenComplete { _, _ -> if (result.isCancelled) close() }
        source.onCompleteFuture().whenComplete { _, cause ->
            synchronized(lock) { if (cause != null) collector.failed(cause) }
            complete()
        }
    }

    override fun subscribe(
        handler: AsyncStreamResponse.Handler<AgentSessionEvent>
    ): AsyncStreamResponse<AgentSessionEvent> = apply {
        check(subscribed.compareAndSet(false, true)) { "Cannot subscribe more than once" }
        source.subscribe(observing(handler))
    }

    override fun subscribe(
        handler: AsyncStreamResponse.Handler<AgentSessionEvent>,
        executor: Executor,
    ): AsyncStreamResponse<AgentSessionEvent> = apply {
        check(subscribed.compareAndSet(false, true)) { "Cannot subscribe more than once" }
        source.subscribe(observing(handler), executor)
    }

    private fun observing(handler: AsyncStreamResponse.Handler<AgentSessionEvent>) =
        object : AsyncStreamResponse.Handler<AgentSessionEvent> {
            override fun onNext(value: AgentSessionEvent) {
                synchronized(lock) { collector.accept(value) }
                handler.onNext(value)
                val stop =
                    synchronized(lock) {
                        requested.get() &&
                            (collector.isReady() || collector.stoppingError() != null)
                    }
                if (stop) finish()
            }

            override fun onComplete(error: Optional<Throwable>) {
                synchronized(lock) { error.ifPresent(collector::failed) }
                handler.onComplete(error)
            }
        }

    fun enableResultCollection() = synchronized(lock) { collector.enable() }

    fun finalResult(): CompletableFuture<AgentTurnResult> {
        enableResultCollection()
        if (closed.get()) synchronized(lock) { collector.closed() }
        requested.set(true)
        val stop = synchronized(lock) { collector.isReady() || collector.stoppingError() != null }
        if (stop) finish()
        else if (!closed.get() && subscribed.compareAndSet(false, true)) {
            try {
                source.subscribe(observing(AsyncStreamResponse.Handler {}))
            } catch (cause: Throwable) {
                synchronized(lock) { collector.failed(cause) }
                finish()
            }
        }
        if (source.onCompleteFuture().isDone) {
            source.onCompleteFuture().whenComplete { _, cause ->
                synchronized(lock) { if (cause != null) collector.failed(cause) }
                complete()
            }
        }
        return result
    }

    /** Never invoke user future callbacks while holding the collector lock. */
    private fun complete() {
        if (result.isDone) return
        val snapshot =
            synchronized(lock) {
                if (!collector.isEnabled()) return
                runCatching { collector.finalResult() }
            }
        snapshot.fold(result::complete, result::completeExceptionally)
    }

    override fun onCompleteFuture(): CompletableFuture<Void?> = source.onCompleteFuture()

    private fun finish() {
        // Resolving the source future invokes complete(); result callbacks can safely await it.
        if (closed.compareAndSet(false, true)) source.close()
    }

    override fun close() {
        synchronized(lock) { if (!closed.get()) collector.closed() }
        finish()
    }
}
