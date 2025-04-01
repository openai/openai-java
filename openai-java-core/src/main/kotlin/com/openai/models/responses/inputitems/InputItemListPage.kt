// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses.inputitems

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.errors.OpenAIInvalidDataException
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
import java.util.Collections
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
    private val response: Response,
) {

    fun response(): Response = response

    fun data(): List<ResponseItem> = response().data()

    fun hasMore(): Optional<Boolean> = response().hasMore()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is InputItemListPage && inputItemsService == other.inputItemsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(inputItemsService, params, response) /* spotless:on */

    override fun toString() =
        "InputItemListPage{inputItemsService=$inputItemsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean {
        return !data().isEmpty()
    }

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
                                ): Optional<String> = Optional.of(responseInputMessageItem.id())

                                override fun visitResponseOutputMessage(
                                    responseOutputMessage: ResponseOutputMessage
                                ): Optional<String> = Optional.of(responseOutputMessage.id())

                                override fun visitFileSearchCall(
                                    fileSearchCall: ResponseFileSearchToolCall
                                ): Optional<String> = Optional.of(fileSearchCall.id())

                                override fun visitComputerCall(
                                    computerCall: ResponseComputerToolCall
                                ): Optional<String> = Optional.of(computerCall.id())

                                override fun visitComputerCallOutput(
                                    computerCallOutput: ResponseComputerToolCallOutputItem
                                ): Optional<String> = Optional.of(computerCallOutput.id())

                                override fun visitWebSearchCall(
                                    webSearchCall: ResponseFunctionWebSearch
                                ): Optional<String> = Optional.of(webSearchCall.id())

                                override fun visitFunctionCall(
                                    functionCall: ResponseFunctionToolCallItem
                                ): Optional<String> = functionCall.id()

                                override fun visitFunctionCallOutput(
                                    functionCallOutput: ResponseFunctionToolCallOutputItem
                                ): Optional<String> = Optional.of(functionCallOutput.id())
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
            response: Response,
        ) = InputItemListPage(inputItemsService, params, response)
    }

    class Response(
        private val data: JsonField<List<ResponseItem>>,
        private val hasMore: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data") data: JsonField<List<ResponseItem>> = JsonMissing.of(),
            @JsonProperty("has_more") hasMore: JsonField<Boolean> = JsonMissing.of(),
        ) : this(data, hasMore, mutableMapOf())

        fun data(): List<ResponseItem> = data.getNullable("data") ?: listOf()

        fun hasMore(): Optional<Boolean> = Optional.ofNullable(hasMore.getNullable("has_more"))

        @JsonProperty("data")
        fun _data(): Optional<JsonField<List<ResponseItem>>> = Optional.ofNullable(data)

        @JsonProperty("has_more")
        fun _hasMore(): Optional<JsonField<Boolean>> = Optional.ofNullable(hasMore)

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        private var validated: Boolean = false

        fun validate(): Response = apply {
            if (validated) {
                return@apply
            }

            data().map { it.validate() }
            hasMore()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OpenAIInvalidDataException) {
                false
            }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Response && data == other.data && hasMore == other.hasMore && additionalProperties == other.additionalProperties /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(data, hasMore, additionalProperties) /* spotless:on */

        override fun toString() =
            "Response{data=$data, hasMore=$hasMore, additionalProperties=$additionalProperties}"

        companion object {

            /** Returns a mutable builder for constructing an instance of [InputItemListPage]. */
            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var data: JsonField<List<ResponseItem>> = JsonMissing.of()
            private var hasMore: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(page: Response) = apply {
                this.data = page.data
                this.hasMore = page.hasMore
                this.additionalProperties.putAll(page.additionalProperties)
            }

            fun data(data: List<ResponseItem>) = data(JsonField.of(data))

            fun data(data: JsonField<List<ResponseItem>>) = apply { this.data = data }

            fun hasMore(hasMore: Boolean) = hasMore(JsonField.of(hasMore))

            fun hasMore(hasMore: JsonField<Boolean>) = apply { this.hasMore = hasMore }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            /**
             * Returns an immutable instance of [Response].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Response = Response(data, hasMore, additionalProperties.toMutableMap())
        }
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
