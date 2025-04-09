// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import com.openai.core.checkRequired
import com.openai.services.async.beta.threads.runs.StepServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** @see [StepServiceAsync.list] */
class StepListPageAsync
private constructor(
    private val service: StepServiceAsync,
    private val params: StepListParams,
    private val response: StepListPageResponse,
) {

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

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<StepListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): CompletableFuture<Optional<StepListPageAsync>> =
        getNextPageParams()
            .map { service.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): StepListParams = params

    /** The response that this page was parsed from. */
    fun response(): StepListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [StepListPageAsync].
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

    /** A builder for [StepListPageAsync]. */
    class Builder internal constructor() {

        private var service: StepServiceAsync? = null
        private var params: StepListParams? = null
        private var response: StepListPageResponse? = null

        @JvmSynthetic
        internal fun from(stepListPageAsync: StepListPageAsync) = apply {
            service = stepListPageAsync.service
            params = stepListPageAsync.params
            response = stepListPageAsync.response
        }

        fun service(service: StepServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: StepListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: StepListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [StepListPageAsync].
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
        fun build(): StepListPageAsync =
            StepListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is StepListPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "StepListPageAsync{service=$service, params=$params, response=$response}"
}
