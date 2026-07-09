// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

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

/** A text input to the model. */
class BetaResponseInputTextContent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val text: JsonField<String>,
    private val type: JsonValue,
    private val promptCacheBreakpoint: JsonField<PromptCacheBreakpoint>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("prompt_cache_breakpoint")
        @ExcludeMissing
        promptCacheBreakpoint: JsonField<PromptCacheBreakpoint> = JsonMissing.of(),
    ) : this(text, type, promptCacheBreakpoint, mutableMapOf())

    /**
     * The text input to the model.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun text(): String = text.getRequired("text")

    /**
     * The type of the input item. Always `input_text`.
     *
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
    fun promptCacheBreakpoint(): Optional<PromptCacheBreakpoint> =
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
    fun _promptCacheBreakpoint(): JsonField<PromptCacheBreakpoint> = promptCacheBreakpoint

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
         * Returns a mutable builder for constructing an instance of [BetaResponseInputTextContent].
         *
         * The following fields are required:
         * ```java
         * .text()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BetaResponseInputTextContent]. */
    class Builder internal constructor() {

        private var text: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("input_text")
        private var promptCacheBreakpoint: JsonField<PromptCacheBreakpoint> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(betaResponseInputTextContent: BetaResponseInputTextContent) = apply {
            text = betaResponseInputTextContent.text
            type = betaResponseInputTextContent.type
            promptCacheBreakpoint = betaResponseInputTextContent.promptCacheBreakpoint
            additionalProperties = betaResponseInputTextContent.additionalProperties.toMutableMap()
        }

        /** The text input to the model. */
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
        fun promptCacheBreakpoint(promptCacheBreakpoint: PromptCacheBreakpoint?) =
            promptCacheBreakpoint(JsonField.ofNullable(promptCacheBreakpoint))

        /**
         * Alias for calling [Builder.promptCacheBreakpoint] with
         * `promptCacheBreakpoint.orElse(null)`.
         */
        fun promptCacheBreakpoint(promptCacheBreakpoint: Optional<PromptCacheBreakpoint>) =
            promptCacheBreakpoint(promptCacheBreakpoint.getOrNull())

        /**
         * Sets [Builder.promptCacheBreakpoint] to an arbitrary JSON value.
         *
         * You should usually call [Builder.promptCacheBreakpoint] with a well-typed
         * [PromptCacheBreakpoint] value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun promptCacheBreakpoint(promptCacheBreakpoint: JsonField<PromptCacheBreakpoint>) = apply {
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
         * Returns an immutable instance of [BetaResponseInputTextContent].
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
        fun build(): BetaResponseInputTextContent =
            BetaResponseInputTextContent(
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
    fun validate(): BetaResponseInputTextContent = apply {
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

    /**
     * Marks the exact end of a reusable prompt prefix. The breakpoint inherits its TTL from the
     * request's `prompt_cache_options.ttl`; the boundary is not rounded to a token block.
     */
    class PromptCacheBreakpoint
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val mode: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("mode") @ExcludeMissing mode: JsonValue = JsonMissing.of()
        ) : this(mode, mutableMapOf())

        /**
         * The breakpoint mode. Always `explicit`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("explicit")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("mode") @ExcludeMissing fun _mode(): JsonValue = mode

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
             * Returns a mutable builder for constructing an instance of [PromptCacheBreakpoint].
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [PromptCacheBreakpoint]. */
        class Builder internal constructor() {

            private var mode: JsonValue = JsonValue.from("explicit")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(promptCacheBreakpoint: PromptCacheBreakpoint) = apply {
                mode = promptCacheBreakpoint.mode
                additionalProperties = promptCacheBreakpoint.additionalProperties.toMutableMap()
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("explicit")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun mode(mode: JsonValue) = apply { this.mode = mode }

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
             * Returns an immutable instance of [PromptCacheBreakpoint].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): PromptCacheBreakpoint =
                PromptCacheBreakpoint(mode, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): PromptCacheBreakpoint = apply {
            if (validated) {
                return@apply
            }

            _mode().let {
                if (it != JsonValue.from("explicit")) {
                    throw OpenAIInvalidDataException("'mode' is invalid, received $it")
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int = mode.let { if (it == JsonValue.from("explicit")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is PromptCacheBreakpoint &&
                mode == other.mode &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(mode, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "PromptCacheBreakpoint{mode=$mode, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BetaResponseInputTextContent &&
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
        "BetaResponseInputTextContent{text=$text, type=$type, promptCacheBreakpoint=$promptCacheBreakpoint, additionalProperties=$additionalProperties}"
}
