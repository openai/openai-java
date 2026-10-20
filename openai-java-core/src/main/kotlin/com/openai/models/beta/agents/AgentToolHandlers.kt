package com.openai.models.beta.agents

import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionStage
import java.util.function.Function

/** Local function handlers for a beta Agents creation stream. Never sent to the API. */
class AgentToolHandlers
private constructor(
    internal val handlers: Map<String, Function<Map<String, Any?>, CompletionStage<*>>>
) {
    companion object {
        @JvmStatic fun builder() = Builder()
    }

    class Builder {
        private val handlers =
            linkedMapOf<String, Function<Map<String, Any?>, CompletionStage<*>>>()

        /** Uses the same return values and sanitized errors as session stream tool handlers. */
        fun toolHandler(name: String, handler: Function<Map<String, Any?>, Any?>) = apply {
            handlers[name] = Function { CompletableFuture.completedFuture(handler.apply(it)) }
        }

        fun asyncToolHandler(
            name: String,
            handler: Function<Map<String, Any?>, CompletionStage<*>>,
        ) = apply { handlers[name] = handler }

        fun build() = AgentToolHandlers(handlers.toMap())
    }
}
