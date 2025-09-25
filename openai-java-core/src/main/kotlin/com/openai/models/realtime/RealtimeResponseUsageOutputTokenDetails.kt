// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

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

/** Details about the output tokens used in the Response. */
class RealtimeResponseUsageOutputTokenDetails
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val audioTokens: JsonField<Long>,
    private val textTokens: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("audio_tokens")
        @ExcludeMissing
        audioTokens: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("text_tokens") @ExcludeMissing textTokens: JsonField<Long> = JsonMissing.of(),
    ) : this(audioTokens, textTokens, mutableMapOf())

    /**
     * The number of audio tokens used in the Response.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun audioTokens(): Optional<Long> = audioTokens.getOptional("audio_tokens")

    /**
     * The number of text tokens used in the Response.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun textTokens(): Optional<Long> = textTokens.getOptional("text_tokens")

    /**
     * Returns the raw JSON value of [audioTokens].
     *
     * Unlike [audioTokens], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("audio_tokens") @ExcludeMissing fun _audioTokens(): JsonField<Long> = audioTokens

    /**
     * Returns the raw JSON value of [textTokens].
     *
     * Unlike [textTokens], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("text_tokens") @ExcludeMissing fun _textTokens(): JsonField<Long> = textTokens

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
         * Returns a mutable builder for constructing an instance of
         * [RealtimeResponseUsageOutputTokenDetails].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RealtimeResponseUsageOutputTokenDetails]. */
    class Builder internal constructor() {

        private var audioTokens: JsonField<Long> = JsonMissing.of()
        private var textTokens: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            realtimeResponseUsageOutputTokenDetails: RealtimeResponseUsageOutputTokenDetails
        ) = apply {
            audioTokens = realtimeResponseUsageOutputTokenDetails.audioTokens
            textTokens = realtimeResponseUsageOutputTokenDetails.textTokens
            additionalProperties =
                realtimeResponseUsageOutputTokenDetails.additionalProperties.toMutableMap()
        }

        /** The number of audio tokens used in the Response. */
        fun audioTokens(audioTokens: Long) = audioTokens(JsonField.of(audioTokens))

        /**
         * Sets [Builder.audioTokens] to an arbitrary JSON value.
         *
         * You should usually call [Builder.audioTokens] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun audioTokens(audioTokens: JsonField<Long>) = apply { this.audioTokens = audioTokens }

        /** The number of text tokens used in the Response. */
        fun textTokens(textTokens: Long) = textTokens(JsonField.of(textTokens))

        /**
         * Sets [Builder.textTokens] to an arbitrary JSON value.
         *
         * You should usually call [Builder.textTokens] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun textTokens(textTokens: JsonField<Long>) = apply { this.textTokens = textTokens }

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
         * Returns an immutable instance of [RealtimeResponseUsageOutputTokenDetails].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): RealtimeResponseUsageOutputTokenDetails =
            RealtimeResponseUsageOutputTokenDetails(
                audioTokens,
                textTokens,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): RealtimeResponseUsageOutputTokenDetails = apply {
        if (validated) {
            return@apply
        }

        audioTokens()
        textTokens()
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
        (if (audioTokens.asKnown().isPresent) 1 else 0) +
            (if (textTokens.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeResponseUsageOutputTokenDetails &&
            audioTokens == other.audioTokens &&
            textTokens == other.textTokens &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(audioTokens, textTokens, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RealtimeResponseUsageOutputTokenDetails{audioTokens=$audioTokens, textTokens=$textTokens, additionalProperties=$additionalProperties}"
}
