// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses.inputitems

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
import com.openai.models.responses.ResponseComputerToolCall
import com.openai.models.responses.ResponseFileSearchToolCall
import com.openai.models.responses.ResponseFunctionToolCall
import com.openai.models.responses.ResponseFunctionWebSearch
import com.openai.models.responses.ResponseInputContent
import com.openai.models.responses.ResponseInputFile
import com.openai.models.responses.ResponseInputImage
import com.openai.models.responses.ResponseInputText
import com.openai.models.responses.ResponseOutputMessage
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A list of Response items. */
@NoAutoDetect
class ResponseItemList
@JsonCreator
private constructor(
    @JsonProperty("data")
    @ExcludeMissing
    private val data: JsonField<List<Data>> = JsonMissing.of(),
    @JsonProperty("first_id")
    @ExcludeMissing
    private val firstId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("has_more")
    @ExcludeMissing
    private val hasMore: JsonField<Boolean> = JsonMissing.of(),
    @JsonProperty("last_id")
    @ExcludeMissing
    private val lastId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("object") @ExcludeMissing private val object_: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** A list of items used to generate this response. */
    fun data(): List<Data> = data.getRequired("data")

    /** The ID of the first item in the list. */
    fun firstId(): String = firstId.getRequired("first_id")

    /** Whether there are more items available. */
    fun hasMore(): Boolean = hasMore.getRequired("has_more")

    /** The ID of the last item in the list. */
    fun lastId(): String = lastId.getRequired("last_id")

    /** The type of object returned, must be `list`. */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /** A list of items used to generate this response. */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<List<Data>> = data

    /** The ID of the first item in the list. */
    @JsonProperty("first_id") @ExcludeMissing fun _firstId(): JsonField<String> = firstId

    /** Whether there are more items available. */
    @JsonProperty("has_more") @ExcludeMissing fun _hasMore(): JsonField<Boolean> = hasMore

    /** The ID of the last item in the list. */
    @JsonProperty("last_id") @ExcludeMissing fun _lastId(): JsonField<String> = lastId

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ResponseItemList = apply {
        if (validated) {
            return@apply
        }

        data().forEach { it.validate() }
        firstId()
        hasMore()
        lastId()
        _object_().let {
            if (it != JsonValue.from("list")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ResponseItemList].
         *
         * The following fields are required:
         * ```java
         * .data()
         * .firstId()
         * .hasMore()
         * .lastId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseItemList]. */
    class Builder internal constructor() {

        private var data: JsonField<MutableList<Data>>? = null
        private var firstId: JsonField<String>? = null
        private var hasMore: JsonField<Boolean>? = null
        private var lastId: JsonField<String>? = null
        private var object_: JsonValue = JsonValue.from("list")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseItemList: ResponseItemList) = apply {
            data = responseItemList.data.map { it.toMutableList() }
            firstId = responseItemList.firstId
            hasMore = responseItemList.hasMore
            lastId = responseItemList.lastId
            object_ = responseItemList.object_
            additionalProperties = responseItemList.additionalProperties.toMutableMap()
        }

        /** A list of items used to generate this response. */
        fun data(data: List<Data>) = data(JsonField.of(data))

        /** A list of items used to generate this response. */
        fun data(data: JsonField<List<Data>>) = apply {
            this.data = data.map { it.toMutableList() }
        }

        /** A list of items used to generate this response. */
        fun addData(data: Data) = apply {
            this.data =
                (this.data ?: JsonField.of(mutableListOf())).also {
                    checkKnown("data", it).add(data)
                }
        }

        /** A list of items used to generate this response. */
        fun addData(message: Data.Message) = addData(Data.ofMessage(message))

        /** An output message from the model. */
        fun addData(responseOutputMessage: ResponseOutputMessage) =
            addData(Data.ofResponseOutputMessage(responseOutputMessage))

        /**
         * The results of a file search tool call. See the
         * [file search guide](https://platform.openai.com/docs/guides/tools-file-search) for more
         * information.
         */
        fun addData(fileSearchCall: ResponseFileSearchToolCall) =
            addData(Data.ofFileSearchCall(fileSearchCall))

        /**
         * A tool call to a computer use tool. See the
         * [computer use guide](https://platform.openai.com/docs/guides/tools-computer-use) for more
         * information.
         */
        fun addData(computerCall: ResponseComputerToolCall) =
            addData(Data.ofComputerCall(computerCall))

        /** A list of items used to generate this response. */
        fun addData(computerCallOutput: Data.ComputerCallOutput) =
            addData(Data.ofComputerCallOutput(computerCallOutput))

        /**
         * The results of a web search tool call. See the
         * [web search guide](https://platform.openai.com/docs/guides/tools-web-search) for more
         * information.
         */
        fun addData(webSearchCall: ResponseFunctionWebSearch) =
            addData(Data.ofWebSearchCall(webSearchCall))

        /**
         * A tool call to run a function. See the
         * [function calling guide](https://platform.openai.com/docs/guides/function-calling) for
         * more information.
         */
        fun addData(functionCall: ResponseFunctionToolCall) =
            addData(Data.ofFunctionCall(functionCall))

        /** A list of items used to generate this response. */
        fun addData(functionCallOutput: Data.FunctionCallOutput) =
            addData(Data.ofFunctionCallOutput(functionCallOutput))

        /** The ID of the first item in the list. */
        fun firstId(firstId: String) = firstId(JsonField.of(firstId))

        /** The ID of the first item in the list. */
        fun firstId(firstId: JsonField<String>) = apply { this.firstId = firstId }

        /** Whether there are more items available. */
        fun hasMore(hasMore: Boolean) = hasMore(JsonField.of(hasMore))

        /** Whether there are more items available. */
        fun hasMore(hasMore: JsonField<Boolean>) = apply { this.hasMore = hasMore }

        /** The ID of the last item in the list. */
        fun lastId(lastId: String) = lastId(JsonField.of(lastId))

        /** The ID of the last item in the list. */
        fun lastId(lastId: JsonField<String>) = apply { this.lastId = lastId }

        /** The type of object returned, must be `list`. */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

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

        fun build(): ResponseItemList =
            ResponseItemList(
                checkRequired("data", data).map { it.toImmutable() },
                checkRequired("firstId", firstId),
                checkRequired("hasMore", hasMore),
                checkRequired("lastId", lastId),
                object_,
                additionalProperties.toImmutable(),
            )
    }

    /** Content item used to generate a response. */
    @JsonDeserialize(using = Data.Deserializer::class)
    @JsonSerialize(using = Data.Serializer::class)
    class Data
    private constructor(
        private val message: Message? = null,
        private val responseOutputMessage: ResponseOutputMessage? = null,
        private val fileSearchCall: ResponseFileSearchToolCall? = null,
        private val computerCall: ResponseComputerToolCall? = null,
        private val computerCallOutput: ComputerCallOutput? = null,
        private val webSearchCall: ResponseFunctionWebSearch? = null,
        private val functionCall: ResponseFunctionToolCall? = null,
        private val functionCallOutput: FunctionCallOutput? = null,
        private val _json: JsonValue? = null,
    ) {

        fun message(): Optional<Message> = Optional.ofNullable(message)

        /** An output message from the model. */
        fun responseOutputMessage(): Optional<ResponseOutputMessage> =
            Optional.ofNullable(responseOutputMessage)

        /**
         * The results of a file search tool call. See the
         * [file search guide](https://platform.openai.com/docs/guides/tools-file-search) for more
         * information.
         */
        fun fileSearchCall(): Optional<ResponseFileSearchToolCall> =
            Optional.ofNullable(fileSearchCall)

        /**
         * A tool call to a computer use tool. See the
         * [computer use guide](https://platform.openai.com/docs/guides/tools-computer-use) for more
         * information.
         */
        fun computerCall(): Optional<ResponseComputerToolCall> = Optional.ofNullable(computerCall)

        fun computerCallOutput(): Optional<ComputerCallOutput> =
            Optional.ofNullable(computerCallOutput)

        /**
         * The results of a web search tool call. See the
         * [web search guide](https://platform.openai.com/docs/guides/tools-web-search) for more
         * information.
         */
        fun webSearchCall(): Optional<ResponseFunctionWebSearch> =
            Optional.ofNullable(webSearchCall)

        /**
         * A tool call to run a function. See the
         * [function calling guide](https://platform.openai.com/docs/guides/function-calling) for
         * more information.
         */
        fun functionCall(): Optional<ResponseFunctionToolCall> = Optional.ofNullable(functionCall)

        fun functionCallOutput(): Optional<FunctionCallOutput> =
            Optional.ofNullable(functionCallOutput)

        fun isMessage(): Boolean = message != null

        fun isResponseOutputMessage(): Boolean = responseOutputMessage != null

        fun isFileSearchCall(): Boolean = fileSearchCall != null

        fun isComputerCall(): Boolean = computerCall != null

        fun isComputerCallOutput(): Boolean = computerCallOutput != null

        fun isWebSearchCall(): Boolean = webSearchCall != null

        fun isFunctionCall(): Boolean = functionCall != null

        fun isFunctionCallOutput(): Boolean = functionCallOutput != null

        fun asMessage(): Message = message.getOrThrow("message")

        /** An output message from the model. */
        fun asResponseOutputMessage(): ResponseOutputMessage =
            responseOutputMessage.getOrThrow("responseOutputMessage")

        /**
         * The results of a file search tool call. See the
         * [file search guide](https://platform.openai.com/docs/guides/tools-file-search) for more
         * information.
         */
        fun asFileSearchCall(): ResponseFileSearchToolCall =
            fileSearchCall.getOrThrow("fileSearchCall")

        /**
         * A tool call to a computer use tool. See the
         * [computer use guide](https://platform.openai.com/docs/guides/tools-computer-use) for more
         * information.
         */
        fun asComputerCall(): ResponseComputerToolCall = computerCall.getOrThrow("computerCall")

        fun asComputerCallOutput(): ComputerCallOutput =
            computerCallOutput.getOrThrow("computerCallOutput")

        /**
         * The results of a web search tool call. See the
         * [web search guide](https://platform.openai.com/docs/guides/tools-web-search) for more
         * information.
         */
        fun asWebSearchCall(): ResponseFunctionWebSearch = webSearchCall.getOrThrow("webSearchCall")

        /**
         * A tool call to run a function. See the
         * [function calling guide](https://platform.openai.com/docs/guides/function-calling) for
         * more information.
         */
        fun asFunctionCall(): ResponseFunctionToolCall = functionCall.getOrThrow("functionCall")

        fun asFunctionCallOutput(): FunctionCallOutput =
            functionCallOutput.getOrThrow("functionCallOutput")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                message != null -> visitor.visitMessage(message)
                responseOutputMessage != null ->
                    visitor.visitResponseOutputMessage(responseOutputMessage)
                fileSearchCall != null -> visitor.visitFileSearchCall(fileSearchCall)
                computerCall != null -> visitor.visitComputerCall(computerCall)
                computerCallOutput != null -> visitor.visitComputerCallOutput(computerCallOutput)
                webSearchCall != null -> visitor.visitWebSearchCall(webSearchCall)
                functionCall != null -> visitor.visitFunctionCall(functionCall)
                functionCallOutput != null -> visitor.visitFunctionCallOutput(functionCallOutput)
                else -> visitor.unknown(_json)
            }
        }

        private var validated: Boolean = false

        fun validate(): Data = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitMessage(message: Message) {
                        message.validate()
                    }

                    override fun visitResponseOutputMessage(
                        responseOutputMessage: ResponseOutputMessage
                    ) {
                        responseOutputMessage.validate()
                    }

                    override fun visitFileSearchCall(fileSearchCall: ResponseFileSearchToolCall) {
                        fileSearchCall.validate()
                    }

                    override fun visitComputerCall(computerCall: ResponseComputerToolCall) {
                        computerCall.validate()
                    }

                    override fun visitComputerCallOutput(computerCallOutput: ComputerCallOutput) {
                        computerCallOutput.validate()
                    }

                    override fun visitWebSearchCall(webSearchCall: ResponseFunctionWebSearch) {
                        webSearchCall.validate()
                    }

                    override fun visitFunctionCall(functionCall: ResponseFunctionToolCall) {
                        functionCall.validate()
                    }

                    override fun visitFunctionCallOutput(functionCallOutput: FunctionCallOutput) {
                        functionCallOutput.validate()
                    }
                }
            )
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Data && message == other.message && responseOutputMessage == other.responseOutputMessage && fileSearchCall == other.fileSearchCall && computerCall == other.computerCall && computerCallOutput == other.computerCallOutput && webSearchCall == other.webSearchCall && functionCall == other.functionCall && functionCallOutput == other.functionCallOutput /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(message, responseOutputMessage, fileSearchCall, computerCall, computerCallOutput, webSearchCall, functionCall, functionCallOutput) /* spotless:on */

        override fun toString(): String =
            when {
                message != null -> "Data{message=$message}"
                responseOutputMessage != null ->
                    "Data{responseOutputMessage=$responseOutputMessage}"
                fileSearchCall != null -> "Data{fileSearchCall=$fileSearchCall}"
                computerCall != null -> "Data{computerCall=$computerCall}"
                computerCallOutput != null -> "Data{computerCallOutput=$computerCallOutput}"
                webSearchCall != null -> "Data{webSearchCall=$webSearchCall}"
                functionCall != null -> "Data{functionCall=$functionCall}"
                functionCallOutput != null -> "Data{functionCallOutput=$functionCallOutput}"
                _json != null -> "Data{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Data")
            }

        companion object {

            @JvmStatic fun ofMessage(message: Message) = Data(message = message)

            /** An output message from the model. */
            @JvmStatic
            fun ofResponseOutputMessage(responseOutputMessage: ResponseOutputMessage) =
                Data(responseOutputMessage = responseOutputMessage)

            /**
             * The results of a file search tool call. See the
             * [file search guide](https://platform.openai.com/docs/guides/tools-file-search) for
             * more information.
             */
            @JvmStatic
            fun ofFileSearchCall(fileSearchCall: ResponseFileSearchToolCall) =
                Data(fileSearchCall = fileSearchCall)

            /**
             * A tool call to a computer use tool. See the
             * [computer use guide](https://platform.openai.com/docs/guides/tools-computer-use) for
             * more information.
             */
            @JvmStatic
            fun ofComputerCall(computerCall: ResponseComputerToolCall) =
                Data(computerCall = computerCall)

            @JvmStatic
            fun ofComputerCallOutput(computerCallOutput: ComputerCallOutput) =
                Data(computerCallOutput = computerCallOutput)

            /**
             * The results of a web search tool call. See the
             * [web search guide](https://platform.openai.com/docs/guides/tools-web-search) for more
             * information.
             */
            @JvmStatic
            fun ofWebSearchCall(webSearchCall: ResponseFunctionWebSearch) =
                Data(webSearchCall = webSearchCall)

            /**
             * A tool call to run a function. See the
             * [function calling guide](https://platform.openai.com/docs/guides/function-calling)
             * for more information.
             */
            @JvmStatic
            fun ofFunctionCall(functionCall: ResponseFunctionToolCall) =
                Data(functionCall = functionCall)

            @JvmStatic
            fun ofFunctionCallOutput(functionCallOutput: FunctionCallOutput) =
                Data(functionCallOutput = functionCallOutput)
        }

        /** An interface that defines how to map each variant of [Data] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitMessage(message: Message): T

            /** An output message from the model. */
            fun visitResponseOutputMessage(responseOutputMessage: ResponseOutputMessage): T

            /**
             * The results of a file search tool call. See the
             * [file search guide](https://platform.openai.com/docs/guides/tools-file-search) for
             * more information.
             */
            fun visitFileSearchCall(fileSearchCall: ResponseFileSearchToolCall): T

            /**
             * A tool call to a computer use tool. See the
             * [computer use guide](https://platform.openai.com/docs/guides/tools-computer-use) for
             * more information.
             */
            fun visitComputerCall(computerCall: ResponseComputerToolCall): T

            fun visitComputerCallOutput(computerCallOutput: ComputerCallOutput): T

            /**
             * The results of a web search tool call. See the
             * [web search guide](https://platform.openai.com/docs/guides/tools-web-search) for more
             * information.
             */
            fun visitWebSearchCall(webSearchCall: ResponseFunctionWebSearch): T

            /**
             * A tool call to run a function. See the
             * [function calling guide](https://platform.openai.com/docs/guides/function-calling)
             * for more information.
             */
            fun visitFunctionCall(functionCall: ResponseFunctionToolCall): T

            fun visitFunctionCallOutput(functionCallOutput: FunctionCallOutput): T

            /**
             * Maps an unknown variant of [Data] to a value of type [T].
             *
             * An instance of [Data] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Data: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Data>(Data::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Data {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "message" -> {
                        tryDeserialize(node, jacksonTypeRef<Message>()) { it.validate() }
                            ?.let {
                                return Data(message = it, _json = json)
                            }
                        tryDeserialize(node, jacksonTypeRef<ResponseOutputMessage>()) {
                                it.validate()
                            }
                            ?.let {
                                return Data(responseOutputMessage = it, _json = json)
                            }
                    }
                    "file_search_call" -> {
                        tryDeserialize(node, jacksonTypeRef<ResponseFileSearchToolCall>()) {
                                it.validate()
                            }
                            ?.let {
                                return Data(fileSearchCall = it, _json = json)
                            }
                    }
                    "computer_call" -> {
                        tryDeserialize(node, jacksonTypeRef<ResponseComputerToolCall>()) {
                                it.validate()
                            }
                            ?.let {
                                return Data(computerCall = it, _json = json)
                            }
                    }
                    "computer_call_output" -> {
                        tryDeserialize(node, jacksonTypeRef<ComputerCallOutput>()) { it.validate() }
                            ?.let {
                                return Data(computerCallOutput = it, _json = json)
                            }
                    }
                    "web_search_call" -> {
                        tryDeserialize(node, jacksonTypeRef<ResponseFunctionWebSearch>()) {
                                it.validate()
                            }
                            ?.let {
                                return Data(webSearchCall = it, _json = json)
                            }
                    }
                    "function_call" -> {
                        tryDeserialize(node, jacksonTypeRef<ResponseFunctionToolCall>()) {
                                it.validate()
                            }
                            ?.let {
                                return Data(functionCall = it, _json = json)
                            }
                    }
                    "function_call_output" -> {
                        tryDeserialize(node, jacksonTypeRef<FunctionCallOutput>()) { it.validate() }
                            ?.let {
                                return Data(functionCallOutput = it, _json = json)
                            }
                    }
                }

                return Data(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Data>(Data::class) {

            override fun serialize(
                value: Data,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.message != null -> generator.writeObject(value.message)
                    value.responseOutputMessage != null ->
                        generator.writeObject(value.responseOutputMessage)
                    value.fileSearchCall != null -> generator.writeObject(value.fileSearchCall)
                    value.computerCall != null -> generator.writeObject(value.computerCall)
                    value.computerCallOutput != null ->
                        generator.writeObject(value.computerCallOutput)
                    value.webSearchCall != null -> generator.writeObject(value.webSearchCall)
                    value.functionCall != null -> generator.writeObject(value.functionCall)
                    value.functionCallOutput != null ->
                        generator.writeObject(value.functionCallOutput)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Data")
                }
            }
        }

        @NoAutoDetect
        class Message
        @JsonCreator
        private constructor(
            @JsonProperty("id")
            @ExcludeMissing
            private val id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("content")
            @ExcludeMissing
            private val content: JsonField<List<ResponseInputContent>> = JsonMissing.of(),
            @JsonProperty("role")
            @ExcludeMissing
            private val role: JsonField<Role> = JsonMissing.of(),
            @JsonProperty("status")
            @ExcludeMissing
            private val status: JsonField<Status> = JsonMissing.of(),
            @JsonProperty("type")
            @ExcludeMissing
            private val type: JsonField<Type> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /** The unique ID of the message input. */
            fun id(): String = id.getRequired("id")

            /**
             * A list of one or many input items to the model, containing different content types.
             */
            fun content(): List<ResponseInputContent> = content.getRequired("content")

            /** The role of the message input. One of `user`, `system`, or `developer`. */
            fun role(): Role = role.getRequired("role")

            /**
             * The status of item. One of `in_progress`, `completed`, or `incomplete`. Populated
             * when items are returned via API.
             */
            fun status(): Optional<Status> = Optional.ofNullable(status.getNullable("status"))

            /** The type of the message input. Always set to `message`. */
            fun type(): Optional<Type> = Optional.ofNullable(type.getNullable("type"))

            /** The unique ID of the message input. */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /**
             * A list of one or many input items to the model, containing different content types.
             */
            @JsonProperty("content")
            @ExcludeMissing
            fun _content(): JsonField<List<ResponseInputContent>> = content

            /** The role of the message input. One of `user`, `system`, or `developer`. */
            @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<Role> = role

            /**
             * The status of item. One of `in_progress`, `completed`, or `incomplete`. Populated
             * when items are returned via API.
             */
            @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

            /** The type of the message input. Always set to `message`. */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): Message = apply {
                if (validated) {
                    return@apply
                }

                id()
                content().forEach { it.validate() }
                role()
                status()
                type()
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Message].
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .content()
                 * .role()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Message]. */
            class Builder internal constructor() {

                private var id: JsonField<String>? = null
                private var content: JsonField<MutableList<ResponseInputContent>>? = null
                private var role: JsonField<Role>? = null
                private var status: JsonField<Status> = JsonMissing.of()
                private var type: JsonField<Type> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(message: Message) = apply {
                    id = message.id
                    content = message.content.map { it.toMutableList() }
                    role = message.role
                    status = message.status
                    type = message.type
                    additionalProperties = message.additionalProperties.toMutableMap()
                }

                /** The unique ID of the message input. */
                fun id(id: String) = id(JsonField.of(id))

                /** The unique ID of the message input. */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /**
                 * A list of one or many input items to the model, containing different content
                 * types.
                 */
                fun content(content: List<ResponseInputContent>) = content(JsonField.of(content))

                /**
                 * A list of one or many input items to the model, containing different content
                 * types.
                 */
                fun content(content: JsonField<List<ResponseInputContent>>) = apply {
                    this.content = content.map { it.toMutableList() }
                }

                /**
                 * A list of one or many input items to the model, containing different content
                 * types.
                 */
                fun addContent(content: ResponseInputContent) = apply {
                    this.content =
                        (this.content ?: JsonField.of(mutableListOf())).also {
                            checkKnown("content", it).add(content)
                        }
                }

                /** A text input to the model. */
                fun addContent(inputText: ResponseInputText) =
                    addContent(ResponseInputContent.ofInputText(inputText))

                /** A text input to the model. */
                fun addInputTextContent(text: String) =
                    addContent(ResponseInputText.builder().text(text).build())

                /**
                 * An image input to the model. Learn about
                 * [image inputs](https://platform.openai.com/docs/guides/vision).
                 */
                fun addContent(inputImage: ResponseInputImage) =
                    addContent(ResponseInputContent.ofInputImage(inputImage))

                /**
                 * An image input to the model. Learn about
                 * [image inputs](https://platform.openai.com/docs/guides/vision).
                 */
                fun addInputImageContent(detail: ResponseInputImage.Detail) =
                    addContent(ResponseInputImage.builder().detail(detail).build())

                /** A file input to the model. */
                fun addContent(inputFile: ResponseInputFile) =
                    addContent(ResponseInputContent.ofInputFile(inputFile))

                /** The role of the message input. One of `user`, `system`, or `developer`. */
                fun role(role: Role) = role(JsonField.of(role))

                /** The role of the message input. One of `user`, `system`, or `developer`. */
                fun role(role: JsonField<Role>) = apply { this.role = role }

                /**
                 * The status of item. One of `in_progress`, `completed`, or `incomplete`. Populated
                 * when items are returned via API.
                 */
                fun status(status: Status) = status(JsonField.of(status))

                /**
                 * The status of item. One of `in_progress`, `completed`, or `incomplete`. Populated
                 * when items are returned via API.
                 */
                fun status(status: JsonField<Status>) = apply { this.status = status }

                /** The type of the message input. Always set to `message`. */
                fun type(type: Type) = type(JsonField.of(type))

                /** The type of the message input. Always set to `message`. */
                fun type(type: JsonField<Type>) = apply { this.type = type }

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

                fun build(): Message =
                    Message(
                        checkRequired("id", id),
                        checkRequired("content", content).map { it.toImmutable() },
                        checkRequired("role", role),
                        status,
                        type,
                        additionalProperties.toImmutable(),
                    )
            }

            /** The role of the message input. One of `user`, `system`, or `developer`. */
            class Role @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val USER = of("user")

                    @JvmField val SYSTEM = of("system")

                    @JvmField val DEVELOPER = of("developer")

                    @JvmStatic fun of(value: String) = Role(JsonField.of(value))
                }

                /** An enum containing [Role]'s known values. */
                enum class Known {
                    USER,
                    SYSTEM,
                    DEVELOPER,
                }

                /**
                 * An enum containing [Role]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Role] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    USER,
                    SYSTEM,
                    DEVELOPER,
                    /**
                     * An enum member indicating that [Role] was instantiated with an unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        USER -> Value.USER
                        SYSTEM -> Value.SYSTEM
                        DEVELOPER -> Value.DEVELOPER
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value is a not a
                 *   known member.
                 */
                fun known(): Known =
                    when (this) {
                        USER -> Known.USER
                        SYSTEM -> Known.SYSTEM
                        DEVELOPER -> Known.DEVELOPER
                        else -> throw OpenAIInvalidDataException("Unknown Role: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        OpenAIInvalidDataException("Value is not a String")
                    }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Role && value == other.value /* spotless:on */
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            /**
             * The status of item. One of `in_progress`, `completed`, or `incomplete`. Populated
             * when items are returned via API.
             */
            class Status @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
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
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    IN_PROGRESS,
                    COMPLETED,
                    INCOMPLETE,
                    /**
                     * An enum member indicating that [Status] was instantiated with an unknown
                     * value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
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
                 * @throws OpenAIInvalidDataException if this class instance's value is a not a
                 *   known member.
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
                 * @throws OpenAIInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
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

            /** The type of the message input. Always set to `message`. */
            class Type @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val MESSAGE = of("message")

                    @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    MESSAGE
                }

                /**
                 * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Type] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    MESSAGE,
                    /**
                     * An enum member indicating that [Type] was instantiated with an unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        MESSAGE -> Value.MESSAGE
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value is a not a
                 *   known member.
                 */
                fun known(): Known =
                    when (this) {
                        MESSAGE -> Known.MESSAGE
                        else -> throw OpenAIInvalidDataException("Unknown Type: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        OpenAIInvalidDataException("Value is not a String")
                    }

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

                return /* spotless:off */ other is Message && id == other.id && content == other.content && role == other.role && status == other.status && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(id, content, role, status, type, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Message{id=$id, content=$content, role=$role, status=$status, type=$type, additionalProperties=$additionalProperties}"
        }

        @NoAutoDetect
        class ComputerCallOutput
        @JsonCreator
        private constructor(
            @JsonProperty("id")
            @ExcludeMissing
            private val id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("call_id")
            @ExcludeMissing
            private val callId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output")
            @ExcludeMissing
            private val output: JsonField<Output> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
            @JsonProperty("acknowledged_safety_checks")
            @ExcludeMissing
            private val acknowledgedSafetyChecks: JsonField<List<AcknowledgedSafetyCheck>> =
                JsonMissing.of(),
            @JsonProperty("status")
            @ExcludeMissing
            private val status: JsonField<Status> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /** The unique ID of the computer call tool output. */
            fun id(): String = id.getRequired("id")

            /** The ID of the computer tool call that produced the output. */
            fun callId(): String = callId.getRequired("call_id")

            /** A computer screenshot image used with the computer use tool. */
            fun output(): Output = output.getRequired("output")

            /** The type of the computer tool call output. Always `computer_call_output`. */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * The safety checks reported by the API that have been acknowledged by the developer.
             */
            fun acknowledgedSafetyChecks(): Optional<List<AcknowledgedSafetyCheck>> =
                Optional.ofNullable(
                    acknowledgedSafetyChecks.getNullable("acknowledged_safety_checks")
                )

            /**
             * The status of the message input. One of `in_progress`, `completed`, or `incomplete`.
             * Populated when input items are returned via API.
             */
            fun status(): Optional<Status> = Optional.ofNullable(status.getNullable("status"))

            /** The unique ID of the computer call tool output. */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /** The ID of the computer tool call that produced the output. */
            @JsonProperty("call_id") @ExcludeMissing fun _callId(): JsonField<String> = callId

            /** A computer screenshot image used with the computer use tool. */
            @JsonProperty("output") @ExcludeMissing fun _output(): JsonField<Output> = output

            /**
             * The safety checks reported by the API that have been acknowledged by the developer.
             */
            @JsonProperty("acknowledged_safety_checks")
            @ExcludeMissing
            fun _acknowledgedSafetyChecks(): JsonField<List<AcknowledgedSafetyCheck>> =
                acknowledgedSafetyChecks

            /**
             * The status of the message input. One of `in_progress`, `completed`, or `incomplete`.
             * Populated when input items are returned via API.
             */
            @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): ComputerCallOutput = apply {
                if (validated) {
                    return@apply
                }

                id()
                callId()
                output().validate()
                _type().let {
                    if (it != JsonValue.from("computer_call_output")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                acknowledgedSafetyChecks().ifPresent { it.forEach { it.validate() } }
                status()
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [ComputerCallOutput].
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .callId()
                 * .output()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ComputerCallOutput]. */
            class Builder internal constructor() {

                private var id: JsonField<String>? = null
                private var callId: JsonField<String>? = null
                private var output: JsonField<Output>? = null
                private var type: JsonValue = JsonValue.from("computer_call_output")
                private var acknowledgedSafetyChecks:
                    JsonField<MutableList<AcknowledgedSafetyCheck>>? =
                    null
                private var status: JsonField<Status> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(computerCallOutput: ComputerCallOutput) = apply {
                    id = computerCallOutput.id
                    callId = computerCallOutput.callId
                    output = computerCallOutput.output
                    type = computerCallOutput.type
                    acknowledgedSafetyChecks =
                        computerCallOutput.acknowledgedSafetyChecks.map { it.toMutableList() }
                    status = computerCallOutput.status
                    additionalProperties = computerCallOutput.additionalProperties.toMutableMap()
                }

                /** The unique ID of the computer call tool output. */
                fun id(id: String) = id(JsonField.of(id))

                /** The unique ID of the computer call tool output. */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /** The ID of the computer tool call that produced the output. */
                fun callId(callId: String) = callId(JsonField.of(callId))

                /** The ID of the computer tool call that produced the output. */
                fun callId(callId: JsonField<String>) = apply { this.callId = callId }

                /** A computer screenshot image used with the computer use tool. */
                fun output(output: Output) = output(JsonField.of(output))

                /** A computer screenshot image used with the computer use tool. */
                fun output(output: JsonField<Output>) = apply { this.output = output }

                /** The type of the computer tool call output. Always `computer_call_output`. */
                fun type(type: JsonValue) = apply { this.type = type }

                /**
                 * The safety checks reported by the API that have been acknowledged by the
                 * developer.
                 */
                fun acknowledgedSafetyChecks(
                    acknowledgedSafetyChecks: List<AcknowledgedSafetyCheck>
                ) = acknowledgedSafetyChecks(JsonField.of(acknowledgedSafetyChecks))

                /**
                 * The safety checks reported by the API that have been acknowledged by the
                 * developer.
                 */
                fun acknowledgedSafetyChecks(
                    acknowledgedSafetyChecks: JsonField<List<AcknowledgedSafetyCheck>>
                ) = apply {
                    this.acknowledgedSafetyChecks =
                        acknowledgedSafetyChecks.map { it.toMutableList() }
                }

                /**
                 * The safety checks reported by the API that have been acknowledged by the
                 * developer.
                 */
                fun addAcknowledgedSafetyCheck(acknowledgedSafetyCheck: AcknowledgedSafetyCheck) =
                    apply {
                        acknowledgedSafetyChecks =
                            (acknowledgedSafetyChecks ?: JsonField.of(mutableListOf())).also {
                                checkKnown("acknowledgedSafetyChecks", it)
                                    .add(acknowledgedSafetyCheck)
                            }
                    }

                /**
                 * The status of the message input. One of `in_progress`, `completed`, or
                 * `incomplete`. Populated when input items are returned via API.
                 */
                fun status(status: Status) = status(JsonField.of(status))

                /**
                 * The status of the message input. One of `in_progress`, `completed`, or
                 * `incomplete`. Populated when input items are returned via API.
                 */
                fun status(status: JsonField<Status>) = apply { this.status = status }

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

                fun build(): ComputerCallOutput =
                    ComputerCallOutput(
                        checkRequired("id", id),
                        checkRequired("callId", callId),
                        checkRequired("output", output),
                        type,
                        (acknowledgedSafetyChecks ?: JsonMissing.of()).map { it.toImmutable() },
                        status,
                        additionalProperties.toImmutable(),
                    )
            }

            /** A computer screenshot image used with the computer use tool. */
            @NoAutoDetect
            class Output
            @JsonCreator
            private constructor(
                @JsonProperty("type")
                @ExcludeMissing
                private val type: JsonValue = JsonMissing.of(),
                @JsonProperty("file_id")
                @ExcludeMissing
                private val fileId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("image_url")
                @ExcludeMissing
                private val imageUrl: JsonField<String> = JsonMissing.of(),
                @JsonAnySetter
                private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
            ) {

                /**
                 * Specifies the event type. For a computer screenshot, this property is always set
                 * to `computer_screenshot`.
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                /** The identifier of an uploaded file that contains the screenshot. */
                fun fileId(): Optional<String> = Optional.ofNullable(fileId.getNullable("file_id"))

                /** The URL of the screenshot image. */
                fun imageUrl(): Optional<String> =
                    Optional.ofNullable(imageUrl.getNullable("image_url"))

                /** The identifier of an uploaded file that contains the screenshot. */
                @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

                /** The URL of the screenshot image. */
                @JsonProperty("image_url")
                @ExcludeMissing
                fun _imageUrl(): JsonField<String> = imageUrl

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                private var validated: Boolean = false

                fun validate(): Output = apply {
                    if (validated) {
                        return@apply
                    }

                    _type().let {
                        if (it != JsonValue.from("computer_screenshot")) {
                            throw OpenAIInvalidDataException("'type' is invalid, received $it")
                        }
                    }
                    fileId()
                    imageUrl()
                    validated = true
                }

                fun toBuilder() = Builder().from(this)

                companion object {

                    /** Returns a mutable builder for constructing an instance of [Output]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Output]. */
                class Builder internal constructor() {

                    private var type: JsonValue = JsonValue.from("computer_screenshot")
                    private var fileId: JsonField<String> = JsonMissing.of()
                    private var imageUrl: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(output: Output) = apply {
                        type = output.type
                        fileId = output.fileId
                        imageUrl = output.imageUrl
                        additionalProperties = output.additionalProperties.toMutableMap()
                    }

                    /**
                     * Specifies the event type. For a computer screenshot, this property is always
                     * set to `computer_screenshot`.
                     */
                    fun type(type: JsonValue) = apply { this.type = type }

                    /** The identifier of an uploaded file that contains the screenshot. */
                    fun fileId(fileId: String) = fileId(JsonField.of(fileId))

                    /** The identifier of an uploaded file that contains the screenshot. */
                    fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

                    /** The URL of the screenshot image. */
                    fun imageUrl(imageUrl: String) = imageUrl(JsonField.of(imageUrl))

                    /** The URL of the screenshot image. */
                    fun imageUrl(imageUrl: JsonField<String>) = apply { this.imageUrl = imageUrl }

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

                    fun build(): Output =
                        Output(type, fileId, imageUrl, additionalProperties.toImmutable())
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Output && type == other.type && fileId == other.fileId && imageUrl == other.imageUrl && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(type, fileId, imageUrl, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Output{type=$type, fileId=$fileId, imageUrl=$imageUrl, additionalProperties=$additionalProperties}"
            }

            /** A pending safety check for the computer call. */
            @NoAutoDetect
            class AcknowledgedSafetyCheck
            @JsonCreator
            private constructor(
                @JsonProperty("id")
                @ExcludeMissing
                private val id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("code")
                @ExcludeMissing
                private val code: JsonField<String> = JsonMissing.of(),
                @JsonProperty("message")
                @ExcludeMissing
                private val message: JsonField<String> = JsonMissing.of(),
                @JsonAnySetter
                private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
            ) {

                /** The ID of the pending safety check. */
                fun id(): String = id.getRequired("id")

                /** The type of the pending safety check. */
                fun code(): String = code.getRequired("code")

                /** Details about the pending safety check. */
                fun message(): String = message.getRequired("message")

                /** The ID of the pending safety check. */
                @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

                /** The type of the pending safety check. */
                @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<String> = code

                /** Details about the pending safety check. */
                @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                private var validated: Boolean = false

                fun validate(): AcknowledgedSafetyCheck = apply {
                    if (validated) {
                        return@apply
                    }

                    id()
                    code()
                    message()
                    validated = true
                }

                fun toBuilder() = Builder().from(this)

                companion object {

                    /**
                     * Returns a mutable builder for constructing an instance of
                     * [AcknowledgedSafetyCheck].
                     *
                     * The following fields are required:
                     * ```java
                     * .id()
                     * .code()
                     * .message()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [AcknowledgedSafetyCheck]. */
                class Builder internal constructor() {

                    private var id: JsonField<String>? = null
                    private var code: JsonField<String>? = null
                    private var message: JsonField<String>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(acknowledgedSafetyCheck: AcknowledgedSafetyCheck) = apply {
                        id = acknowledgedSafetyCheck.id
                        code = acknowledgedSafetyCheck.code
                        message = acknowledgedSafetyCheck.message
                        additionalProperties =
                            acknowledgedSafetyCheck.additionalProperties.toMutableMap()
                    }

                    /** The ID of the pending safety check. */
                    fun id(id: String) = id(JsonField.of(id))

                    /** The ID of the pending safety check. */
                    fun id(id: JsonField<String>) = apply { this.id = id }

                    /** The type of the pending safety check. */
                    fun code(code: String) = code(JsonField.of(code))

                    /** The type of the pending safety check. */
                    fun code(code: JsonField<String>) = apply { this.code = code }

                    /** Details about the pending safety check. */
                    fun message(message: String) = message(JsonField.of(message))

                    /** Details about the pending safety check. */
                    fun message(message: JsonField<String>) = apply { this.message = message }

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

                    fun build(): AcknowledgedSafetyCheck =
                        AcknowledgedSafetyCheck(
                            checkRequired("id", id),
                            checkRequired("code", code),
                            checkRequired("message", message),
                            additionalProperties.toImmutable(),
                        )
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is AcknowledgedSafetyCheck && id == other.id && code == other.code && message == other.message && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(id, code, message, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "AcknowledgedSafetyCheck{id=$id, code=$code, message=$message, additionalProperties=$additionalProperties}"
            }

            /**
             * The status of the message input. One of `in_progress`, `completed`, or `incomplete`.
             * Populated when input items are returned via API.
             */
            class Status @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
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
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    IN_PROGRESS,
                    COMPLETED,
                    INCOMPLETE,
                    /**
                     * An enum member indicating that [Status] was instantiated with an unknown
                     * value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
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
                 * @throws OpenAIInvalidDataException if this class instance's value is a not a
                 *   known member.
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
                 * @throws OpenAIInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
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

                return /* spotless:off */ other is ComputerCallOutput && id == other.id && callId == other.callId && output == other.output && type == other.type && acknowledgedSafetyChecks == other.acknowledgedSafetyChecks && status == other.status && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(id, callId, output, type, acknowledgedSafetyChecks, status, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ComputerCallOutput{id=$id, callId=$callId, output=$output, type=$type, acknowledgedSafetyChecks=$acknowledgedSafetyChecks, status=$status, additionalProperties=$additionalProperties}"
        }

        @NoAutoDetect
        class FunctionCallOutput
        @JsonCreator
        private constructor(
            @JsonProperty("id")
            @ExcludeMissing
            private val id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("call_id")
            @ExcludeMissing
            private val callId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("output")
            @ExcludeMissing
            private val output: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
            @JsonProperty("status")
            @ExcludeMissing
            private val status: JsonField<Status> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /** The unique ID of the function call tool output. */
            fun id(): String = id.getRequired("id")

            /** The unique ID of the function tool call generated by the model. */
            fun callId(): String = callId.getRequired("call_id")

            /** A JSON string of the output of the function tool call. */
            fun output(): String = output.getRequired("output")

            /** The type of the function tool call output. Always `function_call_output`. */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * The status of the item. One of `in_progress`, `completed`, or `incomplete`. Populated
             * when items are returned via API.
             */
            fun status(): Optional<Status> = Optional.ofNullable(status.getNullable("status"))

            /** The unique ID of the function call tool output. */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /** The unique ID of the function tool call generated by the model. */
            @JsonProperty("call_id") @ExcludeMissing fun _callId(): JsonField<String> = callId

            /** A JSON string of the output of the function tool call. */
            @JsonProperty("output") @ExcludeMissing fun _output(): JsonField<String> = output

            /**
             * The status of the item. One of `in_progress`, `completed`, or `incomplete`. Populated
             * when items are returned via API.
             */
            @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): FunctionCallOutput = apply {
                if (validated) {
                    return@apply
                }

                id()
                callId()
                output()
                _type().let {
                    if (it != JsonValue.from("function_call_output")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                status()
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [FunctionCallOutput].
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .callId()
                 * .output()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [FunctionCallOutput]. */
            class Builder internal constructor() {

                private var id: JsonField<String>? = null
                private var callId: JsonField<String>? = null
                private var output: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("function_call_output")
                private var status: JsonField<Status> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(functionCallOutput: FunctionCallOutput) = apply {
                    id = functionCallOutput.id
                    callId = functionCallOutput.callId
                    output = functionCallOutput.output
                    type = functionCallOutput.type
                    status = functionCallOutput.status
                    additionalProperties = functionCallOutput.additionalProperties.toMutableMap()
                }

                /** The unique ID of the function call tool output. */
                fun id(id: String) = id(JsonField.of(id))

                /** The unique ID of the function call tool output. */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /** The unique ID of the function tool call generated by the model. */
                fun callId(callId: String) = callId(JsonField.of(callId))

                /** The unique ID of the function tool call generated by the model. */
                fun callId(callId: JsonField<String>) = apply { this.callId = callId }

                /** A JSON string of the output of the function tool call. */
                fun output(output: String) = output(JsonField.of(output))

                /** A JSON string of the output of the function tool call. */
                fun output(output: JsonField<String>) = apply { this.output = output }

                /** The type of the function tool call output. Always `function_call_output`. */
                fun type(type: JsonValue) = apply { this.type = type }

                /**
                 * The status of the item. One of `in_progress`, `completed`, or `incomplete`.
                 * Populated when items are returned via API.
                 */
                fun status(status: Status) = status(JsonField.of(status))

                /**
                 * The status of the item. One of `in_progress`, `completed`, or `incomplete`.
                 * Populated when items are returned via API.
                 */
                fun status(status: JsonField<Status>) = apply { this.status = status }

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

                fun build(): FunctionCallOutput =
                    FunctionCallOutput(
                        checkRequired("id", id),
                        checkRequired("callId", callId),
                        checkRequired("output", output),
                        type,
                        status,
                        additionalProperties.toImmutable(),
                    )
            }

            /**
             * The status of the item. One of `in_progress`, `completed`, or `incomplete`. Populated
             * when items are returned via API.
             */
            class Status @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
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
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    IN_PROGRESS,
                    COMPLETED,
                    INCOMPLETE,
                    /**
                     * An enum member indicating that [Status] was instantiated with an unknown
                     * value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
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
                 * @throws OpenAIInvalidDataException if this class instance's value is a not a
                 *   known member.
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
                 * @throws OpenAIInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
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

                return /* spotless:off */ other is FunctionCallOutput && id == other.id && callId == other.callId && output == other.output && type == other.type && status == other.status && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(id, callId, output, type, status, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "FunctionCallOutput{id=$id, callId=$callId, output=$output, type=$type, status=$status, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseItemList && data == other.data && firstId == other.firstId && hasMore == other.hasMore && lastId == other.lastId && object_ == other.object_ && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(data, firstId, hasMore, lastId, object_, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseItemList{data=$data, firstId=$firstId, hasMore=$hasMore, lastId=$lastId, object_=$object_, additionalProperties=$additionalProperties}"
}
