// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Emitted when injected input could not be committed to a response. The event returns the
 * uncommitted raw input so the client can retry it in another response when appropriate.
 */
class BetaResponseInjectFailedEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val error: JsonField<Error>,
    private val input: JsonField<List<BetaResponseInputItem>>,
    private val responseId: JsonField<String>,
    private val sequenceNumber: JsonField<Long>,
    private val type: JsonValue,
    private val streamId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("error") @ExcludeMissing error: JsonField<Error> = JsonMissing.of(),
        @JsonProperty("input")
        @ExcludeMissing
        input: JsonField<List<BetaResponseInputItem>> = JsonMissing.of(),
        @JsonProperty("response_id")
        @ExcludeMissing
        responseId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("sequence_number")
        @ExcludeMissing
        sequenceNumber: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("stream_id") @ExcludeMissing streamId: JsonField<String> = JsonMissing.of(),
    ) : this(error, input, responseId, sequenceNumber, type, streamId, mutableMapOf())

    /**
     * Information about why the input was not committed.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun error(): Error = error.getRequired("error")

    /**
     * The raw input items that were not committed.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun input(): List<BetaResponseInputItem> = input.getRequired("input")

    /**
     * The ID of the response that rejected the input.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun responseId(): String = responseId.getRequired("response_id")

    /**
     * The sequence number for this event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

    /**
     * The event discriminator. Always `response.inject.failed`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("response.inject.failed")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * The multiplexed WebSocket stream that emitted the event. This field is present only when
     * WebSocket multiplexing is enabled separately.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun streamId(): Optional<String> = streamId.getOptional("stream_id")

    /**
     * Returns the raw JSON value of [error].
     *
     * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<Error> = error

    /**
     * Returns the raw JSON value of [input].
     *
     * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("input")
    @ExcludeMissing
    fun _input(): JsonField<List<BetaResponseInputItem>> = input

    /**
     * Returns the raw JSON value of [responseId].
     *
     * Unlike [responseId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("response_id") @ExcludeMissing fun _responseId(): JsonField<String> = responseId

    /**
     * Returns the raw JSON value of [sequenceNumber].
     *
     * Unlike [sequenceNumber], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sequence_number")
    @ExcludeMissing
    fun _sequenceNumber(): JsonField<Long> = sequenceNumber

    /**
     * Returns the raw JSON value of [streamId].
     *
     * Unlike [streamId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("stream_id") @ExcludeMissing fun _streamId(): JsonField<String> = streamId

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [BetaResponseInjectFailedEvent].
         *
         * The following fields are required:
         * ```java
         * .error()
         * .input()
         * .responseId()
         * .sequenceNumber()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BetaResponseInjectFailedEvent]. */
    class Builder internal constructor() {

        private var error: JsonField<Error>? = null
        private var input: JsonField<MutableList<BetaResponseInputItem>>? = null
        private var responseId: JsonField<String>? = null
        private var sequenceNumber: JsonField<Long>? = null
        private var type: JsonValue = JsonValue.from("response.inject.failed")
        private var streamId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(betaResponseInjectFailedEvent: BetaResponseInjectFailedEvent) = apply {
            error = betaResponseInjectFailedEvent.error
            input = betaResponseInjectFailedEvent.input.map { it.toMutableList() }
            responseId = betaResponseInjectFailedEvent.responseId
            sequenceNumber = betaResponseInjectFailedEvent.sequenceNumber
            type = betaResponseInjectFailedEvent.type
            streamId = betaResponseInjectFailedEvent.streamId
            additionalProperties = betaResponseInjectFailedEvent.additionalProperties.toMutableMap()
        }

        /** Information about why the input was not committed. */
        fun error(error: Error) = error(JsonField.of(error))

        /**
         * Sets [Builder.error] to an arbitrary JSON value.
         *
         * You should usually call [Builder.error] with a well-typed [Error] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun error(error: JsonField<Error>) = apply { this.error = error }

        /** The raw input items that were not committed. */
        fun input(input: List<BetaResponseInputItem>) = input(JsonField.of(input))

        /**
         * Sets [Builder.input] to an arbitrary JSON value.
         *
         * You should usually call [Builder.input] with a well-typed `List<BetaResponseInputItem>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun input(input: JsonField<List<BetaResponseInputItem>>) = apply {
            this.input = input.map { it.toMutableList() }
        }

        /**
         * Adds a single [BetaResponseInputItem] to [Builder.input].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addInput(input: BetaResponseInputItem) = apply {
            this.input =
                (this.input ?: JsonField.of(mutableListOf())).also {
                    checkKnown("input", it).add(input)
                }
        }

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofBetaEasyInputMessage(betaEasyInputMessage)`.
         */
        fun addInput(betaEasyInputMessage: BetaEasyInputMessage) =
            addInput(BetaResponseInputItem.ofBetaEasyInputMessage(betaEasyInputMessage))

        /** Alias for calling [addInput] with `BetaResponseInputItem.ofMessage(message)`. */
        fun addInput(message: BetaResponseInputItem.Message) =
            addInput(BetaResponseInputItem.ofMessage(message))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofBetaResponseOutputMessage(betaResponseOutputMessage)`.
         */
        fun addInput(betaResponseOutputMessage: BetaResponseOutputMessage) =
            addInput(BetaResponseInputItem.ofBetaResponseOutputMessage(betaResponseOutputMessage))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofFileSearchCall(fileSearchCall)`.
         */
        fun addInput(fileSearchCall: BetaResponseFileSearchToolCall) =
            addInput(BetaResponseInputItem.ofFileSearchCall(fileSearchCall))

        /**
         * Alias for calling [addInput] with `BetaResponseInputItem.ofComputerCall(computerCall)`.
         */
        fun addInput(computerCall: BetaResponseComputerToolCall) =
            addInput(BetaResponseInputItem.ofComputerCall(computerCall))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofComputerCallOutput(computerCallOutput)`.
         */
        fun addInput(computerCallOutput: BetaResponseInputItem.ComputerCallOutput) =
            addInput(BetaResponseInputItem.ofComputerCallOutput(computerCallOutput))

        /**
         * Alias for calling [addInput] with `BetaResponseInputItem.ofWebSearchCall(webSearchCall)`.
         */
        fun addInput(webSearchCall: BetaResponseFunctionWebSearch) =
            addInput(BetaResponseInputItem.ofWebSearchCall(webSearchCall))

        /**
         * Alias for calling [addInput] with `BetaResponseInputItem.ofFunctionCall(functionCall)`.
         */
        fun addInput(functionCall: BetaResponseFunctionToolCall) =
            addInput(BetaResponseInputItem.ofFunctionCall(functionCall))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofFunctionCallOutput(functionCallOutput)`.
         */
        fun addInput(functionCallOutput: BetaResponseInputItem.FunctionCallOutput) =
            addInput(BetaResponseInputItem.ofFunctionCallOutput(functionCallOutput))

        /**
         * Alias for calling [addInput] with `BetaResponseInputItem.ofAgentMessage(agentMessage)`.
         */
        fun addInput(agentMessage: BetaResponseInputItem.AgentMessage) =
            addInput(BetaResponseInputItem.ofAgentMessage(agentMessage))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofMultiAgentCall(multiAgentCall)`.
         */
        fun addInput(multiAgentCall: BetaResponseInputItem.MultiAgentCall) =
            addInput(BetaResponseInputItem.ofMultiAgentCall(multiAgentCall))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofMultiAgentCallOutput(multiAgentCallOutput)`.
         */
        fun addInput(multiAgentCallOutput: BetaResponseInputItem.MultiAgentCallOutput) =
            addInput(BetaResponseInputItem.ofMultiAgentCallOutput(multiAgentCallOutput))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofToolSearchCall(toolSearchCall)`.
         */
        fun addInput(toolSearchCall: BetaResponseInputItem.ToolSearchCall) =
            addInput(BetaResponseInputItem.ofToolSearchCall(toolSearchCall))

        /**
         * Alias for calling [addInput] with the following:
         * ```java
         * BetaResponseInputItem.ToolSearchCall.builder()
         *     .arguments(arguments)
         *     .build()
         * ```
         */
        fun addToolSearchCallInput(arguments: JsonValue) =
            addInput(BetaResponseInputItem.ToolSearchCall.builder().arguments(arguments).build())

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofToolSearchOutput(toolSearchOutput)`.
         */
        fun addInput(toolSearchOutput: BetaResponseToolSearchOutputItemParam) =
            addInput(BetaResponseInputItem.ofToolSearchOutput(toolSearchOutput))

        /**
         * Alias for calling [addInput] with the following:
         * ```java
         * BetaResponseToolSearchOutputItemParam.builder()
         *     .tools(tools)
         *     .build()
         * ```
         */
        fun addToolSearchOutputInput(tools: List<BetaTool>) =
            addInput(BetaResponseToolSearchOutputItemParam.builder().tools(tools).build())

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofAdditionalTools(additionalTools)`.
         */
        fun addInput(additionalTools: BetaResponseInputItem.AdditionalTools) =
            addInput(BetaResponseInputItem.ofAdditionalTools(additionalTools))

        /**
         * Alias for calling [addInput] with the following:
         * ```java
         * BetaResponseInputItem.AdditionalTools.builder()
         *     .tools(tools)
         *     .build()
         * ```
         */
        fun addAdditionalToolsInput(tools: List<BetaTool>) =
            addInput(BetaResponseInputItem.AdditionalTools.builder().tools(tools).build())

        /** Alias for calling [addInput] with `BetaResponseInputItem.ofReasoning(reasoning)`. */
        fun addInput(reasoning: BetaResponseReasoningItem) =
            addInput(BetaResponseInputItem.ofReasoning(reasoning))

        /** Alias for calling [addInput] with `BetaResponseInputItem.ofCompaction(compaction)`. */
        fun addInput(compaction: BetaResponseCompactionItemParam) =
            addInput(BetaResponseInputItem.ofCompaction(compaction))

        /**
         * Alias for calling [addInput] with the following:
         * ```java
         * BetaResponseCompactionItemParam.builder()
         *     .encryptedContent(encryptedContent)
         *     .build()
         * ```
         */
        fun addCompactionInput(encryptedContent: String) =
            addInput(
                BetaResponseCompactionItemParam.builder().encryptedContent(encryptedContent).build()
            )

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofImageGenerationCall(imageGenerationCall)`.
         */
        fun addInput(imageGenerationCall: BetaResponseInputItem.ImageGenerationCall) =
            addInput(BetaResponseInputItem.ofImageGenerationCall(imageGenerationCall))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofCodeInterpreterCall(codeInterpreterCall)`.
         */
        fun addInput(codeInterpreterCall: BetaResponseCodeInterpreterToolCall) =
            addInput(BetaResponseInputItem.ofCodeInterpreterCall(codeInterpreterCall))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofLocalShellCall(localShellCall)`.
         */
        fun addInput(localShellCall: BetaResponseInputItem.LocalShellCall) =
            addInput(BetaResponseInputItem.ofLocalShellCall(localShellCall))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofLocalShellCallOutput(localShellCallOutput)`.
         */
        fun addInput(localShellCallOutput: BetaResponseInputItem.LocalShellCallOutput) =
            addInput(BetaResponseInputItem.ofLocalShellCallOutput(localShellCallOutput))

        /** Alias for calling [addInput] with `BetaResponseInputItem.ofShellCall(shellCall)`. */
        fun addInput(shellCall: BetaResponseInputItem.ShellCall) =
            addInput(BetaResponseInputItem.ofShellCall(shellCall))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofShellCallOutput(shellCallOutput)`.
         */
        fun addInput(shellCallOutput: BetaResponseInputItem.ShellCallOutput) =
            addInput(BetaResponseInputItem.ofShellCallOutput(shellCallOutput))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofApplyPatchCall(applyPatchCall)`.
         */
        fun addInput(applyPatchCall: BetaResponseInputItem.ApplyPatchCall) =
            addInput(BetaResponseInputItem.ofApplyPatchCall(applyPatchCall))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofApplyPatchCallOutput(applyPatchCallOutput)`.
         */
        fun addInput(applyPatchCallOutput: BetaResponseInputItem.ApplyPatchCallOutput) =
            addInput(BetaResponseInputItem.ofApplyPatchCallOutput(applyPatchCallOutput))

        /**
         * Alias for calling [addInput] with `BetaResponseInputItem.ofMcpListTools(mcpListTools)`.
         */
        fun addInput(mcpListTools: BetaResponseInputItem.McpListTools) =
            addInput(BetaResponseInputItem.ofMcpListTools(mcpListTools))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofMcpApprovalRequest(mcpApprovalRequest)`.
         */
        fun addInput(mcpApprovalRequest: BetaResponseInputItem.McpApprovalRequest) =
            addInput(BetaResponseInputItem.ofMcpApprovalRequest(mcpApprovalRequest))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofMcpApprovalResponse(mcpApprovalResponse)`.
         */
        fun addInput(mcpApprovalResponse: BetaResponseInputItem.McpApprovalResponse) =
            addInput(BetaResponseInputItem.ofMcpApprovalResponse(mcpApprovalResponse))

        /** Alias for calling [addInput] with `BetaResponseInputItem.ofMcpCall(mcpCall)`. */
        fun addInput(mcpCall: BetaResponseInputItem.McpCall) =
            addInput(BetaResponseInputItem.ofMcpCall(mcpCall))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofCustomToolCallOutput(customToolCallOutput)`.
         */
        fun addInput(customToolCallOutput: BetaResponseCustomToolCallOutput) =
            addInput(BetaResponseInputItem.ofCustomToolCallOutput(customToolCallOutput))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofCustomToolCall(customToolCall)`.
         */
        fun addInput(customToolCall: BetaResponseCustomToolCall) =
            addInput(BetaResponseInputItem.ofCustomToolCall(customToolCall))

        /**
         * Alias for calling [addInput] with
         * `BetaResponseInputItem.ofCompactionTrigger(compactionTrigger)`.
         */
        fun addInput(compactionTrigger: BetaResponseInputItem.CompactionTrigger) =
            addInput(BetaResponseInputItem.ofCompactionTrigger(compactionTrigger))

        /**
         * Alias for calling [addInput] with `BetaResponseInputItem.ofItemReference(itemReference)`.
         */
        fun addInput(itemReference: BetaResponseInputItem.ItemReference) =
            addInput(BetaResponseInputItem.ofItemReference(itemReference))

        /**
         * Alias for calling [addInput] with the following:
         * ```java
         * BetaResponseInputItem.ItemReference.builder()
         *     .type(BetaResponseInputItem.ItemReference.Type.ITEM_REFERENCE)
         *     .id(id)
         *     .build()
         * ```
         */
        fun addItemReferenceInput(id: String) =
            addInput(
                BetaResponseInputItem.ItemReference.builder()
                    .type(BetaResponseInputItem.ItemReference.Type.ITEM_REFERENCE)
                    .id(id)
                    .build()
            )

        /** Alias for calling [addInput] with `BetaResponseInputItem.ofProgram(program)`. */
        fun addInput(program: BetaResponseInputItem.Program) =
            addInput(BetaResponseInputItem.ofProgram(program))

        /**
         * Alias for calling [addInput] with `BetaResponseInputItem.ofProgramOutput(programOutput)`.
         */
        fun addInput(programOutput: BetaResponseInputItem.ProgramOutput) =
            addInput(BetaResponseInputItem.ofProgramOutput(programOutput))

        /** The ID of the response that rejected the input. */
        fun responseId(responseId: String) = responseId(JsonField.of(responseId))

        /**
         * Sets [Builder.responseId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.responseId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun responseId(responseId: JsonField<String>) = apply { this.responseId = responseId }

        /** The sequence number for this event. */
        fun sequenceNumber(sequenceNumber: Long) = sequenceNumber(JsonField.of(sequenceNumber))

        /**
         * Sets [Builder.sequenceNumber] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sequenceNumber] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun sequenceNumber(sequenceNumber: JsonField<Long>) = apply {
            this.sequenceNumber = sequenceNumber
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("response.inject.failed")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /**
         * The multiplexed WebSocket stream that emitted the event. This field is present only when
         * WebSocket multiplexing is enabled separately.
         */
        fun streamId(streamId: String) = streamId(JsonField.of(streamId))

        /**
         * Sets [Builder.streamId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.streamId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun streamId(streamId: JsonField<String>) = apply { this.streamId = streamId }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [BetaResponseInjectFailedEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .error()
         * .input()
         * .responseId()
         * .sequenceNumber()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BetaResponseInjectFailedEvent =
            BetaResponseInjectFailedEvent(
                checkRequired("error", error),
                checkRequired("input", input).map { it.toImmutable() },
                checkRequired("responseId", responseId),
                checkRequired("sequenceNumber", sequenceNumber),
                type,
                streamId,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): BetaResponseInjectFailedEvent = apply {
        if (validated) {
            return@apply
        }

        error().validate()
        input().forEach { it.validate() }
        responseId()
        sequenceNumber()
        _type().let {
            if (it != JsonValue.from("response.inject.failed")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        streamId()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: OpenAIInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (error.asKnown().getOrNull()?.validity() ?: 0) +
            (input.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (responseId.asKnown().isPresent) 1 else 0) +
            (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("response.inject.failed")) 1 else 0 } +
            (if (streamId.asKnown().isPresent) 1 else 0)

    /** Information about why the input was not committed. */
    class Error
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val code: JsonField<Code>,
        private val message: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("code") @ExcludeMissing code: JsonField<Code> = JsonMissing.of(),
            @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
        ) : this(code, message, mutableMapOf())

        /**
         * A machine-readable error code.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun code(): Code = code.getRequired("code")

        /**
         * A human-readable description of the error.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun message(): String = message.getRequired("message")

        /**
         * Returns the raw JSON value of [code].
         *
         * Unlike [code], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<Code> = code

        /**
         * Returns the raw JSON value of [message].
         *
         * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Error].
             *
             * The following fields are required:
             * ```java
             * .code()
             * .message()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Error]. */
        class Builder internal constructor() {

            private var code: JsonField<Code>? = null
            private var message: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(error: Error) = apply {
                code = error.code
                message = error.message
                additionalProperties = error.additionalProperties.toMutableMap()
            }

            /** A machine-readable error code. */
            fun code(code: Code) = code(JsonField.of(code))

            /**
             * Sets [Builder.code] to an arbitrary JSON value.
             *
             * You should usually call [Builder.code] with a well-typed [Code] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun code(code: JsonField<Code>) = apply { this.code = code }

            /** A human-readable description of the error. */
            fun message(message: String) = message(JsonField.of(message))

            /**
             * Sets [Builder.message] to an arbitrary JSON value.
             *
             * You should usually call [Builder.message] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun message(message: JsonField<String>) = apply { this.message = message }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Error].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .code()
             * .message()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Error =
                Error(
                    checkRequired("code", code),
                    checkRequired("message", message),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Error = apply {
            if (validated) {
                return@apply
            }

            code().validate()
            message()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (code.asKnown().getOrNull()?.validity() ?: 0) +
                (if (message.asKnown().isPresent) 1 else 0)

        /** A machine-readable error code. */
        class Code @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val RESPONSE_ALREADY_COMPLETED = of("response_already_completed")

                @JvmField val RESPONSE_NOT_FOUND = of("response_not_found")

                @JvmStatic fun of(value: String) = Code(JsonField.of(value))
            }

            /** An enum containing [Code]'s known values. */
            enum class Known {
                RESPONSE_ALREADY_COMPLETED,
                RESPONSE_NOT_FOUND,
            }

            /**
             * An enum containing [Code]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Code] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                RESPONSE_ALREADY_COMPLETED,
                RESPONSE_NOT_FOUND,
                /** An enum member indicating that [Code] was instantiated with an unknown value. */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    RESPONSE_ALREADY_COMPLETED -> Value.RESPONSE_ALREADY_COMPLETED
                    RESPONSE_NOT_FOUND -> Value.RESPONSE_NOT_FOUND
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws OpenAIInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    RESPONSE_ALREADY_COMPLETED -> Known.RESPONSE_ALREADY_COMPLETED
                    RESPONSE_NOT_FOUND -> Known.RESPONSE_NOT_FOUND
                    else -> throw OpenAIInvalidDataException("Unknown Code: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws OpenAIInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    OpenAIInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Code = apply {
                if (validated) {
                    return@apply
                }

                known()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: OpenAIInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Code && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Error &&
                code == other.code &&
                message == other.message &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(code, message, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Error{code=$code, message=$message, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BetaResponseInjectFailedEvent &&
            error == other.error &&
            input == other.input &&
            responseId == other.responseId &&
            sequenceNumber == other.sequenceNumber &&
            type == other.type &&
            streamId == other.streamId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(error, input, responseId, sequenceNumber, type, streamId, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BetaResponseInjectFailedEvent{error=$error, input=$input, responseId=$responseId, sequenceNumber=$sequenceNumber, type=$type, streamId=$streamId, additionalProperties=$additionalProperties}"
}
