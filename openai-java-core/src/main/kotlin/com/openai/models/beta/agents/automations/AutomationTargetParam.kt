// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.automations

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
import com.openai.models.beta.agents.AgentReasoningParam
import com.openai.models.beta.agents.AgentSessionInputMessageParam
import com.openai.models.beta.agents.AgentTextParam
import com.openai.models.beta.agents.AgentToolParam
import com.openai.models.beta.agents.EnvironmentParam
import com.openai.models.beta.agents.MultiAgentConfigParam
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** The session an automation invocation targets. */
@JsonDeserialize(using = AutomationTargetParam.Deserializer::class)
@JsonSerialize(using = AutomationTargetParam.Serializer::class)
class AutomationTargetParam
private constructor(
    private val newSession: NewSession? = null,
    private val existingSession: ExistingSession? = null,
    private val _json: JsonValue? = null,
) {

    /** Create a session for each invocation. */
    fun newSession(): Optional<NewSession> = Optional.ofNullable(newSession)

    /** Deliver instructions to an existing session. */
    fun existingSession(): Optional<ExistingSession> = Optional.ofNullable(existingSession)

    fun isNewSession(): Boolean = newSession != null

    fun isExistingSession(): Boolean = existingSession != null

    /** Create a session for each invocation. */
    fun asNewSession(): NewSession = newSession.getOrThrow("newSession")

    /** Deliver instructions to an existing session. */
    fun asExistingSession(): ExistingSession = existingSession.getOrThrow("existingSession")

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
     * Optional<String> result = automationTargetParam.accept(new AutomationTargetParam.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitNewSession(NewSession newSession) {
     *         return Optional.of(newSession.toString());
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
            newSession != null -> visitor.visitNewSession(newSession)
            existingSession != null -> visitor.visitExistingSession(existingSession)
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
    fun validate(): AutomationTargetParam = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitNewSession(newSession: NewSession) {
                    newSession.validate()
                }

                override fun visitExistingSession(existingSession: ExistingSession) {
                    existingSession.validate()
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
                override fun visitNewSession(newSession: NewSession) = newSession.validity()

                override fun visitExistingSession(existingSession: ExistingSession) =
                    existingSession.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AutomationTargetParam &&
            newSession == other.newSession &&
            existingSession == other.existingSession &&
            (newSession != null || existingSession != null || _json == other._json)
    }

    override fun hashCode(): Int =
        if (newSession == null && existingSession == null) Objects.hash(_json)
        else Objects.hash(newSession, existingSession)

    override fun toString(): String =
        when {
            newSession != null -> "AutomationTargetParam{newSession=$newSession}"
            existingSession != null -> "AutomationTargetParam{existingSession=$existingSession}"
            _json != null -> "AutomationTargetParam{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid AutomationTargetParam")
        }

    companion object {

        /** Create a session for each invocation. */
        @JvmStatic
        fun ofNewSession(newSession: NewSession) = AutomationTargetParam(newSession = newSession)

        /** Deliver instructions to an existing session. */
        @JvmStatic
        fun ofExistingSession(existingSession: ExistingSession) =
            AutomationTargetParam(existingSession = existingSession)
    }

    /**
     * An interface that defines how to map each variant of [AutomationTargetParam] to a value of
     * type [T].
     */
    interface Visitor<out T> {

        /** Create a session for each invocation. */
        fun visitNewSession(newSession: NewSession): T = unknown(JsonValue.from(newSession))

        /** Deliver instructions to an existing session. */
        fun visitExistingSession(existingSession: ExistingSession): T =
            unknown(JsonValue.from(existingSession))

        /**
         * Maps an unknown variant of [AutomationTargetParam] to a value of type [T].
         *
         * An instance of [AutomationTargetParam] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * Unhandled known JSON variants reach this method as JSON values.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown AutomationTargetParam")
        }
    }

    internal class Deserializer :
        BaseDeserializer<AutomationTargetParam>(AutomationTargetParam::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): AutomationTargetParam {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "new_session" -> {
                    return tryDeserialize(node, jacksonTypeRef<NewSession>())?.let {
                        AutomationTargetParam(newSession = it, _json = json)
                    } ?: AutomationTargetParam(_json = json)
                }
                "existing_session" -> {
                    return tryDeserialize(node, jacksonTypeRef<ExistingSession>())?.let {
                        AutomationTargetParam(existingSession = it, _json = json)
                    } ?: AutomationTargetParam(_json = json)
                }
            }

            return AutomationTargetParam(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<AutomationTargetParam>(AutomationTargetParam::class) {

        override fun serialize(
            value: AutomationTargetParam,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.newSession != null -> generator.writeObject(value.newSession)
                value.existingSession != null -> generator.writeObject(value.existingSession)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid AutomationTargetParam")
            }
        }
    }

    /** Create a session for each invocation. */
    class NewSession
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val environment: JsonField<EnvironmentParam>,
        private val input: JsonField<List<AgentSessionInputMessageParam>>,
        private val type: JsonValue,
        private val agent: JsonField<Agent>,
        private val agentId: JsonField<String>,
        private val metadata: JsonField<Metadata>,
        private val vaultIds: JsonField<List<String>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("environment")
            @ExcludeMissing
            environment: JsonField<EnvironmentParam> = JsonMissing.of(),
            @JsonProperty("input")
            @ExcludeMissing
            input: JsonField<List<AgentSessionInputMessageParam>> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("agent") @ExcludeMissing agent: JsonField<Agent> = JsonMissing.of(),
            @JsonProperty("agent_id") @ExcludeMissing agentId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("metadata")
            @ExcludeMissing
            metadata: JsonField<Metadata> = JsonMissing.of(),
            @JsonProperty("vault_ids")
            @ExcludeMissing
            vaultIds: JsonField<List<String>> = JsonMissing.of(),
        ) : this(environment, input, type, agent, agentId, metadata, vaultIds, mutableMapOf())

        /**
         * The execution environment for each new session.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun environment(): EnvironmentParam = environment.getRequired("environment")

        /**
         * Initial user messages submitted with each new session.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun input(): List<AgentSessionInputMessageParam> = input.getRequired("input")

        /**
         * The type of the object. Always `new_session`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("new_session")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Inline agent configuration. Provide exactly one of agent and agent_id.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun agent(): Optional<Agent> = agent.getOptional("agent")

        /**
         * A saved agent ID. Provide exactly one of agent and agent_id.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun agentId(): Optional<String> = agentId.getOptional("agent_id")

        /**
         * Metadata attached to each new session.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun metadata(): Optional<Metadata> = metadata.getOptional("metadata")

        /**
         * The IDs of vaults made available to each new session.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun vaultIds(): Optional<List<String>> = vaultIds.getOptional("vault_ids")

        /**
         * Returns the raw JSON value of [environment].
         *
         * Unlike [environment], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("environment")
        @ExcludeMissing
        fun _environment(): JsonField<EnvironmentParam> = environment

        /**
         * Returns the raw JSON value of [input].
         *
         * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("input")
        @ExcludeMissing
        fun _input(): JsonField<List<AgentSessionInputMessageParam>> = input

        /**
         * Returns the raw JSON value of [agent].
         *
         * Unlike [agent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("agent") @ExcludeMissing fun _agent(): JsonField<Agent> = agent

        /**
         * Returns the raw JSON value of [agentId].
         *
         * Unlike [agentId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("agent_id") @ExcludeMissing fun _agentId(): JsonField<String> = agentId

        /**
         * Returns the raw JSON value of [metadata].
         *
         * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonField<Metadata> = metadata

        /**
         * Returns the raw JSON value of [vaultIds].
         *
         * Unlike [vaultIds], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("vault_ids")
        @ExcludeMissing
        fun _vaultIds(): JsonField<List<String>> = vaultIds

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
                "environment" to this.environment,
                "input" to this.input,
                "type" to this.type,
                "agent" to this.agent,
                "agent_id" to this.agentId,
                "metadata" to this.metadata,
                "vault_ids" to this.vaultIds,
            )

        /**
         * Returns the legacy additional-properties view.
         *
         * @deprecated Use [_allProperties] to access both declared and additional JSON properties.
         *   This accessor retains its legacy additional-properties behavior.
         */
        @Deprecated("Use _allProperties() to access both declared and additional JSON properties.")
        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [NewSession].
             *
             * The following fields are required:
             * ```java
             * .environment()
             * .input()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [NewSession]. */
        class Builder internal constructor() {

            private var environment: JsonField<EnvironmentParam>? = null
            private var input: JsonField<MutableList<AgentSessionInputMessageParam>>? = null
            private var type: JsonValue = JsonValue.from("new_session")
            private var agent: JsonField<Agent> = JsonMissing.of()
            private var agentId: JsonField<String> = JsonMissing.of()
            private var metadata: JsonField<Metadata> = JsonMissing.of()
            private var vaultIds: JsonField<MutableList<String>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(newSession: NewSession) = apply {
                environment = newSession.environment
                input = newSession.input.map { it.toMutableList() }
                type = newSession.type
                agent = newSession.agent
                agentId = newSession.agentId
                metadata = newSession.metadata
                vaultIds = newSession.vaultIds.map { it.toMutableList() }
                additionalProperties = newSession.additionalProperties.toMutableMap()
            }

            /** The execution environment for each new session. */
            fun environment(environment: EnvironmentParam) = environment(JsonField.of(environment))

            /**
             * Sets [Builder.environment] to an arbitrary JSON value.
             *
             * You should usually call [Builder.environment] with a well-typed [EnvironmentParam]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun environment(environment: JsonField<EnvironmentParam>) = apply {
                this.environment = environment
            }

            /** Alias for calling [environment] with `EnvironmentParam.ofNone()`. */
            fun environmentNone() = environment(EnvironmentParam.ofNone())

            /**
             * Alias for calling [environment] with `EnvironmentParam.ofOpenAIHosted(openaiHosted)`.
             */
            fun environment(openaiHosted: EnvironmentParam.OpenAIHosted) =
                environment(EnvironmentParam.ofOpenAIHosted(openaiHosted))

            /** Alias for calling [environment] with `EnvironmentParam.ofSelfHosted(selfHosted)`. */
            fun environment(selfHosted: EnvironmentParam.SelfHosted) =
                environment(EnvironmentParam.ofSelfHosted(selfHosted))

            /**
             * Alias for calling [environment] with the following:
             * ```java
             * EnvironmentParam.SelfHosted.builder()
             *     .workspaceDirectory(workspaceDirectory)
             *     .build()
             * ```
             */
            fun selfHostedEnvironment(workspaceDirectory: String) =
                environment(
                    EnvironmentParam.SelfHosted.builder()
                        .workspaceDirectory(workspaceDirectory)
                        .build()
                )

            /** Initial user messages submitted with each new session. */
            fun input(input: List<AgentSessionInputMessageParam>) = input(JsonField.of(input))

            /**
             * Sets [Builder.input] to an arbitrary JSON value.
             *
             * You should usually call [Builder.input] with a well-typed
             * `List<AgentSessionInputMessageParam>` value instead. This method is primarily for
             * setting the field to an undocumented or not yet supported value.
             */
            fun input(input: JsonField<List<AgentSessionInputMessageParam>>) = apply {
                this.input = input.map { it.toMutableList() }
            }

            /**
             * Adds a single [AgentSessionInputMessageParam] to [Builder.input].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addInput(input: AgentSessionInputMessageParam) = apply {
                this.input =
                    (this.input ?: JsonField.of(mutableListOf())).also {
                        checkKnown("input", it).add(input)
                    }
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("new_session")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /** Inline agent configuration. Provide exactly one of agent and agent_id. */
            fun agent(agent: Agent) = agent(JsonField.of(agent))

            /**
             * Sets [Builder.agent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.agent] with a well-typed [Agent] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun agent(agent: JsonField<Agent>) = apply { this.agent = agent }

            /** A saved agent ID. Provide exactly one of agent and agent_id. */
            fun agentId(agentId: String) = agentId(JsonField.of(agentId))

            /**
             * Sets [Builder.agentId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.agentId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun agentId(agentId: JsonField<String>) = apply { this.agentId = agentId }

            /** Metadata attached to each new session. */
            fun metadata(metadata: Metadata?) = metadata(JsonField.ofNullable(metadata))

            /** Alias for calling [Builder.metadata] with `metadata.orElse(null)`. */
            fun metadata(metadata: Optional<Metadata>) = metadata(metadata.getOrNull())

            /**
             * Sets [Builder.metadata] to an arbitrary JSON value.
             *
             * You should usually call [Builder.metadata] with a well-typed [Metadata] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

            /** The IDs of vaults made available to each new session. */
            fun vaultIds(vaultIds: List<String>?) = vaultIds(JsonField.ofNullable(vaultIds))

            /** Alias for calling [Builder.vaultIds] with `vaultIds.orElse(null)`. */
            fun vaultIds(vaultIds: Optional<List<String>>) = vaultIds(vaultIds.getOrNull())

            /**
             * Sets [Builder.vaultIds] to an arbitrary JSON value.
             *
             * You should usually call [Builder.vaultIds] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun vaultIds(vaultIds: JsonField<List<String>>) = apply {
                this.vaultIds = vaultIds.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [vaultIds].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addVaultId(vaultId: String) = apply {
                vaultIds =
                    (vaultIds?.takeUnless { it.isMissing() } ?: JsonField.of(mutableListOf()))
                        .also { checkKnown("vaultIds", it).add(vaultId) }
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
             * Returns an immutable instance of [NewSession].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .environment()
             * .input()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): NewSession =
                NewSession(
                    checkRequired("environment", environment),
                    checkRequired("input", input).map { it.toImmutable() },
                    type,
                    agent,
                    agentId,
                    metadata,
                    (vaultIds ?: JsonMissing.of()).map { it.toImmutable() },
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
        fun validate(): NewSession = apply {
            if (validated) {
                return@apply
            }

            environment().validate()
            input().forEach { it.validate() }
            _type().let {
                if (it != JsonValue.from("new_session")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            agent().ifPresent { it.validate() }
            agentId()
            metadata().ifPresent { it.validate() }
            vaultIds()
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
            (environment.asKnown().getOrNull()?.validity() ?: 0) +
                (input.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                type.let { if (it == JsonValue.from("new_session")) 1 else 0 } +
                (agent.asKnown().getOrNull()?.validity() ?: 0) +
                (if (agentId.asKnown().isPresent) 1 else 0) +
                (metadata.asKnown().getOrNull()?.validity() ?: 0) +
                (vaultIds.asKnown().getOrNull()?.size ?: 0)

        /** Inline agent configuration. Provide exactly one of agent and agent_id. */
        class Agent
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val compaction: JsonField<Compaction>,
            private val experimental: JsonField<Experimental>,
            private val instructions: JsonField<String>,
            private val model: JsonField<String>,
            private val multiAgent: JsonField<MultiAgentConfigParam>,
            private val reasoning: JsonField<AgentReasoningParam>,
            private val serviceTier: JsonField<ServiceTier>,
            private val text: JsonField<AgentTextParam>,
            private val tools: JsonField<List<AgentToolParam>>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("compaction")
                @ExcludeMissing
                compaction: JsonField<Compaction> = JsonMissing.of(),
                @JsonProperty("experimental")
                @ExcludeMissing
                experimental: JsonField<Experimental> = JsonMissing.of(),
                @JsonProperty("instructions")
                @ExcludeMissing
                instructions: JsonField<String> = JsonMissing.of(),
                @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
                @JsonProperty("multi_agent")
                @ExcludeMissing
                multiAgent: JsonField<MultiAgentConfigParam> = JsonMissing.of(),
                @JsonProperty("reasoning")
                @ExcludeMissing
                reasoning: JsonField<AgentReasoningParam> = JsonMissing.of(),
                @JsonProperty("service_tier")
                @ExcludeMissing
                serviceTier: JsonField<ServiceTier> = JsonMissing.of(),
                @JsonProperty("text")
                @ExcludeMissing
                text: JsonField<AgentTextParam> = JsonMissing.of(),
                @JsonProperty("tools")
                @ExcludeMissing
                tools: JsonField<List<AgentToolParam>> = JsonMissing.of(),
            ) : this(
                compaction,
                experimental,
                instructions,
                model,
                multiAgent,
                reasoning,
                serviceTier,
                text,
                tools,
                mutableMapOf(),
            )

            /**
             * Context compaction settings. Omit to keep the current settings. A supplied object
             * replaces the settings; null or an empty object enables background compaction.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun compaction(): Optional<Compaction> = compaction.getOptional("compaction")

            /**
             * Experimental settings to merge by key. Omitted settings keep their current values.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun experimental(): Optional<Experimental> = experimental.getOptional("experimental")

            /**
             * Additional instructions appended to the agent's default base instructions. Omit to
             * leave unchanged.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun instructions(): Optional<String> = instructions.getOptional("instructions")

            /**
             * The model to use for the agent. The requested model name is preserved.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun model(): Optional<String> = model.getOptional("model")

            /**
             * Configuration for creating and coordinating subagents.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun multiAgent(): Optional<MultiAgentConfigParam> =
                multiAgent.getOptional("multi_agent")

            /**
             * Configuration for model reasoning. Omit to keep the current settings; pass `null` to
             * reset to the model's default effort.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun reasoning(): Optional<AgentReasoningParam> = reasoning.getOptional("reasoning")

            /**
             * The service tier used for model requests.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun serviceTier(): Optional<ServiceTier> = serviceTier.getOptional("service_tier")

            /**
             * Configuration for text generated by the agent.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun text(): Optional<AgentTextParam> = text.getOptional("text")

            /**
             * Tools available to the agent. Omit to inherit, or pass null to clear them. The
             * resolved tool list must fit within 3 MiB (3,145,728 bytes) of compact UTF-8 JSON.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun tools(): Optional<List<AgentToolParam>> = tools.getOptional("tools")

            /**
             * Returns the raw JSON value of [compaction].
             *
             * Unlike [compaction], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("compaction")
            @ExcludeMissing
            fun _compaction(): JsonField<Compaction> = compaction

            /**
             * Returns the raw JSON value of [experimental].
             *
             * Unlike [experimental], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("experimental")
            @ExcludeMissing
            fun _experimental(): JsonField<Experimental> = experimental

            /**
             * Returns the raw JSON value of [instructions].
             *
             * Unlike [instructions], this method doesn't throw if the JSON field has an unexpected
             * type.
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
             * Unlike [multiAgent], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("multi_agent")
            @ExcludeMissing
            fun _multiAgent(): JsonField<MultiAgentConfigParam> = multiAgent

            /**
             * Returns the raw JSON value of [reasoning].
             *
             * Unlike [reasoning], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("reasoning")
            @ExcludeMissing
            fun _reasoning(): JsonField<AgentReasoningParam> = reasoning

            /**
             * Returns the raw JSON value of [serviceTier].
             *
             * Unlike [serviceTier], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("service_tier")
            @ExcludeMissing
            fun _serviceTier(): JsonField<ServiceTier> = serviceTier

            /**
             * Returns the raw JSON value of [text].
             *
             * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<AgentTextParam> = text

            /**
             * Returns the raw JSON value of [tools].
             *
             * Unlike [tools], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("tools")
            @ExcludeMissing
            fun _tools(): JsonField<List<AgentToolParam>> = tools

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
                    "compaction" to this.compaction,
                    "experimental" to this.experimental,
                    "instructions" to this.instructions,
                    "model" to this.model,
                    "multi_agent" to this.multiAgent,
                    "reasoning" to this.reasoning,
                    "service_tier" to this.serviceTier,
                    "text" to this.text,
                    "tools" to this.tools,
                )

            /**
             * Returns the legacy additional-properties view.
             *
             * @deprecated Use [_allProperties] to access both declared and additional JSON
             *   properties. This accessor retains its legacy additional-properties behavior.
             */
            @Deprecated(
                "Use _allProperties() to access both declared and additional JSON properties."
            )
            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [Agent]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Agent]. */
            class Builder internal constructor() {

                private var compaction: JsonField<Compaction> = JsonMissing.of()
                private var experimental: JsonField<Experimental> = JsonMissing.of()
                private var instructions: JsonField<String> = JsonMissing.of()
                private var model: JsonField<String> = JsonMissing.of()
                private var multiAgent: JsonField<MultiAgentConfigParam> = JsonMissing.of()
                private var reasoning: JsonField<AgentReasoningParam> = JsonMissing.of()
                private var serviceTier: JsonField<ServiceTier> = JsonMissing.of()
                private var text: JsonField<AgentTextParam> = JsonMissing.of()
                private var tools: JsonField<MutableList<AgentToolParam>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(agent: Agent) = apply {
                    compaction = agent.compaction
                    experimental = agent.experimental
                    instructions = agent.instructions
                    model = agent.model
                    multiAgent = agent.multiAgent
                    reasoning = agent.reasoning
                    serviceTier = agent.serviceTier
                    text = agent.text
                    tools = agent.tools.map { it.toMutableList() }
                    additionalProperties = agent.additionalProperties.toMutableMap()
                }

                /**
                 * Context compaction settings. Omit to keep the current settings. A supplied object
                 * replaces the settings; null or an empty object enables background compaction.
                 */
                fun compaction(compaction: Compaction?) =
                    compaction(JsonField.ofNullable(compaction))

                /** Alias for calling [Builder.compaction] with `compaction.orElse(null)`. */
                fun compaction(compaction: Optional<Compaction>) =
                    compaction(compaction.getOrNull())

                /**
                 * Sets [Builder.compaction] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.compaction] with a well-typed [Compaction] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun compaction(compaction: JsonField<Compaction>) = apply {
                    this.compaction = compaction
                }

                /**
                 * Experimental settings to merge by key. Omitted settings keep their current
                 * values.
                 */
                fun experimental(experimental: Experimental) =
                    experimental(JsonField.of(experimental))

                /**
                 * Sets [Builder.experimental] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.experimental] with a well-typed [Experimental]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun experimental(experimental: JsonField<Experimental>) = apply {
                    this.experimental = experimental
                }

                /**
                 * Additional instructions appended to the agent's default base instructions. Omit
                 * to leave unchanged.
                 */
                fun instructions(instructions: String?) =
                    instructions(JsonField.ofNullable(instructions))

                /** Alias for calling [Builder.instructions] with `instructions.orElse(null)`. */
                fun instructions(instructions: Optional<String>) =
                    instructions(instructions.getOrNull())

                /**
                 * Sets [Builder.instructions] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.instructions] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun instructions(instructions: JsonField<String>) = apply {
                    this.instructions = instructions
                }

                /** The model to use for the agent. The requested model name is preserved. */
                fun model(model: String) = model(JsonField.of(model))

                /**
                 * Sets [Builder.model] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.model] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun model(model: JsonField<String>) = apply { this.model = model }

                /** Configuration for creating and coordinating subagents. */
                fun multiAgent(multiAgent: MultiAgentConfigParam?) =
                    multiAgent(JsonField.ofNullable(multiAgent))

                /** Alias for calling [Builder.multiAgent] with `multiAgent.orElse(null)`. */
                fun multiAgent(multiAgent: Optional<MultiAgentConfigParam>) =
                    multiAgent(multiAgent.getOrNull())

                /**
                 * Sets [Builder.multiAgent] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.multiAgent] with a well-typed
                 * [MultiAgentConfigParam] value instead. This method is primarily for setting the
                 * field to an undocumented or not yet supported value.
                 */
                fun multiAgent(multiAgent: JsonField<MultiAgentConfigParam>) = apply {
                    this.multiAgent = multiAgent
                }

                /**
                 * Configuration for model reasoning. Omit to keep the current settings; pass `null`
                 * to reset to the model's default effort.
                 */
                fun reasoning(reasoning: AgentReasoningParam?) =
                    reasoning(JsonField.ofNullable(reasoning))

                /** Alias for calling [Builder.reasoning] with `reasoning.orElse(null)`. */
                fun reasoning(reasoning: Optional<AgentReasoningParam>) =
                    reasoning(reasoning.getOrNull())

                /**
                 * Sets [Builder.reasoning] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.reasoning] with a well-typed
                 * [AgentReasoningParam] value instead. This method is primarily for setting the
                 * field to an undocumented or not yet supported value.
                 */
                fun reasoning(reasoning: JsonField<AgentReasoningParam>) = apply {
                    this.reasoning = reasoning
                }

                /** The service tier used for model requests. */
                fun serviceTier(serviceTier: ServiceTier?) =
                    serviceTier(JsonField.ofNullable(serviceTier))

                /** Alias for calling [Builder.serviceTier] with `serviceTier.orElse(null)`. */
                fun serviceTier(serviceTier: Optional<ServiceTier>) =
                    serviceTier(serviceTier.getOrNull())

                /**
                 * Sets [Builder.serviceTier] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.serviceTier] with a well-typed [ServiceTier]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun serviceTier(serviceTier: JsonField<ServiceTier>) = apply {
                    this.serviceTier = serviceTier
                }

                /** Configuration for text generated by the agent. */
                fun text(text: AgentTextParam?) = text(JsonField.ofNullable(text))

                /** Alias for calling [Builder.text] with `text.orElse(null)`. */
                fun text(text: Optional<AgentTextParam>) = text(text.getOrNull())

                /**
                 * Sets [Builder.text] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.text] with a well-typed [AgentTextParam] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun text(text: JsonField<AgentTextParam>) = apply { this.text = text }

                /**
                 * Tools available to the agent. Omit to inherit, or pass null to clear them. The
                 * resolved tool list must fit within 3 MiB (3,145,728 bytes) of compact UTF-8 JSON.
                 */
                fun tools(tools: List<AgentToolParam>?) = tools(JsonField.ofNullable(tools))

                /** Alias for calling [Builder.tools] with `tools.orElse(null)`. */
                fun tools(tools: Optional<List<AgentToolParam>>) = tools(tools.getOrNull())

                /**
                 * Sets [Builder.tools] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.tools] with a well-typed `List<AgentToolParam>`
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun tools(tools: JsonField<List<AgentToolParam>>) = apply {
                    this.tools = tools.map { it.toMutableList() }
                }

                /**
                 * Adds a single [AgentToolParam] to [tools].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addTool(tool: AgentToolParam) = apply {
                    tools =
                        (tools?.takeUnless { it.isMissing() } ?: JsonField.of(mutableListOf()))
                            .also { checkKnown("tools", it).add(tool) }
                }

                /** Alias for calling [addTool] with `AgentToolParam.ofFunction(function)`. */
                fun addTool(function: AgentToolParam.Function) =
                    addTool(AgentToolParam.ofFunction(function))

                /** Alias for calling [addTool] with `AgentToolParam.ofToolSearch()`. */
                fun addToolToolSearch() = addTool(AgentToolParam.ofToolSearch())

                /**
                 * Alias for calling [addTool] with
                 * `AgentToolParam.ofProgrammaticToolCalling(programmaticToolCalling)`.
                 */
                fun addTool(programmaticToolCalling: AgentToolParam.ProgrammaticToolCalling) =
                    addTool(AgentToolParam.ofProgrammaticToolCalling(programmaticToolCalling))

                /** Alias for calling [addTool] with `AgentToolParam.ofMcp(mcp)`. */
                fun addTool(mcp: AgentToolParam.Mcp) = addTool(AgentToolParam.ofMcp(mcp))

                /** Alias for calling [addTool] with `AgentToolParam.ofWebSearch(webSearch)`. */
                fun addTool(webSearch: AgentToolParam.WebSearch) =
                    addTool(AgentToolParam.ofWebSearch(webSearch))

                /** Alias for calling [addTool] with `AgentToolParam.ofComputerUse(computerUse)`. */
                fun addTool(computerUse: AgentToolParam.ComputerUse) =
                    addTool(AgentToolParam.ofComputerUse(computerUse))

                /** Alias for calling [addTool] with `AgentToolParam.ofAutomations()`. */
                fun addToolAutomations() = addTool(AgentToolParam.ofAutomations())

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
                 * Returns an immutable instance of [Agent].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Agent =
                    Agent(
                        compaction,
                        experimental,
                        instructions,
                        model,
                        multiAgent,
                        reasoning,
                        serviceTier,
                        text,
                        (tools ?: JsonMissing.of()).map { it.toImmutable() },
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
            fun validate(): Agent = apply {
                if (validated) {
                    return@apply
                }

                compaction().ifPresent { it.validate() }
                experimental().ifPresent { it.validate() }
                instructions()
                model()
                multiAgent().ifPresent { it.validate() }
                reasoning().ifPresent { it.validate() }
                serviceTier().ifPresent { it.validate() }
                text().ifPresent { it.validate() }
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
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (compaction.asKnown().getOrNull()?.validity() ?: 0) +
                    (experimental.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (instructions.asKnown().isPresent) 1 else 0) +
                    (if (model.asKnown().isPresent) 1 else 0) +
                    (multiAgent.asKnown().getOrNull()?.validity() ?: 0) +
                    (reasoning.asKnown().getOrNull()?.validity() ?: 0) +
                    (serviceTier.asKnown().getOrNull()?.validity() ?: 0) +
                    (text.asKnown().getOrNull()?.validity() ?: 0) +
                    (tools.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

            /**
             * Context compaction settings. Omit to keep the current settings. A supplied object
             * replaces the settings; null or an empty object enables background compaction.
             */
            class Compaction
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val async: JsonField<Boolean>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("async")
                    @ExcludeMissing
                    async: JsonField<Boolean> = JsonMissing.of()
                ) : this(async, mutableMapOf())

                /**
                 * Whether to compact context in the background. Omission or null defaults to true.
                 * Set to false to use blocking compaction. Background compaction may increase token
                 * usage.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun async(): Optional<Boolean> = async.getOptional("async")

                /**
                 * Returns the raw JSON value of [async].
                 *
                 * Unlike [async], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("async") @ExcludeMissing fun _async(): JsonField<Boolean> = async

                @JsonAnySetter
                private fun putAdditionalProperty(key: String, value: JsonValue) {
                    additionalProperties.put(key, value)
                }

                /**
                 * Returns an immutable snapshot of all present JSON properties, including declared
                 * and additional properties.
                 *
                 * Keys use their JSON names. Declared properties take precedence over additional
                 * properties with the same name. Missing properties are omitted, while explicit
                 * nulls and unrecognized values are preserved.
                 */
                fun _allProperties(): Map<String, JsonValue> =
                    collectAllProperties(additionalProperties, "async" to this.async)

                /**
                 * Returns the legacy additional-properties view.
                 *
                 * @deprecated Use [_allProperties] to access both declared and additional JSON
                 *   properties. This accessor retains its legacy additional-properties behavior.
                 */
                @Deprecated(
                    "Use _allProperties() to access both declared and additional JSON properties."
                )
                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> =
                    Collections.unmodifiableMap(additionalProperties)

                fun toBuilder() = Builder().from(this)

                companion object {

                    /** Returns a mutable builder for constructing an instance of [Compaction]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Compaction]. */
                class Builder internal constructor() {

                    private var async: JsonField<Boolean> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(compaction: Compaction) = apply {
                        async = compaction.async
                        additionalProperties = compaction.additionalProperties.toMutableMap()
                    }

                    /**
                     * Whether to compact context in the background. Omission or null defaults to
                     * true. Set to false to use blocking compaction. Background compaction may
                     * increase token usage.
                     */
                    fun async(async: Boolean?) = async(JsonField.ofNullable(async))

                    /**
                     * Alias for [Builder.async].
                     *
                     * This unboxed primitive overload exists for backwards compatibility.
                     */
                    fun async(async: Boolean) = async(async as Boolean?)

                    /** Alias for calling [Builder.async] with `async.orElse(null)`. */
                    fun async(async: Optional<Boolean>) = async(async.getOrNull())

                    /**
                     * Sets [Builder.async] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.async] with a well-typed [Boolean] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun async(async: JsonField<Boolean>) = apply { this.async = async }

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
                     * Returns an immutable instance of [Compaction].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Compaction = Compaction(async, additionalProperties.toMutableMap())
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
                fun validate(): Compaction = apply {
                    if (validated) {
                        return@apply
                    }

                    async()
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
                internal fun validity(): Int = (if (async.asKnown().isPresent) 1 else 0)

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

            /**
             * Experimental settings to merge by key. Omitted settings keep their current values.
             */
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
                 * Whether to give the model periodic current-time reminders. Omit to keep the
                 * current setting.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun timeAwareness(): Optional<Boolean> = timeAwareness.getOptional("time_awareness")

                /**
                 * Returns the raw JSON value of [timeAwareness].
                 *
                 * Unlike [timeAwareness], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("time_awareness")
                @ExcludeMissing
                fun _timeAwareness(): JsonField<Boolean> = timeAwareness

                @JsonAnySetter
                private fun putAdditionalProperty(key: String, value: JsonValue) {
                    additionalProperties.put(key, value)
                }

                /**
                 * Returns an immutable snapshot of all present JSON properties, including declared
                 * and additional properties.
                 *
                 * Keys use their JSON names. Declared properties take precedence over additional
                 * properties with the same name. Missing properties are omitted, while explicit
                 * nulls and unrecognized values are preserved.
                 */
                fun _allProperties(): Map<String, JsonValue> =
                    collectAllProperties(
                        additionalProperties,
                        "time_awareness" to this.timeAwareness,
                    )

                /**
                 * Returns the legacy additional-properties view.
                 *
                 * @deprecated Use [_allProperties] to access both declared and additional JSON
                 *   properties. This accessor retains its legacy additional-properties behavior.
                 */
                @Deprecated(
                    "Use _allProperties() to access both declared and additional JSON properties."
                )
                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> =
                    Collections.unmodifiableMap(additionalProperties)

                fun toBuilder() = Builder().from(this)

                companion object {

                    /** Returns a mutable builder for constructing an instance of [Experimental]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Experimental]. */
                class Builder internal constructor() {

                    private var timeAwareness: JsonField<Boolean> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(experimental: Experimental) = apply {
                        timeAwareness = experimental.timeAwareness
                        additionalProperties = experimental.additionalProperties.toMutableMap()
                    }

                    /**
                     * Whether to give the model periodic current-time reminders. Omit to keep the
                     * current setting.
                     */
                    fun timeAwareness(timeAwareness: Boolean) =
                        timeAwareness(JsonField.of(timeAwareness))

                    /**
                     * Sets [Builder.timeAwareness] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.timeAwareness] with a well-typed [Boolean]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
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
                     * Returns an immutable instance of [Experimental].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Experimental =
                        Experimental(timeAwareness, additionalProperties.toMutableMap())
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
                fun validate(): Experimental = apply {
                    if (validated) {
                        return@apply
                    }

                    timeAwareness()
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

                private val hashCode: Int by lazy {
                    Objects.hash(timeAwareness, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Experimental{timeAwareness=$timeAwareness, additionalProperties=$additionalProperties}"
            }

            /** The service tier used for model requests. */
            class ServiceTier
            @JsonCreator
            private constructor(private val value: JsonField<String>) : Enum {

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

                    /** Selects the service tier automatically. */
                    @JvmField val AUTO = of("auto")

                    /** Uses the default service tier. */
                    @JvmField val DEFAULT = of("default")

                    /** Uses the flex service tier. */
                    @JvmField val FLEX = of("flex")

                    /** Uses the priority service tier. */
                    @JvmField val PRIORITY = of("priority")

                    /** Uses the fast service tier. */
                    @JvmField val FAST = of("fast")

                    /** Uses the ultrafast service tier. */
                    @JvmField val ULTRAFAST = of("ultrafast")

                    @JvmStatic fun of(value: String) = ServiceTier(JsonField.of(value))
                }

                /** An enum containing [ServiceTier]'s known values. */
                @Deprecated("Use asString() for string values or _value() for raw JSON.")
                enum class Known {
                    /** Selects the service tier automatically. */
                    AUTO,
                    /** Uses the default service tier. */
                    DEFAULT,
                    /** Uses the flex service tier. */
                    FLEX,
                    /** Uses the priority service tier. */
                    PRIORITY,
                    /** Uses the fast service tier. */
                    FAST,
                    /** Uses the ultrafast service tier. */
                    ULTRAFAST,
                }

                /**
                 * An enum containing [ServiceTier]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [ServiceTier] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                @Deprecated("Use asString() for string values or _value() for raw JSON.")
                enum class Value {
                    /** Selects the service tier automatically. */
                    AUTO,
                    /** Uses the default service tier. */
                    DEFAULT,
                    /** Uses the flex service tier. */
                    FLEX,
                    /** Uses the priority service tier. */
                    PRIORITY,
                    /** Uses the fast service tier. */
                    FAST,
                    /** Uses the ultrafast service tier. */
                    ULTRAFAST,
                    /**
                     * An enum member indicating that [ServiceTier] was instantiated with an unknown
                     * value.
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
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value is a not a
                 *   known member.
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
                    compaction == other.compaction &&
                    experimental == other.experimental &&
                    instructions == other.instructions &&
                    model == other.model &&
                    multiAgent == other.multiAgent &&
                    reasoning == other.reasoning &&
                    serviceTier == other.serviceTier &&
                    text == other.text &&
                    tools == other.tools &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    compaction,
                    experimental,
                    instructions,
                    model,
                    multiAgent,
                    reasoning,
                    serviceTier,
                    text,
                    tools,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Agent{compaction=$compaction, experimental=$experimental, instructions=$instructions, model=$model, multiAgent=$multiAgent, reasoning=$reasoning, serviceTier=$serviceTier, text=$text, tools=$tools, additionalProperties=$additionalProperties}"
        }

        /** Metadata attached to each new session. */
        class Metadata
        @JsonCreator
        private constructor(
            @com.fasterxml.jackson.annotation.JsonValue
            private val additionalProperties: Map<String, JsonValue>
        ) {

            /**
             * Returns an immutable snapshot of all present JSON properties, including declared and
             * additional properties.
             *
             * Keys use their JSON names. Declared properties take precedence over additional
             * properties with the same name. Missing properties are omitted, while explicit nulls
             * and unrecognized values are preserved.
             */
            fun _allProperties(): Map<String, JsonValue> =
                collectAllProperties(additionalProperties)

            /**
             * Returns the legacy additional-properties view.
             *
             * @deprecated Use [_allProperties] to access both declared and additional JSON
             *   properties. This accessor retains its legacy additional-properties behavior.
             */
            @Deprecated(
                "Use _allProperties() to access both declared and additional JSON properties."
            )
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

                /** Adds a string-valued property. */
                fun putProperty(key: String, value: String) = apply {
                    putAdditionalProperty(key, JsonValue.from(value))
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
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is NewSession &&
                environment == other.environment &&
                input == other.input &&
                type == other.type &&
                agent == other.agent &&
                agentId == other.agentId &&
                metadata == other.metadata &&
                vaultIds == other.vaultIds &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                environment,
                input,
                type,
                agent,
                agentId,
                metadata,
                vaultIds,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "NewSession{environment=$environment, input=$input, type=$type, agent=$agent, agentId=$agentId, metadata=$metadata, vaultIds=$vaultIds, additionalProperties=$additionalProperties}"
    }

    /** Deliver instructions to an existing session. */
    class ExistingSession
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val instructions: JsonField<String>,
        private val sessionId: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("instructions")
            @ExcludeMissing
            instructions: JsonField<String> = JsonMissing.of(),
            @JsonProperty("session_id")
            @ExcludeMissing
            sessionId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(instructions, sessionId, type, mutableMapOf())

        /**
         * Instructions delivered as an automation notification.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun instructions(): String = instructions.getRequired("instructions")

        /**
         * The session receiving each invocation.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sessionId(): String = sessionId.getRequired("session_id")

        /**
         * The type of the object. Always `existing_session`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("existing_session")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [instructions].
         *
         * Unlike [instructions], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("instructions")
        @ExcludeMissing
        fun _instructions(): JsonField<String> = instructions

        /**
         * Returns the raw JSON value of [sessionId].
         *
         * Unlike [sessionId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("session_id") @ExcludeMissing fun _sessionId(): JsonField<String> = sessionId

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
                "session_id" to this.sessionId,
                "type" to this.type,
            )

        /**
         * Returns the legacy additional-properties view.
         *
         * @deprecated Use [_allProperties] to access both declared and additional JSON properties.
         *   This accessor retains its legacy additional-properties behavior.
         */
        @Deprecated("Use _allProperties() to access both declared and additional JSON properties.")
        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [ExistingSession].
             *
             * The following fields are required:
             * ```java
             * .instructions()
             * .sessionId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ExistingSession]. */
        class Builder internal constructor() {

            private var instructions: JsonField<String>? = null
            private var sessionId: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("existing_session")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(existingSession: ExistingSession) = apply {
                instructions = existingSession.instructions
                sessionId = existingSession.sessionId
                type = existingSession.type
                additionalProperties = existingSession.additionalProperties.toMutableMap()
            }

            /** Instructions delivered as an automation notification. */
            fun instructions(instructions: String) = instructions(JsonField.of(instructions))

            /**
             * Sets [Builder.instructions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.instructions] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun instructions(instructions: JsonField<String>) = apply {
                this.instructions = instructions
            }

            /** The session receiving each invocation. */
            fun sessionId(sessionId: String) = sessionId(JsonField.of(sessionId))

            /**
             * Sets [Builder.sessionId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sessionId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sessionId(sessionId: JsonField<String>) = apply { this.sessionId = sessionId }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("existing_session")
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
             * Returns an immutable instance of [ExistingSession].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .instructions()
             * .sessionId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ExistingSession =
                ExistingSession(
                    checkRequired("instructions", instructions),
                    checkRequired("sessionId", sessionId),
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
        fun validate(): ExistingSession = apply {
            if (validated) {
                return@apply
            }

            instructions()
            sessionId()
            _type().let {
                if (it != JsonValue.from("existing_session")) {
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
            (if (instructions.asKnown().isPresent) 1 else 0) +
                (if (sessionId.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("existing_session")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ExistingSession &&
                instructions == other.instructions &&
                sessionId == other.sessionId &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(instructions, sessionId, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ExistingSession{instructions=$instructions, sessionId=$sessionId, type=$type, additionalProperties=$additionalProperties}"
    }
}
