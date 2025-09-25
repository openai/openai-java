// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

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

class RealtimeMcpProtocolError
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val code: JsonField<Long>,
    private val message: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("code") @ExcludeMissing code: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(code, message, type, mutableMapOf())

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun code(): Long = code.getRequired("code")

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun message(): String = message.getRequired("message")

    /**
     * Expected to always return the following:
     * ```java
     * JsonValue.from("protocol_error")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [code].
     *
     * Unlike [code], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<Long> = code

    /**
     * Returns the raw JSON value of [message].
     *
     * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

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
         * Returns a mutable builder for constructing an instance of [RealtimeMcpProtocolError].
         *
         * The following fields are required:
         * ```java
         * .code()
         * .message()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RealtimeMcpProtocolError]. */
    class Builder internal constructor() {

        private var code: JsonField<Long>? = null
        private var message: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("protocol_error")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(realtimeMcpProtocolError: RealtimeMcpProtocolError) = apply {
            code = realtimeMcpProtocolError.code
            message = realtimeMcpProtocolError.message
            type = realtimeMcpProtocolError.type
            additionalProperties = realtimeMcpProtocolError.additionalProperties.toMutableMap()
        }

        fun code(code: Long) = code(JsonField.of(code))

        /**
         * Sets [Builder.code] to an arbitrary JSON value.
         *
         * You should usually call [Builder.code] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun code(code: JsonField<Long>) = apply { this.code = code }

        fun message(message: String) = message(JsonField.of(message))

        /**
         * Sets [Builder.message] to an arbitrary JSON value.
         *
         * You should usually call [Builder.message] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun message(message: JsonField<String>) = apply { this.message = message }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("protocol_error")
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
         * Returns an immutable instance of [RealtimeMcpProtocolError].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .code()
         * .message()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): RealtimeMcpProtocolError =
            RealtimeMcpProtocolError(
                checkRequired("code", code),
                checkRequired("message", message),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): RealtimeMcpProtocolError = apply {
        if (validated) {
            return@apply
        }

        code()
        message()
        _type().let {
            if (it != JsonValue.from("protocol_error")) {
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
        (if (code.asKnown().isPresent) 1 else 0) +
            (if (message.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("protocol_error")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeMcpProtocolError &&
            code == other.code &&
            message == other.message &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(code, message, type, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RealtimeMcpProtocolError{code=$code, message=$message, type=$type, additionalProperties=$additionalProperties}"
}
