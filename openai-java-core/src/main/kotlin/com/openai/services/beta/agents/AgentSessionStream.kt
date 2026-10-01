package com.openai.services.beta.agents

import com.openai.core.RequestOptions
import com.openai.core.http.StreamResponse
import com.openai.models.beta.agents.AgentSessionEvent
import com.openai.models.beta.agents.AgentSessionStreamParams
import com.openai.models.beta.agents.sessions.events.EventCreateParams
import com.openai.models.beta.agents.sessions.turns.Turn
import com.openai.services.blocking.beta.agents.SessionService
import java.util.Spliterator
import java.util.Spliterators
import java.util.concurrent.CompletableFuture
import java.util.concurrent.atomic.AtomicBoolean
import java.util.function.Consumer
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/**
 * Original typed events for a new turn or attachment. Input requires an idle session. Use
 * try-with-resources. Closing releases the connection without cancelling the backend turn. Unknown
 * tools remain manual. Registered handlers run sequentially after their event is delivered.
 */
internal class AgentSessionStream(
    private val sessions: SessionService,
    params: AgentSessionStreamParams,
    private val options: RequestOptions,
    private val sleeper: com.openai.core.Sleeper,
) : StreamResponse<AgentSessionEvent> {
    private val support = AgentSessionStreamSupport(params)
    internal val collector =
        AgentTurnCollector(params.handlers.keys, params.sessionId, support.attaching)
    private val closed = AtomicBoolean()
    private val submissionLock = Any()
    private val consumed = AtomicBoolean()
    private var pending: AgentSessionEvent? = null
    @Volatile private var active: CompletableFuture<*>? = null
    private val source: StreamResponse<AgentSessionEvent>
    private val response: com.openai.core.http.HttpResponseFor<StreamResponse<AgentSessionEvent>>

    init {
        if (support.attaching) findActiveTurn(beforeOpen = true)
        else support.checkIdle(sessions.retrieve(support.retrieveParams(), options))
        response =
            sessions.events().withRawResponse().streamStreaming(support.streamParams(), options)
        source =
            try {
                response.parse()
            } catch (error: Throwable) {
                response.close()
                throw error
            }
        try {
            if (!support.attaching)
                sessions.events().withRawResponse().create(support.inputParams(), options).close()
        } catch (error: Throwable) {
            close()
            throw error
        }
    }

    override fun stream(): Stream<AgentSessionEvent> {
        check(consumed.compareAndSet(false, true)) { "Cannot consume a stream more than once" }
        if (support.attaching) {
            collector.startAttachment()
            try {
                refreshTurn()
                val session = sessions.retrieve(support.retrieveParams(), options)
                support.observeSession(session)
                if (
                    collector.isEnabled() && session.requiredActions().any { !it.isFunctionCall() }
                ) {
                    refreshTurn()
                    val latest =
                        if (session.requiredActions().any { it.isEnvironmentConnection() })
                            findLatestRoot()?.id()
                        else null
                    collector.selectAttachedTurn(support.selectedTurn)
                    collector.manualActions(support.manualActions(session, latest))
                }
            } catch (error: Throwable) {
                close()
                throw error
            }
            collector.selectAttachedTurn(support.selectedTurn)
            if (support.settled || collector.stoppingError() != null) {
                try {
                    reconcile()
                } finally {
                    close()
                }
                return Stream.empty()
            }
        }
        val iterator = source.stream().iterator()
        return StreamSupport.stream(
                object :
                    Spliterators.AbstractSpliterator<AgentSessionEvent>(
                        Long.MAX_VALUE,
                        Spliterator.ORDERED,
                    ) {
                    override fun tryAdvance(action: Consumer<in AgentSessionEvent>): Boolean {
                        if (closed.get()) return false
                        try {
                            pending?.let { event ->
                                pending = null
                                val future = support.result(event)
                                active = future
                                if (closed.get()) future.cancel(true)
                                val result =
                                    try {
                                        future.get()
                                    } finally {
                                        active = null
                                    }
                                if (result != null && !closed.get()) submit(result)
                            }
                            while (!closed.get()) {
                                val event =
                                    try {
                                        val hasNext = iterator.hasNext()
                                        if (closed.get()) return false
                                        if (!hasNext) throw support.unexpectedEnd()
                                        iterator.next()
                                    } catch (error: Throwable) {
                                        if (closed.get()) return false
                                        if (recoverObservation()) return false
                                        throw error
                                    }
                                if (support.attaching) {
                                    support.missingTurnId(event)?.let {
                                        support.select(
                                            sessions
                                                .turns()
                                                .retrieve(support.turnRetrieveParams(it), options)
                                        )
                                    }
                                    if (event.isIdle() && support.selectedTurn != null)
                                        refreshTurn()
                                }
                                if (!support.accept(event)) continue
                                if (support.attaching)
                                    collector.selectAttachedTurn(support.selectedTurn)
                                val terminal = support.terminal(event)
                                if (terminal) {
                                    if (support.attaching) reconcile()
                                    close()
                                }
                                action.accept(event)
                                if (!closed.get()) pending = event
                                return true
                            }
                            return false
                        } catch (error: Throwable) {
                            close()
                            throw unwrap(error)
                        }
                    }
                },
                false,
            )
            .onClose { close() }
    }

    private fun recoverObservation(): Boolean {
        if (!support.attaching || support.selectedTurn == null) return false
        return try {
            refreshTurn()
            if (
                support.selectedTurn?.status() !in
                    setOf(Turn.Status.COMPLETED, Turn.Status.FAILED, Turn.Status.CANCELLED)
            )
                return false
            reconcile()
            close()
            true
        } catch (_: Exception) {
            false // Preserve the original observation failure if reconciliation also fails.
        }
    }

    private fun findActiveTurn(beforeOpen: Boolean = false) {
        findLatestRoot()?.let {
            if (beforeOpen) support.baselineRootId = it.id()
            support.select(it, activeOnly = beforeOpen)
        }
    }

    private fun findLatestRoot(): Turn? {
        var params = support.turnListParams()
        while (true) {
            val page = sessions.turns().list(params, options)
            page
                .data()
                .firstOrNull { !it.subagentId().isPresent }
                ?.let {
                    return it
                }
            if (!page.hasNextPage()) return null
            params = page.nextPageParams()
        }
    }

    private fun refreshTurn() {
        val selected = support.selectedTurn
        if (selected == null) findActiveTurn()
        else
            support.select(
                sessions.turns().retrieve(support.turnRetrieveParams(selected.id()), options)
            )
    }

    private fun reconcile() {
        if (!collector.isEnabled()) return
        collector.selectAttachedTurn(support.selectedTurn)
        if (support.selectedTurn?.status() == Turn.Status.COMPLETED) {
            var params = support.itemListParams()
            var index = 0L
            while (true) {
                val page = sessions.items().list(params, options)
                page.data().forEach { item ->
                    item.message().getOrNull()?.let { collector.reconcileMessage(it, index) }
                    index++
                }
                if (!page.hasNextPage()) break
                params = page.nextPageParams()
            }
        }
        collector.attachedIdle(support.sessionFailed)
    }

    private fun submit(result: EventCreateParams) {
        for (attempt in 0..3) {
            // Claim under close's lock, then release it before the blocking request. A claimed
            // submission may finish after close; closing must not wait for the network.
            val claimed =
                synchronized(submissionLock) { if (closed.get()) null else result } ?: return
            try {
                sessions.events().withRawResponse().create(claimed, options).close()
                return
            } catch (error: Exception) {
                if (attempt == 3 || !support.pendingCallRace(error, result)) throw error
                sleeper.sleep(java.time.Duration.ofMillis(longArrayOf(100, 300, 600)[attempt]))
            }
        }
    }

    override fun close() {
        if (synchronized(submissionLock) { closed.compareAndSet(false, true) }) {
            active?.cancel(true)
            try {
                response.close()
            } finally {
                source.close()
            }
        }
    }
}
