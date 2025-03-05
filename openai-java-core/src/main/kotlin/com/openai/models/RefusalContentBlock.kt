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

/** The refusal content generated by the assistant. */
@NoAutoDetect
class RefusalContentBlock
@JsonCreator
private constructor(
    @JsonProperty("refusal")
    @ExcludeMissing
    private val refusal: JsonField<String> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun refusal(): String = refusal.getRequired("refusal")

    /** Always `refusal`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    @JsonProperty("refusal") @ExcludeMissing fun _refusal(): JsonField<String> = refusal

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): RefusalContentBlock = apply {
        if (validated) {
            return@apply
        }

        refusal()
        _type().let {
            if (it != JsonValue.from("refusal")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [RefusalContentBlock].
         *
         * The following fields are required:
         * ```java
         * .refusal()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RefusalContentBlock]. */
    class Builder internal constructor() {

        private var refusal: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("refusal")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(refusalContentBlock: RefusalContentBlock) = apply {
            refusal = refusalContentBlock.refusal
            type = refusalContentBlock.type
            additionalProperties = refusalContentBlock.additionalProperties.toMutableMap()
        }

        fun refusal(refusal: String) = refusal(JsonField.of(refusal))

        fun refusal(refusal: JsonField<String>) = apply { this.refusal = refusal }

        /** Always `refusal`. */
        fun type(type: JsonValue) = apply { this.type = type }

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

        fun build(): RefusalContentBlock =
            RefusalContentBlock(
                checkRequired("refusal", refusal),
                type,
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is RefusalContentBlock && refusal == other.refusal && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(refusal, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RefusalContentBlock{refusal=$refusal, type=$type, additionalProperties=$additionalProperties}"
}
