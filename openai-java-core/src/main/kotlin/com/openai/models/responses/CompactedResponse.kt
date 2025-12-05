// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
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
import kotlin.jvm.optionals.getOrNull

class CompactedResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<Long>,
    private val object_: JsonValue,
    private val output: JsonField<List<ResponseOutputItem>>,
    private val usage: JsonField<ResponseUsage>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("output")
        @ExcludeMissing
        output: JsonField<List<ResponseOutputItem>> = JsonMissing.of(),
        @JsonProperty("usage") @ExcludeMissing usage: JsonField<ResponseUsage> = JsonMissing.of(),
    ) : this(id, createdAt, object_, output, usage, mutableMapOf())

    /**
     * The unique identifier for the compacted response.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Unix timestamp (in seconds) when the compacted conversation was created.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /**
     * The object type. Always `response.compaction`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("response.compaction")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * The compacted list of output items. This is a list of all user messages, followed by a single
     * compaction item.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun output(): List<ResponseOutputItem> = output.getRequired("output")

    /**
     * Token accounting for the compaction pass, including cached, reasoning, and total tokens.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun usage(): ResponseUsage = usage.getRequired("usage")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt(): JsonField<Long> = createdAt

    /**
     * Returns the raw JSON value of [output].
     *
     * Unlike [output], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("output")
    @ExcludeMissing
    fun _output(): JsonField<List<ResponseOutputItem>> = output

    /**
     * Returns the raw JSON value of [usage].
     *
     * Unlike [usage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("usage") @ExcludeMissing fun _usage(): JsonField<ResponseUsage> = usage

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
         * Returns a mutable builder for constructing an instance of [CompactedResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .output()
         * .usage()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CompactedResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<Long>? = null
        private var object_: JsonValue = JsonValue.from("response.compaction")
        private var output: JsonField<MutableList<ResponseOutputItem>>? = null
        private var usage: JsonField<ResponseUsage>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(compactedResponse: CompactedResponse) = apply {
            id = compactedResponse.id
            createdAt = compactedResponse.createdAt
            object_ = compactedResponse.object_
            output = compactedResponse.output.map { it.toMutableList() }
            usage = compactedResponse.usage
            additionalProperties = compactedResponse.additionalProperties.toMutableMap()
        }

        /** The unique identifier for the compacted response. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Unix timestamp (in seconds) when the compacted conversation was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("response.compaction")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /**
         * The compacted list of output items. This is a list of all user messages, followed by a
         * single compaction item.
         */
        fun output(output: List<ResponseOutputItem>) = output(JsonField.of(output))

        /**
         * Sets [Builder.output] to an arbitrary JSON value.
         *
         * You should usually call [Builder.output] with a well-typed `List<ResponseOutputItem>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun output(output: JsonField<List<ResponseOutputItem>>) = apply {
            this.output = output.map { it.toMutableList() }
        }

        /**
         * Adds a single [ResponseOutputItem] to [Builder.output].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addOutput(output: ResponseOutputItem) = apply {
            this.output =
                (this.output ?: JsonField.of(mutableListOf())).also {
                    checkKnown("output", it).add(output)
                }
        }

        /** Alias for calling [addOutput] with `ResponseOutputItem.ofMessage(message)`. */
        fun addOutput(message: ResponseOutputMessage) =
            addOutput(ResponseOutputItem.ofMessage(message))

        /**
         * Alias for calling [addOutput] with `ResponseOutputItem.ofFileSearchCall(fileSearchCall)`.
         */
        fun addOutput(fileSearchCall: ResponseFileSearchToolCall) =
            addOutput(ResponseOutputItem.ofFileSearchCall(fileSearchCall))

        /** Alias for calling [addOutput] with `ResponseOutputItem.ofFunctionCall(functionCall)`. */
        fun addOutput(functionCall: ResponseFunctionToolCall) =
            addOutput(ResponseOutputItem.ofFunctionCall(functionCall))

        /**
         * Alias for calling [addOutput] with `ResponseOutputItem.ofWebSearchCall(webSearchCall)`.
         */
        fun addOutput(webSearchCall: ResponseFunctionWebSearch) =
            addOutput(ResponseOutputItem.ofWebSearchCall(webSearchCall))

        /** Alias for calling [addOutput] with `ResponseOutputItem.ofComputerCall(computerCall)`. */
        fun addOutput(computerCall: ResponseComputerToolCall) =
            addOutput(ResponseOutputItem.ofComputerCall(computerCall))

        /** Alias for calling [addOutput] with `ResponseOutputItem.ofReasoning(reasoning)`. */
        fun addOutput(reasoning: ResponseReasoningItem) =
            addOutput(ResponseOutputItem.ofReasoning(reasoning))

        /** Alias for calling [addOutput] with `ResponseOutputItem.ofCompaction(compaction)`. */
        fun addOutput(compaction: ResponseCompactionItem) =
            addOutput(ResponseOutputItem.ofCompaction(compaction))

        /**
         * Alias for calling [addOutput] with
         * `ResponseOutputItem.ofImageGenerationCall(imageGenerationCall)`.
         */
        fun addOutput(imageGenerationCall: ResponseOutputItem.ImageGenerationCall) =
            addOutput(ResponseOutputItem.ofImageGenerationCall(imageGenerationCall))

        /**
         * Alias for calling [addOutput] with
         * `ResponseOutputItem.ofCodeInterpreterCall(codeInterpreterCall)`.
         */
        fun addOutput(codeInterpreterCall: ResponseCodeInterpreterToolCall) =
            addOutput(ResponseOutputItem.ofCodeInterpreterCall(codeInterpreterCall))

        /**
         * Alias for calling [addOutput] with `ResponseOutputItem.ofLocalShellCall(localShellCall)`.
         */
        fun addOutput(localShellCall: ResponseOutputItem.LocalShellCall) =
            addOutput(ResponseOutputItem.ofLocalShellCall(localShellCall))

        /** Alias for calling [addOutput] with `ResponseOutputItem.ofShellCall(shellCall)`. */
        fun addOutput(shellCall: ResponseFunctionShellToolCall) =
            addOutput(ResponseOutputItem.ofShellCall(shellCall))

        /**
         * Alias for calling [addOutput] with
         * `ResponseOutputItem.ofShellCallOutput(shellCallOutput)`.
         */
        fun addOutput(shellCallOutput: ResponseFunctionShellToolCallOutput) =
            addOutput(ResponseOutputItem.ofShellCallOutput(shellCallOutput))

        /**
         * Alias for calling [addOutput] with `ResponseOutputItem.ofApplyPatchCall(applyPatchCall)`.
         */
        fun addOutput(applyPatchCall: ResponseApplyPatchToolCall) =
            addOutput(ResponseOutputItem.ofApplyPatchCall(applyPatchCall))

        /**
         * Alias for calling [addOutput] with
         * `ResponseOutputItem.ofApplyPatchCallOutput(applyPatchCallOutput)`.
         */
        fun addOutput(applyPatchCallOutput: ResponseApplyPatchToolCallOutput) =
            addOutput(ResponseOutputItem.ofApplyPatchCallOutput(applyPatchCallOutput))

        /** Alias for calling [addOutput] with `ResponseOutputItem.ofMcpCall(mcpCall)`. */
        fun addOutput(mcpCall: ResponseOutputItem.McpCall) =
            addOutput(ResponseOutputItem.ofMcpCall(mcpCall))

        /** Alias for calling [addOutput] with `ResponseOutputItem.ofMcpListTools(mcpListTools)`. */
        fun addOutput(mcpListTools: ResponseOutputItem.McpListTools) =
            addOutput(ResponseOutputItem.ofMcpListTools(mcpListTools))

        /**
         * Alias for calling [addOutput] with
         * `ResponseOutputItem.ofMcpApprovalRequest(mcpApprovalRequest)`.
         */
        fun addOutput(mcpApprovalRequest: ResponseOutputItem.McpApprovalRequest) =
            addOutput(ResponseOutputItem.ofMcpApprovalRequest(mcpApprovalRequest))

        /**
         * Alias for calling [addOutput] with `ResponseOutputItem.ofCustomToolCall(customToolCall)`.
         */
        fun addOutput(customToolCall: ResponseCustomToolCall) =
            addOutput(ResponseOutputItem.ofCustomToolCall(customToolCall))

        /**
         * Token accounting for the compaction pass, including cached, reasoning, and total tokens.
         */
        fun usage(usage: ResponseUsage) = usage(JsonField.of(usage))

        /**
         * Sets [Builder.usage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.usage] with a well-typed [ResponseUsage] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun usage(usage: JsonField<ResponseUsage>) = apply { this.usage = usage }

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
         * Returns an immutable instance of [CompactedResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .output()
         * .usage()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CompactedResponse =
            CompactedResponse(
                checkRequired("id", id),
                checkRequired("createdAt", createdAt),
                object_,
                checkRequired("output", output).map { it.toImmutable() },
                checkRequired("usage", usage),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): CompactedResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        _object_().let {
            if (it != JsonValue.from("response.compaction")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        output().forEach { it.validate() }
        usage().validate()
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("response.compaction")) 1 else 0 } +
            (output.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (usage.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CompactedResponse &&
            id == other.id &&
            createdAt == other.createdAt &&
            object_ == other.object_ &&
            output == other.output &&
            usage == other.usage &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, createdAt, object_, output, usage, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CompactedResponse{id=$id, createdAt=$createdAt, object_=$object_, output=$output, usage=$usage, additionalProperties=$additionalProperties}"
}
