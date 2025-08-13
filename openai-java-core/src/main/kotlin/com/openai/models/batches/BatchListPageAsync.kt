// File generated from our OpenAPI spec by Stainless.

package com.openai.models.batches

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.BatchServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see BatchServiceAsync.list */
class BatchListPageAsync
private constructor(
    private val service: BatchServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: BatchListParams,
    private val response: BatchListPageResponse,
) : PageAsync<Batch> {

    /**
     * Delegates to [BatchListPageResponse], but gracefully handles missing data.
     *
     * @see BatchListPageResponse.data
     */
    fun data(): List<Batch> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [BatchListPageResponse], but gracefully handles missing data.
     *
     * @see BatchListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<Batch> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): BatchListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): CompletableFuture<BatchListPageAsync> = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Batch> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): BatchListParams = params

    /** The response that this page was parsed from. */
    fun response(): BatchListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [BatchListPageAsync].
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

    /** A builder for [BatchListPageAsync]. */
    class Builder internal constructor() {

        private var service: BatchServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: BatchListParams? = null
        private var response: BatchListPageResponse? = null

        @JvmSynthetic
        internal fun from(batchListPageAsync: BatchListPageAsync) = apply {
            service = batchListPageAsync.service
            streamHandlerExecutor = batchListPageAsync.streamHandlerExecutor
            params = batchListPageAsync.params
            response = batchListPageAsync.response
        }

        fun service(service: BatchServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: BatchListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: BatchListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [BatchListPageAsync].
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
        fun build(): BatchListPageAsync =
            BatchListPageAsync(
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

        return other is BatchListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "BatchListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
