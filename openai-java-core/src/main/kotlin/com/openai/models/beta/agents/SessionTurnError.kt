// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** A customer-safe error describing why a session request failed. */
class SessionTurnError
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val code: JsonField<Code>,
    private val message: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("code") @ExcludeMissing code: JsonField<Code> = JsonMissing.of(),
        @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
    ) : this(code, message, mutableMapOf())

    /**
     * A stable, machine-readable failure category.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun code(): Code = code.getRequired("code")

    /**
     * A customer-safe explanation of the failure.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun message(): String = message.getRequired("message")

    /**
     * Returns the raw JSON value of [code].
     *
     * Unlike [code], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<Code> = code

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
         * Returns a mutable builder for constructing an instance of [SessionTurnError].
         *
         * The following fields are required:
         * ```java
         * .code()
         * .message()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SessionTurnError]. */
    class Builder internal constructor() {

        private var code: JsonField<Code>? = null
        private var message: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(sessionTurnError: SessionTurnError) = apply {
            code = sessionTurnError.code
            message = sessionTurnError.message
            additionalProperties = sessionTurnError.additionalProperties.toMutableMap()
        }

        /** A stable, machine-readable failure category. */
        fun code(code: Code) = code(JsonField.of(code))

        /**
         * Sets [Builder.code] to an arbitrary JSON value.
         *
         * You should usually call [Builder.code] with a well-typed [Code] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun code(code: JsonField<Code>) = apply { this.code = code }

        /** A customer-safe explanation of the failure. */
        fun message(message: String) = message(JsonField.of(message))

        /**
         * Sets [Builder.message] to an arbitrary JSON value.
         *
         * You should usually call [Builder.message] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun message(message: JsonField<String>) = apply { this.message = message }

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
         * Returns an immutable instance of [SessionTurnError].
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
        fun build(): SessionTurnError =
            SessionTurnError(
                checkRequired("code", code),
                checkRequired("message", message),
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
    fun validate(): SessionTurnError = apply {
        if (validated) {
            return@apply
        }

        code().validate()
        message()
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
        (code.asKnown().getOrNull()?.validity() ?: 0) + (if (message.asKnown().isPresent) 1 else 0)

    /** A stable, machine-readable failure category. */
    class Code @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            /** The request exceeds the model's context window. */
            @JvmField val CONTEXT_LENGTH_EXCEEDED = of("context_length_exceeded")

            /** The session has reached its usage budget. */
            @JvmField val SESSION_BUDGET_EXCEEDED = of("session_budget_exceeded")

            /** The organization has reached a usage, plan, or billing limit. */
            @JvmField val USAGE_LIMIT_EXCEEDED = of("usage_limit_exceeded")

            /** The request exceeds the available rate limit. */
            @JvmField val RATE_LIMIT_EXCEEDED = of("rate_limit_exceeded")

            /** The model service is temporarily overloaded. */
            @JvmField val SERVER_OVERLOADED = of("server_overloaded")

            /** The request was rejected by a safety policy. */
            @JvmField val CYBER_POLICY = of("cyber_policy")

            /** The request could not connect to the model service. */
            @JvmField val CONNECTION_FAILED = of("connection_failed")

            /** The model service encountered an unexpected error. */
            @JvmField val SERVER_ERROR = of("server_error")

            /** The API credentials are invalid or lack the required access. */
            @JvmField val AUTHENTICATION_ERROR = of("authentication_error")

            /** The request contains invalid input or configuration. */
            @JvmField val INVALID_REQUEST = of("invalid_request")

            /** The requested model or resource is unavailable. */
            @JvmField val RESOURCE_NOT_FOUND = of("resource_not_found")

            /** The request could not complete in its execution environment. */
            @JvmField val SANDBOX_ERROR = of("sandbox_error")

            /** The executor must be upgraded before it can run this turn. */
            @JvmField val EXECUTOR_VERSION_INCOMPATIBLE = of("executor_version_incompatible")

            /** The session cannot accept additional input while a request is running. */
            @JvmField val ACTIVE_TURN_NOT_STEERABLE = of("active_turn_not_steerable")

            /** The request timed out before the model service responded. */
            @JvmField val REQUEST_TIMEOUT = of("request_timeout")

            /** An unexpected internal error prevented the session request from completing. */
            @JvmField val INTERNAL_ERROR = of("internal_error")

            @JvmStatic fun of(value: String) = Code(JsonField.of(value))
        }

        /** An enum containing [Code]'s known values. */
        enum class Known {
            /** The request exceeds the model's context window. */
            CONTEXT_LENGTH_EXCEEDED,
            /** The session has reached its usage budget. */
            SESSION_BUDGET_EXCEEDED,
            /** The organization has reached a usage, plan, or billing limit. */
            USAGE_LIMIT_EXCEEDED,
            /** The request exceeds the available rate limit. */
            RATE_LIMIT_EXCEEDED,
            /** The model service is temporarily overloaded. */
            SERVER_OVERLOADED,
            /** The request was rejected by a safety policy. */
            CYBER_POLICY,
            /** The request could not connect to the model service. */
            CONNECTION_FAILED,
            /** The model service encountered an unexpected error. */
            SERVER_ERROR,
            /** The API credentials are invalid or lack the required access. */
            AUTHENTICATION_ERROR,
            /** The request contains invalid input or configuration. */
            INVALID_REQUEST,
            /** The requested model or resource is unavailable. */
            RESOURCE_NOT_FOUND,
            /** The request could not complete in its execution environment. */
            SANDBOX_ERROR,
            /** The executor must be upgraded before it can run this turn. */
            EXECUTOR_VERSION_INCOMPATIBLE,
            /** The session cannot accept additional input while a request is running. */
            ACTIVE_TURN_NOT_STEERABLE,
            /** The request timed out before the model service responded. */
            REQUEST_TIMEOUT,
            /** An unexpected internal error prevented the session request from completing. */
            INTERNAL_ERROR,
        }

        /**
         * An enum containing [Code]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Code] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            /** The request exceeds the model's context window. */
            CONTEXT_LENGTH_EXCEEDED,
            /** The session has reached its usage budget. */
            SESSION_BUDGET_EXCEEDED,
            /** The organization has reached a usage, plan, or billing limit. */
            USAGE_LIMIT_EXCEEDED,
            /** The request exceeds the available rate limit. */
            RATE_LIMIT_EXCEEDED,
            /** The model service is temporarily overloaded. */
            SERVER_OVERLOADED,
            /** The request was rejected by a safety policy. */
            CYBER_POLICY,
            /** The request could not connect to the model service. */
            CONNECTION_FAILED,
            /** The model service encountered an unexpected error. */
            SERVER_ERROR,
            /** The API credentials are invalid or lack the required access. */
            AUTHENTICATION_ERROR,
            /** The request contains invalid input or configuration. */
            INVALID_REQUEST,
            /** The requested model or resource is unavailable. */
            RESOURCE_NOT_FOUND,
            /** The request could not complete in its execution environment. */
            SANDBOX_ERROR,
            /** The executor must be upgraded before it can run this turn. */
            EXECUTOR_VERSION_INCOMPATIBLE,
            /** The session cannot accept additional input while a request is running. */
            ACTIVE_TURN_NOT_STEERABLE,
            /** The request timed out before the model service responded. */
            REQUEST_TIMEOUT,
            /** An unexpected internal error prevented the session request from completing. */
            INTERNAL_ERROR,
            /** An enum member indicating that [Code] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                CONTEXT_LENGTH_EXCEEDED -> Value.CONTEXT_LENGTH_EXCEEDED
                SESSION_BUDGET_EXCEEDED -> Value.SESSION_BUDGET_EXCEEDED
                USAGE_LIMIT_EXCEEDED -> Value.USAGE_LIMIT_EXCEEDED
                RATE_LIMIT_EXCEEDED -> Value.RATE_LIMIT_EXCEEDED
                SERVER_OVERLOADED -> Value.SERVER_OVERLOADED
                CYBER_POLICY -> Value.CYBER_POLICY
                CONNECTION_FAILED -> Value.CONNECTION_FAILED
                SERVER_ERROR -> Value.SERVER_ERROR
                AUTHENTICATION_ERROR -> Value.AUTHENTICATION_ERROR
                INVALID_REQUEST -> Value.INVALID_REQUEST
                RESOURCE_NOT_FOUND -> Value.RESOURCE_NOT_FOUND
                SANDBOX_ERROR -> Value.SANDBOX_ERROR
                EXECUTOR_VERSION_INCOMPATIBLE -> Value.EXECUTOR_VERSION_INCOMPATIBLE
                ACTIVE_TURN_NOT_STEERABLE -> Value.ACTIVE_TURN_NOT_STEERABLE
                REQUEST_TIMEOUT -> Value.REQUEST_TIMEOUT
                INTERNAL_ERROR -> Value.INTERNAL_ERROR
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OpenAIInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                CONTEXT_LENGTH_EXCEEDED -> Known.CONTEXT_LENGTH_EXCEEDED
                SESSION_BUDGET_EXCEEDED -> Known.SESSION_BUDGET_EXCEEDED
                USAGE_LIMIT_EXCEEDED -> Known.USAGE_LIMIT_EXCEEDED
                RATE_LIMIT_EXCEEDED -> Known.RATE_LIMIT_EXCEEDED
                SERVER_OVERLOADED -> Known.SERVER_OVERLOADED
                CYBER_POLICY -> Known.CYBER_POLICY
                CONNECTION_FAILED -> Known.CONNECTION_FAILED
                SERVER_ERROR -> Known.SERVER_ERROR
                AUTHENTICATION_ERROR -> Known.AUTHENTICATION_ERROR
                INVALID_REQUEST -> Known.INVALID_REQUEST
                RESOURCE_NOT_FOUND -> Known.RESOURCE_NOT_FOUND
                SANDBOX_ERROR -> Known.SANDBOX_ERROR
                EXECUTOR_VERSION_INCOMPATIBLE -> Known.EXECUTOR_VERSION_INCOMPATIBLE
                ACTIVE_TURN_NOT_STEERABLE -> Known.ACTIVE_TURN_NOT_STEERABLE
                REQUEST_TIMEOUT -> Known.REQUEST_TIMEOUT
                INTERNAL_ERROR -> Known.INTERNAL_ERROR
                else -> throw OpenAIInvalidDataException("Unknown Code: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws OpenAIInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

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
        fun validate(): Code = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Code && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SessionTurnError &&
            code == other.code &&
            message == other.message &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(code, message, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SessionTurnError{code=$code, message=$message, additionalProperties=$additionalProperties}"
}
