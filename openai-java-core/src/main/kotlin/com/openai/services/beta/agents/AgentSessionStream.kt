package com.openai.services.beta.agents

import com.openai.core.RequestOptions
import com.openai.core.http.StreamResponse
import com.openai.models.beta.agents.AgentSessionEvent
import com.openai.models.beta.agents.AgentSessionStreamParams
import com.openai.models.beta.agents.sessions.events.EventCreateParams
import com.openai.services.blocking.beta.agents.SessionService
import java.util.Spliterator
import java.util.Spliterators
import java.util.concurrent.CompletableFuture
import java.util.concurrent.atomic.AtomicBoolean
import java.util.function.Consumer
import java.util.stream.Stream
import java.util.stream.StreamSupport

/**
 * One turn's original typed events. Requires an idle session and a single input writer. Use
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
    private val closed = AtomicBoolean()
    private val submissionLock = Any()
    private val consumed = AtomicBoolean()
    private var pending: AgentSessionEvent? = null
    @Volatile private var active: CompletableFuture<*>? = null
    private val source: StreamResponse<AgentSessionEvent>
    private val response: com.openai.core.http.HttpResponseFor<StreamResponse<AgentSessionEvent>>

    init {
        support.checkIdle(sessions.retrieve(support.retrieveParams(), options))
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
            sessions.events().withRawResponse().create(support.inputParams(), options).close()
        } catch (error: Throwable) {
            close()
            throw error
        }
    }

    override fun stream(): Stream<AgentSessionEvent> {
        check(consumed.compareAndSet(false, true)) { "Cannot consume a stream more than once" }
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
                                val hasNext =
                                    try {
                                        iterator.hasNext()
                                    } catch (error: Throwable) {
                                        if (closed.get()) return false
                                        throw error
                                    }
                                if (closed.get()) return false
                                if (!hasNext) throw support.unexpectedEnd()
                                val event = iterator.next()
                                if (!support.accept(event)) continue
                                val terminal = support.terminal(event)
                                if (terminal) close()
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
