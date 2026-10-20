// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.sessions.traces

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.beta.agents.sessions.TraceServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see TraceServiceAsync.list */
class TraceListPageAsync
private constructor(
    private val service: TraceServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: TraceListParams,
    private val response: TraceListPageResponse,
) : PageAsync<SessionTrace> {

    /**
     * Delegates to [TraceListPageResponse], but gracefully handles missing data.
     *
     * @see TraceListPageResponse.data
     */
    fun data(): List<SessionTrace> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [TraceListPageResponse], but gracefully handles missing data.
     *
     * @see TraceListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<SessionTrace> = data()

    override fun hasNextPage(): Boolean = hasMore().orElse(true) && items().isNotEmpty()

    fun nextPageParams(): TraceListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): CompletableFuture<TraceListPageAsync> = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<SessionTrace> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): TraceListParams = params

    /** The response that this page was parsed from. */
    fun response(): TraceListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [TraceListPageAsync].
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

    /** A builder for [TraceListPageAsync]. */
    class Builder internal constructor() {

        private var service: TraceServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: TraceListParams? = null
        private var response: TraceListPageResponse? = null

        @JvmSynthetic
        internal fun from(traceListPageAsync: TraceListPageAsync) = apply {
            service = traceListPageAsync.service
            streamHandlerExecutor = traceListPageAsync.streamHandlerExecutor
            params = traceListPageAsync.params
            response = traceListPageAsync.response
        }

        fun service(service: TraceServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: TraceListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: TraceListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [TraceListPageAsync].
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
        fun build(): TraceListPageAsync =
            TraceListPageAsync(
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

        return other is TraceListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "TraceListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
