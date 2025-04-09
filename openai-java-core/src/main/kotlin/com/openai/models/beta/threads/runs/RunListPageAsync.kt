// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs

import com.openai.core.checkRequired
import com.openai.services.async.beta.threads.RunServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** @see [RunServiceAsync.list] */
class RunListPageAsync
private constructor(
    private val service: RunServiceAsync,
    private val params: RunListParams,
    private val response: RunListPageResponse,
) {

    /**
     * Delegates to [RunListPageResponse], but gracefully handles missing data.
     *
     * @see [RunListPageResponse.data]
     */
    fun data(): List<Run> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [RunListPageResponse], but gracefully handles missing data.
     *
     * @see [RunListPageResponse.hasMore]
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<RunListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): CompletableFuture<Optional<RunListPageAsync>> =
        getNextPageParams()
            .map { service.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): RunListParams = params

    /** The response that this page was parsed from. */
    fun response(): RunListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [RunListPageAsync].
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

    /** A builder for [RunListPageAsync]. */
    class Builder internal constructor() {

        private var service: RunServiceAsync? = null
        private var params: RunListParams? = null
        private var response: RunListPageResponse? = null

        @JvmSynthetic
        internal fun from(runListPageAsync: RunListPageAsync) = apply {
            service = runListPageAsync.service
            params = runListPageAsync.params
            response = runListPageAsync.response
        }

        fun service(service: RunServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: RunListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: RunListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [RunListPageAsync].
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
        fun build(): RunListPageAsync =
            RunListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: RunListPageAsync) {

        fun forEach(action: Predicate<Run>, executor: Executor): CompletableFuture<Void> {
            fun CompletableFuture<Optional<RunListPageAsync>>.forEach(
                action: (Run) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<Run>> {
            val values = mutableListOf<Run>()
            return forEach(values::add, executor).thenApply { values }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is RunListPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "RunListPageAsync{service=$service, params=$params, response=$response}"
}
