// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals

import com.openai.services.async.EvalServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** List evaluations for a project. */
class EvalListPageAsync
private constructor(
    private val evalsService: EvalServiceAsync,
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

        return /* spotless:off */ other is EvalListPageAsync && evalsService == other.evalsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(evalsService, params, response) /* spotless:on */

    override fun toString() =
        "EvalListPageAsync{evalsService=$evalsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<EvalListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): CompletableFuture<Optional<EvalListPageAsync>> {
        return getNextPageParams()
            .map { evalsService.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            evalsService: EvalServiceAsync,
            params: EvalListParams,
            response: EvalListPageResponse,
        ) = EvalListPageAsync(evalsService, params, response)
    }

    class AutoPager(private val firstPage: EvalListPageAsync) {

        fun forEach(
            action: Predicate<EvalListResponse>,
            executor: Executor,
        ): CompletableFuture<Void> {
            fun CompletableFuture<Optional<EvalListPageAsync>>.forEach(
                action: (EvalListResponse) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<EvalListResponse>> {
            val values = mutableListOf<EvalListResponse>()
            return forEach(values::add, executor).thenApply { values }
        }
    }
}
