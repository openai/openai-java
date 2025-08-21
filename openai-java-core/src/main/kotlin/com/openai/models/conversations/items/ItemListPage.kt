// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations.items

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.conversations.ItemService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see ItemService.list */
class ItemListPage
private constructor(
    private val service: ItemService,
    private val params: ItemListParams,
    private val response: ConversationItemList,
) : Page<ConversationItem> {

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

    override fun nextPage(): ItemListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<ConversationItem> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): ItemListParams = params

    /** The response that this page was parsed from. */
    fun response(): ConversationItemList = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ItemListPage].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ItemListPage]. */
    class Builder internal constructor() {

        private var service: ItemService? = null
        private var params: ItemListParams? = null
        private var response: ConversationItemList? = null

        @JvmSynthetic
        internal fun from(itemListPage: ItemListPage) = apply {
            service = itemListPage.service
            params = itemListPage.params
            response = itemListPage.response
        }

        fun service(service: ItemService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ItemListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ConversationItemList) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ItemListPage].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ItemListPage =
            ItemListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ItemListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() = "ItemListPage{service=$service, params=$params, response=$response}"
}
