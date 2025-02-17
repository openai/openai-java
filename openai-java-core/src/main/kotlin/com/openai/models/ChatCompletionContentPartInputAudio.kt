// File generated from our OpenAPI spec by Stainless.

package com.openai.models

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

/** Learn about [audio inputs](https://platform.openai.com/docs/guides/audio). */
@NoAutoDetect
class ChatCompletionContentPartInputAudio
@JsonCreator
private constructor(
    @JsonProperty("input_audio")
    @ExcludeMissing
    private val inputAudio: JsonField<InputAudio> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun inputAudio(): InputAudio = inputAudio.getRequired("input_audio")

    /** The type of the content part. Always `input_audio`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    @JsonProperty("input_audio")
    @ExcludeMissing
    fun _inputAudio(): JsonField<InputAudio> = inputAudio

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ChatCompletionContentPartInputAudio = apply {
        if (validated) {
            return@apply
        }

        inputAudio().validate()
        _type().let {
            if (it != JsonValue.from("input_audio")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ChatCompletionContentPartInputAudio]. */
    class Builder internal constructor() {

        private var inputAudio: JsonField<InputAudio>? = null
        private var type: JsonValue = JsonValue.from("input_audio")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            chatCompletionContentPartInputAudio: ChatCompletionContentPartInputAudio
        ) = apply {
            inputAudio = chatCompletionContentPartInputAudio.inputAudio
            type = chatCompletionContentPartInputAudio.type
            additionalProperties =
                chatCompletionContentPartInputAudio.additionalProperties.toMutableMap()
        }

        fun inputAudio(inputAudio: InputAudio) = inputAudio(JsonField.of(inputAudio))

        fun inputAudio(inputAudio: JsonField<InputAudio>) = apply { this.inputAudio = inputAudio }

        /** The type of the content part. Always `input_audio`. */
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

        fun build(): ChatCompletionContentPartInputAudio =
            ChatCompletionContentPartInputAudio(
                checkRequired("inputAudio", inputAudio),
                type,
                additionalProperties.toImmutable(),
            )
    }

    @NoAutoDetect
    class InputAudio
    @JsonCreator
    private constructor(
        @JsonProperty("data")
        @ExcludeMissing
        private val data: JsonField<String> = JsonMissing.of(),
        @JsonProperty("format")
        @ExcludeMissing
        private val format: JsonField<Format> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** Base64 encoded audio data. */
        fun data(): String = data.getRequired("data")

        /** The format of the encoded audio data. Currently supports "wav" and "mp3". */
        fun format(): Format = format.getRequired("format")

        /** Base64 encoded audio data. */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<String> = data

        /** The format of the encoded audio data. Currently supports "wav" and "mp3". */
        @JsonProperty("format") @ExcludeMissing fun _format(): JsonField<Format> = format

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): InputAudio = apply {
            if (validated) {
                return@apply
            }

            data()
            format()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [InputAudio]. */
        class Builder internal constructor() {

            private var data: JsonField<String>? = null
            private var format: JsonField<Format>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(inputAudio: InputAudio) = apply {
                data = inputAudio.data
                format = inputAudio.format
                additionalProperties = inputAudio.additionalProperties.toMutableMap()
            }

            /** Base64 encoded audio data. */
            fun data(data: String) = data(JsonField.of(data))

            /** Base64 encoded audio data. */
            fun data(data: JsonField<String>) = apply { this.data = data }

            /** The format of the encoded audio data. Currently supports "wav" and "mp3". */
            fun format(format: Format) = format(JsonField.of(format))

            /** The format of the encoded audio data. Currently supports "wav" and "mp3". */
            fun format(format: JsonField<Format>) = apply { this.format = format }

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

            fun build(): InputAudio =
                InputAudio(
                    checkRequired("data", data),
                    checkRequired("format", format),
                    additionalProperties.toImmutable(),
                )
        }

        /** The format of the encoded audio data. Currently supports "wav" and "mp3". */
        class Format @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val WAV = of("wav")

                @JvmField val MP3 = of("mp3")

                @JvmStatic fun of(value: String) = Format(JsonField.of(value))
            }

            /** An enum containing [Format]'s known values. */
            enum class Known {
                WAV,
                MP3,
            }

            /**
             * An enum containing [Format]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Format] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                WAV,
                MP3,
                /**
                 * An enum member indicating that [Format] was instantiated with an unknown value.
                 */
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
                    WAV -> Value.WAV
                    MP3 -> Value.MP3
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
                    WAV -> Known.WAV
                    MP3 -> Known.MP3
                    else -> throw OpenAIInvalidDataException("Unknown Format: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

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

            return /* spotless:off */ other is InputAudio && data == other.data && format == other.format && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(data, format, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "InputAudio{data=$data, format=$format, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionContentPartInputAudio && inputAudio == other.inputAudio && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(inputAudio, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatCompletionContentPartInputAudio{inputAudio=$inputAudio, type=$type, additionalProperties=$additionalProperties}"
}
