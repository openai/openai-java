// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses.inputitems

import com.openai.core.checkRequired
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

/** @see [InputItemService.list] */
class InputItemListPage
private constructor(
    private val service: InputItemService,
    private val params: InputItemListParams,
    private val response: ResponseItemList,
) {

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

    fun getNextPage(): Optional<InputItemListPage> = getNextPageParams().map { service.list(it) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): InputItemListParams = params

    /** The response that this page was parsed from. */
    fun response(): ResponseItemList = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [InputItemListPage].
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

    /** A builder for [InputItemListPage]. */
    class Builder internal constructor() {

        private var service: InputItemService? = null
        private var params: InputItemListParams? = null
        private var response: ResponseItemList? = null

        @JvmSynthetic
        internal fun from(inputItemListPage: InputItemListPage) = apply {
            service = inputItemListPage.service
            params = inputItemListPage.params
            response = inputItemListPage.response
        }

        fun service(service: InputItemService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: InputItemListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ResponseItemList) = apply { this.response = response }

        /**
         * Returns an immutable instance of [InputItemListPage].
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
        fun build(): InputItemListPage =
            InputItemListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is InputItemListPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "InputItemListPage{service=$service, params=$params, response=$response}"
}
