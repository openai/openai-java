// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

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
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.collectAllProperties
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Model, prompt, and tool settings for tasks delegated by the Live session to a Responses backend.
 */
class ResponsesDelegationConfig
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val model: JsonField<String>,
    private val instructions: JsonField<String>,
    private val maxOutputTokens: JsonField<Long>,
    private val parallelToolCalls: JsonField<Boolean>,
    private val reasoning: JsonField<Reasoning>,
    private val serviceTier: JsonField<ServiceTier>,
    private val text: JsonField<Text>,
    private val toolChoice: JsonField<ToolChoice>,
    private val tools: JsonField<List<Tool>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
        @JsonProperty("instructions")
        @ExcludeMissing
        instructions: JsonField<String> = JsonMissing.of(),
        @JsonProperty("max_output_tokens")
        @ExcludeMissing
        maxOutputTokens: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("parallel_tool_calls")
        @ExcludeMissing
        parallelToolCalls: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("reasoning")
        @ExcludeMissing
        reasoning: JsonField<Reasoning> = JsonMissing.of(),
        @JsonProperty("service_tier")
        @ExcludeMissing
        serviceTier: JsonField<ServiceTier> = JsonMissing.of(),
        @JsonProperty("text") @ExcludeMissing text: JsonField<Text> = JsonMissing.of(),
        @JsonProperty("tool_choice")
        @ExcludeMissing
        toolChoice: JsonField<ToolChoice> = JsonMissing.of(),
        @JsonProperty("tools") @ExcludeMissing tools: JsonField<List<Tool>> = JsonMissing.of(),
    ) : this(
        model,
        instructions,
        maxOutputTokens,
        parallelToolCalls,
        reasoning,
        serviceTier,
        text,
        toolChoice,
        tools,
        mutableMapOf(),
    )

    /**
     * The model used for server-owned Responses delegations. The schema requires this property.
     * Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun model(): java.util.Optional<String> = model.getOptional("model")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun modelOrThrow(): String = model.getRequired("model")

    /**
     * Instructions for the delegated Responses model, separate from Live instructions. See
     * [backend prompting](https://developers.openai.com/api/docs/guides/live-delegation#start-with-your-existing-backend-prompt).
     * Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun instructions(): java.util.Optional<String> = instructions.getOptional("instructions")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun instructionsOrThrow(): String = instructions.getRequired("instructions")

    /**
     * Maximum number of output tokens for each delegated response. Returns empty if the JSON
     * property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun maxOutputTokens(): java.util.Optional<Long> =
        maxOutputTokens.getOptional("max_output_tokens")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun maxOutputTokensOrThrow(): Long = maxOutputTokens.getRequired("max_output_tokens")

    /**
     * Whether the delegated Responses model may request multiple tool calls in a single response.
     * Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun parallelToolCalls(): java.util.Optional<Boolean> =
        parallelToolCalls.getOptional("parallel_tool_calls")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun parallelToolCallsOrThrow(): Boolean = parallelToolCalls.getRequired("parallel_tool_calls")

    /**
     * Reasoning settings passed to each delegated Responses request. Returns empty if the JSON
     * property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun reasoning(): java.util.Optional<Reasoning> = reasoning.getOptional("reasoning")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun reasoningOrThrow(): Reasoning = reasoning.getRequired("reasoning")

    /**
     * Service tier for delegated Responses requests. Returns empty if the JSON property is missing
     * or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun serviceTier(): java.util.Optional<ServiceTier> = serviceTier.getOptional("service_tier")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun serviceTierOrThrow(): ServiceTier = serviceTier.getRequired("service_tier")

    /**
     * Text generation settings passed to each delegated Responses request. Returns empty if the
     * JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun text(): java.util.Optional<Text> = text.getOptional("text")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun textOrThrow(): Text = text.getRequired("text")

    /**
     * Controls which tool the Responses backend uses when handling a task delegated by the Live
     * model. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun toolChoice(): java.util.Optional<ToolChoice> = toolChoice.getOptional("tool_choice")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun toolChoiceOrThrow(): ToolChoice = toolChoice.getRequired("tool_choice")

    /**
     * Tools available to the Responses backend while it handles tasks delegated by the Live model.
     * Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun tools(): java.util.Optional<List<Tool>> = tools.getOptional("tools")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun toolsOrThrow(): List<Tool> = tools.getRequired("tools")

    /**
     * Returns the raw JSON value of [model].
     *
     * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

    /**
     * Returns the raw JSON value of [instructions].
     *
     * Unlike [instructions], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("instructions")
    @ExcludeMissing
    fun _instructions(): JsonField<String> = instructions

    /**
     * Returns the raw JSON value of [maxOutputTokens].
     *
     * Unlike [maxOutputTokens], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("max_output_tokens")
    @ExcludeMissing
    fun _maxOutputTokens(): JsonField<Long> = maxOutputTokens

    /**
     * Returns the raw JSON value of [parallelToolCalls].
     *
     * Unlike [parallelToolCalls], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("parallel_tool_calls")
    @ExcludeMissing
    fun _parallelToolCalls(): JsonField<Boolean> = parallelToolCalls

    /**
     * Returns the raw JSON value of [reasoning].
     *
     * Unlike [reasoning], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("reasoning") @ExcludeMissing fun _reasoning(): JsonField<Reasoning> = reasoning

    /**
     * Returns the raw JSON value of [serviceTier].
     *
     * Unlike [serviceTier], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("service_tier")
    @ExcludeMissing
    fun _serviceTier(): JsonField<ServiceTier> = serviceTier

    /**
     * Returns the raw JSON value of [text].
     *
     * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<Text> = text

    /**
     * Returns the raw JSON value of [toolChoice].
     *
     * Unlike [toolChoice], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tool_choice")
    @ExcludeMissing
    fun _toolChoice(): JsonField<ToolChoice> = toolChoice

    /**
     * Returns the raw JSON value of [tools].
     *
     * Unlike [tools], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tools") @ExcludeMissing fun _tools(): JsonField<List<Tool>> = tools

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
            "model" to this.model,
            "instructions" to this.instructions,
            "max_output_tokens" to this.maxOutputTokens,
            "parallel_tool_calls" to this.parallelToolCalls,
            "reasoning" to this.reasoning,
            "service_tier" to this.serviceTier,
            "text" to this.text,
            "tool_choice" to this.toolChoice,
            "tools" to this.tools,
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
         * Returns a mutable builder for constructing an instance of [ResponsesDelegationConfig].
         *
         * The following fields are required:
         * ```java
         * .model()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponsesDelegationConfig]. */
    class Builder internal constructor() {

        private var model: JsonField<String>? = null
        private var instructions: JsonField<String> = JsonMissing.of()
        private var maxOutputTokens: JsonField<Long> = JsonMissing.of()
        private var parallelToolCalls: JsonField<Boolean> = JsonMissing.of()
        private var reasoning: JsonField<Reasoning> = JsonMissing.of()
        private var serviceTier: JsonField<ServiceTier> = JsonMissing.of()
        private var text: JsonField<Text> = JsonMissing.of()
        private var toolChoice: JsonField<ToolChoice> = JsonMissing.of()
        private var tools: JsonField<MutableList<Tool>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responsesDelegationConfig: ResponsesDelegationConfig) = apply {
            model = responsesDelegationConfig.model
            instructions = responsesDelegationConfig.instructions
            maxOutputTokens = responsesDelegationConfig.maxOutputTokens
            parallelToolCalls = responsesDelegationConfig.parallelToolCalls
            reasoning = responsesDelegationConfig.reasoning
            serviceTier = responsesDelegationConfig.serviceTier
            text = responsesDelegationConfig.text
            toolChoice = responsesDelegationConfig.toolChoice
            tools = responsesDelegationConfig.tools.map { it.toMutableList() }
            additionalProperties = responsesDelegationConfig.additionalProperties.toMutableMap()
        }

        /** The model used for server-owned Responses delegations. */
        fun model(model: String) = model(JsonField.of(model))

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(model: JsonField<String>) = apply { this.model = model }

        /**
         * Instructions for the delegated Responses model, separate from Live instructions. See
         * [backend prompting](https://developers.openai.com/api/docs/guides/live-delegation#start-with-your-existing-backend-prompt).
         */
        fun instructions(instructions: String?) = instructions(JsonField.ofNullable(instructions))

        /** Alias for calling [Builder.instructions] with `instructions.orElse(null)`. */
        fun instructions(instructions: Optional<String>) = instructions(instructions.getOrNull())

        /**
         * Sets [Builder.instructions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.instructions] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun instructions(instructions: JsonField<String>) = apply {
            this.instructions = instructions
        }

        /** Maximum number of output tokens for each delegated response. */
        fun maxOutputTokens(maxOutputTokens: Long?) =
            maxOutputTokens(JsonField.ofNullable(maxOutputTokens))

        /**
         * Alias for [Builder.maxOutputTokens].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun maxOutputTokens(maxOutputTokens: Long) = maxOutputTokens(maxOutputTokens as Long?)

        /** Alias for calling [Builder.maxOutputTokens] with `maxOutputTokens.orElse(null)`. */
        fun maxOutputTokens(maxOutputTokens: Optional<Long>) =
            maxOutputTokens(maxOutputTokens.getOrNull())

        /**
         * Sets [Builder.maxOutputTokens] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxOutputTokens] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun maxOutputTokens(maxOutputTokens: JsonField<Long>) = apply {
            this.maxOutputTokens = maxOutputTokens
        }

        /**
         * Whether the delegated Responses model may request multiple tool calls in a single
         * response.
         */
        fun parallelToolCalls(parallelToolCalls: Boolean?) =
            parallelToolCalls(JsonField.ofNullable(parallelToolCalls))

        /**
         * Alias for [Builder.parallelToolCalls].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun parallelToolCalls(parallelToolCalls: Boolean) =
            parallelToolCalls(parallelToolCalls as Boolean?)

        /** Alias for calling [Builder.parallelToolCalls] with `parallelToolCalls.orElse(null)`. */
        fun parallelToolCalls(parallelToolCalls: Optional<Boolean>) =
            parallelToolCalls(parallelToolCalls.getOrNull())

        /**
         * Sets [Builder.parallelToolCalls] to an arbitrary JSON value.
         *
         * You should usually call [Builder.parallelToolCalls] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun parallelToolCalls(parallelToolCalls: JsonField<Boolean>) = apply {
            this.parallelToolCalls = parallelToolCalls
        }

        /** Reasoning settings passed to each delegated Responses request. */
        fun reasoning(reasoning: Reasoning?) = reasoning(JsonField.ofNullable(reasoning))

        /** Alias for calling [Builder.reasoning] with `reasoning.orElse(null)`. */
        fun reasoning(reasoning: Optional<Reasoning>) = reasoning(reasoning.getOrNull())

        /**
         * Sets [Builder.reasoning] to an arbitrary JSON value.
         *
         * You should usually call [Builder.reasoning] with a well-typed [Reasoning] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun reasoning(reasoning: JsonField<Reasoning>) = apply { this.reasoning = reasoning }

        /** Service tier for delegated Responses requests. */
        fun serviceTier(serviceTier: ServiceTier?) = serviceTier(JsonField.ofNullable(serviceTier))

        /** Alias for calling [Builder.serviceTier] with `serviceTier.orElse(null)`. */
        fun serviceTier(serviceTier: Optional<ServiceTier>) = serviceTier(serviceTier.getOrNull())

        /**
         * Sets [Builder.serviceTier] to an arbitrary JSON value.
         *
         * You should usually call [Builder.serviceTier] with a well-typed [ServiceTier] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun serviceTier(serviceTier: JsonField<ServiceTier>) = apply {
            this.serviceTier = serviceTier
        }

        /** Text generation settings passed to each delegated Responses request. */
        fun text(text: Text?) = text(JsonField.ofNullable(text))

        /** Alias for calling [Builder.text] with `text.orElse(null)`. */
        fun text(text: Optional<Text>) = text(text.getOrNull())

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [Text] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun text(text: JsonField<Text>) = apply { this.text = text }

        /**
         * Controls which tool the Responses backend uses when handling a task delegated by the Live
         * model.
         */
        fun toolChoice(toolChoice: ToolChoice) = toolChoice(JsonField.of(toolChoice))

        /**
         * Sets [Builder.toolChoice] to an arbitrary JSON value.
         *
         * You should usually call [Builder.toolChoice] with a well-typed [ToolChoice] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun toolChoice(toolChoice: JsonField<ToolChoice>) = apply { this.toolChoice = toolChoice }

        /**
         * Alias for calling [toolChoice] with
         * `ToolChoice.ofLiveFunctionToolChoiceParam(liveFunctionToolChoiceParam)`.
         */
        fun toolChoice(liveFunctionToolChoiceParam: ToolChoice.LiveFunctionToolChoiceParam) =
            toolChoice(ToolChoice.ofLiveFunctionToolChoiceParam(liveFunctionToolChoiceParam))

        /**
         * Alias for calling [toolChoice] with
         * `ToolChoice.ofLiveMcpToolChoiceParam(liveMcpToolChoiceParam)`.
         */
        fun toolChoice(liveMcpToolChoiceParam: ToolChoice.LiveMcpToolChoiceParam) =
            toolChoice(ToolChoice.ofLiveMcpToolChoiceParam(liveMcpToolChoiceParam))

        /** Alias for calling [toolChoice] with `ToolChoice.ofLiveSpecificFileSearchParam()`. */
        fun toolChoiceLiveSpecificFileSearchParam() =
            toolChoice(ToolChoice.ofLiveSpecificFileSearchParam())

        /** Alias for calling [toolChoice] with `ToolChoice.ofLiveSpecificWebSearchParam()`. */
        fun toolChoiceLiveSpecificWebSearchParam() =
            toolChoice(ToolChoice.ofLiveSpecificWebSearchParam())

        /**
         * Alias for calling [toolChoice] with `ToolChoice.ofLiveSpecificWebSearchPreviewParam()`.
         */
        fun toolChoiceLiveSpecificWebSearchPreviewParam() =
            toolChoice(ToolChoice.ofLiveSpecificWebSearchPreviewParam())

        /** Alias for calling [toolChoice] with `ToolChoice.ofLiveSpecificImageGenParam()`. */
        fun toolChoiceLiveSpecificImageGenParam() =
            toolChoice(ToolChoice.ofLiveSpecificImageGenParam())

        /** Alias for calling [toolChoice] with `ToolChoice.ofLiveSpecificComputerParam()`. */
        fun toolChoiceLiveSpecificComputerParam() =
            toolChoice(ToolChoice.ofLiveSpecificComputerParam())

        /**
         * Alias for calling [toolChoice] with `ToolChoice.ofLiveSpecificCodeInterpreterParam()`.
         */
        fun toolChoiceLiveSpecificCodeInterpreterParam() =
            toolChoice(ToolChoice.ofLiveSpecificCodeInterpreterParam())

        /**
         * Alias for calling [toolChoice] with
         * `ToolChoice.ofLiveSpecificProgrammaticToolCallingParam()`.
         */
        fun toolChoiceLiveSpecificProgrammaticToolCallingParam() =
            toolChoice(ToolChoice.ofLiveSpecificProgrammaticToolCallingParam())

        /** Alias for calling [toolChoice] with `ToolChoice.ofSpecificShell()`. */
        fun toolChoiceSpecificShell() = toolChoice(ToolChoice.ofSpecificShell())

        /**
         * Alias for calling [toolChoice] with
         * `ToolChoice.ofLiveSpecificCustomToolParam(liveSpecificCustomToolParam)`.
         */
        fun toolChoice(liveSpecificCustomToolParam: ToolChoice.LiveSpecificCustomToolParam) =
            toolChoice(ToolChoice.ofLiveSpecificCustomToolParam(liveSpecificCustomToolParam))

        /** Alias for calling [toolChoice] with `ToolChoice.ofSpecificApplyPatch()`. */
        fun toolChoiceSpecificApplyPatch() = toolChoice(ToolChoice.ofSpecificApplyPatch())

        /**
         * Alias for calling [toolChoice] with
         * `ToolChoice.ofLiveToolChoiceEnum(liveToolChoiceEnum)`.
         */
        fun toolChoice(liveToolChoiceEnum: ToolChoice.LiveToolChoiceEnum) =
            toolChoice(ToolChoice.ofLiveToolChoiceEnum(liveToolChoiceEnum))

        /**
         * Alias for calling [toolChoice] with
         * `ToolChoice.ofLiveAllowedToolsChoiceParam(liveAllowedToolsChoiceParam)`.
         */
        fun toolChoice(liveAllowedToolsChoiceParam: ToolChoice.LiveAllowedToolsChoiceParam) =
            toolChoice(ToolChoice.ofLiveAllowedToolsChoiceParam(liveAllowedToolsChoiceParam))

        /**
         * Tools available to the Responses backend while it handles tasks delegated by the Live
         * model.
         */
        fun tools(tools: List<Tool>) = tools(JsonField.of(tools))

        /**
         * Sets [Builder.tools] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tools] with a well-typed `List<Tool>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun tools(tools: JsonField<List<Tool>>) = apply {
            this.tools = tools.map { it.toMutableList() }
        }

        /**
         * Adds a single [Tool] to [tools].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTool(tool: Tool) = apply {
            tools =
                (tools?.takeUnless { it.isMissing() } ?: JsonField.of(mutableListOf())).also {
                    checkKnown("tools", it).add(tool)
                }
        }

        /** Alias for calling [addTool] with `Tool.ofFunction(function)`. */
        fun addTool(function: FunctionTool) = addTool(Tool.ofFunction(function))

        /**
         * Alias for calling [addTool] with the following:
         * ```java
         * FunctionTool.builder()
         *     .name(name)
         *     .build()
         * ```
         */
        fun addFunctionTool(name: String) = addTool(FunctionTool.builder().name(name).build())

        /** Alias for calling [addTool] with `Tool.ofWebSearch()`. */
        fun addToolWebSearch() = addTool(Tool.ofWebSearch())

        /** Alias for calling [addTool] with `Tool.ofFileSearch()`. */
        fun addToolFileSearch() = addTool(Tool.ofFileSearch())

        /** Alias for calling [addTool] with `Tool.ofCodeInterpreter()`. */
        fun addToolCodeInterpreter() = addTool(Tool.ofCodeInterpreter())

        /** Alias for calling [addTool] with `Tool.ofShell(shell)`. */
        fun addTool(shell: Tool.Shell) = addTool(Tool.ofShell(shell))

        /** Alias for calling [addTool] with `Tool.ofImageGeneration()`. */
        fun addToolImageGeneration() = addTool(Tool.ofImageGeneration())

        /** Alias for calling [addTool] with `Tool.ofMcp()`. */
        fun addToolMcp() = addTool(Tool.ofMcp())

        /** Alias for calling [addTool] with `Tool.ofCustom()`. */
        fun addToolCustom() = addTool(Tool.ofCustom())

        /** Alias for calling [addTool] with `Tool.ofNamespace()`. */
        fun addToolNamespace() = addTool(Tool.ofNamespace())

        /** Alias for calling [addTool] with `Tool.ofSearch()`. */
        fun addToolSearch() = addTool(Tool.ofSearch())

        /** Alias for calling [addTool] with `Tool.ofProgrammaticToolCalling()`. */
        fun addToolProgrammaticToolCalling() = addTool(Tool.ofProgrammaticToolCalling())

        /** Alias for calling [addTool] with `Tool.ofComputer()`. */
        fun addToolComputer() = addTool(Tool.ofComputer())

        /** Alias for calling [addTool] with `Tool.ofApplyPatch()`. */
        fun addToolApplyPatch() = addTool(Tool.ofApplyPatch())

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
         * Returns an immutable instance of [ResponsesDelegationConfig].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .model()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ResponsesDelegationConfig =
            ResponsesDelegationConfig(
                checkRequired("model", model),
                instructions,
                maxOutputTokens,
                parallelToolCalls,
                reasoning,
                serviceTier,
                text,
                toolChoice,
                (tools ?: JsonMissing.of()).map { it.toImmutable() },
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
    fun validate(): ResponsesDelegationConfig = apply {
        if (validated) {
            return@apply
        }

        modelOrThrow()
        instructions()
        maxOutputTokens()
        parallelToolCalls()
        reasoning().ifPresent { it.validate() }
        serviceTier().ifPresent { it.validate() }
        text().ifPresent { it.validate() }
        toolChoice().ifPresent { it.validate() }
        tools().ifPresent { it.forEach { it.validate() } }
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
        (if (model.asKnown().isPresent) 1 else 0) +
            (if (instructions.asKnown().isPresent) 1 else 0) +
            (if (maxOutputTokens.asKnown().isPresent) 1 else 0) +
            (if (parallelToolCalls.asKnown().isPresent) 1 else 0) +
            (reasoning.asKnown().getOrNull()?.validity() ?: 0) +
            (serviceTier.asKnown().getOrNull()?.validity() ?: 0) +
            (text.asKnown().getOrNull()?.validity() ?: 0) +
            (toolChoice.asKnown().getOrNull()?.validity() ?: 0) +
            (tools.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    /** Reasoning settings passed to each delegated Responses request. */
    class Reasoning
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val effort: JsonField<Effort>,
        private val summary: JsonField<Summary>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("effort") @ExcludeMissing effort: JsonField<Effort> = JsonMissing.of(),
            @JsonProperty("summary") @ExcludeMissing summary: JsonField<Summary> = JsonMissing.of(),
        ) : this(effort, summary, mutableMapOf())

        /**
         * How much reasoning effort the delegated Responses model should use. Supported values
         * depend on the backend model. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun effort(): java.util.Optional<Effort> = effort.getOptional("effort")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun effortOrThrow(): Effort = effort.getRequired("effort")

        /**
         * The reasoning summary to request from the delegated Responses model, when supported.
         * Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun summary(): java.util.Optional<Summary> = summary.getOptional("summary")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun summaryOrThrow(): Summary = summary.getRequired("summary")

        /**
         * Returns the raw JSON value of [effort].
         *
         * Unlike [effort], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("effort") @ExcludeMissing fun _effort(): JsonField<Effort> = effort

        /**
         * Returns the raw JSON value of [summary].
         *
         * Unlike [summary], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("summary") @ExcludeMissing fun _summary(): JsonField<Summary> = summary

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
                "effort" to this.effort,
                "summary" to this.summary,
            )

        @JvmSynthetic
        internal fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        @JsonAnyGetter
        @ExcludeMissing
        private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Reasoning]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Reasoning]. */
        class Builder internal constructor() {

            private var effort: JsonField<Effort> = JsonMissing.of()
            private var summary: JsonField<Summary> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(reasoning: Reasoning) = apply {
                effort = reasoning.effort
                summary = reasoning.summary
                additionalProperties = reasoning.additionalProperties.toMutableMap()
            }

            /**
             * How much reasoning effort the delegated Responses model should use. Supported values
             * depend on the backend model.
             */
            fun effort(effort: Effort?) = effort(JsonField.ofNullable(effort))

            /** Alias for calling [Builder.effort] with `effort.orElse(null)`. */
            fun effort(effort: Optional<Effort>) = effort(effort.getOrNull())

            /**
             * Sets [Builder.effort] to an arbitrary JSON value.
             *
             * You should usually call [Builder.effort] with a well-typed [Effort] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun effort(effort: JsonField<Effort>) = apply { this.effort = effort }

            /**
             * The reasoning summary to request from the delegated Responses model, when supported.
             */
            fun summary(summary: Summary?) = summary(JsonField.ofNullable(summary))

            /** Alias for calling [Builder.summary] with `summary.orElse(null)`. */
            fun summary(summary: Optional<Summary>) = summary(summary.getOrNull())

            /**
             * Sets [Builder.summary] to an arbitrary JSON value.
             *
             * You should usually call [Builder.summary] with a well-typed [Summary] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun summary(summary: JsonField<Summary>) = apply { this.summary = summary }

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
             * Returns an immutable instance of [Reasoning].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Reasoning = Reasoning(effort, summary, additionalProperties.toMutableMap())
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
        fun validate(): Reasoning = apply {
            if (validated) {
                return@apply
            }

            effort().ifPresent { it.validate() }
            summary().ifPresent { it.validate() }
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
            (effort.asKnown().getOrNull()?.validity() ?: 0) +
                (summary.asKnown().getOrNull()?.validity() ?: 0)

        /**
         * How much reasoning effort the delegated Responses model should use. Supported values
         * depend on the backend model.
         */
        class Effort @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val NONE = of("none")

                @JvmField val MINIMAL = of("minimal")

                @JvmField val LOW = of("low")

                @JvmField val MEDIUM = of("medium")

                @JvmField val HIGH = of("high")

                @JvmField val XHIGH = of("xhigh")

                @JvmStatic fun of(value: String) = Effort(JsonField.of(value))
            }

            /** An enum containing [Effort]'s known values. */
            @Deprecated("Use asString() for string values or _value() for raw JSON.")
            enum class Known {
                NONE,
                MINIMAL,
                LOW,
                MEDIUM,
                HIGH,
                XHIGH,
            }

            /**
             * An enum containing [Effort]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Effort] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            @Deprecated("Use asString() for string values or _value() for raw JSON.")
            enum class Value {
                NONE,
                MINIMAL,
                LOW,
                MEDIUM,
                HIGH,
                XHIGH,
                /**
                 * An enum member indicating that [Effort] was instantiated with an unknown value.
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
                    NONE -> Value.NONE
                    MINIMAL -> Value.MINIMAL
                    LOW -> Value.LOW
                    MEDIUM -> Value.MEDIUM
                    HIGH -> Value.HIGH
                    XHIGH -> Value.XHIGH
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
                    NONE -> Known.NONE
                    MINIMAL -> Known.MINIMAL
                    LOW -> Known.LOW
                    MEDIUM -> Known.MEDIUM
                    HIGH -> Known.HIGH
                    XHIGH -> Known.XHIGH
                    else -> throw OpenAIInvalidDataException("Unknown Effort: $value")
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
            fun validate(): Effort = apply {
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

                return other is Effort && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /** The reasoning summary to request from the delegated Responses model, when supported. */
        class Summary @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

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

                @JvmField val CONCISE = of("concise")

                @JvmField val DETAILED = of("detailed")

                @JvmField val AUTO = of("auto")

                @JvmStatic fun of(value: String) = Summary(JsonField.of(value))
            }

            /** An enum containing [Summary]'s known values. */
            @Deprecated("Use asString() for string values or _value() for raw JSON.")
            enum class Known {
                CONCISE,
                DETAILED,
                AUTO,
            }

            /**
             * An enum containing [Summary]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Summary] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            @Deprecated("Use asString() for string values or _value() for raw JSON.")
            enum class Value {
                CONCISE,
                DETAILED,
                AUTO,
                /**
                 * An enum member indicating that [Summary] was instantiated with an unknown value.
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
                    CONCISE -> Value.CONCISE
                    DETAILED -> Value.DETAILED
                    AUTO -> Value.AUTO
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
                    CONCISE -> Known.CONCISE
                    DETAILED -> Known.DETAILED
                    AUTO -> Known.AUTO
                    else -> throw OpenAIInvalidDataException("Unknown Summary: $value")
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
            fun validate(): Summary = apply {
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

                return other is Summary && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Reasoning &&
                effort == other.effort &&
                summary == other.summary &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(effort, summary, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Reasoning{effort=$effort, summary=$summary, additionalProperties=$additionalProperties}"
    }

    /** Service tier for delegated Responses requests. */
    class ServiceTier @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val AUTO = of("auto")

            @JvmField val DEFAULT = of("default")

            @JvmField val FAST_TIER_TEMP_PILOT = of("fast_tier_temp_pilot")

            @JvmField val FLEX = of("flex")

            @JvmField val PRIORITY = of("priority")

            @JvmField val ULTRAFAST = of("ultrafast")

            @JvmStatic fun of(value: String) = ServiceTier(JsonField.of(value))
        }

        /** An enum containing [ServiceTier]'s known values. */
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
        enum class Known {
            AUTO,
            DEFAULT,
            FAST_TIER_TEMP_PILOT,
            FLEX,
            PRIORITY,
            ULTRAFAST,
        }

        /**
         * An enum containing [ServiceTier]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [ServiceTier] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
        enum class Value {
            AUTO,
            DEFAULT,
            FAST_TIER_TEMP_PILOT,
            FLEX,
            PRIORITY,
            ULTRAFAST,
            /**
             * An enum member indicating that [ServiceTier] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
        fun value(): Value =
            when (this) {
                AUTO -> Value.AUTO
                DEFAULT -> Value.DEFAULT
                FAST_TIER_TEMP_PILOT -> Value.FAST_TIER_TEMP_PILOT
                FLEX -> Value.FLEX
                PRIORITY -> Value.PRIORITY
                ULTRAFAST -> Value.ULTRAFAST
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OpenAIInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
        fun known(): Known =
            when (this) {
                AUTO -> Known.AUTO
                DEFAULT -> Known.DEFAULT
                FAST_TIER_TEMP_PILOT -> Known.FAST_TIER_TEMP_PILOT
                FLEX -> Known.FLEX
                PRIORITY -> Known.PRIORITY
                ULTRAFAST -> Known.ULTRAFAST
                else -> throw OpenAIInvalidDataException("Unknown ServiceTier: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws OpenAIInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

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
        fun validate(): ServiceTier = apply {
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

            return other is ServiceTier && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Text generation settings passed to each delegated Responses request. */
    class Text
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val verbosity: JsonField<Verbosity>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("verbosity")
            @ExcludeMissing
            verbosity: JsonField<Verbosity> = JsonMissing.of()
        ) : this(verbosity, mutableMapOf())

        /**
         * The amount of detail in text generated by the Responses backend. This does not configure
         * the Live model’s spoken delivery. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun verbosity(): java.util.Optional<Verbosity> = verbosity.getOptional("verbosity")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun verbosityOrThrow(): Verbosity = verbosity.getRequired("verbosity")

        /**
         * Returns the raw JSON value of [verbosity].
         *
         * Unlike [verbosity], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("verbosity")
        @ExcludeMissing
        fun _verbosity(): JsonField<Verbosity> = verbosity

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
            collectAllProperties(additionalProperties, "verbosity" to this.verbosity)

        @JvmSynthetic
        internal fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        @JsonAnyGetter
        @ExcludeMissing
        private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Text]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Text]. */
        class Builder internal constructor() {

            private var verbosity: JsonField<Verbosity> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(text: Text) = apply {
                verbosity = text.verbosity
                additionalProperties = text.additionalProperties.toMutableMap()
            }

            /**
             * The amount of detail in text generated by the Responses backend. This does not
             * configure the Live model’s spoken delivery.
             */
            fun verbosity(verbosity: Verbosity?) = verbosity(JsonField.ofNullable(verbosity))

            /** Alias for calling [Builder.verbosity] with `verbosity.orElse(null)`. */
            fun verbosity(verbosity: Optional<Verbosity>) = verbosity(verbosity.getOrNull())

            /**
             * Sets [Builder.verbosity] to an arbitrary JSON value.
             *
             * You should usually call [Builder.verbosity] with a well-typed [Verbosity] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun verbosity(verbosity: JsonField<Verbosity>) = apply { this.verbosity = verbosity }

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
             * Returns an immutable instance of [Text].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Text = Text(verbosity, additionalProperties.toMutableMap())
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
        fun validate(): Text = apply {
            if (validated) {
                return@apply
            }

            verbosity().ifPresent { it.validate() }
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
        internal fun validity(): Int = (verbosity.asKnown().getOrNull()?.validity() ?: 0)

        /**
         * The amount of detail in text generated by the Responses backend. This does not configure
         * the Live model’s spoken delivery.
         */
        class Verbosity @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

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

                @JvmField val LOW = of("low")

                @JvmField val MEDIUM = of("medium")

                @JvmField val HIGH = of("high")

                @JvmStatic fun of(value: String) = Verbosity(JsonField.of(value))
            }

            /** An enum containing [Verbosity]'s known values. */
            @Deprecated("Use asString() for string values or _value() for raw JSON.")
            enum class Known {
                LOW,
                MEDIUM,
                HIGH,
            }

            /**
             * An enum containing [Verbosity]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Verbosity] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            @Deprecated("Use asString() for string values or _value() for raw JSON.")
            enum class Value {
                LOW,
                MEDIUM,
                HIGH,
                /**
                 * An enum member indicating that [Verbosity] was instantiated with an unknown
                 * value.
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
                    LOW -> Value.LOW
                    MEDIUM -> Value.MEDIUM
                    HIGH -> Value.HIGH
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
                    LOW -> Known.LOW
                    MEDIUM -> Known.MEDIUM
                    HIGH -> Known.HIGH
                    else -> throw OpenAIInvalidDataException("Unknown Verbosity: $value")
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
            fun validate(): Verbosity = apply {
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

                return other is Verbosity && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Text &&
                verbosity == other.verbosity &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(verbosity, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Text{verbosity=$verbosity, additionalProperties=$additionalProperties}"
    }

    /**
     * Controls which tool the Responses backend uses when handling a task delegated by the Live
     * model.
     */
    @JsonDeserialize(using = ToolChoice.Deserializer::class)
    @JsonSerialize(using = ToolChoice.Serializer::class)
    class ToolChoice
    private constructor(
        private val liveFunctionToolChoiceParam: LiveFunctionToolChoiceParam? = null,
        private val liveMcpToolChoiceParam: LiveMcpToolChoiceParam? = null,
        private val liveSpecificFileSearchParam: JsonValue? = null,
        private val liveSpecificWebSearchParam: JsonValue? = null,
        private val liveSpecificWebSearchPreviewParam: JsonValue? = null,
        private val liveSpecificImageGenParam: JsonValue? = null,
        private val liveSpecificComputerParam: JsonValue? = null,
        private val liveSpecificCodeInterpreterParam: JsonValue? = null,
        private val liveSpecificProgrammaticToolCallingParam: JsonValue? = null,
        private val specificShell: JsonValue? = null,
        private val liveSpecificCustomToolParam: LiveSpecificCustomToolParam? = null,
        private val specificApplyPatch: JsonValue? = null,
        private val liveToolChoiceEnum: LiveToolChoiceEnum? = null,
        private val liveAllowedToolsChoiceParam: LiveAllowedToolsChoiceParam? = null,
        private val _json: JsonValue? = null,
    ) {

        fun liveFunctionToolChoiceParam(): Optional<LiveFunctionToolChoiceParam> =
            Optional.ofNullable(liveFunctionToolChoiceParam)

        fun liveMcpToolChoiceParam(): Optional<LiveMcpToolChoiceParam> =
            Optional.ofNullable(liveMcpToolChoiceParam)

        fun liveSpecificFileSearchParam(): Optional<JsonValue> =
            Optional.ofNullable(liveSpecificFileSearchParam)

        fun liveSpecificWebSearchParam(): Optional<JsonValue> =
            Optional.ofNullable(liveSpecificWebSearchParam)

        fun liveSpecificWebSearchPreviewParam(): Optional<JsonValue> =
            Optional.ofNullable(liveSpecificWebSearchPreviewParam)

        fun liveSpecificImageGenParam(): Optional<JsonValue> =
            Optional.ofNullable(liveSpecificImageGenParam)

        fun liveSpecificComputerParam(): Optional<JsonValue> =
            Optional.ofNullable(liveSpecificComputerParam)

        fun liveSpecificCodeInterpreterParam(): Optional<JsonValue> =
            Optional.ofNullable(liveSpecificCodeInterpreterParam)

        fun liveSpecificProgrammaticToolCallingParam(): Optional<JsonValue> =
            Optional.ofNullable(liveSpecificProgrammaticToolCallingParam)

        /** Forces the model to call the shell tool when a tool call is required. */
        fun specificShell(): Optional<JsonValue> = Optional.ofNullable(specificShell)

        fun liveSpecificCustomToolParam(): Optional<LiveSpecificCustomToolParam> =
            Optional.ofNullable(liveSpecificCustomToolParam)

        /** Forces the model to call the apply_patch tool when executing a tool call. */
        fun specificApplyPatch(): Optional<JsonValue> = Optional.ofNullable(specificApplyPatch)

        fun liveToolChoiceEnum(): Optional<LiveToolChoiceEnum> =
            Optional.ofNullable(liveToolChoiceEnum)

        fun liveAllowedToolsChoiceParam(): Optional<LiveAllowedToolsChoiceParam> =
            Optional.ofNullable(liveAllowedToolsChoiceParam)

        fun isLiveFunctionToolChoiceParam(): Boolean = liveFunctionToolChoiceParam != null

        fun isLiveMcpToolChoiceParam(): Boolean = liveMcpToolChoiceParam != null

        fun isLiveSpecificFileSearchParam(): Boolean = liveSpecificFileSearchParam != null

        fun isLiveSpecificWebSearchParam(): Boolean = liveSpecificWebSearchParam != null

        fun isLiveSpecificWebSearchPreviewParam(): Boolean =
            liveSpecificWebSearchPreviewParam != null

        fun isLiveSpecificImageGenParam(): Boolean = liveSpecificImageGenParam != null

        fun isLiveSpecificComputerParam(): Boolean = liveSpecificComputerParam != null

        fun isLiveSpecificCodeInterpreterParam(): Boolean = liveSpecificCodeInterpreterParam != null

        fun isLiveSpecificProgrammaticToolCallingParam(): Boolean =
            liveSpecificProgrammaticToolCallingParam != null

        fun isSpecificShell(): Boolean = specificShell != null

        fun isLiveSpecificCustomToolParam(): Boolean = liveSpecificCustomToolParam != null

        fun isSpecificApplyPatch(): Boolean = specificApplyPatch != null

        fun isLiveToolChoiceEnum(): Boolean = liveToolChoiceEnum != null

        fun isLiveAllowedToolsChoiceParam(): Boolean = liveAllowedToolsChoiceParam != null

        fun asLiveFunctionToolChoiceParam(): LiveFunctionToolChoiceParam =
            liveFunctionToolChoiceParam.getOrThrow("liveFunctionToolChoiceParam")

        fun asLiveMcpToolChoiceParam(): LiveMcpToolChoiceParam =
            liveMcpToolChoiceParam.getOrThrow("liveMcpToolChoiceParam")

        fun asLiveSpecificFileSearchParam(): JsonValue =
            liveSpecificFileSearchParam.getOrThrow("liveSpecificFileSearchParam")

        fun asLiveSpecificWebSearchParam(): JsonValue =
            liveSpecificWebSearchParam.getOrThrow("liveSpecificWebSearchParam")

        fun asLiveSpecificWebSearchPreviewParam(): JsonValue =
            liveSpecificWebSearchPreviewParam.getOrThrow("liveSpecificWebSearchPreviewParam")

        fun asLiveSpecificImageGenParam(): JsonValue =
            liveSpecificImageGenParam.getOrThrow("liveSpecificImageGenParam")

        fun asLiveSpecificComputerParam(): JsonValue =
            liveSpecificComputerParam.getOrThrow("liveSpecificComputerParam")

        fun asLiveSpecificCodeInterpreterParam(): JsonValue =
            liveSpecificCodeInterpreterParam.getOrThrow("liveSpecificCodeInterpreterParam")

        fun asLiveSpecificProgrammaticToolCallingParam(): JsonValue =
            liveSpecificProgrammaticToolCallingParam.getOrThrow(
                "liveSpecificProgrammaticToolCallingParam"
            )

        /** Forces the model to call the shell tool when a tool call is required. */
        fun asSpecificShell(): JsonValue = specificShell.getOrThrow("specificShell")

        fun asLiveSpecificCustomToolParam(): LiveSpecificCustomToolParam =
            liveSpecificCustomToolParam.getOrThrow("liveSpecificCustomToolParam")

        /** Forces the model to call the apply_patch tool when executing a tool call. */
        fun asSpecificApplyPatch(): JsonValue = specificApplyPatch.getOrThrow("specificApplyPatch")

        fun asLiveToolChoiceEnum(): LiveToolChoiceEnum =
            liveToolChoiceEnum.getOrThrow("liveToolChoiceEnum")

        fun asLiveAllowedToolsChoiceParam(): LiveAllowedToolsChoiceParam =
            liveAllowedToolsChoiceParam.getOrThrow("liveAllowedToolsChoiceParam")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        /** Maps this value using an immutable callback registration snapshot. */
        fun <T> match(handler: Handler<T>): T = handler.apply(this)

        /**
         * SDK-owned dispatch. Omitted callbacks use [Builder.onDefault], or throw a payload-free
         * error. Callback return values (including null) and exceptions are propagated unchanged.
         * Immutable registration does not make callbacks or their captured state thread-safe.
         */
        class Handler<T>
        private constructor(
            private val callbacks: Map<String, (ToolChoice) -> T>,
            private val onDefault: java.util.function.Function<in ToolChoice, out T>?,
        ) {
            fun apply(value: ToolChoice): T {
                val callback =
                    when {
                        value.liveFunctionToolChoiceParam != null ->
                            callbacks["liveFunctionToolChoiceParam"]
                        value.liveMcpToolChoiceParam != null -> callbacks["liveMcpToolChoiceParam"]
                        value.liveSpecificFileSearchParam != null ->
                            callbacks["liveSpecificFileSearchParam"]
                        value.liveSpecificWebSearchParam != null ->
                            callbacks["liveSpecificWebSearchParam"]
                        value.liveSpecificWebSearchPreviewParam != null ->
                            callbacks["liveSpecificWebSearchPreviewParam"]
                        value.liveSpecificImageGenParam != null ->
                            callbacks["liveSpecificImageGenParam"]
                        value.liveSpecificComputerParam != null ->
                            callbacks["liveSpecificComputerParam"]
                        value.liveSpecificCodeInterpreterParam != null ->
                            callbacks["liveSpecificCodeInterpreterParam"]
                        value.liveSpecificProgrammaticToolCallingParam != null ->
                            callbacks["liveSpecificProgrammaticToolCallingParam"]
                        value.specificShell != null -> callbacks["specificShell"]
                        value.liveSpecificCustomToolParam != null ->
                            callbacks["liveSpecificCustomToolParam"]
                        value.specificApplyPatch != null -> callbacks["specificApplyPatch"]
                        value.liveToolChoiceEnum != null -> callbacks["liveToolChoiceEnum"]
                        value.liveAllowedToolsChoiceParam != null ->
                            callbacks["liveAllowedToolsChoiceParam"]
                        else -> null
                    }
                if (callback != null) return callback(value)
                if (onDefault != null) return onDefault.apply(value)
                throw OpenAIInvalidDataException("Unhandled ToolChoice")
            }

            companion object {
                @JvmStatic fun <T> builder(): Builder<T> = Builder()
            }

            /** Repeated setters replace earlier registrations. [build] copies the registrations. */
            class Builder<T> internal constructor() {
                private val callbacks = mutableMapOf<String, (ToolChoice) -> T>()
                private var onDefault: java.util.function.Function<in ToolChoice, out T>? = null

                fun onLiveFunctionToolChoiceParam(
                    callback: java.util.function.Function<in LiveFunctionToolChoiceParam, out T>
                ) = apply {
                    callbacks["liveFunctionToolChoiceParam"] = { value ->
                        callback.apply(value.liveFunctionToolChoiceParam!!)
                    }
                }

                fun onLiveMcpToolChoiceParam(
                    callback: java.util.function.Function<in LiveMcpToolChoiceParam, out T>
                ) = apply {
                    callbacks["liveMcpToolChoiceParam"] = { value ->
                        callback.apply(value.liveMcpToolChoiceParam!!)
                    }
                }

                fun onLiveSpecificFileSearchParam(
                    callback: java.util.function.Function<in JsonValue, out T>
                ) = apply {
                    callbacks["liveSpecificFileSearchParam"] = { value ->
                        callback.apply(value.liveSpecificFileSearchParam!!)
                    }
                }

                fun onLiveSpecificWebSearchParam(
                    callback: java.util.function.Function<in JsonValue, out T>
                ) = apply {
                    callbacks["liveSpecificWebSearchParam"] = { value ->
                        callback.apply(value.liveSpecificWebSearchParam!!)
                    }
                }

                fun onLiveSpecificWebSearchPreviewParam(
                    callback: java.util.function.Function<in JsonValue, out T>
                ) = apply {
                    callbacks["liveSpecificWebSearchPreviewParam"] = { value ->
                        callback.apply(value.liveSpecificWebSearchPreviewParam!!)
                    }
                }

                fun onLiveSpecificImageGenParam(
                    callback: java.util.function.Function<in JsonValue, out T>
                ) = apply {
                    callbacks["liveSpecificImageGenParam"] = { value ->
                        callback.apply(value.liveSpecificImageGenParam!!)
                    }
                }

                fun onLiveSpecificComputerParam(
                    callback: java.util.function.Function<in JsonValue, out T>
                ) = apply {
                    callbacks["liveSpecificComputerParam"] = { value ->
                        callback.apply(value.liveSpecificComputerParam!!)
                    }
                }

                fun onLiveSpecificCodeInterpreterParam(
                    callback: java.util.function.Function<in JsonValue, out T>
                ) = apply {
                    callbacks["liveSpecificCodeInterpreterParam"] = { value ->
                        callback.apply(value.liveSpecificCodeInterpreterParam!!)
                    }
                }

                fun onLiveSpecificProgrammaticToolCallingParam(
                    callback: java.util.function.Function<in JsonValue, out T>
                ) = apply {
                    callbacks["liveSpecificProgrammaticToolCallingParam"] = { value ->
                        callback.apply(value.liveSpecificProgrammaticToolCallingParam!!)
                    }
                }

                fun onSpecificShell(callback: java.util.function.Function<in JsonValue, out T>) =
                    apply {
                        callbacks["specificShell"] = { value ->
                            callback.apply(value.specificShell!!)
                        }
                    }

                fun onLiveSpecificCustomToolParam(
                    callback: java.util.function.Function<in LiveSpecificCustomToolParam, out T>
                ) = apply {
                    callbacks["liveSpecificCustomToolParam"] = { value ->
                        callback.apply(value.liveSpecificCustomToolParam!!)
                    }
                }

                fun onSpecificApplyPatch(
                    callback: java.util.function.Function<in JsonValue, out T>
                ) = apply {
                    callbacks["specificApplyPatch"] = { value ->
                        callback.apply(value.specificApplyPatch!!)
                    }
                }

                fun onLiveToolChoiceEnum(
                    callback: java.util.function.Function<in LiveToolChoiceEnum, out T>
                ) = apply {
                    callbacks["liveToolChoiceEnum"] = { value ->
                        callback.apply(value.liveToolChoiceEnum!!)
                    }
                }

                fun onLiveAllowedToolsChoiceParam(
                    callback: java.util.function.Function<in LiveAllowedToolsChoiceParam, out T>
                ) = apply {
                    callbacks["liveAllowedToolsChoiceParam"] = { value ->
                        callback.apply(value.liveAllowedToolsChoiceParam!!)
                    }
                }

                /**
                 * Receives this union for both unknown and recognized-but-unregistered variants.
                 */
                fun onDefault(callback: java.util.function.Function<in ToolChoice, out T>) = apply {
                    onDefault = callback
                }

                /** Builds a snapshot; registration of every variant is intentionally optional. */
                fun build(): Handler<T> = Handler(callbacks.toMap(), onDefault)
            }
        }

        private fun <T> dispatchCurrent(visitor: CurrentVisitor<T>): T =
            when {
                liveFunctionToolChoiceParam != null ->
                    visitor.visitLiveFunctionToolChoiceParam(liveFunctionToolChoiceParam)
                liveMcpToolChoiceParam != null ->
                    visitor.visitLiveMcpToolChoiceParam(liveMcpToolChoiceParam)
                liveSpecificFileSearchParam != null ->
                    visitor.visitLiveSpecificFileSearchParam(liveSpecificFileSearchParam)
                liveSpecificWebSearchParam != null ->
                    visitor.visitLiveSpecificWebSearchParam(liveSpecificWebSearchParam)
                liveSpecificWebSearchPreviewParam != null ->
                    visitor.visitLiveSpecificWebSearchPreviewParam(
                        liveSpecificWebSearchPreviewParam
                    )
                liveSpecificImageGenParam != null ->
                    visitor.visitLiveSpecificImageGenParam(liveSpecificImageGenParam)
                liveSpecificComputerParam != null ->
                    visitor.visitLiveSpecificComputerParam(liveSpecificComputerParam)
                liveSpecificCodeInterpreterParam != null ->
                    visitor.visitLiveSpecificCodeInterpreterParam(liveSpecificCodeInterpreterParam)
                liveSpecificProgrammaticToolCallingParam != null ->
                    visitor.visitLiveSpecificProgrammaticToolCallingParam(
                        liveSpecificProgrammaticToolCallingParam
                    )
                specificShell != null -> visitor.visitSpecificShell(specificShell)
                liveSpecificCustomToolParam != null ->
                    visitor.visitLiveSpecificCustomToolParam(liveSpecificCustomToolParam)
                specificApplyPatch != null -> visitor.visitSpecificApplyPatch(specificApplyPatch)
                liveToolChoiceEnum != null -> visitor.visitLiveToolChoiceEnum(liveToolChoiceEnum)
                liveAllowedToolsChoiceParam != null ->
                    visitor.visitLiveAllowedToolsChoiceParam(liveAllowedToolsChoiceParam)
                else -> visitor.unknown(_json)
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
        fun validate(): ToolChoice = apply {
            if (validated) {
                return@apply
            }

            dispatchCurrent(
                object : CurrentVisitor<Unit> {
                    override fun visitLiveFunctionToolChoiceParam(
                        liveFunctionToolChoiceParam: LiveFunctionToolChoiceParam
                    ) {
                        liveFunctionToolChoiceParam.validate()
                    }

                    override fun visitLiveMcpToolChoiceParam(
                        liveMcpToolChoiceParam: LiveMcpToolChoiceParam
                    ) {
                        liveMcpToolChoiceParam.validate()
                    }

                    override fun visitLiveSpecificFileSearchParam(
                        liveSpecificFileSearchParam: JsonValue
                    ) {
                        liveSpecificFileSearchParam.let {
                            if (it != JsonValue.from(mapOf("type" to "file_search"))) {
                                throw OpenAIInvalidDataException(
                                    "'liveSpecificFileSearchParam' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitLiveSpecificWebSearchParam(
                        liveSpecificWebSearchParam: JsonValue
                    ) {
                        liveSpecificWebSearchParam.let {
                            if (it != JsonValue.from(mapOf("type" to "web_search"))) {
                                throw OpenAIInvalidDataException(
                                    "'liveSpecificWebSearchParam' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitLiveSpecificWebSearchPreviewParam(
                        liveSpecificWebSearchPreviewParam: JsonValue
                    ) {
                        liveSpecificWebSearchPreviewParam.let {
                            if (it != JsonValue.from(mapOf("type" to "web_search_preview"))) {
                                throw OpenAIInvalidDataException(
                                    "'liveSpecificWebSearchPreviewParam' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitLiveSpecificImageGenParam(
                        liveSpecificImageGenParam: JsonValue
                    ) {
                        liveSpecificImageGenParam.let {
                            if (it != JsonValue.from(mapOf("type" to "image_generation"))) {
                                throw OpenAIInvalidDataException(
                                    "'liveSpecificImageGenParam' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitLiveSpecificComputerParam(
                        liveSpecificComputerParam: JsonValue
                    ) {
                        liveSpecificComputerParam.let {
                            if (it != JsonValue.from(mapOf("type" to "computer"))) {
                                throw OpenAIInvalidDataException(
                                    "'liveSpecificComputerParam' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitLiveSpecificCodeInterpreterParam(
                        liveSpecificCodeInterpreterParam: JsonValue
                    ) {
                        liveSpecificCodeInterpreterParam.let {
                            if (it != JsonValue.from(mapOf("type" to "code_interpreter"))) {
                                throw OpenAIInvalidDataException(
                                    "'liveSpecificCodeInterpreterParam' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitLiveSpecificProgrammaticToolCallingParam(
                        liveSpecificProgrammaticToolCallingParam: JsonValue
                    ) {
                        liveSpecificProgrammaticToolCallingParam.let {
                            if (
                                it != JsonValue.from(mapOf("type" to "programmatic_tool_calling"))
                            ) {
                                throw OpenAIInvalidDataException(
                                    "'liveSpecificProgrammaticToolCallingParam' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitSpecificShell(specificShell: JsonValue) {
                        specificShell.let {
                            if (it != JsonValue.from(mapOf("type" to "shell"))) {
                                throw OpenAIInvalidDataException(
                                    "'specificShell' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitLiveSpecificCustomToolParam(
                        liveSpecificCustomToolParam: LiveSpecificCustomToolParam
                    ) {
                        liveSpecificCustomToolParam.validate()
                    }

                    override fun visitSpecificApplyPatch(specificApplyPatch: JsonValue) {
                        specificApplyPatch.let {
                            if (it != JsonValue.from(mapOf("type" to "apply_patch"))) {
                                throw OpenAIInvalidDataException(
                                    "'specificApplyPatch' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitLiveToolChoiceEnum(liveToolChoiceEnum: LiveToolChoiceEnum) {
                        liveToolChoiceEnum.validate()
                    }

                    override fun visitLiveAllowedToolsChoiceParam(
                        liveAllowedToolsChoiceParam: LiveAllowedToolsChoiceParam
                    ) {
                        liveAllowedToolsChoiceParam.validate()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            dispatchCurrent(
                object : CurrentVisitor<Int> {
                    override fun visitLiveFunctionToolChoiceParam(
                        liveFunctionToolChoiceParam: LiveFunctionToolChoiceParam
                    ) = liveFunctionToolChoiceParam.validity()

                    override fun visitLiveMcpToolChoiceParam(
                        liveMcpToolChoiceParam: LiveMcpToolChoiceParam
                    ) = liveMcpToolChoiceParam.validity()

                    override fun visitLiveSpecificFileSearchParam(
                        liveSpecificFileSearchParam: JsonValue
                    ) =
                        liveSpecificFileSearchParam.let {
                            if (it == JsonValue.from(mapOf("type" to "file_search"))) 1 else 0
                        }

                    override fun visitLiveSpecificWebSearchParam(
                        liveSpecificWebSearchParam: JsonValue
                    ) =
                        liveSpecificWebSearchParam.let {
                            if (it == JsonValue.from(mapOf("type" to "web_search"))) 1 else 0
                        }

                    override fun visitLiveSpecificWebSearchPreviewParam(
                        liveSpecificWebSearchPreviewParam: JsonValue
                    ) =
                        liveSpecificWebSearchPreviewParam.let {
                            if (it == JsonValue.from(mapOf("type" to "web_search_preview"))) 1
                            else 0
                        }

                    override fun visitLiveSpecificImageGenParam(
                        liveSpecificImageGenParam: JsonValue
                    ) =
                        liveSpecificImageGenParam.let {
                            if (it == JsonValue.from(mapOf("type" to "image_generation"))) 1 else 0
                        }

                    override fun visitLiveSpecificComputerParam(
                        liveSpecificComputerParam: JsonValue
                    ) =
                        liveSpecificComputerParam.let {
                            if (it == JsonValue.from(mapOf("type" to "computer"))) 1 else 0
                        }

                    override fun visitLiveSpecificCodeInterpreterParam(
                        liveSpecificCodeInterpreterParam: JsonValue
                    ) =
                        liveSpecificCodeInterpreterParam.let {
                            if (it == JsonValue.from(mapOf("type" to "code_interpreter"))) 1 else 0
                        }

                    override fun visitLiveSpecificProgrammaticToolCallingParam(
                        liveSpecificProgrammaticToolCallingParam: JsonValue
                    ) =
                        liveSpecificProgrammaticToolCallingParam.let {
                            if (it == JsonValue.from(mapOf("type" to "programmatic_tool_calling")))
                                1
                            else 0
                        }

                    override fun visitSpecificShell(specificShell: JsonValue) =
                        specificShell.let {
                            if (it == JsonValue.from(mapOf("type" to "shell"))) 1 else 0
                        }

                    override fun visitLiveSpecificCustomToolParam(
                        liveSpecificCustomToolParam: LiveSpecificCustomToolParam
                    ) = liveSpecificCustomToolParam.validity()

                    override fun visitSpecificApplyPatch(specificApplyPatch: JsonValue) =
                        specificApplyPatch.let {
                            if (it == JsonValue.from(mapOf("type" to "apply_patch"))) 1 else 0
                        }

                    override fun visitLiveToolChoiceEnum(liveToolChoiceEnum: LiveToolChoiceEnum) =
                        liveToolChoiceEnum.validity()

                    override fun visitLiveAllowedToolsChoiceParam(
                        liveAllowedToolsChoiceParam: LiveAllowedToolsChoiceParam
                    ) = liveAllowedToolsChoiceParam.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ToolChoice &&
                liveFunctionToolChoiceParam == other.liveFunctionToolChoiceParam &&
                liveMcpToolChoiceParam == other.liveMcpToolChoiceParam &&
                liveSpecificFileSearchParam == other.liveSpecificFileSearchParam &&
                liveSpecificWebSearchParam == other.liveSpecificWebSearchParam &&
                liveSpecificWebSearchPreviewParam == other.liveSpecificWebSearchPreviewParam &&
                liveSpecificImageGenParam == other.liveSpecificImageGenParam &&
                liveSpecificComputerParam == other.liveSpecificComputerParam &&
                liveSpecificCodeInterpreterParam == other.liveSpecificCodeInterpreterParam &&
                liveSpecificProgrammaticToolCallingParam ==
                    other.liveSpecificProgrammaticToolCallingParam &&
                specificShell == other.specificShell &&
                liveSpecificCustomToolParam == other.liveSpecificCustomToolParam &&
                specificApplyPatch == other.specificApplyPatch &&
                liveToolChoiceEnum == other.liveToolChoiceEnum &&
                liveAllowedToolsChoiceParam == other.liveAllowedToolsChoiceParam &&
                (liveFunctionToolChoiceParam != null ||
                    liveMcpToolChoiceParam != null ||
                    liveSpecificFileSearchParam != null ||
                    liveSpecificWebSearchParam != null ||
                    liveSpecificWebSearchPreviewParam != null ||
                    liveSpecificImageGenParam != null ||
                    liveSpecificComputerParam != null ||
                    liveSpecificCodeInterpreterParam != null ||
                    liveSpecificProgrammaticToolCallingParam != null ||
                    specificShell != null ||
                    liveSpecificCustomToolParam != null ||
                    specificApplyPatch != null ||
                    liveToolChoiceEnum != null ||
                    liveAllowedToolsChoiceParam != null ||
                    _json == other._json)
        }

        override fun hashCode(): Int =
            if (
                liveFunctionToolChoiceParam == null &&
                    liveMcpToolChoiceParam == null &&
                    liveSpecificFileSearchParam == null &&
                    liveSpecificWebSearchParam == null &&
                    liveSpecificWebSearchPreviewParam == null &&
                    liveSpecificImageGenParam == null &&
                    liveSpecificComputerParam == null &&
                    liveSpecificCodeInterpreterParam == null &&
                    liveSpecificProgrammaticToolCallingParam == null &&
                    specificShell == null &&
                    liveSpecificCustomToolParam == null &&
                    specificApplyPatch == null &&
                    liveToolChoiceEnum == null &&
                    liveAllowedToolsChoiceParam == null
            )
                Objects.hash(_json)
            else
                Objects.hash(
                    liveFunctionToolChoiceParam,
                    liveMcpToolChoiceParam,
                    liveSpecificFileSearchParam,
                    liveSpecificWebSearchParam,
                    liveSpecificWebSearchPreviewParam,
                    liveSpecificImageGenParam,
                    liveSpecificComputerParam,
                    liveSpecificCodeInterpreterParam,
                    liveSpecificProgrammaticToolCallingParam,
                    specificShell,
                    liveSpecificCustomToolParam,
                    specificApplyPatch,
                    liveToolChoiceEnum,
                    liveAllowedToolsChoiceParam,
                )

        override fun toString(): String =
            when {
                liveFunctionToolChoiceParam != null ->
                    "ToolChoice{liveFunctionToolChoiceParam=$liveFunctionToolChoiceParam}"
                liveMcpToolChoiceParam != null ->
                    "ToolChoice{liveMcpToolChoiceParam=$liveMcpToolChoiceParam}"
                liveSpecificFileSearchParam != null ->
                    "ToolChoice{liveSpecificFileSearchParam=$liveSpecificFileSearchParam}"
                liveSpecificWebSearchParam != null ->
                    "ToolChoice{liveSpecificWebSearchParam=$liveSpecificWebSearchParam}"
                liveSpecificWebSearchPreviewParam != null ->
                    "ToolChoice{liveSpecificWebSearchPreviewParam=$liveSpecificWebSearchPreviewParam}"
                liveSpecificImageGenParam != null ->
                    "ToolChoice{liveSpecificImageGenParam=$liveSpecificImageGenParam}"
                liveSpecificComputerParam != null ->
                    "ToolChoice{liveSpecificComputerParam=$liveSpecificComputerParam}"
                liveSpecificCodeInterpreterParam != null ->
                    "ToolChoice{liveSpecificCodeInterpreterParam=$liveSpecificCodeInterpreterParam}"
                liveSpecificProgrammaticToolCallingParam != null ->
                    "ToolChoice{liveSpecificProgrammaticToolCallingParam=$liveSpecificProgrammaticToolCallingParam}"
                specificShell != null -> "ToolChoice{specificShell=$specificShell}"
                liveSpecificCustomToolParam != null ->
                    "ToolChoice{liveSpecificCustomToolParam=$liveSpecificCustomToolParam}"
                specificApplyPatch != null -> "ToolChoice{specificApplyPatch=$specificApplyPatch}"
                liveToolChoiceEnum != null -> "ToolChoice{liveToolChoiceEnum=$liveToolChoiceEnum}"
                liveAllowedToolsChoiceParam != null ->
                    "ToolChoice{liveAllowedToolsChoiceParam=$liveAllowedToolsChoiceParam}"
                _json != null -> "ToolChoice{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid ToolChoice")
            }

        companion object {

            @JvmStatic
            fun ofLiveFunctionToolChoiceParam(
                liveFunctionToolChoiceParam: LiveFunctionToolChoiceParam
            ) = ToolChoice(liveFunctionToolChoiceParam = liveFunctionToolChoiceParam)

            @JvmStatic
            fun ofLiveMcpToolChoiceParam(liveMcpToolChoiceParam: LiveMcpToolChoiceParam) =
                ToolChoice(liveMcpToolChoiceParam = liveMcpToolChoiceParam)

            @JvmStatic
            fun ofLiveSpecificFileSearchParam() =
                ToolChoice(
                    liveSpecificFileSearchParam = JsonValue.from(mapOf("type" to "file_search"))
                )

            @JvmStatic
            fun ofLiveSpecificWebSearchParam() =
                ToolChoice(
                    liveSpecificWebSearchParam = JsonValue.from(mapOf("type" to "web_search"))
                )

            @JvmStatic
            fun ofLiveSpecificWebSearchPreviewParam() =
                ToolChoice(
                    liveSpecificWebSearchPreviewParam =
                        JsonValue.from(mapOf("type" to "web_search_preview"))
                )

            @JvmStatic
            fun ofLiveSpecificImageGenParam() =
                ToolChoice(
                    liveSpecificImageGenParam = JsonValue.from(mapOf("type" to "image_generation"))
                )

            @JvmStatic
            fun ofLiveSpecificComputerParam() =
                ToolChoice(liveSpecificComputerParam = JsonValue.from(mapOf("type" to "computer")))

            @JvmStatic
            fun ofLiveSpecificCodeInterpreterParam() =
                ToolChoice(
                    liveSpecificCodeInterpreterParam =
                        JsonValue.from(mapOf("type" to "code_interpreter"))
                )

            @JvmStatic
            fun ofLiveSpecificProgrammaticToolCallingParam() =
                ToolChoice(
                    liveSpecificProgrammaticToolCallingParam =
                        JsonValue.from(mapOf("type" to "programmatic_tool_calling"))
                )

            /** Forces the model to call the shell tool when a tool call is required. */
            @JvmStatic
            fun ofSpecificShell() =
                ToolChoice(specificShell = JsonValue.from(mapOf("type" to "shell")))

            @JvmStatic
            fun ofLiveSpecificCustomToolParam(
                liveSpecificCustomToolParam: LiveSpecificCustomToolParam
            ) = ToolChoice(liveSpecificCustomToolParam = liveSpecificCustomToolParam)

            /** Forces the model to call the apply_patch tool when executing a tool call. */
            @JvmStatic
            fun ofSpecificApplyPatch() =
                ToolChoice(specificApplyPatch = JsonValue.from(mapOf("type" to "apply_patch")))

            @JvmStatic
            fun ofLiveToolChoiceEnum(liveToolChoiceEnum: LiveToolChoiceEnum) =
                ToolChoice(liveToolChoiceEnum = liveToolChoiceEnum)

            @JvmStatic
            fun ofLiveAllowedToolsChoiceParam(
                liveAllowedToolsChoiceParam: LiveAllowedToolsChoiceParam
            ) = ToolChoice(liveAllowedToolsChoiceParam = liveAllowedToolsChoiceParam)
        }

        /**
         * An interface that defines how to map each variant of [ToolChoice] to a value of type [T].
         */
        private interface CurrentVisitor<out T> {

            fun visitLiveFunctionToolChoiceParam(
                liveFunctionToolChoiceParam: LiveFunctionToolChoiceParam
            ): T

            fun visitLiveMcpToolChoiceParam(liveMcpToolChoiceParam: LiveMcpToolChoiceParam): T

            fun visitLiveSpecificFileSearchParam(liveSpecificFileSearchParam: JsonValue): T

            fun visitLiveSpecificWebSearchParam(liveSpecificWebSearchParam: JsonValue): T

            fun visitLiveSpecificWebSearchPreviewParam(
                liveSpecificWebSearchPreviewParam: JsonValue
            ): T

            fun visitLiveSpecificImageGenParam(liveSpecificImageGenParam: JsonValue): T

            fun visitLiveSpecificComputerParam(liveSpecificComputerParam: JsonValue): T

            fun visitLiveSpecificCodeInterpreterParam(
                liveSpecificCodeInterpreterParam: JsonValue
            ): T

            fun visitLiveSpecificProgrammaticToolCallingParam(
                liveSpecificProgrammaticToolCallingParam: JsonValue
            ): T

            /** Forces the model to call the shell tool when a tool call is required. */
            fun visitSpecificShell(specificShell: JsonValue): T

            fun visitLiveSpecificCustomToolParam(
                liveSpecificCustomToolParam: LiveSpecificCustomToolParam
            ): T

            /** Forces the model to call the apply_patch tool when executing a tool call. */
            fun visitSpecificApplyPatch(specificApplyPatch: JsonValue): T

            fun visitLiveToolChoiceEnum(liveToolChoiceEnum: LiveToolChoiceEnum): T

            fun visitLiveAllowedToolsChoiceParam(
                liveAllowedToolsChoiceParam: LiveAllowedToolsChoiceParam
            ): T

            /**
             * Maps an unknown variant of [ToolChoice] to a value of type [T].
             *
             * An instance of [ToolChoice] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown ToolChoice")
            }
        }

        internal class Deserializer : BaseDeserializer<ToolChoice>(ToolChoice::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): ToolChoice {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "function" -> {
                        return tryDeserialize(node, jacksonTypeRef<LiveFunctionToolChoiceParam>())
                            ?.let { ToolChoice(liveFunctionToolChoiceParam = it, _json = json) }
                            ?: ToolChoice(_json = json)
                    }
                    "mcp" -> {
                        return tryDeserialize(node, jacksonTypeRef<LiveMcpToolChoiceParam>())?.let {
                            ToolChoice(liveMcpToolChoiceParam = it, _json = json)
                        } ?: ToolChoice(_json = json)
                    }
                    "file_search" -> {
                        return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                            ?.let { ToolChoice(liveSpecificFileSearchParam = it, _json = json) }
                            ?.takeIf { it.isValid() } ?: ToolChoice(_json = json)
                    }
                    "web_search" -> {
                        return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                            ?.let { ToolChoice(liveSpecificWebSearchParam = it, _json = json) }
                            ?.takeIf { it.isValid() } ?: ToolChoice(_json = json)
                    }
                    "web_search_preview" -> {
                        return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                            ?.let {
                                ToolChoice(liveSpecificWebSearchPreviewParam = it, _json = json)
                            }
                            ?.takeIf { it.isValid() } ?: ToolChoice(_json = json)
                    }
                    "image_generation" -> {
                        return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                            ?.let { ToolChoice(liveSpecificImageGenParam = it, _json = json) }
                            ?.takeIf { it.isValid() } ?: ToolChoice(_json = json)
                    }
                    "computer" -> {
                        return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                            ?.let { ToolChoice(liveSpecificComputerParam = it, _json = json) }
                            ?.takeIf { it.isValid() } ?: ToolChoice(_json = json)
                    }
                    "code_interpreter" -> {
                        return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                            ?.let {
                                ToolChoice(liveSpecificCodeInterpreterParam = it, _json = json)
                            }
                            ?.takeIf { it.isValid() } ?: ToolChoice(_json = json)
                    }
                    "programmatic_tool_calling" -> {
                        return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                            ?.let {
                                ToolChoice(
                                    liveSpecificProgrammaticToolCallingParam = it,
                                    _json = json,
                                )
                            }
                            ?.takeIf { it.isValid() } ?: ToolChoice(_json = json)
                    }
                    "shell" -> {
                        return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                            ?.let { ToolChoice(specificShell = it, _json = json) }
                            ?.takeIf { it.isValid() } ?: ToolChoice(_json = json)
                    }
                    "custom" -> {
                        return tryDeserialize(node, jacksonTypeRef<LiveSpecificCustomToolParam>())
                            ?.let { ToolChoice(liveSpecificCustomToolParam = it, _json = json) }
                            ?: ToolChoice(_json = json)
                    }
                    "apply_patch" -> {
                        return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                            ?.let { ToolChoice(specificApplyPatch = it, _json = json) }
                            ?.takeIf { it.isValid() } ?: ToolChoice(_json = json)
                    }
                    "allowed_tools" -> {
                        return tryDeserialize(node, jacksonTypeRef<LiveAllowedToolsChoiceParam>())
                            ?.let { ToolChoice(liveAllowedToolsChoiceParam = it, _json = json) }
                            ?: ToolChoice(_json = json)
                    }
                }

                return tryDeserialize(node, jacksonTypeRef<LiveToolChoiceEnum>())?.let {
                    ToolChoice(liveToolChoiceEnum = it, _json = json)
                } ?: ToolChoice(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<ToolChoice>(ToolChoice::class) {

            override fun serialize(
                value: ToolChoice,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.liveFunctionToolChoiceParam != null ->
                        generator.writeObject(value.liveFunctionToolChoiceParam)
                    value.liveMcpToolChoiceParam != null ->
                        generator.writeObject(value.liveMcpToolChoiceParam)
                    value.liveSpecificFileSearchParam != null ->
                        generator.writeObject(value.liveSpecificFileSearchParam)
                    value.liveSpecificWebSearchParam != null ->
                        generator.writeObject(value.liveSpecificWebSearchParam)
                    value.liveSpecificWebSearchPreviewParam != null ->
                        generator.writeObject(value.liveSpecificWebSearchPreviewParam)
                    value.liveSpecificImageGenParam != null ->
                        generator.writeObject(value.liveSpecificImageGenParam)
                    value.liveSpecificComputerParam != null ->
                        generator.writeObject(value.liveSpecificComputerParam)
                    value.liveSpecificCodeInterpreterParam != null ->
                        generator.writeObject(value.liveSpecificCodeInterpreterParam)
                    value.liveSpecificProgrammaticToolCallingParam != null ->
                        generator.writeObject(value.liveSpecificProgrammaticToolCallingParam)
                    value.specificShell != null -> generator.writeObject(value.specificShell)
                    value.liveSpecificCustomToolParam != null ->
                        generator.writeObject(value.liveSpecificCustomToolParam)
                    value.specificApplyPatch != null ->
                        generator.writeObject(value.specificApplyPatch)
                    value.liveToolChoiceEnum != null ->
                        generator.writeObject(value.liveToolChoiceEnum)
                    value.liveAllowedToolsChoiceParam != null ->
                        generator.writeObject(value.liveAllowedToolsChoiceParam)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid ToolChoice")
                }
            }
        }

        class LiveToolChoiceEnum
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

                @JvmField val AUTO = of("auto")

                @JvmField val NONE = of("none")

                @JvmField val REQUIRED = of("required")

                @JvmStatic fun of(value: String) = LiveToolChoiceEnum(JsonField.of(value))
            }

            /** An enum containing [LiveToolChoiceEnum]'s known values. */
            @Deprecated("Use asString() for string values or _value() for raw JSON.")
            enum class Known {
                AUTO,
                NONE,
                REQUIRED,
            }

            /**
             * An enum containing [LiveToolChoiceEnum]'s known values, as well as an [_UNKNOWN]
             * member.
             *
             * An instance of [LiveToolChoiceEnum] can contain an unknown value in a couple of
             * cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            @Deprecated("Use asString() for string values or _value() for raw JSON.")
            enum class Value {
                AUTO,
                NONE,
                REQUIRED,
                /**
                 * An enum member indicating that [LiveToolChoiceEnum] was instantiated with an
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
                    AUTO -> Value.AUTO
                    NONE -> Value.NONE
                    REQUIRED -> Value.REQUIRED
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
                    AUTO -> Known.AUTO
                    NONE -> Known.NONE
                    REQUIRED -> Known.REQUIRED
                    else -> throw OpenAIInvalidDataException("Unknown LiveToolChoiceEnum: $value")
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
            fun validate(): LiveToolChoiceEnum = apply {
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

                return other is LiveToolChoiceEnum && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class LiveFunctionToolChoiceParam
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val name: JsonField<String>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(name, type, mutableMapOf())

            /**
             * The schema requires this property. Returns empty if the JSON property is missing or
             * null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun name(): java.util.Optional<String> = name.getOptional("name")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun nameOrThrow(): String = name.getRequired("name")

            /**
             * The schema requires this property. Returns empty if the JSON property is missing or
             * null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun type(): java.util.Optional<JsonValue> {
                val raw = type
                return when {
                    raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                    !(raw == JsonValue.from("function")) ->
                        throw OpenAIInvalidDataException("`type` is invalid")
                    else -> java.util.Optional.of(raw)
                }
            }

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

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

            /**
             * Returns an immutable snapshot of all present JSON properties, including declared and
             * additional properties.
             *
             * Keys use their JSON names. Declared properties take precedence over additional
             * properties with the same name. Missing properties are omitted, while explicit nulls
             * and unrecognized values are preserved.
             */
            fun _allProperties(): Map<String, JsonValue> =
                collectAllProperties(additionalProperties, "name" to this.name, "type" to this.type)

            @JvmSynthetic
            internal fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            @JsonAnyGetter
            @ExcludeMissing
            private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of
                 * [LiveFunctionToolChoiceParam].
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [LiveFunctionToolChoiceParam]. */
            class Builder internal constructor() {

                private var name: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("function")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(liveFunctionToolChoiceParam: LiveFunctionToolChoiceParam) =
                    apply {
                        name = liveFunctionToolChoiceParam.name
                        type = liveFunctionToolChoiceParam.type
                        additionalProperties =
                            liveFunctionToolChoiceParam.additionalProperties.toMutableMap()
                    }

                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("function")
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

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [LiveFunctionToolChoiceParam].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): LiveFunctionToolChoiceParam =
                    LiveFunctionToolChoiceParam(
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
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): LiveFunctionToolChoiceParam = apply {
                if (validated) {
                    return@apply
                }

                nameOrThrow()
                typeOrThrow()
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
                (if (name.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("function")) 1 else 0 }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is LiveFunctionToolChoiceParam &&
                    name == other.name &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(name, type, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "LiveFunctionToolChoiceParam{name=$name, type=$type, additionalProperties=$additionalProperties}"
        }

        class LiveMcpToolChoiceParam
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val name: JsonField<String>,
            private val serverLabel: JsonField<String>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("server_label")
                @ExcludeMissing
                serverLabel: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(name, serverLabel, type, mutableMapOf())

            /**
             * The schema requires this property. Returns empty if the JSON property is missing or
             * null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun name(): java.util.Optional<String> = name.getOptional("name")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun nameOrThrow(): String = name.getRequired("name")

            /**
             * The schema requires this property. Returns empty if the JSON property is missing or
             * null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun serverLabel(): java.util.Optional<String> = serverLabel.getOptional("server_label")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun serverLabelOrThrow(): String = serverLabel.getRequired("server_label")

            /**
             * The schema requires this property. Returns empty if the JSON property is missing or
             * null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun type(): java.util.Optional<JsonValue> {
                val raw = type
                return when {
                    raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                    !(raw == JsonValue.from("mcp")) ->
                        throw OpenAIInvalidDataException("`type` is invalid")
                    else -> java.util.Optional.of(raw)
                }
            }

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [serverLabel].
             *
             * Unlike [serverLabel], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("server_label")
            @ExcludeMissing
            fun _serverLabel(): JsonField<String> = serverLabel

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            /**
             * Returns an immutable snapshot of all present JSON properties, including declared and
             * additional properties.
             *
             * Keys use their JSON names. Declared properties take precedence over additional
             * properties with the same name. Missing properties are omitted, while explicit nulls
             * and unrecognized values are preserved.
             */
            fun _allProperties(): Map<String, JsonValue> =
                collectAllProperties(
                    additionalProperties,
                    "name" to this.name,
                    "server_label" to this.serverLabel,
                    "type" to this.type,
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
                 * Returns a mutable builder for constructing an instance of
                 * [LiveMcpToolChoiceParam].
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * .serverLabel()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [LiveMcpToolChoiceParam]. */
            class Builder internal constructor() {

                private var name: JsonField<String>? = null
                private var serverLabel: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("mcp")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(liveMcpToolChoiceParam: LiveMcpToolChoiceParam) = apply {
                    name = liveMcpToolChoiceParam.name
                    serverLabel = liveMcpToolChoiceParam.serverLabel
                    type = liveMcpToolChoiceParam.type
                    additionalProperties =
                        liveMcpToolChoiceParam.additionalProperties.toMutableMap()
                }

                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun serverLabel(serverLabel: String) = serverLabel(JsonField.of(serverLabel))

                /**
                 * Sets [Builder.serverLabel] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.serverLabel] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun serverLabel(serverLabel: JsonField<String>) = apply {
                    this.serverLabel = serverLabel
                }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("mcp")
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

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [LiveMcpToolChoiceParam].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * .serverLabel()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): LiveMcpToolChoiceParam =
                    LiveMcpToolChoiceParam(
                        checkRequired("name", name),
                        checkRequired("serverLabel", serverLabel),
                        type,
                        additionalProperties.toMutableMap(),
                    )
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
            fun validate(): LiveMcpToolChoiceParam = apply {
                if (validated) {
                    return@apply
                }

                nameOrThrow()
                serverLabelOrThrow()
                typeOrThrow()
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
                (if (name.asKnown().isPresent) 1 else 0) +
                    (if (serverLabel.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("mcp")) 1 else 0 }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is LiveMcpToolChoiceParam &&
                    name == other.name &&
                    serverLabel == other.serverLabel &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(name, serverLabel, type, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "LiveMcpToolChoiceParam{name=$name, serverLabel=$serverLabel, type=$type, additionalProperties=$additionalProperties}"
        }

        class LiveSpecificCustomToolParam
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val name: JsonField<String>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(name, type, mutableMapOf())

            /**
             * The name of the custom tool to call. The schema requires this property. Returns empty
             * if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun name(): java.util.Optional<String> = name.getOptional("name")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun nameOrThrow(): String = name.getRequired("name")

            /**
             * The tool to call. Always `custom`. The schema requires this property. Returns empty
             * if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun type(): java.util.Optional<JsonValue> {
                val raw = type
                return when {
                    raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                    !(raw == JsonValue.from("custom")) ->
                        throw OpenAIInvalidDataException("`type` is invalid")
                    else -> java.util.Optional.of(raw)
                }
            }

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

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

            /**
             * Returns an immutable snapshot of all present JSON properties, including declared and
             * additional properties.
             *
             * Keys use their JSON names. Declared properties take precedence over additional
             * properties with the same name. Missing properties are omitted, while explicit nulls
             * and unrecognized values are preserved.
             */
            fun _allProperties(): Map<String, JsonValue> =
                collectAllProperties(additionalProperties, "name" to this.name, "type" to this.type)

            @JvmSynthetic
            internal fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            @JsonAnyGetter
            @ExcludeMissing
            private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of
                 * [LiveSpecificCustomToolParam].
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [LiveSpecificCustomToolParam]. */
            class Builder internal constructor() {

                private var name: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("custom")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(liveSpecificCustomToolParam: LiveSpecificCustomToolParam) =
                    apply {
                        name = liveSpecificCustomToolParam.name
                        type = liveSpecificCustomToolParam.type
                        additionalProperties =
                            liveSpecificCustomToolParam.additionalProperties.toMutableMap()
                    }

                /** The name of the custom tool to call. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("custom")
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

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [LiveSpecificCustomToolParam].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): LiveSpecificCustomToolParam =
                    LiveSpecificCustomToolParam(
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
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): LiveSpecificCustomToolParam = apply {
                if (validated) {
                    return@apply
                }

                nameOrThrow()
                typeOrThrow()
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
                (if (name.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("custom")) 1 else 0 }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is LiveSpecificCustomToolParam &&
                    name == other.name &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(name, type, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "LiveSpecificCustomToolParam{name=$name, type=$type, additionalProperties=$additionalProperties}"
        }

        class LiveAllowedToolsChoiceParam
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val tools: JsonField<List<Tool>>,
            private val type: JsonValue,
            private val mode: JsonField<Mode>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("tools")
                @ExcludeMissing
                tools: JsonField<List<Tool>> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("mode") @ExcludeMissing mode: JsonField<Mode> = JsonMissing.of(),
            ) : this(tools, type, mode, mutableMapOf())

            /**
             * The tools that the delegated Responses model may call. The schema requires this
             * property. Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun tools(): java.util.Optional<List<Tool>> = tools.getOptional("tools")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun toolsOrThrow(): List<Tool> = tools.getRequired("tools")

            /**
             * The tool choice type. Always `allowed_tools`. The schema requires this property.
             * Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun type(): java.util.Optional<JsonValue> {
                val raw = type
                return when {
                    raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                    !(raw == JsonValue.from("allowed_tools")) ->
                        throw OpenAIInvalidDataException("`type` is invalid")
                    else -> java.util.Optional.of(raw)
                }
            }

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

            /**
             * How to select a tool from the allowed set. Returns empty if the JSON property is
             * missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun mode(): java.util.Optional<Mode> = mode.getOptional("mode")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun modeOrThrow(): Mode = mode.getRequired("mode")

            /**
             * Returns the raw JSON value of [tools].
             *
             * Unlike [tools], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("tools") @ExcludeMissing fun _tools(): JsonField<List<Tool>> = tools

            /**
             * Returns the raw JSON value of [mode].
             *
             * Unlike [mode], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("mode") @ExcludeMissing fun _mode(): JsonField<Mode> = mode

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            /**
             * Returns an immutable snapshot of all present JSON properties, including declared and
             * additional properties.
             *
             * Keys use their JSON names. Declared properties take precedence over additional
             * properties with the same name. Missing properties are omitted, while explicit nulls
             * and unrecognized values are preserved.
             */
            fun _allProperties(): Map<String, JsonValue> =
                collectAllProperties(
                    additionalProperties,
                    "tools" to this.tools,
                    "type" to this.type,
                    "mode" to this.mode,
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
                 * Returns a mutable builder for constructing an instance of
                 * [LiveAllowedToolsChoiceParam].
                 *
                 * The following fields are required:
                 * ```java
                 * .tools()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [LiveAllowedToolsChoiceParam]. */
            class Builder internal constructor() {

                private var tools: JsonField<MutableList<Tool>>? = null
                private var type: JsonValue = JsonValue.from("allowed_tools")
                private var mode: JsonField<Mode> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(liveAllowedToolsChoiceParam: LiveAllowedToolsChoiceParam) =
                    apply {
                        tools = liveAllowedToolsChoiceParam.tools.map { it.toMutableList() }
                        type = liveAllowedToolsChoiceParam.type
                        mode = liveAllowedToolsChoiceParam.mode
                        additionalProperties =
                            liveAllowedToolsChoiceParam.additionalProperties.toMutableMap()
                    }

                /** The tools that the delegated Responses model may call. */
                fun tools(tools: List<Tool>) = tools(JsonField.of(tools))

                /**
                 * Sets [Builder.tools] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.tools] with a well-typed `List<Tool>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun tools(tools: JsonField<List<Tool>>) = apply {
                    this.tools = tools.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Tool] to [tools].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addTool(tool: Tool) = apply {
                    tools =
                        (tools ?: JsonField.of(mutableListOf())).also {
                            checkKnown("tools", it).add(tool)
                        }
                }

                /** Alias for calling [addTool] with `Tool.ofFunction(function)`. */
                fun addTool(function: Tool.Function) = addTool(Tool.ofFunction(function))

                /**
                 * Alias for calling [addTool] with the following:
                 * ```java
                 * Tool.Function.builder()
                 *     .name(name)
                 *     .build()
                 * ```
                 */
                fun addFunctionTool(name: String) =
                    addTool(Tool.Function.builder().name(name).build())

                /** Alias for calling [addTool] with `Tool.ofMcp(mcp)`. */
                fun addTool(mcp: Tool.Mcp) = addTool(Tool.ofMcp(mcp))

                /** Alias for calling [addTool] with `Tool.ofFileSearch()`. */
                fun addToolFileSearch() = addTool(Tool.ofFileSearch())

                /** Alias for calling [addTool] with `Tool.ofWebSearch()`. */
                fun addToolWebSearch() = addTool(Tool.ofWebSearch())

                /** Alias for calling [addTool] with `Tool.ofWebSearchPreview()`. */
                fun addToolWebSearchPreview() = addTool(Tool.ofWebSearchPreview())

                /** Alias for calling [addTool] with `Tool.ofImageGeneration()`. */
                fun addToolImageGeneration() = addTool(Tool.ofImageGeneration())

                /** Alias for calling [addTool] with `Tool.ofComputer()`. */
                fun addToolComputer() = addTool(Tool.ofComputer())

                /** Alias for calling [addTool] with `Tool.ofCodeInterpreter()`. */
                fun addToolCodeInterpreter() = addTool(Tool.ofCodeInterpreter())

                /** Alias for calling [addTool] with `Tool.ofProgrammaticToolCalling()`. */
                fun addToolProgrammaticToolCalling() = addTool(Tool.ofProgrammaticToolCalling())

                /** Alias for calling [addTool] with `Tool.ofShell()`. */
                fun addToolShell() = addTool(Tool.ofShell())

                /** Alias for calling [addTool] with `Tool.ofCustom(custom)`. */
                fun addTool(custom: Tool.Custom) = addTool(Tool.ofCustom(custom))

                /**
                 * Alias for calling [addTool] with the following:
                 * ```java
                 * Tool.Custom.builder()
                 *     .name(name)
                 *     .build()
                 * ```
                 */
                fun addCustomTool(name: String) = addTool(Tool.Custom.builder().name(name).build())

                /** Alias for calling [addTool] with `Tool.ofApplyPatch()`. */
                fun addToolApplyPatch() = addTool(Tool.ofApplyPatch())

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("allowed_tools")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                /** How to select a tool from the allowed set. */
                fun mode(mode: Mode?) = mode(JsonField.ofNullable(mode))

                /** Alias for calling [Builder.mode] with `mode.orElse(null)`. */
                fun mode(mode: Optional<Mode>) = mode(mode.getOrNull())

                /**
                 * Sets [Builder.mode] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.mode] with a well-typed [Mode] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun mode(mode: JsonField<Mode>) = apply { this.mode = mode }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [LiveAllowedToolsChoiceParam].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .tools()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): LiveAllowedToolsChoiceParam =
                    LiveAllowedToolsChoiceParam(
                        checkRequired("tools", tools).map { it.toImmutable() },
                        type,
                        mode,
                        additionalProperties.toMutableMap(),
                    )
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
            fun validate(): LiveAllowedToolsChoiceParam = apply {
                if (validated) {
                    return@apply
                }

                toolsOrThrow().forEach { it.validate() }
                typeOrThrow()
                mode().ifPresent { it.validate() }
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
                (tools.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                    type.let { if (it == JsonValue.from("allowed_tools")) 1 else 0 } +
                    (mode.asKnown().getOrNull()?.validity() ?: 0)

            /** Forces the model to call the shell tool when a tool call is required. */
            @JsonDeserialize(using = Tool.Deserializer::class)
            @JsonSerialize(using = Tool.Serializer::class)
            class Tool
            private constructor(
                private val function: Function? = null,
                private val mcp: Mcp? = null,
                private val fileSearch: JsonValue? = null,
                private val webSearch: JsonValue? = null,
                private val webSearchPreview: JsonValue? = null,
                private val imageGeneration: JsonValue? = null,
                private val computer: JsonValue? = null,
                private val codeInterpreter: JsonValue? = null,
                private val programmaticToolCalling: JsonValue? = null,
                private val shell: JsonValue? = null,
                private val custom: Custom? = null,
                private val applyPatch: JsonValue? = null,
                private val _json: JsonValue? = null,
            ) {

                fun function(): Optional<Function> = Optional.ofNullable(function)

                fun mcp(): Optional<Mcp> = Optional.ofNullable(mcp)

                fun fileSearch(): Optional<JsonValue> = Optional.ofNullable(fileSearch)

                fun webSearch(): Optional<JsonValue> = Optional.ofNullable(webSearch)

                fun webSearchPreview(): Optional<JsonValue> = Optional.ofNullable(webSearchPreview)

                fun imageGeneration(): Optional<JsonValue> = Optional.ofNullable(imageGeneration)

                fun computer(): Optional<JsonValue> = Optional.ofNullable(computer)

                fun codeInterpreter(): Optional<JsonValue> = Optional.ofNullable(codeInterpreter)

                fun programmaticToolCalling(): Optional<JsonValue> =
                    Optional.ofNullable(programmaticToolCalling)

                /** Forces the model to call the shell tool when a tool call is required. */
                fun shell(): Optional<JsonValue> = Optional.ofNullable(shell)

                fun custom(): Optional<Custom> = Optional.ofNullable(custom)

                /** Forces the model to call the apply_patch tool when executing a tool call. */
                fun applyPatch(): Optional<JsonValue> = Optional.ofNullable(applyPatch)

                fun isFunction(): Boolean = function != null

                fun isMcp(): Boolean = mcp != null

                fun isFileSearch(): Boolean = fileSearch != null

                fun isWebSearch(): Boolean = webSearch != null

                fun isWebSearchPreview(): Boolean = webSearchPreview != null

                fun isImageGeneration(): Boolean = imageGeneration != null

                fun isComputer(): Boolean = computer != null

                fun isCodeInterpreter(): Boolean = codeInterpreter != null

                fun isProgrammaticToolCalling(): Boolean = programmaticToolCalling != null

                fun isShell(): Boolean = shell != null

                fun isCustom(): Boolean = custom != null

                fun isApplyPatch(): Boolean = applyPatch != null

                fun asFunction(): Function = function.getOrThrow("function")

                fun asMcp(): Mcp = mcp.getOrThrow("mcp")

                fun asFileSearch(): JsonValue = fileSearch.getOrThrow("fileSearch")

                fun asWebSearch(): JsonValue = webSearch.getOrThrow("webSearch")

                fun asWebSearchPreview(): JsonValue =
                    webSearchPreview.getOrThrow("webSearchPreview")

                fun asImageGeneration(): JsonValue = imageGeneration.getOrThrow("imageGeneration")

                fun asComputer(): JsonValue = computer.getOrThrow("computer")

                fun asCodeInterpreter(): JsonValue = codeInterpreter.getOrThrow("codeInterpreter")

                fun asProgrammaticToolCalling(): JsonValue =
                    programmaticToolCalling.getOrThrow("programmaticToolCalling")

                /** Forces the model to call the shell tool when a tool call is required. */
                fun asShell(): JsonValue = shell.getOrThrow("shell")

                fun asCustom(): Custom = custom.getOrThrow("custom")

                /** Forces the model to call the apply_patch tool when executing a tool call. */
                fun asApplyPatch(): JsonValue = applyPatch.getOrThrow("applyPatch")

                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                /**
                 * Maps this instance's current variant to a value of type [T] using the given
                 * [visitor].
                 *
                 * Note that this method is _not_ forwards compatible with new variants from the
                 * API, unless [visitor] overrides [Visitor.unknown]. To handle variants not known
                 * to this version of the SDK gracefully, consider overriding [Visitor.unknown]:
                 * ```java
                 * import com.openai.core.JsonValue;
                 * import java.util.Optional;
                 *
                 * Optional<String> result = tool.accept(new Tool.Visitor<Optional<String>>() {
                 *     @Override
                 *     public Optional<String> visitFunction(Function function) {
                 *         return Optional.of(function.toString());
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
                 * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in
                 *   [visitor] and the current variant is unknown.
                 */
                fun <T> accept(visitor: Visitor<T>): T =
                    when {
                        function != null -> visitor.visitFunction(function)
                        mcp != null -> visitor.visitMcp(mcp)
                        fileSearch != null -> visitor.visitFileSearch(fileSearch)
                        webSearch != null -> visitor.visitWebSearch(webSearch)
                        webSearchPreview != null -> visitor.visitWebSearchPreview(webSearchPreview)
                        imageGeneration != null -> visitor.visitImageGeneration(imageGeneration)
                        computer != null -> visitor.visitComputer(computer)
                        codeInterpreter != null -> visitor.visitCodeInterpreter(codeInterpreter)
                        programmaticToolCalling != null ->
                            visitor.visitProgrammaticToolCalling(programmaticToolCalling)
                        shell != null -> visitor.visitShell(shell)
                        custom != null -> visitor.visitCustom(custom)
                        applyPatch != null -> visitor.visitApplyPatch(applyPatch)
                        else -> visitor.unknown(_json)
                    }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Tool = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitFunction(function: Function) {
                                function.validate()
                            }

                            override fun visitMcp(mcp: Mcp) {
                                mcp.validate()
                            }

                            override fun visitFileSearch(fileSearch: JsonValue) {
                                fileSearch.let {
                                    if (it != JsonValue.from(mapOf("type" to "file_search"))) {
                                        throw OpenAIInvalidDataException(
                                            "'fileSearch' is invalid, received $it"
                                        )
                                    }
                                }
                            }

                            override fun visitWebSearch(webSearch: JsonValue) {
                                webSearch.let {
                                    if (it != JsonValue.from(mapOf("type" to "web_search"))) {
                                        throw OpenAIInvalidDataException(
                                            "'webSearch' is invalid, received $it"
                                        )
                                    }
                                }
                            }

                            override fun visitWebSearchPreview(webSearchPreview: JsonValue) {
                                webSearchPreview.let {
                                    if (
                                        it != JsonValue.from(mapOf("type" to "web_search_preview"))
                                    ) {
                                        throw OpenAIInvalidDataException(
                                            "'webSearchPreview' is invalid, received $it"
                                        )
                                    }
                                }
                            }

                            override fun visitImageGeneration(imageGeneration: JsonValue) {
                                imageGeneration.let {
                                    if (it != JsonValue.from(mapOf("type" to "image_generation"))) {
                                        throw OpenAIInvalidDataException(
                                            "'imageGeneration' is invalid, received $it"
                                        )
                                    }
                                }
                            }

                            override fun visitComputer(computer: JsonValue) {
                                computer.let {
                                    if (it != JsonValue.from(mapOf("type" to "computer"))) {
                                        throw OpenAIInvalidDataException(
                                            "'computer' is invalid, received $it"
                                        )
                                    }
                                }
                            }

                            override fun visitCodeInterpreter(codeInterpreter: JsonValue) {
                                codeInterpreter.let {
                                    if (it != JsonValue.from(mapOf("type" to "code_interpreter"))) {
                                        throw OpenAIInvalidDataException(
                                            "'codeInterpreter' is invalid, received $it"
                                        )
                                    }
                                }
                            }

                            override fun visitProgrammaticToolCalling(
                                programmaticToolCalling: JsonValue
                            ) {
                                programmaticToolCalling.let {
                                    if (
                                        it !=
                                            JsonValue.from(
                                                mapOf("type" to "programmatic_tool_calling")
                                            )
                                    ) {
                                        throw OpenAIInvalidDataException(
                                            "'programmaticToolCalling' is invalid, received $it"
                                        )
                                    }
                                }
                            }

                            override fun visitShell(shell: JsonValue) {
                                shell.let {
                                    if (it != JsonValue.from(mapOf("type" to "shell"))) {
                                        throw OpenAIInvalidDataException(
                                            "'shell' is invalid, received $it"
                                        )
                                    }
                                }
                            }

                            override fun visitCustom(custom: Custom) {
                                custom.validate()
                            }

                            override fun visitApplyPatch(applyPatch: JsonValue) {
                                applyPatch.let {
                                    if (it != JsonValue.from(mapOf("type" to "apply_patch"))) {
                                        throw OpenAIInvalidDataException(
                                            "'applyPatch' is invalid, received $it"
                                        )
                                    }
                                }
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
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
                 *
                 * Used for best match union deserialization.
                 */
                @JvmSynthetic
                internal fun validity(): Int =
                    accept(
                        object : Visitor<Int> {
                            override fun visitFunction(function: Function) = function.validity()

                            override fun visitMcp(mcp: Mcp) = mcp.validity()

                            override fun visitFileSearch(fileSearch: JsonValue) =
                                fileSearch.let {
                                    if (it == JsonValue.from(mapOf("type" to "file_search"))) 1
                                    else 0
                                }

                            override fun visitWebSearch(webSearch: JsonValue) =
                                webSearch.let {
                                    if (it == JsonValue.from(mapOf("type" to "web_search"))) 1
                                    else 0
                                }

                            override fun visitWebSearchPreview(webSearchPreview: JsonValue) =
                                webSearchPreview.let {
                                    if (it == JsonValue.from(mapOf("type" to "web_search_preview")))
                                        1
                                    else 0
                                }

                            override fun visitImageGeneration(imageGeneration: JsonValue) =
                                imageGeneration.let {
                                    if (it == JsonValue.from(mapOf("type" to "image_generation"))) 1
                                    else 0
                                }

                            override fun visitComputer(computer: JsonValue) =
                                computer.let {
                                    if (it == JsonValue.from(mapOf("type" to "computer"))) 1 else 0
                                }

                            override fun visitCodeInterpreter(codeInterpreter: JsonValue) =
                                codeInterpreter.let {
                                    if (it == JsonValue.from(mapOf("type" to "code_interpreter"))) 1
                                    else 0
                                }

                            override fun visitProgrammaticToolCalling(
                                programmaticToolCalling: JsonValue
                            ) =
                                programmaticToolCalling.let {
                                    if (
                                        it ==
                                            JsonValue.from(
                                                mapOf("type" to "programmatic_tool_calling")
                                            )
                                    )
                                        1
                                    else 0
                                }

                            override fun visitShell(shell: JsonValue) =
                                shell.let {
                                    if (it == JsonValue.from(mapOf("type" to "shell"))) 1 else 0
                                }

                            override fun visitCustom(custom: Custom) = custom.validity()

                            override fun visitApplyPatch(applyPatch: JsonValue) =
                                applyPatch.let {
                                    if (it == JsonValue.from(mapOf("type" to "apply_patch"))) 1
                                    else 0
                                }

                            override fun unknown(json: JsonValue?) = 0
                        }
                    )

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Tool &&
                        function == other.function &&
                        mcp == other.mcp &&
                        fileSearch == other.fileSearch &&
                        webSearch == other.webSearch &&
                        webSearchPreview == other.webSearchPreview &&
                        imageGeneration == other.imageGeneration &&
                        computer == other.computer &&
                        codeInterpreter == other.codeInterpreter &&
                        programmaticToolCalling == other.programmaticToolCalling &&
                        shell == other.shell &&
                        custom == other.custom &&
                        applyPatch == other.applyPatch &&
                        (function != null ||
                            mcp != null ||
                            fileSearch != null ||
                            webSearch != null ||
                            webSearchPreview != null ||
                            imageGeneration != null ||
                            computer != null ||
                            codeInterpreter != null ||
                            programmaticToolCalling != null ||
                            shell != null ||
                            custom != null ||
                            applyPatch != null ||
                            _json == other._json)
                }

                override fun hashCode(): Int =
                    if (
                        function == null &&
                            mcp == null &&
                            fileSearch == null &&
                            webSearch == null &&
                            webSearchPreview == null &&
                            imageGeneration == null &&
                            computer == null &&
                            codeInterpreter == null &&
                            programmaticToolCalling == null &&
                            shell == null &&
                            custom == null &&
                            applyPatch == null
                    )
                        Objects.hash(_json)
                    else
                        Objects.hash(
                            function,
                            mcp,
                            fileSearch,
                            webSearch,
                            webSearchPreview,
                            imageGeneration,
                            computer,
                            codeInterpreter,
                            programmaticToolCalling,
                            shell,
                            custom,
                            applyPatch,
                        )

                override fun toString(): String =
                    when {
                        function != null -> "Tool{function=$function}"
                        mcp != null -> "Tool{mcp=$mcp}"
                        fileSearch != null -> "Tool{fileSearch=$fileSearch}"
                        webSearch != null -> "Tool{webSearch=$webSearch}"
                        webSearchPreview != null -> "Tool{webSearchPreview=$webSearchPreview}"
                        imageGeneration != null -> "Tool{imageGeneration=$imageGeneration}"
                        computer != null -> "Tool{computer=$computer}"
                        codeInterpreter != null -> "Tool{codeInterpreter=$codeInterpreter}"
                        programmaticToolCalling != null ->
                            "Tool{programmaticToolCalling=$programmaticToolCalling}"
                        shell != null -> "Tool{shell=$shell}"
                        custom != null -> "Tool{custom=$custom}"
                        applyPatch != null -> "Tool{applyPatch=$applyPatch}"
                        _json != null -> "Tool{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid Tool")
                    }

                companion object {

                    @JvmStatic fun ofFunction(function: Function) = Tool(function = function)

                    @JvmStatic fun ofMcp(mcp: Mcp) = Tool(mcp = mcp)

                    @JvmStatic
                    fun ofFileSearch() =
                        Tool(fileSearch = JsonValue.from(mapOf("type" to "file_search")))

                    @JvmStatic
                    fun ofWebSearch() =
                        Tool(webSearch = JsonValue.from(mapOf("type" to "web_search")))

                    @JvmStatic
                    fun ofWebSearchPreview() =
                        Tool(
                            webSearchPreview = JsonValue.from(mapOf("type" to "web_search_preview"))
                        )

                    @JvmStatic
                    fun ofImageGeneration() =
                        Tool(imageGeneration = JsonValue.from(mapOf("type" to "image_generation")))

                    @JvmStatic
                    fun ofComputer() = Tool(computer = JsonValue.from(mapOf("type" to "computer")))

                    @JvmStatic
                    fun ofCodeInterpreter() =
                        Tool(codeInterpreter = JsonValue.from(mapOf("type" to "code_interpreter")))

                    @JvmStatic
                    fun ofProgrammaticToolCalling() =
                        Tool(
                            programmaticToolCalling =
                                JsonValue.from(mapOf("type" to "programmatic_tool_calling"))
                        )

                    /** Forces the model to call the shell tool when a tool call is required. */
                    @JvmStatic
                    fun ofShell() = Tool(shell = JsonValue.from(mapOf("type" to "shell")))

                    @JvmStatic fun ofCustom(custom: Custom) = Tool(custom = custom)

                    /** Forces the model to call the apply_patch tool when executing a tool call. */
                    @JvmStatic
                    fun ofApplyPatch() =
                        Tool(applyPatch = JsonValue.from(mapOf("type" to "apply_patch")))
                }

                /**
                 * An interface that defines how to map each variant of [Tool] to a value of type
                 * [T].
                 */
                interface Visitor<out T> {

                    fun visitFunction(function: Function): T = unknown(JsonValue.from(function))

                    fun visitMcp(mcp: Mcp): T = unknown(JsonValue.from(mcp))

                    fun visitFileSearch(fileSearch: JsonValue): T =
                        unknown(JsonValue.from(fileSearch))

                    fun visitWebSearch(webSearch: JsonValue): T = unknown(JsonValue.from(webSearch))

                    fun visitWebSearchPreview(webSearchPreview: JsonValue): T =
                        unknown(JsonValue.from(webSearchPreview))

                    fun visitImageGeneration(imageGeneration: JsonValue): T =
                        unknown(JsonValue.from(imageGeneration))

                    fun visitComputer(computer: JsonValue): T = unknown(JsonValue.from(computer))

                    fun visitCodeInterpreter(codeInterpreter: JsonValue): T =
                        unknown(JsonValue.from(codeInterpreter))

                    fun visitProgrammaticToolCalling(programmaticToolCalling: JsonValue): T =
                        unknown(JsonValue.from(programmaticToolCalling))

                    /** Forces the model to call the shell tool when a tool call is required. */
                    fun visitShell(shell: JsonValue): T = unknown(JsonValue.from(shell))

                    fun visitCustom(custom: Custom): T = unknown(JsonValue.from(custom))

                    /** Forces the model to call the apply_patch tool when executing a tool call. */
                    fun visitApplyPatch(applyPatch: JsonValue): T =
                        unknown(JsonValue.from(applyPatch))

                    /**
                     * Maps an unknown variant of [Tool] to a value of type [T].
                     *
                     * An instance of [Tool] can contain an unknown variant if it was deserialized
                     * from data that doesn't match any known variant. For example, if the SDK is on
                     * an older version than the API, then the API may respond with new variants
                     * that the SDK is unaware of.
                     *
                     * Unhandled known JSON variants reach this method as JSON values.
                     *
                     * @throws OpenAIInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw OpenAIInvalidDataException("Unknown Tool")
                    }
                }

                internal class Deserializer : BaseDeserializer<Tool>(Tool::class) {

                    override fun ObjectCodec.deserialize(node: JsonNode): Tool {
                        val json = JsonValue.fromJsonNode(node)
                        val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                        when (type) {
                            "function" -> {
                                return tryDeserialize(node, jacksonTypeRef<Function>())?.let {
                                    Tool(function = it, _json = json)
                                } ?: Tool(_json = json)
                            }
                            "mcp" -> {
                                return tryDeserialize(node, jacksonTypeRef<Mcp>())?.let {
                                    Tool(mcp = it, _json = json)
                                } ?: Tool(_json = json)
                            }
                            "file_search" -> {
                                return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                    ?.let { Tool(fileSearch = it, _json = json) }
                                    ?.takeIf { it.isValid() } ?: Tool(_json = json)
                            }
                            "web_search" -> {
                                return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                    ?.let { Tool(webSearch = it, _json = json) }
                                    ?.takeIf { it.isValid() } ?: Tool(_json = json)
                            }
                            "web_search_preview" -> {
                                return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                    ?.let { Tool(webSearchPreview = it, _json = json) }
                                    ?.takeIf { it.isValid() } ?: Tool(_json = json)
                            }
                            "image_generation" -> {
                                return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                    ?.let { Tool(imageGeneration = it, _json = json) }
                                    ?.takeIf { it.isValid() } ?: Tool(_json = json)
                            }
                            "computer" -> {
                                return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                    ?.let { Tool(computer = it, _json = json) }
                                    ?.takeIf { it.isValid() } ?: Tool(_json = json)
                            }
                            "code_interpreter" -> {
                                return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                    ?.let { Tool(codeInterpreter = it, _json = json) }
                                    ?.takeIf { it.isValid() } ?: Tool(_json = json)
                            }
                            "programmatic_tool_calling" -> {
                                return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                    ?.let { Tool(programmaticToolCalling = it, _json = json) }
                                    ?.takeIf { it.isValid() } ?: Tool(_json = json)
                            }
                            "shell" -> {
                                return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                    ?.let { Tool(shell = it, _json = json) }
                                    ?.takeIf { it.isValid() } ?: Tool(_json = json)
                            }
                            "custom" -> {
                                return tryDeserialize(node, jacksonTypeRef<Custom>())?.let {
                                    Tool(custom = it, _json = json)
                                } ?: Tool(_json = json)
                            }
                            "apply_patch" -> {
                                return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                    ?.let { Tool(applyPatch = it, _json = json) }
                                    ?.takeIf { it.isValid() } ?: Tool(_json = json)
                            }
                        }

                        return Tool(_json = json)
                    }
                }

                internal class Serializer : BaseSerializer<Tool>(Tool::class) {

                    override fun serialize(
                        value: Tool,
                        generator: JsonGenerator,
                        provider: SerializerProvider,
                    ) {
                        when {
                            value.function != null -> generator.writeObject(value.function)
                            value.mcp != null -> generator.writeObject(value.mcp)
                            value.fileSearch != null -> generator.writeObject(value.fileSearch)
                            value.webSearch != null -> generator.writeObject(value.webSearch)
                            value.webSearchPreview != null ->
                                generator.writeObject(value.webSearchPreview)
                            value.imageGeneration != null ->
                                generator.writeObject(value.imageGeneration)
                            value.computer != null -> generator.writeObject(value.computer)
                            value.codeInterpreter != null ->
                                generator.writeObject(value.codeInterpreter)
                            value.programmaticToolCalling != null ->
                                generator.writeObject(value.programmaticToolCalling)
                            value.shell != null -> generator.writeObject(value.shell)
                            value.custom != null -> generator.writeObject(value.custom)
                            value.applyPatch != null -> generator.writeObject(value.applyPatch)
                            value._json != null -> generator.writeObject(value._json)
                            else -> throw IllegalStateException("Invalid Tool")
                        }
                    }
                }

                class Function
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val name: JsonField<String>,
                    private val type: JsonValue,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("name")
                        @ExcludeMissing
                        name: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                    ) : this(name, type, mutableMapOf())

                    /**
                     * The schema requires this property. Returns empty if the JSON property is
                     * missing or null.
                     *
                     * @throws OpenAIInvalidDataException if the value has an unexpected type.
                     */
                    fun name(): java.util.Optional<String> = name.getOptional("name")

                    /**
                     * Returns the value or throws [OpenAIInvalidDataException] if it is missing,
                     * null, or invalid.
                     */
                    fun nameOrThrow(): String = name.getRequired("name")

                    /**
                     * The schema requires this property. Returns empty if the JSON property is
                     * missing or null.
                     *
                     * @throws OpenAIInvalidDataException if the value has an unexpected type.
                     */
                    fun type(): java.util.Optional<JsonValue> {
                        val raw = type
                        return when {
                            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                            !(raw == JsonValue.from("function")) ->
                                throw OpenAIInvalidDataException("`type` is invalid")
                            else -> java.util.Optional.of(raw)
                        }
                    }

                    /**
                     * Returns the value or throws [OpenAIInvalidDataException] if it is missing,
                     * null, or invalid.
                     */
                    fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

                    /**
                     * Returns the raw JSON value of [name].
                     *
                     * Unlike [name], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

                    @JsonAnySetter
                    private fun putAdditionalProperty(key: String, value: JsonValue) {
                        additionalProperties.put(key, value)
                    }

                    /**
                     * Returns an immutable snapshot of all present JSON properties, including
                     * declared and additional properties.
                     *
                     * Keys use their JSON names. Declared properties take precedence over
                     * additional properties with the same name. Missing properties are omitted,
                     * while explicit nulls and unrecognized values are preserved.
                     */
                    fun _allProperties(): Map<String, JsonValue> =
                        collectAllProperties(
                            additionalProperties,
                            "name" to this.name,
                            "type" to this.type,
                        )

                    @JvmSynthetic
                    internal fun _additionalProperties(): Map<String, JsonValue> =
                        Collections.unmodifiableMap(additionalProperties)

                    @JsonAnyGetter
                    @ExcludeMissing
                    private fun additionalProperties(): Map<String, JsonValue> =
                        additionalProperties

                    fun toBuilder() = Builder().from(this)

                    companion object {

                        /**
                         * Returns a mutable builder for constructing an instance of [Function].
                         *
                         * The following fields are required:
                         * ```java
                         * .name()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Function]. */
                    class Builder internal constructor() {

                        private var name: JsonField<String>? = null
                        private var type: JsonValue = JsonValue.from("function")
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(function: Function) = apply {
                            name = function.name
                            type = function.type
                            additionalProperties = function.additionalProperties.toMutableMap()
                        }

                        fun name(name: String) = name(JsonField.of(name))

                        /**
                         * Sets [Builder.name] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.name] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun name(name: JsonField<String>) = apply { this.name = name }

                        /**
                         * Sets the field to an arbitrary JSON value.
                         *
                         * It is usually unnecessary to call this method because the field defaults
                         * to the following:
                         * ```java
                         * JsonValue.from("function")
                         * ```
                         *
                         * This method is primarily for setting the field to an undocumented or not
                         * yet supported value.
                         */
                        fun type(type: JsonValue) = apply { this.type = type }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [Function].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .name()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): Function =
                            Function(
                                checkRequired("name", name),
                                type,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws OpenAIInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): Function = apply {
                        if (validated) {
                            return@apply
                        }

                        nameOrThrow()
                        typeOrThrow()
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
                        (if (name.asKnown().isPresent) 1 else 0) +
                            type.let { if (it == JsonValue.from("function")) 1 else 0 }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Function &&
                            name == other.name &&
                            type == other.type &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(name, type, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Function{name=$name, type=$type, additionalProperties=$additionalProperties}"
                }

                class Mcp
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val name: JsonField<String>,
                    private val serverLabel: JsonField<String>,
                    private val type: JsonValue,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("name")
                        @ExcludeMissing
                        name: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("server_label")
                        @ExcludeMissing
                        serverLabel: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                    ) : this(name, serverLabel, type, mutableMapOf())

                    /**
                     * The schema requires this property. Returns empty if the JSON property is
                     * missing or null.
                     *
                     * @throws OpenAIInvalidDataException if the value has an unexpected type.
                     */
                    fun name(): java.util.Optional<String> = name.getOptional("name")

                    /**
                     * Returns the value or throws [OpenAIInvalidDataException] if it is missing,
                     * null, or invalid.
                     */
                    fun nameOrThrow(): String = name.getRequired("name")

                    /**
                     * The schema requires this property. Returns empty if the JSON property is
                     * missing or null.
                     *
                     * @throws OpenAIInvalidDataException if the value has an unexpected type.
                     */
                    fun serverLabel(): java.util.Optional<String> =
                        serverLabel.getOptional("server_label")

                    /**
                     * Returns the value or throws [OpenAIInvalidDataException] if it is missing,
                     * null, or invalid.
                     */
                    fun serverLabelOrThrow(): String = serverLabel.getRequired("server_label")

                    /**
                     * The schema requires this property. Returns empty if the JSON property is
                     * missing or null.
                     *
                     * @throws OpenAIInvalidDataException if the value has an unexpected type.
                     */
                    fun type(): java.util.Optional<JsonValue> {
                        val raw = type
                        return when {
                            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                            !(raw == JsonValue.from("mcp")) ->
                                throw OpenAIInvalidDataException("`type` is invalid")
                            else -> java.util.Optional.of(raw)
                        }
                    }

                    /**
                     * Returns the value or throws [OpenAIInvalidDataException] if it is missing,
                     * null, or invalid.
                     */
                    fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

                    /**
                     * Returns the raw JSON value of [name].
                     *
                     * Unlike [name], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

                    /**
                     * Returns the raw JSON value of [serverLabel].
                     *
                     * Unlike [serverLabel], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("server_label")
                    @ExcludeMissing
                    fun _serverLabel(): JsonField<String> = serverLabel

                    @JsonAnySetter
                    private fun putAdditionalProperty(key: String, value: JsonValue) {
                        additionalProperties.put(key, value)
                    }

                    /**
                     * Returns an immutable snapshot of all present JSON properties, including
                     * declared and additional properties.
                     *
                     * Keys use their JSON names. Declared properties take precedence over
                     * additional properties with the same name. Missing properties are omitted,
                     * while explicit nulls and unrecognized values are preserved.
                     */
                    fun _allProperties(): Map<String, JsonValue> =
                        collectAllProperties(
                            additionalProperties,
                            "name" to this.name,
                            "server_label" to this.serverLabel,
                            "type" to this.type,
                        )

                    @JvmSynthetic
                    internal fun _additionalProperties(): Map<String, JsonValue> =
                        Collections.unmodifiableMap(additionalProperties)

                    @JsonAnyGetter
                    @ExcludeMissing
                    private fun additionalProperties(): Map<String, JsonValue> =
                        additionalProperties

                    fun toBuilder() = Builder().from(this)

                    companion object {

                        /**
                         * Returns a mutable builder for constructing an instance of [Mcp].
                         *
                         * The following fields are required:
                         * ```java
                         * .name()
                         * .serverLabel()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Mcp]. */
                    class Builder internal constructor() {

                        private var name: JsonField<String>? = null
                        private var serverLabel: JsonField<String>? = null
                        private var type: JsonValue = JsonValue.from("mcp")
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(mcp: Mcp) = apply {
                            name = mcp.name
                            serverLabel = mcp.serverLabel
                            type = mcp.type
                            additionalProperties = mcp.additionalProperties.toMutableMap()
                        }

                        fun name(name: String) = name(JsonField.of(name))

                        /**
                         * Sets [Builder.name] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.name] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun name(name: JsonField<String>) = apply { this.name = name }

                        fun serverLabel(serverLabel: String) =
                            serverLabel(JsonField.of(serverLabel))

                        /**
                         * Sets [Builder.serverLabel] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.serverLabel] with a well-typed [String]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun serverLabel(serverLabel: JsonField<String>) = apply {
                            this.serverLabel = serverLabel
                        }

                        /**
                         * Sets the field to an arbitrary JSON value.
                         *
                         * It is usually unnecessary to call this method because the field defaults
                         * to the following:
                         * ```java
                         * JsonValue.from("mcp")
                         * ```
                         *
                         * This method is primarily for setting the field to an undocumented or not
                         * yet supported value.
                         */
                        fun type(type: JsonValue) = apply { this.type = type }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [Mcp].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .name()
                         * .serverLabel()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): Mcp =
                            Mcp(
                                checkRequired("name", name),
                                checkRequired("serverLabel", serverLabel),
                                type,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws OpenAIInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): Mcp = apply {
                        if (validated) {
                            return@apply
                        }

                        nameOrThrow()
                        serverLabelOrThrow()
                        typeOrThrow()
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
                        (if (name.asKnown().isPresent) 1 else 0) +
                            (if (serverLabel.asKnown().isPresent) 1 else 0) +
                            type.let { if (it == JsonValue.from("mcp")) 1 else 0 }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Mcp &&
                            name == other.name &&
                            serverLabel == other.serverLabel &&
                            type == other.type &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(name, serverLabel, type, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Mcp{name=$name, serverLabel=$serverLabel, type=$type, additionalProperties=$additionalProperties}"
                }

                class Custom
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val name: JsonField<String>,
                    private val type: JsonValue,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("name")
                        @ExcludeMissing
                        name: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                    ) : this(name, type, mutableMapOf())

                    /**
                     * The name of the custom tool to call. The schema requires this property.
                     * Returns empty if the JSON property is missing or null.
                     *
                     * @throws OpenAIInvalidDataException if the value has an unexpected type.
                     */
                    fun name(): java.util.Optional<String> = name.getOptional("name")

                    /**
                     * Returns the value or throws [OpenAIInvalidDataException] if it is missing,
                     * null, or invalid.
                     */
                    fun nameOrThrow(): String = name.getRequired("name")

                    /**
                     * The tool to call. Always `custom`. The schema requires this property. Returns
                     * empty if the JSON property is missing or null.
                     *
                     * @throws OpenAIInvalidDataException if the value has an unexpected type.
                     */
                    fun type(): java.util.Optional<JsonValue> {
                        val raw = type
                        return when {
                            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                            !(raw == JsonValue.from("custom")) ->
                                throw OpenAIInvalidDataException("`type` is invalid")
                            else -> java.util.Optional.of(raw)
                        }
                    }

                    /**
                     * Returns the value or throws [OpenAIInvalidDataException] if it is missing,
                     * null, or invalid.
                     */
                    fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

                    /**
                     * Returns the raw JSON value of [name].
                     *
                     * Unlike [name], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

                    @JsonAnySetter
                    private fun putAdditionalProperty(key: String, value: JsonValue) {
                        additionalProperties.put(key, value)
                    }

                    /**
                     * Returns an immutable snapshot of all present JSON properties, including
                     * declared and additional properties.
                     *
                     * Keys use their JSON names. Declared properties take precedence over
                     * additional properties with the same name. Missing properties are omitted,
                     * while explicit nulls and unrecognized values are preserved.
                     */
                    fun _allProperties(): Map<String, JsonValue> =
                        collectAllProperties(
                            additionalProperties,
                            "name" to this.name,
                            "type" to this.type,
                        )

                    @JvmSynthetic
                    internal fun _additionalProperties(): Map<String, JsonValue> =
                        Collections.unmodifiableMap(additionalProperties)

                    @JsonAnyGetter
                    @ExcludeMissing
                    private fun additionalProperties(): Map<String, JsonValue> =
                        additionalProperties

                    fun toBuilder() = Builder().from(this)

                    companion object {

                        /**
                         * Returns a mutable builder for constructing an instance of [Custom].
                         *
                         * The following fields are required:
                         * ```java
                         * .name()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Custom]. */
                    class Builder internal constructor() {

                        private var name: JsonField<String>? = null
                        private var type: JsonValue = JsonValue.from("custom")
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(custom: Custom) = apply {
                            name = custom.name
                            type = custom.type
                            additionalProperties = custom.additionalProperties.toMutableMap()
                        }

                        /** The name of the custom tool to call. */
                        fun name(name: String) = name(JsonField.of(name))

                        /**
                         * Sets [Builder.name] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.name] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun name(name: JsonField<String>) = apply { this.name = name }

                        /**
                         * Sets the field to an arbitrary JSON value.
                         *
                         * It is usually unnecessary to call this method because the field defaults
                         * to the following:
                         * ```java
                         * JsonValue.from("custom")
                         * ```
                         *
                         * This method is primarily for setting the field to an undocumented or not
                         * yet supported value.
                         */
                        fun type(type: JsonValue) = apply { this.type = type }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [Custom].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .name()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): Custom =
                            Custom(
                                checkRequired("name", name),
                                type,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws OpenAIInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): Custom = apply {
                        if (validated) {
                            return@apply
                        }

                        nameOrThrow()
                        typeOrThrow()
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
                        (if (name.asKnown().isPresent) 1 else 0) +
                            type.let { if (it == JsonValue.from("custom")) 1 else 0 }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Custom &&
                            name == other.name &&
                            type == other.type &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(name, type, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Custom{name=$name, type=$type, additionalProperties=$additionalProperties}"
                }
            }

            /** How to select a tool from the allowed set. */
            class Mode @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val NONE = of("none")

                    @JvmField val AUTO = of("auto")

                    @JvmField val REQUIRED = of("required")

                    @JvmStatic fun of(value: String) = Mode(JsonField.of(value))
                }

                /** An enum containing [Mode]'s known values. */
                @Deprecated("Use asString() for string values or _value() for raw JSON.")
                enum class Known {
                    NONE,
                    AUTO,
                    REQUIRED,
                }

                /**
                 * An enum containing [Mode]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Mode] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                @Deprecated("Use asString() for string values or _value() for raw JSON.")
                enum class Value {
                    NONE,
                    AUTO,
                    REQUIRED,
                    /**
                     * An enum member indicating that [Mode] was instantiated with an unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                @Deprecated("Use asString() for string values or _value() for raw JSON.")
                fun value(): Value =
                    when (this) {
                        NONE -> Value.NONE
                        AUTO -> Value.AUTO
                        REQUIRED -> Value.REQUIRED
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value is a not a
                 *   known member.
                 */
                @Deprecated("Use asString() for string values or _value() for raw JSON.")
                fun known(): Known =
                    when (this) {
                        NONE -> Known.NONE
                        AUTO -> Known.AUTO
                        REQUIRED -> Known.REQUIRED
                        else -> throw OpenAIInvalidDataException("Unknown Mode: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
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
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Mode = apply {
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

                    return other is Mode && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is LiveAllowedToolsChoiceParam &&
                    tools == other.tools &&
                    type == other.type &&
                    mode == other.mode &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(tools, type, mode, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "LiveAllowedToolsChoiceParam{tools=$tools, type=$type, mode=$mode, additionalProperties=$additionalProperties}"
        }
    }

    /** A function tool available to the Responses backend when the Live model delegates a task. */
    @JsonDeserialize(using = Tool.Deserializer::class)
    @JsonSerialize(using = Tool.Serializer::class)
    class Tool
    private constructor(
        private val function: FunctionTool? = null,
        private val webSearch: JsonValue? = null,
        private val fileSearch: JsonValue? = null,
        private val codeInterpreter: JsonValue? = null,
        private val shell: Shell? = null,
        private val imageGeneration: JsonValue? = null,
        private val mcp: JsonValue? = null,
        private val custom: JsonValue? = null,
        private val namespace: JsonValue? = null,
        private val search: JsonValue? = null,
        private val programmaticToolCalling: JsonValue? = null,
        private val computer: JsonValue? = null,
        private val applyPatch: JsonValue? = null,
        private val _json: JsonValue? = null,
    ) {

        /**
         * A function tool available to the Responses backend when the Live model delegates a task.
         */
        fun function(): Optional<FunctionTool> = Optional.ofNullable(function)

        /** A web search tool available to the Live session’s Responses backend. */
        fun webSearch(): Optional<JsonValue> = Optional.ofNullable(webSearch)

        fun fileSearch(): Optional<JsonValue> = Optional.ofNullable(fileSearch)

        fun codeInterpreter(): Optional<JsonValue> = Optional.ofNullable(codeInterpreter)

        /**
         * A Responses shell tool. Use a hosted container or return local shell results with
         * response.item.create. Domain secrets are not supported.
         */
        fun shell(): Optional<Shell> = Optional.ofNullable(shell)

        fun imageGeneration(): Optional<JsonValue> = Optional.ofNullable(imageGeneration)

        fun mcp(): Optional<JsonValue> = Optional.ofNullable(mcp)

        fun custom(): Optional<JsonValue> = Optional.ofNullable(custom)

        fun namespace(): Optional<JsonValue> = Optional.ofNullable(namespace)

        fun search(): Optional<JsonValue> = Optional.ofNullable(search)

        fun programmaticToolCalling(): Optional<JsonValue> =
            Optional.ofNullable(programmaticToolCalling)

        fun computer(): Optional<JsonValue> = Optional.ofNullable(computer)

        fun applyPatch(): Optional<JsonValue> = Optional.ofNullable(applyPatch)

        fun isFunction(): Boolean = function != null

        fun isWebSearch(): Boolean = webSearch != null

        fun isFileSearch(): Boolean = fileSearch != null

        fun isCodeInterpreter(): Boolean = codeInterpreter != null

        fun isShell(): Boolean = shell != null

        fun isImageGeneration(): Boolean = imageGeneration != null

        fun isMcp(): Boolean = mcp != null

        fun isCustom(): Boolean = custom != null

        fun isNamespace(): Boolean = namespace != null

        fun isSearch(): Boolean = search != null

        fun isProgrammaticToolCalling(): Boolean = programmaticToolCalling != null

        fun isComputer(): Boolean = computer != null

        fun isApplyPatch(): Boolean = applyPatch != null

        /**
         * A function tool available to the Responses backend when the Live model delegates a task.
         */
        fun asFunction(): FunctionTool = function.getOrThrow("function")

        /** A web search tool available to the Live session’s Responses backend. */
        fun asWebSearch(): JsonValue = webSearch.getOrThrow("webSearch")

        fun asFileSearch(): JsonValue = fileSearch.getOrThrow("fileSearch")

        fun asCodeInterpreter(): JsonValue = codeInterpreter.getOrThrow("codeInterpreter")

        /**
         * A Responses shell tool. Use a hosted container or return local shell results with
         * response.item.create. Domain secrets are not supported.
         */
        fun asShell(): Shell = shell.getOrThrow("shell")

        fun asImageGeneration(): JsonValue = imageGeneration.getOrThrow("imageGeneration")

        fun asMcp(): JsonValue = mcp.getOrThrow("mcp")

        fun asCustom(): JsonValue = custom.getOrThrow("custom")

        fun asNamespace(): JsonValue = namespace.getOrThrow("namespace")

        fun asSearch(): JsonValue = search.getOrThrow("search")

        fun asProgrammaticToolCalling(): JsonValue =
            programmaticToolCalling.getOrThrow("programmaticToolCalling")

        fun asComputer(): JsonValue = computer.getOrThrow("computer")

        fun asApplyPatch(): JsonValue = applyPatch.getOrThrow("applyPatch")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        /** Maps this value using an immutable callback registration snapshot. */
        fun <T> match(handler: Handler<T>): T = handler.apply(this)

        /**
         * SDK-owned dispatch. Omitted callbacks use [Builder.onDefault], or throw a payload-free
         * error. Callback return values (including null) and exceptions are propagated unchanged.
         * Immutable registration does not make callbacks or their captured state thread-safe.
         */
        class Handler<T>
        private constructor(
            private val callbacks: Map<String, (Tool) -> T>,
            private val onDefault: java.util.function.Function<in Tool, out T>?,
        ) {
            fun apply(value: Tool): T {
                val callback =
                    when {
                        value.function != null -> callbacks["function"]
                        value.webSearch != null -> callbacks["webSearch"]
                        value.fileSearch != null -> callbacks["fileSearch"]
                        value.codeInterpreter != null -> callbacks["codeInterpreter"]
                        value.shell != null -> callbacks["shell"]
                        value.imageGeneration != null -> callbacks["imageGeneration"]
                        value.mcp != null -> callbacks["mcp"]
                        value.custom != null -> callbacks["custom"]
                        value.namespace != null -> callbacks["namespace"]
                        value.search != null -> callbacks["search"]
                        value.programmaticToolCalling != null ->
                            callbacks["programmaticToolCalling"]
                        value.computer != null -> callbacks["computer"]
                        value.applyPatch != null -> callbacks["applyPatch"]
                        else -> null
                    }
                if (callback != null) return callback(value)
                if (onDefault != null) return onDefault.apply(value)
                throw OpenAIInvalidDataException("Unhandled Tool")
            }

            companion object {
                @JvmStatic fun <T> builder(): Builder<T> = Builder()
            }

            /** Repeated setters replace earlier registrations. [build] copies the registrations. */
            class Builder<T> internal constructor() {
                private val callbacks = mutableMapOf<String, (Tool) -> T>()
                private var onDefault: java.util.function.Function<in Tool, out T>? = null

                fun onFunction(callback: java.util.function.Function<in FunctionTool, out T>) =
                    apply {
                        callbacks["function"] = { value -> callback.apply(value.function!!) }
                    }

                fun onWebSearch(callback: java.util.function.Function<in JsonValue, out T>) =
                    apply {
                        callbacks["webSearch"] = { value -> callback.apply(value.webSearch!!) }
                    }

                fun onFileSearch(callback: java.util.function.Function<in JsonValue, out T>) =
                    apply {
                        callbacks["fileSearch"] = { value -> callback.apply(value.fileSearch!!) }
                    }

                fun onCodeInterpreter(callback: java.util.function.Function<in JsonValue, out T>) =
                    apply {
                        callbacks["codeInterpreter"] = { value ->
                            callback.apply(value.codeInterpreter!!)
                        }
                    }

                fun onShell(callback: java.util.function.Function<in Shell, out T>) = apply {
                    callbacks["shell"] = { value -> callback.apply(value.shell!!) }
                }

                fun onImageGeneration(callback: java.util.function.Function<in JsonValue, out T>) =
                    apply {
                        callbacks["imageGeneration"] = { value ->
                            callback.apply(value.imageGeneration!!)
                        }
                    }

                fun onMcp(callback: java.util.function.Function<in JsonValue, out T>) = apply {
                    callbacks["mcp"] = { value -> callback.apply(value.mcp!!) }
                }

                fun onCustom(callback: java.util.function.Function<in JsonValue, out T>) = apply {
                    callbacks["custom"] = { value -> callback.apply(value.custom!!) }
                }

                fun onNamespace(callback: java.util.function.Function<in JsonValue, out T>) =
                    apply {
                        callbacks["namespace"] = { value -> callback.apply(value.namespace!!) }
                    }

                fun onSearch(callback: java.util.function.Function<in JsonValue, out T>) = apply {
                    callbacks["search"] = { value -> callback.apply(value.search!!) }
                }

                fun onProgrammaticToolCalling(
                    callback: java.util.function.Function<in JsonValue, out T>
                ) = apply {
                    callbacks["programmaticToolCalling"] = { value ->
                        callback.apply(value.programmaticToolCalling!!)
                    }
                }

                fun onComputer(callback: java.util.function.Function<in JsonValue, out T>) = apply {
                    callbacks["computer"] = { value -> callback.apply(value.computer!!) }
                }

                fun onApplyPatch(callback: java.util.function.Function<in JsonValue, out T>) =
                    apply {
                        callbacks["applyPatch"] = { value -> callback.apply(value.applyPatch!!) }
                    }

                /**
                 * Receives this union for both unknown and recognized-but-unregistered variants.
                 */
                fun onDefault(callback: java.util.function.Function<in Tool, out T>) = apply {
                    onDefault = callback
                }

                /** Builds a snapshot; registration of every variant is intentionally optional. */
                fun build(): Handler<T> = Handler(callbacks.toMap(), onDefault)
            }
        }

        private fun <T> dispatchCurrent(visitor: CurrentVisitor<T>): T =
            when {
                function != null -> visitor.visitFunction(function)
                webSearch != null -> visitor.visitWebSearch(webSearch)
                fileSearch != null -> visitor.visitFileSearch(fileSearch)
                codeInterpreter != null -> visitor.visitCodeInterpreter(codeInterpreter)
                shell != null -> visitor.visitShell(shell)
                imageGeneration != null -> visitor.visitImageGeneration(imageGeneration)
                mcp != null -> visitor.visitMcp(mcp)
                custom != null -> visitor.visitCustom(custom)
                namespace != null -> visitor.visitNamespace(namespace)
                search != null -> visitor.visitSearch(search)
                programmaticToolCalling != null ->
                    visitor.visitProgrammaticToolCalling(programmaticToolCalling)
                computer != null -> visitor.visitComputer(computer)
                applyPatch != null -> visitor.visitApplyPatch(applyPatch)
                else -> visitor.unknown(_json)
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
        fun validate(): Tool = apply {
            if (validated) {
                return@apply
            }

            dispatchCurrent(
                object : CurrentVisitor<Unit> {
                    override fun visitFunction(function: FunctionTool) {
                        function.validate()
                    }

                    override fun visitWebSearch(webSearch: JsonValue) {
                        webSearch.let {
                            if (it != JsonValue.from(mapOf("type" to "web_search"))) {
                                throw OpenAIInvalidDataException(
                                    "'webSearch' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitFileSearch(fileSearch: JsonValue) {
                        fileSearch.let {
                            if (it != JsonValue.from(mapOf("type" to "file_search"))) {
                                throw OpenAIInvalidDataException(
                                    "'fileSearch' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitCodeInterpreter(codeInterpreter: JsonValue) {
                        codeInterpreter.let {
                            if (it != JsonValue.from(mapOf("type" to "code_interpreter"))) {
                                throw OpenAIInvalidDataException(
                                    "'codeInterpreter' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitShell(shell: Shell) {
                        shell.validate()
                    }

                    override fun visitImageGeneration(imageGeneration: JsonValue) {
                        imageGeneration.let {
                            if (it != JsonValue.from(mapOf("type" to "image_generation"))) {
                                throw OpenAIInvalidDataException(
                                    "'imageGeneration' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitMcp(mcp: JsonValue) {
                        mcp.let {
                            if (it != JsonValue.from(mapOf("type" to "mcp"))) {
                                throw OpenAIInvalidDataException("'mcp' is invalid, received $it")
                            }
                        }
                    }

                    override fun visitCustom(custom: JsonValue) {
                        custom.let {
                            if (it != JsonValue.from(mapOf("type" to "custom"))) {
                                throw OpenAIInvalidDataException(
                                    "'custom' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitNamespace(namespace: JsonValue) {
                        namespace.let {
                            if (it != JsonValue.from(mapOf("type" to "namespace"))) {
                                throw OpenAIInvalidDataException(
                                    "'namespace' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitSearch(search: JsonValue) {
                        search.let {
                            if (it != JsonValue.from(mapOf("type" to "tool_search"))) {
                                throw OpenAIInvalidDataException(
                                    "'search' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitProgrammaticToolCalling(programmaticToolCalling: JsonValue) {
                        programmaticToolCalling.let {
                            if (
                                it != JsonValue.from(mapOf("type" to "programmatic_tool_calling"))
                            ) {
                                throw OpenAIInvalidDataException(
                                    "'programmaticToolCalling' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitComputer(computer: JsonValue) {
                        computer.let {
                            if (it != JsonValue.from(mapOf("type" to "computer"))) {
                                throw OpenAIInvalidDataException(
                                    "'computer' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitApplyPatch(applyPatch: JsonValue) {
                        applyPatch.let {
                            if (it != JsonValue.from(mapOf("type" to "apply_patch"))) {
                                throw OpenAIInvalidDataException(
                                    "'applyPatch' is invalid, received $it"
                                )
                            }
                        }
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            dispatchCurrent(
                object : CurrentVisitor<Int> {
                    override fun visitFunction(function: FunctionTool) = function.validity()

                    override fun visitWebSearch(webSearch: JsonValue) =
                        webSearch.let {
                            if (it == JsonValue.from(mapOf("type" to "web_search"))) 1 else 0
                        }

                    override fun visitFileSearch(fileSearch: JsonValue) =
                        fileSearch.let {
                            if (it == JsonValue.from(mapOf("type" to "file_search"))) 1 else 0
                        }

                    override fun visitCodeInterpreter(codeInterpreter: JsonValue) =
                        codeInterpreter.let {
                            if (it == JsonValue.from(mapOf("type" to "code_interpreter"))) 1 else 0
                        }

                    override fun visitShell(shell: Shell) = shell.validity()

                    override fun visitImageGeneration(imageGeneration: JsonValue) =
                        imageGeneration.let {
                            if (it == JsonValue.from(mapOf("type" to "image_generation"))) 1 else 0
                        }

                    override fun visitMcp(mcp: JsonValue) =
                        mcp.let { if (it == JsonValue.from(mapOf("type" to "mcp"))) 1 else 0 }

                    override fun visitCustom(custom: JsonValue) =
                        custom.let { if (it == JsonValue.from(mapOf("type" to "custom"))) 1 else 0 }

                    override fun visitNamespace(namespace: JsonValue) =
                        namespace.let {
                            if (it == JsonValue.from(mapOf("type" to "namespace"))) 1 else 0
                        }

                    override fun visitSearch(search: JsonValue) =
                        search.let {
                            if (it == JsonValue.from(mapOf("type" to "tool_search"))) 1 else 0
                        }

                    override fun visitProgrammaticToolCalling(programmaticToolCalling: JsonValue) =
                        programmaticToolCalling.let {
                            if (it == JsonValue.from(mapOf("type" to "programmatic_tool_calling")))
                                1
                            else 0
                        }

                    override fun visitComputer(computer: JsonValue) =
                        computer.let {
                            if (it == JsonValue.from(mapOf("type" to "computer"))) 1 else 0
                        }

                    override fun visitApplyPatch(applyPatch: JsonValue) =
                        applyPatch.let {
                            if (it == JsonValue.from(mapOf("type" to "apply_patch"))) 1 else 0
                        }

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Tool &&
                function == other.function &&
                webSearch == other.webSearch &&
                fileSearch == other.fileSearch &&
                codeInterpreter == other.codeInterpreter &&
                shell == other.shell &&
                imageGeneration == other.imageGeneration &&
                mcp == other.mcp &&
                custom == other.custom &&
                namespace == other.namespace &&
                search == other.search &&
                programmaticToolCalling == other.programmaticToolCalling &&
                computer == other.computer &&
                applyPatch == other.applyPatch &&
                (function != null ||
                    webSearch != null ||
                    fileSearch != null ||
                    codeInterpreter != null ||
                    shell != null ||
                    imageGeneration != null ||
                    mcp != null ||
                    custom != null ||
                    namespace != null ||
                    search != null ||
                    programmaticToolCalling != null ||
                    computer != null ||
                    applyPatch != null ||
                    _json == other._json)
        }

        override fun hashCode(): Int =
            if (
                function == null &&
                    webSearch == null &&
                    fileSearch == null &&
                    codeInterpreter == null &&
                    shell == null &&
                    imageGeneration == null &&
                    mcp == null &&
                    custom == null &&
                    namespace == null &&
                    search == null &&
                    programmaticToolCalling == null &&
                    computer == null &&
                    applyPatch == null
            )
                Objects.hash(_json)
            else
                Objects.hash(
                    function,
                    webSearch,
                    fileSearch,
                    codeInterpreter,
                    shell,
                    imageGeneration,
                    mcp,
                    custom,
                    namespace,
                    search,
                    programmaticToolCalling,
                    computer,
                    applyPatch,
                )

        override fun toString(): String =
            when {
                function != null -> "Tool{function=$function}"
                webSearch != null -> "Tool{webSearch=$webSearch}"
                fileSearch != null -> "Tool{fileSearch=$fileSearch}"
                codeInterpreter != null -> "Tool{codeInterpreter=$codeInterpreter}"
                shell != null -> "Tool{shell=$shell}"
                imageGeneration != null -> "Tool{imageGeneration=$imageGeneration}"
                mcp != null -> "Tool{mcp=$mcp}"
                custom != null -> "Tool{custom=$custom}"
                namespace != null -> "Tool{namespace=$namespace}"
                search != null -> "Tool{search=$search}"
                programmaticToolCalling != null ->
                    "Tool{programmaticToolCalling=$programmaticToolCalling}"
                computer != null -> "Tool{computer=$computer}"
                applyPatch != null -> "Tool{applyPatch=$applyPatch}"
                _json != null -> "Tool{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Tool")
            }

        companion object {

            /**
             * A function tool available to the Responses backend when the Live model delegates a
             * task.
             */
            @JvmStatic fun ofFunction(function: FunctionTool) = Tool(function = function)

            /** A web search tool available to the Live session’s Responses backend. */
            @JvmStatic
            fun ofWebSearch() = Tool(webSearch = JsonValue.from(mapOf("type" to "web_search")))

            @JvmStatic
            fun ofFileSearch() = Tool(fileSearch = JsonValue.from(mapOf("type" to "file_search")))

            @JvmStatic
            fun ofCodeInterpreter() =
                Tool(codeInterpreter = JsonValue.from(mapOf("type" to "code_interpreter")))

            /**
             * A Responses shell tool. Use a hosted container or return local shell results with
             * response.item.create. Domain secrets are not supported.
             */
            @JvmStatic fun ofShell(shell: Shell) = Tool(shell = shell)

            @JvmStatic
            fun ofImageGeneration() =
                Tool(imageGeneration = JsonValue.from(mapOf("type" to "image_generation")))

            @JvmStatic fun ofMcp() = Tool(mcp = JsonValue.from(mapOf("type" to "mcp")))

            @JvmStatic fun ofCustom() = Tool(custom = JsonValue.from(mapOf("type" to "custom")))

            @JvmStatic
            fun ofNamespace() = Tool(namespace = JsonValue.from(mapOf("type" to "namespace")))

            @JvmStatic
            fun ofSearch() = Tool(search = JsonValue.from(mapOf("type" to "tool_search")))

            @JvmStatic
            fun ofProgrammaticToolCalling() =
                Tool(
                    programmaticToolCalling =
                        JsonValue.from(mapOf("type" to "programmatic_tool_calling"))
                )

            @JvmStatic
            fun ofComputer() = Tool(computer = JsonValue.from(mapOf("type" to "computer")))

            @JvmStatic
            fun ofApplyPatch() = Tool(applyPatch = JsonValue.from(mapOf("type" to "apply_patch")))
        }

        /** An interface that defines how to map each variant of [Tool] to a value of type [T]. */
        private interface CurrentVisitor<out T> {

            /**
             * A function tool available to the Responses backend when the Live model delegates a
             * task.
             */
            fun visitFunction(function: FunctionTool): T

            /** A web search tool available to the Live session’s Responses backend. */
            fun visitWebSearch(webSearch: JsonValue): T

            fun visitFileSearch(fileSearch: JsonValue): T

            fun visitCodeInterpreter(codeInterpreter: JsonValue): T

            /**
             * A Responses shell tool. Use a hosted container or return local shell results with
             * response.item.create. Domain secrets are not supported.
             */
            fun visitShell(shell: Shell): T

            fun visitImageGeneration(imageGeneration: JsonValue): T

            fun visitMcp(mcp: JsonValue): T

            fun visitCustom(custom: JsonValue): T

            fun visitNamespace(namespace: JsonValue): T

            fun visitSearch(search: JsonValue): T

            fun visitProgrammaticToolCalling(programmaticToolCalling: JsonValue): T

            fun visitComputer(computer: JsonValue): T

            fun visitApplyPatch(applyPatch: JsonValue): T

            /**
             * Maps an unknown variant of [Tool] to a value of type [T].
             *
             * An instance of [Tool] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Tool")
            }
        }

        internal class Deserializer : BaseDeserializer<Tool>(Tool::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Tool {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "function" -> {
                        return tryDeserialize(node, jacksonTypeRef<FunctionTool>())?.let {
                            Tool(function = it, _json = json)
                        } ?: Tool(_json = json)
                    }
                    "web_search" -> {
                        return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                            ?.let { Tool(webSearch = it, _json = json) }
                            ?.takeIf { it.isValid() } ?: Tool(_json = json)
                    }
                    "file_search" -> {
                        return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                            ?.let { Tool(fileSearch = it, _json = json) }
                            ?.takeIf { it.isValid() } ?: Tool(_json = json)
                    }
                    "code_interpreter" -> {
                        return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                            ?.let { Tool(codeInterpreter = it, _json = json) }
                            ?.takeIf { it.isValid() } ?: Tool(_json = json)
                    }
                    "shell" -> {
                        return tryDeserialize(node, jacksonTypeRef<Shell>())?.let {
                            Tool(shell = it, _json = json)
                        } ?: Tool(_json = json)
                    }
                    "image_generation" -> {
                        return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                            ?.let { Tool(imageGeneration = it, _json = json) }
                            ?.takeIf { it.isValid() } ?: Tool(_json = json)
                    }
                    "mcp" -> {
                        return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                            ?.let { Tool(mcp = it, _json = json) }
                            ?.takeIf { it.isValid() } ?: Tool(_json = json)
                    }
                    "custom" -> {
                        return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                            ?.let { Tool(custom = it, _json = json) }
                            ?.takeIf { it.isValid() } ?: Tool(_json = json)
                    }
                    "namespace" -> {
                        return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                            ?.let { Tool(namespace = it, _json = json) }
                            ?.takeIf { it.isValid() } ?: Tool(_json = json)
                    }
                    "tool_search" -> {
                        return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                            ?.let { Tool(search = it, _json = json) }
                            ?.takeIf { it.isValid() } ?: Tool(_json = json)
                    }
                    "programmatic_tool_calling" -> {
                        return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                            ?.let { Tool(programmaticToolCalling = it, _json = json) }
                            ?.takeIf { it.isValid() } ?: Tool(_json = json)
                    }
                    "computer" -> {
                        return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                            ?.let { Tool(computer = it, _json = json) }
                            ?.takeIf { it.isValid() } ?: Tool(_json = json)
                    }
                    "apply_patch" -> {
                        return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                            ?.let { Tool(applyPatch = it, _json = json) }
                            ?.takeIf { it.isValid() } ?: Tool(_json = json)
                    }
                }

                return Tool(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Tool>(Tool::class) {

            override fun serialize(
                value: Tool,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.function != null -> generator.writeObject(value.function)
                    value.webSearch != null -> generator.writeObject(value.webSearch)
                    value.fileSearch != null -> generator.writeObject(value.fileSearch)
                    value.codeInterpreter != null -> generator.writeObject(value.codeInterpreter)
                    value.shell != null -> generator.writeObject(value.shell)
                    value.imageGeneration != null -> generator.writeObject(value.imageGeneration)
                    value.mcp != null -> generator.writeObject(value.mcp)
                    value.custom != null -> generator.writeObject(value.custom)
                    value.namespace != null -> generator.writeObject(value.namespace)
                    value.search != null -> generator.writeObject(value.search)
                    value.programmaticToolCalling != null ->
                        generator.writeObject(value.programmaticToolCalling)
                    value.computer != null -> generator.writeObject(value.computer)
                    value.applyPatch != null -> generator.writeObject(value.applyPatch)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Tool")
                }
            }
        }

        /**
         * A Responses shell tool. Use a hosted container or return local shell results with
         * response.item.create. Domain secrets are not supported.
         */
        class Shell
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val type: JsonValue,
            private val environment: JsonField<Environment>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("environment")
                @ExcludeMissing
                environment: JsonField<Environment> = JsonMissing.of(),
            ) : this(type, environment, mutableMapOf())

            /**
             * The schema requires this property. Returns empty if the JSON property is missing or
             * null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun type(): java.util.Optional<JsonValue> {
                val raw = type
                return when {
                    raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                    !(raw == JsonValue.from("shell")) ->
                        throw OpenAIInvalidDataException("`type` is invalid")
                    else -> java.util.Optional.of(raw)
                }
            }

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

            /**
             * Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun environment(): java.util.Optional<Environment> =
                environment.getOptional("environment")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun environmentOrThrow(): Environment = environment.getRequired("environment")

            /**
             * Returns the raw JSON value of [environment].
             *
             * Unlike [environment], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("environment")
            @ExcludeMissing
            fun _environment(): JsonField<Environment> = environment

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            /**
             * Returns an immutable snapshot of all present JSON properties, including declared and
             * additional properties.
             *
             * Keys use their JSON names. Declared properties take precedence over additional
             * properties with the same name. Missing properties are omitted, while explicit nulls
             * and unrecognized values are preserved.
             */
            fun _allProperties(): Map<String, JsonValue> =
                collectAllProperties(
                    additionalProperties,
                    "type" to this.type,
                    "environment" to this.environment,
                )

            @JvmSynthetic
            internal fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            @JsonAnyGetter
            @ExcludeMissing
            private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [Shell]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Shell]. */
            class Builder internal constructor() {

                private var type: JsonValue = JsonValue.from("shell")
                private var environment: JsonField<Environment> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(shell: Shell) = apply {
                    type = shell.type
                    environment = shell.environment
                    additionalProperties = shell.additionalProperties.toMutableMap()
                }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("shell")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                fun environment(environment: Environment?) =
                    environment(JsonField.ofNullable(environment))

                /** Alias for calling [Builder.environment] with `environment.orElse(null)`. */
                fun environment(environment: Optional<Environment>) =
                    environment(environment.getOrNull())

                /**
                 * Sets [Builder.environment] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.environment] with a well-typed [Environment]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun environment(environment: JsonField<Environment>) = apply {
                    this.environment = environment
                }

                /**
                 * Alias for calling [environment] with
                 * `Environment.ofContainerAuto(containerAuto)`.
                 */
                fun environment(containerAuto: Environment.ContainerAuto) =
                    environment(Environment.ofContainerAuto(containerAuto))

                /**
                 * Alias for calling [environment] with
                 * `Environment.ofContainerReference(containerReference)`.
                 */
                fun environment(containerReference: Environment.ContainerReference) =
                    environment(Environment.ofContainerReference(containerReference))

                /**
                 * Alias for calling [environment] with the following:
                 * ```java
                 * Environment.ContainerReference.builder()
                 *     .containerId(containerId)
                 *     .build()
                 * ```
                 */
                fun containerReferenceEnvironment(containerId: String) =
                    environment(
                        Environment.ContainerReference.builder().containerId(containerId).build()
                    )

                /** Alias for calling [environment] with `Environment.ofLocal(local)`. */
                fun environment(local: Environment.Local) = environment(Environment.ofLocal(local))

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Shell].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Shell = Shell(type, environment, additionalProperties.toMutableMap())
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
            fun validate(): Shell = apply {
                if (validated) {
                    return@apply
                }

                typeOrThrow()
                environment().ifPresent { it.validate() }
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
                type.let { if (it == JsonValue.from("shell")) 1 else 0 } +
                    (environment.asKnown().getOrNull()?.validity() ?: 0)

            @JsonDeserialize(using = Environment.Deserializer::class)
            @JsonSerialize(using = Environment.Serializer::class)
            class Environment
            private constructor(
                private val containerAuto: ContainerAuto? = null,
                private val containerReference: ContainerReference? = null,
                private val local: Local? = null,
                private val _json: JsonValue? = null,
            ) {

                fun containerAuto(): Optional<ContainerAuto> = Optional.ofNullable(containerAuto)

                fun containerReference(): Optional<ContainerReference> =
                    Optional.ofNullable(containerReference)

                fun local(): Optional<Local> = Optional.ofNullable(local)

                fun isContainerAuto(): Boolean = containerAuto != null

                fun isContainerReference(): Boolean = containerReference != null

                fun isLocal(): Boolean = local != null

                fun asContainerAuto(): ContainerAuto = containerAuto.getOrThrow("containerAuto")

                fun asContainerReference(): ContainerReference =
                    containerReference.getOrThrow("containerReference")

                fun asLocal(): Local = local.getOrThrow("local")

                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                /**
                 * Maps this instance's current variant to a value of type [T] using the given
                 * [visitor].
                 *
                 * Note that this method is _not_ forwards compatible with new variants from the
                 * API, unless [visitor] overrides [Visitor.unknown]. To handle variants not known
                 * to this version of the SDK gracefully, consider overriding [Visitor.unknown]:
                 * ```java
                 * import com.openai.core.JsonValue;
                 * import java.util.Optional;
                 *
                 * Optional<String> result = environment.accept(new Environment.Visitor<Optional<String>>() {
                 *     @Override
                 *     public Optional<String> visitContainerAuto(ContainerAuto containerAuto) {
                 *         return Optional.of(containerAuto.toString());
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
                 * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in
                 *   [visitor] and the current variant is unknown.
                 */
                fun <T> accept(visitor: Visitor<T>): T =
                    when {
                        containerAuto != null -> visitor.visitContainerAuto(containerAuto)
                        containerReference != null ->
                            visitor.visitContainerReference(containerReference)
                        local != null -> visitor.visitLocal(local)
                        else -> visitor.unknown(_json)
                    }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Environment = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitContainerAuto(containerAuto: ContainerAuto) {
                                containerAuto.validate()
                            }

                            override fun visitContainerReference(
                                containerReference: ContainerReference
                            ) {
                                containerReference.validate()
                            }

                            override fun visitLocal(local: Local) {
                                local.validate()
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
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
                 *
                 * Used for best match union deserialization.
                 */
                @JvmSynthetic
                internal fun validity(): Int =
                    accept(
                        object : Visitor<Int> {
                            override fun visitContainerAuto(containerAuto: ContainerAuto) =
                                containerAuto.validity()

                            override fun visitContainerReference(
                                containerReference: ContainerReference
                            ) = containerReference.validity()

                            override fun visitLocal(local: Local) = local.validity()

                            override fun unknown(json: JsonValue?) = 0
                        }
                    )

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Environment &&
                        containerAuto == other.containerAuto &&
                        containerReference == other.containerReference &&
                        local == other.local &&
                        (containerAuto != null ||
                            containerReference != null ||
                            local != null ||
                            _json == other._json)
                }

                override fun hashCode(): Int =
                    if (containerAuto == null && containerReference == null && local == null)
                        Objects.hash(_json)
                    else Objects.hash(containerAuto, containerReference, local)

                override fun toString(): String =
                    when {
                        containerAuto != null -> "Environment{containerAuto=$containerAuto}"
                        containerReference != null ->
                            "Environment{containerReference=$containerReference}"
                        local != null -> "Environment{local=$local}"
                        _json != null -> "Environment{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid Environment")
                    }

                companion object {

                    @JvmStatic
                    fun ofContainerAuto(containerAuto: ContainerAuto) =
                        Environment(containerAuto = containerAuto)

                    @JvmStatic
                    fun ofContainerReference(containerReference: ContainerReference) =
                        Environment(containerReference = containerReference)

                    @JvmStatic fun ofLocal(local: Local) = Environment(local = local)
                }

                /**
                 * An interface that defines how to map each variant of [Environment] to a value of
                 * type [T].
                 */
                interface Visitor<out T> {

                    fun visitContainerAuto(containerAuto: ContainerAuto): T =
                        unknown(JsonValue.from(containerAuto))

                    fun visitContainerReference(containerReference: ContainerReference): T =
                        unknown(JsonValue.from(containerReference))

                    fun visitLocal(local: Local): T = unknown(JsonValue.from(local))

                    /**
                     * Maps an unknown variant of [Environment] to a value of type [T].
                     *
                     * An instance of [Environment] can contain an unknown variant if it was
                     * deserialized from data that doesn't match any known variant. For example, if
                     * the SDK is on an older version than the API, then the API may respond with
                     * new variants that the SDK is unaware of.
                     *
                     * Unhandled known JSON variants reach this method as JSON values.
                     *
                     * @throws OpenAIInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw OpenAIInvalidDataException("Unknown Environment")
                    }
                }

                internal class Deserializer : BaseDeserializer<Environment>(Environment::class) {

                    override fun ObjectCodec.deserialize(node: JsonNode): Environment {
                        val json = JsonValue.fromJsonNode(node)
                        val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                        when (type) {
                            "container_auto" -> {
                                return tryDeserialize(node, jacksonTypeRef<ContainerAuto>())?.let {
                                    Environment(containerAuto = it, _json = json)
                                } ?: Environment(_json = json)
                            }
                            "container_reference" -> {
                                return tryDeserialize(node, jacksonTypeRef<ContainerReference>())
                                    ?.let { Environment(containerReference = it, _json = json) }
                                    ?: Environment(_json = json)
                            }
                            "local" -> {
                                return tryDeserialize(node, jacksonTypeRef<Local>())?.let {
                                    Environment(local = it, _json = json)
                                } ?: Environment(_json = json)
                            }
                        }

                        return Environment(_json = json)
                    }
                }

                internal class Serializer : BaseSerializer<Environment>(Environment::class) {

                    override fun serialize(
                        value: Environment,
                        generator: JsonGenerator,
                        provider: SerializerProvider,
                    ) {
                        when {
                            value.containerAuto != null ->
                                generator.writeObject(value.containerAuto)
                            value.containerReference != null ->
                                generator.writeObject(value.containerReference)
                            value.local != null -> generator.writeObject(value.local)
                            value._json != null -> generator.writeObject(value._json)
                            else -> throw IllegalStateException("Invalid Environment")
                        }
                    }
                }

                class ContainerAuto
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val type: JsonValue,
                    private val fileIds: JsonField<List<String>>,
                    private val memoryLimit: JsonField<MemoryLimit>,
                    private val networkPolicy: JsonField<NetworkPolicy>,
                    private val skills: JsonField<List<Skill>>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                        @JsonProperty("file_ids")
                        @ExcludeMissing
                        fileIds: JsonField<List<String>> = JsonMissing.of(),
                        @JsonProperty("memory_limit")
                        @ExcludeMissing
                        memoryLimit: JsonField<MemoryLimit> = JsonMissing.of(),
                        @JsonProperty("network_policy")
                        @ExcludeMissing
                        networkPolicy: JsonField<NetworkPolicy> = JsonMissing.of(),
                        @JsonProperty("skills")
                        @ExcludeMissing
                        skills: JsonField<List<Skill>> = JsonMissing.of(),
                    ) : this(type, fileIds, memoryLimit, networkPolicy, skills, mutableMapOf())

                    /**
                     * Automatically creates a container for this request The schema requires this
                     * property. Returns empty if the JSON property is missing or null.
                     *
                     * @throws OpenAIInvalidDataException if the value has an unexpected type.
                     */
                    fun type(): java.util.Optional<JsonValue> {
                        val raw = type
                        return when {
                            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                            !(raw == JsonValue.from("container_auto")) ->
                                throw OpenAIInvalidDataException("`type` is invalid")
                            else -> java.util.Optional.of(raw)
                        }
                    }

                    /**
                     * Returns the value or throws [OpenAIInvalidDataException] if it is missing,
                     * null, or invalid.
                     */
                    fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

                    /**
                     * An optional list of uploaded files to make available to your code. Returns
                     * empty if the JSON property is missing or null.
                     *
                     * @throws OpenAIInvalidDataException if the value has an unexpected type.
                     */
                    fun fileIds(): java.util.Optional<List<String>> =
                        fileIds.getOptional("file_ids")

                    /**
                     * Returns the value or throws [OpenAIInvalidDataException] if it is missing,
                     * null, or invalid.
                     */
                    fun fileIdsOrThrow(): List<String> = fileIds.getRequired("file_ids")

                    /**
                     * The memory limit for the container. Returns empty if the JSON property is
                     * missing or null.
                     *
                     * @throws OpenAIInvalidDataException if the value has an unexpected type.
                     */
                    fun memoryLimit(): java.util.Optional<MemoryLimit> =
                        memoryLimit.getOptional("memory_limit")

                    /**
                     * Returns the value or throws [OpenAIInvalidDataException] if it is missing,
                     * null, or invalid.
                     */
                    fun memoryLimitOrThrow(): MemoryLimit = memoryLimit.getRequired("memory_limit")

                    /**
                     * Network access policy for the container. Returns empty if the JSON property
                     * is missing or null.
                     *
                     * @throws OpenAIInvalidDataException if the value has an unexpected type.
                     */
                    fun networkPolicy(): java.util.Optional<NetworkPolicy> =
                        networkPolicy.getOptional("network_policy")

                    /**
                     * Returns the value or throws [OpenAIInvalidDataException] if it is missing,
                     * null, or invalid.
                     */
                    fun networkPolicyOrThrow(): NetworkPolicy =
                        networkPolicy.getRequired("network_policy")

                    /**
                     * An optional list of skills referenced by id or inline data. Returns empty if
                     * the JSON property is missing or null.
                     *
                     * @throws OpenAIInvalidDataException if the value has an unexpected type.
                     */
                    fun skills(): java.util.Optional<List<Skill>> = skills.getOptional("skills")

                    /**
                     * Returns the value or throws [OpenAIInvalidDataException] if it is missing,
                     * null, or invalid.
                     */
                    fun skillsOrThrow(): List<Skill> = skills.getRequired("skills")

                    /**
                     * Returns the raw JSON value of [fileIds].
                     *
                     * Unlike [fileIds], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("file_ids")
                    @ExcludeMissing
                    fun _fileIds(): JsonField<List<String>> = fileIds

                    /**
                     * Returns the raw JSON value of [memoryLimit].
                     *
                     * Unlike [memoryLimit], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("memory_limit")
                    @ExcludeMissing
                    fun _memoryLimit(): JsonField<MemoryLimit> = memoryLimit

                    /**
                     * Returns the raw JSON value of [networkPolicy].
                     *
                     * Unlike [networkPolicy], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("network_policy")
                    @ExcludeMissing
                    fun _networkPolicy(): JsonField<NetworkPolicy> = networkPolicy

                    /**
                     * Returns the raw JSON value of [skills].
                     *
                     * Unlike [skills], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("skills")
                    @ExcludeMissing
                    fun _skills(): JsonField<List<Skill>> = skills

                    @JsonAnySetter
                    private fun putAdditionalProperty(key: String, value: JsonValue) {
                        additionalProperties.put(key, value)
                    }

                    /**
                     * Returns an immutable snapshot of all present JSON properties, including
                     * declared and additional properties.
                     *
                     * Keys use their JSON names. Declared properties take precedence over
                     * additional properties with the same name. Missing properties are omitted,
                     * while explicit nulls and unrecognized values are preserved.
                     */
                    fun _allProperties(): Map<String, JsonValue> =
                        collectAllProperties(
                            additionalProperties,
                            "type" to this.type,
                            "file_ids" to this.fileIds,
                            "memory_limit" to this.memoryLimit,
                            "network_policy" to this.networkPolicy,
                            "skills" to this.skills,
                        )

                    @JvmSynthetic
                    internal fun _additionalProperties(): Map<String, JsonValue> =
                        Collections.unmodifiableMap(additionalProperties)

                    @JsonAnyGetter
                    @ExcludeMissing
                    private fun additionalProperties(): Map<String, JsonValue> =
                        additionalProperties

                    fun toBuilder() = Builder().from(this)

                    companion object {

                        /**
                         * Returns a mutable builder for constructing an instance of
                         * [ContainerAuto].
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [ContainerAuto]. */
                    class Builder internal constructor() {

                        private var type: JsonValue = JsonValue.from("container_auto")
                        private var fileIds: JsonField<MutableList<String>>? = null
                        private var memoryLimit: JsonField<MemoryLimit> = JsonMissing.of()
                        private var networkPolicy: JsonField<NetworkPolicy> = JsonMissing.of()
                        private var skills: JsonField<MutableList<Skill>>? = null
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(containerAuto: ContainerAuto) = apply {
                            type = containerAuto.type
                            fileIds = containerAuto.fileIds.map { it.toMutableList() }
                            memoryLimit = containerAuto.memoryLimit
                            networkPolicy = containerAuto.networkPolicy
                            skills = containerAuto.skills.map { it.toMutableList() }
                            additionalProperties = containerAuto.additionalProperties.toMutableMap()
                        }

                        /**
                         * Sets the field to an arbitrary JSON value.
                         *
                         * It is usually unnecessary to call this method because the field defaults
                         * to the following:
                         * ```java
                         * JsonValue.from("container_auto")
                         * ```
                         *
                         * This method is primarily for setting the field to an undocumented or not
                         * yet supported value.
                         */
                        fun type(type: JsonValue) = apply { this.type = type }

                        /** An optional list of uploaded files to make available to your code. */
                        fun fileIds(fileIds: List<String>?) = fileIds(JsonField.ofNullable(fileIds))

                        /** Alias for calling [Builder.fileIds] with `fileIds.orElse(null)`. */
                        fun fileIds(fileIds: Optional<List<String>>) = fileIds(fileIds.getOrNull())

                        /**
                         * Sets [Builder.fileIds] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.fileIds] with a well-typed
                         * `List<String>` value instead. This method is primarily for setting the
                         * field to an undocumented or not yet supported value.
                         */
                        fun fileIds(fileIds: JsonField<List<String>>) = apply {
                            this.fileIds = fileIds.map { it.toMutableList() }
                        }

                        /**
                         * Adds a single [String] to [fileIds].
                         *
                         * @throws IllegalStateException if the field was previously set to a
                         *   non-list.
                         */
                        fun addFileId(fileId: String) = apply {
                            fileIds =
                                (fileIds?.takeUnless { it.isMissing() }
                                        ?: JsonField.of(mutableListOf()))
                                    .also { checkKnown("fileIds", it).add(fileId) }
                        }

                        /** The memory limit for the container. */
                        fun memoryLimit(memoryLimit: MemoryLimit?) =
                            memoryLimit(JsonField.ofNullable(memoryLimit))

                        /**
                         * Alias for calling [Builder.memoryLimit] with `memoryLimit.orElse(null)`.
                         */
                        fun memoryLimit(memoryLimit: Optional<MemoryLimit>) =
                            memoryLimit(memoryLimit.getOrNull())

                        /**
                         * Sets [Builder.memoryLimit] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.memoryLimit] with a well-typed
                         * [MemoryLimit] value instead. This method is primarily for setting the
                         * field to an undocumented or not yet supported value.
                         */
                        fun memoryLimit(memoryLimit: JsonField<MemoryLimit>) = apply {
                            this.memoryLimit = memoryLimit
                        }

                        /** Network access policy for the container. */
                        fun networkPolicy(networkPolicy: NetworkPolicy?) =
                            networkPolicy(JsonField.ofNullable(networkPolicy))

                        /**
                         * Alias for calling [Builder.networkPolicy] with
                         * `networkPolicy.orElse(null)`.
                         */
                        fun networkPolicy(networkPolicy: Optional<NetworkPolicy>) =
                            networkPolicy(networkPolicy.getOrNull())

                        /**
                         * Sets [Builder.networkPolicy] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.networkPolicy] with a well-typed
                         * [NetworkPolicy] value instead. This method is primarily for setting the
                         * field to an undocumented or not yet supported value.
                         */
                        fun networkPolicy(networkPolicy: JsonField<NetworkPolicy>) = apply {
                            this.networkPolicy = networkPolicy
                        }

                        /** Alias for calling [networkPolicy] with `NetworkPolicy.ofDisabled()`. */
                        fun networkPolicyDisabled() = networkPolicy(NetworkPolicy.ofDisabled())

                        /**
                         * Alias for calling [networkPolicy] with
                         * `NetworkPolicy.ofAllowlist(allowlist)`.
                         */
                        fun networkPolicy(allowlist: NetworkPolicy.Allowlist) =
                            networkPolicy(NetworkPolicy.ofAllowlist(allowlist))

                        /**
                         * Alias for calling [networkPolicy] with the following:
                         * ```java
                         * NetworkPolicy.Allowlist.builder()
                         *     .allowedDomains(allowedDomains)
                         *     .build()
                         * ```
                         */
                        fun allowlistNetworkPolicy(allowedDomains: List<String>) =
                            networkPolicy(
                                NetworkPolicy.Allowlist.builder()
                                    .allowedDomains(allowedDomains)
                                    .build()
                            )

                        /** An optional list of skills referenced by id or inline data. */
                        fun skills(skills: List<Skill>?) = skills(JsonField.ofNullable(skills))

                        /** Alias for calling [Builder.skills] with `skills.orElse(null)`. */
                        fun skills(skills: Optional<List<Skill>>) = skills(skills.getOrNull())

                        /**
                         * Sets [Builder.skills] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.skills] with a well-typed `List<Skill>`
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun skills(skills: JsonField<List<Skill>>) = apply {
                            this.skills = skills.map { it.toMutableList() }
                        }

                        /**
                         * Adds a single [Skill] to [skills].
                         *
                         * @throws IllegalStateException if the field was previously set to a
                         *   non-list.
                         */
                        fun addSkill(skill: Skill) = apply {
                            skills =
                                (skills?.takeUnless { it.isMissing() }
                                        ?: JsonField.of(mutableListOf()))
                                    .also { checkKnown("skills", it).add(skill) }
                        }

                        /** Alias for calling [addSkill] with `Skill.ofReference(reference)`. */
                        fun addSkill(reference: Skill.SkillReference) =
                            addSkill(Skill.ofReference(reference))

                        /**
                         * Alias for calling [addSkill] with the following:
                         * ```java
                         * Skill.SkillReference.builder()
                         *     .skillId(skillId)
                         *     .build()
                         * ```
                         */
                        fun addReferenceSkill(skillId: String) =
                            addSkill(Skill.SkillReference.builder().skillId(skillId).build())

                        /** Alias for calling [addSkill] with `Skill.ofInline(inline)`. */
                        fun addSkill(inline: Skill.Inline) = addSkill(Skill.ofInline(inline))

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [ContainerAuto].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): ContainerAuto =
                            ContainerAuto(
                                type,
                                (fileIds ?: JsonMissing.of()).map { it.toImmutable() },
                                memoryLimit,
                                networkPolicy,
                                (skills ?: JsonMissing.of()).map { it.toImmutable() },
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws OpenAIInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): ContainerAuto = apply {
                        if (validated) {
                            return@apply
                        }

                        typeOrThrow()
                        fileIds()
                        memoryLimit().ifPresent { it.validate() }
                        networkPolicy().ifPresent { it.validate() }
                        skills().ifPresent { it.forEach { it.validate() } }
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
                        type.let { if (it == JsonValue.from("container_auto")) 1 else 0 } +
                            (fileIds.asKnown().getOrNull()?.size ?: 0) +
                            (memoryLimit.asKnown().getOrNull()?.validity() ?: 0) +
                            (networkPolicy.asKnown().getOrNull()?.validity() ?: 0) +
                            (skills.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

                    /** The memory limit for the container. */
                    class MemoryLimit
                    @JsonCreator
                    private constructor(private val value: JsonField<String>) : Enum {

                        /**
                         * Returns this class instance's raw value.
                         *
                         * This is usually only useful if this instance was deserialized from data
                         * that doesn't match any known member, and you want to know that value. For
                         * example, if the SDK is on an older version than the API, then the API may
                         * respond with new members that the SDK is unaware of.
                         */
                        @com.fasterxml.jackson.annotation.JsonValue
                        fun _value(): JsonField<String> = value

                        companion object {

                            @JvmField val _1G = of("1g")

                            @JvmField val _4G = of("4g")

                            @JvmField val _16G = of("16g")

                            @JvmField val _64G = of("64g")

                            @JvmStatic fun of(value: String) = MemoryLimit(JsonField.of(value))
                        }

                        /** An enum containing [MemoryLimit]'s known values. */
                        @Deprecated("Use asString() for string values or _value() for raw JSON.")
                        enum class Known {
                            _1G,
                            _4G,
                            _16G,
                            _64G,
                        }

                        /**
                         * An enum containing [MemoryLimit]'s known values, as well as an [_UNKNOWN]
                         * member.
                         *
                         * An instance of [MemoryLimit] can contain an unknown value in a couple of
                         * cases:
                         * - It was deserialized from data that doesn't match any known member. For
                         *   example, if the SDK is on an older version than the API, then the API
                         *   may respond with new members that the SDK is unaware of.
                         * - It was constructed with an arbitrary value using the [of] method.
                         */
                        @Deprecated("Use asString() for string values or _value() for raw JSON.")
                        enum class Value {
                            _1G,
                            _4G,
                            _16G,
                            _64G,
                            /**
                             * An enum member indicating that [MemoryLimit] was instantiated with an
                             * unknown value.
                             */
                            _UNKNOWN,
                        }

                        /**
                         * Returns an enum member corresponding to this class instance's value, or
                         * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                         *
                         * Use the [known] method instead if you're certain the value is always
                         * known or if you want to throw for the unknown case.
                         */
                        @Deprecated("Use asString() for string values or _value() for raw JSON.")
                        fun value(): Value =
                            when (this) {
                                _1G -> Value._1G
                                _4G -> Value._4G
                                _16G -> Value._16G
                                _64G -> Value._64G
                                else -> Value._UNKNOWN
                            }

                        /**
                         * Returns an enum member corresponding to this class instance's value.
                         *
                         * Use the [value] method instead if you're uncertain the value is always
                         * known and don't want to throw for the unknown case.
                         *
                         * @throws OpenAIInvalidDataException if this class instance's value is a
                         *   not a known member.
                         */
                        @Deprecated("Use asString() for string values or _value() for raw JSON.")
                        fun known(): Known =
                            when (this) {
                                _1G -> Known._1G
                                _4G -> Known._4G
                                _16G -> Known._16G
                                _64G -> Known._64G
                                else ->
                                    throw OpenAIInvalidDataException("Unknown MemoryLimit: $value")
                            }

                        /**
                         * Returns this class instance's primitive wire representation.
                         *
                         * This differs from the [toString] method because that method is primarily
                         * for debugging and generally doesn't throw.
                         *
                         * @throws OpenAIInvalidDataException if this class instance's value does
                         *   not have the expected primitive type.
                         */
                        fun asString(): String =
                            _value().asString().orElseThrow {
                                OpenAIInvalidDataException("Value is not a String")
                            }

                        private var validated: Boolean = false

                        /**
                         * Validates that the types of all values in this object match their
                         * expected types recursively.
                         *
                         * This method is _not_ forwards compatible with new types from the API for
                         * existing fields.
                         *
                         * @throws OpenAIInvalidDataException if any value type in this object
                         *   doesn't match its expected type.
                         */
                        fun validate(): MemoryLimit = apply {
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is MemoryLimit && value == other.value
                        }

                        override fun hashCode() = value.hashCode()

                        override fun toString() = value.toString()
                    }

                    /** Network access policy for the container. */
                    @JsonDeserialize(using = NetworkPolicy.Deserializer::class)
                    @JsonSerialize(using = NetworkPolicy.Serializer::class)
                    class NetworkPolicy
                    private constructor(
                        private val disabled: JsonValue? = null,
                        private val allowlist: Allowlist? = null,
                        private val _json: JsonValue? = null,
                    ) {

                        fun disabled(): Optional<JsonValue> = Optional.ofNullable(disabled)

                        fun allowlist(): Optional<Allowlist> = Optional.ofNullable(allowlist)

                        fun isDisabled(): Boolean = disabled != null

                        fun isAllowlist(): Boolean = allowlist != null

                        fun asDisabled(): JsonValue = disabled.getOrThrow("disabled")

                        fun asAllowlist(): Allowlist = allowlist.getOrThrow("allowlist")

                        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                        /**
                         * Maps this instance's current variant to a value of type [T] using the
                         * given [visitor].
                         *
                         * Note that this method is _not_ forwards compatible with new variants from
                         * the API, unless [visitor] overrides [Visitor.unknown]. To handle variants
                         * not known to this version of the SDK gracefully, consider overriding
                         * [Visitor.unknown]:
                         * ```java
                         * import com.openai.core.JsonValue;
                         * import java.util.Optional;
                         *
                         * Optional<String> result = networkPolicy.accept(new NetworkPolicy.Visitor<Optional<String>>() {
                         *     @Override
                         *     public Optional<String> visitDisabled(JsonValue disabled) {
                         *         return Optional.of(disabled.toString());
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
                         * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden
                         *   in [visitor] and the current variant is unknown.
                         */
                        fun <T> accept(visitor: Visitor<T>): T =
                            when {
                                disabled != null -> visitor.visitDisabled(disabled)
                                allowlist != null -> visitor.visitAllowlist(allowlist)
                                else -> visitor.unknown(_json)
                            }

                        private var validated: Boolean = false

                        /**
                         * Validates that the types of all values in this object match their
                         * expected types recursively.
                         *
                         * This method is _not_ forwards compatible with new types from the API for
                         * existing fields.
                         *
                         * @throws OpenAIInvalidDataException if any value type in this object
                         *   doesn't match its expected type.
                         */
                        fun validate(): NetworkPolicy = apply {
                            if (validated) {
                                return@apply
                            }

                            accept(
                                object : Visitor<Unit> {
                                    override fun visitDisabled(disabled: JsonValue) {
                                        disabled.let {
                                            if (it != JsonValue.from(mapOf("type" to "disabled"))) {
                                                throw OpenAIInvalidDataException(
                                                    "'disabled' is invalid, received $it"
                                                )
                                            }
                                        }
                                    }

                                    override fun visitAllowlist(allowlist: Allowlist) {
                                        allowlist.validate()
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int =
                            accept(
                                object : Visitor<Int> {
                                    override fun visitDisabled(disabled: JsonValue) =
                                        disabled.let {
                                            if (it == JsonValue.from(mapOf("type" to "disabled"))) 1
                                            else 0
                                        }

                                    override fun visitAllowlist(allowlist: Allowlist) =
                                        allowlist.validity()

                                    override fun unknown(json: JsonValue?) = 0
                                }
                            )

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is NetworkPolicy &&
                                disabled == other.disabled &&
                                allowlist == other.allowlist &&
                                (disabled != null || allowlist != null || _json == other._json)
                        }

                        override fun hashCode(): Int =
                            if (disabled == null && allowlist == null) Objects.hash(_json)
                            else Objects.hash(disabled, allowlist)

                        override fun toString(): String =
                            when {
                                disabled != null -> "NetworkPolicy{disabled=$disabled}"
                                allowlist != null -> "NetworkPolicy{allowlist=$allowlist}"
                                _json != null -> "NetworkPolicy{_unknown=$_json}"
                                else -> throw IllegalStateException("Invalid NetworkPolicy")
                            }

                        companion object {

                            @JvmStatic
                            fun ofDisabled() =
                                NetworkPolicy(
                                    disabled = JsonValue.from(mapOf("type" to "disabled"))
                                )

                            @JvmStatic
                            fun ofAllowlist(allowlist: Allowlist) =
                                NetworkPolicy(allowlist = allowlist)
                        }

                        /**
                         * An interface that defines how to map each variant of [NetworkPolicy] to a
                         * value of type [T].
                         */
                        interface Visitor<out T> {

                            fun visitDisabled(disabled: JsonValue): T =
                                unknown(JsonValue.from(disabled))

                            fun visitAllowlist(allowlist: Allowlist): T =
                                unknown(JsonValue.from(allowlist))

                            /**
                             * Maps an unknown variant of [NetworkPolicy] to a value of type [T].
                             *
                             * An instance of [NetworkPolicy] can contain an unknown variant if it
                             * was deserialized from data that doesn't match any known variant. For
                             * example, if the SDK is on an older version than the API, then the API
                             * may respond with new variants that the SDK is unaware of.
                             *
                             * Unhandled known JSON variants reach this method as JSON values.
                             *
                             * @throws OpenAIInvalidDataException in the default implementation.
                             */
                            fun unknown(json: JsonValue?): T {
                                throw OpenAIInvalidDataException("Unknown NetworkPolicy")
                            }
                        }

                        internal class Deserializer :
                            BaseDeserializer<NetworkPolicy>(NetworkPolicy::class) {

                            override fun ObjectCodec.deserialize(node: JsonNode): NetworkPolicy {
                                val json = JsonValue.fromJsonNode(node)
                                val type =
                                    json
                                        .asObject()
                                        .getOrNull()
                                        ?.get("type")
                                        ?.asString()
                                        ?.getOrNull()

                                when (type) {
                                    "disabled" -> {
                                        return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                            ?.let { NetworkPolicy(disabled = it, _json = json) }
                                            ?.takeIf { it.isValid() } ?: NetworkPolicy(_json = json)
                                    }
                                    "allowlist" -> {
                                        return tryDeserialize(node, jacksonTypeRef<Allowlist>())
                                            ?.let { NetworkPolicy(allowlist = it, _json = json) }
                                            ?: NetworkPolicy(_json = json)
                                    }
                                }

                                return NetworkPolicy(_json = json)
                            }
                        }

                        internal class Serializer :
                            BaseSerializer<NetworkPolicy>(NetworkPolicy::class) {

                            override fun serialize(
                                value: NetworkPolicy,
                                generator: JsonGenerator,
                                provider: SerializerProvider,
                            ) {
                                when {
                                    value.disabled != null -> generator.writeObject(value.disabled)
                                    value.allowlist != null ->
                                        generator.writeObject(value.allowlist)
                                    value._json != null -> generator.writeObject(value._json)
                                    else -> throw IllegalStateException("Invalid NetworkPolicy")
                                }
                            }
                        }

                        class Allowlist
                        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                        private constructor(
                            private val allowedDomains: JsonField<List<String>>,
                            private val type: JsonValue,
                            private val additionalProperties: MutableMap<String, JsonValue>,
                        ) {

                            @JsonCreator
                            private constructor(
                                @JsonProperty("allowed_domains")
                                @ExcludeMissing
                                allowedDomains: JsonField<List<String>> = JsonMissing.of(),
                                @JsonProperty("type")
                                @ExcludeMissing
                                type: JsonValue = JsonMissing.of(),
                            ) : this(allowedDomains, type, mutableMapOf())

                            /**
                             * A list of allowed domains when type is `allowlist`. The schema
                             * requires this property. Returns empty if the JSON property is missing
                             * or null.
                             *
                             * @throws OpenAIInvalidDataException if the value has an unexpected
                             *   type.
                             */
                            fun allowedDomains(): java.util.Optional<List<String>> =
                                allowedDomains.getOptional("allowed_domains")

                            /**
                             * Returns the value or throws [OpenAIInvalidDataException] if it is
                             * missing, null, or invalid.
                             */
                            fun allowedDomainsOrThrow(): List<String> =
                                allowedDomains.getRequired("allowed_domains")

                            /**
                             * Allow outbound network access only to specified domains. Always
                             * `allowlist`. The schema requires this property. Returns empty if the
                             * JSON property is missing or null.
                             *
                             * @throws OpenAIInvalidDataException if the value has an unexpected
                             *   type.
                             */
                            fun type(): java.util.Optional<JsonValue> {
                                val raw = type
                                return when {
                                    raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                                    !(raw == JsonValue.from("allowlist")) ->
                                        throw OpenAIInvalidDataException("`type` is invalid")
                                    else -> java.util.Optional.of(raw)
                                }
                            }

                            /**
                             * Returns the value or throws [OpenAIInvalidDataException] if it is
                             * missing, null, or invalid.
                             */
                            fun typeOrThrow(): JsonValue =
                                type().orElseGet { type.getRequired("type") }

                            @JsonProperty("type")
                            @ExcludeMissing
                            fun _type(): JsonField<JsonValue> = type

                            /**
                             * Returns the raw JSON value of [allowedDomains].
                             *
                             * Unlike [allowedDomains], this method doesn't throw if the JSON field
                             * has an unexpected type.
                             */
                            @JsonProperty("allowed_domains")
                            @ExcludeMissing
                            fun _allowedDomains(): JsonField<List<String>> = allowedDomains

                            @JsonAnySetter
                            private fun putAdditionalProperty(key: String, value: JsonValue) {
                                additionalProperties.put(key, value)
                            }

                            /**
                             * Returns an immutable snapshot of all present JSON properties,
                             * including declared and additional properties.
                             *
                             * Keys use their JSON names. Declared properties take precedence over
                             * additional properties with the same name. Missing properties are
                             * omitted, while explicit nulls and unrecognized values are preserved.
                             */
                            fun _allProperties(): Map<String, JsonValue> =
                                collectAllProperties(
                                    additionalProperties,
                                    "allowed_domains" to this.allowedDomains,
                                    "type" to this.type,
                                )

                            @JvmSynthetic
                            internal fun _additionalProperties(): Map<String, JsonValue> =
                                Collections.unmodifiableMap(additionalProperties)

                            @JsonAnyGetter
                            @ExcludeMissing
                            private fun additionalProperties(): Map<String, JsonValue> =
                                additionalProperties

                            fun toBuilder() = Builder().from(this)

                            companion object {

                                /**
                                 * Returns a mutable builder for constructing an instance of
                                 * [Allowlist].
                                 *
                                 * The following fields are required:
                                 * ```java
                                 * .allowedDomains()
                                 * ```
                                 */
                                @JvmStatic fun builder() = Builder()
                            }

                            /** A builder for [Allowlist]. */
                            class Builder internal constructor() {

                                private var allowedDomains: JsonField<MutableList<String>>? = null
                                private var type: JsonValue = JsonValue.from("allowlist")
                                private var additionalProperties: MutableMap<String, JsonValue> =
                                    mutableMapOf()

                                @JvmSynthetic
                                internal fun from(allowlist: Allowlist) = apply {
                                    allowedDomains =
                                        allowlist.allowedDomains.map { it.toMutableList() }
                                    type = allowlist.type
                                    additionalProperties =
                                        allowlist.additionalProperties.toMutableMap()
                                }

                                /** A list of allowed domains when type is `allowlist`. */
                                fun allowedDomains(allowedDomains: List<String>) =
                                    allowedDomains(JsonField.of(allowedDomains))

                                /**
                                 * Sets [Builder.allowedDomains] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.allowedDomains] with a
                                 * well-typed `List<String>` value instead. This method is primarily
                                 * for setting the field to an undocumented or not yet supported
                                 * value.
                                 */
                                fun allowedDomains(allowedDomains: JsonField<List<String>>) =
                                    apply {
                                        this.allowedDomains =
                                            allowedDomains.map { it.toMutableList() }
                                    }

                                /**
                                 * Adds a single [String] to [allowedDomains].
                                 *
                                 * @throws IllegalStateException if the field was previously set to
                                 *   a non-list.
                                 */
                                fun addAllowedDomain(allowedDomain: String) = apply {
                                    allowedDomains =
                                        (allowedDomains ?: JsonField.of(mutableListOf())).also {
                                            checkKnown("allowedDomains", it).add(allowedDomain)
                                        }
                                }

                                /**
                                 * Sets the field to an arbitrary JSON value.
                                 *
                                 * It is usually unnecessary to call this method because the field
                                 * defaults to the following:
                                 * ```java
                                 * JsonValue.from("allowlist")
                                 * ```
                                 *
                                 * This method is primarily for setting the field to an undocumented
                                 * or not yet supported value.
                                 */
                                fun type(type: JsonValue) = apply { this.type = type }

                                fun additionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                    additionalProperties.put(key, value)
                                }

                                fun putAllAdditionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply { this.additionalProperties.putAll(additionalProperties) }

                                fun removeAdditionalProperty(key: String) = apply {
                                    additionalProperties.remove(key)
                                }

                                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                    keys.forEach(::removeAdditionalProperty)
                                }

                                /**
                                 * Returns an immutable instance of [Allowlist].
                                 *
                                 * Further updates to this [Builder] will not mutate the returned
                                 * instance.
                                 *
                                 * The following fields are required:
                                 * ```java
                                 * .allowedDomains()
                                 * ```
                                 *
                                 * @throws IllegalStateException if any required field is unset.
                                 */
                                fun build(): Allowlist =
                                    Allowlist(
                                        checkRequired("allowedDomains", allowedDomains).map {
                                            it.toImmutable()
                                        },
                                        type,
                                        additionalProperties.toMutableMap(),
                                    )
                            }

                            private var validated: Boolean = false

                            /**
                             * Validates that the types of all values in this object match their
                             * expected types recursively.
                             *
                             * This method is _not_ forwards compatible with new types from the API
                             * for existing fields.
                             *
                             * @throws OpenAIInvalidDataException if any value type in this object
                             *   doesn't match its expected type.
                             */
                            fun validate(): Allowlist = apply {
                                if (validated) {
                                    return@apply
                                }

                                allowedDomainsOrThrow()
                                typeOrThrow()
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
                             * Returns a score indicating how many valid values are contained in
                             * this object recursively.
                             *
                             * Used for best match union deserialization.
                             */
                            @JvmSynthetic
                            internal fun validity(): Int =
                                (allowedDomains.asKnown().getOrNull()?.size ?: 0) +
                                    type.let { if (it == JsonValue.from("allowlist")) 1 else 0 }

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return other is Allowlist &&
                                    allowedDomains == other.allowedDomains &&
                                    type == other.type &&
                                    additionalProperties == other.additionalProperties
                            }

                            private val hashCode: Int by lazy {
                                Objects.hash(allowedDomains, type, additionalProperties)
                            }

                            override fun hashCode(): Int = hashCode

                            override fun toString() =
                                "Allowlist{allowedDomains=$allowedDomains, type=$type, additionalProperties=$additionalProperties}"
                        }
                    }

                    @JsonDeserialize(using = Skill.Deserializer::class)
                    @JsonSerialize(using = Skill.Serializer::class)
                    class Skill
                    private constructor(
                        private val reference: SkillReference? = null,
                        private val inline: Inline? = null,
                        private val _json: JsonValue? = null,
                    ) {

                        fun reference(): Optional<SkillReference> = Optional.ofNullable(reference)

                        fun inline(): Optional<Inline> = Optional.ofNullable(inline)

                        fun isReference(): Boolean = reference != null

                        fun isInline(): Boolean = inline != null

                        fun asReference(): SkillReference = reference.getOrThrow("reference")

                        fun asInline(): Inline = inline.getOrThrow("inline")

                        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                        /**
                         * Maps this instance's current variant to a value of type [T] using the
                         * given [visitor].
                         *
                         * Note that this method is _not_ forwards compatible with new variants from
                         * the API, unless [visitor] overrides [Visitor.unknown]. To handle variants
                         * not known to this version of the SDK gracefully, consider overriding
                         * [Visitor.unknown]:
                         * ```java
                         * import com.openai.core.JsonValue;
                         * import java.util.Optional;
                         *
                         * Optional<String> result = skill.accept(new Skill.Visitor<Optional<String>>() {
                         *     @Override
                         *     public Optional<String> visitReference(SkillReference reference) {
                         *         return Optional.of(reference.toString());
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
                         * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden
                         *   in [visitor] and the current variant is unknown.
                         */
                        fun <T> accept(visitor: Visitor<T>): T =
                            when {
                                reference != null -> visitor.visitReference(reference)
                                inline != null -> visitor.visitInline(inline)
                                else -> visitor.unknown(_json)
                            }

                        private var validated: Boolean = false

                        /**
                         * Validates that the types of all values in this object match their
                         * expected types recursively.
                         *
                         * This method is _not_ forwards compatible with new types from the API for
                         * existing fields.
                         *
                         * @throws OpenAIInvalidDataException if any value type in this object
                         *   doesn't match its expected type.
                         */
                        fun validate(): Skill = apply {
                            if (validated) {
                                return@apply
                            }

                            accept(
                                object : Visitor<Unit> {
                                    override fun visitReference(reference: SkillReference) {
                                        reference.validate()
                                    }

                                    override fun visitInline(inline: Inline) {
                                        inline.validate()
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int =
                            accept(
                                object : Visitor<Int> {
                                    override fun visitReference(reference: SkillReference) =
                                        reference.validity()

                                    override fun visitInline(inline: Inline) = inline.validity()

                                    override fun unknown(json: JsonValue?) = 0
                                }
                            )

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Skill &&
                                reference == other.reference &&
                                inline == other.inline &&
                                (reference != null || inline != null || _json == other._json)
                        }

                        override fun hashCode(): Int =
                            if (reference == null && inline == null) Objects.hash(_json)
                            else Objects.hash(reference, inline)

                        override fun toString(): String =
                            when {
                                reference != null -> "Skill{reference=$reference}"
                                inline != null -> "Skill{inline=$inline}"
                                _json != null -> "Skill{_unknown=$_json}"
                                else -> throw IllegalStateException("Invalid Skill")
                            }

                        companion object {

                            @JvmStatic
                            fun ofReference(reference: SkillReference) =
                                Skill(reference = reference)

                            @JvmStatic fun ofInline(inline: Inline) = Skill(inline = inline)
                        }

                        /**
                         * An interface that defines how to map each variant of [Skill] to a value
                         * of type [T].
                         */
                        interface Visitor<out T> {

                            fun visitReference(reference: SkillReference): T =
                                unknown(JsonValue.from(reference))

                            fun visitInline(inline: Inline): T = unknown(JsonValue.from(inline))

                            /**
                             * Maps an unknown variant of [Skill] to a value of type [T].
                             *
                             * An instance of [Skill] can contain an unknown variant if it was
                             * deserialized from data that doesn't match any known variant. For
                             * example, if the SDK is on an older version than the API, then the API
                             * may respond with new variants that the SDK is unaware of.
                             *
                             * Unhandled known JSON variants reach this method as JSON values.
                             *
                             * @throws OpenAIInvalidDataException in the default implementation.
                             */
                            fun unknown(json: JsonValue?): T {
                                throw OpenAIInvalidDataException("Unknown Skill")
                            }
                        }

                        internal class Deserializer : BaseDeserializer<Skill>(Skill::class) {

                            override fun ObjectCodec.deserialize(node: JsonNode): Skill {
                                val json = JsonValue.fromJsonNode(node)
                                val type =
                                    json
                                        .asObject()
                                        .getOrNull()
                                        ?.get("type")
                                        ?.asString()
                                        ?.getOrNull()

                                when (type) {
                                    "skill_reference" -> {
                                        return tryDeserialize(
                                                node,
                                                jacksonTypeRef<SkillReference>(),
                                            )
                                            ?.let { Skill(reference = it, _json = json) }
                                            ?: Skill(_json = json)
                                    }
                                    "inline" -> {
                                        return tryDeserialize(node, jacksonTypeRef<Inline>())?.let {
                                            Skill(inline = it, _json = json)
                                        } ?: Skill(_json = json)
                                    }
                                }

                                return Skill(_json = json)
                            }
                        }

                        internal class Serializer : BaseSerializer<Skill>(Skill::class) {

                            override fun serialize(
                                value: Skill,
                                generator: JsonGenerator,
                                provider: SerializerProvider,
                            ) {
                                when {
                                    value.reference != null ->
                                        generator.writeObject(value.reference)
                                    value.inline != null -> generator.writeObject(value.inline)
                                    value._json != null -> generator.writeObject(value._json)
                                    else -> throw IllegalStateException("Invalid Skill")
                                }
                            }
                        }

                        class SkillReference
                        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                        private constructor(
                            private val skillId: JsonField<String>,
                            private val type: JsonValue,
                            private val version: JsonField<String>,
                            private val additionalProperties: MutableMap<String, JsonValue>,
                        ) {

                            @JsonCreator
                            private constructor(
                                @JsonProperty("skill_id")
                                @ExcludeMissing
                                skillId: JsonField<String> = JsonMissing.of(),
                                @JsonProperty("type")
                                @ExcludeMissing
                                type: JsonValue = JsonMissing.of(),
                                @JsonProperty("version")
                                @ExcludeMissing
                                version: JsonField<String> = JsonMissing.of(),
                            ) : this(skillId, type, version, mutableMapOf())

                            /**
                             * The ID of the referenced skill. The schema requires this property.
                             * Returns empty if the JSON property is missing or null.
                             *
                             * @throws OpenAIInvalidDataException if the value has an unexpected
                             *   type.
                             */
                            fun skillId(): java.util.Optional<String> =
                                skillId.getOptional("skill_id")

                            /**
                             * Returns the value or throws [OpenAIInvalidDataException] if it is
                             * missing, null, or invalid.
                             */
                            fun skillIdOrThrow(): String = skillId.getRequired("skill_id")

                            /**
                             * References a skill created with the /v1/skills endpoint. The schema
                             * requires this property. Returns empty if the JSON property is missing
                             * or null.
                             *
                             * @throws OpenAIInvalidDataException if the value has an unexpected
                             *   type.
                             */
                            fun type(): java.util.Optional<JsonValue> {
                                val raw = type
                                return when {
                                    raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                                    !(raw == JsonValue.from("skill_reference")) ->
                                        throw OpenAIInvalidDataException("`type` is invalid")
                                    else -> java.util.Optional.of(raw)
                                }
                            }

                            /**
                             * Returns the value or throws [OpenAIInvalidDataException] if it is
                             * missing, null, or invalid.
                             */
                            fun typeOrThrow(): JsonValue =
                                type().orElseGet { type.getRequired("type") }

                            @JsonProperty("type")
                            @ExcludeMissing
                            fun _type(): JsonField<JsonValue> = type

                            /**
                             * Optional skill version. Use a positive integer or 'latest'. Omit for
                             * default. Returns empty if the JSON property is missing or null.
                             *
                             * @throws OpenAIInvalidDataException if the value has an unexpected
                             *   type.
                             */
                            fun version(): java.util.Optional<String> =
                                version.getOptional("version")

                            /**
                             * Returns the value or throws [OpenAIInvalidDataException] if it is
                             * missing, null, or invalid.
                             */
                            fun versionOrThrow(): String = version.getRequired("version")

                            /**
                             * Returns the raw JSON value of [skillId].
                             *
                             * Unlike [skillId], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("skill_id")
                            @ExcludeMissing
                            fun _skillId(): JsonField<String> = skillId

                            /**
                             * Returns the raw JSON value of [version].
                             *
                             * Unlike [version], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("version")
                            @ExcludeMissing
                            fun _version(): JsonField<String> = version

                            @JsonAnySetter
                            private fun putAdditionalProperty(key: String, value: JsonValue) {
                                additionalProperties.put(key, value)
                            }

                            /**
                             * Returns an immutable snapshot of all present JSON properties,
                             * including declared and additional properties.
                             *
                             * Keys use their JSON names. Declared properties take precedence over
                             * additional properties with the same name. Missing properties are
                             * omitted, while explicit nulls and unrecognized values are preserved.
                             */
                            fun _allProperties(): Map<String, JsonValue> =
                                collectAllProperties(
                                    additionalProperties,
                                    "skill_id" to this.skillId,
                                    "type" to this.type,
                                    "version" to this.version,
                                )

                            @JvmSynthetic
                            internal fun _additionalProperties(): Map<String, JsonValue> =
                                Collections.unmodifiableMap(additionalProperties)

                            @JsonAnyGetter
                            @ExcludeMissing
                            private fun additionalProperties(): Map<String, JsonValue> =
                                additionalProperties

                            fun toBuilder() = Builder().from(this)

                            companion object {

                                /**
                                 * Returns a mutable builder for constructing an instance of
                                 * [SkillReference].
                                 *
                                 * The following fields are required:
                                 * ```java
                                 * .skillId()
                                 * ```
                                 */
                                @JvmStatic fun builder() = Builder()
                            }

                            /** A builder for [SkillReference]. */
                            class Builder internal constructor() {

                                private var skillId: JsonField<String>? = null
                                private var type: JsonValue = JsonValue.from("skill_reference")
                                private var version: JsonField<String> = JsonMissing.of()
                                private var additionalProperties: MutableMap<String, JsonValue> =
                                    mutableMapOf()

                                @JvmSynthetic
                                internal fun from(skillReference: SkillReference) = apply {
                                    skillId = skillReference.skillId
                                    type = skillReference.type
                                    version = skillReference.version
                                    additionalProperties =
                                        skillReference.additionalProperties.toMutableMap()
                                }

                                /** The ID of the referenced skill. */
                                fun skillId(skillId: String) = skillId(JsonField.of(skillId))

                                /**
                                 * Sets [Builder.skillId] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.skillId] with a well-typed
                                 * [String] value instead. This method is primarily for setting the
                                 * field to an undocumented or not yet supported value.
                                 */
                                fun skillId(skillId: JsonField<String>) = apply {
                                    this.skillId = skillId
                                }

                                /**
                                 * Sets the field to an arbitrary JSON value.
                                 *
                                 * It is usually unnecessary to call this method because the field
                                 * defaults to the following:
                                 * ```java
                                 * JsonValue.from("skill_reference")
                                 * ```
                                 *
                                 * This method is primarily for setting the field to an undocumented
                                 * or not yet supported value.
                                 */
                                fun type(type: JsonValue) = apply { this.type = type }

                                /**
                                 * Optional skill version. Use a positive integer or 'latest'. Omit
                                 * for default.
                                 */
                                fun version(version: String?) =
                                    version(JsonField.ofNullable(version))

                                /**
                                 * Alias for calling [Builder.version] with `version.orElse(null)`.
                                 */
                                fun version(version: Optional<String>) =
                                    version(version.getOrNull())

                                /**
                                 * Sets [Builder.version] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.version] with a well-typed
                                 * [String] value instead. This method is primarily for setting the
                                 * field to an undocumented or not yet supported value.
                                 */
                                fun version(version: JsonField<String>) = apply {
                                    this.version = version
                                }

                                fun additionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                    additionalProperties.put(key, value)
                                }

                                fun putAllAdditionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply { this.additionalProperties.putAll(additionalProperties) }

                                fun removeAdditionalProperty(key: String) = apply {
                                    additionalProperties.remove(key)
                                }

                                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                    keys.forEach(::removeAdditionalProperty)
                                }

                                /**
                                 * Returns an immutable instance of [SkillReference].
                                 *
                                 * Further updates to this [Builder] will not mutate the returned
                                 * instance.
                                 *
                                 * The following fields are required:
                                 * ```java
                                 * .skillId()
                                 * ```
                                 *
                                 * @throws IllegalStateException if any required field is unset.
                                 */
                                fun build(): SkillReference =
                                    SkillReference(
                                        checkRequired("skillId", skillId),
                                        type,
                                        version,
                                        additionalProperties.toMutableMap(),
                                    )
                            }

                            private var validated: Boolean = false

                            /**
                             * Validates that the types of all values in this object match their
                             * expected types recursively.
                             *
                             * This method is _not_ forwards compatible with new types from the API
                             * for existing fields.
                             *
                             * @throws OpenAIInvalidDataException if any value type in this object
                             *   doesn't match its expected type.
                             */
                            fun validate(): SkillReference = apply {
                                if (validated) {
                                    return@apply
                                }

                                skillIdOrThrow()
                                typeOrThrow()
                                version()
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
                             * Returns a score indicating how many valid values are contained in
                             * this object recursively.
                             *
                             * Used for best match union deserialization.
                             */
                            @JvmSynthetic
                            internal fun validity(): Int =
                                (if (skillId.asKnown().isPresent) 1 else 0) +
                                    type.let {
                                        if (it == JsonValue.from("skill_reference")) 1 else 0
                                    } +
                                    (if (version.asKnown().isPresent) 1 else 0)

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return other is SkillReference &&
                                    skillId == other.skillId &&
                                    type == other.type &&
                                    version == other.version &&
                                    additionalProperties == other.additionalProperties
                            }

                            private val hashCode: Int by lazy {
                                Objects.hash(skillId, type, version, additionalProperties)
                            }

                            override fun hashCode(): Int = hashCode

                            override fun toString() =
                                "SkillReference{skillId=$skillId, type=$type, version=$version, additionalProperties=$additionalProperties}"
                        }

                        class Inline
                        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                        private constructor(
                            private val description: JsonField<String>,
                            private val name: JsonField<String>,
                            private val source: JsonField<Source>,
                            private val type: JsonValue,
                            private val additionalProperties: MutableMap<String, JsonValue>,
                        ) {

                            @JsonCreator
                            private constructor(
                                @JsonProperty("description")
                                @ExcludeMissing
                                description: JsonField<String> = JsonMissing.of(),
                                @JsonProperty("name")
                                @ExcludeMissing
                                name: JsonField<String> = JsonMissing.of(),
                                @JsonProperty("source")
                                @ExcludeMissing
                                source: JsonField<Source> = JsonMissing.of(),
                                @JsonProperty("type")
                                @ExcludeMissing
                                type: JsonValue = JsonMissing.of(),
                            ) : this(description, name, source, type, mutableMapOf())

                            /**
                             * The description of the skill. The schema requires this property.
                             * Returns empty if the JSON property is missing or null.
                             *
                             * @throws OpenAIInvalidDataException if the value has an unexpected
                             *   type.
                             */
                            fun description(): java.util.Optional<String> =
                                description.getOptional("description")

                            /**
                             * Returns the value or throws [OpenAIInvalidDataException] if it is
                             * missing, null, or invalid.
                             */
                            fun descriptionOrThrow(): String =
                                description.getRequired("description")

                            /**
                             * The name of the skill. The schema requires this property. Returns
                             * empty if the JSON property is missing or null.
                             *
                             * @throws OpenAIInvalidDataException if the value has an unexpected
                             *   type.
                             */
                            fun name(): java.util.Optional<String> = name.getOptional("name")

                            /**
                             * Returns the value or throws [OpenAIInvalidDataException] if it is
                             * missing, null, or invalid.
                             */
                            fun nameOrThrow(): String = name.getRequired("name")

                            /**
                             * Inline skill payload The schema requires this property. Returns empty
                             * if the JSON property is missing or null.
                             *
                             * @throws OpenAIInvalidDataException if the value has an unexpected
                             *   type.
                             */
                            fun source(): java.util.Optional<Source> = source.getOptional("source")

                            /**
                             * Returns the value or throws [OpenAIInvalidDataException] if it is
                             * missing, null, or invalid.
                             */
                            fun sourceOrThrow(): Source = source.getRequired("source")

                            /**
                             * Defines an inline skill for this request. The schema requires this
                             * property. Returns empty if the JSON property is missing or null.
                             *
                             * @throws OpenAIInvalidDataException if the value has an unexpected
                             *   type.
                             */
                            fun type(): java.util.Optional<JsonValue> {
                                val raw = type
                                return when {
                                    raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                                    !(raw == JsonValue.from("inline")) ->
                                        throw OpenAIInvalidDataException("`type` is invalid")
                                    else -> java.util.Optional.of(raw)
                                }
                            }

                            /**
                             * Returns the value or throws [OpenAIInvalidDataException] if it is
                             * missing, null, or invalid.
                             */
                            fun typeOrThrow(): JsonValue =
                                type().orElseGet { type.getRequired("type") }

                            @JsonProperty("type")
                            @ExcludeMissing
                            fun _type(): JsonField<JsonValue> = type

                            /**
                             * Returns the raw JSON value of [description].
                             *
                             * Unlike [description], this method doesn't throw if the JSON field has
                             * an unexpected type.
                             */
                            @JsonProperty("description")
                            @ExcludeMissing
                            fun _description(): JsonField<String> = description

                            /**
                             * Returns the raw JSON value of [name].
                             *
                             * Unlike [name], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("name")
                            @ExcludeMissing
                            fun _name(): JsonField<String> = name

                            /**
                             * Returns the raw JSON value of [source].
                             *
                             * Unlike [source], this method doesn't throw if the JSON field has an
                             * unexpected type.
                             */
                            @JsonProperty("source")
                            @ExcludeMissing
                            fun _source(): JsonField<Source> = source

                            @JsonAnySetter
                            private fun putAdditionalProperty(key: String, value: JsonValue) {
                                additionalProperties.put(key, value)
                            }

                            /**
                             * Returns an immutable snapshot of all present JSON properties,
                             * including declared and additional properties.
                             *
                             * Keys use their JSON names. Declared properties take precedence over
                             * additional properties with the same name. Missing properties are
                             * omitted, while explicit nulls and unrecognized values are preserved.
                             */
                            fun _allProperties(): Map<String, JsonValue> =
                                collectAllProperties(
                                    additionalProperties,
                                    "description" to this.description,
                                    "name" to this.name,
                                    "source" to this.source,
                                    "type" to this.type,
                                )

                            @JvmSynthetic
                            internal fun _additionalProperties(): Map<String, JsonValue> =
                                Collections.unmodifiableMap(additionalProperties)

                            @JsonAnyGetter
                            @ExcludeMissing
                            private fun additionalProperties(): Map<String, JsonValue> =
                                additionalProperties

                            fun toBuilder() = Builder().from(this)

                            companion object {

                                /**
                                 * Returns a mutable builder for constructing an instance of
                                 * [Inline].
                                 *
                                 * The following fields are required:
                                 * ```java
                                 * .description()
                                 * .name()
                                 * .source()
                                 * ```
                                 */
                                @JvmStatic fun builder() = Builder()
                            }

                            /** A builder for [Inline]. */
                            class Builder internal constructor() {

                                private var description: JsonField<String>? = null
                                private var name: JsonField<String>? = null
                                private var source: JsonField<Source>? = null
                                private var type: JsonValue = JsonValue.from("inline")
                                private var additionalProperties: MutableMap<String, JsonValue> =
                                    mutableMapOf()

                                @JvmSynthetic
                                internal fun from(inline: Inline) = apply {
                                    description = inline.description
                                    name = inline.name
                                    source = inline.source
                                    type = inline.type
                                    additionalProperties =
                                        inline.additionalProperties.toMutableMap()
                                }

                                /** The description of the skill. */
                                fun description(description: String) =
                                    description(JsonField.of(description))

                                /**
                                 * Sets [Builder.description] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.description] with a well-typed
                                 * [String] value instead. This method is primarily for setting the
                                 * field to an undocumented or not yet supported value.
                                 */
                                fun description(description: JsonField<String>) = apply {
                                    this.description = description
                                }

                                /** The name of the skill. */
                                fun name(name: String) = name(JsonField.of(name))

                                /**
                                 * Sets [Builder.name] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.name] with a well-typed [String]
                                 * value instead. This method is primarily for setting the field to
                                 * an undocumented or not yet supported value.
                                 */
                                fun name(name: JsonField<String>) = apply { this.name = name }

                                /** Inline skill payload */
                                fun source(source: Source) = source(JsonField.of(source))

                                /**
                                 * Sets [Builder.source] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.source] with a well-typed
                                 * [Source] value instead. This method is primarily for setting the
                                 * field to an undocumented or not yet supported value.
                                 */
                                fun source(source: JsonField<Source>) = apply {
                                    this.source = source
                                }

                                /**
                                 * Sets the field to an arbitrary JSON value.
                                 *
                                 * It is usually unnecessary to call this method because the field
                                 * defaults to the following:
                                 * ```java
                                 * JsonValue.from("inline")
                                 * ```
                                 *
                                 * This method is primarily for setting the field to an undocumented
                                 * or not yet supported value.
                                 */
                                fun type(type: JsonValue) = apply { this.type = type }

                                fun additionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                    additionalProperties.put(key, value)
                                }

                                fun putAllAdditionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply { this.additionalProperties.putAll(additionalProperties) }

                                fun removeAdditionalProperty(key: String) = apply {
                                    additionalProperties.remove(key)
                                }

                                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                    keys.forEach(::removeAdditionalProperty)
                                }

                                /**
                                 * Returns an immutable instance of [Inline].
                                 *
                                 * Further updates to this [Builder] will not mutate the returned
                                 * instance.
                                 *
                                 * The following fields are required:
                                 * ```java
                                 * .description()
                                 * .name()
                                 * .source()
                                 * ```
                                 *
                                 * @throws IllegalStateException if any required field is unset.
                                 */
                                fun build(): Inline =
                                    Inline(
                                        checkRequired("description", description),
                                        checkRequired("name", name),
                                        checkRequired("source", source),
                                        type,
                                        additionalProperties.toMutableMap(),
                                    )
                            }

                            private var validated: Boolean = false

                            /**
                             * Validates that the types of all values in this object match their
                             * expected types recursively.
                             *
                             * This method is _not_ forwards compatible with new types from the API
                             * for existing fields.
                             *
                             * @throws OpenAIInvalidDataException if any value type in this object
                             *   doesn't match its expected type.
                             */
                            fun validate(): Inline = apply {
                                if (validated) {
                                    return@apply
                                }

                                descriptionOrThrow()
                                nameOrThrow()
                                sourceOrThrow().validate()
                                typeOrThrow()
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
                             * Returns a score indicating how many valid values are contained in
                             * this object recursively.
                             *
                             * Used for best match union deserialization.
                             */
                            @JvmSynthetic
                            internal fun validity(): Int =
                                (if (description.asKnown().isPresent) 1 else 0) +
                                    (if (name.asKnown().isPresent) 1 else 0) +
                                    (source.asKnown().getOrNull()?.validity() ?: 0) +
                                    type.let { if (it == JsonValue.from("inline")) 1 else 0 }

                            /** Inline skill payload */
                            class Source
                            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                            private constructor(
                                private val data: JsonField<String>,
                                private val mediaType: JsonValue,
                                private val type: JsonValue,
                                private val additionalProperties: MutableMap<String, JsonValue>,
                            ) {

                                @JsonCreator
                                private constructor(
                                    @JsonProperty("data")
                                    @ExcludeMissing
                                    data: JsonField<String> = JsonMissing.of(),
                                    @JsonProperty("media_type")
                                    @ExcludeMissing
                                    mediaType: JsonValue = JsonMissing.of(),
                                    @JsonProperty("type")
                                    @ExcludeMissing
                                    type: JsonValue = JsonMissing.of(),
                                ) : this(data, mediaType, type, mutableMapOf())

                                /**
                                 * Base64-encoded skill zip bundle. The schema requires this
                                 * property. Returns empty if the JSON property is missing or null.
                                 *
                                 * @throws OpenAIInvalidDataException if the value has an unexpected
                                 *   type.
                                 */
                                fun data(): java.util.Optional<String> = data.getOptional("data")

                                /**
                                 * Returns the value or throws [OpenAIInvalidDataException] if it is
                                 * missing, null, or invalid.
                                 */
                                fun dataOrThrow(): String = data.getRequired("data")

                                /**
                                 * The media type of the inline skill payload. Must be
                                 * `application/zip`. The schema requires this property. Returns
                                 * empty if the JSON property is missing or null.
                                 *
                                 * @throws OpenAIInvalidDataException if the value has an unexpected
                                 *   type.
                                 */
                                fun mediaType(): java.util.Optional<JsonValue> {
                                    val raw = mediaType
                                    return when {
                                        raw.isMissing() || raw.isNull() ->
                                            java.util.Optional.empty()
                                        !(raw == JsonValue.from("application/zip")) ->
                                            throw OpenAIInvalidDataException(
                                                "`media_type` is invalid"
                                            )
                                        else -> java.util.Optional.of(raw)
                                    }
                                }

                                /**
                                 * Returns the value or throws [OpenAIInvalidDataException] if it is
                                 * missing, null, or invalid.
                                 */
                                fun mediaTypeOrThrow(): JsonValue =
                                    mediaType().orElseGet { mediaType.getRequired("media_type") }

                                @JsonProperty("media_type")
                                @ExcludeMissing
                                fun _mediaType(): JsonField<JsonValue> = mediaType

                                /**
                                 * The type of the inline skill source. Must be `base64`. The schema
                                 * requires this property. Returns empty if the JSON property is
                                 * missing or null.
                                 *
                                 * @throws OpenAIInvalidDataException if the value has an unexpected
                                 *   type.
                                 */
                                fun type(): java.util.Optional<JsonValue> {
                                    val raw = type
                                    return when {
                                        raw.isMissing() || raw.isNull() ->
                                            java.util.Optional.empty()
                                        !(raw == JsonValue.from("base64")) ->
                                            throw OpenAIInvalidDataException("`type` is invalid")
                                        else -> java.util.Optional.of(raw)
                                    }
                                }

                                /**
                                 * Returns the value or throws [OpenAIInvalidDataException] if it is
                                 * missing, null, or invalid.
                                 */
                                fun typeOrThrow(): JsonValue =
                                    type().orElseGet { type.getRequired("type") }

                                @JsonProperty("type")
                                @ExcludeMissing
                                fun _type(): JsonField<JsonValue> = type

                                /**
                                 * Returns the raw JSON value of [data].
                                 *
                                 * Unlike [data], this method doesn't throw if the JSON field has an
                                 * unexpected type.
                                 */
                                @JsonProperty("data")
                                @ExcludeMissing
                                fun _data(): JsonField<String> = data

                                @JsonAnySetter
                                private fun putAdditionalProperty(key: String, value: JsonValue) {
                                    additionalProperties.put(key, value)
                                }

                                /**
                                 * Returns an immutable snapshot of all present JSON properties,
                                 * including declared and additional properties.
                                 *
                                 * Keys use their JSON names. Declared properties take precedence
                                 * over additional properties with the same name. Missing properties
                                 * are omitted, while explicit nulls and unrecognized values are
                                 * preserved.
                                 */
                                fun _allProperties(): Map<String, JsonValue> =
                                    collectAllProperties(
                                        additionalProperties,
                                        "data" to this.data,
                                        "media_type" to this.mediaType,
                                        "type" to this.type,
                                    )

                                @JvmSynthetic
                                internal fun _additionalProperties(): Map<String, JsonValue> =
                                    Collections.unmodifiableMap(additionalProperties)

                                @JsonAnyGetter
                                @ExcludeMissing
                                private fun additionalProperties(): Map<String, JsonValue> =
                                    additionalProperties

                                fun toBuilder() = Builder().from(this)

                                companion object {

                                    /**
                                     * Returns a mutable builder for constructing an instance of
                                     * [Source].
                                     *
                                     * The following fields are required:
                                     * ```java
                                     * .data()
                                     * ```
                                     */
                                    @JvmStatic fun builder() = Builder()
                                }

                                /** A builder for [Source]. */
                                class Builder internal constructor() {

                                    private var data: JsonField<String>? = null
                                    private var mediaType: JsonValue =
                                        JsonValue.from("application/zip")
                                    private var type: JsonValue = JsonValue.from("base64")
                                    private var additionalProperties:
                                        MutableMap<String, JsonValue> =
                                        mutableMapOf()

                                    @JvmSynthetic
                                    internal fun from(source: Source) = apply {
                                        data = source.data
                                        mediaType = source.mediaType
                                        type = source.type
                                        additionalProperties =
                                            source.additionalProperties.toMutableMap()
                                    }

                                    /** Base64-encoded skill zip bundle. */
                                    fun data(data: String) = data(JsonField.of(data))

                                    /**
                                     * Sets [Builder.data] to an arbitrary JSON value.
                                     *
                                     * You should usually call [Builder.data] with a well-typed
                                     * [String] value instead. This method is primarily for setting
                                     * the field to an undocumented or not yet supported value.
                                     */
                                    fun data(data: JsonField<String>) = apply { this.data = data }

                                    /**
                                     * Sets the field to an arbitrary JSON value.
                                     *
                                     * It is usually unnecessary to call this method because the
                                     * field defaults to the following:
                                     * ```java
                                     * JsonValue.from("application/zip")
                                     * ```
                                     *
                                     * This method is primarily for setting the field to an
                                     * undocumented or not yet supported value.
                                     */
                                    fun mediaType(mediaType: JsonValue) = apply {
                                        this.mediaType = mediaType
                                    }

                                    /**
                                     * Sets the field to an arbitrary JSON value.
                                     *
                                     * It is usually unnecessary to call this method because the
                                     * field defaults to the following:
                                     * ```java
                                     * JsonValue.from("base64")
                                     * ```
                                     *
                                     * This method is primarily for setting the field to an
                                     * undocumented or not yet supported value.
                                     */
                                    fun type(type: JsonValue) = apply { this.type = type }

                                    fun additionalProperties(
                                        additionalProperties: Map<String, JsonValue>
                                    ) = apply {
                                        this.additionalProperties.clear()
                                        putAllAdditionalProperties(additionalProperties)
                                    }

                                    fun putAdditionalProperty(key: String, value: JsonValue) =
                                        apply {
                                            additionalProperties.put(key, value)
                                        }

                                    fun putAllAdditionalProperties(
                                        additionalProperties: Map<String, JsonValue>
                                    ) = apply {
                                        this.additionalProperties.putAll(additionalProperties)
                                    }

                                    fun removeAdditionalProperty(key: String) = apply {
                                        additionalProperties.remove(key)
                                    }

                                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                        keys.forEach(::removeAdditionalProperty)
                                    }

                                    /**
                                     * Returns an immutable instance of [Source].
                                     *
                                     * Further updates to this [Builder] will not mutate the
                                     * returned instance.
                                     *
                                     * The following fields are required:
                                     * ```java
                                     * .data()
                                     * ```
                                     *
                                     * @throws IllegalStateException if any required field is unset.
                                     */
                                    fun build(): Source =
                                        Source(
                                            checkRequired("data", data),
                                            mediaType,
                                            type,
                                            additionalProperties.toMutableMap(),
                                        )
                                }

                                private var validated: Boolean = false

                                /**
                                 * Validates that the types of all values in this object match their
                                 * expected types recursively.
                                 *
                                 * This method is _not_ forwards compatible with new types from the
                                 * API for existing fields.
                                 *
                                 * @throws OpenAIInvalidDataException if any value type in this
                                 *   object doesn't match its expected type.
                                 */
                                fun validate(): Source = apply {
                                    if (validated) {
                                        return@apply
                                    }

                                    dataOrThrow()
                                    mediaTypeOrThrow()
                                    typeOrThrow()
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
                                 * Returns a score indicating how many valid values are contained in
                                 * this object recursively.
                                 *
                                 * Used for best match union deserialization.
                                 */
                                @JvmSynthetic
                                internal fun validity(): Int =
                                    (if (data.asKnown().isPresent) 1 else 0) +
                                        mediaType.let {
                                            if (it == JsonValue.from("application/zip")) 1 else 0
                                        } +
                                        type.let { if (it == JsonValue.from("base64")) 1 else 0 }

                                override fun equals(other: Any?): Boolean {
                                    if (this === other) {
                                        return true
                                    }

                                    return other is Source &&
                                        data == other.data &&
                                        mediaType == other.mediaType &&
                                        type == other.type &&
                                        additionalProperties == other.additionalProperties
                                }

                                private val hashCode: Int by lazy {
                                    Objects.hash(data, mediaType, type, additionalProperties)
                                }

                                override fun hashCode(): Int = hashCode

                                override fun toString() =
                                    "Source{data=$data, mediaType=$mediaType, type=$type, additionalProperties=$additionalProperties}"
                            }

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return other is Inline &&
                                    description == other.description &&
                                    name == other.name &&
                                    source == other.source &&
                                    type == other.type &&
                                    additionalProperties == other.additionalProperties
                            }

                            private val hashCode: Int by lazy {
                                Objects.hash(description, name, source, type, additionalProperties)
                            }

                            override fun hashCode(): Int = hashCode

                            override fun toString() =
                                "Inline{description=$description, name=$name, source=$source, type=$type, additionalProperties=$additionalProperties}"
                        }
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is ContainerAuto &&
                            type == other.type &&
                            fileIds == other.fileIds &&
                            memoryLimit == other.memoryLimit &&
                            networkPolicy == other.networkPolicy &&
                            skills == other.skills &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(
                            type,
                            fileIds,
                            memoryLimit,
                            networkPolicy,
                            skills,
                            additionalProperties,
                        )
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "ContainerAuto{type=$type, fileIds=$fileIds, memoryLimit=$memoryLimit, networkPolicy=$networkPolicy, skills=$skills, additionalProperties=$additionalProperties}"
                }

                class ContainerReference
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val containerId: JsonField<String>,
                    private val type: JsonValue,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("container_id")
                        @ExcludeMissing
                        containerId: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                    ) : this(containerId, type, mutableMapOf())

                    /**
                     * The ID of the referenced container. The schema requires this property.
                     * Returns empty if the JSON property is missing or null.
                     *
                     * @throws OpenAIInvalidDataException if the value has an unexpected type.
                     */
                    fun containerId(): java.util.Optional<String> =
                        containerId.getOptional("container_id")

                    /**
                     * Returns the value or throws [OpenAIInvalidDataException] if it is missing,
                     * null, or invalid.
                     */
                    fun containerIdOrThrow(): String = containerId.getRequired("container_id")

                    /**
                     * References a container created with the /v1/containers endpoint The schema
                     * requires this property. Returns empty if the JSON property is missing or
                     * null.
                     *
                     * @throws OpenAIInvalidDataException if the value has an unexpected type.
                     */
                    fun type(): java.util.Optional<JsonValue> {
                        val raw = type
                        return when {
                            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                            !(raw == JsonValue.from("container_reference")) ->
                                throw OpenAIInvalidDataException("`type` is invalid")
                            else -> java.util.Optional.of(raw)
                        }
                    }

                    /**
                     * Returns the value or throws [OpenAIInvalidDataException] if it is missing,
                     * null, or invalid.
                     */
                    fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

                    /**
                     * Returns the raw JSON value of [containerId].
                     *
                     * Unlike [containerId], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("container_id")
                    @ExcludeMissing
                    fun _containerId(): JsonField<String> = containerId

                    @JsonAnySetter
                    private fun putAdditionalProperty(key: String, value: JsonValue) {
                        additionalProperties.put(key, value)
                    }

                    /**
                     * Returns an immutable snapshot of all present JSON properties, including
                     * declared and additional properties.
                     *
                     * Keys use their JSON names. Declared properties take precedence over
                     * additional properties with the same name. Missing properties are omitted,
                     * while explicit nulls and unrecognized values are preserved.
                     */
                    fun _allProperties(): Map<String, JsonValue> =
                        collectAllProperties(
                            additionalProperties,
                            "container_id" to this.containerId,
                            "type" to this.type,
                        )

                    @JvmSynthetic
                    internal fun _additionalProperties(): Map<String, JsonValue> =
                        Collections.unmodifiableMap(additionalProperties)

                    @JsonAnyGetter
                    @ExcludeMissing
                    private fun additionalProperties(): Map<String, JsonValue> =
                        additionalProperties

                    fun toBuilder() = Builder().from(this)

                    companion object {

                        /**
                         * Returns a mutable builder for constructing an instance of
                         * [ContainerReference].
                         *
                         * The following fields are required:
                         * ```java
                         * .containerId()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [ContainerReference]. */
                    class Builder internal constructor() {

                        private var containerId: JsonField<String>? = null
                        private var type: JsonValue = JsonValue.from("container_reference")
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(containerReference: ContainerReference) = apply {
                            containerId = containerReference.containerId
                            type = containerReference.type
                            additionalProperties =
                                containerReference.additionalProperties.toMutableMap()
                        }

                        /** The ID of the referenced container. */
                        fun containerId(containerId: String) =
                            containerId(JsonField.of(containerId))

                        /**
                         * Sets [Builder.containerId] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.containerId] with a well-typed [String]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun containerId(containerId: JsonField<String>) = apply {
                            this.containerId = containerId
                        }

                        /**
                         * Sets the field to an arbitrary JSON value.
                         *
                         * It is usually unnecessary to call this method because the field defaults
                         * to the following:
                         * ```java
                         * JsonValue.from("container_reference")
                         * ```
                         *
                         * This method is primarily for setting the field to an undocumented or not
                         * yet supported value.
                         */
                        fun type(type: JsonValue) = apply { this.type = type }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [ContainerReference].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .containerId()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): ContainerReference =
                            ContainerReference(
                                checkRequired("containerId", containerId),
                                type,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws OpenAIInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): ContainerReference = apply {
                        if (validated) {
                            return@apply
                        }

                        containerIdOrThrow()
                        typeOrThrow()
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
                        (if (containerId.asKnown().isPresent) 1 else 0) +
                            type.let { if (it == JsonValue.from("container_reference")) 1 else 0 }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is ContainerReference &&
                            containerId == other.containerId &&
                            type == other.type &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(containerId, type, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "ContainerReference{containerId=$containerId, type=$type, additionalProperties=$additionalProperties}"
                }

                class Local
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val type: JsonValue,
                    private val skills: JsonField<List<Skill>>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                        @JsonProperty("skills")
                        @ExcludeMissing
                        skills: JsonField<List<Skill>> = JsonMissing.of(),
                    ) : this(type, skills, mutableMapOf())

                    /**
                     * Use a local computer environment. The schema requires this property. Returns
                     * empty if the JSON property is missing or null.
                     *
                     * @throws OpenAIInvalidDataException if the value has an unexpected type.
                     */
                    fun type(): java.util.Optional<JsonValue> {
                        val raw = type
                        return when {
                            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                            !(raw == JsonValue.from("local")) ->
                                throw OpenAIInvalidDataException("`type` is invalid")
                            else -> java.util.Optional.of(raw)
                        }
                    }

                    /**
                     * Returns the value or throws [OpenAIInvalidDataException] if it is missing,
                     * null, or invalid.
                     */
                    fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

                    /**
                     * An optional list of skills. Returns empty if the JSON property is missing or
                     * null.
                     *
                     * @throws OpenAIInvalidDataException if the value has an unexpected type.
                     */
                    fun skills(): java.util.Optional<List<Skill>> = skills.getOptional("skills")

                    /**
                     * Returns the value or throws [OpenAIInvalidDataException] if it is missing,
                     * null, or invalid.
                     */
                    fun skillsOrThrow(): List<Skill> = skills.getRequired("skills")

                    /**
                     * Returns the raw JSON value of [skills].
                     *
                     * Unlike [skills], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("skills")
                    @ExcludeMissing
                    fun _skills(): JsonField<List<Skill>> = skills

                    @JsonAnySetter
                    private fun putAdditionalProperty(key: String, value: JsonValue) {
                        additionalProperties.put(key, value)
                    }

                    /**
                     * Returns an immutable snapshot of all present JSON properties, including
                     * declared and additional properties.
                     *
                     * Keys use their JSON names. Declared properties take precedence over
                     * additional properties with the same name. Missing properties are omitted,
                     * while explicit nulls and unrecognized values are preserved.
                     */
                    fun _allProperties(): Map<String, JsonValue> =
                        collectAllProperties(
                            additionalProperties,
                            "type" to this.type,
                            "skills" to this.skills,
                        )

                    @JvmSynthetic
                    internal fun _additionalProperties(): Map<String, JsonValue> =
                        Collections.unmodifiableMap(additionalProperties)

                    @JsonAnyGetter
                    @ExcludeMissing
                    private fun additionalProperties(): Map<String, JsonValue> =
                        additionalProperties

                    fun toBuilder() = Builder().from(this)

                    companion object {

                        /** Returns a mutable builder for constructing an instance of [Local]. */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Local]. */
                    class Builder internal constructor() {

                        private var type: JsonValue = JsonValue.from("local")
                        private var skills: JsonField<MutableList<Skill>>? = null
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(local: Local) = apply {
                            type = local.type
                            skills = local.skills.map { it.toMutableList() }
                            additionalProperties = local.additionalProperties.toMutableMap()
                        }

                        /**
                         * Sets the field to an arbitrary JSON value.
                         *
                         * It is usually unnecessary to call this method because the field defaults
                         * to the following:
                         * ```java
                         * JsonValue.from("local")
                         * ```
                         *
                         * This method is primarily for setting the field to an undocumented or not
                         * yet supported value.
                         */
                        fun type(type: JsonValue) = apply { this.type = type }

                        /** An optional list of skills. */
                        fun skills(skills: List<Skill>?) = skills(JsonField.ofNullable(skills))

                        /** Alias for calling [Builder.skills] with `skills.orElse(null)`. */
                        fun skills(skills: Optional<List<Skill>>) = skills(skills.getOrNull())

                        /**
                         * Sets [Builder.skills] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.skills] with a well-typed `List<Skill>`
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun skills(skills: JsonField<List<Skill>>) = apply {
                            this.skills = skills.map { it.toMutableList() }
                        }

                        /**
                         * Adds a single [Skill] to [skills].
                         *
                         * @throws IllegalStateException if the field was previously set to a
                         *   non-list.
                         */
                        fun addSkill(skill: Skill) = apply {
                            skills =
                                (skills?.takeUnless { it.isMissing() }
                                        ?: JsonField.of(mutableListOf()))
                                    .also { checkKnown("skills", it).add(skill) }
                        }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [Local].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): Local =
                            Local(
                                type,
                                (skills ?: JsonMissing.of()).map { it.toImmutable() },
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws OpenAIInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): Local = apply {
                        if (validated) {
                            return@apply
                        }

                        typeOrThrow()
                        skills().ifPresent { it.forEach { it.validate() } }
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
                        type.let { if (it == JsonValue.from("local")) 1 else 0 } +
                            (skills.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

                    class Skill
                    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                    private constructor(
                        private val description: JsonField<String>,
                        private val name: JsonField<String>,
                        private val path: JsonField<String>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("description")
                            @ExcludeMissing
                            description: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("name")
                            @ExcludeMissing
                            name: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("path")
                            @ExcludeMissing
                            path: JsonField<String> = JsonMissing.of(),
                        ) : this(description, name, path, mutableMapOf())

                        /**
                         * The description of the skill. The schema requires this property. Returns
                         * empty if the JSON property is missing or null.
                         *
                         * @throws OpenAIInvalidDataException if the value has an unexpected type.
                         */
                        fun description(): java.util.Optional<String> =
                            description.getOptional("description")

                        /**
                         * Returns the value or throws [OpenAIInvalidDataException] if it is
                         * missing, null, or invalid.
                         */
                        fun descriptionOrThrow(): String = description.getRequired("description")

                        /**
                         * The name of the skill. The schema requires this property. Returns empty
                         * if the JSON property is missing or null.
                         *
                         * @throws OpenAIInvalidDataException if the value has an unexpected type.
                         */
                        fun name(): java.util.Optional<String> = name.getOptional("name")

                        /**
                         * Returns the value or throws [OpenAIInvalidDataException] if it is
                         * missing, null, or invalid.
                         */
                        fun nameOrThrow(): String = name.getRequired("name")

                        /**
                         * The path to the directory containing the skill. The schema requires this
                         * property. Returns empty if the JSON property is missing or null.
                         *
                         * @throws OpenAIInvalidDataException if the value has an unexpected type.
                         */
                        fun path(): java.util.Optional<String> = path.getOptional("path")

                        /**
                         * Returns the value or throws [OpenAIInvalidDataException] if it is
                         * missing, null, or invalid.
                         */
                        fun pathOrThrow(): String = path.getRequired("path")

                        /**
                         * Returns the raw JSON value of [description].
                         *
                         * Unlike [description], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("description")
                        @ExcludeMissing
                        fun _description(): JsonField<String> = description

                        /**
                         * Returns the raw JSON value of [name].
                         *
                         * Unlike [name], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

                        /**
                         * Returns the raw JSON value of [path].
                         *
                         * Unlike [path], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("path") @ExcludeMissing fun _path(): JsonField<String> = path

                        @JsonAnySetter
                        private fun putAdditionalProperty(key: String, value: JsonValue) {
                            additionalProperties.put(key, value)
                        }

                        /**
                         * Returns an immutable snapshot of all present JSON properties, including
                         * declared and additional properties.
                         *
                         * Keys use their JSON names. Declared properties take precedence over
                         * additional properties with the same name. Missing properties are omitted,
                         * while explicit nulls and unrecognized values are preserved.
                         */
                        fun _allProperties(): Map<String, JsonValue> =
                            collectAllProperties(
                                additionalProperties,
                                "description" to this.description,
                                "name" to this.name,
                                "path" to this.path,
                            )

                        @JvmSynthetic
                        internal fun _additionalProperties(): Map<String, JsonValue> =
                            Collections.unmodifiableMap(additionalProperties)

                        @JsonAnyGetter
                        @ExcludeMissing
                        private fun additionalProperties(): Map<String, JsonValue> =
                            additionalProperties

                        fun toBuilder() = Builder().from(this)

                        companion object {

                            /**
                             * Returns a mutable builder for constructing an instance of [Skill].
                             *
                             * The following fields are required:
                             * ```java
                             * .description()
                             * .name()
                             * .path()
                             * ```
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [Skill]. */
                        class Builder internal constructor() {

                            private var description: JsonField<String>? = null
                            private var name: JsonField<String>? = null
                            private var path: JsonField<String>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(skill: Skill) = apply {
                                description = skill.description
                                name = skill.name
                                path = skill.path
                                additionalProperties = skill.additionalProperties.toMutableMap()
                            }

                            /** The description of the skill. */
                            fun description(description: String) =
                                description(JsonField.of(description))

                            /**
                             * Sets [Builder.description] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.description] with a well-typed
                             * [String] value instead. This method is primarily for setting the
                             * field to an undocumented or not yet supported value.
                             */
                            fun description(description: JsonField<String>) = apply {
                                this.description = description
                            }

                            /** The name of the skill. */
                            fun name(name: String) = name(JsonField.of(name))

                            /**
                             * Sets [Builder.name] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.name] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun name(name: JsonField<String>) = apply { this.name = name }

                            /** The path to the directory containing the skill. */
                            fun path(path: String) = path(JsonField.of(path))

                            /**
                             * Sets [Builder.path] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.path] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun path(path: JsonField<String>) = apply { this.path = path }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [Skill].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```java
                             * .description()
                             * .name()
                             * .path()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): Skill =
                                Skill(
                                    checkRequired("description", description),
                                    checkRequired("name", name),
                                    checkRequired("path", path),
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        /**
                         * Validates that the types of all values in this object match their
                         * expected types recursively.
                         *
                         * This method is _not_ forwards compatible with new types from the API for
                         * existing fields.
                         *
                         * @throws OpenAIInvalidDataException if any value type in this object
                         *   doesn't match its expected type.
                         */
                        fun validate(): Skill = apply {
                            if (validated) {
                                return@apply
                            }

                            descriptionOrThrow()
                            nameOrThrow()
                            pathOrThrow()
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int =
                            (if (description.asKnown().isPresent) 1 else 0) +
                                (if (name.asKnown().isPresent) 1 else 0) +
                                (if (path.asKnown().isPresent) 1 else 0)

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Skill &&
                                description == other.description &&
                                name == other.name &&
                                path == other.path &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(description, name, path, additionalProperties)
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "Skill{description=$description, name=$name, path=$path, additionalProperties=$additionalProperties}"
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Local &&
                            type == other.type &&
                            skills == other.skills &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(type, skills, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Local{type=$type, skills=$skills, additionalProperties=$additionalProperties}"
                }
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Shell &&
                    type == other.type &&
                    environment == other.environment &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(type, environment, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Shell{type=$type, environment=$environment, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponsesDelegationConfig &&
            model == other.model &&
            instructions == other.instructions &&
            maxOutputTokens == other.maxOutputTokens &&
            parallelToolCalls == other.parallelToolCalls &&
            reasoning == other.reasoning &&
            serviceTier == other.serviceTier &&
            text == other.text &&
            toolChoice == other.toolChoice &&
            tools == other.tools &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            model,
            instructions,
            maxOutputTokens,
            parallelToolCalls,
            reasoning,
            serviceTier,
            text,
            toolChoice,
            tools,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponsesDelegationConfig{model=$model, instructions=$instructions, maxOutputTokens=$maxOutputTokens, parallelToolCalls=$parallelToolCalls, reasoning=$reasoning, serviceTier=$serviceTier, text=$text, toolChoice=$toolChoice, tools=$tools, additionalProperties=$additionalProperties}"
}
