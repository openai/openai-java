package com.openai.models.responses

import com.openai.core.BOOLEAN
import com.openai.core.DOUBLE
import com.openai.core.DelegationWriteTestCase
import com.openai.core.JSON_FIELD
import com.openai.core.JSON_VALUE
import com.openai.core.LIST
import com.openai.core.LONG
import com.openai.core.MAP
import com.openai.core.NULLABLE
import com.openai.core.NULLABLE_BOOLEAN
import com.openai.core.NULLABLE_DOUBLE
import com.openai.core.NULLABLE_LONG
import com.openai.core.NULLABLE_STRING
import com.openai.core.OPTIONAL
import com.openai.core.SET
import com.openai.core.STRING
import com.openai.core.X
import com.openai.core.checkAllDelegation
import com.openai.core.checkAllDelegatorWriteFunctionsAreTested
import com.openai.core.checkOneDelegationWrite
import com.openai.core.findDelegationMethod
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.textConfigFromClass
import com.openai.models.ChatModel
import com.openai.models.Reasoning
import com.openai.models.ResponsesModel
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.mockito.Mockito.mock
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

/**
 * Unit tests for the [StructuredResponseCreateParams] class (delegator) and its delegation of most
 * functions to a wrapped [ResponseCreateParams] (delegate). The tests include confirmation of the
 * following:
 * - All functions in the delegator correspond to a function in the delegate and _vice versa_.
 * - All functions in the delegator call their corresponding function in the delegate and only that
 *   function.
 * - A unit test exists for all functions.
 *
 * There are some exceptions to the above that are handled differently.
 */
internal class StructuredResponseCreateParamsTest {
    companion object {
        private val CHAT_MODEL = ChatModel.GPT_4O
        private val RESPONSES_MODEL = ResponsesModel.ofChat(CHAT_MODEL)
        private val RESPONSES_ONLY_MODEL = ResponsesModel.ResponsesOnlyModel.O1_PRO
        private val PARAMS_INPUT = ResponseCreateParams.Input.ofText(STRING)

        private val INCLUDABLE = ResponseIncludable.of(STRING)
        private val METADATA = ResponseCreateParams.Metadata.builder().build()
        private val SERVICE_TIER = ResponseCreateParams.ServiceTier.AUTO
        private val REASONING = Reasoning.builder().build()

        private val TOOL_CHOICE_TYPE = ToolChoiceTypes.Type.FILE_SEARCH
        private val TOOL_CHOICE_TYPES = ToolChoiceTypes.builder().type(TOOL_CHOICE_TYPE).build()
        private val TOOL_CHOICE = ResponseCreateParams.ToolChoice.ofTypes(TOOL_CHOICE_TYPES)
        private val TOOL_CHOICE_OPTIONS = ToolChoiceOptions.AUTO
        private val TOOL_CHOICE_FUNCTION = ToolChoiceFunction.builder().name(STRING).build()

        private val FUNCTION_TOOL =
            FunctionTool.builder().name(STRING).parameters(NULLABLE).strict(BOOLEAN).build()
        private val FILE_SEARCH_TOOL = FileSearchTool.builder().vectorStoreIds(LIST).build()
        private val WEB_SEARCH_TOOL =
            WebSearchTool.builder().type(WebSearchTool.Type.WEB_SEARCH_PREVIEW).build()
        private val COMPUTER_TOOL =
            ComputerTool.builder()
                .displayWidth(LONG)
                .displayHeight(LONG)
                .environment(ComputerTool.Environment.LINUX)
                .build()
        private val TOOL = Tool.ofFunction(FUNCTION_TOOL)

        private val HEADERS = Headers.builder().build()
        private val QUERY_PARAMS = QueryParams.builder().build()

        // The list order follows the declaration order in `ResponseCreateParams.Builder` for
        // easier maintenance.
        @JvmStatic
        private fun builderDelegationTestCases() =
            listOf(
                // The `body(...)` function is deliberately not supported: too messy.
                DelegationWriteTestCase("input", PARAMS_INPUT),
                DelegationWriteTestCase("input", JSON_FIELD),
                DelegationWriteTestCase("input", STRING),
                DelegationWriteTestCase("inputOfResponse", LIST),
                DelegationWriteTestCase("model", RESPONSES_MODEL),
                DelegationWriteTestCase("model", JSON_FIELD),
                DelegationWriteTestCase("model", STRING),
                DelegationWriteTestCase("model", CHAT_MODEL),
                DelegationWriteTestCase("model", RESPONSES_ONLY_MODEL),
                DelegationWriteTestCase("include", LIST),
                DelegationWriteTestCase("include", OPTIONAL),
                DelegationWriteTestCase("include", JSON_FIELD),
                DelegationWriteTestCase("addInclude", INCLUDABLE),
                DelegationWriteTestCase("instructions", NULLABLE_STRING),
                DelegationWriteTestCase("instructions", OPTIONAL),
                DelegationWriteTestCase("instructions", JSON_FIELD),
                DelegationWriteTestCase("maxOutputTokens", NULLABLE_LONG),
                DelegationWriteTestCase("maxOutputTokens", LONG),
                DelegationWriteTestCase("maxOutputTokens", OPTIONAL),
                DelegationWriteTestCase("maxOutputTokens", JSON_FIELD),
                DelegationWriteTestCase("metadata", METADATA),
                DelegationWriteTestCase("metadata", OPTIONAL),
                DelegationWriteTestCase("metadata", JSON_FIELD),
                DelegationWriteTestCase("parallelToolCalls", NULLABLE_BOOLEAN),
                DelegationWriteTestCase("parallelToolCalls", BOOLEAN),
                DelegationWriteTestCase("parallelToolCalls", OPTIONAL),
                DelegationWriteTestCase("parallelToolCalls", JSON_FIELD),
                DelegationWriteTestCase("previousResponseId", NULLABLE_STRING),
                DelegationWriteTestCase("previousResponseId", OPTIONAL),
                DelegationWriteTestCase("previousResponseId", JSON_FIELD),
                DelegationWriteTestCase("reasoning", REASONING),
                DelegationWriteTestCase("reasoning", OPTIONAL),
                DelegationWriteTestCase("reasoning", JSON_FIELD),
                DelegationWriteTestCase("serviceTier", SERVICE_TIER),
                DelegationWriteTestCase("serviceTier", OPTIONAL),
                DelegationWriteTestCase("serviceTier", JSON_FIELD),
                DelegationWriteTestCase("store", NULLABLE_BOOLEAN),
                DelegationWriteTestCase("store", BOOLEAN),
                DelegationWriteTestCase("store", OPTIONAL),
                DelegationWriteTestCase("store", JSON_FIELD),
                DelegationWriteTestCase("temperature", NULLABLE_DOUBLE),
                DelegationWriteTestCase("temperature", DOUBLE),
                DelegationWriteTestCase("temperature", OPTIONAL),
                DelegationWriteTestCase("temperature", JSON_FIELD),
                // `text()` is a special case and has its own unit tests.
                DelegationWriteTestCase("toolChoice", TOOL_CHOICE),
                DelegationWriteTestCase("toolChoice", JSON_FIELD),
                DelegationWriteTestCase("toolChoice", TOOL_CHOICE_OPTIONS),
                DelegationWriteTestCase("toolChoice", TOOL_CHOICE_TYPES),
                DelegationWriteTestCase("toolChoice", TOOL_CHOICE_FUNCTION),
                DelegationWriteTestCase("tools", LIST),
                DelegationWriteTestCase("tools", JSON_FIELD),
                DelegationWriteTestCase("addTool", TOOL),
                DelegationWriteTestCase("addTool", FILE_SEARCH_TOOL),
                DelegationWriteTestCase("addFileSearchTool", LIST),
                DelegationWriteTestCase("addTool", FUNCTION_TOOL),
                DelegationWriteTestCase("addTool", WEB_SEARCH_TOOL),
                DelegationWriteTestCase("addTool", COMPUTER_TOOL),
                DelegationWriteTestCase("topP", NULLABLE_DOUBLE),
                DelegationWriteTestCase("topP", DOUBLE),
                DelegationWriteTestCase("topP", OPTIONAL),
                DelegationWriteTestCase("topP", JSON_FIELD),
                DelegationWriteTestCase("truncation", NULLABLE),
                DelegationWriteTestCase("truncation", OPTIONAL),
                DelegationWriteTestCase("truncation", JSON_FIELD),
                DelegationWriteTestCase("user", STRING),
                DelegationWriteTestCase("user", JSON_FIELD),
                DelegationWriteTestCase("additionalBodyProperties", MAP),
                DelegationWriteTestCase("putAdditionalBodyProperty", STRING, JSON_VALUE),
                DelegationWriteTestCase("putAllAdditionalBodyProperties", MAP),
                DelegationWriteTestCase("removeAdditionalBodyProperty", STRING),
                DelegationWriteTestCase("removeAllAdditionalBodyProperties", SET),
                DelegationWriteTestCase("additionalHeaders", HEADERS),
                DelegationWriteTestCase("additionalHeaders", MAP),
                DelegationWriteTestCase("putAdditionalHeader", STRING, STRING),
                DelegationWriteTestCase("putAdditionalHeaders", STRING, LIST),
                DelegationWriteTestCase("putAllAdditionalHeaders", HEADERS),
                DelegationWriteTestCase("putAllAdditionalHeaders", MAP),
                DelegationWriteTestCase("replaceAdditionalHeaders", STRING, STRING),
                DelegationWriteTestCase("replaceAdditionalHeaders", STRING, LIST),
                DelegationWriteTestCase("replaceAllAdditionalHeaders", HEADERS),
                DelegationWriteTestCase("replaceAllAdditionalHeaders", MAP),
                DelegationWriteTestCase("removeAdditionalHeaders", STRING),
                DelegationWriteTestCase("removeAllAdditionalHeaders", SET),
                DelegationWriteTestCase("additionalQueryParams", QUERY_PARAMS),
                DelegationWriteTestCase("additionalQueryParams", MAP),
                DelegationWriteTestCase("putAdditionalQueryParam", STRING, STRING),
                DelegationWriteTestCase("putAdditionalQueryParams", STRING, LIST),
                DelegationWriteTestCase("putAllAdditionalQueryParams", QUERY_PARAMS),
                DelegationWriteTestCase("putAllAdditionalQueryParams", MAP),
                DelegationWriteTestCase("replaceAdditionalQueryParams", STRING, STRING),
                DelegationWriteTestCase("replaceAdditionalQueryParams", STRING, LIST),
                DelegationWriteTestCase("replaceAllAdditionalQueryParams", QUERY_PARAMS),
                DelegationWriteTestCase("replaceAllAdditionalQueryParams", MAP),
                DelegationWriteTestCase("removeAdditionalQueryParams", STRING),
                DelegationWriteTestCase("removeAllAdditionalQueryParams", SET),
            )
    }

    // New instances of the `mockBuilderDelegate` and `builderDelegator` are required for each test
    // case (each test case runs in its own instance of the test class).
    private val mockBuilderDelegate: ResponseCreateParams.Builder =
        mock(ResponseCreateParams.Builder::class.java)
    private val builderDelegator =
        StructuredResponseCreateParams.builder<X>().inject(mockBuilderDelegate)

    @Test
    fun allBuilderDelegateFunctionsExistInDelegator() {
        // The delegator class does not implement various functions from the delegate class:
        // - text functions and body function
        // - addCodeInterpreterTool methods
        // - various tool-related methods (addTool variations, addToolLocalShell)
        // - background-related methods
        checkAllDelegation(
            mockBuilderDelegate::class,
            builderDelegator::class,
            "body",
            "text",
            "addCodeInterpreterTool",
            "addTool",
            "addToolLocalShell",
            "background",
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
            exceptionalTestedFns = setOf("text"),
            nonDelegatingFns = setOf("build", "wrap", "inject"),
        )
    }

    @ParameterizedTest
    @MethodSource("builderDelegationTestCases")
    fun `delegation of Builder write functions`(testCase: DelegationWriteTestCase) {
        checkOneDelegationWrite(builderDelegator, mockBuilderDelegate, testCase)
    }

    @Test
    fun `delegation of text`() {
        // Special unit test case as the delegator method signature does not match that of the
        // delegate method.
        val delegatorTestCase = DelegationWriteTestCase("text", X::class.java)
        val delegatorMethod = findDelegationMethod(builderDelegator, delegatorTestCase)
        val mockDelegateTestCase =
            DelegationWriteTestCase("text", textConfigFromClass(X::class.java))
        val mockDelegateMethod = findDelegationMethod(mockBuilderDelegate, mockDelegateTestCase)

        delegatorMethod.invoke(builderDelegator, delegatorTestCase.inputValues[0])

        // Verify that the corresponding method on the mock delegate was called exactly once.
        verify(mockBuilderDelegate, times(1)).apply {
            mockDelegateMethod.invoke(mockBuilderDelegate, mockDelegateTestCase.inputValues[0])
        }
        verifyNoMoreInteractions(mockBuilderDelegate)
    }
}
