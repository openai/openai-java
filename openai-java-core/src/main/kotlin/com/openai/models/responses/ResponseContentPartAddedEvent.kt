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
import com.openai.core.NoAutoDetect
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Emitted when a new content part is added. */
@NoAutoDetect
class ResponseContentPartAddedEvent
@JsonCreator
private constructor(
    @JsonProperty("content_index")
    @ExcludeMissing
    private val contentIndex: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("item_id")
    @ExcludeMissing
    private val itemId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("output_index")
    @ExcludeMissing
    private val outputIndex: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("part") @ExcludeMissing private val part: JsonField<Part> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The index of the content part that was added. */
    fun contentIndex(): Long = contentIndex.getRequired("content_index")

    /** The ID of the output item that the content part was added to. */
    fun itemId(): String = itemId.getRequired("item_id")

    /** The index of the output item that the content part was added to. */
    fun outputIndex(): Long = outputIndex.getRequired("output_index")

    /** The content part that was added. */
    fun part(): Part = part.getRequired("part")

    /** The type of the event. Always `response.content_part.added`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /** The index of the content part that was added. */
    @JsonProperty("content_index")
    @ExcludeMissing
    fun _contentIndex(): JsonField<Long> = contentIndex

    /** The ID of the output item that the content part was added to. */
    @JsonProperty("item_id") @ExcludeMissing fun _itemId(): JsonField<String> = itemId

    /** The index of the output item that the content part was added to. */
    @JsonProperty("output_index") @ExcludeMissing fun _outputIndex(): JsonField<Long> = outputIndex

    /** The content part that was added. */
    @JsonProperty("part") @ExcludeMissing fun _part(): JsonField<Part> = part

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ResponseContentPartAddedEvent = apply {
        if (validated) {
            return@apply
        }

        contentIndex()
        itemId()
        outputIndex()
        part().validate()
        _type().let {
            if (it != JsonValue.from("response.content_part.added")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [ResponseContentPartAddedEvent].
         *
         * The following fields are required:
         * ```java
         * .contentIndex()
         * .itemId()
         * .outputIndex()
         * .part()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseContentPartAddedEvent]. */
    class Builder internal constructor() {

        private var contentIndex: JsonField<Long>? = null
        private var itemId: JsonField<String>? = null
        private var outputIndex: JsonField<Long>? = null
        private var part: JsonField<Part>? = null
        private var type: JsonValue = JsonValue.from("response.content_part.added")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseContentPartAddedEvent: ResponseContentPartAddedEvent) = apply {
            contentIndex = responseContentPartAddedEvent.contentIndex
            itemId = responseContentPartAddedEvent.itemId
            outputIndex = responseContentPartAddedEvent.outputIndex
            part = responseContentPartAddedEvent.part
            type = responseContentPartAddedEvent.type
            additionalProperties = responseContentPartAddedEvent.additionalProperties.toMutableMap()
        }

        /** The index of the content part that was added. */
        fun contentIndex(contentIndex: Long) = contentIndex(JsonField.of(contentIndex))

        /** The index of the content part that was added. */
        fun contentIndex(contentIndex: JsonField<Long>) = apply { this.contentIndex = contentIndex }

        /** The ID of the output item that the content part was added to. */
        fun itemId(itemId: String) = itemId(JsonField.of(itemId))

        /** The ID of the output item that the content part was added to. */
        fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

        /** The index of the output item that the content part was added to. */
        fun outputIndex(outputIndex: Long) = outputIndex(JsonField.of(outputIndex))

        /** The index of the output item that the content part was added to. */
        fun outputIndex(outputIndex: JsonField<Long>) = apply { this.outputIndex = outputIndex }

        /** The content part that was added. */
        fun part(part: Part) = part(JsonField.of(part))

        /** The content part that was added. */
        fun part(part: JsonField<Part>) = apply { this.part = part }

        /** A text output from the model. */
        fun part(outputText: ResponseOutputText) = part(Part.ofOutputText(outputText))

        /** A refusal from the model. */
        fun part(refusal: ResponseOutputRefusal) = part(Part.ofRefusal(refusal))

        /** A refusal from the model. */
        fun refusalPart(refusal: String) =
            part(ResponseOutputRefusal.builder().refusal(refusal).build())

        /** The type of the event. Always `response.content_part.added`. */
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

        fun build(): ResponseContentPartAddedEvent =
            ResponseContentPartAddedEvent(
                checkRequired("contentIndex", contentIndex),
                checkRequired("itemId", itemId),
                checkRequired("outputIndex", outputIndex),
                checkRequired("part", part),
                type,
                additionalProperties.toImmutable(),
            )
    }

    /** The content part that was added. */
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

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                outputText != null -> visitor.visitOutputText(outputText)
                refusal != null -> visitor.visitRefusal(refusal)
                else -> visitor.unknown(_json)
            }
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Part && outputText == other.outputText && refusal == other.refusal /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(outputText, refusal) /* spotless:on */

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
                        tryDeserialize(node, jacksonTypeRef<ResponseOutputText>()) { it.validate() }
                            ?.let {
                                return Part(outputText = it, _json = json)
                            }
                    }
                    "refusal" -> {
                        tryDeserialize(node, jacksonTypeRef<ResponseOutputRefusal>()) {
                                it.validate()
                            }
                            ?.let {
                                return Part(refusal = it, _json = json)
                            }
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

        return /* spotless:off */ other is ResponseContentPartAddedEvent && contentIndex == other.contentIndex && itemId == other.itemId && outputIndex == other.outputIndex && part == other.part && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(contentIndex, itemId, outputIndex, part, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseContentPartAddedEvent{contentIndex=$contentIndex, itemId=$itemId, outputIndex=$outputIndex, part=$part, type=$type, additionalProperties=$additionalProperties}"
}
