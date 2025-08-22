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
import com.openai.core.checkRequired
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects

/**
 * A custom grammar for the model to follow when generating text. Learn more in the
 * [custom grammars guide](https://platform.openai.com/docs/guides/custom-grammars).
 */
class ResponseFormatTextGrammar
private constructor(
    private val grammar: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("grammar") @ExcludeMissing grammar: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(grammar, type, mutableMapOf())

    /**
     * The custom grammar for the model to follow.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun grammar(): String = grammar.getRequired("grammar")

    /**
     * The type of response format being defined. Always `grammar`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("grammar")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [grammar].
     *
     * Unlike [grammar], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("grammar") @ExcludeMissing fun _grammar(): JsonField<String> = grammar

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
         * Returns a mutable builder for constructing an instance of [ResponseFormatTextGrammar].
         *
         * The following fields are required:
         * ```java
         * .grammar()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseFormatTextGrammar]. */
    class Builder internal constructor() {

        private var grammar: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("grammar")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseFormatTextGrammar: ResponseFormatTextGrammar) = apply {
            grammar = responseFormatTextGrammar.grammar
            type = responseFormatTextGrammar.type
            additionalProperties = responseFormatTextGrammar.additionalProperties.toMutableMap()
        }

        /** The custom grammar for the model to follow. */
        fun grammar(grammar: String) = grammar(JsonField.of(grammar))

        /**
         * Sets [Builder.grammar] to an arbitrary JSON value.
         *
         * You should usually call [Builder.grammar] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun grammar(grammar: JsonField<String>) = apply { this.grammar = grammar }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("grammar")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAlladditional_properties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAlladditional_properties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAlladditional_properties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [ResponseFormatTextGrammar].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .grammar()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ResponseFormatTextGrammar =
            ResponseFormatTextGrammar(
                checkRequired("grammar", grammar),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ResponseFormatTextGrammar = apply {
        if (validated) {
            return@apply
        }

        grammar()
        _type().let {
            if (it != JsonValue.from("grammar")) {
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
        (if (grammar.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("grammar")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponseFormatTextGrammar &&
            grammar == other.grammar &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(grammar, type, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseFormatTextGrammar{grammar=$grammar, type=$type, additionalProperties=$additionalProperties}"
}
