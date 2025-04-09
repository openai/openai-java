// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.services.async.VectorStoreServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** @see [VectorStoreServiceAsync.search] */
class VectorStoreSearchPageAsync
private constructor(
    private val service: VectorStoreServiceAsync,
    private val params: VectorStoreSearchParams,
    private val response: VectorStoreSearchPageResponse,
) {

    /**
     * Delegates to [VectorStoreSearchPageResponse], but gracefully handles missing data.
     *
     * @see [VectorStoreSearchPageResponse.data]
     */
    fun data(): List<VectorStoreSearchResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /** @see [VectorStoreSearchPageResponse.object_] */
    fun object_(): JsonValue = response._object_()

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<VectorStoreSearchParams> = Optional.empty()

    fun getNextPage(): CompletableFuture<Optional<VectorStoreSearchPageAsync>> =
        getNextPageParams()
            .map { service.search(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): VectorStoreSearchParams = params

    /** The response that this page was parsed from. */
    fun response(): VectorStoreSearchPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [VectorStoreSearchPageAsync].
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

    /** A builder for [VectorStoreSearchPageAsync]. */
    class Builder internal constructor() {

        private var service: VectorStoreServiceAsync? = null
        private var params: VectorStoreSearchParams? = null
        private var response: VectorStoreSearchPageResponse? = null

        @JvmSynthetic
        internal fun from(vectorStoreSearchPageAsync: VectorStoreSearchPageAsync) = apply {
            service = vectorStoreSearchPageAsync.service
            params = vectorStoreSearchPageAsync.params
            response = vectorStoreSearchPageAsync.response
        }

        fun service(service: VectorStoreServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: VectorStoreSearchParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: VectorStoreSearchPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [VectorStoreSearchPageAsync].
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
        fun build(): VectorStoreSearchPageAsync =
            VectorStoreSearchPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: VectorStoreSearchPageAsync) {

        fun forEach(
            action: Predicate<VectorStoreSearchResponse>,
            executor: Executor,
        ): CompletableFuture<Void> {
            fun CompletableFuture<Optional<VectorStoreSearchPageAsync>>.forEach(
                action: (VectorStoreSearchResponse) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<VectorStoreSearchResponse>> {
            val values = mutableListOf<VectorStoreSearchResponse>()
            return forEach(values::add, executor).thenApply { values }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is VectorStoreSearchPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "VectorStoreSearchPageAsync{service=$service, params=$params, response=$response}"
}
