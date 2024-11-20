// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

@JsonDeserialize(builder = ChatCompletionFunctionMessageParam.Builder::class)
@NoAutoDetect
class ChatCompletionFunctionMessageParam
private constructor(
    private val role: JsonField<Role>,
    private val content: JsonField<String>,
    private val name: JsonField<String>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    /** The role of the messages author, in this case `function`. */
    fun role(): Role = role.getRequired("role")

    /** The contents of the function message. */
    fun content(): Optional<String> = Optional.ofNullable(content.getNullable("content"))

    /** The name of the function to call. */
    fun name(): String = name.getRequired("name")

    /** The role of the messages author, in this case `function`. */
    @JsonProperty("role") @ExcludeMissing fun _role() = role

    /** The contents of the function message. */
    @JsonProperty("content") @ExcludeMissing fun _content() = content

    /** The name of the function to call. */
    @JsonProperty("name") @ExcludeMissing fun _name() = name

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ChatCompletionFunctionMessageParam = apply {
        if (!validated) {
            role()
            content()
            name()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var role: JsonField<Role> = JsonMissing.of()
        private var content: JsonField<String> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletionFunctionMessageParam: ChatCompletionFunctionMessageParam) =
            apply {
                this.role = chatCompletionFunctionMessageParam.role
                this.content = chatCompletionFunctionMessageParam.content
                this.name = chatCompletionFunctionMessageParam.name
                additionalProperties(chatCompletionFunctionMessageParam.additionalProperties)
            }

        /** The role of the messages author, in this case `function`. */
        fun role(role: Role) = role(JsonField.of(role))

        /** The role of the messages author, in this case `function`. */
        @JsonProperty("role")
        @ExcludeMissing
        fun role(role: JsonField<Role>) = apply { this.role = role }

        /** The contents of the function message. */
        fun content(content: String) = content(JsonField.of(content))

        /** The contents of the function message. */
        @JsonProperty("content")
        @ExcludeMissing
        fun content(content: JsonField<String>) = apply { this.content = content }

        /** The name of the function to call. */
        fun name(name: String) = name(JsonField.of(name))

        /** The name of the function to call. */
        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply { this.name = name }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            this.additionalProperties.putAll(additionalProperties)
        }

        @JsonAnySetter
        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            this.additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun build(): ChatCompletionFunctionMessageParam =
            ChatCompletionFunctionMessageParam(
                role,
                content,
                name,
                additionalProperties.toImmutable(),
            )
    }

    class Role
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Role && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val FUNCTION = Role(JsonField.of("function"))

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
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionFunctionMessageParam && role == other.role && content == other.content && name == other.name && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(role, content, name, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatCompletionFunctionMessageParam{role=$role, content=$content, name=$name, additionalProperties=$additionalProperties}"
}
