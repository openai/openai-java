// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses.inputtokens

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.core.collectAllProperties
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects

class InputTokenCountResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val inputTokens: JsonField<Long>,
    private val object_: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("input_tokens")
        @ExcludeMissing
        inputTokens: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
    ) : this(inputTokens, object_, mutableMapOf())

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun inputTokens(): java.util.Optional<Long> = inputTokens.getOptional("input_tokens")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun inputTokensOrThrow(): Long = inputTokens.getRequired("input_tokens")

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun object_(): java.util.Optional<JsonValue> {
        val raw = object_
        return when {
            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
            !(raw == JsonValue.from("response.input_tokens")) ->
                throw OpenAIInvalidDataException("`object` is invalid")
            else -> java.util.Optional.of(raw)
        }
    }

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun object_OrThrow(): JsonValue = object_().orElseGet { object_.getRequired("object") }

    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<JsonValue> = object_

    /**
     * Returns the raw JSON value of [inputTokens].
     *
     * Unlike [inputTokens], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("input_tokens") @ExcludeMissing fun _inputTokens(): JsonField<Long> = inputTokens

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    /**
     * Returns an immutable snapshot of all present JSON properties, including declared and
     * additional properties.
     *
     * Keys use their JSON names. Declared properties take precedence over additional properties
     * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
     * values are preserved.
     */
    fun _allProperties(): Map<String, JsonValue> =
        collectAllProperties(
            additionalProperties,
            "input_tokens" to this.inputTokens,
            "object" to this.object_,
        )

    @JvmSynthetic
    internal fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    @JsonAnyGetter
    @ExcludeMissing
    private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [InputTokenCountResponse].
         *
         * The following fields are required:
         * ```java
         * .inputTokens()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InputTokenCountResponse]. */
    class Builder internal constructor() {

        private var inputTokens: JsonField<Long>? = null
        private var object_: JsonValue = JsonValue.from("response.input_tokens")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(inputTokenCountResponse: InputTokenCountResponse) = apply {
            inputTokens = inputTokenCountResponse.inputTokens
            object_ = inputTokenCountResponse.object_
            additionalProperties = inputTokenCountResponse.additionalProperties.toMutableMap()
        }

        fun inputTokens(inputTokens: Long) = inputTokens(JsonField.of(inputTokens))

        /**
         * Sets [Builder.inputTokens] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inputTokens] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun inputTokens(inputTokens: JsonField<Long>) = apply { this.inputTokens = inputTokens }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("response.input_tokens")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

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
         * Returns an immutable instance of [InputTokenCountResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .inputTokens()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): InputTokenCountResponse =
            InputTokenCountResponse(
                checkRequired("inputTokens", inputTokens),
                object_,
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
    fun validate(): InputTokenCountResponse = apply {
        if (validated) {
            return@apply
        }

        inputTokensOrThrow()
        object_OrThrow()
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
        (if (inputTokens.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("response.input_tokens")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InputTokenCountResponse &&
            inputTokens == other.inputTokens &&
            object_ == other.object_ &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(inputTokens, object_, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "InputTokenCountResponse{inputTokens=$inputTokens, object_=$object_, additionalProperties=$additionalProperties}"
}
