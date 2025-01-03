// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.errors.OpenAIInvalidDataException

class RunStepInclude
@JsonCreator
private constructor(
    private val value: JsonField<String>,
) : Enum {

    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField
        val STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT =
            of("step_details.tool_calls[*].file_search.results[*].content")

        @JvmStatic fun of(value: String) = RunStepInclude(JsonField.of(value))
    }

    enum class Known {
        STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT,
    }

    enum class Value {
        STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT,
        _UNKNOWN,
    }

    fun value(): Value =
        when (this) {
            STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT ->
                Value.STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT
            else -> Value._UNKNOWN
        }

    fun known(): Known =
        when (this) {
            STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT ->
                Known.STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT
            else -> throw OpenAIInvalidDataException("Unknown RunStepInclude: $value")
        }

    fun asString(): String = _value().asStringOrThrow()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is RunStepInclude && value == other.value /* spotless:on */
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
