package com.openai.services.beta.agents

import com.openai.core.RequestOptions
import com.openai.core.http.AsyncStreamResponse
import com.openai.core.http.StreamResponse
import com.openai.models.beta.agents.AgentSession
import com.openai.models.beta.agents.AgentSessionEvent
import com.openai.models.beta.agents.AgentSessionStreamParams
import com.openai.models.beta.agents.sessions.events.EventCreateParams
import com.openai.models.beta.agents.sessions.turns.Turn
import com.openai.services.async.beta.agents.SessionServiceAsync
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.jvm.optionals.getOrNull

/** Async one-turn stream; uses the SDK executor and never allocates a thread pool. */
internal class AgentSessionStreamAsync(
    private val sessions: SessionServiceAsync,
    params: AgentSessionStreamParams,
    private val options: RequestOptions,
    private val defaultExecutor: Executor,
    private val sleeper: com.openai.core.Sleeper,
) : AsyncStreamResponse<AgentSessionEvent> {
    private val support = AgentSessionStreamSupport(params)
    internal val collector =
        AgentTurnCollector(params.handlers.keys, params.sessionId, support.attaching)
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
        if (support.attaching) synchronized(collector) { collector.startAttachment() }
        if (closed.get()) {
            execute { notifyComplete(null) }
            return@apply
        }
        if (support.attaching) findActiveTurn(beforeOpen = true) { open() }
        else
            await(sessions.retrieve(support.retrieveParams(), options), cancelOnClose = false) {
                session ->
                support.checkIdle(session)
                open()
            }
    }

    private fun open() {
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
            if (support.attaching)
                refreshTurn {
                    await(sessions.retrieve(support.retrieveParams(), options)) { session ->
                        if (
                            session.status() == AgentSession.Status.FAILED &&
                                support.selectedTurn != null
                        )
                            refreshTurn { observedSession(session) }
                        else observedSession(session)
                    }
                }
            else create(support.inputParams())?.let { await(it) { pump() } }
        }
    }

    private fun observedSession(session: AgentSession) {
        support.observeSession(session)
        val enabled = synchronized(collector) { collector.isEnabled() }
        if (enabled && session.requiredActions().any { !it.isFunctionCall() })
            refreshTurn {
                if (session.requiredActions().any { it.isEnvironmentConnection() })
                    findLatestRoot { readyAttachment(session, it?.id()) }
                else readyAttachment(session)
            }
        else readyAttachment()
    }

    private fun readyAttachment(session: AgentSession? = null, latestRootId: String? = null) {
        val stop =
            synchronized(collector) {
                collector.selectAttachedTurn(support.selectedTurn)
                session?.let { collector.manualActions(support.manualActions(it, latestRootId)) }
                collector.stoppingError() != null
            }
        if (support.settled || stop) reconcile { finish(null) } else pump()
    }

    private fun findActiveTurn(beforeOpen: Boolean = false, done: () -> Unit) {
        findLatestRoot { root ->
            if (root != null) {
                if (beforeOpen) support.baselineRootId = root.id()
                support.select(root, activeOnly = beforeOpen)
            }
            done()
        }
    }

    private fun findLatestRoot(after: String? = null, done: (Turn?) -> Unit) {
        await(sessions.turns().list(support.turnListParams(after), options)) { page ->
            val root = page.data().firstOrNull { !it.subagentId().isPresent }
            if (root != null || !page.hasNextPage()) done(root)
            else findLatestRoot(page.nextPageParams().after().getOrNull(), done)
        }
    }

    private fun refreshTurn(done: () -> Unit) {
        val selected = support.selectedTurn
        if (selected == null) findActiveTurn(done = done)
        else
            await(sessions.turns().retrieve(support.turnRetrieveParams(selected.id()), options)) {
                support.select(it)
                done()
            }
    }

    private fun reconcile(
        after: String? = null,
        index: Long = 0,
        failed: (Throwable) -> Unit = { finish(it) },
        done: () -> Unit,
    ) {
        val enabled =
            synchronized(collector) {
                collector.selectAttachedTurn(support.selectedTurn)
                collector.isEnabled()
            }
        if (!enabled) {
            done()
            return
        }
        if (
            support.selectedTurn == null ||
                (!support.sessionFailed &&
                    support.selectedTurn?.status() !in
                        setOf(Turn.Status.COMPLETED, Turn.Status.FAILED, Turn.Status.CANCELLED))
        ) {
            synchronized(collector) { collector.attachedIdle(support.sessionFailed) }
            done()
            return
        }
        await(sessions.items().list(support.itemListParams(after), options), failed = failed) { page
            ->
            synchronized(collector) {
                page.data().forEachIndexed { offset, item ->
                    item.message().getOrNull()?.let {
                        collector.reconcileMessage(it, index + offset)
                    }
                }
            }
            if (page.hasNextPage())
                reconcile(
                    page.nextPageParams().after().getOrNull(),
                    index + page.data().size,
                    failed,
                    done,
                )
            else {
                synchronized(collector) { collector.attachedIdle(support.sessionFailed) }
                done()
            }
        }
    }

    private fun <T> await(
        future: CompletableFuture<T>,
        cancelOnClose: Boolean = true,
        failed: (Throwable) -> Unit = { finish(it) },
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
                if (error != null) failed(unwrap(error))
                else {
                    try {
                        next(value)
                    } catch (failure: Throwable) {
                        failed(unwrap(failure))
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
                val event =
                    try {
                        val hasNext = iterator.hasNext()
                        if (closed.get()) {
                            notifyComplete(null)
                            return
                        }
                        if (!hasNext) throw support.unexpectedEnd()
                        iterator.next()
                    } catch (error: Throwable) {
                        if (closed.get()) notifyComplete(null)
                        else recoverObservation(unwrap(error))
                        return
                    }
                if (!support.accept(event)) continue
                if (support.attaching) {
                    val missing = support.missingTurnId(event)
                    if (missing != null) {
                        findLatestRoot { latest ->
                            latest?.takeIf { it.id() == missing }?.let { support.select(it) }
                            support.observeTurn(event)
                            deliver(event)
                        }
                        return
                    }
                    if (event.isFailed() && support.selectedTurn != null) {
                        refreshTurn {
                            support.observeSession(event.asFailed().session())
                            deliver(event)
                        }
                        return
                    }
                    if (event.isIdle()) {
                        refreshTurn {
                            await(sessions.retrieve(support.retrieveParams(), options)) { session ->
                                support.observeSession(session)
                                deliver(event)
                            }
                        }
                        return
                    }
                }
                deliver(event)
                return
            }
            notifyComplete(null)
        } catch (error: Throwable) {
            finish(unwrap(error))
        }
    }

    private fun recoverObservation(cause: Throwable) {
        val selected = support.selectedTurn
        if (!support.attaching || selected == null) {
            finish(cause)
            return
        }
        try {
            await(
                sessions.turns().retrieve(support.turnRetrieveParams(selected.id()), options),
                failed = { finish(cause) },
            ) { turn ->
                support.select(turn)
                if (
                    support.selectedTurn?.status() in
                        setOf(Turn.Status.COMPLETED, Turn.Status.FAILED, Turn.Status.CANCELLED)
                )
                    reconcile(failed = { finish(cause) }) { finish(null) }
                else finish(cause)
            }
        } catch (_: Exception) {
            finish(cause)
        }
    }

    private fun deliver(event: AgentSessionEvent) {
        val session = event.requiresAction().getOrNull()?.session()
        if (
            support.attaching &&
                synchronized(collector) { collector.isEnabled() } &&
                session?.requiredActions()?.any { it.isEnvironmentConnection() } == true
        ) {
            refreshTurn {
                findLatestRoot { latest ->
                    fun diagnose(current: AgentSession) {
                        synchronized(collector) {
                            collector.selectAttachedTurn(support.selectedTurn)
                            collector.manualActions(support.manualActions(current, latest?.id()))
                        }
                        deliverSelected(event)
                    }
                    if (support.selectedTurn == null)
                        await(sessions.retrieve(support.retrieveParams(), options)) { diagnose(it) }
                    else diagnose(session)
                }
            }
        } else deliverSelected(event)
    }

    private fun deliverSelected(event: AgentSessionEvent) {
        if (support.attaching)
            synchronized(collector) { collector.selectAttachedTurn(support.selectedTurn) }
        val terminal = support.terminal(event)
        if (terminal && support.attaching) reconcile { publish(event, terminal) }
        else publish(event, terminal)
    }

    private fun publish(event: AgentSessionEvent, terminal: Boolean) {
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
        await(support.result(event)) { result -> if (result == null) pump() else submit(result, 0) }
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
