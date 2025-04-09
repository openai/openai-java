// File generated from our OpenAPI spec by Stainless.

package com.openai.models.models

import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.services.async.ModelServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** @see [ModelServiceAsync.list] */
class ModelListPageAsync
private constructor(
    private val service: ModelServiceAsync,
    private val params: ModelListParams,
    private val response: ModelListPageResponse,
) {

    /**
     * Delegates to [ModelListPageResponse], but gracefully handles missing data.
     *
     * @see [ModelListPageResponse.data]
     */
    fun data(): List<Model> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /** @see [ModelListPageResponse.object_] */
    fun object_(): JsonValue = response._object_()

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<ModelListParams> = Optional.empty()

    fun getNextPage(): CompletableFuture<Optional<ModelListPageAsync>> =
        getNextPageParams()
            .map { service.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): ModelListParams = params

    /** The response that this page was parsed from. */
    fun response(): ModelListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ModelListPageAsync].
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

    /** A builder for [ModelListPageAsync]. */
    class Builder internal constructor() {

        private var service: ModelServiceAsync? = null
        private var params: ModelListParams? = null
        private var response: ModelListPageResponse? = null

        @JvmSynthetic
        internal fun from(modelListPageAsync: ModelListPageAsync) = apply {
            service = modelListPageAsync.service
            params = modelListPageAsync.params
            response = modelListPageAsync.response
        }

        fun service(service: ModelServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ModelListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ModelListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ModelListPageAsync].
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
        fun build(): ModelListPageAsync =
            ModelListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: ModelListPageAsync) {

        fun forEach(action: Predicate<Model>, executor: Executor): CompletableFuture<Void> {
            fun CompletableFuture<Optional<ModelListPageAsync>>.forEach(
                action: (Model) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<Model>> {
            val values = mutableListOf<Model>()
            return forEach(values::add, executor).thenApply { values }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ModelListPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "ModelListPageAsync{service=$service, params=$params, response=$response}"
}
