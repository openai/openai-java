// File generated from our OpenAPI spec by Stainless.

package com.openai.models.completions

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
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

class CompletionChoice
private constructor(
    private val finishReason: JsonField<FinishReason>,
    private val index: JsonField<Long>,
    private val logprobs: JsonField<Logprobs>,
    private val text: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("finish_reason")
        @ExcludeMissing
        finishReason: JsonField<FinishReason> = JsonMissing.of(),
        @JsonProperty("index") @ExcludeMissing index: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("logprobs") @ExcludeMissing logprobs: JsonField<Logprobs> = JsonMissing.of(),
        @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
    ) : this(finishReason, index, logprobs, text, mutableMapOf())

    /**
     * The reason the model stopped generating tokens. This will be `stop` if the model hit a
     * natural stop point or a provided stop sequence, `length` if the maximum number of tokens
     * specified in the request was reached, or `content_filter` if content was omitted due to a
     * flag from our content filters.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun finishReason(): FinishReason = finishReason.getRequired("finish_reason")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun index(): Long = index.getRequired("index")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun logprobs(): Optional<Logprobs> = Optional.ofNullable(logprobs.getNullable("logprobs"))

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun text(): String = text.getRequired("text")

    /**
     * Returns the raw JSON value of [finishReason].
     *
     * Unlike [finishReason], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("finish_reason")
    @ExcludeMissing
    fun _finishReason(): JsonField<FinishReason> = finishReason

    /**
     * Returns the raw JSON value of [index].
     *
     * Unlike [index], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("index") @ExcludeMissing fun _index(): JsonField<Long> = index

    /**
     * Returns the raw JSON value of [logprobs].
     *
     * Unlike [logprobs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("logprobs") @ExcludeMissing fun _logprobs(): JsonField<Logprobs> = logprobs

    /**
     * Returns the raw JSON value of [text].
     *
     * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

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
         * Returns a mutable builder for constructing an instance of [CompletionChoice].
         *
         * The following fields are required:
         * ```java
         * .finishReason()
         * .index()
         * .logprobs()
         * .text()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CompletionChoice]. */
    class Builder internal constructor() {

        private var finishReason: JsonField<FinishReason>? = null
        private var index: JsonField<Long>? = null
        private var logprobs: JsonField<Logprobs>? = null
        private var text: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(completionChoice: CompletionChoice) = apply {
            finishReason = completionChoice.finishReason
            index = completionChoice.index
            logprobs = completionChoice.logprobs
            text = completionChoice.text
            additionalProperties = completionChoice.additionalProperties.toMutableMap()
        }

        /**
         * The reason the model stopped generating tokens. This will be `stop` if the model hit a
         * natural stop point or a provided stop sequence, `length` if the maximum number of tokens
         * specified in the request was reached, or `content_filter` if content was omitted due to a
         * flag from our content filters.
         */
        fun finishReason(finishReason: FinishReason) = finishReason(JsonField.of(finishReason))

        /**
         * Sets [Builder.finishReason] to an arbitrary JSON value.
         *
         * You should usually call [Builder.finishReason] with a well-typed [FinishReason] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun finishReason(finishReason: JsonField<FinishReason>) = apply {
            this.finishReason = finishReason
        }

        fun index(index: Long) = index(JsonField.of(index))

        /**
         * Sets [Builder.index] to an arbitrary JSON value.
         *
         * You should usually call [Builder.index] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun index(index: JsonField<Long>) = apply { this.index = index }

        fun logprobs(logprobs: Logprobs?) = logprobs(JsonField.ofNullable(logprobs))

        /** Alias for calling [Builder.logprobs] with `logprobs.orElse(null)`. */
        fun logprobs(logprobs: Optional<Logprobs>) = logprobs(logprobs.getOrNull())

        /**
         * Sets [Builder.logprobs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.logprobs] with a well-typed [Logprobs] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun logprobs(logprobs: JsonField<Logprobs>) = apply { this.logprobs = logprobs }

        fun text(text: String) = text(JsonField.of(text))

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun text(text: JsonField<String>) = apply { this.text = text }

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
         * Returns an immutable instance of [CompletionChoice].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .finishReason()
         * .index()
         * .logprobs()
         * .text()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CompletionChoice =
            CompletionChoice(
                checkRequired("finishReason", finishReason),
                checkRequired("index", index),
                checkRequired("logprobs", logprobs),
                checkRequired("text", text),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): CompletionChoice = apply {
        if (validated) {
            return@apply
        }

        finishReason()
        index()
        logprobs().ifPresent { it.validate() }
        text()
        validated = true
    }

    /**
     * The reason the model stopped generating tokens. This will be `stop` if the model hit a
     * natural stop point or a provided stop sequence, `length` if the maximum number of tokens
     * specified in the request was reached, or `content_filter` if content was omitted due to a
     * flag from our content filters.
     */
    class FinishReason @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val STOP = of("stop")

            @JvmField val LENGTH = of("length")

            @JvmField val CONTENT_FILTER = of("content_filter")

            @JvmStatic fun of(value: String) = FinishReason(JsonField.of(value))
        }

        /** An enum containing [FinishReason]'s known values. */
        enum class Known {
            STOP,
            LENGTH,
            CONTENT_FILTER,
        }

        /**
         * An enum containing [FinishReason]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [FinishReason] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            STOP,
            LENGTH,
            CONTENT_FILTER,
            /**
             * An enum member indicating that [FinishReason] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                STOP -> Value.STOP
                LENGTH -> Value.LENGTH
                CONTENT_FILTER -> Value.CONTENT_FILTER
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OpenAIInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                STOP -> Known.STOP
                LENGTH -> Known.LENGTH
                CONTENT_FILTER -> Known.CONTENT_FILTER
                else -> throw OpenAIInvalidDataException("Unknown FinishReason: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws OpenAIInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is FinishReason && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class Logprobs
    private constructor(
        private val textOffset: JsonField<List<Long>>,
        private val tokenLogprobs: JsonField<List<Double>>,
        private val tokens: JsonField<List<String>>,
        private val topLogprobs: JsonField<List<TopLogprob>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("text_offset")
            @ExcludeMissing
            textOffset: JsonField<List<Long>> = JsonMissing.of(),
            @JsonProperty("token_logprobs")
            @ExcludeMissing
            tokenLogprobs: JsonField<List<Double>> = JsonMissing.of(),
            @JsonProperty("tokens")
            @ExcludeMissing
            tokens: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("top_logprobs")
            @ExcludeMissing
            topLogprobs: JsonField<List<TopLogprob>> = JsonMissing.of(),
        ) : this(textOffset, tokenLogprobs, tokens, topLogprobs, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun textOffset(): Optional<List<Long>> =
            Optional.ofNullable(textOffset.getNullable("text_offset"))

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun tokenLogprobs(): Optional<List<Double>> =
            Optional.ofNullable(tokenLogprobs.getNullable("token_logprobs"))

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun tokens(): Optional<List<String>> = Optional.ofNullable(tokens.getNullable("tokens"))

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun topLogprobs(): Optional<List<TopLogprob>> =
            Optional.ofNullable(topLogprobs.getNullable("top_logprobs"))

        /**
         * Returns the raw JSON value of [textOffset].
         *
         * Unlike [textOffset], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("text_offset")
        @ExcludeMissing
        fun _textOffset(): JsonField<List<Long>> = textOffset

        /**
         * Returns the raw JSON value of [tokenLogprobs].
         *
         * Unlike [tokenLogprobs], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("token_logprobs")
        @ExcludeMissing
        fun _tokenLogprobs(): JsonField<List<Double>> = tokenLogprobs

        /**
         * Returns the raw JSON value of [tokens].
         *
         * Unlike [tokens], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tokens") @ExcludeMissing fun _tokens(): JsonField<List<String>> = tokens

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

            /** Returns a mutable builder for constructing an instance of [Logprobs]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Logprobs]. */
        class Builder internal constructor() {

            private var textOffset: JsonField<MutableList<Long>>? = null
            private var tokenLogprobs: JsonField<MutableList<Double>>? = null
            private var tokens: JsonField<MutableList<String>>? = null
            private var topLogprobs: JsonField<MutableList<TopLogprob>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(logprobs: Logprobs) = apply {
                textOffset = logprobs.textOffset.map { it.toMutableList() }
                tokenLogprobs = logprobs.tokenLogprobs.map { it.toMutableList() }
                tokens = logprobs.tokens.map { it.toMutableList() }
                topLogprobs = logprobs.topLogprobs.map { it.toMutableList() }
                additionalProperties = logprobs.additionalProperties.toMutableMap()
            }

            fun textOffset(textOffset: List<Long>) = textOffset(JsonField.of(textOffset))

            /**
             * Sets [Builder.textOffset] to an arbitrary JSON value.
             *
             * You should usually call [Builder.textOffset] with a well-typed `List<Long>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun textOffset(textOffset: JsonField<List<Long>>) = apply {
                this.textOffset = textOffset.map { it.toMutableList() }
            }

            /**
             * Adds a single [Long] to [Builder.textOffset].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTextOffset(textOffset: Long) = apply {
                this.textOffset =
                    (this.textOffset ?: JsonField.of(mutableListOf())).also {
                        checkKnown("textOffset", it).add(textOffset)
                    }
            }

            fun tokenLogprobs(tokenLogprobs: List<Double>) =
                tokenLogprobs(JsonField.of(tokenLogprobs))

            /**
             * Sets [Builder.tokenLogprobs] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tokenLogprobs] with a well-typed `List<Double>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun tokenLogprobs(tokenLogprobs: JsonField<List<Double>>) = apply {
                this.tokenLogprobs = tokenLogprobs.map { it.toMutableList() }
            }

            /**
             * Adds a single [Double] to [tokenLogprobs].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTokenLogprob(tokenLogprob: Double) = apply {
                tokenLogprobs =
                    (tokenLogprobs ?: JsonField.of(mutableListOf())).also {
                        checkKnown("tokenLogprobs", it).add(tokenLogprob)
                    }
            }

            fun tokens(tokens: List<String>) = tokens(JsonField.of(tokens))

            /**
             * Sets [Builder.tokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tokens] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tokens(tokens: JsonField<List<String>>) = apply {
                this.tokens = tokens.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [tokens].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addToken(token: String) = apply {
                tokens =
                    (tokens ?: JsonField.of(mutableListOf())).also {
                        checkKnown("tokens", it).add(token)
                    }
            }

            fun topLogprobs(topLogprobs: List<TopLogprob>) = topLogprobs(JsonField.of(topLogprobs))

            /**
             * Sets [Builder.topLogprobs] to an arbitrary JSON value.
             *
             * You should usually call [Builder.topLogprobs] with a well-typed `List<TopLogprob>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
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
             * Returns an immutable instance of [Logprobs].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Logprobs =
                Logprobs(
                    (textOffset ?: JsonMissing.of()).map { it.toImmutable() },
                    (tokenLogprobs ?: JsonMissing.of()).map { it.toImmutable() },
                    (tokens ?: JsonMissing.of()).map { it.toImmutable() },
                    (topLogprobs ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Logprobs = apply {
            if (validated) {
                return@apply
            }

            textOffset()
            tokenLogprobs()
            tokens()
            topLogprobs().ifPresent { it.forEach { it.validate() } }
            validated = true
        }

        class TopLogprob
        @JsonCreator
        private constructor(
            @com.fasterxml.jackson.annotation.JsonValue
            private val additionalProperties: Map<String, JsonValue>
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [TopLogprob]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [TopLogprob]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(topLogprob: TopLogprob) = apply {
                    additionalProperties = topLogprob.additionalProperties.toMutableMap()
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [TopLogprob].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): TopLogprob = TopLogprob(additionalProperties.toImmutable())
            }

            private var validated: Boolean = false

            fun validate(): TopLogprob = apply {
                if (validated) {
                    return@apply
                }

                validated = true
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is TopLogprob && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() = "TopLogprob{additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Logprobs && textOffset == other.textOffset && tokenLogprobs == other.tokenLogprobs && tokens == other.tokens && topLogprobs == other.topLogprobs && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(textOffset, tokenLogprobs, tokens, topLogprobs, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Logprobs{textOffset=$textOffset, tokenLogprobs=$tokenLogprobs, tokens=$tokens, topLogprobs=$topLogprobs, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is CompletionChoice && finishReason == other.finishReason && index == other.index && logprobs == other.logprobs && text == other.text && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(finishReason, index, logprobs, text, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CompletionChoice{finishReason=$finishReason, index=$index, logprobs=$logprobs, text=$text, additionalProperties=$additionalProperties}"
}
