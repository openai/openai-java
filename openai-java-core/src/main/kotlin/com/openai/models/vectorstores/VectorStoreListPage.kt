// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import com.openai.services.blocking.VectorStoreService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** Returns a list of vector stores. */
class VectorStoreListPage
private constructor(
    private val vectorStoresService: VectorStoreService,
    private val params: VectorStoreListParams,
    private val response: VectorStoreListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): VectorStoreListPageResponse = response

    /**
     * Delegates to [VectorStoreListPageResponse], but gracefully handles missing data.
     *
     * @see [VectorStoreListPageResponse.data]
     */
    fun data(): List<VectorStore> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [VectorStoreListPageResponse], but gracefully handles missing data.
     *
     * @see [VectorStoreListPageResponse.hasMore]
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is VectorStoreListPage && vectorStoresService == other.vectorStoresService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(vectorStoresService, params, response) /* spotless:on */

    override fun toString() =
        "VectorStoreListPage{vectorStoresService=$vectorStoresService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<VectorStoreListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): Optional<VectorStoreListPage> {
        return getNextPageParams().map { vectorStoresService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            vectorStoresService: VectorStoreService,
            params: VectorStoreListParams,
            response: VectorStoreListPageResponse,
        ) = VectorStoreListPage(vectorStoresService, params, response)
    }

    class AutoPager(private val firstPage: VectorStoreListPage) : Iterable<VectorStore> {

        override fun iterator(): Iterator<VectorStore> = iterator {
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

        fun stream(): Stream<VectorStore> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
