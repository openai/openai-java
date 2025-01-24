// File generated from our OpenAPI spec by Stainless.

package com.openai.models

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

    /** The content of the message in array of text and/or images. */
    fun content(): Optional<List<MessageContentDelta>> =
        Optional.ofNullable(content.getNullable("content"))

    /** The entity that produced the message. One of `user` or `assistant`. */
    fun role(): Optional<Role> = Optional.ofNullable(role.getNullable("role"))

    /** The content of the message in array of text and/or images. */
    @JsonProperty("content")
    @ExcludeMissing
    fun _content(): JsonField<List<MessageContentDelta>> = content

    /** The entity that produced the message. One of `user` or `assistant`. */
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

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

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

        /** The content of the message in array of text and/or images. */
        fun content(content: JsonField<List<MessageContentDelta>>) = apply {
            this.content = content.map { it.toMutableList() }
        }

        /** The content of the message in array of text and/or images. */
        fun addContent(content: MessageContentDelta) = apply {
            this.content =
                (this.content ?: JsonField.of(mutableListOf())).apply {
                    asKnown()
                        .orElseThrow {
                            IllegalStateException(
                                "Field was set to non-list type: ${javaClass.simpleName}"
                            )
                        }
                        .add(content)
                }
        }

        /**
         * References an image [File](https://platform.openai.com/docs/api-reference/files) in the
         * content of a message.
         */
        fun addContent(imageFile: ImageFileDeltaBlock) =
            addContent(MessageContentDelta.ofImageFile(imageFile))

        /** The text content that is part of a message. */
        fun addContent(text: TextDeltaBlock) = addContent(MessageContentDelta.ofText(text))

        /** The refusal content that is part of a message. */
        fun addContent(refusal: RefusalDeltaBlock) =
            addContent(MessageContentDelta.ofRefusal(refusal))

        /** References an image URL in the content of a message. */
        fun addContent(imageUrl: ImageUrlDeltaBlock) =
            addContent(MessageContentDelta.ofImageUrl(imageUrl))

        /** The entity that produced the message. One of `user` or `assistant`. */
        fun role(role: Role) = role(JsonField.of(role))

        /** The entity that produced the message. One of `user` or `assistant`. */
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

        fun build(): MessageDelta =
            MessageDelta(
                (content ?: JsonMissing.of()).map { it.toImmutable() },
                role,
                additionalProperties.toImmutable(),
            )
    }

    /** The entity that produced the message. One of `user` or `assistant`. */
    class Role
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val USER = of("user")

            @JvmField val ASSISTANT = of("assistant")

            @JvmStatic fun of(value: String) = Role(JsonField.of(value))
        }

        enum class Known {
            USER,
            ASSISTANT,
        }

        enum class Value {
            USER,
            ASSISTANT,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                USER -> Value.USER
                ASSISTANT -> Value.ASSISTANT
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                USER -> Known.USER
                ASSISTANT -> Known.ASSISTANT
                else -> throw OpenAIInvalidDataException("Unknown Role: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

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
