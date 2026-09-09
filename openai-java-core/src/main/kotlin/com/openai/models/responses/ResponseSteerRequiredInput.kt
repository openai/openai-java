// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * An input stub identifying an outstanding client-owned tool result or approval decision. Copy the
 * stub and fill the result fields using the corresponding `response.create` input schema. Use saved
 * results without rerunning the tool. The server does not supply results, approval decisions, or
 * safety acknowledgements in these stubs.
 */
@JsonDeserialize(using = ResponseSteerRequiredInput.Deserializer::class)
@JsonSerialize(using = ResponseSteerRequiredInput.Serializer::class)
class ResponseSteerRequiredInput
private constructor(
    private val functionCallOutput: FunctionCallOutput? = null,
    private val customToolCallOutput: CustomToolCallOutput? = null,
    private val computerCallOutput: ComputerCallOutput? = null,
    private val shellCallOutput: ShellCallOutput? = null,
    private val applyPatchCallOutput: ApplyPatchCallOutput? = null,
    private val toolSearchOutput: ToolSearchOutput? = null,
    private val mcpApprovalResponse: McpApprovalResponse? = null,
    private val _json: JsonValue? = null,
) {

    /** Supply `output` using the function tool call output input schema. */
    fun functionCallOutput(): Optional<FunctionCallOutput> = Optional.ofNullable(functionCallOutput)

    /**
     * Supply `output` using the custom tool call output input schema. The original custom tool call
     * supplies the tool's name.
     */
    fun customToolCallOutput(): Optional<CustomToolCallOutput> =
        Optional.ofNullable(customToolCallOutput)

    /**
     * Supply `output` using the computer tool call output input schema, including any required
     * `acknowledged_safety_checks`.
     */
    fun computerCallOutput(): Optional<ComputerCallOutput> = Optional.ofNullable(computerCallOutput)

    /**
     * Supply `output` using the shell tool call output input schema. Each output entry includes
     * `stdout`, `stderr`, and `outcome`.
     */
    fun shellCallOutput(): Optional<ShellCallOutput> = Optional.ofNullable(shellCallOutput)

    /**
     * Supply `status` and optional `output` using the apply patch tool call output input schema.
     */
    fun applyPatchCallOutput(): Optional<ApplyPatchCallOutput> =
        Optional.ofNullable(applyPatchCallOutput)

    /**
     * Supply `tools` using the tool search output input schema, retaining `execution: "client"`.
     */
    fun toolSearchOutput(): Optional<ToolSearchOutput> = Optional.ofNullable(toolSearchOutput)

    /**
     * Supply `approve` using the MCP approval response input schema. An optional `reason` can be
     * supplied when denying the request. The original approval request identifies the tool and
     * server.
     */
    fun mcpApprovalResponse(): Optional<McpApprovalResponse> =
        Optional.ofNullable(mcpApprovalResponse)

    fun isFunctionCallOutput(): Boolean = functionCallOutput != null

    fun isCustomToolCallOutput(): Boolean = customToolCallOutput != null

    fun isComputerCallOutput(): Boolean = computerCallOutput != null

    fun isShellCallOutput(): Boolean = shellCallOutput != null

    fun isApplyPatchCallOutput(): Boolean = applyPatchCallOutput != null

    fun isToolSearchOutput(): Boolean = toolSearchOutput != null

    fun isMcpApprovalResponse(): Boolean = mcpApprovalResponse != null

    /** Supply `output` using the function tool call output input schema. */
    fun asFunctionCallOutput(): FunctionCallOutput =
        functionCallOutput.getOrThrow("functionCallOutput")

    /**
     * Supply `output` using the custom tool call output input schema. The original custom tool call
     * supplies the tool's name.
     */
    fun asCustomToolCallOutput(): CustomToolCallOutput =
        customToolCallOutput.getOrThrow("customToolCallOutput")

    /**
     * Supply `output` using the computer tool call output input schema, including any required
     * `acknowledged_safety_checks`.
     */
    fun asComputerCallOutput(): ComputerCallOutput =
        computerCallOutput.getOrThrow("computerCallOutput")

    /**
     * Supply `output` using the shell tool call output input schema. Each output entry includes
     * `stdout`, `stderr`, and `outcome`.
     */
    fun asShellCallOutput(): ShellCallOutput = shellCallOutput.getOrThrow("shellCallOutput")

    /**
     * Supply `status` and optional `output` using the apply patch tool call output input schema.
     */
    fun asApplyPatchCallOutput(): ApplyPatchCallOutput =
        applyPatchCallOutput.getOrThrow("applyPatchCallOutput")

    /**
     * Supply `tools` using the tool search output input schema, retaining `execution: "client"`.
     */
    fun asToolSearchOutput(): ToolSearchOutput = toolSearchOutput.getOrThrow("toolSearchOutput")

    /**
     * Supply `approve` using the MCP approval response input schema. An optional `reason` can be
     * supplied when denying the request. The original approval request identifies the tool and
     * server.
     */
    fun asMcpApprovalResponse(): McpApprovalResponse =
        mcpApprovalResponse.getOrThrow("mcpApprovalResponse")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    /**
     * Maps this instance's current variant to a value of type [T] using the given [visitor].
     *
     * Note that this method is _not_ forwards compatible with new variants from the API, unless
     * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of the
     * SDK gracefully, consider overriding [Visitor.unknown]:
     * ```java
     * import com.openai.core.JsonValue;
     * import java.util.Optional;
     *
     * Optional<String> result = responseSteerRequiredInput.accept(new ResponseSteerRequiredInput.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitFunctionCallOutput(FunctionCallOutput functionCallOutput) {
     *         return Optional.of(functionCallOutput.toString());
     *     }
     *
     *     // ...
     *
     *     @Override
     *     public Optional<String> unknown(JsonValue json) {
     *         // Or inspect the `json`.
     *         return Optional.empty();
     *     }
     * });
     * ```
     *
     * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor] and
     *   the current variant is unknown.
     */
    fun <T> accept(visitor: Visitor<T>): T =
        when {
            functionCallOutput != null -> visitor.visitFunctionCallOutput(functionCallOutput)
            customToolCallOutput != null -> visitor.visitCustomToolCallOutput(customToolCallOutput)
            computerCallOutput != null -> visitor.visitComputerCallOutput(computerCallOutput)
            shellCallOutput != null -> visitor.visitShellCallOutput(shellCallOutput)
            applyPatchCallOutput != null -> visitor.visitApplyPatchCallOutput(applyPatchCallOutput)
            toolSearchOutput != null -> visitor.visitToolSearchOutput(toolSearchOutput)
            mcpApprovalResponse != null -> visitor.visitMcpApprovalResponse(mcpApprovalResponse)
            else -> visitor.unknown(_json)
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
    fun validate(): ResponseSteerRequiredInput = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitFunctionCallOutput(functionCallOutput: FunctionCallOutput) {
                    functionCallOutput.validate()
                }

                override fun visitCustomToolCallOutput(customToolCallOutput: CustomToolCallOutput) {
                    customToolCallOutput.validate()
                }

                override fun visitComputerCallOutput(computerCallOutput: ComputerCallOutput) {
                    computerCallOutput.validate()
                }

                override fun visitShellCallOutput(shellCallOutput: ShellCallOutput) {
                    shellCallOutput.validate()
                }

                override fun visitApplyPatchCallOutput(applyPatchCallOutput: ApplyPatchCallOutput) {
                    applyPatchCallOutput.validate()
                }

                override fun visitToolSearchOutput(toolSearchOutput: ToolSearchOutput) {
                    toolSearchOutput.validate()
                }

                override fun visitMcpApprovalResponse(mcpApprovalResponse: McpApprovalResponse) {
                    mcpApprovalResponse.validate()
                }
            }
        )
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
        accept(
            object : Visitor<Int> {
                override fun visitFunctionCallOutput(functionCallOutput: FunctionCallOutput) =
                    functionCallOutput.validity()

                override fun visitCustomToolCallOutput(customToolCallOutput: CustomToolCallOutput) =
                    customToolCallOutput.validity()

                override fun visitComputerCallOutput(computerCallOutput: ComputerCallOutput) =
                    computerCallOutput.validity()

                override fun visitShellCallOutput(shellCallOutput: ShellCallOutput) =
                    shellCallOutput.validity()

                override fun visitApplyPatchCallOutput(applyPatchCallOutput: ApplyPatchCallOutput) =
                    applyPatchCallOutput.validity()

                override fun visitToolSearchOutput(toolSearchOutput: ToolSearchOutput) =
                    toolSearchOutput.validity()

                override fun visitMcpApprovalResponse(mcpApprovalResponse: McpApprovalResponse) =
                    mcpApprovalResponse.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponseSteerRequiredInput &&
            functionCallOutput == other.functionCallOutput &&
            customToolCallOutput == other.customToolCallOutput &&
            computerCallOutput == other.computerCallOutput &&
            shellCallOutput == other.shellCallOutput &&
            applyPatchCallOutput == other.applyPatchCallOutput &&
            toolSearchOutput == other.toolSearchOutput &&
            mcpApprovalResponse == other.mcpApprovalResponse
    }

    override fun hashCode(): Int =
        Objects.hash(
            functionCallOutput,
            customToolCallOutput,
            computerCallOutput,
            shellCallOutput,
            applyPatchCallOutput,
            toolSearchOutput,
            mcpApprovalResponse,
        )

    override fun toString(): String =
        when {
            functionCallOutput != null ->
                "ResponseSteerRequiredInput{functionCallOutput=$functionCallOutput}"
            customToolCallOutput != null ->
                "ResponseSteerRequiredInput{customToolCallOutput=$customToolCallOutput}"
            computerCallOutput != null ->
                "ResponseSteerRequiredInput{computerCallOutput=$computerCallOutput}"
            shellCallOutput != null ->
                "ResponseSteerRequiredInput{shellCallOutput=$shellCallOutput}"
            applyPatchCallOutput != null ->
                "ResponseSteerRequiredInput{applyPatchCallOutput=$applyPatchCallOutput}"
            toolSearchOutput != null ->
                "ResponseSteerRequiredInput{toolSearchOutput=$toolSearchOutput}"
            mcpApprovalResponse != null ->
                "ResponseSteerRequiredInput{mcpApprovalResponse=$mcpApprovalResponse}"
            _json != null -> "ResponseSteerRequiredInput{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ResponseSteerRequiredInput")
        }

    companion object {

        /** Supply `output` using the function tool call output input schema. */
        @JvmStatic
        fun ofFunctionCallOutput(functionCallOutput: FunctionCallOutput) =
            ResponseSteerRequiredInput(functionCallOutput = functionCallOutput)

        /**
         * Supply `output` using the custom tool call output input schema. The original custom tool
         * call supplies the tool's name.
         */
        @JvmStatic
        fun ofCustomToolCallOutput(customToolCallOutput: CustomToolCallOutput) =
            ResponseSteerRequiredInput(customToolCallOutput = customToolCallOutput)

        /**
         * Supply `output` using the computer tool call output input schema, including any required
         * `acknowledged_safety_checks`.
         */
        @JvmStatic
        fun ofComputerCallOutput(computerCallOutput: ComputerCallOutput) =
            ResponseSteerRequiredInput(computerCallOutput = computerCallOutput)

        /**
         * Supply `output` using the shell tool call output input schema. Each output entry includes
         * `stdout`, `stderr`, and `outcome`.
         */
        @JvmStatic
        fun ofShellCallOutput(shellCallOutput: ShellCallOutput) =
            ResponseSteerRequiredInput(shellCallOutput = shellCallOutput)

        /**
         * Supply `status` and optional `output` using the apply patch tool call output input
         * schema.
         */
        @JvmStatic
        fun ofApplyPatchCallOutput(applyPatchCallOutput: ApplyPatchCallOutput) =
            ResponseSteerRequiredInput(applyPatchCallOutput = applyPatchCallOutput)

        /**
         * Supply `tools` using the tool search output input schema, retaining `execution:
         * "client"`.
         */
        @JvmStatic
        fun ofToolSearchOutput(toolSearchOutput: ToolSearchOutput) =
            ResponseSteerRequiredInput(toolSearchOutput = toolSearchOutput)

        /**
         * Supply `approve` using the MCP approval response input schema. An optional `reason` can
         * be supplied when denying the request. The original approval request identifies the tool
         * and server.
         */
        @JvmStatic
        fun ofMcpApprovalResponse(mcpApprovalResponse: McpApprovalResponse) =
            ResponseSteerRequiredInput(mcpApprovalResponse = mcpApprovalResponse)
    }

    /**
     * An interface that defines how to map each variant of [ResponseSteerRequiredInput] to a value
     * of type [T].
     */
    interface Visitor<out T> {

        /** Supply `output` using the function tool call output input schema. */
        fun visitFunctionCallOutput(functionCallOutput: FunctionCallOutput): T

        /**
         * Supply `output` using the custom tool call output input schema. The original custom tool
         * call supplies the tool's name.
         */
        fun visitCustomToolCallOutput(customToolCallOutput: CustomToolCallOutput): T

        /**
         * Supply `output` using the computer tool call output input schema, including any required
         * `acknowledged_safety_checks`.
         */
        fun visitComputerCallOutput(computerCallOutput: ComputerCallOutput): T

        /**
         * Supply `output` using the shell tool call output input schema. Each output entry includes
         * `stdout`, `stderr`, and `outcome`.
         */
        fun visitShellCallOutput(shellCallOutput: ShellCallOutput): T

        /**
         * Supply `status` and optional `output` using the apply patch tool call output input
         * schema.
         */
        fun visitApplyPatchCallOutput(applyPatchCallOutput: ApplyPatchCallOutput): T

        /**
         * Supply `tools` using the tool search output input schema, retaining `execution:
         * "client"`.
         */
        fun visitToolSearchOutput(toolSearchOutput: ToolSearchOutput): T

        /**
         * Supply `approve` using the MCP approval response input schema. An optional `reason` can
         * be supplied when denying the request. The original approval request identifies the tool
         * and server.
         */
        fun visitMcpApprovalResponse(mcpApprovalResponse: McpApprovalResponse): T

        /**
         * Maps an unknown variant of [ResponseSteerRequiredInput] to a value of type [T].
         *
         * An instance of [ResponseSteerRequiredInput] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ResponseSteerRequiredInput: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<ResponseSteerRequiredInput>(ResponseSteerRequiredInput::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ResponseSteerRequiredInput {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "function_call_output" -> {
                    return tryDeserialize(node, jacksonTypeRef<FunctionCallOutput>())?.let {
                        ResponseSteerRequiredInput(functionCallOutput = it, _json = json)
                    } ?: ResponseSteerRequiredInput(_json = json)
                }
                "custom_tool_call_output" -> {
                    return tryDeserialize(node, jacksonTypeRef<CustomToolCallOutput>())?.let {
                        ResponseSteerRequiredInput(customToolCallOutput = it, _json = json)
                    } ?: ResponseSteerRequiredInput(_json = json)
                }
                "computer_call_output" -> {
                    return tryDeserialize(node, jacksonTypeRef<ComputerCallOutput>())?.let {
                        ResponseSteerRequiredInput(computerCallOutput = it, _json = json)
                    } ?: ResponseSteerRequiredInput(_json = json)
                }
                "shell_call_output" -> {
                    return tryDeserialize(node, jacksonTypeRef<ShellCallOutput>())?.let {
                        ResponseSteerRequiredInput(shellCallOutput = it, _json = json)
                    } ?: ResponseSteerRequiredInput(_json = json)
                }
                "apply_patch_call_output" -> {
                    return tryDeserialize(node, jacksonTypeRef<ApplyPatchCallOutput>())?.let {
                        ResponseSteerRequiredInput(applyPatchCallOutput = it, _json = json)
                    } ?: ResponseSteerRequiredInput(_json = json)
                }
                "tool_search_output" -> {
                    return tryDeserialize(node, jacksonTypeRef<ToolSearchOutput>())?.let {
                        ResponseSteerRequiredInput(toolSearchOutput = it, _json = json)
                    } ?: ResponseSteerRequiredInput(_json = json)
                }
                "mcp_approval_response" -> {
                    return tryDeserialize(node, jacksonTypeRef<McpApprovalResponse>())?.let {
                        ResponseSteerRequiredInput(mcpApprovalResponse = it, _json = json)
                    } ?: ResponseSteerRequiredInput(_json = json)
                }
            }

            return ResponseSteerRequiredInput(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<ResponseSteerRequiredInput>(ResponseSteerRequiredInput::class) {

        override fun serialize(
            value: ResponseSteerRequiredInput,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.functionCallOutput != null -> generator.writeObject(value.functionCallOutput)
                value.customToolCallOutput != null ->
                    generator.writeObject(value.customToolCallOutput)
                value.computerCallOutput != null -> generator.writeObject(value.computerCallOutput)
                value.shellCallOutput != null -> generator.writeObject(value.shellCallOutput)
                value.applyPatchCallOutput != null ->
                    generator.writeObject(value.applyPatchCallOutput)
                value.toolSearchOutput != null -> generator.writeObject(value.toolSearchOutput)
                value.mcpApprovalResponse != null ->
                    generator.writeObject(value.mcpApprovalResponse)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ResponseSteerRequiredInput")
            }
        }
    }

    /** Supply `output` using the function tool call output input schema. */
    class FunctionCallOutput
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val callId: JsonField<String>,
        private val name: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("call_id") @ExcludeMissing callId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(callId, name, type, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun callId(): String = callId.getRequired("call_id")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("function_call_output")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [callId].
         *
         * Unlike [callId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("call_id") @ExcludeMissing fun _callId(): JsonField<String> = callId

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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
             * Returns a mutable builder for constructing an instance of [FunctionCallOutput].
             *
             * The following fields are required:
             * ```java
             * .callId()
             * .name()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [FunctionCallOutput]. */
        class Builder internal constructor() {

            private var callId: JsonField<String>? = null
            private var name: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("function_call_output")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(functionCallOutput: FunctionCallOutput) = apply {
                callId = functionCallOutput.callId
                name = functionCallOutput.name
                type = functionCallOutput.type
                additionalProperties = functionCallOutput.additionalProperties.toMutableMap()
            }

            fun callId(callId: String) = callId(JsonField.of(callId))

            /**
             * Sets [Builder.callId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.callId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun callId(callId: JsonField<String>) = apply { this.callId = callId }

            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("function_call_output")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [FunctionCallOutput].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .callId()
             * .name()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): FunctionCallOutput =
                FunctionCallOutput(
                    checkRequired("callId", callId),
                    checkRequired("name", name),
                    type,
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
        fun validate(): FunctionCallOutput = apply {
            if (validated) {
                return@apply
            }

            callId()
            name()
            _type().let {
                if (it != JsonValue.from("function_call_output")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (callId.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("function_call_output")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is FunctionCallOutput &&
                callId == other.callId &&
                name == other.name &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(callId, name, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "FunctionCallOutput{callId=$callId, name=$name, type=$type, additionalProperties=$additionalProperties}"
    }

    /**
     * Supply `output` using the custom tool call output input schema. The original custom tool call
     * supplies the tool's name.
     */
    class CustomToolCallOutput
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val callId: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("call_id") @ExcludeMissing callId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(callId, type, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun callId(): String = callId.getRequired("call_id")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("custom_tool_call_output")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [callId].
         *
         * Unlike [callId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("call_id") @ExcludeMissing fun _callId(): JsonField<String> = callId

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
             * Returns a mutable builder for constructing an instance of [CustomToolCallOutput].
             *
             * The following fields are required:
             * ```java
             * .callId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [CustomToolCallOutput]. */
        class Builder internal constructor() {

            private var callId: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("custom_tool_call_output")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(customToolCallOutput: CustomToolCallOutput) = apply {
                callId = customToolCallOutput.callId
                type = customToolCallOutput.type
                additionalProperties = customToolCallOutput.additionalProperties.toMutableMap()
            }

            fun callId(callId: String) = callId(JsonField.of(callId))

            /**
             * Sets [Builder.callId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.callId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun callId(callId: JsonField<String>) = apply { this.callId = callId }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("custom_tool_call_output")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [CustomToolCallOutput].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .callId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): CustomToolCallOutput =
                CustomToolCallOutput(
                    checkRequired("callId", callId),
                    type,
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
        fun validate(): CustomToolCallOutput = apply {
            if (validated) {
                return@apply
            }

            callId()
            _type().let {
                if (it != JsonValue.from("custom_tool_call_output")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (callId.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("custom_tool_call_output")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CustomToolCallOutput &&
                callId == other.callId &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(callId, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "CustomToolCallOutput{callId=$callId, type=$type, additionalProperties=$additionalProperties}"
    }

    /**
     * Supply `output` using the computer tool call output input schema, including any required
     * `acknowledged_safety_checks`.
     */
    class ComputerCallOutput
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val callId: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("call_id") @ExcludeMissing callId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(callId, type, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun callId(): String = callId.getRequired("call_id")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("computer_call_output")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [callId].
         *
         * Unlike [callId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("call_id") @ExcludeMissing fun _callId(): JsonField<String> = callId

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
             * Returns a mutable builder for constructing an instance of [ComputerCallOutput].
             *
             * The following fields are required:
             * ```java
             * .callId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ComputerCallOutput]. */
        class Builder internal constructor() {

            private var callId: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("computer_call_output")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(computerCallOutput: ComputerCallOutput) = apply {
                callId = computerCallOutput.callId
                type = computerCallOutput.type
                additionalProperties = computerCallOutput.additionalProperties.toMutableMap()
            }

            fun callId(callId: String) = callId(JsonField.of(callId))

            /**
             * Sets [Builder.callId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.callId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun callId(callId: JsonField<String>) = apply { this.callId = callId }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("computer_call_output")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ComputerCallOutput].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .callId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ComputerCallOutput =
                ComputerCallOutput(
                    checkRequired("callId", callId),
                    type,
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
        fun validate(): ComputerCallOutput = apply {
            if (validated) {
                return@apply
            }

            callId()
            _type().let {
                if (it != JsonValue.from("computer_call_output")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (callId.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("computer_call_output")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ComputerCallOutput &&
                callId == other.callId &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(callId, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ComputerCallOutput{callId=$callId, type=$type, additionalProperties=$additionalProperties}"
    }

    /**
     * Supply `output` using the shell tool call output input schema. Each output entry includes
     * `stdout`, `stderr`, and `outcome`.
     */
    class ShellCallOutput
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val callId: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("call_id") @ExcludeMissing callId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(callId, type, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun callId(): String = callId.getRequired("call_id")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("shell_call_output")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [callId].
         *
         * Unlike [callId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("call_id") @ExcludeMissing fun _callId(): JsonField<String> = callId

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
             * Returns a mutable builder for constructing an instance of [ShellCallOutput].
             *
             * The following fields are required:
             * ```java
             * .callId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ShellCallOutput]. */
        class Builder internal constructor() {

            private var callId: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("shell_call_output")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(shellCallOutput: ShellCallOutput) = apply {
                callId = shellCallOutput.callId
                type = shellCallOutput.type
                additionalProperties = shellCallOutput.additionalProperties.toMutableMap()
            }

            fun callId(callId: String) = callId(JsonField.of(callId))

            /**
             * Sets [Builder.callId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.callId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun callId(callId: JsonField<String>) = apply { this.callId = callId }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("shell_call_output")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ShellCallOutput].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .callId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ShellCallOutput =
                ShellCallOutput(
                    checkRequired("callId", callId),
                    type,
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
        fun validate(): ShellCallOutput = apply {
            if (validated) {
                return@apply
            }

            callId()
            _type().let {
                if (it != JsonValue.from("shell_call_output")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (callId.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("shell_call_output")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ShellCallOutput &&
                callId == other.callId &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(callId, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ShellCallOutput{callId=$callId, type=$type, additionalProperties=$additionalProperties}"
    }

    /**
     * Supply `status` and optional `output` using the apply patch tool call output input schema.
     */
    class ApplyPatchCallOutput
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val callId: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("call_id") @ExcludeMissing callId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(callId, type, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun callId(): String = callId.getRequired("call_id")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("apply_patch_call_output")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [callId].
         *
         * Unlike [callId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("call_id") @ExcludeMissing fun _callId(): JsonField<String> = callId

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
             * Returns a mutable builder for constructing an instance of [ApplyPatchCallOutput].
             *
             * The following fields are required:
             * ```java
             * .callId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ApplyPatchCallOutput]. */
        class Builder internal constructor() {

            private var callId: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("apply_patch_call_output")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(applyPatchCallOutput: ApplyPatchCallOutput) = apply {
                callId = applyPatchCallOutput.callId
                type = applyPatchCallOutput.type
                additionalProperties = applyPatchCallOutput.additionalProperties.toMutableMap()
            }

            fun callId(callId: String) = callId(JsonField.of(callId))

            /**
             * Sets [Builder.callId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.callId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun callId(callId: JsonField<String>) = apply { this.callId = callId }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("apply_patch_call_output")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ApplyPatchCallOutput].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .callId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ApplyPatchCallOutput =
                ApplyPatchCallOutput(
                    checkRequired("callId", callId),
                    type,
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
        fun validate(): ApplyPatchCallOutput = apply {
            if (validated) {
                return@apply
            }

            callId()
            _type().let {
                if (it != JsonValue.from("apply_patch_call_output")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (callId.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("apply_patch_call_output")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ApplyPatchCallOutput &&
                callId == other.callId &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(callId, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ApplyPatchCallOutput{callId=$callId, type=$type, additionalProperties=$additionalProperties}"
    }

    /**
     * Supply `tools` using the tool search output input schema, retaining `execution: "client"`.
     */
    class ToolSearchOutput
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val callId: JsonField<String>,
        private val execution: JsonValue,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("call_id") @ExcludeMissing callId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("execution") @ExcludeMissing execution: JsonValue = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(callId, execution, type, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun callId(): String = callId.getRequired("call_id")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("client")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("execution") @ExcludeMissing fun _execution(): JsonValue = execution

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("tool_search_output")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [callId].
         *
         * Unlike [callId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("call_id") @ExcludeMissing fun _callId(): JsonField<String> = callId

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
             * Returns a mutable builder for constructing an instance of [ToolSearchOutput].
             *
             * The following fields are required:
             * ```java
             * .callId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ToolSearchOutput]. */
        class Builder internal constructor() {

            private var callId: JsonField<String>? = null
            private var execution: JsonValue = JsonValue.from("client")
            private var type: JsonValue = JsonValue.from("tool_search_output")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(toolSearchOutput: ToolSearchOutput) = apply {
                callId = toolSearchOutput.callId
                execution = toolSearchOutput.execution
                type = toolSearchOutput.type
                additionalProperties = toolSearchOutput.additionalProperties.toMutableMap()
            }

            fun callId(callId: String) = callId(JsonField.of(callId))

            /**
             * Sets [Builder.callId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.callId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun callId(callId: JsonField<String>) = apply { this.callId = callId }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("client")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun execution(execution: JsonValue) = apply { this.execution = execution }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("tool_search_output")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [ToolSearchOutput].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .callId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ToolSearchOutput =
                ToolSearchOutput(
                    checkRequired("callId", callId),
                    execution,
                    type,
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
        fun validate(): ToolSearchOutput = apply {
            if (validated) {
                return@apply
            }

            callId()
            _execution().let {
                if (it != JsonValue.from("client")) {
                    throw OpenAIInvalidDataException("'execution' is invalid, received $it")
                }
            }
            _type().let {
                if (it != JsonValue.from("tool_search_output")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (callId.asKnown().isPresent) 1 else 0) +
                execution.let { if (it == JsonValue.from("client")) 1 else 0 } +
                type.let { if (it == JsonValue.from("tool_search_output")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ToolSearchOutput &&
                callId == other.callId &&
                execution == other.execution &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(callId, execution, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ToolSearchOutput{callId=$callId, execution=$execution, type=$type, additionalProperties=$additionalProperties}"
    }

    /**
     * Supply `approve` using the MCP approval response input schema. An optional `reason` can be
     * supplied when denying the request. The original approval request identifies the tool and
     * server.
     */
    class McpApprovalResponse
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val approvalRequestId: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("approval_request_id")
            @ExcludeMissing
            approvalRequestId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(approvalRequestId, type, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun approvalRequestId(): String = approvalRequestId.getRequired("approval_request_id")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("mcp_approval_response")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [approvalRequestId].
         *
         * Unlike [approvalRequestId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("approval_request_id")
        @ExcludeMissing
        fun _approvalRequestId(): JsonField<String> = approvalRequestId

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
             * Returns a mutable builder for constructing an instance of [McpApprovalResponse].
             *
             * The following fields are required:
             * ```java
             * .approvalRequestId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [McpApprovalResponse]. */
        class Builder internal constructor() {

            private var approvalRequestId: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("mcp_approval_response")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(mcpApprovalResponse: McpApprovalResponse) = apply {
                approvalRequestId = mcpApprovalResponse.approvalRequestId
                type = mcpApprovalResponse.type
                additionalProperties = mcpApprovalResponse.additionalProperties.toMutableMap()
            }

            fun approvalRequestId(approvalRequestId: String) =
                approvalRequestId(JsonField.of(approvalRequestId))

            /**
             * Sets [Builder.approvalRequestId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.approvalRequestId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun approvalRequestId(approvalRequestId: JsonField<String>) = apply {
                this.approvalRequestId = approvalRequestId
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("mcp_approval_response")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

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
             * Returns an immutable instance of [McpApprovalResponse].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .approvalRequestId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): McpApprovalResponse =
                McpApprovalResponse(
                    checkRequired("approvalRequestId", approvalRequestId),
                    type,
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
        fun validate(): McpApprovalResponse = apply {
            if (validated) {
                return@apply
            }

            approvalRequestId()
            _type().let {
                if (it != JsonValue.from("mcp_approval_response")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
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
            (if (approvalRequestId.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("mcp_approval_response")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is McpApprovalResponse &&
                approvalRequestId == other.approvalRequestId &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(approvalRequestId, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "McpApprovalResponse{approvalRequestId=$approvalRequestId, type=$type, additionalProperties=$additionalProperties}"
    }
}
