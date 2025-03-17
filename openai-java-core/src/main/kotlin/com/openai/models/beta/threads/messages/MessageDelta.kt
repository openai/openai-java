// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.checkKnown
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/** The delta containing the fields that have changed on the Message. */
@NoAutoDetect
class MessageDelta
@JsonCreator
private constructor(
    @JsonProperty("content")
    @ExcludeMissing
    private val content: JsonField<List<MessageContentDelta>> = JsonMissing.of(),
    @JsonProperty("role") @ExcludeMissing private val role: JsonField<Role> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * The content of the message in array of text and/or images.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun content(): Optional<List<MessageContentDelta>> =
        Optional.ofNullable(content.getNullable("content"))

    /**
     * The entity that produced the message. One of `user` or `assistant`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun role(): Optional<Role> = Optional.ofNullable(role.getNullable("role"))

    /**
     * Returns the raw JSON value of [content].
     *
     * Unlike [content], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("content")
    @ExcludeMissing
    fun _content(): JsonField<List<MessageContentDelta>> = content

    /**
     * Returns the raw JSON value of [role].
     *
     * Unlike [role], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<Role> = role

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): MessageDelta = apply {
        if (validated) {
            return@apply
        }

        content().ifPresent { it.forEach { it.validate() } }
        role()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /** Returns a mutable builder for constructing an instance of [MessageDelta]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MessageDelta]. */
    class Builder internal constructor() {

        private var content: JsonField<MutableList<MessageContentDelta>>? = null
        private var role: JsonField<Role> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(messageDelta: MessageDelta) = apply {
            content = messageDelta.content.map { it.toMutableList() }
            role = messageDelta.role
            additionalProperties = messageDelta.additionalProperties.toMutableMap()
        }

        /** The content of the message in array of text and/or images. */
        fun content(content: List<MessageContentDelta>) = content(JsonField.of(content))

        /**
         * Sets [Builder.content] to an arbitrary JSON value.
         *
         * You should usually call [Builder.content] with a well-typed `List<MessageContentDelta>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun content(content: JsonField<List<MessageContentDelta>>) = apply {
            this.content = content.map { it.toMutableList() }
        }

        /**
         * Adds a single [MessageContentDelta] to [Builder.content].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addContent(content: MessageContentDelta) = apply {
            this.content =
                (this.content ?: JsonField.of(mutableListOf())).also {
                    checkKnown("content", it).add(content)
                }
        }

        /** Alias for calling [addContent] with `MessageContentDelta.ofImageFile(imageFile)`. */
        fun addContent(imageFile: ImageFileDeltaBlock) =
            addContent(MessageContentDelta.ofImageFile(imageFile))

        /**
         * Alias for calling [addContent] with the following:
         * ```java
         * ImageFileDeltaBlock.builder()
         *     .index(index)
         *     .build()
         * ```
         */
        fun addImageFileContent(index: Long) =
            addContent(ImageFileDeltaBlock.builder().index(index).build())

        /** Alias for calling [addContent] with `MessageContentDelta.ofText(text)`. */
        fun addContent(text: TextDeltaBlock) = addContent(MessageContentDelta.ofText(text))

        /**
         * Alias for calling [addContent] with the following:
         * ```java
         * TextDeltaBlock.builder()
         *     .index(index)
         *     .build()
         * ```
         */
        fun addTextContent(index: Long) = addContent(TextDeltaBlock.builder().index(index).build())

        /** Alias for calling [addContent] with `MessageContentDelta.ofRefusal(refusal)`. */
        fun addContent(refusal: RefusalDeltaBlock) =
            addContent(MessageContentDelta.ofRefusal(refusal))

        /**
         * Alias for calling [addContent] with the following:
         * ```java
         * RefusalDeltaBlock.builder()
         *     .index(index)
         *     .build()
         * ```
         */
        fun addRefusalContent(index: Long) =
            addContent(RefusalDeltaBlock.builder().index(index).build())

        /** Alias for calling [addContent] with `MessageContentDelta.ofImageUrl(imageUrl)`. */
        fun addContent(imageUrl: ImageUrlDeltaBlock) =
            addContent(MessageContentDelta.ofImageUrl(imageUrl))

        /**
         * Alias for calling [addContent] with the following:
         * ```java
         * ImageUrlDeltaBlock.builder()
         *     .index(index)
         *     .build()
         * ```
         */
        fun addImageUrlContent(index: Long) =
            addContent(ImageUrlDeltaBlock.builder().index(index).build())

        /** The entity that produced the message. One of `user` or `assistant`. */
        fun role(role: Role) = role(JsonField.of(role))

        /**
         * Sets [Builder.role] to an arbitrary JSON value.
         *
         * You should usually call [Builder.role] with a well-typed [Role] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun role(role: JsonField<Role>) = apply { this.role = role }

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
         * Returns an immutable instance of [MessageDelta].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): MessageDelta =
            MessageDelta(
                (content ?: JsonMissing.of()).map { it.toImmutable() },
                role,
                additionalProperties.toImmutable(),
            )
    }

    /** The entity that produced the message. One of `user` or `assistant`. */
    class Role @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val USER = of("user")

            @JvmField val ASSISTANT = of("assistant")

            @JvmStatic fun of(value: String) = Role(JsonField.of(value))
        }

        /** An enum containing [Role]'s known values. */
        enum class Known {
            USER,
            ASSISTANT,
        }

        /**
         * An enum containing [Role]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Role] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            USER,
            ASSISTANT,
            /** An enum member indicating that [Role] was instantiated with an unknown value. */
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
                USER -> Value.USER
                ASSISTANT -> Value.ASSISTANT
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
                USER -> Known.USER
                ASSISTANT -> Known.ASSISTANT
                else -> throw OpenAIInvalidDataException("Unknown Role: $value")
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Role && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MessageDelta && content == other.content && role == other.role && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(content, role, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MessageDelta{content=$content, role=$role, additionalProperties=$additionalProperties}"
}
