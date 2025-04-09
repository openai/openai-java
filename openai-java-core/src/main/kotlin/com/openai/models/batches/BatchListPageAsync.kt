// File generated from our OpenAPI spec by Stainless.

package com.openai.models.batches

import com.openai.services.async.BatchServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** List your organization's batches. */
class BatchListPageAsync
private constructor(
    private val batchesService: BatchServiceAsync,
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

        return /* spotless:off */ other is BatchListPageAsync && batchesService == other.batchesService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(batchesService, params, response) /* spotless:on */

    override fun toString() =
        "BatchListPageAsync{batchesService=$batchesService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<BatchListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): CompletableFuture<Optional<BatchListPageAsync>> {
        return getNextPageParams()
            .map { batchesService.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            batchesService: BatchServiceAsync,
            params: BatchListParams,
            response: BatchListPageResponse,
        ) = BatchListPageAsync(batchesService, params, response)
    }

    class AutoPager(private val firstPage: BatchListPageAsync) {

        fun forEach(action: Predicate<Batch>, executor: Executor): CompletableFuture<Void> {
            fun CompletableFuture<Optional<BatchListPageAsync>>.forEach(
                action: (Batch) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<Batch>> {
            val values = mutableListOf<Batch>()
            return forEach(values::add, executor).thenApply { values }
        }
    }
}
