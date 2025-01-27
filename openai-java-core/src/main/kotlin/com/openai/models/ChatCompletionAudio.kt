// File generated from our OpenAPI spec by Stainless.

package com.openai.models

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
import java.util.Objects

/**
 * If the audio output modality is requested, this object contains data about the audio response
 * from the model. [Learn more](https://platform.openai.com/docs/guides/audio).
 */
@NoAutoDetect
class ChatCompletionAudio
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("data") @ExcludeMissing private val data: JsonField<String> = JsonMissing.of(),
    @JsonProperty("expires_at")
    @ExcludeMissing
    private val expiresAt: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("transcript")
    @ExcludeMissing
    private val transcript: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** Unique identifier for this audio response. */
    fun id(): String = id.getRequired("id")

    /**
     * Base64 encoded audio bytes generated by the model, in the format specified in the request.
     */
    fun data(): String = data.getRequired("data")

    /**
     * The Unix timestamp (in seconds) for when this audio response will no longer be accessible on
     * the server for use in multi-turn conversations.
     */
    fun expiresAt(): Long = expiresAt.getRequired("expires_at")

    /** Transcript of the audio generated by the model. */
    fun transcript(): String = transcript.getRequired("transcript")

    /** Unique identifier for this audio response. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Base64 encoded audio bytes generated by the model, in the format specified in the request.
     */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<String> = data

    /**
     * The Unix timestamp (in seconds) for when this audio response will no longer be accessible on
     * the server for use in multi-turn conversations.
     */
    @JsonProperty("expires_at") @ExcludeMissing fun _expiresAt(): JsonField<Long> = expiresAt

    /** Transcript of the audio generated by the model. */
    @JsonProperty("transcript") @ExcludeMissing fun _transcript(): JsonField<String> = transcript

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ChatCompletionAudio = apply {
        if (validated) {
            return@apply
        }

        id()
        data()
        expiresAt()
        transcript()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ChatCompletionAudio]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var data: JsonField<String>? = null
        private var expiresAt: JsonField<Long>? = null
        private var transcript: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletionAudio: ChatCompletionAudio) = apply {
            id = chatCompletionAudio.id
            data = chatCompletionAudio.data
            expiresAt = chatCompletionAudio.expiresAt
            transcript = chatCompletionAudio.transcript
            additionalProperties = chatCompletionAudio.additionalProperties.toMutableMap()
        }

        /** Unique identifier for this audio response. */
        fun id(id: String) = id(JsonField.of(id))

        /** Unique identifier for this audio response. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /**
         * Base64 encoded audio bytes generated by the model, in the format specified in the
         * request.
         */
        fun data(data: String) = data(JsonField.of(data))

        /**
         * Base64 encoded audio bytes generated by the model, in the format specified in the
         * request.
         */
        fun data(data: JsonField<String>) = apply { this.data = data }

        /**
         * The Unix timestamp (in seconds) for when this audio response will no longer be accessible
         * on the server for use in multi-turn conversations.
         */
        fun expiresAt(expiresAt: Long) = expiresAt(JsonField.of(expiresAt))

        /**
         * The Unix timestamp (in seconds) for when this audio response will no longer be accessible
         * on the server for use in multi-turn conversations.
         */
        fun expiresAt(expiresAt: JsonField<Long>) = apply { this.expiresAt = expiresAt }

        /** Transcript of the audio generated by the model. */
        fun transcript(transcript: String) = transcript(JsonField.of(transcript))

        /** Transcript of the audio generated by the model. */
        fun transcript(transcript: JsonField<String>) = apply { this.transcript = transcript }

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

        fun build(): ChatCompletionAudio =
            ChatCompletionAudio(
                checkRequired("id", id),
                checkRequired("data", data),
                checkRequired("expiresAt", expiresAt),
                checkRequired("transcript", transcript),
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionAudio && id == other.id && data == other.data && expiresAt == other.expiresAt && transcript == other.transcript && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, data, expiresAt, transcript, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatCompletionAudio{id=$id, data=$data, expiresAt=$expiresAt, transcript=$transcript, additionalProperties=$additionalProperties}"
}
