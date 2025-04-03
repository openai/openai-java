// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.errors.OpenAIInvalidDataException

class RunStepInclude @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

    /**
     * Returns this class instance's raw value.
     *
     * This is usually only useful if this instance was deserialized from data that doesn't match
     * any known member, and you want to know that value. For example, if the SDK is on an older
     * version than the API, then the API may respond with new members that the SDK is unaware of.
     */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField
        val STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT =
            of("step_details.tool_calls[*].file_search.results[*].content")

        @JvmStatic fun of(value: String) = RunStepInclude(JsonField.of(value))
    }

    /** An enum containing [RunStepInclude]'s known values. */
    enum class Known {
        STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT
    }

    /**
     * An enum containing [RunStepInclude]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [RunStepInclude] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT,
        /**
         * An enum member indicating that [RunStepInclude] was instantiated with an unknown value.
         */
        _UNKNOWN,
    }

    /**
     * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN] if
     * the class was instantiated with an unknown value.
     *
     * Use the [known] method instead if you're certain the value is always known or if you want to
     * throw for the unknown case.
     */
    fun value(): Value =
        when (this) {
            STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT ->
                Value.STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT
            else -> Value._UNKNOWN
        }

    /**
     * Returns an enum member corresponding to this class instance's value.
     *
     * Use the [value] method instead if you're uncertain the value is always known and don't want
     * to throw for the unknown case.
     *
     * @throws OpenAIInvalidDataException if this class instance's value is a not a known member.
     */
    fun known(): Known =
        when (this) {
            STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT ->
                Known.STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT
            else -> throw OpenAIInvalidDataException("Unknown RunStepInclude: $value")
        }

    /**
     * Returns this class instance's primitive wire representation.
     *
     * This differs from the [toString] method because that method is primarily for debugging and
     * generally doesn't throw.
     *
     * @throws OpenAIInvalidDataException if this class instance's value does not have the expected
     *   primitive type.
     */
    fun asString(): String =
        _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

    private var validated: Boolean = false

    fun validate(): RunStepInclude = apply {
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is RunStepInclude && value == other.value /* spotless:on */
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
