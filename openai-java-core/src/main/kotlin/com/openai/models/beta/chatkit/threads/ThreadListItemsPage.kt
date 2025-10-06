// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit.threads

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.beta.chatkit.ThreadService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see ThreadService.listItems */
class ThreadListItemsPage
private constructor(
    private val service: ThreadService,
    private val params: ThreadListItemsParams,
    private val response: ChatKitThreadItemList,
) : Page<ChatKitThreadItemList.Data> {

    /**
     * Delegates to [ChatKitThreadItemList], but gracefully handles missing data.
     *
     * @see ChatKitThreadItemList.data
     */
    fun data(): List<ChatKitThreadItemList.Data> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [ChatKitThreadItemList], but gracefully handles missing data.
     *
     * @see ChatKitThreadItemList.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    /**
     * Delegates to [ChatKitThreadItemList], but gracefully handles missing data.
     *
     * @see ChatKitThreadItemList.lastId
     */
    fun lastId(): Optional<String> = response._lastId().getOptional("last_id")

    override fun items(): List<ChatKitThreadItemList.Data> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && lastId().isPresent

    fun nextPageParams(): ThreadListItemsParams {
        val nextCursor =
            lastId().getOrNull() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): ThreadListItemsPage = service.listItems(nextPageParams())

    fun autoPager(): AutoPager<ChatKitThreadItemList.Data> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): ThreadListItemsParams = params

    /** The response that this page was parsed from. */
    fun response(): ChatKitThreadItemList = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ThreadListItemsPage].
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

    /** A builder for [ThreadListItemsPage]. */
    class Builder internal constructor() {

        private var service: ThreadService? = null
        private var params: ThreadListItemsParams? = null
        private var response: ChatKitThreadItemList? = null

        @JvmSynthetic
        internal fun from(threadListItemsPage: ThreadListItemsPage) = apply {
            service = threadListItemsPage.service
            params = threadListItemsPage.params
            response = threadListItemsPage.response
        }

        fun service(service: ThreadService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ThreadListItemsParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ChatKitThreadItemList) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ThreadListItemsPage].
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
        fun build(): ThreadListItemsPage =
            ThreadListItemsPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ThreadListItemsPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "ThreadListItemsPage{service=$service, params=$params, response=$response}"
}
