// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals.runs

import com.openai.services.blocking.evals.RunService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** Get a list of runs for an evaluation. */
class RunListPage
private constructor(
    private val runsService: RunService,
    private val params: RunListParams,
    private val response: RunListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): RunListPageResponse = response

    /**
     * Delegates to [RunListPageResponse], but gracefully handles missing data.
     *
     * @see [RunListPageResponse.data]
     */
    fun data(): List<RunListResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [RunListPageResponse], but gracefully handles missing data.
     *
     * @see [RunListPageResponse.hasMore]
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is RunListPage && runsService == other.runsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(runsService, params, response) /* spotless:on */

    override fun toString() =
        "RunListPage{runsService=$runsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<RunListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): Optional<RunListPage> {
        return getNextPageParams().map { runsService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(runsService: RunService, params: RunListParams, response: RunListPageResponse) =
            RunListPage(runsService, params, response)
    }

    class AutoPager(private val firstPage: RunListPage) : Iterable<RunListResponse> {

        override fun iterator(): Iterator<RunListResponse> = iterator {
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

        fun stream(): Stream<RunListResponse> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
