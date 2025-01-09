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

/**
 * This is returned when the chunking strategy is unknown. Typically, this is because the file was
 * indexed before the `chunking_strategy` concept was introduced in the API.
 */
@NoAutoDetect
class OtherFileChunkingStrategyObject
@JsonCreator
private constructor(
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** Always `other`. */
    fun type(): Type = type.getRequired("type")

    /** Always `other`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): OtherFileChunkingStrategyObject = apply {
        if (validated) {
            return@apply
        }

        type()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var type: JsonField<Type>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(otherFileChunkingStrategyObject: OtherFileChunkingStrategyObject) =
            apply {
                type = otherFileChunkingStrategyObject.type
                additionalProperties =
                    otherFileChunkingStrategyObject.additionalProperties.toMutableMap()
            }

        /** Always `other`. */
        fun type(type: Type) = type(JsonField.of(type))

        /** Always `other`. */
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

        fun build(): OtherFileChunkingStrategyObject =
            OtherFileChunkingStrategyObject(
                checkNotNull(type) { "`type` is required but was not set" },
                additionalProperties.toImmutable()
            )
    }

    class Type
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val OTHER = of("other")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            OTHER,
        }

        enum class Value {
            OTHER,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                OTHER -> Value.OTHER
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                OTHER -> Known.OTHER
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

        return /* spotless:off */ other is OtherFileChunkingStrategyObject && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "OtherFileChunkingStrategyObject{type=$type, additionalProperties=$additionalProperties}"
}
