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

@NoAutoDetect
class StaticFileChunkingStrategyParam
@JsonCreator
private constructor(
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
    @JsonProperty("static")
    @ExcludeMissing
    private val static_: JsonField<StaticFileChunkingStrategy> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** Always `static`. */
    fun type(): Type = type.getRequired("type")

    fun static_(): StaticFileChunkingStrategy = static_.getRequired("static")

    /** Always `static`. */
    @JsonProperty("type") @ExcludeMissing fun _type() = type

    @JsonProperty("static") @ExcludeMissing fun _static_() = static_

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): StaticFileChunkingStrategyParam = apply {
        if (!validated) {
            type()
            static_().validate()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var type: JsonField<Type> = JsonMissing.of()
        private var static_: JsonField<StaticFileChunkingStrategy> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(staticFileChunkingStrategyParam: StaticFileChunkingStrategyParam) =
            apply {
                type = staticFileChunkingStrategyParam.type
                static_ = staticFileChunkingStrategyParam.static_
                additionalProperties =
                    staticFileChunkingStrategyParam.additionalProperties.toMutableMap()
            }

        /** Always `static`. */
        fun type(type: Type) = type(JsonField.of(type))

        /** Always `static`. */
        fun type(type: JsonField<Type>) = apply { this.type = type }

        fun static_(static_: StaticFileChunkingStrategy) = static_(JsonField.of(static_))

        fun static_(static_: JsonField<StaticFileChunkingStrategy>) = apply {
            this.static_ = static_
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

        fun build(): StaticFileChunkingStrategyParam =
            StaticFileChunkingStrategyParam(
                type,
                static_,
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

            @JvmField val STATIC = of("static")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            STATIC,
        }

        enum class Value {
            STATIC,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                STATIC -> Value.STATIC
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                STATIC -> Known.STATIC
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

        return /* spotless:off */ other is StaticFileChunkingStrategyParam && type == other.type && static_ == other.static_ && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(type, static_, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "StaticFileChunkingStrategyParam{type=$type, static_=$static_, additionalProperties=$additionalProperties}"
}
