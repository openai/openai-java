// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.jobs.checkpoints

import com.openai.services.async.finetuning.jobs.CheckpointServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** List checkpoints for a fine-tuning job. */
class CheckpointListPageAsync
private constructor(
    private val checkpointsService: CheckpointServiceAsync,
    private val params: CheckpointListParams,
    private val response: CheckpointListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): CheckpointListPageResponse = response

    /**
     * Delegates to [CheckpointListPageResponse], but gracefully handles missing data.
     *
     * @see [CheckpointListPageResponse.data]
     */
    fun data(): List<FineTuningJobCheckpoint> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [CheckpointListPageResponse], but gracefully handles missing data.
     *
     * @see [CheckpointListPageResponse.hasMore]
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is CheckpointListPageAsync && checkpointsService == other.checkpointsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(checkpointsService, params, response) /* spotless:on */

    override fun toString() =
        "CheckpointListPageAsync{checkpointsService=$checkpointsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<CheckpointListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): CompletableFuture<Optional<CheckpointListPageAsync>> {
        return getNextPageParams()
            .map { checkpointsService.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            checkpointsService: CheckpointServiceAsync,
            params: CheckpointListParams,
            response: CheckpointListPageResponse,
        ) = CheckpointListPageAsync(checkpointsService, params, response)
    }

    class AutoPager(private val firstPage: CheckpointListPageAsync) {

        fun forEach(
            action: Predicate<FineTuningJobCheckpoint>,
            executor: Executor,
        ): CompletableFuture<Void> {
            fun CompletableFuture<Optional<CheckpointListPageAsync>>.forEach(
                action: (FineTuningJobCheckpoint) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<FineTuningJobCheckpoint>> {
            val values = mutableListOf<FineTuningJobCheckpoint>()
            return forEach(values::add, executor).thenApply { values }
        }
    }
}
