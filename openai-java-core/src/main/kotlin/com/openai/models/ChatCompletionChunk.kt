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

/**
 * Represents a streamed chunk of a chat completion response returned by model, based on the
 * provided input.
 */
@JsonDeserialize(builder = ChatCompletionChunk.Builder::class)
@NoAutoDetect
class ChatCompletionChunk
private constructor(
    private val id: JsonField<String>,
    private val choices: JsonField<List<Choice>>,
    private val created: JsonField<Long>,
    private val model: JsonField<String>,
    private val serviceTier: JsonField<ServiceTier>,
    private val systemFingerprint: JsonField<String>,
    private val object_: JsonField<Object>,
    private val usage: JsonField<CompletionUsage>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    /** A unique identifier for the chat completion. Each chunk has the same ID. */
    fun id(): String = id.getRequired("id")

    /**
     * A list of chat completion choices. Can contain more than one elements if `n` is greater
     * than 1. Can also be empty for the last chunk if you set `stream_options: {"include_usage":
     * true}`.
     */
    fun choices(): List<Choice> = choices.getRequired("choices")

    /**
     * The Unix timestamp (in seconds) of when the chat completion was created. Each chunk has the
     * same timestamp.
     */
    fun created(): Long = created.getRequired("created")

    /** The model to generate the completion. */
    fun model(): String = model.getRequired("model")

    /**
     * The service tier used for processing the request. This field is only included if the
     * `service_tier` parameter is specified in the request.
     */
    fun serviceTier(): Optional<ServiceTier> =
        Optional.ofNullable(serviceTier.getNullable("service_tier"))

    /**
     * This fingerprint represents the backend configuration that the model runs with. Can be used
     * in conjunction with the `seed` request parameter to understand when backend changes have been
     * made that might impact determinism.
     */
    fun systemFingerprint(): Optional<String> =
        Optional.ofNullable(systemFingerprint.getNullable("system_fingerprint"))

    /** The object type, which is always `chat.completion.chunk`. */
    fun object_(): Object = object_.getRequired("object")

    /**
     * An optional field that will only be present when you set `stream_options: {"include_usage":
     * true}` in your request. When present, it contains a null value except for the last chunk
     * which contains the token usage statistics for the entire request.
     */
    fun usage(): Optional<CompletionUsage> = Optional.ofNullable(usage.getNullable("usage"))

    /** A unique identifier for the chat completion. Each chunk has the same ID. */
    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /**
     * A list of chat completion choices. Can contain more than one elements if `n` is greater
     * than 1. Can also be empty for the last chunk if you set `stream_options: {"include_usage":
     * true}`.
     */
    @JsonProperty("choices") @ExcludeMissing fun _choices() = choices

    /**
     * The Unix timestamp (in seconds) of when the chat completion was created. Each chunk has the
     * same timestamp.
     */
    @JsonProperty("created") @ExcludeMissing fun _created() = created

    /** The model to generate the completion. */
    @JsonProperty("model") @ExcludeMissing fun _model() = model

    /**
     * The service tier used for processing the request. This field is only included if the
     * `service_tier` parameter is specified in the request.
     */
    @JsonProperty("service_tier") @ExcludeMissing fun _serviceTier() = serviceTier

    /**
     * This fingerprint represents the backend configuration that the model runs with. Can be used
     * in conjunction with the `seed` request parameter to understand when backend changes have been
     * made that might impact determinism.
     */
    @JsonProperty("system_fingerprint") @ExcludeMissing fun _systemFingerprint() = systemFingerprint

    /** The object type, which is always `chat.completion.chunk`. */
    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    /**
     * An optional field that will only be present when you set `stream_options: {"include_usage":
     * true}` in your request. When present, it contains a null value except for the last chunk
     * which contains the token usage statistics for the entire request.
     */
    @JsonProperty("usage") @ExcludeMissing fun _usage() = usage

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ChatCompletionChunk = apply {
        if (!validated) {
            id()
            choices().forEach { it.validate() }
            created()
            model()
            serviceTier()
            systemFingerprint()
            object_()
            usage().map { it.validate() }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var choices: JsonField<List<Choice>> = JsonMissing.of()
        private var created: JsonField<Long> = JsonMissing.of()
        private var model: JsonField<String> = JsonMissing.of()
        private var serviceTier: JsonField<ServiceTier> = JsonMissing.of()
        private var systemFingerprint: JsonField<String> = JsonMissing.of()
        private var object_: JsonField<Object> = JsonMissing.of()
        private var usage: JsonField<CompletionUsage> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletionChunk: ChatCompletionChunk) = apply {
            this.id = chatCompletionChunk.id
            this.choices = chatCompletionChunk.choices
            this.created = chatCompletionChunk.created
            this.model = chatCompletionChunk.model
            this.serviceTier = chatCompletionChunk.serviceTier
            this.systemFingerprint = chatCompletionChunk.systemFingerprint
            this.object_ = chatCompletionChunk.object_
            this.usage = chatCompletionChunk.usage
            additionalProperties(chatCompletionChunk.additionalProperties)
        }

        /** A unique identifier for the chat completion. Each chunk has the same ID. */
        fun id(id: String) = id(JsonField.of(id))

        /** A unique identifier for the chat completion. Each chunk has the same ID. */
        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /**
         * A list of chat completion choices. Can contain more than one elements if `n` is greater
         * than 1. Can also be empty for the last chunk if you set `stream_options:
         * {"include_usage": true}`.
         */
        fun choices(choices: List<Choice>) = choices(JsonField.of(choices))

        /**
         * A list of chat completion choices. Can contain more than one elements if `n` is greater
         * than 1. Can also be empty for the last chunk if you set `stream_options:
         * {"include_usage": true}`.
         */
        @JsonProperty("choices")
        @ExcludeMissing
        fun choices(choices: JsonField<List<Choice>>) = apply { this.choices = choices }

        /**
         * The Unix timestamp (in seconds) of when the chat completion was created. Each chunk has
         * the same timestamp.
         */
        fun created(created: Long) = created(JsonField.of(created))

        /**
         * The Unix timestamp (in seconds) of when the chat completion was created. Each chunk has
         * the same timestamp.
         */
        @JsonProperty("created")
        @ExcludeMissing
        fun created(created: JsonField<Long>) = apply { this.created = created }

        /** The model to generate the completion. */
        fun model(model: String) = model(JsonField.of(model))

        /** The model to generate the completion. */
        @JsonProperty("model")
        @ExcludeMissing
        fun model(model: JsonField<String>) = apply { this.model = model }

        /**
         * The service tier used for processing the request. This field is only included if the
         * `service_tier` parameter is specified in the request.
         */
        fun serviceTier(serviceTier: ServiceTier) = serviceTier(JsonField.of(serviceTier))

        /**
         * The service tier used for processing the request. This field is only included if the
         * `service_tier` parameter is specified in the request.
         */
        @JsonProperty("service_tier")
        @ExcludeMissing
        fun serviceTier(serviceTier: JsonField<ServiceTier>) = apply {
            this.serviceTier = serviceTier
        }

        /**
         * This fingerprint represents the backend configuration that the model runs with. Can be
         * used in conjunction with the `seed` request parameter to understand when backend changes
         * have been made that might impact determinism.
         */
        fun systemFingerprint(systemFingerprint: String) =
            systemFingerprint(JsonField.of(systemFingerprint))

        /**
         * This fingerprint represents the backend configuration that the model runs with. Can be
         * used in conjunction with the `seed` request parameter to understand when backend changes
         * have been made that might impact determinism.
         */
        @JsonProperty("system_fingerprint")
        @ExcludeMissing
        fun systemFingerprint(systemFingerprint: JsonField<String>) = apply {
            this.systemFingerprint = systemFingerprint
        }

        /** The object type, which is always `chat.completion.chunk`. */
        fun object_(object_: Object) = object_(JsonField.of(object_))

        /** The object type, which is always `chat.completion.chunk`. */
        @JsonProperty("object")
        @ExcludeMissing
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        /**
         * An optional field that will only be present when you set `stream_options:
         * {"include_usage": true}` in your request. When present, it contains a null value except
         * for the last chunk which contains the token usage statistics for the entire request.
         */
        fun usage(usage: CompletionUsage) = usage(JsonField.of(usage))

        /**
         * An optional field that will only be present when you set `stream_options:
         * {"include_usage": true}` in your request. When present, it contains a null value except
         * for the last chunk which contains the token usage statistics for the entire request.
         */
        @JsonProperty("usage")
        @ExcludeMissing
        fun usage(usage: JsonField<CompletionUsage>) = apply { this.usage = usage }

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

        fun build(): ChatCompletionChunk =
            ChatCompletionChunk(
                id,
                choices.map { it.toImmutable() },
                created,
                model,
                serviceTier,
                systemFingerprint,
                object_,
                usage,
                additionalProperties.toImmutable(),
            )
    }

    @JsonDeserialize(builder = Choice.Builder::class)
    @NoAutoDetect
    class Choice
    private constructor(
        private val delta: JsonField<Delta>,
        private val logprobs: JsonField<Logprobs>,
        private val finishReason: JsonField<FinishReason>,
        private val index: JsonField<Long>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        /** A chat completion delta generated by streamed model responses. */
        fun delta(): Delta = delta.getRequired("delta")

        /** Log probability information for the choice. */
        fun logprobs(): Optional<Logprobs> = Optional.ofNullable(logprobs.getNullable("logprobs"))

        /**
         * The reason the model stopped generating tokens. This will be `stop` if the model hit a
         * natural stop point or a provided stop sequence, `length` if the maximum number of tokens
         * specified in the request was reached, `content_filter` if content was omitted due to a
         * flag from our content filters, `tool_calls` if the model called a tool, or
         * `function_call` (deprecated) if the model called a function.
         */
        fun finishReason(): Optional<FinishReason> =
            Optional.ofNullable(finishReason.getNullable("finish_reason"))

        /** The index of the choice in the list of choices. */
        fun index(): Long = index.getRequired("index")

        /** A chat completion delta generated by streamed model responses. */
        @JsonProperty("delta") @ExcludeMissing fun _delta() = delta

        /** Log probability information for the choice. */
        @JsonProperty("logprobs") @ExcludeMissing fun _logprobs() = logprobs

        /**
         * The reason the model stopped generating tokens. This will be `stop` if the model hit a
         * natural stop point or a provided stop sequence, `length` if the maximum number of tokens
         * specified in the request was reached, `content_filter` if content was omitted due to a
         * flag from our content filters, `tool_calls` if the model called a tool, or
         * `function_call` (deprecated) if the model called a function.
         */
        @JsonProperty("finish_reason") @ExcludeMissing fun _finishReason() = finishReason

        /** The index of the choice in the list of choices. */
        @JsonProperty("index") @ExcludeMissing fun _index() = index

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Choice = apply {
            if (!validated) {
                delta().validate()
                logprobs().map { it.validate() }
                finishReason()
                index()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var delta: JsonField<Delta> = JsonMissing.of()
            private var logprobs: JsonField<Logprobs> = JsonMissing.of()
            private var finishReason: JsonField<FinishReason> = JsonMissing.of()
            private var index: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(choice: Choice) = apply {
                this.delta = choice.delta
                this.logprobs = choice.logprobs
                this.finishReason = choice.finishReason
                this.index = choice.index
                additionalProperties(choice.additionalProperties)
            }

            /** A chat completion delta generated by streamed model responses. */
            fun delta(delta: Delta) = delta(JsonField.of(delta))

            /** A chat completion delta generated by streamed model responses. */
            @JsonProperty("delta")
            @ExcludeMissing
            fun delta(delta: JsonField<Delta>) = apply { this.delta = delta }

            /** Log probability information for the choice. */
            fun logprobs(logprobs: Logprobs) = logprobs(JsonField.of(logprobs))

            /** Log probability information for the choice. */
            @JsonProperty("logprobs")
            @ExcludeMissing
            fun logprobs(logprobs: JsonField<Logprobs>) = apply { this.logprobs = logprobs }

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
            @JsonProperty("finish_reason")
            @ExcludeMissing
            fun finishReason(finishReason: JsonField<FinishReason>) = apply {
                this.finishReason = finishReason
            }

            /** The index of the choice in the list of choices. */
            fun index(index: Long) = index(JsonField.of(index))

            /** The index of the choice in the list of choices. */
            @JsonProperty("index")
            @ExcludeMissing
            fun index(index: JsonField<Long>) = apply { this.index = index }

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

            fun build(): Choice =
                Choice(
                    delta,
                    logprobs,
                    finishReason,
                    index,
                    additionalProperties.toImmutable(),
                )
        }

        /** A chat completion delta generated by streamed model responses. */
        @JsonDeserialize(builder = Delta.Builder::class)
        @NoAutoDetect
        class Delta
        private constructor(
            private val content: JsonField<String>,
            private val functionCall: JsonField<FunctionCall>,
            private val toolCalls: JsonField<List<ToolCall>>,
            private val role: JsonField<Role>,
            private val refusal: JsonField<String>,
            private val additionalProperties: Map<String, JsonValue>,
        ) {

            private var validated: Boolean = false

            /** The contents of the chunk message. */
            fun content(): Optional<String> = Optional.ofNullable(content.getNullable("content"))

            /**
             * Deprecated and replaced by `tool_calls`. The name and arguments of a function that
             * should be called, as generated by the model.
             */
            fun functionCall(): Optional<FunctionCall> =
                Optional.ofNullable(functionCall.getNullable("function_call"))

            fun toolCalls(): Optional<List<ToolCall>> =
                Optional.ofNullable(toolCalls.getNullable("tool_calls"))

            /** The role of the author of this message. */
            fun role(): Optional<Role> = Optional.ofNullable(role.getNullable("role"))

            /** The refusal message generated by the model. */
            fun refusal(): Optional<String> = Optional.ofNullable(refusal.getNullable("refusal"))

            /** The contents of the chunk message. */
            @JsonProperty("content") @ExcludeMissing fun _content() = content

            /**
             * Deprecated and replaced by `tool_calls`. The name and arguments of a function that
             * should be called, as generated by the model.
             */
            @JsonProperty("function_call") @ExcludeMissing fun _functionCall() = functionCall

            @JsonProperty("tool_calls") @ExcludeMissing fun _toolCalls() = toolCalls

            /** The role of the author of this message. */
            @JsonProperty("role") @ExcludeMissing fun _role() = role

            /** The refusal message generated by the model. */
            @JsonProperty("refusal") @ExcludeMissing fun _refusal() = refusal

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun validate(): Delta = apply {
                if (!validated) {
                    content()
                    functionCall().map { it.validate() }
                    toolCalls().map { it.forEach { it.validate() } }
                    role()
                    refusal()
                    validated = true
                }
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var content: JsonField<String> = JsonMissing.of()
                private var functionCall: JsonField<FunctionCall> = JsonMissing.of()
                private var toolCalls: JsonField<List<ToolCall>> = JsonMissing.of()
                private var role: JsonField<Role> = JsonMissing.of()
                private var refusal: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(delta: Delta) = apply {
                    this.content = delta.content
                    this.functionCall = delta.functionCall
                    this.toolCalls = delta.toolCalls
                    this.role = delta.role
                    this.refusal = delta.refusal
                    additionalProperties(delta.additionalProperties)
                }

                /** The contents of the chunk message. */
                fun content(content: String) = content(JsonField.of(content))

                /** The contents of the chunk message. */
                @JsonProperty("content")
                @ExcludeMissing
                fun content(content: JsonField<String>) = apply { this.content = content }

                /**
                 * Deprecated and replaced by `tool_calls`. The name and arguments of a function
                 * that should be called, as generated by the model.
                 */
                fun functionCall(functionCall: FunctionCall) =
                    functionCall(JsonField.of(functionCall))

                /**
                 * Deprecated and replaced by `tool_calls`. The name and arguments of a function
                 * that should be called, as generated by the model.
                 */
                @JsonProperty("function_call")
                @ExcludeMissing
                fun functionCall(functionCall: JsonField<FunctionCall>) = apply {
                    this.functionCall = functionCall
                }

                fun toolCalls(toolCalls: List<ToolCall>) = toolCalls(JsonField.of(toolCalls))

                @JsonProperty("tool_calls")
                @ExcludeMissing
                fun toolCalls(toolCalls: JsonField<List<ToolCall>>) = apply {
                    this.toolCalls = toolCalls
                }

                /** The role of the author of this message. */
                fun role(role: Role) = role(JsonField.of(role))

                /** The role of the author of this message. */
                @JsonProperty("role")
                @ExcludeMissing
                fun role(role: JsonField<Role>) = apply { this.role = role }

                /** The refusal message generated by the model. */
                fun refusal(refusal: String) = refusal(JsonField.of(refusal))

                /** The refusal message generated by the model. */
                @JsonProperty("refusal")
                @ExcludeMissing
                fun refusal(refusal: JsonField<String>) = apply { this.refusal = refusal }

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

                fun build(): Delta =
                    Delta(
                        content,
                        functionCall,
                        toolCalls.map { it.toImmutable() },
                        role,
                        refusal,
                        additionalProperties.toImmutable(),
                    )
            }

            /**
             * Deprecated and replaced by `tool_calls`. The name and arguments of a function that
             * should be called, as generated by the model.
             */
            @JsonDeserialize(builder = FunctionCall.Builder::class)
            @NoAutoDetect
            class FunctionCall
            private constructor(
                private val arguments: JsonField<String>,
                private val name: JsonField<String>,
                private val additionalProperties: Map<String, JsonValue>,
            ) {

                private var validated: Boolean = false

                /**
                 * The arguments to call the function with, as generated by the model in JSON
                 * format. Note that the model does not always generate valid JSON, and may
                 * hallucinate parameters not defined by your function schema. Validate the
                 * arguments in your code before calling your function.
                 */
                fun arguments(): Optional<String> =
                    Optional.ofNullable(arguments.getNullable("arguments"))

                /** The name of the function to call. */
                fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

                /**
                 * The arguments to call the function with, as generated by the model in JSON
                 * format. Note that the model does not always generate valid JSON, and may
                 * hallucinate parameters not defined by your function schema. Validate the
                 * arguments in your code before calling your function.
                 */
                @JsonProperty("arguments") @ExcludeMissing fun _arguments() = arguments

                /** The name of the function to call. */
                @JsonProperty("name") @ExcludeMissing fun _name() = name

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun validate(): FunctionCall = apply {
                    if (!validated) {
                        arguments()
                        name()
                        validated = true
                    }
                }

                fun toBuilder() = Builder().from(this)

                companion object {

                    @JvmStatic fun builder() = Builder()
                }

                class Builder {

                    private var arguments: JsonField<String> = JsonMissing.of()
                    private var name: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(functionCall: FunctionCall) = apply {
                        this.arguments = functionCall.arguments
                        this.name = functionCall.name
                        additionalProperties(functionCall.additionalProperties)
                    }

                    /**
                     * The arguments to call the function with, as generated by the model in JSON
                     * format. Note that the model does not always generate valid JSON, and may
                     * hallucinate parameters not defined by your function schema. Validate the
                     * arguments in your code before calling your function.
                     */
                    fun arguments(arguments: String) = arguments(JsonField.of(arguments))

                    /**
                     * The arguments to call the function with, as generated by the model in JSON
                     * format. Note that the model does not always generate valid JSON, and may
                     * hallucinate parameters not defined by your function schema. Validate the
                     * arguments in your code before calling your function.
                     */
                    @JsonProperty("arguments")
                    @ExcludeMissing
                    fun arguments(arguments: JsonField<String>) = apply {
                        this.arguments = arguments
                    }

                    /** The name of the function to call. */
                    fun name(name: String) = name(JsonField.of(name))

                    /** The name of the function to call. */
                    @JsonProperty("name")
                    @ExcludeMissing
                    fun name(name: JsonField<String>) = apply { this.name = name }

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

                    fun build(): FunctionCall =
                        FunctionCall(
                            arguments,
                            name,
                            additionalProperties.toImmutable(),
                        )
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is FunctionCall && arguments == other.arguments && name == other.name && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(arguments, name, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "FunctionCall{arguments=$arguments, name=$name, additionalProperties=$additionalProperties}"
            }

            class Role
            @JsonCreator
            private constructor(
                private val value: JsonField<String>,
            ) : Enum {

                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val SYSTEM = of("system")

                    @JvmField val USER = of("user")

                    @JvmField val ASSISTANT = of("assistant")

                    @JvmField val TOOL = of("tool")

                    @JvmStatic fun of(value: String) = Role(JsonField.of(value))
                }

                enum class Known {
                    SYSTEM,
                    USER,
                    ASSISTANT,
                    TOOL,
                }

                enum class Value {
                    SYSTEM,
                    USER,
                    ASSISTANT,
                    TOOL,
                    _UNKNOWN,
                }

                fun value(): Value =
                    when (this) {
                        SYSTEM -> Value.SYSTEM
                        USER -> Value.USER
                        ASSISTANT -> Value.ASSISTANT
                        TOOL -> Value.TOOL
                        else -> Value._UNKNOWN
                    }

                fun known(): Known =
                    when (this) {
                        SYSTEM -> Known.SYSTEM
                        USER -> Known.USER
                        ASSISTANT -> Known.ASSISTANT
                        TOOL -> Known.TOOL
                        else -> throw OpenAIInvalidDataException("Unknown Role: $value")
                    }

                fun asString(): String = _value().asStringOrThrow()

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Role && value == other.value /* spotless:on */
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            @JsonDeserialize(builder = ToolCall.Builder::class)
            @NoAutoDetect
            class ToolCall
            private constructor(
                private val index: JsonField<Long>,
                private val id: JsonField<String>,
                private val type: JsonField<Type>,
                private val function: JsonField<Function>,
                private val additionalProperties: Map<String, JsonValue>,
            ) {

                private var validated: Boolean = false

                fun index(): Long = index.getRequired("index")

                /** The ID of the tool call. */
                fun id(): Optional<String> = Optional.ofNullable(id.getNullable("id"))

                /** The type of the tool. Currently, only `function` is supported. */
                fun type(): Optional<Type> = Optional.ofNullable(type.getNullable("type"))

                fun function(): Optional<Function> =
                    Optional.ofNullable(function.getNullable("function"))

                @JsonProperty("index") @ExcludeMissing fun _index() = index

                /** The ID of the tool call. */
                @JsonProperty("id") @ExcludeMissing fun _id() = id

                /** The type of the tool. Currently, only `function` is supported. */
                @JsonProperty("type") @ExcludeMissing fun _type() = type

                @JsonProperty("function") @ExcludeMissing fun _function() = function

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun validate(): ToolCall = apply {
                    if (!validated) {
                        index()
                        id()
                        type()
                        function().map { it.validate() }
                        validated = true
                    }
                }

                fun toBuilder() = Builder().from(this)

                companion object {

                    @JvmStatic fun builder() = Builder()
                }

                class Builder {

                    private var index: JsonField<Long> = JsonMissing.of()
                    private var id: JsonField<String> = JsonMissing.of()
                    private var type: JsonField<Type> = JsonMissing.of()
                    private var function: JsonField<Function> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(toolCall: ToolCall) = apply {
                        this.index = toolCall.index
                        this.id = toolCall.id
                        this.type = toolCall.type
                        this.function = toolCall.function
                        additionalProperties(toolCall.additionalProperties)
                    }

                    fun index(index: Long) = index(JsonField.of(index))

                    @JsonProperty("index")
                    @ExcludeMissing
                    fun index(index: JsonField<Long>) = apply { this.index = index }

                    /** The ID of the tool call. */
                    fun id(id: String) = id(JsonField.of(id))

                    /** The ID of the tool call. */
                    @JsonProperty("id")
                    @ExcludeMissing
                    fun id(id: JsonField<String>) = apply { this.id = id }

                    /** The type of the tool. Currently, only `function` is supported. */
                    fun type(type: Type) = type(JsonField.of(type))

                    /** The type of the tool. Currently, only `function` is supported. */
                    @JsonProperty("type")
                    @ExcludeMissing
                    fun type(type: JsonField<Type>) = apply { this.type = type }

                    fun function(function: Function) = function(JsonField.of(function))

                    @JsonProperty("function")
                    @ExcludeMissing
                    fun function(function: JsonField<Function>) = apply { this.function = function }

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

                    fun build(): ToolCall =
                        ToolCall(
                            index,
                            id,
                            type,
                            function,
                            additionalProperties.toImmutable(),
                        )
                }

                @JsonDeserialize(builder = Function.Builder::class)
                @NoAutoDetect
                class Function
                private constructor(
                    private val name: JsonField<String>,
                    private val arguments: JsonField<String>,
                    private val additionalProperties: Map<String, JsonValue>,
                ) {

                    private var validated: Boolean = false

                    /** The name of the function to call. */
                    fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

                    /**
                     * The arguments to call the function with, as generated by the model in JSON
                     * format. Note that the model does not always generate valid JSON, and may
                     * hallucinate parameters not defined by your function schema. Validate the
                     * arguments in your code before calling your function.
                     */
                    fun arguments(): Optional<String> =
                        Optional.ofNullable(arguments.getNullable("arguments"))

                    /** The name of the function to call. */
                    @JsonProperty("name") @ExcludeMissing fun _name() = name

                    /**
                     * The arguments to call the function with, as generated by the model in JSON
                     * format. Note that the model does not always generate valid JSON, and may
                     * hallucinate parameters not defined by your function schema. Validate the
                     * arguments in your code before calling your function.
                     */
                    @JsonProperty("arguments") @ExcludeMissing fun _arguments() = arguments

                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                    fun validate(): Function = apply {
                        if (!validated) {
                            name()
                            arguments()
                            validated = true
                        }
                    }

                    fun toBuilder() = Builder().from(this)

                    companion object {

                        @JvmStatic fun builder() = Builder()
                    }

                    class Builder {

                        private var name: JsonField<String> = JsonMissing.of()
                        private var arguments: JsonField<String> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(function: Function) = apply {
                            this.name = function.name
                            this.arguments = function.arguments
                            additionalProperties(function.additionalProperties)
                        }

                        /** The name of the function to call. */
                        fun name(name: String) = name(JsonField.of(name))

                        /** The name of the function to call. */
                        @JsonProperty("name")
                        @ExcludeMissing
                        fun name(name: JsonField<String>) = apply { this.name = name }

                        /**
                         * The arguments to call the function with, as generated by the model in
                         * JSON format. Note that the model does not always generate valid JSON, and
                         * may hallucinate parameters not defined by your function schema. Validate
                         * the arguments in your code before calling your function.
                         */
                        fun arguments(arguments: String) = arguments(JsonField.of(arguments))

                        /**
                         * The arguments to call the function with, as generated by the model in
                         * JSON format. Note that the model does not always generate valid JSON, and
                         * may hallucinate parameters not defined by your function schema. Validate
                         * the arguments in your code before calling your function.
                         */
                        @JsonProperty("arguments")
                        @ExcludeMissing
                        fun arguments(arguments: JsonField<String>) = apply {
                            this.arguments = arguments
                        }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                this.additionalProperties.putAll(additionalProperties)
                            }

                        @JsonAnySetter
                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            this.additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun build(): Function =
                            Function(
                                name,
                                arguments,
                                additionalProperties.toImmutable(),
                            )
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is Function && name == other.name && arguments == other.arguments && additionalProperties == other.additionalProperties /* spotless:on */
                    }

                    /* spotless:off */
                    private val hashCode: Int by lazy { Objects.hash(name, arguments, additionalProperties) }
                    /* spotless:on */

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Function{name=$name, arguments=$arguments, additionalProperties=$additionalProperties}"
                }

                class Type
                @JsonCreator
                private constructor(
                    private val value: JsonField<String>,
                ) : Enum {

                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val FUNCTION = of("function")

                        @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                    }

                    enum class Known {
                        FUNCTION,
                    }

                    enum class Value {
                        FUNCTION,
                        _UNKNOWN,
                    }

                    fun value(): Value =
                        when (this) {
                            FUNCTION -> Value.FUNCTION
                            else -> Value._UNKNOWN
                        }

                    fun known(): Known =
                        when (this) {
                            FUNCTION -> Known.FUNCTION
                            else -> throw OpenAIInvalidDataException("Unknown Type: $value")
                        }

                    fun asString(): String = _value().asStringOrThrow()

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is Type && value == other.value /* spotless:on */
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is ToolCall && index == other.index && id == other.id && type == other.type && function == other.function && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(index, id, type, function, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "ToolCall{index=$index, id=$id, type=$type, function=$function, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Delta && content == other.content && functionCall == other.functionCall && toolCalls == other.toolCalls && role == other.role && refusal == other.refusal && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(content, functionCall, toolCalls, role, refusal, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Delta{content=$content, functionCall=$functionCall, toolCalls=$toolCalls, role=$role, refusal=$refusal, additionalProperties=$additionalProperties}"
        }

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
        @JsonDeserialize(builder = Logprobs.Builder::class)
        @NoAutoDetect
        class Logprobs
        private constructor(
            private val content: JsonField<List<ChatCompletionTokenLogprob>>,
            private val refusal: JsonField<List<ChatCompletionTokenLogprob>>,
            private val additionalProperties: Map<String, JsonValue>,
        ) {

            private var validated: Boolean = false

            /** A list of message content tokens with log probability information. */
            fun content(): Optional<List<ChatCompletionTokenLogprob>> =
                Optional.ofNullable(content.getNullable("content"))

            /** A list of message refusal tokens with log probability information. */
            fun refusal(): Optional<List<ChatCompletionTokenLogprob>> =
                Optional.ofNullable(refusal.getNullable("refusal"))

            /** A list of message content tokens with log probability information. */
            @JsonProperty("content") @ExcludeMissing fun _content() = content

            /** A list of message refusal tokens with log probability information. */
            @JsonProperty("refusal") @ExcludeMissing fun _refusal() = refusal

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun validate(): Logprobs = apply {
                if (!validated) {
                    content().map { it.forEach { it.validate() } }
                    refusal().map { it.forEach { it.validate() } }
                    validated = true
                }
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var content: JsonField<List<ChatCompletionTokenLogprob>> = JsonMissing.of()
                private var refusal: JsonField<List<ChatCompletionTokenLogprob>> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(logprobs: Logprobs) = apply {
                    this.content = logprobs.content
                    this.refusal = logprobs.refusal
                    additionalProperties(logprobs.additionalProperties)
                }

                /** A list of message content tokens with log probability information. */
                fun content(content: List<ChatCompletionTokenLogprob>) =
                    content(JsonField.of(content))

                /** A list of message content tokens with log probability information. */
                @JsonProperty("content")
                @ExcludeMissing
                fun content(content: JsonField<List<ChatCompletionTokenLogprob>>) = apply {
                    this.content = content
                }

                /** A list of message refusal tokens with log probability information. */
                fun refusal(refusal: List<ChatCompletionTokenLogprob>) =
                    refusal(JsonField.of(refusal))

                /** A list of message refusal tokens with log probability information. */
                @JsonProperty("refusal")
                @ExcludeMissing
                fun refusal(refusal: JsonField<List<ChatCompletionTokenLogprob>>) = apply {
                    this.refusal = refusal
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

                fun build(): Logprobs =
                    Logprobs(
                        content.map { it.toImmutable() },
                        refusal.map { it.toImmutable() },
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

            return /* spotless:off */ other is Choice && delta == other.delta && logprobs == other.logprobs && finishReason == other.finishReason && index == other.index && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(delta, logprobs, finishReason, index, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Choice{delta=$delta, logprobs=$logprobs, finishReason=$finishReason, index=$index, additionalProperties=$additionalProperties}"
    }

    class Object
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val CHAT_COMPLETION_CHUNK = of("chat.completion.chunk")

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        enum class Known {
            CHAT_COMPLETION_CHUNK,
        }

        enum class Value {
            CHAT_COMPLETION_CHUNK,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                CHAT_COMPLETION_CHUNK -> Value.CHAT_COMPLETION_CHUNK
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                CHAT_COMPLETION_CHUNK -> Known.CHAT_COMPLETION_CHUNK
                else -> throw OpenAIInvalidDataException("Unknown Object: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Object && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

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

        return /* spotless:off */ other is ChatCompletionChunk && id == other.id && choices == other.choices && created == other.created && model == other.model && serviceTier == other.serviceTier && systemFingerprint == other.systemFingerprint && object_ == other.object_ && usage == other.usage && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, choices, created, model, serviceTier, systemFingerprint, object_, usage, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatCompletionChunk{id=$id, choices=$choices, created=$created, model=$model, serviceTier=$serviceTier, systemFingerprint=$systemFingerprint, object_=$object_, usage=$usage, additionalProperties=$additionalProperties}"
}
