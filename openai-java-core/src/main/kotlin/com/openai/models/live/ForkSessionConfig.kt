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
 * Overrides for a stored session after connecting to the fork WebSocket. An empty object inherits
 * the stored configuration; do not supply a new model. audio.format applies only to the new
 * WebSocket connection. client overrides are only supported for WebRTC forks.
 */
class ForkSessionConfig
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val audio: JsonField<Audio>,
    private val client: JsonField<ClientConfig>,
    private val delegation: JsonField<Delegation>,
    private val store: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("audio") @ExcludeMissing audio: JsonField<Audio> = JsonMissing.of(),
        @JsonProperty("client") @ExcludeMissing client: JsonField<ClientConfig> = JsonMissing.of(),
        @JsonProperty("delegation")
        @ExcludeMissing
        delegation: JsonField<Delegation> = JsonMissing.of(),
        @JsonProperty("store") @ExcludeMissing store: JsonField<Boolean> = JsonMissing.of(),
    ) : this(audio, client, delegation, store, mutableMapOf())

    /**
     * Audio format for a WebSocket fork. WebRTC forks negotiate their audio format and must omit
     * this field.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun audio(): Optional<Audio> = audio.getOptional("audio")

    /**
     * Frontend data-channel permissions for a WebRTC fork. Omitted permissions inherit the stored
     * values. Not supported for WebSocket forks.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun client(): Optional<ClientConfig> = client.getOptional("client")

    /**
     * Overrides for the stored session’s Responses backend. Only supported when the stored session
     * already uses Responses delegation; the delegation type cannot change.
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
     * Returns the raw JSON value of [audio].
     *
     * Unlike [audio], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("audio") @ExcludeMissing fun _audio(): JsonField<Audio> = audio

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

        /** Returns a mutable builder for constructing an instance of [ForkSessionConfig]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ForkSessionConfig]. */
    class Builder internal constructor() {

        private var audio: JsonField<Audio> = JsonMissing.of()
        private var client: JsonField<ClientConfig> = JsonMissing.of()
        private var delegation: JsonField<Delegation> = JsonMissing.of()
        private var store: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(forkSessionConfig: ForkSessionConfig) = apply {
            audio = forkSessionConfig.audio
            client = forkSessionConfig.client
            delegation = forkSessionConfig.delegation
            store = forkSessionConfig.store
            additionalProperties = forkSessionConfig.additionalProperties.toMutableMap()
        }

        /**
         * Audio format for a WebSocket fork. WebRTC forks negotiate their audio format and must
         * omit this field.
         */
        fun audio(audio: Audio) = audio(JsonField.of(audio))

        /**
         * Sets [Builder.audio] to an arbitrary JSON value.
         *
         * You should usually call [Builder.audio] with a well-typed [Audio] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun audio(audio: JsonField<Audio>) = apply { this.audio = audio }

        /**
         * Frontend data-channel permissions for a WebRTC fork. Omitted permissions inherit the
         * stored values. Not supported for WebSocket forks.
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
         * Overrides for the stored session’s Responses backend. Only supported when the stored
         * session already uses Responses delegation; the delegation type cannot change.
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
         * Returns an immutable instance of [ForkSessionConfig].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ForkSessionConfig =
            ForkSessionConfig(audio, client, delegation, store, additionalProperties.toMutableMap())
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
    fun validate(): ForkSessionConfig = apply {
        if (validated) {
            return@apply
        }

        audio().ifPresent { it.validate() }
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
        (audio.asKnown().getOrNull()?.validity() ?: 0) +
            (client.asKnown().getOrNull()?.validity() ?: 0) +
            (delegation.asKnown().getOrNull()?.validity() ?: 0) +
            (if (store.asKnown().isPresent) 1 else 0)

    /**
     * Audio format for a WebSocket fork. WebRTC forks negotiate their audio format and must omit
     * this field.
     */
    class Audio
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val format: JsonField<AudioFormat>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("format")
            @ExcludeMissing
            format: JsonField<AudioFormat> = JsonMissing.of()
        ) : this(format, mutableMapOf())

        /**
         * Audio encoding and sample rate for audio sent and received over a Live WebSocket
         * connection. WebRTC and SIP negotiate their media format separately.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun format(): Optional<AudioFormat> = format.getOptional("format")

        /**
         * Returns the raw JSON value of [format].
         *
         * Unlike [format], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("format") @ExcludeMissing fun _format(): JsonField<AudioFormat> = format

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

            /** Returns a mutable builder for constructing an instance of [Audio]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Audio]. */
        class Builder internal constructor() {

            private var format: JsonField<AudioFormat> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(audio: Audio) = apply {
                format = audio.format
                additionalProperties = audio.additionalProperties.toMutableMap()
            }

            /**
             * Audio encoding and sample rate for audio sent and received over a Live WebSocket
             * connection. WebRTC and SIP negotiate their media format separately.
             */
            fun format(format: AudioFormat) = format(JsonField.of(format))

            /**
             * Sets [Builder.format] to an arbitrary JSON value.
             *
             * You should usually call [Builder.format] with a well-typed [AudioFormat] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun format(format: JsonField<AudioFormat>) = apply { this.format = format }

            /** Alias for calling [format] with `AudioFormat.ofAudioPcm(audioPcm)`. */
            fun format(audioPcm: AudioFormat.AudioPcm) = format(AudioFormat.ofAudioPcm(audioPcm))

            /**
             * Alias for calling [format] with the following:
             * ```java
             * AudioFormat.AudioPcm.builder()
             *     .rate(rate)
             *     .build()
             * ```
             */
            fun audioPcmFormat(rate: AudioFormat.AudioPcm.Rate) =
                format(AudioFormat.AudioPcm.builder().rate(rate).build())

            /** Alias for calling [format] with `AudioFormat.ofAudioPcmu(audioPcmu)`. */
            fun format(audioPcmu: AudioFormat.AudioPcmu) =
                format(AudioFormat.ofAudioPcmu(audioPcmu))

            /**
             * Alias for calling [format] with the following:
             * ```java
             * AudioFormat.AudioPcmu.builder()
             *     .rate(rate)
             *     .build()
             * ```
             */
            fun audioPcmuFormat(rate: Long) =
                format(AudioFormat.AudioPcmu.builder().rate(rate).build())

            /** Alias for calling [format] with `AudioFormat.ofAudioPcma(audioPcma)`. */
            fun format(audioPcma: AudioFormat.AudioPcma) =
                format(AudioFormat.ofAudioPcma(audioPcma))

            /**
             * Alias for calling [format] with the following:
             * ```java
             * AudioFormat.AudioPcma.builder()
             *     .rate(rate)
             *     .build()
             * ```
             */
            fun audioPcmaFormat(rate: Long) =
                format(AudioFormat.AudioPcma.builder().rate(rate).build())

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
             * Returns an immutable instance of [Audio].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Audio = Audio(format, additionalProperties.toMutableMap())
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
        fun validate(): Audio = apply {
            if (validated) {
                return@apply
            }

            format().ifPresent { it.validate() }
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
        @JvmSynthetic internal fun validity(): Int = (format.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Audio &&
                format == other.format &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(format, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Audio{format=$format, additionalProperties=$additionalProperties}"
    }

    /**
     * Overrides for the stored session’s Responses backend. Only supported when the stored session
     * already uses Responses delegation; the delegation type cannot change.
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

        return other is ForkSessionConfig &&
            audio == other.audio &&
            client == other.client &&
            delegation == other.delegation &&
            store == other.store &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(audio, client, delegation, store, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ForkSessionConfig{audio=$audio, client=$client, delegation=$delegation, store=$store, additionalProperties=$additionalProperties}"
}
