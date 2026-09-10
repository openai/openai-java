// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

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

/**
 * Details of an error encountered by the Live session, including the affected parameter or client
 * command when available.
 */
class Error
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val code: JsonField<String>,
    private val message: JsonField<String>,
    private val type: JsonField<String>,
    private val clientEventId: JsonField<String>,
    private val param: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("code") @ExcludeMissing code: JsonField<String> = JsonMissing.of(),
        @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
        @JsonProperty("client_event_id")
        @ExcludeMissing
        clientEventId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("param") @ExcludeMissing param: JsonField<String> = JsonMissing.of(),
    ) : this(code, message, type, clientEventId, param, mutableMapOf())

    /**
     * A machine-readable code identifying the Live error, such as `unknown_parameter`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun code(): String = code.getRequired("code")

    /**
     * A human-readable explanation of the Live error.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun message(): String = message.getRequired("message")

    /**
     * The category of error, such as `invalid_request_error` for an invalid Live client command.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): String = type.getRequired("type")

    /**
     * The event_id of the client command that caused the error, when supplied.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun clientEventId(): Optional<String> = clientEventId.getOptional("client_event_id")

    /**
     * The parameter that caused the error, when applicable, such as `session.voice`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun param(): Optional<String> = param.getOptional("param")

    /**
     * Returns the raw JSON value of [code].
     *
     * Unlike [code], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<String> = code

    /**
     * Returns the raw JSON value of [message].
     *
     * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

    /**
     * Returns the raw JSON value of [clientEventId].
     *
     * Unlike [clientEventId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("client_event_id")
    @ExcludeMissing
    fun _clientEventId(): JsonField<String> = clientEventId

    /**
     * Returns the raw JSON value of [param].
     *
     * Unlike [param], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("param") @ExcludeMissing fun _param(): JsonField<String> = param

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
         * Returns a mutable builder for constructing an instance of [Error].
         *
         * The following fields are required:
         * ```java
         * .code()
         * .message()
         * .type()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Error]. */
    class Builder internal constructor() {

        private var code: JsonField<String>? = null
        private var message: JsonField<String>? = null
        private var type: JsonField<String>? = null
        private var clientEventId: JsonField<String> = JsonMissing.of()
        private var param: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(error: Error) = apply {
            code = error.code
            message = error.message
            type = error.type
            clientEventId = error.clientEventId
            param = error.param
            additionalProperties = error.additionalProperties.toMutableMap()
        }

        /** A machine-readable code identifying the Live error, such as `unknown_parameter`. */
        fun code(code: String) = code(JsonField.of(code))

        /**
         * Sets [Builder.code] to an arbitrary JSON value.
         *
         * You should usually call [Builder.code] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun code(code: JsonField<String>) = apply { this.code = code }

        /** A human-readable explanation of the Live error. */
        fun message(message: String) = message(JsonField.of(message))

        /**
         * Sets [Builder.message] to an arbitrary JSON value.
         *
         * You should usually call [Builder.message] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun message(message: JsonField<String>) = apply { this.message = message }

        /**
         * The category of error, such as `invalid_request_error` for an invalid Live client
         * command.
         */
        fun type(type: String) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<String>) = apply { this.type = type }

        /** The event_id of the client command that caused the error, when supplied. */
        fun clientEventId(clientEventId: String) = clientEventId(JsonField.of(clientEventId))

        /**
         * Sets [Builder.clientEventId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.clientEventId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun clientEventId(clientEventId: JsonField<String>) = apply {
            this.clientEventId = clientEventId
        }

        /** The parameter that caused the error, when applicable, such as `session.voice`. */
        fun param(param: String) = param(JsonField.of(param))

        /**
         * Sets [Builder.param] to an arbitrary JSON value.
         *
         * You should usually call [Builder.param] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun param(param: JsonField<String>) = apply { this.param = param }

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
         * Returns an immutable instance of [Error].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .code()
         * .message()
         * .type()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Error =
            Error(
                checkRequired("code", code),
                checkRequired("message", message),
                checkRequired("type", type),
                clientEventId,
                param,
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
    fun validate(): Error = apply {
        if (validated) {
            return@apply
        }

        code()
        message()
        type()
        clientEventId()
        param()
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
            (if (type.asKnown().isPresent) 1 else 0) +
            (if (clientEventId.asKnown().isPresent) 1 else 0) +
            (if (param.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Error &&
            code == other.code &&
            message == other.message &&
            type == other.type &&
            clientEventId == other.clientEventId &&
            param == other.param &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(code, message, type, clientEventId, param, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Error{code=$code, message=$message, type=$type, clientEventId=$clientEventId, param=$param, additionalProperties=$additionalProperties}"
}
