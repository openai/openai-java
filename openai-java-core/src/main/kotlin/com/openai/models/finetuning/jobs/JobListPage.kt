// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.jobs

import com.openai.services.blocking.finetuning.JobService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** List your organization's fine-tuning jobs */
class JobListPage
private constructor(
    private val jobsService: JobService,
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

        return /* spotless:off */ other is JobListPage && jobsService == other.jobsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(jobsService, params, response) /* spotless:on */

    override fun toString() =
        "JobListPage{jobsService=$jobsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<JobListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): Optional<JobListPage> {
        return getNextPageParams().map { jobsService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(jobsService: JobService, params: JobListParams, response: JobListPageResponse) =
            JobListPage(jobsService, params, response)
    }

    class AutoPager(private val firstPage: JobListPage) : Iterable<FineTuningJob> {

        override fun iterator(): Iterator<FineTuningJob> = iterator {
            var page = firstPage
            var index = 0
            while (true) {
                while (index < page.data().size) {
                    yield(page.data()[index++])
                }
                page = page.getNextPage().getOrNull() ?: break
                index = 0
            }
        }

        fun stream(): Stream<FineTuningJob> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
