package com.openai.helpers

import com.openai.client.OpenAIClient
import com.openai.core.RequestOptions
import com.openai.core.functionToolFromClass
import com.openai.core.toJsonString
import com.openai.models.chat.completions.ChatCompletion
import com.openai.models.chat.completions.ChatCompletionCreateParams
import com.openai.models.chat.completions.ChatCompletionMessageFunctionToolCall
import com.openai.models.chat.completions.ChatCompletionMessageParam
import com.openai.models.chat.completions.ChatCompletionTool
import com.openai.models.chat.completions.ChatCompletionToolMessageParam
import java.util.Collections
import java.util.Optional
import java.util.function.Function

/**
 * Runs a bounded, blocking Chat Completions function-calling loop. The caller owns the client.
 * Callbacks execute sequentially on the calling thread and are never retried by this helper.
 * Request timeouts/retries still use the client's policy and [Builder.requestOptions].
 *
 * Register only tools the application authorizes the model to invoke. Typed JSON conversion is not
 * domain validation or user approval: callbacks must enforce those requirements themselves.
 */
class ChatCompletionToolRunner private constructor(builder: Builder) {
    private val client = checkNotNull(builder.client) { "client is required" }
    private val maxTurns = builder.maxTurns
    private val options = builder.options
    private val tools = builder.tools.toMap()

    companion object {
        @JvmStatic fun builder() = Builder()

        private fun snapshot(messages: List<ChatCompletionMessageParam>) =
            Collections.unmodifiableList(ArrayList(messages))
    }

    class Builder internal constructor() {
        internal var client: OpenAIClient? = null
        internal var maxTurns = 8
        internal var options = RequestOptions.none()
        internal val tools = linkedMapOf<String, Binding>()

        fun client(client: OpenAIClient) = apply { this.client = client }

        /** Maximum model requests, including the final answer request. Defaults to eight. */
        fun maxTurns(maxTurns: Int) = apply {
            require(maxTurns > 0) { "maxTurns must be positive" }
            this.maxTurns = maxTurns
        }

        fun requestOptions(options: RequestOptions) = apply { this.options = options }

        /** Uses the SDK's existing schema generation and typed argument conversion. */
        fun <T : Any> addTool(argumentsType: Class<T>, callback: Function<T, *>) = apply {
            val definition = functionToolFromClass(argumentsType)
            val name = definition.asFunction().function().name()
            require(!tools.containsKey(name)) { "Tool names must be unique" }
            tools[name] =
                Binding(definition) { call ->
                    val arguments =
                        checkNotNull(call.function().arguments(argumentsType)) {
                            "Tool arguments must not be null"
                        }
                    val invoke: () -> Any? = { callback.apply(arguments) }
                    invoke
                }
        }

        fun build(): ChatCompletionToolRunner {
            require(tools.isNotEmpty()) { "At least one tool is required" }
            return ChatCompletionToolRunner(this)
        }
    }

    internal class Binding(
        val definition: ChatCompletionTool,
        val prepare: (ChatCompletionMessageFunctionToolCall) -> (() -> Any?),
    )

    class Result
    internal constructor(
        private val completion: ChatCompletion,
        messages: List<ChatCompletionMessageParam>,
    ) {
        private val messages = snapshot(messages)

        fun completion(): ChatCompletion = completion

        /** Complete conversation, including the final assistant message. */
        fun messages(): List<ChatCompletionMessageParam> = messages
    }

    /**
     * Partial progress for recovery. The last callback may have had side effects even if it failed
     * or its result could not be serialized. Do not blindly replay a failed run. Messages can
     * contain sensitive data; do not log them indiscriminately. A partial transcript may end with
     * unresolved tool calls and must be reconciled before reuse.
     */
    class RunException
    internal constructor(
        message: String,
        cause: Exception,
        messages: List<ChatCompletionMessageParam>,
        private val completion: ChatCompletion?,
        private val toolCallId: String?,
    ) : RuntimeException(message, cause) {
        private val messages = snapshot(messages)

        fun messages(): List<ChatCompletionMessageParam> = messages

        fun lastCompletion(): Optional<ChatCompletion> = Optional.ofNullable(completion)

        fun toolCallId(): Optional<String> = Optional.ofNullable(toolCallId)
    }

    /**
     * The runner supplies tools. Params must use one choice and must not supply tools or deprecated
     * functions. Other request settings, including tool_choice, are preserved on every turn.
     * Streaming is not supported. A forced tool choice may exhaust the turn limit.
     */
    @Suppress("DEPRECATION")
    fun run(params: ChatCompletionCreateParams): Result {
        require(
            !params.tools().isPresent &&
                !params.functions().isPresent &&
                !params.functionCall().isPresent
        ) {
            "Register tools on the runner instead of request params"
        }
        require(params.n().orElse(1) == 1L) { "The runner requires exactly one choice" }
        require(
            params._additionalBodyProperties().keys.none {
                it in setOf("messages", "tools", "n", "functions", "function_call", "stream")
            }
        ) {
            "Additional properties must not override runner-managed fields"
        }
        val messages = params.messages().toMutableList()
        val seenIds = mutableSetOf<String>()
        var completion: ChatCompletion? = null
        var currentId: String? = null
        try {
            repeat(maxTurns) { turn ->
                currentId = null
                checkInterrupted()
                val response =
                    client
                        .chat()
                        .completions()
                        .create(
                            params
                                .toBuilder()
                                .messages(messages.toList())
                                .tools(tools.values.map { it.definition })
                                .build(),
                            options,
                        )
                completion = response
                check(response.choices().size == 1) { "Expected exactly one completion choice" }
                val choice = response.choices().single()
                val message = choice.message()
                messages.add(ChatCompletionMessageParam.ofAssistant(message.toParam()))
                check(!message.functionCall().isPresent) {
                    "Legacy function calls are not supported"
                }
                val calls = message.toolCalls().orElse(emptyList())
                if (calls.isEmpty()) {
                    check(choice.finishReason().toString() == "stop") {
                        "Completion ended without a final answer"
                    }
                    return Result(response, messages)
                }
                check(choice.finishReason().toString() == "tool_calls") {
                    "Completion ended with incomplete tool calls"
                }
                check(turn + 1 < maxTurns) { "Tool runner reached its turn limit" }
                // Validate and parse the whole turn before executing any callback.
                val pending =
                    calls.map { call ->
                        currentId = null
                        check(call.function().isPresent) {
                            "Only function tool calls are supported"
                        }
                        val function = call.asFunction()
                        currentId = function.id()
                        check(function.id().isNotBlank() && seenIds.add(function.id())) {
                            "Tool call IDs must be nonempty and unique within a run"
                        }
                        val binding =
                            checkNotNull(tools[function.function().name()]) {
                                "Model requested an unregistered tool"
                            }
                        function.id() to binding.prepare(function)
                    }
                for ((id, invoke) in pending) {
                    currentId = id
                    checkInterrupted()
                    val value = invoke()
                    val json = if (value == null) "null" else toJsonString(value)
                    messages.add(
                        ChatCompletionMessageParam.ofTool(
                            ChatCompletionToolMessageParam.builder()
                                .toolCallId(id)
                                .content(json)
                                .build()
                        )
                    )
                }
            }
            error("Tool runner reached its turn limit")
        } catch (e: Exception) {
            if (e is InterruptedException) Thread.currentThread().interrupt()
            throw RunException(
                "Chat tool runner did not complete",
                e,
                messages,
                completion,
                currentId,
            )
        }
    }

    private fun checkInterrupted() {
        if (Thread.currentThread().isInterrupted)
            throw InterruptedException("Tool runner interrupted")
    }
}
