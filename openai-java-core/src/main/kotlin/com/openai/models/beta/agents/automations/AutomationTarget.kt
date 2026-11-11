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
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonNull
import com.openai.core.JsonValue
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.collectAllProperties
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.beta.agents.InputContent
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Saved target configuration, excluding confidential request-only values. */
@JsonDeserialize(using = AutomationTarget.Deserializer::class)
@JsonSerialize(using = AutomationTarget.Serializer::class)
class AutomationTarget
private constructor(
    private val newSession: NewSession? = null,
    private val existingSession: ExistingSession? = null,
    private val _json: JsonValue? = null,
) {

    fun newSession(): Optional<NewSession> = Optional.ofNullable(newSession)

    fun existingSession(): Optional<ExistingSession> = Optional.ofNullable(existingSession)

    fun isNewSession(): Boolean = newSession != null

    fun isExistingSession(): Boolean = existingSession != null

    fun asNewSession(): NewSession = newSession.getOrThrow("newSession")

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
     * Optional<String> result = automationTarget.accept(new AutomationTarget.Visitor<Optional<String>>() {
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
    fun validate(): AutomationTarget = apply {
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

        return other is AutomationTarget &&
            newSession == other.newSession &&
            existingSession == other.existingSession &&
            (newSession != null || existingSession != null || _json == other._json)
    }

    override fun hashCode(): Int =
        if (newSession == null && existingSession == null) Objects.hash(_json)
        else Objects.hash(newSession, existingSession)

    override fun toString(): String =
        when {
            newSession != null -> "AutomationTarget{newSession=$newSession}"
            existingSession != null -> "AutomationTarget{existingSession=$existingSession}"
            _json != null -> "AutomationTarget{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid AutomationTarget")
        }

    companion object {

        @JvmStatic
        fun ofNewSession(newSession: NewSession) = AutomationTarget(newSession = newSession)

        @JvmStatic
        fun ofExistingSession(existingSession: ExistingSession) =
            AutomationTarget(existingSession = existingSession)
    }

    /**
     * An interface that defines how to map each variant of [AutomationTarget] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        fun visitNewSession(newSession: NewSession): T = unknown(JsonValue.from(newSession))

        fun visitExistingSession(existingSession: ExistingSession): T =
            unknown(JsonValue.from(existingSession))

        /**
         * Maps an unknown variant of [AutomationTarget] to a value of type [T].
         *
         * An instance of [AutomationTarget] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * Unhandled known JSON variants reach this method as JSON values.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown AutomationTarget")
        }
    }

    internal class Deserializer : BaseDeserializer<AutomationTarget>(AutomationTarget::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): AutomationTarget {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "new_session" -> {
                    return tryDeserialize(node, jacksonTypeRef<NewSession>())?.let {
                        AutomationTarget(newSession = it, _json = json)
                    } ?: AutomationTarget(_json = json)
                }
                "existing_session" -> {
                    return tryDeserialize(node, jacksonTypeRef<ExistingSession>())?.let {
                        AutomationTarget(existingSession = it, _json = json)
                    } ?: AutomationTarget(_json = json)
                }
            }

            return AutomationTarget(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<AutomationTarget>(AutomationTarget::class) {

        override fun serialize(
            value: AutomationTarget,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.newSession != null -> generator.writeObject(value.newSession)
                value.existingSession != null -> generator.writeObject(value.existingSession)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid AutomationTarget")
            }
        }
    }

    class NewSession
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val agent: JsonField<AutomationAgentConfig>,
        private val agentId: JsonField<String>,
        private val environment: JsonField<AutomationEnvironment>,
        private val input: JsonField<List<Input>>,
        private val metadata: JsonField<Metadata>,
        private val type: JsonValue,
        private val vaultIds: JsonField<List<String>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("agent")
            @ExcludeMissing
            agent: JsonField<AutomationAgentConfig> = JsonMissing.of(),
            @JsonProperty("agent_id") @ExcludeMissing agentId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("environment")
            @ExcludeMissing
            environment: JsonField<AutomationEnvironment> = JsonMissing.of(),
            @JsonProperty("input") @ExcludeMissing input: JsonField<List<Input>> = JsonMissing.of(),
            @JsonProperty("metadata")
            @ExcludeMissing
            metadata: JsonField<Metadata> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("vault_ids")
            @ExcludeMissing
            vaultIds: JsonField<List<String>> = JsonMissing.of(),
        ) : this(agent, agentId, environment, input, metadata, type, vaultIds, mutableMapOf())

        /**
         * The inline agent configuration, or null when agent_id is configured. The schema requires
         * this property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun agent(): java.util.Optional<AutomationAgentConfig> = agent.getOptional("agent")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun agentOrThrow(): AutomationAgentConfig = agent.getRequired("agent")

        /**
         * The saved agent reference, or null when an inline agent is configured. The schema
         * requires this property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun agentId(): java.util.Optional<String> = agentId.getOptional("agent_id")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun agentIdOrThrow(): String = agentId.getRequired("agent_id")

        /**
         * Configuration or references used to select the execution environment. The schema requires
         * this property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun environment(): java.util.Optional<AutomationEnvironment> =
            environment.getOptional("environment")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun environmentOrThrow(): AutomationEnvironment = environment.getRequired("environment")

        /**
         * Initial input delivered to each new session. The schema requires this property. Returns
         * empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun input(): java.util.Optional<List<Input>> = input.getOptional("input")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun inputOrThrow(): List<Input> = input.getRequired("input")

        /**
         * Metadata attached to each new session. The schema requires this property. Returns empty
         * if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun metadata(): java.util.Optional<Metadata> = metadata.getOptional("metadata")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun metadataOrThrow(): Metadata = metadata.getRequired("metadata")

        /**
         * The type of the object. Always `new_session`. The schema requires this property. Returns
         * empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun type(): java.util.Optional<JsonValue> {
            val raw = type
            return when {
                raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                !(raw == JsonValue.from("new_session")) ->
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
         * Vaults made available to each new session. The schema requires this property. Returns
         * empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun vaultIds(): java.util.Optional<List<String>> = vaultIds.getOptional("vault_ids")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun vaultIdsOrThrow(): List<String> = vaultIds.getRequired("vault_ids")

        /**
         * Returns the raw JSON value of [agent].
         *
         * Unlike [agent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("agent")
        @ExcludeMissing
        fun _agent(): JsonField<AutomationAgentConfig> = agent

        /**
         * Returns the raw JSON value of [agentId].
         *
         * Unlike [agentId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("agent_id") @ExcludeMissing fun _agentId(): JsonField<String> = agentId

        /**
         * Returns the raw JSON value of [environment].
         *
         * Unlike [environment], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("environment")
        @ExcludeMissing
        fun _environment(): JsonField<AutomationEnvironment> = environment

        /**
         * Returns the raw JSON value of [input].
         *
         * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("input") @ExcludeMissing fun _input(): JsonField<List<Input>> = input

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
                "agent" to this.agent,
                "agent_id" to this.agentId,
                "environment" to this.environment,
                "input" to this.input,
                "metadata" to this.metadata,
                "type" to this.type,
                "vault_ids" to this.vaultIds,
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
             * Returns a mutable builder for constructing an instance of [NewSession].
             *
             * The following fields are required:
             * ```java
             * .environment()
             * .input()
             * .metadata()
             * .vaultIds()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [NewSession]. */
        class Builder internal constructor() {

            private var agent: JsonField<AutomationAgentConfig>? = JsonNull.of()
            private var agentId: JsonField<String>? = JsonNull.of()
            private var environment: JsonField<AutomationEnvironment>? = null
            private var input: JsonField<MutableList<Input>>? = null
            private var metadata: JsonField<Metadata>? = null
            private var type: JsonValue = JsonValue.from("new_session")
            private var vaultIds: JsonField<MutableList<String>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(newSession: NewSession) = apply {
                agent = newSession.agent
                agentId = newSession.agentId
                environment = newSession.environment
                input = newSession.input.map { it.toMutableList() }
                metadata = newSession.metadata
                type = newSession.type
                vaultIds = newSession.vaultIds.map { it.toMutableList() }
                additionalProperties = newSession.additionalProperties.toMutableMap()
            }

            /** The inline agent configuration, or null when agent_id is configured. */
            fun agent(agent: AutomationAgentConfig?) = agent(JsonField.ofNullable(agent))

            /** Alias for calling [Builder.agent] with `agent.orElse(null)`. */
            fun agent(agent: Optional<AutomationAgentConfig>) = agent(agent.getOrNull())

            /**
             * Sets [Builder.agent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.agent] with a well-typed [AutomationAgentConfig]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun agent(agent: JsonField<AutomationAgentConfig>) = apply { this.agent = agent }

            /** The saved agent reference, or null when an inline agent is configured. */
            fun agentId(agentId: String?) = agentId(JsonField.ofNullable(agentId))

            /** Alias for calling [Builder.agentId] with `agentId.orElse(null)`. */
            fun agentId(agentId: Optional<String>) = agentId(agentId.getOrNull())

            /**
             * Sets [Builder.agentId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.agentId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun agentId(agentId: JsonField<String>) = apply { this.agentId = agentId }

            /** Configuration or references used to select the execution environment. */
            fun environment(environment: AutomationEnvironment) =
                environment(JsonField.of(environment))

            /**
             * Sets [Builder.environment] to an arbitrary JSON value.
             *
             * You should usually call [Builder.environment] with a well-typed
             * [AutomationEnvironment] value instead. This method is primarily for setting the field
             * to an undocumented or not yet supported value.
             */
            fun environment(environment: JsonField<AutomationEnvironment>) = apply {
                this.environment = environment
            }

            /** Alias for calling [environment] with `AutomationEnvironment.ofNone()`. */
            fun environmentNone() = environment(AutomationEnvironment.ofNone())

            /**
             * Alias for calling [environment] with
             * `AutomationEnvironment.ofOpenAIHosted(openaiHosted)`.
             */
            fun environment(openaiHosted: AutomationEnvironment.OpenAIHosted) =
                environment(AutomationEnvironment.ofOpenAIHosted(openaiHosted))

            /**
             * Alias for calling [environment] with
             * `AutomationEnvironment.ofSelfHosted(selfHosted)`.
             */
            fun environment(selfHosted: AutomationEnvironment.SelfHosted) =
                environment(AutomationEnvironment.ofSelfHosted(selfHosted))

            /** Initial input delivered to each new session. */
            fun input(input: List<Input>) = input(JsonField.of(input))

            /**
             * Sets [Builder.input] to an arbitrary JSON value.
             *
             * You should usually call [Builder.input] with a well-typed `List<Input>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun input(input: JsonField<List<Input>>) = apply {
                this.input = input.map { it.toMutableList() }
            }

            /**
             * Adds a single [Input] to [Builder.input].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addInput(input: Input) = apply {
                this.input =
                    (this.input ?: JsonField.of(mutableListOf())).also {
                        checkKnown("input", it).add(input)
                    }
            }

            /** Metadata attached to each new session. */
            fun metadata(metadata: Metadata) = metadata(JsonField.of(metadata))

            /**
             * Sets [Builder.metadata] to an arbitrary JSON value.
             *
             * You should usually call [Builder.metadata] with a well-typed [Metadata] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

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

            /** Vaults made available to each new session. */
            fun vaultIds(vaultIds: List<String>) = vaultIds(JsonField.of(vaultIds))

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
                    (vaultIds ?: JsonField.of(mutableListOf())).also {
                        checkKnown("vaultIds", it).add(vaultId)
                    }
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
             * .metadata()
             * .vaultIds()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): NewSession =
                NewSession(
                    checkRequired("agent", agent),
                    checkRequired("agentId", agentId),
                    checkRequired("environment", environment),
                    checkRequired("input", input).map { it.toImmutable() },
                    checkRequired("metadata", metadata),
                    type,
                    checkRequired("vaultIds", vaultIds).map { it.toImmutable() },
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

            agent().ifPresent { it.validate() }
            agentId()
            environmentOrThrow().validate()
            inputOrThrow().forEach { it.validate() }
            metadataOrThrow().validate()
            typeOrThrow()
            vaultIdsOrThrow()
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
            (agent.asKnown().getOrNull()?.validity() ?: 0) +
                (if (agentId.asKnown().isPresent) 1 else 0) +
                (environment.asKnown().getOrNull()?.validity() ?: 0) +
                (input.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (metadata.asKnown().getOrNull()?.validity() ?: 0) +
                type.let { if (it == JsonValue.from("new_session")) 1 else 0 } +
                (vaultIds.asKnown().getOrNull()?.size ?: 0)

        /** A user message recorded in a session. */
        class Input
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val content: JsonField<List<InputContent>>,
            private val role: JsonValue,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("content")
                @ExcludeMissing
                content: JsonField<List<InputContent>> = JsonMissing.of(),
                @JsonProperty("role") @ExcludeMissing role: JsonValue = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(content, role, type, mutableMapOf())

            /**
             * The content of the message. The schema requires this property. Returns empty if the
             * JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun content(): java.util.Optional<List<InputContent>> = content.getOptional("content")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun contentOrThrow(): List<InputContent> = content.getRequired("content")

            /**
             * The role of the message author. Always `user`. The schema requires this property.
             * Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun role(): java.util.Optional<JsonValue> {
                val raw = role
                return when {
                    raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                    !(raw == JsonValue.from("user")) ->
                        throw OpenAIInvalidDataException("`role` is invalid")
                    else -> java.util.Optional.of(raw)
                }
            }

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun roleOrThrow(): JsonValue = role().orElseGet { role.getRequired("role") }

            @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<JsonValue> = role

            /**
             * The type of the input item. Always `message`. The schema requires this property.
             * Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun type(): java.util.Optional<JsonValue> {
                val raw = type
                return when {
                    raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                    !(raw == JsonValue.from("message")) ->
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
             * Returns the raw JSON value of [content].
             *
             * Unlike [content], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("content")
            @ExcludeMissing
            fun _content(): JsonField<List<InputContent>> = content

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
                    "content" to this.content,
                    "role" to this.role,
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
                 * Returns a mutable builder for constructing an instance of [Input].
                 *
                 * The following fields are required:
                 * ```java
                 * .content()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Input]. */
            class Builder internal constructor() {

                private var content: JsonField<MutableList<InputContent>>? = null
                private var role: JsonValue = JsonValue.from("user")
                private var type: JsonValue = JsonValue.from("message")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(input: Input) = apply {
                    content = input.content.map { it.toMutableList() }
                    role = input.role
                    type = input.type
                    additionalProperties = input.additionalProperties.toMutableMap()
                }

                /** The content of the message. */
                fun content(content: List<InputContent>) = content(JsonField.of(content))

                /**
                 * Sets [Builder.content] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.content] with a well-typed `List<InputContent>`
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun content(content: JsonField<List<InputContent>>) = apply {
                    this.content = content.map { it.toMutableList() }
                }

                /**
                 * Adds a single [InputContent] to [Builder.content].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addContent(content: InputContent) = apply {
                    this.content =
                        (this.content ?: JsonField.of(mutableListOf())).also {
                            checkKnown("content", it).add(content)
                        }
                }

                /** Alias for calling [addContent] with `InputContent.ofInputText(inputText)`. */
                fun addContent(inputText: InputContent.InputText) =
                    addContent(InputContent.ofInputText(inputText))

                /**
                 * Alias for calling [addContent] with the following:
                 * ```java
                 * InputContent.InputText.builder()
                 *     .text(text)
                 *     .build()
                 * ```
                 */
                fun addInputTextContent(text: String) =
                    addContent(InputContent.InputText.builder().text(text).build())

                /** Alias for calling [addContent] with `InputContent.ofInputImage(inputImage)`. */
                fun addContent(inputImage: InputContent.InputImage) =
                    addContent(InputContent.ofInputImage(inputImage))

                /**
                 * Alias for calling [addContent] with the following:
                 * ```java
                 * InputContent.InputImage.builder()
                 *     .imageUrl(imageUrl)
                 *     .build()
                 * ```
                 */
                fun addInputImageContent(imageUrl: String) =
                    addContent(InputContent.InputImage.builder().imageUrl(imageUrl).build())

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("user")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun role(role: JsonValue) = apply { this.role = role }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("message")
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
                 * Returns an immutable instance of [Input].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .content()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Input =
                    Input(
                        checkRequired("content", content).map { it.toImmutable() },
                        role,
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
            fun validate(): Input = apply {
                if (validated) {
                    return@apply
                }

                contentOrThrow().forEach { it.validate() }
                roleOrThrow()
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
                (content.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                    role.let { if (it == JsonValue.from("user")) 1 else 0 } +
                    type.let { if (it == JsonValue.from("message")) 1 else 0 }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Input &&
                    content == other.content &&
                    role == other.role &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(content, role, type, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Input{content=$content, role=$role, type=$type, additionalProperties=$additionalProperties}"
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

            @JvmSynthetic
            internal fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            @JsonAnyGetter
            @ExcludeMissing
            private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

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
                agent == other.agent &&
                agentId == other.agentId &&
                environment == other.environment &&
                input == other.input &&
                metadata == other.metadata &&
                type == other.type &&
                vaultIds == other.vaultIds &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                agent,
                agentId,
                environment,
                input,
                metadata,
                type,
                vaultIds,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "NewSession{agent=$agent, agentId=$agentId, environment=$environment, input=$input, metadata=$metadata, type=$type, vaultIds=$vaultIds, additionalProperties=$additionalProperties}"
    }

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
         * Saved instructions delivered as an automation notification. The schema requires this
         * property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun instructions(): java.util.Optional<String> = instructions.getOptional("instructions")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun instructionsOrThrow(): String = instructions.getRequired("instructions")

        /**
         * The session receiving each invocation. The schema requires this property. Returns empty
         * if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun sessionId(): java.util.Optional<String> = sessionId.getOptional("session_id")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun sessionIdOrThrow(): String = sessionId.getRequired("session_id")

        /**
         * The type of the object. Always `existing_session`. The schema requires this property.
         * Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun type(): java.util.Optional<JsonValue> {
            val raw = type
            return when {
                raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
                !(raw == JsonValue.from("existing_session")) ->
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

        @JvmSynthetic
        internal fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        @JsonAnyGetter
        @ExcludeMissing
        private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

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

            /** Saved instructions delivered as an automation notification. */
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

            instructionsOrThrow()
            sessionIdOrThrow()
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
