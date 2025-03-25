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

/** Emitted when a new content part is added. */
class ResponseContentPartAddedEvent
private constructor(
    private val contentIndex: JsonField<Long>,
    private val itemId: JsonField<String>,
    private val outputIndex: JsonField<Long>,
    private val part: JsonField<Part>,
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
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(contentIndex, itemId, outputIndex, part, type, mutableMapOf())

    /**
     * The index of the content part that was added.
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
     * The content part that was added.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun part(): Part = part.getRequired("part")

    /**
     * The type of the event. Always `response.content_part.added`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("response.content_part.added")
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

        /** The content part that was added. */
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

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("response.content_part.added")
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
         * Returns an immutable instance of [ResponseContentPartAddedEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .contentIndex()
         * .itemId()
         * .outputIndex()
         * .part()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ResponseContentPartAddedEvent =
            ResponseContentPartAddedEvent(
                checkRequired("contentIndex", contentIndex),
                checkRequired("itemId", itemId),
                checkRequired("outputIndex", outputIndex),
                checkRequired("part", part),
                type,
                additionalProperties.toMutableMap(),
            )
    }

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
