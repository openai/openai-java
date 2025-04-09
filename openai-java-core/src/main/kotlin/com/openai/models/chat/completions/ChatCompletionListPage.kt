// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.openai.core.checkRequired
import com.openai.services.blocking.chat.ChatCompletionService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** @see [ChatCompletionService.list] */
class ChatCompletionListPage
private constructor(
    private val service: ChatCompletionService,
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

    fun getNextPage(): Optional<ChatCompletionListPage> =
        getNextPageParams().map { service.list(it) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): ChatCompletionListParams = params

    /** The response that this page was parsed from. */
    fun response(): ChatCompletionListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ChatCompletionListPage].
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

    /** A builder for [ChatCompletionListPage]. */
    class Builder internal constructor() {

        private var service: ChatCompletionService? = null
        private var params: ChatCompletionListParams? = null
        private var response: ChatCompletionListPageResponse? = null

        @JvmSynthetic
        internal fun from(chatCompletionListPage: ChatCompletionListPage) = apply {
            service = chatCompletionListPage.service
            params = chatCompletionListPage.params
            response = chatCompletionListPage.response
        }

        fun service(service: ChatCompletionService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ChatCompletionListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ChatCompletionListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ChatCompletionListPage].
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
        fun build(): ChatCompletionListPage =
            ChatCompletionListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: ChatCompletionListPage) : Iterable<ChatCompletion> {

        override fun iterator(): Iterator<ChatCompletion> = iterator {
            var page = firstPage
            var index = 0
            while (true) {
                while (index < page.data().size) {
                    yield(page.data()[index++])
                }
                page = page.getNextPage().getOrNull() ?: break
                index = 0
            }
        }

        fun stream(): Stream<ChatCompletion> {
            return StreamSupport.stream(spliterator(), false)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionListPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "ChatCompletionListPage{service=$service, params=$params, response=$response}"
}
