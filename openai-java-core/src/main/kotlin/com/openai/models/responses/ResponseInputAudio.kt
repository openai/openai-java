// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.checkRequired
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects

/** An audio input to the model. */
@NoAutoDetect
class ResponseInputAudio
@JsonCreator
private constructor(
    @JsonProperty("data") @ExcludeMissing private val data: JsonField<String> = JsonMissing.of(),
    @JsonProperty("format")
    @ExcludeMissing
    private val format: JsonField<Format> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** Base64-encoded audio data. */
    fun data(): String = data.getRequired("data")

    /** The format of the audio data. Currently supported formats are `mp3` and `wav`. */
    fun format(): Format = format.getRequired("format")

    /** The type of the input item. Always `input_audio`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /** Base64-encoded audio data. */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<String> = data

    /** The format of the audio data. Currently supported formats are `mp3` and `wav`. */
    @JsonProperty("format") @ExcludeMissing fun _format(): JsonField<Format> = format

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ResponseInputAudio = apply {
        if (validated) {
            return@apply
        }

        data()
        format()
        _type().let {
            if (it != JsonValue.from("input_audio")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ResponseInputAudio].
         *
         * The following fields are required:
         * ```java
         * .data()
         * .format()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseInputAudio]. */
    class Builder internal constructor() {

        private var data: JsonField<String>? = null
        private var format: JsonField<Format>? = null
        private var type: JsonValue = JsonValue.from("input_audio")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseInputAudio: ResponseInputAudio) = apply {
            data = responseInputAudio.data
            format = responseInputAudio.format
            type = responseInputAudio.type
            additionalProperties = responseInputAudio.additionalProperties.toMutableMap()
        }

        /** Base64-encoded audio data. */
        fun data(data: String) = data(JsonField.of(data))

        /** Base64-encoded audio data. */
        fun data(data: JsonField<String>) = apply { this.data = data }

        /** The format of the audio data. Currently supported formats are `mp3` and `wav`. */
        fun format(format: Format) = format(JsonField.of(format))

        /** The format of the audio data. Currently supported formats are `mp3` and `wav`. */
        fun format(format: JsonField<Format>) = apply { this.format = format }

        /** The type of the input item. Always `input_audio`. */
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

        fun build(): ResponseInputAudio =
            ResponseInputAudio(
                checkRequired("data", data),
                checkRequired("format", format),
                type,
                additionalProperties.toImmutable(),
            )
    }

    /** The format of the audio data. Currently supported formats are `mp3` and `wav`. */
    class Format @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val MP3 = of("mp3")

            @JvmField val WAV = of("wav")

            @JvmStatic fun of(value: String) = Format(JsonField.of(value))
        }

        /** An enum containing [Format]'s known values. */
        enum class Known {
            MP3,
            WAV,
        }

        /**
         * An enum containing [Format]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Format] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            MP3,
            WAV,
            /** An enum member indicating that [Format] was instantiated with an unknown value. */
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
                MP3 -> Value.MP3
                WAV -> Value.WAV
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
                MP3 -> Known.MP3
                WAV -> Known.WAV
                else -> throw OpenAIInvalidDataException("Unknown Format: $value")
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Format && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseInputAudio && data == other.data && format == other.format && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(data, format, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseInputAudio{data=$data, format=$format, type=$type, additionalProperties=$additionalProperties}"
}
