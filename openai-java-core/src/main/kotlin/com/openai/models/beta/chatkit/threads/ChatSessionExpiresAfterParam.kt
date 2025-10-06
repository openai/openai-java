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

/** Controls when the session expires relative to an anchor timestamp. */
class ChatSessionExpiresAfterParam
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val anchor: JsonValue,
    private val seconds: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("anchor") @ExcludeMissing anchor: JsonValue = JsonMissing.of(),
        @JsonProperty("seconds") @ExcludeMissing seconds: JsonField<Long> = JsonMissing.of(),
    ) : this(anchor, seconds, mutableMapOf())

    /**
     * Base timestamp used to calculate expiration. Currently fixed to `created_at`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("created_at")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("anchor") @ExcludeMissing fun _anchor(): JsonValue = anchor

    /**
     * Number of seconds after the anchor when the session expires.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun seconds(): Long = seconds.getRequired("seconds")

    /**
     * Returns the raw JSON value of [seconds].
     *
     * Unlike [seconds], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("seconds") @ExcludeMissing fun _seconds(): JsonField<Long> = seconds

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
         * Returns a mutable builder for constructing an instance of [ChatSessionExpiresAfterParam].
         *
         * The following fields are required:
         * ```java
         * .seconds()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ChatSessionExpiresAfterParam]. */
    class Builder internal constructor() {

        private var anchor: JsonValue = JsonValue.from("created_at")
        private var seconds: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatSessionExpiresAfterParam: ChatSessionExpiresAfterParam) = apply {
            anchor = chatSessionExpiresAfterParam.anchor
            seconds = chatSessionExpiresAfterParam.seconds
            additionalProperties = chatSessionExpiresAfterParam.additionalProperties.toMutableMap()
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("created_at")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun anchor(anchor: JsonValue) = apply { this.anchor = anchor }

        /** Number of seconds after the anchor when the session expires. */
        fun seconds(seconds: Long) = seconds(JsonField.of(seconds))

        /**
         * Sets [Builder.seconds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.seconds] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun seconds(seconds: JsonField<Long>) = apply { this.seconds = seconds }

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
         * Returns an immutable instance of [ChatSessionExpiresAfterParam].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .seconds()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ChatSessionExpiresAfterParam =
            ChatSessionExpiresAfterParam(
                anchor,
                checkRequired("seconds", seconds),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ChatSessionExpiresAfterParam = apply {
        if (validated) {
            return@apply
        }

        _anchor().let {
            if (it != JsonValue.from("created_at")) {
                throw OpenAIInvalidDataException("'anchor' is invalid, received $it")
            }
        }
        seconds()
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
        anchor.let { if (it == JsonValue.from("created_at")) 1 else 0 } +
            (if (seconds.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ChatSessionExpiresAfterParam &&
            anchor == other.anchor &&
            seconds == other.seconds &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(anchor, seconds, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatSessionExpiresAfterParam{anchor=$anchor, seconds=$seconds, additionalProperties=$additionalProperties}"
}
