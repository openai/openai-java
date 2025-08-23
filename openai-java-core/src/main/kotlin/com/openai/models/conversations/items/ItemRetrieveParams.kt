// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations.items

import com.openai.core.Params
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.models.responses.ResponseIncludable
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Get a single item from a conversation with the given IDs. */
class ItemRetrieveParams
private constructor(
    private val conversationId: String,
    private val itemId: String?,
    private val include: List<ResponseIncludable>?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun conversationId(): String = conversationId

    fun itemId(): Optional<String> = Optional.ofNullable(itemId)

    /**
     * Additional fields to include in the response. See the `include` parameter for
     * [listing Conversation items above](https://platform.openai.com/docs/api-reference/conversations/list-items#conversations_list_items-include)
     * for more information.
     */
    fun include(): Optional<List<ResponseIncludable>> = Optional.ofNullable(include)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ItemRetrieveParams].
         *
         * The following fields are required:
         * ```java
         * .conversationId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ItemRetrieveParams]. */
    class Builder internal constructor() {

        private var conversationId: String? = null
        private var itemId: String? = null
        private var include: MutableList<ResponseIncludable>? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(itemRetrieveParams: ItemRetrieveParams) = apply {
            conversationId = itemRetrieveParams.conversationId
            itemId = itemRetrieveParams.itemId
            include = itemRetrieveParams.include?.toMutableList()
            additionalHeaders = itemRetrieveParams.additionalHeaders.toBuilder()
            additionalQueryParams = itemRetrieveParams.additionalQueryParams.toBuilder()
        }

        fun conversationId(conversationId: String) = apply { this.conversationId = conversationId }

        fun itemId(itemId: String?) = apply { this.itemId = itemId }

        /** Alias for calling [Builder.itemId] with `itemId.orElse(null)`. */
        fun itemId(itemId: Optional<String>) = itemId(itemId.getOrNull())

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
         * Returns an immutable instance of [ItemRetrieveParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .conversationId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ItemRetrieveParams =
            ItemRetrieveParams(
                checkRequired("conversationId", conversationId),
                itemId,
                include?.toImmutable(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> conversationId
            1 -> itemId ?: ""
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ItemRetrieveParams &&
            conversationId == other.conversationId &&
            itemId == other.itemId &&
            include == other.include &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(conversationId, itemId, include, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ItemRetrieveParams{conversationId=$conversationId, itemId=$itemId, include=$include, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
