// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals.runs.outputitems

import com.openai.core.checkRequired
import com.openai.services.async.evals.runs.OutputItemServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** @see [OutputItemServiceAsync.list] */
class OutputItemListPageAsync
private constructor(
    private val service: OutputItemServiceAsync,
    private val params: OutputItemListParams,
    private val response: OutputItemListPageResponse,
) {

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

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<OutputItemListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): CompletableFuture<Optional<OutputItemListPageAsync>> =
        getNextPageParams()
            .map { service.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): OutputItemListParams = params

    /** The response that this page was parsed from. */
    fun response(): OutputItemListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [OutputItemListPageAsync].
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

    /** A builder for [OutputItemListPageAsync]. */
    class Builder internal constructor() {

        private var service: OutputItemServiceAsync? = null
        private var params: OutputItemListParams? = null
        private var response: OutputItemListPageResponse? = null

        @JvmSynthetic
        internal fun from(outputItemListPageAsync: OutputItemListPageAsync) = apply {
            service = outputItemListPageAsync.service
            params = outputItemListPageAsync.params
            response = outputItemListPageAsync.response
        }

        fun service(service: OutputItemServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: OutputItemListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: OutputItemListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [OutputItemListPageAsync].
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
        fun build(): OutputItemListPageAsync =
            OutputItemListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is OutputItemListPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "OutputItemListPageAsync{service=$service, params=$params, response=$response}"
}
