// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.beta.threads.RunServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see RunServiceAsync.list */
@Deprecated("The Assistants API is deprecated in favor of the Responses API")
class RunListPageAsync
private constructor(
    private val service: RunServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: RunListParams,
    private val response: RunListPageResponse,
) : PageAsync<Run> {

    /**
     * Delegates to [RunListPageResponse], but gracefully handles missing data.
     *
     * @see RunListPageResponse.data
     */
    fun data(): List<Run> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [RunListPageResponse], but gracefully handles missing data.
     *
     * @see RunListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<Run> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): RunListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): CompletableFuture<RunListPageAsync> = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Run> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): RunListParams = params

    /** The response that this page was parsed from. */
    fun response(): RunListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [RunListPageAsync].
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

    /** A builder for [RunListPageAsync]. */
    class Builder internal constructor() {

        private var service: RunServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: RunListParams? = null
        private var response: RunListPageResponse? = null

        @JvmSynthetic
        internal fun from(runListPageAsync: RunListPageAsync) = apply {
            service = runListPageAsync.service
            streamHandlerExecutor = runListPageAsync.streamHandlerExecutor
            params = runListPageAsync.params
            response = runListPageAsync.response
        }

        fun service(service: RunServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: RunListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: RunListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [RunListPageAsync].
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
        fun build(): RunListPageAsync =
            RunListPageAsync(
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

        return other is RunListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "RunListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
