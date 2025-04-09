// File generated from our OpenAPI spec by Stainless.

package com.openai.models.batches

import com.openai.core.checkRequired
import com.openai.services.async.BatchServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** @see [BatchServiceAsync.list] */
class BatchListPageAsync
private constructor(
    private val service: BatchServiceAsync,
    private val params: BatchListParams,
    private val response: BatchListPageResponse,
) {

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

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<BatchListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): CompletableFuture<Optional<BatchListPageAsync>> =
        getNextPageParams()
            .map { service.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): BatchListParams = params

    /** The response that this page was parsed from. */
    fun response(): BatchListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [BatchListPageAsync].
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

    /** A builder for [BatchListPageAsync]. */
    class Builder internal constructor() {

        private var service: BatchServiceAsync? = null
        private var params: BatchListParams? = null
        private var response: BatchListPageResponse? = null

        @JvmSynthetic
        internal fun from(batchListPageAsync: BatchListPageAsync) = apply {
            service = batchListPageAsync.service
            params = batchListPageAsync.params
            response = batchListPageAsync.response
        }

        fun service(service: BatchServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: BatchListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: BatchListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [BatchListPageAsync].
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
        fun build(): BatchListPageAsync =
            BatchListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BatchListPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "BatchListPageAsync{service=$service, params=$params, response=$response}"
}
