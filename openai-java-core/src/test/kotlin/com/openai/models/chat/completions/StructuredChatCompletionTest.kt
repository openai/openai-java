package com.openai.models.chat.completions

import com.openai.core.DelegationReadTestCase
import com.openai.core.JSON_FIELD
import com.openai.core.JSON_VALUE
import com.openai.core.JsonField
import com.openai.core.LONG
import com.openai.core.OPTIONAL
import com.openai.core.STRING
import com.openai.core.X
import com.openai.core.checkAllDelegation
import com.openai.core.checkAllDelegatorReadFunctionsAreTested
import com.openai.core.checkOneDelegationRead
import com.openai.errors.OpenAIInvalidDataException
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
 * Unit tests for the [StructuredChatCompletion] class (delegator) and its delegation of most
 * functions to a wrapped [ChatCompletion] (delegate). The tests include confirmation of the
 * following:
 * - All functions in the delegator correspond to a function in the delegate and _vice versa_.
 * - All functions in the delegator call their corresponding function in the delegate and only that
 *   function.
 * - A unit test exists for all functions.
 *
 * There are some exceptions to the above that are handled differently.
 */
internal class StructuredChatCompletionTest {
    companion object {
        private val MESSAGE =
            ChatCompletionMessage.builder().content(STRING).refusal(STRING).build()
        private val FINISH_REASON = ChatCompletion.Choice.FinishReason.STOP
        private val CHOICE =
            ChatCompletion.Choice.builder()
                .message(MESSAGE)
                .index(0L)
                .finishReason(FINISH_REASON)
                .logprobs(
                    ChatCompletion.Choice.Logprobs.builder().content(null).refusal(null).build()
                )
                .build()

        // The list order follows the declaration order in `ChatCompletion` for easier maintenance.
        @JvmStatic
        private fun delegationTestCases() =
            listOf(
                DelegationReadTestCase("id", STRING),
                // `choices()` is a special case and has its own test function.
                DelegationReadTestCase("created", LONG),
                DelegationReadTestCase("model", STRING),
                DelegationReadTestCase("_object_", JSON_VALUE),
                DelegationReadTestCase("serviceTier", OPTIONAL),
                DelegationReadTestCase("systemFingerprint", OPTIONAL),
                DelegationReadTestCase("usage", OPTIONAL),
                DelegationReadTestCase("_id", JSON_FIELD),
                // `_choices()` is a special case and has its own test function.
                DelegationReadTestCase("_created", JSON_FIELD),
                DelegationReadTestCase("_model", JSON_FIELD),
                DelegationReadTestCase("_serviceTier", JSON_FIELD),
                DelegationReadTestCase("_systemFingerprint", JSON_FIELD),
                DelegationReadTestCase("_usage", JSON_FIELD),
                DelegationReadTestCase("_additionalProperties", mapOf("key" to JSON_VALUE)),
                // `validate()` and `isValid()` (which calls `validate()`) are tested separately,
                // as they require special handling.
            )

        @JvmStatic
        private fun choiceDelegationTestCases() =
            listOf(
                DelegationReadTestCase("finishReason", FINISH_REASON),
                DelegationReadTestCase("index", LONG),
                DelegationReadTestCase("logprobs", OPTIONAL),
                DelegationReadTestCase("_finishReason", JSON_FIELD),
                // `message()` is a special case and has its own test function.
                DelegationReadTestCase("_index", JSON_FIELD),
                DelegationReadTestCase("_logprobs", JSON_FIELD),
                // `_message()` is a special case and has its own test function.
                DelegationReadTestCase("_additionalProperties", mapOf("key" to JSON_VALUE)),
                // `validate()` and `isValid()` (which calls `validate()`) are tested separately,
                // as they require special handling.
            )
    }

    // New instances of the `mockDelegate` and `delegator` are required for each test case (each
    // test case runs in its own instance of the test class).
    private val mockDelegate: ChatCompletion = mock(ChatCompletion::class.java)
    private val delegator = StructuredChatCompletion<X>(X::class.java, mockDelegate)

    private val mockChoiceDelegate: ChatCompletion.Choice = mock(ChatCompletion.Choice::class.java)
    private val choiceDelegator =
        StructuredChatCompletion.Choice<X>(X::class.java, mockChoiceDelegate)

    @Test
    fun allChatCompletionDelegateFunctionsExistInDelegator() {
        checkAllDelegation(mockDelegate::class, delegator::class, "toBuilder")
    }

    @Test
    fun allChatCompletionDelegatorFunctionsExistInDelegate() {
        checkAllDelegation(delegator::class, mockDelegate::class)
    }

    @Test
    fun allChoiceDelegateFunctionsExistInDelegator() {
        checkAllDelegation(mockChoiceDelegate::class, choiceDelegator::class, "toBuilder")
    }

    @Test
    fun allChoiceDelegatorFunctionsExistInDelegate() {
        checkAllDelegation(choiceDelegator::class, mockChoiceDelegate::class)
    }

    @Test
    fun allDelegatorFunctionsAreTested() {
        // There are exceptional test cases for some functions. Most other functions are part of the
        // list of those using the parameterized test. A few delegator functions do not delegate, so
        // no test function is necessary.
        checkAllDelegatorReadFunctionsAreTested(
            delegator::class,
            delegationTestCases(),
            exceptionalTestedFns = setOf("choices", "_choices", "validate", "isValid"),
            nonDelegatingFns = setOf("equals", "hashCode", "toString"),
        )
    }

    @Test
    fun allChoiceDelegatorFunctionsAreTested() {
        checkAllDelegatorReadFunctionsAreTested(
            choiceDelegator::class,
            choiceDelegationTestCases(),
            exceptionalTestedFns = setOf("message", "_message", "validate", "isValid"),
            nonDelegatingFns = setOf("equals", "hashCode", "toString"),
        )
    }

    @ParameterizedTest
    @MethodSource("delegationTestCases")
    fun `delegation of functions in general`(testCase: DelegationReadTestCase) {
        checkOneDelegationRead(delegator, mockDelegate, testCase)
    }

    @ParameterizedTest
    @MethodSource("choiceDelegationTestCases")
    fun `delegation of Choice functions in general`(testCase: DelegationReadTestCase) {
        checkOneDelegationRead(choiceDelegator, mockChoiceDelegate, testCase)
    }

    @Test
    fun `delegation of choices`() {
        // Input and output are different types, so this test is an exceptional case.
        // `choices()` (without an underscore) delegates to `_choices()` (with an underscore)
        // indirectly via the `choices` field initializer.
        val input = JsonField.of(listOf(CHOICE))
        `when`(mockDelegate._choices()).thenReturn(input)
        val output = delegator.choices() // Without an underscore.

        verify(mockDelegate, times(1))._choices()
        verifyNoMoreInteractions(mockDelegate)

        assertThat(output[0].rawChoice).isEqualTo(CHOICE)
    }

    @Test
    fun `delegation of _choices`() {
        // Input and output are different types, so this test is an exceptional case.
        // `_choices()` delegates to `_choices()` indirectly via the `choices` field initializer.
        val input = JsonField.of(listOf(CHOICE))
        `when`(mockDelegate._choices()).thenReturn(input)
        val output = delegator._choices() // With an underscore.

        verify(mockDelegate, times(1))._choices()
        verifyNoMoreInteractions(mockDelegate)

        assertThat(output.getRequired("_choices")[0].rawChoice).isEqualTo(CHOICE)
    }

    @Test
    fun `delegation of validate`() {
        val input = JsonField.of(listOf(CHOICE))
        `when`(mockDelegate._choices()).thenReturn(input)
        val output = delegator.validate()

        // `validate()` calls `choices()` on the delegator which triggers the lazy initializer which
        // calls `_choices()` on the delegate before `validate()` also calls `validate()` on the
        // delegate.
        verify(mockDelegate, times(1))._choices()
        verify(mockDelegate, times(1)).validate()
        verifyNoMoreInteractions(mockDelegate)

        assertThat(output).isSameAs(delegator)
    }

    @Test
    fun `delegation of isValid when true`() {
        val input = JsonField.of(listOf(CHOICE))
        `when`(mockDelegate._choices()).thenReturn(input)
        val output = delegator.isValid()

        // `isValid()` calls `validate()`, which has side effects explained in its test function.
        verify(mockDelegate, times(1))._choices()
        verify(mockDelegate, times(1)).validate()
        verifyNoMoreInteractions(mockDelegate)

        assertThat(output).isTrue
    }

    @Test
    fun `delegation of isValid when false`() {
        // Try with a `false` value to make sure `isValid()` is not just hard-coded to `true`. Do
        // this by making `validate()` on the delegate throw an exception.
        val input = JsonField.of(listOf(CHOICE))
        `when`(mockDelegate._choices()).thenReturn(input)
        `when`(mockDelegate.validate()).thenThrow(OpenAIInvalidDataException("test"))
        val output = delegator.isValid()

        // `isValid()` calls `validate()`, which has side effects explained in its test function.
        verify(mockDelegate, times(1))._choices()
        verify(mockDelegate, times(1)).validate()
        verifyNoMoreInteractions(mockDelegate)

        assertThat(output).isFalse
    }

    @Test
    fun `delegation of Choice-message`() {
        // Input and output are different types, so this test is an exceptional case.
        // `message()` (without an underscore) delegates to `_message()` (with an underscore)
        // indirectly via the `message` field initializer.
        val input = JsonField.of(MESSAGE)
        `when`(mockChoiceDelegate._message()).thenReturn(input)
        val output = choiceDelegator.message() // Without an underscore.

        verify(mockChoiceDelegate, times(1))._message()
        verifyNoMoreInteractions(mockChoiceDelegate)

        assertThat(output.rawMessage).isEqualTo(MESSAGE)
    }

    @Test
    fun `delegation of Choice-_message`() {
        // Input and output are different types, so this test is an exceptional case.
        // `_message()` delegates to `_message()` indirectly via the `message` field initializer.
        val input = JsonField.of(MESSAGE)
        `when`(mockChoiceDelegate._message()).thenReturn(input)
        val output = choiceDelegator._message() // With an underscore.

        verify(mockChoiceDelegate, times(1))._message()
        verifyNoMoreInteractions(mockChoiceDelegate)

        assertThat(output.getRequired("_message").rawMessage).isEqualTo(MESSAGE)
    }

    @Test
    fun `delegation of Choice-validate`() {
        val input = JsonField.of(MESSAGE)
        `when`(mockChoiceDelegate._message()).thenReturn(input)
        val output = choiceDelegator.validate()

        // `validate()` calls `message()` on the delegator which triggers the lazy initializer which
        // calls `_message()` on the delegate before `validate()` also calls `validate()` on the
        // delegate.
        verify(mockChoiceDelegate, times(1))._message()
        verify(mockChoiceDelegate, times(1)).validate()
        verifyNoMoreInteractions(mockChoiceDelegate)

        assertThat(output).isSameAs(choiceDelegator)
    }

    @Test
    fun `delegation of Choice-isValid when true`() {
        val input = JsonField.of(MESSAGE)
        `when`(mockChoiceDelegate._message()).thenReturn(input)
        val output = choiceDelegator.isValid()

        // `isValid()` calls `validate()`, which has side effects explained in its test function.
        verify(mockChoiceDelegate, times(1))._message()
        verify(mockChoiceDelegate, times(1)).validate()
        verifyNoMoreInteractions(mockChoiceDelegate)

        assertThat(output).isTrue
    }

    @Test
    fun `delegation of Choice-isValid when false`() {
        // Try with a `false` value to make sure `isValid()` is not just hard-coded to `true`. Do
        // this by making `validate()` on the delegate throw an exception.
        val input = JsonField.of(MESSAGE)
        `when`(mockChoiceDelegate._message()).thenReturn(input)
        `when`(mockChoiceDelegate.validate()).thenThrow(OpenAIInvalidDataException("test"))
        val output = choiceDelegator.isValid()

        // `isValid()` calls `validate()`, which has side effects explained in its test function.
        verify(mockChoiceDelegate, times(1))._message()
        verify(mockChoiceDelegate, times(1)).validate()
        verifyNoMoreInteractions(mockChoiceDelegate)

        assertThat(output).isFalse
    }
}
