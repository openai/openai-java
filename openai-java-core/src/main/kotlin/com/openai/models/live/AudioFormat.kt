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
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Audio encoding and sample rate for audio sent and received over a Live WebSocket connection.
 * WebRTC and SIP negotiate their media format separately.
 */
@JsonDeserialize(using = AudioFormat.Deserializer::class)
@JsonSerialize(using = AudioFormat.Serializer::class)
class AudioFormat
private constructor(
    private val audioPcm: AudioPcm? = null,
    private val audioPcmu: AudioPcmu? = null,
    private val audioPcma: AudioPcma? = null,
    private val _json: JsonValue? = null,
) {

    /** Raw, mono 16-bit little-endian PCM audio for a Live WebSocket connection. */
    fun audioPcm(): Optional<AudioPcm> = Optional.ofNullable(audioPcm)

    /** Raw, mono G.711 μ-law audio for a Live WebSocket connection. */
    fun audioPcmu(): Optional<AudioPcmu> = Optional.ofNullable(audioPcmu)

    /** Raw, mono G.711 A-law audio for a Live WebSocket connection. */
    fun audioPcma(): Optional<AudioPcma> = Optional.ofNullable(audioPcma)

    fun isAudioPcm(): Boolean = audioPcm != null

    fun isAudioPcmu(): Boolean = audioPcmu != null

    fun isAudioPcma(): Boolean = audioPcma != null

    /** Raw, mono 16-bit little-endian PCM audio for a Live WebSocket connection. */
    fun asAudioPcm(): AudioPcm = audioPcm.getOrThrow("audioPcm")

    /** Raw, mono G.711 μ-law audio for a Live WebSocket connection. */
    fun asAudioPcmu(): AudioPcmu = audioPcmu.getOrThrow("audioPcmu")

    /** Raw, mono G.711 A-law audio for a Live WebSocket connection. */
    fun asAudioPcma(): AudioPcma = audioPcma.getOrThrow("audioPcma")

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
     * Optional<String> result = audioFormat.accept(new AudioFormat.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitAudioPcm(AudioPcm audioPcm) {
     *         return Optional.of(audioPcm.toString());
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
            audioPcm != null -> visitor.visitAudioPcm(audioPcm)
            audioPcmu != null -> visitor.visitAudioPcmu(audioPcmu)
            audioPcma != null -> visitor.visitAudioPcma(audioPcma)
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
    fun validate(): AudioFormat = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitAudioPcm(audioPcm: AudioPcm) {
                    audioPcm.validate()
                }

                override fun visitAudioPcmu(audioPcmu: AudioPcmu) {
                    audioPcmu.validate()
                }

                override fun visitAudioPcma(audioPcma: AudioPcma) {
                    audioPcma.validate()
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
                override fun visitAudioPcm(audioPcm: AudioPcm) = audioPcm.validity()

                override fun visitAudioPcmu(audioPcmu: AudioPcmu) = audioPcmu.validity()

                override fun visitAudioPcma(audioPcma: AudioPcma) = audioPcma.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AudioFormat &&
            audioPcm == other.audioPcm &&
            audioPcmu == other.audioPcmu &&
            audioPcma == other.audioPcma
    }

    override fun hashCode(): Int = Objects.hash(audioPcm, audioPcmu, audioPcma)

    override fun toString(): String =
        when {
            audioPcm != null -> "AudioFormat{audioPcm=$audioPcm}"
            audioPcmu != null -> "AudioFormat{audioPcmu=$audioPcmu}"
            audioPcma != null -> "AudioFormat{audioPcma=$audioPcma}"
            _json != null -> "AudioFormat{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid AudioFormat")
        }

    companion object {

        /** Raw, mono 16-bit little-endian PCM audio for a Live WebSocket connection. */
        @JvmStatic fun ofAudioPcm(audioPcm: AudioPcm) = AudioFormat(audioPcm = audioPcm)

        /** Raw, mono G.711 μ-law audio for a Live WebSocket connection. */
        @JvmStatic fun ofAudioPcmu(audioPcmu: AudioPcmu) = AudioFormat(audioPcmu = audioPcmu)

        /** Raw, mono G.711 A-law audio for a Live WebSocket connection. */
        @JvmStatic fun ofAudioPcma(audioPcma: AudioPcma) = AudioFormat(audioPcma = audioPcma)
    }

    /**
     * An interface that defines how to map each variant of [AudioFormat] to a value of type [T].
     */
    interface Visitor<out T> {

        /** Raw, mono 16-bit little-endian PCM audio for a Live WebSocket connection. */
        fun visitAudioPcm(audioPcm: AudioPcm): T

        /** Raw, mono G.711 μ-law audio for a Live WebSocket connection. */
        fun visitAudioPcmu(audioPcmu: AudioPcmu): T

        /** Raw, mono G.711 A-law audio for a Live WebSocket connection. */
        fun visitAudioPcma(audioPcma: AudioPcma): T

        /**
         * Maps an unknown variant of [AudioFormat] to a value of type [T].
         *
         * An instance of [AudioFormat] can contain an unknown variant if it was deserialized from
         * data that doesn't match any known variant. For example, if the SDK is on an older version
         * than the API, then the API may respond with new variants that the SDK is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown AudioFormat: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<AudioFormat>(AudioFormat::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): AudioFormat {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "audio/pcm" -> {
                    return tryDeserialize(node, jacksonTypeRef<AudioPcm>())?.let {
                        AudioFormat(audioPcm = it, _json = json)
                    } ?: AudioFormat(_json = json)
                }
                "audio/pcmu" -> {
                    return tryDeserialize(node, jacksonTypeRef<AudioPcmu>())?.let {
                        AudioFormat(audioPcmu = it, _json = json)
                    } ?: AudioFormat(_json = json)
                }
                "audio/pcma" -> {
                    return tryDeserialize(node, jacksonTypeRef<AudioPcma>())?.let {
                        AudioFormat(audioPcma = it, _json = json)
                    } ?: AudioFormat(_json = json)
                }
            }

            return AudioFormat(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<AudioFormat>(AudioFormat::class) {

        override fun serialize(
            value: AudioFormat,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.audioPcm != null -> generator.writeObject(value.audioPcm)
                value.audioPcmu != null -> generator.writeObject(value.audioPcmu)
                value.audioPcma != null -> generator.writeObject(value.audioPcma)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid AudioFormat")
            }
        }
    }

    /** Raw, mono 16-bit little-endian PCM audio for a Live WebSocket connection. */
    class AudioPcm
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val rate: JsonField<Rate>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("rate") @ExcludeMissing rate: JsonField<Rate> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(rate, type, mutableMapOf())

        /**
         * Audio sample rate in hertz. Live WebSocket PCM audio supports 16000 or 24000 Hz.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun rate(): Rate = rate.getRequired("rate")

        /**
         * The audio encoding. Always `audio/pcm`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("audio/pcm")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [rate].
         *
         * Unlike [rate], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("rate") @ExcludeMissing fun _rate(): JsonField<Rate> = rate

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
             * Returns a mutable builder for constructing an instance of [AudioPcm].
             *
             * The following fields are required:
             * ```java
             * .rate()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [AudioPcm]. */
        class Builder internal constructor() {

            private var rate: JsonField<Rate>? = null
            private var type: JsonValue = JsonValue.from("audio/pcm")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(audioPcm: AudioPcm) = apply {
                rate = audioPcm.rate
                type = audioPcm.type
                additionalProperties = audioPcm.additionalProperties.toMutableMap()
            }

            /** Audio sample rate in hertz. Live WebSocket PCM audio supports 16000 or 24000 Hz. */
            fun rate(rate: Rate) = rate(JsonField.of(rate))

            /**
             * Sets [Builder.rate] to an arbitrary JSON value.
             *
             * You should usually call [Builder.rate] with a well-typed [Rate] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun rate(rate: JsonField<Rate>) = apply { this.rate = rate }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("audio/pcm")
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
             * Returns an immutable instance of [AudioPcm].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .rate()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): AudioPcm =
                AudioPcm(checkRequired("rate", rate), type, additionalProperties.toMutableMap())
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
        fun validate(): AudioPcm = apply {
            if (validated) {
                return@apply
            }

            rate().validate()
            _type().let {
                if (it != JsonValue.from("audio/pcm")) {
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
            (rate.asKnown().getOrNull()?.validity() ?: 0) +
                type.let { if (it == JsonValue.from("audio/pcm")) 1 else 0 }

        /** Audio sample rate in hertz. Live WebSocket PCM audio supports 16000 or 24000 Hz. */
        class Rate @JsonCreator private constructor(private val value: JsonField<Long>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<Long> = value

            companion object {

                @JvmField val _16000 = of(16000L)

                @JvmField val _24000 = of(24000L)

                @JvmStatic fun of(value: Long) = Rate(JsonField.of(value))
            }

            /** An enum containing [Rate]'s known values. */
            enum class Known {
                _16000,
                _24000,
            }

            /**
             * An enum containing [Rate]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Rate] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                _16000,
                _24000,
                /** An enum member indicating that [Rate] was instantiated with an unknown value. */
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
                    _16000 -> Value._16000
                    _24000 -> Value._24000
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
                    _16000 -> Known._16000
                    _24000 -> Known._24000
                    else -> throw OpenAIInvalidDataException("Unknown Rate: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * @throws OpenAIInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asLong(): Long =
                _value().asNumber().getOrNull()?.let {
                    if (it.toDouble() % 1 == 0.0) it.toLong() else null
                } ?: throw OpenAIInvalidDataException("Value is not a Long")

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
            fun validate(): Rate = apply {
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

                return other is Rate && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AudioPcm &&
                rate == other.rate &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(rate, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "AudioPcm{rate=$rate, type=$type, additionalProperties=$additionalProperties}"
    }

    /** Raw, mono G.711 μ-law audio for a Live WebSocket connection. */
    class AudioPcmu
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val rate: JsonField<Long>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("rate") @ExcludeMissing rate: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(rate, type, mutableMapOf())

        /**
         * Audio sample rate in hertz. G.711 audio uses 8000 Hz.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun rate(): Long = rate.getRequired("rate")

        /**
         * The audio encoding. Always `audio/pcmu`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("audio/pcmu")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [rate].
         *
         * Unlike [rate], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("rate") @ExcludeMissing fun _rate(): JsonField<Long> = rate

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
             * Returns a mutable builder for constructing an instance of [AudioPcmu].
             *
             * The following fields are required:
             * ```java
             * .rate()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [AudioPcmu]. */
        class Builder internal constructor() {

            private var rate: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("audio/pcmu")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(audioPcmu: AudioPcmu) = apply {
                rate = audioPcmu.rate
                type = audioPcmu.type
                additionalProperties = audioPcmu.additionalProperties.toMutableMap()
            }

            /** Audio sample rate in hertz. G.711 audio uses 8000 Hz. */
            fun rate(rate: Long) = rate(JsonField.of(rate))

            /**
             * Sets [Builder.rate] to an arbitrary JSON value.
             *
             * You should usually call [Builder.rate] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun rate(rate: JsonField<Long>) = apply { this.rate = rate }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("audio/pcmu")
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
             * Returns an immutable instance of [AudioPcmu].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .rate()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): AudioPcmu =
                AudioPcmu(checkRequired("rate", rate), type, additionalProperties.toMutableMap())
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
        fun validate(): AudioPcmu = apply {
            if (validated) {
                return@apply
            }

            rate()
            _type().let {
                if (it != JsonValue.from("audio/pcmu")) {
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
            (if (rate.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("audio/pcmu")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AudioPcmu &&
                rate == other.rate &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(rate, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "AudioPcmu{rate=$rate, type=$type, additionalProperties=$additionalProperties}"
    }

    /** Raw, mono G.711 A-law audio for a Live WebSocket connection. */
    class AudioPcma
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val rate: JsonField<Long>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("rate") @ExcludeMissing rate: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(rate, type, mutableMapOf())

        /**
         * Audio sample rate in hertz. G.711 audio uses 8000 Hz.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun rate(): Long = rate.getRequired("rate")

        /**
         * The audio encoding. Always `audio/pcma`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("audio/pcma")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [rate].
         *
         * Unlike [rate], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("rate") @ExcludeMissing fun _rate(): JsonField<Long> = rate

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
             * Returns a mutable builder for constructing an instance of [AudioPcma].
             *
             * The following fields are required:
             * ```java
             * .rate()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [AudioPcma]. */
        class Builder internal constructor() {

            private var rate: JsonField<Long>? = null
            private var type: JsonValue = JsonValue.from("audio/pcma")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(audioPcma: AudioPcma) = apply {
                rate = audioPcma.rate
                type = audioPcma.type
                additionalProperties = audioPcma.additionalProperties.toMutableMap()
            }

            /** Audio sample rate in hertz. G.711 audio uses 8000 Hz. */
            fun rate(rate: Long) = rate(JsonField.of(rate))

            /**
             * Sets [Builder.rate] to an arbitrary JSON value.
             *
             * You should usually call [Builder.rate] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun rate(rate: JsonField<Long>) = apply { this.rate = rate }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("audio/pcma")
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
             * Returns an immutable instance of [AudioPcma].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .rate()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): AudioPcma =
                AudioPcma(checkRequired("rate", rate), type, additionalProperties.toMutableMap())
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
        fun validate(): AudioPcma = apply {
            if (validated) {
                return@apply
            }

            rate()
            _type().let {
                if (it != JsonValue.from("audio/pcma")) {
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
            (if (rate.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("audio/pcma")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AudioPcma &&
                rate == other.rate &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(rate, type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "AudioPcma{rate=$rate, type=$type, additionalProperties=$additionalProperties}"
    }
}
