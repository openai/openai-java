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
                .action(
                    ResponseFunctionWebSearch.Action.ofSearch(
                        ResponseFunctionWebSearch.Action.Search.builder().query("query").build()
                    )
                )
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
        private val COMPACTION_ITEM =
            ResponseCompactionItem.builder().id(STRING).encryptedContent(STRING).build()
        private val CODE_INTERPRETER_CALL =
            ResponseCodeInterpreterToolCall.builder()
                .id(STRING)
                .code(STRING)
                .containerId(STRING)
                .outputs(listOf())
                .status(ResponseCodeInterpreterToolCall.Status.COMPLETED)
                .build()
        private val IMAGE_GENERATION_CALL =
            ResponseOutputItem.ImageGenerationCall.builder()
                .id(STRING)
                .result(STRING)
                .status(ResponseOutputItem.ImageGenerationCall.Status.COMPLETED)
                .build()
        private val LOCAL_SHELL_CALL =
            ResponseOutputItem.LocalShellCall.builder()
                .id(STRING)
                .callId(STRING)
                .action(
                    ResponseOutputItem.LocalShellCall.Action.builder()
                        .command(listOf("echo", "hello"))
                        .env(ResponseOutputItem.LocalShellCall.Action.Env.builder().build())
                        .build()
                )
                .status(ResponseOutputItem.LocalShellCall.Status.COMPLETED)
                .build()
        private val SHELL_TOOL_CALL =
            ResponseFunctionShellToolCall.builder()
                .id(STRING)
                .callId(STRING)
                .environment(ResponseLocalEnvironment.builder().build())
                .status(ResponseFunctionShellToolCall.Status.COMPLETED)
                .action(
                    ResponseFunctionShellToolCall.Action.builder()
                        .commands(listOf("echo hello"))
                        .maxOutputLength(1024L)
                        .timeoutMs(1000L)
                        .build()
                )
                .build()
        private val SHELL_TOOL_CALL_OUTPUT =
            ResponseFunctionShellToolCallOutput.builder()
                .id(STRING)
                .callId(STRING)
                .maxOutputLength(1024L)
                .output(
                    listOf(
                        ResponseFunctionShellToolCallOutput.Output.builder()
                            .exitOutcome(0L)
                            .stderr(STRING)
                            .stdout(STRING)
                            .build()
                    )
                )
                .status(ResponseFunctionShellToolCallOutput.Status.COMPLETED)
                .build()
        private val APPLY_PATCH_TOOL_CALL =
            ResponseApplyPatchToolCall.builder()
                .id(STRING)
                .callId(STRING)
                .operation(
                    ResponseApplyPatchToolCall.Operation.CreateFile.builder()
                        .diff(STRING)
                        .path(STRING)
                        .build()
                )
                .status(ResponseApplyPatchToolCall.Status.COMPLETED)
                .build()
        private val APPLY_PATCH_TOOL_CALL_OUTPUT =
            ResponseApplyPatchToolCallOutput.builder()
                .id(STRING)
                .callId(STRING)
                .output(STRING)
                .status(ResponseApplyPatchToolCallOutput.Status.COMPLETED)
                .build()
        private val MCP_APPROVAL_REQUEST =
            ResponseOutputItem.McpApprovalRequest.builder()
                .id(STRING)
                .arguments(STRING)
                .name(STRING)
                .serverLabel(STRING)
                .build()
        private val MCP_CALL =
            ResponseOutputItem.McpCall.builder()
                .id(STRING)
                .arguments(STRING)
                .name(STRING)
                .serverLabel(STRING)
                .output(STRING)
                .build()
        private val MCP_LIST_TOOLS =
            ResponseOutputItem.McpListTools.builder()
                .id(STRING)
                .serverLabel(STRING)
                .tools(listOf())
                .build()
        private val CUSTOM_TOOL_CALL =
            ResponseCustomToolCall.builder().callId(STRING).input(STRING).name(STRING).build()
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
                DelegationReadTestCase("compaction", OPTIONAL),
                DelegationReadTestCase("localShellCall", OPTIONAL),
                DelegationReadTestCase("shellCall", OPTIONAL),
                DelegationReadTestCase("shellCallOutput", OPTIONAL),
                DelegationReadTestCase("applyPatchCall", OPTIONAL),
                DelegationReadTestCase("applyPatchCallOutput", OPTIONAL),
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
                DelegationReadTestCase("isCompaction", true),
                DelegationReadTestCase("isCompaction", false),
                DelegationReadTestCase("isLocalShellCall", true),
                DelegationReadTestCase("isLocalShellCall", false),
                DelegationReadTestCase("isShellCall", true),
                DelegationReadTestCase("isShellCall", false),
                DelegationReadTestCase("isShellCallOutput", true),
                DelegationReadTestCase("isShellCallOutput", false),
                DelegationReadTestCase("isApplyPatchCall", true),
                DelegationReadTestCase("isApplyPatchCall", false),
                DelegationReadTestCase("isApplyPatchCallOutput", true),
                DelegationReadTestCase("isApplyPatchCallOutput", false),
                // `asMessage()` is a special case and has its own test function.
                DelegationReadTestCase("asFileSearchCall", FILE_SEARCH_TOOL_CALL),
                DelegationReadTestCase("asFunctionCall", FUNCTION_TOOL_CALL),
                DelegationReadTestCase("asWebSearchCall", FUNCTION_WEB_SEARCH),
                DelegationReadTestCase("asComputerCall", COMPUTER_TOOL_CALL),
                DelegationReadTestCase("asReasoning", REASONING_ITEM),
                DelegationReadTestCase("asCompaction", COMPACTION_ITEM),
                DelegationReadTestCase("asCodeInterpreterCall", CODE_INTERPRETER_CALL),
                DelegationReadTestCase("asImageGenerationCall", IMAGE_GENERATION_CALL),
                DelegationReadTestCase("asLocalShellCall", LOCAL_SHELL_CALL),
                DelegationReadTestCase("asShellCall", SHELL_TOOL_CALL),
                DelegationReadTestCase("asShellCallOutput", SHELL_TOOL_CALL_OUTPUT),
                DelegationReadTestCase("asApplyPatchCall", APPLY_PATCH_TOOL_CALL),
                DelegationReadTestCase("asApplyPatchCallOutput", APPLY_PATCH_TOOL_CALL_OUTPUT),
                DelegationReadTestCase("asMcpApprovalRequest", MCP_APPROVAL_REQUEST),
                DelegationReadTestCase("asMcpCall", MCP_CALL),
                DelegationReadTestCase("asMcpListTools", MCP_LIST_TOOLS),
                DelegationReadTestCase("customToolCall", OPTIONAL),
                DelegationReadTestCase("isCustomToolCall", true),
                DelegationReadTestCase("isCustomToolCall", false),
                DelegationReadTestCase("asCustomToolCall", CUSTOM_TOOL_CALL),
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
        // We're also skipping all the newly added tool methods related to Code Interpreter, Image
        // Generation, etc.
        checkAllDelegation(
            mockDelegate::class,
            delegator::class,
            "toBuilder",
            "accept",
            "asCodeInterpreterCall",
            "asImageGenerationCall",
            "asLocalShellCall",
            "asMcpApprovalRequest",
            "asMcpCall",
            "asMcpListTools",
            "codeInterpreterCall",
            "imageGenerationCall",
            "localShellCall",
            "mcpApprovalRequest",
            "mcpCall",
            "mcpListTools",
            "isCodeInterpreterCall",
            "isImageGenerationCall",
            "isLocalShellCall",
            "isMcpApprovalRequest",
            "isMcpCall",
            "isMcpListTools",
        )
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
                setOf(
                    "message",
                    "asMessage",
                    "isMessage",
                    "validate",
                    "isValid",
                    "accept",
                    "visitCodeInterpreterCall",
                    "visitImageGenerationCall",
                    "visitCompaction",
                    "visitMcpApprovalRequest",
                    "visitMcpCall",
                    "visitMcpListTools",
                    "visitLocalShellCall",
                    // All the functions added for new tools:
                    "asCodeInterpreterCall",
                    "asImageGenerationCall",
                    "asMcpApprovalRequest",
                    "asMcpCall",
                    "asMcpListTools",
                    "codeInterpreterCall",
                    "imageGenerationCall",
                    "mcpApprovalRequest",
                    "mcpCall",
                    "mcpListTools",
                    "isCodeInterpreterCall",
                    "isImageGenerationCall",
                    "isMcpApprovalRequest",
                    "isMcpCall",
                    "isMcpListTools",
                ),
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
