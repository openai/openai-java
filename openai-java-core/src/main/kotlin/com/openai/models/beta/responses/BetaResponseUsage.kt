// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.core.collectAllProperties
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Represents token usage details including input tokens, output tokens, a breakdown of output
 * tokens, and the total tokens used.
 */
class BetaResponseUsage
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
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
     * The number of input tokens. The schema requires this property. Returns empty if the JSON
     * property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun inputTokens(): java.util.Optional<Long> = inputTokens.getOptional("input_tokens")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun inputTokensOrThrow(): Long = inputTokens.getRequired("input_tokens")

    /**
     * A detailed breakdown of the input tokens. The schema requires this property. Returns empty if
     * the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun inputTokensDetails(): java.util.Optional<InputTokensDetails> =
        inputTokensDetails.getOptional("input_tokens_details")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun inputTokensDetailsOrThrow(): InputTokensDetails =
        inputTokensDetails.getRequired("input_tokens_details")

    /**
     * The number of output tokens. The schema requires this property. Returns empty if the JSON
     * property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun outputTokens(): java.util.Optional<Long> = outputTokens.getOptional("output_tokens")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun outputTokensOrThrow(): Long = outputTokens.getRequired("output_tokens")

    /**
     * A detailed breakdown of the output tokens. The schema requires this property. Returns empty
     * if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun outputTokensDetails(): java.util.Optional<OutputTokensDetails> =
        outputTokensDetails.getOptional("output_tokens_details")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun outputTokensDetailsOrThrow(): OutputTokensDetails =
        outputTokensDetails.getRequired("output_tokens_details")

    /**
     * The total number of tokens used. The schema requires this property. Returns empty if the JSON
     * property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun totalTokens(): java.util.Optional<Long> = totalTokens.getOptional("total_tokens")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun totalTokensOrThrow(): Long = totalTokens.getRequired("total_tokens")

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

    /**
     * Returns an immutable snapshot of all present JSON properties, including declared and
     * additional properties.
     *
     * Keys use their JSON names. Declared properties take precedence over additional properties
     * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
     * values are preserved.
     */
    fun _allProperties(): Map<String, JsonValue> =
        collectAllProperties(
            additionalProperties,
            "input_tokens" to this.inputTokens,
            "input_tokens_details" to this.inputTokensDetails,
            "output_tokens" to this.outputTokens,
            "output_tokens_details" to this.outputTokensDetails,
            "total_tokens" to this.totalTokens,
        )

    @JvmSynthetic
    internal fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    @JsonAnyGetter
    @ExcludeMissing
    private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [BetaResponseUsage].
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

    /** A builder for [BetaResponseUsage]. */
    class Builder internal constructor() {

        private var inputTokens: JsonField<Long>? = null
        private var inputTokensDetails: JsonField<InputTokensDetails>? = null
        private var outputTokens: JsonField<Long>? = null
        private var outputTokensDetails: JsonField<OutputTokensDetails>? = null
        private var totalTokens: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(betaResponseUsage: BetaResponseUsage) = apply {
            inputTokens = betaResponseUsage.inputTokens
            inputTokensDetails = betaResponseUsage.inputTokensDetails
            outputTokens = betaResponseUsage.outputTokens
            outputTokensDetails = betaResponseUsage.outputTokensDetails
            totalTokens = betaResponseUsage.totalTokens
            additionalProperties = betaResponseUsage.additionalProperties.toMutableMap()
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
         * Returns an immutable instance of [BetaResponseUsage].
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
        fun build(): BetaResponseUsage =
            BetaResponseUsage(
                checkRequired("inputTokens", inputTokens),
                checkRequired("inputTokensDetails", inputTokensDetails),
                checkRequired("outputTokens", outputTokens),
                checkRequired("outputTokensDetails", outputTokensDetails),
                checkRequired("totalTokens", totalTokens),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): BetaResponseUsage = apply {
        if (validated) {
            return@apply
        }

        inputTokensOrThrow()
        inputTokensDetailsOrThrow().validate()
        outputTokensOrThrow()
        outputTokensDetailsOrThrow().validate()
        totalTokensOrThrow()
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
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val cacheWriteTokens: JsonField<Long>,
        private val cachedTokens: JsonField<Long>,
        private val cacheWriteTokensDetails: JsonField<CacheWriteTokensDetails>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("cache_write_tokens")
            @ExcludeMissing
            cacheWriteTokens: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("cached_tokens")
            @ExcludeMissing
            cachedTokens: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("cache_write_tokens_details")
            @ExcludeMissing
            cacheWriteTokensDetails: JsonField<CacheWriteTokensDetails> = JsonMissing.of(),
        ) : this(cacheWriteTokens, cachedTokens, cacheWriteTokensDetails, mutableMapOf())

        /**
         * The number of input tokens that were written to the cache. The schema requires this
         * property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun cacheWriteTokens(): java.util.Optional<Long> =
            cacheWriteTokens.getOptional("cache_write_tokens")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun cacheWriteTokensOrThrow(): Long = cacheWriteTokens.getRequired("cache_write_tokens")

        /**
         * The number of tokens that were retrieved from the cache.
         * [More on prompt caching](https://developers.openai.com/api/docs/guides/prompt-caching).
         * The schema requires this property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun cachedTokens(): java.util.Optional<Long> = cachedTokens.getOptional("cached_tokens")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun cachedTokensOrThrow(): Long = cachedTokens.getRequired("cached_tokens")

        /**
         * Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun cacheWriteTokensDetails(): java.util.Optional<CacheWriteTokensDetails> =
            cacheWriteTokensDetails.getOptional("cache_write_tokens_details")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun cacheWriteTokensDetailsOrThrow(): CacheWriteTokensDetails =
            cacheWriteTokensDetails.getRequired("cache_write_tokens_details")

        /**
         * Returns the raw JSON value of [cacheWriteTokens].
         *
         * Unlike [cacheWriteTokens], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("cache_write_tokens")
        @ExcludeMissing
        fun _cacheWriteTokens(): JsonField<Long> = cacheWriteTokens

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
         * Returns the raw JSON value of [cacheWriteTokensDetails].
         *
         * Unlike [cacheWriteTokensDetails], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("cache_write_tokens_details")
        @ExcludeMissing
        fun _cacheWriteTokensDetails(): JsonField<CacheWriteTokensDetails> = cacheWriteTokensDetails

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        /**
         * Returns an immutable snapshot of all present JSON properties, including declared and
         * additional properties.
         *
         * Keys use their JSON names. Declared properties take precedence over additional properties
         * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
         * values are preserved.
         */
        fun _allProperties(): Map<String, JsonValue> =
            collectAllProperties(
                additionalProperties,
                "cache_write_tokens" to this.cacheWriteTokens,
                "cached_tokens" to this.cachedTokens,
                "cache_write_tokens_details" to this.cacheWriteTokensDetails,
            )

        @JvmSynthetic
        internal fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        @JsonAnyGetter
        @ExcludeMissing
        private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [InputTokensDetails].
             *
             * The following fields are required:
             * ```java
             * .cacheWriteTokens()
             * .cachedTokens()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [InputTokensDetails]. */
        class Builder internal constructor() {

            private var cacheWriteTokens: JsonField<Long>? = null
            private var cachedTokens: JsonField<Long>? = null
            private var cacheWriteTokensDetails: JsonField<CacheWriteTokensDetails> =
                JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(inputTokensDetails: InputTokensDetails) = apply {
                cacheWriteTokens = inputTokensDetails.cacheWriteTokens
                cachedTokens = inputTokensDetails.cachedTokens
                cacheWriteTokensDetails = inputTokensDetails.cacheWriteTokensDetails
                additionalProperties = inputTokensDetails.additionalProperties.toMutableMap()
            }

            /** The number of input tokens that were written to the cache. */
            fun cacheWriteTokens(cacheWriteTokens: Long) =
                cacheWriteTokens(JsonField.of(cacheWriteTokens))

            /**
             * Sets [Builder.cacheWriteTokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.cacheWriteTokens] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun cacheWriteTokens(cacheWriteTokens: JsonField<Long>) = apply {
                this.cacheWriteTokens = cacheWriteTokens
            }

            /**
             * The number of tokens that were retrieved from the cache.
             * [More on prompt caching](https://developers.openai.com/api/docs/guides/prompt-caching).
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

            fun cacheWriteTokensDetails(cacheWriteTokensDetails: CacheWriteTokensDetails) =
                cacheWriteTokensDetails(JsonField.of(cacheWriteTokensDetails))

            /**
             * Sets [Builder.cacheWriteTokensDetails] to an arbitrary JSON value.
             *
             * You should usually call [Builder.cacheWriteTokensDetails] with a well-typed
             * [CacheWriteTokensDetails] value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun cacheWriteTokensDetails(
                cacheWriteTokensDetails: JsonField<CacheWriteTokensDetails>
            ) = apply { this.cacheWriteTokensDetails = cacheWriteTokensDetails }

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
             * .cacheWriteTokens()
             * .cachedTokens()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): InputTokensDetails =
                InputTokensDetails(
                    checkRequired("cacheWriteTokens", cacheWriteTokens),
                    checkRequired("cachedTokens", cachedTokens),
                    cacheWriteTokensDetails,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): InputTokensDetails = apply {
            if (validated) {
                return@apply
            }

            cacheWriteTokensOrThrow()
            cachedTokensOrThrow()
            cacheWriteTokensDetails().ifPresent { it.validate() }
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
            (if (cacheWriteTokens.asKnown().isPresent) 1 else 0) +
                (if (cachedTokens.asKnown().isPresent) 1 else 0) +
                (cacheWriteTokensDetails.asKnown().getOrNull()?.validity() ?: 0)

        class CacheWriteTokensDetails
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val ttl12hTokens: JsonField<Long>,
            private val ttl30mTokens: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("ttl_12h_tokens")
                @ExcludeMissing
                ttl12hTokens: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("ttl_30m_tokens")
                @ExcludeMissing
                ttl30mTokens: JsonField<Long> = JsonMissing.of(),
            ) : this(ttl12hTokens, ttl30mTokens, mutableMapOf())

            /**
             * The number of input tokens written with 12-hour retention. The schema requires this
             * property. Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun ttl12hTokens(): java.util.Optional<Long> =
                ttl12hTokens.getOptional("ttl_12h_tokens")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun ttl12hTokensOrThrow(): Long = ttl12hTokens.getRequired("ttl_12h_tokens")

            /**
             * The number of input tokens written with 30-minute retention. The schema requires this
             * property. Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun ttl30mTokens(): java.util.Optional<Long> =
                ttl30mTokens.getOptional("ttl_30m_tokens")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun ttl30mTokensOrThrow(): Long = ttl30mTokens.getRequired("ttl_30m_tokens")

            /**
             * Returns the raw JSON value of [ttl12hTokens].
             *
             * Unlike [ttl12hTokens], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("ttl_12h_tokens")
            @ExcludeMissing
            fun _ttl12hTokens(): JsonField<Long> = ttl12hTokens

            /**
             * Returns the raw JSON value of [ttl30mTokens].
             *
             * Unlike [ttl30mTokens], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("ttl_30m_tokens")
            @ExcludeMissing
            fun _ttl30mTokens(): JsonField<Long> = ttl30mTokens

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            /**
             * Returns an immutable snapshot of all present JSON properties, including declared and
             * additional properties.
             *
             * Keys use their JSON names. Declared properties take precedence over additional
             * properties with the same name. Missing properties are omitted, while explicit nulls
             * and unrecognized values are preserved.
             */
            fun _allProperties(): Map<String, JsonValue> =
                collectAllProperties(
                    additionalProperties,
                    "ttl_12h_tokens" to this.ttl12hTokens,
                    "ttl_30m_tokens" to this.ttl30mTokens,
                )

            @JvmSynthetic
            internal fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            @JsonAnyGetter
            @ExcludeMissing
            private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of
                 * [CacheWriteTokensDetails].
                 *
                 * The following fields are required:
                 * ```java
                 * .ttl12hTokens()
                 * .ttl30mTokens()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [CacheWriteTokensDetails]. */
            class Builder internal constructor() {

                private var ttl12hTokens: JsonField<Long>? = null
                private var ttl30mTokens: JsonField<Long>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(cacheWriteTokensDetails: CacheWriteTokensDetails) = apply {
                    ttl12hTokens = cacheWriteTokensDetails.ttl12hTokens
                    ttl30mTokens = cacheWriteTokensDetails.ttl30mTokens
                    additionalProperties =
                        cacheWriteTokensDetails.additionalProperties.toMutableMap()
                }

                /** The number of input tokens written with 12-hour retention. */
                fun ttl12hTokens(ttl12hTokens: Long) = ttl12hTokens(JsonField.of(ttl12hTokens))

                /**
                 * Sets [Builder.ttl12hTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.ttl12hTokens] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun ttl12hTokens(ttl12hTokens: JsonField<Long>) = apply {
                    this.ttl12hTokens = ttl12hTokens
                }

                /** The number of input tokens written with 30-minute retention. */
                fun ttl30mTokens(ttl30mTokens: Long) = ttl30mTokens(JsonField.of(ttl30mTokens))

                /**
                 * Sets [Builder.ttl30mTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.ttl30mTokens] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun ttl30mTokens(ttl30mTokens: JsonField<Long>) = apply {
                    this.ttl30mTokens = ttl30mTokens
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [CacheWriteTokensDetails].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .ttl12hTokens()
                 * .ttl30mTokens()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): CacheWriteTokensDetails =
                    CacheWriteTokensDetails(
                        checkRequired("ttl12hTokens", ttl12hTokens),
                        checkRequired("ttl30mTokens", ttl30mTokens),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): CacheWriteTokensDetails = apply {
                if (validated) {
                    return@apply
                }

                ttl12hTokensOrThrow()
                ttl30mTokensOrThrow()
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
                (if (ttl12hTokens.asKnown().isPresent) 1 else 0) +
                    (if (ttl30mTokens.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is CacheWriteTokensDetails &&
                    ttl12hTokens == other.ttl12hTokens &&
                    ttl30mTokens == other.ttl30mTokens &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(ttl12hTokens, ttl30mTokens, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "CacheWriteTokensDetails{ttl12hTokens=$ttl12hTokens, ttl30mTokens=$ttl30mTokens, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is InputTokensDetails &&
                cacheWriteTokens == other.cacheWriteTokens &&
                cachedTokens == other.cachedTokens &&
                cacheWriteTokensDetails == other.cacheWriteTokensDetails &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                cacheWriteTokens,
                cachedTokens,
                cacheWriteTokensDetails,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "InputTokensDetails{cacheWriteTokens=$cacheWriteTokens, cachedTokens=$cachedTokens, cacheWriteTokensDetails=$cacheWriteTokensDetails, additionalProperties=$additionalProperties}"
    }

    /** A detailed breakdown of the output tokens. */
    class OutputTokensDetails
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
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
         * The number of reasoning tokens. The schema requires this property. Returns empty if the
         * JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun reasoningTokens(): java.util.Optional<Long> =
            reasoningTokens.getOptional("reasoning_tokens")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun reasoningTokensOrThrow(): Long = reasoningTokens.getRequired("reasoning_tokens")

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

        /**
         * Returns an immutable snapshot of all present JSON properties, including declared and
         * additional properties.
         *
         * Keys use their JSON names. Declared properties take precedence over additional properties
         * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
         * values are preserved.
         */
        fun _allProperties(): Map<String, JsonValue> =
            collectAllProperties(additionalProperties, "reasoning_tokens" to this.reasoningTokens)

        @JvmSynthetic
        internal fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        @JsonAnyGetter
        @ExcludeMissing
        private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): OutputTokensDetails = apply {
            if (validated) {
                return@apply
            }

            reasoningTokensOrThrow()
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

            return other is OutputTokensDetails &&
                reasoningTokens == other.reasoningTokens &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(reasoningTokens, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "OutputTokensDetails{reasoningTokens=$reasoningTokens, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BetaResponseUsage &&
            inputTokens == other.inputTokens &&
            inputTokensDetails == other.inputTokensDetails &&
            outputTokens == other.outputTokens &&
            outputTokensDetails == other.outputTokensDetails &&
            totalTokens == other.totalTokens &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            inputTokens,
            inputTokensDetails,
            outputTokens,
            outputTokensDetails,
            totalTokens,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BetaResponseUsage{inputTokens=$inputTokens, inputTokensDetails=$inputTokensDetails, outputTokens=$outputTokens, outputTokensDetails=$outputTokensDetails, totalTokens=$totalTokens, additionalProperties=$additionalProperties}"
}
