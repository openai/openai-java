// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.beta.threads.runs.StepServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see [StepServiceAsync.list] */
class StepListPageAsync
private constructor(
    private val service: StepServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: StepListParams,
    private val response: StepListPageResponse,
) : PageAsync<RunStep> {

    /**
     * Delegates to [StepListPageResponse], but gracefully handles missing data.
     *
     * @see [StepListPageResponse.data]
     */
    fun data(): List<RunStep> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [StepListPageResponse], but gracefully handles missing data.
     *
     * @see [StepListPageResponse.hasMore]
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<RunStep> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): StepListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): CompletableFuture<StepListPageAsync> = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<RunStep> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): StepListParams = params

    /** The response that this page was parsed from. */
    fun response(): StepListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [StepListPageAsync].
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

    /** A builder for [StepListPageAsync]. */
    class Builder internal constructor() {

        private var service: StepServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: StepListParams? = null
        private var response: StepListPageResponse? = null

        @JvmSynthetic
        internal fun from(stepListPageAsync: StepListPageAsync) = apply {
            service = stepListPageAsync.service
            streamHandlerExecutor = stepListPageAsync.streamHandlerExecutor
            params = stepListPageAsync.params
            response = stepListPageAsync.response
        }

        fun service(service: StepServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: StepListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: StepListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [StepListPageAsync].
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
        fun build(): StepListPageAsync =
            StepListPageAsync(
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

        return /* spotless:off */ other is StepListPageAsync && service == other.service && streamHandlerExecutor == other.streamHandlerExecutor && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, streamHandlerExecutor, params, response) /* spotless:on */

    override fun toString() =
        "StepListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
