// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.checkRequired
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects

/** Emitted when an output item is marked done. */
@NoAutoDetect
class ResponseOutputItemDoneEvent
@JsonCreator
private constructor(
    @JsonProperty("item")
    @ExcludeMissing
    private val item: JsonField<ResponseOutputItem> = JsonMissing.of(),
    @JsonProperty("output_index")
    @ExcludeMissing
    private val outputIndex: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The output item that was marked done. */
    fun item(): ResponseOutputItem = item.getRequired("item")

    /** The index of the output item that was marked done. */
    fun outputIndex(): Long = outputIndex.getRequired("output_index")

    /** The type of the event. Always `response.output_item.done`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /** The output item that was marked done. */
    @JsonProperty("item") @ExcludeMissing fun _item(): JsonField<ResponseOutputItem> = item

    /** The index of the output item that was marked done. */
    @JsonProperty("output_index") @ExcludeMissing fun _outputIndex(): JsonField<Long> = outputIndex

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ResponseOutputItemDoneEvent = apply {
        if (validated) {
            return@apply
        }

        item().validate()
        outputIndex()
        _type().let {
            if (it != JsonValue.from("response.output_item.done")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ResponseOutputItemDoneEvent].
         *
         * The following fields are required:
         * ```java
         * .item()
         * .outputIndex()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseOutputItemDoneEvent]. */
    class Builder internal constructor() {

        private var item: JsonField<ResponseOutputItem>? = null
        private var outputIndex: JsonField<Long>? = null
        private var type: JsonValue = JsonValue.from("response.output_item.done")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseOutputItemDoneEvent: ResponseOutputItemDoneEvent) = apply {
            item = responseOutputItemDoneEvent.item
            outputIndex = responseOutputItemDoneEvent.outputIndex
            type = responseOutputItemDoneEvent.type
            additionalProperties = responseOutputItemDoneEvent.additionalProperties.toMutableMap()
        }

        /** The output item that was marked done. */
        fun item(item: ResponseOutputItem) = item(JsonField.of(item))

        /** The output item that was marked done. */
        fun item(item: JsonField<ResponseOutputItem>) = apply { this.item = item }

        /** An output message from the model. */
        fun item(message: ResponseOutputMessage) = item(ResponseOutputItem.ofMessage(message))

        /**
         * The results of a file search tool call. See the
         * [file search guide](https://platform.openai.com/docs/guides/tools-file-search) for more
         * information.
         */
        fun item(fileSearchCall: ResponseFileSearchToolCall) =
            item(ResponseOutputItem.ofFileSearchCall(fileSearchCall))

        /**
         * A tool call to run a function. See the
         * [function calling guide](https://platform.openai.com/docs/guides/function-calling) for
         * more information.
         */
        fun item(functionCall: ResponseFunctionToolCall) =
            item(ResponseOutputItem.ofFunctionCall(functionCall))

        /**
         * The results of a web search tool call. See the
         * [web search guide](https://platform.openai.com/docs/guides/tools-web-search) for more
         * information.
         */
        fun item(webSearchCall: ResponseFunctionWebSearch) =
            item(ResponseOutputItem.ofWebSearchCall(webSearchCall))

        /**
         * A tool call to a computer use tool. See the
         * [computer use guide](https://platform.openai.com/docs/guides/tools-computer-use) for more
         * information.
         */
        fun item(computerCall: ResponseComputerToolCall) =
            item(ResponseOutputItem.ofComputerCall(computerCall))

        /**
         * A description of the chain of thought used by a reasoning model while generating a
         * response.
         */
        fun item(reasoning: ResponseOutputItem.Reasoning) =
            item(ResponseOutputItem.ofReasoning(reasoning))

        /** The index of the output item that was marked done. */
        fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

        /** The index of the output item that was marked done. */
        fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

        /** The type of the event. Always `response.output_item.done`. */
        fun type(type: JsonValue) = apply { this.type = type }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        fun build(): ResponseOutputItemDoneEvent =
            ResponseOutputItemDoneEvent(
                checkRequired("item", item),
                checkRequired("outputIndex", outputIndex),
                type,
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseOutputItemDoneEvent && item == other.item && outputIndex == other.outputIndex && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(item, outputIndex, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseOutputItemDoneEvent{item=$item, outputIndex=$outputIndex, type=$type, additionalProperties=$additionalProperties}"
}
