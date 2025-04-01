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
import com.openai.core.checkRequired
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** Emitted when an output item is marked done. */
class ResponseOutputItemDoneEvent
private constructor(
    private val item: JsonField<ResponseOutputItem>,
    private val outputIndex: JsonField<Long>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("item")
        @ExcludeMissing
        item: JsonField<ResponseOutputItem> = JsonMissing.of(),
        @JsonProperty("output_index")
        @ExcludeMissing
        outputIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(item, outputIndex, type, mutableMapOf())

    /**
     * The output item that was marked done.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun item(): ResponseOutputItem = item.getRequired("item")

    /**
     * The index of the output item that was marked done.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun outputIndex(): Long = outputIndex.getRequired("output_index")

    /**
     * The type of the event. Always `response.output_item.done`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("response.output_item.done")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [item].
     *
     * Unlike [item], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("item") @ExcludeMissing fun _item(): JsonField<ResponseOutputItem> = item

    /**
     * Returns the raw JSON value of [outputIndex].
     *
     * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("output_index") @ExcludeMissing fun _outputIndex(): JsonField<Long> = outputIndex

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

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

        /**
         * Sets [Builder.item] to an arbitrary JSON value.
         *
         * You should usually call [Builder.item] with a well-typed [ResponseOutputItem] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun item(item: JsonField<ResponseOutputItem>) = apply { this.item = item }

        /** Alias for calling [item] with `ResponseOutputItem.ofMessage(message)`. */
        fun item(message: ResponseOutputMessage) = item(ResponseOutputItem.ofMessage(message))

        /** Alias for calling [item] with `ResponseOutputItem.ofFileSearchCall(fileSearchCall)`. */
        fun item(fileSearchCall: ResponseFileSearchToolCall) =
            item(ResponseOutputItem.ofFileSearchCall(fileSearchCall))

        /** Alias for calling [item] with `ResponseOutputItem.ofFunctionCall(functionCall)`. */
        fun item(functionCall: ResponseFunctionToolCall) =
            item(ResponseOutputItem.ofFunctionCall(functionCall))

        /** Alias for calling [item] with `ResponseOutputItem.ofWebSearchCall(webSearchCall)`. */
        fun item(webSearchCall: ResponseFunctionWebSearch) =
            item(ResponseOutputItem.ofWebSearchCall(webSearchCall))

        /** Alias for calling [item] with `ResponseOutputItem.ofComputerCall(computerCall)`. */
        fun item(computerCall: ResponseComputerToolCall) =
            item(ResponseOutputItem.ofComputerCall(computerCall))

        /** Alias for calling [item] with `ResponseOutputItem.ofReasoning(reasoning)`. */
        fun item(reasoning: ResponseReasoningItem) = item(ResponseOutputItem.ofReasoning(reasoning))

        /** The index of the output item that was marked done. */
        fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

        /**
         * Sets [Builder.outputIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("response.output_item.done")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
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

        /**
         * Returns an immutable instance of [ResponseOutputItemDoneEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .item()
         * .outputIndex()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ResponseOutputItemDoneEvent =
            ResponseOutputItemDoneEvent(
                checkRequired("item", item),
                checkRequired("outputIndex", outputIndex),
                type,
                additionalProperties.toMutableMap(),
            )
    }

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

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: OpenAIInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (item.asKnown().getOrNull()?.validity() ?: 0) +
            (if (outputIndex.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("response.output_item.done")) 1 else 0 }

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
