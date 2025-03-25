// File generated from our OpenAPI spec by Stainless.

package com.openai.models.batches

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

/** The request counts for different statuses within the batch. */
class BatchRequestCounts
private constructor(
    private val completed: JsonField<Long>,
    private val failed: JsonField<Long>,
    private val total: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("completed") @ExcludeMissing completed: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("failed") @ExcludeMissing failed: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("total") @ExcludeMissing total: JsonField<Long> = JsonMissing.of(),
    ) : this(completed, failed, total, mutableMapOf())

    /**
     * Number of requests that have been completed successfully.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun completed(): Long = completed.getRequired("completed")

    /**
     * Number of requests that have failed.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun failed(): Long = failed.getRequired("failed")

    /**
     * Total number of requests in the batch.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun total(): Long = total.getRequired("total")

    /**
     * Returns the raw JSON value of [completed].
     *
     * Unlike [completed], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("completed") @ExcludeMissing fun _completed(): JsonField<Long> = completed

    /**
     * Returns the raw JSON value of [failed].
     *
     * Unlike [failed], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("failed") @ExcludeMissing fun _failed(): JsonField<Long> = failed

    /**
     * Returns the raw JSON value of [total].
     *
     * Unlike [total], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("total") @ExcludeMissing fun _total(): JsonField<Long> = total

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
         * Returns a mutable builder for constructing an instance of [BatchRequestCounts].
         *
         * The following fields are required:
         * ```java
         * .completed()
         * .failed()
         * .total()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BatchRequestCounts]. */
    class Builder internal constructor() {

        private var completed: JsonField<Long>? = null
        private var failed: JsonField<Long>? = null
        private var total: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(batchRequestCounts: BatchRequestCounts) = apply {
            completed = batchRequestCounts.completed
            failed = batchRequestCounts.failed
            total = batchRequestCounts.total
            additionalProperties = batchRequestCounts.additionalProperties.toMutableMap()
        }

        /** Number of requests that have been completed successfully. */
        fun completed(completed: Long) = completed(JsonField.of(completed))

        /**
         * Sets [Builder.completed] to an arbitrary JSON value.
         *
         * You should usually call [Builder.completed] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun completed(completed: JsonField<Long>) = apply { this.completed = completed }

        /** Number of requests that have failed. */
        fun failed(failed: Long) = failed(JsonField.of(failed))

        /**
         * Sets [Builder.failed] to an arbitrary JSON value.
         *
         * You should usually call [Builder.failed] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun failed(failed: JsonField<Long>) = apply { this.failed = failed }

        /** Total number of requests in the batch. */
        fun total(total: Long) = total(JsonField.of(total))

        /**
         * Sets [Builder.total] to an arbitrary JSON value.
         *
         * You should usually call [Builder.total] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun total(total: JsonField<Long>) = apply { this.total = total }

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
         * Returns an immutable instance of [BatchRequestCounts].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .completed()
         * .failed()
         * .total()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BatchRequestCounts =
            BatchRequestCounts(
                checkRequired("completed", completed),
                checkRequired("failed", failed),
                checkRequired("total", total),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): BatchRequestCounts = apply {
        if (validated) {
            return@apply
        }

        completed()
        failed()
        total()
        validated = true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BatchRequestCounts && completed == other.completed && failed == other.failed && total == other.total && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(completed, failed, total, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BatchRequestCounts{completed=$completed, failed=$failed, total=$total, additionalProperties=$additionalProperties}"
}
