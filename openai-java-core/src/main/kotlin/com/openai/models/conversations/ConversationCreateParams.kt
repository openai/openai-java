// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.Params
import com.openai.core.checkKnown
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.responses.EasyInputMessage
import com.openai.models.responses.ResponseCodeInterpreterToolCall
import com.openai.models.responses.ResponseComputerToolCall
import com.openai.models.responses.ResponseCustomToolCall
import com.openai.models.responses.ResponseCustomToolCallOutput
import com.openai.models.responses.ResponseFileSearchToolCall
import com.openai.models.responses.ResponseFunctionToolCall
import com.openai.models.responses.ResponseFunctionWebSearch
import com.openai.models.responses.ResponseInputItem
import com.openai.models.responses.ResponseOutputMessage
import com.openai.models.responses.ResponseReasoningItem
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Create a conversation. */
class ConversationCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Initial items to include in the conversation context. You may add up to 20 items at a time.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun items(): Optional<List<ResponseInputItem>> = body.items()

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
     * Returns the raw JSON value of [items].
     *
     * Unlike [items], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _items(): JsonField<List<ResponseInputItem>> = body._items()

    /**
     * Returns the raw JSON value of [metadata].
     *
     * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _metadata(): JsonField<Metadata> = body._metadata()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): ConversationCreateParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [ConversationCreateParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ConversationCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(conversationCreateParams: ConversationCreateParams) = apply {
            body = conversationCreateParams.body.toBuilder()
            additionalHeaders = conversationCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = conversationCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [items]
         * - [metadata]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * Initial items to include in the conversation context. You may add up to 20 items at a
         * time.
         */
        fun items(items: List<ResponseInputItem>?) = apply { body.items(items) }

        /** Alias for calling [Builder.items] with `items.orElse(null)`. */
        fun items(items: Optional<List<ResponseInputItem>>) = items(items.getOrNull())

        /**
         * Sets [Builder.items] to an arbitrary JSON value.
         *
         * You should usually call [Builder.items] with a well-typed `List<ResponseInputItem>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun items(items: JsonField<List<ResponseInputItem>>) = apply { body.items(items) }

        /**
         * Adds a single [ResponseInputItem] to [items].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addItem(item: ResponseInputItem) = apply { body.addItem(item) }

        /**
         * Alias for calling [addItem] with
         * `ResponseInputItem.ofEasyInputMessage(easyInputMessage)`.
         */
        fun addItem(easyInputMessage: EasyInputMessage) = apply { body.addItem(easyInputMessage) }

        /** Alias for calling [addItem] with `ResponseInputItem.ofMessage(message)`. */
        fun addItem(message: ResponseInputItem.Message) = apply { body.addItem(message) }

        /**
         * Alias for calling [addItem] with
         * `ResponseInputItem.ofResponseOutputMessage(responseOutputMessage)`.
         */
        fun addItem(responseOutputMessage: ResponseOutputMessage) = apply {
            body.addItem(responseOutputMessage)
        }

        /**
         * Alias for calling [addItem] with `ResponseInputItem.ofFileSearchCall(fileSearchCall)`.
         */
        fun addItem(fileSearchCall: ResponseFileSearchToolCall) = apply {
            body.addItem(fileSearchCall)
        }

        /** Alias for calling [addItem] with `ResponseInputItem.ofComputerCall(computerCall)`. */
        fun addItem(computerCall: ResponseComputerToolCall) = apply { body.addItem(computerCall) }

        /**
         * Alias for calling [addItem] with
         * `ResponseInputItem.ofComputerCallOutput(computerCallOutput)`.
         */
        fun addItem(computerCallOutput: ResponseInputItem.ComputerCallOutput) = apply {
            body.addItem(computerCallOutput)
        }

        /** Alias for calling [addItem] with `ResponseInputItem.ofWebSearchCall(webSearchCall)`. */
        fun addItem(webSearchCall: ResponseFunctionWebSearch) = apply {
            body.addItem(webSearchCall)
        }

        /** Alias for calling [addItem] with `ResponseInputItem.ofFunctionCall(functionCall)`. */
        fun addItem(functionCall: ResponseFunctionToolCall) = apply { body.addItem(functionCall) }

        /**
         * Alias for calling [addItem] with
         * `ResponseInputItem.ofFunctionCallOutput(functionCallOutput)`.
         */
        fun addItem(functionCallOutput: ResponseInputItem.FunctionCallOutput) = apply {
            body.addItem(functionCallOutput)
        }

        /** Alias for calling [addItem] with `ResponseInputItem.ofReasoning(reasoning)`. */
        fun addItem(reasoning: ResponseReasoningItem) = apply { body.addItem(reasoning) }

        /**
         * Alias for calling [addItem] with
         * `ResponseInputItem.ofImageGenerationCall(imageGenerationCall)`.
         */
        fun addItem(imageGenerationCall: ResponseInputItem.ImageGenerationCall) = apply {
            body.addItem(imageGenerationCall)
        }

        /**
         * Alias for calling [addItem] with
         * `ResponseInputItem.ofCodeInterpreterCall(codeInterpreterCall)`.
         */
        fun addItem(codeInterpreterCall: ResponseCodeInterpreterToolCall) = apply {
            body.addItem(codeInterpreterCall)
        }

        /**
         * Alias for calling [addItem] with `ResponseInputItem.ofLocalShellCall(localShellCall)`.
         */
        fun addItem(localShellCall: ResponseInputItem.LocalShellCall) = apply {
            body.addItem(localShellCall)
        }

        /**
         * Alias for calling [addItem] with
         * `ResponseInputItem.ofLocalShellCallOutput(localShellCallOutput)`.
         */
        fun addItem(localShellCallOutput: ResponseInputItem.LocalShellCallOutput) = apply {
            body.addItem(localShellCallOutput)
        }

        /** Alias for calling [addItem] with `ResponseInputItem.ofShellCall(shellCall)`. */
        fun addItem(shellCall: ResponseInputItem.ShellCall) = apply { body.addItem(shellCall) }

        /**
         * Alias for calling [addItem] with `ResponseInputItem.ofShellCallOutput(shellCallOutput)`.
         */
        fun addItem(shellCallOutput: ResponseInputItem.ShellCallOutput) = apply {
            body.addItem(shellCallOutput)
        }

        /**
         * Alias for calling [addItem] with `ResponseInputItem.ofApplyPatchCall(applyPatchCall)`.
         */
        fun addItem(applyPatchCall: ResponseInputItem.ApplyPatchCall) = apply {
            body.addItem(applyPatchCall)
        }

        /**
         * Alias for calling [addItem] with
         * `ResponseInputItem.ofApplyPatchCallOutput(applyPatchCallOutput)`.
         */
        fun addItem(applyPatchCallOutput: ResponseInputItem.ApplyPatchCallOutput) = apply {
            body.addItem(applyPatchCallOutput)
        }

        /** Alias for calling [addItem] with `ResponseInputItem.ofMcpListTools(mcpListTools)`. */
        fun addItem(mcpListTools: ResponseInputItem.McpListTools) = apply {
            body.addItem(mcpListTools)
        }

        /**
         * Alias for calling [addItem] with
         * `ResponseInputItem.ofMcpApprovalRequest(mcpApprovalRequest)`.
         */
        fun addItem(mcpApprovalRequest: ResponseInputItem.McpApprovalRequest) = apply {
            body.addItem(mcpApprovalRequest)
        }

        /**
         * Alias for calling [addItem] with
         * `ResponseInputItem.ofMcpApprovalResponse(mcpApprovalResponse)`.
         */
        fun addItem(mcpApprovalResponse: ResponseInputItem.McpApprovalResponse) = apply {
            body.addItem(mcpApprovalResponse)
        }

        /** Alias for calling [addItem] with `ResponseInputItem.ofMcpCall(mcpCall)`. */
        fun addItem(mcpCall: ResponseInputItem.McpCall) = apply { body.addItem(mcpCall) }

        /**
         * Alias for calling [addItem] with
         * `ResponseInputItem.ofCustomToolCallOutput(customToolCallOutput)`.
         */
        fun addItem(customToolCallOutput: ResponseCustomToolCallOutput) = apply {
            body.addItem(customToolCallOutput)
        }

        /**
         * Alias for calling [addItem] with `ResponseInputItem.ofCustomToolCall(customToolCall)`.
         */
        fun addItem(customToolCall: ResponseCustomToolCall) = apply { body.addItem(customToolCall) }

        /** Alias for calling [addItem] with `ResponseInputItem.ofItemReference(itemReference)`. */
        fun addItem(itemReference: ResponseInputItem.ItemReference) = apply {
            body.addItem(itemReference)
        }

        /**
         * Alias for calling [addItem] with the following:
         * ```java
         * ResponseInputItem.ItemReference.builder()
         *     .type(ResponseInputItem.ItemReference.Type.ITEM_REFERENCE)
         *     .id(id)
         *     .build()
         * ```
         */
        fun addItemReferenceItem(id: String) = apply { body.addItemReferenceItem(id) }

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
         * Returns an immutable instance of [ConversationCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ConversationCreateParams =
            ConversationCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val items: JsonField<List<ResponseInputItem>>,
        private val metadata: JsonField<Metadata>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("items")
            @ExcludeMissing
            items: JsonField<List<ResponseInputItem>> = JsonMissing.of(),
            @JsonProperty("metadata")
            @ExcludeMissing
            metadata: JsonField<Metadata> = JsonMissing.of(),
        ) : this(items, metadata, mutableMapOf())

        /**
         * Initial items to include in the conversation context. You may add up to 20 items at a
         * time.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun items(): Optional<List<ResponseInputItem>> = items.getOptional("items")

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
        fun metadata(): Optional<Metadata> = metadata.getOptional("metadata")

        /**
         * Returns the raw JSON value of [items].
         *
         * Unlike [items], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("items")
        @ExcludeMissing
        fun _items(): JsonField<List<ResponseInputItem>> = items

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

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var items: JsonField<MutableList<ResponseInputItem>>? = null
            private var metadata: JsonField<Metadata> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                items = body.items.map { it.toMutableList() }
                metadata = body.metadata
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * Initial items to include in the conversation context. You may add up to 20 items at a
             * time.
             */
            fun items(items: List<ResponseInputItem>?) = items(JsonField.ofNullable(items))

            /** Alias for calling [Builder.items] with `items.orElse(null)`. */
            fun items(items: Optional<List<ResponseInputItem>>) = items(items.getOrNull())

            /**
             * Sets [Builder.items] to an arbitrary JSON value.
             *
             * You should usually call [Builder.items] with a well-typed `List<ResponseInputItem>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun items(items: JsonField<List<ResponseInputItem>>) = apply {
                this.items = items.map { it.toMutableList() }
            }

            /**
             * Adds a single [ResponseInputItem] to [items].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addItem(item: ResponseInputItem) = apply {
                items =
                    (items ?: JsonField.of(mutableListOf())).also {
                        checkKnown("items", it).add(item)
                    }
            }

            /**
             * Alias for calling [addItem] with
             * `ResponseInputItem.ofEasyInputMessage(easyInputMessage)`.
             */
            fun addItem(easyInputMessage: EasyInputMessage) =
                addItem(ResponseInputItem.ofEasyInputMessage(easyInputMessage))

            /** Alias for calling [addItem] with `ResponseInputItem.ofMessage(message)`. */
            fun addItem(message: ResponseInputItem.Message) =
                addItem(ResponseInputItem.ofMessage(message))

            /**
             * Alias for calling [addItem] with
             * `ResponseInputItem.ofResponseOutputMessage(responseOutputMessage)`.
             */
            fun addItem(responseOutputMessage: ResponseOutputMessage) =
                addItem(ResponseInputItem.ofResponseOutputMessage(responseOutputMessage))

            /**
             * Alias for calling [addItem] with
             * `ResponseInputItem.ofFileSearchCall(fileSearchCall)`.
             */
            fun addItem(fileSearchCall: ResponseFileSearchToolCall) =
                addItem(ResponseInputItem.ofFileSearchCall(fileSearchCall))

            /**
             * Alias for calling [addItem] with `ResponseInputItem.ofComputerCall(computerCall)`.
             */
            fun addItem(computerCall: ResponseComputerToolCall) =
                addItem(ResponseInputItem.ofComputerCall(computerCall))

            /**
             * Alias for calling [addItem] with
             * `ResponseInputItem.ofComputerCallOutput(computerCallOutput)`.
             */
            fun addItem(computerCallOutput: ResponseInputItem.ComputerCallOutput) =
                addItem(ResponseInputItem.ofComputerCallOutput(computerCallOutput))

            /**
             * Alias for calling [addItem] with `ResponseInputItem.ofWebSearchCall(webSearchCall)`.
             */
            fun addItem(webSearchCall: ResponseFunctionWebSearch) =
                addItem(ResponseInputItem.ofWebSearchCall(webSearchCall))

            /**
             * Alias for calling [addItem] with `ResponseInputItem.ofFunctionCall(functionCall)`.
             */
            fun addItem(functionCall: ResponseFunctionToolCall) =
                addItem(ResponseInputItem.ofFunctionCall(functionCall))

            /**
             * Alias for calling [addItem] with
             * `ResponseInputItem.ofFunctionCallOutput(functionCallOutput)`.
             */
            fun addItem(functionCallOutput: ResponseInputItem.FunctionCallOutput) =
                addItem(ResponseInputItem.ofFunctionCallOutput(functionCallOutput))

            /** Alias for calling [addItem] with `ResponseInputItem.ofReasoning(reasoning)`. */
            fun addItem(reasoning: ResponseReasoningItem) =
                addItem(ResponseInputItem.ofReasoning(reasoning))

            /**
             * Alias for calling [addItem] with
             * `ResponseInputItem.ofImageGenerationCall(imageGenerationCall)`.
             */
            fun addItem(imageGenerationCall: ResponseInputItem.ImageGenerationCall) =
                addItem(ResponseInputItem.ofImageGenerationCall(imageGenerationCall))

            /**
             * Alias for calling [addItem] with
             * `ResponseInputItem.ofCodeInterpreterCall(codeInterpreterCall)`.
             */
            fun addItem(codeInterpreterCall: ResponseCodeInterpreterToolCall) =
                addItem(ResponseInputItem.ofCodeInterpreterCall(codeInterpreterCall))

            /**
             * Alias for calling [addItem] with
             * `ResponseInputItem.ofLocalShellCall(localShellCall)`.
             */
            fun addItem(localShellCall: ResponseInputItem.LocalShellCall) =
                addItem(ResponseInputItem.ofLocalShellCall(localShellCall))

            /**
             * Alias for calling [addItem] with
             * `ResponseInputItem.ofLocalShellCallOutput(localShellCallOutput)`.
             */
            fun addItem(localShellCallOutput: ResponseInputItem.LocalShellCallOutput) =
                addItem(ResponseInputItem.ofLocalShellCallOutput(localShellCallOutput))

            /** Alias for calling [addItem] with `ResponseInputItem.ofShellCall(shellCall)`. */
            fun addItem(shellCall: ResponseInputItem.ShellCall) =
                addItem(ResponseInputItem.ofShellCall(shellCall))

            /**
             * Alias for calling [addItem] with
             * `ResponseInputItem.ofShellCallOutput(shellCallOutput)`.
             */
            fun addItem(shellCallOutput: ResponseInputItem.ShellCallOutput) =
                addItem(ResponseInputItem.ofShellCallOutput(shellCallOutput))

            /**
             * Alias for calling [addItem] with
             * `ResponseInputItem.ofApplyPatchCall(applyPatchCall)`.
             */
            fun addItem(applyPatchCall: ResponseInputItem.ApplyPatchCall) =
                addItem(ResponseInputItem.ofApplyPatchCall(applyPatchCall))

            /**
             * Alias for calling [addItem] with
             * `ResponseInputItem.ofApplyPatchCallOutput(applyPatchCallOutput)`.
             */
            fun addItem(applyPatchCallOutput: ResponseInputItem.ApplyPatchCallOutput) =
                addItem(ResponseInputItem.ofApplyPatchCallOutput(applyPatchCallOutput))

            /**
             * Alias for calling [addItem] with `ResponseInputItem.ofMcpListTools(mcpListTools)`.
             */
            fun addItem(mcpListTools: ResponseInputItem.McpListTools) =
                addItem(ResponseInputItem.ofMcpListTools(mcpListTools))

            /**
             * Alias for calling [addItem] with
             * `ResponseInputItem.ofMcpApprovalRequest(mcpApprovalRequest)`.
             */
            fun addItem(mcpApprovalRequest: ResponseInputItem.McpApprovalRequest) =
                addItem(ResponseInputItem.ofMcpApprovalRequest(mcpApprovalRequest))

            /**
             * Alias for calling [addItem] with
             * `ResponseInputItem.ofMcpApprovalResponse(mcpApprovalResponse)`.
             */
            fun addItem(mcpApprovalResponse: ResponseInputItem.McpApprovalResponse) =
                addItem(ResponseInputItem.ofMcpApprovalResponse(mcpApprovalResponse))

            /** Alias for calling [addItem] with `ResponseInputItem.ofMcpCall(mcpCall)`. */
            fun addItem(mcpCall: ResponseInputItem.McpCall) =
                addItem(ResponseInputItem.ofMcpCall(mcpCall))

            /**
             * Alias for calling [addItem] with
             * `ResponseInputItem.ofCustomToolCallOutput(customToolCallOutput)`.
             */
            fun addItem(customToolCallOutput: ResponseCustomToolCallOutput) =
                addItem(ResponseInputItem.ofCustomToolCallOutput(customToolCallOutput))

            /**
             * Alias for calling [addItem] with
             * `ResponseInputItem.ofCustomToolCall(customToolCall)`.
             */
            fun addItem(customToolCall: ResponseCustomToolCall) =
                addItem(ResponseInputItem.ofCustomToolCall(customToolCall))

            /**
             * Alias for calling [addItem] with `ResponseInputItem.ofItemReference(itemReference)`.
             */
            fun addItem(itemReference: ResponseInputItem.ItemReference) =
                addItem(ResponseInputItem.ofItemReference(itemReference))

            /**
             * Alias for calling [addItem] with the following:
             * ```java
             * ResponseInputItem.ItemReference.builder()
             *     .type(ResponseInputItem.ItemReference.Type.ITEM_REFERENCE)
             *     .id(id)
             *     .build()
             * ```
             */
            fun addItemReferenceItem(id: String) =
                addItem(
                    ResponseInputItem.ItemReference.builder()
                        .type(ResponseInputItem.ItemReference.Type.ITEM_REFERENCE)
                        .id(id)
                        .build()
                )

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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Body =
                Body(
                    (items ?: JsonMissing.of()).map { it.toImmutable() },
                    metadata,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            items().ifPresent { it.forEach { it.validate() } }
            metadata().ifPresent { it.validate() }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (items.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (metadata.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                items == other.items &&
                metadata == other.metadata &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(items, metadata, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{items=$items, metadata=$metadata, additionalProperties=$additionalProperties}"
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

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Metadata && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Metadata{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ConversationCreateParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ConversationCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
