// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import com.openai.core.checkRequired
import com.openai.services.async.VectorStoreServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** @see [VectorStoreServiceAsync.list] */
class VectorStoreListPageAsync
private constructor(
    private val service: VectorStoreServiceAsync,
    private val params: VectorStoreListParams,
    private val response: VectorStoreListPageResponse,
) {

    /**
     * Delegates to [VectorStoreListPageResponse], but gracefully handles missing data.
     *
     * @see [VectorStoreListPageResponse.data]
     */
    fun data(): List<VectorStore> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [VectorStoreListPageResponse], but gracefully handles missing data.
     *
     * @see [VectorStoreListPageResponse.hasMore]
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<VectorStoreListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): CompletableFuture<Optional<VectorStoreListPageAsync>> =
        getNextPageParams()
            .map { service.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): VectorStoreListParams = params

    /** The response that this page was parsed from. */
    fun response(): VectorStoreListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [VectorStoreListPageAsync].
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

    /** A builder for [VectorStoreListPageAsync]. */
    class Builder internal constructor() {

        private var service: VectorStoreServiceAsync? = null
        private var params: VectorStoreListParams? = null
        private var response: VectorStoreListPageResponse? = null

        @JvmSynthetic
        internal fun from(vectorStoreListPageAsync: VectorStoreListPageAsync) = apply {
            service = vectorStoreListPageAsync.service
            params = vectorStoreListPageAsync.params
            response = vectorStoreListPageAsync.response
        }

        fun service(service: VectorStoreServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: VectorStoreListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: VectorStoreListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [VectorStoreListPageAsync].
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
        fun build(): VectorStoreListPageAsync =
            VectorStoreListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: VectorStoreListPageAsync) {

        fun forEach(action: Predicate<VectorStore>, executor: Executor): CompletableFuture<Void> {
            fun CompletableFuture<Optional<VectorStoreListPageAsync>>.forEach(
                action: (VectorStore) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<VectorStore>> {
            val values = mutableListOf<VectorStore>()
            return forEach(values::add, executor).thenApply { values }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is VectorStoreListPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "VectorStoreListPageAsync{service=$service, params=$params, response=$response}"
}
