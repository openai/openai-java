// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses.inputitems

import com.openai.models.responses.ResponseComputerToolCall
import com.openai.models.responses.ResponseComputerToolCallOutputItem
import com.openai.models.responses.ResponseFileSearchToolCall
import com.openai.models.responses.ResponseFunctionToolCallItem
import com.openai.models.responses.ResponseFunctionToolCallOutputItem
import com.openai.models.responses.ResponseFunctionWebSearch
import com.openai.models.responses.ResponseInputMessageItem
import com.openai.models.responses.ResponseItem
import com.openai.models.responses.ResponseOutputMessage
import com.openai.services.blocking.responses.InputItemService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** Returns a list of input items for a given response. */
class InputItemListPage
private constructor(
    private val inputItemsService: InputItemService,
    private val params: InputItemListParams,
    private val response: ResponseItemList,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): ResponseItemList = response

    /**
     * Delegates to [ResponseItemList], but gracefully handles missing data.
     *
     * @see [ResponseItemList.data]
     */
    fun data(): List<ResponseItem> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [ResponseItemList], but gracefully handles missing data.
     *
     * @see [ResponseItemList.hasMore]
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is InputItemListPage && inputItemsService == other.inputItemsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(inputItemsService, params, response) /* spotless:on */

    override fun toString() =
        "InputItemListPage{inputItemsService=$inputItemsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<InputItemListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(
            params
                .toBuilder()
                .after(
                    data()
                        .last()
                        .accept(
                            object : ResponseItem.Visitor<Optional<String>> {
                                override fun visitResponseInputMessageItem(
                                    responseInputMessageItem: ResponseInputMessageItem
                                ): Optional<String> =
                                    responseInputMessageItem._id().getOptional("id")

                                override fun visitResponseOutputMessage(
                                    responseOutputMessage: ResponseOutputMessage
                                ): Optional<String> = responseOutputMessage._id().getOptional("id")

                                override fun visitFileSearchCall(
                                    fileSearchCall: ResponseFileSearchToolCall
                                ): Optional<String> = fileSearchCall._id().getOptional("id")

                                override fun visitComputerCall(
                                    computerCall: ResponseComputerToolCall
                                ): Optional<String> = computerCall._id().getOptional("id")

                                override fun visitComputerCallOutput(
                                    computerCallOutput: ResponseComputerToolCallOutputItem
                                ): Optional<String> = computerCallOutput._id().getOptional("id")

                                override fun visitWebSearchCall(
                                    webSearchCall: ResponseFunctionWebSearch
                                ): Optional<String> = webSearchCall._id().getOptional("id")

                                override fun visitFunctionCall(
                                    functionCall: ResponseFunctionToolCallItem
                                ): Optional<String> = functionCall._id().getOptional("id")

                                override fun visitFunctionCallOutput(
                                    functionCallOutput: ResponseFunctionToolCallOutputItem
                                ): Optional<String> = functionCallOutput._id().getOptional("id")
                            }
                        )
                )
                .build()
        )
    }

    fun getNextPage(): Optional<InputItemListPage> {
        return getNextPageParams().map { inputItemsService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            inputItemsService: InputItemService,
            params: InputItemListParams,
            response: ResponseItemList,
        ) = InputItemListPage(inputItemsService, params, response)
    }

    class AutoPager(private val firstPage: InputItemListPage) : Iterable<ResponseItem> {

        override fun iterator(): Iterator<ResponseItem> = iterator {
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

        fun stream(): Stream<ResponseItem> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
