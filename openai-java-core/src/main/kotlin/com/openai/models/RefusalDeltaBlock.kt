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

/** The refusal content that is part of a message. */
@NoAutoDetect
class RefusalDeltaBlock
@JsonCreator
private constructor(
    @JsonProperty("index") @ExcludeMissing private val index: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
    @JsonProperty("refusal")
    @ExcludeMissing
    private val refusal: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The index of the refusal part in the message. */
    fun index(): Long = index.getRequired("index")

    /** Always `refusal`. */
    fun type(): Type = type.getRequired("type")

    fun refusal(): Optional<String> = Optional.ofNullable(refusal.getNullable("refusal"))

    /** The index of the refusal part in the message. */
    @JsonProperty("index") @ExcludeMissing fun _index(): JsonField<Long> = index

    /** Always `refusal`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    @JsonProperty("refusal") @ExcludeMissing fun _refusal(): JsonField<String> = refusal

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): RefusalDeltaBlock = apply {
        if (validated) {
            return@apply
        }

        index()
        type()
        refusal()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var index: JsonField<Long>? = null
        private var type: JsonField<Type>? = null
        private var refusal: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(refusalDeltaBlock: RefusalDeltaBlock) = apply {
            index = refusalDeltaBlock.index
            type = refusalDeltaBlock.type
            refusal = refusalDeltaBlock.refusal
            additionalProperties = refusalDeltaBlock.additionalProperties.toMutableMap()
        }

        /** The index of the refusal part in the message. */
        fun index(index: Long) = index(JsonField.of(index))

        /** The index of the refusal part in the message. */
        fun index(index: JsonField<Long>) = apply { this.index = index }

        /** Always `refusal`. */
        fun type(type: Type) = type(JsonField.of(type))

        /** Always `refusal`. */
        fun type(type: JsonField<Type>) = apply { this.type = type }

        fun refusal(refusal: String) = refusal(JsonField.of(refusal))

        fun refusal(refusal: JsonField<String>) = apply { this.refusal = refusal }

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

        fun build(): RefusalDeltaBlock =
            RefusalDeltaBlock(
                checkNotNull(index) { "`index` is required but was not set" },
                checkNotNull(type) { "`type` is required but was not set" },
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

        companion object {

            @JvmField val REFUSAL = of("refusal")

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

        return /* spotless:off */ other is RefusalDeltaBlock && index == other.index && type == other.type && refusal == other.refusal && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(index, type, refusal, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RefusalDeltaBlock{index=$index, type=$type, refusal=$refusal, additionalProperties=$additionalProperties}"
}
