// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations.items

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
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.responses.EasyInputMessage
import com.openai.models.responses.ResponseCodeInterpreterToolCall
import com.openai.models.responses.ResponseCompactionItemParam
import com.openai.models.responses.ResponseComputerToolCall
import com.openai.models.responses.ResponseCustomToolCall
import com.openai.models.responses.ResponseCustomToolCallOutput
import com.openai.models.responses.ResponseFileSearchToolCall
import com.openai.models.responses.ResponseFunctionToolCall
import com.openai.models.responses.ResponseFunctionWebSearch
import com.openai.models.responses.ResponseIncludable
import com.openai.models.responses.ResponseInputItem
import com.openai.models.responses.ResponseOutputMessage
import com.openai.models.responses.ResponseReasoningItem
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Create items in a conversation with the given ID. */
class ItemCreateParams
private constructor(
    private val conversationId: String?,
    private val include: List<ResponseIncludable>?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun conversationId(): Optional<String> = Optional.ofNullable(conversationId)

    /**
     * Additional fields to include in the response. See the `include` parameter for
     * [listing Conversation items above](https://platform.openai.com/docs/api-reference/conversations/list-items#conversations_list_items-include)
     * for more information.
     */
    fun include(): Optional<List<ResponseIncludable>> = Optional.ofNullable(include)

    /**
     * The items to add to the conversation. You may add up to 20 items at a time.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun items(): List<ResponseInputItem> = body.items()

    /**
     * Returns the raw JSON value of [items].
     *
     * Unlike [items], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _items(): JsonField<List<ResponseInputItem>> = body._items()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ItemCreateParams].
         *
         * The following fields are required:
         * ```java
         * .items()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ItemCreateParams]. */
    class Builder internal constructor() {

        private var conversationId: String? = null
        private var include: MutableList<ResponseIncludable>? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(itemCreateParams: ItemCreateParams) = apply {
            conversationId = itemCreateParams.conversationId
            include = itemCreateParams.include?.toMutableList()
            body = itemCreateParams.body.toBuilder()
            additionalHeaders = itemCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = itemCreateParams.additionalQueryParams.toBuilder()
        }

        fun conversationId(conversationId: String?) = apply { this.conversationId = conversationId }

        /** Alias for calling [Builder.conversationId] with `conversationId.orElse(null)`. */
        fun conversationId(conversationId: Optional<String>) =
            conversationId(conversationId.getOrNull())

        /**
         * Additional fields to include in the response. See the `include` parameter for
         * [listing Conversation items above](https://platform.openai.com/docs/api-reference/conversations/list-items#conversations_list_items-include)
         * for more information.
         */
        fun include(include: List<ResponseIncludable>?) = apply {
            this.include = include?.toMutableList()
        }

        /** Alias for calling [Builder.include] with `include.orElse(null)`. */
        fun include(include: Optional<List<ResponseIncludable>>) = include(include.getOrNull())

        /**
         * Adds a single [ResponseIncludable] to [Builder.include].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addInclude(include: ResponseIncludable) = apply {
            this.include = (this.include ?: mutableListOf()).apply { add(include) }
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [items]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** The items to add to the conversation. You may add up to 20 items at a time. */
        fun items(items: List<ResponseInputItem>) = apply { body.items(items) }

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

        /** Alias for calling [addItem] with `ResponseInputItem.ofCompaction(compaction)`. */
        fun addItem(compaction: ResponseCompactionItemParam) = apply { body.addItem(compaction) }

        /**
         * Alias for calling [addItem] with the following:
         * ```java
         * ResponseCompactionItemParam.builder()
         *     .encryptedContent(encryptedContent)
         *     .build()
         * ```
         */
        fun addCompactionItem(encryptedContent: String) = apply {
            body.addCompactionItem(encryptedContent)
        }

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
         * Returns an immutable instance of [ItemCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .items()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ItemCreateParams =
            ItemCreateParams(
                conversationId,
                include?.toImmutable(),
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> conversationId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                include?.forEach { put("include[]", it.toString()) }
                putAll(additionalQueryParams)
            }
            .build()

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val items: JsonField<List<ResponseInputItem>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("items")
            @ExcludeMissing
            items: JsonField<List<ResponseInputItem>> = JsonMissing.of()
        ) : this(items, mutableMapOf())

        /**
         * The items to add to the conversation. You may add up to 20 items at a time.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun items(): List<ResponseInputItem> = items.getRequired("items")

        /**
         * Returns the raw JSON value of [items].
         *
         * Unlike [items], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("items")
        @ExcludeMissing
        fun _items(): JsonField<List<ResponseInputItem>> = items

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
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .items()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var items: JsonField<MutableList<ResponseInputItem>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                items = body.items.map { it.toMutableList() }
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** The items to add to the conversation. You may add up to 20 items at a time. */
            fun items(items: List<ResponseInputItem>) = items(JsonField.of(items))

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

            /** Alias for calling [addItem] with `ResponseInputItem.ofCompaction(compaction)`. */
            fun addItem(compaction: ResponseCompactionItemParam) =
                addItem(ResponseInputItem.ofCompaction(compaction))

            /**
             * Alias for calling [addItem] with the following:
             * ```java
             * ResponseCompactionItemParam.builder()
             *     .encryptedContent(encryptedContent)
             *     .build()
             * ```
             */
            fun addCompactionItem(encryptedContent: String) =
                addItem(
                    ResponseCompactionItemParam.builder().encryptedContent(encryptedContent).build()
                )

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
             *
             * The following fields are required:
             * ```java
             * .items()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("items", items).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            items().forEach { it.validate() }
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
            (items.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                items == other.items &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(items, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Body{items=$items, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ItemCreateParams &&
            conversationId == other.conversationId &&
            include == other.include &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(conversationId, include, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ItemCreateParams{conversationId=$conversationId, include=$include, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
