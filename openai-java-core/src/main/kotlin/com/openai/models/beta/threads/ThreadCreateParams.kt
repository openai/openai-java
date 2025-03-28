// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads

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
import com.openai.core.Params
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.beta.assistants.CodeInterpreterTool
import com.openai.models.beta.threads.messages.MessageContentPartParam
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Create a thread. */
class ThreadCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * A list of [messages](https://platform.openai.com/docs/api-reference/messages) to start the
     * thread with.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun messages(): Optional<List<Message>> = body.messages()

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format, and querying for objects via
     * API or the dashboard.
     *
     * Keys are strings with a maximum length of 64 characters. Values are strings with a maximum
     * length of 512 characters.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun metadata(): Optional<Metadata> = body.metadata()

    /**
     * A set of resources that are made available to the assistant's tools in this thread. The
     * resources are specific to the type of tool. For example, the `code_interpreter` tool requires
     * a list of file IDs, while the `file_search` tool requires a list of vector store IDs.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun toolResources(): Optional<ToolResources> = body.toolResources()

    /**
     * Returns the raw JSON value of [messages].
     *
     * Unlike [messages], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _messages(): JsonField<List<Message>> = body._messages()

    /**
     * Returns the raw JSON value of [metadata].
     *
     * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _metadata(): JsonField<Metadata> = body._metadata()

    /**
     * Returns the raw JSON value of [toolResources].
     *
     * Unlike [toolResources], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _toolResources(): JsonField<ToolResources> = body._toolResources()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): ThreadCreateParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [ThreadCreateParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ThreadCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(threadCreateParams: ThreadCreateParams) = apply {
            body = threadCreateParams.body.toBuilder()
            additionalHeaders = threadCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = threadCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * A list of [messages](https://platform.openai.com/docs/api-reference/messages) to start
         * the thread with.
         */
        fun messages(messages: List<Message>) = apply { body.messages(messages) }

        /**
         * Sets [Builder.messages] to an arbitrary JSON value.
         *
         * You should usually call [Builder.messages] with a well-typed `List<Message>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun messages(messages: JsonField<List<Message>>) = apply { body.messages(messages) }

        /**
         * Adds a single [Message] to [messages].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addMessage(message: Message) = apply { body.addMessage(message) }

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard.
         *
         * Keys are strings with a maximum length of 64 characters. Values are strings with a
         * maximum length of 512 characters.
         */
        fun metadata(metadata: Metadata?) = apply { body.metadata(metadata) }

        /** Alias for calling [Builder.metadata] with `metadata.orElse(null)`. */
        fun metadata(metadata: Optional<Metadata>) = metadata(metadata.getOrNull())

        /**
         * Sets [Builder.metadata] to an arbitrary JSON value.
         *
         * You should usually call [Builder.metadata] with a well-typed [Metadata] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun metadata(metadata: JsonField<Metadata>) = apply { body.metadata(metadata) }

        /**
         * A set of resources that are made available to the assistant's tools in this thread. The
         * resources are specific to the type of tool. For example, the `code_interpreter` tool
         * requires a list of file IDs, while the `file_search` tool requires a list of vector store
         * IDs.
         */
        fun toolResources(toolResources: ToolResources?) = apply {
            body.toolResources(toolResources)
        }

        /** Alias for calling [Builder.toolResources] with `toolResources.orElse(null)`. */
        fun toolResources(toolResources: Optional<ToolResources>) =
            toolResources(toolResources.getOrNull())

        /**
         * Sets [Builder.toolResources] to an arbitrary JSON value.
         *
         * You should usually call [Builder.toolResources] with a well-typed [ToolResources] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
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

        /**
         * Returns an immutable instance of [ThreadCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ThreadCreateParams =
            ThreadCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    @JvmSynthetic internal fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /**
     * Options to create a new thread. If no thread is provided when running a request, an empty
     * thread will be created.
     */
    class Body
    private constructor(
        private val messages: JsonField<List<Message>>,
        private val metadata: JsonField<Metadata>,
        private val toolResources: JsonField<ToolResources>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("messages")
            @ExcludeMissing
            messages: JsonField<List<Message>> = JsonMissing.of(),
            @JsonProperty("metadata")
            @ExcludeMissing
            metadata: JsonField<Metadata> = JsonMissing.of(),
            @JsonProperty("tool_resources")
            @ExcludeMissing
            toolResources: JsonField<ToolResources> = JsonMissing.of(),
        ) : this(messages, metadata, toolResources, mutableMapOf())

        /**
         * A list of [messages](https://platform.openai.com/docs/api-reference/messages) to start
         * the thread with.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun messages(): Optional<List<Message>> =
            Optional.ofNullable(messages.getNullable("messages"))

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard.
         *
         * Keys are strings with a maximum length of 64 characters. Values are strings with a
         * maximum length of 512 characters.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun metadata(): Optional<Metadata> = Optional.ofNullable(metadata.getNullable("metadata"))

        /**
         * A set of resources that are made available to the assistant's tools in this thread. The
         * resources are specific to the type of tool. For example, the `code_interpreter` tool
         * requires a list of file IDs, while the `file_search` tool requires a list of vector store
         * IDs.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun toolResources(): Optional<ToolResources> =
            Optional.ofNullable(toolResources.getNullable("tool_resources"))

        /**
         * Returns the raw JSON value of [messages].
         *
         * Unlike [messages], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("messages")
        @ExcludeMissing
        fun _messages(): JsonField<List<Message>> = messages

        /**
         * Returns the raw JSON value of [metadata].
         *
         * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonField<Metadata> = metadata

        /**
         * Returns the raw JSON value of [toolResources].
         *
         * Unlike [toolResources], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("tool_resources")
        @ExcludeMissing
        fun _toolResources(): JsonField<ToolResources> = toolResources

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

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var messages: JsonField<MutableList<Message>>? = null
            private var metadata: JsonField<Metadata> = JsonMissing.of()
            private var toolResources: JsonField<ToolResources> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                messages = body.messages.map { it.toMutableList() }
                metadata = body.metadata
                toolResources = body.toolResources
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * A list of [messages](https://platform.openai.com/docs/api-reference/messages) to
             * start the thread with.
             */
            fun messages(messages: List<Message>) = messages(JsonField.of(messages))

            /**
             * Sets [Builder.messages] to an arbitrary JSON value.
             *
             * You should usually call [Builder.messages] with a well-typed `List<Message>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun messages(messages: JsonField<List<Message>>) = apply {
                this.messages = messages.map { it.toMutableList() }
            }

            /**
             * Adds a single [Message] to [messages].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addMessage(message: Message) = apply {
                messages =
                    (messages ?: JsonField.of(mutableListOf())).also {
                        checkKnown("messages", it).add(message)
                    }
            }

            /**
             * Set of 16 key-value pairs that can be attached to an object. This can be useful for
             * storing additional information about the object in a structured format, and querying
             * for objects via API or the dashboard.
             *
             * Keys are strings with a maximum length of 64 characters. Values are strings with a
             * maximum length of 512 characters.
             */
            fun metadata(metadata: Metadata?) = metadata(JsonField.ofNullable(metadata))

            /** Alias for calling [Builder.metadata] with `metadata.orElse(null)`. */
            fun metadata(metadata: Optional<Metadata>) = metadata(metadata.getOrNull())

            /**
             * Sets [Builder.metadata] to an arbitrary JSON value.
             *
             * You should usually call [Builder.metadata] with a well-typed [Metadata] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

            /**
             * A set of resources that are made available to the assistant's tools in this thread.
             * The resources are specific to the type of tool. For example, the `code_interpreter`
             * tool requires a list of file IDs, while the `file_search` tool requires a list of
             * vector store IDs.
             */
            fun toolResources(toolResources: ToolResources?) =
                toolResources(JsonField.ofNullable(toolResources))

            /** Alias for calling [Builder.toolResources] with `toolResources.orElse(null)`. */
            fun toolResources(toolResources: Optional<ToolResources>) =
                toolResources(toolResources.getOrNull())

            /**
             * Sets [Builder.toolResources] to an arbitrary JSON value.
             *
             * You should usually call [Builder.toolResources] with a well-typed [ToolResources]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
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

            /**
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Body =
                Body(
                    (messages ?: JsonMissing.of()).map { it.toImmutable() },
                    metadata,
                    toolResources,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            messages().ifPresent { it.forEach { it.validate() } }
            metadata().ifPresent { it.validate() }
            toolResources().ifPresent { it.validate() }
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && messages == other.messages && metadata == other.metadata && toolResources == other.toolResources && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(messages, metadata, toolResources, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{messages=$messages, metadata=$metadata, toolResources=$toolResources, additionalProperties=$additionalProperties}"
    }

    class Message
    private constructor(
        private val content: JsonField<Content>,
        private val role: JsonField<Role>,
        private val attachments: JsonField<List<Attachment>>,
        private val metadata: JsonField<Metadata>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("content") @ExcludeMissing content: JsonField<Content> = JsonMissing.of(),
            @JsonProperty("role") @ExcludeMissing role: JsonField<Role> = JsonMissing.of(),
            @JsonProperty("attachments")
            @ExcludeMissing
            attachments: JsonField<List<Attachment>> = JsonMissing.of(),
            @JsonProperty("metadata")
            @ExcludeMissing
            metadata: JsonField<Metadata> = JsonMissing.of(),
        ) : this(content, role, attachments, metadata, mutableMapOf())

        /**
         * The text contents of the message.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun content(): Content = content.getRequired("content")

        /**
         * The role of the entity that is creating the message. Allowed values include:
         * - `user`: Indicates the message is sent by an actual user and should be used in most
         *   cases to represent user-generated messages.
         * - `assistant`: Indicates the message is generated by the assistant. Use this value to
         *   insert messages from the assistant into the conversation.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun role(): Role = role.getRequired("role")

        /**
         * A list of files attached to the message, and the tools they should be added to.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun attachments(): Optional<List<Attachment>> =
            Optional.ofNullable(attachments.getNullable("attachments"))

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard.
         *
         * Keys are strings with a maximum length of 64 characters. Values are strings with a
         * maximum length of 512 characters.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun metadata(): Optional<Metadata> = Optional.ofNullable(metadata.getNullable("metadata"))

        /**
         * Returns the raw JSON value of [content].
         *
         * Unlike [content], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<Content> = content

        /**
         * Returns the raw JSON value of [role].
         *
         * Unlike [role], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<Role> = role

        /**
         * Returns the raw JSON value of [attachments].
         *
         * Unlike [attachments], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("attachments")
        @ExcludeMissing
        fun _attachments(): JsonField<List<Attachment>> = attachments

        /**
         * Returns the raw JSON value of [metadata].
         *
         * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonField<Metadata> = metadata

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
             * Returns a mutable builder for constructing an instance of [Message].
             *
             * The following fields are required:
             * ```java
             * .content()
             * .role()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Message]. */
        class Builder internal constructor() {

            private var content: JsonField<Content>? = null
            private var role: JsonField<Role>? = null
            private var attachments: JsonField<MutableList<Attachment>>? = null
            private var metadata: JsonField<Metadata> = JsonMissing.of()
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

            /**
             * Sets [Builder.content] to an arbitrary JSON value.
             *
             * You should usually call [Builder.content] with a well-typed [Content] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun content(content: JsonField<Content>) = apply { this.content = content }

            /** Alias for calling [content] with `Content.ofText(text)`. */
            fun content(text: String) = content(Content.ofText(text))

            /**
             * Alias for calling [content] with
             * `Content.ofArrayOfContentParts(arrayOfContentParts)`.
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
             * Sets [Builder.role] to an arbitrary JSON value.
             *
             * You should usually call [Builder.role] with a well-typed [Role] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun role(role: JsonField<Role>) = apply { this.role = role }

            /** A list of files attached to the message, and the tools they should be added to. */
            fun attachments(attachments: List<Attachment>?) =
                attachments(JsonField.ofNullable(attachments))

            /** Alias for calling [Builder.attachments] with `attachments.orElse(null)`. */
            fun attachments(attachments: Optional<List<Attachment>>) =
                attachments(attachments.getOrNull())

            /**
             * Sets [Builder.attachments] to an arbitrary JSON value.
             *
             * You should usually call [Builder.attachments] with a well-typed `List<Attachment>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun attachments(attachments: JsonField<List<Attachment>>) = apply {
                this.attachments = attachments.map { it.toMutableList() }
            }

            /**
             * Adds a single [Attachment] to [attachments].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addAttachment(attachment: Attachment) = apply {
                attachments =
                    (attachments ?: JsonField.of(mutableListOf())).also {
                        checkKnown("attachments", it).add(attachment)
                    }
            }

            /**
             * Set of 16 key-value pairs that can be attached to an object. This can be useful for
             * storing additional information about the object in a structured format, and querying
             * for objects via API or the dashboard.
             *
             * Keys are strings with a maximum length of 64 characters. Values are strings with a
             * maximum length of 512 characters.
             */
            fun metadata(metadata: Metadata?) = metadata(JsonField.ofNullable(metadata))

            /** Alias for calling [Builder.metadata] with `metadata.orElse(null)`. */
            fun metadata(metadata: Optional<Metadata>) = metadata(metadata.getOrNull())

            /**
             * Sets [Builder.metadata] to an arbitrary JSON value.
             *
             * You should usually call [Builder.metadata] with a well-typed [Metadata] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

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
             * Returns an immutable instance of [Message].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .content()
             * .role()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Message =
                Message(
                    checkRequired("content", content),
                    checkRequired("role", role),
                    (attachments ?: JsonMissing.of()).map { it.toImmutable() },
                    metadata,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Message = apply {
            if (validated) {
                return@apply
            }

            content().validate()
            role()
            attachments().ifPresent { it.forEach { it.validate() } }
            metadata().ifPresent { it.validate() }
            validated = true
        }

        /** The text contents of the message. */
        @JsonDeserialize(using = Content.Deserializer::class)
        @JsonSerialize(using = Content.Serializer::class)
        class Content
        private constructor(
            private val text: String? = null,
            private val arrayOfContentParts: List<MessageContentPartParam>? = null,
            private val _json: JsonValue? = null,
        ) {

            /** The text contents of the message. */
            fun text(): Optional<String> = Optional.ofNullable(text)

            /**
             * An array of content parts with a defined type, each can be of type `text` or images
             * can be passed with `image_url` or `image_file`. Image types are only supported on
             * [Vision-compatible models](https://platform.openai.com/docs/models).
             */
            fun arrayOfContentParts(): Optional<List<MessageContentPartParam>> =
                Optional.ofNullable(arrayOfContentParts)

            fun isText(): Boolean = text != null

            fun isArrayOfContentParts(): Boolean = arrayOfContentParts != null

            /** The text contents of the message. */
            fun asText(): String = text.getOrThrow("text")

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
                    text != null -> visitor.visitText(text)
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
                        override fun visitText(text: String) {}

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

                return /* spotless:off */ other is Content && text == other.text && arrayOfContentParts == other.arrayOfContentParts /* spotless:on */
            }

            override fun hashCode(): Int = /* spotless:off */ Objects.hash(text, arrayOfContentParts) /* spotless:on */

            override fun toString(): String =
                when {
                    text != null -> "Content{text=$text}"
                    arrayOfContentParts != null ->
                        "Content{arrayOfContentParts=$arrayOfContentParts}"
                    _json != null -> "Content{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Content")
                }

            companion object {

                /** The text contents of the message. */
                @JvmStatic fun ofText(text: String) = Content(text = text)

                /**
                 * An array of content parts with a defined type, each can be of type `text` or
                 * images can be passed with `image_url` or `image_file`. Image types are only
                 * supported on [Vision-compatible models](https://platform.openai.com/docs/models).
                 */
                @JvmStatic
                fun ofArrayOfContentParts(arrayOfContentParts: List<MessageContentPartParam>) =
                    Content(arrayOfContentParts = arrayOfContentParts)
            }

            /**
             * An interface that defines how to map each variant of [Content] to a value of type
             * [T].
             */
            interface Visitor<out T> {

                /** The text contents of the message. */
                fun visitText(text: String): T

                /**
                 * An array of content parts with a defined type, each can be of type `text` or
                 * images can be passed with `image_url` or `image_file`. Image types are only
                 * supported on [Vision-compatible models](https://platform.openai.com/docs/models).
                 */
                fun visitArrayOfContentParts(arrayOfContentParts: List<MessageContentPartParam>): T

                /**
                 * Maps an unknown variant of [Content] to a value of type [T].
                 *
                 * An instance of [Content] can contain an unknown variant if it was deserialized
                 * from data that doesn't match any known variant. For example, if the SDK is on an
                 * older version than the API, then the API may respond with new variants that the
                 * SDK is unaware of.
                 *
                 * @throws OpenAIInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown Content: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<Content>(Content::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Content {
                    val json = JsonValue.fromJsonNode(node)

                    tryDeserialize(node, jacksonTypeRef<String>())?.let {
                        return Content(text = it, _json = json)
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

            internal class Serializer : BaseSerializer<Content>(Content::class) {

                override fun serialize(
                    value: Content,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.text != null -> generator.writeObject(value.text)
                        value.arrayOfContentParts != null ->
                            generator.writeObject(value.arrayOfContentParts)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Content")
                    }
                }
            }
        }

        /**
         * The role of the entity that is creating the message. Allowed values include:
         * - `user`: Indicates the message is sent by an actual user and should be used in most
         *   cases to represent user-generated messages.
         * - `assistant`: Indicates the message is generated by the assistant. Use this value to
         *   insert messages from the assistant into the conversation.
         */
        class Role @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val USER = of("user")

                @JvmField val ASSISTANT = of("assistant")

                @JvmStatic fun of(value: String) = Role(JsonField.of(value))
            }

            /** An enum containing [Role]'s known values. */
            enum class Known {
                USER,
                ASSISTANT,
            }

            /**
             * An enum containing [Role]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Role] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                USER,
                ASSISTANT,
                /** An enum member indicating that [Role] was instantiated with an unknown value. */
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
                    USER -> Value.USER
                    ASSISTANT -> Value.ASSISTANT
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
                    USER -> Known.USER
                    ASSISTANT -> Known.ASSISTANT
                    else -> throw OpenAIInvalidDataException("Unknown Role: $value")
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

                return /* spotless:off */ other is Role && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class Attachment
        private constructor(
            private val fileId: JsonField<String>,
            private val tools: JsonField<List<Tool>>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("file_id")
                @ExcludeMissing
                fileId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("tools")
                @ExcludeMissing
                tools: JsonField<List<Tool>> = JsonMissing.of(),
            ) : this(fileId, tools, mutableMapOf())

            /**
             * The ID of the file to attach to the message.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun fileId(): Optional<String> = Optional.ofNullable(fileId.getNullable("file_id"))

            /**
             * The tools to add this file to.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun tools(): Optional<List<Tool>> = Optional.ofNullable(tools.getNullable("tools"))

            /**
             * Returns the raw JSON value of [fileId].
             *
             * Unlike [fileId], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

            /**
             * Returns the raw JSON value of [tools].
             *
             * Unlike [tools], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("tools") @ExcludeMissing fun _tools(): JsonField<List<Tool>> = tools

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

                /** Returns a mutable builder for constructing an instance of [Attachment]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Attachment]. */
            class Builder internal constructor() {

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

                /**
                 * Sets [Builder.fileId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.fileId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

                /** The tools to add this file to. */
                fun tools(tools: List<Tool>) = tools(JsonField.of(tools))

                /**
                 * Sets [Builder.tools] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.tools] with a well-typed `List<Tool>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun tools(tools: JsonField<List<Tool>>) = apply {
                    this.tools = tools.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Tool] to [tools].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addTool(tool: Tool) = apply {
                    tools =
                        (tools ?: JsonField.of(mutableListOf())).also {
                            checkKnown("tools", it).add(tool)
                        }
                }

                /** Alias for calling [addTool] with `Tool.ofCodeInterpreter(codeInterpreter)`. */
                fun addTool(codeInterpreter: CodeInterpreterTool) =
                    addTool(Tool.ofCodeInterpreter(codeInterpreter))

                /** Alias for calling [addTool] with `Tool.ofFileSearch()`. */
                fun addToolFileSearch() = addTool(Tool.ofFileSearch())

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
                 * Returns an immutable instance of [Attachment].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Attachment =
                    Attachment(
                        fileId,
                        (tools ?: JsonMissing.of()).map { it.toImmutable() },
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Attachment = apply {
                if (validated) {
                    return@apply
                }

                fileId()
                tools().ifPresent { it.forEach { it.validate() } }
                validated = true
            }

            @JsonDeserialize(using = Tool.Deserializer::class)
            @JsonSerialize(using = Tool.Serializer::class)
            class Tool
            private constructor(
                private val codeInterpreter: CodeInterpreterTool? = null,
                private val fileSearch: JsonValue? = null,
                private val _json: JsonValue? = null,
            ) {

                fun codeInterpreter(): Optional<CodeInterpreterTool> =
                    Optional.ofNullable(codeInterpreter)

                fun fileSearch(): Optional<JsonValue> = Optional.ofNullable(fileSearch)

                fun isCodeInterpreter(): Boolean = codeInterpreter != null

                fun isFileSearch(): Boolean = fileSearch != null

                fun asCodeInterpreter(): CodeInterpreterTool =
                    codeInterpreter.getOrThrow("codeInterpreter")

                fun asFileSearch(): JsonValue = fileSearch.getOrThrow("fileSearch")

                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                fun <T> accept(visitor: Visitor<T>): T {
                    return when {
                        codeInterpreter != null -> visitor.visitCodeInterpreter(codeInterpreter)
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
                            override fun visitCodeInterpreter(
                                codeInterpreter: CodeInterpreterTool
                            ) {
                                codeInterpreter.validate()
                            }

                            override fun visitFileSearch(fileSearch: JsonValue) {
                                fileSearch.let {
                                    if (it != JsonValue.from(mapOf("type" to "file_search"))) {
                                        throw OpenAIInvalidDataException(
                                            "'fileSearch' is invalid, received $it"
                                        )
                                    }
                                }
                            }
                        }
                    )
                    validated = true
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Tool && codeInterpreter == other.codeInterpreter && fileSearch == other.fileSearch /* spotless:on */
                }

                override fun hashCode(): Int = /* spotless:off */ Objects.hash(codeInterpreter, fileSearch) /* spotless:on */

                override fun toString(): String =
                    when {
                        codeInterpreter != null -> "Tool{codeInterpreter=$codeInterpreter}"
                        fileSearch != null -> "Tool{fileSearch=$fileSearch}"
                        _json != null -> "Tool{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid Tool")
                    }

                companion object {

                    @JvmStatic
                    fun ofCodeInterpreter(codeInterpreter: CodeInterpreterTool) =
                        Tool(codeInterpreter = codeInterpreter)

                    @JvmStatic
                    fun ofFileSearch() =
                        Tool(fileSearch = JsonValue.from(mapOf("type" to "file_search")))
                }

                /**
                 * An interface that defines how to map each variant of [Tool] to a value of type
                 * [T].
                 */
                interface Visitor<out T> {

                    fun visitCodeInterpreter(codeInterpreter: CodeInterpreterTool): T

                    fun visitFileSearch(fileSearch: JsonValue): T

                    /**
                     * Maps an unknown variant of [Tool] to a value of type [T].
                     *
                     * An instance of [Tool] can contain an unknown variant if it was deserialized
                     * from data that doesn't match any known variant. For example, if the SDK is on
                     * an older version than the API, then the API may respond with new variants
                     * that the SDK is unaware of.
                     *
                     * @throws OpenAIInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw OpenAIInvalidDataException("Unknown Tool: $json")
                    }
                }

                internal class Deserializer : BaseDeserializer<Tool>(Tool::class) {

                    override fun ObjectCodec.deserialize(node: JsonNode): Tool {
                        val json = JsonValue.fromJsonNode(node)
                        val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                        when (type) {
                            "code_interpreter" -> {
                                return Tool(
                                    codeInterpreter =
                                        deserialize(node, jacksonTypeRef<CodeInterpreterTool>()),
                                    _json = json,
                                )
                            }
                            "file_search" -> {
                                return Tool(
                                    fileSearch = deserialize(node, jacksonTypeRef<JsonValue>()),
                                    _json = json,
                                )
                            }
                        }

                        return Tool(_json = json)
                    }
                }

                internal class Serializer : BaseSerializer<Tool>(Tool::class) {

                    override fun serialize(
                        value: Tool,
                        generator: JsonGenerator,
                        provider: SerializerProvider,
                    ) {
                        when {
                            value.codeInterpreter != null ->
                                generator.writeObject(value.codeInterpreter)
                            value.fileSearch != null -> generator.writeObject(value.fileSearch)
                            value._json != null -> generator.writeObject(value._json)
                            else -> throw IllegalStateException("Invalid Tool")
                        }
                    }
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

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard.
         *
         * Keys are strings with a maximum length of 64 characters. Values are strings with a
         * maximum length of 512 characters.
         */
        class Metadata
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

                /** Returns a mutable builder for constructing an instance of [Metadata]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Metadata]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(metadata: Metadata) = apply {
                    additionalProperties = metadata.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [Metadata].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Metadata = Metadata(additionalProperties.toImmutable())
            }

            private var validated: Boolean = false

            fun validate(): Metadata = apply {
                if (validated) {
                    return@apply
                }

                validated = true
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Metadata && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() = "Metadata{additionalProperties=$additionalProperties}"
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
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format, and querying for objects via
     * API or the dashboard.
     *
     * Keys are strings with a maximum length of 64 characters. Values are strings with a maximum
     * length of 512 characters.
     */
    class Metadata
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

            /** Returns a mutable builder for constructing an instance of [Metadata]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Metadata]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(metadata: Metadata) = apply {
                additionalProperties = metadata.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Metadata].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Metadata = Metadata(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): Metadata = apply {
            if (validated) {
                return@apply
            }

            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Metadata && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Metadata{additionalProperties=$additionalProperties}"
    }

    /**
     * A set of resources that are made available to the assistant's tools in this thread. The
     * resources are specific to the type of tool. For example, the `code_interpreter` tool requires
     * a list of file IDs, while the `file_search` tool requires a list of vector store IDs.
     */
    class ToolResources
    private constructor(
        private val codeInterpreter: JsonField<CodeInterpreter>,
        private val fileSearch: JsonField<FileSearch>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("code_interpreter")
            @ExcludeMissing
            codeInterpreter: JsonField<CodeInterpreter> = JsonMissing.of(),
            @JsonProperty("file_search")
            @ExcludeMissing
            fileSearch: JsonField<FileSearch> = JsonMissing.of(),
        ) : this(codeInterpreter, fileSearch, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun codeInterpreter(): Optional<CodeInterpreter> =
            Optional.ofNullable(codeInterpreter.getNullable("code_interpreter"))

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun fileSearch(): Optional<FileSearch> =
            Optional.ofNullable(fileSearch.getNullable("file_search"))

        /**
         * Returns the raw JSON value of [codeInterpreter].
         *
         * Unlike [codeInterpreter], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("code_interpreter")
        @ExcludeMissing
        fun _codeInterpreter(): JsonField<CodeInterpreter> = codeInterpreter

        /**
         * Returns the raw JSON value of [fileSearch].
         *
         * Unlike [fileSearch], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("file_search")
        @ExcludeMissing
        fun _fileSearch(): JsonField<FileSearch> = fileSearch

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

            /** Returns a mutable builder for constructing an instance of [ToolResources]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ToolResources]. */
        class Builder internal constructor() {

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

            /**
             * Sets [Builder.codeInterpreter] to an arbitrary JSON value.
             *
             * You should usually call [Builder.codeInterpreter] with a well-typed [CodeInterpreter]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun codeInterpreter(codeInterpreter: JsonField<CodeInterpreter>) = apply {
                this.codeInterpreter = codeInterpreter
            }

            fun fileSearch(fileSearch: FileSearch) = fileSearch(JsonField.of(fileSearch))

            /**
             * Sets [Builder.fileSearch] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fileSearch] with a well-typed [FileSearch] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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

            /**
             * Returns an immutable instance of [ToolResources].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ToolResources =
                ToolResources(codeInterpreter, fileSearch, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): ToolResources = apply {
            if (validated) {
                return@apply
            }

            codeInterpreter().ifPresent { it.validate() }
            fileSearch().ifPresent { it.validate() }
            validated = true
        }

        class CodeInterpreter
        private constructor(
            private val fileIds: JsonField<List<String>>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("file_ids")
                @ExcludeMissing
                fileIds: JsonField<List<String>> = JsonMissing.of()
            ) : this(fileIds, mutableMapOf())

            /**
             * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs made
             * available to the `code_interpreter` tool. There can be a maximum of 20 files
             * associated with the tool.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun fileIds(): Optional<List<String>> =
                Optional.ofNullable(fileIds.getNullable("file_ids"))

            /**
             * Returns the raw JSON value of [fileIds].
             *
             * Unlike [fileIds], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("file_ids")
            @ExcludeMissing
            fun _fileIds(): JsonField<List<String>> = fileIds

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

                /** Returns a mutable builder for constructing an instance of [CodeInterpreter]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [CodeInterpreter]. */
            class Builder internal constructor() {

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
                 * Sets [Builder.fileIds] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.fileIds] with a well-typed `List<String>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun fileIds(fileIds: JsonField<List<String>>) = apply {
                    this.fileIds = fileIds.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [fileIds].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addFileId(fileId: String) = apply {
                    fileIds =
                        (fileIds ?: JsonField.of(mutableListOf())).also {
                            checkKnown("fileIds", it).add(fileId)
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

                /**
                 * Returns an immutable instance of [CodeInterpreter].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): CodeInterpreter =
                    CodeInterpreter(
                        (fileIds ?: JsonMissing.of()).map { it.toImmutable() },
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): CodeInterpreter = apply {
                if (validated) {
                    return@apply
                }

                fileIds()
                validated = true
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

        class FileSearch
        private constructor(
            private val vectorStoreIds: JsonField<List<String>>,
            private val vectorStores: JsonField<List<VectorStore>>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("vector_store_ids")
                @ExcludeMissing
                vectorStoreIds: JsonField<List<String>> = JsonMissing.of(),
                @JsonProperty("vector_stores")
                @ExcludeMissing
                vectorStores: JsonField<List<VectorStore>> = JsonMissing.of(),
            ) : this(vectorStoreIds, vectorStores, mutableMapOf())

            /**
             * The
             * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
             * attached to this thread. There can be a maximum of 1 vector store attached to the
             * thread.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun vectorStoreIds(): Optional<List<String>> =
                Optional.ofNullable(vectorStoreIds.getNullable("vector_store_ids"))

            /**
             * A helper to create a
             * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
             * with file_ids and attach it to this thread. There can be a maximum of 1 vector store
             * attached to the thread.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun vectorStores(): Optional<List<VectorStore>> =
                Optional.ofNullable(vectorStores.getNullable("vector_stores"))

            /**
             * Returns the raw JSON value of [vectorStoreIds].
             *
             * Unlike [vectorStoreIds], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("vector_store_ids")
            @ExcludeMissing
            fun _vectorStoreIds(): JsonField<List<String>> = vectorStoreIds

            /**
             * Returns the raw JSON value of [vectorStores].
             *
             * Unlike [vectorStores], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("vector_stores")
            @ExcludeMissing
            fun _vectorStores(): JsonField<List<VectorStore>> = vectorStores

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

                /** Returns a mutable builder for constructing an instance of [FileSearch]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [FileSearch]. */
            class Builder internal constructor() {

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
                 * Sets [Builder.vectorStoreIds] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.vectorStoreIds] with a well-typed `List<String>`
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun vectorStoreIds(vectorStoreIds: JsonField<List<String>>) = apply {
                    this.vectorStoreIds = vectorStoreIds.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [vectorStoreIds].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addVectorStoreId(vectorStoreId: String) = apply {
                    vectorStoreIds =
                        (vectorStoreIds ?: JsonField.of(mutableListOf())).also {
                            checkKnown("vectorStoreIds", it).add(vectorStoreId)
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
                 * Sets [Builder.vectorStores] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.vectorStores] with a well-typed
                 * `List<VectorStore>` value instead. This method is primarily for setting the field
                 * to an undocumented or not yet supported value.
                 */
                fun vectorStores(vectorStores: JsonField<List<VectorStore>>) = apply {
                    this.vectorStores = vectorStores.map { it.toMutableList() }
                }

                /**
                 * Adds a single [VectorStore] to [vectorStores].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addVectorStore(vectorStore: VectorStore) = apply {
                    vectorStores =
                        (vectorStores ?: JsonField.of(mutableListOf())).also {
                            checkKnown("vectorStores", it).add(vectorStore)
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

                /**
                 * Returns an immutable instance of [FileSearch].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): FileSearch =
                    FileSearch(
                        (vectorStoreIds ?: JsonMissing.of()).map { it.toImmutable() },
                        (vectorStores ?: JsonMissing.of()).map { it.toImmutable() },
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): FileSearch = apply {
                if (validated) {
                    return@apply
                }

                vectorStoreIds()
                vectorStores().ifPresent { it.forEach { it.validate() } }
                validated = true
            }

            class VectorStore
            private constructor(
                private val chunkingStrategy: JsonField<ChunkingStrategy>,
                private val fileIds: JsonField<List<String>>,
                private val metadata: JsonField<Metadata>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("chunking_strategy")
                    @ExcludeMissing
                    chunkingStrategy: JsonField<ChunkingStrategy> = JsonMissing.of(),
                    @JsonProperty("file_ids")
                    @ExcludeMissing
                    fileIds: JsonField<List<String>> = JsonMissing.of(),
                    @JsonProperty("metadata")
                    @ExcludeMissing
                    metadata: JsonField<Metadata> = JsonMissing.of(),
                ) : this(chunkingStrategy, fileIds, metadata, mutableMapOf())

                /**
                 * The chunking strategy used to chunk the file(s). If not set, will use the `auto`
                 * strategy.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun chunkingStrategy(): Optional<ChunkingStrategy> =
                    Optional.ofNullable(chunkingStrategy.getNullable("chunking_strategy"))

                /**
                 * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs to add
                 * to the vector store. There can be a maximum of 10000 files in a vector store.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun fileIds(): Optional<List<String>> =
                    Optional.ofNullable(fileIds.getNullable("file_ids"))

                /**
                 * Set of 16 key-value pairs that can be attached to an object. This can be useful
                 * for storing additional information about the object in a structured format, and
                 * querying for objects via API or the dashboard.
                 *
                 * Keys are strings with a maximum length of 64 characters. Values are strings with
                 * a maximum length of 512 characters.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun metadata(): Optional<Metadata> =
                    Optional.ofNullable(metadata.getNullable("metadata"))

                /**
                 * Returns the raw JSON value of [chunkingStrategy].
                 *
                 * Unlike [chunkingStrategy], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("chunking_strategy")
                @ExcludeMissing
                fun _chunkingStrategy(): JsonField<ChunkingStrategy> = chunkingStrategy

                /**
                 * Returns the raw JSON value of [fileIds].
                 *
                 * Unlike [fileIds], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("file_ids")
                @ExcludeMissing
                fun _fileIds(): JsonField<List<String>> = fileIds

                /**
                 * Returns the raw JSON value of [metadata].
                 *
                 * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("metadata")
                @ExcludeMissing
                fun _metadata(): JsonField<Metadata> = metadata

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

                    /** Returns a mutable builder for constructing an instance of [VectorStore]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [VectorStore]. */
                class Builder internal constructor() {

                    private var chunkingStrategy: JsonField<ChunkingStrategy> = JsonMissing.of()
                    private var fileIds: JsonField<MutableList<String>>? = null
                    private var metadata: JsonField<Metadata> = JsonMissing.of()
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
                     * `auto` strategy.
                     */
                    fun chunkingStrategy(chunkingStrategy: ChunkingStrategy) =
                        chunkingStrategy(JsonField.of(chunkingStrategy))

                    /**
                     * Sets [Builder.chunkingStrategy] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.chunkingStrategy] with a well-typed
                     * [ChunkingStrategy] value instead. This method is primarily for setting the
                     * field to an undocumented or not yet supported value.
                     */
                    fun chunkingStrategy(chunkingStrategy: JsonField<ChunkingStrategy>) = apply {
                        this.chunkingStrategy = chunkingStrategy
                    }

                    /** Alias for calling [chunkingStrategy] with `ChunkingStrategy.ofAuto()`. */
                    fun chunkingStrategyAuto() = chunkingStrategy(ChunkingStrategy.ofAuto())

                    /**
                     * Alias for calling [chunkingStrategy] with
                     * `ChunkingStrategy.ofStatic(static_)`.
                     */
                    fun chunkingStrategy(static_: ChunkingStrategy.StaticObject) =
                        chunkingStrategy(ChunkingStrategy.ofStatic(static_))

                    /**
                     * Alias for calling [chunkingStrategy] with the following:
                     * ```java
                     * ChunkingStrategy.StaticObject.builder()
                     *     .static_(static_)
                     *     .build()
                     * ```
                     */
                    fun staticChunkingStrategy(static_: ChunkingStrategy.StaticObject.Static) =
                        chunkingStrategy(
                            ChunkingStrategy.StaticObject.builder().static_(static_).build()
                        )

                    /**
                     * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs to
                     * add to the vector store. There can be a maximum of 10000 files in a vector
                     * store.
                     */
                    fun fileIds(fileIds: List<String>) = fileIds(JsonField.of(fileIds))

                    /**
                     * Sets [Builder.fileIds] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.fileIds] with a well-typed `List<String>`
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun fileIds(fileIds: JsonField<List<String>>) = apply {
                        this.fileIds = fileIds.map { it.toMutableList() }
                    }

                    /**
                     * Adds a single [String] to [fileIds].
                     *
                     * @throws IllegalStateException if the field was previously set to a non-list.
                     */
                    fun addFileId(fileId: String) = apply {
                        fileIds =
                            (fileIds ?: JsonField.of(mutableListOf())).also {
                                checkKnown("fileIds", it).add(fileId)
                            }
                    }

                    /**
                     * Set of 16 key-value pairs that can be attached to an object. This can be
                     * useful for storing additional information about the object in a structured
                     * format, and querying for objects via API or the dashboard.
                     *
                     * Keys are strings with a maximum length of 64 characters. Values are strings
                     * with a maximum length of 512 characters.
                     */
                    fun metadata(metadata: Metadata?) = metadata(JsonField.ofNullable(metadata))

                    /** Alias for calling [Builder.metadata] with `metadata.orElse(null)`. */
                    fun metadata(metadata: Optional<Metadata>) = metadata(metadata.getOrNull())

                    /**
                     * Sets [Builder.metadata] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.metadata] with a well-typed [Metadata] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

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
                     * Returns an immutable instance of [VectorStore].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): VectorStore =
                        VectorStore(
                            chunkingStrategy,
                            (fileIds ?: JsonMissing.of()).map { it.toImmutable() },
                            metadata,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): VectorStore = apply {
                    if (validated) {
                        return@apply
                    }

                    chunkingStrategy().ifPresent { it.validate() }
                    fileIds()
                    metadata().ifPresent { it.validate() }
                    validated = true
                }

                /**
                 * The chunking strategy used to chunk the file(s). If not set, will use the `auto`
                 * strategy.
                 */
                @JsonDeserialize(using = ChunkingStrategy.Deserializer::class)
                @JsonSerialize(using = ChunkingStrategy.Serializer::class)
                class ChunkingStrategy
                private constructor(
                    private val auto: JsonValue? = null,
                    private val static_: StaticObject? = null,
                    private val _json: JsonValue? = null,
                ) {

                    /**
                     * The default strategy. This strategy currently uses a `max_chunk_size_tokens`
                     * of `800` and `chunk_overlap_tokens` of `400`.
                     */
                    fun auto(): Optional<JsonValue> = Optional.ofNullable(auto)

                    fun static_(): Optional<StaticObject> = Optional.ofNullable(static_)

                    fun isAuto(): Boolean = auto != null

                    fun isStatic(): Boolean = static_ != null

                    /**
                     * The default strategy. This strategy currently uses a `max_chunk_size_tokens`
                     * of `800` and `chunk_overlap_tokens` of `400`.
                     */
                    fun asAuto(): JsonValue = auto.getOrThrow("auto")

                    fun asStatic(): StaticObject = static_.getOrThrow("static_")

                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                    fun <T> accept(visitor: Visitor<T>): T {
                        return when {
                            auto != null -> visitor.visitAuto(auto)
                            static_ != null -> visitor.visitStatic(static_)
                            else -> visitor.unknown(_json)
                        }
                    }

                    private var validated: Boolean = false

                    fun validate(): ChunkingStrategy = apply {
                        if (validated) {
                            return@apply
                        }

                        accept(
                            object : Visitor<Unit> {
                                override fun visitAuto(auto: JsonValue) {
                                    auto.let {
                                        if (it != JsonValue.from(mapOf("type" to "auto"))) {
                                            throw OpenAIInvalidDataException(
                                                "'auto' is invalid, received $it"
                                            )
                                        }
                                    }
                                }

                                override fun visitStatic(static_: StaticObject) {
                                    static_.validate()
                                }
                            }
                        )
                        validated = true
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is ChunkingStrategy && auto == other.auto && static_ == other.static_ /* spotless:on */
                    }

                    override fun hashCode(): Int = /* spotless:off */ Objects.hash(auto, static_) /* spotless:on */

                    override fun toString(): String =
                        when {
                            auto != null -> "ChunkingStrategy{auto=$auto}"
                            static_ != null -> "ChunkingStrategy{static_=$static_}"
                            _json != null -> "ChunkingStrategy{_unknown=$_json}"
                            else -> throw IllegalStateException("Invalid ChunkingStrategy")
                        }

                    companion object {

                        /**
                         * The default strategy. This strategy currently uses a
                         * `max_chunk_size_tokens` of `800` and `chunk_overlap_tokens` of `400`.
                         */
                        @JvmStatic
                        fun ofAuto() =
                            ChunkingStrategy(auto = JsonValue.from(mapOf("type" to "auto")))

                        @JvmStatic
                        fun ofStatic(static_: StaticObject) = ChunkingStrategy(static_ = static_)
                    }

                    /**
                     * An interface that defines how to map each variant of [ChunkingStrategy] to a
                     * value of type [T].
                     */
                    interface Visitor<out T> {

                        /**
                         * The default strategy. This strategy currently uses a
                         * `max_chunk_size_tokens` of `800` and `chunk_overlap_tokens` of `400`.
                         */
                        fun visitAuto(auto: JsonValue): T

                        fun visitStatic(static_: StaticObject): T

                        /**
                         * Maps an unknown variant of [ChunkingStrategy] to a value of type [T].
                         *
                         * An instance of [ChunkingStrategy] can contain an unknown variant if it
                         * was deserialized from data that doesn't match any known variant. For
                         * example, if the SDK is on an older version than the API, then the API may
                         * respond with new variants that the SDK is unaware of.
                         *
                         * @throws OpenAIInvalidDataException in the default implementation.
                         */
                        fun unknown(json: JsonValue?): T {
                            throw OpenAIInvalidDataException("Unknown ChunkingStrategy: $json")
                        }
                    }

                    internal class Deserializer :
                        BaseDeserializer<ChunkingStrategy>(ChunkingStrategy::class) {

                        override fun ObjectCodec.deserialize(node: JsonNode): ChunkingStrategy {
                            val json = JsonValue.fromJsonNode(node)
                            val type =
                                json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                            when (type) {
                                "auto" -> {
                                    return ChunkingStrategy(
                                        auto = deserialize(node, jacksonTypeRef<JsonValue>()),
                                        _json = json,
                                    )
                                }
                                "static" -> {
                                    return ChunkingStrategy(
                                        static_ = deserialize(node, jacksonTypeRef<StaticObject>()),
                                        _json = json,
                                    )
                                }
                            }

                            return ChunkingStrategy(_json = json)
                        }
                    }

                    internal class Serializer :
                        BaseSerializer<ChunkingStrategy>(ChunkingStrategy::class) {

                        override fun serialize(
                            value: ChunkingStrategy,
                            generator: JsonGenerator,
                            provider: SerializerProvider,
                        ) {
                            when {
                                value.auto != null -> generator.writeObject(value.auto)
                                value.static_ != null -> generator.writeObject(value.static_)
                                value._json != null -> generator.writeObject(value._json)
                                else -> throw IllegalStateException("Invalid ChunkingStrategy")
                            }
                        }
                    }

                    class StaticObject
                    private constructor(
                        private val static_: JsonField<Static>,
                        private val type: JsonValue,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("static")
                            @ExcludeMissing
                            static_: JsonField<Static> = JsonMissing.of(),
                            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                        ) : this(static_, type, mutableMapOf())

                        /**
                         * @throws OpenAIInvalidDataException if the JSON field has an unexpected
                         *   type or is unexpectedly missing or null (e.g. if the server responded
                         *   with an unexpected value).
                         */
                        fun static_(): Static = static_.getRequired("static")

                        /**
                         * Always `static`.
                         *
                         * Expected to always return the following:
                         * ```java
                         * JsonValue.from("static")
                         * ```
                         *
                         * However, this method can be useful for debugging and logging (e.g. if the
                         * server responded with an unexpected value).
                         */
                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                        /**
                         * Returns the raw JSON value of [static_].
                         *
                         * Unlike [static_], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("static")
                        @ExcludeMissing
                        fun _static_(): JsonField<Static> = static_

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
                             * Returns a mutable builder for constructing an instance of
                             * [StaticObject].
                             *
                             * The following fields are required:
                             * ```java
                             * .static_()
                             * ```
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [StaticObject]. */
                        class Builder internal constructor() {

                            private var static_: JsonField<Static>? = null
                            private var type: JsonValue = JsonValue.from("static")
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(staticObject: StaticObject) = apply {
                                static_ = staticObject.static_
                                type = staticObject.type
                                additionalProperties =
                                    staticObject.additionalProperties.toMutableMap()
                            }

                            fun static_(static_: Static) = static_(JsonField.of(static_))

                            /**
                             * Sets [Builder.static_] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.static_] with a well-typed [Static]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun static_(static_: JsonField<Static>) = apply {
                                this.static_ = static_
                            }

                            /**
                             * Sets the field to an arbitrary JSON value.
                             *
                             * It is usually unnecessary to call this method because the field
                             * defaults to the following:
                             * ```java
                             * JsonValue.from("static")
                             * ```
                             *
                             * This method is primarily for setting the field to an undocumented or
                             * not yet supported value.
                             */
                            fun type(type: JsonValue) = apply { this.type = type }

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

                            /**
                             * Returns an immutable instance of [StaticObject].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```java
                             * .static_()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): StaticObject =
                                StaticObject(
                                    checkRequired("static_", static_),
                                    type,
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): StaticObject = apply {
                            if (validated) {
                                return@apply
                            }

                            static_().validate()
                            _type().let {
                                if (it != JsonValue.from("static")) {
                                    throw OpenAIInvalidDataException(
                                        "'type' is invalid, received $it"
                                    )
                                }
                            }
                            validated = true
                        }

                        class Static
                        private constructor(
                            private val chunkOverlapTokens: JsonField<Long>,
                            private val maxChunkSizeTokens: JsonField<Long>,
                            private val additionalProperties: MutableMap<String, JsonValue>,
                        ) {

                            @JsonCreator
                            private constructor(
                                @JsonProperty("chunk_overlap_tokens")
                                @ExcludeMissing
                                chunkOverlapTokens: JsonField<Long> = JsonMissing.of(),
                                @JsonProperty("max_chunk_size_tokens")
                                @ExcludeMissing
                                maxChunkSizeTokens: JsonField<Long> = JsonMissing.of(),
                            ) : this(chunkOverlapTokens, maxChunkSizeTokens, mutableMapOf())

                            /**
                             * The number of tokens that overlap between chunks. The default value
                             * is `400`.
                             *
                             * Note that the overlap must not exceed half of
                             * `max_chunk_size_tokens`.
                             *
                             * @throws OpenAIInvalidDataException if the JSON field has an
                             *   unexpected type or is unexpectedly missing or null (e.g. if the
                             *   server responded with an unexpected value).
                             */
                            fun chunkOverlapTokens(): Long =
                                chunkOverlapTokens.getRequired("chunk_overlap_tokens")

                            /**
                             * The maximum number of tokens in each chunk. The default value is
                             * `800`. The minimum value is `100` and the maximum value is `4096`.
                             *
                             * @throws OpenAIInvalidDataException if the JSON field has an
                             *   unexpected type or is unexpectedly missing or null (e.g. if the
                             *   server responded with an unexpected value).
                             */
                            fun maxChunkSizeTokens(): Long =
                                maxChunkSizeTokens.getRequired("max_chunk_size_tokens")

                            /**
                             * Returns the raw JSON value of [chunkOverlapTokens].
                             *
                             * Unlike [chunkOverlapTokens], this method doesn't throw if the JSON
                             * field has an unexpected type.
                             */
                            @JsonProperty("chunk_overlap_tokens")
                            @ExcludeMissing
                            fun _chunkOverlapTokens(): JsonField<Long> = chunkOverlapTokens

                            /**
                             * Returns the raw JSON value of [maxChunkSizeTokens].
                             *
                             * Unlike [maxChunkSizeTokens], this method doesn't throw if the JSON
                             * field has an unexpected type.
                             */
                            @JsonProperty("max_chunk_size_tokens")
                            @ExcludeMissing
                            fun _maxChunkSizeTokens(): JsonField<Long> = maxChunkSizeTokens

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
                                 * Returns a mutable builder for constructing an instance of
                                 * [Static].
                                 *
                                 * The following fields are required:
                                 * ```java
                                 * .chunkOverlapTokens()
                                 * .maxChunkSizeTokens()
                                 * ```
                                 */
                                @JvmStatic fun builder() = Builder()
                            }

                            /** A builder for [Static]. */
                            class Builder internal constructor() {

                                private var chunkOverlapTokens: JsonField<Long>? = null
                                private var maxChunkSizeTokens: JsonField<Long>? = null
                                private var additionalProperties: MutableMap<String, JsonValue> =
                                    mutableMapOf()

                                @JvmSynthetic
                                internal fun from(static_: Static) = apply {
                                    chunkOverlapTokens = static_.chunkOverlapTokens
                                    maxChunkSizeTokens = static_.maxChunkSizeTokens
                                    additionalProperties =
                                        static_.additionalProperties.toMutableMap()
                                }

                                /**
                                 * The number of tokens that overlap between chunks. The default
                                 * value is `400`.
                                 *
                                 * Note that the overlap must not exceed half of
                                 * `max_chunk_size_tokens`.
                                 */
                                fun chunkOverlapTokens(chunkOverlapTokens: Long) =
                                    chunkOverlapTokens(JsonField.of(chunkOverlapTokens))

                                /**
                                 * Sets [Builder.chunkOverlapTokens] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.chunkOverlapTokens] with a
                                 * well-typed [Long] value instead. This method is primarily for
                                 * setting the field to an undocumented or not yet supported value.
                                 */
                                fun chunkOverlapTokens(chunkOverlapTokens: JsonField<Long>) =
                                    apply {
                                        this.chunkOverlapTokens = chunkOverlapTokens
                                    }

                                /**
                                 * The maximum number of tokens in each chunk. The default value is
                                 * `800`. The minimum value is `100` and the maximum value is
                                 * `4096`.
                                 */
                                fun maxChunkSizeTokens(maxChunkSizeTokens: Long) =
                                    maxChunkSizeTokens(JsonField.of(maxChunkSizeTokens))

                                /**
                                 * Sets [Builder.maxChunkSizeTokens] to an arbitrary JSON value.
                                 *
                                 * You should usually call [Builder.maxChunkSizeTokens] with a
                                 * well-typed [Long] value instead. This method is primarily for
                                 * setting the field to an undocumented or not yet supported value.
                                 */
                                fun maxChunkSizeTokens(maxChunkSizeTokens: JsonField<Long>) =
                                    apply {
                                        this.maxChunkSizeTokens = maxChunkSizeTokens
                                    }

                                fun additionalProperties(
                                    additionalProperties: Map<String, JsonValue>
                                ) = apply {
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

                                /**
                                 * Returns an immutable instance of [Static].
                                 *
                                 * Further updates to this [Builder] will not mutate the returned
                                 * instance.
                                 *
                                 * The following fields are required:
                                 * ```java
                                 * .chunkOverlapTokens()
                                 * .maxChunkSizeTokens()
                                 * ```
                                 *
                                 * @throws IllegalStateException if any required field is unset.
                                 */
                                fun build(): Static =
                                    Static(
                                        checkRequired("chunkOverlapTokens", chunkOverlapTokens),
                                        checkRequired("maxChunkSizeTokens", maxChunkSizeTokens),
                                        additionalProperties.toMutableMap(),
                                    )
                            }

                            private var validated: Boolean = false

                            fun validate(): Static = apply {
                                if (validated) {
                                    return@apply
                                }

                                chunkOverlapTokens()
                                maxChunkSizeTokens()
                                validated = true
                            }

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return /* spotless:off */ other is Static && chunkOverlapTokens == other.chunkOverlapTokens && maxChunkSizeTokens == other.maxChunkSizeTokens && additionalProperties == other.additionalProperties /* spotless:on */
                            }

                            /* spotless:off */
                            private val hashCode: Int by lazy { Objects.hash(chunkOverlapTokens, maxChunkSizeTokens, additionalProperties) }
                            /* spotless:on */

                            override fun hashCode(): Int = hashCode

                            override fun toString() =
                                "Static{chunkOverlapTokens=$chunkOverlapTokens, maxChunkSizeTokens=$maxChunkSizeTokens, additionalProperties=$additionalProperties}"
                        }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return /* spotless:off */ other is StaticObject && static_ == other.static_ && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                        }

                        /* spotless:off */
                        private val hashCode: Int by lazy { Objects.hash(static_, type, additionalProperties) }
                        /* spotless:on */

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "StaticObject{static_=$static_, type=$type, additionalProperties=$additionalProperties}"
                    }
                }

                /**
                 * Set of 16 key-value pairs that can be attached to an object. This can be useful
                 * for storing additional information about the object in a structured format, and
                 * querying for objects via API or the dashboard.
                 *
                 * Keys are strings with a maximum length of 64 characters. Values are strings with
                 * a maximum length of 512 characters.
                 */
                class Metadata
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

                        /** Returns a mutable builder for constructing an instance of [Metadata]. */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Metadata]. */
                    class Builder internal constructor() {

                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(metadata: Metadata) = apply {
                            additionalProperties = metadata.additionalProperties.toMutableMap()
                        }

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

                        /**
                         * Returns an immutable instance of [Metadata].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): Metadata = Metadata(additionalProperties.toImmutable())
                    }

                    private var validated: Boolean = false

                    fun validate(): Metadata = apply {
                        if (validated) {
                            return@apply
                        }

                        validated = true
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is Metadata && additionalProperties == other.additionalProperties /* spotless:on */
                    }

                    /* spotless:off */
                    private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
                    /* spotless:on */

                    override fun hashCode(): Int = hashCode

                    override fun toString() = "Metadata{additionalProperties=$additionalProperties}"
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

        return /* spotless:off */ other is ThreadCreateParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "ThreadCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
