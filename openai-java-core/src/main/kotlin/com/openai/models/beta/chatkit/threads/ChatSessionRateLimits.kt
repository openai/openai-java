// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit.threads

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

/** Active per-minute request limit for the session. */
class ChatSessionRateLimits
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val maxRequestsPer1Minute: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("max_requests_per_1_minute")
        @ExcludeMissing
        maxRequestsPer1Minute: JsonField<Long> = JsonMissing.of()
    ) : this(maxRequestsPer1Minute, mutableMapOf())

    /**
     * Maximum allowed requests per one-minute window.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun maxRequestsPer1Minute(): Long =
        maxRequestsPer1Minute.getRequired("max_requests_per_1_minute")

    /**
     * Returns the raw JSON value of [maxRequestsPer1Minute].
     *
     * Unlike [maxRequestsPer1Minute], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("max_requests_per_1_minute")
    @ExcludeMissing
    fun _maxRequestsPer1Minute(): JsonField<Long> = maxRequestsPer1Minute

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
         * Returns a mutable builder for constructing an instance of [ChatSessionRateLimits].
         *
         * The following fields are required:
         * ```java
         * .maxRequestsPer1Minute()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ChatSessionRateLimits]. */
    class Builder internal constructor() {

        private var maxRequestsPer1Minute: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatSessionRateLimits: ChatSessionRateLimits) = apply {
            maxRequestsPer1Minute = chatSessionRateLimits.maxRequestsPer1Minute
            additionalProperties = chatSessionRateLimits.additionalProperties.toMutableMap()
        }

        /** Maximum allowed requests per one-minute window. */
        fun maxRequestsPer1Minute(maxRequestsPer1Minute: Long) =
            maxRequestsPer1Minute(JsonField.of(maxRequestsPer1Minute))

        /**
         * Sets [Builder.maxRequestsPer1Minute] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxRequestsPer1Minute] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun maxRequestsPer1Minute(maxRequestsPer1Minute: JsonField<Long>) = apply {
            this.maxRequestsPer1Minute = maxRequestsPer1Minute
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
         * Returns an immutable instance of [ChatSessionRateLimits].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .maxRequestsPer1Minute()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ChatSessionRateLimits =
            ChatSessionRateLimits(
                checkRequired("maxRequestsPer1Minute", maxRequestsPer1Minute),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ChatSessionRateLimits = apply {
        if (validated) {
            return@apply
        }

        maxRequestsPer1Minute()
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
    internal fun validity(): Int = (if (maxRequestsPer1Minute.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ChatSessionRateLimits &&
            maxRequestsPer1Minute == other.maxRequestsPer1Minute &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(maxRequestsPer1Minute, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatSessionRateLimits{maxRequestsPer1Minute=$maxRequestsPer1Minute, additionalProperties=$additionalProperties}"
}
