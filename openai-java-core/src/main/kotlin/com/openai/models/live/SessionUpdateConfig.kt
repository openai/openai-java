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
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Changes to an active Live session. Only delegation backend settings can be updated after startup.
 */
class SessionUpdateConfig
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val delegation: JsonField<Delegation>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("delegation")
        @ExcludeMissing
        delegation: JsonField<Delegation> = JsonMissing.of()
    ) : this(delegation, mutableMapOf())

    /**
     * Delegation settings to update. The delegation type must match the current session; omitted
     * settings retain their values.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun delegation(): Optional<Delegation> = delegation.getOptional("delegation")

    /**
     * Returns the raw JSON value of [delegation].
     *
     * Unlike [delegation], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("delegation")
    @ExcludeMissing
    fun _delegation(): JsonField<Delegation> = delegation

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

        /** Returns a mutable builder for constructing an instance of [SessionUpdateConfig]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SessionUpdateConfig]. */
    class Builder internal constructor() {

        private var delegation: JsonField<Delegation> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(sessionUpdateConfig: SessionUpdateConfig) = apply {
            delegation = sessionUpdateConfig.delegation
            additionalProperties = sessionUpdateConfig.additionalProperties.toMutableMap()
        }

        /**
         * Delegation settings to update. The delegation type must match the current session;
         * omitted settings retain their values.
         */
        fun delegation(delegation: Delegation?) = delegation(JsonField.ofNullable(delegation))

        /** Alias for calling [Builder.delegation] with `delegation.orElse(null)`. */
        fun delegation(delegation: Optional<Delegation>) = delegation(delegation.getOrNull())

        /**
         * Sets [Builder.delegation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.delegation] with a well-typed [Delegation] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun delegation(delegation: JsonField<Delegation>) = apply { this.delegation = delegation }

        /** Alias for calling [delegation] with `Delegation.ofClient(client)`. */
        fun delegation(client: ClientDelegation) = delegation(Delegation.ofClient(client))

        /** Alias for calling [delegation] with `Delegation.ofResponses(responses)`. */
        fun delegation(responses: Delegation.Responses) =
            delegation(Delegation.ofResponses(responses))

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
         * Returns an immutable instance of [SessionUpdateConfig].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): SessionUpdateConfig =
            SessionUpdateConfig(delegation, additionalProperties.toMutableMap())
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
    fun validate(): SessionUpdateConfig = apply {
        if (validated) {
            return@apply
        }

        delegation().ifPresent { it.validate() }
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
    @JvmSynthetic internal fun validity(): Int = (delegation.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * Delegation settings to update. The delegation type must match the current session; omitted
     * settings retain their values.
     */
    @JsonDeserialize(using = Delegation.Deserializer::class)
    @JsonSerialize(using = Delegation.Serializer::class)
    class Delegation
    private constructor(
        private val client: ClientDelegation? = null,
        private val responses: Responses? = null,
        private val _json: JsonValue? = null,
    ) {

        /**
         * Delegate tasks to your application. The Live session emits delegation events that your
         * backend handles.
         */
        fun client(): Optional<ClientDelegation> = Optional.ofNullable(client)

        /**
         * Update the Responses backend for an existing Live session without changing delegation
         * ownership.
         */
        fun responses(): Optional<Responses> = Optional.ofNullable(responses)

        fun isClient(): Boolean = client != null

        fun isResponses(): Boolean = responses != null

        /**
         * Delegate tasks to your application. The Live session emits delegation events that your
         * backend handles.
         */
        fun asClient(): ClientDelegation = client.getOrThrow("client")

        /**
         * Update the Responses backend for an existing Live session without changing delegation
         * ownership.
         */
        fun asResponses(): Responses = responses.getOrThrow("responses")

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
         * Optional<String> result = delegation.accept(new Delegation.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitClient(ClientDelegation client) {
         *         return Optional.of(client.toString());
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
                client != null -> visitor.visitClient(client)
                responses != null -> visitor.visitResponses(responses)
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
        fun validate(): Delegation = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitClient(client: ClientDelegation) {
                        client.validate()
                    }

                    override fun visitResponses(responses: Responses) {
                        responses.validate()
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
                    override fun visitClient(client: ClientDelegation) = client.validity()

                    override fun visitResponses(responses: Responses) = responses.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Delegation && client == other.client && responses == other.responses
        }

        override fun hashCode(): Int = Objects.hash(client, responses)

        override fun toString(): String =
            when {
                client != null -> "Delegation{client=$client}"
                responses != null -> "Delegation{responses=$responses}"
                _json != null -> "Delegation{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Delegation")
            }

        companion object {

            /**
             * Delegate tasks to your application. The Live session emits delegation events that
             * your backend handles.
             */
            @JvmStatic fun ofClient(client: ClientDelegation) = Delegation(client = client)

            /**
             * Update the Responses backend for an existing Live session without changing delegation
             * ownership.
             */
            @JvmStatic fun ofResponses(responses: Responses) = Delegation(responses = responses)
        }

        /**
         * An interface that defines how to map each variant of [Delegation] to a value of type [T].
         */
        interface Visitor<out T> {

            /**
             * Delegate tasks to your application. The Live session emits delegation events that
             * your backend handles.
             */
            fun visitClient(client: ClientDelegation): T

            /**
             * Update the Responses backend for an existing Live session without changing delegation
             * ownership.
             */
            fun visitResponses(responses: Responses): T

            /**
             * Maps an unknown variant of [Delegation] to a value of type [T].
             *
             * An instance of [Delegation] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Delegation: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Delegation>(Delegation::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Delegation {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "client" -> {
                        return tryDeserialize(node, jacksonTypeRef<ClientDelegation>())?.let {
                            Delegation(client = it, _json = json)
                        } ?: Delegation(_json = json)
                    }
                    "responses" -> {
                        return tryDeserialize(node, jacksonTypeRef<Responses>())?.let {
                            Delegation(responses = it, _json = json)
                        } ?: Delegation(_json = json)
                    }
                }

                return Delegation(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Delegation>(Delegation::class) {

            override fun serialize(
                value: Delegation,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.client != null -> generator.writeObject(value.client)
                    value.responses != null -> generator.writeObject(value.responses)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Delegation")
                }
            }
        }

        /**
         * Update the Responses backend for an existing Live session without changing delegation
         * ownership.
         */
        class Responses
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val type: JsonValue,
            private val responses: JsonField<ResponsesDelegationUpdateConfig>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("responses")
                @ExcludeMissing
                responses: JsonField<ResponsesDelegationUpdateConfig> = JsonMissing.of(),
            ) : this(type, responses, mutableMapOf())

            /**
             * The delegation owner. Always `responses` for tasks handled by the Responses API.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("responses")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Responses backend settings to update. Omitted settings keep their existing values.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun responses(): Optional<ResponsesDelegationUpdateConfig> =
                responses.getOptional("responses")

            /**
             * Returns the raw JSON value of [responses].
             *
             * Unlike [responses], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("responses")
            @ExcludeMissing
            fun _responses(): JsonField<ResponsesDelegationUpdateConfig> = responses

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

                /** Returns a mutable builder for constructing an instance of [Responses]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Responses]. */
            class Builder internal constructor() {

                private var type: JsonValue = JsonValue.from("responses")
                private var responses: JsonField<ResponsesDelegationUpdateConfig> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(responses: Responses) = apply {
                    type = responses.type
                    this.responses = responses.responses
                    additionalProperties = responses.additionalProperties.toMutableMap()
                }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("responses")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                /**
                 * Responses backend settings to update. Omitted settings keep their existing
                 * values.
                 */
                fun responses(responses: ResponsesDelegationUpdateConfig) =
                    responses(JsonField.of(responses))

                /**
                 * Sets [Builder.responses] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.responses] with a well-typed
                 * [ResponsesDelegationUpdateConfig] value instead. This method is primarily for
                 * setting the field to an undocumented or not yet supported value.
                 */
                fun responses(responses: JsonField<ResponsesDelegationUpdateConfig>) = apply {
                    this.responses = responses
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
                 * Returns an immutable instance of [Responses].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Responses =
                    Responses(type, responses, additionalProperties.toMutableMap())
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
            fun validate(): Responses = apply {
                if (validated) {
                    return@apply
                }

                _type().let {
                    if (it != JsonValue.from("responses")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                responses().ifPresent { it.validate() }
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
                type.let { if (it == JsonValue.from("responses")) 1 else 0 } +
                    (responses.asKnown().getOrNull()?.validity() ?: 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Responses &&
                    type == other.type &&
                    responses == other.responses &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(type, responses, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Responses{type=$type, responses=$responses, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SessionUpdateConfig &&
            delegation == other.delegation &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(delegation, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SessionUpdateConfig{delegation=$delegation, additionalProperties=$additionalProperties}"
}
