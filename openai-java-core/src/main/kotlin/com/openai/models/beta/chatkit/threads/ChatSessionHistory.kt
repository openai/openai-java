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
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** History retention preferences returned for the session. */
class ChatSessionHistory
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val enabled: JsonField<Boolean>,
    private val recentThreads: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("enabled") @ExcludeMissing enabled: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("recent_threads")
        @ExcludeMissing
        recentThreads: JsonField<Long> = JsonMissing.of(),
    ) : this(enabled, recentThreads, mutableMapOf())

    /**
     * Indicates if chat history is persisted for the session.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun enabled(): Boolean = enabled.getRequired("enabled")

    /**
     * Number of prior threads surfaced in history views. Defaults to null when all history is
     * retained.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun recentThreads(): Optional<Long> = recentThreads.getOptional("recent_threads")

    /**
     * Returns the raw JSON value of [enabled].
     *
     * Unlike [enabled], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("enabled") @ExcludeMissing fun _enabled(): JsonField<Boolean> = enabled

    /**
     * Returns the raw JSON value of [recentThreads].
     *
     * Unlike [recentThreads], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("recent_threads")
    @ExcludeMissing
    fun _recentThreads(): JsonField<Long> = recentThreads

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
         * Returns a mutable builder for constructing an instance of [ChatSessionHistory].
         *
         * The following fields are required:
         * ```java
         * .enabled()
         * .recentThreads()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ChatSessionHistory]. */
    class Builder internal constructor() {

        private var enabled: JsonField<Boolean>? = null
        private var recentThreads: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatSessionHistory: ChatSessionHistory) = apply {
            enabled = chatSessionHistory.enabled
            recentThreads = chatSessionHistory.recentThreads
            additionalProperties = chatSessionHistory.additionalProperties.toMutableMap()
        }

        /** Indicates if chat history is persisted for the session. */
        fun enabled(enabled: Boolean) = enabled(JsonField.of(enabled))

        /**
         * Sets [Builder.enabled] to an arbitrary JSON value.
         *
         * You should usually call [Builder.enabled] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun enabled(enabled: JsonField<Boolean>) = apply { this.enabled = enabled }

        /**
         * Number of prior threads surfaced in history views. Defaults to null when all history is
         * retained.
         */
        fun recentThreads(recentThreads: Long?) = recentThreads(JsonField.ofNullable(recentThreads))

        /**
         * Alias for [Builder.recentThreads].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun recentThreads(recentThreads: Long) = recentThreads(recentThreads as Long?)

        /** Alias for calling [Builder.recentThreads] with `recentThreads.orElse(null)`. */
        fun recentThreads(recentThreads: Optional<Long>) = recentThreads(recentThreads.getOrNull())

        /**
         * Sets [Builder.recentThreads] to an arbitrary JSON value.
         *
         * You should usually call [Builder.recentThreads] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun recentThreads(recentThreads: JsonField<Long>) = apply {
            this.recentThreads = recentThreads
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
         * Returns an immutable instance of [ChatSessionHistory].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .enabled()
         * .recentThreads()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ChatSessionHistory =
            ChatSessionHistory(
                checkRequired("enabled", enabled),
                checkRequired("recentThreads", recentThreads),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ChatSessionHistory = apply {
        if (validated) {
            return@apply
        }

        enabled()
        recentThreads()
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
        (if (enabled.asKnown().isPresent) 1 else 0) +
            (if (recentThreads.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ChatSessionHistory &&
            enabled == other.enabled &&
            recentThreads == other.recentThreads &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(enabled, recentThreads, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatSessionHistory{enabled=$enabled, recentThreads=$recentThreads, additionalProperties=$additionalProperties}"
}
