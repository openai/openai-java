package com.openai.models.responses

import com.openai.core.DelegationWriteTestCase
import com.openai.core.JSON_FIELD
import com.openai.core.JSON_VALUE
import com.openai.core.MAP
import com.openai.core.OPTIONAL
import com.openai.core.SET
import com.openai.core.STRING
import com.openai.core.X
import com.openai.core.checkAllDelegation
import com.openai.core.checkAllDelegatorWriteFunctionsAreTested
import com.openai.core.checkOneDelegationWrite
import com.openai.core.findDelegationMethod
import com.openai.core.jsonSchemaFromClass
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.mockito.Mockito.mock
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

/**
 * Unit tests for the [StructuredResponseTextConfig] class (delegator) and its delegation of most
 * functions to a wrapped [ResponseTextConfig] (delegate). The tests include confirmation of the
 * following:
 * - All functions in the delegator correspond to a function in the delegate and _vice versa_.
 * - All functions in the delegator call their corresponding function in the delegate and only that
 *   function.
 * - A unit test exists for all functions.
 *
 * There are some exceptions to the above that are handled differently.
 */
internal class StructuredResponseTextConfigTest {
    companion object {
        private val VERBOSITY = ResponseTextConfig.Verbosity.HIGH

        // The list order follows the declaration order in `ResponseTextConfig.Builder` for easier
        // maintenance.
        @JvmStatic
        private fun builderDelegationTestCases() =
            listOf(
                // The `format` function is a special case and is handled separately.
                DelegationWriteTestCase("verbosity", VERBOSITY),
                DelegationWriteTestCase("verbosity", OPTIONAL),
                DelegationWriteTestCase("verbosity", JSON_FIELD),
                DelegationWriteTestCase("additionalProperties", MAP),
                DelegationWriteTestCase("putAdditionalProperty", STRING, JSON_VALUE),
                DelegationWriteTestCase("putAllAdditionalProperties", MAP),
                DelegationWriteTestCase("removeAdditionalProperty", STRING),
                DelegationWriteTestCase("removeAllAdditionalProperties", SET),
            )
    }

    // New instances of the `mockBuilderDelegate` and `builderDelegator` are required for each test
    // case (each test case runs in its own instance of the test class).
    private val mockBuilderDelegate: ResponseTextConfig.Builder =
        mock(ResponseTextConfig.Builder::class.java)
    private val builderDelegator =
        StructuredResponseTextConfig.builder<X>().inject(mockBuilderDelegate)

    @Test
    fun allBuilderDelegateFunctionsExistInDelegator() {
        checkAllDelegation(
            mockBuilderDelegate::class,
            builderDelegator::class,
            // ************************************************************************************
            // NOTE: THIS TEST EXISTS TO ENSURE THAT WHEN NEW FUNCTIONS ARE ADDED MANUALLY OR VIA
            // CODE GEN TO `ResponseTextConfig.Builder`, THAT THOSE FUNCTIONS ARE _ALSO_ ADDED
            // _MANUALLY_ TO `StructuredResponseTextConfig.Builder`. FAILURE TO ADD THOSE FUNCTIONS
            // RESULTS IN _MISSING_ FUNCTIONALITY WHEN USING STRUCTURED OUTPUTS. EXCEPTIONS ADDED TO
            // THIS LIST ARE PRESENT BY DESIGN, NOT BECAUSE THE FUNCTIONS ARE SIMPLY NOT YET
            // IMPLEMENTED IN THE DELEGATOR CLASS.
            //
            // DO NOT ADD EXCEPTIONS TO THIS LIST SIMPLY BECAUSE TESTS ARE FAILING. THE TESTS ARE
            // SUPPOSED TO FAIL. ADD THE NEW FUNCTIONS TO `StructuredResponseTextConfig.Builder`
            // AND ADD A PARAMETERIZED TEST TO `builderDelegationTestCases` (above) TO ENSURE
            // CORRECT DELEGATION BEHAVIOR.
            // ************************************************************************************

            // For Structured Outputs, a new type-safe generic `format` function replaces all
            // existing `format` functions, as they are mutually incompatible. This function has its
            // own dedicated unit tests.
            "format",
        )
    }

    @Test
    fun allBuilderDelegatorFunctionsExistInDelegate() {
        // The delegator implements a different `text` function from those overloads in the delegate
        // class.
        checkAllDelegation(builderDelegator::class, mockBuilderDelegate::class, "text")
    }

    @Test
    fun allBuilderDelegatorFunctionsAreTested() {
        checkAllDelegatorWriteFunctionsAreTested(
            builderDelegator::class,
            builderDelegationTestCases(),
            exceptionalTestedFns = listOf("format"),
            nonDelegatingFns = setOf("build", "wrap", "inject"),
        )
    }

    @ParameterizedTest
    @MethodSource("builderDelegationTestCases")
    fun `delegation of Builder write functions`(testCase: DelegationWriteTestCase) {
        checkOneDelegationWrite(builderDelegator, mockBuilderDelegate, testCase)
    }

    @Test
    fun `delegation of format from class`() {
        // Special unit test case as the delegator method signature does not match that of the
        // delegate method.
        val delegatorTestCase = DelegationWriteTestCase("format", X::class.java)
        val delegatorMethod = findDelegationMethod(builderDelegator, delegatorTestCase)
        val mockDelegateTestCase =
            DelegationWriteTestCase("format", jsonSchemaFromClass(X::class.java))
        val mockDelegateMethod = findDelegationMethod(mockBuilderDelegate, mockDelegateTestCase)

        delegatorMethod.invoke(builderDelegator, delegatorTestCase.inputValues[0])

        // Verify that the corresponding method on the mock delegate was called exactly once.
        verify(mockBuilderDelegate, times(1)).apply {
            mockDelegateMethod.invoke(mockBuilderDelegate, mockDelegateTestCase.inputValues[0])
        }
        verifyNoMoreInteractions(mockBuilderDelegate)
    }
}
