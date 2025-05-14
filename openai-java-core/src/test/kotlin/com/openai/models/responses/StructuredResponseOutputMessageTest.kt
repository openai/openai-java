package com.openai.models.responses

import com.openai.core.DelegationReadTestCase
import com.openai.core.JSON_FIELD
import com.openai.core.JSON_VALUE
import com.openai.core.JsonField
import com.openai.core.JsonValue
import com.openai.core.MAP
import com.openai.core.OPTIONAL
import com.openai.core.STRING
import com.openai.core.X
import com.openai.core.checkAllDelegation
import com.openai.core.checkAllDelegatorReadFunctionsAreTested
import com.openai.core.checkOneDelegationRead
import com.openai.errors.OpenAIInvalidDataException
import java.util.Optional
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.mockito.Mockito.mock
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.Mockito.`when`
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

/**
 * Unit tests for the [StructuredResponseOutputMessage] class (delegator) and its delegation of most
 * functions to a wrapped [ResponseOutputMessage] (delegate). The tests include confirmation of the
 * following:
 * - All functions in the delegator correspond to a function in the delegate and _vice versa_.
 * - All functions in the delegator call their corresponding function in the delegate and only that
 *   function.
 * - A unit test exists for all functions.
 *
 * There are some exceptions to the above that are handled differently.
 */
internal class StructuredResponseOutputMessageTest {
    companion object {
        private val MESSAGE_STATUS = ResponseOutputMessage.Status.COMPLETED
        private val OUTPUT_TEXT =
            ResponseOutputText.builder().annotations(listOf()).text(STRING).build()
        private val OUTPUT_REFUSAL = ResponseOutputRefusal.builder().refusal(STRING).build()
        private val CONTENT = ResponseOutputMessage.Content.ofOutputText(OUTPUT_TEXT)

        // The list order follows the declaration order in `ResponseOutputMessage` for easier
        // maintenance.
        @JvmStatic
        private fun delegationTestCases() =
            listOf(
                DelegationReadTestCase("id", STRING),
                // `content()` is a special case and has its own test function.
                DelegationReadTestCase("_role", JSON_VALUE),
                DelegationReadTestCase("status", MESSAGE_STATUS),
                DelegationReadTestCase("_type", JSON_VALUE),
                DelegationReadTestCase("_id", JSON_FIELD),
                // `_content()` is a special case and has its own test function.
                DelegationReadTestCase("_status", JSON_FIELD),
                DelegationReadTestCase("_additionalProperties", MAP),
            )

        // The list order follows the declaration order in `ResponseOutputMessage.Content` for
        // easier maintenance.
        @JvmStatic
        private fun contentDelegationTestCases() =
            listOf(
                // `outputText()` is a special case and has its own test function.
                DelegationReadTestCase("refusal", OPTIONAL),
                // For the Boolean functions, pass both `true` and `false` to ensure that one value
                // is not hard-coded.
                DelegationReadTestCase("isOutputText", true),
                DelegationReadTestCase("isOutputText", false),
                DelegationReadTestCase("isRefusal", true),
                DelegationReadTestCase("isRefusal", false),
                // `asOutputText()` is a special case and has its own test function.
                DelegationReadTestCase("asRefusal", OUTPUT_REFUSAL),
                DelegationReadTestCase("_json", OPTIONAL),
            )
    }

    // New instances of the `mockDelegate` and `delegator` are required for each test case (each
    // test case runs in its own instance of the test class).
    private val mockDelegate: ResponseOutputMessage = mock(ResponseOutputMessage::class.java)
    private val delegator = StructuredResponseOutputMessage<X>(X::class.java, mockDelegate)

    private val contentMockDelegate: ResponseOutputMessage.Content =
        mock(ResponseOutputMessage.Content::class.java)
    private val contentDelegator =
        StructuredResponseOutputMessage.Content<X>(X::class.java, contentMockDelegate)

    @Test
    fun allDelegateFunctionsExistInDelegator() {
        checkAllDelegation(mockDelegate::class, delegator::class, "toBuilder")
    }

    @Test
    fun allDelegatorFunctionsExistInDelegate() {
        checkAllDelegation(delegator::class, mockDelegate::class)
    }

    @Test
    fun allContentDelegateFunctionsExistInDelegator() {
        // The `Content.accept()` function in the delegator takes a different type than that in the
        // delegate, so there is no delegation from the former to the latter. `Content.toBuilder` is
        // deliberately not implemented.
        checkAllDelegation(
            contentMockDelegate::class,
            contentDelegator::class,
            "toBuilder",
            "accept",
        )
    }

    @Test
    fun allContentDelegatorFunctionsExistInDelegate() {
        // The `Content.accept()` function in the delegator takes a different type than that in the
        // delegate, so there is no delegation from the former to the latter.
        checkAllDelegation(contentDelegator::class, contentMockDelegate::class, "accept")
    }

    @Test
    fun allDelegatorFunctionsAreTested() {
        // There are exceptional test cases for some functions. Most other functions are part of the
        // list of those using the parameterized test. A few delegator functions do not delegate, so
        // no test function is necessary.
        checkAllDelegatorReadFunctionsAreTested(
            delegator::class,
            delegationTestCases(),
            exceptionalTestedFns = setOf("content", "_content", "validate", "isValid"),
            nonDelegatingFns = setOf("equals", "hashCode", "toString"),
        )
    }

    @Test
    fun allContentDelegatorFunctionsAreTested() {
        checkAllDelegatorReadFunctionsAreTested(
            contentDelegator::class,
            contentDelegationTestCases(),
            exceptionalTestedFns =
                setOf("outputText", "asOutputText", "validate", "isValid", "accept"),
            nonDelegatingFns = setOf("equals", "hashCode", "toString"),
        )
    }

    @ParameterizedTest
    @MethodSource("delegationTestCases")
    fun `delegation of functions in general`(testCase: DelegationReadTestCase) {
        checkOneDelegationRead(delegator, mockDelegate, testCase)
    }

    @ParameterizedTest
    @MethodSource("contentDelegationTestCases")
    fun `delegation of Content functions in general`(testCase: DelegationReadTestCase) {
        checkOneDelegationRead(contentDelegator, contentMockDelegate, testCase)
    }

    @Test
    fun `delegation of content`() {
        // Input and output are different types, so this test is an exceptional case.
        // `content()` (without an underscore) delegates to `_content()` (with an underscore)
        // indirectly via the `content` field initializer.
        val input = JsonField.of(listOf(CONTENT))
        `when`(mockDelegate._content()).thenReturn(input)
        val output = delegator.content() // Without an underscore.

        verify(mockDelegate, times(1))._content()
        verifyNoMoreInteractions(mockDelegate)

        assertThat(output[0].rawContent).isEqualTo(CONTENT)
    }

    @Test
    fun `delegation of _content`() {
        // Input and output are different types, so this test is an exceptional case.
        // `_content()` (with an underscore) delegates to `_content()` (with an underscore)
        // indirectly via the `content` field initializer.
        val input = JsonField.of(listOf(CONTENT))
        `when`(mockDelegate._content()).thenReturn(input)
        val output = delegator._content() // With an underscore.

        verify(mockDelegate, times(1))._content()
        verifyNoMoreInteractions(mockDelegate)

        assertThat(output.getRequired("content")[0].rawContent).isEqualTo(CONTENT)
    }

    @Test
    fun `delegation of validate`() {
        `when`(mockDelegate._content()).thenReturn(JsonField.of(listOf(CONTENT)))
        `when`(mockDelegate._role()).thenReturn(JsonValue.from("assistant"))
        `when`(mockDelegate.status()).thenReturn(ResponseOutputMessage.Status.COMPLETED)
        `when`(mockDelegate._type()).thenReturn(JsonValue.from("message"))

        delegator.validate()

        // Delegator's `validate()` does not call delegate's `validate()`. `_content` is called
        // indirectly via the `content` field initializer.
        verify(mockDelegate, times(1))._content()
        verify(mockDelegate, times(1)).id()
        verify(mockDelegate, times(1))._role()
        verify(mockDelegate, times(1)).status()
        verify(mockDelegate, times(1))._type()
        verifyNoMoreInteractions(mockDelegate)
    }

    @Test
    fun `delegation of isValid`() {
        // `isValid` calls `validate()`, so the test is similar to that for `validate()`.
        `when`(mockDelegate._content()).thenReturn(JsonField.of(listOf(CONTENT)))
        `when`(mockDelegate._role()).thenReturn(JsonValue.from("assistant"))
        `when`(mockDelegate.status()).thenReturn(ResponseOutputMessage.Status.COMPLETED)
        `when`(mockDelegate._type()).thenReturn(JsonValue.from("message"))

        delegator.isValid()

        verify(mockDelegate, times(1))._content()
        verify(mockDelegate, times(1)).id()
        verify(mockDelegate, times(1))._role()
        verify(mockDelegate, times(1)).status()
        verify(mockDelegate, times(1))._type()
        verifyNoMoreInteractions(mockDelegate)
    }

    @Test
    fun `delegation of Content outputText`() {
        // Input and output are different types, so this test is an exceptional case. The
        // delegator's `outputText()` delegates to the delegate's `outputText()` indirectly via the
        // `outputText` field initializer.
        val input =
            Optional.of(
                ResponseOutputText.builder()
                    .annotations(listOf())
                    .text("{\"s\" : \"hello\"}")
                    .build()
            )
        `when`(contentMockDelegate.outputText()).thenReturn(input)
        val output = contentDelegator.outputText()

        verify(contentMockDelegate, times(1)).outputText()
        verifyNoMoreInteractions(contentMockDelegate)

        assertThat(output).isEqualTo(Optional.of(X("hello")))
    }

    @Test
    fun `delegation of Content asOutputText`() {
        // Input and output are different types, so this test is an exceptional case. The
        // delegator's `asOutputText()` delegates to the delegate's `outputText()` indirectly via
        // the
        // `outputText` field initializer.
        val input =
            Optional.of(
                ResponseOutputText.builder()
                    .annotations(listOf())
                    .text("{\"s\" : \"hello\"}")
                    .build()
            )
        `when`(contentMockDelegate.outputText()).thenReturn(input)
        val output = contentDelegator.asOutputText()

        verify(contentMockDelegate, times(1)).outputText()
        verifyNoMoreInteractions(contentMockDelegate)

        assertThat(output).isEqualTo(X("hello"))
    }

    @Test
    fun `delegation of Content asOutputText missing`() {
        val input = Optional.ofNullable<ResponseOutputText>(null)
        `when`(contentMockDelegate.outputText()).thenReturn(input)

        assertThatThrownBy { contentDelegator.asOutputText() }
            .isInstanceOf(OpenAIInvalidDataException::class.java)
            .hasMessage("`outputText` is not present")

        verify(contentMockDelegate, times(1)).outputText()
        verifyNoMoreInteractions(contentMockDelegate)
    }

    @Test
    fun `delegation of Content validate`() {
        // No values or passed and only `this` is returned.
        contentDelegator.validate()

        verify(contentMockDelegate, times(1)).validate()
        verifyNoMoreInteractions(contentMockDelegate)
    }

    @Test
    fun `delegation of Content isValid`() {
        contentDelegator.isValid()

        // `isValid()` calls `validate`, which then calls the mock delegate.
        verify(contentMockDelegate, times(1)).validate()
        verifyNoMoreInteractions(contentMockDelegate)
    }
}
