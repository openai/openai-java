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
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A chat completion message generated by the model. */
@NoAutoDetect
class ChatCompletionStoreMessage
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
    private val functionCall: JsonField<ChatCompletionMessage.FunctionCall> = JsonMissing.of(),
    @JsonProperty("tool_calls")
    @ExcludeMissing
    private val toolCalls: JsonField<List<ChatCompletionMessageToolCall>> = JsonMissing.of(),
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
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
    fun functionCall(): Optional<ChatCompletionMessage.FunctionCall> =
        Optional.ofNullable(functionCall.getNullable("function_call"))

    /** The tool calls generated by the model, such as function calls. */
    fun toolCalls(): Optional<List<ChatCompletionMessageToolCall>> =
        Optional.ofNullable(toolCalls.getNullable("tool_calls"))

    /** The identifier of the chat message. */
    fun id(): String = id.getRequired("id")

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
    fun _functionCall(): JsonField<ChatCompletionMessage.FunctionCall> = functionCall

    /** The tool calls generated by the model, such as function calls. */
    @JsonProperty("tool_calls")
    @ExcludeMissing
    fun _toolCalls(): JsonField<List<ChatCompletionMessageToolCall>> = toolCalls

    /** The identifier of the chat message. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun toChatCompletionMessage(): ChatCompletionMessage =
        ChatCompletionMessage.builder()
            .content(content)
            .refusal(refusal)
            .role(role)
            .audio(audio)
            .functionCall(functionCall)
            .toolCalls(toolCalls)
            .build()

    private var validated: Boolean = false

    fun validate(): ChatCompletionStoreMessage = apply {
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
        id()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ChatCompletionStoreMessage].
         *
         * The following fields are required:
         * ```java
         * .content()
         * .refusal()
         * .id()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ChatCompletionStoreMessage]. */
    class Builder internal constructor() {

        private var content: JsonField<String>? = null
        private var refusal: JsonField<String>? = null
        private var role: JsonValue = JsonValue.from("assistant")
        private var audio: JsonField<ChatCompletionAudio> = JsonMissing.of()
        private var functionCall: JsonField<ChatCompletionMessage.FunctionCall> = JsonMissing.of()
        private var toolCalls: JsonField<MutableList<ChatCompletionMessageToolCall>>? = null
        private var id: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletionStoreMessage: ChatCompletionStoreMessage) = apply {
            content = chatCompletionStoreMessage.content
            refusal = chatCompletionStoreMessage.refusal
            role = chatCompletionStoreMessage.role
            audio = chatCompletionStoreMessage.audio
            functionCall = chatCompletionStoreMessage.functionCall
            toolCalls = chatCompletionStoreMessage.toolCalls.map { it.toMutableList() }
            id = chatCompletionStoreMessage.id
            additionalProperties = chatCompletionStoreMessage.additionalProperties.toMutableMap()
        }

        /** The contents of the message. */
        fun content(content: String?) = content(JsonField.ofNullable(content))

        /** The contents of the message. */
        fun content(content: Optional<String>) = content(content.getOrNull())

        /** The contents of the message. */
        fun content(content: JsonField<String>) = apply { this.content = content }

        /** The refusal message generated by the model. */
        fun refusal(refusal: String?) = refusal(JsonField.ofNullable(refusal))

        /** The refusal message generated by the model. */
        fun refusal(refusal: Optional<String>) = refusal(refusal.getOrNull())

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
        fun audio(audio: Optional<ChatCompletionAudio>) = audio(audio.getOrNull())

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
        fun functionCall(functionCall: ChatCompletionMessage.FunctionCall) =
            functionCall(JsonField.of(functionCall))

        /**
         * Deprecated and replaced by `tool_calls`. The name and arguments of a function that should
         * be called, as generated by the model.
         */
        @Deprecated("deprecated")
        fun functionCall(functionCall: JsonField<ChatCompletionMessage.FunctionCall>) = apply {
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
                (toolCalls ?: JsonField.of(mutableListOf())).also {
                    checkKnown("toolCalls", it).add(toolCall)
                }
        }

        /** The identifier of the chat message. */
        fun id(id: String) = id(JsonField.of(id))

        /** The identifier of the chat message. */
        fun id(id: JsonField<String>) = apply { this.id = id }

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

        fun build(): ChatCompletionStoreMessage =
            ChatCompletionStoreMessage(
                checkRequired("content", content),
                checkRequired("refusal", refusal),
                role,
                audio,
                functionCall,
                (toolCalls ?: JsonMissing.of()).map { it.toImmutable() },
                checkRequired("id", id),
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionStoreMessage && content == other.content && refusal == other.refusal && role == other.role && audio == other.audio && functionCall == other.functionCall && toolCalls == other.toolCalls && id == other.id && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(content, refusal, role, audio, functionCall, toolCalls, id, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatCompletionStoreMessage{content=$content, refusal=$refusal, role=$role, audio=$audio, functionCall=$functionCall, toolCalls=$toolCalls, id=$id, additionalProperties=$additionalProperties}"
}
