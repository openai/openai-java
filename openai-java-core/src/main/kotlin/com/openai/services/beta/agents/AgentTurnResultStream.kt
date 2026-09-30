package com.openai.services.beta.agents

import com.openai.core.http.StreamResponse
import com.openai.models.beta.agents.AgentSessionEvent
import java.util.Spliterator
import java.util.Spliterators
import java.util.function.Consumer
import java.util.stream.Stream
import java.util.stream.StreamSupport

internal class AgentTurnResultStream(
    internal val source: StreamResponse<AgentSessionEvent>,
    private val collector: AgentTurnCollector,
) : StreamResponse<AgentSessionEvent> {
    private var iterator: Iterator<AgentSessionEvent>? = null
    private var exposed = false
    private var closed = false
    private var ended = false

    override fun stream(): Stream<AgentSessionEvent> {
        check(!exposed) { "Cannot consume a stream more than once" }
        exposed = true
        return StreamSupport.stream(
                object :
                    Spliterators.AbstractSpliterator<AgentSessionEvent>(
                        Long.MAX_VALUE,
                        Spliterator.ORDERED,
                    ) {
                    override fun tryAdvance(action: Consumer<in AgentSessionEvent>): Boolean {
                        val event = next() ?: return false
                        action.accept(event)
                        return true
                    }
                },
                false,
            )
            .onClose { close() }
    }

    private fun next(): AgentSessionEvent? {
        if (closed || ended) return null
        try {
            val current = iterator ?: source.stream().iterator().also { iterator = it }
            if (!current.hasNext()) {
                ended = true
                return null
            }
            return current.next().also(collector::accept)
        } catch (cause: Throwable) {
            collector.failed(cause)
            throw cause
        }
    }

    fun enableResultCollection() = collector.enable()

    fun finalResult(): AgentTurnResult {
        enableResultCollection()
        if (closed) collector.closed()
        try {
            while (!collector.isReady()) {
                collector.stoppingError()?.let { throw it }
                if (next() == null) break
            }
            return collector.finalResult()
        } catch (cause: AgentTurnResultException) {
            throw cause
        } catch (cause: Throwable) {
            collector.failed(cause)
            throw requireNotNull(collector.stoppingError())
        } finally {
            close()
        }
    }

    override fun close() {
        if (!closed) {
            closed = true
            if (!ended) collector.closed()
            source.close()
        }
    }
}
