// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import java.util.Objects

/** The request counts for different statuses within the batch. */
@NoAutoDetect
class BatchRequestCounts
@JsonCreator
private constructor(
    @JsonProperty("total") @ExcludeMissing private val total: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("completed")
    @ExcludeMissing
    private val completed: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("failed") @ExcludeMissing private val failed: JsonField<Long> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** Total number of requests in the batch. */
    fun total(): Long = total.getRequired("total")

    /** Number of requests that have been completed successfully. */
    fun completed(): Long = completed.getRequired("completed")

    /** Number of requests that have failed. */
    fun failed(): Long = failed.getRequired("failed")

    /** Total number of requests in the batch. */
    @JsonProperty("total") @ExcludeMissing fun _total() = total

    /** Number of requests that have been completed successfully. */
    @JsonProperty("completed") @ExcludeMissing fun _completed() = completed

    /** Number of requests that have failed. */
    @JsonProperty("failed") @ExcludeMissing fun _failed() = failed

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): BatchRequestCounts = apply {
        if (!validated) {
            total()
            completed()
            failed()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var total: JsonField<Long> = JsonMissing.of()
        private var completed: JsonField<Long> = JsonMissing.of()
        private var failed: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(batchRequestCounts: BatchRequestCounts) = apply {
            total = batchRequestCounts.total
            completed = batchRequestCounts.completed
            failed = batchRequestCounts.failed
            additionalProperties = batchRequestCounts.additionalProperties.toMutableMap()
        }

        /** Total number of requests in the batch. */
        fun total(total: Long) = total(JsonField.of(total))

        /** Total number of requests in the batch. */
        fun total(total: JsonField<Long>) = apply { this.total = total }

        /** Number of requests that have been completed successfully. */
        fun completed(completed: Long) = completed(JsonField.of(completed))

        /** Number of requests that have been completed successfully. */
        fun completed(completed: JsonField<Long>) = apply { this.completed = completed }

        /** Number of requests that have failed. */
        fun failed(failed: Long) = failed(JsonField.of(failed))

        /** Number of requests that have failed. */
        fun failed(failed: JsonField<Long>) = apply { this.failed = failed }

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

        fun build(): BatchRequestCounts =
            BatchRequestCounts(
                total,
                completed,
                failed,
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BatchRequestCounts && total == other.total && completed == other.completed && failed == other.failed && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(total, completed, failed, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BatchRequestCounts{total=$total, completed=$completed, failed=$failed, additionalProperties=$additionalProperties}"
}
