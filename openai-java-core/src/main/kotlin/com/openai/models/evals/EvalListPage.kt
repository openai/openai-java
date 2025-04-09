// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals

import com.openai.services.blocking.EvalService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** List evaluations for a project. */
class EvalListPage
private constructor(
    private val evalsService: EvalService,
    private val params: EvalListParams,
    private val response: EvalListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): EvalListPageResponse = response

    /**
     * Delegates to [EvalListPageResponse], but gracefully handles missing data.
     *
     * @see [EvalListPageResponse.data]
     */
    fun data(): List<EvalListResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [EvalListPageResponse], but gracefully handles missing data.
     *
     * @see [EvalListPageResponse.hasMore]
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is EvalListPage && evalsService == other.evalsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(evalsService, params, response) /* spotless:on */

    override fun toString() =
        "EvalListPage{evalsService=$evalsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<EvalListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): Optional<EvalListPage> {
        return getNextPageParams().map { evalsService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(evalsService: EvalService, params: EvalListParams, response: EvalListPageResponse) =
            EvalListPage(evalsService, params, response)
    }

    class AutoPager(private val firstPage: EvalListPage) : Iterable<EvalListResponse> {

        override fun iterator(): Iterator<EvalListResponse> = iterator {
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

        fun stream(): Stream<EvalListResponse> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
