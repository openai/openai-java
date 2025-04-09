// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import com.openai.services.blocking.beta.threads.runs.StepService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** Returns a list of run steps belonging to a run. */
class StepListPage
private constructor(
    private val stepsService: StepService,
    private val params: StepListParams,
    private val response: StepListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): StepListPageResponse = response

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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is StepListPage && stepsService == other.stepsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(stepsService, params, response) /* spotless:on */

    override fun toString() =
        "StepListPage{stepsService=$stepsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<StepListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): Optional<StepListPage> {
        return getNextPageParams().map { stepsService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(stepsService: StepService, params: StepListParams, response: StepListPageResponse) =
            StepListPage(stepsService, params, response)
    }

    class AutoPager(private val firstPage: StepListPage) : Iterable<RunStep> {

        override fun iterator(): Iterator<RunStep> = iterator {
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

        fun stream(): Stream<RunStep> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
