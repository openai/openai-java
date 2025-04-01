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
import com.openai.core.checkRequired
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/**
 * Represents token usage details including input tokens, output tokens, a breakdown of output
 * tokens, and the total tokens used.
 */
class ResponseUsage
private constructor(
    private val inputTokens: JsonField<Long>,
    private val inputTokensDetails: JsonField<InputTokensDetails>,
    private val outputTokens: JsonField<Long>,
    private val outputTokensDetails: JsonField<OutputTokensDetails>,
    private val totalTokens: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("input_tokens")
        @ExcludeMissing
        inputTokens: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("input_tokens_details")
        @ExcludeMissing
        inputTokensDetails: JsonField<InputTokensDetails> = JsonMissing.of(),
        @JsonProperty("output_tokens")
        @ExcludeMissing
        outputTokens: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("output_tokens_details")
        @ExcludeMissing
        outputTokensDetails: JsonField<OutputTokensDetails> = JsonMissing.of(),
        @JsonProperty("total_tokens")
        @ExcludeMissing
        totalTokens: JsonField<Long> = JsonMissing.of(),
    ) : this(
        inputTokens,
        inputTokensDetails,
        outputTokens,
        outputTokensDetails,
        totalTokens,
        mutableMapOf(),
    )

    /**
     * The number of input tokens.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun inputTokens(): Long = inputTokens.getRequired("input_tokens")

    /**
     * A detailed breakdown of the input tokens.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun inputTokensDetails(): InputTokensDetails =
        inputTokensDetails.getRequired("input_tokens_details")

    /**
     * The number of output tokens.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun outputTokens(): Long = outputTokens.getRequired("output_tokens")

    /**
     * A detailed breakdown of the output tokens.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun outputTokensDetails(): OutputTokensDetails =
        outputTokensDetails.getRequired("output_tokens_details")

    /**
     * The total number of tokens used.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun totalTokens(): Long = totalTokens.getRequired("total_tokens")

    /**
     * Returns the raw JSON value of [inputTokens].
     *
     * Unlike [inputTokens], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("input_tokens") @ExcludeMissing fun _inputTokens(): JsonField<Long> = inputTokens

    /**
     * Returns the raw JSON value of [inputTokensDetails].
     *
     * Unlike [inputTokensDetails], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("input_tokens_details")
    @ExcludeMissing
    fun _inputTokensDetails(): JsonField<InputTokensDetails> = inputTokensDetails

    /**
     * Returns the raw JSON value of [outputTokens].
     *
     * Unlike [outputTokens], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("output_tokens")
    @ExcludeMissing
    fun _outputTokens(): JsonField<Long> = outputTokens

    /**
     * Returns the raw JSON value of [outputTokensDetails].
     *
     * Unlike [outputTokensDetails], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("output_tokens_details")
    @ExcludeMissing
    fun _outputTokensDetails(): JsonField<OutputTokensDetails> = outputTokensDetails

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

        /**
         * Returns a mutable builder for constructing an instance of [ResponseUsage].
         *
         * The following fields are required:
         * ```java
         * .inputTokens()
         * .inputTokensDetails()
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
        private var inputTokensDetails: JsonField<InputTokensDetails>? = null
        private var outputTokens: JsonField<Long>? = null
        private var outputTokensDetails: JsonField<OutputTokensDetails>? = null
        private var totalTokens: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseUsage: ResponseUsage) = apply {
            inputTokens = responseUsage.inputTokens
            inputTokensDetails = responseUsage.inputTokensDetails
            outputTokens = responseUsage.outputTokens
            outputTokensDetails = responseUsage.outputTokensDetails
            totalTokens = responseUsage.totalTokens
            additionalProperties = responseUsage.additionalProperties.toMutableMap()
        }

        /** The number of input tokens. */
        fun inputTokens(inputTokens: Long) = inputTokens(JsonField.of(inputTokens))

        /**
         * Sets [Builder.inputTokens] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inputTokens] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun inputTokens(inputTokens: JsonField<Long>) = apply { this.inputTokens = inputTokens }

        /** A detailed breakdown of the input tokens. */
        fun inputTokensDetails(inputTokensDetails: InputTokensDetails) =
            inputTokensDetails(JsonField.of(inputTokensDetails))

        /**
         * Sets [Builder.inputTokensDetails] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inputTokensDetails] with a well-typed
         * [InputTokensDetails] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun inputTokensDetails(inputTokensDetails: JsonField<InputTokensDetails>) = apply {
            this.inputTokensDetails = inputTokensDetails
        }

        /** The number of output tokens. */
        fun outputTokens(outputTokens: Long) = outputTokens(JsonField.of(outputTokens))

        /**
         * Sets [Builder.outputTokens] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outputTokens] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun outputTokens(outputTokens: JsonField<Long>) = apply { this.outputTokens = outputTokens }

        /** A detailed breakdown of the output tokens. */
        fun outputTokensDetails(outputTokensDetails: OutputTokensDetails) =
            outputTokensDetails(JsonField.of(outputTokensDetails))

        /**
         * Sets [Builder.outputTokensDetails] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outputTokensDetails] with a well-typed
         * [OutputTokensDetails] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun outputTokensDetails(outputTokensDetails: JsonField<OutputTokensDetails>) = apply {
            this.outputTokensDetails = outputTokensDetails
        }

        /** The total number of tokens used. */
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
         * Returns an immutable instance of [ResponseUsage].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .inputTokens()
         * .inputTokensDetails()
         * .outputTokens()
         * .outputTokensDetails()
         * .totalTokens()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ResponseUsage =
            ResponseUsage(
                checkRequired("inputTokens", inputTokens),
                checkRequired("inputTokensDetails", inputTokensDetails),
                checkRequired("outputTokens", outputTokens),
                checkRequired("outputTokensDetails", outputTokensDetails),
                checkRequired("totalTokens", totalTokens),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ResponseUsage = apply {
        if (validated) {
            return@apply
        }

        inputTokens()
        inputTokensDetails().validate()
        outputTokens()
        outputTokensDetails().validate()
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
        (if (inputTokens.asKnown().isPresent) 1 else 0) +
            (inputTokensDetails.asKnown().getOrNull()?.validity() ?: 0) +
            (if (outputTokens.asKnown().isPresent) 1 else 0) +
            (outputTokensDetails.asKnown().getOrNull()?.validity() ?: 0) +
            (if (totalTokens.asKnown().isPresent) 1 else 0)

    /** A detailed breakdown of the input tokens. */
    class InputTokensDetails
    private constructor(
        private val cachedTokens: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("cached_tokens")
            @ExcludeMissing
            cachedTokens: JsonField<Long> = JsonMissing.of()
        ) : this(cachedTokens, mutableMapOf())

        /**
         * The number of tokens that were retrieved from the cache.
         * [More on prompt caching](https://platform.openai.com/docs/guides/prompt-caching).
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun cachedTokens(): Long = cachedTokens.getRequired("cached_tokens")

        /**
         * Returns the raw JSON value of [cachedTokens].
         *
         * Unlike [cachedTokens], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("cached_tokens")
        @ExcludeMissing
        fun _cachedTokens(): JsonField<Long> = cachedTokens

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
             * Returns a mutable builder for constructing an instance of [InputTokensDetails].
             *
             * The following fields are required:
             * ```java
             * .cachedTokens()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [InputTokensDetails]. */
        class Builder internal constructor() {

            private var cachedTokens: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(inputTokensDetails: InputTokensDetails) = apply {
                cachedTokens = inputTokensDetails.cachedTokens
                additionalProperties = inputTokensDetails.additionalProperties.toMutableMap()
            }

            /**
             * The number of tokens that were retrieved from the cache.
             * [More on prompt caching](https://platform.openai.com/docs/guides/prompt-caching).
             */
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
             * Returns an immutable instance of [InputTokensDetails].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .cachedTokens()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): InputTokensDetails =
                InputTokensDetails(
                    checkRequired("cachedTokens", cachedTokens),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): InputTokensDetails = apply {
            if (validated) {
                return@apply
            }

            cachedTokens()
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
        internal fun validity(): Int = (if (cachedTokens.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is InputTokensDetails && cachedTokens == other.cachedTokens && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(cachedTokens, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "InputTokensDetails{cachedTokens=$cachedTokens, additionalProperties=$additionalProperties}"
    }

    /** A detailed breakdown of the output tokens. */
    class OutputTokensDetails
    private constructor(
        private val reasoningTokens: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("reasoning_tokens")
            @ExcludeMissing
            reasoningTokens: JsonField<Long> = JsonMissing.of()
        ) : this(reasoningTokens, mutableMapOf())

        /**
         * The number of reasoning tokens.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun reasoningTokens(): Long = reasoningTokens.getRequired("reasoning_tokens")

        /**
         * Returns the raw JSON value of [reasoningTokens].
         *
         * Unlike [reasoningTokens], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("reasoning_tokens")
        @ExcludeMissing
        fun _reasoningTokens(): JsonField<Long> = reasoningTokens

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

            /**
             * Sets [Builder.reasoningTokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.reasoningTokens] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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

            /**
             * Returns an immutable instance of [OutputTokensDetails].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .reasoningTokens()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): OutputTokensDetails =
                OutputTokensDetails(
                    checkRequired("reasoningTokens", reasoningTokens),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): OutputTokensDetails = apply {
            if (validated) {
                return@apply
            }

            reasoningTokens()
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
        internal fun validity(): Int = (if (reasoningTokens.asKnown().isPresent) 1 else 0)

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

        return /* spotless:off */ other is ResponseUsage && inputTokens == other.inputTokens && inputTokensDetails == other.inputTokensDetails && outputTokens == other.outputTokens && outputTokensDetails == other.outputTokensDetails && totalTokens == other.totalTokens && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(inputTokens, inputTokensDetails, outputTokens, outputTokensDetails, totalTokens, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseUsage{inputTokens=$inputTokens, inputTokensDetails=$inputTokensDetails, outputTokens=$outputTokens, outputTokensDetails=$outputTokensDetails, totalTokens=$totalTokens, additionalProperties=$additionalProperties}"
}
