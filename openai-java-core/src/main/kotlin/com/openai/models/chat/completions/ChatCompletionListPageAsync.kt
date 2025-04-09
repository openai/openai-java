// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.openai.services.async.chat.ChatCompletionServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/**
 * List stored Chat Completions. Only Chat Completions that have been stored with the `store`
 * parameter set to `true` will be returned.
 */
class ChatCompletionListPageAsync
private constructor(
    private val completionsService: ChatCompletionServiceAsync,
    private val params: ChatCompletionListParams,
    private val response: ChatCompletionListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): ChatCompletionListPageResponse = response

    /**
     * Delegates to [ChatCompletionListPageResponse], but gracefully handles missing data.
     *
     * @see [ChatCompletionListPageResponse.data]
     */
    fun data(): List<ChatCompletion> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [ChatCompletionListPageResponse], but gracefully handles missing data.
     *
     * @see [ChatCompletionListPageResponse.hasMore]
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionListPageAsync && completionsService == other.completionsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(completionsService, params, response) /* spotless:on */

    override fun toString() =
        "ChatCompletionListPageAsync{completionsService=$completionsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<ChatCompletionListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): CompletableFuture<Optional<ChatCompletionListPageAsync>> {
        return getNextPageParams()
            .map { completionsService.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            completionsService: ChatCompletionServiceAsync,
            params: ChatCompletionListParams,
            response: ChatCompletionListPageResponse,
        ) = ChatCompletionListPageAsync(completionsService, params, response)
    }

    class AutoPager(private val firstPage: ChatCompletionListPageAsync) {

        fun forEach(
            action: Predicate<ChatCompletion>,
            executor: Executor,
        ): CompletableFuture<Void> {
            fun CompletableFuture<Optional<ChatCompletionListPageAsync>>.forEach(
                action: (ChatCompletion) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<ChatCompletion>> {
            val values = mutableListOf<ChatCompletion>()
            return forEach(values::add, executor).thenApply { values }
        }
    }
}
