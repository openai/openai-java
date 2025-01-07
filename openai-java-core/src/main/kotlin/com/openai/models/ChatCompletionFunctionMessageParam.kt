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

@NoAutoDetect
class ChatCompletionFunctionMessageParam
@JsonCreator
private constructor(
    @JsonProperty("content")
    @ExcludeMissing
    private val content: JsonField<String> = JsonMissing.of(),
    @JsonProperty("name") @ExcludeMissing private val name: JsonField<String> = JsonMissing.of(),
    @JsonProperty("role") @ExcludeMissing private val role: JsonField<Role> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The contents of the function message. */
    fun content(): Optional<String> = Optional.ofNullable(content.getNullable("content"))

    /** The name of the function to call. */
    fun name(): String = name.getRequired("name")

    /** The role of the messages author, in this case `function`. */
    fun role(): Role = role.getRequired("role")

    /** The contents of the function message. */
    @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<String> = content

    /** The name of the function to call. */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /** The role of the messages author, in this case `function`. */
    @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<Role> = role

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ChatCompletionFunctionMessageParam = apply {
        if (!validated) {
            content()
            name()
            role()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var content: JsonField<String>? = null
        private var name: JsonField<String>? = null
        private var role: JsonField<Role>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletionFunctionMessageParam: ChatCompletionFunctionMessageParam) =
            apply {
                content = chatCompletionFunctionMessageParam.content
                name = chatCompletionFunctionMessageParam.name
                role = chatCompletionFunctionMessageParam.role
                additionalProperties =
                    chatCompletionFunctionMessageParam.additionalProperties.toMutableMap()
            }

        /** The contents of the function message. */
        fun content(content: String?) = content(JsonField.ofNullable(content))

        /** The contents of the function message. */
        fun content(content: Optional<String>) = content(content.orElse(null))

        /** The contents of the function message. */
        fun content(content: JsonField<String>) = apply { this.content = content }

        /** The name of the function to call. */
        fun name(name: String) = name(JsonField.of(name))

        /** The name of the function to call. */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** The role of the messages author, in this case `function`. */
        fun role(role: Role) = role(JsonField.of(role))

        /** The role of the messages author, in this case `function`. */
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

        fun build(): ChatCompletionFunctionMessageParam =
            ChatCompletionFunctionMessageParam(
                checkNotNull(content) { "`content` is required but was not set" },
                checkNotNull(name) { "`name` is required but was not set" },
                checkNotNull(role) { "`role` is required but was not set" },
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

            @JvmField val FUNCTION = of("function")

            @JvmStatic fun of(value: String) = Role(JsonField.of(value))
        }

        enum class Known {
            FUNCTION,
        }

        enum class Value {
            FUNCTION,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                FUNCTION -> Value.FUNCTION
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                FUNCTION -> Known.FUNCTION
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

        return /* spotless:off */ other is ChatCompletionFunctionMessageParam && content == other.content && name == other.name && role == other.role && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(content, name, role, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatCompletionFunctionMessageParam{content=$content, name=$name, role=$role, additionalProperties=$additionalProperties}"
}
