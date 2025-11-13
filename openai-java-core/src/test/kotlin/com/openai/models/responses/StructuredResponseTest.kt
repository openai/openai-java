package com.openai.models.responses

import com.openai.core.BOOLEAN
import com.openai.core.DOUBLE
import com.openai.core.DelegationReadTestCase
import com.openai.core.JSON_FIELD
import com.openai.core.JSON_VALUE
import com.openai.core.JsonField
import com.openai.core.LIST
import com.openai.core.MAP
import com.openai.core.OPTIONAL
import com.openai.core.STRING
import com.openai.core.X
import com.openai.core.checkAllDelegation
import com.openai.core.checkAllDelegatorReadFunctionsAreTested
import com.openai.core.checkOneDelegationRead
import com.openai.models.ChatModel
import com.openai.models.ResponsesModel
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.mockito.Mockito.mock
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.Mockito.`when`
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

/**
 * Unit tests for the [StructuredResponse] class (delegator) and its delegation of most functions to
 * a wrapped [Response] (delegate). The tests include confirmation of the following:
 * - All functions in the delegator correspond to a function in the delegate and _vice versa_.
 * - All functions in the delegator call their corresponding function in the delegate and only that
 *   function.
 * - A unit test exists for all functions.
 *
 * There are some exceptions to the above that are handled differently.
 */
internal class StructuredResponseTest {
    companion object {
        private val RESPONSES_MODEL = ResponsesModel.ofChat(ChatModel.GPT_4O)

        private val TOOL_CHOICE =
            Response.ToolChoice.ofFunction(ToolChoiceFunction.builder().name(STRING).build())
        // A reasoning item is probably the simplest one to create.
        private val OUTPUT_ITEM =
            ResponseOutputItem.ofReasoning(
                ResponseReasoningItem.builder()
                    .id(STRING)
                    .summary(listOf(ResponseReasoningItem.Summary.builder().text(STRING).build()))
                    .build()
            )

        // The list order follows the declaration order in `Response` for easier maintenance.
        @JvmStatic
        private fun delegationTestCases() =
            listOf(
                DelegationReadTestCase("id", STRING),
                DelegationReadTestCase("createdAt", DOUBLE),
                DelegationReadTestCase("error", OPTIONAL),
                DelegationReadTestCase("incompleteDetails", OPTIONAL),
                DelegationReadTestCase("instructions", OPTIONAL),
                DelegationReadTestCase("metadata", OPTIONAL),
                DelegationReadTestCase("model", RESPONSES_MODEL),
                DelegationReadTestCase("_object_", JSON_VALUE),
                // `output()` is a special case and has its own test function.
                DelegationReadTestCase("parallelToolCalls", BOOLEAN),
                DelegationReadTestCase("temperature", OPTIONAL),
                DelegationReadTestCase("toolChoice", TOOL_CHOICE),
                DelegationReadTestCase("tools", LIST),
                DelegationReadTestCase("topP", OPTIONAL),
                DelegationReadTestCase("maxToolCalls", OPTIONAL),
                DelegationReadTestCase("topLogprobs", OPTIONAL),
                DelegationReadTestCase("maxOutputTokens", OPTIONAL),
                DelegationReadTestCase("previousResponseId", OPTIONAL),
                DelegationReadTestCase("prompt", OPTIONAL),
                DelegationReadTestCase("promptCacheKey", OPTIONAL),
                DelegationReadTestCase("promptCacheRetention", OPTIONAL),
                DelegationReadTestCase("reasoning", OPTIONAL),
                DelegationReadTestCase("safetyIdentifier", OPTIONAL),
                DelegationReadTestCase("serviceTier", OPTIONAL),
                DelegationReadTestCase("status", OPTIONAL),
                DelegationReadTestCase("text", OPTIONAL),
                DelegationReadTestCase("truncation", OPTIONAL),
                DelegationReadTestCase("usage", OPTIONAL),
                DelegationReadTestCase("user", OPTIONAL),
                DelegationReadTestCase("_id", JSON_FIELD),
                DelegationReadTestCase("_createdAt", JSON_FIELD),
                DelegationReadTestCase("_error", JSON_FIELD),
                DelegationReadTestCase("_incompleteDetails", JSON_FIELD),
                DelegationReadTestCase("_instructions", JSON_FIELD),
                DelegationReadTestCase("_metadata", JSON_FIELD),
                DelegationReadTestCase("_model", JSON_FIELD),
                // `_output()` is a special case and has its own test function.
                DelegationReadTestCase("_parallelToolCalls", JSON_FIELD),
                DelegationReadTestCase("_temperature", JSON_FIELD),
                DelegationReadTestCase("_toolChoice", JSON_FIELD),
                DelegationReadTestCase("_tools", JSON_FIELD),
                DelegationReadTestCase("_topP", JSON_FIELD),
                DelegationReadTestCase("_maxToolCalls", JSON_FIELD),
                DelegationReadTestCase("_topLogprobs", JSON_FIELD),
                DelegationReadTestCase("_maxOutputTokens", JSON_FIELD),
                DelegationReadTestCase("_previousResponseId", JSON_FIELD),
                DelegationReadTestCase("_prompt", JSON_FIELD),
                DelegationReadTestCase("_promptCacheKey", JSON_FIELD),
                DelegationReadTestCase("_promptCacheRetention", JSON_FIELD),
                DelegationReadTestCase("_reasoning", JSON_FIELD),
                DelegationReadTestCase("_safetyIdentifier", JSON_FIELD),
                DelegationReadTestCase("_serviceTier", JSON_FIELD),
                DelegationReadTestCase("_status", JSON_FIELD),
                DelegationReadTestCase("_text", JSON_FIELD),
                DelegationReadTestCase("_truncation", JSON_FIELD),
                DelegationReadTestCase("_usage", JSON_FIELD),
                DelegationReadTestCase("_user", JSON_FIELD),
                DelegationReadTestCase("background", OPTIONAL),
                DelegationReadTestCase("_background", JSON_FIELD),
                DelegationReadTestCase("conversation", OPTIONAL),
                DelegationReadTestCase("_conversation", JSON_FIELD),
                DelegationReadTestCase("_additionalProperties", MAP),
                // `validate()` and `isValid()` (which calls `validate()`) are tested separately,
                // as they require special handling.
            )
    }

    // New instances of the `mockDelegate` and `delegator` are required for each test case (each
    // test case runs in its own instance of the test class).
    private val mockDelegate: Response = mock(Response::class.java)
    private val delegator = StructuredResponse<X>(X::class.java, mockDelegate)

    @Test
    fun allDelegateFunctionsExistInDelegator() {
        checkAllDelegation(mockDelegate::class, delegator::class, "toBuilder")
    }

    @Test
    fun allDelegatorFunctionsExistInDelegate() {
        checkAllDelegation(delegator::class, mockDelegate::class)
    }

    @Test
    fun allDelegatorFunctionsAreTested() {
        // There are exceptional test cases for some functions. Most other functions are part of the
        // list of those using the parameterized test. A few delegator functions do not delegate, so
        // no test function is necessary.
        checkAllDelegatorReadFunctionsAreTested(
            delegator::class,
            delegationTestCases(),
            exceptionalTestedFns = setOf("output", "_output", "validate", "isValid"),
            nonDelegatingFns = setOf("equals", "hashCode", "toString"),
        )
    }

    @ParameterizedTest
    @MethodSource("delegationTestCases")
    fun `delegation of functions in general`(testCase: DelegationReadTestCase) {
        checkOneDelegationRead(delegator, mockDelegate, testCase)
    }

    @Test
    fun `delegation of output`() {
        // Input and output are different types, so this test is an exceptional case.
        // `output()` (without an underscore) delegates to `_output()` (with an underscore)
        // indirectly via the `output` field initializer.
        val input = JsonField.of(listOf(OUTPUT_ITEM))
        `when`(mockDelegate._output()).thenReturn(input)
        val output = delegator.output() // Without an underscore.

        verify(mockDelegate, times(1))._output()
        verifyNoMoreInteractions(mockDelegate)

        assertThat(output[0].rawOutputItem).isEqualTo(OUTPUT_ITEM)
    }

    @Test
    fun `delegation of _output`() {
        // Input and output are different types, so this test is an exceptional case.
        // `_output()` delegates to `_output()` indirectly via the `output` field initializer.
        val input = JsonField.of(listOf(OUTPUT_ITEM))
        `when`(mockDelegate._output()).thenReturn(input)
        val output = delegator._output() // With an underscore.

        verify(mockDelegate, times(1))._output()
        verifyNoMoreInteractions(mockDelegate)

        assertThat(output.getRequired("_output")[0].rawOutputItem).isEqualTo(OUTPUT_ITEM)
    }

    @Test
    fun `delegation of validate`() {
        `when`(mockDelegate._output()).thenReturn(JsonField.of(listOf(OUTPUT_ITEM)))

        delegator.validate()

        // Delegator's `validate()` calls the delegate's `validate()`. Delegate's `_output()` is
        // called indirectly via the `output` field initializer.
        verify(mockDelegate, times(1))._output() // Indirect
        verify(mockDelegate, times(1)).validate()
        verifyNoMoreInteractions(mockDelegate)
    }

    @Test
    fun `delegation of isValid`() {
        // `isValid()` calls `validate()` which delegates to `validate()`, so the test is
        // more-or-less the same as for `validate()`.
        `when`(mockDelegate._output()).thenReturn(JsonField.of(listOf(OUTPUT_ITEM)))

        delegator.isValid()

        verify(mockDelegate, times(1))._output() // Indirect
        verify(mockDelegate, times(1)).validate()
        verifyNoMoreInteractions(mockDelegate)
    }
}
