// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import com.openai.services.async.VectorStoreServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** Returns a list of vector stores. */
class VectorStoreListPageAsync
private constructor(
    private val vectorStoresService: VectorStoreServiceAsync,
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

        return /* spotless:off */ other is VectorStoreListPageAsync && vectorStoresService == other.vectorStoresService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(vectorStoresService, params, response) /* spotless:on */

    override fun toString() =
        "VectorStoreListPageAsync{vectorStoresService=$vectorStoresService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<VectorStoreListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): CompletableFuture<Optional<VectorStoreListPageAsync>> {
        return getNextPageParams()
            .map { vectorStoresService.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            vectorStoresService: VectorStoreServiceAsync,
            params: VectorStoreListParams,
            response: VectorStoreListPageResponse,
        ) = VectorStoreListPageAsync(vectorStoresService, params, response)
    }

    class AutoPager(private val firstPage: VectorStoreListPageAsync) {

        fun forEach(action: Predicate<VectorStore>, executor: Executor): CompletableFuture<Void> {
            fun CompletableFuture<Optional<VectorStoreListPageAsync>>.forEach(
                action: (VectorStore) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<VectorStore>> {
            val values = mutableListOf<VectorStore>()
            return forEach(values::add, executor).thenApply { values }
        }
    }
}
