// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.realtime

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.core.collectAllProperties
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Returned when a new content part is added to an assistant message item during response
 * generation.
 */
class ResponseContentPartAddedEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val contentIndex: JsonField<Long>,
    private val eventId: JsonField<String>,
    private val itemId: JsonField<String>,
    private val outputIndex: JsonField<Long>,
    private val part: JsonField<Part>,
    private val responseId: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("content_index")
        @ExcludeMissing
        contentIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("event_id") @ExcludeMissing eventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("item_id") @ExcludeMissing itemId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("output_index")
        @ExcludeMissing
        outputIndex: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("part") @ExcludeMissing part: JsonField<Part> = JsonMissing.of(),
        @JsonProperty("response_id")
        @ExcludeMissing
        responseId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(contentIndex, eventId, itemId, outputIndex, part, responseId, type, mutableMapOf())

    /**
     * The index of the content part in the item's content array. The schema requires this property.
     * Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun contentIndex(): java.util.Optional<Long> = contentIndex.getOptional("content_index")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun contentIndexOrThrow(): Long = contentIndex.getRequired("content_index")

    /**
     * The unique ID of the server event. The schema requires this property. Returns empty if the
     * JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun eventId(): java.util.Optional<String> = eventId.getOptional("event_id")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun eventIdOrThrow(): String = eventId.getRequired("event_id")

    /**
     * The ID of the item to which the content part was added. The schema requires this property.
     * Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun itemId(): java.util.Optional<String> = itemId.getOptional("item_id")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun itemIdOrThrow(): String = itemId.getRequired("item_id")

    /**
     * The index of the output item in the response. The schema requires this property. Returns
     * empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun outputIndex(): java.util.Optional<Long> = outputIndex.getOptional("output_index")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun outputIndexOrThrow(): Long = outputIndex.getRequired("output_index")

    /**
     * The content part that was added. The schema requires this property. Returns empty if the JSON
     * property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun part(): java.util.Optional<Part> = part.getOptional("part")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun partOrThrow(): Part = part.getRequired("part")

    /**
     * The ID of the response. The schema requires this property. Returns empty if the JSON property
     * is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun responseId(): java.util.Optional<String> = responseId.getOptional("response_id")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun responseIdOrThrow(): String = responseId.getRequired("response_id")

    /**
     * The event type, must be `response.content_part.added`. The schema requires this property.
     * Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun type(): java.util.Optional<JsonValue> {
        val raw = type
        return when {
            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
            !(raw == JsonValue.from("response.content_part.added")) ->
                throw OpenAIInvalidDataException("`type` is invalid")
            else -> java.util.Optional.of(raw)
        }
    }

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

    /**
     * Returns the raw JSON value of [contentIndex].
     *
     * Unlike [contentIndex], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("content_index")
    @ExcludeMissing
    fun _contentIndex(): JsonField<Long> = contentIndex

    /**
     * Returns the raw JSON value of [eventId].
     *
     * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_id") @ExcludeMissing fun _eventId(): JsonField<String> = eventId

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
     * Returns the raw JSON value of [responseId].
     *
     * Unlike [responseId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("response_id") @ExcludeMissing fun _responseId(): JsonField<String> = responseId

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    /**
     * Returns an immutable snapshot of all present JSON properties, including declared and
     * additional properties.
     *
     * Keys use their JSON names. Declared properties take precedence over additional properties
     * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
     * values are preserved.
     */
    fun _allProperties(): Map<String, JsonValue> =
        collectAllProperties(
            additionalProperties,
            "content_index" to this.contentIndex,
            "event_id" to this.eventId,
            "item_id" to this.itemId,
            "output_index" to this.outputIndex,
            "part" to this.part,
            "response_id" to this.responseId,
            "type" to this.type,
        )

    @JvmSynthetic
    internal fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    @JsonAnyGetter
    @ExcludeMissing
    private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [ResponseContentPartAddedEvent].
         *
         * The following fields are required:
         * ```java
         * .contentIndex()
         * .eventId()
         * .itemId()
         * .outputIndex()
         * .part()
         * .responseId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseContentPartAddedEvent]. */
    class Builder internal constructor() {

        private var contentIndex: JsonField<Long>? = null
        private var eventId: JsonField<String>? = null
        private var itemId: JsonField<String>? = null
        private var outputIndex: JsonField<Long>? = null
        private var part: JsonField<Part>? = null
        private var responseId: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("response.content_part.added")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseContentPartAddedEvent: ResponseContentPartAddedEvent) = apply {
            contentIndex = responseContentPartAddedEvent.contentIndex
            eventId = responseContentPartAddedEvent.eventId
            itemId = responseContentPartAddedEvent.itemId
            outputIndex = responseContentPartAddedEvent.outputIndex
            part = responseContentPartAddedEvent.part
            responseId = responseContentPartAddedEvent.responseId
            type = responseContentPartAddedEvent.type
            additionalProperties = responseContentPartAddedEvent.additionalProperties.toMutableMap()
        }

        /** The index of the content part in the item's content array. */
        fun contentIndex(contentIndex: Long) = contentIndex(JsonField.of(contentIndex))

        /**
         * Sets [Builder.contentIndex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contentIndex] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun contentIndex(contentIndex: JsonField<Long>) = apply { this.contentIndex = contentIndex }

        /** The unique ID of the server event. */
        fun eventId(eventId: String) = eventId(JsonField.of(eventId))

        /**
         * Sets [Builder.eventId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

        /** The ID of the item to which the content part was added. */
        fun itemId(itemId: String) = itemId(JsonField.of(itemId))

        /**
         * Sets [Builder.itemId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.itemId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun itemId(itemId: JsonField<String>) = apply { this.itemId = itemId }

        /** The index of the output item in the response. */
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

        /** The ID of the response. */
        fun responseId(responseId: String) = responseId(JsonField.of(responseId))

        /**
         * Sets [Builder.responseId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.responseId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun responseId(responseId: JsonField<String>) = apply { this.responseId = responseId }

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
         * .eventId()
         * .itemId()
         * .outputIndex()
         * .part()
         * .responseId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ResponseContentPartAddedEvent =
            ResponseContentPartAddedEvent(
                checkRequired("contentIndex", contentIndex),
                checkRequired("eventId", eventId),
                checkRequired("itemId", itemId),
                checkRequired("outputIndex", outputIndex),
                checkRequired("part", part),
                checkRequired("responseId", responseId),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): ResponseContentPartAddedEvent = apply {
        if (validated) {
            return@apply
        }

        contentIndexOrThrow()
        eventIdOrThrow()
        itemIdOrThrow()
        outputIndexOrThrow()
        partOrThrow().validate()
        responseIdOrThrow()
        typeOrThrow()
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
            (if (eventId.asKnown().isPresent) 1 else 0) +
            (if (itemId.asKnown().isPresent) 1 else 0) +
            (if (outputIndex.asKnown().isPresent) 1 else 0) +
            (part.asKnown().getOrNull()?.validity() ?: 0) +
            (if (responseId.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("response.content_part.added")) 1 else 0 }

    /** The content part that was added. */
    class Part
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val audio: JsonField<String>,
        private val text: JsonField<String>,
        private val transcript: JsonField<String>,
        private val type: JsonField<Type>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("audio") @ExcludeMissing audio: JsonField<String> = JsonMissing.of(),
            @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
            @JsonProperty("transcript")
            @ExcludeMissing
            transcript: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
        ) : this(audio, text, transcript, type, mutableMapOf())

        /**
         * Base64-encoded audio data (if type is "audio"). Returns empty if the JSON property is
         * missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun audio(): java.util.Optional<String> = audio.getOptional("audio")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun audioOrThrow(): String = audio.getRequired("audio")

        /**
         * The text content (if type is "text"). Returns empty if the JSON property is missing or
         * null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun text(): java.util.Optional<String> = text.getOptional("text")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun textOrThrow(): String = text.getRequired("text")

        /**
         * The transcript of the audio (if type is "audio"). Returns empty if the JSON property is
         * missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun transcript(): java.util.Optional<String> = transcript.getOptional("transcript")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun transcriptOrThrow(): String = transcript.getRequired("transcript")

        /**
         * The content type ("text", "audio"). Returns empty if the JSON property is missing or
         * null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun type(): java.util.Optional<Type> = type.getOptional("type")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun typeOrThrow(): Type = type.getRequired("type")

        /**
         * Returns the raw JSON value of [audio].
         *
         * Unlike [audio], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("audio") @ExcludeMissing fun _audio(): JsonField<String> = audio

        /**
         * Returns the raw JSON value of [text].
         *
         * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

        /**
         * Returns the raw JSON value of [transcript].
         *
         * Unlike [transcript], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("transcript")
        @ExcludeMissing
        fun _transcript(): JsonField<String> = transcript

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        /**
         * Returns an immutable snapshot of all present JSON properties, including declared and
         * additional properties.
         *
         * Keys use their JSON names. Declared properties take precedence over additional properties
         * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
         * values are preserved.
         */
        fun _allProperties(): Map<String, JsonValue> =
            collectAllProperties(
                additionalProperties,
                "audio" to this.audio,
                "text" to this.text,
                "transcript" to this.transcript,
                "type" to this.type,
            )

        @JvmSynthetic
        internal fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        @JsonAnyGetter
        @ExcludeMissing
        private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Part]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Part]. */
        class Builder internal constructor() {

            private var audio: JsonField<String> = JsonMissing.of()
            private var text: JsonField<String> = JsonMissing.of()
            private var transcript: JsonField<String> = JsonMissing.of()
            private var type: JsonField<Type> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(part: Part) = apply {
                audio = part.audio
                text = part.text
                transcript = part.transcript
                type = part.type
                additionalProperties = part.additionalProperties.toMutableMap()
            }

            /** Base64-encoded audio data (if type is "audio"). */
            fun audio(audio: String) = audio(JsonField.of(audio))

            /**
             * Sets [Builder.audio] to an arbitrary JSON value.
             *
             * You should usually call [Builder.audio] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun audio(audio: JsonField<String>) = apply { this.audio = audio }

            /** The text content (if type is "text"). */
            fun text(text: String) = text(JsonField.of(text))

            /**
             * Sets [Builder.text] to an arbitrary JSON value.
             *
             * You should usually call [Builder.text] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun text(text: JsonField<String>) = apply { this.text = text }

            /** The transcript of the audio (if type is "audio"). */
            fun transcript(transcript: String) = transcript(JsonField.of(transcript))

            /**
             * Sets [Builder.transcript] to an arbitrary JSON value.
             *
             * You should usually call [Builder.transcript] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun transcript(transcript: JsonField<String>) = apply { this.transcript = transcript }

            /** The content type ("text", "audio"). */
            fun type(type: Type) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<Type>) = apply { this.type = type }

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
             * Returns an immutable instance of [Part].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Part =
                Part(audio, text, transcript, type, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Part = apply {
            if (validated) {
                return@apply
            }

            audio()
            text()
            transcript()
            type().ifPresent { it.validate() }
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
            (if (audio.asKnown().isPresent) 1 else 0) +
                (if (text.asKnown().isPresent) 1 else 0) +
                (if (transcript.asKnown().isPresent) 1 else 0) +
                (type.asKnown().getOrNull()?.validity() ?: 0)

        /** The content type ("text", "audio"). */
        class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val TEXT = of("text")

                @JvmField val AUDIO = of("audio")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            @Deprecated("Use asString() for string values or _value() for raw JSON.")
            enum class Known {
                TEXT,
                AUDIO,
            }

            /**
             * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Type] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            @Deprecated("Use asString() for string values or _value() for raw JSON.")
            enum class Value {
                TEXT,
                AUDIO,
                /** An enum member indicating that [Type] was instantiated with an unknown value. */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            @Deprecated("Use asString() for string values or _value() for raw JSON.")
            fun value(): Value =
                when (this) {
                    TEXT -> Value.TEXT
                    AUDIO -> Value.AUDIO
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws OpenAIInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            @Deprecated("Use asString() for string values or _value() for raw JSON.")
            fun known(): Known =
                when (this) {
                    TEXT -> Known.TEXT
                    AUDIO -> Known.AUDIO
                    else -> throw OpenAIInvalidDataException("Unknown Type: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws OpenAIInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    OpenAIInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Type = apply {
                if (validated) {
                    return@apply
                }

                known()
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
            @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Type && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Part &&
                audio == other.audio &&
                text == other.text &&
                transcript == other.transcript &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(audio, text, transcript, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Part{audio=$audio, text=$text, transcript=$transcript, type=$type, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponseContentPartAddedEvent &&
            contentIndex == other.contentIndex &&
            eventId == other.eventId &&
            itemId == other.itemId &&
            outputIndex == other.outputIndex &&
            part == other.part &&
            responseId == other.responseId &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            contentIndex,
            eventId,
            itemId,
            outputIndex,
            part,
            responseId,
            type,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseContentPartAddedEvent{contentIndex=$contentIndex, eventId=$eventId, itemId=$itemId, outputIndex=$outputIndex, part=$part, responseId=$responseId, type=$type, additionalProperties=$additionalProperties}"
}
