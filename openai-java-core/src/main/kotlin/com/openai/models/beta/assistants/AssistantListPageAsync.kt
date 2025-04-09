// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.assistants

import com.openai.services.async.beta.AssistantServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** Returns a list of assistants. */
class AssistantListPageAsync
private constructor(
    private val assistantsService: AssistantServiceAsync,
    private val params: AssistantListParams,
    private val response: AssistantListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): AssistantListPageResponse = response

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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is AssistantListPageAsync && assistantsService == other.assistantsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(assistantsService, params, response) /* spotless:on */

    override fun toString() =
        "AssistantListPageAsync{assistantsService=$assistantsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<AssistantListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): CompletableFuture<Optional<AssistantListPageAsync>> {
        return getNextPageParams()
            .map { assistantsService.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            assistantsService: AssistantServiceAsync,
            params: AssistantListParams,
            response: AssistantListPageResponse,
        ) = AssistantListPageAsync(assistantsService, params, response)
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
}
