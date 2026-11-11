// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.sessions.turns.items

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.models.beta.agents.AgentSessionItem
import com.openai.services.async.beta.agents.sessions.turns.ItemServiceAsync
import java.util.Objects
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see ItemServiceAsync.list */
class ItemListPageAsync
private constructor(
    private val service: ItemServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: ItemListParams,
    private val response: ItemListPageResponse,
) : PageAsync<AgentSessionItem> {

    /** @see ItemListPageResponse.data */
    fun data() = response.data()

    fun dataOrThrow(): List<AgentSessionItem> =
        data().orElseGet { response._data().getRequired("data") }

    fun _data() = response._data()

    /** @see ItemListPageResponse.hasMore */
    fun hasMore() = response.hasMore()

    fun hasMoreOrThrow(): Boolean =
        hasMore().orElseGet { response._hasMore().getRequired("has_more") }

    fun _hasMore() = response._hasMore()

    /** @see ItemListPageResponse.lastId */
    fun lastId() = response.lastId()

    fun lastIdOrThrow(): String = lastId().orElseGet { response._lastId().getRequired("last_id") }

    fun _lastId() = response._lastId()

    override fun items(): List<AgentSessionItem> = data().orElseGet { emptyList() }

    override fun hasNextPage(): Boolean =
        hasMore().orElse(true) && items().isNotEmpty() && lastId().isPresent

    fun nextPageParams(): ItemListParams {
        val nextCursor =
            lastId().getOrNull() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<ItemListPageAsync> = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<AgentSessionItem> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): ItemListParams = params

    /** The response that this page was parsed from. */
    fun response(): ItemListPageResponse = response

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
        private var response: ItemListPageResponse? = null

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
        fun response(response: ItemListPageResponse) = apply { this.response = response }

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
