// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions.messages

import com.openai.models.chat.completions.ChatCompletionStoreMessage
import com.openai.services.blocking.chat.completions.MessageService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/**
 * Get the messages in a stored chat completion. Only Chat Completions that have been created with
 * the `store` parameter set to `true` will be returned.
 */
class MessageListPage
private constructor(
    private val messagesService: MessageService,
    private val params: MessageListParams,
    private val response: MessageListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): MessageListPageResponse = response

    /**
     * Delegates to [MessageListPageResponse], but gracefully handles missing data.
     *
     * @see [MessageListPageResponse.data]
     */
    fun data(): List<ChatCompletionStoreMessage> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [MessageListPageResponse], but gracefully handles missing data.
     *
     * @see [MessageListPageResponse.hasMore]
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MessageListPage && messagesService == other.messagesService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(messagesService, params, response) /* spotless:on */

    override fun toString() =
        "MessageListPage{messagesService=$messagesService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<MessageListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): Optional<MessageListPage> {
        return getNextPageParams().map { messagesService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            messagesService: MessageService,
            params: MessageListParams,
            response: MessageListPageResponse,
        ) = MessageListPage(messagesService, params, response)
    }

    class AutoPager(private val firstPage: MessageListPage) : Iterable<ChatCompletionStoreMessage> {

        override fun iterator(): Iterator<ChatCompletionStoreMessage> = iterator {
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

        fun stream(): Stream<ChatCompletionStoreMessage> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
