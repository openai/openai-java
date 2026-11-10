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
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.core.collectAllProperties
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** How the automation was created, independently of how an invocation started. */
@JsonDeserialize(using = AutomationCreatedBy.Deserializer::class)
@JsonSerialize(using = AutomationCreatedBy.Serializer::class)
class AutomationCreatedBy
private constructor(
    private val developer: JsonValue? = null,
    private val agent: Agent? = null,
    private val _json: JsonValue? = null,
) {

    fun developer(): Optional<JsonValue> = Optional.ofNullable(developer)

    fun agent(): Optional<Agent> = Optional.ofNullable(agent)

    fun isDeveloper(): Boolean = developer != null

    fun isAgent(): Boolean = agent != null

    fun asDeveloper(): JsonValue = developer.getOrThrow("developer")

    fun asAgent(): Agent = agent.getOrThrow("agent")

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
     * Optional<String> result = automationCreatedBy.accept(new AutomationCreatedBy.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitDeveloper(JsonValue developer) {
     *         return Optional.of(developer.toString());
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
            developer != null -> visitor.visitDeveloper(developer)
            agent != null -> visitor.visitAgent(agent)
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
    fun validate(): AutomationCreatedBy = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitDeveloper(developer: JsonValue) {
                    developer.let {
                        if (it != JsonValue.from(mapOf("type" to "developer"))) {
                            throw OpenAIInvalidDataException("'developer' is invalid, received $it")
                        }
                    }
                }

                override fun visitAgent(agent: Agent) {
                    agent.validate()
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
                override fun visitDeveloper(developer: JsonValue) =
                    developer.let {
                        if (it == JsonValue.from(mapOf("type" to "developer"))) 1 else 0
                    }

                override fun visitAgent(agent: Agent) = agent.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AutomationCreatedBy &&
            developer == other.developer &&
            agent == other.agent &&
            (developer != null || agent != null || _json == other._json)
    }

    override fun hashCode(): Int =
        if (developer == null && agent == null) Objects.hash(_json)
        else Objects.hash(developer, agent)

    override fun toString(): String =
        when {
            developer != null -> "AutomationCreatedBy{developer=$developer}"
            agent != null -> "AutomationCreatedBy{agent=$agent}"
            _json != null -> "AutomationCreatedBy{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid AutomationCreatedBy")
        }

    companion object {

        @JvmStatic
        fun ofDeveloper() =
            AutomationCreatedBy(developer = JsonValue.from(mapOf("type" to "developer")))

        @JvmStatic fun ofAgent(agent: Agent) = AutomationCreatedBy(agent = agent)
    }

    /**
     * An interface that defines how to map each variant of [AutomationCreatedBy] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        fun visitDeveloper(developer: JsonValue): T = unknown(JsonValue.from(developer))

        fun visitAgent(agent: Agent): T = unknown(JsonValue.from(agent))

        /**
         * Maps an unknown variant of [AutomationCreatedBy] to a value of type [T].
         *
         * An instance of [AutomationCreatedBy] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * Unhandled known JSON variants reach this method as JSON values.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown AutomationCreatedBy")
        }
    }

    internal class Deserializer :
        BaseDeserializer<AutomationCreatedBy>(AutomationCreatedBy::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): AutomationCreatedBy {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "developer" -> {
                    return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                        ?.let { AutomationCreatedBy(developer = it, _json = json) }
                        ?.takeIf { it.isValid() } ?: AutomationCreatedBy(_json = json)
                }
                "agent" -> {
                    return tryDeserialize(node, jacksonTypeRef<Agent>())?.let {
                        AutomationCreatedBy(agent = it, _json = json)
                    } ?: AutomationCreatedBy(_json = json)
                }
            }

            return AutomationCreatedBy(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<AutomationCreatedBy>(AutomationCreatedBy::class) {

        override fun serialize(
            value: AutomationCreatedBy,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.developer != null -> generator.writeObject(value.developer)
                value.agent != null -> generator.writeObject(value.agent)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid AutomationCreatedBy")
            }
        }
    }

    class Agent
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val sessionId: JsonField<String>,
        private val toolCallId: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("session_id")
            @ExcludeMissing
            sessionId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("tool_call_id")
            @ExcludeMissing
            toolCallId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(sessionId, toolCallId, type, mutableMapOf())

        /**
         * The creator session, which is also the automation's target.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sessionId(): String = sessionId.getRequired("session_id")

        /**
         * The tool call that created the automation.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun toolCallId(): String = toolCallId.getRequired("tool_call_id")

        /**
         * The type of the object. Always `agent`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("agent")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [sessionId].
         *
         * Unlike [sessionId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("session_id") @ExcludeMissing fun _sessionId(): JsonField<String> = sessionId

        /**
         * Returns the raw JSON value of [toolCallId].
         *
         * Unlike [toolCallId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tool_call_id")
        @ExcludeMissing
        fun _toolCallId(): JsonField<String> = toolCallId

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
                "session_id" to this.sessionId,
                "tool_call_id" to this.toolCallId,
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
             * Returns a mutable builder for constructing an instance of [Agent].
             *
             * The following fields are required:
             * ```java
             * .sessionId()
             * .toolCallId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Agent]. */
        class Builder internal constructor() {

            private var sessionId: JsonField<String>? = null
            private var toolCallId: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("agent")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(agent: Agent) = apply {
                sessionId = agent.sessionId
                toolCallId = agent.toolCallId
                type = agent.type
                additionalProperties = agent.additionalProperties.toMutableMap()
            }

            /** The creator session, which is also the automation's target. */
            fun sessionId(sessionId: String) = sessionId(JsonField.of(sessionId))

            /**
             * Sets [Builder.sessionId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sessionId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sessionId(sessionId: JsonField<String>) = apply { this.sessionId = sessionId }

            /** The tool call that created the automation. */
            fun toolCallId(toolCallId: String) = toolCallId(JsonField.of(toolCallId))

            /**
             * Sets [Builder.toolCallId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.toolCallId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun toolCallId(toolCallId: JsonField<String>) = apply { this.toolCallId = toolCallId }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("agent")
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
             * Returns an immutable instance of [Agent].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .sessionId()
             * .toolCallId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Agent =
                Agent(
                    checkRequired("sessionId", sessionId),
                    checkRequired("toolCallId", toolCallId),
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
        fun validate(): Agent = apply {
            if (validated) {
                return@apply
            }

            sessionId()
            toolCallId()
            _type().let {
                if (it != JsonValue.from("agent")) {
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
            (if (sessionId.asKnown().isPresent) 1 else 0) +
                (if (toolCallId.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("agent")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Agent &&
                sessionId == other.sessionId &&
                toolCallId == other.toolCallId &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(sessionId, toolCallId, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Agent{sessionId=$sessionId, toolCallId=$toolCallId, type=$type, additionalProperties=$additionalProperties}"
    }
}
