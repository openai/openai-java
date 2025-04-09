// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import com.openai.core.JsonValue
import com.openai.services.blocking.VectorStoreService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** Search a vector store for relevant chunks based on a query and file attributes filter. */
class VectorStoreSearchPage
private constructor(
    private val vectorStoresService: VectorStoreService,
    private val params: VectorStoreSearchParams,
    private val response: VectorStoreSearchPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): VectorStoreSearchPageResponse = response

    /**
     * Delegates to [VectorStoreSearchPageResponse], but gracefully handles missing data.
     *
     * @see [VectorStoreSearchPageResponse.data]
     */
    fun data(): List<VectorStoreSearchResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /** @see [VectorStoreSearchPageResponse.object_] */
    fun object_(): JsonValue = response._object_()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is VectorStoreSearchPage && vectorStoresService == other.vectorStoresService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(vectorStoresService, params, response) /* spotless:on */

    override fun toString() =
        "VectorStoreSearchPage{vectorStoresService=$vectorStoresService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<VectorStoreSearchParams> = Optional.empty()

    fun getNextPage(): Optional<VectorStoreSearchPage> {
        return getNextPageParams().map { vectorStoresService.search(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            vectorStoresService: VectorStoreService,
            params: VectorStoreSearchParams,
            response: VectorStoreSearchPageResponse,
        ) = VectorStoreSearchPage(vectorStoresService, params, response)
    }

    class AutoPager(private val firstPage: VectorStoreSearchPage) :
        Iterable<VectorStoreSearchResponse> {

        override fun iterator(): Iterator<VectorStoreSearchResponse> = iterator {
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

        fun stream(): Stream<VectorStoreSearchResponse> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
