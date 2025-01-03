// File generated from our OpenAPI spec by Stainless.

package com.openai.models

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
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class BetaThreadCreateParams
constructor(
    private val body: BetaThreadCreateBody,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) {

    /**
     * A list of [messages](https://platform.openai.com/docs/api-reference/messages) to start the
     * thread with.
     */
    fun messages(): Optional<List<Message>> = body.messages()

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format. Keys can be a maximum of 64
     * characters long and values can be a maximum of 512 characters long.
     */
    fun metadata(): Optional<JsonValue> = body.metadata()

    /**
     * A set of resources that are made available to the assistant's tools in this thread. The
     * resources are specific to the type of tool. For example, the `code_interpreter` tool requires
     * a list of file IDs, while the `file_search` tool requires a list of vector store IDs.
     */
    fun toolResources(): Optional<ToolResources> = body.toolResources()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    @JvmSynthetic internal fun getBody(): BetaThreadCreateBody = body

    @JvmSynthetic internal fun getHeaders(): Headers = additionalHeaders

    @JvmSynthetic internal fun getQueryParams(): QueryParams = additionalQueryParams

    @NoAutoDetect
    class BetaThreadCreateBody
    @JsonCreator
    internal constructor(
        @JsonProperty("messages") private val messages: List<Message>?,
        @JsonProperty("metadata") private val metadata: JsonValue?,
        @JsonProperty("tool_resources") private val toolResources: ToolResources?,
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * A list of [messages](https://platform.openai.com/docs/api-reference/messages) to start
         * the thread with.
         */
        @JsonProperty("messages")
        fun messages(): Optional<List<Message>> = Optional.ofNullable(messages)

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format. Keys can be a
         * maximum of 64 characters long and values can be a maximum of 512 characters long.
         */
        @JsonProperty("metadata")
        fun metadata(): Optional<JsonValue> = Optional.ofNullable(metadata)

        /**
         * A set of resources that are made available to the assistant's tools in this thread. The
         * resources are specific to the type of tool. For example, the `code_interpreter` tool
         * requires a list of file IDs, while the `file_search` tool requires a list of vector store
         * IDs.
         */
        @JsonProperty("tool_resources")
        fun toolResources(): Optional<ToolResources> = Optional.ofNullable(toolResources)

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var messages: MutableList<Message>? = null
            private var metadata: JsonValue? = null
            private var toolResources: ToolResources? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(betaThreadCreateBody: BetaThreadCreateBody) = apply {
                messages = betaThreadCreateBody.messages?.toMutableList()
                metadata = betaThreadCreateBody.metadata
                toolResources = betaThreadCreateBody.toolResources
                additionalProperties = betaThreadCreateBody.additionalProperties.toMutableMap()
            }

            /**
             * A list of [messages](https://platform.openai.com/docs/api-reference/messages) to
             * start the thread with.
             */
            fun messages(messages: List<Message>) = apply {
                this.messages = messages.toMutableList()
            }

            /**
             * A list of [messages](https://platform.openai.com/docs/api-reference/messages) to
             * start the thread with.
             */
            fun addMessage(message: Message) = apply {
                messages = (messages ?: mutableListOf()).apply { add(message) }
            }

            /**
             * Set of 16 key-value pairs that can be attached to an object. This can be useful for
             * storing additional information about the object in a structured format. Keys can be a
             * maximum of 64 characters long and values can be a maximum of 512 characters long.
             */
            fun metadata(metadata: JsonValue) = apply { this.metadata = metadata }

            /**
             * A set of resources that are made available to the assistant's tools in this thread.
             * The resources are specific to the type of tool. For example, the `code_interpreter`
             * tool requires a list of file IDs, while the `file_search` tool requires a list of
             * vector store IDs.
             */
            fun toolResources(toolResources: ToolResources) = apply {
                this.toolResources = toolResources
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

            fun build(): BetaThreadCreateBody =
                BetaThreadCreateBody(
                    messages?.toImmutable(),
                    metadata,
                    toolResources,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is BetaThreadCreateBody && messages == other.messages && metadata == other.metadata && toolResources == other.toolResources && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(messages, metadata, toolResources, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "BetaThreadCreateBody{messages=$messages, metadata=$metadata, toolResources=$toolResources, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var body: BetaThreadCreateBody.Builder = BetaThreadCreateBody.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(betaThreadCreateParams: BetaThreadCreateParams) = apply {
            body = betaThreadCreateParams.body.toBuilder()
            additionalHeaders = betaThreadCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = betaThreadCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * A list of [messages](https://platform.openai.com/docs/api-reference/messages) to start
         * the thread with.
         */
        fun messages(messages: List<Message>) = apply { body.messages(messages) }

        /**
         * A list of [messages](https://platform.openai.com/docs/api-reference/messages) to start
         * the thread with.
         */
        fun addMessage(message: Message) = apply { body.addMessage(message) }

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format. Keys can be a
         * maximum of 64 characters long and values can be a maximum of 512 characters long.
         */
        fun metadata(metadata: JsonValue) = apply { body.metadata(metadata) }

        /**
         * A set of resources that are made available to the assistant's tools in this thread. The
         * resources are specific to the type of tool. For example, the `code_interpreter` tool
         * requires a list of file IDs, while the `file_search` tool requires a list of vector store
         * IDs.
         */
        fun toolResources(toolResources: ToolResources) = apply {
            body.toolResources(toolResources)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun build(): BetaThreadCreateParams =
            BetaThreadCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    @NoAutoDetect
    class Message
    @JsonCreator
    private constructor(
        @JsonProperty("role") private val role: Role,
        @JsonProperty("content") private val content: Content,
        @JsonProperty("attachments") private val attachments: List<Attachment>?,
        @JsonProperty("metadata") private val metadata: JsonValue?,
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * The role of the entity that is creating the message. Allowed values include:
         * - `user`: Indicates the message is sent by an actual user and should be used in most
         *   cases to represent user-generated messages.
         * - `assistant`: Indicates the message is generated by the assistant. Use this value to
         *   insert messages from the assistant into the conversation.
         */
        @JsonProperty("role") fun role(): Role = role

        /** The text contents of the message. */
        @JsonProperty("content") fun content(): Content = content

        /** A list of files attached to the message, and the tools they should be added to. */
        @JsonProperty("attachments")
        fun attachments(): Optional<List<Attachment>> = Optional.ofNullable(attachments)

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format. Keys can be a
         * maximum of 64 characters long and values can be a maximum of 512 characters long.
         */
        @JsonProperty("metadata")
        fun metadata(): Optional<JsonValue> = Optional.ofNullable(metadata)

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var role: Role? = null
            private var content: Content? = null
            private var attachments: MutableList<Attachment>? = null
            private var metadata: JsonValue? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(message: Message) = apply {
                role = message.role
                content = message.content
                attachments = message.attachments?.toMutableList()
                metadata = message.metadata
                additionalProperties = message.additionalProperties.toMutableMap()
            }

            /**
             * The role of the entity that is creating the message. Allowed values include:
             * - `user`: Indicates the message is sent by an actual user and should be used in most
             *   cases to represent user-generated messages.
             * - `assistant`: Indicates the message is generated by the assistant. Use this value to
             *   insert messages from the assistant into the conversation.
             */
            fun role(role: Role) = apply { this.role = role }

            /** The text contents of the message. */
            fun content(content: Content) = apply { this.content = content }

            /** The text contents of the message. */
            fun content(textContent: String) = apply {
                this.content = Content.ofTextContent(textContent)
            }

            /**
             * An array of content parts with a defined type, each can be of type `text` or images
             * can be passed with `image_url` or `image_file`. Image types are only supported on
             * [Vision-compatible models](https://platform.openai.com/docs/models).
             */
            fun contentOfArrayOfContentParts(arrayOfContentParts: List<MessageContentPartParam>) =
                apply {
                    this.content = Content.ofArrayOfContentParts(arrayOfContentParts)
                }

            /** A list of files attached to the message, and the tools they should be added to. */
            fun attachments(attachments: List<Attachment>) = apply {
                this.attachments = attachments.toMutableList()
            }

            /** A list of files attached to the message, and the tools they should be added to. */
            fun addAttachment(attachment: Attachment) = apply {
                attachments = (attachments ?: mutableListOf()).apply { add(attachment) }
            }

            /**
             * Set of 16 key-value pairs that can be attached to an object. This can be useful for
             * storing additional information about the object in a structured format. Keys can be a
             * maximum of 64 characters long and values can be a maximum of 512 characters long.
             */
            fun metadata(metadata: JsonValue) = apply { this.metadata = metadata }

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

            fun build(): Message =
                Message(
                    checkNotNull(role) { "`role` is required but was not set" },
                    checkNotNull(content) { "`content` is required but was not set" },
                    attachments?.toImmutable(),
                    metadata,
                    additionalProperties.toImmutable(),
                )
        }

        /** The text contents of the message. */
        @JsonDeserialize(using = Content.Deserializer::class)
        @JsonSerialize(using = Content.Serializer::class)
        class Content
        private constructor(
            private val textContent: String? = null,
            private val arrayOfContentParts: List<MessageContentPartParam>? = null,
            private val _json: JsonValue? = null,
        ) {

            /** The text contents of the message. */
            fun textContent(): Optional<String> = Optional.ofNullable(textContent)
            /**
             * An array of content parts with a defined type, each can be of type `text` or images
             * can be passed with `image_url` or `image_file`. Image types are only supported on
             * [Vision-compatible models](https://platform.openai.com/docs/models).
             */
            fun arrayOfContentParts(): Optional<List<MessageContentPartParam>> =
                Optional.ofNullable(arrayOfContentParts)

            fun isTextContent(): Boolean = textContent != null

            fun isArrayOfContentParts(): Boolean = arrayOfContentParts != null

            /** The text contents of the message. */
            fun asTextContent(): String = textContent.getOrThrow("textContent")
            /**
             * An array of content parts with a defined type, each can be of type `text` or images
             * can be passed with `image_url` or `image_file`. Image types are only supported on
             * [Vision-compatible models](https://platform.openai.com/docs/models).
             */
            fun asArrayOfContentParts(): List<MessageContentPartParam> =
                arrayOfContentParts.getOrThrow("arrayOfContentParts")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T {
                return when {
                    textContent != null -> visitor.visitTextContent(textContent)
                    arrayOfContentParts != null ->
                        visitor.visitArrayOfContentParts(arrayOfContentParts)
                    else -> visitor.unknown(_json)
                }
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Content && textContent == other.textContent && arrayOfContentParts == other.arrayOfContentParts /* spotless:on */
            }

            override fun hashCode(): Int = /* spotless:off */ Objects.hash(textContent, arrayOfContentParts) /* spotless:on */

            override fun toString(): String =
                when {
                    textContent != null -> "Content{textContent=$textContent}"
                    arrayOfContentParts != null ->
                        "Content{arrayOfContentParts=$arrayOfContentParts}"
                    _json != null -> "Content{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Content")
                }

            companion object {

                /** The text contents of the message. */
                @JvmStatic
                fun ofTextContent(textContent: String) = Content(textContent = textContent)

                /**
                 * An array of content parts with a defined type, each can be of type `text` or
                 * images can be passed with `image_url` or `image_file`. Image types are only
                 * supported on [Vision-compatible models](https://platform.openai.com/docs/models).
                 */
                @JvmStatic
                fun ofArrayOfContentParts(arrayOfContentParts: List<MessageContentPartParam>) =
                    Content(arrayOfContentParts = arrayOfContentParts)
            }

            interface Visitor<out T> {

                fun visitTextContent(textContent: String): T

                fun visitArrayOfContentParts(arrayOfContentParts: List<MessageContentPartParam>): T

                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown Content: $json")
                }
            }

            class Deserializer : BaseDeserializer<Content>(Content::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Content {
                    val json = JsonValue.fromJsonNode(node)

                    tryDeserialize(node, jacksonTypeRef<String>())?.let {
                        return Content(textContent = it, _json = json)
                    }
                    tryDeserialize(node, jacksonTypeRef<List<MessageContentPartParam>>())?.let {
                        return Content(arrayOfContentParts = it, _json = json)
                    }

                    return Content(_json = json)
                }
            }

            class Serializer : BaseSerializer<Content>(Content::class) {

                override fun serialize(
                    value: Content,
                    generator: JsonGenerator,
                    provider: SerializerProvider
                ) {
                    when {
                        value.textContent != null -> generator.writeObject(value.textContent)
                        value.arrayOfContentParts != null ->
                            generator.writeObject(value.arrayOfContentParts)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Content")
                    }
                }
            }
        }

        class Role
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val USER = of("user")

                @JvmField val ASSISTANT = of("assistant")

                @JvmStatic fun of(value: String) = Role(JsonField.of(value))
            }

            enum class Known {
                USER,
                ASSISTANT,
            }

            enum class Value {
                USER,
                ASSISTANT,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    USER -> Value.USER
                    ASSISTANT -> Value.ASSISTANT
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    USER -> Known.USER
                    ASSISTANT -> Known.ASSISTANT
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

        @NoAutoDetect
        class Attachment
        @JsonCreator
        private constructor(
            @JsonProperty("file_id") private val fileId: String?,
            @JsonProperty("tools") private val tools: List<Tool>?,
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /** The ID of the file to attach to the message. */
            @JsonProperty("file_id") fun fileId(): Optional<String> = Optional.ofNullable(fileId)

            /** The tools to add this file to. */
            @JsonProperty("tools") fun tools(): Optional<List<Tool>> = Optional.ofNullable(tools)

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var fileId: String? = null
                private var tools: MutableList<Tool>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(attachment: Attachment) = apply {
                    fileId = attachment.fileId
                    tools = attachment.tools?.toMutableList()
                    additionalProperties = attachment.additionalProperties.toMutableMap()
                }

                /** The ID of the file to attach to the message. */
                fun fileId(fileId: String) = apply { this.fileId = fileId }

                /** The tools to add this file to. */
                fun tools(tools: List<Tool>) = apply { this.tools = tools.toMutableList() }

                /** The tools to add this file to. */
                fun addTool(tool: Tool) = apply {
                    tools = (tools ?: mutableListOf()).apply { add(tool) }
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

                fun build(): Attachment =
                    Attachment(
                        fileId,
                        tools?.toImmutable(),
                        additionalProperties.toImmutable(),
                    )
            }

            @JsonDeserialize(using = Tool.Deserializer::class)
            @JsonSerialize(using = Tool.Serializer::class)
            class Tool
            private constructor(
                private val codeInterpreterTool: CodeInterpreterTool? = null,
                private val fileSearch: FileSearch? = null,
                private val _json: JsonValue? = null,
            ) {

                fun codeInterpreterTool(): Optional<CodeInterpreterTool> =
                    Optional.ofNullable(codeInterpreterTool)

                fun fileSearch(): Optional<FileSearch> = Optional.ofNullable(fileSearch)

                fun isCodeInterpreterTool(): Boolean = codeInterpreterTool != null

                fun isFileSearch(): Boolean = fileSearch != null

                fun asCodeInterpreterTool(): CodeInterpreterTool =
                    codeInterpreterTool.getOrThrow("codeInterpreterTool")

                fun asFileSearch(): FileSearch = fileSearch.getOrThrow("fileSearch")

                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                fun <T> accept(visitor: Visitor<T>): T {
                    return when {
                        codeInterpreterTool != null ->
                            visitor.visitCodeInterpreterTool(codeInterpreterTool)
                        fileSearch != null -> visitor.visitFileSearch(fileSearch)
                        else -> visitor.unknown(_json)
                    }
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Tool && codeInterpreterTool == other.codeInterpreterTool && fileSearch == other.fileSearch /* spotless:on */
                }

                override fun hashCode(): Int = /* spotless:off */ Objects.hash(codeInterpreterTool, fileSearch) /* spotless:on */

                override fun toString(): String =
                    when {
                        codeInterpreterTool != null ->
                            "Tool{codeInterpreterTool=$codeInterpreterTool}"
                        fileSearch != null -> "Tool{fileSearch=$fileSearch}"
                        _json != null -> "Tool{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid Tool")
                    }

                companion object {

                    @JvmStatic
                    fun ofCodeInterpreterTool(codeInterpreterTool: CodeInterpreterTool) =
                        Tool(codeInterpreterTool = codeInterpreterTool)

                    @JvmStatic
                    fun ofFileSearch(fileSearch: FileSearch) = Tool(fileSearch = fileSearch)
                }

                interface Visitor<out T> {

                    fun visitCodeInterpreterTool(codeInterpreterTool: CodeInterpreterTool): T

                    fun visitFileSearch(fileSearch: FileSearch): T

                    fun unknown(json: JsonValue?): T {
                        throw OpenAIInvalidDataException("Unknown Tool: $json")
                    }
                }

                class Deserializer : BaseDeserializer<Tool>(Tool::class) {

                    override fun ObjectCodec.deserialize(node: JsonNode): Tool {
                        val json = JsonValue.fromJsonNode(node)
                        val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                        when (type) {
                            "code_interpreter" -> {
                                tryDeserialize(node, jacksonTypeRef<CodeInterpreterTool>())?.let {
                                    return Tool(codeInterpreterTool = it, _json = json)
                                }
                            }
                            "file_search" -> {
                                tryDeserialize(node, jacksonTypeRef<FileSearch>())?.let {
                                    return Tool(fileSearch = it, _json = json)
                                }
                            }
                        }

                        return Tool(_json = json)
                    }
                }

                class Serializer : BaseSerializer<Tool>(Tool::class) {

                    override fun serialize(
                        value: Tool,
                        generator: JsonGenerator,
                        provider: SerializerProvider
                    ) {
                        when {
                            value.codeInterpreterTool != null ->
                                generator.writeObject(value.codeInterpreterTool)
                            value.fileSearch != null -> generator.writeObject(value.fileSearch)
                            value._json != null -> generator.writeObject(value._json)
                            else -> throw IllegalStateException("Invalid Tool")
                        }
                    }
                }

                @NoAutoDetect
                class FileSearch
                @JsonCreator
                private constructor(
                    @JsonProperty("type") private val type: Type,
                    @JsonAnySetter
                    private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
                ) {

                    /** The type of tool being defined: `file_search` */
                    @JsonProperty("type") fun type(): Type = type

                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                    fun toBuilder() = Builder().from(this)

                    companion object {

                        @JvmStatic fun builder() = Builder()
                    }

                    class Builder {

                        private var type: Type? = null
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(fileSearch: FileSearch) = apply {
                            type = fileSearch.type
                            additionalProperties = fileSearch.additionalProperties.toMutableMap()
                        }

                        /** The type of tool being defined: `file_search` */
                        fun type(type: Type) = apply { this.type = type }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        fun build(): FileSearch =
                            FileSearch(
                                checkNotNull(type) { "`type` is required but was not set" },
                                additionalProperties.toImmutable()
                            )
                    }

                    class Type
                    @JsonCreator
                    private constructor(
                        private val value: JsonField<String>,
                    ) : Enum {

                        @com.fasterxml.jackson.annotation.JsonValue
                        fun _value(): JsonField<String> = value

                        companion object {

                            @JvmField val FILE_SEARCH = of("file_search")

                            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                        }

                        enum class Known {
                            FILE_SEARCH,
                        }

                        enum class Value {
                            FILE_SEARCH,
                            _UNKNOWN,
                        }

                        fun value(): Value =
                            when (this) {
                                FILE_SEARCH -> Value.FILE_SEARCH
                                else -> Value._UNKNOWN
                            }

                        fun known(): Known =
                            when (this) {
                                FILE_SEARCH -> Known.FILE_SEARCH
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

                        return /* spotless:off */ other is FileSearch && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                    }

                    /* spotless:off */
                    private val hashCode: Int by lazy { Objects.hash(type, additionalProperties) }
                    /* spotless:on */

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "FileSearch{type=$type, additionalProperties=$additionalProperties}"
                }
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Attachment && fileId == other.fileId && tools == other.tools && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(fileId, tools, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Attachment{fileId=$fileId, tools=$tools, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Message && role == other.role && content == other.content && attachments == other.attachments && metadata == other.metadata && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(role, content, attachments, metadata, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Message{role=$role, content=$content, attachments=$attachments, metadata=$metadata, additionalProperties=$additionalProperties}"
    }

    /**
     * A set of resources that are made available to the assistant's tools in this thread. The
     * resources are specific to the type of tool. For example, the `code_interpreter` tool requires
     * a list of file IDs, while the `file_search` tool requires a list of vector store IDs.
     */
    @NoAutoDetect
    class ToolResources
    @JsonCreator
    private constructor(
        @JsonProperty("code_interpreter") private val codeInterpreter: CodeInterpreter?,
        @JsonProperty("file_search") private val fileSearch: FileSearch?,
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        @JsonProperty("code_interpreter")
        fun codeInterpreter(): Optional<CodeInterpreter> = Optional.ofNullable(codeInterpreter)

        @JsonProperty("file_search")
        fun fileSearch(): Optional<FileSearch> = Optional.ofNullable(fileSearch)

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var codeInterpreter: CodeInterpreter? = null
            private var fileSearch: FileSearch? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(toolResources: ToolResources) = apply {
                codeInterpreter = toolResources.codeInterpreter
                fileSearch = toolResources.fileSearch
                additionalProperties = toolResources.additionalProperties.toMutableMap()
            }

            fun codeInterpreter(codeInterpreter: CodeInterpreter) = apply {
                this.codeInterpreter = codeInterpreter
            }

            fun fileSearch(fileSearch: FileSearch) = apply { this.fileSearch = fileSearch }

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

            fun build(): ToolResources =
                ToolResources(
                    codeInterpreter,
                    fileSearch,
                    additionalProperties.toImmutable(),
                )
        }

        @NoAutoDetect
        class CodeInterpreter
        @JsonCreator
        private constructor(
            @JsonProperty("file_ids") private val fileIds: List<String>?,
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /**
             * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs made
             * available to the `code_interpreter` tool. There can be a maximum of 20 files
             * associated with the tool.
             */
            @JsonProperty("file_ids")
            fun fileIds(): Optional<List<String>> = Optional.ofNullable(fileIds)

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var fileIds: MutableList<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(codeInterpreter: CodeInterpreter) = apply {
                    fileIds = codeInterpreter.fileIds?.toMutableList()
                    additionalProperties = codeInterpreter.additionalProperties.toMutableMap()
                }

                /**
                 * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs made
                 * available to the `code_interpreter` tool. There can be a maximum of 20 files
                 * associated with the tool.
                 */
                fun fileIds(fileIds: List<String>) = apply {
                    this.fileIds = fileIds.toMutableList()
                }

                /**
                 * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs made
                 * available to the `code_interpreter` tool. There can be a maximum of 20 files
                 * associated with the tool.
                 */
                fun addFileId(fileId: String) = apply {
                    fileIds = (fileIds ?: mutableListOf()).apply { add(fileId) }
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

                fun build(): CodeInterpreter =
                    CodeInterpreter(fileIds?.toImmutable(), additionalProperties.toImmutable())
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is CodeInterpreter && fileIds == other.fileIds && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(fileIds, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "CodeInterpreter{fileIds=$fileIds, additionalProperties=$additionalProperties}"
        }

        @NoAutoDetect
        class FileSearch
        @JsonCreator
        private constructor(
            @JsonProperty("vector_store_ids") private val vectorStoreIds: List<String>?,
            @JsonProperty("vector_stores") private val vectorStores: List<VectorStore>?,
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /**
             * The
             * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
             * attached to this thread. There can be a maximum of 1 vector store attached to the
             * thread.
             */
            @JsonProperty("vector_store_ids")
            fun vectorStoreIds(): Optional<List<String>> = Optional.ofNullable(vectorStoreIds)

            /**
             * A helper to create a
             * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
             * with file_ids and attach it to this thread. There can be a maximum of 1 vector store
             * attached to the thread.
             */
            @JsonProperty("vector_stores")
            fun vectorStores(): Optional<List<VectorStore>> = Optional.ofNullable(vectorStores)

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var vectorStoreIds: MutableList<String>? = null
                private var vectorStores: MutableList<VectorStore>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(fileSearch: FileSearch) = apply {
                    vectorStoreIds = fileSearch.vectorStoreIds?.toMutableList()
                    vectorStores = fileSearch.vectorStores?.toMutableList()
                    additionalProperties = fileSearch.additionalProperties.toMutableMap()
                }

                /**
                 * The
                 * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
                 * attached to this thread. There can be a maximum of 1 vector store attached to the
                 * thread.
                 */
                fun vectorStoreIds(vectorStoreIds: List<String>) = apply {
                    this.vectorStoreIds = vectorStoreIds.toMutableList()
                }

                /**
                 * The
                 * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
                 * attached to this thread. There can be a maximum of 1 vector store attached to the
                 * thread.
                 */
                fun addVectorStoreId(vectorStoreId: String) = apply {
                    vectorStoreIds =
                        (vectorStoreIds ?: mutableListOf()).apply { add(vectorStoreId) }
                }

                /**
                 * A helper to create a
                 * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
                 * with file_ids and attach it to this thread. There can be a maximum of 1 vector
                 * store attached to the thread.
                 */
                fun vectorStores(vectorStores: List<VectorStore>) = apply {
                    this.vectorStores = vectorStores.toMutableList()
                }

                /**
                 * A helper to create a
                 * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
                 * with file_ids and attach it to this thread. There can be a maximum of 1 vector
                 * store attached to the thread.
                 */
                fun addVectorStore(vectorStore: VectorStore) = apply {
                    vectorStores = (vectorStores ?: mutableListOf()).apply { add(vectorStore) }
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

                fun build(): FileSearch =
                    FileSearch(
                        vectorStoreIds?.toImmutable(),
                        vectorStores?.toImmutable(),
                        additionalProperties.toImmutable(),
                    )
            }

            @NoAutoDetect
            class VectorStore
            @JsonCreator
            private constructor(
                @JsonProperty("file_ids") private val fileIds: List<String>?,
                @JsonProperty("chunking_strategy")
                private val chunkingStrategy: FileChunkingStrategyParam?,
                @JsonProperty("metadata") private val metadata: JsonValue?,
                @JsonAnySetter
                private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
            ) {

                /**
                 * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs to add
                 * to the vector store. There can be a maximum of 10000 files in a vector store.
                 */
                @JsonProperty("file_ids")
                fun fileIds(): Optional<List<String>> = Optional.ofNullable(fileIds)

                /**
                 * The chunking strategy used to chunk the file(s). If not set, will use the `auto`
                 * strategy. Only applicable if `file_ids` is non-empty.
                 */
                @JsonProperty("chunking_strategy")
                fun chunkingStrategy(): Optional<FileChunkingStrategyParam> =
                    Optional.ofNullable(chunkingStrategy)

                /**
                 * Set of 16 key-value pairs that can be attached to a vector store. This can be
                 * useful for storing additional information about the vector store in a structured
                 * format. Keys can be a maximum of 64 characters long and values can be a maximum
                 * of 512 characters long.
                 */
                @JsonProperty("metadata")
                fun metadata(): Optional<JsonValue> = Optional.ofNullable(metadata)

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun toBuilder() = Builder().from(this)

                companion object {

                    @JvmStatic fun builder() = Builder()
                }

                class Builder {

                    private var fileIds: MutableList<String>? = null
                    private var chunkingStrategy: FileChunkingStrategyParam? = null
                    private var metadata: JsonValue? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(vectorStore: VectorStore) = apply {
                        fileIds = vectorStore.fileIds?.toMutableList()
                        chunkingStrategy = vectorStore.chunkingStrategy
                        metadata = vectorStore.metadata
                        additionalProperties = vectorStore.additionalProperties.toMutableMap()
                    }

                    /**
                     * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs to
                     * add to the vector store. There can be a maximum of 10000 files in a vector
                     * store.
                     */
                    fun fileIds(fileIds: List<String>) = apply {
                        this.fileIds = fileIds.toMutableList()
                    }

                    /**
                     * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs to
                     * add to the vector store. There can be a maximum of 10000 files in a vector
                     * store.
                     */
                    fun addFileId(fileId: String) = apply {
                        fileIds = (fileIds ?: mutableListOf()).apply { add(fileId) }
                    }

                    /**
                     * The chunking strategy used to chunk the file(s). If not set, will use the
                     * `auto` strategy. Only applicable if `file_ids` is non-empty.
                     */
                    fun chunkingStrategy(chunkingStrategy: FileChunkingStrategyParam) = apply {
                        this.chunkingStrategy = chunkingStrategy
                    }

                    /**
                     * The default strategy. This strategy currently uses a `max_chunk_size_tokens`
                     * of `800` and `chunk_overlap_tokens` of `400`.
                     */
                    fun chunkingStrategy(
                        autoFileChunkingStrategyParam: AutoFileChunkingStrategyParam
                    ) = apply {
                        this.chunkingStrategy =
                            FileChunkingStrategyParam.ofAutoFileChunkingStrategyParam(
                                autoFileChunkingStrategyParam
                            )
                    }

                    fun chunkingStrategy(
                        staticFileChunkingStrategyParam: StaticFileChunkingStrategyParam
                    ) = apply {
                        this.chunkingStrategy =
                            FileChunkingStrategyParam.ofStaticFileChunkingStrategyParam(
                                staticFileChunkingStrategyParam
                            )
                    }

                    /**
                     * Set of 16 key-value pairs that can be attached to a vector store. This can be
                     * useful for storing additional information about the vector store in a
                     * structured format. Keys can be a maximum of 64 characters long and values can
                     * be a maximum of 512 characters long.
                     */
                    fun metadata(metadata: JsonValue) = apply { this.metadata = metadata }

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

                    fun build(): VectorStore =
                        VectorStore(
                            fileIds?.toImmutable(),
                            chunkingStrategy,
                            metadata,
                            additionalProperties.toImmutable(),
                        )
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is VectorStore && fileIds == other.fileIds && chunkingStrategy == other.chunkingStrategy && metadata == other.metadata && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(fileIds, chunkingStrategy, metadata, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "VectorStore{fileIds=$fileIds, chunkingStrategy=$chunkingStrategy, metadata=$metadata, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is FileSearch && vectorStoreIds == other.vectorStoreIds && vectorStores == other.vectorStores && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(vectorStoreIds, vectorStores, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "FileSearch{vectorStoreIds=$vectorStoreIds, vectorStores=$vectorStores, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ToolResources && codeInterpreter == other.codeInterpreter && fileSearch == other.fileSearch && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(codeInterpreter, fileSearch, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ToolResources{codeInterpreter=$codeInterpreter, fileSearch=$fileSearch, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BetaThreadCreateParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "BetaThreadCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
