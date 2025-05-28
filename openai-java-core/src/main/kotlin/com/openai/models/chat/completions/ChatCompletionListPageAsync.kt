// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.chat.ChatCompletionServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see [ChatCompletionServiceAsync.list] */
class ChatCompletionListPageAsync
private constructor(
    private val service: ChatCompletionServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: ChatCompletionListParams,
    private val response: ChatCompletionListPageResponse,
) : PageAsync<ChatCompletion> {

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

    override fun items(): List<ChatCompletion> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): ChatCompletionListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): CompletableFuture<ChatCompletionListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<ChatCompletion> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

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
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ChatCompletionListPageAsync]. */
    class Builder internal constructor() {

        private var service: ChatCompletionServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: ChatCompletionListParams? = null
        private var response: ChatCompletionListPageResponse? = null

        @JvmSynthetic
        internal fun from(chatCompletionListPageAsync: ChatCompletionListPageAsync) = apply {
            service = chatCompletionListPageAsync.service
            streamHandlerExecutor = chatCompletionListPageAsync.streamHandlerExecutor
            params = chatCompletionListPageAsync.params
            response = chatCompletionListPageAsync.response
        }

        fun service(service: ChatCompletionServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

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
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ChatCompletionListPageAsync =
            ChatCompletionListPageAsync(
                checkRequired("service", service),
                checkRequired("streamHandlerExecutor", streamHandlerExecutor),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionListPageAsync && service == other.service && streamHandlerExecutor == other.streamHandlerExecutor && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, streamHandlerExecutor, params, response) /* spotless:on */

    override fun toString() =
        "ChatCompletionListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
