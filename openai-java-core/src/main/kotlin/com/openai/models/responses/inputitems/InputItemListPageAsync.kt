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
import com.openai.services.async.responses.InputItemServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** Returns a list of input items for a given response. */
class InputItemListPageAsync
private constructor(
    private val inputItemsService: InputItemServiceAsync,
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

        return /* spotless:off */ other is InputItemListPageAsync && inputItemsService == other.inputItemsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(inputItemsService, params, response) /* spotless:on */

    override fun toString() =
        "InputItemListPageAsync{inputItemsService=$inputItemsService, params=$params, response=$response}"

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

    fun getNextPage(): CompletableFuture<Optional<InputItemListPageAsync>> {
        return getNextPageParams()
            .map { inputItemsService.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            inputItemsService: InputItemServiceAsync,
            params: InputItemListParams,
            response: ResponseItemList,
        ) = InputItemListPageAsync(inputItemsService, params, response)
    }

    class AutoPager(private val firstPage: InputItemListPageAsync) {

        fun forEach(action: Predicate<ResponseItem>, executor: Executor): CompletableFuture<Void> {
            fun CompletableFuture<Optional<InputItemListPageAsync>>.forEach(
                action: (ResponseItem) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<ResponseItem>> {
            val values = mutableListOf<ResponseItem>()
            return forEach(values::add, executor).thenApply { values }
        }
    }
}
