// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import com.openai.services.async.beta.threads.runs.StepServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** Returns a list of run steps belonging to a run. */
class StepListPageAsync
private constructor(
    private val stepsService: StepServiceAsync,
    private val params: StepListParams,
    private val response: StepListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): StepListPageResponse = response

    /**
     * Delegates to [StepListPageResponse], but gracefully handles missing data.
     *
     * @see [StepListPageResponse.data]
     */
    fun data(): List<RunStep> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [StepListPageResponse], but gracefully handles missing data.
     *
     * @see [StepListPageResponse.hasMore]
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is StepListPageAsync && stepsService == other.stepsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(stepsService, params, response) /* spotless:on */

    override fun toString() =
        "StepListPageAsync{stepsService=$stepsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<StepListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): CompletableFuture<Optional<StepListPageAsync>> {
        return getNextPageParams()
            .map { stepsService.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            stepsService: StepServiceAsync,
            params: StepListParams,
            response: StepListPageResponse,
        ) = StepListPageAsync(stepsService, params, response)
    }

    class AutoPager(private val firstPage: StepListPageAsync) {

        fun forEach(action: Predicate<RunStep>, executor: Executor): CompletableFuture<Void> {
            fun CompletableFuture<Optional<StepListPageAsync>>.forEach(
                action: (RunStep) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<RunStep>> {
            val values = mutableListOf<RunStep>()
            return forEach(values::add, executor).thenApply { values }
        }
    }
}
