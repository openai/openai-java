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
    @JsonProperty("role") @ExcludeMissing private val role: JsonField<Role> = JsonMissing.of(),
    @JsonProperty("content")
    @ExcludeMissing
    private val content: JsonField<List<MessageContentDelta>> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The entity that produced the message. One of `user` or `assistant`. */
    fun role(): Optional<Role> = Optional.ofNullable(role.getNullable("role"))

    /** The content of the message in array of text and/or images. */
    fun content(): Optional<List<MessageContentDelta>> =
        Optional.ofNullable(content.getNullable("content"))

    /** The entity that produced the message. One of `user` or `assistant`. */
    @JsonProperty("role") @ExcludeMissing fun _role() = role

    /** The content of the message in array of text and/or images. */
    @JsonProperty("content") @ExcludeMissing fun _content() = content

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): MessageDelta = apply {
        if (!validated) {
            role()
            content()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var role: JsonField<Role> = JsonMissing.of()
        private var content: JsonField<List<MessageContentDelta>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(messageDelta: MessageDelta) = apply {
            role = messageDelta.role
            content = messageDelta.content
            additionalProperties = messageDelta.additionalProperties.toMutableMap()
        }

        /** The entity that produced the message. One of `user` or `assistant`. */
        fun role(role: Role) = role(JsonField.of(role))

        /** The entity that produced the message. One of `user` or `assistant`. */
        fun role(role: JsonField<Role>) = apply { this.role = role }

        /** The content of the message in array of text and/or images. */
        fun content(content: List<MessageContentDelta>) = content(JsonField.of(content))

        /** The content of the message in array of text and/or images. */
        fun content(content: JsonField<List<MessageContentDelta>>) = apply {
            this.content = content
        }

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
                role,
                content.map { it.toImmutable() },
                additionalProperties.toImmutable(),
            )
    }

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

        return /* spotless:off */ other is MessageDelta && role == other.role && content == other.content && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(role, content, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MessageDelta{role=$role, content=$content, additionalProperties=$additionalProperties}"
}
