// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.jobs

import com.openai.services.blocking.finetuning.JobService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** Get status updates for a fine-tuning job. */
class JobListEventsPage
private constructor(
    private val jobsService: JobService,
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

        return /* spotless:off */ other is JobListEventsPage && jobsService == other.jobsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(jobsService, params, response) /* spotless:on */

    override fun toString() =
        "JobListEventsPage{jobsService=$jobsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<JobListEventsParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): Optional<JobListEventsPage> {
        return getNextPageParams().map { jobsService.listEvents(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            jobsService: JobService,
            params: JobListEventsParams,
            response: JobListEventsPageResponse,
        ) = JobListEventsPage(jobsService, params, response)
    }

    class AutoPager(private val firstPage: JobListEventsPage) : Iterable<FineTuningJobEvent> {

        override fun iterator(): Iterator<FineTuningJobEvent> = iterator {
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

        fun stream(): Stream<FineTuningJobEvent> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
