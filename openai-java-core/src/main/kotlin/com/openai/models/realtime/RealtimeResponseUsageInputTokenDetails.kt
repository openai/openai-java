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
import kotlin.jvm.optionals.getOrNull

/**
 * Details about the input tokens used in the Response. Cached tokens are tokens from previous turns
 * in the conversation that are included as context for the current response. Cached tokens here are
 * counted as a subset of input tokens, meaning input tokens will include cached and uncached
 * tokens.
 */
class RealtimeResponseUsageInputTokenDetails
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val audioTokens: JsonField<Long>,
    private val cachedTokens: JsonField<Long>,
    private val cachedTokensDetails: JsonField<CachedTokensDetails>,
    private val imageTokens: JsonField<Long>,
    private val textTokens: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("audio_tokens")
        @ExcludeMissing
        audioTokens: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("cached_tokens")
        @ExcludeMissing
        cachedTokens: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("cached_tokens_details")
        @ExcludeMissing
        cachedTokensDetails: JsonField<CachedTokensDetails> = JsonMissing.of(),
        @JsonProperty("image_tokens")
        @ExcludeMissing
        imageTokens: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("text_tokens") @ExcludeMissing textTokens: JsonField<Long> = JsonMissing.of(),
    ) : this(
        audioTokens,
        cachedTokens,
        cachedTokensDetails,
        imageTokens,
        textTokens,
        mutableMapOf(),
    )

    /**
     * The number of audio tokens used as input for the Response.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun audioTokens(): Optional<Long> = audioTokens.getOptional("audio_tokens")

    /**
     * The number of cached tokens used as input for the Response.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun cachedTokens(): Optional<Long> = cachedTokens.getOptional("cached_tokens")

    /**
     * Details about the cached tokens used as input for the Response.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun cachedTokensDetails(): Optional<CachedTokensDetails> =
        cachedTokensDetails.getOptional("cached_tokens_details")

    /**
     * The number of image tokens used as input for the Response.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun imageTokens(): Optional<Long> = imageTokens.getOptional("image_tokens")

    /**
     * The number of text tokens used as input for the Response.
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
     * Returns the raw JSON value of [cachedTokens].
     *
     * Unlike [cachedTokens], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("cached_tokens")
    @ExcludeMissing
    fun _cachedTokens(): JsonField<Long> = cachedTokens

    /**
     * Returns the raw JSON value of [cachedTokensDetails].
     *
     * Unlike [cachedTokensDetails], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("cached_tokens_details")
    @ExcludeMissing
    fun _cachedTokensDetails(): JsonField<CachedTokensDetails> = cachedTokensDetails

    /**
     * Returns the raw JSON value of [imageTokens].
     *
     * Unlike [imageTokens], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("image_tokens") @ExcludeMissing fun _imageTokens(): JsonField<Long> = imageTokens

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
         * [RealtimeResponseUsageInputTokenDetails].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RealtimeResponseUsageInputTokenDetails]. */
    class Builder internal constructor() {

        private var audioTokens: JsonField<Long> = JsonMissing.of()
        private var cachedTokens: JsonField<Long> = JsonMissing.of()
        private var cachedTokensDetails: JsonField<CachedTokensDetails> = JsonMissing.of()
        private var imageTokens: JsonField<Long> = JsonMissing.of()
        private var textTokens: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            realtimeResponseUsageInputTokenDetails: RealtimeResponseUsageInputTokenDetails
        ) = apply {
            audioTokens = realtimeResponseUsageInputTokenDetails.audioTokens
            cachedTokens = realtimeResponseUsageInputTokenDetails.cachedTokens
            cachedTokensDetails = realtimeResponseUsageInputTokenDetails.cachedTokensDetails
            imageTokens = realtimeResponseUsageInputTokenDetails.imageTokens
            textTokens = realtimeResponseUsageInputTokenDetails.textTokens
            additionalProperties =
                realtimeResponseUsageInputTokenDetails.additionalProperties.toMutableMap()
        }

        /** The number of audio tokens used as input for the Response. */
        fun audioTokens(audioTokens: Long) = audioTokens(JsonField.of(audioTokens))

        /**
         * Sets [Builder.audioTokens] to an arbitrary JSON value.
         *
         * You should usually call [Builder.audioTokens] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun audioTokens(audioTokens: JsonField<Long>) = apply { this.audioTokens = audioTokens }

        /** The number of cached tokens used as input for the Response. */
        fun cachedTokens(cachedTokens: Long) = cachedTokens(JsonField.of(cachedTokens))

        /**
         * Sets [Builder.cachedTokens] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cachedTokens] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun cachedTokens(cachedTokens: JsonField<Long>) = apply { this.cachedTokens = cachedTokens }

        /** Details about the cached tokens used as input for the Response. */
        fun cachedTokensDetails(cachedTokensDetails: CachedTokensDetails) =
            cachedTokensDetails(JsonField.of(cachedTokensDetails))

        /**
         * Sets [Builder.cachedTokensDetails] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cachedTokensDetails] with a well-typed
         * [CachedTokensDetails] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun cachedTokensDetails(cachedTokensDetails: JsonField<CachedTokensDetails>) = apply {
            this.cachedTokensDetails = cachedTokensDetails
        }

        /** The number of image tokens used as input for the Response. */
        fun imageTokens(imageTokens: Long) = imageTokens(JsonField.of(imageTokens))

        /**
         * Sets [Builder.imageTokens] to an arbitrary JSON value.
         *
         * You should usually call [Builder.imageTokens] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun imageTokens(imageTokens: JsonField<Long>) = apply { this.imageTokens = imageTokens }

        /** The number of text tokens used as input for the Response. */
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
         * Returns an immutable instance of [RealtimeResponseUsageInputTokenDetails].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): RealtimeResponseUsageInputTokenDetails =
            RealtimeResponseUsageInputTokenDetails(
                audioTokens,
                cachedTokens,
                cachedTokensDetails,
                imageTokens,
                textTokens,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): RealtimeResponseUsageInputTokenDetails = apply {
        if (validated) {
            return@apply
        }

        audioTokens()
        cachedTokens()
        cachedTokensDetails().ifPresent { it.validate() }
        imageTokens()
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
            (if (cachedTokens.asKnown().isPresent) 1 else 0) +
            (cachedTokensDetails.asKnown().getOrNull()?.validity() ?: 0) +
            (if (imageTokens.asKnown().isPresent) 1 else 0) +
            (if (textTokens.asKnown().isPresent) 1 else 0)

    /** Details about the cached tokens used as input for the Response. */
    class CachedTokensDetails
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val audioTokens: JsonField<Long>,
        private val imageTokens: JsonField<Long>,
        private val textTokens: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("audio_tokens")
            @ExcludeMissing
            audioTokens: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("image_tokens")
            @ExcludeMissing
            imageTokens: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("text_tokens")
            @ExcludeMissing
            textTokens: JsonField<Long> = JsonMissing.of(),
        ) : this(audioTokens, imageTokens, textTokens, mutableMapOf())

        /**
         * The number of cached audio tokens used as input for the Response.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun audioTokens(): Optional<Long> = audioTokens.getOptional("audio_tokens")

        /**
         * The number of cached image tokens used as input for the Response.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun imageTokens(): Optional<Long> = imageTokens.getOptional("image_tokens")

        /**
         * The number of cached text tokens used as input for the Response.
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
        @JsonProperty("audio_tokens")
        @ExcludeMissing
        fun _audioTokens(): JsonField<Long> = audioTokens

        /**
         * Returns the raw JSON value of [imageTokens].
         *
         * Unlike [imageTokens], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("image_tokens")
        @ExcludeMissing
        fun _imageTokens(): JsonField<Long> = imageTokens

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

            /** Returns a mutable builder for constructing an instance of [CachedTokensDetails]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [CachedTokensDetails]. */
        class Builder internal constructor() {

            private var audioTokens: JsonField<Long> = JsonMissing.of()
            private var imageTokens: JsonField<Long> = JsonMissing.of()
            private var textTokens: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(cachedTokensDetails: CachedTokensDetails) = apply {
                audioTokens = cachedTokensDetails.audioTokens
                imageTokens = cachedTokensDetails.imageTokens
                textTokens = cachedTokensDetails.textTokens
                additionalProperties = cachedTokensDetails.additionalProperties.toMutableMap()
            }

            /** The number of cached audio tokens used as input for the Response. */
            fun audioTokens(audioTokens: Long) = audioTokens(JsonField.of(audioTokens))

            /**
             * Sets [Builder.audioTokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.audioTokens] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun audioTokens(audioTokens: JsonField<Long>) = apply { this.audioTokens = audioTokens }

            /** The number of cached image tokens used as input for the Response. */
            fun imageTokens(imageTokens: Long) = imageTokens(JsonField.of(imageTokens))

            /**
             * Sets [Builder.imageTokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.imageTokens] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun imageTokens(imageTokens: JsonField<Long>) = apply { this.imageTokens = imageTokens }

            /** The number of cached text tokens used as input for the Response. */
            fun textTokens(textTokens: Long) = textTokens(JsonField.of(textTokens))

            /**
             * Sets [Builder.textTokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.textTokens] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * Returns an immutable instance of [CachedTokensDetails].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): CachedTokensDetails =
                CachedTokensDetails(
                    audioTokens,
                    imageTokens,
                    textTokens,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): CachedTokensDetails = apply {
            if (validated) {
                return@apply
            }

            audioTokens()
            imageTokens()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (audioTokens.asKnown().isPresent) 1 else 0) +
                (if (imageTokens.asKnown().isPresent) 1 else 0) +
                (if (textTokens.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CachedTokensDetails &&
                audioTokens == other.audioTokens &&
                imageTokens == other.imageTokens &&
                textTokens == other.textTokens &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(audioTokens, imageTokens, textTokens, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "CachedTokensDetails{audioTokens=$audioTokens, imageTokens=$imageTokens, textTokens=$textTokens, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeResponseUsageInputTokenDetails &&
            audioTokens == other.audioTokens &&
            cachedTokens == other.cachedTokens &&
            cachedTokensDetails == other.cachedTokensDetails &&
            imageTokens == other.imageTokens &&
            textTokens == other.textTokens &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            audioTokens,
            cachedTokens,
            cachedTokensDetails,
            imageTokens,
            textTokens,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RealtimeResponseUsageInputTokenDetails{audioTokens=$audioTokens, cachedTokens=$cachedTokens, cachedTokensDetails=$cachedTokensDetails, imageTokens=$imageTokens, textTokens=$textTokens, additionalProperties=$additionalProperties}"
}
