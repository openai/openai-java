// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects

/**
 * If the audio output modality is requested, this object contains data about the audio response
 * from the model. [Learn more](https://platform.openai.com/docs/guides/audio).
 */
class ChatCompletionAudio
private constructor(
    private val id: JsonField<String>,
    private val data: JsonField<String>,
    private val expiresAt: JsonField<Long>,
    private val transcript: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("data") @ExcludeMissing data: JsonField<String> = JsonMissing.of(),
        @JsonProperty("expires_at") @ExcludeMissing expiresAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("transcript") @ExcludeMissing transcript: JsonField<String> = JsonMissing.of(),
    ) : this(id, data, expiresAt, transcript, mutableMapOf())

    /**
     * Unique identifier for this audio response.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Base64 encoded audio bytes generated by the model, in the format specified in the request.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun data(): String = data.getRequired("data")

    /**
     * The Unix timestamp (in seconds) for when this audio response will no longer be accessible on
     * the server for use in multi-turn conversations.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun expiresAt(): Long = expiresAt.getRequired("expires_at")

    /**
     * Transcript of the audio generated by the model.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun transcript(): String = transcript.getRequired("transcript")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [data].
     *
     * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<String> = data

    /**
     * Returns the raw JSON value of [expiresAt].
     *
     * Unlike [expiresAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("expires_at") @ExcludeMissing fun _expiresAt(): JsonField<Long> = expiresAt

    /**
     * Returns the raw JSON value of [transcript].
     *
     * Unlike [transcript], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("transcript") @ExcludeMissing fun _transcript(): JsonField<String> = transcript

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
         * Returns a mutable builder for constructing an instance of [ChatCompletionAudio].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .data()
         * .expiresAt()
         * .transcript()
         * ```
         */
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

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /**
         * Base64 encoded audio bytes generated by the model, in the format specified in the
         * request.
         */
        fun data(data: String) = data(JsonField.of(data))

        /**
         * Sets [Builder.data] to an arbitrary JSON value.
         *
         * You should usually call [Builder.data] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun data(data: JsonField<String>) = apply { this.data = data }

        /**
         * The Unix timestamp (in seconds) for when this audio response will no longer be accessible
         * on the server for use in multi-turn conversations.
         */
        fun expiresAt(expiresAt: Long) = expiresAt(JsonField.of(expiresAt))

        /**
         * Sets [Builder.expiresAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.expiresAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun expiresAt(expiresAt: JsonField<Long>) = apply { this.expiresAt = expiresAt }

        /** Transcript of the audio generated by the model. */
        fun transcript(transcript: String) = transcript(JsonField.of(transcript))

        /**
         * Sets [Builder.transcript] to an arbitrary JSON value.
         *
         * You should usually call [Builder.transcript] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
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

        /**
         * Returns an immutable instance of [ChatCompletionAudio].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .data()
         * .expiresAt()
         * .transcript()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ChatCompletionAudio =
            ChatCompletionAudio(
                checkRequired("id", id),
                checkRequired("data", data),
                checkRequired("expiresAt", expiresAt),
                checkRequired("transcript", transcript),
                additionalProperties.toMutableMap(),
            )
    }

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
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (data.asKnown().isPresent) 1 else 0) +
            (if (expiresAt.asKnown().isPresent) 1 else 0) +
            (if (transcript.asKnown().isPresent) 1 else 0)

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
