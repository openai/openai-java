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

@JsonDeserialize(builder = ChatCompletionContentPartRefusal.Builder::class)
@NoAutoDetect
class ChatCompletionContentPartRefusal
private constructor(
    private val type: JsonField<Type>,
    private val refusal: JsonField<String>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    /** The type of the content part. */
    fun type(): Type = type.getRequired("type")

    /** The refusal message generated by the model. */
    fun refusal(): String = refusal.getRequired("refusal")

    /** The type of the content part. */
    @JsonProperty("type") @ExcludeMissing fun _type() = type

    /** The refusal message generated by the model. */
    @JsonProperty("refusal") @ExcludeMissing fun _refusal() = refusal

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ChatCompletionContentPartRefusal = apply {
        if (!validated) {
            type()
            refusal()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var type: JsonField<Type> = JsonMissing.of()
        private var refusal: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletionContentPartRefusal: ChatCompletionContentPartRefusal) =
            apply {
                this.type = chatCompletionContentPartRefusal.type
                this.refusal = chatCompletionContentPartRefusal.refusal
                additionalProperties(chatCompletionContentPartRefusal.additionalProperties)
            }

        /** The type of the content part. */
        fun type(type: Type) = type(JsonField.of(type))

        /** The type of the content part. */
        @JsonProperty("type")
        @ExcludeMissing
        fun type(type: JsonField<Type>) = apply { this.type = type }

        /** The refusal message generated by the model. */
        fun refusal(refusal: String) = refusal(JsonField.of(refusal))

        /** The refusal message generated by the model. */
        @JsonProperty("refusal")
        @ExcludeMissing
        fun refusal(refusal: JsonField<String>) = apply { this.refusal = refusal }

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

        fun build(): ChatCompletionContentPartRefusal =
            ChatCompletionContentPartRefusal(
                type,
                refusal,
                additionalProperties.toImmutable(),
            )
    }

    class Type
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Type && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val REFUSAL = Type(JsonField.of("refusal"))

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            REFUSAL,
        }

        enum class Value {
            REFUSAL,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                REFUSAL -> Value.REFUSAL
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                REFUSAL -> Known.REFUSAL
                else -> throw OpenAIInvalidDataException("Unknown Type: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionContentPartRefusal && type == other.type && refusal == other.refusal && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(type, refusal, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatCompletionContentPartRefusal{type=$type, refusal=$refusal, additionalProperties=$additionalProperties}"
}
