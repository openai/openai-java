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
        private val liveFunctionToolChoiceParam: LiveFunctionToolChoiceParam? = null,
        private val liveMcpToolChoiceParam: LiveMcpToolChoiceParam? = null,
        private val _json: JsonValue? = null,
    ) {

        fun liveToolChoiceEnum(): Optional<LiveToolChoiceEnum> =
            Optional.ofNullable(liveToolChoiceEnum)

        fun liveFunctionToolChoiceParam(): Optional<LiveFunctionToolChoiceParam> =
            Optional.ofNullable(liveFunctionToolChoiceParam)

        fun liveMcpToolChoiceParam(): Optional<LiveMcpToolChoiceParam> =
            Optional.ofNullable(liveMcpToolChoiceParam)

        fun isLiveToolChoiceEnum(): Boolean = liveToolChoiceEnum != null

        fun isLiveFunctionToolChoiceParam(): Boolean = liveFunctionToolChoiceParam != null

        fun isLiveMcpToolChoiceParam(): Boolean = liveMcpToolChoiceParam != null

        fun asLiveToolChoiceEnum(): LiveToolChoiceEnum =
            liveToolChoiceEnum.getOrThrow("liveToolChoiceEnum")

        fun asLiveFunctionToolChoiceParam(): LiveFunctionToolChoiceParam =
            liveFunctionToolChoiceParam.getOrThrow("liveFunctionToolChoiceParam")

        fun asLiveMcpToolChoiceParam(): LiveMcpToolChoiceParam =
            liveMcpToolChoiceParam.getOrThrow("liveMcpToolChoiceParam")

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
                liveFunctionToolChoiceParam != null ->
                    visitor.visitLiveFunctionToolChoiceParam(liveFunctionToolChoiceParam)
                liveMcpToolChoiceParam != null ->
                    visitor.visitLiveMcpToolChoiceParam(liveMcpToolChoiceParam)
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

                    override fun visitLiveFunctionToolChoiceParam(
                        liveFunctionToolChoiceParam: LiveFunctionToolChoiceParam
                    ) = liveFunctionToolChoiceParam.validity()

                    override fun visitLiveMcpToolChoiceParam(
                        liveMcpToolChoiceParam: LiveMcpToolChoiceParam
                    ) = liveMcpToolChoiceParam.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ToolChoice &&
                liveToolChoiceEnum == other.liveToolChoiceEnum &&
                liveFunctionToolChoiceParam == other.liveFunctionToolChoiceParam &&
                liveMcpToolChoiceParam == other.liveMcpToolChoiceParam
        }

        override fun hashCode(): Int =
            Objects.hash(liveToolChoiceEnum, liveFunctionToolChoiceParam, liveMcpToolChoiceParam)

        override fun toString(): String =
            when {
                liveToolChoiceEnum != null -> "ToolChoice{liveToolChoiceEnum=$liveToolChoiceEnum}"
                liveFunctionToolChoiceParam != null ->
                    "ToolChoice{liveFunctionToolChoiceParam=$liveFunctionToolChoiceParam}"
                liveMcpToolChoiceParam != null ->
                    "ToolChoice{liveMcpToolChoiceParam=$liveMcpToolChoiceParam}"
                _json != null -> "ToolChoice{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid ToolChoice")
            }

        companion object {

            @JvmStatic
            fun ofLiveToolChoiceEnum(liveToolChoiceEnum: LiveToolChoiceEnum) =
                ToolChoice(liveToolChoiceEnum = liveToolChoiceEnum)

            @JvmStatic
            fun ofLiveFunctionToolChoiceParam(
                liveFunctionToolChoiceParam: LiveFunctionToolChoiceParam
            ) = ToolChoice(liveFunctionToolChoiceParam = liveFunctionToolChoiceParam)

            @JvmStatic
            fun ofLiveMcpToolChoiceParam(liveMcpToolChoiceParam: LiveMcpToolChoiceParam) =
                ToolChoice(liveMcpToolChoiceParam = liveMcpToolChoiceParam)
        }

        /**
         * An interface that defines how to map each variant of [ToolChoice] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitLiveToolChoiceEnum(liveToolChoiceEnum: LiveToolChoiceEnum): T

            fun visitLiveFunctionToolChoiceParam(
                liveFunctionToolChoiceParam: LiveFunctionToolChoiceParam
            ): T

            fun visitLiveMcpToolChoiceParam(liveMcpToolChoiceParam: LiveMcpToolChoiceParam): T

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
                throw OpenAIInvalidDataException("Unknown ToolChoice: $json")
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
                            tryDeserialize(node, jacksonTypeRef<LiveFunctionToolChoiceParam>())
                                ?.let {
                                    ToolChoice(liveFunctionToolChoiceParam = it, _json = json)
                                },
                            tryDeserialize(node, jacksonTypeRef<LiveMcpToolChoiceParam>())?.let {
                                ToolChoice(liveMcpToolChoiceParam = it, _json = json)
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
                    value.liveFunctionToolChoiceParam != null ->
                        generator.writeObject(value.liveFunctionToolChoiceParam)
                    value.liveMcpToolChoiceParam != null ->
                        generator.writeObject(value.liveMcpToolChoiceParam)
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
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Expected to always return the following:
             * ```java
             * JsonValue.from("function")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

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

                name()
                _type().let {
                    if (it != JsonValue.from("function")) {
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
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun serverLabel(): String = serverLabel.getRequired("server_label")

            /**
             * Expected to always return the following:
             * ```java
             * JsonValue.from("mcp")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

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

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

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

                name()
                serverLabel()
                _type().let {
                    if (it != JsonValue.from("mcp")) {
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
    }

    /** A function tool available to the Responses backend when the Live model delegates a task. */
    @JsonDeserialize(using = Tool.Deserializer::class)
    @JsonSerialize(using = Tool.Serializer::class)
    class Tool
    private constructor(
        private val function: FunctionTool? = null,
        private val webSearch: JsonValue? = null,
        private val _json: JsonValue? = null,
    ) {

        /**
         * A function tool available to the Responses backend when the Live model delegates a task.
         */
        fun function(): Optional<FunctionTool> = Optional.ofNullable(function)

        /** A web search tool available to the Live session’s Responses backend. */
        fun webSearch(): Optional<JsonValue> = Optional.ofNullable(webSearch)

        fun isFunction(): Boolean = function != null

        fun isWebSearch(): Boolean = webSearch != null

        /**
         * A function tool available to the Responses backend when the Live model delegates a task.
         */
        fun asFunction(): FunctionTool = function.getOrThrow("function")

        /** A web search tool available to the Live session’s Responses backend. */
        fun asWebSearch(): JsonValue = webSearch.getOrThrow("webSearch")

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

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Tool && function == other.function && webSearch == other.webSearch
        }

        override fun hashCode(): Int = Objects.hash(function, webSearch)

        override fun toString(): String =
            when {
                function != null -> "Tool{function=$function}"
                webSearch != null -> "Tool{webSearch=$webSearch}"
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
                throw OpenAIInvalidDataException("Unknown Tool: $json")
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
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Tool")
                }
            }
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
