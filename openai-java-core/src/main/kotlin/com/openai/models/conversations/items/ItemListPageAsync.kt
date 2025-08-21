// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations.items

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.conversations.ItemServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see ItemServiceAsync.list */
class ItemListPageAsync
private constructor(
    private val service: ItemServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: ItemListParams,
    private val response: ConversationItemList,
) : PageAsync<ConversationItem> {

    /**
     * Delegates to [ConversationItemList], but gracefully handles missing data.
     *
     * @see ConversationItemList.data
     */
    fun data(): List<ConversationItem> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [ConversationItemList], but gracefully handles missing data.
     *
     * @see ConversationItemList.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    /**
     * Delegates to [ConversationItemList], but gracefully handles missing data.
     *
     * @see ConversationItemList.lastId
     */
    fun lastId(): Optional<String> = response._lastId().getOptional("last_id")

    override fun items(): List<ConversationItem> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && lastId().isPresent

    fun nextPageParams(): ItemListParams {
        val nextCursor =
            lastId().getOrNull() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<ItemListPageAsync> = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<ConversationItem> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): ItemListParams = params

    /** The response that this page was parsed from. */
    fun response(): ConversationItemList = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ItemListPageAsync].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ItemListPageAsync]. */
    class Builder internal constructor() {

        private var service: ItemServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: ItemListParams? = null
        private var response: ConversationItemList? = null

        @JvmSynthetic
        internal fun from(itemListPageAsync: ItemListPageAsync) = apply {
            service = itemListPageAsync.service
            streamHandlerExecutor = itemListPageAsync.streamHandlerExecutor
            params = itemListPageAsync.params
            response = itemListPageAsync.response
        }

        fun service(service: ItemServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: ItemListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ConversationItemList) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ItemListPageAsync].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ItemListPageAsync =
            ItemListPageAsync(
                checkRequired("service", service),
                checkRequired("streamHandlerExecutor", streamHandlerExecutor),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ItemListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "ItemListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
