// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

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
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class ChatCompletionTokenLogprob
private constructor(
    private val token: JsonField<String>,
    private val bytes: JsonField<List<Long>>,
    private val logprob: JsonField<Double>,
    private val topLogprobs: JsonField<List<TopLogprob>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("token") @ExcludeMissing token: JsonField<String> = JsonMissing.of(),
        @JsonProperty("bytes") @ExcludeMissing bytes: JsonField<List<Long>> = JsonMissing.of(),
        @JsonProperty("logprob") @ExcludeMissing logprob: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("top_logprobs")
        @ExcludeMissing
        topLogprobs: JsonField<List<TopLogprob>> = JsonMissing.of(),
    ) : this(token, bytes, logprob, topLogprobs, mutableMapOf())

    /**
     * The token.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun token(): String = token.getRequired("token")

    /**
     * A list of integers representing the UTF-8 bytes representation of the token. Useful in
     * instances where characters are represented by multiple tokens and their byte representations
     * must be combined to generate the correct text representation. Can be `null` if there is no
     * bytes representation for the token.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun bytes(): Optional<List<Long>> = Optional.ofNullable(bytes.getNullable("bytes"))

    /**
     * The log probability of this token, if it is within the top 20 most likely tokens. Otherwise,
     * the value `-9999.0` is used to signify that the token is very unlikely.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun logprob(): Double = logprob.getRequired("logprob")

    /**
     * List of the most likely tokens and their log probability, at this token position. In rare
     * cases, there may be fewer than the number of requested `top_logprobs` returned.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun topLogprobs(): List<TopLogprob> = topLogprobs.getRequired("top_logprobs")

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

    /**
     * Returns the raw JSON value of [topLogprobs].
     *
     * Unlike [topLogprobs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("top_logprobs")
    @ExcludeMissing
    fun _topLogprobs(): JsonField<List<TopLogprob>> = topLogprobs

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
         * Returns a mutable builder for constructing an instance of [ChatCompletionTokenLogprob].
         *
         * The following fields are required:
         * ```java
         * .token()
         * .bytes()
         * .logprob()
         * .topLogprobs()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ChatCompletionTokenLogprob]. */
    class Builder internal constructor() {

        private var token: JsonField<String>? = null
        private var bytes: JsonField<MutableList<Long>>? = null
        private var logprob: JsonField<Double>? = null
        private var topLogprobs: JsonField<MutableList<TopLogprob>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletionTokenLogprob: ChatCompletionTokenLogprob) = apply {
            token = chatCompletionTokenLogprob.token
            bytes = chatCompletionTokenLogprob.bytes.map { it.toMutableList() }
            logprob = chatCompletionTokenLogprob.logprob
            topLogprobs = chatCompletionTokenLogprob.topLogprobs.map { it.toMutableList() }
            additionalProperties = chatCompletionTokenLogprob.additionalProperties.toMutableMap()
        }

        /** The token. */
        fun token(token: String) = token(JsonField.of(token))

        /**
         * Sets [Builder.token] to an arbitrary JSON value.
         *
         * You should usually call [Builder.token] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun token(token: JsonField<String>) = apply { this.token = token }

        /**
         * A list of integers representing the UTF-8 bytes representation of the token. Useful in
         * instances where characters are represented by multiple tokens and their byte
         * representations must be combined to generate the correct text representation. Can be
         * `null` if there is no bytes representation for the token.
         */
        fun bytes(bytes: List<Long>?) = bytes(JsonField.ofNullable(bytes))

        /** Alias for calling [Builder.bytes] with `bytes.orElse(null)`. */
        fun bytes(bytes: Optional<List<Long>>) = bytes(bytes.getOrNull())

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

        /**
         * The log probability of this token, if it is within the top 20 most likely tokens.
         * Otherwise, the value `-9999.0` is used to signify that the token is very unlikely.
         */
        fun logprob(logprob: Double) = logprob(JsonField.of(logprob))

        /**
         * Sets [Builder.logprob] to an arbitrary JSON value.
         *
         * You should usually call [Builder.logprob] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun logprob(logprob: JsonField<Double>) = apply { this.logprob = logprob }

        /**
         * List of the most likely tokens and their log probability, at this token position. In rare
         * cases, there may be fewer than the number of requested `top_logprobs` returned.
         */
        fun topLogprobs(topLogprobs: List<TopLogprob>) = topLogprobs(JsonField.of(topLogprobs))

        /**
         * Sets [Builder.topLogprobs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.topLogprobs] with a well-typed `List<TopLogprob>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun topLogprobs(topLogprobs: JsonField<List<TopLogprob>>) = apply {
            this.topLogprobs = topLogprobs.map { it.toMutableList() }
        }

        /**
         * Adds a single [TopLogprob] to [topLogprobs].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTopLogprob(topLogprob: TopLogprob) = apply {
            topLogprobs =
                (topLogprobs ?: JsonField.of(mutableListOf())).also {
                    checkKnown("topLogprobs", it).add(topLogprob)
                }
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
         * Returns an immutable instance of [ChatCompletionTokenLogprob].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .token()
         * .bytes()
         * .logprob()
         * .topLogprobs()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ChatCompletionTokenLogprob =
            ChatCompletionTokenLogprob(
                checkRequired("token", token),
                checkRequired("bytes", bytes).map { it.toImmutable() },
                checkRequired("logprob", logprob),
                checkRequired("topLogprobs", topLogprobs).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ChatCompletionTokenLogprob = apply {
        if (validated) {
            return@apply
        }

        token()
        bytes()
        logprob()
        topLogprobs().forEach { it.validate() }
        validated = true
    }

    class TopLogprob
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
         * The token.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun token(): String = token.getRequired("token")

        /**
         * A list of integers representing the UTF-8 bytes representation of the token. Useful in
         * instances where characters are represented by multiple tokens and their byte
         * representations must be combined to generate the correct text representation. Can be
         * `null` if there is no bytes representation for the token.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun bytes(): Optional<List<Long>> = Optional.ofNullable(bytes.getNullable("bytes"))

        /**
         * The log probability of this token, if it is within the top 20 most likely tokens.
         * Otherwise, the value `-9999.0` is used to signify that the token is very unlikely.
         *
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
             * Returns a mutable builder for constructing an instance of [TopLogprob].
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

        /** A builder for [TopLogprob]. */
        class Builder internal constructor() {

            private var token: JsonField<String>? = null
            private var bytes: JsonField<MutableList<Long>>? = null
            private var logprob: JsonField<Double>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(topLogprob: TopLogprob) = apply {
                token = topLogprob.token
                bytes = topLogprob.bytes.map { it.toMutableList() }
                logprob = topLogprob.logprob
                additionalProperties = topLogprob.additionalProperties.toMutableMap()
            }

            /** The token. */
            fun token(token: String) = token(JsonField.of(token))

            /**
             * Sets [Builder.token] to an arbitrary JSON value.
             *
             * You should usually call [Builder.token] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun token(token: JsonField<String>) = apply { this.token = token }

            /**
             * A list of integers representing the UTF-8 bytes representation of the token. Useful
             * in instances where characters are represented by multiple tokens and their byte
             * representations must be combined to generate the correct text representation. Can be
             * `null` if there is no bytes representation for the token.
             */
            fun bytes(bytes: List<Long>?) = bytes(JsonField.ofNullable(bytes))

            /** Alias for calling [Builder.bytes] with `bytes.orElse(null)`. */
            fun bytes(bytes: Optional<List<Long>>) = bytes(bytes.getOrNull())

            /**
             * Sets [Builder.bytes] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bytes] with a well-typed `List<Long>` value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
                    (bytes ?: JsonField.of(mutableListOf())).also {
                        checkKnown("bytes", it).add(byte_)
                    }
            }

            /**
             * The log probability of this token, if it is within the top 20 most likely tokens.
             * Otherwise, the value `-9999.0` is used to signify that the token is very unlikely.
             */
            fun logprob(logprob: Double) = logprob(JsonField.of(logprob))

            /**
             * Sets [Builder.logprob] to an arbitrary JSON value.
             *
             * You should usually call [Builder.logprob] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * Returns an immutable instance of [TopLogprob].
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
            fun build(): TopLogprob =
                TopLogprob(
                    checkRequired("token", token),
                    checkRequired("bytes", bytes).map { it.toImmutable() },
                    checkRequired("logprob", logprob),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): TopLogprob = apply {
            if (validated) {
                return@apply
            }

            token()
            bytes()
            logprob()
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is TopLogprob && token == other.token && bytes == other.bytes && logprob == other.logprob && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(token, bytes, logprob, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "TopLogprob{token=$token, bytes=$bytes, logprob=$logprob, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionTokenLogprob && token == other.token && bytes == other.bytes && logprob == other.logprob && topLogprobs == other.topLogprobs && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(token, bytes, logprob, topLogprobs, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatCompletionTokenLogprob{token=$token, bytes=$bytes, logprob=$logprob, topLogprobs=$topLogprobs, additionalProperties=$additionalProperties}"
}
