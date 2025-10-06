// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit.threads

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.beta.chatkit.ThreadServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see ThreadServiceAsync.listItems */
class ThreadListItemsPageAsync
private constructor(
    private val service: ThreadServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: ThreadListItemsParams,
    private val response: ChatKitThreadItemList,
) : PageAsync<ChatKitThreadItemList.Data> {

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

    override fun nextPage(): CompletableFuture<ThreadListItemsPageAsync> =
        service.listItems(nextPageParams())

    fun autoPager(): AutoPagerAsync<ChatKitThreadItemList.Data> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): ThreadListItemsParams = params

    /** The response that this page was parsed from. */
    fun response(): ChatKitThreadItemList = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ThreadListItemsPageAsync].
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

    /** A builder for [ThreadListItemsPageAsync]. */
    class Builder internal constructor() {

        private var service: ThreadServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: ThreadListItemsParams? = null
        private var response: ChatKitThreadItemList? = null

        @JvmSynthetic
        internal fun from(threadListItemsPageAsync: ThreadListItemsPageAsync) = apply {
            service = threadListItemsPageAsync.service
            streamHandlerExecutor = threadListItemsPageAsync.streamHandlerExecutor
            params = threadListItemsPageAsync.params
            response = threadListItemsPageAsync.response
        }

        fun service(service: ThreadServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: ThreadListItemsParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ChatKitThreadItemList) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ThreadListItemsPageAsync].
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
        fun build(): ThreadListItemsPageAsync =
            ThreadListItemsPageAsync(
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

        return other is ThreadListItemsPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "ThreadListItemsPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
