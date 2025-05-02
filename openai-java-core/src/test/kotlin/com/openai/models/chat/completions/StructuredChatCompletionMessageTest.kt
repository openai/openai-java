package com.openai.models.chat.completions

import com.openai.core.JsonField
import com.openai.models.chat.completions.StructuredChatCompletionTest.Companion.DelegationReadTestCase
import com.openai.models.chat.completions.StructuredChatCompletionTest.Companion.JSON_FIELD
import com.openai.models.chat.completions.StructuredChatCompletionTest.Companion.JSON_VALUE
import com.openai.models.chat.completions.StructuredChatCompletionTest.Companion.MESSAGE
import com.openai.models.chat.completions.StructuredChatCompletionTest.Companion.OPTIONAL
import com.openai.models.chat.completions.StructuredChatCompletionTest.Companion.X
import com.openai.models.chat.completions.StructuredChatCompletionTest.Companion.checkOneDelegationRead
import java.util.Optional
import kotlin.reflect.full.declaredFunctions
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
        // The list order follows the declaration order in `StructuredChatCompletionMessage` for
        // easier maintenance. See `StructuredChatCompletionTest` for details on the values used.
        @JvmStatic
        fun delegationTestCases() =
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
    val mockDelegate: ChatCompletionMessage = mock(ChatCompletionMessage::class.java)
    val delegator = StructuredChatCompletionMessage<X>(X::class.java, mockDelegate)

    @Test
    fun allDelegateFunctionsExistInDelegator() {
        StructuredChatCompletionTest.checkAllDelegation(
            ChatCompletionMessage::class,
            StructuredChatCompletionMessage::class,
            "toBuilder",
            "toParam",
        )
    }

    @Test
    fun allDelegatorFunctionsExistInDelegate() {
        StructuredChatCompletionTest.checkAllDelegation(
            StructuredChatCompletionMessage::class,
            ChatCompletionMessage::class,
        )
    }

    @Test
    fun allDelegatorFunctionsAreTested() {
        // There are exceptional test cases for some functions. Most other functions are part of the
        // list of those using the parameterized test.
        val exceptionalTestedFns = setOf("content", "_content")
        val testedFns = delegationTestCases().map { it.functionName }.toSet() + exceptionalTestedFns
        // A few delegator functions do not delegate, so no test function is necessary.
        val nonDelegatingFns = listOf("equals", "hashCode", "toString")

        val delegatorFunctions = StructuredChatCompletionMessage::class.declaredFunctions

        for (delegatorFunction in delegatorFunctions) {
            assertThat(
                    delegatorFunction.name in testedFns ||
                        delegatorFunction.name in nonDelegatingFns
                )
                .describedAs("Delegation is not tested for function '${delegatorFunction.name}.")
                .isTrue
        }
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
