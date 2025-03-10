// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import java.util.Objects
import java.util.Optional

/** Options for streaming response. Only set this when you set `stream: true`. */
@NoAutoDetect
class ChatCompletionStreamOptions
@JsonCreator
private constructor(
    @JsonProperty("include_usage")
    @ExcludeMissing
    private val includeUsage: JsonField<Boolean> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * If set, an additional chunk will be streamed before the `data: [DONE]` message. The `usage`
     * field on this chunk shows the token usage statistics for the entire request, and the
     * `choices` field will always be an empty array. All other chunks will also include a `usage`
     * field, but with a null value.
     */
    fun includeUsage(): Optional<Boolean> =
        Optional.ofNullable(includeUsage.getNullable("include_usage"))

    /**
     * If set, an additional chunk will be streamed before the `data: [DONE]` message. The `usage`
     * field on this chunk shows the token usage statistics for the entire request, and the
     * `choices` field will always be an empty array. All other chunks will also include a `usage`
     * field, but with a null value.
     */
    @JsonProperty("include_usage")
    @ExcludeMissing
    fun _includeUsage(): JsonField<Boolean> = includeUsage

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ChatCompletionStreamOptions = apply {
        if (validated) {
            return@apply
        }

        includeUsage()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ChatCompletionStreamOptions].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ChatCompletionStreamOptions]. */
    class Builder internal constructor() {

        private var includeUsage: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletionStreamOptions: ChatCompletionStreamOptions) = apply {
            includeUsage = chatCompletionStreamOptions.includeUsage
            additionalProperties = chatCompletionStreamOptions.additionalProperties.toMutableMap()
        }

        /**
         * If set, an additional chunk will be streamed before the `data: [DONE]` message. The
         * `usage` field on this chunk shows the token usage statistics for the entire request, and
         * the `choices` field will always be an empty array. All other chunks will also include a
         * `usage` field, but with a null value.
         */
        fun includeUsage(includeUsage: Boolean) = includeUsage(JsonField.of(includeUsage))

        /**
         * If set, an additional chunk will be streamed before the `data: [DONE]` message. The
         * `usage` field on this chunk shows the token usage statistics for the entire request, and
         * the `choices` field will always be an empty array. All other chunks will also include a
         * `usage` field, but with a null value.
         */
        fun includeUsage(includeUsage: JsonField<Boolean>) = apply {
            this.includeUsage = includeUsage
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

        fun build(): ChatCompletionStreamOptions =
            ChatCompletionStreamOptions(includeUsage, additionalProperties.toImmutable())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionStreamOptions && includeUsage == other.includeUsage && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(includeUsage, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatCompletionStreamOptions{includeUsage=$includeUsage, additionalProperties=$additionalProperties}"
}
