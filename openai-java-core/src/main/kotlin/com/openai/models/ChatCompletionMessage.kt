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
import com.openai.core.checkRequired
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/** A chat completion message generated by the model. */
@NoAutoDetect
class ChatCompletionMessage
@JsonCreator
private constructor(
    @JsonProperty("content")
    @ExcludeMissing
    private val content: JsonField<String> = JsonMissing.of(),
    @JsonProperty("refusal")
    @ExcludeMissing
    private val refusal: JsonField<String> = JsonMissing.of(),
    @JsonProperty("role") @ExcludeMissing private val role: JsonValue = JsonMissing.of(),
    @JsonProperty("audio")
    @ExcludeMissing
    private val audio: JsonField<ChatCompletionAudio> = JsonMissing.of(),
    @JsonProperty("function_call")
    @ExcludeMissing
    private val functionCall: JsonField<FunctionCall> = JsonMissing.of(),
    @JsonProperty("tool_calls")
    @ExcludeMissing
    private val toolCalls: JsonField<List<ChatCompletionMessageToolCall>> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The contents of the message. */
    fun content(): Optional<String> = Optional.ofNullable(content.getNullable("content"))

    /** The refusal message generated by the model. */
    fun refusal(): Optional<String> = Optional.ofNullable(refusal.getNullable("refusal"))

    /** The role of the author of this message. */
    @JsonProperty("role") @ExcludeMissing fun _role(): JsonValue = role

    /**
     * If the audio output modality is requested, this object contains data about the audio response
     * from the model. [Learn more](https://platform.openai.com/docs/guides/audio).
     */
    fun audio(): Optional<ChatCompletionAudio> = Optional.ofNullable(audio.getNullable("audio"))

    /**
     * Deprecated and replaced by `tool_calls`. The name and arguments of a function that should be
     * called, as generated by the model.
     */
    @Deprecated("deprecated")
    fun functionCall(): Optional<FunctionCall> =
        Optional.ofNullable(functionCall.getNullable("function_call"))

    /** The tool calls generated by the model, such as function calls. */
    fun toolCalls(): Optional<List<ChatCompletionMessageToolCall>> =
        Optional.ofNullable(toolCalls.getNullable("tool_calls"))

    /** The contents of the message. */
    @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<String> = content

    /** The refusal message generated by the model. */
    @JsonProperty("refusal") @ExcludeMissing fun _refusal(): JsonField<String> = refusal

    /**
     * If the audio output modality is requested, this object contains data about the audio response
     * from the model. [Learn more](https://platform.openai.com/docs/guides/audio).
     */
    @JsonProperty("audio") @ExcludeMissing fun _audio(): JsonField<ChatCompletionAudio> = audio

    /**
     * Deprecated and replaced by `tool_calls`. The name and arguments of a function that should be
     * called, as generated by the model.
     */
    @Deprecated("deprecated")
    @JsonProperty("function_call")
    @ExcludeMissing
    fun _functionCall(): JsonField<FunctionCall> = functionCall

    /** The tool calls generated by the model, such as function calls. */
    @JsonProperty("tool_calls")
    @ExcludeMissing
    fun _toolCalls(): JsonField<List<ChatCompletionMessageToolCall>> = toolCalls

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun toParam(): ChatCompletionAssistantMessageParam =
        ChatCompletionAssistantMessageParam.builder()
            .audio(
                _audio().map {
                    ChatCompletionAssistantMessageParam.Audio.builder().id(it._id()).build()
                }
            )
            .content(_content().map { ChatCompletionAssistantMessageParam.Content.ofText(it) })
            .functionCall(
                _functionCall().map {
                    ChatCompletionAssistantMessageParam.FunctionCall.builder()
                        .arguments(it._arguments())
                        .name(it._name())
                        .build()
                }
            )
            .refusal(_refusal())
            .toolCalls(_toolCalls())
            .build()

    private var validated: Boolean = false

    fun validate(): ChatCompletionMessage = apply {
        if (validated) {
            return@apply
        }

        content()
        refusal()
        _role().let {
            if (it != JsonValue.from("assistant")) {
                throw OpenAIInvalidDataException("'role' is invalid, received $it")
            }
        }
        audio().ifPresent { it.validate() }
        functionCall().ifPresent { it.validate() }
        toolCalls().ifPresent { it.forEach { it.validate() } }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ChatCompletionMessage]. */
    class Builder internal constructor() {

        private var content: JsonField<String>? = null
        private var refusal: JsonField<String>? = null
        private var role: JsonValue = JsonValue.from("assistant")
        private var audio: JsonField<ChatCompletionAudio> = JsonMissing.of()
        private var functionCall: JsonField<FunctionCall> = JsonMissing.of()
        private var toolCalls: JsonField<MutableList<ChatCompletionMessageToolCall>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletionMessage: ChatCompletionMessage) = apply {
            content = chatCompletionMessage.content
            refusal = chatCompletionMessage.refusal
            role = chatCompletionMessage.role
            audio = chatCompletionMessage.audio
            functionCall = chatCompletionMessage.functionCall
            toolCalls = chatCompletionMessage.toolCalls.map { it.toMutableList() }
            additionalProperties = chatCompletionMessage.additionalProperties.toMutableMap()
        }

        /** The contents of the message. */
        fun content(content: String?) = content(JsonField.ofNullable(content))

        /** The contents of the message. */
        fun content(content: Optional<String>) = content(content.orElse(null))

        /** The contents of the message. */
        fun content(content: JsonField<String>) = apply { this.content = content }

        /** The refusal message generated by the model. */
        fun refusal(refusal: String?) = refusal(JsonField.ofNullable(refusal))

        /** The refusal message generated by the model. */
        fun refusal(refusal: Optional<String>) = refusal(refusal.orElse(null))

        /** The refusal message generated by the model. */
        fun refusal(refusal: JsonField<String>) = apply { this.refusal = refusal }

        /** The role of the author of this message. */
        fun role(role: JsonValue) = apply { this.role = role }

        /**
         * If the audio output modality is requested, this object contains data about the audio
         * response from the model. [Learn more](https://platform.openai.com/docs/guides/audio).
         */
        fun audio(audio: ChatCompletionAudio?) = audio(JsonField.ofNullable(audio))

        /**
         * If the audio output modality is requested, this object contains data about the audio
         * response from the model. [Learn more](https://platform.openai.com/docs/guides/audio).
         */
        fun audio(audio: Optional<ChatCompletionAudio>) = audio(audio.orElse(null))

        /**
         * If the audio output modality is requested, this object contains data about the audio
         * response from the model. [Learn more](https://platform.openai.com/docs/guides/audio).
         */
        fun audio(audio: JsonField<ChatCompletionAudio>) = apply { this.audio = audio }

        /**
         * Deprecated and replaced by `tool_calls`. The name and arguments of a function that should
         * be called, as generated by the model.
         */
        @Deprecated("deprecated")
        fun functionCall(functionCall: FunctionCall) = functionCall(JsonField.of(functionCall))

        /**
         * Deprecated and replaced by `tool_calls`. The name and arguments of a function that should
         * be called, as generated by the model.
         */
        @Deprecated("deprecated")
        fun functionCall(functionCall: JsonField<FunctionCall>) = apply {
            this.functionCall = functionCall
        }

        /** The tool calls generated by the model, such as function calls. */
        fun toolCalls(toolCalls: List<ChatCompletionMessageToolCall>) =
            toolCalls(JsonField.of(toolCalls))

        /** The tool calls generated by the model, such as function calls. */
        fun toolCalls(toolCalls: JsonField<List<ChatCompletionMessageToolCall>>) = apply {
            this.toolCalls = toolCalls.map { it.toMutableList() }
        }

        /** The tool calls generated by the model, such as function calls. */
        fun addToolCall(toolCall: ChatCompletionMessageToolCall) = apply {
            toolCalls =
                (toolCalls ?: JsonField.of(mutableListOf())).apply {
                    asKnown()
                        .orElseThrow {
                            IllegalStateException(
                                "Field was set to non-list type: ${javaClass.simpleName}"
                            )
                        }
                        .add(toolCall)
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

        fun build(): ChatCompletionMessage =
            ChatCompletionMessage(
                checkRequired("content", content),
                checkRequired("refusal", refusal),
                role,
                audio,
                functionCall,
                (toolCalls ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toImmutable(),
            )
    }

    /**
     * Deprecated and replaced by `tool_calls`. The name and arguments of a function that should be
     * called, as generated by the model.
     */
    @Deprecated("deprecated")
    @NoAutoDetect
    class FunctionCall
    @JsonCreator
    private constructor(
        @JsonProperty("arguments")
        @ExcludeMissing
        private val arguments: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name")
        @ExcludeMissing
        private val name: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * The arguments to call the function with, as generated by the model in JSON format. Note
         * that the model does not always generate valid JSON, and may hallucinate parameters not
         * defined by your function schema. Validate the arguments in your code before calling your
         * function.
         */
        fun arguments(): String = arguments.getRequired("arguments")

        /** The name of the function to call. */
        fun name(): String = name.getRequired("name")

        /**
         * The arguments to call the function with, as generated by the model in JSON format. Note
         * that the model does not always generate valid JSON, and may hallucinate parameters not
         * defined by your function schema. Validate the arguments in your code before calling your
         * function.
         */
        @JsonProperty("arguments") @ExcludeMissing fun _arguments(): JsonField<String> = arguments

        /** The name of the function to call. */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): FunctionCall = apply {
            if (validated) {
                return@apply
            }

            arguments()
            name()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [FunctionCall]. */
        class Builder internal constructor() {

            private var arguments: JsonField<String>? = null
            private var name: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(functionCall: FunctionCall) = apply {
                arguments = functionCall.arguments
                name = functionCall.name
                additionalProperties = functionCall.additionalProperties.toMutableMap()
            }

            /**
             * The arguments to call the function with, as generated by the model in JSON format.
             * Note that the model does not always generate valid JSON, and may hallucinate
             * parameters not defined by your function schema. Validate the arguments in your code
             * before calling your function.
             */
            fun arguments(arguments: String) = arguments(JsonField.of(arguments))

            /**
             * The arguments to call the function with, as generated by the model in JSON format.
             * Note that the model does not always generate valid JSON, and may hallucinate
             * parameters not defined by your function schema. Validate the arguments in your code
             * before calling your function.
             */
            fun arguments(arguments: JsonField<String>) = apply { this.arguments = arguments }

            /** The name of the function to call. */
            fun name(name: String) = name(JsonField.of(name))

            /** The name of the function to call. */
            fun name(name: JsonField<String>) = apply { this.name = name }

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

            fun build(): FunctionCall =
                FunctionCall(
                    checkRequired("arguments", arguments),
                    checkRequired("name", name),
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionMessage && content == other.content && refusal == other.refusal && role == other.role && audio == other.audio && functionCall == other.functionCall && toolCalls == other.toolCalls && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(content, refusal, role, audio, functionCall, toolCalls, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatCompletionMessage{content=$content, refusal=$refusal, role=$role, audio=$audio, functionCall=$functionCall, toolCalls=$toolCalls, additionalProperties=$additionalProperties}"
}
