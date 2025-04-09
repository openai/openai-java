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
import com.openai.services.async.responses.InputItemServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** @see [InputItemServiceAsync.list] */
class InputItemListPageAsync
private constructor(
    private val service: InputItemServiceAsync,
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

    fun getNextPage(): CompletableFuture<Optional<InputItemListPageAsync>> =
        getNextPageParams()
            .map { service.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): InputItemListParams = params

    /** The response that this page was parsed from. */
    fun response(): ResponseItemList = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [InputItemListPageAsync].
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

    /** A builder for [InputItemListPageAsync]. */
    class Builder internal constructor() {

        private var service: InputItemServiceAsync? = null
        private var params: InputItemListParams? = null
        private var response: ResponseItemList? = null

        @JvmSynthetic
        internal fun from(inputItemListPageAsync: InputItemListPageAsync) = apply {
            service = inputItemListPageAsync.service
            params = inputItemListPageAsync.params
            response = inputItemListPageAsync.response
        }

        fun service(service: InputItemServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: InputItemListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ResponseItemList) = apply { this.response = response }

        /**
         * Returns an immutable instance of [InputItemListPageAsync].
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
        fun build(): InputItemListPageAsync =
            InputItemListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is InputItemListPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "InputItemListPageAsync{service=$service, params=$params, response=$response}"
}
