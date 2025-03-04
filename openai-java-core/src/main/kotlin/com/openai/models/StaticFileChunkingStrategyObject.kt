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

@NoAutoDetect
class StaticFileChunkingStrategyObject
@JsonCreator
private constructor(
    @JsonProperty("static")
    @ExcludeMissing
    private val static_: JsonField<StaticFileChunkingStrategy> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun static_(): StaticFileChunkingStrategy = static_.getRequired("static")

    /** Always `static`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    @JsonProperty("static")
    @ExcludeMissing
    fun _static_(): JsonField<StaticFileChunkingStrategy> = static_

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): StaticFileChunkingStrategyObject = apply {
        if (validated) {
            return@apply
        }

        static_().validate()
        _type().let {
            if (it != JsonValue.from("static")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [StaticFileChunkingStrategyObject].
         *
         * The following fields are required:
         * ```java
         * .static_()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [StaticFileChunkingStrategyObject]. */
    class Builder internal constructor() {

        private var static_: JsonField<StaticFileChunkingStrategy>? = null
        private var type: JsonValue = JsonValue.from("static")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(staticFileChunkingStrategyObject: StaticFileChunkingStrategyObject) =
            apply {
                static_ = staticFileChunkingStrategyObject.static_
                type = staticFileChunkingStrategyObject.type
                additionalProperties =
                    staticFileChunkingStrategyObject.additionalProperties.toMutableMap()
            }

        fun static_(static_: StaticFileChunkingStrategy) = static_(JsonField.of(static_))

        fun static_(static_: JsonField<StaticFileChunkingStrategy>) = apply {
            this.static_ = static_
        }

        /** Always `static`. */
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

        fun build(): StaticFileChunkingStrategyObject =
            StaticFileChunkingStrategyObject(
                checkRequired("static_", static_),
                type,
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is StaticFileChunkingStrategyObject && static_ == other.static_ && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(static_, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "StaticFileChunkingStrategyObject{static_=$static_, type=$type, additionalProperties=$additionalProperties}"
}
