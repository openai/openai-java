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
import com.openai.core.checkRequired
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects

/**
 * Retain a fraction of the conversation tokens when the conversation exceeds the input token limit.
 * This allows you to amortize truncations across multiple turns, which can help improve cached
 * token usage.
 */
class RealtimeTruncationRetentionRatio
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val retentionRatio: JsonField<Double>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("retention_ratio")
        @ExcludeMissing
        retentionRatio: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(retentionRatio, type, mutableMapOf())

    /**
     * Fraction of post-instruction conversation tokens to retain (0.0 - 1.0) when the conversation
     * exceeds the input token limit.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun retentionRatio(): Double = retentionRatio.getRequired("retention_ratio")

    /**
     * Use retention ratio truncation.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("retention_ratio")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [retentionRatio].
     *
     * Unlike [retentionRatio], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("retention_ratio")
    @ExcludeMissing
    fun _retentionRatio(): JsonField<Double> = retentionRatio

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
         * [RealtimeTruncationRetentionRatio].
         *
         * The following fields are required:
         * ```java
         * .retentionRatio()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RealtimeTruncationRetentionRatio]. */
    class Builder internal constructor() {

        private var retentionRatio: JsonField<Double>? = null
        private var type: JsonValue = JsonValue.from("retention_ratio")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(realtimeTruncationRetentionRatio: RealtimeTruncationRetentionRatio) =
            apply {
                retentionRatio = realtimeTruncationRetentionRatio.retentionRatio
                type = realtimeTruncationRetentionRatio.type
                additionalProperties =
                    realtimeTruncationRetentionRatio.additionalProperties.toMutableMap()
            }

        /**
         * Fraction of post-instruction conversation tokens to retain (0.0 - 1.0) when the
         * conversation exceeds the input token limit.
         */
        fun retentionRatio(retentionRatio: Double) = retentionRatio(JsonField.of(retentionRatio))

        /**
         * Sets [Builder.retentionRatio] to an arbitrary JSON value.
         *
         * You should usually call [Builder.retentionRatio] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun retentionRatio(retentionRatio: JsonField<Double>) = apply {
            this.retentionRatio = retentionRatio
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("retention_ratio")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

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
         * Returns an immutable instance of [RealtimeTruncationRetentionRatio].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .retentionRatio()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): RealtimeTruncationRetentionRatio =
            RealtimeTruncationRetentionRatio(
                checkRequired("retentionRatio", retentionRatio),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): RealtimeTruncationRetentionRatio = apply {
        if (validated) {
            return@apply
        }

        retentionRatio()
        _type().let {
            if (it != JsonValue.from("retention_ratio")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
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
        (if (retentionRatio.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("retention_ratio")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeTruncationRetentionRatio &&
            retentionRatio == other.retentionRatio &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(retentionRatio, type, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RealtimeTruncationRetentionRatio{retentionRatio=$retentionRatio, type=$type, additionalProperties=$additionalProperties}"
}
