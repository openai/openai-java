// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals.runs.outputitems

import com.openai.services.async.evals.runs.OutputItemServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** Get a list of output items for an evaluation run. */
class OutputItemListPageAsync
private constructor(
    private val outputItemsService: OutputItemServiceAsync,
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

        return /* spotless:off */ other is OutputItemListPageAsync && outputItemsService == other.outputItemsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(outputItemsService, params, response) /* spotless:on */

    override fun toString() =
        "OutputItemListPageAsync{outputItemsService=$outputItemsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<OutputItemListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): CompletableFuture<Optional<OutputItemListPageAsync>> {
        return getNextPageParams()
            .map { outputItemsService.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            outputItemsService: OutputItemServiceAsync,
            params: OutputItemListParams,
            response: OutputItemListPageResponse,
        ) = OutputItemListPageAsync(outputItemsService, params, response)
    }

    class AutoPager(private val firstPage: OutputItemListPageAsync) {

        fun forEach(
            action: Predicate<OutputItemListResponse>,
            executor: Executor,
        ): CompletableFuture<Void> {
            fun CompletableFuture<Optional<OutputItemListPageAsync>>.forEach(
                action: (OutputItemListResponse) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<OutputItemListResponse>> {
            val values = mutableListOf<OutputItemListResponse>()
            return forEach(values::add, executor).thenApply { values }
        }
    }
}
