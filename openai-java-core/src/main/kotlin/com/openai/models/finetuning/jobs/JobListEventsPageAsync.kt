// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.finetuning.jobs

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.finetuning.JobServiceAsync
import java.util.Objects
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor

/** @see JobServiceAsync.listEvents */
class JobListEventsPageAsync
private constructor(
    private val service: JobServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: JobListEventsParams,
    private val response: JobListEventsPageResponse,
) : PageAsync<FineTuningJobEvent> {

    /** @see JobListEventsPageResponse.data */
    fun data() = response.data()

    fun dataOrThrow(): List<FineTuningJobEvent> =
        data().orElseGet { response._data().getRequired("data") }

    fun _data() = response._data()

    /** @see JobListEventsPageResponse.hasMore */
    fun hasMore() = response.hasMore()

    fun hasMoreOrThrow(): Boolean =
        hasMore().orElseGet { response._hasMore().getRequired("has_more") }

    fun _hasMore() = response._hasMore()

    override fun items(): List<FineTuningJobEvent> = data().orElseGet { emptyList() }

    override fun hasNextPage(): Boolean = hasMore().orElse(true) && items().isNotEmpty()

    fun nextPageParams(): JobListEventsParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): CompletableFuture<JobListEventsPageAsync> =
        service.listEvents(nextPageParams())

    fun autoPager(): AutoPagerAsync<FineTuningJobEvent> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): JobListEventsParams = params

    /** The response that this page was parsed from. */
    fun response(): JobListEventsPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [JobListEventsPageAsync].
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

    /** A builder for [JobListEventsPageAsync]. */
    class Builder internal constructor() {

        private var service: JobServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: JobListEventsParams? = null
        private var response: JobListEventsPageResponse? = null

        @JvmSynthetic
        internal fun from(jobListEventsPageAsync: JobListEventsPageAsync) = apply {
            service = jobListEventsPageAsync.service
            streamHandlerExecutor = jobListEventsPageAsync.streamHandlerExecutor
            params = jobListEventsPageAsync.params
            response = jobListEventsPageAsync.response
        }

        fun service(service: JobServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: JobListEventsParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: JobListEventsPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [JobListEventsPageAsync].
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
        fun build(): JobListEventsPageAsync =
            JobListEventsPageAsync(
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

        return other is JobListEventsPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "JobListEventsPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
