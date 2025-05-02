package com.openai.models.chat.completions

import com.openai.core.JsonField
import com.openai.core.JsonValue
import com.openai.errors.OpenAIInvalidDataException
import java.util.Optional
import kotlin.reflect.KClass
import kotlin.reflect.KVisibility
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
        internal fun checkAllDelegation(
            delegateClass: KClass<*>,
            delegatorClass: KClass<*>,
            vararg exceptFunctionNames: String,
        ) {
            assertThat(delegateClass != delegatorClass)
                .describedAs { "Delegate and delegator classes should not be the same." }
                .isTrue

            val delegateFunctions = delegateClass.declaredFunctions

            for (delegateFunction in delegateFunctions) {
                if (delegateFunction.visibility != KVisibility.PUBLIC) {
                    // Non-public methods are just implementation details of each class.
                    continue
                }

                if (delegateFunction.name in exceptFunctionNames) {
                    // Ignore functions that are known exceptions (e.g., `toBuilder`).
                    continue
                }

                // Drop the first parameter from each function, as it is the implicit "this" object
                // and has the type of the class declaring the function, which will never match.
                val delegatorFunction =
                    delegatorClass.declaredFunctions.find {
                        it.name == delegateFunction.name &&
                            it.parameters.drop(1).map { it.type } ==
                                delegateFunction.parameters.drop(1).map { it.type }
                    }

                assertThat(delegatorFunction != null)
                    .describedAs {
                        "Function $delegateFunction is not found in ${delegatorClass.simpleName}."
                    }
                    .isTrue
            }
        }

        internal fun checkOneDelegationRead(
            delegator: Any,
            mockDelegate: Any,
            testCase: DelegationReadTestCase,
        ) {
            // Stub the method in the mock delegate using reflection
            val delegateMethod = mockDelegate::class.java.getMethod(testCase.functionName)
            `when`(delegateMethod.invoke(mockDelegate)).thenReturn(testCase.expectedValue)

            // Call the corresponding method on the delegator using reflection
            val delegatorMethod = delegator::class.java.getMethod(testCase.functionName)
            val result = delegatorMethod.invoke(delegator)

            // Verify that the corresponding method on the mock delegate was called exactly once
            verify(mockDelegate, times(1)).apply { delegateMethod.invoke(mockDelegate) }
            verifyNoMoreInteractions(mockDelegate)

            // Assert that the result matches the expected value
            assertThat(result).isEqualTo(testCase.expectedValue)
        }

        // Where a function returns `Optional<T>`, `JsonField<T>` or `JsonValue` There is no need to
        // provide a value that matches the type `<T>`, a simple `String` value of `"a-string"` will
        // work OK with the test. Constants have been provided for this purpose.
        internal const val STRING = "a-string"

        internal val OPTIONAL = Optional.of(STRING)
        internal val JSON_FIELD = JsonField.of(STRING)
        internal val JSON_VALUE = JsonValue.from(STRING)
        internal val MESSAGE =
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

        data class DelegationReadTestCase(val functionName: String, val expectedValue: Any)

        // The list order follows the declaration order in `StructuredChatCompletionMessage` for
        // easier maintenance.
        @JvmStatic
        fun delegationTestCases() =
            listOf(
                DelegationReadTestCase("id", STRING),
                // `choices()` is a special case and has its own test function.
                DelegationReadTestCase("created", 123L),
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
        fun choiceDelegationTestCases() =
            listOf(
                DelegationReadTestCase("finishReason", FINISH_REASON),
                DelegationReadTestCase("index", 123L),
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

        /** A basic class used as the generic type when testing. */
        internal class X(val s: String) {
            override fun equals(other: Any?) = other is X && other.s == s

            override fun hashCode() = s.hashCode()
        }
    }

    // New instances of the `mockDelegate` and `delegator` are required for each test case (each
    // test case runs in its own instance of the test class).
    val mockDelegate: ChatCompletion = mock(ChatCompletion::class.java)
    val delegator = StructuredChatCompletion<X>(X::class.java, mockDelegate)

    val mockChoiceDelegate: ChatCompletion.Choice = mock(ChatCompletion.Choice::class.java)
    val choiceDelegator = StructuredChatCompletion.Choice<X>(X::class.java, mockChoiceDelegate)

    @Test
    fun allChatCompletionDelegateFunctionsExistInDelegator() {
        checkAllDelegation(ChatCompletion::class, StructuredChatCompletion::class, "toBuilder")
    }

    @Test
    fun allChatCompletionDelegatorFunctionsExistInDelegate() {
        checkAllDelegation(StructuredChatCompletion::class, ChatCompletion::class)
    }

    @Test
    fun allChoiceDelegateFunctionsExistInDelegator() {
        checkAllDelegation(
            ChatCompletion.Choice::class,
            StructuredChatCompletion.Choice::class,
            "toBuilder",
        )
    }

    @Test
    fun allChoiceDelegatorFunctionsExistInDelegate() {
        checkAllDelegation(StructuredChatCompletion.Choice::class, ChatCompletion.Choice::class)
    }

    @Test
    fun allDelegatorFunctionsAreTested() {
        // There are exceptional test cases for some functions. Most other functions are part of the
        // list of those using the parameterized test.
        val exceptionalTestedFns = setOf("choices", "_choices", "validate", "isValid")
        val testedFns = delegationTestCases().map { it.functionName }.toSet() + exceptionalTestedFns
        // A few delegator functions do not delegate, so no test function is necessary.
        val nonDelegatingFns = listOf("equals", "hashCode", "toString")

        val delegatorFunctions = StructuredChatCompletion::class.declaredFunctions

        for (delegatorFunction in delegatorFunctions) {
            assertThat(
                    delegatorFunction.name in testedFns ||
                        delegatorFunction.name in nonDelegatingFns
                )
                .describedAs("Delegation is not tested for function '${delegatorFunction.name}.")
                .isTrue
        }
    }

    @Test
    fun allChoiceDelegatorFunctionsAreTested() {
        // There are exceptional test cases for some functions. Most other functions are part of the
        // list of those using the parameterized test.
        val exceptionalTestedFns = setOf("message", "_message", "validate", "isValid")
        val testedFns =
            choiceDelegationTestCases().map { it.functionName }.toSet() + exceptionalTestedFns
        // A few delegator functions do not delegate, so no test function is necessary.
        val nonDelegatingFns = listOf("equals", "hashCode", "toString")

        val delegatorFunctions = StructuredChatCompletion.Choice::class.declaredFunctions

        for (delegatorFunction in delegatorFunctions) {
            assertThat(
                    delegatorFunction.name in testedFns ||
                        delegatorFunction.name in nonDelegatingFns
                )
                .describedAs(
                    "Delegation is not tested for function 'Choice.${delegatorFunction.name}."
                )
                .isTrue
        }
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

        assertThat(output[0].choice).isEqualTo(CHOICE)
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

        assertThat(output.getRequired("_choices")[0].choice).isEqualTo(CHOICE)
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

        assertThat(output.chatCompletionMessage).isEqualTo(MESSAGE)
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

        assertThat(output.getRequired("_message").chatCompletionMessage).isEqualTo(MESSAGE)
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
