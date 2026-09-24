// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Optional overrides for a stored Live session. Omitted settings are inherited. The model, voice,
 * frontend instructions, and prior conversation come from the stored session. WebRTC negotiates its
 * audio format; audio.format is only supported on WebSocket forks.
 */
class MediaSessionForkConfig
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val client: JsonField<ClientConfig>,
    private val delegation: JsonField<Delegation>,
    private val store: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("client") @ExcludeMissing client: JsonField<ClientConfig> = JsonMissing.of(),
        @JsonProperty("delegation")
        @ExcludeMissing
        delegation: JsonField<Delegation> = JsonMissing.of(),
        @JsonProperty("store") @ExcludeMissing store: JsonField<Boolean> = JsonMissing.of(),
    ) : this(client, delegation, store, mutableMapOf())

    /**
     * Startup-only capabilities for an untrusted frontend attached to a unified WebRTC session.
     * Trusted sideband connections are unaffected.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun client(): Optional<ClientConfig> = client.getOptional("client")

    /**
     * Update the Responses backend for an existing Live session without changing delegation
     * ownership.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun delegation(): Optional<Delegation> = delegation.getOptional("delegation")

    /**
     * Whether to store the forked session. Omission inherits the stored session's setting.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun store(): Optional<Boolean> = store.getOptional("store")

    /**
     * Returns the raw JSON value of [client].
     *
     * Unlike [client], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("client") @ExcludeMissing fun _client(): JsonField<ClientConfig> = client

    /**
     * Returns the raw JSON value of [delegation].
     *
     * Unlike [delegation], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("delegation")
    @ExcludeMissing
    fun _delegation(): JsonField<Delegation> = delegation

    /**
     * Returns the raw JSON value of [store].
     *
     * Unlike [store], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("store") @ExcludeMissing fun _store(): JsonField<Boolean> = store

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

        /** Returns a mutable builder for constructing an instance of [MediaSessionForkConfig]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MediaSessionForkConfig]. */
    class Builder internal constructor() {

        private var client: JsonField<ClientConfig> = JsonMissing.of()
        private var delegation: JsonField<Delegation> = JsonMissing.of()
        private var store: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(mediaSessionForkConfig: MediaSessionForkConfig) = apply {
            client = mediaSessionForkConfig.client
            delegation = mediaSessionForkConfig.delegation
            store = mediaSessionForkConfig.store
            additionalProperties = mediaSessionForkConfig.additionalProperties.toMutableMap()
        }

        /**
         * Startup-only capabilities for an untrusted frontend attached to a unified WebRTC session.
         * Trusted sideband connections are unaffected.
         */
        fun client(client: ClientConfig) = client(JsonField.of(client))

        /**
         * Sets [Builder.client] to an arbitrary JSON value.
         *
         * You should usually call [Builder.client] with a well-typed [ClientConfig] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun client(client: JsonField<ClientConfig>) = apply { this.client = client }

        /**
         * Update the Responses backend for an existing Live session without changing delegation
         * ownership.
         */
        fun delegation(delegation: Delegation) = delegation(JsonField.of(delegation))

        /**
         * Sets [Builder.delegation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.delegation] with a well-typed [Delegation] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun delegation(delegation: JsonField<Delegation>) = apply { this.delegation = delegation }

        /** Whether to store the forked session. Omission inherits the stored session's setting. */
        fun store(store: Boolean) = store(JsonField.of(store))

        /**
         * Sets [Builder.store] to an arbitrary JSON value.
         *
         * You should usually call [Builder.store] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun store(store: JsonField<Boolean>) = apply { this.store = store }

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
         * Returns an immutable instance of [MediaSessionForkConfig].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): MediaSessionForkConfig =
            MediaSessionForkConfig(client, delegation, store, additionalProperties.toMutableMap())
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
    fun validate(): MediaSessionForkConfig = apply {
        if (validated) {
            return@apply
        }

        client().ifPresent { it.validate() }
        delegation().ifPresent { it.validate() }
        store()
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
        (client.asKnown().getOrNull()?.validity() ?: 0) +
            (delegation.asKnown().getOrNull()?.validity() ?: 0) +
            (if (store.asKnown().isPresent) 1 else 0)

    /**
     * Update the Responses backend for an existing Live session without changing delegation
     * ownership.
     */
    class Delegation
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
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun responses(): Optional<ResponsesDelegationUpdateConfig> =
            responses.getOptional("responses")

        /**
         * Returns the raw JSON value of [responses].
         *
         * Unlike [responses], this method doesn't throw if the JSON field has an unexpected type.
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

            /** Returns a mutable builder for constructing an instance of [Delegation]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Delegation]. */
        class Builder internal constructor() {

            private var type: JsonValue = JsonValue.from("responses")
            private var responses: JsonField<ResponsesDelegationUpdateConfig> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(delegation: Delegation) = apply {
                type = delegation.type
                responses = delegation.responses
                additionalProperties = delegation.additionalProperties.toMutableMap()
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
             * Responses backend settings to update. Omitted settings keep their existing values.
             */
            fun responses(responses: ResponsesDelegationUpdateConfig) =
                responses(JsonField.of(responses))

            /**
             * Sets [Builder.responses] to an arbitrary JSON value.
             *
             * You should usually call [Builder.responses] with a well-typed
             * [ResponsesDelegationUpdateConfig] value instead. This method is primarily for setting
             * the field to an undocumented or not yet supported value.
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Delegation].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Delegation =
                Delegation(type, responses, additionalProperties.toMutableMap())
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

            return other is Delegation &&
                type == other.type &&
                responses == other.responses &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(type, responses, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Delegation{type=$type, responses=$responses, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MediaSessionForkConfig &&
            client == other.client &&
            delegation == other.delegation &&
            store == other.store &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(client, delegation, store, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MediaSessionForkConfig{client=$client, delegation=$delegation, store=$store, additionalProperties=$additionalProperties}"
}
