// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.EvalServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see [EvalServiceAsync.list] */
class EvalListPageAsync
private constructor(
    private val service: EvalServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: EvalListParams,
    private val response: EvalListPageResponse,
) : PageAsync<EvalListResponse> {

    /**
     * Delegates to [EvalListPageResponse], but gracefully handles missing data.
     *
     * @see [EvalListPageResponse.data]
     */
    fun data(): List<EvalListResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [EvalListPageResponse], but gracefully handles missing data.
     *
     * @see [EvalListPageResponse.hasMore]
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<EvalListResponse> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): EvalListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): CompletableFuture<EvalListPageAsync> = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<EvalListResponse> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): EvalListParams = params

    /** The response that this page was parsed from. */
    fun response(): EvalListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [EvalListPageAsync].
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

    /** A builder for [EvalListPageAsync]. */
    class Builder internal constructor() {

        private var service: EvalServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: EvalListParams? = null
        private var response: EvalListPageResponse? = null

        @JvmSynthetic
        internal fun from(evalListPageAsync: EvalListPageAsync) = apply {
            service = evalListPageAsync.service
            streamHandlerExecutor = evalListPageAsync.streamHandlerExecutor
            params = evalListPageAsync.params
            response = evalListPageAsync.response
        }

        fun service(service: EvalServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: EvalListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: EvalListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [EvalListPageAsync].
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
        fun build(): EvalListPageAsync =
            EvalListPageAsync(
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

        return /* spotless:off */ other is EvalListPageAsync && service == other.service && streamHandlerExecutor == other.streamHandlerExecutor && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, streamHandlerExecutor, params, response) /* spotless:on */

    override fun toString() =
        "EvalListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
