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
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Create a thread. */
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
    fun _metadata(): JsonValue = body._metadata()

    /**
     * A set of resources that are made available to the assistant's tools in this thread. The
     * resources are specific to the type of tool. For example, the `code_interpreter` tool requires
     * a list of file IDs, while the `file_search` tool requires a list of vector store IDs.
     */
    fun toolResources(): Optional<ToolResources> = body.toolResources()

    /**
     * A list of [messages](https://platform.openai.com/docs/api-reference/messages) to start the
     * thread with.
     */
    fun _messages(): JsonField<List<Message>> = body._messages()

    /**
     * A set of resources that are made available to the assistant's tools in this thread. The
     * resources are specific to the type of tool. For example, the `code_interpreter` tool requires
     * a list of file IDs, while the `file_search` tool requires a list of vector store IDs.
     */
    fun _toolResources(): JsonField<ToolResources> = body._toolResources()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic internal fun getBody(): BetaThreadCreateBody = body

    @JvmSynthetic internal fun getHeaders(): Headers = additionalHeaders

    @JvmSynthetic internal fun getQueryParams(): QueryParams = additionalQueryParams

    @NoAutoDetect
    class BetaThreadCreateBody
    @JsonCreator
    internal constructor(
        @JsonProperty("messages")
        @ExcludeMissing
        private val messages: JsonField<List<Message>> = JsonMissing.of(),
        @JsonProperty("metadata")
        @ExcludeMissing
        private val metadata: JsonValue = JsonMissing.of(),
        @JsonProperty("tool_resources")
        @ExcludeMissing
        private val toolResources: JsonField<ToolResources> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * A list of [messages](https://platform.openai.com/docs/api-reference/messages) to start
         * the thread with.
         */
        fun messages(): Optional<List<Message>> =
            Optional.ofNullable(messages.getNullable("messages"))

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format. Keys can be a
         * maximum of 64 characters long and values can be a maximum of 512 characters long.
         */
        @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonValue = metadata

        /**
         * A set of resources that are made available to the assistant's tools in this thread. The
         * resources are specific to the type of tool. For example, the `code_interpreter` tool
         * requires a list of file IDs, while the `file_search` tool requires a list of vector store
         * IDs.
         */
        fun toolResources(): Optional<ToolResources> =
            Optional.ofNullable(toolResources.getNullable("tool_resources"))

        /**
         * A list of [messages](https://platform.openai.com/docs/api-reference/messages) to start
         * the thread with.
         */
        @JsonProperty("messages")
        @ExcludeMissing
        fun _messages(): JsonField<List<Message>> = messages

        /**
         * A set of resources that are made available to the assistant's tools in this thread. The
         * resources are specific to the type of tool. For example, the `code_interpreter` tool
         * requires a list of file IDs, while the `file_search` tool requires a list of vector store
         * IDs.
         */
        @JsonProperty("tool_resources")
        @ExcludeMissing
        fun _toolResources(): JsonField<ToolResources> = toolResources

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): BetaThreadCreateBody = apply {
            if (validated) {
                return@apply
            }

            messages().ifPresent { it.forEach { it.validate() } }
            toolResources().ifPresent { it.validate() }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var messages: JsonField<MutableList<Message>>? = null
            private var metadata: JsonValue = JsonMissing.of()
            private var toolResources: JsonField<ToolResources> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(betaThreadCreateBody: BetaThreadCreateBody) = apply {
                messages = betaThreadCreateBody.messages.map { it.toMutableList() }
                metadata = betaThreadCreateBody.metadata
                toolResources = betaThreadCreateBody.toolResources
                additionalProperties = betaThreadCreateBody.additionalProperties.toMutableMap()
            }

            /**
             * A list of [messages](https://platform.openai.com/docs/api-reference/messages) to
             * start the thread with.
             */
            fun messages(messages: List<Message>) = messages(JsonField.of(messages))

            /**
             * A list of [messages](https://platform.openai.com/docs/api-reference/messages) to
             * start the thread with.
             */
            fun messages(messages: JsonField<List<Message>>) = apply {
                this.messages = messages.map { it.toMutableList() }
            }

            /**
             * A list of [messages](https://platform.openai.com/docs/api-reference/messages) to
             * start the thread with.
             */
            fun addMessage(message: Message) = apply {
                messages =
                    (messages ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(message)
                    }
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
            fun toolResources(toolResources: ToolResources?) =
                toolResources(JsonField.ofNullable(toolResources))

            /**
             * A set of resources that are made available to the assistant's tools in this thread.
             * The resources are specific to the type of tool. For example, the `code_interpreter`
             * tool requires a list of file IDs, while the `file_search` tool requires a list of
             * vector store IDs.
             */
            fun toolResources(toolResources: Optional<ToolResources>) =
                toolResources(toolResources.orElse(null))

            /**
             * A set of resources that are made available to the assistant's tools in this thread.
             * The resources are specific to the type of tool. For example, the `code_interpreter`
             * tool requires a list of file IDs, while the `file_search` tool requires a list of
             * vector store IDs.
             */
            fun toolResources(toolResources: JsonField<ToolResources>) = apply {
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
                    (messages ?: JsonMissing.of()).map { it.toImmutable() },
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
        fun messages(messages: JsonField<List<Message>>) = apply { body.messages(messages) }

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
        fun toolResources(toolResources: ToolResources?) = apply {
            body.toolResources(toolResources)
        }

        /**
         * A set of resources that are made available to the assistant's tools in this thread. The
         * resources are specific to the type of tool. For example, the `code_interpreter` tool
         * requires a list of file IDs, while the `file_search` tool requires a list of vector store
         * IDs.
         */
        fun toolResources(toolResources: Optional<ToolResources>) =
            toolResources(toolResources.orElse(null))

        /**
         * A set of resources that are made available to the assistant's tools in this thread. The
         * resources are specific to the type of tool. For example, the `code_interpreter` tool
         * requires a list of file IDs, while the `file_search` tool requires a list of vector store
         * IDs.
         */
        fun toolResources(toolResources: JsonField<ToolResources>) = apply {
            body.toolResources(toolResources)
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
        @JsonProperty("content")
        @ExcludeMissing
        private val content: JsonField<Content> = JsonMissing.of(),
        @JsonProperty("role") @ExcludeMissing private val role: JsonField<Role> = JsonMissing.of(),
        @JsonProperty("attachments")
        @ExcludeMissing
        private val attachments: JsonField<List<Attachment>> = JsonMissing.of(),
        @JsonProperty("metadata")
        @ExcludeMissing
        private val metadata: JsonValue = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The text contents of the message. */
        fun content(): Content = content.getRequired("content")

        /**
         * The role of the entity that is creating the message. Allowed values include:
         * - `user`: Indicates the message is sent by an actual user and should be used in most
         *   cases to represent user-generated messages.
         * - `assistant`: Indicates the message is generated by the assistant. Use this value to
         *   insert messages from the assistant into the conversation.
         */
        fun role(): Role = role.getRequired("role")

        /** A list of files attached to the message, and the tools they should be added to. */
        fun attachments(): Optional<List<Attachment>> =
            Optional.ofNullable(attachments.getNullable("attachments"))

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format. Keys can be a
         * maximum of 64 characters long and values can be a maximum of 512 characters long.
         */
        @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonValue = metadata

        /** The text contents of the message. */
        @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<Content> = content

        /**
         * The role of the entity that is creating the message. Allowed values include:
         * - `user`: Indicates the message is sent by an actual user and should be used in most
         *   cases to represent user-generated messages.
         * - `assistant`: Indicates the message is generated by the assistant. Use this value to
         *   insert messages from the assistant into the conversation.
         */
        @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<Role> = role

        /** A list of files attached to the message, and the tools they should be added to. */
        @JsonProperty("attachments")
        @ExcludeMissing
        fun _attachments(): JsonField<List<Attachment>> = attachments

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Message = apply {
            if (validated) {
                return@apply
            }

            content().validate()
            role()
            attachments().ifPresent { it.forEach { it.validate() } }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var content: JsonField<Content>? = null
            private var role: JsonField<Role>? = null
            private var attachments: JsonField<MutableList<Attachment>>? = null
            private var metadata: JsonValue = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(message: Message) = apply {
                content = message.content
                role = message.role
                attachments = message.attachments.map { it.toMutableList() }
                metadata = message.metadata
                additionalProperties = message.additionalProperties.toMutableMap()
            }

            /** The text contents of the message. */
            fun content(content: Content) = content(JsonField.of(content))

            /** The text contents of the message. */
            fun content(content: JsonField<Content>) = apply { this.content = content }

            /** The text contents of the message. */
            fun content(textContent: String) = content(Content.ofTextContent(textContent))

            /**
             * An array of content parts with a defined type, each can be of type `text` or images
             * can be passed with `image_url` or `image_file`. Image types are only supported on
             * [Vision-compatible models](https://platform.openai.com/docs/models).
             */
            fun contentOfArrayOfContentParts(arrayOfContentParts: List<MessageContentPartParam>) =
                content(Content.ofArrayOfContentParts(arrayOfContentParts))

            /**
             * The role of the entity that is creating the message. Allowed values include:
             * - `user`: Indicates the message is sent by an actual user and should be used in most
             *   cases to represent user-generated messages.
             * - `assistant`: Indicates the message is generated by the assistant. Use this value to
             *   insert messages from the assistant into the conversation.
             */
            fun role(role: Role) = role(JsonField.of(role))

            /**
             * The role of the entity that is creating the message. Allowed values include:
             * - `user`: Indicates the message is sent by an actual user and should be used in most
             *   cases to represent user-generated messages.
             * - `assistant`: Indicates the message is generated by the assistant. Use this value to
             *   insert messages from the assistant into the conversation.
             */
            fun role(role: JsonField<Role>) = apply { this.role = role }

            /** A list of files attached to the message, and the tools they should be added to. */
            fun attachments(attachments: List<Attachment>?) =
                attachments(JsonField.ofNullable(attachments))

            /** A list of files attached to the message, and the tools they should be added to. */
            fun attachments(attachments: Optional<List<Attachment>>) =
                attachments(attachments.orElse(null))

            /** A list of files attached to the message, and the tools they should be added to. */
            fun attachments(attachments: JsonField<List<Attachment>>) = apply {
                this.attachments = attachments.map { it.toMutableList() }
            }

            /** A list of files attached to the message, and the tools they should be added to. */
            fun addAttachment(attachment: Attachment) = apply {
                attachments =
                    (attachments ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(attachment)
                    }
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
                    checkRequired("content", content),
                    checkRequired("role", role),
                    (attachments ?: JsonMissing.of()).map { it.toImmutable() },
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

            private var validated: Boolean = false

            fun validate(): Content = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitTextContent(textContent: String) {}

                        override fun visitArrayOfContentParts(
                            arrayOfContentParts: List<MessageContentPartParam>
                        ) {
                            arrayOfContentParts.forEach { it.validate() }
                        }
                    }
                )
                validated = true
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
                    tryDeserialize(node, jacksonTypeRef<List<MessageContentPartParam>>()) {
                            it.forEach { it.validate() }
                        }
                        ?.let {
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
            @JsonProperty("file_id")
            @ExcludeMissing
            private val fileId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("tools")
            @ExcludeMissing
            private val tools: JsonField<List<Tool>> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /** The ID of the file to attach to the message. */
            fun fileId(): Optional<String> = Optional.ofNullable(fileId.getNullable("file_id"))

            /** The tools to add this file to. */
            fun tools(): Optional<List<Tool>> = Optional.ofNullable(tools.getNullable("tools"))

            /** The ID of the file to attach to the message. */
            @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

            /** The tools to add this file to. */
            @JsonProperty("tools") @ExcludeMissing fun _tools(): JsonField<List<Tool>> = tools

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): Attachment = apply {
                if (validated) {
                    return@apply
                }

                fileId()
                tools().ifPresent { it.forEach { it.validate() } }
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var fileId: JsonField<String> = JsonMissing.of()
                private var tools: JsonField<MutableList<Tool>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(attachment: Attachment) = apply {
                    fileId = attachment.fileId
                    tools = attachment.tools.map { it.toMutableList() }
                    additionalProperties = attachment.additionalProperties.toMutableMap()
                }

                /** The ID of the file to attach to the message. */
                fun fileId(fileId: String) = fileId(JsonField.of(fileId))

                /** The ID of the file to attach to the message. */
                fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

                /** The tools to add this file to. */
                fun tools(tools: List<Tool>) = tools(JsonField.of(tools))

                /** The tools to add this file to. */
                fun tools(tools: JsonField<List<Tool>>) = apply {
                    this.tools = tools.map { it.toMutableList() }
                }

                /** The tools to add this file to. */
                fun addTool(tool: Tool) = apply {
                    tools =
                        (tools ?: JsonField.of(mutableListOf())).apply {
                            asKnown()
                                .orElseThrow {
                                    IllegalStateException(
                                        "Field was set to non-list type: ${javaClass.simpleName}"
                                    )
                                }
                                .add(tool)
                        }
                }

                /** The tools to add this file to. */
                fun addTool(codeInterpreterTool: CodeInterpreterTool) =
                    addTool(Tool.ofCodeInterpreterTool(codeInterpreterTool))

                /** The tools to add this file to. */
                fun addTool(fileSearch: Tool.FileSearch) = addTool(Tool.ofFileSearch(fileSearch))

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
                        (tools ?: JsonMissing.of()).map { it.toImmutable() },
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

                private var validated: Boolean = false

                fun validate(): Tool = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitCodeInterpreterTool(
                                codeInterpreterTool: CodeInterpreterTool
                            ) {
                                codeInterpreterTool.validate()
                            }

                            override fun visitFileSearch(fileSearch: FileSearch) {
                                fileSearch.validate()
                            }
                        }
                    )
                    validated = true
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
                                tryDeserialize(node, jacksonTypeRef<CodeInterpreterTool>()) {
                                        it.validate()
                                    }
                                    ?.let {
                                        return Tool(codeInterpreterTool = it, _json = json)
                                    }
                            }
                            "file_search" -> {
                                tryDeserialize(node, jacksonTypeRef<FileSearch>()) { it.validate() }
                                    ?.let {
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
                    @JsonProperty("type")
                    @ExcludeMissing
                    private val type: JsonField<Type> = JsonMissing.of(),
                    @JsonAnySetter
                    private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
                ) {

                    /** The type of tool being defined: `file_search` */
                    fun type(): Type = type.getRequired("type")

                    /** The type of tool being defined: `file_search` */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                    private var validated: Boolean = false

                    fun validate(): FileSearch = apply {
                        if (validated) {
                            return@apply
                        }

                        type()
                        validated = true
                    }

                    fun toBuilder() = Builder().from(this)

                    companion object {

                        @JvmStatic fun builder() = Builder()
                    }

                    class Builder {

                        private var type: JsonField<Type>? = null
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(fileSearch: FileSearch) = apply {
                            type = fileSearch.type
                            additionalProperties = fileSearch.additionalProperties.toMutableMap()
                        }

                        /** The type of tool being defined: `file_search` */
                        fun type(type: Type) = type(JsonField.of(type))

                        /** The type of tool being defined: `file_search` */
                        fun type(type: JsonField<Type>) = apply { this.type = type }

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
                                checkRequired("type", type),
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

            return /* spotless:off */ other is Message && content == other.content && role == other.role && attachments == other.attachments && metadata == other.metadata && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(content, role, attachments, metadata, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Message{content=$content, role=$role, attachments=$attachments, metadata=$metadata, additionalProperties=$additionalProperties}"
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
        @JsonProperty("code_interpreter")
        @ExcludeMissing
        private val codeInterpreter: JsonField<CodeInterpreter> = JsonMissing.of(),
        @JsonProperty("file_search")
        @ExcludeMissing
        private val fileSearch: JsonField<FileSearch> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun codeInterpreter(): Optional<CodeInterpreter> =
            Optional.ofNullable(codeInterpreter.getNullable("code_interpreter"))

        fun fileSearch(): Optional<FileSearch> =
            Optional.ofNullable(fileSearch.getNullable("file_search"))

        @JsonProperty("code_interpreter")
        @ExcludeMissing
        fun _codeInterpreter(): JsonField<CodeInterpreter> = codeInterpreter

        @JsonProperty("file_search")
        @ExcludeMissing
        fun _fileSearch(): JsonField<FileSearch> = fileSearch

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): ToolResources = apply {
            if (validated) {
                return@apply
            }

            codeInterpreter().ifPresent { it.validate() }
            fileSearch().ifPresent { it.validate() }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var codeInterpreter: JsonField<CodeInterpreter> = JsonMissing.of()
            private var fileSearch: JsonField<FileSearch> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(toolResources: ToolResources) = apply {
                codeInterpreter = toolResources.codeInterpreter
                fileSearch = toolResources.fileSearch
                additionalProperties = toolResources.additionalProperties.toMutableMap()
            }

            fun codeInterpreter(codeInterpreter: CodeInterpreter) =
                codeInterpreter(JsonField.of(codeInterpreter))

            fun codeInterpreter(codeInterpreter: JsonField<CodeInterpreter>) = apply {
                this.codeInterpreter = codeInterpreter
            }

            fun fileSearch(fileSearch: FileSearch) = fileSearch(JsonField.of(fileSearch))

            fun fileSearch(fileSearch: JsonField<FileSearch>) = apply {
                this.fileSearch = fileSearch
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
            @JsonProperty("file_ids")
            @ExcludeMissing
            private val fileIds: JsonField<List<String>> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /**
             * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs made
             * available to the `code_interpreter` tool. There can be a maximum of 20 files
             * associated with the tool.
             */
            fun fileIds(): Optional<List<String>> =
                Optional.ofNullable(fileIds.getNullable("file_ids"))

            /**
             * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs made
             * available to the `code_interpreter` tool. There can be a maximum of 20 files
             * associated with the tool.
             */
            @JsonProperty("file_ids")
            @ExcludeMissing
            fun _fileIds(): JsonField<List<String>> = fileIds

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): CodeInterpreter = apply {
                if (validated) {
                    return@apply
                }

                fileIds()
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var fileIds: JsonField<MutableList<String>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(codeInterpreter: CodeInterpreter) = apply {
                    fileIds = codeInterpreter.fileIds.map { it.toMutableList() }
                    additionalProperties = codeInterpreter.additionalProperties.toMutableMap()
                }

                /**
                 * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs made
                 * available to the `code_interpreter` tool. There can be a maximum of 20 files
                 * associated with the tool.
                 */
                fun fileIds(fileIds: List<String>) = fileIds(JsonField.of(fileIds))

                /**
                 * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs made
                 * available to the `code_interpreter` tool. There can be a maximum of 20 files
                 * associated with the tool.
                 */
                fun fileIds(fileIds: JsonField<List<String>>) = apply {
                    this.fileIds = fileIds.map { it.toMutableList() }
                }

                /**
                 * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs made
                 * available to the `code_interpreter` tool. There can be a maximum of 20 files
                 * associated with the tool.
                 */
                fun addFileId(fileId: String) = apply {
                    fileIds =
                        (fileIds ?: JsonField.of(mutableListOf())).apply {
                            asKnown()
                                .orElseThrow {
                                    IllegalStateException(
                                        "Field was set to non-list type: ${javaClass.simpleName}"
                                    )
                                }
                                .add(fileId)
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

                fun build(): CodeInterpreter =
                    CodeInterpreter(
                        (fileIds ?: JsonMissing.of()).map { it.toImmutable() },
                        additionalProperties.toImmutable()
                    )
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
            @JsonProperty("vector_store_ids")
            @ExcludeMissing
            private val vectorStoreIds: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("vector_stores")
            @ExcludeMissing
            private val vectorStores: JsonField<List<VectorStore>> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /**
             * The
             * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
             * attached to this thread. There can be a maximum of 1 vector store attached to the
             * thread.
             */
            fun vectorStoreIds(): Optional<List<String>> =
                Optional.ofNullable(vectorStoreIds.getNullable("vector_store_ids"))

            /**
             * A helper to create a
             * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
             * with file_ids and attach it to this thread. There can be a maximum of 1 vector store
             * attached to the thread.
             */
            fun vectorStores(): Optional<List<VectorStore>> =
                Optional.ofNullable(vectorStores.getNullable("vector_stores"))

            /**
             * The
             * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
             * attached to this thread. There can be a maximum of 1 vector store attached to the
             * thread.
             */
            @JsonProperty("vector_store_ids")
            @ExcludeMissing
            fun _vectorStoreIds(): JsonField<List<String>> = vectorStoreIds

            /**
             * A helper to create a
             * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
             * with file_ids and attach it to this thread. There can be a maximum of 1 vector store
             * attached to the thread.
             */
            @JsonProperty("vector_stores")
            @ExcludeMissing
            fun _vectorStores(): JsonField<List<VectorStore>> = vectorStores

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): FileSearch = apply {
                if (validated) {
                    return@apply
                }

                vectorStoreIds()
                vectorStores().ifPresent { it.forEach { it.validate() } }
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var vectorStoreIds: JsonField<MutableList<String>>? = null
                private var vectorStores: JsonField<MutableList<VectorStore>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(fileSearch: FileSearch) = apply {
                    vectorStoreIds = fileSearch.vectorStoreIds.map { it.toMutableList() }
                    vectorStores = fileSearch.vectorStores.map { it.toMutableList() }
                    additionalProperties = fileSearch.additionalProperties.toMutableMap()
                }

                /**
                 * The
                 * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
                 * attached to this thread. There can be a maximum of 1 vector store attached to the
                 * thread.
                 */
                fun vectorStoreIds(vectorStoreIds: List<String>) =
                    vectorStoreIds(JsonField.of(vectorStoreIds))

                /**
                 * The
                 * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
                 * attached to this thread. There can be a maximum of 1 vector store attached to the
                 * thread.
                 */
                fun vectorStoreIds(vectorStoreIds: JsonField<List<String>>) = apply {
                    this.vectorStoreIds = vectorStoreIds.map { it.toMutableList() }
                }

                /**
                 * The
                 * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
                 * attached to this thread. There can be a maximum of 1 vector store attached to the
                 * thread.
                 */
                fun addVectorStoreId(vectorStoreId: String) = apply {
                    vectorStoreIds =
                        (vectorStoreIds ?: JsonField.of(mutableListOf())).apply {
                            asKnown()
                                .orElseThrow {
                                    IllegalStateException(
                                        "Field was set to non-list type: ${javaClass.simpleName}"
                                    )
                                }
                                .add(vectorStoreId)
                        }
                }

                /**
                 * A helper to create a
                 * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
                 * with file_ids and attach it to this thread. There can be a maximum of 1 vector
                 * store attached to the thread.
                 */
                fun vectorStores(vectorStores: List<VectorStore>) =
                    vectorStores(JsonField.of(vectorStores))

                /**
                 * A helper to create a
                 * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
                 * with file_ids and attach it to this thread. There can be a maximum of 1 vector
                 * store attached to the thread.
                 */
                fun vectorStores(vectorStores: JsonField<List<VectorStore>>) = apply {
                    this.vectorStores = vectorStores.map { it.toMutableList() }
                }

                /**
                 * A helper to create a
                 * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
                 * with file_ids and attach it to this thread. There can be a maximum of 1 vector
                 * store attached to the thread.
                 */
                fun addVectorStore(vectorStore: VectorStore) = apply {
                    vectorStores =
                        (vectorStores ?: JsonField.of(mutableListOf())).apply {
                            asKnown()
                                .orElseThrow {
                                    IllegalStateException(
                                        "Field was set to non-list type: ${javaClass.simpleName}"
                                    )
                                }
                                .add(vectorStore)
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

                fun build(): FileSearch =
                    FileSearch(
                        (vectorStoreIds ?: JsonMissing.of()).map { it.toImmutable() },
                        (vectorStores ?: JsonMissing.of()).map { it.toImmutable() },
                        additionalProperties.toImmutable(),
                    )
            }

            @NoAutoDetect
            class VectorStore
            @JsonCreator
            private constructor(
                @JsonProperty("chunking_strategy")
                @ExcludeMissing
                private val chunkingStrategy: JsonField<FileChunkingStrategyParam> =
                    JsonMissing.of(),
                @JsonProperty("file_ids")
                @ExcludeMissing
                private val fileIds: JsonField<List<String>> = JsonMissing.of(),
                @JsonProperty("metadata")
                @ExcludeMissing
                private val metadata: JsonValue = JsonMissing.of(),
                @JsonAnySetter
                private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
            ) {

                /**
                 * The chunking strategy used to chunk the file(s). If not set, will use the `auto`
                 * strategy. Only applicable if `file_ids` is non-empty.
                 */
                fun chunkingStrategy(): Optional<FileChunkingStrategyParam> =
                    Optional.ofNullable(chunkingStrategy.getNullable("chunking_strategy"))

                /**
                 * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs to add
                 * to the vector store. There can be a maximum of 10000 files in a vector store.
                 */
                fun fileIds(): Optional<List<String>> =
                    Optional.ofNullable(fileIds.getNullable("file_ids"))

                /**
                 * Set of 16 key-value pairs that can be attached to a vector store. This can be
                 * useful for storing additional information about the vector store in a structured
                 * format. Keys can be a maximum of 64 characters long and values can be a maximum
                 * of 512 characters long.
                 */
                @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonValue = metadata

                /**
                 * The chunking strategy used to chunk the file(s). If not set, will use the `auto`
                 * strategy. Only applicable if `file_ids` is non-empty.
                 */
                @JsonProperty("chunking_strategy")
                @ExcludeMissing
                fun _chunkingStrategy(): JsonField<FileChunkingStrategyParam> = chunkingStrategy

                /**
                 * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs to add
                 * to the vector store. There can be a maximum of 10000 files in a vector store.
                 */
                @JsonProperty("file_ids")
                @ExcludeMissing
                fun _fileIds(): JsonField<List<String>> = fileIds

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                private var validated: Boolean = false

                fun validate(): VectorStore = apply {
                    if (validated) {
                        return@apply
                    }

                    chunkingStrategy().ifPresent { it.validate() }
                    fileIds()
                    validated = true
                }

                fun toBuilder() = Builder().from(this)

                companion object {

                    @JvmStatic fun builder() = Builder()
                }

                class Builder {

                    private var chunkingStrategy: JsonField<FileChunkingStrategyParam> =
                        JsonMissing.of()
                    private var fileIds: JsonField<MutableList<String>>? = null
                    private var metadata: JsonValue = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(vectorStore: VectorStore) = apply {
                        chunkingStrategy = vectorStore.chunkingStrategy
                        fileIds = vectorStore.fileIds.map { it.toMutableList() }
                        metadata = vectorStore.metadata
                        additionalProperties = vectorStore.additionalProperties.toMutableMap()
                    }

                    /**
                     * The chunking strategy used to chunk the file(s). If not set, will use the
                     * `auto` strategy. Only applicable if `file_ids` is non-empty.
                     */
                    fun chunkingStrategy(chunkingStrategy: FileChunkingStrategyParam) =
                        chunkingStrategy(JsonField.of(chunkingStrategy))

                    /**
                     * The chunking strategy used to chunk the file(s). If not set, will use the
                     * `auto` strategy. Only applicable if `file_ids` is non-empty.
                     */
                    fun chunkingStrategy(chunkingStrategy: JsonField<FileChunkingStrategyParam>) =
                        apply {
                            this.chunkingStrategy = chunkingStrategy
                        }

                    /**
                     * The default strategy. This strategy currently uses a `max_chunk_size_tokens`
                     * of `800` and `chunk_overlap_tokens` of `400`.
                     */
                    fun chunkingStrategy(
                        autoFileChunkingStrategyParam: AutoFileChunkingStrategyParam
                    ) =
                        chunkingStrategy(
                            FileChunkingStrategyParam.ofAutoFileChunkingStrategyParam(
                                autoFileChunkingStrategyParam
                            )
                        )

                    /**
                     * The chunking strategy used to chunk the file(s). If not set, will use the
                     * `auto` strategy. Only applicable if `file_ids` is non-empty.
                     */
                    fun chunkingStrategy(
                        staticFileChunkingStrategyObjectParam: StaticFileChunkingStrategyObjectParam
                    ) =
                        chunkingStrategy(
                            FileChunkingStrategyParam.ofStaticFileChunkingStrategyObjectParam(
                                staticFileChunkingStrategyObjectParam
                            )
                        )

                    /**
                     * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs to
                     * add to the vector store. There can be a maximum of 10000 files in a vector
                     * store.
                     */
                    fun fileIds(fileIds: List<String>) = fileIds(JsonField.of(fileIds))

                    /**
                     * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs to
                     * add to the vector store. There can be a maximum of 10000 files in a vector
                     * store.
                     */
                    fun fileIds(fileIds: JsonField<List<String>>) = apply {
                        this.fileIds = fileIds.map { it.toMutableList() }
                    }

                    /**
                     * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs to
                     * add to the vector store. There can be a maximum of 10000 files in a vector
                     * store.
                     */
                    fun addFileId(fileId: String) = apply {
                        fileIds =
                            (fileIds ?: JsonField.of(mutableListOf())).apply {
                                asKnown()
                                    .orElseThrow {
                                        IllegalStateException(
                                            "Field was set to non-list type: ${javaClass.simpleName}"
                                        )
                                    }
                                    .add(fileId)
                            }
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
                            chunkingStrategy,
                            (fileIds ?: JsonMissing.of()).map { it.toImmutable() },
                            metadata,
                            additionalProperties.toImmutable(),
                        )
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is VectorStore && chunkingStrategy == other.chunkingStrategy && fileIds == other.fileIds && metadata == other.metadata && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(chunkingStrategy, fileIds, metadata, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "VectorStore{chunkingStrategy=$chunkingStrategy, fileIds=$fileIds, metadata=$metadata, additionalProperties=$additionalProperties}"
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
