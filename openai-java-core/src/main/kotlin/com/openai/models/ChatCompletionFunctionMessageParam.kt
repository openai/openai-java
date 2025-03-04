// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.checkRequired
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

@Deprecated("deprecated")
@NoAutoDetect
class ChatCompletionFunctionMessageParam
@JsonCreator
private constructor(
    @JsonProperty("content")
    @ExcludeMissing
    private val content: JsonField<String> = JsonMissing.of(),
    @JsonProperty("name") @ExcludeMissing private val name: JsonField<String> = JsonMissing.of(),
    @JsonProperty("role") @ExcludeMissing private val role: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The contents of the function message. */
    fun content(): Optional<String> = Optional.ofNullable(content.getNullable("content"))

    /** The name of the function to call. */
    fun name(): String = name.getRequired("name")

    /** The role of the messages author, in this case `function`. */
    @JsonProperty("role") @ExcludeMissing fun _role(): JsonValue = role

    /** The contents of the function message. */
    @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<String> = content

    /** The name of the function to call. */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ChatCompletionFunctionMessageParam = apply {
        if (validated) {
            return@apply
        }

        content()
        name()
        _role().let {
            if (it != JsonValue.from("function")) {
                throw OpenAIInvalidDataException("'role' is invalid, received $it")
            }
        }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [ChatCompletionFunctionMessageParam].
         *
         * The following fields are required:
         * ```java
         * .content()
         * .name()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ChatCompletionFunctionMessageParam]. */
    class Builder internal constructor() {

        private var content: JsonField<String>? = null
        private var name: JsonField<String>? = null
        private var role: JsonValue = JsonValue.from("function")
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
        fun role(role: JsonValue) = apply { this.role = role }

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
                checkRequired("content", content),
                checkRequired("name", name),
                role,
                additionalProperties.toImmutable(),
            )
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
