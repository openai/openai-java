// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.automations

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonNull
import com.openai.core.JsonValue
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.collectAllProperties
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.beta.agents.AgentReasoning
import com.openai.models.beta.agents.AgentText
import com.openai.models.beta.agents.AgentTool
import com.openai.models.beta.agents.MultiAgentConfig
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Inline agent configuration without a generated session-local identity. */
class AutomationAgentConfig
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val instructions: JsonField<String>,
    private val model: JsonField<String>,
    private val multiAgent: JsonField<MultiAgentConfig>,
    private val reasoning: JsonField<AgentReasoning>,
    private val serviceTier: JsonField<ServiceTier>,
    private val text: JsonField<AgentText>,
    private val tools: JsonField<List<AgentTool>>,
    private val compaction: JsonField<Compaction>,
    private val experimental: JsonField<Experimental>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("instructions")
        @ExcludeMissing
        instructions: JsonField<String> = JsonMissing.of(),
        @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
        @JsonProperty("multi_agent")
        @ExcludeMissing
        multiAgent: JsonField<MultiAgentConfig> = JsonMissing.of(),
        @JsonProperty("reasoning")
        @ExcludeMissing
        reasoning: JsonField<AgentReasoning> = JsonMissing.of(),
        @JsonProperty("service_tier")
        @ExcludeMissing
        serviceTier: JsonField<ServiceTier> = JsonMissing.of(),
        @JsonProperty("text") @ExcludeMissing text: JsonField<AgentText> = JsonMissing.of(),
        @JsonProperty("tools") @ExcludeMissing tools: JsonField<List<AgentTool>> = JsonMissing.of(),
        @JsonProperty("compaction")
        @ExcludeMissing
        compaction: JsonField<Compaction> = JsonMissing.of(),
        @JsonProperty("experimental")
        @ExcludeMissing
        experimental: JsonField<Experimental> = JsonMissing.of(),
    ) : this(
        instructions,
        model,
        multiAgent,
        reasoning,
        serviceTier,
        text,
        tools,
        compaction,
        experimental,
        mutableMapOf(),
    )

    /**
     * Custom instructions, or null when absent. The schema requires this property. Returns empty if
     * the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun instructions(): java.util.Optional<String> = instructions.getOptional("instructions")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun instructionsOrThrow(): String = instructions.getRequired("instructions")

    /**
     * The requested model name. The schema requires this property. Returns empty if the JSON
     * property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun model(): java.util.Optional<String> = model.getOptional("model")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun modelOrThrow(): String = model.getRequired("model")

    /**
     * The configuration for creating and coordinating subagents. The schema requires this property.
     * Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun multiAgent(): java.util.Optional<MultiAgentConfig> = multiAgent.getOptional("multi_agent")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun multiAgentOrThrow(): MultiAgentConfig = multiAgent.getRequired("multi_agent")

    /**
     * The configured reasoning policy. The schema requires this property. Returns empty if the JSON
     * property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun reasoning(): java.util.Optional<AgentReasoning> = reasoning.getOptional("reasoning")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun reasoningOrThrow(): AgentReasoning = reasoning.getRequired("reasoning")

    /**
     * The configured service-tier policy. The schema requires this property. Returns empty if the
     * JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun serviceTier(): java.util.Optional<ServiceTier> = serviceTier.getOptional("service_tier")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun serviceTierOrThrow(): ServiceTier = serviceTier.getRequired("service_tier")

    /**
     * The configured output format and verbosity. The schema requires this property. Returns empty
     * if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun text(): java.util.Optional<AgentText> = text.getOptional("text")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun textOrThrow(): AgentText = text.getRequired("text")

    /**
     * Configured tools, excluding confidential credentials. The schema requires this property.
     * Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun tools(): java.util.Optional<List<AgentTool>> = tools.getOptional("tools")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun toolsOrThrow(): List<AgentTool> = tools.getRequired("tools")

    /**
     * The effective context compaction settings. Returns empty if the JSON property is missing or
     * null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun compaction(): java.util.Optional<Compaction> = compaction.getOptional("compaction")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun compactionOrThrow(): Compaction = compaction.getRequired("compaction")

    /**
     * The effective experimental settings for the agent. Returns empty if the JSON property is
     * missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun experimental(): java.util.Optional<Experimental> = experimental.getOptional("experimental")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun experimentalOrThrow(): Experimental = experimental.getRequired("experimental")

    /**
     * Returns the raw JSON value of [instructions].
     *
     * Unlike [instructions], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("instructions")
    @ExcludeMissing
    fun _instructions(): JsonField<String> = instructions

    /**
     * Returns the raw JSON value of [model].
     *
     * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

    /**
     * Returns the raw JSON value of [multiAgent].
     *
     * Unlike [multiAgent], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("multi_agent")
    @ExcludeMissing
    fun _multiAgent(): JsonField<MultiAgentConfig> = multiAgent

    /**
     * Returns the raw JSON value of [reasoning].
     *
     * Unlike [reasoning], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("reasoning")
    @ExcludeMissing
    fun _reasoning(): JsonField<AgentReasoning> = reasoning

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
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<AgentText> = text

    /**
     * Returns the raw JSON value of [tools].
     *
     * Unlike [tools], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tools") @ExcludeMissing fun _tools(): JsonField<List<AgentTool>> = tools

    /**
     * Returns the raw JSON value of [compaction].
     *
     * Unlike [compaction], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("compaction")
    @ExcludeMissing
    fun _compaction(): JsonField<Compaction> = compaction

    /**
     * Returns the raw JSON value of [experimental].
     *
     * Unlike [experimental], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("experimental")
    @ExcludeMissing
    fun _experimental(): JsonField<Experimental> = experimental

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
            "instructions" to this.instructions,
            "model" to this.model,
            "multi_agent" to this.multiAgent,
            "reasoning" to this.reasoning,
            "service_tier" to this.serviceTier,
            "text" to this.text,
            "tools" to this.tools,
            "compaction" to this.compaction,
            "experimental" to this.experimental,
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
         * Returns a mutable builder for constructing an instance of [AutomationAgentConfig].
         *
         * The following fields are required:
         * ```java
         * .model()
         * .multiAgent()
         * .reasoning()
         * .serviceTier()
         * .text()
         * .tools()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AutomationAgentConfig]. */
    class Builder internal constructor() {

        private var instructions: JsonField<String>? = JsonNull.of()
        private var model: JsonField<String>? = null
        private var multiAgent: JsonField<MultiAgentConfig>? = null
        private var reasoning: JsonField<AgentReasoning>? = null
        private var serviceTier: JsonField<ServiceTier>? = null
        private var text: JsonField<AgentText>? = null
        private var tools: JsonField<MutableList<AgentTool>>? = null
        private var compaction: JsonField<Compaction> = JsonMissing.of()
        private var experimental: JsonField<Experimental> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(automationAgentConfig: AutomationAgentConfig) = apply {
            instructions = automationAgentConfig.instructions
            model = automationAgentConfig.model
            multiAgent = automationAgentConfig.multiAgent
            reasoning = automationAgentConfig.reasoning
            serviceTier = automationAgentConfig.serviceTier
            text = automationAgentConfig.text
            tools = automationAgentConfig.tools.map { it.toMutableList() }
            compaction = automationAgentConfig.compaction
            experimental = automationAgentConfig.experimental
            additionalProperties = automationAgentConfig.additionalProperties.toMutableMap()
        }

        /** Custom instructions, or null when absent. */
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

        /** The requested model name. */
        fun model(model: String) = model(JsonField.of(model))

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(model: JsonField<String>) = apply { this.model = model }

        /** The configuration for creating and coordinating subagents. */
        fun multiAgent(multiAgent: MultiAgentConfig) = multiAgent(JsonField.of(multiAgent))

        /**
         * Sets [Builder.multiAgent] to an arbitrary JSON value.
         *
         * You should usually call [Builder.multiAgent] with a well-typed [MultiAgentConfig] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun multiAgent(multiAgent: JsonField<MultiAgentConfig>) = apply {
            this.multiAgent = multiAgent
        }

        /** The configured reasoning policy. */
        fun reasoning(reasoning: AgentReasoning) = reasoning(JsonField.of(reasoning))

        /**
         * Sets [Builder.reasoning] to an arbitrary JSON value.
         *
         * You should usually call [Builder.reasoning] with a well-typed [AgentReasoning] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun reasoning(reasoning: JsonField<AgentReasoning>) = apply { this.reasoning = reasoning }

        /** The configured service-tier policy. */
        fun serviceTier(serviceTier: ServiceTier) = serviceTier(JsonField.of(serviceTier))

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

        /** The configured output format and verbosity. */
        fun text(text: AgentText) = text(JsonField.of(text))

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [AgentText] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun text(text: JsonField<AgentText>) = apply { this.text = text }

        /** Configured tools, excluding confidential credentials. */
        fun tools(tools: List<AgentTool>) = tools(JsonField.of(tools))

        /**
         * Sets [Builder.tools] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tools] with a well-typed `List<AgentTool>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun tools(tools: JsonField<List<AgentTool>>) = apply {
            this.tools = tools.map { it.toMutableList() }
        }

        /**
         * Adds a single [AgentTool] to [tools].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTool(tool: AgentTool) = apply {
            tools =
                (tools ?: JsonField.of(mutableListOf())).also { checkKnown("tools", it).add(tool) }
        }

        /** Alias for calling [addTool] with `AgentTool.ofFunction(function)`. */
        fun addTool(function: AgentTool.Function) = addTool(AgentTool.ofFunction(function))

        /**
         * Alias for calling [addTool] with
         * `AgentTool.ofProgrammaticToolCalling(programmaticToolCalling)`.
         */
        fun addTool(programmaticToolCalling: AgentTool.ProgrammaticToolCalling) =
            addTool(AgentTool.ofProgrammaticToolCalling(programmaticToolCalling))

        /**
         * Alias for calling [addTool] with the following:
         * ```java
         * AgentTool.ProgrammaticToolCalling.builder()
         *     .enabled(enabled)
         *     .build()
         * ```
         */
        fun addProgrammaticToolCallingTool(enabled: Boolean) =
            addTool(AgentTool.ProgrammaticToolCalling.builder().enabled(enabled).build())

        /** Alias for calling [addTool] with `AgentTool.ofMcp(mcp)`. */
        fun addTool(mcp: AgentTool.Mcp) = addTool(AgentTool.ofMcp(mcp))

        /** Alias for calling [addTool] with `AgentTool.ofWebSearch(webSearch)`. */
        fun addTool(webSearch: AgentTool.WebSearch) = addTool(AgentTool.ofWebSearch(webSearch))

        /** Alias for calling [addTool] with `AgentTool.ofComputerUse(computerUse)`. */
        fun addTool(computerUse: AgentTool.ComputerUse) =
            addTool(AgentTool.ofComputerUse(computerUse))

        /**
         * Alias for calling [addTool] with the following:
         * ```java
         * AgentTool.ComputerUse.builder()
         *     .includeScreenshots(includeScreenshots)
         *     .build()
         * ```
         */
        fun addComputerUseTool(includeScreenshots: Boolean) =
            addTool(AgentTool.ComputerUse.builder().includeScreenshots(includeScreenshots).build())

        /** Alias for calling [addTool] with `AgentTool.ofAutomations()`. */
        fun addToolAutomations() = addTool(AgentTool.ofAutomations())

        /** The effective context compaction settings. */
        fun compaction(compaction: Compaction) = compaction(JsonField.of(compaction))

        /**
         * Sets [Builder.compaction] to an arbitrary JSON value.
         *
         * You should usually call [Builder.compaction] with a well-typed [Compaction] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun compaction(compaction: JsonField<Compaction>) = apply { this.compaction = compaction }

        /** The effective experimental settings for the agent. */
        fun experimental(experimental: Experimental) = experimental(JsonField.of(experimental))

        /**
         * Sets [Builder.experimental] to an arbitrary JSON value.
         *
         * You should usually call [Builder.experimental] with a well-typed [Experimental] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun experimental(experimental: JsonField<Experimental>) = apply {
            this.experimental = experimental
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
         * Returns an immutable instance of [AutomationAgentConfig].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .model()
         * .multiAgent()
         * .reasoning()
         * .serviceTier()
         * .text()
         * .tools()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AutomationAgentConfig =
            AutomationAgentConfig(
                checkRequired("instructions", instructions),
                checkRequired("model", model),
                checkRequired("multiAgent", multiAgent),
                checkRequired("reasoning", reasoning),
                checkRequired("serviceTier", serviceTier),
                checkRequired("text", text),
                checkRequired("tools", tools).map { it.toImmutable() },
                compaction,
                experimental,
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
    fun validate(): AutomationAgentConfig = apply {
        if (validated) {
            return@apply
        }

        instructions()
        modelOrThrow()
        multiAgentOrThrow().validate()
        reasoningOrThrow().validate()
        serviceTierOrThrow().validate()
        textOrThrow().validate()
        toolsOrThrow().forEach { it.validate() }
        compaction().ifPresent { it.validate() }
        experimental().ifPresent { it.validate() }
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
        (if (instructions.asKnown().isPresent) 1 else 0) +
            (if (model.asKnown().isPresent) 1 else 0) +
            (multiAgent.asKnown().getOrNull()?.validity() ?: 0) +
            (reasoning.asKnown().getOrNull()?.validity() ?: 0) +
            (serviceTier.asKnown().getOrNull()?.validity() ?: 0) +
            (text.asKnown().getOrNull()?.validity() ?: 0) +
            (tools.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (compaction.asKnown().getOrNull()?.validity() ?: 0) +
            (experimental.asKnown().getOrNull()?.validity() ?: 0)

    /** The configured service-tier policy. */
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

            @JvmField val FLEX = of("flex")

            @JvmField val PRIORITY = of("priority")

            @JvmField val FAST = of("fast")

            @JvmField val ULTRAFAST = of("ultrafast")

            @JvmStatic fun of(value: String) = ServiceTier(JsonField.of(value))
        }

        /** An enum containing [ServiceTier]'s known values. */
        @Deprecated("Use asString() for string values or _value() for raw JSON.")
        enum class Known {
            AUTO,
            DEFAULT,
            FLEX,
            PRIORITY,
            FAST,
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
            FLEX,
            PRIORITY,
            FAST,
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
                FLEX -> Value.FLEX
                PRIORITY -> Value.PRIORITY
                FAST -> Value.FAST
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
                FLEX -> Known.FLEX
                PRIORITY -> Known.PRIORITY
                FAST -> Known.FAST
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

    /** The effective context compaction settings. */
    class Compaction
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val async: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("async") @ExcludeMissing async: JsonField<Boolean> = JsonMissing.of()
        ) : this(async, mutableMapOf())

        /**
         * Whether context is compacted in the background. Defaults to true. The schema requires
         * this property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun async(): java.util.Optional<Boolean> = async.getOptional("async")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun asyncOrThrow(): Boolean = async.getRequired("async")

        /**
         * Returns the raw JSON value of [async].
         *
         * Unlike [async], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("async") @ExcludeMissing fun _async(): JsonField<Boolean> = async

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
            collectAllProperties(additionalProperties, "async" to this.async)

        @JvmSynthetic
        internal fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        @JsonAnyGetter
        @ExcludeMissing
        private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Compaction].
             *
             * The following fields are required:
             * ```java
             * .async()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Compaction]. */
        class Builder internal constructor() {

            private var async: JsonField<Boolean>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(compaction: Compaction) = apply {
                async = compaction.async
                additionalProperties = compaction.additionalProperties.toMutableMap()
            }

            /** Whether context is compacted in the background. Defaults to true. */
            fun async(async: Boolean) = async(JsonField.of(async))

            /**
             * Sets [Builder.async] to an arbitrary JSON value.
             *
             * You should usually call [Builder.async] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun async(async: JsonField<Boolean>) = apply { this.async = async }

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
             * Returns an immutable instance of [Compaction].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .async()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Compaction =
                Compaction(checkRequired("async", async), additionalProperties.toMutableMap())
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
        fun validate(): Compaction = apply {
            if (validated) {
                return@apply
            }

            asyncOrThrow()
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
        @JvmSynthetic internal fun validity(): Int = (if (async.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Compaction &&
                async == other.async &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(async, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Compaction{async=$async, additionalProperties=$additionalProperties}"
    }

    /** The effective experimental settings for the agent. */
    class Experimental
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val timeAwareness: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("time_awareness")
            @ExcludeMissing
            timeAwareness: JsonField<Boolean> = JsonMissing.of()
        ) : this(timeAwareness, mutableMapOf())

        /**
         * Whether the model receives periodic current-time reminders. The schema requires this
         * property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun timeAwareness(): java.util.Optional<Boolean> =
            timeAwareness.getOptional("time_awareness")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun timeAwarenessOrThrow(): Boolean = timeAwareness.getRequired("time_awareness")

        /**
         * Returns the raw JSON value of [timeAwareness].
         *
         * Unlike [timeAwareness], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("time_awareness")
        @ExcludeMissing
        fun _timeAwareness(): JsonField<Boolean> = timeAwareness

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
            collectAllProperties(additionalProperties, "time_awareness" to this.timeAwareness)

        @JvmSynthetic
        internal fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        @JsonAnyGetter
        @ExcludeMissing
        private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Experimental].
             *
             * The following fields are required:
             * ```java
             * .timeAwareness()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Experimental]. */
        class Builder internal constructor() {

            private var timeAwareness: JsonField<Boolean>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(experimental: Experimental) = apply {
                timeAwareness = experimental.timeAwareness
                additionalProperties = experimental.additionalProperties.toMutableMap()
            }

            /** Whether the model receives periodic current-time reminders. */
            fun timeAwareness(timeAwareness: Boolean) = timeAwareness(JsonField.of(timeAwareness))

            /**
             * Sets [Builder.timeAwareness] to an arbitrary JSON value.
             *
             * You should usually call [Builder.timeAwareness] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun timeAwareness(timeAwareness: JsonField<Boolean>) = apply {
                this.timeAwareness = timeAwareness
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
             * Returns an immutable instance of [Experimental].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .timeAwareness()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Experimental =
                Experimental(
                    checkRequired("timeAwareness", timeAwareness),
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
        fun validate(): Experimental = apply {
            if (validated) {
                return@apply
            }

            timeAwarenessOrThrow()
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
        internal fun validity(): Int = (if (timeAwareness.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Experimental &&
                timeAwareness == other.timeAwareness &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(timeAwareness, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Experimental{timeAwareness=$timeAwareness, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AutomationAgentConfig &&
            instructions == other.instructions &&
            model == other.model &&
            multiAgent == other.multiAgent &&
            reasoning == other.reasoning &&
            serviceTier == other.serviceTier &&
            text == other.text &&
            tools == other.tools &&
            compaction == other.compaction &&
            experimental == other.experimental &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            instructions,
            model,
            multiAgent,
            reasoning,
            serviceTier,
            text,
            tools,
            compaction,
            experimental,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AutomationAgentConfig{instructions=$instructions, model=$model, multiAgent=$multiAgent, reasoning=$reasoning, serviceTier=$serviceTier, text=$text, tools=$tools, compaction=$compaction, experimental=$experimental, additionalProperties=$additionalProperties}"
}
