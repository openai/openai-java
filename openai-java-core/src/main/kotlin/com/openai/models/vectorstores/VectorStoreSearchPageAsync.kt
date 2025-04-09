// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import com.openai.core.JsonValue
import com.openai.services.async.VectorStoreServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** Search a vector store for relevant chunks based on a query and file attributes filter. */
class VectorStoreSearchPageAsync
private constructor(
    private val vectorStoresService: VectorStoreServiceAsync,
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

        return /* spotless:off */ other is VectorStoreSearchPageAsync && vectorStoresService == other.vectorStoresService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(vectorStoresService, params, response) /* spotless:on */

    override fun toString() =
        "VectorStoreSearchPageAsync{vectorStoresService=$vectorStoresService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<VectorStoreSearchParams> = Optional.empty()

    fun getNextPage(): CompletableFuture<Optional<VectorStoreSearchPageAsync>> {
        return getNextPageParams()
            .map { vectorStoresService.search(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            vectorStoresService: VectorStoreServiceAsync,
            params: VectorStoreSearchParams,
            response: VectorStoreSearchPageResponse,
        ) = VectorStoreSearchPageAsync(vectorStoresService, params, response)
    }

    class AutoPager(private val firstPage: VectorStoreSearchPageAsync) {

        fun forEach(
            action: Predicate<VectorStoreSearchResponse>,
            executor: Executor,
        ): CompletableFuture<Void> {
            fun CompletableFuture<Optional<VectorStoreSearchPageAsync>>.forEach(
                action: (VectorStoreSearchResponse) -> Boolean,
                executor: Executor,
            ): CompletableFuture<Void> =
                thenComposeAsync(
                    { page ->
                        page
                            .filter { it.data().all(action) }
                            .map { it.getNextPage().forEach(action, executor) }
                            .orElseGet { CompletableFuture.completedFuture(null) }
                    },
                    executor,
                )
            return CompletableFuture.completedFuture(Optional.of(firstPage))
                .forEach(action::test, executor)
        }

        fun toList(executor: Executor): CompletableFuture<List<VectorStoreSearchResponse>> {
            val values = mutableListOf<VectorStoreSearchResponse>()
            return forEach(values::add, executor).thenApply { values }
        }
    }
}
