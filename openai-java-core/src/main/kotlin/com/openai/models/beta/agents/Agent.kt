// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

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

/** A reusable agent scoped to the caller's project. */
class Agent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<Long>,
    private val instructions: JsonField<String>,
    private val metadata: JsonField<Metadata>,
    private val model: JsonField<String>,
    private val multiAgent: JsonField<MultiAgentConfig>,
    private val name: JsonField<String>,
    private val object_: JsonValue,
    private val reasoning: JsonField<AgentReasoning>,
    private val serviceTier: JsonField<ServiceTier>,
    private val text: JsonField<AgentText>,
    private val tools: JsonField<List<PersistedAgentTool>>,
    private val updatedAt: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("instructions")
        @ExcludeMissing
        instructions: JsonField<String> = JsonMissing.of(),
        @JsonProperty("metadata") @ExcludeMissing metadata: JsonField<Metadata> = JsonMissing.of(),
        @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
        @JsonProperty("multi_agent")
        @ExcludeMissing
        multiAgent: JsonField<MultiAgentConfig> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("reasoning")
        @ExcludeMissing
        reasoning: JsonField<AgentReasoning> = JsonMissing.of(),
        @JsonProperty("service_tier")
        @ExcludeMissing
        serviceTier: JsonField<ServiceTier> = JsonMissing.of(),
        @JsonProperty("text") @ExcludeMissing text: JsonField<AgentText> = JsonMissing.of(),
        @JsonProperty("tools")
        @ExcludeMissing
        tools: JsonField<List<PersistedAgentTool>> = JsonMissing.of(),
        @JsonProperty("updated_at") @ExcludeMissing updatedAt: JsonField<Long> = JsonMissing.of(),
    ) : this(
        id,
        createdAt,
        instructions,
        metadata,
        model,
        multiAgent,
        name,
        object_,
        reasoning,
        serviceTier,
        text,
        tools,
        updatedAt,
        mutableMapOf(),
    )

    /**
     * The ID of the reusable agent.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The Unix timestamp, in seconds, when the agent was created.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /**
     * Custom instructions appended to the agent's default base instructions.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun instructions(): Optional<String> = instructions.getOptional("instructions")

    /**
     * Custom string key-value pairs attached to the agent.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun metadata(): Metadata = metadata.getRequired("metadata")

    /**
     * The requested model name used for inference.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun model(): String = model.getRequired("model")

    /**
     * The resolved configuration for creating and coordinating subagents.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun multiAgent(): MultiAgentConfig = multiAgent.getRequired("multi_agent")

    /**
     * A human-readable name for the agent, or null if it is unnamed.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = name.getOptional("name")

    /**
     * The object type. Always `agent`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("agent")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * The resolved reasoning configuration, including the model default for an omitted effort.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun reasoning(): AgentReasoning = reasoning.getRequired("reasoning")

    /**
     * The resolved service-tier policy used for model requests.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun serviceTier(): ServiceTier = serviceTier.getRequired("service_tier")

    /**
     * The resolved configuration for text generated by the agent.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun text(): AgentText = text.getRequired("text")

    /**
     * Tools available to the agent.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun tools(): List<PersistedAgentTool> = tools.getRequired("tools")

    /**
     * The Unix timestamp, in seconds, when the agent was last updated.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun updatedAt(): Long = updatedAt.getRequired("updated_at")

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
     * Returns the raw JSON value of [instructions].
     *
     * Unlike [instructions], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("instructions")
    @ExcludeMissing
    fun _instructions(): JsonField<String> = instructions

    /**
     * Returns the raw JSON value of [metadata].
     *
     * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonField<Metadata> = metadata

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
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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
    @JsonProperty("tools") @ExcludeMissing fun _tools(): JsonField<List<PersistedAgentTool>> = tools

    /**
     * Returns the raw JSON value of [updatedAt].
     *
     * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updated_at") @ExcludeMissing fun _updatedAt(): JsonField<Long> = updatedAt

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
         * Returns a mutable builder for constructing an instance of [Agent].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .instructions()
         * .metadata()
         * .model()
         * .multiAgent()
         * .name()
         * .reasoning()
         * .serviceTier()
         * .text()
         * .tools()
         * .updatedAt()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Agent]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<Long>? = null
        private var instructions: JsonField<String>? = null
        private var metadata: JsonField<Metadata>? = null
        private var model: JsonField<String>? = null
        private var multiAgent: JsonField<MultiAgentConfig>? = null
        private var name: JsonField<String>? = null
        private var object_: JsonValue = JsonValue.from("agent")
        private var reasoning: JsonField<AgentReasoning>? = null
        private var serviceTier: JsonField<ServiceTier>? = null
        private var text: JsonField<AgentText>? = null
        private var tools: JsonField<MutableList<PersistedAgentTool>>? = null
        private var updatedAt: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(agent: Agent) = apply {
            id = agent.id
            createdAt = agent.createdAt
            instructions = agent.instructions
            metadata = agent.metadata
            model = agent.model
            multiAgent = agent.multiAgent
            name = agent.name
            object_ = agent.object_
            reasoning = agent.reasoning
            serviceTier = agent.serviceTier
            text = agent.text
            tools = agent.tools.map { it.toMutableList() }
            updatedAt = agent.updatedAt
            additionalProperties = agent.additionalProperties.toMutableMap()
        }

        /** The ID of the reusable agent. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The Unix timestamp, in seconds, when the agent was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /** Custom instructions appended to the agent's default base instructions. */
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

        /** Custom string key-value pairs attached to the agent. */
        fun metadata(metadata: Metadata) = metadata(JsonField.of(metadata))

        /**
         * Sets [Builder.metadata] to an arbitrary JSON value.
         *
         * You should usually call [Builder.metadata] with a well-typed [Metadata] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

        /** The requested model name used for inference. */
        fun model(model: String) = model(JsonField.of(model))

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(model: JsonField<String>) = apply { this.model = model }

        /** The resolved configuration for creating and coordinating subagents. */
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

        /** A human-readable name for the agent, or null if it is unnamed. */
        fun name(name: String?) = name(JsonField.ofNullable(name))

        /** Alias for calling [Builder.name] with `name.orElse(null)`. */
        fun name(name: Optional<String>) = name(name.getOrNull())

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("agent")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /**
         * The resolved reasoning configuration, including the model default for an omitted effort.
         */
        fun reasoning(reasoning: AgentReasoning) = reasoning(JsonField.of(reasoning))

        /**
         * Sets [Builder.reasoning] to an arbitrary JSON value.
         *
         * You should usually call [Builder.reasoning] with a well-typed [AgentReasoning] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun reasoning(reasoning: JsonField<AgentReasoning>) = apply { this.reasoning = reasoning }

        /** The resolved service-tier policy used for model requests. */
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

        /** The resolved configuration for text generated by the agent. */
        fun text(text: AgentText) = text(JsonField.of(text))

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [AgentText] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun text(text: JsonField<AgentText>) = apply { this.text = text }

        /** Tools available to the agent. */
        fun tools(tools: List<PersistedAgentTool>) = tools(JsonField.of(tools))

        /**
         * Sets [Builder.tools] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tools] with a well-typed `List<PersistedAgentTool>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun tools(tools: JsonField<List<PersistedAgentTool>>) = apply {
            this.tools = tools.map { it.toMutableList() }
        }

        /**
         * Adds a single [PersistedAgentTool] to [tools].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTool(tool: PersistedAgentTool) = apply {
            tools =
                (tools ?: JsonField.of(mutableListOf())).also { checkKnown("tools", it).add(tool) }
        }

        /** Alias for calling [addTool] with `PersistedAgentTool.ofFunction(function)`. */
        fun addTool(function: PersistedAgentTool.Function) =
            addTool(PersistedAgentTool.ofFunction(function))

        /** Alias for calling [addTool] with `PersistedAgentTool.ofToolSearch()`. */
        fun addToolToolSearch() = addTool(PersistedAgentTool.ofToolSearch())

        /**
         * Alias for calling [addTool] with
         * `PersistedAgentTool.ofProgrammaticToolCalling(programmaticToolCalling)`.
         */
        fun addTool(programmaticToolCalling: PersistedAgentTool.ProgrammaticToolCalling) =
            addTool(PersistedAgentTool.ofProgrammaticToolCalling(programmaticToolCalling))

        /**
         * Alias for calling [addTool] with the following:
         * ```java
         * PersistedAgentTool.ProgrammaticToolCalling.builder()
         *     .enabled(enabled)
         *     .build()
         * ```
         */
        fun addProgrammaticToolCallingTool(enabled: Boolean) =
            addTool(PersistedAgentTool.ProgrammaticToolCalling.builder().enabled(enabled).build())

        /** Alias for calling [addTool] with `PersistedAgentTool.ofMcp(mcp)`. */
        fun addTool(mcp: PersistedAgentTool.Mcp) = addTool(PersistedAgentTool.ofMcp(mcp))

        /** Alias for calling [addTool] with `PersistedAgentTool.ofWebSearch(webSearch)`. */
        fun addTool(webSearch: PersistedAgentTool.WebSearch) =
            addTool(PersistedAgentTool.ofWebSearch(webSearch))

        /** The Unix timestamp, in seconds, when the agent was last updated. */
        fun updatedAt(updatedAt: Long) = updatedAt(JsonField.of(updatedAt))

        /**
         * Sets [Builder.updatedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updatedAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun updatedAt(updatedAt: JsonField<Long>) = apply { this.updatedAt = updatedAt }

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
         * Returns an immutable instance of [Agent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .instructions()
         * .metadata()
         * .model()
         * .multiAgent()
         * .name()
         * .reasoning()
         * .serviceTier()
         * .text()
         * .tools()
         * .updatedAt()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Agent =
            Agent(
                checkRequired("id", id),
                checkRequired("createdAt", createdAt),
                checkRequired("instructions", instructions),
                checkRequired("metadata", metadata),
                checkRequired("model", model),
                checkRequired("multiAgent", multiAgent),
                checkRequired("name", name),
                object_,
                checkRequired("reasoning", reasoning),
                checkRequired("serviceTier", serviceTier),
                checkRequired("text", text),
                checkRequired("tools", tools).map { it.toImmutable() },
                checkRequired("updatedAt", updatedAt),
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
    fun validate(): Agent = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        instructions()
        metadata().validate()
        model()
        multiAgent().validate()
        name()
        _object_().let {
            if (it != JsonValue.from("agent")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        reasoning().validate()
        serviceTier().validate()
        text().validate()
        tools().forEach { it.validate() }
        updatedAt()
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
            (if (instructions.asKnown().isPresent) 1 else 0) +
            (metadata.asKnown().getOrNull()?.validity() ?: 0) +
            (if (model.asKnown().isPresent) 1 else 0) +
            (multiAgent.asKnown().getOrNull()?.validity() ?: 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("agent")) 1 else 0 } +
            (reasoning.asKnown().getOrNull()?.validity() ?: 0) +
            (serviceTier.asKnown().getOrNull()?.validity() ?: 0) +
            (text.asKnown().getOrNull()?.validity() ?: 0) +
            (tools.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0)

    /** Custom string key-value pairs attached to the agent. */
    class Metadata
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

            /** Returns a mutable builder for constructing an instance of [Metadata]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Metadata]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(metadata: Metadata) = apply {
                additionalProperties = metadata.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Metadata].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Metadata = Metadata(additionalProperties.toImmutable())
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
        fun validate(): Metadata = apply {
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

            return other is Metadata && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Metadata{additionalProperties=$additionalProperties}"
    }

    /** The resolved service-tier policy used for model requests. */
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

            @JvmStatic fun of(value: String) = ServiceTier(JsonField.of(value))
        }

        /** An enum containing [ServiceTier]'s known values. */
        enum class Known {
            AUTO,
            DEFAULT,
            FLEX,
            PRIORITY,
            FAST,
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
            FLEX,
            PRIORITY,
            FAST,
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
                FLEX -> Value.FLEX
                PRIORITY -> Value.PRIORITY
                FAST -> Value.FAST
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
                FLEX -> Known.FLEX
                PRIORITY -> Known.PRIORITY
                FAST -> Known.FAST
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Agent &&
            id == other.id &&
            createdAt == other.createdAt &&
            instructions == other.instructions &&
            metadata == other.metadata &&
            model == other.model &&
            multiAgent == other.multiAgent &&
            name == other.name &&
            object_ == other.object_ &&
            reasoning == other.reasoning &&
            serviceTier == other.serviceTier &&
            text == other.text &&
            tools == other.tools &&
            updatedAt == other.updatedAt &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            createdAt,
            instructions,
            metadata,
            model,
            multiAgent,
            name,
            object_,
            reasoning,
            serviceTier,
            text,
            tools,
            updatedAt,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Agent{id=$id, createdAt=$createdAt, instructions=$instructions, metadata=$metadata, model=$model, multiAgent=$multiAgent, name=$name, object_=$object_, reasoning=$reasoning, serviceTier=$serviceTier, text=$text, tools=$tools, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
}
