// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals.runs

import com.openai.services.async.evals.RunServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** Get a list of runs for an evaluation. */
class RunListPageAsync
private constructor(
    private val runsService: RunServiceAsync,
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

        return /* spotless:off */ other is RunListPageAsync && runsService == other.runsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(runsService, params, response) /* spotless:on */

    override fun toString() =
        "RunListPageAsync{runsService=$runsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<RunListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): CompletableFuture<Optional<RunListPageAsync>> {
        return getNextPageParams()
            .map { runsService.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(runsService: RunServiceAsync, params: RunListParams, response: RunListPageResponse) =
            RunListPageAsync(runsService, params, response)
    }

    class AutoPager(private val firstPage: RunListPageAsync) {

        fun forEach(
            action: Predicate<RunListResponse>,
            executor: Executor,
        ): CompletableFuture<Void> {
            fun CompletableFuture<Optional<RunListPageAsync>>.forEach(
                action: (RunListResponse) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<RunListResponse>> {
            val values = mutableListOf<RunListResponse>()
            return forEach(values::add, executor).thenApply { values }
        }
    }
}
