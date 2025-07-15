// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.realtime

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class ConversationItemContent
private constructor(
    private val id: JsonField<String>,
    private val audio: JsonField<String>,
    private val text: JsonField<String>,
    private val transcript: JsonField<String>,
    private val type: JsonField<Type>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("audio") @ExcludeMissing audio: JsonField<String> = JsonMissing.of(),
        @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
        @JsonProperty("transcript")
        @ExcludeMissing
        transcript: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
    ) : this(id, audio, text, transcript, type, mutableMapOf())

    /**
     * ID of a previous conversation item to reference (for `item_reference` content types in
     * `response.create` events). These can reference both client and server created items.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun id(): Optional<String> = id.getOptional("id")

    /**
     * Base64-encoded audio bytes, used for `input_audio` content type.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun audio(): Optional<String> = audio.getOptional("audio")

    /**
     * The text content, used for `input_text` and `text` content types.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun text(): Optional<String> = text.getOptional("text")

    /**
     * The transcript of the audio, used for `input_audio` and `audio` content types.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun transcript(): Optional<String> = transcript.getOptional("transcript")

    /**
     * The content type (`input_text`, `input_audio`, `item_reference`, `text`, `audio`).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun type(): Optional<Type> = type.getOptional("type")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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
    @JsonProperty("transcript") @ExcludeMissing fun _transcript(): JsonField<String> = transcript

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

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /** Returns a mutable builder for constructing an instance of [ConversationItemContent]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ConversationItemContent]. */
    class Builder internal constructor() {

        private var id: JsonField<String> = JsonMissing.of()
        private var audio: JsonField<String> = JsonMissing.of()
        private var text: JsonField<String> = JsonMissing.of()
        private var transcript: JsonField<String> = JsonMissing.of()
        private var type: JsonField<Type> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(conversationItemContent: ConversationItemContent) = apply {
            id = conversationItemContent.id
            audio = conversationItemContent.audio
            text = conversationItemContent.text
            transcript = conversationItemContent.transcript
            type = conversationItemContent.type
            additionalProperties = conversationItemContent.additionalProperties.toMutableMap()
        }

        /**
         * ID of a previous conversation item to reference (for `item_reference` content types in
         * `response.create` events). These can reference both client and server created items.
         */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Base64-encoded audio bytes, used for `input_audio` content type. */
        fun audio(audio: String) = audio(JsonField.of(audio))

        /**
         * Sets [Builder.audio] to an arbitrary JSON value.
         *
         * You should usually call [Builder.audio] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun audio(audio: JsonField<String>) = apply { this.audio = audio }

        /** The text content, used for `input_text` and `text` content types. */
        fun text(text: String) = text(JsonField.of(text))

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun text(text: JsonField<String>) = apply { this.text = text }

        /** The transcript of the audio, used for `input_audio` and `audio` content types. */
        fun transcript(transcript: String) = transcript(JsonField.of(transcript))

        /**
         * Sets [Builder.transcript] to an arbitrary JSON value.
         *
         * You should usually call [Builder.transcript] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun transcript(transcript: JsonField<String>) = apply { this.transcript = transcript }

        /** The content type (`input_text`, `input_audio`, `item_reference`, `text`, `audio`). */
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [Type] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
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
         * Returns an immutable instance of [ConversationItemContent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ConversationItemContent =
            ConversationItemContent(
                id,
                audio,
                text,
                transcript,
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ConversationItemContent = apply {
        if (validated) {
            return@apply
        }

        id()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (audio.asKnown().isPresent) 1 else 0) +
            (if (text.asKnown().isPresent) 1 else 0) +
            (if (transcript.asKnown().isPresent) 1 else 0) +
            (type.asKnown().getOrNull()?.validity() ?: 0)

    /** The content type (`input_text`, `input_audio`, `item_reference`, `text`, `audio`). */
    class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val INPUT_TEXT = of("input_text")

            @JvmField val INPUT_AUDIO = of("input_audio")

            @JvmField val ITEM_REFERENCE = of("item_reference")

            @JvmField val TEXT = of("text")

            @JvmField val AUDIO = of("audio")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            INPUT_TEXT,
            INPUT_AUDIO,
            ITEM_REFERENCE,
            TEXT,
            AUDIO,
        }

        /**
         * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Type] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            INPUT_TEXT,
            INPUT_AUDIO,
            ITEM_REFERENCE,
            TEXT,
            AUDIO,
            /** An enum member indicating that [Type] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                INPUT_TEXT -> Value.INPUT_TEXT
                INPUT_AUDIO -> Value.INPUT_AUDIO
                ITEM_REFERENCE -> Value.ITEM_REFERENCE
                TEXT -> Value.TEXT
                AUDIO -> Value.AUDIO
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OpenAIInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                INPUT_TEXT -> Known.INPUT_TEXT
                INPUT_AUDIO -> Known.INPUT_AUDIO
                ITEM_REFERENCE -> Known.ITEM_REFERENCE
                TEXT -> Known.TEXT
                AUDIO -> Known.AUDIO
                else -> throw OpenAIInvalidDataException("Unknown Type: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws OpenAIInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

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

            return /* spotless:off */ other is Type && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ConversationItemContent && id == other.id && audio == other.audio && text == other.text && transcript == other.transcript && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, audio, text, transcript, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ConversationItemContent{id=$id, audio=$audio, text=$text, transcript=$transcript, type=$type, additionalProperties=$additionalProperties}"
}
