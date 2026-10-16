// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.decisions

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
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class DecisionInputText
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val text: JsonField<String>,
    private val type: JsonValue,
    private val promptCacheBreakpoint: JsonField<DecisionPromptCacheBreakpoint>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("prompt_cache_breakpoint")
        @ExcludeMissing
        promptCacheBreakpoint: JsonField<DecisionPromptCacheBreakpoint> = JsonMissing.of(),
    ) : this(text, type, promptCacheBreakpoint, mutableMapOf())

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun text(): String = text.getRequired("text")

    /**
     * Expected to always return the following:
     * ```java
     * JsonValue.from("input_text")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Marks the exact end of a reusable prompt prefix. The breakpoint inherits its TTL from the
     * request's `prompt_cache_options.ttl`; the boundary is not rounded to a token block.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun promptCacheBreakpoint(): Optional<DecisionPromptCacheBreakpoint> =
        promptCacheBreakpoint.getOptional("prompt_cache_breakpoint")

    /**
     * Returns the raw JSON value of [text].
     *
     * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

    /**
     * Returns the raw JSON value of [promptCacheBreakpoint].
     *
     * Unlike [promptCacheBreakpoint], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("prompt_cache_breakpoint")
    @ExcludeMissing
    fun _promptCacheBreakpoint(): JsonField<DecisionPromptCacheBreakpoint> = promptCacheBreakpoint

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
         * Returns a mutable builder for constructing an instance of [DecisionInputText].
         *
         * The following fields are required:
         * ```java
         * .text()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DecisionInputText]. */
    class Builder internal constructor() {

        private var text: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("input_text")
        private var promptCacheBreakpoint: JsonField<DecisionPromptCacheBreakpoint> =
            JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(decisionInputText: DecisionInputText) = apply {
            text = decisionInputText.text
            type = decisionInputText.type
            promptCacheBreakpoint = decisionInputText.promptCacheBreakpoint
            additionalProperties = decisionInputText.additionalProperties.toMutableMap()
        }

        fun text(text: String) = text(JsonField.of(text))

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun text(text: JsonField<String>) = apply { this.text = text }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("input_text")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /**
         * Marks the exact end of a reusable prompt prefix. The breakpoint inherits its TTL from the
         * request's `prompt_cache_options.ttl`; the boundary is not rounded to a token block.
         */
        fun promptCacheBreakpoint(promptCacheBreakpoint: DecisionPromptCacheBreakpoint?) =
            promptCacheBreakpoint(JsonField.ofNullable(promptCacheBreakpoint))

        /**
         * Alias for calling [Builder.promptCacheBreakpoint] with
         * `promptCacheBreakpoint.orElse(null)`.
         */
        fun promptCacheBreakpoint(promptCacheBreakpoint: Optional<DecisionPromptCacheBreakpoint>) =
            promptCacheBreakpoint(promptCacheBreakpoint.getOrNull())

        /**
         * Sets [Builder.promptCacheBreakpoint] to an arbitrary JSON value.
         *
         * You should usually call [Builder.promptCacheBreakpoint] with a well-typed
         * [DecisionPromptCacheBreakpoint] value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun promptCacheBreakpoint(promptCacheBreakpoint: JsonField<DecisionPromptCacheBreakpoint>) =
            apply {
                this.promptCacheBreakpoint = promptCacheBreakpoint
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
         * Returns an immutable instance of [DecisionInputText].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .text()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): DecisionInputText =
            DecisionInputText(
                checkRequired("text", text),
                type,
                promptCacheBreakpoint,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): DecisionInputText = apply {
        if (validated) {
            return@apply
        }

        text()
        _type().let {
            if (it != JsonValue.from("input_text")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        promptCacheBreakpoint().ifPresent { it.validate() }
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
        (if (text.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("input_text")) 1 else 0 } +
            (promptCacheBreakpoint.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DecisionInputText &&
            text == other.text &&
            type == other.type &&
            promptCacheBreakpoint == other.promptCacheBreakpoint &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(text, type, promptCacheBreakpoint, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "DecisionInputText{text=$text, type=$type, promptCacheBreakpoint=$promptCacheBreakpoint, additionalProperties=$additionalProperties}"
}
