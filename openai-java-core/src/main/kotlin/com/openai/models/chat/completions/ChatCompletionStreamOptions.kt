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
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

/** Options for streaming response. Only set this when you set `stream: true`. */
class ChatCompletionStreamOptions
private constructor(
    private val includeObfuscation: JsonField<Boolean>,
    private val includeUsage: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("include_obfuscation")
        @ExcludeMissing
        includeObfuscation: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("include_usage")
        @ExcludeMissing
        includeUsage: JsonField<Boolean> = JsonMissing.of(),
    ) : this(includeObfuscation, includeUsage, mutableMapOf())

    /**
     * When true, stream obfuscation will be enabled. Stream obfuscation adds random characters to
     * an `obfuscation` field on streaming delta events to normalize payload sizes as a mitigation
     * to certain side-channel attacks. These obfuscation fields are included by default, but add a
     * small amount of overhead to the data stream. You can set `include_obfuscation` to false to
     * optimize for bandwidth if you trust the network links between your application and the OpenAI
     * API.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun includeObfuscation(): Optional<Boolean> =
        includeObfuscation.getOptional("include_obfuscation")

    /**
     * If set, an additional chunk will be streamed before the `data: [DONE]` message. The `usage`
     * field on this chunk shows the token usage statistics for the entire request, and the
     * `choices` field will always be an empty array.
     *
     * All other chunks will also include a `usage` field, but with a null value. **NOTE:** If the
     * stream is interrupted, you may not receive the final usage chunk which contains the total
     * token usage for the request.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun includeUsage(): Optional<Boolean> = includeUsage.getOptional("include_usage")

    /**
     * Returns the raw JSON value of [includeObfuscation].
     *
     * Unlike [includeObfuscation], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("include_obfuscation")
    @ExcludeMissing
    fun _includeObfuscation(): JsonField<Boolean> = includeObfuscation

    /**
     * Returns the raw JSON value of [includeUsage].
     *
     * Unlike [includeUsage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("include_usage")
    @ExcludeMissing
    fun _includeUsage(): JsonField<Boolean> = includeUsage

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ChatCompletionStreamOptions].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ChatCompletionStreamOptions]. */
    class Builder internal constructor() {

        private var includeObfuscation: JsonField<Boolean> = JsonMissing.of()
        private var includeUsage: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletionStreamOptions: ChatCompletionStreamOptions) = apply {
            includeObfuscation = chatCompletionStreamOptions.includeObfuscation
            includeUsage = chatCompletionStreamOptions.includeUsage
            additionalProperties = chatCompletionStreamOptions.additionalProperties.toMutableMap()
        }

        /**
         * When true, stream obfuscation will be enabled. Stream obfuscation adds random characters
         * to an `obfuscation` field on streaming delta events to normalize payload sizes as a
         * mitigation to certain side-channel attacks. These obfuscation fields are included by
         * default, but add a small amount of overhead to the data stream. You can set
         * `include_obfuscation` to false to optimize for bandwidth if you trust the network links
         * between your application and the OpenAI API.
         */
        fun includeObfuscation(includeObfuscation: Boolean) =
            includeObfuscation(JsonField.of(includeObfuscation))

        /**
         * Sets [Builder.includeObfuscation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.includeObfuscation] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun includeObfuscation(includeObfuscation: JsonField<Boolean>) = apply {
            this.includeObfuscation = includeObfuscation
        }

        /**
         * If set, an additional chunk will be streamed before the `data: [DONE]` message. The
         * `usage` field on this chunk shows the token usage statistics for the entire request, and
         * the `choices` field will always be an empty array.
         *
         * All other chunks will also include a `usage` field, but with a null value. **NOTE:** If
         * the stream is interrupted, you may not receive the final usage chunk which contains the
         * total token usage for the request.
         */
        fun includeUsage(includeUsage: Boolean) = includeUsage(JsonField.of(includeUsage))

        /**
         * Sets [Builder.includeUsage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.includeUsage] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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

        /**
         * Returns an immutable instance of [ChatCompletionStreamOptions].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ChatCompletionStreamOptions =
            ChatCompletionStreamOptions(
                includeObfuscation,
                includeUsage,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ChatCompletionStreamOptions = apply {
        if (validated) {
            return@apply
        }

        includeObfuscation()
        includeUsage()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: OpenAIInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (includeObfuscation.asKnown().isPresent) 1 else 0) +
            (if (includeUsage.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ChatCompletionStreamOptions &&
            includeObfuscation == other.includeObfuscation &&
            includeUsage == other.includeUsage &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(includeObfuscation, includeUsage, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatCompletionStreamOptions{includeObfuscation=$includeObfuscation, includeUsage=$includeUsage, additionalProperties=$additionalProperties}"
}
