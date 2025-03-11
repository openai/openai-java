// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** An output message from the model. */
@JsonDeserialize(using = ResponseOutputItem.Deserializer::class)
@JsonSerialize(using = ResponseOutputItem.Serializer::class)
class ResponseOutputItem
private constructor(
    private val message: ResponseOutputMessage? = null,
    private val fileSearchCall: ResponseFileSearchToolCall? = null,
    private val functionCall: ResponseFunctionToolCall? = null,
    private val webSearchCall: ResponseFunctionWebSearch? = null,
    private val computerCall: ResponseComputerToolCall? = null,
    private val reasoning: Reasoning? = null,
    private val _json: JsonValue? = null,
) {

    /** An output message from the model. */
    fun message(): Optional<ResponseOutputMessage> = Optional.ofNullable(message)

    /**
     * The results of a file search tool call. See the
     * [file search guide](https://platform.openai.com/docs/guides/tools-file-search) for more
     * information.
     */
    fun fileSearchCall(): Optional<ResponseFileSearchToolCall> = Optional.ofNullable(fileSearchCall)

    /**
     * A tool call to run a function. See the
     * [function calling guide](https://platform.openai.com/docs/guides/function-calling) for more
     * information.
     */
    fun functionCall(): Optional<ResponseFunctionToolCall> = Optional.ofNullable(functionCall)

    /**
     * The results of a web search tool call. See the
     * [web search guide](https://platform.openai.com/docs/guides/tools-web-search) for more
     * information.
     */
    fun webSearchCall(): Optional<ResponseFunctionWebSearch> = Optional.ofNullable(webSearchCall)

    /**
     * A tool call to a computer use tool. See the
     * [computer use guide](https://platform.openai.com/docs/guides/tools-computer-use) for more
     * information.
     */
    fun computerCall(): Optional<ResponseComputerToolCall> = Optional.ofNullable(computerCall)

    /**
     * A description of the chain of thought used by a reasoning model while generating a response.
     */
    fun reasoning(): Optional<Reasoning> = Optional.ofNullable(reasoning)

    fun isMessage(): Boolean = message != null

    fun isFileSearchCall(): Boolean = fileSearchCall != null

    fun isFunctionCall(): Boolean = functionCall != null

    fun isWebSearchCall(): Boolean = webSearchCall != null

    fun isComputerCall(): Boolean = computerCall != null

    fun isReasoning(): Boolean = reasoning != null

    /** An output message from the model. */
    fun asMessage(): ResponseOutputMessage = message.getOrThrow("message")

    /**
     * The results of a file search tool call. See the
     * [file search guide](https://platform.openai.com/docs/guides/tools-file-search) for more
     * information.
     */
    fun asFileSearchCall(): ResponseFileSearchToolCall = fileSearchCall.getOrThrow("fileSearchCall")

    /**
     * A tool call to run a function. See the
     * [function calling guide](https://platform.openai.com/docs/guides/function-calling) for more
     * information.
     */
    fun asFunctionCall(): ResponseFunctionToolCall = functionCall.getOrThrow("functionCall")

    /**
     * The results of a web search tool call. See the
     * [web search guide](https://platform.openai.com/docs/guides/tools-web-search) for more
     * information.
     */
    fun asWebSearchCall(): ResponseFunctionWebSearch = webSearchCall.getOrThrow("webSearchCall")

    /**
     * A tool call to a computer use tool. See the
     * [computer use guide](https://platform.openai.com/docs/guides/tools-computer-use) for more
     * information.
     */
    fun asComputerCall(): ResponseComputerToolCall = computerCall.getOrThrow("computerCall")

    /**
     * A description of the chain of thought used by a reasoning model while generating a response.
     */
    fun asReasoning(): Reasoning = reasoning.getOrThrow("reasoning")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            message != null -> visitor.visitMessage(message)
            fileSearchCall != null -> visitor.visitFileSearchCall(fileSearchCall)
            functionCall != null -> visitor.visitFunctionCall(functionCall)
            webSearchCall != null -> visitor.visitWebSearchCall(webSearchCall)
            computerCall != null -> visitor.visitComputerCall(computerCall)
            reasoning != null -> visitor.visitReasoning(reasoning)
            else -> visitor.unknown(_json)
        }
    }

    private var validated: Boolean = false

    fun validate(): ResponseOutputItem = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitMessage(message: ResponseOutputMessage) {
                    message.validate()
                }

                override fun visitFileSearchCall(fileSearchCall: ResponseFileSearchToolCall) {
                    fileSearchCall.validate()
                }

                override fun visitFunctionCall(functionCall: ResponseFunctionToolCall) {
                    functionCall.validate()
                }

                override fun visitWebSearchCall(webSearchCall: ResponseFunctionWebSearch) {
                    webSearchCall.validate()
                }

                override fun visitComputerCall(computerCall: ResponseComputerToolCall) {
                    computerCall.validate()
                }

                override fun visitReasoning(reasoning: Reasoning) {
                    reasoning.validate()
                }
            }
        )
        validated = true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseOutputItem && message == other.message && fileSearchCall == other.fileSearchCall && functionCall == other.functionCall && webSearchCall == other.webSearchCall && computerCall == other.computerCall && reasoning == other.reasoning /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(message, fileSearchCall, functionCall, webSearchCall, computerCall, reasoning) /* spotless:on */

    override fun toString(): String =
        when {
            message != null -> "ResponseOutputItem{message=$message}"
            fileSearchCall != null -> "ResponseOutputItem{fileSearchCall=$fileSearchCall}"
            functionCall != null -> "ResponseOutputItem{functionCall=$functionCall}"
            webSearchCall != null -> "ResponseOutputItem{webSearchCall=$webSearchCall}"
            computerCall != null -> "ResponseOutputItem{computerCall=$computerCall}"
            reasoning != null -> "ResponseOutputItem{reasoning=$reasoning}"
            _json != null -> "ResponseOutputItem{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ResponseOutputItem")
        }

    companion object {

        /** An output message from the model. */
        @JvmStatic
        fun ofMessage(message: ResponseOutputMessage) = ResponseOutputItem(message = message)

        /**
         * The results of a file search tool call. See the
         * [file search guide](https://platform.openai.com/docs/guides/tools-file-search) for more
         * information.
         */
        @JvmStatic
        fun ofFileSearchCall(fileSearchCall: ResponseFileSearchToolCall) =
            ResponseOutputItem(fileSearchCall = fileSearchCall)

        /**
         * A tool call to run a function. See the
         * [function calling guide](https://platform.openai.com/docs/guides/function-calling) for
         * more information.
         */
        @JvmStatic
        fun ofFunctionCall(functionCall: ResponseFunctionToolCall) =
            ResponseOutputItem(functionCall = functionCall)

        /**
         * The results of a web search tool call. See the
         * [web search guide](https://platform.openai.com/docs/guides/tools-web-search) for more
         * information.
         */
        @JvmStatic
        fun ofWebSearchCall(webSearchCall: ResponseFunctionWebSearch) =
            ResponseOutputItem(webSearchCall = webSearchCall)

        /**
         * A tool call to a computer use tool. See the
         * [computer use guide](https://platform.openai.com/docs/guides/tools-computer-use) for more
         * information.
         */
        @JvmStatic
        fun ofComputerCall(computerCall: ResponseComputerToolCall) =
            ResponseOutputItem(computerCall = computerCall)

        /**
         * A description of the chain of thought used by a reasoning model while generating a
         * response.
         */
        @JvmStatic fun ofReasoning(reasoning: Reasoning) = ResponseOutputItem(reasoning = reasoning)
    }

    /**
     * An interface that defines how to map each variant of [ResponseOutputItem] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /** An output message from the model. */
        fun visitMessage(message: ResponseOutputMessage): T

        /**
         * The results of a file search tool call. See the
         * [file search guide](https://platform.openai.com/docs/guides/tools-file-search) for more
         * information.
         */
        fun visitFileSearchCall(fileSearchCall: ResponseFileSearchToolCall): T

        /**
         * A tool call to run a function. See the
         * [function calling guide](https://platform.openai.com/docs/guides/function-calling) for
         * more information.
         */
        fun visitFunctionCall(functionCall: ResponseFunctionToolCall): T

        /**
         * The results of a web search tool call. See the
         * [web search guide](https://platform.openai.com/docs/guides/tools-web-search) for more
         * information.
         */
        fun visitWebSearchCall(webSearchCall: ResponseFunctionWebSearch): T

        /**
         * A tool call to a computer use tool. See the
         * [computer use guide](https://platform.openai.com/docs/guides/tools-computer-use) for more
         * information.
         */
        fun visitComputerCall(computerCall: ResponseComputerToolCall): T

        /**
         * A description of the chain of thought used by a reasoning model while generating a
         * response.
         */
        fun visitReasoning(reasoning: Reasoning): T

        /**
         * Maps an unknown variant of [ResponseOutputItem] to a value of type [T].
         *
         * An instance of [ResponseOutputItem] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ResponseOutputItem: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<ResponseOutputItem>(ResponseOutputItem::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ResponseOutputItem {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "message" -> {
                    tryDeserialize(node, jacksonTypeRef<ResponseOutputMessage>()) { it.validate() }
                        ?.let {
                            return ResponseOutputItem(message = it, _json = json)
                        }
                }
                "file_search_call" -> {
                    tryDeserialize(node, jacksonTypeRef<ResponseFileSearchToolCall>()) {
                            it.validate()
                        }
                        ?.let {
                            return ResponseOutputItem(fileSearchCall = it, _json = json)
                        }
                }
                "function_call" -> {
                    tryDeserialize(node, jacksonTypeRef<ResponseFunctionToolCall>()) {
                            it.validate()
                        }
                        ?.let {
                            return ResponseOutputItem(functionCall = it, _json = json)
                        }
                }
                "web_search_call" -> {
                    tryDeserialize(node, jacksonTypeRef<ResponseFunctionWebSearch>()) {
                            it.validate()
                        }
                        ?.let {
                            return ResponseOutputItem(webSearchCall = it, _json = json)
                        }
                }
                "computer_call" -> {
                    tryDeserialize(node, jacksonTypeRef<ResponseComputerToolCall>()) {
                            it.validate()
                        }
                        ?.let {
                            return ResponseOutputItem(computerCall = it, _json = json)
                        }
                }
                "reasoning" -> {
                    tryDeserialize(node, jacksonTypeRef<Reasoning>()) { it.validate() }
                        ?.let {
                            return ResponseOutputItem(reasoning = it, _json = json)
                        }
                }
            }

            return ResponseOutputItem(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<ResponseOutputItem>(ResponseOutputItem::class) {

        override fun serialize(
            value: ResponseOutputItem,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.message != null -> generator.writeObject(value.message)
                value.fileSearchCall != null -> generator.writeObject(value.fileSearchCall)
                value.functionCall != null -> generator.writeObject(value.functionCall)
                value.webSearchCall != null -> generator.writeObject(value.webSearchCall)
                value.computerCall != null -> generator.writeObject(value.computerCall)
                value.reasoning != null -> generator.writeObject(value.reasoning)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ResponseOutputItem")
            }
        }
    }

    /**
     * A description of the chain of thought used by a reasoning model while generating a response.
     */
    @NoAutoDetect
    class Reasoning
    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("content")
        @ExcludeMissing
        private val content: JsonField<List<Content>> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
        @JsonProperty("status")
        @ExcludeMissing
        private val status: JsonField<Status> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The unique identifier of the reasoning content. */
        fun id(): String = id.getRequired("id")

        /** Reasoning text contents. */
        fun content(): List<Content> = content.getRequired("content")

        /** The type of the object. Always `reasoning`. */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The status of the item. One of `in_progress`, `completed`, or `incomplete`. Populated
         * when items are returned via API.
         */
        fun status(): Optional<Status> = Optional.ofNullable(status.getNullable("status"))

        /** The unique identifier of the reasoning content. */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /** Reasoning text contents. */
        @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<List<Content>> = content

        /**
         * The status of the item. One of `in_progress`, `completed`, or `incomplete`. Populated
         * when items are returned via API.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Reasoning = apply {
            if (validated) {
                return@apply
            }

            id()
            content().forEach { it.validate() }
            _type().let {
                if (it != JsonValue.from("reasoning")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            status()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Reasoning].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .content()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Reasoning]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var content: JsonField<MutableList<Content>>? = null
            private var type: JsonValue = JsonValue.from("reasoning")
            private var status: JsonField<Status> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(reasoning: Reasoning) = apply {
                id = reasoning.id
                content = reasoning.content.map { it.toMutableList() }
                type = reasoning.type
                status = reasoning.status
                additionalProperties = reasoning.additionalProperties.toMutableMap()
            }

            /** The unique identifier of the reasoning content. */
            fun id(id: String) = id(JsonField.of(id))

            /** The unique identifier of the reasoning content. */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** Reasoning text contents. */
            fun content(content: List<Content>) = content(JsonField.of(content))

            /** Reasoning text contents. */
            fun content(content: JsonField<List<Content>>) = apply {
                this.content = content.map { it.toMutableList() }
            }

            /** Reasoning text contents. */
            fun addContent(content: Content) = apply {
                this.content =
                    (this.content ?: JsonField.of(mutableListOf())).also {
                        checkKnown("content", it).add(content)
                    }
            }

            /** The type of the object. Always `reasoning`. */
            fun type(type: JsonValue) = apply { this.type = type }

            /**
             * The status of the item. One of `in_progress`, `completed`, or `incomplete`. Populated
             * when items are returned via API.
             */
            fun status(status: Status) = status(JsonField.of(status))

            /**
             * The status of the item. One of `in_progress`, `completed`, or `incomplete`. Populated
             * when items are returned via API.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

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

            fun build(): Reasoning =
                Reasoning(
                    checkRequired("id", id),
                    checkRequired("content", content).map { it.toImmutable() },
                    type,
                    status,
                    additionalProperties.toImmutable(),
                )
        }

        @NoAutoDetect
        class Content
        @JsonCreator
        private constructor(
            @JsonProperty("text")
            @ExcludeMissing
            private val text: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /** A short summary of the reasoning used by the model when generating the response. */
            fun text(): String = text.getRequired("text")

            /** The type of the object. Always `text`. */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /** A short summary of the reasoning used by the model when generating the response. */
            @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): Content = apply {
                if (validated) {
                    return@apply
                }

                text()
                _type().let {
                    if (it != JsonValue.from("reasoning_summary")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Content].
                 *
                 * The following fields are required:
                 * ```java
                 * .text()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Content]. */
            class Builder internal constructor() {

                private var text: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("reasoning_summary")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(content: Content) = apply {
                    text = content.text
                    type = content.type
                    additionalProperties = content.additionalProperties.toMutableMap()
                }

                /**
                 * A short summary of the reasoning used by the model when generating the response.
                 */
                fun text(text: String) = text(JsonField.of(text))

                /**
                 * A short summary of the reasoning used by the model when generating the response.
                 */
                fun text(text: JsonField<String>) = apply { this.text = text }

                /** The type of the object. Always `text`. */
                fun type(type: JsonValue) = apply { this.type = type }

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

                fun build(): Content =
                    Content(checkRequired("text", text), type, additionalProperties.toImmutable())
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Content && text == other.text && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(text, type, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Content{text=$text, type=$type, additionalProperties=$additionalProperties}"
        }

        /**
         * The status of the item. One of `in_progress`, `completed`, or `incomplete`. Populated
         * when items are returned via API.
         */
        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val IN_PROGRESS = of("in_progress")

                @JvmField val COMPLETED = of("completed")

                @JvmField val INCOMPLETE = of("incomplete")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                IN_PROGRESS,
                COMPLETED,
                INCOMPLETE,
            }

            /**
             * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Status] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                IN_PROGRESS,
                COMPLETED,
                INCOMPLETE,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    IN_PROGRESS -> Value.IN_PROGRESS
                    COMPLETED -> Value.COMPLETED
                    INCOMPLETE -> Value.INCOMPLETE
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws OpenAIInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    IN_PROGRESS -> Known.IN_PROGRESS
                    COMPLETED -> Known.COMPLETED
                    INCOMPLETE -> Known.INCOMPLETE
                    else -> throw OpenAIInvalidDataException("Unknown Status: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws OpenAIInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    OpenAIInvalidDataException("Value is not a String")
                }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Status && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Reasoning && id == other.id && content == other.content && type == other.type && status == other.status && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(id, content, type, status, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Reasoning{id=$id, content=$content, type=$type, status=$status, additionalProperties=$additionalProperties}"
    }
}
