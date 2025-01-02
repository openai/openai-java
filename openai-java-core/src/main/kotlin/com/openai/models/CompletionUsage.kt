// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.toImmutable
import java.util.Objects
import java.util.Optional

/** Usage statistics for the completion request. */
@JsonDeserialize(builder = CompletionUsage.Builder::class)
@NoAutoDetect
class CompletionUsage
private constructor(
    private val completionTokens: JsonField<Long>,
    private val promptTokens: JsonField<Long>,
    private val totalTokens: JsonField<Long>,
    private val completionTokensDetails: JsonField<CompletionTokensDetails>,
    private val promptTokensDetails: JsonField<PromptTokensDetails>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    /** Number of tokens in the generated completion. */
    fun completionTokens(): Long = completionTokens.getRequired("completion_tokens")

    /** Number of tokens in the prompt. */
    fun promptTokens(): Long = promptTokens.getRequired("prompt_tokens")

    /** Total number of tokens used in the request (prompt + completion). */
    fun totalTokens(): Long = totalTokens.getRequired("total_tokens")

    /** Breakdown of tokens used in a completion. */
    fun completionTokensDetails(): Optional<CompletionTokensDetails> =
        Optional.ofNullable(completionTokensDetails.getNullable("completion_tokens_details"))

    /** Breakdown of tokens used in the prompt. */
    fun promptTokensDetails(): Optional<PromptTokensDetails> =
        Optional.ofNullable(promptTokensDetails.getNullable("prompt_tokens_details"))

    /** Number of tokens in the generated completion. */
    @JsonProperty("completion_tokens") @ExcludeMissing fun _completionTokens() = completionTokens

    /** Number of tokens in the prompt. */
    @JsonProperty("prompt_tokens") @ExcludeMissing fun _promptTokens() = promptTokens

    /** Total number of tokens used in the request (prompt + completion). */
    @JsonProperty("total_tokens") @ExcludeMissing fun _totalTokens() = totalTokens

    /** Breakdown of tokens used in a completion. */
    @JsonProperty("completion_tokens_details")
    @ExcludeMissing
    fun _completionTokensDetails() = completionTokensDetails

    /** Breakdown of tokens used in the prompt. */
    @JsonProperty("prompt_tokens_details")
    @ExcludeMissing
    fun _promptTokensDetails() = promptTokensDetails

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): CompletionUsage = apply {
        if (!validated) {
            completionTokens()
            promptTokens()
            totalTokens()
            completionTokensDetails().map { it.validate() }
            promptTokensDetails().map { it.validate() }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var completionTokens: JsonField<Long> = JsonMissing.of()
        private var promptTokens: JsonField<Long> = JsonMissing.of()
        private var totalTokens: JsonField<Long> = JsonMissing.of()
        private var completionTokensDetails: JsonField<CompletionTokensDetails> = JsonMissing.of()
        private var promptTokensDetails: JsonField<PromptTokensDetails> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(completionUsage: CompletionUsage) = apply {
            completionTokens = completionUsage.completionTokens
            promptTokens = completionUsage.promptTokens
            totalTokens = completionUsage.totalTokens
            completionTokensDetails = completionUsage.completionTokensDetails
            promptTokensDetails = completionUsage.promptTokensDetails
            additionalProperties = completionUsage.additionalProperties.toMutableMap()
        }

        /** Number of tokens in the generated completion. */
        fun completionTokens(completionTokens: Long) =
            completionTokens(JsonField.of(completionTokens))

        /** Number of tokens in the generated completion. */
        @JsonProperty("completion_tokens")
        @ExcludeMissing
        fun completionTokens(completionTokens: JsonField<Long>) = apply {
            this.completionTokens = completionTokens
        }

        /** Number of tokens in the prompt. */
        fun promptTokens(promptTokens: Long) = promptTokens(JsonField.of(promptTokens))

        /** Number of tokens in the prompt. */
        @JsonProperty("prompt_tokens")
        @ExcludeMissing
        fun promptTokens(promptTokens: JsonField<Long>) = apply { this.promptTokens = promptTokens }

        /** Total number of tokens used in the request (prompt + completion). */
        fun totalTokens(totalTokens: Long) = totalTokens(JsonField.of(totalTokens))

        /** Total number of tokens used in the request (prompt + completion). */
        @JsonProperty("total_tokens")
        @ExcludeMissing
        fun totalTokens(totalTokens: JsonField<Long>) = apply { this.totalTokens = totalTokens }

        /** Breakdown of tokens used in a completion. */
        fun completionTokensDetails(completionTokensDetails: CompletionTokensDetails) =
            completionTokensDetails(JsonField.of(completionTokensDetails))

        /** Breakdown of tokens used in a completion. */
        @JsonProperty("completion_tokens_details")
        @ExcludeMissing
        fun completionTokensDetails(completionTokensDetails: JsonField<CompletionTokensDetails>) =
            apply {
                this.completionTokensDetails = completionTokensDetails
            }

        /** Breakdown of tokens used in the prompt. */
        fun promptTokensDetails(promptTokensDetails: PromptTokensDetails) =
            promptTokensDetails(JsonField.of(promptTokensDetails))

        /** Breakdown of tokens used in the prompt. */
        @JsonProperty("prompt_tokens_details")
        @ExcludeMissing
        fun promptTokensDetails(promptTokensDetails: JsonField<PromptTokensDetails>) = apply {
            this.promptTokensDetails = promptTokensDetails
        }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        @JsonAnySetter
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

        fun build(): CompletionUsage =
            CompletionUsage(
                completionTokens,
                promptTokens,
                totalTokens,
                completionTokensDetails,
                promptTokensDetails,
                additionalProperties.toImmutable(),
            )
    }

    /** Breakdown of tokens used in a completion. */
    @JsonDeserialize(builder = CompletionTokensDetails.Builder::class)
    @NoAutoDetect
    class CompletionTokensDetails
    private constructor(
        private val acceptedPredictionTokens: JsonField<Long>,
        private val audioTokens: JsonField<Long>,
        private val reasoningTokens: JsonField<Long>,
        private val rejectedPredictionTokens: JsonField<Long>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        /**
         * When using Predicted Outputs, the number of tokens in the prediction that appeared in the
         * completion.
         */
        fun acceptedPredictionTokens(): Optional<Long> =
            Optional.ofNullable(acceptedPredictionTokens.getNullable("accepted_prediction_tokens"))

        /** Audio input tokens generated by the model. */
        fun audioTokens(): Optional<Long> =
            Optional.ofNullable(audioTokens.getNullable("audio_tokens"))

        /** Tokens generated by the model for reasoning. */
        fun reasoningTokens(): Optional<Long> =
            Optional.ofNullable(reasoningTokens.getNullable("reasoning_tokens"))

        /**
         * When using Predicted Outputs, the number of tokens in the prediction that did not appear
         * in the completion. However, like reasoning tokens, these tokens are still counted in the
         * total completion tokens for purposes of billing, output, and context window limits.
         */
        fun rejectedPredictionTokens(): Optional<Long> =
            Optional.ofNullable(rejectedPredictionTokens.getNullable("rejected_prediction_tokens"))

        /**
         * When using Predicted Outputs, the number of tokens in the prediction that appeared in the
         * completion.
         */
        @JsonProperty("accepted_prediction_tokens")
        @ExcludeMissing
        fun _acceptedPredictionTokens() = acceptedPredictionTokens

        /** Audio input tokens generated by the model. */
        @JsonProperty("audio_tokens") @ExcludeMissing fun _audioTokens() = audioTokens

        /** Tokens generated by the model for reasoning. */
        @JsonProperty("reasoning_tokens") @ExcludeMissing fun _reasoningTokens() = reasoningTokens

        /**
         * When using Predicted Outputs, the number of tokens in the prediction that did not appear
         * in the completion. However, like reasoning tokens, these tokens are still counted in the
         * total completion tokens for purposes of billing, output, and context window limits.
         */
        @JsonProperty("rejected_prediction_tokens")
        @ExcludeMissing
        fun _rejectedPredictionTokens() = rejectedPredictionTokens

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): CompletionTokensDetails = apply {
            if (!validated) {
                acceptedPredictionTokens()
                audioTokens()
                reasoningTokens()
                rejectedPredictionTokens()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var acceptedPredictionTokens: JsonField<Long> = JsonMissing.of()
            private var audioTokens: JsonField<Long> = JsonMissing.of()
            private var reasoningTokens: JsonField<Long> = JsonMissing.of()
            private var rejectedPredictionTokens: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(completionTokensDetails: CompletionTokensDetails) = apply {
                acceptedPredictionTokens = completionTokensDetails.acceptedPredictionTokens
                audioTokens = completionTokensDetails.audioTokens
                reasoningTokens = completionTokensDetails.reasoningTokens
                rejectedPredictionTokens = completionTokensDetails.rejectedPredictionTokens
                additionalProperties = completionTokensDetails.additionalProperties.toMutableMap()
            }

            /**
             * When using Predicted Outputs, the number of tokens in the prediction that appeared in
             * the completion.
             */
            fun acceptedPredictionTokens(acceptedPredictionTokens: Long) =
                acceptedPredictionTokens(JsonField.of(acceptedPredictionTokens))

            /**
             * When using Predicted Outputs, the number of tokens in the prediction that appeared in
             * the completion.
             */
            @JsonProperty("accepted_prediction_tokens")
            @ExcludeMissing
            fun acceptedPredictionTokens(acceptedPredictionTokens: JsonField<Long>) = apply {
                this.acceptedPredictionTokens = acceptedPredictionTokens
            }

            /** Audio input tokens generated by the model. */
            fun audioTokens(audioTokens: Long) = audioTokens(JsonField.of(audioTokens))

            /** Audio input tokens generated by the model. */
            @JsonProperty("audio_tokens")
            @ExcludeMissing
            fun audioTokens(audioTokens: JsonField<Long>) = apply { this.audioTokens = audioTokens }

            /** Tokens generated by the model for reasoning. */
            fun reasoningTokens(reasoningTokens: Long) =
                reasoningTokens(JsonField.of(reasoningTokens))

            /** Tokens generated by the model for reasoning. */
            @JsonProperty("reasoning_tokens")
            @ExcludeMissing
            fun reasoningTokens(reasoningTokens: JsonField<Long>) = apply {
                this.reasoningTokens = reasoningTokens
            }

            /**
             * When using Predicted Outputs, the number of tokens in the prediction that did not
             * appear in the completion. However, like reasoning tokens, these tokens are still
             * counted in the total completion tokens for purposes of billing, output, and context
             * window limits.
             */
            fun rejectedPredictionTokens(rejectedPredictionTokens: Long) =
                rejectedPredictionTokens(JsonField.of(rejectedPredictionTokens))

            /**
             * When using Predicted Outputs, the number of tokens in the prediction that did not
             * appear in the completion. However, like reasoning tokens, these tokens are still
             * counted in the total completion tokens for purposes of billing, output, and context
             * window limits.
             */
            @JsonProperty("rejected_prediction_tokens")
            @ExcludeMissing
            fun rejectedPredictionTokens(rejectedPredictionTokens: JsonField<Long>) = apply {
                this.rejectedPredictionTokens = rejectedPredictionTokens
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            @JsonAnySetter
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

            fun build(): CompletionTokensDetails =
                CompletionTokensDetails(
                    acceptedPredictionTokens,
                    audioTokens,
                    reasoningTokens,
                    rejectedPredictionTokens,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is CompletionTokensDetails && acceptedPredictionTokens == other.acceptedPredictionTokens && audioTokens == other.audioTokens && reasoningTokens == other.reasoningTokens && rejectedPredictionTokens == other.rejectedPredictionTokens && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(acceptedPredictionTokens, audioTokens, reasoningTokens, rejectedPredictionTokens, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "CompletionTokensDetails{acceptedPredictionTokens=$acceptedPredictionTokens, audioTokens=$audioTokens, reasoningTokens=$reasoningTokens, rejectedPredictionTokens=$rejectedPredictionTokens, additionalProperties=$additionalProperties}"
    }

    /** Breakdown of tokens used in the prompt. */
    @JsonDeserialize(builder = PromptTokensDetails.Builder::class)
    @NoAutoDetect
    class PromptTokensDetails
    private constructor(
        private val audioTokens: JsonField<Long>,
        private val cachedTokens: JsonField<Long>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        /** Audio input tokens present in the prompt. */
        fun audioTokens(): Optional<Long> =
            Optional.ofNullable(audioTokens.getNullable("audio_tokens"))

        /** Cached tokens present in the prompt. */
        fun cachedTokens(): Optional<Long> =
            Optional.ofNullable(cachedTokens.getNullable("cached_tokens"))

        /** Audio input tokens present in the prompt. */
        @JsonProperty("audio_tokens") @ExcludeMissing fun _audioTokens() = audioTokens

        /** Cached tokens present in the prompt. */
        @JsonProperty("cached_tokens") @ExcludeMissing fun _cachedTokens() = cachedTokens

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): PromptTokensDetails = apply {
            if (!validated) {
                audioTokens()
                cachedTokens()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var audioTokens: JsonField<Long> = JsonMissing.of()
            private var cachedTokens: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(promptTokensDetails: PromptTokensDetails) = apply {
                audioTokens = promptTokensDetails.audioTokens
                cachedTokens = promptTokensDetails.cachedTokens
                additionalProperties = promptTokensDetails.additionalProperties.toMutableMap()
            }

            /** Audio input tokens present in the prompt. */
            fun audioTokens(audioTokens: Long) = audioTokens(JsonField.of(audioTokens))

            /** Audio input tokens present in the prompt. */
            @JsonProperty("audio_tokens")
            @ExcludeMissing
            fun audioTokens(audioTokens: JsonField<Long>) = apply { this.audioTokens = audioTokens }

            /** Cached tokens present in the prompt. */
            fun cachedTokens(cachedTokens: Long) = cachedTokens(JsonField.of(cachedTokens))

            /** Cached tokens present in the prompt. */
            @JsonProperty("cached_tokens")
            @ExcludeMissing
            fun cachedTokens(cachedTokens: JsonField<Long>) = apply {
                this.cachedTokens = cachedTokens
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            @JsonAnySetter
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

            fun build(): PromptTokensDetails =
                PromptTokensDetails(
                    audioTokens,
                    cachedTokens,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is PromptTokensDetails && audioTokens == other.audioTokens && cachedTokens == other.cachedTokens && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(audioTokens, cachedTokens, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "PromptTokensDetails{audioTokens=$audioTokens, cachedTokens=$cachedTokens, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is CompletionUsage && completionTokens == other.completionTokens && promptTokens == other.promptTokens && totalTokens == other.totalTokens && completionTokensDetails == other.completionTokensDetails && promptTokensDetails == other.promptTokensDetails && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(completionTokens, promptTokens, totalTokens, completionTokensDetails, promptTokensDetails, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CompletionUsage{completionTokens=$completionTokens, promptTokens=$promptTokens, totalTokens=$totalTokens, completionTokensDetails=$completionTokensDetails, promptTokensDetails=$promptTokensDetails, additionalProperties=$additionalProperties}"
}
