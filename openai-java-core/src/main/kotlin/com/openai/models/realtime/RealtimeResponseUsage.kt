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
 * Usage statistics for the Response, this will correspond to billing. A Realtime API session will
 * maintain a conversation context and append new Items to the Conversation, thus output from
 * previous turns (text and audio tokens) will become the input for later turns.
 */
class RealtimeResponseUsage
private constructor(
    private val inputTokenDetails: JsonField<RealtimeResponseUsageInputTokenDetails>,
    private val inputTokens: JsonField<Long>,
    private val outputTokenDetails: JsonField<RealtimeResponseUsageOutputTokenDetails>,
    private val outputTokens: JsonField<Long>,
    private val totalTokens: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("input_token_details")
        @ExcludeMissing
        inputTokenDetails: JsonField<RealtimeResponseUsageInputTokenDetails> = JsonMissing.of(),
        @JsonProperty("input_tokens")
        @ExcludeMissing
        inputTokens: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("output_token_details")
        @ExcludeMissing
        outputTokenDetails: JsonField<RealtimeResponseUsageOutputTokenDetails> = JsonMissing.of(),
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
    fun inputTokenDetails(): Optional<RealtimeResponseUsageInputTokenDetails> =
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
    fun outputTokenDetails(): Optional<RealtimeResponseUsageOutputTokenDetails> =
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
    fun _inputTokenDetails(): JsonField<RealtimeResponseUsageInputTokenDetails> = inputTokenDetails

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
    fun _outputTokenDetails(): JsonField<RealtimeResponseUsageOutputTokenDetails> =
        outputTokenDetails

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

        private var inputTokenDetails: JsonField<RealtimeResponseUsageInputTokenDetails> =
            JsonMissing.of()
        private var inputTokens: JsonField<Long> = JsonMissing.of()
        private var outputTokenDetails: JsonField<RealtimeResponseUsageOutputTokenDetails> =
            JsonMissing.of()
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
        fun inputTokenDetails(inputTokenDetails: RealtimeResponseUsageInputTokenDetails) =
            inputTokenDetails(JsonField.of(inputTokenDetails))

        /**
         * Sets [Builder.inputTokenDetails] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inputTokenDetails] with a well-typed
         * [RealtimeResponseUsageInputTokenDetails] value instead. This method is primarily for
         * setting the field to an undocumented or not yet supported value.
         */
        fun inputTokenDetails(
            inputTokenDetails: JsonField<RealtimeResponseUsageInputTokenDetails>
        ) = apply { this.inputTokenDetails = inputTokenDetails }

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
        fun outputTokenDetails(outputTokenDetails: RealtimeResponseUsageOutputTokenDetails) =
            outputTokenDetails(JsonField.of(outputTokenDetails))

        /**
         * Sets [Builder.outputTokenDetails] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outputTokenDetails] with a well-typed
         * [RealtimeResponseUsageOutputTokenDetails] value instead. This method is primarily for
         * setting the field to an undocumented or not yet supported value.
         */
        fun outputTokenDetails(
            outputTokenDetails: JsonField<RealtimeResponseUsageOutputTokenDetails>
        ) = apply { this.outputTokenDetails = outputTokenDetails }

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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeResponseUsage &&
            inputTokenDetails == other.inputTokenDetails &&
            inputTokens == other.inputTokens &&
            outputTokenDetails == other.outputTokenDetails &&
            outputTokens == other.outputTokens &&
            totalTokens == other.totalTokens &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            inputTokenDetails,
            inputTokens,
            outputTokenDetails,
            outputTokens,
            totalTokens,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RealtimeResponseUsage{inputTokenDetails=$inputTokenDetails, inputTokens=$inputTokens, outputTokenDetails=$outputTokenDetails, outputTokens=$outputTokens, totalTokens=$totalTokens, additionalProperties=$additionalProperties}"
}
