// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals.runs.outputitems

import com.openai.services.blocking.evals.runs.OutputItemService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** Get a list of output items for an evaluation run. */
class OutputItemListPage
private constructor(
    private val outputItemsService: OutputItemService,
    private val params: OutputItemListParams,
    private val response: OutputItemListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): OutputItemListPageResponse = response

    /**
     * Delegates to [OutputItemListPageResponse], but gracefully handles missing data.
     *
     * @see [OutputItemListPageResponse.data]
     */
    fun data(): List<OutputItemListResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [OutputItemListPageResponse], but gracefully handles missing data.
     *
     * @see [OutputItemListPageResponse.hasMore]
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is OutputItemListPage && outputItemsService == other.outputItemsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(outputItemsService, params, response) /* spotless:on */

    override fun toString() =
        "OutputItemListPage{outputItemsService=$outputItemsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<OutputItemListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): Optional<OutputItemListPage> {
        return getNextPageParams().map { outputItemsService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            outputItemsService: OutputItemService,
            params: OutputItemListParams,
            response: OutputItemListPageResponse,
        ) = OutputItemListPage(outputItemsService, params, response)
    }

    class AutoPager(private val firstPage: OutputItemListPage) : Iterable<OutputItemListResponse> {

        override fun iterator(): Iterator<OutputItemListResponse> = iterator {
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

        fun stream(): Stream<OutputItemListResponse> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
