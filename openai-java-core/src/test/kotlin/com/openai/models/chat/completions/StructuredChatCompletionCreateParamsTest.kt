package com.openai.models.chat.completions

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
import com.openai.core.responseFormatFromClass
import com.openai.models.ChatModel
import com.openai.models.FunctionDefinition
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.mockito.Mockito.mock
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

/**
 * Unit tests for the [StructuredChatCompletionCreateParams] class (delegator) and its delegation of
 * most functions to a wrapped [ChatCompletionCreateParams] (delegate). It is the `Builder` class of
 * each main class that is involved in the delegation. The tests include confirmation of the
 * following:
 * - All functions in the delegator correspond to a function in the delegate and _vice versa_.
 * - All functions in the delegator call their corresponding function in the delegate and only that
 *   function.
 * - A unit test exists for all functions.
 *
 * There are some exceptions to the above that are handled differently.
 */
internal class StructuredChatCompletionCreateParamsTest {
    companion object {
        private val CHAT_MODEL = ChatModel.GPT_4

        private val MESSAGE =
            ChatCompletionMessage.builder().content(STRING).refusal(STRING).build()

        private val USER_MESSAGE_PARAM =
            ChatCompletionUserMessageParam.builder().content(STRING).build()
        private val DEV_MESSAGE_PARAM =
            ChatCompletionDeveloperMessageParam.builder().content(STRING).build()
        private val SYS_MESSAGE_PARAM =
            ChatCompletionSystemMessageParam.builder().content(STRING).build()
        private val ASSIST_MESSAGE_PARAM =
            ChatCompletionAssistantMessageParam.builder().content(STRING).build()
        private val TOOL_MESSAGE_PARAM =
            ChatCompletionToolMessageParam.builder().content(STRING).toolCallId(STRING).build()
        private val FUNC_MESSAGE_PARAM =
            ChatCompletionFunctionMessageParam.builder().content(STRING).name(STRING).build()
        private val MESSAGE_PARAM = ChatCompletionMessageParam.ofUser(USER_MESSAGE_PARAM)

        private val DEV_MESSAGE_PARAM_CONTENT =
            ChatCompletionDeveloperMessageParam.Content.ofText(STRING)
        private val SYS_MESSAGE_PARAM_CONTENT =
            ChatCompletionSystemMessageParam.Content.ofText(STRING)
        private val USER_MESSAGE_PARAM_CONTENT =
            ChatCompletionUserMessageParam.Content.ofText(STRING)

        private val PARAMS_BODY =
            ChatCompletionCreateParams.Body.builder()
                .messages(listOf(MESSAGE_PARAM))
                .model(CHAT_MODEL)
                .build()
        private val WEB_SEARCH_OPTIONS =
            ChatCompletionCreateParams.WebSearchOptions.builder().build()

        private val FUNCTION_CALL_MODE =
            ChatCompletionCreateParams.FunctionCall.FunctionCallMode.AUTO
        private val FUNCTION_CALL_OPTION =
            ChatCompletionFunctionCallOption.builder().name(STRING).build()
        private val FUNCTION_CALL =
            ChatCompletionCreateParams.FunctionCall.ofFunctionCallOption(FUNCTION_CALL_OPTION)

        private val FUNCTION = ChatCompletionCreateParams.Function.builder().name(STRING).build()
        private val METADATA = ChatCompletionCreateParams.Metadata.builder().build()
        private val MODALITY = ChatCompletionCreateParams.Modality.TEXT
        private val FUNCTION_DEFINITION = FunctionDefinition.builder().name(STRING).build()
        private val TOOL = ChatCompletionTool.builder().function(FUNCTION_DEFINITION).build()

        private val NAMED_TOOL_CHOICE_FUNCTION =
            ChatCompletionNamedToolChoice.Function.builder().name(STRING).build()
        private val NAMED_TOOL_CHOICE =
            ChatCompletionNamedToolChoice.builder().function(NAMED_TOOL_CHOICE_FUNCTION).build()
        private val TOOL_CHOICE_OPTION_AUTO = ChatCompletionToolChoiceOption.Auto.AUTO
        private val TOOL_CHOICE_OPTION =
            ChatCompletionToolChoiceOption.ofAuto(TOOL_CHOICE_OPTION_AUTO)

        private val HEADERS = Headers.builder().build()
        private val QUERY_PARAMS = QueryParams.builder().build()

        // The list order follows the declaration order in `ChatCompletionCreateParams.Builder` for
        // easier maintenance.
        @JvmStatic
        private fun builderDelegationTestCases() =
            listOf(
                DelegationWriteTestCase("body", PARAMS_BODY),
                DelegationWriteTestCase("messages", LIST),
                DelegationWriteTestCase("messages", JSON_FIELD),
                DelegationWriteTestCase("addMessage", MESSAGE_PARAM),
                DelegationWriteTestCase("addMessage", DEV_MESSAGE_PARAM),
                DelegationWriteTestCase("addDeveloperMessage", DEV_MESSAGE_PARAM_CONTENT),
                DelegationWriteTestCase("addDeveloperMessage", STRING),
                DelegationWriteTestCase("addDeveloperMessageOfArrayOfContentParts", LIST),
                DelegationWriteTestCase("addMessage", SYS_MESSAGE_PARAM),
                DelegationWriteTestCase("addSystemMessage", SYS_MESSAGE_PARAM_CONTENT),
                DelegationWriteTestCase("addSystemMessage", STRING),
                DelegationWriteTestCase("addSystemMessageOfArrayOfContentParts", LIST),
                DelegationWriteTestCase("addMessage", USER_MESSAGE_PARAM),
                DelegationWriteTestCase("addUserMessage", USER_MESSAGE_PARAM_CONTENT),
                DelegationWriteTestCase("addUserMessage", STRING),
                DelegationWriteTestCase("addUserMessageOfArrayOfContentParts", LIST),
                DelegationWriteTestCase("addMessage", ASSIST_MESSAGE_PARAM),
                DelegationWriteTestCase("addMessage", MESSAGE),
                DelegationWriteTestCase("addMessage", TOOL_MESSAGE_PARAM),
                DelegationWriteTestCase("addMessage", FUNC_MESSAGE_PARAM),
                DelegationWriteTestCase("model", CHAT_MODEL),
                DelegationWriteTestCase("model", JSON_FIELD),
                DelegationWriteTestCase("model", STRING),
                DelegationWriteTestCase("audio", NULLABLE),
                DelegationWriteTestCase("audio", OPTIONAL),
                DelegationWriteTestCase("audio", JSON_FIELD),
                DelegationWriteTestCase("frequencyPenalty", NULLABLE_DOUBLE),
                DelegationWriteTestCase("frequencyPenalty", DOUBLE),
                DelegationWriteTestCase("frequencyPenalty", OPTIONAL),
                DelegationWriteTestCase("frequencyPenalty", JSON_FIELD),
                DelegationWriteTestCase("functionCall", FUNCTION_CALL),
                DelegationWriteTestCase("functionCall", JSON_FIELD),
                DelegationWriteTestCase("functionCall", FUNCTION_CALL_MODE),
                DelegationWriteTestCase("functionCall", FUNCTION_CALL_OPTION),
                DelegationWriteTestCase("functions", LIST),
                DelegationWriteTestCase("functions", JSON_FIELD),
                DelegationWriteTestCase("addFunction", FUNCTION),
                DelegationWriteTestCase("logitBias", NULLABLE),
                DelegationWriteTestCase("logitBias", OPTIONAL),
                DelegationWriteTestCase("logitBias", JSON_FIELD),
                DelegationWriteTestCase("logprobs", NULLABLE_BOOLEAN),
                DelegationWriteTestCase("logprobs", BOOLEAN),
                DelegationWriteTestCase("logprobs", OPTIONAL),
                DelegationWriteTestCase("logprobs", JSON_FIELD),
                DelegationWriteTestCase("maxCompletionTokens", NULLABLE_LONG),
                DelegationWriteTestCase("maxCompletionTokens", LONG),
                DelegationWriteTestCase("maxCompletionTokens", OPTIONAL),
                DelegationWriteTestCase("maxCompletionTokens", JSON_FIELD),
                DelegationWriteTestCase("maxTokens", NULLABLE_LONG),
                DelegationWriteTestCase("maxTokens", LONG),
                DelegationWriteTestCase("maxTokens", OPTIONAL),
                DelegationWriteTestCase("maxTokens", JSON_FIELD),
                DelegationWriteTestCase("metadata", METADATA),
                DelegationWriteTestCase("metadata", OPTIONAL),
                DelegationWriteTestCase("metadata", JSON_FIELD),
                DelegationWriteTestCase("modalities", LIST),
                DelegationWriteTestCase("modalities", OPTIONAL),
                DelegationWriteTestCase("modalities", JSON_FIELD),
                DelegationWriteTestCase("addModality", MODALITY),
                DelegationWriteTestCase("n", NULLABLE_LONG),
                DelegationWriteTestCase("n", LONG),
                DelegationWriteTestCase("n", OPTIONAL),
                DelegationWriteTestCase("n", JSON_FIELD),
                DelegationWriteTestCase("parallelToolCalls", BOOLEAN),
                DelegationWriteTestCase("parallelToolCalls", JSON_FIELD),
                DelegationWriteTestCase("prediction", NULLABLE),
                DelegationWriteTestCase("prediction", OPTIONAL),
                DelegationWriteTestCase("prediction", JSON_FIELD),
                DelegationWriteTestCase("presencePenalty", NULLABLE_DOUBLE),
                DelegationWriteTestCase("presencePenalty", DOUBLE),
                DelegationWriteTestCase("presencePenalty", OPTIONAL),
                DelegationWriteTestCase("presencePenalty", JSON_FIELD),
                DelegationWriteTestCase("reasoningEffort", NULLABLE),
                DelegationWriteTestCase("reasoningEffort", OPTIONAL),
                DelegationWriteTestCase("reasoningEffort", JSON_FIELD),
                // `responseFormat()` is a special case and has its own unit test.
                DelegationWriteTestCase("seed", NULLABLE_LONG),
                DelegationWriteTestCase("seed", LONG),
                DelegationWriteTestCase("seed", OPTIONAL),
                DelegationWriteTestCase("seed", JSON_FIELD),
                DelegationWriteTestCase("serviceTier", NULLABLE),
                DelegationWriteTestCase("serviceTier", OPTIONAL),
                DelegationWriteTestCase("serviceTier", JSON_FIELD),
                DelegationWriteTestCase("stop", NULLABLE),
                DelegationWriteTestCase("stop", OPTIONAL),
                DelegationWriteTestCase("stop", JSON_FIELD),
                DelegationWriteTestCase("stop", STRING),
                DelegationWriteTestCase("stopOfStrings", LIST),
                DelegationWriteTestCase("store", NULLABLE_BOOLEAN),
                DelegationWriteTestCase("store", BOOLEAN),
                DelegationWriteTestCase("store", OPTIONAL),
                DelegationWriteTestCase("store", JSON_FIELD),
                DelegationWriteTestCase("streamOptions", NULLABLE),
                DelegationWriteTestCase("streamOptions", OPTIONAL),
                DelegationWriteTestCase("streamOptions", JSON_FIELD),
                DelegationWriteTestCase("temperature", NULLABLE_DOUBLE),
                DelegationWriteTestCase("temperature", DOUBLE),
                DelegationWriteTestCase("temperature", OPTIONAL),
                DelegationWriteTestCase("temperature", JSON_FIELD),
                DelegationWriteTestCase("toolChoice", TOOL_CHOICE_OPTION),
                DelegationWriteTestCase("toolChoice", JSON_FIELD),
                DelegationWriteTestCase("toolChoice", TOOL_CHOICE_OPTION_AUTO),
                DelegationWriteTestCase("toolChoice", NAMED_TOOL_CHOICE),
                DelegationWriteTestCase("tools", LIST),
                DelegationWriteTestCase("tools", JSON_FIELD),
                DelegationWriteTestCase("addTool", TOOL),
                DelegationWriteTestCase("topLogprobs", NULLABLE_LONG),
                DelegationWriteTestCase("topLogprobs", LONG),
                DelegationWriteTestCase("topLogprobs", OPTIONAL),
                DelegationWriteTestCase("topLogprobs", JSON_FIELD),
                DelegationWriteTestCase("topP", NULLABLE_DOUBLE),
                DelegationWriteTestCase("topP", DOUBLE),
                DelegationWriteTestCase("topP", OPTIONAL),
                DelegationWriteTestCase("topP", JSON_FIELD),
                DelegationWriteTestCase("user", STRING),
                DelegationWriteTestCase("user", JSON_FIELD),
                DelegationWriteTestCase("webSearchOptions", WEB_SEARCH_OPTIONS),
                DelegationWriteTestCase("webSearchOptions", JSON_FIELD),
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
    private val mockBuilderDelegate: ChatCompletionCreateParams.Builder =
        mock(ChatCompletionCreateParams.Builder::class.java)
    private val builderDelegator =
        StructuredChatCompletionCreateParams.builder<X>().inject(mockBuilderDelegate)

    @Test
    fun allBuilderDelegateFunctionsExistInDelegator() {
        // The delegator class does not implement the various `responseFormat` functions of the
        // delegate class.
        checkAllDelegation(mockBuilderDelegate::class, builderDelegator::class, "responseFormat")
    }

    @Test
    fun allBuilderDelegatorFunctionsExistInDelegate() {
        // The delegator implements a different `responseFormat` function from those overloads in
        // the delegate class.
        checkAllDelegation(builderDelegator::class, mockBuilderDelegate::class, "responseFormat")
    }

    @Test
    fun allBuilderDelegatorFunctionsAreTested() {
        checkAllDelegatorWriteFunctionsAreTested(
            builderDelegator::class,
            builderDelegationTestCases(),
            exceptionalTestedFns = setOf("responseFormat"),
            nonDelegatingFns = setOf("build", "wrap", "inject"),
        )
    }

    @ParameterizedTest
    @MethodSource("builderDelegationTestCases")
    fun `delegation of Builder write functions`(testCase: DelegationWriteTestCase) {
        checkOneDelegationWrite(builderDelegator, mockBuilderDelegate, testCase)
    }

    @Test
    fun `delegation of responseFormat`() {
        // Special unit test case as the delegator method signature does not match that of the
        // delegate method.
        val delegatorTestCase = DelegationWriteTestCase("responseFormat", X::class.java)
        val delegatorMethod = findDelegationMethod(builderDelegator, delegatorTestCase)
        val mockDelegateTestCase =
            DelegationWriteTestCase("responseFormat", responseFormatFromClass(X::class.java))
        val mockDelegateMethod = findDelegationMethod(mockBuilderDelegate, mockDelegateTestCase)

        delegatorMethod.invoke(builderDelegator, delegatorTestCase.inputValues[0])

        // Verify that the corresponding method on the mock delegate was called exactly once.
        verify(mockBuilderDelegate, times(1)).apply {
            mockDelegateMethod.invoke(mockBuilderDelegate, mockDelegateTestCase.inputValues[0])
        }
        verifyNoMoreInteractions(mockBuilderDelegate)
    }
}
