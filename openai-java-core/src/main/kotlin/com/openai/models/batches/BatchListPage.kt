// File generated from our OpenAPI spec by Stainless.

package com.openai.models.batches

import com.openai.services.blocking.BatchService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** List your organization's batches. */
class BatchListPage
private constructor(
    private val batchesService: BatchService,
    private val params: BatchListParams,
    private val response: BatchListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): BatchListPageResponse = response

    /**
     * Delegates to [BatchListPageResponse], but gracefully handles missing data.
     *
     * @see [BatchListPageResponse.data]
     */
    fun data(): List<Batch> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [BatchListPageResponse], but gracefully handles missing data.
     *
     * @see [BatchListPageResponse.hasMore]
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BatchListPage && batchesService == other.batchesService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(batchesService, params, response) /* spotless:on */

    override fun toString() =
        "BatchListPage{batchesService=$batchesService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<BatchListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): Optional<BatchListPage> {
        return getNextPageParams().map { batchesService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            batchesService: BatchService,
            params: BatchListParams,
            response: BatchListPageResponse,
        ) = BatchListPage(batchesService, params, response)
    }

    class AutoPager(private val firstPage: BatchListPage) : Iterable<Batch> {

        override fun iterator(): Iterator<Batch> = iterator {
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

        fun stream(): Stream<Batch> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
