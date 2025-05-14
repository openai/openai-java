package com.openai.models.chat.completions

import com.openai.core.DelegationReadTestCase
import com.openai.core.JSON_FIELD
import com.openai.core.JSON_VALUE
import com.openai.core.JsonField
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
 * Unit tests for the [StructuredChatCompletionMessage] class (delegator) and its delegation of most
 * functions to a wrapped [ChatCompletionMessage] (delegate). The tests include confirmation of the
 * following:
 * - All functions in the delegator correspond to a function in the delegate and _vice versa_.
 * - All functions in the delegator call their corresponding function in the delegate and only that
 *   function.
 * - A unit test exists for all functions.
 *
 * There are some exceptions to the above that are handled differently.
 */
internal class StructuredChatCompletionMessageTest {
    companion object {
        private val MESSAGE =
            ChatCompletionMessage.builder().content(STRING).refusal(STRING).build()

        // The list order follows the declaration order in `ChatCompletionMessage` for easier
        // maintenance.
        @JvmStatic
        private fun delegationTestCases() =
            listOf(
                // `content()` is a special case and has its own test function.
                DelegationReadTestCase("refusal", OPTIONAL),
                DelegationReadTestCase("_role", JSON_VALUE),
                DelegationReadTestCase("annotations", OPTIONAL),
                DelegationReadTestCase("audio", OPTIONAL),
                DelegationReadTestCase("functionCall", OPTIONAL),
                DelegationReadTestCase("toolCalls", OPTIONAL),
                // `_content()` is a special case and has its own test function.
                DelegationReadTestCase("_refusal", JSON_FIELD),
                DelegationReadTestCase("_annotations", JSON_FIELD),
                DelegationReadTestCase("_audio", JSON_FIELD),
                DelegationReadTestCase("_functionCall", JSON_FIELD),
                DelegationReadTestCase("_toolCalls", JSON_FIELD),
                DelegationReadTestCase("_additionalProperties", mapOf("key" to JSON_VALUE)),
                DelegationReadTestCase("validate", MESSAGE),
                // For this boolean function, call with both possible values to ensure that any
                // hard-coding or default value will not result in a false positive test.
                DelegationReadTestCase("isValid", true),
                DelegationReadTestCase("isValid", false),
            )
    }

    // New instances of the `mockDelegate` and `delegator` are required for each test case (each
    // test case runs in its own instance of the test class).
    private val mockDelegate: ChatCompletionMessage = mock(ChatCompletionMessage::class.java)
    private val delegator = StructuredChatCompletionMessage<X>(X::class.java, mockDelegate)

    @Test
    fun allDelegateFunctionsExistInDelegator() {
        checkAllDelegation(mockDelegate::class, delegator::class, "toBuilder", "toParam")
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
            exceptionalTestedFns = setOf("content", "_content"),
            nonDelegatingFns = setOf("equals", "hashCode", "toString"),
        )
    }

    @ParameterizedTest
    @MethodSource("delegationTestCases")
    fun `delegation of functions in general`(testCase: DelegationReadTestCase) {
        checkOneDelegationRead(delegator, mockDelegate, testCase)
    }

    @Test
    fun `delegation of content`() {
        // Input and output are different types, so this test is an exceptional case.
        // `content()` (without an underscore) delegates to `_content()` (with an underscore)
        // indirectly via the `content` field initializer.
        val input = JsonField.of("{\"s\" : \"hello\"}")
        `when`(mockDelegate._content()).thenReturn(input)
        val output = delegator.content() // Without an underscore.

        verify(mockDelegate, times(1))._content()
        verifyNoMoreInteractions(mockDelegate)

        assertThat(output).isEqualTo(Optional.of(X("hello")))
    }

    @Test
    fun `delegation of _content`() {
        // Input and output are different types, so this test is an exceptional case.
        // `_content()` delegates to `_content()` indirectly via the `content` field initializer.
        val input = JsonField.of("{\"s\" : \"hello\"}")
        `when`(mockDelegate._content()).thenReturn(input)
        val output = delegator._content() // With an underscore.

        verify(mockDelegate, times(1))._content()
        verifyNoMoreInteractions(mockDelegate)

        assertThat(output).isEqualTo(JsonField.of(X("hello")))
    }
}
