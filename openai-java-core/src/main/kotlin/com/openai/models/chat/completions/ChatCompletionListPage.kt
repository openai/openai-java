// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.openai.services.blocking.chat.ChatCompletionService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/**
 * List stored Chat Completions. Only Chat Completions that have been stored with the `store`
 * parameter set to `true` will be returned.
 */
class ChatCompletionListPage
private constructor(
    private val completionsService: ChatCompletionService,
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

        return /* spotless:off */ other is ChatCompletionListPage && completionsService == other.completionsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(completionsService, params, response) /* spotless:on */

    override fun toString() =
        "ChatCompletionListPage{completionsService=$completionsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<ChatCompletionListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): Optional<ChatCompletionListPage> {
        return getNextPageParams().map { completionsService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            completionsService: ChatCompletionService,
            params: ChatCompletionListParams,
            response: ChatCompletionListPageResponse,
        ) = ChatCompletionListPage(completionsService, params, response)
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
}
