package com.openai.services.beta.agents

import com.openai.core.http.AsyncStreamResponse
import com.openai.models.beta.agents.AgentSessionEvent
import com.openai.services.beta.agents.AgentTurnResultException.Reason
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
    private val lock = Any()

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
                if (stop) {
                    complete()
                    source.close()
                }
            }

            override fun onComplete(error: Optional<Throwable>) {
                synchronized(lock) { error.ifPresent(collector::failed) }
                complete()
                handler.onComplete(error)
            }
        }

    fun finalResult(): CompletableFuture<AgentTurnResult> {
        requested.set(true)
        val stop = synchronized(lock) { collector.isReady() || collector.stoppingError() != null }
        if (stop) {
            complete()
            source.close()
        } else if (!closed.get() && subscribed.compareAndSet(false, true)) {
            try {
                source.subscribe(observing(AsyncStreamResponse.Handler {}))
            } catch (cause: Throwable) {
                synchronized(lock) { collector.failed(cause) }
                complete()
                source.close()
            }
        }
        return result
    }

    /** Never invoke user future callbacks while holding the collector lock. */
    private fun complete() {
        if (result.isDone) return
        val snapshot = synchronized(lock) { runCatching { collector.finalResult() } }
        snapshot.fold(result::complete, result::completeExceptionally)
    }

    override fun onCompleteFuture(): CompletableFuture<Void?> = source.onCompleteFuture()

    override fun close() {
        if (closed.compareAndSet(false, true)) {
            val failure =
                synchronized(lock) {
                    if (collector.isReady()) null
                    else collector.stoppingError() ?: collector.error(Reason.CLOSED)
                }
            if (failure == null) complete() else result.completeExceptionally(failure)
            source.close()
        }
    }
}
