// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Emitted when a content part is done. */
class ResponseContentPartDoneEvent
private constructor(
    private val contentIndex: JsonField<Long>,
    private val itemId: JsonField<String>,
    private val outputIndex: JsonField<Long>,
    private val part: JsonField<Part>,
    private val sequenceNumber: JsonField<Long>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("content_index")
        @ExcludeMissing
        contentIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("output_index")
        @ExcludeMissing
        outputIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("part") @ExcludeMissing part: JsonField<Part> = JsonMissing.of(),
        @JsonProperty("sequence_number")
        @ExcludeMissing
        sequenceNumber: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(contentIndex, itemId, outputIndex, part, sequenceNumber, type, mutableMapOf())

    /**
     * The index of the content part that is done.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun contentIndex(): Long = contentIndex.getRequired("content_index")

    /**
     * The ID of the output item that the content part was added to.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun itemId(): String = itemId.getRequired("item_id")

    /**
     * The index of the output item that the content part was added to.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun outputIndex(): Long = outputIndex.getRequired("output_index")

    /**
     * The content part that is done.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun part(): Part = part.getRequired("part")

    /**
     * The sequence number of this event.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun sequenceNumber(): Long = sequenceNumber.getRequired("sequence_number")

    /**
     * The type of the event. Always `response.content_part.done`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("response.content_part.done")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [contentIndex].
     *
     * Unlike [contentIndex], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("content_index")
    @ExcludeMissing
    fun _contentIndex(): JsonField<Long> = contentIndex

    /**
     * Returns the raw JSON value of [itemId].
     *
     * Unlike [itemId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

    /**
     * Returns the raw JSON value of [outputIndex].
     *
     * Unlike [outputIndex], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("output_index") @ExcludeMissing fun _outputIndex(): JsonField<Long> = outputIndex

    /**
     * Returns the raw JSON value of [part].
     *
     * Unlike [part], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("part") @ExcludeMissing fun _part(): JsonField<Part> = part

    /**
     * Returns the raw JSON value of [sequenceNumber].
     *
     * Unlike [sequenceNumber], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sequence_number")
    @ExcludeMissing
    fun _sequenceNumber(): JsonField<Long> = sequenceNumber

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
         * Returns a mutable builder for constructing an instance of [ResponseContentPartDoneEvent].
         *
         * The following fields are required:
         * ```java
         * .contentIndex()
         * .itemId()
         * .outputIndex()
         * .part()
         * .sequenceNumber()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseContentPartDoneEvent]. */
    class Builder internal constructor() {

        private var contentIndex: JsonField<Long>? = null
        private var itemId: JsonField<String>? = null
        private var outputIndex: JsonField<Long>? = null
        private var part: JsonField<Part>? = null
        private var sequenceNumber: JsonField<Long>? = null
        private var type: JsonValue = JsonValue.from("response.content_part.done")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseContentPartDoneEvent: ResponseContentPartDoneEvent) = apply {
            contentIndex = responseContentPartDoneEvent.contentIndex
            itemId = responseContentPartDoneEvent.itemId
            outputIndex = responseContentPartDoneEvent.outputIndex
            part = responseContentPartDoneEvent.part
            sequenceNumber = responseContentPartDoneEvent.sequenceNumber
            type = responseContentPartDoneEvent.type
            additionalProperties = responseContentPartDoneEvent.additionalProperties.toMutableMap()
        }

        /** The index of the content part that is done. */
        fun contentIndex(contentIndex: Long) = contentIndex(JsonField.of(contentIndex))

        /**
         * Sets [Builder.contentIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contentIndex] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun contentIndex(contentIndex: JsonField<Long>) = apply { this.contentIndex = contentIndex }

        /** The ID of the output item that the content part was added to. */
        fun itemId(itemId: String) = itemId(JsonField.of(itemId))

        /**
         * Sets [Builder.itemId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.itemId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

        /** The index of the output item that the content part was added to. */
        fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

        /**
         * Sets [Builder.outputIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outputIndex] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

        /** The content part that is done. */
        fun part(part: Part) = part(JsonField.of(part))

        /**
         * Sets [Builder.part] to an arbitrary JSON value.
         *
         * You should usually call [Builder.part] with a well-typed [Part] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun part(part: JsonField<Part>) = apply { this.part = part }

        /** Alias for calling [part] with `Part.ofOutputText(outputText)`. */
        fun part(outputText: ResponseOutputText) = part(Part.ofOutputText(outputText))

        /** Alias for calling [part] with `Part.ofRefusal(refusal)`. */
        fun part(refusal: ResponseOutputRefusal) = part(Part.ofRefusal(refusal))

        /**
         * Alias for calling [part] with the following:
         * ```java
         * ResponseOutputRefusal.builder()
         *     .refusal(refusal)
         *     .build()
         * ```
         */
        fun refusalPart(refusal: String) =
            part(ResponseOutputRefusal.builder().refusal(refusal).build())

        /** The sequence number of this event. */
        fun sequenceNumber(sequenceNumber: Long) = sequenceNumber(JsonField.of(sequenceNumber))

        /**
         * Sets [Builder.sequenceNumber] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sequenceNumber] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun sequenceNumber(sequenceNumber: JsonField<Long>) = apply {
            this.sequenceNumber = sequenceNumber
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("response.content_part.done")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAlladditional_properties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAlladditional_properties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAlladditional_properties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [ResponseContentPartDoneEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .contentIndex()
         * .itemId()
         * .outputIndex()
         * .part()
         * .sequenceNumber()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ResponseContentPartDoneEvent =
            ResponseContentPartDoneEvent(
                checkRequired("contentIndex", contentIndex),
                checkRequired("itemId", itemId),
                checkRequired("outputIndex", outputIndex),
                checkRequired("part", part),
                checkRequired("sequenceNumber", sequenceNumber),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ResponseContentPartDoneEvent = apply {
        if (validated) {
            return@apply
        }

        contentIndex()
        itemId()
        outputIndex()
        part().validate()
        sequenceNumber()
        _type().let {
            if (it != JsonValue.from("response.content_part.done")) {
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
        (if (contentIndex.asKnown().isPresent) 1 else 0) +
            (if (itemId.asKnown().isPresent) 1 else 0) +
            (if (outputIndex.asKnown().isPresent) 1 else 0) +
            (part.asKnown().getOrNull()?.validity() ?: 0) +
            (if (sequenceNumber.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("response.content_part.done")) 1 else 0 }

    /** The content part that is done. */
    @JsonDeserialize(using = Part.Deserializer::class)
    @JsonSerialize(using = Part.Serializer::class)
    class Part
    private constructor(
        private val outputText: ResponseOutputText? = null,
        private val refusal: ResponseOutputRefusal? = null,
        private val _json: JsonValue? = null,
    ) {

        /** A text output from the model. */
        fun outputText(): Optional<ResponseOutputText> = Optional.ofNullable(outputText)

        /** A refusal from the model. */
        fun refusal(): Optional<ResponseOutputRefusal> = Optional.ofNullable(refusal)

        fun isOutputText(): Boolean = outputText != null

        fun isRefusal(): Boolean = refusal != null

        /** A text output from the model. */
        fun asOutputText(): ResponseOutputText = outputText.getOrThrow("outputText")

        /** A refusal from the model. */
        fun asRefusal(): ResponseOutputRefusal = refusal.getOrThrow("refusal")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                outputText != null -> visitor.visitOutputText(outputText)
                refusal != null -> visitor.visitRefusal(refusal)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Part = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitOutputText(outputText: ResponseOutputText) {
                        outputText.validate()
                    }

                    override fun visitRefusal(refusal: ResponseOutputRefusal) {
                        refusal.validate()
                    }
                }
            )
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            accept(
                object : Visitor<Int> {
                    override fun visitOutputText(outputText: ResponseOutputText) =
                        outputText.validity()

                    override fun visitRefusal(refusal: ResponseOutputRefusal) = refusal.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Part && outputText == other.outputText && refusal == other.refusal
        }

        override fun hashCode(): Int = Objects.hash(outputText, refusal)

        override fun toString(): String =
            when {
                outputText != null -> "Part{outputText=$outputText}"
                refusal != null -> "Part{refusal=$refusal}"
                _json != null -> "Part{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Part")
            }

        companion object {

            /** A text output from the model. */
            @JvmStatic
            fun ofOutputText(outputText: ResponseOutputText) = Part(outputText = outputText)

            /** A refusal from the model. */
            @JvmStatic fun ofRefusal(refusal: ResponseOutputRefusal) = Part(refusal = refusal)
        }

        /** An interface that defines how to map each variant of [Part] to a value of type [T]. */
        interface Visitor<out T> {

            /** A text output from the model. */
            fun visitOutputText(outputText: ResponseOutputText): T

            /** A refusal from the model. */
            fun visitRefusal(refusal: ResponseOutputRefusal): T

            /**
             * Maps an unknown variant of [Part] to a value of type [T].
             *
             * An instance of [Part] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Part: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Part>(Part::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Part {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "output_text" -> {
                        return tryDeserialize(node, jacksonTypeRef<ResponseOutputText>())?.let {
                            Part(outputText = it, _json = json)
                        } ?: Part(_json = json)
                    }
                    "refusal" -> {
                        return tryDeserialize(node, jacksonTypeRef<ResponseOutputRefusal>())?.let {
                            Part(refusal = it, _json = json)
                        } ?: Part(_json = json)
                    }
                }

                return Part(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Part>(Part::class) {

            override fun serialize(
                value: Part,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.outputText != null -> generator.writeObject(value.outputText)
                    value.refusal != null -> generator.writeObject(value.refusal)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Part")
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponseContentPartDoneEvent &&
            contentIndex == other.contentIndex &&
            itemId == other.itemId &&
            outputIndex == other.outputIndex &&
            part == other.part &&
            sequenceNumber == other.sequenceNumber &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            contentIndex,
            itemId,
            outputIndex,
            part,
            sequenceNumber,
            type,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseContentPartDoneEvent{contentIndex=$contentIndex, itemId=$itemId, outputIndex=$outputIndex, part=$part, sequenceNumber=$sequenceNumber, type=$type, additionalProperties=$additionalProperties}"
}
