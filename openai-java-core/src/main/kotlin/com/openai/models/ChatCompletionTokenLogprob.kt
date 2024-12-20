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
import java.util.Optional

@NoAutoDetect
class ChatCompletionTokenLogprob
@JsonCreator
private constructor(
    @JsonProperty("token") @ExcludeMissing private val token: JsonField<String> = JsonMissing.of(),
    @JsonProperty("logprob")
    @ExcludeMissing
    private val logprob: JsonField<Double> = JsonMissing.of(),
    @JsonProperty("bytes")
    @ExcludeMissing
    private val bytes: JsonField<List<Long>> = JsonMissing.of(),
    @JsonProperty("top_logprobs")
    @ExcludeMissing
    private val topLogprobs: JsonField<List<TopLogprob>> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The token. */
    fun token(): String = token.getRequired("token")

    /**
     * The log probability of this token, if it is within the top 20 most likely tokens. Otherwise,
     * the value `-9999.0` is used to signify that the token is very unlikely.
     */
    fun logprob(): Double = logprob.getRequired("logprob")

    /**
     * A list of integers representing the UTF-8 bytes representation of the token. Useful in
     * instances where characters are represented by multiple tokens and their byte representations
     * must be combined to generate the correct text representation. Can be `null` if there is no
     * bytes representation for the token.
     */
    fun bytes(): Optional<List<Long>> = Optional.ofNullable(bytes.getNullable("bytes"))

    /**
     * List of the most likely tokens and their log probability, at this token position. In rare
     * cases, there may be fewer than the number of requested `top_logprobs` returned.
     */
    fun topLogprobs(): List<TopLogprob> = topLogprobs.getRequired("top_logprobs")

    /** The token. */
    @JsonProperty("token") @ExcludeMissing fun _token() = token

    /**
     * The log probability of this token, if it is within the top 20 most likely tokens. Otherwise,
     * the value `-9999.0` is used to signify that the token is very unlikely.
     */
    @JsonProperty("logprob") @ExcludeMissing fun _logprob() = logprob

    /**
     * A list of integers representing the UTF-8 bytes representation of the token. Useful in
     * instances where characters are represented by multiple tokens and their byte representations
     * must be combined to generate the correct text representation. Can be `null` if there is no
     * bytes representation for the token.
     */
    @JsonProperty("bytes") @ExcludeMissing fun _bytes() = bytes

    /**
     * List of the most likely tokens and their log probability, at this token position. In rare
     * cases, there may be fewer than the number of requested `top_logprobs` returned.
     */
    @JsonProperty("top_logprobs") @ExcludeMissing fun _topLogprobs() = topLogprobs

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ChatCompletionTokenLogprob = apply {
        if (!validated) {
            token()
            logprob()
            bytes()
            topLogprobs().forEach { it.validate() }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var token: JsonField<String> = JsonMissing.of()
        private var logprob: JsonField<Double> = JsonMissing.of()
        private var bytes: JsonField<List<Long>> = JsonMissing.of()
        private var topLogprobs: JsonField<List<TopLogprob>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletionTokenLogprob: ChatCompletionTokenLogprob) = apply {
            token = chatCompletionTokenLogprob.token
            logprob = chatCompletionTokenLogprob.logprob
            bytes = chatCompletionTokenLogprob.bytes
            topLogprobs = chatCompletionTokenLogprob.topLogprobs
            additionalProperties = chatCompletionTokenLogprob.additionalProperties.toMutableMap()
        }

        /** The token. */
        fun token(token: String) = token(JsonField.of(token))

        /** The token. */
        fun token(token: JsonField<String>) = apply { this.token = token }

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
         * A list of integers representing the UTF-8 bytes representation of the token. Useful in
         * instances where characters are represented by multiple tokens and their byte
         * representations must be combined to generate the correct text representation. Can be
         * `null` if there is no bytes representation for the token.
         */
        fun bytes(bytes: List<Long>) = bytes(JsonField.of(bytes))

        /**
         * A list of integers representing the UTF-8 bytes representation of the token. Useful in
         * instances where characters are represented by multiple tokens and their byte
         * representations must be combined to generate the correct text representation. Can be
         * `null` if there is no bytes representation for the token.
         */
        fun bytes(bytes: JsonField<List<Long>>) = apply { this.bytes = bytes }

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
            this.topLogprobs = topLogprobs
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
                token,
                logprob,
                bytes.map { it.toImmutable() },
                topLogprobs.map { it.toImmutable() },
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
        @JsonProperty("logprob")
        @ExcludeMissing
        private val logprob: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("bytes")
        @ExcludeMissing
        private val bytes: JsonField<List<Long>> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The token. */
        fun token(): String = token.getRequired("token")

        /**
         * The log probability of this token, if it is within the top 20 most likely tokens.
         * Otherwise, the value `-9999.0` is used to signify that the token is very unlikely.
         */
        fun logprob(): Double = logprob.getRequired("logprob")

        /**
         * A list of integers representing the UTF-8 bytes representation of the token. Useful in
         * instances where characters are represented by multiple tokens and their byte
         * representations must be combined to generate the correct text representation. Can be
         * `null` if there is no bytes representation for the token.
         */
        fun bytes(): Optional<List<Long>> = Optional.ofNullable(bytes.getNullable("bytes"))

        /** The token. */
        @JsonProperty("token") @ExcludeMissing fun _token() = token

        /**
         * The log probability of this token, if it is within the top 20 most likely tokens.
         * Otherwise, the value `-9999.0` is used to signify that the token is very unlikely.
         */
        @JsonProperty("logprob") @ExcludeMissing fun _logprob() = logprob

        /**
         * A list of integers representing the UTF-8 bytes representation of the token. Useful in
         * instances where characters are represented by multiple tokens and their byte
         * representations must be combined to generate the correct text representation. Can be
         * `null` if there is no bytes representation for the token.
         */
        @JsonProperty("bytes") @ExcludeMissing fun _bytes() = bytes

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): TopLogprob = apply {
            if (!validated) {
                token()
                logprob()
                bytes()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var token: JsonField<String> = JsonMissing.of()
            private var logprob: JsonField<Double> = JsonMissing.of()
            private var bytes: JsonField<List<Long>> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(topLogprob: TopLogprob) = apply {
                token = topLogprob.token
                logprob = topLogprob.logprob
                bytes = topLogprob.bytes
                additionalProperties = topLogprob.additionalProperties.toMutableMap()
            }

            /** The token. */
            fun token(token: String) = token(JsonField.of(token))

            /** The token. */
            fun token(token: JsonField<String>) = apply { this.token = token }

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
             * A list of integers representing the UTF-8 bytes representation of the token. Useful
             * in instances where characters are represented by multiple tokens and their byte
             * representations must be combined to generate the correct text representation. Can be
             * `null` if there is no bytes representation for the token.
             */
            fun bytes(bytes: List<Long>) = bytes(JsonField.of(bytes))

            /**
             * A list of integers representing the UTF-8 bytes representation of the token. Useful
             * in instances where characters are represented by multiple tokens and their byte
             * representations must be combined to generate the correct text representation. Can be
             * `null` if there is no bytes representation for the token.
             */
            fun bytes(bytes: JsonField<List<Long>>) = apply { this.bytes = bytes }

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
                    token,
                    logprob,
                    bytes.map { it.toImmutable() },
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is TopLogprob && token == other.token && logprob == other.logprob && bytes == other.bytes && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(token, logprob, bytes, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "TopLogprob{token=$token, logprob=$logprob, bytes=$bytes, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionTokenLogprob && token == other.token && logprob == other.logprob && bytes == other.bytes && topLogprobs == other.topLogprobs && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(token, logprob, bytes, topLogprobs, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatCompletionTokenLogprob{token=$token, logprob=$logprob, bytes=$bytes, topLogprobs=$topLogprobs, additionalProperties=$additionalProperties}"
}
