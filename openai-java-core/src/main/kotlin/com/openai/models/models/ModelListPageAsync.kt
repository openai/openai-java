// File generated from our OpenAPI spec by Stainless.

package com.openai.models.models

import com.openai.core.JsonValue
import com.openai.services.async.ModelServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/**
 * Lists the currently available models, and provides basic information about each one such as the
 * owner and availability.
 */
class ModelListPageAsync
private constructor(
    private val modelsService: ModelServiceAsync,
    private val params: ModelListParams,
    private val response: ModelListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): ModelListPageResponse = response

    /**
     * Delegates to [ModelListPageResponse], but gracefully handles missing data.
     *
     * @see [ModelListPageResponse.data]
     */
    fun data(): List<Model> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /** @see [ModelListPageResponse.object_] */
    fun object_(): JsonValue = response._object_()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ModelListPageAsync && modelsService == other.modelsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(modelsService, params, response) /* spotless:on */

    override fun toString() =
        "ModelListPageAsync{modelsService=$modelsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<ModelListParams> = Optional.empty()

    fun getNextPage(): CompletableFuture<Optional<ModelListPageAsync>> {
        return getNextPageParams()
            .map { modelsService.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            modelsService: ModelServiceAsync,
            params: ModelListParams,
            response: ModelListPageResponse,
        ) = ModelListPageAsync(modelsService, params, response)
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
}
