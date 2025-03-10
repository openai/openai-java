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
import com.openai.core.NoAutoDetect
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

@NoAutoDetect
class ChatCompletionTokenLogprob
@JsonCreator
private constructor(
    @JsonProperty("token") @ExcludeMissing private val token: JsonField<String> = JsonMissing.of(),
    @JsonProperty("bytes")
    @ExcludeMissing
    private val bytes: JsonField<List<Long>> = JsonMissing.of(),
    @JsonProperty("logprob")
    @ExcludeMissing
    private val logprob: JsonField<Double> = JsonMissing.of(),
    @JsonProperty("top_logprobs")
    @ExcludeMissing
    private val topLogprobs: JsonField<List<TopLogprob>> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The token. */
    fun token(): String = token.getRequired("token")

    /**
     * A list of integers representing the UTF-8 bytes representation of the token. Useful in
     * instances where characters are represented by multiple tokens and their byte representations
     * must be combined to generate the correct text representation. Can be `null` if there is no
     * bytes representation for the token.
     */
    fun bytes(): Optional<List<Long>> = Optional.ofNullable(bytes.getNullable("bytes"))

    /**
     * The log probability of this token, if it is within the top 20 most likely tokens. Otherwise,
     * the value `-9999.0` is used to signify that the token is very unlikely.
     */
    fun logprob(): Double = logprob.getRequired("logprob")

    /**
     * List of the most likely tokens and their log probability, at this token position. In rare
     * cases, there may be fewer than the number of requested `top_logprobs` returned.
     */
    fun topLogprobs(): List<TopLogprob> = topLogprobs.getRequired("top_logprobs")

    /** The token. */
    @JsonProperty("token") @ExcludeMissing fun _token(): JsonField<String> = token

    /**
     * A list of integers representing the UTF-8 bytes representation of the token. Useful in
     * instances where characters are represented by multiple tokens and their byte representations
     * must be combined to generate the correct text representation. Can be `null` if there is no
     * bytes representation for the token.
     */
    @JsonProperty("bytes") @ExcludeMissing fun _bytes(): JsonField<List<Long>> = bytes

    /**
     * The log probability of this token, if it is within the top 20 most likely tokens. Otherwise,
     * the value `-9999.0` is used to signify that the token is very unlikely.
     */
    @JsonProperty("logprob") @ExcludeMissing fun _logprob(): JsonField<Double> = logprob

    /**
     * List of the most likely tokens and their log probability, at this token position. In rare
     * cases, there may be fewer than the number of requested `top_logprobs` returned.
     */
    @JsonProperty("top_logprobs")
    @ExcludeMissing
    fun _topLogprobs(): JsonField<List<TopLogprob>> = topLogprobs

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

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

        /** The token. */
        fun token(token: JsonField<String>) = apply { this.token = token }

        /**
         * A list of integers representing the UTF-8 bytes representation of the token. Useful in
         * instances where characters are represented by multiple tokens and their byte
         * representations must be combined to generate the correct text representation. Can be
         * `null` if there is no bytes representation for the token.
         */
        fun bytes(bytes: List<Long>?) = bytes(JsonField.ofNullable(bytes))

        /**
         * A list of integers representing the UTF-8 bytes representation of the token. Useful in
         * instances where characters are represented by multiple tokens and their byte
         * representations must be combined to generate the correct text representation. Can be
         * `null` if there is no bytes representation for the token.
         */
        fun bytes(bytes: Optional<List<Long>>) = bytes(bytes.getOrNull())

        /**
         * A list of integers representing the UTF-8 bytes representation of the token. Useful in
         * instances where characters are represented by multiple tokens and their byte
         * representations must be combined to generate the correct text representation. Can be
         * `null` if there is no bytes representation for the token.
         */
        fun bytes(bytes: JsonField<List<Long>>) = apply {
            this.bytes = bytes.map { it.toMutableList() }
        }

        /**
         * A list of integers representing the UTF-8 bytes representation of the token. Useful in
         * instances where characters are represented by multiple tokens and their byte
         * representations must be combined to generate the correct text representation. Can be
         * `null` if there is no bytes representation for the token.
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
         * The log probability of this token, if it is within the top 20 most likely tokens.
         * Otherwise, the value `-9999.0` is used to signify that the token is very unlikely.
         */
        fun logprob(logprob: JsonField<Double>) = apply { this.logprob = logprob }

        /**
         * List of the most likely tokens and their log probability, at this token position. In rare
         * cases, there may be fewer than the number of requested `top_logprobs` returned.
         */
        fun topLogprobs(topLogprobs: List<TopLogprob>) = topLogprobs(JsonField.of(topLogprobs))

        /**
         * List of the most likely tokens and their log probability, at this token position. In rare
         * cases, there may be fewer than the number of requested `top_logprobs` returned.
         */
        fun topLogprobs(topLogprobs: JsonField<List<TopLogprob>>) = apply {
            this.topLogprobs = topLogprobs.map { it.toMutableList() }
        }

        /**
         * List of the most likely tokens and their log probability, at this token position. In rare
         * cases, there may be fewer than the number of requested `top_logprobs` returned.
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

        fun build(): ChatCompletionTokenLogprob =
            ChatCompletionTokenLogprob(
                checkRequired("token", token),
                checkRequired("bytes", bytes).map { it.toImmutable() },
                checkRequired("logprob", logprob),
                checkRequired("topLogprobs", topLogprobs).map { it.toImmutable() },
                additionalProperties.toImmutable(),
            )
    }

    @NoAutoDetect
    class TopLogprob
    @JsonCreator
    private constructor(
        @JsonProperty("token")
        @ExcludeMissing
        private val token: JsonField<String> = JsonMissing.of(),
        @JsonProperty("bytes")
        @ExcludeMissing
        private val bytes: JsonField<List<Long>> = JsonMissing.of(),
        @JsonProperty("logprob")
        @ExcludeMissing
        private val logprob: JsonField<Double> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The token. */
        fun token(): String = token.getRequired("token")

        /**
         * A list of integers representing the UTF-8 bytes representation of the token. Useful in
         * instances where characters are represented by multiple tokens and their byte
         * representations must be combined to generate the correct text representation. Can be
         * `null` if there is no bytes representation for the token.
         */
        fun bytes(): Optional<List<Long>> = Optional.ofNullable(bytes.getNullable("bytes"))

        /**
         * The log probability of this token, if it is within the top 20 most likely tokens.
         * Otherwise, the value `-9999.0` is used to signify that the token is very unlikely.
         */
        fun logprob(): Double = logprob.getRequired("logprob")

        /** The token. */
        @JsonProperty("token") @ExcludeMissing fun _token(): JsonField<String> = token

        /**
         * A list of integers representing the UTF-8 bytes representation of the token. Useful in
         * instances where characters are represented by multiple tokens and their byte
         * representations must be combined to generate the correct text representation. Can be
         * `null` if there is no bytes representation for the token.
         */
        @JsonProperty("bytes") @ExcludeMissing fun _bytes(): JsonField<List<Long>> = bytes

        /**
         * The log probability of this token, if it is within the top 20 most likely tokens.
         * Otherwise, the value `-9999.0` is used to signify that the token is very unlikely.
         */
        @JsonProperty("logprob") @ExcludeMissing fun _logprob(): JsonField<Double> = logprob

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

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

            /** The token. */
            fun token(token: JsonField<String>) = apply { this.token = token }

            /**
             * A list of integers representing the UTF-8 bytes representation of the token. Useful
             * in instances where characters are represented by multiple tokens and their byte
             * representations must be combined to generate the correct text representation. Can be
             * `null` if there is no bytes representation for the token.
             */
            fun bytes(bytes: List<Long>?) = bytes(JsonField.ofNullable(bytes))

            /**
             * A list of integers representing the UTF-8 bytes representation of the token. Useful
             * in instances where characters are represented by multiple tokens and their byte
             * representations must be combined to generate the correct text representation. Can be
             * `null` if there is no bytes representation for the token.
             */
            fun bytes(bytes: Optional<List<Long>>) = bytes(bytes.getOrNull())

            /**
             * A list of integers representing the UTF-8 bytes representation of the token. Useful
             * in instances where characters are represented by multiple tokens and their byte
             * representations must be combined to generate the correct text representation. Can be
             * `null` if there is no bytes representation for the token.
             */
            fun bytes(bytes: JsonField<List<Long>>) = apply {
                this.bytes = bytes.map { it.toMutableList() }
            }

            /**
             * A list of integers representing the UTF-8 bytes representation of the token. Useful
             * in instances where characters are represented by multiple tokens and their byte
             * representations must be combined to generate the correct text representation. Can be
             * `null` if there is no bytes representation for the token.
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
             * The log probability of this token, if it is within the top 20 most likely tokens.
             * Otherwise, the value `-9999.0` is used to signify that the token is very unlikely.
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

            fun build(): TopLogprob =
                TopLogprob(
                    checkRequired("token", token),
                    checkRequired("bytes", bytes).map { it.toImmutable() },
                    checkRequired("logprob", logprob),
                    additionalProperties.toImmutable(),
                )
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
