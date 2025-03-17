// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.checkRequired
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects

/** An error object returned when the model fails to generate a Response. */
@NoAutoDetect
class ResponseError
@JsonCreator
private constructor(
    @JsonProperty("code") @ExcludeMissing private val code: JsonField<Code> = JsonMissing.of(),
    @JsonProperty("message")
    @ExcludeMissing
    private val message: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * The error code for the response.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun code(): Code = code.getRequired("code")

    /**
     * A human-readable description of the error.
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

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ResponseError = apply {
        if (validated) {
            return@apply
        }

        code()
        message()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ResponseError].
         *
         * The following fields are required:
         * ```java
         * .code()
         * .message()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseError]. */
    class Builder internal constructor() {

        private var code: JsonField<Code>? = null
        private var message: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseError: ResponseError) = apply {
            code = responseError.code
            message = responseError.message
            additionalProperties = responseError.additionalProperties.toMutableMap()
        }

        /** The error code for the response. */
        fun code(code: Code) = code(JsonField.of(code))

        /**
         * Sets [Builder.code] to an arbitrary JSON value.
         *
         * You should usually call [Builder.code] with a well-typed [Code] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun code(code: JsonField<Code>) = apply { this.code = code }

        /** A human-readable description of the error. */
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
         * Returns an immutable instance of [ResponseError].
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
        fun build(): ResponseError =
            ResponseError(
                checkRequired("code", code),
                checkRequired("message", message),
                additionalProperties.toImmutable(),
            )
    }

    /** The error code for the response. */
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

            @JvmField val SERVER_ERROR = of("server_error")

            @JvmField val RATE_LIMIT_EXCEEDED = of("rate_limit_exceeded")

            @JvmField val INVALID_PROMPT = of("invalid_prompt")

            @JvmField val VECTOR_STORE_TIMEOUT = of("vector_store_timeout")

            @JvmField val INVALID_IMAGE = of("invalid_image")

            @JvmField val INVALID_IMAGE_FORMAT = of("invalid_image_format")

            @JvmField val INVALID_BASE64_IMAGE = of("invalid_base64_image")

            @JvmField val INVALID_IMAGE_URL = of("invalid_image_url")

            @JvmField val IMAGE_TOO_LARGE = of("image_too_large")

            @JvmField val IMAGE_TOO_SMALL = of("image_too_small")

            @JvmField val IMAGE_PARSE_ERROR = of("image_parse_error")

            @JvmField val IMAGE_CONTENT_POLICY_VIOLATION = of("image_content_policy_violation")

            @JvmField val INVALID_IMAGE_MODE = of("invalid_image_mode")

            @JvmField val IMAGE_FILE_TOO_LARGE = of("image_file_too_large")

            @JvmField val UNSUPPORTED_IMAGE_MEDIA_TYPE = of("unsupported_image_media_type")

            @JvmField val EMPTY_IMAGE_FILE = of("empty_image_file")

            @JvmField val FAILED_TO_DOWNLOAD_IMAGE = of("failed_to_download_image")

            @JvmField val IMAGE_FILE_NOT_FOUND = of("image_file_not_found")

            @JvmStatic fun of(value: String) = Code(JsonField.of(value))
        }

        /** An enum containing [Code]'s known values. */
        enum class Known {
            SERVER_ERROR,
            RATE_LIMIT_EXCEEDED,
            INVALID_PROMPT,
            VECTOR_STORE_TIMEOUT,
            INVALID_IMAGE,
            INVALID_IMAGE_FORMAT,
            INVALID_BASE64_IMAGE,
            INVALID_IMAGE_URL,
            IMAGE_TOO_LARGE,
            IMAGE_TOO_SMALL,
            IMAGE_PARSE_ERROR,
            IMAGE_CONTENT_POLICY_VIOLATION,
            INVALID_IMAGE_MODE,
            IMAGE_FILE_TOO_LARGE,
            UNSUPPORTED_IMAGE_MEDIA_TYPE,
            EMPTY_IMAGE_FILE,
            FAILED_TO_DOWNLOAD_IMAGE,
            IMAGE_FILE_NOT_FOUND,
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
            SERVER_ERROR,
            RATE_LIMIT_EXCEEDED,
            INVALID_PROMPT,
            VECTOR_STORE_TIMEOUT,
            INVALID_IMAGE,
            INVALID_IMAGE_FORMAT,
            INVALID_BASE64_IMAGE,
            INVALID_IMAGE_URL,
            IMAGE_TOO_LARGE,
            IMAGE_TOO_SMALL,
            IMAGE_PARSE_ERROR,
            IMAGE_CONTENT_POLICY_VIOLATION,
            INVALID_IMAGE_MODE,
            IMAGE_FILE_TOO_LARGE,
            UNSUPPORTED_IMAGE_MEDIA_TYPE,
            EMPTY_IMAGE_FILE,
            FAILED_TO_DOWNLOAD_IMAGE,
            IMAGE_FILE_NOT_FOUND,
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
                SERVER_ERROR -> Value.SERVER_ERROR
                RATE_LIMIT_EXCEEDED -> Value.RATE_LIMIT_EXCEEDED
                INVALID_PROMPT -> Value.INVALID_PROMPT
                VECTOR_STORE_TIMEOUT -> Value.VECTOR_STORE_TIMEOUT
                INVALID_IMAGE -> Value.INVALID_IMAGE
                INVALID_IMAGE_FORMAT -> Value.INVALID_IMAGE_FORMAT
                INVALID_BASE64_IMAGE -> Value.INVALID_BASE64_IMAGE
                INVALID_IMAGE_URL -> Value.INVALID_IMAGE_URL
                IMAGE_TOO_LARGE -> Value.IMAGE_TOO_LARGE
                IMAGE_TOO_SMALL -> Value.IMAGE_TOO_SMALL
                IMAGE_PARSE_ERROR -> Value.IMAGE_PARSE_ERROR
                IMAGE_CONTENT_POLICY_VIOLATION -> Value.IMAGE_CONTENT_POLICY_VIOLATION
                INVALID_IMAGE_MODE -> Value.INVALID_IMAGE_MODE
                IMAGE_FILE_TOO_LARGE -> Value.IMAGE_FILE_TOO_LARGE
                UNSUPPORTED_IMAGE_MEDIA_TYPE -> Value.UNSUPPORTED_IMAGE_MEDIA_TYPE
                EMPTY_IMAGE_FILE -> Value.EMPTY_IMAGE_FILE
                FAILED_TO_DOWNLOAD_IMAGE -> Value.FAILED_TO_DOWNLOAD_IMAGE
                IMAGE_FILE_NOT_FOUND -> Value.IMAGE_FILE_NOT_FOUND
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
                SERVER_ERROR -> Known.SERVER_ERROR
                RATE_LIMIT_EXCEEDED -> Known.RATE_LIMIT_EXCEEDED
                INVALID_PROMPT -> Known.INVALID_PROMPT
                VECTOR_STORE_TIMEOUT -> Known.VECTOR_STORE_TIMEOUT
                INVALID_IMAGE -> Known.INVALID_IMAGE
                INVALID_IMAGE_FORMAT -> Known.INVALID_IMAGE_FORMAT
                INVALID_BASE64_IMAGE -> Known.INVALID_BASE64_IMAGE
                INVALID_IMAGE_URL -> Known.INVALID_IMAGE_URL
                IMAGE_TOO_LARGE -> Known.IMAGE_TOO_LARGE
                IMAGE_TOO_SMALL -> Known.IMAGE_TOO_SMALL
                IMAGE_PARSE_ERROR -> Known.IMAGE_PARSE_ERROR
                IMAGE_CONTENT_POLICY_VIOLATION -> Known.IMAGE_CONTENT_POLICY_VIOLATION
                INVALID_IMAGE_MODE -> Known.INVALID_IMAGE_MODE
                IMAGE_FILE_TOO_LARGE -> Known.IMAGE_FILE_TOO_LARGE
                UNSUPPORTED_IMAGE_MEDIA_TYPE -> Known.UNSUPPORTED_IMAGE_MEDIA_TYPE
                EMPTY_IMAGE_FILE -> Known.EMPTY_IMAGE_FILE
                FAILED_TO_DOWNLOAD_IMAGE -> Known.FAILED_TO_DOWNLOAD_IMAGE
                IMAGE_FILE_NOT_FOUND -> Known.IMAGE_FILE_NOT_FOUND
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Code && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseError && code == other.code && message == other.message && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(code, message, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseError{code=$code, message=$message, additionalProperties=$additionalProperties}"
}
