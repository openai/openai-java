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
import java.util.Objects

/**
 * Represents token usage details including input tokens, output tokens, a breakdown of output
 * tokens, and the total tokens used.
 */
@NoAutoDetect
class ResponseUsage
@JsonCreator
private constructor(
    @JsonProperty("input_tokens")
    @ExcludeMissing
    private val inputTokens: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("output_tokens")
    @ExcludeMissing
    private val outputTokens: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("output_tokens_details")
    @ExcludeMissing
    private val outputTokensDetails: JsonField<OutputTokensDetails> = JsonMissing.of(),
    @JsonProperty("total_tokens")
    @ExcludeMissing
    private val totalTokens: JsonField<Long> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The number of input tokens. */
    fun inputTokens(): Long = inputTokens.getRequired("input_tokens")

    /** The number of output tokens. */
    fun outputTokens(): Long = outputTokens.getRequired("output_tokens")

    /** A detailed breakdown of the output tokens. */
    fun outputTokensDetails(): OutputTokensDetails =
        outputTokensDetails.getRequired("output_tokens_details")

    /** The total number of tokens used. */
    fun totalTokens(): Long = totalTokens.getRequired("total_tokens")

    /** The number of input tokens. */
    @JsonProperty("input_tokens") @ExcludeMissing fun _inputTokens(): JsonField<Long> = inputTokens

    /** The number of output tokens. */
    @JsonProperty("output_tokens")
    @ExcludeMissing
    fun _outputTokens(): JsonField<Long> = outputTokens

    /** A detailed breakdown of the output tokens. */
    @JsonProperty("output_tokens_details")
    @ExcludeMissing
    fun _outputTokensDetails(): JsonField<OutputTokensDetails> = outputTokensDetails

    /** The total number of tokens used. */
    @JsonProperty("total_tokens") @ExcludeMissing fun _totalTokens(): JsonField<Long> = totalTokens

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ResponseUsage = apply {
        if (validated) {
            return@apply
        }

        inputTokens()
        outputTokens()
        outputTokensDetails().validate()
        totalTokens()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ResponseUsage].
         *
         * The following fields are required:
         * ```java
         * .inputTokens()
         * .outputTokens()
         * .outputTokensDetails()
         * .totalTokens()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseUsage]. */
    class Builder internal constructor() {

        private var inputTokens: JsonField<Long>? = null
        private var outputTokens: JsonField<Long>? = null
        private var outputTokensDetails: JsonField<OutputTokensDetails>? = null
        private var totalTokens: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseUsage: ResponseUsage) = apply {
            inputTokens = responseUsage.inputTokens
            outputTokens = responseUsage.outputTokens
            outputTokensDetails = responseUsage.outputTokensDetails
            totalTokens = responseUsage.totalTokens
            additionalProperties = responseUsage.additionalProperties.toMutableMap()
        }

        /** The number of input tokens. */
        fun inputTokens(inputTokens: Long) = inputTokens(JsonField.of(inputTokens))

        /** The number of input tokens. */
        fun inputTokens(inputTokens: JsonField<Long>) = apply { this.inputTokens = inputTokens }

        /** The number of output tokens. */
        fun outputTokens(outputTokens: Long) = outputTokens(JsonField.of(outputTokens))

        /** The number of output tokens. */
        fun outputTokens(outputTokens: JsonField<Long>) = apply { this.outputTokens = outputTokens }

        /** A detailed breakdown of the output tokens. */
        fun outputTokensDetails(outputTokensDetails: OutputTokensDetails) =
            outputTokensDetails(JsonField.of(outputTokensDetails))

        /** A detailed breakdown of the output tokens. */
        fun outputTokensDetails(outputTokensDetails: JsonField<OutputTokensDetails>) = apply {
            this.outputTokensDetails = outputTokensDetails
        }

        /** The total number of tokens used. */
        fun totalTokens(totalTokens: Long) = totalTokens(JsonField.of(totalTokens))

        /** The total number of tokens used. */
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

        fun build(): ResponseUsage =
            ResponseUsage(
                checkRequired("inputTokens", inputTokens),
                checkRequired("outputTokens", outputTokens),
                checkRequired("outputTokensDetails", outputTokensDetails),
                checkRequired("totalTokens", totalTokens),
                additionalProperties.toImmutable(),
            )
    }

    /** A detailed breakdown of the output tokens. */
    @NoAutoDetect
    class OutputTokensDetails
    @JsonCreator
    private constructor(
        @JsonProperty("reasoning_tokens")
        @ExcludeMissing
        private val reasoningTokens: JsonField<Long> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The number of reasoning tokens. */
        fun reasoningTokens(): Long = reasoningTokens.getRequired("reasoning_tokens")

        /** The number of reasoning tokens. */
        @JsonProperty("reasoning_tokens")
        @ExcludeMissing
        fun _reasoningTokens(): JsonField<Long> = reasoningTokens

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): OutputTokensDetails = apply {
            if (validated) {
                return@apply
            }

            reasoningTokens()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [OutputTokensDetails].
             *
             * The following fields are required:
             * ```java
             * .reasoningTokens()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [OutputTokensDetails]. */
        class Builder internal constructor() {

            private var reasoningTokens: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(outputTokensDetails: OutputTokensDetails) = apply {
                reasoningTokens = outputTokensDetails.reasoningTokens
                additionalProperties = outputTokensDetails.additionalProperties.toMutableMap()
            }

            /** The number of reasoning tokens. */
            fun reasoningTokens(reasoningTokens: Long) =
                reasoningTokens(JsonField.of(reasoningTokens))

            /** The number of reasoning tokens. */
            fun reasoningTokens(reasoningTokens: JsonField<Long>) = apply {
                this.reasoningTokens = reasoningTokens
            }

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

            fun build(): OutputTokensDetails =
                OutputTokensDetails(
                    checkRequired("reasoningTokens", reasoningTokens),
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is OutputTokensDetails && reasoningTokens == other.reasoningTokens && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(reasoningTokens, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "OutputTokensDetails{reasoningTokens=$reasoningTokens, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseUsage && inputTokens == other.inputTokens && outputTokens == other.outputTokens && outputTokensDetails == other.outputTokensDetails && totalTokens == other.totalTokens && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(inputTokens, outputTokens, outputTokensDetails, totalTokens, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseUsage{inputTokens=$inputTokens, outputTokens=$outputTokens, outputTokensDetails=$outputTokensDetails, totalTokens=$totalTokens, additionalProperties=$additionalProperties}"
}
