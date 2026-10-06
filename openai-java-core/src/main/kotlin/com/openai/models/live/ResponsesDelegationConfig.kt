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
import com.openai.core.allMaxBy
import com.openai.core.checkKnown
import com.openai.core.checkRequired
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
     * The model used for server-owned Responses delegations.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun model(): String = model.getRequired("model")

    /**
     * Instructions for the delegated Responses model, separate from Live instructions. See
     * [backend prompting](https://developers.openai.com/api/docs/guides/live-delegation#start-with-your-existing-backend-prompt).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun instructions(): Optional<String> = instructions.getOptional("instructions")

    /**
     * Maximum number of output tokens for each delegated response.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun maxOutputTokens(): Optional<Long> = maxOutputTokens.getOptional("max_output_tokens")

    /**
     * Whether the delegated Responses model may request multiple tool calls in a single response.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun parallelToolCalls(): Optional<Boolean> =
        parallelToolCalls.getOptional("parallel_tool_calls")

    /**
     * Reasoning settings passed to each delegated Responses request.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun reasoning(): Optional<Reasoning> = reasoning.getOptional("reasoning")

    /**
     * Service tier for delegated Responses requests.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun serviceTier(): Optional<ServiceTier> = serviceTier.getOptional("service_tier")

    /**
     * Text generation settings passed to each delegated Responses request.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun text(): Optional<Text> = text.getOptional("text")

    /**
     * Controls which tool the Responses backend uses when handling a task delegated by the Live
     * model.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun toolChoice(): Optional<ToolChoice> = toolChoice.getOptional("tool_choice")

    /**
     * Tools available to the Responses backend while it handles tasks delegated by the Live model.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tools(): Optional<List<Tool>> = tools.getOptional("tools")

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

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

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
         * `ToolChoice.ofLiveToolChoiceEnum(liveToolChoiceEnum)`.
         */
        fun toolChoice(liveToolChoiceEnum: ToolChoice.LiveToolChoiceEnum) =
            toolChoice(ToolChoice.ofLiveToolChoiceEnum(liveToolChoiceEnum))

        /** Alias for calling [toolChoice] with `ToolChoice.ofUnionMember1(unionMember1)`. */
        fun toolChoice(unionMember1: ToolChoice.UnionMember1) =
            toolChoice(ToolChoice.ofUnionMember1(unionMember1))

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
                (tools ?: JsonField.of(mutableListOf())).also { checkKnown("tools", it).add(tool) }
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

        model()
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
         * depend on the backend model.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun effort(): Optional<Effort> = effort.getOptional("effort")

        /**
         * The reasoning summary to request from the delegated Responses model, when supported.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun summary(): Optional<Summary> = summary.getOptional("summary")

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

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

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
         * the Live model’s spoken delivery.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun verbosity(): Optional<Verbosity> = verbosity.getOptional("verbosity")

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

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

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
        private val liveToolChoiceEnum: LiveToolChoiceEnum? = null,
        private val unionMember1: UnionMember1? = null,
        private val _json: JsonValue? = null,
    ) {

        /**
         * Controls which tool the Responses backend uses when handling a task delegated by the Live
         * model.
         */
        fun liveToolChoiceEnum(): Optional<LiveToolChoiceEnum> =
            Optional.ofNullable(liveToolChoiceEnum)

        fun unionMember1(): Optional<UnionMember1> = Optional.ofNullable(unionMember1)

        fun isLiveToolChoiceEnum(): Boolean = liveToolChoiceEnum != null

        fun isUnionMember1(): Boolean = unionMember1 != null

        /**
         * Controls which tool the Responses backend uses when handling a task delegated by the Live
         * model.
         */
        fun asLiveToolChoiceEnum(): LiveToolChoiceEnum =
            liveToolChoiceEnum.getOrThrow("liveToolChoiceEnum")

        fun asUnionMember1(): UnionMember1 = unionMember1.getOrThrow("unionMember1")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        /**
         * Maps this instance's current variant to a value of type [T] using the given [visitor].
         *
         * Note that this method is _not_ forwards compatible with new variants from the API, unless
         * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of
         * the SDK gracefully, consider overriding [Visitor.unknown]:
         * ```java
         * import com.openai.core.JsonValue;
         * import java.util.Optional;
         *
         * Optional<String> result = toolChoice.accept(new ToolChoice.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitLiveToolChoiceEnum(LiveToolChoiceEnum liveToolChoiceEnum) {
         *         return Optional.of(liveToolChoiceEnum.toString());
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
         * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor]
         *   and the current variant is unknown.
         */
        fun <T> accept(visitor: Visitor<T>): T =
            when {
                liveToolChoiceEnum != null -> visitor.visitLiveToolChoiceEnum(liveToolChoiceEnum)
                unionMember1 != null -> visitor.visitUnionMember1(unionMember1)
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

            accept(
                object : Visitor<Unit> {
                    override fun visitLiveToolChoiceEnum(liveToolChoiceEnum: LiveToolChoiceEnum) {
                        liveToolChoiceEnum.validate()
                    }

                    override fun visitUnionMember1(unionMember1: UnionMember1) {
                        unionMember1.validate()
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
                    override fun visitLiveToolChoiceEnum(liveToolChoiceEnum: LiveToolChoiceEnum) =
                        liveToolChoiceEnum.validity()

                    override fun visitUnionMember1(unionMember1: UnionMember1) =
                        unionMember1.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ToolChoice &&
                liveToolChoiceEnum == other.liveToolChoiceEnum &&
                unionMember1 == other.unionMember1
        }

        override fun hashCode(): Int = Objects.hash(liveToolChoiceEnum, unionMember1)

        override fun toString(): String =
            when {
                liveToolChoiceEnum != null -> "ToolChoice{liveToolChoiceEnum=$liveToolChoiceEnum}"
                unionMember1 != null -> "ToolChoice{unionMember1=$unionMember1}"
                _json != null -> "ToolChoice{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid ToolChoice")
            }

        companion object {

            /**
             * Controls which tool the Responses backend uses when handling a task delegated by the
             * Live model.
             */
            @JvmStatic
            fun ofLiveToolChoiceEnum(liveToolChoiceEnum: LiveToolChoiceEnum) =
                ToolChoice(liveToolChoiceEnum = liveToolChoiceEnum)

            @JvmStatic
            fun ofUnionMember1(unionMember1: UnionMember1) = ToolChoice(unionMember1 = unionMember1)
        }

        /**
         * An interface that defines how to map each variant of [ToolChoice] to a value of type [T].
         */
        interface Visitor<out T> {

            /**
             * Controls which tool the Responses backend uses when handling a task delegated by the
             * Live model.
             */
            fun visitLiveToolChoiceEnum(liveToolChoiceEnum: LiveToolChoiceEnum): T

            fun visitUnionMember1(unionMember1: UnionMember1): T

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

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<LiveToolChoiceEnum>())?.let {
                                ToolChoice(liveToolChoiceEnum = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<UnionMember1>())?.let {
                                ToolChoice(unionMember1 = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> ToolChoice(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<ToolChoice>(ToolChoice::class) {

            override fun serialize(
                value: ToolChoice,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.liveToolChoiceEnum != null ->
                        generator.writeObject(value.liveToolChoiceEnum)
                    value.unionMember1 != null -> generator.writeObject(value.unionMember1)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid ToolChoice")
                }
            }
        }

        /**
         * Controls which tool the Responses backend uses when handling a task delegated by the Live
         * model.
         */
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

        class UnionMember1
        @JsonCreator
        private constructor(
            @com.fasterxml.jackson.annotation.JsonValue
            private val additionalProperties: Map<String, JsonValue>
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [UnionMember1]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [UnionMember1]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(unionMember1: UnionMember1) = apply {
                    additionalProperties = unionMember1.additionalProperties.toMutableMap()
                }

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
                 * Returns an immutable instance of [UnionMember1].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): UnionMember1 = UnionMember1(additionalProperties.toImmutable())
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
            fun validate(): UnionMember1 = apply {
                if (validated) {
                    return@apply
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
                additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is UnionMember1 && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "UnionMember1{additionalProperties=$additionalProperties}"
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

        /**
         * Maps this instance's current variant to a value of type [T] using the given [visitor].
         *
         * Note that this method is _not_ forwards compatible with new variants from the API, unless
         * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of
         * the SDK gracefully, consider overriding [Visitor.unknown]:
         * ```java
         * import com.openai.core.JsonValue;
         * import java.util.Optional;
         *
         * Optional<String> result = tool.accept(new Tool.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitFunction(FunctionTool function) {
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
         * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor]
         *   and the current variant is unknown.
         */
        fun <T> accept(visitor: Visitor<T>): T =
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

            accept(
                object : Visitor<Unit> {
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
            accept(
                object : Visitor<Int> {
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
                applyPatch == other.applyPatch
        }

        override fun hashCode(): Int =
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
        interface Visitor<out T> {

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
             * Expected to always return the following:
             * ```java
             * JsonValue.from("shell")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun environment(): Optional<Environment> = environment.getOptional("environment")

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

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

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

                _type().let {
                    if (it != JsonValue.from("shell")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
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
                        local == other.local
                }

                override fun hashCode(): Int =
                    Objects.hash(containerAuto, containerReference, local)

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

                    fun visitContainerAuto(containerAuto: ContainerAuto): T

                    fun visitContainerReference(containerReference: ContainerReference): T

                    fun visitLocal(local: Local): T

                    /**
                     * Maps an unknown variant of [Environment] to a value of type [T].
                     *
                     * An instance of [Environment] can contain an unknown variant if it was
                     * deserialized from data that doesn't match any known variant. For example, if
                     * the SDK is on an older version than the API, then the API may respond with
                     * new variants that the SDK is unaware of.
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
                     * Automatically creates a container for this request
                     *
                     * Expected to always return the following:
                     * ```java
                     * JsonValue.from("container_auto")
                     * ```
                     *
                     * However, this method can be useful for debugging and logging (e.g. if the
                     * server responded with an unexpected value).
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                    /**
                     * An optional list of uploaded files to make available to your code.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun fileIds(): Optional<List<String>> = fileIds.getOptional("file_ids")

                    /**
                     * The memory limit for the container.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun memoryLimit(): Optional<MemoryLimit> =
                        memoryLimit.getOptional("memory_limit")

                    /**
                     * Network access policy for the container.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun networkPolicy(): Optional<NetworkPolicy> =
                        networkPolicy.getOptional("network_policy")

                    /**
                     * An optional list of skills referenced by id or inline data.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun skills(): Optional<List<Skill>> = skills.getOptional("skills")

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

                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> =
                        Collections.unmodifiableMap(additionalProperties)

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
                                (fileIds ?: JsonField.of(mutableListOf())).also {
                                    checkKnown("fileIds", it).add(fileId)
                                }
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
                                (skills ?: JsonField.of(mutableListOf())).also {
                                    checkKnown("skills", it).add(skill)
                                }
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

                        _type().let {
                            if (it != JsonValue.from("container_auto")) {
                                throw OpenAIInvalidDataException("'type' is invalid, received $it")
                            }
                        }
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
                                allowlist == other.allowlist
                        }

                        override fun hashCode(): Int = Objects.hash(disabled, allowlist)

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

                            fun visitDisabled(disabled: JsonValue): T

                            fun visitAllowlist(allowlist: Allowlist): T

                            /**
                             * Maps an unknown variant of [NetworkPolicy] to a value of type [T].
                             *
                             * An instance of [NetworkPolicy] can contain an unknown variant if it
                             * was deserialized from data that doesn't match any known variant. For
                             * example, if the SDK is on an older version than the API, then the API
                             * may respond with new variants that the SDK is unaware of.
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
                             * A list of allowed domains when type is `allowlist`.
                             *
                             * @throws OpenAIInvalidDataException if the JSON field has an
                             *   unexpected type or is unexpectedly missing or null (e.g. if the
                             *   server responded with an unexpected value).
                             */
                            fun allowedDomains(): List<String> =
                                allowedDomains.getRequired("allowed_domains")

                            /**
                             * Allow outbound network access only to specified domains. Always
                             * `allowlist`.
                             *
                             * Expected to always return the following:
                             * ```java
                             * JsonValue.from("allowlist")
                             * ```
                             *
                             * However, this method can be useful for debugging and logging (e.g. if
                             * the server responded with an unexpected value).
                             */
                            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

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

                            @JsonAnyGetter
                            @ExcludeMissing
                            fun _additionalProperties(): Map<String, JsonValue> =
                                Collections.unmodifiableMap(additionalProperties)

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

                                allowedDomains()
                                _type().let {
                                    if (it != JsonValue.from("allowlist")) {
                                        throw OpenAIInvalidDataException(
                                            "'type' is invalid, received $it"
                                        )
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
                                inline == other.inline
                        }

                        override fun hashCode(): Int = Objects.hash(reference, inline)

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

                            fun visitReference(reference: SkillReference): T

                            fun visitInline(inline: Inline): T

                            /**
                             * Maps an unknown variant of [Skill] to a value of type [T].
                             *
                             * An instance of [Skill] can contain an unknown variant if it was
                             * deserialized from data that doesn't match any known variant. For
                             * example, if the SDK is on an older version than the API, then the API
                             * may respond with new variants that the SDK is unaware of.
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
                             * The ID of the referenced skill.
                             *
                             * @throws OpenAIInvalidDataException if the JSON field has an
                             *   unexpected type or is unexpectedly missing or null (e.g. if the
                             *   server responded with an unexpected value).
                             */
                            fun skillId(): String = skillId.getRequired("skill_id")

                            /**
                             * References a skill created with the /v1/skills endpoint.
                             *
                             * Expected to always return the following:
                             * ```java
                             * JsonValue.from("skill_reference")
                             * ```
                             *
                             * However, this method can be useful for debugging and logging (e.g. if
                             * the server responded with an unexpected value).
                             */
                            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                            /**
                             * Optional skill version. Use a positive integer or 'latest'. Omit for
                             * default.
                             *
                             * @throws OpenAIInvalidDataException if the JSON field has an
                             *   unexpected type (e.g. if the server responded with an unexpected
                             *   value).
                             */
                            fun version(): Optional<String> = version.getOptional("version")

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

                            @JsonAnyGetter
                            @ExcludeMissing
                            fun _additionalProperties(): Map<String, JsonValue> =
                                Collections.unmodifiableMap(additionalProperties)

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

                                skillId()
                                _type().let {
                                    if (it != JsonValue.from("skill_reference")) {
                                        throw OpenAIInvalidDataException(
                                            "'type' is invalid, received $it"
                                        )
                                    }
                                }
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
                             * The description of the skill.
                             *
                             * @throws OpenAIInvalidDataException if the JSON field has an
                             *   unexpected type or is unexpectedly missing or null (e.g. if the
                             *   server responded with an unexpected value).
                             */
                            fun description(): String = description.getRequired("description")

                            /**
                             * The name of the skill.
                             *
                             * @throws OpenAIInvalidDataException if the JSON field has an
                             *   unexpected type or is unexpectedly missing or null (e.g. if the
                             *   server responded with an unexpected value).
                             */
                            fun name(): String = name.getRequired("name")

                            /**
                             * Inline skill payload
                             *
                             * @throws OpenAIInvalidDataException if the JSON field has an
                             *   unexpected type or is unexpectedly missing or null (e.g. if the
                             *   server responded with an unexpected value).
                             */
                            fun source(): Source = source.getRequired("source")

                            /**
                             * Defines an inline skill for this request.
                             *
                             * Expected to always return the following:
                             * ```java
                             * JsonValue.from("inline")
                             * ```
                             *
                             * However, this method can be useful for debugging and logging (e.g. if
                             * the server responded with an unexpected value).
                             */
                            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

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

                            @JsonAnyGetter
                            @ExcludeMissing
                            fun _additionalProperties(): Map<String, JsonValue> =
                                Collections.unmodifiableMap(additionalProperties)

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

                                description()
                                name()
                                source().validate()
                                _type().let {
                                    if (it != JsonValue.from("inline")) {
                                        throw OpenAIInvalidDataException(
                                            "'type' is invalid, received $it"
                                        )
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
                                 * Base64-encoded skill zip bundle.
                                 *
                                 * @throws OpenAIInvalidDataException if the JSON field has an
                                 *   unexpected type or is unexpectedly missing or null (e.g. if the
                                 *   server responded with an unexpected value).
                                 */
                                fun data(): String = data.getRequired("data")

                                /**
                                 * The media type of the inline skill payload. Must be
                                 * `application/zip`.
                                 *
                                 * Expected to always return the following:
                                 * ```java
                                 * JsonValue.from("application/zip")
                                 * ```
                                 *
                                 * However, this method can be useful for debugging and logging
                                 * (e.g. if the server responded with an unexpected value).
                                 */
                                @JsonProperty("media_type")
                                @ExcludeMissing
                                fun _mediaType(): JsonValue = mediaType

                                /**
                                 * The type of the inline skill source. Must be `base64`.
                                 *
                                 * Expected to always return the following:
                                 * ```java
                                 * JsonValue.from("base64")
                                 * ```
                                 *
                                 * However, this method can be useful for debugging and logging
                                 * (e.g. if the server responded with an unexpected value).
                                 */
                                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

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

                                @JsonAnyGetter
                                @ExcludeMissing
                                fun _additionalProperties(): Map<String, JsonValue> =
                                    Collections.unmodifiableMap(additionalProperties)

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

                                    data()
                                    _mediaType().let {
                                        if (it != JsonValue.from("application/zip")) {
                                            throw OpenAIInvalidDataException(
                                                "'mediaType' is invalid, received $it"
                                            )
                                        }
                                    }
                                    _type().let {
                                        if (it != JsonValue.from("base64")) {
                                            throw OpenAIInvalidDataException(
                                                "'type' is invalid, received $it"
                                            )
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
                     * The ID of the referenced container.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   or is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun containerId(): String = containerId.getRequired("container_id")

                    /**
                     * References a container created with the /v1/containers endpoint
                     *
                     * Expected to always return the following:
                     * ```java
                     * JsonValue.from("container_reference")
                     * ```
                     *
                     * However, this method can be useful for debugging and logging (e.g. if the
                     * server responded with an unexpected value).
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

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

                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> =
                        Collections.unmodifiableMap(additionalProperties)

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

                        containerId()
                        _type().let {
                            if (it != JsonValue.from("container_reference")) {
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
                     * Use a local computer environment.
                     *
                     * Expected to always return the following:
                     * ```java
                     * JsonValue.from("local")
                     * ```
                     *
                     * However, this method can be useful for debugging and logging (e.g. if the
                     * server responded with an unexpected value).
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                    /**
                     * An optional list of skills.
                     *
                     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun skills(): Optional<List<Skill>> = skills.getOptional("skills")

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

                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> =
                        Collections.unmodifiableMap(additionalProperties)

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
                                (skills ?: JsonField.of(mutableListOf())).also {
                                    checkKnown("skills", it).add(skill)
                                }
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

                        _type().let {
                            if (it != JsonValue.from("local")) {
                                throw OpenAIInvalidDataException("'type' is invalid, received $it")
                            }
                        }
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
                         * The description of the skill.
                         *
                         * @throws OpenAIInvalidDataException if the JSON field has an unexpected
                         *   type or is unexpectedly missing or null (e.g. if the server responded
                         *   with an unexpected value).
                         */
                        fun description(): String = description.getRequired("description")

                        /**
                         * The name of the skill.
                         *
                         * @throws OpenAIInvalidDataException if the JSON field has an unexpected
                         *   type or is unexpectedly missing or null (e.g. if the server responded
                         *   with an unexpected value).
                         */
                        fun name(): String = name.getRequired("name")

                        /**
                         * The path to the directory containing the skill.
                         *
                         * @throws OpenAIInvalidDataException if the JSON field has an unexpected
                         *   type or is unexpectedly missing or null (e.g. if the server responded
                         *   with an unexpected value).
                         */
                        fun path(): String = path.getRequired("path")

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

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> =
                            Collections.unmodifiableMap(additionalProperties)

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

                            description()
                            name()
                            path()
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
