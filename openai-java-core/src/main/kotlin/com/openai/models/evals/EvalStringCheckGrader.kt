// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals

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

/**
 * A StringCheckGrader object that performs a string comparison between input and reference using a
 * specified operation.
 */
class EvalStringCheckGrader
private constructor(
    private val input: JsonField<String>,
    private val name: JsonField<String>,
    private val operation: JsonField<Operation>,
    private val reference: JsonField<String>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("input") @ExcludeMissing input: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("operation")
        @ExcludeMissing
        operation: JsonField<Operation> = JsonMissing.of(),
        @JsonProperty("reference") @ExcludeMissing reference: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(input, name, operation, reference, type, mutableMapOf())

    /**
     * The input text. This may include template strings.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun input(): String = input.getRequired("input")

    /**
     * The name of the grader.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * The string check operation to perform. One of `eq`, `ne`, `like`, or `ilike`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun operation(): Operation = operation.getRequired("operation")

    /**
     * The reference text. This may include template strings.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun reference(): String = reference.getRequired("reference")

    /**
     * The object type, which is always `string_check`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("string_check")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [input].
     *
     * Unlike [input], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("input") @ExcludeMissing fun _input(): JsonField<String> = input

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [operation].
     *
     * Unlike [operation], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("operation") @ExcludeMissing fun _operation(): JsonField<Operation> = operation

    /**
     * Returns the raw JSON value of [reference].
     *
     * Unlike [reference], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("reference") @ExcludeMissing fun _reference(): JsonField<String> = reference

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
         * Returns a mutable builder for constructing an instance of [EvalStringCheckGrader].
         *
         * The following fields are required:
         * ```java
         * .input()
         * .name()
         * .operation()
         * .reference()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [EvalStringCheckGrader]. */
    class Builder internal constructor() {

        private var input: JsonField<String>? = null
        private var name: JsonField<String>? = null
        private var operation: JsonField<Operation>? = null
        private var reference: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("string_check")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(evalStringCheckGrader: EvalStringCheckGrader) = apply {
            input = evalStringCheckGrader.input
            name = evalStringCheckGrader.name
            operation = evalStringCheckGrader.operation
            reference = evalStringCheckGrader.reference
            type = evalStringCheckGrader.type
            additionalProperties = evalStringCheckGrader.additionalProperties.toMutableMap()
        }

        /** The input text. This may include template strings. */
        fun input(input: String) = input(JsonField.of(input))

        /**
         * Sets [Builder.input] to an arbitrary JSON value.
         *
         * You should usually call [Builder.input] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun input(input: JsonField<String>) = apply { this.input = input }

        /** The name of the grader. */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** The string check operation to perform. One of `eq`, `ne`, `like`, or `ilike`. */
        fun operation(operation: Operation) = operation(JsonField.of(operation))

        /**
         * Sets [Builder.operation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.operation] with a well-typed [Operation] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun operation(operation: JsonField<Operation>) = apply { this.operation = operation }

        /** The reference text. This may include template strings. */
        fun reference(reference: String) = reference(JsonField.of(reference))

        /**
         * Sets [Builder.reference] to an arbitrary JSON value.
         *
         * You should usually call [Builder.reference] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun reference(reference: JsonField<String>) = apply { this.reference = reference }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("string_check")
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
         * Returns an immutable instance of [EvalStringCheckGrader].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .input()
         * .name()
         * .operation()
         * .reference()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): EvalStringCheckGrader =
            EvalStringCheckGrader(
                checkRequired("input", input),
                checkRequired("name", name),
                checkRequired("operation", operation),
                checkRequired("reference", reference),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): EvalStringCheckGrader = apply {
        if (validated) {
            return@apply
        }

        input()
        name()
        operation().validate()
        reference()
        _type().let {
            if (it != JsonValue.from("string_check")) {
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
        (if (input.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (operation.asKnown().getOrNull()?.validity() ?: 0) +
            (if (reference.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("string_check")) 1 else 0 }

    /** The string check operation to perform. One of `eq`, `ne`, `like`, or `ilike`. */
    class Operation @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val EQ = of("eq")

            @JvmField val NE = of("ne")

            @JvmField val LIKE = of("like")

            @JvmField val ILIKE = of("ilike")

            @JvmStatic fun of(value: String) = Operation(JsonField.of(value))
        }

        /** An enum containing [Operation]'s known values. */
        enum class Known {
            EQ,
            NE,
            LIKE,
            ILIKE,
        }

        /**
         * An enum containing [Operation]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Operation] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            EQ,
            NE,
            LIKE,
            ILIKE,
            /**
             * An enum member indicating that [Operation] was instantiated with an unknown value.
             */
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
                EQ -> Value.EQ
                NE -> Value.NE
                LIKE -> Value.LIKE
                ILIKE -> Value.ILIKE
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
                EQ -> Known.EQ
                NE -> Known.NE
                LIKE -> Known.LIKE
                ILIKE -> Known.ILIKE
                else -> throw OpenAIInvalidDataException("Unknown Operation: $value")
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

        fun validate(): Operation = apply {
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

            return /* spotless:off */ other is Operation && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is EvalStringCheckGrader && input == other.input && name == other.name && operation == other.operation && reference == other.reference && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(input, name, operation, reference, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "EvalStringCheckGrader{input=$input, name=$name, operation=$operation, reference=$reference, type=$type, additionalProperties=$additionalProperties}"
}
