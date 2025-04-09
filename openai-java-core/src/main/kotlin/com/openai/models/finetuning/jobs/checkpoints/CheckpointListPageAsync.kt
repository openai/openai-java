// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.jobs.checkpoints

import com.openai.core.checkRequired
import com.openai.services.async.finetuning.jobs.CheckpointServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** @see [CheckpointServiceAsync.list] */
class CheckpointListPageAsync
private constructor(
    private val service: CheckpointServiceAsync,
    private val params: CheckpointListParams,
    private val response: CheckpointListPageResponse,
) {

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

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<CheckpointListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): CompletableFuture<Optional<CheckpointListPageAsync>> =
        getNextPageParams()
            .map { service.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): CheckpointListParams = params

    /** The response that this page was parsed from. */
    fun response(): CheckpointListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [CheckpointListPageAsync].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CheckpointListPageAsync]. */
    class Builder internal constructor() {

        private var service: CheckpointServiceAsync? = null
        private var params: CheckpointListParams? = null
        private var response: CheckpointListPageResponse? = null

        @JvmSynthetic
        internal fun from(checkpointListPageAsync: CheckpointListPageAsync) = apply {
            service = checkpointListPageAsync.service
            params = checkpointListPageAsync.params
            response = checkpointListPageAsync.response
        }

        fun service(service: CheckpointServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: CheckpointListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: CheckpointListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [CheckpointListPageAsync].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CheckpointListPageAsync =
            CheckpointListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is CheckpointListPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "CheckpointListPageAsync{service=$service, params=$params, response=$response}"
}
