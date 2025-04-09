// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals

import com.openai.core.checkRequired
import com.openai.services.async.EvalServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** @see [EvalServiceAsync.list] */
class EvalListPageAsync
private constructor(
    private val service: EvalServiceAsync,
    private val params: EvalListParams,
    private val response: EvalListPageResponse,
) {

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

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<EvalListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): CompletableFuture<Optional<EvalListPageAsync>> =
        getNextPageParams()
            .map { service.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): EvalListParams = params

    /** The response that this page was parsed from. */
    fun response(): EvalListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [EvalListPageAsync].
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

    /** A builder for [EvalListPageAsync]. */
    class Builder internal constructor() {

        private var service: EvalServiceAsync? = null
        private var params: EvalListParams? = null
        private var response: EvalListPageResponse? = null

        @JvmSynthetic
        internal fun from(evalListPageAsync: EvalListPageAsync) = apply {
            service = evalListPageAsync.service
            params = evalListPageAsync.params
            response = evalListPageAsync.response
        }

        fun service(service: EvalServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: EvalListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: EvalListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [EvalListPageAsync].
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
        fun build(): EvalListPageAsync =
            EvalListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is EvalListPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "EvalListPageAsync{service=$service, params=$params, response=$response}"
}
