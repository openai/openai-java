// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.jobs

import com.openai.services.async.finetuning.JobServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** Get status updates for a fine-tuning job. */
class JobListEventsPageAsync
private constructor(
    private val jobsService: JobServiceAsync,
    private val params: JobListEventsParams,
    private val response: JobListEventsPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): JobListEventsPageResponse = response

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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is JobListEventsPageAsync && jobsService == other.jobsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(jobsService, params, response) /* spotless:on */

    override fun toString() =
        "JobListEventsPageAsync{jobsService=$jobsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<JobListEventsParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): CompletableFuture<Optional<JobListEventsPageAsync>> {
        return getNextPageParams()
            .map { jobsService.listEvents(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            jobsService: JobServiceAsync,
            params: JobListEventsParams,
            response: JobListEventsPageResponse,
        ) = JobListEventsPageAsync(jobsService, params, response)
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
}
