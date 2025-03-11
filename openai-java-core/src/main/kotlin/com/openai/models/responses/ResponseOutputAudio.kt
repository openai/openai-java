// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
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

/** An audio output from the model. */
@NoAutoDetect
class ResponseOutputAudio
@JsonCreator
private constructor(
    @JsonProperty("data") @ExcludeMissing private val data: JsonField<String> = JsonMissing.of(),
    @JsonProperty("transcript")
    @ExcludeMissing
    private val transcript: JsonField<String> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** Base64-encoded audio data from the model. */
    fun data(): String = data.getRequired("data")

    /** The transcript of the audio data from the model. */
    fun transcript(): String = transcript.getRequired("transcript")

    /** The type of the output audio. Always `output_audio`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /** Base64-encoded audio data from the model. */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<String> = data

    /** The transcript of the audio data from the model. */
    @JsonProperty("transcript") @ExcludeMissing fun _transcript(): JsonField<String> = transcript

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ResponseOutputAudio = apply {
        if (validated) {
            return@apply
        }

        data()
        transcript()
        _type().let {
            if (it != JsonValue.from("output_audio")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ResponseOutputAudio].
         *
         * The following fields are required:
         * ```java
         * .data()
         * .transcript()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseOutputAudio]. */
    class Builder internal constructor() {

        private var data: JsonField<String>? = null
        private var transcript: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("output_audio")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseOutputAudio: ResponseOutputAudio) = apply {
            data = responseOutputAudio.data
            transcript = responseOutputAudio.transcript
            type = responseOutputAudio.type
            additionalProperties = responseOutputAudio.additionalProperties.toMutableMap()
        }

        /** Base64-encoded audio data from the model. */
        fun data(data: String) = data(JsonField.of(data))

        /** Base64-encoded audio data from the model. */
        fun data(data: JsonField<String>) = apply { this.data = data }

        /** The transcript of the audio data from the model. */
        fun transcript(transcript: String) = transcript(JsonField.of(transcript))

        /** The transcript of the audio data from the model. */
        fun transcript(transcript: JsonField<String>) = apply { this.transcript = transcript }

        /** The type of the output audio. Always `output_audio`. */
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

        fun build(): ResponseOutputAudio =
            ResponseOutputAudio(
                checkRequired("data", data),
                checkRequired("transcript", transcript),
                type,
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseOutputAudio && data == other.data && transcript == other.transcript && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(data, transcript, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseOutputAudio{data=$data, transcript=$transcript, type=$type, additionalProperties=$additionalProperties}"
}
