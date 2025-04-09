// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.openai.core.checkRequired
import com.openai.services.async.chat.ChatCompletionServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** @see [ChatCompletionServiceAsync.list] */
class ChatCompletionListPageAsync
private constructor(
    private val service: ChatCompletionServiceAsync,
    private val params: ChatCompletionListParams,
    private val response: ChatCompletionListPageResponse,
) {

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

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<ChatCompletionListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): CompletableFuture<Optional<ChatCompletionListPageAsync>> =
        getNextPageParams()
            .map { service.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): ChatCompletionListParams = params

    /** The response that this page was parsed from. */
    fun response(): ChatCompletionListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ChatCompletionListPageAsync].
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

    /** A builder for [ChatCompletionListPageAsync]. */
    class Builder internal constructor() {

        private var service: ChatCompletionServiceAsync? = null
        private var params: ChatCompletionListParams? = null
        private var response: ChatCompletionListPageResponse? = null

        @JvmSynthetic
        internal fun from(chatCompletionListPageAsync: ChatCompletionListPageAsync) = apply {
            service = chatCompletionListPageAsync.service
            params = chatCompletionListPageAsync.params
            response = chatCompletionListPageAsync.response
        }

        fun service(service: ChatCompletionServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ChatCompletionListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ChatCompletionListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ChatCompletionListPageAsync].
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
        fun build(): ChatCompletionListPageAsync =
            ChatCompletionListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionListPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "ChatCompletionListPageAsync{service=$service, params=$params, response=$response}"
}
