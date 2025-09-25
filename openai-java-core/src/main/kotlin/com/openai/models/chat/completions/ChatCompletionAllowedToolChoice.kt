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
import com.openai.core.checkRequired
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** Constrains the tools available to the model to a pre-defined set. */
class ChatCompletionAllowedToolChoice
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val allowedTools: JsonField<ChatCompletionAllowedTools>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("allowed_tools")
        @ExcludeMissing
        allowedTools: JsonField<ChatCompletionAllowedTools> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(allowedTools, type, mutableMapOf())

    /**
     * Constrains the tools available to the model to a pre-defined set.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun allowedTools(): ChatCompletionAllowedTools = allowedTools.getRequired("allowed_tools")

    /**
     * Allowed tool configuration type. Always `allowed_tools`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("allowed_tools")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [allowedTools].
     *
     * Unlike [allowedTools], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("allowed_tools")
    @ExcludeMissing
    fun _allowedTools(): JsonField<ChatCompletionAllowedTools> = allowedTools

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
         * Returns a mutable builder for constructing an instance of
         * [ChatCompletionAllowedToolChoice].
         *
         * The following fields are required:
         * ```java
         * .allowedTools()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ChatCompletionAllowedToolChoice]. */
    class Builder internal constructor() {

        private var allowedTools: JsonField<ChatCompletionAllowedTools>? = null
        private var type: JsonValue = JsonValue.from("allowed_tools")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletionAllowedToolChoice: ChatCompletionAllowedToolChoice) =
            apply {
                allowedTools = chatCompletionAllowedToolChoice.allowedTools
                type = chatCompletionAllowedToolChoice.type
                additionalProperties =
                    chatCompletionAllowedToolChoice.additionalProperties.toMutableMap()
            }

        /** Constrains the tools available to the model to a pre-defined set. */
        fun allowedTools(allowedTools: ChatCompletionAllowedTools) =
            allowedTools(JsonField.of(allowedTools))

        /**
         * Sets [Builder.allowedTools] to an arbitrary JSON value.
         *
         * You should usually call [Builder.allowedTools] with a well-typed
         * [ChatCompletionAllowedTools] value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun allowedTools(allowedTools: JsonField<ChatCompletionAllowedTools>) = apply {
            this.allowedTools = allowedTools
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("allowed_tools")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
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

        /**
         * Returns an immutable instance of [ChatCompletionAllowedToolChoice].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .allowedTools()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ChatCompletionAllowedToolChoice =
            ChatCompletionAllowedToolChoice(
                checkRequired("allowedTools", allowedTools),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ChatCompletionAllowedToolChoice = apply {
        if (validated) {
            return@apply
        }

        allowedTools().validate()
        _type().let {
            if (it != JsonValue.from("allowed_tools")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
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
        (allowedTools.asKnown().getOrNull()?.validity() ?: 0) +
            type.let { if (it == JsonValue.from("allowed_tools")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ChatCompletionAllowedToolChoice &&
            allowedTools == other.allowedTools &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(allowedTools, type, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatCompletionAllowedToolChoice{allowedTools=$allowedTools, type=$type, additionalProperties=$additionalProperties}"
}
