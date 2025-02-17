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
import com.openai.core.NoAutoDetect
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import java.util.Objects
import java.util.Optional

@NoAutoDetect
class BatchError
@JsonCreator
private constructor(
    @JsonProperty("code") @ExcludeMissing private val code: JsonField<String> = JsonMissing.of(),
    @JsonProperty("line") @ExcludeMissing private val line: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("message")
    @ExcludeMissing
    private val message: JsonField<String> = JsonMissing.of(),
    @JsonProperty("param") @ExcludeMissing private val param: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** An error code identifying the error type. */
    fun code(): Optional<String> = Optional.ofNullable(code.getNullable("code"))

    /** The line number of the input file where the error occurred, if applicable. */
    fun line(): Optional<Long> = Optional.ofNullable(line.getNullable("line"))

    /** A human-readable message providing more details about the error. */
    fun message(): Optional<String> = Optional.ofNullable(message.getNullable("message"))

    /** The name of the parameter that caused the error, if applicable. */
    fun param(): Optional<String> = Optional.ofNullable(param.getNullable("param"))

    /** An error code identifying the error type. */
    @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<String> = code

    /** The line number of the input file where the error occurred, if applicable. */
    @JsonProperty("line") @ExcludeMissing fun _line(): JsonField<Long> = line

    /** A human-readable message providing more details about the error. */
    @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

    /** The name of the parameter that caused the error, if applicable. */
    @JsonProperty("param") @ExcludeMissing fun _param(): JsonField<String> = param

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): BatchError = apply {
        if (validated) {
            return@apply
        }

        code()
        line()
        message()
        param()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BatchError]. */
    class Builder internal constructor() {

        private var code: JsonField<String> = JsonMissing.of()
        private var line: JsonField<Long> = JsonMissing.of()
        private var message: JsonField<String> = JsonMissing.of()
        private var param: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(batchError: BatchError) = apply {
            code = batchError.code
            line = batchError.line
            message = batchError.message
            param = batchError.param
            additionalProperties = batchError.additionalProperties.toMutableMap()
        }

        /** An error code identifying the error type. */
        fun code(code: String) = code(JsonField.of(code))

        /** An error code identifying the error type. */
        fun code(code: JsonField<String>) = apply { this.code = code }

        /** The line number of the input file where the error occurred, if applicable. */
        fun line(line: Long?) = line(JsonField.ofNullable(line))

        /** The line number of the input file where the error occurred, if applicable. */
        fun line(line: Long) = line(line as Long?)

        /** The line number of the input file where the error occurred, if applicable. */
        @Suppress("USELESS_CAST") // See https://youtrack.jetbrains.com/issue/KT-74228
        fun line(line: Optional<Long>) = line(line.orElse(null) as Long?)

        /** The line number of the input file where the error occurred, if applicable. */
        fun line(line: JsonField<Long>) = apply { this.line = line }

        /** A human-readable message providing more details about the error. */
        fun message(message: String) = message(JsonField.of(message))

        /** A human-readable message providing more details about the error. */
        fun message(message: JsonField<String>) = apply { this.message = message }

        /** The name of the parameter that caused the error, if applicable. */
        fun param(param: String?) = param(JsonField.ofNullable(param))

        /** The name of the parameter that caused the error, if applicable. */
        fun param(param: Optional<String>) = param(param.orElse(null))

        /** The name of the parameter that caused the error, if applicable. */
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

        fun build(): BatchError =
            BatchError(code, line, message, param, additionalProperties.toImmutable())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BatchError && code == other.code && line == other.line && message == other.message && param == other.param && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(code, line, message, param, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BatchError{code=$code, line=$line, message=$message, param=$param, additionalProperties=$additionalProperties}"
}
