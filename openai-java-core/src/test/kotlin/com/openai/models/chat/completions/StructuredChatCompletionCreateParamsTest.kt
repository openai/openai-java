package com.openai.models.chat.completions

import com.openai.core.fromClass
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.models.ChatModel
import com.openai.models.FunctionDefinition
import com.openai.models.chat.completions.StructuredChatCompletionTest.Companion.JSON_FIELD
import com.openai.models.chat.completions.StructuredChatCompletionTest.Companion.JSON_VALUE
import com.openai.models.chat.completions.StructuredChatCompletionTest.Companion.MESSAGE
import com.openai.models.chat.completions.StructuredChatCompletionTest.Companion.OPTIONAL
import com.openai.models.chat.completions.StructuredChatCompletionTest.Companion.STRING
import com.openai.models.chat.completions.StructuredChatCompletionTest.Companion.X
import java.lang.reflect.Method
import kotlin.collections.plus
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.jvm.javaMethod
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail
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
        private fun checkOneDelegationWrite(
            delegator: Any,
            mockDelegate: Any,
            testCase: DelegationWriteTestCase,
        ) {
            invokeMethod(findDelegationMethod(delegator, testCase), delegator, testCase)

            // Verify that the corresponding method on the mock delegate was called exactly once.
            verify(mockDelegate, times(1)).apply {
                invokeMethod(findDelegationMethod(mockDelegate, testCase), mockDelegate, testCase)
            }
            verifyNoMoreInteractions(mockDelegate)
        }

        private fun invokeMethod(method: Method, target: Any, testCase: DelegationWriteTestCase) {
            val numParams = testCase.inputValues.size
            val inputValue1 = testCase.inputValues[0]
            val inputValue2 = testCase.inputValues.getOrNull(1)

            when (numParams) {
                1 -> method.invoke(target, inputValue1)
                2 -> method.invoke(target, inputValue1, inputValue2)
                else -> fail { "Unexpected number of function parameters ($numParams)." }
            }
        }

        /**
         * Finds the java method matching the test case's function name and parameter types in the
         * delegator or delegate `target`.
         */
        private fun findDelegationMethod(target: Any, testCase: DelegationWriteTestCase): Method {
            val numParams = testCase.inputValues.size
            val inputValue1: Any? = testCase.inputValues[0]
            val inputValue2 = if (numParams > 1) testCase.inputValues[1] else null

            val method =
                when (numParams) {
                    1 ->
                        if (inputValue1 != null) {
                            findJavaMethod(
                                target.javaClass,
                                testCase.functionName,
                                toJavaType(inputValue1.javaClass),
                            )
                        } else {
                            // Only the first parameter may be nullable and only if it is the only
                            // parameter. If the first parameter is nullable, it will be the only
                            // function of the same name with a nullable first parameter. To handle
                            // the potentially nullable first parameter, Kotlin reflection is
                            // needed. This allows a function `f(Boolean)` to be distinguished from
                            // `f(Boolean?)`. For the tests, if the parameter type is nullable, the
                            // parameter value will always be `null` (if not, the function with the
                            // nullable parameter would not be matched).
                            //
                            // Using Kotlin reflection, the first parameter (zero index) is `this`
                            // object, so start matching from the second parameter onwards.
                            target::class
                                .declaredFunctions
                                .find {
                                    it.name == testCase.functionName &&
                                        it.parameters[1].type.isMarkedNullable
                                }
                                ?.javaMethod
                        }
                    2 ->
                        if (inputValue1 != null && inputValue2 != null) {
                            findJavaMethod(
                                target.javaClass,
                                testCase.functionName,
                                toJavaType(inputValue1.javaClass),
                                toJavaType(inputValue2.javaClass),
                            )
                        } else {
                            // There are no instances where there are two parameters and one of them
                            // is nullable.
                            fail { "Function $testCase second parameter must not be null." }
                        }
                    else -> fail { "Function $testCase has unsupported number of parameters." }
                }

            // Using `if` and `fail`, so the compiler knows the code will not continue and can infer
            // that `delegationMethod` is not null. It cannot do this for `assertThat...isNotNull`.
            if (method == null) {
                fail { "Function $testCase cannot be found in $target." }
            }

            return method
        }

        private fun findJavaMethod(
            clazz: Class<*>,
            methodName: String,
            vararg parameterTypes: Class<*>,
        ): Method? =
            clazz.declaredMethods.firstOrNull { method ->
                method.name == methodName &&
                    method.parameterTypes.size == parameterTypes.size &&
                    method.parameterTypes.indices.all { index ->
                        (parameterTypes[index].isPrimitive &&
                            method.parameterTypes[index] == parameterTypes[index]) ||
                            method.parameterTypes[index].isAssignableFrom(parameterTypes[index])
                    }
            }

        /**
         * Returns the Java type to use when matching type parameters for a Java method. The type is
         * the type of the input value that will be used when the method is invoked. For most types,
         * the given type is returned. However, if the type represents a Kotlin primitive, it will
         * be converted to a Java primitive. This allows matching of methods with parameter types
         * that are non-nullable Kotlin primitives. If not translated, methods with parameter types
         * that are nullable Kotlin primitives would always be matched instead.
         */
        private fun toJavaType(type: Class<*>) =
            when (type) {
                // This only needs to cover the types used in the test cases.
                java.lang.Long::class.java -> java.lang.Long.TYPE
                java.lang.Boolean::class.java -> java.lang.Boolean.TYPE
                java.lang.Double::class.java -> java.lang.Double.TYPE
                else -> type
            }

        private val NULLABLE = null
        private const val BOOLEAN: Boolean = true
        private val NULLABLE_BOOLEAN: Boolean? = null
        private const val LONG: Long = 42L
        private val NULLABLE_LONG: Long? = null
        private const val DOUBLE: Double = 42.0
        private val NULLABLE_DOUBLE: Double? = null
        private val LIST = listOf(STRING)
        private val SET = setOf(STRING)
        private val MAP = mapOf(STRING to STRING)

        private val CHAT_MODEL = ChatModel.GPT_4

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

        // Want `vararg`, so cannot use `data class`. Need a custom `toString`, anyway.
        class DelegationWriteTestCase(val functionName: String, vararg val inputValues: Any?) {
            /**
             * Gets the string representation that identifies the test function when running JUnit.
             */
            override fun toString(): String =
                "$functionName(${inputValues.joinToString(", ") { 
                    it?.javaClass?.simpleName ?: "null" 
                }})"
        }

        // The list order follows the declaration order in `ChatCompletionCreateParams.Builder` for
        // easier maintenance.
        @JvmStatic
        fun builderDelegationTestCases() =
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
    val mockBuilderDelegate: ChatCompletionCreateParams.Builder =
        mock(ChatCompletionCreateParams.Builder::class.java)
    val builderDelegator =
        StructuredChatCompletionCreateParams.builder<X>().inject(mockBuilderDelegate)

    @Test
    fun allBuilderDelegateFunctionsExistInDelegator() {
        // The delegator class does not implement the various `responseFormat` functions of the
        // delegate class.
        StructuredChatCompletionTest.checkAllDelegation(
            ChatCompletionCreateParams.Builder::class,
            StructuredChatCompletionCreateParams.Builder::class,
            "responseFormat",
        )
    }

    @Test
    fun allBuilderDelegatorFunctionsExistInDelegate() {
        // The delegator implements a different `responseFormat` function from those overloads in
        // the delegate class.
        StructuredChatCompletionTest.checkAllDelegation(
            StructuredChatCompletionCreateParams.Builder::class,
            ChatCompletionCreateParams.Builder::class,
            "responseFormat",
        )
    }

    @Test
    fun allBuilderDelegatorFunctionsAreTested() {
        // There are exceptional test cases for some functions. Most other functions are part of the
        // list of those using the parameterized test. There are many overloaded functions, so the
        // approach here is to build a list (_not_ a set) of all function names and then "subtract"
        // those for which tests are defined and see what remains. For example, there are (at this
        // time) eight `addMessage` functions, so there must be eight tests defined for functions
        // named `addMessage` that will be subtracted from the list of functions matching that name.
        // Parameter types are not checked, as that is awkward and probably overkill. Therefore,
        // this scheme is not reliable if a function is tested more than once.
        val exceptionalTestedFns = listOf("responseFormat")
        val testedFns =
            (builderDelegationTestCases().map { it.functionName } + exceptionalTestedFns)
                .toMutableList()
        val nonDelegatingFns = listOf("build", "wrap", "inject")

        val delegatorFns =
            StructuredChatCompletionCreateParams.Builder::class.declaredFunctions.toMutableList()

        // Making concurrent modifications to the list, so using an `Iterator`.
        val i = delegatorFns.iterator()

        while (i.hasNext()) {
            val functionName = i.next().name

            if (functionName in testedFns) {
                testedFns.remove(functionName)
                i.remove()
            }
            if (functionName in nonDelegatingFns) {
                i.remove()
            }
        }

        // If there are function names remaining in `delegatorFns`, then there are tests missing.
        // Only report the names of the functions not tested: parameters are not matched, so any
        // signatures could be misleading.
        assertThat(delegatorFns)
            .describedAs {
                "Delegation is not tested for functions ${delegatorFns.map { it.name }}."
            }
            .isEmpty()

        // If there are function names remaining in `testedFns`, then there are more tests than
        // there should be. Functions might be tested twice, or there may be tests for functions
        // that have since been removed from the delegate (though those tests probably failed).
        assertThat(testedFns)
            .describedAs { "Unexpected or redundant tests for functions $testedFns." }
            .isEmpty()
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
            DelegationWriteTestCase("responseFormat", fromClass(X::class.java))
        val mockDelegateMethod = findDelegationMethod(mockBuilderDelegate, mockDelegateTestCase)

        delegatorMethod.invoke(builderDelegator, delegatorTestCase.inputValues[0])

        // Verify that the corresponding method on the mock delegate was called exactly once.
        verify(mockBuilderDelegate, times(1)).apply {
            mockDelegateMethod.invoke(mockBuilderDelegate, mockDelegateTestCase.inputValues[0])
        }
        verifyNoMoreInteractions(mockBuilderDelegate)
    }
}
