package com.openai.models.responses

import com.openai.core.DelegationReadTestCase
import com.openai.core.LIST
import com.openai.core.OPTIONAL
import com.openai.core.STRING
import com.openai.core.X
import com.openai.core.checkAllDelegation
import com.openai.core.checkAllDelegatorReadFunctionsAreTested
import com.openai.core.checkOneDelegationRead
import java.util.Optional
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
 * Unit tests for the [StructuredResponseOutputItem] class (delegator) and its delegation of most
 * functions to a wrapped [ResponseOutputItem] (delegate). The tests include confirmation of the
 * following:
 * - All functions in the delegator correspond to a function in the delegate and _vice versa_.
 * - All functions in the delegator call their corresponding function in the delegate and only that
 *   function.
 * - A unit test exists for all functions.
 *
 * There are some exceptions to the above that are handled differently.
 */
internal class StructuredResponseOutputItemTest {
    companion object {
        private val FILE_SEARCH_TOOL_CALL =
            ResponseFileSearchToolCall.builder()
                .id(STRING)
                .queries(LIST)
                .status(ResponseFileSearchToolCall.Status.COMPLETED)
                .build()
        private val FUNCTION_TOOL_CALL =
            ResponseFunctionToolCall.builder().arguments(STRING).callId(STRING).name(STRING).build()
        private val FUNCTION_WEB_SEARCH =
            ResponseFunctionWebSearch.builder()
                .id(STRING)
                .status(ResponseFunctionWebSearch.Status.COMPLETED)
                .build()
        private val COMPUTER_TOOL_CALL =
            ResponseComputerToolCall.builder()
                .id(STRING)
                .action(ResponseComputerToolCall.Action.ofWait())
                .callId(STRING)
                .pendingSafetyChecks(listOf())
                .status(ResponseComputerToolCall.Status.COMPLETED)
                .type(ResponseComputerToolCall.Type.COMPUTER_CALL)
                .build()
        private val REASONING_ITEM =
            ResponseReasoningItem.builder().id(STRING).summary(listOf()).build()
        private val MESSAGE =
            ResponseOutputMessage.builder()
                .id(STRING)
                .content(listOf())
                .status(ResponseOutputMessage.Status.COMPLETED)
                .build()

        // The list order follows the declaration order in `ResponseOutputItem` for easier
        // maintenance.
        @JvmStatic
        private fun delegationTestCases() =
            listOf(
                // `message()` is a special case and has its own test function.
                DelegationReadTestCase("fileSearchCall", OPTIONAL),
                DelegationReadTestCase("functionCall", OPTIONAL),
                DelegationReadTestCase("webSearchCall", OPTIONAL),
                DelegationReadTestCase("computerCall", OPTIONAL),
                DelegationReadTestCase("reasoning", OPTIONAL),
                // `isMessage()` is a special case and has its own test function.
                // For the Boolean functions, call each in turn with both `true` and `false` to
                // ensure that a return value is not hard-coded.
                DelegationReadTestCase("isFileSearchCall", true),
                DelegationReadTestCase("isFileSearchCall", false),
                DelegationReadTestCase("isFunctionCall", true),
                DelegationReadTestCase("isFunctionCall", false),
                DelegationReadTestCase("isWebSearchCall", true),
                DelegationReadTestCase("isWebSearchCall", false),
                DelegationReadTestCase("isComputerCall", true),
                DelegationReadTestCase("isComputerCall", false),
                DelegationReadTestCase("isReasoning", true),
                DelegationReadTestCase("isReasoning", false),
                // `asMessage()` is a special case and has its own test function.
                DelegationReadTestCase("asFileSearchCall", FILE_SEARCH_TOOL_CALL),
                DelegationReadTestCase("asFunctionCall", FUNCTION_TOOL_CALL),
                DelegationReadTestCase("asWebSearchCall", FUNCTION_WEB_SEARCH),
                DelegationReadTestCase("asComputerCall", COMPUTER_TOOL_CALL),
                DelegationReadTestCase("asReasoning", REASONING_ITEM),
                DelegationReadTestCase("_json", OPTIONAL),
            )
    }

    // New instances of the `mockDelegate` and `delegator` are required for each test case (each
    // test case runs in its own instance of the test class).
    private val mockDelegate: ResponseOutputItem = mock(ResponseOutputItem::class.java)
    private val delegator = StructuredResponseOutputItem<X>(X::class.java, mockDelegate)

    @Test
    fun allDelegateFunctionsExistInDelegator() {
        // `toBuilder()` is deliberately not implemented. `accept()` has a different signature.
        checkAllDelegation(mockDelegate::class, delegator::class, "toBuilder", "accept")
    }

    @Test
    fun allDelegatorFunctionsExistInDelegate() {
        // `accept()` has a different signature.
        checkAllDelegation(delegator::class, mockDelegate::class, "accept")
    }

    @Test
    fun allDelegatorFunctionsAreTested() {
        // There are exceptional test cases for some functions. Most other functions are part of the
        // list of those using the parameterized test. A few delegator functions do not delegate, so
        // no test function is necessary.
        checkAllDelegatorReadFunctionsAreTested(
            delegator::class,
            delegationTestCases(),
            exceptionalTestedFns =
                setOf("message", "asMessage", "isMessage", "validate", "isValid", "accept"),
            nonDelegatingFns = setOf("equals", "hashCode", "toString"),
        )
    }

    @ParameterizedTest
    @MethodSource("delegationTestCases")
    fun `delegation of functions in general`(testCase: DelegationReadTestCase) {
        checkOneDelegationRead(delegator, mockDelegate, testCase)
    }

    @Test
    fun `delegation of message`() {
        // Input and output are different types, so this test is an exceptional case.
        // The delegator's `message()` delegates to the delegate's `message()` indirectly via the
        // delegator's `message` field initializer.
        val input = Optional.of(MESSAGE)
        `when`(mockDelegate.message()).thenReturn(input)
        val output = delegator.message()

        verify(mockDelegate, times(1)).message()
        verifyNoMoreInteractions(mockDelegate)

        assertThat(output.get().rawMessage).isEqualTo(MESSAGE)
    }

    @Test
    fun `delegation of asMessage`() {
        // Delegation function names do not match, so this test is an exceptional case.
        // The delegator's `asMessage()` delegates to the delegate's `message()` (without the "as")
        // indirectly via the delegator's `message` field initializer.
        val input = Optional.of(MESSAGE)
        `when`(mockDelegate.message()).thenReturn(input)
        val output = delegator.asMessage()

        verify(mockDelegate, times(1)).message()
        verifyNoMoreInteractions(mockDelegate)

        assertThat(output.rawMessage).isEqualTo(MESSAGE)
    }

    @Test
    fun `delegation of isMessage`() {
        // Delegation function names do not match, so this test is an exceptional case.
        // The delegator's `isMessage()` delegates to the delegate's `message()` (without the "is")
        // indirectly via the delegator's `message` field initializer.
        val input = Optional.of(MESSAGE)
        `when`(mockDelegate.message()).thenReturn(input)
        val output = delegator.isMessage()

        verify(mockDelegate, times(1)).message()
        verifyNoMoreInteractions(mockDelegate)

        assertThat(output).isTrue
    }

    @Test
    fun `delegation of validate`() {
        `when`(mockDelegate.message()).thenReturn(Optional.of(MESSAGE))

        delegator.validate()

        // Delegator's `validate()` does not call delegate's `validate()`. `message()` is called
        // indirectly via the `message` field initializer.
        verify(mockDelegate, times(1)).message()
        verifyNoMoreInteractions(mockDelegate)
    }

    @Test
    fun `delegation of isValid`() {
        // `isValid` calls `validate()`, so the test is similar to that for `validate()`.
        `when`(mockDelegate.message()).thenReturn(Optional.of(MESSAGE))

        delegator.isValid()

        verify(mockDelegate, times(1)).message()
        verifyNoMoreInteractions(mockDelegate)
    }
}
