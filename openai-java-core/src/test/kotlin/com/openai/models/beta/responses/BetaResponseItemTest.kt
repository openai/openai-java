// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class BetaResponseItemTest {

    @Test
    fun ofBetaResponseInputMessageItem() {
        val betaResponseInputMessageItem =
            BetaResponseInputMessageItem.builder()
                .id("id")
                .addContent(
                    BetaResponseInputText.builder()
                        .text("text")
                        .promptCacheBreakpoint(
                            BetaResponseInputText.PromptCacheBreakpoint.builder().build()
                        )
                        .build()
                )
                .role(BetaResponseInputMessageItem.Role.USER)
                .agent(BetaResponseInputMessageItem.Agent.builder().agentName("agent_name").build())
                .status(BetaResponseInputMessageItem.Status.IN_PROGRESS)
                .build()

        val betaResponseItem =
            BetaResponseItem.ofBetaResponseInputMessageItem(betaResponseInputMessageItem)

        assertThat(betaResponseItem.betaResponseInputMessageItem())
            .contains(betaResponseInputMessageItem)
        assertThat(betaResponseItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseItem.fileSearchCall()).isEmpty
        assertThat(betaResponseItem.computerCall()).isEmpty
        assertThat(betaResponseItem.computerCallOutput()).isEmpty
        assertThat(betaResponseItem.webSearchCall()).isEmpty
        assertThat(betaResponseItem.functionCall()).isEmpty
        assertThat(betaResponseItem.functionCallOutput()).isEmpty
        assertThat(betaResponseItem.agentMessage()).isEmpty
        assertThat(betaResponseItem.multiAgentCall()).isEmpty
        assertThat(betaResponseItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseItem.toolSearchCall()).isEmpty
        assertThat(betaResponseItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseItem.additionalTools()).isEmpty
        assertThat(betaResponseItem.reasoning()).isEmpty
        assertThat(betaResponseItem.program()).isEmpty
        assertThat(betaResponseItem.programOutput()).isEmpty
        assertThat(betaResponseItem.compaction()).isEmpty
        assertThat(betaResponseItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseItem.localShellCall()).isEmpty
        assertThat(betaResponseItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseItem.shellCall()).isEmpty
        assertThat(betaResponseItem.shellCallOutput()).isEmpty
        assertThat(betaResponseItem.applyPatchCall()).isEmpty
        assertThat(betaResponseItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseItem.mcpListTools()).isEmpty
        assertThat(betaResponseItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseItem.mcpCall()).isEmpty
        assertThat(betaResponseItem.customToolCall()).isEmpty
        assertThat(betaResponseItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofBetaResponseInputMessageItemRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItem =
            BetaResponseItem.ofBetaResponseInputMessageItem(
                BetaResponseInputMessageItem.builder()
                    .id("id")
                    .addContent(
                        BetaResponseInputText.builder()
                            .text("text")
                            .promptCacheBreakpoint(
                                BetaResponseInputText.PromptCacheBreakpoint.builder().build()
                            )
                            .build()
                    )
                    .role(BetaResponseInputMessageItem.Role.USER)
                    .agent(
                        BetaResponseInputMessageItem.Agent.builder().agentName("agent_name").build()
                    )
                    .status(BetaResponseInputMessageItem.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedBetaResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItem),
                jacksonTypeRef<BetaResponseItem>(),
            )

        assertThat(roundtrippedBetaResponseItem).isEqualTo(betaResponseItem)
    }

    @Test
    fun ofBetaResponseOutputMessage() {
        val betaResponseOutputMessage =
            BetaResponseOutputMessage.builder()
                .id("id")
                .addContent(
                    BetaResponseOutputText.builder()
                        .addAnnotation(
                            BetaResponseOutputText.Annotation.FileCitation.builder()
                                .fileId("file_id")
                                .filename("filename")
                                .index(0L)
                                .build()
                        )
                        .text("text")
                        .addLogprob(
                            BetaResponseOutputText.Logprob.builder()
                                .token("token")
                                .addByte(0L)
                                .logprob(0.0)
                                .addTopLogprob(
                                    BetaResponseOutputText.Logprob.TopLogprob.builder()
                                        .token("token")
                                        .addByte(0L)
                                        .logprob(0.0)
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .status(BetaResponseOutputMessage.Status.IN_PROGRESS)
                .agent(BetaResponseOutputMessage.Agent.builder().agentName("agent_name").build())
                .phase(BetaResponseOutputMessage.Phase.COMMENTARY)
                .build()

        val betaResponseItem =
            BetaResponseItem.ofBetaResponseOutputMessage(betaResponseOutputMessage)

        assertThat(betaResponseItem.betaResponseInputMessageItem()).isEmpty
        assertThat(betaResponseItem.betaResponseOutputMessage()).contains(betaResponseOutputMessage)
        assertThat(betaResponseItem.fileSearchCall()).isEmpty
        assertThat(betaResponseItem.computerCall()).isEmpty
        assertThat(betaResponseItem.computerCallOutput()).isEmpty
        assertThat(betaResponseItem.webSearchCall()).isEmpty
        assertThat(betaResponseItem.functionCall()).isEmpty
        assertThat(betaResponseItem.functionCallOutput()).isEmpty
        assertThat(betaResponseItem.agentMessage()).isEmpty
        assertThat(betaResponseItem.multiAgentCall()).isEmpty
        assertThat(betaResponseItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseItem.toolSearchCall()).isEmpty
        assertThat(betaResponseItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseItem.additionalTools()).isEmpty
        assertThat(betaResponseItem.reasoning()).isEmpty
        assertThat(betaResponseItem.program()).isEmpty
        assertThat(betaResponseItem.programOutput()).isEmpty
        assertThat(betaResponseItem.compaction()).isEmpty
        assertThat(betaResponseItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseItem.localShellCall()).isEmpty
        assertThat(betaResponseItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseItem.shellCall()).isEmpty
        assertThat(betaResponseItem.shellCallOutput()).isEmpty
        assertThat(betaResponseItem.applyPatchCall()).isEmpty
        assertThat(betaResponseItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseItem.mcpListTools()).isEmpty
        assertThat(betaResponseItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseItem.mcpCall()).isEmpty
        assertThat(betaResponseItem.customToolCall()).isEmpty
        assertThat(betaResponseItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofBetaResponseOutputMessageRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItem =
            BetaResponseItem.ofBetaResponseOutputMessage(
                BetaResponseOutputMessage.builder()
                    .id("id")
                    .addContent(
                        BetaResponseOutputText.builder()
                            .addAnnotation(
                                BetaResponseOutputText.Annotation.FileCitation.builder()
                                    .fileId("file_id")
                                    .filename("filename")
                                    .index(0L)
                                    .build()
                            )
                            .text("text")
                            .addLogprob(
                                BetaResponseOutputText.Logprob.builder()
                                    .token("token")
                                    .addByte(0L)
                                    .logprob(0.0)
                                    .addTopLogprob(
                                        BetaResponseOutputText.Logprob.TopLogprob.builder()
                                            .token("token")
                                            .addByte(0L)
                                            .logprob(0.0)
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .status(BetaResponseOutputMessage.Status.IN_PROGRESS)
                    .agent(
                        BetaResponseOutputMessage.Agent.builder().agentName("agent_name").build()
                    )
                    .phase(BetaResponseOutputMessage.Phase.COMMENTARY)
                    .build()
            )

        val roundtrippedBetaResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItem),
                jacksonTypeRef<BetaResponseItem>(),
            )

        assertThat(roundtrippedBetaResponseItem).isEqualTo(betaResponseItem)
    }

    @Test
    fun ofFileSearchCall() {
        val fileSearchCall =
            BetaResponseFileSearchToolCall.builder()
                .id("id")
                .addQuery("string")
                .status(BetaResponseFileSearchToolCall.Status.IN_PROGRESS)
                .agent(
                    BetaResponseFileSearchToolCall.Agent.builder().agentName("agent_name").build()
                )
                .addResult(
                    BetaResponseFileSearchToolCall.Result.builder()
                        .attributes(
                            BetaResponseFileSearchToolCall.Result.Attributes.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .fileId("file_id")
                        .filename("filename")
                        .score(0.0f)
                        .text("text")
                        .build()
                )
                .build()

        val betaResponseItem = BetaResponseItem.ofFileSearchCall(fileSearchCall)

        assertThat(betaResponseItem.betaResponseInputMessageItem()).isEmpty
        assertThat(betaResponseItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseItem.fileSearchCall()).contains(fileSearchCall)
        assertThat(betaResponseItem.computerCall()).isEmpty
        assertThat(betaResponseItem.computerCallOutput()).isEmpty
        assertThat(betaResponseItem.webSearchCall()).isEmpty
        assertThat(betaResponseItem.functionCall()).isEmpty
        assertThat(betaResponseItem.functionCallOutput()).isEmpty
        assertThat(betaResponseItem.agentMessage()).isEmpty
        assertThat(betaResponseItem.multiAgentCall()).isEmpty
        assertThat(betaResponseItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseItem.toolSearchCall()).isEmpty
        assertThat(betaResponseItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseItem.additionalTools()).isEmpty
        assertThat(betaResponseItem.reasoning()).isEmpty
        assertThat(betaResponseItem.program()).isEmpty
        assertThat(betaResponseItem.programOutput()).isEmpty
        assertThat(betaResponseItem.compaction()).isEmpty
        assertThat(betaResponseItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseItem.localShellCall()).isEmpty
        assertThat(betaResponseItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseItem.shellCall()).isEmpty
        assertThat(betaResponseItem.shellCallOutput()).isEmpty
        assertThat(betaResponseItem.applyPatchCall()).isEmpty
        assertThat(betaResponseItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseItem.mcpListTools()).isEmpty
        assertThat(betaResponseItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseItem.mcpCall()).isEmpty
        assertThat(betaResponseItem.customToolCall()).isEmpty
        assertThat(betaResponseItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofFileSearchCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItem =
            BetaResponseItem.ofFileSearchCall(
                BetaResponseFileSearchToolCall.builder()
                    .id("id")
                    .addQuery("string")
                    .status(BetaResponseFileSearchToolCall.Status.IN_PROGRESS)
                    .agent(
                        BetaResponseFileSearchToolCall.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .addResult(
                        BetaResponseFileSearchToolCall.Result.builder()
                            .attributes(
                                BetaResponseFileSearchToolCall.Result.Attributes.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .fileId("file_id")
                            .filename("filename")
                            .score(0.0f)
                            .text("text")
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItem),
                jacksonTypeRef<BetaResponseItem>(),
            )

        assertThat(roundtrippedBetaResponseItem).isEqualTo(betaResponseItem)
    }

    @Test
    fun ofComputerCall() {
        val computerCall =
            BetaResponseComputerToolCall.builder()
                .id("id")
                .callId("call_id")
                .addPendingSafetyCheck(
                    BetaResponseComputerToolCall.PendingSafetyCheck.builder()
                        .id("id")
                        .code("code")
                        .message("message")
                        .build()
                )
                .status(BetaResponseComputerToolCall.Status.IN_PROGRESS)
                .type(BetaResponseComputerToolCall.Type.COMPUTER_CALL)
                .action(
                    BetaComputerAction.Click.builder()
                        .button(BetaComputerAction.Click.Button.LEFT)
                        .x(0L)
                        .y(0L)
                        .addKey("string")
                        .build()
                )
                .addAction(
                    BetaComputerAction.Click.builder()
                        .button(BetaComputerAction.Click.Button.LEFT)
                        .x(0L)
                        .y(0L)
                        .addKey("string")
                        .build()
                )
                .agent(BetaResponseComputerToolCall.Agent.builder().agentName("agent_name").build())
                .build()

        val betaResponseItem = BetaResponseItem.ofComputerCall(computerCall)

        assertThat(betaResponseItem.betaResponseInputMessageItem()).isEmpty
        assertThat(betaResponseItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseItem.fileSearchCall()).isEmpty
        assertThat(betaResponseItem.computerCall()).contains(computerCall)
        assertThat(betaResponseItem.computerCallOutput()).isEmpty
        assertThat(betaResponseItem.webSearchCall()).isEmpty
        assertThat(betaResponseItem.functionCall()).isEmpty
        assertThat(betaResponseItem.functionCallOutput()).isEmpty
        assertThat(betaResponseItem.agentMessage()).isEmpty
        assertThat(betaResponseItem.multiAgentCall()).isEmpty
        assertThat(betaResponseItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseItem.toolSearchCall()).isEmpty
        assertThat(betaResponseItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseItem.additionalTools()).isEmpty
        assertThat(betaResponseItem.reasoning()).isEmpty
        assertThat(betaResponseItem.program()).isEmpty
        assertThat(betaResponseItem.programOutput()).isEmpty
        assertThat(betaResponseItem.compaction()).isEmpty
        assertThat(betaResponseItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseItem.localShellCall()).isEmpty
        assertThat(betaResponseItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseItem.shellCall()).isEmpty
        assertThat(betaResponseItem.shellCallOutput()).isEmpty
        assertThat(betaResponseItem.applyPatchCall()).isEmpty
        assertThat(betaResponseItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseItem.mcpListTools()).isEmpty
        assertThat(betaResponseItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseItem.mcpCall()).isEmpty
        assertThat(betaResponseItem.customToolCall()).isEmpty
        assertThat(betaResponseItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofComputerCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItem =
            BetaResponseItem.ofComputerCall(
                BetaResponseComputerToolCall.builder()
                    .id("id")
                    .callId("call_id")
                    .addPendingSafetyCheck(
                        BetaResponseComputerToolCall.PendingSafetyCheck.builder()
                            .id("id")
                            .code("code")
                            .message("message")
                            .build()
                    )
                    .status(BetaResponseComputerToolCall.Status.IN_PROGRESS)
                    .type(BetaResponseComputerToolCall.Type.COMPUTER_CALL)
                    .action(
                        BetaComputerAction.Click.builder()
                            .button(BetaComputerAction.Click.Button.LEFT)
                            .x(0L)
                            .y(0L)
                            .addKey("string")
                            .build()
                    )
                    .addAction(
                        BetaComputerAction.Click.builder()
                            .button(BetaComputerAction.Click.Button.LEFT)
                            .x(0L)
                            .y(0L)
                            .addKey("string")
                            .build()
                    )
                    .agent(
                        BetaResponseComputerToolCall.Agent.builder().agentName("agent_name").build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItem),
                jacksonTypeRef<BetaResponseItem>(),
            )

        assertThat(roundtrippedBetaResponseItem).isEqualTo(betaResponseItem)
    }

    @Test
    fun ofComputerCallOutput() {
        val computerCallOutput =
            BetaResponseComputerToolCallOutputItem.builder()
                .id("id")
                .callId("call_id")
                .output(
                    BetaResponseComputerToolCallOutputScreenshot.builder()
                        .fileId("file_id")
                        .imageUrl("https://example.com")
                        .build()
                )
                .status(BetaResponseComputerToolCallOutputItem.Status.COMPLETED)
                .addAcknowledgedSafetyCheck(
                    BetaResponseComputerToolCallOutputItem.AcknowledgedSafetyCheck.builder()
                        .id("id")
                        .code("code")
                        .message("message")
                        .build()
                )
                .agent(
                    BetaResponseComputerToolCallOutputItem.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .createdBy("created_by")
                .build()

        val betaResponseItem = BetaResponseItem.ofComputerCallOutput(computerCallOutput)

        assertThat(betaResponseItem.betaResponseInputMessageItem()).isEmpty
        assertThat(betaResponseItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseItem.fileSearchCall()).isEmpty
        assertThat(betaResponseItem.computerCall()).isEmpty
        assertThat(betaResponseItem.computerCallOutput()).contains(computerCallOutput)
        assertThat(betaResponseItem.webSearchCall()).isEmpty
        assertThat(betaResponseItem.functionCall()).isEmpty
        assertThat(betaResponseItem.functionCallOutput()).isEmpty
        assertThat(betaResponseItem.agentMessage()).isEmpty
        assertThat(betaResponseItem.multiAgentCall()).isEmpty
        assertThat(betaResponseItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseItem.toolSearchCall()).isEmpty
        assertThat(betaResponseItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseItem.additionalTools()).isEmpty
        assertThat(betaResponseItem.reasoning()).isEmpty
        assertThat(betaResponseItem.program()).isEmpty
        assertThat(betaResponseItem.programOutput()).isEmpty
        assertThat(betaResponseItem.compaction()).isEmpty
        assertThat(betaResponseItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseItem.localShellCall()).isEmpty
        assertThat(betaResponseItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseItem.shellCall()).isEmpty
        assertThat(betaResponseItem.shellCallOutput()).isEmpty
        assertThat(betaResponseItem.applyPatchCall()).isEmpty
        assertThat(betaResponseItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseItem.mcpListTools()).isEmpty
        assertThat(betaResponseItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseItem.mcpCall()).isEmpty
        assertThat(betaResponseItem.customToolCall()).isEmpty
        assertThat(betaResponseItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofComputerCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItem =
            BetaResponseItem.ofComputerCallOutput(
                BetaResponseComputerToolCallOutputItem.builder()
                    .id("id")
                    .callId("call_id")
                    .output(
                        BetaResponseComputerToolCallOutputScreenshot.builder()
                            .fileId("file_id")
                            .imageUrl("https://example.com")
                            .build()
                    )
                    .status(BetaResponseComputerToolCallOutputItem.Status.COMPLETED)
                    .addAcknowledgedSafetyCheck(
                        BetaResponseComputerToolCallOutputItem.AcknowledgedSafetyCheck.builder()
                            .id("id")
                            .code("code")
                            .message("message")
                            .build()
                    )
                    .agent(
                        BetaResponseComputerToolCallOutputItem.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .createdBy("created_by")
                    .build()
            )

        val roundtrippedBetaResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItem),
                jacksonTypeRef<BetaResponseItem>(),
            )

        assertThat(roundtrippedBetaResponseItem).isEqualTo(betaResponseItem)
    }

    @Test
    fun ofWebSearchCall() {
        val webSearchCall =
            BetaResponseFunctionWebSearch.builder()
                .id("id")
                .action(
                    BetaResponseFunctionWebSearch.Action.Search.builder()
                        .addQuery("string")
                        .query("query")
                        .addSource(
                            BetaResponseFunctionWebSearch.Action.Search.Source.builder()
                                .url("https://example.com")
                                .build()
                        )
                        .build()
                )
                .status(BetaResponseFunctionWebSearch.Status.IN_PROGRESS)
                .agent(
                    BetaResponseFunctionWebSearch.Agent.builder().agentName("agent_name").build()
                )
                .build()

        val betaResponseItem = BetaResponseItem.ofWebSearchCall(webSearchCall)

        assertThat(betaResponseItem.betaResponseInputMessageItem()).isEmpty
        assertThat(betaResponseItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseItem.fileSearchCall()).isEmpty
        assertThat(betaResponseItem.computerCall()).isEmpty
        assertThat(betaResponseItem.computerCallOutput()).isEmpty
        assertThat(betaResponseItem.webSearchCall()).contains(webSearchCall)
        assertThat(betaResponseItem.functionCall()).isEmpty
        assertThat(betaResponseItem.functionCallOutput()).isEmpty
        assertThat(betaResponseItem.agentMessage()).isEmpty
        assertThat(betaResponseItem.multiAgentCall()).isEmpty
        assertThat(betaResponseItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseItem.toolSearchCall()).isEmpty
        assertThat(betaResponseItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseItem.additionalTools()).isEmpty
        assertThat(betaResponseItem.reasoning()).isEmpty
        assertThat(betaResponseItem.program()).isEmpty
        assertThat(betaResponseItem.programOutput()).isEmpty
        assertThat(betaResponseItem.compaction()).isEmpty
        assertThat(betaResponseItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseItem.localShellCall()).isEmpty
        assertThat(betaResponseItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseItem.shellCall()).isEmpty
        assertThat(betaResponseItem.shellCallOutput()).isEmpty
        assertThat(betaResponseItem.applyPatchCall()).isEmpty
        assertThat(betaResponseItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseItem.mcpListTools()).isEmpty
        assertThat(betaResponseItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseItem.mcpCall()).isEmpty
        assertThat(betaResponseItem.customToolCall()).isEmpty
        assertThat(betaResponseItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofWebSearchCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItem =
            BetaResponseItem.ofWebSearchCall(
                BetaResponseFunctionWebSearch.builder()
                    .id("id")
                    .action(
                        BetaResponseFunctionWebSearch.Action.Search.builder()
                            .addQuery("string")
                            .query("query")
                            .addSource(
                                BetaResponseFunctionWebSearch.Action.Search.Source.builder()
                                    .url("https://example.com")
                                    .build()
                            )
                            .build()
                    )
                    .status(BetaResponseFunctionWebSearch.Status.IN_PROGRESS)
                    .agent(
                        BetaResponseFunctionWebSearch.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItem),
                jacksonTypeRef<BetaResponseItem>(),
            )

        assertThat(roundtrippedBetaResponseItem).isEqualTo(betaResponseItem)
    }

    @Test
    fun ofFunctionCall() {
        val functionCall =
            BetaResponseFunctionToolCallItem.builder()
                .arguments("arguments")
                .callId("call_id")
                .name("name")
                .id("id")
                .agent(BetaResponseFunctionToolCall.Agent.builder().agentName("agent_name").build())
                .callerDirect()
                .namespace("namespace")
                .status(BetaResponseFunctionToolCall.Status.IN_PROGRESS)
                .createdBy("created_by")
                .build()

        val betaResponseItem = BetaResponseItem.ofFunctionCall(functionCall)

        assertThat(betaResponseItem.betaResponseInputMessageItem()).isEmpty
        assertThat(betaResponseItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseItem.fileSearchCall()).isEmpty
        assertThat(betaResponseItem.computerCall()).isEmpty
        assertThat(betaResponseItem.computerCallOutput()).isEmpty
        assertThat(betaResponseItem.webSearchCall()).isEmpty
        assertThat(betaResponseItem.functionCall()).contains(functionCall)
        assertThat(betaResponseItem.functionCallOutput()).isEmpty
        assertThat(betaResponseItem.agentMessage()).isEmpty
        assertThat(betaResponseItem.multiAgentCall()).isEmpty
        assertThat(betaResponseItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseItem.toolSearchCall()).isEmpty
        assertThat(betaResponseItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseItem.additionalTools()).isEmpty
        assertThat(betaResponseItem.reasoning()).isEmpty
        assertThat(betaResponseItem.program()).isEmpty
        assertThat(betaResponseItem.programOutput()).isEmpty
        assertThat(betaResponseItem.compaction()).isEmpty
        assertThat(betaResponseItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseItem.localShellCall()).isEmpty
        assertThat(betaResponseItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseItem.shellCall()).isEmpty
        assertThat(betaResponseItem.shellCallOutput()).isEmpty
        assertThat(betaResponseItem.applyPatchCall()).isEmpty
        assertThat(betaResponseItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseItem.mcpListTools()).isEmpty
        assertThat(betaResponseItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseItem.mcpCall()).isEmpty
        assertThat(betaResponseItem.customToolCall()).isEmpty
        assertThat(betaResponseItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofFunctionCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItem =
            BetaResponseItem.ofFunctionCall(
                BetaResponseFunctionToolCallItem.builder()
                    .arguments("arguments")
                    .callId("call_id")
                    .name("name")
                    .id("id")
                    .agent(
                        BetaResponseFunctionToolCall.Agent.builder().agentName("agent_name").build()
                    )
                    .callerDirect()
                    .namespace("namespace")
                    .status(BetaResponseFunctionToolCall.Status.IN_PROGRESS)
                    .createdBy("created_by")
                    .build()
            )

        val roundtrippedBetaResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItem),
                jacksonTypeRef<BetaResponseItem>(),
            )

        assertThat(roundtrippedBetaResponseItem).isEqualTo(betaResponseItem)
    }

    @Test
    fun ofFunctionCallOutput() {
        val functionCallOutput =
            BetaResponseFunctionToolCallOutputItem.builder()
                .id("id")
                .callId("call_id")
                .output("string")
                .status(BetaResponseFunctionToolCallOutputItem.Status.IN_PROGRESS)
                .agent(
                    BetaResponseFunctionToolCallOutputItem.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .callerDirect()
                .createdBy("created_by")
                .build()

        val betaResponseItem = BetaResponseItem.ofFunctionCallOutput(functionCallOutput)

        assertThat(betaResponseItem.betaResponseInputMessageItem()).isEmpty
        assertThat(betaResponseItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseItem.fileSearchCall()).isEmpty
        assertThat(betaResponseItem.computerCall()).isEmpty
        assertThat(betaResponseItem.computerCallOutput()).isEmpty
        assertThat(betaResponseItem.webSearchCall()).isEmpty
        assertThat(betaResponseItem.functionCall()).isEmpty
        assertThat(betaResponseItem.functionCallOutput()).contains(functionCallOutput)
        assertThat(betaResponseItem.agentMessage()).isEmpty
        assertThat(betaResponseItem.multiAgentCall()).isEmpty
        assertThat(betaResponseItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseItem.toolSearchCall()).isEmpty
        assertThat(betaResponseItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseItem.additionalTools()).isEmpty
        assertThat(betaResponseItem.reasoning()).isEmpty
        assertThat(betaResponseItem.program()).isEmpty
        assertThat(betaResponseItem.programOutput()).isEmpty
        assertThat(betaResponseItem.compaction()).isEmpty
        assertThat(betaResponseItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseItem.localShellCall()).isEmpty
        assertThat(betaResponseItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseItem.shellCall()).isEmpty
        assertThat(betaResponseItem.shellCallOutput()).isEmpty
        assertThat(betaResponseItem.applyPatchCall()).isEmpty
        assertThat(betaResponseItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseItem.mcpListTools()).isEmpty
        assertThat(betaResponseItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseItem.mcpCall()).isEmpty
        assertThat(betaResponseItem.customToolCall()).isEmpty
        assertThat(betaResponseItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofFunctionCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItem =
            BetaResponseItem.ofFunctionCallOutput(
                BetaResponseFunctionToolCallOutputItem.builder()
                    .id("id")
                    .callId("call_id")
                    .output("string")
                    .status(BetaResponseFunctionToolCallOutputItem.Status.IN_PROGRESS)
                    .agent(
                        BetaResponseFunctionToolCallOutputItem.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .callerDirect()
                    .createdBy("created_by")
                    .build()
            )

        val roundtrippedBetaResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItem),
                jacksonTypeRef<BetaResponseItem>(),
            )

        assertThat(roundtrippedBetaResponseItem).isEqualTo(betaResponseItem)
    }

    @Test
    fun ofAgentMessage() {
        val agentMessage =
            BetaResponseItem.AgentMessage.builder()
                .id("id")
                .author("author")
                .addContent(
                    BetaResponseInputText.builder()
                        .text("text")
                        .promptCacheBreakpoint(
                            BetaResponseInputText.PromptCacheBreakpoint.builder().build()
                        )
                        .build()
                )
                .recipient("recipient")
                .agent(
                    BetaResponseItem.AgentMessage.Agent.builder().agentName("agent_name").build()
                )
                .build()

        val betaResponseItem = BetaResponseItem.ofAgentMessage(agentMessage)

        assertThat(betaResponseItem.betaResponseInputMessageItem()).isEmpty
        assertThat(betaResponseItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseItem.fileSearchCall()).isEmpty
        assertThat(betaResponseItem.computerCall()).isEmpty
        assertThat(betaResponseItem.computerCallOutput()).isEmpty
        assertThat(betaResponseItem.webSearchCall()).isEmpty
        assertThat(betaResponseItem.functionCall()).isEmpty
        assertThat(betaResponseItem.functionCallOutput()).isEmpty
        assertThat(betaResponseItem.agentMessage()).contains(agentMessage)
        assertThat(betaResponseItem.multiAgentCall()).isEmpty
        assertThat(betaResponseItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseItem.toolSearchCall()).isEmpty
        assertThat(betaResponseItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseItem.additionalTools()).isEmpty
        assertThat(betaResponseItem.reasoning()).isEmpty
        assertThat(betaResponseItem.program()).isEmpty
        assertThat(betaResponseItem.programOutput()).isEmpty
        assertThat(betaResponseItem.compaction()).isEmpty
        assertThat(betaResponseItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseItem.localShellCall()).isEmpty
        assertThat(betaResponseItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseItem.shellCall()).isEmpty
        assertThat(betaResponseItem.shellCallOutput()).isEmpty
        assertThat(betaResponseItem.applyPatchCall()).isEmpty
        assertThat(betaResponseItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseItem.mcpListTools()).isEmpty
        assertThat(betaResponseItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseItem.mcpCall()).isEmpty
        assertThat(betaResponseItem.customToolCall()).isEmpty
        assertThat(betaResponseItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofAgentMessageRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItem =
            BetaResponseItem.ofAgentMessage(
                BetaResponseItem.AgentMessage.builder()
                    .id("id")
                    .author("author")
                    .addContent(
                        BetaResponseInputText.builder()
                            .text("text")
                            .promptCacheBreakpoint(
                                BetaResponseInputText.PromptCacheBreakpoint.builder().build()
                            )
                            .build()
                    )
                    .recipient("recipient")
                    .agent(
                        BetaResponseItem.AgentMessage.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItem),
                jacksonTypeRef<BetaResponseItem>(),
            )

        assertThat(roundtrippedBetaResponseItem).isEqualTo(betaResponseItem)
    }

    @Test
    fun ofMultiAgentCall() {
        val multiAgentCall =
            BetaResponseItem.MultiAgentCall.builder()
                .id("id")
                .action(BetaResponseItem.MultiAgentCall.Action.SPAWN_AGENT)
                .arguments("arguments")
                .callId("call_id")
                .agent(
                    BetaResponseItem.MultiAgentCall.Agent.builder().agentName("agent_name").build()
                )
                .build()

        val betaResponseItem = BetaResponseItem.ofMultiAgentCall(multiAgentCall)

        assertThat(betaResponseItem.betaResponseInputMessageItem()).isEmpty
        assertThat(betaResponseItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseItem.fileSearchCall()).isEmpty
        assertThat(betaResponseItem.computerCall()).isEmpty
        assertThat(betaResponseItem.computerCallOutput()).isEmpty
        assertThat(betaResponseItem.webSearchCall()).isEmpty
        assertThat(betaResponseItem.functionCall()).isEmpty
        assertThat(betaResponseItem.functionCallOutput()).isEmpty
        assertThat(betaResponseItem.agentMessage()).isEmpty
        assertThat(betaResponseItem.multiAgentCall()).contains(multiAgentCall)
        assertThat(betaResponseItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseItem.toolSearchCall()).isEmpty
        assertThat(betaResponseItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseItem.additionalTools()).isEmpty
        assertThat(betaResponseItem.reasoning()).isEmpty
        assertThat(betaResponseItem.program()).isEmpty
        assertThat(betaResponseItem.programOutput()).isEmpty
        assertThat(betaResponseItem.compaction()).isEmpty
        assertThat(betaResponseItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseItem.localShellCall()).isEmpty
        assertThat(betaResponseItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseItem.shellCall()).isEmpty
        assertThat(betaResponseItem.shellCallOutput()).isEmpty
        assertThat(betaResponseItem.applyPatchCall()).isEmpty
        assertThat(betaResponseItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseItem.mcpListTools()).isEmpty
        assertThat(betaResponseItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseItem.mcpCall()).isEmpty
        assertThat(betaResponseItem.customToolCall()).isEmpty
        assertThat(betaResponseItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofMultiAgentCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItem =
            BetaResponseItem.ofMultiAgentCall(
                BetaResponseItem.MultiAgentCall.builder()
                    .id("id")
                    .action(BetaResponseItem.MultiAgentCall.Action.SPAWN_AGENT)
                    .arguments("arguments")
                    .callId("call_id")
                    .agent(
                        BetaResponseItem.MultiAgentCall.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItem),
                jacksonTypeRef<BetaResponseItem>(),
            )

        assertThat(roundtrippedBetaResponseItem).isEqualTo(betaResponseItem)
    }

    @Test
    fun ofMultiAgentCallOutput() {
        val multiAgentCallOutput =
            BetaResponseItem.MultiAgentCallOutput.builder()
                .id("id")
                .action(BetaResponseItem.MultiAgentCallOutput.Action.SPAWN_AGENT)
                .callId("call_id")
                .addOutput(
                    BetaResponseOutputText.builder()
                        .addAnnotation(
                            BetaResponseOutputText.Annotation.FileCitation.builder()
                                .fileId("file_id")
                                .filename("filename")
                                .index(0L)
                                .build()
                        )
                        .text("text")
                        .addLogprob(
                            BetaResponseOutputText.Logprob.builder()
                                .token("token")
                                .addByte(0L)
                                .logprob(0.0)
                                .addTopLogprob(
                                    BetaResponseOutputText.Logprob.TopLogprob.builder()
                                        .token("token")
                                        .addByte(0L)
                                        .logprob(0.0)
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .agent(
                    BetaResponseItem.MultiAgentCallOutput.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val betaResponseItem = BetaResponseItem.ofMultiAgentCallOutput(multiAgentCallOutput)

        assertThat(betaResponseItem.betaResponseInputMessageItem()).isEmpty
        assertThat(betaResponseItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseItem.fileSearchCall()).isEmpty
        assertThat(betaResponseItem.computerCall()).isEmpty
        assertThat(betaResponseItem.computerCallOutput()).isEmpty
        assertThat(betaResponseItem.webSearchCall()).isEmpty
        assertThat(betaResponseItem.functionCall()).isEmpty
        assertThat(betaResponseItem.functionCallOutput()).isEmpty
        assertThat(betaResponseItem.agentMessage()).isEmpty
        assertThat(betaResponseItem.multiAgentCall()).isEmpty
        assertThat(betaResponseItem.multiAgentCallOutput()).contains(multiAgentCallOutput)
        assertThat(betaResponseItem.toolSearchCall()).isEmpty
        assertThat(betaResponseItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseItem.additionalTools()).isEmpty
        assertThat(betaResponseItem.reasoning()).isEmpty
        assertThat(betaResponseItem.program()).isEmpty
        assertThat(betaResponseItem.programOutput()).isEmpty
        assertThat(betaResponseItem.compaction()).isEmpty
        assertThat(betaResponseItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseItem.localShellCall()).isEmpty
        assertThat(betaResponseItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseItem.shellCall()).isEmpty
        assertThat(betaResponseItem.shellCallOutput()).isEmpty
        assertThat(betaResponseItem.applyPatchCall()).isEmpty
        assertThat(betaResponseItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseItem.mcpListTools()).isEmpty
        assertThat(betaResponseItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseItem.mcpCall()).isEmpty
        assertThat(betaResponseItem.customToolCall()).isEmpty
        assertThat(betaResponseItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofMultiAgentCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItem =
            BetaResponseItem.ofMultiAgentCallOutput(
                BetaResponseItem.MultiAgentCallOutput.builder()
                    .id("id")
                    .action(BetaResponseItem.MultiAgentCallOutput.Action.SPAWN_AGENT)
                    .callId("call_id")
                    .addOutput(
                        BetaResponseOutputText.builder()
                            .addAnnotation(
                                BetaResponseOutputText.Annotation.FileCitation.builder()
                                    .fileId("file_id")
                                    .filename("filename")
                                    .index(0L)
                                    .build()
                            )
                            .text("text")
                            .addLogprob(
                                BetaResponseOutputText.Logprob.builder()
                                    .token("token")
                                    .addByte(0L)
                                    .logprob(0.0)
                                    .addTopLogprob(
                                        BetaResponseOutputText.Logprob.TopLogprob.builder()
                                            .token("token")
                                            .addByte(0L)
                                            .logprob(0.0)
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .agent(
                        BetaResponseItem.MultiAgentCallOutput.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItem),
                jacksonTypeRef<BetaResponseItem>(),
            )

        assertThat(roundtrippedBetaResponseItem).isEqualTo(betaResponseItem)
    }

    @Test
    fun ofToolSearchCall() {
        val toolSearchCall =
            BetaResponseToolSearchCall.builder()
                .id("id")
                .arguments(JsonValue.from(mapOf<String, Any>()))
                .callId("call_id")
                .execution(BetaResponseToolSearchCall.Execution.SERVER)
                .status(BetaResponseToolSearchCall.Status.IN_PROGRESS)
                .agent(BetaResponseToolSearchCall.Agent.builder().agentName("agent_name").build())
                .createdBy("created_by")
                .build()

        val betaResponseItem = BetaResponseItem.ofToolSearchCall(toolSearchCall)

        assertThat(betaResponseItem.betaResponseInputMessageItem()).isEmpty
        assertThat(betaResponseItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseItem.fileSearchCall()).isEmpty
        assertThat(betaResponseItem.computerCall()).isEmpty
        assertThat(betaResponseItem.computerCallOutput()).isEmpty
        assertThat(betaResponseItem.webSearchCall()).isEmpty
        assertThat(betaResponseItem.functionCall()).isEmpty
        assertThat(betaResponseItem.functionCallOutput()).isEmpty
        assertThat(betaResponseItem.agentMessage()).isEmpty
        assertThat(betaResponseItem.multiAgentCall()).isEmpty
        assertThat(betaResponseItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseItem.toolSearchCall()).contains(toolSearchCall)
        assertThat(betaResponseItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseItem.additionalTools()).isEmpty
        assertThat(betaResponseItem.reasoning()).isEmpty
        assertThat(betaResponseItem.program()).isEmpty
        assertThat(betaResponseItem.programOutput()).isEmpty
        assertThat(betaResponseItem.compaction()).isEmpty
        assertThat(betaResponseItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseItem.localShellCall()).isEmpty
        assertThat(betaResponseItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseItem.shellCall()).isEmpty
        assertThat(betaResponseItem.shellCallOutput()).isEmpty
        assertThat(betaResponseItem.applyPatchCall()).isEmpty
        assertThat(betaResponseItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseItem.mcpListTools()).isEmpty
        assertThat(betaResponseItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseItem.mcpCall()).isEmpty
        assertThat(betaResponseItem.customToolCall()).isEmpty
        assertThat(betaResponseItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofToolSearchCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItem =
            BetaResponseItem.ofToolSearchCall(
                BetaResponseToolSearchCall.builder()
                    .id("id")
                    .arguments(JsonValue.from(mapOf<String, Any>()))
                    .callId("call_id")
                    .execution(BetaResponseToolSearchCall.Execution.SERVER)
                    .status(BetaResponseToolSearchCall.Status.IN_PROGRESS)
                    .agent(
                        BetaResponseToolSearchCall.Agent.builder().agentName("agent_name").build()
                    )
                    .createdBy("created_by")
                    .build()
            )

        val roundtrippedBetaResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItem),
                jacksonTypeRef<BetaResponseItem>(),
            )

        assertThat(roundtrippedBetaResponseItem).isEqualTo(betaResponseItem)
    }

    @Test
    fun ofToolSearchOutput() {
        val toolSearchOutput =
            BetaResponseToolSearchOutputItem.builder()
                .id("id")
                .callId("call_id")
                .execution(BetaResponseToolSearchOutputItem.Execution.SERVER)
                .status(BetaResponseToolSearchOutputItem.Status.IN_PROGRESS)
                .addTool(
                    BetaFunctionTool.builder()
                        .name("name")
                        .parameters(
                            BetaFunctionTool.Parameters.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .strict(true)
                        .addAllowedCaller(BetaFunctionTool.AllowedCaller.DIRECT)
                        .deferLoading(true)
                        .description("description")
                        .outputSchema(
                            BetaFunctionTool.OutputSchema.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
                .agent(
                    BetaResponseToolSearchOutputItem.Agent.builder().agentName("agent_name").build()
                )
                .createdBy("created_by")
                .build()

        val betaResponseItem = BetaResponseItem.ofToolSearchOutput(toolSearchOutput)

        assertThat(betaResponseItem.betaResponseInputMessageItem()).isEmpty
        assertThat(betaResponseItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseItem.fileSearchCall()).isEmpty
        assertThat(betaResponseItem.computerCall()).isEmpty
        assertThat(betaResponseItem.computerCallOutput()).isEmpty
        assertThat(betaResponseItem.webSearchCall()).isEmpty
        assertThat(betaResponseItem.functionCall()).isEmpty
        assertThat(betaResponseItem.functionCallOutput()).isEmpty
        assertThat(betaResponseItem.agentMessage()).isEmpty
        assertThat(betaResponseItem.multiAgentCall()).isEmpty
        assertThat(betaResponseItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseItem.toolSearchCall()).isEmpty
        assertThat(betaResponseItem.toolSearchOutput()).contains(toolSearchOutput)
        assertThat(betaResponseItem.additionalTools()).isEmpty
        assertThat(betaResponseItem.reasoning()).isEmpty
        assertThat(betaResponseItem.program()).isEmpty
        assertThat(betaResponseItem.programOutput()).isEmpty
        assertThat(betaResponseItem.compaction()).isEmpty
        assertThat(betaResponseItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseItem.localShellCall()).isEmpty
        assertThat(betaResponseItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseItem.shellCall()).isEmpty
        assertThat(betaResponseItem.shellCallOutput()).isEmpty
        assertThat(betaResponseItem.applyPatchCall()).isEmpty
        assertThat(betaResponseItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseItem.mcpListTools()).isEmpty
        assertThat(betaResponseItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseItem.mcpCall()).isEmpty
        assertThat(betaResponseItem.customToolCall()).isEmpty
        assertThat(betaResponseItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofToolSearchOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItem =
            BetaResponseItem.ofToolSearchOutput(
                BetaResponseToolSearchOutputItem.builder()
                    .id("id")
                    .callId("call_id")
                    .execution(BetaResponseToolSearchOutputItem.Execution.SERVER)
                    .status(BetaResponseToolSearchOutputItem.Status.IN_PROGRESS)
                    .addTool(
                        BetaFunctionTool.builder()
                            .name("name")
                            .parameters(
                                BetaFunctionTool.Parameters.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .strict(true)
                            .addAllowedCaller(BetaFunctionTool.AllowedCaller.DIRECT)
                            .deferLoading(true)
                            .description("description")
                            .outputSchema(
                                BetaFunctionTool.OutputSchema.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .build()
                    )
                    .agent(
                        BetaResponseToolSearchOutputItem.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .createdBy("created_by")
                    .build()
            )

        val roundtrippedBetaResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItem),
                jacksonTypeRef<BetaResponseItem>(),
            )

        assertThat(roundtrippedBetaResponseItem).isEqualTo(betaResponseItem)
    }

    @Test
    fun ofAdditionalTools() {
        val additionalTools =
            BetaResponseItem.AdditionalTools.builder()
                .id("id")
                .role(BetaResponseItem.AdditionalTools.Role.UNKNOWN)
                .addTool(
                    BetaFunctionTool.builder()
                        .name("name")
                        .parameters(
                            BetaFunctionTool.Parameters.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .strict(true)
                        .addAllowedCaller(BetaFunctionTool.AllowedCaller.DIRECT)
                        .deferLoading(true)
                        .description("description")
                        .outputSchema(
                            BetaFunctionTool.OutputSchema.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
                .agent(
                    BetaResponseItem.AdditionalTools.Agent.builder().agentName("agent_name").build()
                )
                .build()

        val betaResponseItem = BetaResponseItem.ofAdditionalTools(additionalTools)

        assertThat(betaResponseItem.betaResponseInputMessageItem()).isEmpty
        assertThat(betaResponseItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseItem.fileSearchCall()).isEmpty
        assertThat(betaResponseItem.computerCall()).isEmpty
        assertThat(betaResponseItem.computerCallOutput()).isEmpty
        assertThat(betaResponseItem.webSearchCall()).isEmpty
        assertThat(betaResponseItem.functionCall()).isEmpty
        assertThat(betaResponseItem.functionCallOutput()).isEmpty
        assertThat(betaResponseItem.agentMessage()).isEmpty
        assertThat(betaResponseItem.multiAgentCall()).isEmpty
        assertThat(betaResponseItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseItem.toolSearchCall()).isEmpty
        assertThat(betaResponseItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseItem.additionalTools()).contains(additionalTools)
        assertThat(betaResponseItem.reasoning()).isEmpty
        assertThat(betaResponseItem.program()).isEmpty
        assertThat(betaResponseItem.programOutput()).isEmpty
        assertThat(betaResponseItem.compaction()).isEmpty
        assertThat(betaResponseItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseItem.localShellCall()).isEmpty
        assertThat(betaResponseItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseItem.shellCall()).isEmpty
        assertThat(betaResponseItem.shellCallOutput()).isEmpty
        assertThat(betaResponseItem.applyPatchCall()).isEmpty
        assertThat(betaResponseItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseItem.mcpListTools()).isEmpty
        assertThat(betaResponseItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseItem.mcpCall()).isEmpty
        assertThat(betaResponseItem.customToolCall()).isEmpty
        assertThat(betaResponseItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofAdditionalToolsRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItem =
            BetaResponseItem.ofAdditionalTools(
                BetaResponseItem.AdditionalTools.builder()
                    .id("id")
                    .role(BetaResponseItem.AdditionalTools.Role.UNKNOWN)
                    .addTool(
                        BetaFunctionTool.builder()
                            .name("name")
                            .parameters(
                                BetaFunctionTool.Parameters.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .strict(true)
                            .addAllowedCaller(BetaFunctionTool.AllowedCaller.DIRECT)
                            .deferLoading(true)
                            .description("description")
                            .outputSchema(
                                BetaFunctionTool.OutputSchema.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .build()
                    )
                    .agent(
                        BetaResponseItem.AdditionalTools.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItem),
                jacksonTypeRef<BetaResponseItem>(),
            )

        assertThat(roundtrippedBetaResponseItem).isEqualTo(betaResponseItem)
    }

    @Test
    fun ofReasoning() {
        val reasoning =
            BetaResponseReasoningItem.builder()
                .id("id")
                .addSummary(BetaResponseReasoningItem.Summary.builder().text("text").build())
                .agent(BetaResponseReasoningItem.Agent.builder().agentName("agent_name").build())
                .addContent(BetaResponseReasoningItem.Content.builder().text("text").build())
                .encryptedContent("encrypted_content")
                .status(BetaResponseReasoningItem.Status.IN_PROGRESS)
                .build()

        val betaResponseItem = BetaResponseItem.ofReasoning(reasoning)

        assertThat(betaResponseItem.betaResponseInputMessageItem()).isEmpty
        assertThat(betaResponseItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseItem.fileSearchCall()).isEmpty
        assertThat(betaResponseItem.computerCall()).isEmpty
        assertThat(betaResponseItem.computerCallOutput()).isEmpty
        assertThat(betaResponseItem.webSearchCall()).isEmpty
        assertThat(betaResponseItem.functionCall()).isEmpty
        assertThat(betaResponseItem.functionCallOutput()).isEmpty
        assertThat(betaResponseItem.agentMessage()).isEmpty
        assertThat(betaResponseItem.multiAgentCall()).isEmpty
        assertThat(betaResponseItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseItem.toolSearchCall()).isEmpty
        assertThat(betaResponseItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseItem.additionalTools()).isEmpty
        assertThat(betaResponseItem.reasoning()).contains(reasoning)
        assertThat(betaResponseItem.program()).isEmpty
        assertThat(betaResponseItem.programOutput()).isEmpty
        assertThat(betaResponseItem.compaction()).isEmpty
        assertThat(betaResponseItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseItem.localShellCall()).isEmpty
        assertThat(betaResponseItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseItem.shellCall()).isEmpty
        assertThat(betaResponseItem.shellCallOutput()).isEmpty
        assertThat(betaResponseItem.applyPatchCall()).isEmpty
        assertThat(betaResponseItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseItem.mcpListTools()).isEmpty
        assertThat(betaResponseItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseItem.mcpCall()).isEmpty
        assertThat(betaResponseItem.customToolCall()).isEmpty
        assertThat(betaResponseItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofReasoningRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItem =
            BetaResponseItem.ofReasoning(
                BetaResponseReasoningItem.builder()
                    .id("id")
                    .addSummary(BetaResponseReasoningItem.Summary.builder().text("text").build())
                    .agent(
                        BetaResponseReasoningItem.Agent.builder().agentName("agent_name").build()
                    )
                    .addContent(BetaResponseReasoningItem.Content.builder().text("text").build())
                    .encryptedContent("encrypted_content")
                    .status(BetaResponseReasoningItem.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedBetaResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItem),
                jacksonTypeRef<BetaResponseItem>(),
            )

        assertThat(roundtrippedBetaResponseItem).isEqualTo(betaResponseItem)
    }

    @Test
    fun ofProgram() {
        val program =
            BetaResponseItem.Program.builder()
                .id("id")
                .callId("call_id")
                .code("code")
                .fingerprint("fingerprint")
                .agent(BetaResponseItem.Program.Agent.builder().agentName("agent_name").build())
                .build()

        val betaResponseItem = BetaResponseItem.ofProgram(program)

        assertThat(betaResponseItem.betaResponseInputMessageItem()).isEmpty
        assertThat(betaResponseItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseItem.fileSearchCall()).isEmpty
        assertThat(betaResponseItem.computerCall()).isEmpty
        assertThat(betaResponseItem.computerCallOutput()).isEmpty
        assertThat(betaResponseItem.webSearchCall()).isEmpty
        assertThat(betaResponseItem.functionCall()).isEmpty
        assertThat(betaResponseItem.functionCallOutput()).isEmpty
        assertThat(betaResponseItem.agentMessage()).isEmpty
        assertThat(betaResponseItem.multiAgentCall()).isEmpty
        assertThat(betaResponseItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseItem.toolSearchCall()).isEmpty
        assertThat(betaResponseItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseItem.additionalTools()).isEmpty
        assertThat(betaResponseItem.reasoning()).isEmpty
        assertThat(betaResponseItem.program()).contains(program)
        assertThat(betaResponseItem.programOutput()).isEmpty
        assertThat(betaResponseItem.compaction()).isEmpty
        assertThat(betaResponseItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseItem.localShellCall()).isEmpty
        assertThat(betaResponseItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseItem.shellCall()).isEmpty
        assertThat(betaResponseItem.shellCallOutput()).isEmpty
        assertThat(betaResponseItem.applyPatchCall()).isEmpty
        assertThat(betaResponseItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseItem.mcpListTools()).isEmpty
        assertThat(betaResponseItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseItem.mcpCall()).isEmpty
        assertThat(betaResponseItem.customToolCall()).isEmpty
        assertThat(betaResponseItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofProgramRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItem =
            BetaResponseItem.ofProgram(
                BetaResponseItem.Program.builder()
                    .id("id")
                    .callId("call_id")
                    .code("code")
                    .fingerprint("fingerprint")
                    .agent(BetaResponseItem.Program.Agent.builder().agentName("agent_name").build())
                    .build()
            )

        val roundtrippedBetaResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItem),
                jacksonTypeRef<BetaResponseItem>(),
            )

        assertThat(roundtrippedBetaResponseItem).isEqualTo(betaResponseItem)
    }

    @Test
    fun ofProgramOutput() {
        val programOutput =
            BetaResponseItem.ProgramOutput.builder()
                .id("id")
                .callId("call_id")
                .result("result")
                .status(BetaResponseItem.ProgramOutput.Status.COMPLETED)
                .agent(
                    BetaResponseItem.ProgramOutput.Agent.builder().agentName("agent_name").build()
                )
                .build()

        val betaResponseItem = BetaResponseItem.ofProgramOutput(programOutput)

        assertThat(betaResponseItem.betaResponseInputMessageItem()).isEmpty
        assertThat(betaResponseItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseItem.fileSearchCall()).isEmpty
        assertThat(betaResponseItem.computerCall()).isEmpty
        assertThat(betaResponseItem.computerCallOutput()).isEmpty
        assertThat(betaResponseItem.webSearchCall()).isEmpty
        assertThat(betaResponseItem.functionCall()).isEmpty
        assertThat(betaResponseItem.functionCallOutput()).isEmpty
        assertThat(betaResponseItem.agentMessage()).isEmpty
        assertThat(betaResponseItem.multiAgentCall()).isEmpty
        assertThat(betaResponseItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseItem.toolSearchCall()).isEmpty
        assertThat(betaResponseItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseItem.additionalTools()).isEmpty
        assertThat(betaResponseItem.reasoning()).isEmpty
        assertThat(betaResponseItem.program()).isEmpty
        assertThat(betaResponseItem.programOutput()).contains(programOutput)
        assertThat(betaResponseItem.compaction()).isEmpty
        assertThat(betaResponseItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseItem.localShellCall()).isEmpty
        assertThat(betaResponseItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseItem.shellCall()).isEmpty
        assertThat(betaResponseItem.shellCallOutput()).isEmpty
        assertThat(betaResponseItem.applyPatchCall()).isEmpty
        assertThat(betaResponseItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseItem.mcpListTools()).isEmpty
        assertThat(betaResponseItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseItem.mcpCall()).isEmpty
        assertThat(betaResponseItem.customToolCall()).isEmpty
        assertThat(betaResponseItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofProgramOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItem =
            BetaResponseItem.ofProgramOutput(
                BetaResponseItem.ProgramOutput.builder()
                    .id("id")
                    .callId("call_id")
                    .result("result")
                    .status(BetaResponseItem.ProgramOutput.Status.COMPLETED)
                    .agent(
                        BetaResponseItem.ProgramOutput.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItem),
                jacksonTypeRef<BetaResponseItem>(),
            )

        assertThat(roundtrippedBetaResponseItem).isEqualTo(betaResponseItem)
    }

    @Test
    fun ofCompaction() {
        val compaction =
            BetaResponseCompactionItem.builder()
                .id("id")
                .encryptedContent("encrypted_content")
                .agent(BetaResponseCompactionItem.Agent.builder().agentName("agent_name").build())
                .createdBy("created_by")
                .build()

        val betaResponseItem = BetaResponseItem.ofCompaction(compaction)

        assertThat(betaResponseItem.betaResponseInputMessageItem()).isEmpty
        assertThat(betaResponseItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseItem.fileSearchCall()).isEmpty
        assertThat(betaResponseItem.computerCall()).isEmpty
        assertThat(betaResponseItem.computerCallOutput()).isEmpty
        assertThat(betaResponseItem.webSearchCall()).isEmpty
        assertThat(betaResponseItem.functionCall()).isEmpty
        assertThat(betaResponseItem.functionCallOutput()).isEmpty
        assertThat(betaResponseItem.agentMessage()).isEmpty
        assertThat(betaResponseItem.multiAgentCall()).isEmpty
        assertThat(betaResponseItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseItem.toolSearchCall()).isEmpty
        assertThat(betaResponseItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseItem.additionalTools()).isEmpty
        assertThat(betaResponseItem.reasoning()).isEmpty
        assertThat(betaResponseItem.program()).isEmpty
        assertThat(betaResponseItem.programOutput()).isEmpty
        assertThat(betaResponseItem.compaction()).contains(compaction)
        assertThat(betaResponseItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseItem.localShellCall()).isEmpty
        assertThat(betaResponseItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseItem.shellCall()).isEmpty
        assertThat(betaResponseItem.shellCallOutput()).isEmpty
        assertThat(betaResponseItem.applyPatchCall()).isEmpty
        assertThat(betaResponseItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseItem.mcpListTools()).isEmpty
        assertThat(betaResponseItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseItem.mcpCall()).isEmpty
        assertThat(betaResponseItem.customToolCall()).isEmpty
        assertThat(betaResponseItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofCompactionRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItem =
            BetaResponseItem.ofCompaction(
                BetaResponseCompactionItem.builder()
                    .id("id")
                    .encryptedContent("encrypted_content")
                    .agent(
                        BetaResponseCompactionItem.Agent.builder().agentName("agent_name").build()
                    )
                    .createdBy("created_by")
                    .build()
            )

        val roundtrippedBetaResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItem),
                jacksonTypeRef<BetaResponseItem>(),
            )

        assertThat(roundtrippedBetaResponseItem).isEqualTo(betaResponseItem)
    }

    @Test
    fun ofImageGenerationCall() {
        val imageGenerationCall =
            BetaResponseItem.ImageGenerationCall.builder()
                .id("id")
                .result("result")
                .status(BetaResponseItem.ImageGenerationCall.Status.IN_PROGRESS)
                .agent(
                    BetaResponseItem.ImageGenerationCall.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val betaResponseItem = BetaResponseItem.ofImageGenerationCall(imageGenerationCall)

        assertThat(betaResponseItem.betaResponseInputMessageItem()).isEmpty
        assertThat(betaResponseItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseItem.fileSearchCall()).isEmpty
        assertThat(betaResponseItem.computerCall()).isEmpty
        assertThat(betaResponseItem.computerCallOutput()).isEmpty
        assertThat(betaResponseItem.webSearchCall()).isEmpty
        assertThat(betaResponseItem.functionCall()).isEmpty
        assertThat(betaResponseItem.functionCallOutput()).isEmpty
        assertThat(betaResponseItem.agentMessage()).isEmpty
        assertThat(betaResponseItem.multiAgentCall()).isEmpty
        assertThat(betaResponseItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseItem.toolSearchCall()).isEmpty
        assertThat(betaResponseItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseItem.additionalTools()).isEmpty
        assertThat(betaResponseItem.reasoning()).isEmpty
        assertThat(betaResponseItem.program()).isEmpty
        assertThat(betaResponseItem.programOutput()).isEmpty
        assertThat(betaResponseItem.compaction()).isEmpty
        assertThat(betaResponseItem.imageGenerationCall()).contains(imageGenerationCall)
        assertThat(betaResponseItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseItem.localShellCall()).isEmpty
        assertThat(betaResponseItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseItem.shellCall()).isEmpty
        assertThat(betaResponseItem.shellCallOutput()).isEmpty
        assertThat(betaResponseItem.applyPatchCall()).isEmpty
        assertThat(betaResponseItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseItem.mcpListTools()).isEmpty
        assertThat(betaResponseItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseItem.mcpCall()).isEmpty
        assertThat(betaResponseItem.customToolCall()).isEmpty
        assertThat(betaResponseItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofImageGenerationCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItem =
            BetaResponseItem.ofImageGenerationCall(
                BetaResponseItem.ImageGenerationCall.builder()
                    .id("id")
                    .result("result")
                    .status(BetaResponseItem.ImageGenerationCall.Status.IN_PROGRESS)
                    .agent(
                        BetaResponseItem.ImageGenerationCall.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItem),
                jacksonTypeRef<BetaResponseItem>(),
            )

        assertThat(roundtrippedBetaResponseItem).isEqualTo(betaResponseItem)
    }

    @Test
    fun ofCodeInterpreterCall() {
        val codeInterpreterCall =
            BetaResponseCodeInterpreterToolCall.builder()
                .id("id")
                .code("code")
                .containerId("container_id")
                .addLogsOutput("logs")
                .status(BetaResponseCodeInterpreterToolCall.Status.IN_PROGRESS)
                .agent(
                    BetaResponseCodeInterpreterToolCall.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val betaResponseItem = BetaResponseItem.ofCodeInterpreterCall(codeInterpreterCall)

        assertThat(betaResponseItem.betaResponseInputMessageItem()).isEmpty
        assertThat(betaResponseItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseItem.fileSearchCall()).isEmpty
        assertThat(betaResponseItem.computerCall()).isEmpty
        assertThat(betaResponseItem.computerCallOutput()).isEmpty
        assertThat(betaResponseItem.webSearchCall()).isEmpty
        assertThat(betaResponseItem.functionCall()).isEmpty
        assertThat(betaResponseItem.functionCallOutput()).isEmpty
        assertThat(betaResponseItem.agentMessage()).isEmpty
        assertThat(betaResponseItem.multiAgentCall()).isEmpty
        assertThat(betaResponseItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseItem.toolSearchCall()).isEmpty
        assertThat(betaResponseItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseItem.additionalTools()).isEmpty
        assertThat(betaResponseItem.reasoning()).isEmpty
        assertThat(betaResponseItem.program()).isEmpty
        assertThat(betaResponseItem.programOutput()).isEmpty
        assertThat(betaResponseItem.compaction()).isEmpty
        assertThat(betaResponseItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseItem.codeInterpreterCall()).contains(codeInterpreterCall)
        assertThat(betaResponseItem.localShellCall()).isEmpty
        assertThat(betaResponseItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseItem.shellCall()).isEmpty
        assertThat(betaResponseItem.shellCallOutput()).isEmpty
        assertThat(betaResponseItem.applyPatchCall()).isEmpty
        assertThat(betaResponseItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseItem.mcpListTools()).isEmpty
        assertThat(betaResponseItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseItem.mcpCall()).isEmpty
        assertThat(betaResponseItem.customToolCall()).isEmpty
        assertThat(betaResponseItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofCodeInterpreterCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItem =
            BetaResponseItem.ofCodeInterpreterCall(
                BetaResponseCodeInterpreterToolCall.builder()
                    .id("id")
                    .code("code")
                    .containerId("container_id")
                    .addLogsOutput("logs")
                    .status(BetaResponseCodeInterpreterToolCall.Status.IN_PROGRESS)
                    .agent(
                        BetaResponseCodeInterpreterToolCall.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItem),
                jacksonTypeRef<BetaResponseItem>(),
            )

        assertThat(roundtrippedBetaResponseItem).isEqualTo(betaResponseItem)
    }

    @Test
    fun ofLocalShellCall() {
        val localShellCall =
            BetaResponseItem.LocalShellCall.builder()
                .id("id")
                .action(
                    BetaResponseItem.LocalShellCall.Action.builder()
                        .addCommand("string")
                        .env(
                            BetaResponseItem.LocalShellCall.Action.Env.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .timeoutMs(0L)
                        .user("user")
                        .workingDirectory("working_directory")
                        .build()
                )
                .callId("call_id")
                .status(BetaResponseItem.LocalShellCall.Status.IN_PROGRESS)
                .agent(
                    BetaResponseItem.LocalShellCall.Agent.builder().agentName("agent_name").build()
                )
                .build()

        val betaResponseItem = BetaResponseItem.ofLocalShellCall(localShellCall)

        assertThat(betaResponseItem.betaResponseInputMessageItem()).isEmpty
        assertThat(betaResponseItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseItem.fileSearchCall()).isEmpty
        assertThat(betaResponseItem.computerCall()).isEmpty
        assertThat(betaResponseItem.computerCallOutput()).isEmpty
        assertThat(betaResponseItem.webSearchCall()).isEmpty
        assertThat(betaResponseItem.functionCall()).isEmpty
        assertThat(betaResponseItem.functionCallOutput()).isEmpty
        assertThat(betaResponseItem.agentMessage()).isEmpty
        assertThat(betaResponseItem.multiAgentCall()).isEmpty
        assertThat(betaResponseItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseItem.toolSearchCall()).isEmpty
        assertThat(betaResponseItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseItem.additionalTools()).isEmpty
        assertThat(betaResponseItem.reasoning()).isEmpty
        assertThat(betaResponseItem.program()).isEmpty
        assertThat(betaResponseItem.programOutput()).isEmpty
        assertThat(betaResponseItem.compaction()).isEmpty
        assertThat(betaResponseItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseItem.localShellCall()).contains(localShellCall)
        assertThat(betaResponseItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseItem.shellCall()).isEmpty
        assertThat(betaResponseItem.shellCallOutput()).isEmpty
        assertThat(betaResponseItem.applyPatchCall()).isEmpty
        assertThat(betaResponseItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseItem.mcpListTools()).isEmpty
        assertThat(betaResponseItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseItem.mcpCall()).isEmpty
        assertThat(betaResponseItem.customToolCall()).isEmpty
        assertThat(betaResponseItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofLocalShellCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItem =
            BetaResponseItem.ofLocalShellCall(
                BetaResponseItem.LocalShellCall.builder()
                    .id("id")
                    .action(
                        BetaResponseItem.LocalShellCall.Action.builder()
                            .addCommand("string")
                            .env(
                                BetaResponseItem.LocalShellCall.Action.Env.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .timeoutMs(0L)
                            .user("user")
                            .workingDirectory("working_directory")
                            .build()
                    )
                    .callId("call_id")
                    .status(BetaResponseItem.LocalShellCall.Status.IN_PROGRESS)
                    .agent(
                        BetaResponseItem.LocalShellCall.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItem),
                jacksonTypeRef<BetaResponseItem>(),
            )

        assertThat(roundtrippedBetaResponseItem).isEqualTo(betaResponseItem)
    }

    @Test
    fun ofLocalShellCallOutput() {
        val localShellCallOutput =
            BetaResponseItem.LocalShellCallOutput.builder()
                .id("id")
                .output("output")
                .agent(
                    BetaResponseItem.LocalShellCallOutput.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .status(BetaResponseItem.LocalShellCallOutput.Status.IN_PROGRESS)
                .build()

        val betaResponseItem = BetaResponseItem.ofLocalShellCallOutput(localShellCallOutput)

        assertThat(betaResponseItem.betaResponseInputMessageItem()).isEmpty
        assertThat(betaResponseItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseItem.fileSearchCall()).isEmpty
        assertThat(betaResponseItem.computerCall()).isEmpty
        assertThat(betaResponseItem.computerCallOutput()).isEmpty
        assertThat(betaResponseItem.webSearchCall()).isEmpty
        assertThat(betaResponseItem.functionCall()).isEmpty
        assertThat(betaResponseItem.functionCallOutput()).isEmpty
        assertThat(betaResponseItem.agentMessage()).isEmpty
        assertThat(betaResponseItem.multiAgentCall()).isEmpty
        assertThat(betaResponseItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseItem.toolSearchCall()).isEmpty
        assertThat(betaResponseItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseItem.additionalTools()).isEmpty
        assertThat(betaResponseItem.reasoning()).isEmpty
        assertThat(betaResponseItem.program()).isEmpty
        assertThat(betaResponseItem.programOutput()).isEmpty
        assertThat(betaResponseItem.compaction()).isEmpty
        assertThat(betaResponseItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseItem.localShellCall()).isEmpty
        assertThat(betaResponseItem.localShellCallOutput()).contains(localShellCallOutput)
        assertThat(betaResponseItem.shellCall()).isEmpty
        assertThat(betaResponseItem.shellCallOutput()).isEmpty
        assertThat(betaResponseItem.applyPatchCall()).isEmpty
        assertThat(betaResponseItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseItem.mcpListTools()).isEmpty
        assertThat(betaResponseItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseItem.mcpCall()).isEmpty
        assertThat(betaResponseItem.customToolCall()).isEmpty
        assertThat(betaResponseItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofLocalShellCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItem =
            BetaResponseItem.ofLocalShellCallOutput(
                BetaResponseItem.LocalShellCallOutput.builder()
                    .id("id")
                    .output("output")
                    .agent(
                        BetaResponseItem.LocalShellCallOutput.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .status(BetaResponseItem.LocalShellCallOutput.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedBetaResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItem),
                jacksonTypeRef<BetaResponseItem>(),
            )

        assertThat(roundtrippedBetaResponseItem).isEqualTo(betaResponseItem)
    }

    @Test
    fun ofShellCall() {
        val shellCall =
            BetaResponseFunctionShellToolCall.builder()
                .id("id")
                .action(
                    BetaResponseFunctionShellToolCall.Action.builder()
                        .addCommand("string")
                        .maxOutputLength(0L)
                        .timeoutMs(0L)
                        .build()
                )
                .callId("call_id")
                .environment(BetaResponseLocalEnvironment.builder().build())
                .status(BetaResponseFunctionShellToolCall.Status.IN_PROGRESS)
                .agent(
                    BetaResponseFunctionShellToolCall.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .callerDirect()
                .createdBy("created_by")
                .build()

        val betaResponseItem = BetaResponseItem.ofShellCall(shellCall)

        assertThat(betaResponseItem.betaResponseInputMessageItem()).isEmpty
        assertThat(betaResponseItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseItem.fileSearchCall()).isEmpty
        assertThat(betaResponseItem.computerCall()).isEmpty
        assertThat(betaResponseItem.computerCallOutput()).isEmpty
        assertThat(betaResponseItem.webSearchCall()).isEmpty
        assertThat(betaResponseItem.functionCall()).isEmpty
        assertThat(betaResponseItem.functionCallOutput()).isEmpty
        assertThat(betaResponseItem.agentMessage()).isEmpty
        assertThat(betaResponseItem.multiAgentCall()).isEmpty
        assertThat(betaResponseItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseItem.toolSearchCall()).isEmpty
        assertThat(betaResponseItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseItem.additionalTools()).isEmpty
        assertThat(betaResponseItem.reasoning()).isEmpty
        assertThat(betaResponseItem.program()).isEmpty
        assertThat(betaResponseItem.programOutput()).isEmpty
        assertThat(betaResponseItem.compaction()).isEmpty
        assertThat(betaResponseItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseItem.localShellCall()).isEmpty
        assertThat(betaResponseItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseItem.shellCall()).contains(shellCall)
        assertThat(betaResponseItem.shellCallOutput()).isEmpty
        assertThat(betaResponseItem.applyPatchCall()).isEmpty
        assertThat(betaResponseItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseItem.mcpListTools()).isEmpty
        assertThat(betaResponseItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseItem.mcpCall()).isEmpty
        assertThat(betaResponseItem.customToolCall()).isEmpty
        assertThat(betaResponseItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofShellCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItem =
            BetaResponseItem.ofShellCall(
                BetaResponseFunctionShellToolCall.builder()
                    .id("id")
                    .action(
                        BetaResponseFunctionShellToolCall.Action.builder()
                            .addCommand("string")
                            .maxOutputLength(0L)
                            .timeoutMs(0L)
                            .build()
                    )
                    .callId("call_id")
                    .environment(BetaResponseLocalEnvironment.builder().build())
                    .status(BetaResponseFunctionShellToolCall.Status.IN_PROGRESS)
                    .agent(
                        BetaResponseFunctionShellToolCall.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .callerDirect()
                    .createdBy("created_by")
                    .build()
            )

        val roundtrippedBetaResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItem),
                jacksonTypeRef<BetaResponseItem>(),
            )

        assertThat(roundtrippedBetaResponseItem).isEqualTo(betaResponseItem)
    }

    @Test
    fun ofShellCallOutput() {
        val shellCallOutput =
            BetaResponseFunctionShellToolCallOutput.builder()
                .id("id")
                .callId("call_id")
                .maxOutputLength(0L)
                .addOutput(
                    BetaResponseFunctionShellToolCallOutput.Output.builder()
                        .outcomeTimeout()
                        .stderr("stderr")
                        .stdout("stdout")
                        .createdBy("created_by")
                        .build()
                )
                .status(BetaResponseFunctionShellToolCallOutput.Status.IN_PROGRESS)
                .agent(
                    BetaResponseFunctionShellToolCallOutput.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .callerDirect()
                .createdBy("created_by")
                .build()

        val betaResponseItem = BetaResponseItem.ofShellCallOutput(shellCallOutput)

        assertThat(betaResponseItem.betaResponseInputMessageItem()).isEmpty
        assertThat(betaResponseItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseItem.fileSearchCall()).isEmpty
        assertThat(betaResponseItem.computerCall()).isEmpty
        assertThat(betaResponseItem.computerCallOutput()).isEmpty
        assertThat(betaResponseItem.webSearchCall()).isEmpty
        assertThat(betaResponseItem.functionCall()).isEmpty
        assertThat(betaResponseItem.functionCallOutput()).isEmpty
        assertThat(betaResponseItem.agentMessage()).isEmpty
        assertThat(betaResponseItem.multiAgentCall()).isEmpty
        assertThat(betaResponseItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseItem.toolSearchCall()).isEmpty
        assertThat(betaResponseItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseItem.additionalTools()).isEmpty
        assertThat(betaResponseItem.reasoning()).isEmpty
        assertThat(betaResponseItem.program()).isEmpty
        assertThat(betaResponseItem.programOutput()).isEmpty
        assertThat(betaResponseItem.compaction()).isEmpty
        assertThat(betaResponseItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseItem.localShellCall()).isEmpty
        assertThat(betaResponseItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseItem.shellCall()).isEmpty
        assertThat(betaResponseItem.shellCallOutput()).contains(shellCallOutput)
        assertThat(betaResponseItem.applyPatchCall()).isEmpty
        assertThat(betaResponseItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseItem.mcpListTools()).isEmpty
        assertThat(betaResponseItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseItem.mcpCall()).isEmpty
        assertThat(betaResponseItem.customToolCall()).isEmpty
        assertThat(betaResponseItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofShellCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItem =
            BetaResponseItem.ofShellCallOutput(
                BetaResponseFunctionShellToolCallOutput.builder()
                    .id("id")
                    .callId("call_id")
                    .maxOutputLength(0L)
                    .addOutput(
                        BetaResponseFunctionShellToolCallOutput.Output.builder()
                            .outcomeTimeout()
                            .stderr("stderr")
                            .stdout("stdout")
                            .createdBy("created_by")
                            .build()
                    )
                    .status(BetaResponseFunctionShellToolCallOutput.Status.IN_PROGRESS)
                    .agent(
                        BetaResponseFunctionShellToolCallOutput.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .callerDirect()
                    .createdBy("created_by")
                    .build()
            )

        val roundtrippedBetaResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItem),
                jacksonTypeRef<BetaResponseItem>(),
            )

        assertThat(roundtrippedBetaResponseItem).isEqualTo(betaResponseItem)
    }

    @Test
    fun ofApplyPatchCall() {
        val applyPatchCall =
            BetaResponseApplyPatchToolCall.builder()
                .id("id")
                .callId("call_id")
                .operation(
                    BetaResponseApplyPatchToolCall.Operation.CreateFile.builder()
                        .diff("diff")
                        .path("path")
                        .build()
                )
                .status(BetaResponseApplyPatchToolCall.Status.IN_PROGRESS)
                .agent(
                    BetaResponseApplyPatchToolCall.Agent.builder().agentName("agent_name").build()
                )
                .callerDirect()
                .createdBy("created_by")
                .build()

        val betaResponseItem = BetaResponseItem.ofApplyPatchCall(applyPatchCall)

        assertThat(betaResponseItem.betaResponseInputMessageItem()).isEmpty
        assertThat(betaResponseItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseItem.fileSearchCall()).isEmpty
        assertThat(betaResponseItem.computerCall()).isEmpty
        assertThat(betaResponseItem.computerCallOutput()).isEmpty
        assertThat(betaResponseItem.webSearchCall()).isEmpty
        assertThat(betaResponseItem.functionCall()).isEmpty
        assertThat(betaResponseItem.functionCallOutput()).isEmpty
        assertThat(betaResponseItem.agentMessage()).isEmpty
        assertThat(betaResponseItem.multiAgentCall()).isEmpty
        assertThat(betaResponseItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseItem.toolSearchCall()).isEmpty
        assertThat(betaResponseItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseItem.additionalTools()).isEmpty
        assertThat(betaResponseItem.reasoning()).isEmpty
        assertThat(betaResponseItem.program()).isEmpty
        assertThat(betaResponseItem.programOutput()).isEmpty
        assertThat(betaResponseItem.compaction()).isEmpty
        assertThat(betaResponseItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseItem.localShellCall()).isEmpty
        assertThat(betaResponseItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseItem.shellCall()).isEmpty
        assertThat(betaResponseItem.shellCallOutput()).isEmpty
        assertThat(betaResponseItem.applyPatchCall()).contains(applyPatchCall)
        assertThat(betaResponseItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseItem.mcpListTools()).isEmpty
        assertThat(betaResponseItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseItem.mcpCall()).isEmpty
        assertThat(betaResponseItem.customToolCall()).isEmpty
        assertThat(betaResponseItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofApplyPatchCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItem =
            BetaResponseItem.ofApplyPatchCall(
                BetaResponseApplyPatchToolCall.builder()
                    .id("id")
                    .callId("call_id")
                    .operation(
                        BetaResponseApplyPatchToolCall.Operation.CreateFile.builder()
                            .diff("diff")
                            .path("path")
                            .build()
                    )
                    .status(BetaResponseApplyPatchToolCall.Status.IN_PROGRESS)
                    .agent(
                        BetaResponseApplyPatchToolCall.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .callerDirect()
                    .createdBy("created_by")
                    .build()
            )

        val roundtrippedBetaResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItem),
                jacksonTypeRef<BetaResponseItem>(),
            )

        assertThat(roundtrippedBetaResponseItem).isEqualTo(betaResponseItem)
    }

    @Test
    fun ofApplyPatchCallOutput() {
        val applyPatchCallOutput =
            BetaResponseApplyPatchToolCallOutput.builder()
                .id("id")
                .callId("call_id")
                .status(BetaResponseApplyPatchToolCallOutput.Status.COMPLETED)
                .agent(
                    BetaResponseApplyPatchToolCallOutput.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .callerDirect()
                .createdBy("created_by")
                .output("output")
                .build()

        val betaResponseItem = BetaResponseItem.ofApplyPatchCallOutput(applyPatchCallOutput)

        assertThat(betaResponseItem.betaResponseInputMessageItem()).isEmpty
        assertThat(betaResponseItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseItem.fileSearchCall()).isEmpty
        assertThat(betaResponseItem.computerCall()).isEmpty
        assertThat(betaResponseItem.computerCallOutput()).isEmpty
        assertThat(betaResponseItem.webSearchCall()).isEmpty
        assertThat(betaResponseItem.functionCall()).isEmpty
        assertThat(betaResponseItem.functionCallOutput()).isEmpty
        assertThat(betaResponseItem.agentMessage()).isEmpty
        assertThat(betaResponseItem.multiAgentCall()).isEmpty
        assertThat(betaResponseItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseItem.toolSearchCall()).isEmpty
        assertThat(betaResponseItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseItem.additionalTools()).isEmpty
        assertThat(betaResponseItem.reasoning()).isEmpty
        assertThat(betaResponseItem.program()).isEmpty
        assertThat(betaResponseItem.programOutput()).isEmpty
        assertThat(betaResponseItem.compaction()).isEmpty
        assertThat(betaResponseItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseItem.localShellCall()).isEmpty
        assertThat(betaResponseItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseItem.shellCall()).isEmpty
        assertThat(betaResponseItem.shellCallOutput()).isEmpty
        assertThat(betaResponseItem.applyPatchCall()).isEmpty
        assertThat(betaResponseItem.applyPatchCallOutput()).contains(applyPatchCallOutput)
        assertThat(betaResponseItem.mcpListTools()).isEmpty
        assertThat(betaResponseItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseItem.mcpCall()).isEmpty
        assertThat(betaResponseItem.customToolCall()).isEmpty
        assertThat(betaResponseItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofApplyPatchCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItem =
            BetaResponseItem.ofApplyPatchCallOutput(
                BetaResponseApplyPatchToolCallOutput.builder()
                    .id("id")
                    .callId("call_id")
                    .status(BetaResponseApplyPatchToolCallOutput.Status.COMPLETED)
                    .agent(
                        BetaResponseApplyPatchToolCallOutput.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .callerDirect()
                    .createdBy("created_by")
                    .output("output")
                    .build()
            )

        val roundtrippedBetaResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItem),
                jacksonTypeRef<BetaResponseItem>(),
            )

        assertThat(roundtrippedBetaResponseItem).isEqualTo(betaResponseItem)
    }

    @Test
    fun ofMcpListTools() {
        val mcpListTools =
            BetaResponseItem.McpListTools.builder()
                .id("id")
                .serverLabel("server_label")
                .addTool(
                    BetaResponseItem.McpListTools.Tool.builder()
                        .inputSchema(JsonValue.from(mapOf<String, Any>()))
                        .name("name")
                        .annotations(JsonValue.from(mapOf<String, Any>()))
                        .description("description")
                        .build()
                )
                .agent(
                    BetaResponseItem.McpListTools.Agent.builder().agentName("agent_name").build()
                )
                .error("error")
                .build()

        val betaResponseItem = BetaResponseItem.ofMcpListTools(mcpListTools)

        assertThat(betaResponseItem.betaResponseInputMessageItem()).isEmpty
        assertThat(betaResponseItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseItem.fileSearchCall()).isEmpty
        assertThat(betaResponseItem.computerCall()).isEmpty
        assertThat(betaResponseItem.computerCallOutput()).isEmpty
        assertThat(betaResponseItem.webSearchCall()).isEmpty
        assertThat(betaResponseItem.functionCall()).isEmpty
        assertThat(betaResponseItem.functionCallOutput()).isEmpty
        assertThat(betaResponseItem.agentMessage()).isEmpty
        assertThat(betaResponseItem.multiAgentCall()).isEmpty
        assertThat(betaResponseItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseItem.toolSearchCall()).isEmpty
        assertThat(betaResponseItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseItem.additionalTools()).isEmpty
        assertThat(betaResponseItem.reasoning()).isEmpty
        assertThat(betaResponseItem.program()).isEmpty
        assertThat(betaResponseItem.programOutput()).isEmpty
        assertThat(betaResponseItem.compaction()).isEmpty
        assertThat(betaResponseItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseItem.localShellCall()).isEmpty
        assertThat(betaResponseItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseItem.shellCall()).isEmpty
        assertThat(betaResponseItem.shellCallOutput()).isEmpty
        assertThat(betaResponseItem.applyPatchCall()).isEmpty
        assertThat(betaResponseItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseItem.mcpListTools()).contains(mcpListTools)
        assertThat(betaResponseItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseItem.mcpCall()).isEmpty
        assertThat(betaResponseItem.customToolCall()).isEmpty
        assertThat(betaResponseItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofMcpListToolsRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItem =
            BetaResponseItem.ofMcpListTools(
                BetaResponseItem.McpListTools.builder()
                    .id("id")
                    .serverLabel("server_label")
                    .addTool(
                        BetaResponseItem.McpListTools.Tool.builder()
                            .inputSchema(JsonValue.from(mapOf<String, Any>()))
                            .name("name")
                            .annotations(JsonValue.from(mapOf<String, Any>()))
                            .description("description")
                            .build()
                    )
                    .agent(
                        BetaResponseItem.McpListTools.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .error("error")
                    .build()
            )

        val roundtrippedBetaResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItem),
                jacksonTypeRef<BetaResponseItem>(),
            )

        assertThat(roundtrippedBetaResponseItem).isEqualTo(betaResponseItem)
    }

    @Test
    fun ofMcpApprovalRequest() {
        val mcpApprovalRequest =
            BetaResponseItem.McpApprovalRequest.builder()
                .id("id")
                .arguments("arguments")
                .name("name")
                .serverLabel("server_label")
                .agent(
                    BetaResponseItem.McpApprovalRequest.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val betaResponseItem = BetaResponseItem.ofMcpApprovalRequest(mcpApprovalRequest)

        assertThat(betaResponseItem.betaResponseInputMessageItem()).isEmpty
        assertThat(betaResponseItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseItem.fileSearchCall()).isEmpty
        assertThat(betaResponseItem.computerCall()).isEmpty
        assertThat(betaResponseItem.computerCallOutput()).isEmpty
        assertThat(betaResponseItem.webSearchCall()).isEmpty
        assertThat(betaResponseItem.functionCall()).isEmpty
        assertThat(betaResponseItem.functionCallOutput()).isEmpty
        assertThat(betaResponseItem.agentMessage()).isEmpty
        assertThat(betaResponseItem.multiAgentCall()).isEmpty
        assertThat(betaResponseItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseItem.toolSearchCall()).isEmpty
        assertThat(betaResponseItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseItem.additionalTools()).isEmpty
        assertThat(betaResponseItem.reasoning()).isEmpty
        assertThat(betaResponseItem.program()).isEmpty
        assertThat(betaResponseItem.programOutput()).isEmpty
        assertThat(betaResponseItem.compaction()).isEmpty
        assertThat(betaResponseItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseItem.localShellCall()).isEmpty
        assertThat(betaResponseItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseItem.shellCall()).isEmpty
        assertThat(betaResponseItem.shellCallOutput()).isEmpty
        assertThat(betaResponseItem.applyPatchCall()).isEmpty
        assertThat(betaResponseItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseItem.mcpListTools()).isEmpty
        assertThat(betaResponseItem.mcpApprovalRequest()).contains(mcpApprovalRequest)
        assertThat(betaResponseItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseItem.mcpCall()).isEmpty
        assertThat(betaResponseItem.customToolCall()).isEmpty
        assertThat(betaResponseItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofMcpApprovalRequestRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItem =
            BetaResponseItem.ofMcpApprovalRequest(
                BetaResponseItem.McpApprovalRequest.builder()
                    .id("id")
                    .arguments("arguments")
                    .name("name")
                    .serverLabel("server_label")
                    .agent(
                        BetaResponseItem.McpApprovalRequest.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItem),
                jacksonTypeRef<BetaResponseItem>(),
            )

        assertThat(roundtrippedBetaResponseItem).isEqualTo(betaResponseItem)
    }

    @Test
    fun ofMcpApprovalResponse() {
        val mcpApprovalResponse =
            BetaResponseItem.McpApprovalResponse.builder()
                .id("id")
                .approvalRequestId("approval_request_id")
                .approve(true)
                .agent(
                    BetaResponseItem.McpApprovalResponse.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .reason("reason")
                .build()

        val betaResponseItem = BetaResponseItem.ofMcpApprovalResponse(mcpApprovalResponse)

        assertThat(betaResponseItem.betaResponseInputMessageItem()).isEmpty
        assertThat(betaResponseItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseItem.fileSearchCall()).isEmpty
        assertThat(betaResponseItem.computerCall()).isEmpty
        assertThat(betaResponseItem.computerCallOutput()).isEmpty
        assertThat(betaResponseItem.webSearchCall()).isEmpty
        assertThat(betaResponseItem.functionCall()).isEmpty
        assertThat(betaResponseItem.functionCallOutput()).isEmpty
        assertThat(betaResponseItem.agentMessage()).isEmpty
        assertThat(betaResponseItem.multiAgentCall()).isEmpty
        assertThat(betaResponseItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseItem.toolSearchCall()).isEmpty
        assertThat(betaResponseItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseItem.additionalTools()).isEmpty
        assertThat(betaResponseItem.reasoning()).isEmpty
        assertThat(betaResponseItem.program()).isEmpty
        assertThat(betaResponseItem.programOutput()).isEmpty
        assertThat(betaResponseItem.compaction()).isEmpty
        assertThat(betaResponseItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseItem.localShellCall()).isEmpty
        assertThat(betaResponseItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseItem.shellCall()).isEmpty
        assertThat(betaResponseItem.shellCallOutput()).isEmpty
        assertThat(betaResponseItem.applyPatchCall()).isEmpty
        assertThat(betaResponseItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseItem.mcpListTools()).isEmpty
        assertThat(betaResponseItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseItem.mcpApprovalResponse()).contains(mcpApprovalResponse)
        assertThat(betaResponseItem.mcpCall()).isEmpty
        assertThat(betaResponseItem.customToolCall()).isEmpty
        assertThat(betaResponseItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofMcpApprovalResponseRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItem =
            BetaResponseItem.ofMcpApprovalResponse(
                BetaResponseItem.McpApprovalResponse.builder()
                    .id("id")
                    .approvalRequestId("approval_request_id")
                    .approve(true)
                    .agent(
                        BetaResponseItem.McpApprovalResponse.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .reason("reason")
                    .build()
            )

        val roundtrippedBetaResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItem),
                jacksonTypeRef<BetaResponseItem>(),
            )

        assertThat(roundtrippedBetaResponseItem).isEqualTo(betaResponseItem)
    }

    @Test
    fun ofMcpCall() {
        val mcpCall =
            BetaResponseItem.McpCall.builder()
                .id("id")
                .arguments("arguments")
                .name("name")
                .serverLabel("server_label")
                .agent(BetaResponseItem.McpCall.Agent.builder().agentName("agent_name").build())
                .approvalRequestId("approval_request_id")
                .error("error")
                .output("output")
                .status(BetaResponseItem.McpCall.Status.IN_PROGRESS)
                .build()

        val betaResponseItem = BetaResponseItem.ofMcpCall(mcpCall)

        assertThat(betaResponseItem.betaResponseInputMessageItem()).isEmpty
        assertThat(betaResponseItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseItem.fileSearchCall()).isEmpty
        assertThat(betaResponseItem.computerCall()).isEmpty
        assertThat(betaResponseItem.computerCallOutput()).isEmpty
        assertThat(betaResponseItem.webSearchCall()).isEmpty
        assertThat(betaResponseItem.functionCall()).isEmpty
        assertThat(betaResponseItem.functionCallOutput()).isEmpty
        assertThat(betaResponseItem.agentMessage()).isEmpty
        assertThat(betaResponseItem.multiAgentCall()).isEmpty
        assertThat(betaResponseItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseItem.toolSearchCall()).isEmpty
        assertThat(betaResponseItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseItem.additionalTools()).isEmpty
        assertThat(betaResponseItem.reasoning()).isEmpty
        assertThat(betaResponseItem.program()).isEmpty
        assertThat(betaResponseItem.programOutput()).isEmpty
        assertThat(betaResponseItem.compaction()).isEmpty
        assertThat(betaResponseItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseItem.localShellCall()).isEmpty
        assertThat(betaResponseItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseItem.shellCall()).isEmpty
        assertThat(betaResponseItem.shellCallOutput()).isEmpty
        assertThat(betaResponseItem.applyPatchCall()).isEmpty
        assertThat(betaResponseItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseItem.mcpListTools()).isEmpty
        assertThat(betaResponseItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseItem.mcpCall()).contains(mcpCall)
        assertThat(betaResponseItem.customToolCall()).isEmpty
        assertThat(betaResponseItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofMcpCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItem =
            BetaResponseItem.ofMcpCall(
                BetaResponseItem.McpCall.builder()
                    .id("id")
                    .arguments("arguments")
                    .name("name")
                    .serverLabel("server_label")
                    .agent(BetaResponseItem.McpCall.Agent.builder().agentName("agent_name").build())
                    .approvalRequestId("approval_request_id")
                    .error("error")
                    .output("output")
                    .status(BetaResponseItem.McpCall.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedBetaResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItem),
                jacksonTypeRef<BetaResponseItem>(),
            )

        assertThat(roundtrippedBetaResponseItem).isEqualTo(betaResponseItem)
    }

    @Test
    fun ofCustomToolCall() {
        val customToolCall =
            BetaResponseCustomToolCallItem.builder()
                .callId("call_id")
                .input("input")
                .name("name")
                .id("id")
                .agent(BetaResponseCustomToolCall.Agent.builder().agentName("agent_name").build())
                .callerDirect()
                .namespace("namespace")
                .status(BetaResponseCustomToolCallItem.Status.IN_PROGRESS)
                .createdBy("created_by")
                .build()

        val betaResponseItem = BetaResponseItem.ofCustomToolCall(customToolCall)

        assertThat(betaResponseItem.betaResponseInputMessageItem()).isEmpty
        assertThat(betaResponseItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseItem.fileSearchCall()).isEmpty
        assertThat(betaResponseItem.computerCall()).isEmpty
        assertThat(betaResponseItem.computerCallOutput()).isEmpty
        assertThat(betaResponseItem.webSearchCall()).isEmpty
        assertThat(betaResponseItem.functionCall()).isEmpty
        assertThat(betaResponseItem.functionCallOutput()).isEmpty
        assertThat(betaResponseItem.agentMessage()).isEmpty
        assertThat(betaResponseItem.multiAgentCall()).isEmpty
        assertThat(betaResponseItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseItem.toolSearchCall()).isEmpty
        assertThat(betaResponseItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseItem.additionalTools()).isEmpty
        assertThat(betaResponseItem.reasoning()).isEmpty
        assertThat(betaResponseItem.program()).isEmpty
        assertThat(betaResponseItem.programOutput()).isEmpty
        assertThat(betaResponseItem.compaction()).isEmpty
        assertThat(betaResponseItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseItem.localShellCall()).isEmpty
        assertThat(betaResponseItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseItem.shellCall()).isEmpty
        assertThat(betaResponseItem.shellCallOutput()).isEmpty
        assertThat(betaResponseItem.applyPatchCall()).isEmpty
        assertThat(betaResponseItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseItem.mcpListTools()).isEmpty
        assertThat(betaResponseItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseItem.mcpCall()).isEmpty
        assertThat(betaResponseItem.customToolCall()).contains(customToolCall)
        assertThat(betaResponseItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofCustomToolCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItem =
            BetaResponseItem.ofCustomToolCall(
                BetaResponseCustomToolCallItem.builder()
                    .callId("call_id")
                    .input("input")
                    .name("name")
                    .id("id")
                    .agent(
                        BetaResponseCustomToolCall.Agent.builder().agentName("agent_name").build()
                    )
                    .callerDirect()
                    .namespace("namespace")
                    .status(BetaResponseCustomToolCallItem.Status.IN_PROGRESS)
                    .createdBy("created_by")
                    .build()
            )

        val roundtrippedBetaResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItem),
                jacksonTypeRef<BetaResponseItem>(),
            )

        assertThat(roundtrippedBetaResponseItem).isEqualTo(betaResponseItem)
    }

    @Test
    fun ofCustomToolCallOutput() {
        val customToolCallOutput =
            BetaResponseCustomToolCallOutputItem.builder()
                .callId("call_id")
                .output("string")
                .id("id")
                .agent(
                    BetaResponseCustomToolCallOutput.Agent.builder().agentName("agent_name").build()
                )
                .callerDirect()
                .status(BetaResponseCustomToolCallOutputItem.Status.IN_PROGRESS)
                .createdBy("created_by")
                .build()

        val betaResponseItem = BetaResponseItem.ofCustomToolCallOutput(customToolCallOutput)

        assertThat(betaResponseItem.betaResponseInputMessageItem()).isEmpty
        assertThat(betaResponseItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseItem.fileSearchCall()).isEmpty
        assertThat(betaResponseItem.computerCall()).isEmpty
        assertThat(betaResponseItem.computerCallOutput()).isEmpty
        assertThat(betaResponseItem.webSearchCall()).isEmpty
        assertThat(betaResponseItem.functionCall()).isEmpty
        assertThat(betaResponseItem.functionCallOutput()).isEmpty
        assertThat(betaResponseItem.agentMessage()).isEmpty
        assertThat(betaResponseItem.multiAgentCall()).isEmpty
        assertThat(betaResponseItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseItem.toolSearchCall()).isEmpty
        assertThat(betaResponseItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseItem.additionalTools()).isEmpty
        assertThat(betaResponseItem.reasoning()).isEmpty
        assertThat(betaResponseItem.program()).isEmpty
        assertThat(betaResponseItem.programOutput()).isEmpty
        assertThat(betaResponseItem.compaction()).isEmpty
        assertThat(betaResponseItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseItem.localShellCall()).isEmpty
        assertThat(betaResponseItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseItem.shellCall()).isEmpty
        assertThat(betaResponseItem.shellCallOutput()).isEmpty
        assertThat(betaResponseItem.applyPatchCall()).isEmpty
        assertThat(betaResponseItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseItem.mcpListTools()).isEmpty
        assertThat(betaResponseItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseItem.mcpCall()).isEmpty
        assertThat(betaResponseItem.customToolCall()).isEmpty
        assertThat(betaResponseItem.customToolCallOutput()).contains(customToolCallOutput)
    }

    @Test
    fun ofCustomToolCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseItem =
            BetaResponseItem.ofCustomToolCallOutput(
                BetaResponseCustomToolCallOutputItem.builder()
                    .callId("call_id")
                    .output("string")
                    .id("id")
                    .agent(
                        BetaResponseCustomToolCallOutput.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .callerDirect()
                    .status(BetaResponseCustomToolCallOutputItem.Status.IN_PROGRESS)
                    .createdBy("created_by")
                    .build()
            )

        val roundtrippedBetaResponseItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseItem),
                jacksonTypeRef<BetaResponseItem>(),
            )

        assertThat(roundtrippedBetaResponseItem).isEqualTo(betaResponseItem)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val betaResponseItem =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<BetaResponseItem>())

        val e = assertThrows<OpenAIInvalidDataException> { betaResponseItem.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
