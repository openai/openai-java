// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

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

/** The expiration policy for a vector store. */
class VectorStoreExpirationAfter
private constructor(
    private val anchor: JsonValue,
    private val days: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("anchor") @ExcludeMissing anchor: JsonValue = JsonMissing.of(),
        @JsonProperty("days") @ExcludeMissing days: JsonField<Long> = JsonMissing.of(),
    ) : this(anchor, days, mutableMapOf())

    /**
     * Anchor timestamp after which the expiration policy applies. Supported anchors:
     * `last_active_at`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("last_active_at")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("anchor") @ExcludeMissing fun _anchor(): JsonValue = anchor

    /**
     * The number of days after the anchor time that the vector store will expire.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun days(): Long = days.getRequired("days")

    /**
     * Returns the raw JSON value of [days].
     *
     * Unlike [days], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("days") @ExcludeMissing fun _days(): JsonField<Long> = days

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
         * Returns a mutable builder for constructing an instance of [VectorStoreExpirationAfter].
         *
         * The following fields are required:
         * ```java
         * .days()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VectorStoreExpirationAfter]. */
    class Builder internal constructor() {

        private var anchor: JsonValue = JsonValue.from("last_active_at")
        private var days: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(vectorStoreExpirationAfter: VectorStoreExpirationAfter) = apply {
            anchor = vectorStoreExpirationAfter.anchor
            days = vectorStoreExpirationAfter.days
            additionalProperties = vectorStoreExpirationAfter.additionalProperties.toMutableMap()
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("last_active_at")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun anchor(anchor: JsonValue) = apply { this.anchor = anchor }

        /** The number of days after the anchor time that the vector store will expire. */
        fun days(days: Long) = days(JsonField.of(days))

        /**
         * Sets [Builder.days] to an arbitrary JSON value.
         *
         * You should usually call [Builder.days] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun days(days: JsonField<Long>) = apply { this.days = days }

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
         * Returns an immutable instance of [VectorStoreExpirationAfter].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .days()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): VectorStoreExpirationAfter =
            VectorStoreExpirationAfter(
                anchor,
                checkRequired("days", days),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): VectorStoreExpirationAfter = apply {
        if (validated) {
            return@apply
        }

        _anchor().let {
            if (it != JsonValue.from("last_active_at")) {
                throw OpenAIInvalidDataException("'anchor' is invalid, received $it")
            }
        }
        days()
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
        anchor.let { if (it == JsonValue.from("last_active_at")) 1 else 0 } +
            (if (days.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is VectorStoreExpirationAfter && anchor == other.anchor && days == other.days && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(anchor, days, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "VectorStoreExpirationAfter{anchor=$anchor, days=$days, additionalProperties=$additionalProperties}"
}
