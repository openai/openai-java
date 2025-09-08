// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

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
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** The PCM audio format. Only a 24kHz sample rate is supported. */
@JsonDeserialize(using = RealtimeAudioFormats.Deserializer::class)
@JsonSerialize(using = RealtimeAudioFormats.Serializer::class)
class RealtimeAudioFormats
private constructor(
    private val audioPcm: AudioPcm? = null,
    private val audioPcmu: AudioPcmu? = null,
    private val audioPcma: AudioPcma? = null,
    private val _json: JsonValue? = null,
) {

    /** The PCM audio format. Only a 24kHz sample rate is supported. */
    fun audioPcm(): Optional<AudioPcm> = Optional.ofNullable(audioPcm)

    /** The G.711 μ-law format. */
    fun audioPcmu(): Optional<AudioPcmu> = Optional.ofNullable(audioPcmu)

    /** The G.711 A-law format. */
    fun audioPcma(): Optional<AudioPcma> = Optional.ofNullable(audioPcma)

    fun isAudioPcm(): Boolean = audioPcm != null

    fun isAudioPcmu(): Boolean = audioPcmu != null

    fun isAudioPcma(): Boolean = audioPcma != null

    /** The PCM audio format. Only a 24kHz sample rate is supported. */
    fun asAudioPcm(): AudioPcm = audioPcm.getOrThrow("audioPcm")

    /** The G.711 μ-law format. */
    fun asAudioPcmu(): AudioPcmu = audioPcmu.getOrThrow("audioPcmu")

    /** The G.711 A-law format. */
    fun asAudioPcma(): AudioPcma = audioPcma.getOrThrow("audioPcma")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            audioPcm != null -> visitor.visitAudioPcm(audioPcm)
            audioPcmu != null -> visitor.visitAudioPcmu(audioPcmu)
            audioPcma != null -> visitor.visitAudioPcma(audioPcma)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): RealtimeAudioFormats = apply {
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

        return other is RealtimeAudioFormats &&
            audioPcm == other.audioPcm &&
            audioPcmu == other.audioPcmu &&
            audioPcma == other.audioPcma
    }

    override fun hashCode(): Int = Objects.hash(audioPcm, audioPcmu, audioPcma)

    override fun toString(): String =
        when {
            audioPcm != null -> "RealtimeAudioFormats{audioPcm=$audioPcm}"
            audioPcmu != null -> "RealtimeAudioFormats{audioPcmu=$audioPcmu}"
            audioPcma != null -> "RealtimeAudioFormats{audioPcma=$audioPcma}"
            _json != null -> "RealtimeAudioFormats{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid RealtimeAudioFormats")
        }

    companion object {

        /** The PCM audio format. Only a 24kHz sample rate is supported. */
        @JvmStatic fun ofAudioPcm(audioPcm: AudioPcm) = RealtimeAudioFormats(audioPcm = audioPcm)

        /** The G.711 μ-law format. */
        @JvmStatic
        fun ofAudioPcmu(audioPcmu: AudioPcmu) = RealtimeAudioFormats(audioPcmu = audioPcmu)

        /** The G.711 A-law format. */
        @JvmStatic
        fun ofAudioPcma(audioPcma: AudioPcma) = RealtimeAudioFormats(audioPcma = audioPcma)
    }

    /**
     * An interface that defines how to map each variant of [RealtimeAudioFormats] to a value of
     * type [T].
     */
    interface Visitor<out T> {

        /** The PCM audio format. Only a 24kHz sample rate is supported. */
        fun visitAudioPcm(audioPcm: AudioPcm): T

        /** The G.711 μ-law format. */
        fun visitAudioPcmu(audioPcmu: AudioPcmu): T

        /** The G.711 A-law format. */
        fun visitAudioPcma(audioPcma: AudioPcma): T

        /**
         * Maps an unknown variant of [RealtimeAudioFormats] to a value of type [T].
         *
         * An instance of [RealtimeAudioFormats] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown RealtimeAudioFormats: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<RealtimeAudioFormats>(RealtimeAudioFormats::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): RealtimeAudioFormats {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "audio/pcm" -> {
                    return tryDeserialize(node, jacksonTypeRef<AudioPcm>())?.let {
                        RealtimeAudioFormats(audioPcm = it, _json = json)
                    } ?: RealtimeAudioFormats(_json = json)
                }
                "audio/pcmu" -> {
                    return tryDeserialize(node, jacksonTypeRef<AudioPcmu>())?.let {
                        RealtimeAudioFormats(audioPcmu = it, _json = json)
                    } ?: RealtimeAudioFormats(_json = json)
                }
                "audio/pcma" -> {
                    return tryDeserialize(node, jacksonTypeRef<AudioPcma>())?.let {
                        RealtimeAudioFormats(audioPcma = it, _json = json)
                    } ?: RealtimeAudioFormats(_json = json)
                }
            }

            return RealtimeAudioFormats(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<RealtimeAudioFormats>(RealtimeAudioFormats::class) {

        override fun serialize(
            value: RealtimeAudioFormats,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.audioPcm != null -> generator.writeObject(value.audioPcm)
                value.audioPcmu != null -> generator.writeObject(value.audioPcmu)
                value.audioPcma != null -> generator.writeObject(value.audioPcma)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid RealtimeAudioFormats")
            }
        }
    }

    /** The PCM audio format. Only a 24kHz sample rate is supported. */
    class AudioPcm
    private constructor(
        private val rate: JsonField<Rate>,
        private val type: JsonField<Type>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("rate") @ExcludeMissing rate: JsonField<Rate> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
        ) : this(rate, type, mutableMapOf())

        /**
         * The sample rate of the audio. Always `24000`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun rate(): Optional<Rate> = rate.getOptional("rate")

        /**
         * The audio format. Always `audio/pcm`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun type(): Optional<Type> = type.getOptional("type")

        /**
         * Returns the raw JSON value of [rate].
         *
         * Unlike [rate], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("rate") @ExcludeMissing fun _rate(): JsonField<Rate> = rate

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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

            /** Returns a mutable builder for constructing an instance of [AudioPcm]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [AudioPcm]. */
        class Builder internal constructor() {

            private var rate: JsonField<Rate> = JsonMissing.of()
            private var type: JsonField<Type> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(audioPcm: AudioPcm) = apply {
                rate = audioPcm.rate
                type = audioPcm.type
                additionalProperties = audioPcm.additionalProperties.toMutableMap()
            }

            /** The sample rate of the audio. Always `24000`. */
            fun rate(rate: Rate) = rate(JsonField.of(rate))

            /**
             * Sets [Builder.rate] to an arbitrary JSON value.
             *
             * You should usually call [Builder.rate] with a well-typed [Rate] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun rate(rate: JsonField<Rate>) = apply { this.rate = rate }

            /** The audio format. Always `audio/pcm`. */
            fun type(type: Type) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<Type>) = apply { this.type = type }

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
             */
            fun build(): AudioPcm = AudioPcm(rate, type, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): AudioPcm = apply {
            if (validated) {
                return@apply
            }

            rate().ifPresent { it.validate() }
            type().ifPresent { it.validate() }
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
                (type.asKnown().getOrNull()?.validity() ?: 0)

        /** The sample rate of the audio. Always `24000`. */
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

                @JvmField val _24000 = of(24000L)

                @JvmStatic fun of(value: Long) = Rate(JsonField.of(value))
            }

            /** An enum containing [Rate]'s known values. */
            enum class Known {
                _24000
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

        /** The audio format. Always `audio/pcm`. */
        class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val AUDIO_PCM = of("audio/pcm")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                AUDIO_PCM
            }

            /**
             * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Type] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                AUDIO_PCM,
                /** An enum member indicating that [Type] was instantiated with an unknown value. */
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
                    AUDIO_PCM -> Value.AUDIO_PCM
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
                    AUDIO_PCM -> Known.AUDIO_PCM
                    else -> throw OpenAIInvalidDataException("Unknown Type: $value")
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

            fun validate(): Type = apply {
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

                return other is Type && value == other.value
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

    /** The G.711 μ-law format. */
    class AudioPcmu
    private constructor(
        private val type: JsonField<Type>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of()
        ) : this(type, mutableMapOf())

        /**
         * The audio format. Always `audio/pcmu`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun type(): Optional<Type> = type.getOptional("type")

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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

            /** Returns a mutable builder for constructing an instance of [AudioPcmu]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [AudioPcmu]. */
        class Builder internal constructor() {

            private var type: JsonField<Type> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(audioPcmu: AudioPcmu) = apply {
                type = audioPcmu.type
                additionalProperties = audioPcmu.additionalProperties.toMutableMap()
            }

            /** The audio format. Always `audio/pcmu`. */
            fun type(type: Type) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<Type>) = apply { this.type = type }

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
             */
            fun build(): AudioPcmu = AudioPcmu(type, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): AudioPcmu = apply {
            if (validated) {
                return@apply
            }

            type().ifPresent { it.validate() }
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
        @JvmSynthetic internal fun validity(): Int = (type.asKnown().getOrNull()?.validity() ?: 0)

        /** The audio format. Always `audio/pcmu`. */
        class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val AUDIO_PCMU = of("audio/pcmu")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                AUDIO_PCMU
            }

            /**
             * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Type] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                AUDIO_PCMU,
                /** An enum member indicating that [Type] was instantiated with an unknown value. */
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
                    AUDIO_PCMU -> Value.AUDIO_PCMU
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
                    AUDIO_PCMU -> Known.AUDIO_PCMU
                    else -> throw OpenAIInvalidDataException("Unknown Type: $value")
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

            fun validate(): Type = apply {
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

                return other is Type && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AudioPcmu &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "AudioPcmu{type=$type, additionalProperties=$additionalProperties}"
    }

    /** The G.711 A-law format. */
    class AudioPcma
    private constructor(
        private val type: JsonField<Type>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of()
        ) : this(type, mutableMapOf())

        /**
         * The audio format. Always `audio/pcma`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun type(): Optional<Type> = type.getOptional("type")

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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

            /** Returns a mutable builder for constructing an instance of [AudioPcma]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [AudioPcma]. */
        class Builder internal constructor() {

            private var type: JsonField<Type> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(audioPcma: AudioPcma) = apply {
                type = audioPcma.type
                additionalProperties = audioPcma.additionalProperties.toMutableMap()
            }

            /** The audio format. Always `audio/pcma`. */
            fun type(type: Type) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<Type>) = apply { this.type = type }

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
             */
            fun build(): AudioPcma = AudioPcma(type, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): AudioPcma = apply {
            if (validated) {
                return@apply
            }

            type().ifPresent { it.validate() }
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
        @JvmSynthetic internal fun validity(): Int = (type.asKnown().getOrNull()?.validity() ?: 0)

        /** The audio format. Always `audio/pcma`. */
        class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val AUDIO_PCMA = of("audio/pcma")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                AUDIO_PCMA
            }

            /**
             * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Type] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                AUDIO_PCMA,
                /** An enum member indicating that [Type] was instantiated with an unknown value. */
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
                    AUDIO_PCMA -> Value.AUDIO_PCMA
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
                    AUDIO_PCMA -> Known.AUDIO_PCMA
                    else -> throw OpenAIInvalidDataException("Unknown Type: $value")
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

            fun validate(): Type = apply {
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

                return other is Type && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AudioPcma &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(type, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "AudioPcma{type=$type, additionalProperties=$additionalProperties}"
    }
}
