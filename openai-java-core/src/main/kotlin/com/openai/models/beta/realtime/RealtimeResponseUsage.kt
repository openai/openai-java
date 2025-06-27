// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

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
 * Usage statistics for the Response, this will correspond to billing. A Realtime API session will
 * maintain a conversation context and append new Items to the Conversation, thus output from
 * previous turns (text and audio tokens) will become the input for later turns.
 */
class RealtimeResponseUsage
private constructor(
    private val inputTokenDetails: JsonField<InputTokenDetails>,
    private val inputTokens: JsonField<Long>,
    private val outputTokenDetails: JsonField<OutputTokenDetails>,
    private val outputTokens: JsonField<Long>,
    private val totalTokens: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("input_token_details")
        @ExcludeMissing
        inputTokenDetails: JsonField<InputTokenDetails> = JsonMissing.of(),
        @JsonProperty("input_tokens")
        @ExcludeMissing
        inputTokens: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("output_token_details")
        @ExcludeMissing
        outputTokenDetails: JsonField<OutputTokenDetails> = JsonMissing.of(),
        @JsonProperty("output_tokens")
        @ExcludeMissing
        outputTokens: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("total_tokens")
        @ExcludeMissing
        totalTokens: JsonField<Long> = JsonMissing.of(),
    ) : this(
        inputTokenDetails,
        inputTokens,
        outputTokenDetails,
        outputTokens,
        totalTokens,
        mutableMapOf(),
    )

    /**
     * Details about the input tokens used in the Response.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun inputTokenDetails(): Optional<InputTokenDetails> =
        inputTokenDetails.getOptional("input_token_details")

    /**
     * The number of input tokens used in the Response, including text and audio tokens.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun inputTokens(): Optional<Long> = inputTokens.getOptional("input_tokens")

    /**
     * Details about the output tokens used in the Response.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun outputTokenDetails(): Optional<OutputTokenDetails> =
        outputTokenDetails.getOptional("output_token_details")

    /**
     * The number of output tokens sent in the Response, including text and audio tokens.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun outputTokens(): Optional<Long> = outputTokens.getOptional("output_tokens")

    /**
     * The total number of tokens in the Response including input and output text and audio tokens.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun totalTokens(): Optional<Long> = totalTokens.getOptional("total_tokens")

    /**
     * Returns the raw JSON value of [inputTokenDetails].
     *
     * Unlike [inputTokenDetails], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("input_token_details")
    @ExcludeMissing
    fun _inputTokenDetails(): JsonField<InputTokenDetails> = inputTokenDetails

    /**
     * Returns the raw JSON value of [inputTokens].
     *
     * Unlike [inputTokens], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("input_tokens") @ExcludeMissing fun _inputTokens(): JsonField<Long> = inputTokens

    /**
     * Returns the raw JSON value of [outputTokenDetails].
     *
     * Unlike [outputTokenDetails], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("output_token_details")
    @ExcludeMissing
    fun _outputTokenDetails(): JsonField<OutputTokenDetails> = outputTokenDetails

    /**
     * Returns the raw JSON value of [outputTokens].
     *
     * Unlike [outputTokens], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("output_tokens")
    @ExcludeMissing
    fun _outputTokens(): JsonField<Long> = outputTokens

    /**
     * Returns the raw JSON value of [totalTokens].
     *
     * Unlike [totalTokens], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("total_tokens") @ExcludeMissing fun _totalTokens(): JsonField<Long> = totalTokens

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

        /** Returns a mutable builder for constructing an instance of [RealtimeResponseUsage]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RealtimeResponseUsage]. */
    class Builder internal constructor() {

        private var inputTokenDetails: JsonField<InputTokenDetails> = JsonMissing.of()
        private var inputTokens: JsonField<Long> = JsonMissing.of()
        private var outputTokenDetails: JsonField<OutputTokenDetails> = JsonMissing.of()
        private var outputTokens: JsonField<Long> = JsonMissing.of()
        private var totalTokens: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(realtimeResponseUsage: RealtimeResponseUsage) = apply {
            inputTokenDetails = realtimeResponseUsage.inputTokenDetails
            inputTokens = realtimeResponseUsage.inputTokens
            outputTokenDetails = realtimeResponseUsage.outputTokenDetails
            outputTokens = realtimeResponseUsage.outputTokens
            totalTokens = realtimeResponseUsage.totalTokens
            additionalProperties = realtimeResponseUsage.additionalProperties.toMutableMap()
        }

        /** Details about the input tokens used in the Response. */
        fun inputTokenDetails(inputTokenDetails: InputTokenDetails) =
            inputTokenDetails(JsonField.of(inputTokenDetails))

        /**
         * Sets [Builder.inputTokenDetails] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inputTokenDetails] with a well-typed [InputTokenDetails]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun inputTokenDetails(inputTokenDetails: JsonField<InputTokenDetails>) = apply {
            this.inputTokenDetails = inputTokenDetails
        }

        /** The number of input tokens used in the Response, including text and audio tokens. */
        fun inputTokens(inputTokens: Long) = inputTokens(JsonField.of(inputTokens))

        /**
         * Sets [Builder.inputTokens] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inputTokens] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun inputTokens(inputTokens: JsonField<Long>) = apply { this.inputTokens = inputTokens }

        /** Details about the output tokens used in the Response. */
        fun outputTokenDetails(outputTokenDetails: OutputTokenDetails) =
            outputTokenDetails(JsonField.of(outputTokenDetails))

        /**
         * Sets [Builder.outputTokenDetails] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outputTokenDetails] with a well-typed
         * [OutputTokenDetails] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun outputTokenDetails(outputTokenDetails: JsonField<OutputTokenDetails>) = apply {
            this.outputTokenDetails = outputTokenDetails
        }

        /** The number of output tokens sent in the Response, including text and audio tokens. */
        fun outputTokens(outputTokens: Long) = outputTokens(JsonField.of(outputTokens))

        /**
         * Sets [Builder.outputTokens] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outputTokens] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun outputTokens(outputTokens: JsonField<Long>) = apply { this.outputTokens = outputTokens }

        /**
         * The total number of tokens in the Response including input and output text and audio
         * tokens.
         */
        fun totalTokens(totalTokens: Long) = totalTokens(JsonField.of(totalTokens))

        /**
         * Sets [Builder.totalTokens] to an arbitrary JSON value.
         *
         * You should usually call [Builder.totalTokens] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun totalTokens(totalTokens: JsonField<Long>) = apply { this.totalTokens = totalTokens }

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
         * Returns an immutable instance of [RealtimeResponseUsage].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): RealtimeResponseUsage =
            RealtimeResponseUsage(
                inputTokenDetails,
                inputTokens,
                outputTokenDetails,
                outputTokens,
                totalTokens,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): RealtimeResponseUsage = apply {
        if (validated) {
            return@apply
        }

        inputTokenDetails().ifPresent { it.validate() }
        inputTokens()
        outputTokenDetails().ifPresent { it.validate() }
        outputTokens()
        totalTokens()
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
        (inputTokenDetails.asKnown().getOrNull()?.validity() ?: 0) +
            (if (inputTokens.asKnown().isPresent) 1 else 0) +
            (outputTokenDetails.asKnown().getOrNull()?.validity() ?: 0) +
            (if (outputTokens.asKnown().isPresent) 1 else 0) +
            (if (totalTokens.asKnown().isPresent) 1 else 0)

    /** Details about the input tokens used in the Response. */
    class InputTokenDetails
    private constructor(
        private val audioTokens: JsonField<Long>,
        private val cachedTokens: JsonField<Long>,
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
            @JsonProperty("text_tokens")
            @ExcludeMissing
            textTokens: JsonField<Long> = JsonMissing.of(),
        ) : this(audioTokens, cachedTokens, textTokens, mutableMapOf())

        /**
         * The number of audio tokens used in the Response.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun audioTokens(): Optional<Long> = audioTokens.getOptional("audio_tokens")

        /**
         * The number of cached tokens used in the Response.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun cachedTokens(): Optional<Long> = cachedTokens.getOptional("cached_tokens")

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
        @JsonProperty("audio_tokens")
        @ExcludeMissing
        fun _audioTokens(): JsonField<Long> = audioTokens

        /**
         * Returns the raw JSON value of [cachedTokens].
         *
         * Unlike [cachedTokens], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("cached_tokens")
        @ExcludeMissing
        fun _cachedTokens(): JsonField<Long> = cachedTokens

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

            /** Returns a mutable builder for constructing an instance of [InputTokenDetails]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [InputTokenDetails]. */
        class Builder internal constructor() {

            private var audioTokens: JsonField<Long> = JsonMissing.of()
            private var cachedTokens: JsonField<Long> = JsonMissing.of()
            private var textTokens: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(inputTokenDetails: InputTokenDetails) = apply {
                audioTokens = inputTokenDetails.audioTokens
                cachedTokens = inputTokenDetails.cachedTokens
                textTokens = inputTokenDetails.textTokens
                additionalProperties = inputTokenDetails.additionalProperties.toMutableMap()
            }

            /** The number of audio tokens used in the Response. */
            fun audioTokens(audioTokens: Long) = audioTokens(JsonField.of(audioTokens))

            /**
             * Sets [Builder.audioTokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.audioTokens] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun audioTokens(audioTokens: JsonField<Long>) = apply { this.audioTokens = audioTokens }

            /** The number of cached tokens used in the Response. */
            fun cachedTokens(cachedTokens: Long) = cachedTokens(JsonField.of(cachedTokens))

            /**
             * Sets [Builder.cachedTokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.cachedTokens] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun cachedTokens(cachedTokens: JsonField<Long>) = apply {
                this.cachedTokens = cachedTokens
            }

            /** The number of text tokens used in the Response. */
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
             * Returns an immutable instance of [InputTokenDetails].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): InputTokenDetails =
                InputTokenDetails(
                    audioTokens,
                    cachedTokens,
                    textTokens,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): InputTokenDetails = apply {
            if (validated) {
                return@apply
            }

            audioTokens()
            cachedTokens()
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
                (if (cachedTokens.asKnown().isPresent) 1 else 0) +
                (if (textTokens.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is InputTokenDetails && audioTokens == other.audioTokens && cachedTokens == other.cachedTokens && textTokens == other.textTokens && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(audioTokens, cachedTokens, textTokens, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "InputTokenDetails{audioTokens=$audioTokens, cachedTokens=$cachedTokens, textTokens=$textTokens, additionalProperties=$additionalProperties}"
    }

    /** Details about the output tokens used in the Response. */
    class OutputTokenDetails
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
            @JsonProperty("text_tokens")
            @ExcludeMissing
            textTokens: JsonField<Long> = JsonMissing.of(),
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
        @JsonProperty("audio_tokens")
        @ExcludeMissing
        fun _audioTokens(): JsonField<Long> = audioTokens

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

            /** Returns a mutable builder for constructing an instance of [OutputTokenDetails]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [OutputTokenDetails]. */
        class Builder internal constructor() {

            private var audioTokens: JsonField<Long> = JsonMissing.of()
            private var textTokens: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(outputTokenDetails: OutputTokenDetails) = apply {
                audioTokens = outputTokenDetails.audioTokens
                textTokens = outputTokenDetails.textTokens
                additionalProperties = outputTokenDetails.additionalProperties.toMutableMap()
            }

            /** The number of audio tokens used in the Response. */
            fun audioTokens(audioTokens: Long) = audioTokens(JsonField.of(audioTokens))

            /**
             * Sets [Builder.audioTokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.audioTokens] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun audioTokens(audioTokens: JsonField<Long>) = apply { this.audioTokens = audioTokens }

            /** The number of text tokens used in the Response. */
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
             * Returns an immutable instance of [OutputTokenDetails].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): OutputTokenDetails =
                OutputTokenDetails(audioTokens, textTokens, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): OutputTokenDetails = apply {
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
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

            return /* spotless:off */ other is OutputTokenDetails && audioTokens == other.audioTokens && textTokens == other.textTokens && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(audioTokens, textTokens, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "OutputTokenDetails{audioTokens=$audioTokens, textTokens=$textTokens, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is RealtimeResponseUsage && inputTokenDetails == other.inputTokenDetails && inputTokens == other.inputTokens && outputTokenDetails == other.outputTokenDetails && outputTokens == other.outputTokens && totalTokens == other.totalTokens && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(inputTokenDetails, inputTokens, outputTokenDetails, outputTokens, totalTokens, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RealtimeResponseUsage{inputTokenDetails=$inputTokenDetails, inputTokens=$inputTokens, outputTokenDetails=$outputTokenDetails, outputTokens=$outputTokens, totalTokens=$totalTokens, additionalProperties=$additionalProperties}"
}
