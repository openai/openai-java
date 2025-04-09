// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.jobs

import com.openai.core.checkRequired
import com.openai.services.blocking.finetuning.JobService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** @see [JobService.listEvents] */
class JobListEventsPage
private constructor(
    private val service: JobService,
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

    fun getNextPage(): Optional<JobListEventsPage> =
        getNextPageParams().map { service.listEvents(it) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): JobListEventsParams = params

    /** The response that this page was parsed from. */
    fun response(): JobListEventsPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [JobListEventsPage].
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

    /** A builder for [JobListEventsPage]. */
    class Builder internal constructor() {

        private var service: JobService? = null
        private var params: JobListEventsParams? = null
        private var response: JobListEventsPageResponse? = null

        @JvmSynthetic
        internal fun from(jobListEventsPage: JobListEventsPage) = apply {
            service = jobListEventsPage.service
            params = jobListEventsPage.params
            response = jobListEventsPage.response
        }

        fun service(service: JobService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: JobListEventsParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: JobListEventsPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [JobListEventsPage].
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
        fun build(): JobListEventsPage =
            JobListEventsPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is JobListEventsPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "JobListEventsPage{service=$service, params=$params, response=$response}"
}
