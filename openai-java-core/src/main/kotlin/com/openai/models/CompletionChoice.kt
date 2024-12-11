// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

@JsonDeserialize(builder = CompletionChoice.Builder::class)
@NoAutoDetect
class CompletionChoice
private constructor(
    private val finishReason: JsonField<FinishReason>,
    private val index: JsonField<Long>,
    private val logprobs: JsonField<Logprobs>,
    private val text: JsonField<String>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    /**
     * The reason the model stopped generating tokens. This will be `stop` if the model hit a
     * natural stop point or a provided stop sequence, `length` if the maximum number of tokens
     * specified in the request was reached, or `content_filter` if content was omitted due to a
     * flag from our content filters.
     */
    fun finishReason(): FinishReason = finishReason.getRequired("finish_reason")

    fun index(): Long = index.getRequired("index")

    fun logprobs(): Optional<Logprobs> = Optional.ofNullable(logprobs.getNullable("logprobs"))

    fun text(): String = text.getRequired("text")

    /**
     * The reason the model stopped generating tokens. This will be `stop` if the model hit a
     * natural stop point or a provided stop sequence, `length` if the maximum number of tokens
     * specified in the request was reached, or `content_filter` if content was omitted due to a
     * flag from our content filters.
     */
    @JsonProperty("finish_reason") @ExcludeMissing fun _finishReason() = finishReason

    @JsonProperty("index") @ExcludeMissing fun _index() = index

    @JsonProperty("logprobs") @ExcludeMissing fun _logprobs() = logprobs

    @JsonProperty("text") @ExcludeMissing fun _text() = text

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): CompletionChoice = apply {
        if (!validated) {
            finishReason()
            index()
            logprobs().map { it.validate() }
            text()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var finishReason: JsonField<FinishReason> = JsonMissing.of()
        private var index: JsonField<Long> = JsonMissing.of()
        private var logprobs: JsonField<Logprobs> = JsonMissing.of()
        private var text: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(completionChoice: CompletionChoice) = apply {
            this.finishReason = completionChoice.finishReason
            this.index = completionChoice.index
            this.logprobs = completionChoice.logprobs
            this.text = completionChoice.text
            additionalProperties(completionChoice.additionalProperties)
        }

        /**
         * The reason the model stopped generating tokens. This will be `stop` if the model hit a
         * natural stop point or a provided stop sequence, `length` if the maximum number of tokens
         * specified in the request was reached, or `content_filter` if content was omitted due to a
         * flag from our content filters.
         */
        fun finishReason(finishReason: FinishReason) = finishReason(JsonField.of(finishReason))

        /**
         * The reason the model stopped generating tokens. This will be `stop` if the model hit a
         * natural stop point or a provided stop sequence, `length` if the maximum number of tokens
         * specified in the request was reached, or `content_filter` if content was omitted due to a
         * flag from our content filters.
         */
        @JsonProperty("finish_reason")
        @ExcludeMissing
        fun finishReason(finishReason: JsonField<FinishReason>) = apply {
            this.finishReason = finishReason
        }

        fun index(index: Long) = index(JsonField.of(index))

        @JsonProperty("index")
        @ExcludeMissing
        fun index(index: JsonField<Long>) = apply { this.index = index }

        fun logprobs(logprobs: Logprobs) = logprobs(JsonField.of(logprobs))

        @JsonProperty("logprobs")
        @ExcludeMissing
        fun logprobs(logprobs: JsonField<Logprobs>) = apply { this.logprobs = logprobs }

        fun text(text: String) = text(JsonField.of(text))

        @JsonProperty("text")
        @ExcludeMissing
        fun text(text: JsonField<String>) = apply { this.text = text }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            this.additionalProperties.putAll(additionalProperties)
        }

        @JsonAnySetter
        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            this.additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun build(): CompletionChoice =
            CompletionChoice(
                finishReason,
                index,
                logprobs,
                text,
                additionalProperties.toImmutable(),
            )
    }

    class FinishReason
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is FinishReason && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val STOP = of("stop")

            @JvmField val LENGTH = of("length")

            @JvmField val CONTENT_FILTER = of("content_filter")

            @JvmStatic fun of(value: String) = FinishReason(JsonField.of(value))
        }

        enum class Known {
            STOP,
            LENGTH,
            CONTENT_FILTER,
        }

        enum class Value {
            STOP,
            LENGTH,
            CONTENT_FILTER,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                STOP -> Value.STOP
                LENGTH -> Value.LENGTH
                CONTENT_FILTER -> Value.CONTENT_FILTER
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                STOP -> Known.STOP
                LENGTH -> Known.LENGTH
                CONTENT_FILTER -> Known.CONTENT_FILTER
                else -> throw OpenAIInvalidDataException("Unknown FinishReason: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    @JsonDeserialize(builder = Logprobs.Builder::class)
    @NoAutoDetect
    class Logprobs
    private constructor(
        private val textOffset: JsonField<List<Long>>,
        private val tokenLogprobs: JsonField<List<Double>>,
        private val tokens: JsonField<List<String>>,
        private val topLogprobs: JsonField<List<TopLogprob>>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        fun textOffset(): Optional<List<Long>> =
            Optional.ofNullable(textOffset.getNullable("text_offset"))

        fun tokenLogprobs(): Optional<List<Double>> =
            Optional.ofNullable(tokenLogprobs.getNullable("token_logprobs"))

        fun tokens(): Optional<List<String>> = Optional.ofNullable(tokens.getNullable("tokens"))

        fun topLogprobs(): Optional<List<TopLogprob>> =
            Optional.ofNullable(topLogprobs.getNullable("top_logprobs"))

        @JsonProperty("text_offset") @ExcludeMissing fun _textOffset() = textOffset

        @JsonProperty("token_logprobs") @ExcludeMissing fun _tokenLogprobs() = tokenLogprobs

        @JsonProperty("tokens") @ExcludeMissing fun _tokens() = tokens

        @JsonProperty("top_logprobs") @ExcludeMissing fun _topLogprobs() = topLogprobs

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Logprobs = apply {
            if (!validated) {
                textOffset()
                tokenLogprobs()
                tokens()
                topLogprobs().map { it.forEach { it.validate() } }
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var textOffset: JsonField<List<Long>> = JsonMissing.of()
            private var tokenLogprobs: JsonField<List<Double>> = JsonMissing.of()
            private var tokens: JsonField<List<String>> = JsonMissing.of()
            private var topLogprobs: JsonField<List<TopLogprob>> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(logprobs: Logprobs) = apply {
                this.textOffset = logprobs.textOffset
                this.tokenLogprobs = logprobs.tokenLogprobs
                this.tokens = logprobs.tokens
                this.topLogprobs = logprobs.topLogprobs
                additionalProperties(logprobs.additionalProperties)
            }

            fun textOffset(textOffset: List<Long>) = textOffset(JsonField.of(textOffset))

            @JsonProperty("text_offset")
            @ExcludeMissing
            fun textOffset(textOffset: JsonField<List<Long>>) = apply {
                this.textOffset = textOffset
            }

            fun tokenLogprobs(tokenLogprobs: List<Double>) =
                tokenLogprobs(JsonField.of(tokenLogprobs))

            @JsonProperty("token_logprobs")
            @ExcludeMissing
            fun tokenLogprobs(tokenLogprobs: JsonField<List<Double>>) = apply {
                this.tokenLogprobs = tokenLogprobs
            }

            fun tokens(tokens: List<String>) = tokens(JsonField.of(tokens))

            @JsonProperty("tokens")
            @ExcludeMissing
            fun tokens(tokens: JsonField<List<String>>) = apply { this.tokens = tokens }

            fun topLogprobs(topLogprobs: List<TopLogprob>) = topLogprobs(JsonField.of(topLogprobs))

            @JsonProperty("top_logprobs")
            @ExcludeMissing
            fun topLogprobs(topLogprobs: JsonField<List<TopLogprob>>) = apply {
                this.topLogprobs = topLogprobs
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                this.additionalProperties.putAll(additionalProperties)
            }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun build(): Logprobs =
                Logprobs(
                    textOffset.map { it.toImmutable() },
                    tokenLogprobs.map { it.toImmutable() },
                    tokens.map { it.toImmutable() },
                    topLogprobs.map { it.toImmutable() },
                    additionalProperties.toImmutable(),
                )
        }

        @JsonDeserialize(builder = TopLogprob.Builder::class)
        @NoAutoDetect
        class TopLogprob
        private constructor(
            private val additionalProperties: Map<String, JsonValue>,
        ) {

            private var validated: Boolean = false

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun validate(): TopLogprob = apply {
                if (!validated) {
                    validated = true
                }
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(topLogprob: TopLogprob) = apply {
                    additionalProperties(topLogprob.additionalProperties)
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    this.additionalProperties.putAll(additionalProperties)
                }

                @JsonAnySetter
                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    this.additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun build(): TopLogprob = TopLogprob(additionalProperties.toImmutable())
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
