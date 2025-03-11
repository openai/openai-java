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

/** Emitted when there is a partial transcript of audio. */
@NoAutoDetect
class ResponseAudioTranscriptDeltaEvent
@JsonCreator
private constructor(
    @JsonProperty("delta") @ExcludeMissing private val delta: JsonField<String> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The partial transcript of the audio response. */
    fun delta(): String = delta.getRequired("delta")

    /** The type of the event. Always `response.audio.transcript.delta`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /** The partial transcript of the audio response. */
    @JsonProperty("delta") @ExcludeMissing fun _delta(): JsonField<String> = delta

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ResponseAudioTranscriptDeltaEvent = apply {
        if (validated) {
            return@apply
        }

        delta()
        _type().let {
            if (it != JsonValue.from("response.audio.transcript.delta")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [ResponseAudioTranscriptDeltaEvent].
         *
         * The following fields are required:
         * ```java
         * .delta()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseAudioTranscriptDeltaEvent]. */
    class Builder internal constructor() {

        private var delta: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("response.audio.transcript.delta")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseAudioTranscriptDeltaEvent: ResponseAudioTranscriptDeltaEvent) =
            apply {
                delta = responseAudioTranscriptDeltaEvent.delta
                type = responseAudioTranscriptDeltaEvent.type
                additionalProperties =
                    responseAudioTranscriptDeltaEvent.additionalProperties.toMutableMap()
            }

        /** The partial transcript of the audio response. */
        fun delta(delta: String) = delta(JsonField.of(delta))

        /** The partial transcript of the audio response. */
        fun delta(delta: JsonField<String>) = apply { this.delta = delta }

        /** The type of the event. Always `response.audio.transcript.delta`. */
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

        fun build(): ResponseAudioTranscriptDeltaEvent =
            ResponseAudioTranscriptDeltaEvent(
                checkRequired("delta", delta),
                type,
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseAudioTranscriptDeltaEvent && delta == other.delta && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(delta, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseAudioTranscriptDeltaEvent{delta=$delta, type=$type, additionalProperties=$additionalProperties}"
}
