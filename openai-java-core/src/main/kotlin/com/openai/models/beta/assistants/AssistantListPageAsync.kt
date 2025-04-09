// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.assistants

import com.openai.core.checkRequired
import com.openai.services.async.beta.AssistantServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** @see [AssistantServiceAsync.list] */
class AssistantListPageAsync
private constructor(
    private val service: AssistantServiceAsync,
    private val params: AssistantListParams,
    private val response: AssistantListPageResponse,
) {

    /**
     * Delegates to [AssistantListPageResponse], but gracefully handles missing data.
     *
     * @see [AssistantListPageResponse.data]
     */
    fun data(): List<Assistant> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [AssistantListPageResponse], but gracefully handles missing data.
     *
     * @see [AssistantListPageResponse.hasMore]
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<AssistantListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): CompletableFuture<Optional<AssistantListPageAsync>> =
        getNextPageParams()
            .map { service.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): AssistantListParams = params

    /** The response that this page was parsed from. */
    fun response(): AssistantListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [AssistantListPageAsync].
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

    /** A builder for [AssistantListPageAsync]. */
    class Builder internal constructor() {

        private var service: AssistantServiceAsync? = null
        private var params: AssistantListParams? = null
        private var response: AssistantListPageResponse? = null

        @JvmSynthetic
        internal fun from(assistantListPageAsync: AssistantListPageAsync) = apply {
            service = assistantListPageAsync.service
            params = assistantListPageAsync.params
            response = assistantListPageAsync.response
        }

        fun service(service: AssistantServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: AssistantListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: AssistantListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [AssistantListPageAsync].
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
        fun build(): AssistantListPageAsync =
            AssistantListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: AssistantListPageAsync) {

        fun forEach(action: Predicate<Assistant>, executor: Executor): CompletableFuture<Void> {
            fun CompletableFuture<Optional<AssistantListPageAsync>>.forEach(
                action: (Assistant) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<Assistant>> {
            val values = mutableListOf<Assistant>()
            return forEach(values::add, executor).thenApply { values }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is AssistantListPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "AssistantListPageAsync{service=$service, params=$params, response=$response}"
}
