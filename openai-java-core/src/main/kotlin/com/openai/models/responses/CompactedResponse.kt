// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

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
import com.openai.core.collectAllProperties
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class CompactedResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<Long>,
    private val object_: JsonValue,
    private val output: JsonField<List<ResponseOutputItem>>,
    private val usage: JsonField<ResponseUsage>,
    private val image: JsonField<Image>,
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
        @JsonProperty("image") @ExcludeMissing image: JsonField<Image> = JsonMissing.of(),
    ) : this(id, createdAt, object_, output, usage, image, mutableMapOf())

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
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun image(): Optional<Image> = image.getOptional("image")

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

    /**
     * Returns the raw JSON value of [image].
     *
     * Unlike [image], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("image") @ExcludeMissing fun _image(): JsonField<Image> = image

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    /**
     * Returns an immutable snapshot of all present JSON properties, including declared and
     * additional properties.
     *
     * Keys use their JSON names. Declared properties take precedence over additional properties
     * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
     * values are preserved.
     */
    fun _allProperties(): Map<String, JsonValue> =
        collectAllProperties(
            additionalProperties,
            "id" to this.id,
            "created_at" to this.createdAt,
            "object" to this.object_,
            "output" to this.output,
            "usage" to this.usage,
            "image" to this.image,
        )

    @JvmSynthetic
    internal fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    @JsonAnyGetter
    @ExcludeMissing
    private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

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
        private var image: JsonField<Image> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(compactedResponse: CompactedResponse) = apply {
            id = compactedResponse.id
            createdAt = compactedResponse.createdAt
            object_ = compactedResponse.object_
            output = compactedResponse.output.map { it.toMutableList() }
            usage = compactedResponse.usage
            image = compactedResponse.image
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
         * Alias for calling [addOutput] with
         * `ResponseOutputItem.ofFunctionCallOutput(functionCallOutput)`.
         */
        fun addOutput(functionCallOutput: ResponseFunctionToolCallOutputItem) =
            addOutput(ResponseOutputItem.ofFunctionCallOutput(functionCallOutput))

        /**
         * Alias for calling [addOutput] with `ResponseOutputItem.ofWebSearchCall(webSearchCall)`.
         */
        fun addOutput(webSearchCall: ResponseFunctionWebSearch) =
            addOutput(ResponseOutputItem.ofWebSearchCall(webSearchCall))

        /** Alias for calling [addOutput] with `ResponseOutputItem.ofComputerCall(computerCall)`. */
        fun addOutput(computerCall: ResponseComputerToolCall) =
            addOutput(ResponseOutputItem.ofComputerCall(computerCall))

        /**
         * Alias for calling [addOutput] with
         * `ResponseOutputItem.ofComputerCallOutput(computerCallOutput)`.
         */
        fun addOutput(computerCallOutput: ResponseComputerToolCallOutputItem) =
            addOutput(ResponseOutputItem.ofComputerCallOutput(computerCallOutput))

        /** Alias for calling [addOutput] with `ResponseOutputItem.ofReasoning(reasoning)`. */
        fun addOutput(reasoning: ResponseReasoningItem) =
            addOutput(ResponseOutputItem.ofReasoning(reasoning))

        /** Alias for calling [addOutput] with `ResponseOutputItem.ofProgram(program)`. */
        fun addOutput(program: ResponseOutputItem.Program) =
            addOutput(ResponseOutputItem.ofProgram(program))

        /**
         * Alias for calling [addOutput] with `ResponseOutputItem.ofProgramOutput(programOutput)`.
         */
        fun addOutput(programOutput: ResponseOutputItem.ProgramOutput) =
            addOutput(ResponseOutputItem.ofProgramOutput(programOutput))

        /**
         * Alias for calling [addOutput] with `ResponseOutputItem.ofToolSearchCall(toolSearchCall)`.
         */
        fun addOutput(toolSearchCall: ResponseToolSearchCall) =
            addOutput(ResponseOutputItem.ofToolSearchCall(toolSearchCall))

        /**
         * Alias for calling [addOutput] with
         * `ResponseOutputItem.ofToolSearchOutput(toolSearchOutput)`.
         */
        fun addOutput(toolSearchOutput: ResponseToolSearchOutputItem) =
            addOutput(ResponseOutputItem.ofToolSearchOutput(toolSearchOutput))

        /**
         * Alias for calling [addOutput] with
         * `ResponseOutputItem.ofAdditionalTools(additionalTools)`.
         */
        fun addOutput(additionalTools: ResponseOutputItem.AdditionalTools) =
            addOutput(ResponseOutputItem.ofAdditionalTools(additionalTools))

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

        /**
         * Alias for calling [addOutput] with
         * `ResponseOutputItem.ofLocalShellCallOutput(localShellCallOutput)`.
         */
        fun addOutput(localShellCallOutput: ResponseOutputItem.LocalShellCallOutput) =
            addOutput(ResponseOutputItem.ofLocalShellCallOutput(localShellCallOutput))

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
         * Alias for calling [addOutput] with
         * `ResponseOutputItem.ofMcpApprovalResponse(mcpApprovalResponse)`.
         */
        fun addOutput(mcpApprovalResponse: ResponseOutputItem.McpApprovalResponse) =
            addOutput(ResponseOutputItem.ofMcpApprovalResponse(mcpApprovalResponse))

        /**
         * Alias for calling [addOutput] with `ResponseOutputItem.ofCustomToolCall(customToolCall)`.
         */
        fun addOutput(customToolCall: ResponseCustomToolCall) =
            addOutput(ResponseOutputItem.ofCustomToolCall(customToolCall))

        /**
         * Alias for calling [addOutput] with
         * `ResponseOutputItem.ofCustomToolCallOutput(customToolCallOutput)`.
         */
        fun addOutput(customToolCallOutput: ResponseCustomToolCallOutputItem) =
            addOutput(ResponseOutputItem.ofCustomToolCallOutput(customToolCallOutput))

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

        fun image(image: Image) = image(JsonField.of(image))

        /**
         * Sets [Builder.image] to an arbitrary JSON value.
         *
         * You should usually call [Builder.image] with a well-typed [Image] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun image(image: JsonField<Image>) = apply { this.image = image }

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
                image,
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
        image().ifPresent { it.validate() }
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
            (usage.asKnown().getOrNull()?.validity() ?: 0) +
            (image.asKnown().getOrNull()?.validity() ?: 0)

    class Image
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val contextCompression: JsonField<ContextCompression>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("context_compression")
            @ExcludeMissing
            contextCompression: JsonField<ContextCompression> = JsonMissing.of()
        ) : this(contextCompression, mutableMapOf())

        /**
         * Effective image context optimization policy.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun contextCompression(): ContextCompression =
            contextCompression.getRequired("context_compression")

        /**
         * Returns the raw JSON value of [contextCompression].
         *
         * Unlike [contextCompression], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("context_compression")
        @ExcludeMissing
        fun _contextCompression(): JsonField<ContextCompression> = contextCompression

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        /**
         * Returns an immutable snapshot of all present JSON properties, including declared and
         * additional properties.
         *
         * Keys use their JSON names. Declared properties take precedence over additional properties
         * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
         * values are preserved.
         */
        fun _allProperties(): Map<String, JsonValue> =
            collectAllProperties(
                additionalProperties,
                "context_compression" to this.contextCompression,
            )

        @JvmSynthetic
        internal fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        @JsonAnyGetter
        @ExcludeMissing
        private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Image].
             *
             * The following fields are required:
             * ```java
             * .contextCompression()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Image]. */
        class Builder internal constructor() {

            private var contextCompression: JsonField<ContextCompression>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(image: Image) = apply {
                contextCompression = image.contextCompression
                additionalProperties = image.additionalProperties.toMutableMap()
            }

            /** Effective image context optimization policy. */
            fun contextCompression(contextCompression: ContextCompression) =
                contextCompression(JsonField.of(contextCompression))

            /**
             * Sets [Builder.contextCompression] to an arbitrary JSON value.
             *
             * You should usually call [Builder.contextCompression] with a well-typed
             * [ContextCompression] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun contextCompression(contextCompression: JsonField<ContextCompression>) = apply {
                this.contextCompression = contextCompression
            }

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
             * Returns an immutable instance of [Image].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .contextCompression()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Image =
                Image(
                    checkRequired("contextCompression", contextCompression),
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
        fun validate(): Image = apply {
            if (validated) {
                return@apply
            }

            contextCompression().validate()
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
        internal fun validity(): Int = (contextCompression.asKnown().getOrNull()?.validity() ?: 0)

        /** Effective image context optimization policy. */
        class ContextCompression
        @JsonCreator
        private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val ENABLED = of("enabled")

                @JvmField val DISABLED = of("disabled")

                @JvmStatic fun of(value: String) = ContextCompression(JsonField.of(value))
            }

            /** An enum containing [ContextCompression]'s known values. */
            @Deprecated("Use asString() for string values or _value() for raw JSON.")
            enum class Known {
                ENABLED,
                DISABLED,
            }

            /**
             * An enum containing [ContextCompression]'s known values, as well as an [_UNKNOWN]
             * member.
             *
             * An instance of [ContextCompression] can contain an unknown value in a couple of
             * cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            @Deprecated("Use asString() for string values or _value() for raw JSON.")
            enum class Value {
                ENABLED,
                DISABLED,
                /**
                 * An enum member indicating that [ContextCompression] was instantiated with an
                 * unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            @Deprecated("Use asString() for string values or _value() for raw JSON.")
            fun value(): Value =
                when (this) {
                    ENABLED -> Value.ENABLED
                    DISABLED -> Value.DISABLED
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
            @Deprecated("Use asString() for string values or _value() for raw JSON.")
            fun known(): Known =
                when (this) {
                    ENABLED -> Known.ENABLED
                    DISABLED -> Known.DISABLED
                    else -> throw OpenAIInvalidDataException("Unknown ContextCompression: $value")
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
            fun validate(): ContextCompression = apply {
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

                return other is ContextCompression && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Image &&
                contextCompression == other.contextCompression &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(contextCompression, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Image{contextCompression=$contextCompression, additionalProperties=$additionalProperties}"
    }

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
            image == other.image &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, createdAt, object_, output, usage, image, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CompactedResponse{id=$id, createdAt=$createdAt, object_=$object_, output=$output, usage=$usage, image=$image, additionalProperties=$additionalProperties}"
}
