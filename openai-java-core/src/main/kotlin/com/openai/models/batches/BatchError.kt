// File generated from our OpenAPI spec by Stainless.

package com.openai.models.batches

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class BatchError
private constructor(
    private val code: JsonField<String>,
    private val line: JsonField<Long>,
    private val message: JsonField<String>,
    private val param: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("code") @ExcludeMissing code: JsonField<String> = JsonMissing.of(),
        @JsonProperty("line") @ExcludeMissing line: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
        @JsonProperty("param") @ExcludeMissing param: JsonField<String> = JsonMissing.of(),
    ) : this(code, line, message, param, mutableMapOf())

    /**
     * An error code identifying the error type.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun code(): Optional<String> = Optional.ofNullable(code.getNullable("code"))

    /**
     * The line number of the input file where the error occurred, if applicable.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun line(): Optional<Long> = Optional.ofNullable(line.getNullable("line"))

    /**
     * A human-readable message providing more details about the error.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun message(): Optional<String> = Optional.ofNullable(message.getNullable("message"))

    /**
     * The name of the parameter that caused the error, if applicable.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun param(): Optional<String> = Optional.ofNullable(param.getNullable("param"))

    /**
     * Returns the raw JSON value of [code].
     *
     * Unlike [code], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<String> = code

    /**
     * Returns the raw JSON value of [line].
     *
     * Unlike [line], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("line") @ExcludeMissing fun _line(): JsonField<Long> = line

    /**
     * Returns the raw JSON value of [message].
     *
     * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

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

        /** Returns a mutable builder for constructing an instance of [BatchError]. */
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

        /**
         * Sets [Builder.code] to an arbitrary JSON value.
         *
         * You should usually call [Builder.code] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun code(code: JsonField<String>) = apply { this.code = code }

        /** The line number of the input file where the error occurred, if applicable. */
        fun line(line: Long?) = line(JsonField.ofNullable(line))

        /**
         * Alias for [Builder.line].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun line(line: Long) = line(line as Long?)

        /** Alias for calling [Builder.line] with `line.orElse(null)`. */
        fun line(line: Optional<Long>) = line(line.getOrNull())

        /**
         * Sets [Builder.line] to an arbitrary JSON value.
         *
         * You should usually call [Builder.line] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun line(line: JsonField<Long>) = apply { this.line = line }

        /** A human-readable message providing more details about the error. */
        fun message(message: String) = message(JsonField.of(message))

        /**
         * Sets [Builder.message] to an arbitrary JSON value.
         *
         * You should usually call [Builder.message] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun message(message: JsonField<String>) = apply { this.message = message }

        /** The name of the parameter that caused the error, if applicable. */
        fun param(param: String?) = param(JsonField.ofNullable(param))

        /** Alias for calling [Builder.param] with `param.orElse(null)`. */
        fun param(param: Optional<String>) = param(param.getOrNull())

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
         * Returns an immutable instance of [BatchError].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): BatchError =
            BatchError(code, line, message, param, additionalProperties.toMutableMap())
    }

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
            (if (line.asKnown().isPresent) 1 else 0) +
            (if (message.asKnown().isPresent) 1 else 0) +
            (if (param.asKnown().isPresent) 1 else 0)

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
