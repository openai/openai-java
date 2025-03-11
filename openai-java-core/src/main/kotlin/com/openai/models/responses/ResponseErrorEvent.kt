// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
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
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Emitted when an error occurs. */
@NoAutoDetect
class ResponseErrorEvent
@JsonCreator
private constructor(
    @JsonProperty("code") @ExcludeMissing private val code: JsonField<String> = JsonMissing.of(),
    @JsonProperty("message")
    @ExcludeMissing
    private val message: JsonField<String> = JsonMissing.of(),
    @JsonProperty("param") @ExcludeMissing private val param: JsonField<String> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The error code. */
    fun code(): Optional<String> = Optional.ofNullable(code.getNullable("code"))

    /** The error message. */
    fun message(): String = message.getRequired("message")

    /** The error parameter. */
    fun param(): Optional<String> = Optional.ofNullable(param.getNullable("param"))

    /** The type of the event. Always `error`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /** The error code. */
    @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<String> = code

    /** The error message. */
    @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

    /** The error parameter. */
    @JsonProperty("param") @ExcludeMissing fun _param(): JsonField<String> = param

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ResponseErrorEvent = apply {
        if (validated) {
            return@apply
        }

        code()
        message()
        param()
        _type().let {
            if (it != JsonValue.from("error")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ResponseErrorEvent].
         *
         * The following fields are required:
         * ```java
         * .code()
         * .message()
         * .param()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseErrorEvent]. */
    class Builder internal constructor() {

        private var code: JsonField<String>? = null
        private var message: JsonField<String>? = null
        private var param: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("error")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseErrorEvent: ResponseErrorEvent) = apply {
            code = responseErrorEvent.code
            message = responseErrorEvent.message
            param = responseErrorEvent.param
            type = responseErrorEvent.type
            additionalProperties = responseErrorEvent.additionalProperties.toMutableMap()
        }

        /** The error code. */
        fun code(code: String?) = code(JsonField.ofNullable(code))

        /** The error code. */
        fun code(code: Optional<String>) = code(code.getOrNull())

        /** The error code. */
        fun code(code: JsonField<String>) = apply { this.code = code }

        /** The error message. */
        fun message(message: String) = message(JsonField.of(message))

        /** The error message. */
        fun message(message: JsonField<String>) = apply { this.message = message }

        /** The error parameter. */
        fun param(param: String?) = param(JsonField.ofNullable(param))

        /** The error parameter. */
        fun param(param: Optional<String>) = param(param.getOrNull())

        /** The error parameter. */
        fun param(param: JsonField<String>) = apply { this.param = param }

        /** The type of the event. Always `error`. */
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

        fun build(): ResponseErrorEvent =
            ResponseErrorEvent(
                checkRequired("code", code),
                checkRequired("message", message),
                checkRequired("param", param),
                type,
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseErrorEvent && code == other.code && message == other.message && param == other.param && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(code, message, param, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseErrorEvent{code=$code, message=$message, param=$param, type=$type, additionalProperties=$additionalProperties}"
}
