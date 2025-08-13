// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals.runs.outputitems

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.evals.runs.OutputItemServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see OutputItemServiceAsync.list */
class OutputItemListPageAsync
private constructor(
    private val service: OutputItemServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: OutputItemListParams,
    private val response: OutputItemListPageResponse,
) : PageAsync<OutputItemListResponse> {

    /**
     * Delegates to [OutputItemListPageResponse], but gracefully handles missing data.
     *
     * @see OutputItemListPageResponse.data
     */
    fun data(): List<OutputItemListResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [OutputItemListPageResponse], but gracefully handles missing data.
     *
     * @see OutputItemListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<OutputItemListResponse> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): OutputItemListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): CompletableFuture<OutputItemListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<OutputItemListResponse> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): OutputItemListParams = params

    /** The response that this page was parsed from. */
    fun response(): OutputItemListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [OutputItemListPageAsync].
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

    /** A builder for [OutputItemListPageAsync]. */
    class Builder internal constructor() {

        private var service: OutputItemServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: OutputItemListParams? = null
        private var response: OutputItemListPageResponse? = null

        @JvmSynthetic
        internal fun from(outputItemListPageAsync: OutputItemListPageAsync) = apply {
            service = outputItemListPageAsync.service
            streamHandlerExecutor = outputItemListPageAsync.streamHandlerExecutor
            params = outputItemListPageAsync.params
            response = outputItemListPageAsync.response
        }

        fun service(service: OutputItemServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: OutputItemListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: OutputItemListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [OutputItemListPageAsync].
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
        fun build(): OutputItemListPageAsync =
            OutputItemListPageAsync(
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

        return other is OutputItemListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "OutputItemListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
