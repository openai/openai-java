// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.checkRequired
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/** Represents a chat completion response returned by model, based on the provided input. */
@NoAutoDetect
class ChatCompletion
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("choices")
    @ExcludeMissing
    private val choices: JsonField<List<Choice>> = JsonMissing.of(),
    @JsonProperty("created")
    @ExcludeMissing
    private val created: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("model") @ExcludeMissing private val model: JsonField<String> = JsonMissing.of(),
    @JsonProperty("object") @ExcludeMissing private val object_: JsonValue = JsonMissing.of(),
    @JsonProperty("service_tier")
    @ExcludeMissing
    private val serviceTier: JsonField<ServiceTier> = JsonMissing.of(),
    @JsonProperty("system_fingerprint")
    @ExcludeMissing
    private val systemFingerprint: JsonField<String> = JsonMissing.of(),
    @JsonProperty("usage")
    @ExcludeMissing
    private val usage: JsonField<CompletionUsage> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** A unique identifier for the chat completion. */
    fun id(): String = id.getRequired("id")

    /** A list of chat completion choices. Can be more than one if `n` is greater than 1. */
    fun choices(): List<Choice> = choices.getRequired("choices")

    /** The Unix timestamp (in seconds) of when the chat completion was created. */
    fun created(): Long = created.getRequired("created")

    /** The model used for the chat completion. */
    fun model(): String = model.getRequired("model")

    /** The object type, which is always `chat.completion`. */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /** The service tier used for processing the request. */
    fun serviceTier(): Optional<ServiceTier> =
        Optional.ofNullable(serviceTier.getNullable("service_tier"))

    /**
     * This fingerprint represents the backend configuration that the model runs with.
     *
     * Can be used in conjunction with the `seed` request parameter to understand when backend
     * changes have been made that might impact determinism.
     */
    fun systemFingerprint(): Optional<String> =
        Optional.ofNullable(systemFingerprint.getNullable("system_fingerprint"))

    /** Usage statistics for the completion request. */
    fun usage(): Optional<CompletionUsage> = Optional.ofNullable(usage.getNullable("usage"))

    /** A unique identifier for the chat completion. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** A list of chat completion choices. Can be more than one if `n` is greater than 1. */
    @JsonProperty("choices") @ExcludeMissing fun _choices(): JsonField<List<Choice>> = choices

    /** The Unix timestamp (in seconds) of when the chat completion was created. */
    @JsonProperty("created") @ExcludeMissing fun _created(): JsonField<Long> = created

    /** The model used for the chat completion. */
    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

    /** The service tier used for processing the request. */
    @JsonProperty("service_tier")
    @ExcludeMissing
    fun _serviceTier(): JsonField<ServiceTier> = serviceTier

    /**
     * This fingerprint represents the backend configuration that the model runs with.
     *
     * Can be used in conjunction with the `seed` request parameter to understand when backend
     * changes have been made that might impact determinism.
     */
    @JsonProperty("system_fingerprint")
    @ExcludeMissing
    fun _systemFingerprint(): JsonField<String> = systemFingerprint

    /** Usage statistics for the completion request. */
    @JsonProperty("usage") @ExcludeMissing fun _usage(): JsonField<CompletionUsage> = usage

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ChatCompletion = apply {
        if (validated) {
            return@apply
        }

        id()
        choices().forEach { it.validate() }
        created()
        model()
        _object_().let {
            if (it != JsonValue.from("chat.completion")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        serviceTier()
        systemFingerprint()
        usage().ifPresent { it.validate() }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var choices: JsonField<MutableList<Choice>>? = null
        private var created: JsonField<Long>? = null
        private var model: JsonField<String>? = null
        private var object_: JsonValue = JsonValue.from("chat.completion")
        private var serviceTier: JsonField<ServiceTier> = JsonMissing.of()
        private var systemFingerprint: JsonField<String> = JsonMissing.of()
        private var usage: JsonField<CompletionUsage> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletion: ChatCompletion) = apply {
            id = chatCompletion.id
            choices = chatCompletion.choices.map { it.toMutableList() }
            created = chatCompletion.created
            model = chatCompletion.model
            object_ = chatCompletion.object_
            serviceTier = chatCompletion.serviceTier
            systemFingerprint = chatCompletion.systemFingerprint
            usage = chatCompletion.usage
            additionalProperties = chatCompletion.additionalProperties.toMutableMap()
        }

        /** A unique identifier for the chat completion. */
        fun id(id: String) = id(JsonField.of(id))

        /** A unique identifier for the chat completion. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** A list of chat completion choices. Can be more than one if `n` is greater than 1. */
        fun choices(choices: List<Choice>) = choices(JsonField.of(choices))

        /** A list of chat completion choices. Can be more than one if `n` is greater than 1. */
        fun choices(choices: JsonField<List<Choice>>) = apply {
            this.choices = choices.map { it.toMutableList() }
        }

        /** A list of chat completion choices. Can be more than one if `n` is greater than 1. */
        fun addChoice(choice: Choice) = apply {
            choices =
                (choices ?: JsonField.of(mutableListOf())).apply {
                    asKnown()
                        .orElseThrow {
                            IllegalStateException(
                                "Field was set to non-list type: ${javaClass.simpleName}"
                            )
                        }
                        .add(choice)
                }
        }

        /** The Unix timestamp (in seconds) of when the chat completion was created. */
        fun created(created: Long) = created(JsonField.of(created))

        /** The Unix timestamp (in seconds) of when the chat completion was created. */
        fun created(created: JsonField<Long>) = apply { this.created = created }

        /** The model used for the chat completion. */
        fun model(model: String) = model(JsonField.of(model))

        /** The model used for the chat completion. */
        fun model(model: JsonField<String>) = apply { this.model = model }

        /** The object type, which is always `chat.completion`. */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /** The service tier used for processing the request. */
        fun serviceTier(serviceTier: ServiceTier?) = serviceTier(JsonField.ofNullable(serviceTier))

        /** The service tier used for processing the request. */
        fun serviceTier(serviceTier: Optional<ServiceTier>) = serviceTier(serviceTier.orElse(null))

        /** The service tier used for processing the request. */
        fun serviceTier(serviceTier: JsonField<ServiceTier>) = apply {
            this.serviceTier = serviceTier
        }

        /**
         * This fingerprint represents the backend configuration that the model runs with.
         *
         * Can be used in conjunction with the `seed` request parameter to understand when backend
         * changes have been made that might impact determinism.
         */
        fun systemFingerprint(systemFingerprint: String) =
            systemFingerprint(JsonField.of(systemFingerprint))

        /**
         * This fingerprint represents the backend configuration that the model runs with.
         *
         * Can be used in conjunction with the `seed` request parameter to understand when backend
         * changes have been made that might impact determinism.
         */
        fun systemFingerprint(systemFingerprint: JsonField<String>) = apply {
            this.systemFingerprint = systemFingerprint
        }

        /** Usage statistics for the completion request. */
        fun usage(usage: CompletionUsage) = usage(JsonField.of(usage))

        /** Usage statistics for the completion request. */
        fun usage(usage: JsonField<CompletionUsage>) = apply { this.usage = usage }

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

        fun build(): ChatCompletion =
            ChatCompletion(
                checkRequired("id", id),
                checkRequired("choices", choices).map { it.toImmutable() },
                checkRequired("created", created),
                checkRequired("model", model),
                object_,
                serviceTier,
                systemFingerprint,
                usage,
                additionalProperties.toImmutable(),
            )
    }

    @NoAutoDetect
    class Choice
    @JsonCreator
    private constructor(
        @JsonProperty("finish_reason")
        @ExcludeMissing
        private val finishReason: JsonField<FinishReason> = JsonMissing.of(),
        @JsonProperty("index")
        @ExcludeMissing
        private val index: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("logprobs")
        @ExcludeMissing
        private val logprobs: JsonField<Logprobs> = JsonMissing.of(),
        @JsonProperty("message")
        @ExcludeMissing
        private val message: JsonField<ChatCompletionMessage> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * The reason the model stopped generating tokens. This will be `stop` if the model hit a
         * natural stop point or a provided stop sequence, `length` if the maximum number of tokens
         * specified in the request was reached, `content_filter` if content was omitted due to a
         * flag from our content filters, `tool_calls` if the model called a tool, or
         * `function_call` (deprecated) if the model called a function.
         */
        fun finishReason(): FinishReason = finishReason.getRequired("finish_reason")

        /** The index of the choice in the list of choices. */
        fun index(): Long = index.getRequired("index")

        /** Log probability information for the choice. */
        fun logprobs(): Optional<Logprobs> = Optional.ofNullable(logprobs.getNullable("logprobs"))

        /** A chat completion message generated by the model. */
        fun message(): ChatCompletionMessage = message.getRequired("message")

        /**
         * The reason the model stopped generating tokens. This will be `stop` if the model hit a
         * natural stop point or a provided stop sequence, `length` if the maximum number of tokens
         * specified in the request was reached, `content_filter` if content was omitted due to a
         * flag from our content filters, `tool_calls` if the model called a tool, or
         * `function_call` (deprecated) if the model called a function.
         */
        @JsonProperty("finish_reason")
        @ExcludeMissing
        fun _finishReason(): JsonField<FinishReason> = finishReason

        /** The index of the choice in the list of choices. */
        @JsonProperty("index") @ExcludeMissing fun _index(): JsonField<Long> = index

        /** Log probability information for the choice. */
        @JsonProperty("logprobs") @ExcludeMissing fun _logprobs(): JsonField<Logprobs> = logprobs

        /** A chat completion message generated by the model. */
        @JsonProperty("message")
        @ExcludeMissing
        fun _message(): JsonField<ChatCompletionMessage> = message

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Choice = apply {
            if (validated) {
                return@apply
            }

            finishReason()
            index()
            logprobs().ifPresent { it.validate() }
            message().validate()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder internal constructor() {

            private var finishReason: JsonField<FinishReason>? = null
            private var index: JsonField<Long>? = null
            private var logprobs: JsonField<Logprobs>? = null
            private var message: JsonField<ChatCompletionMessage>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(choice: Choice) = apply {
                finishReason = choice.finishReason
                index = choice.index
                logprobs = choice.logprobs
                message = choice.message
                additionalProperties = choice.additionalProperties.toMutableMap()
            }

            /**
             * The reason the model stopped generating tokens. This will be `stop` if the model hit
             * a natural stop point or a provided stop sequence, `length` if the maximum number of
             * tokens specified in the request was reached, `content_filter` if content was omitted
             * due to a flag from our content filters, `tool_calls` if the model called a tool, or
             * `function_call` (deprecated) if the model called a function.
             */
            fun finishReason(finishReason: FinishReason) = finishReason(JsonField.of(finishReason))

            /**
             * The reason the model stopped generating tokens. This will be `stop` if the model hit
             * a natural stop point or a provided stop sequence, `length` if the maximum number of
             * tokens specified in the request was reached, `content_filter` if content was omitted
             * due to a flag from our content filters, `tool_calls` if the model called a tool, or
             * `function_call` (deprecated) if the model called a function.
             */
            fun finishReason(finishReason: JsonField<FinishReason>) = apply {
                this.finishReason = finishReason
            }

            /** The index of the choice in the list of choices. */
            fun index(index: Long) = index(JsonField.of(index))

            /** The index of the choice in the list of choices. */
            fun index(index: JsonField<Long>) = apply { this.index = index }

            /** Log probability information for the choice. */
            fun logprobs(logprobs: Logprobs?) = logprobs(JsonField.ofNullable(logprobs))

            /** Log probability information for the choice. */
            fun logprobs(logprobs: Optional<Logprobs>) = logprobs(logprobs.orElse(null))

            /** Log probability information for the choice. */
            fun logprobs(logprobs: JsonField<Logprobs>) = apply { this.logprobs = logprobs }

            /** A chat completion message generated by the model. */
            fun message(message: ChatCompletionMessage) = message(JsonField.of(message))

            /** A chat completion message generated by the model. */
            fun message(message: JsonField<ChatCompletionMessage>) = apply {
                this.message = message
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

            fun build(): Choice =
                Choice(
                    checkRequired("finishReason", finishReason),
                    checkRequired("index", index),
                    checkRequired("logprobs", logprobs),
                    checkRequired("message", message),
                    additionalProperties.toImmutable(),
                )
        }

        /**
         * The reason the model stopped generating tokens. This will be `stop` if the model hit a
         * natural stop point or a provided stop sequence, `length` if the maximum number of tokens
         * specified in the request was reached, `content_filter` if content was omitted due to a
         * flag from our content filters, `tool_calls` if the model called a tool, or
         * `function_call` (deprecated) if the model called a function.
         */
        class FinishReason
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val STOP = of("stop")

                @JvmField val LENGTH = of("length")

                @JvmField val TOOL_CALLS = of("tool_calls")

                @JvmField val CONTENT_FILTER = of("content_filter")

                @JvmField val FUNCTION_CALL = of("function_call")

                @JvmStatic fun of(value: String) = FinishReason(JsonField.of(value))
            }

            enum class Known {
                STOP,
                LENGTH,
                TOOL_CALLS,
                CONTENT_FILTER,
                FUNCTION_CALL,
            }

            enum class Value {
                STOP,
                LENGTH,
                TOOL_CALLS,
                CONTENT_FILTER,
                FUNCTION_CALL,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    STOP -> Value.STOP
                    LENGTH -> Value.LENGTH
                    TOOL_CALLS -> Value.TOOL_CALLS
                    CONTENT_FILTER -> Value.CONTENT_FILTER
                    FUNCTION_CALL -> Value.FUNCTION_CALL
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    STOP -> Known.STOP
                    LENGTH -> Known.LENGTH
                    TOOL_CALLS -> Known.TOOL_CALLS
                    CONTENT_FILTER -> Known.CONTENT_FILTER
                    FUNCTION_CALL -> Known.FUNCTION_CALL
                    else -> throw OpenAIInvalidDataException("Unknown FinishReason: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is FinishReason && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /** Log probability information for the choice. */
        @NoAutoDetect
        class Logprobs
        @JsonCreator
        private constructor(
            @JsonProperty("content")
            @ExcludeMissing
            private val content: JsonField<List<ChatCompletionTokenLogprob>> = JsonMissing.of(),
            @JsonProperty("refusal")
            @ExcludeMissing
            private val refusal: JsonField<List<ChatCompletionTokenLogprob>> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /** A list of message content tokens with log probability information. */
            fun content(): Optional<List<ChatCompletionTokenLogprob>> =
                Optional.ofNullable(content.getNullable("content"))

            /** A list of message refusal tokens with log probability information. */
            fun refusal(): Optional<List<ChatCompletionTokenLogprob>> =
                Optional.ofNullable(refusal.getNullable("refusal"))

            /** A list of message content tokens with log probability information. */
            @JsonProperty("content")
            @ExcludeMissing
            fun _content(): JsonField<List<ChatCompletionTokenLogprob>> = content

            /** A list of message refusal tokens with log probability information. */
            @JsonProperty("refusal")
            @ExcludeMissing
            fun _refusal(): JsonField<List<ChatCompletionTokenLogprob>> = refusal

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): Logprobs = apply {
                if (validated) {
                    return@apply
                }

                content().ifPresent { it.forEach { it.validate() } }
                refusal().ifPresent { it.forEach { it.validate() } }
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder internal constructor() {

                private var content: JsonField<MutableList<ChatCompletionTokenLogprob>>? = null
                private var refusal: JsonField<MutableList<ChatCompletionTokenLogprob>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(logprobs: Logprobs) = apply {
                    content = logprobs.content.map { it.toMutableList() }
                    refusal = logprobs.refusal.map { it.toMutableList() }
                    additionalProperties = logprobs.additionalProperties.toMutableMap()
                }

                /** A list of message content tokens with log probability information. */
                fun content(content: List<ChatCompletionTokenLogprob>?) =
                    content(JsonField.ofNullable(content))

                /** A list of message content tokens with log probability information. */
                fun content(content: Optional<List<ChatCompletionTokenLogprob>>) =
                    content(content.orElse(null))

                /** A list of message content tokens with log probability information. */
                fun content(content: JsonField<List<ChatCompletionTokenLogprob>>) = apply {
                    this.content = content.map { it.toMutableList() }
                }

                /** A list of message content tokens with log probability information. */
                fun addContent(content: ChatCompletionTokenLogprob) = apply {
                    this.content =
                        (this.content ?: JsonField.of(mutableListOf())).apply {
                            asKnown()
                                .orElseThrow {
                                    IllegalStateException(
                                        "Field was set to non-list type: ${javaClass.simpleName}"
                                    )
                                }
                                .add(content)
                        }
                }

                /** A list of message refusal tokens with log probability information. */
                fun refusal(refusal: List<ChatCompletionTokenLogprob>?) =
                    refusal(JsonField.ofNullable(refusal))

                /** A list of message refusal tokens with log probability information. */
                fun refusal(refusal: Optional<List<ChatCompletionTokenLogprob>>) =
                    refusal(refusal.orElse(null))

                /** A list of message refusal tokens with log probability information. */
                fun refusal(refusal: JsonField<List<ChatCompletionTokenLogprob>>) = apply {
                    this.refusal = refusal.map { it.toMutableList() }
                }

                /** A list of message refusal tokens with log probability information. */
                fun addRefusal(refusal: ChatCompletionTokenLogprob) = apply {
                    this.refusal =
                        (this.refusal ?: JsonField.of(mutableListOf())).apply {
                            asKnown()
                                .orElseThrow {
                                    IllegalStateException(
                                        "Field was set to non-list type: ${javaClass.simpleName}"
                                    )
                                }
                                .add(refusal)
                        }
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

                fun build(): Logprobs =
                    Logprobs(
                        checkRequired("content", content).map { it.toImmutable() },
                        checkRequired("refusal", refusal).map { it.toImmutable() },
                        additionalProperties.toImmutable(),
                    )
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Logprobs && content == other.content && refusal == other.refusal && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(content, refusal, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Logprobs{content=$content, refusal=$refusal, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Choice && finishReason == other.finishReason && index == other.index && logprobs == other.logprobs && message == other.message && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(finishReason, index, logprobs, message, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Choice{finishReason=$finishReason, index=$index, logprobs=$logprobs, message=$message, additionalProperties=$additionalProperties}"
    }

    /** The service tier used for processing the request. */
    class ServiceTier
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val SCALE = of("scale")

            @JvmField val DEFAULT = of("default")

            @JvmStatic fun of(value: String) = ServiceTier(JsonField.of(value))
        }

        enum class Known {
            SCALE,
            DEFAULT,
        }

        enum class Value {
            SCALE,
            DEFAULT,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                SCALE -> Value.SCALE
                DEFAULT -> Value.DEFAULT
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                SCALE -> Known.SCALE
                DEFAULT -> Known.DEFAULT
                else -> throw OpenAIInvalidDataException("Unknown ServiceTier: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ServiceTier && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletion && id == other.id && choices == other.choices && created == other.created && model == other.model && object_ == other.object_ && serviceTier == other.serviceTier && systemFingerprint == other.systemFingerprint && usage == other.usage && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, choices, created, model, object_, serviceTier, systemFingerprint, usage, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatCompletion{id=$id, choices=$choices, created=$created, model=$model, object_=$object_, serviceTier=$serviceTier, systemFingerprint=$systemFingerprint, usage=$usage, additionalProperties=$additionalProperties}"
}
