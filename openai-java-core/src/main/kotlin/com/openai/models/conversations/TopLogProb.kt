// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

class TopLogProb
private constructor(
    private val token: JsonField<String>,
    private val bytes: JsonField<List<Long>>,
    private val logprob: JsonField<Double>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("token") @ExcludeMissing token: JsonField<String> = JsonMissing.of(),
        @JsonProperty("bytes") @ExcludeMissing bytes: JsonField<List<Long>> = JsonMissing.of(),
        @JsonProperty("logprob") @ExcludeMissing logprob: JsonField<Double> = JsonMissing.of(),
    ) : this(token, bytes, logprob, mutableMapOf())

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun token(): String = token.getRequired("token")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun bytes(): List<Long> = bytes.getRequired("bytes")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun logprob(): Double = logprob.getRequired("logprob")

    /**
     * Returns the raw JSON value of [token].
     *
     * Unlike [token], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("token") @ExcludeMissing fun _token(): JsonField<String> = token

    /**
     * Returns the raw JSON value of [bytes].
     *
     * Unlike [bytes], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("bytes") @ExcludeMissing fun _bytes(): JsonField<List<Long>> = bytes

    /**
     * Returns the raw JSON value of [logprob].
     *
     * Unlike [logprob], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("logprob") @ExcludeMissing fun _logprob(): JsonField<Double> = logprob

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
         * Returns a mutable builder for constructing an instance of [TopLogProb].
         *
         * The following fields are required:
         * ```java
         * .token()
         * .bytes()
         * .logprob()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TopLogProb]. */
    class Builder internal constructor() {

        private var token: JsonField<String>? = null
        private var bytes: JsonField<MutableList<Long>>? = null
        private var logprob: JsonField<Double>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(topLogProb: TopLogProb) = apply {
            token = topLogProb.token
            bytes = topLogProb.bytes.map { it.toMutableList() }
            logprob = topLogProb.logprob
            additionalProperties = topLogProb.additionalProperties.toMutableMap()
        }

        fun token(token: String) = token(JsonField.of(token))

        /**
         * Sets [Builder.token] to an arbitrary JSON value.
         *
         * You should usually call [Builder.token] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun token(token: JsonField<String>) = apply { this.token = token }

        fun bytes(bytes: List<Long>) = bytes(JsonField.of(bytes))

        /**
         * Sets [Builder.bytes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.bytes] with a well-typed `List<Long>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun bytes(bytes: JsonField<List<Long>>) = apply {
            this.bytes = bytes.map { it.toMutableList() }
        }

        /**
         * Adds a single [Long] to [bytes].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addByte(byte_: Long) = apply {
            bytes =
                (bytes ?: JsonField.of(mutableListOf())).also { checkKnown("bytes", it).add(byte_) }
        }

        fun logprob(logprob: Double) = logprob(JsonField.of(logprob))

        /**
         * Sets [Builder.logprob] to an arbitrary JSON value.
         *
         * You should usually call [Builder.logprob] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun logprob(logprob: JsonField<Double>) = apply { this.logprob = logprob }

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
         * Returns an immutable instance of [TopLogProb].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .token()
         * .bytes()
         * .logprob()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TopLogProb =
            TopLogProb(
                checkRequired("token", token),
                checkRequired("bytes", bytes).map { it.toImmutable() },
                checkRequired("logprob", logprob),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): TopLogProb = apply {
        if (validated) {
            return@apply
        }

        token()
        bytes()
        logprob()
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
        (if (token.asKnown().isPresent) 1 else 0) +
            (bytes.asKnown().getOrNull()?.size ?: 0) +
            (if (logprob.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TopLogProb &&
            token == other.token &&
            bytes == other.bytes &&
            logprob == other.logprob &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(token, bytes, logprob, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TopLogProb{token=$token, bytes=$bytes, logprob=$logprob, additionalProperties=$additionalProperties}"
}
