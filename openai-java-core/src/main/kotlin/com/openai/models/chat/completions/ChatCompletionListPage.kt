// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.chat.ChatCompletionService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see ChatCompletionService.list */
class ChatCompletionListPage
private constructor(
    private val service: ChatCompletionService,
    private val params: ChatCompletionListParams,
    private val response: ChatCompletionListPageResponse,
) : Page<ChatCompletion> {

    /**
     * Delegates to [ChatCompletionListPageResponse], but gracefully handles missing data.
     *
     * @see ChatCompletionListPageResponse.data
     */
    fun data(): List<ChatCompletion> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [ChatCompletionListPageResponse], but gracefully handles missing data.
     *
     * @see ChatCompletionListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<ChatCompletion> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): ChatCompletionListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): ChatCompletionListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<ChatCompletion> = AutoPager.from(this)

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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ChatCompletionListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "ChatCompletionListPage{service=$service, params=$params, response=$response}"
}
