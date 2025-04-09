// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.jobs

import com.openai.services.async.finetuning.JobServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** List your organization's fine-tuning jobs */
class JobListPageAsync
private constructor(
    private val jobsService: JobServiceAsync,
    private val params: JobListParams,
    private val response: JobListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): JobListPageResponse = response

    /**
     * Delegates to [JobListPageResponse], but gracefully handles missing data.
     *
     * @see [JobListPageResponse.data]
     */
    fun data(): List<FineTuningJob> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [JobListPageResponse], but gracefully handles missing data.
     *
     * @see [JobListPageResponse.hasMore]
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is JobListPageAsync && jobsService == other.jobsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(jobsService, params, response) /* spotless:on */

    override fun toString() =
        "JobListPageAsync{jobsService=$jobsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<JobListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): CompletableFuture<Optional<JobListPageAsync>> {
        return getNextPageParams()
            .map { jobsService.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(jobsService: JobServiceAsync, params: JobListParams, response: JobListPageResponse) =
            JobListPageAsync(jobsService, params, response)
    }

    class AutoPager(private val firstPage: JobListPageAsync) {

        fun forEach(action: Predicate<FineTuningJob>, executor: Executor): CompletableFuture<Void> {
            fun CompletableFuture<Optional<JobListPageAsync>>.forEach(
                action: (FineTuningJob) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<FineTuningJob>> {
            val values = mutableListOf<FineTuningJob>()
            return forEach(values::add, executor).thenApply { values }
        }
    }
}
