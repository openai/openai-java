// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.jobs

import com.openai.core.checkRequired
import com.openai.services.async.finetuning.JobServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** @see [JobServiceAsync.listEvents] */
class JobListEventsPageAsync
private constructor(
    private val service: JobServiceAsync,
    private val params: JobListEventsParams,
    private val response: JobListEventsPageResponse,
) {

    /**
     * Delegates to [JobListEventsPageResponse], but gracefully handles missing data.
     *
     * @see [JobListEventsPageResponse.data]
     */
    fun data(): List<FineTuningJobEvent> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [JobListEventsPageResponse], but gracefully handles missing data.
     *
     * @see [JobListEventsPageResponse.hasMore]
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<JobListEventsParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): CompletableFuture<Optional<JobListEventsPageAsync>> =
        getNextPageParams()
            .map { service.listEvents(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }

    fun autoPager(): AutoPager = AutoPager(this)

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
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [JobListEventsPageAsync]. */
    class Builder internal constructor() {

        private var service: JobServiceAsync? = null
        private var params: JobListEventsParams? = null
        private var response: JobListEventsPageResponse? = null

        @JvmSynthetic
        internal fun from(jobListEventsPageAsync: JobListEventsPageAsync) = apply {
            service = jobListEventsPageAsync.service
            params = jobListEventsPageAsync.params
            response = jobListEventsPageAsync.response
        }

        fun service(service: JobServiceAsync) = apply { this.service = service }

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
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): JobListEventsPageAsync =
            JobListEventsPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: JobListEventsPageAsync) {

        fun forEach(
            action: Predicate<FineTuningJobEvent>,
            executor: Executor,
        ): CompletableFuture<Void> {
            fun CompletableFuture<Optional<JobListEventsPageAsync>>.forEach(
                action: (FineTuningJobEvent) -> Boolean,
                executor: Executor,
            ): CompletableFuture<Void> =
                thenComposeAsync(
                    { page ->
                        page
                            .filter { it.data().all(action) }
                            .map { it.getNextPage().forEach(action, executor) }
                            .orElseGet { CompletableFuture.completedFuture(null) }
                    },
                    executor,
                )
            return CompletableFuture.completedFuture(Optional.of(firstPage))
                .forEach(action::test, executor)
        }

        fun toList(executor: Executor): CompletableFuture<List<FineTuningJobEvent>> {
            val values = mutableListOf<FineTuningJobEvent>()
            return forEach(values::add, executor).thenApply { values }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is JobListEventsPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "JobListEventsPageAsync{service=$service, params=$params, response=$response}"
}
