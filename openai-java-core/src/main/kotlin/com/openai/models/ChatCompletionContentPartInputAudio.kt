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
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun inputAudio(): InputAudio = inputAudio.getRequired("input_audio")

    /** The type of the content part. Always `input_audio`. */
    fun type(): Type = type.getRequired("type")

    @JsonProperty("input_audio")
    @ExcludeMissing
    fun _inputAudio(): JsonField<InputAudio> = inputAudio

    /** The type of the content part. Always `input_audio`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ChatCompletionContentPartInputAudio = apply {
        if (validated) {
            return@apply
        }

        inputAudio().validate()
        type()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var inputAudio: JsonField<InputAudio>? = null
        private var type: JsonField<Type>? = null
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
        fun type(type: Type) = type(JsonField.of(type))

        /** The type of the content part. Always `input_audio`. */
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

        fun build(): ChatCompletionContentPartInputAudio =
            ChatCompletionContentPartInputAudio(
                checkRequired("inputAudio", inputAudio),
                checkRequired("type", type),
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

        class Builder {

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
        class Format
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val WAV = of("wav")

                @JvmField val MP3 = of("mp3")

                @JvmStatic fun of(value: String) = Format(JsonField.of(value))
            }

            enum class Known {
                WAV,
                MP3,
            }

            enum class Value {
                WAV,
                MP3,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    WAV -> Value.WAV
                    MP3 -> Value.MP3
                    else -> Value._UNKNOWN
                }

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

    /** The type of the content part. Always `input_audio`. */
    class Type
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val INPUT_AUDIO = of("input_audio")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            INPUT_AUDIO,
        }

        enum class Value {
            INPUT_AUDIO,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                INPUT_AUDIO -> Value.INPUT_AUDIO
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                INPUT_AUDIO -> Known.INPUT_AUDIO
                else -> throw OpenAIInvalidDataException("Unknown Type: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Type && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
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
