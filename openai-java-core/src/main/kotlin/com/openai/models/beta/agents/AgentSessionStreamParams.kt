package com.openai.models.beta.agents

import com.openai.core.http.Headers
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionStage
import java.util.function.Function

/** Input and optional function handlers for one turn of an idle session. */
class AgentSessionStreamParams
private constructor(
    val sessionId: String,
    val input: List<AgentSessionInputMessageParam>,
    val headers: Headers,
    val idempotencyKey: String?,
    internal val handlers: Map<String, Function<Map<String, Any?>, CompletionStage<*>>>,
) {
    companion object {
        @JvmStatic fun builder() = Builder()
    }

    class Builder {
        private var sessionId: String? = null
        private var input: List<AgentSessionInputMessageParam> = emptyList()
        private val headers = Headers.builder()
        private var idempotencyKey: String? = null
        private val handlers =
            linkedMapOf<String, Function<Map<String, Any?>, CompletionStage<*>>>()

        fun sessionId(value: String) = apply { sessionId = value }

        fun input(value: String) = apply {
            require(value.isNotEmpty()) { "input must not be empty" }
            input =
                listOf(AgentSessionInputMessageParam.builder().addInputTextContent(value).build())
        }

        fun input(value: List<AgentSessionInputMessageParam>) = apply { input = value.toList() }

        /** Applies only to the input POST. Each tool result receives a separate key. */
        fun idempotencyKey(value: String) = apply { idempotencyKey = value }

        /** Headers propagate to every request. An Idempotency-Key overrides the input key only. */
        fun putAdditionalHeader(name: String, value: String) = apply {
            headers.replace(name, value)
        }

        /**
         * Return a string, JSON object, list of InputContentParam, or null. Exceptions are
         * redacted.
         */
        fun toolHandler(name: String, handler: Function<Map<String, Any?>, Any?>) = apply {
            handlers[name] = Function { CompletableFuture.completedFuture(handler.apply(it)) }
        }

        /** Completion is awaited before reading the next event or invoking another handler. */
        fun asyncToolHandler(
            name: String,
            handler: Function<Map<String, Any?>, CompletionStage<*>>,
        ) = apply { handlers[name] = handler }

        fun build(): AgentSessionStreamParams {
            require(input.isNotEmpty()) { "input must not be empty" }
            val allHeaders = headers.build()
            return AgentSessionStreamParams(
                requireNotNull(sessionId) { "sessionId is required" },
                input.toList(),
                allHeaders.toBuilder().remove("Idempotency-Key").build(),
                allHeaders.values("Idempotency-Key").firstOrNull() ?: idempotencyKey,
                handlers.toMap(),
            )
        }
    }
}
