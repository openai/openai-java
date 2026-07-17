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

internal class BetaResponseInputItemTest {

    @Test
    fun ofBetaEasyInputMessage() {
        val betaEasyInputMessage =
            BetaEasyInputMessage.builder()
                .content("string")
                .role(BetaEasyInputMessage.Role.USER)
                .phase(BetaEasyInputMessage.Phase.COMMENTARY)
                .type(BetaEasyInputMessage.Type.MESSAGE)
                .build()

        val betaResponseInputItem =
            BetaResponseInputItem.ofBetaEasyInputMessage(betaEasyInputMessage)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).contains(betaEasyInputMessage)
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofBetaEasyInputMessageRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofBetaEasyInputMessage(
                BetaEasyInputMessage.builder()
                    .content("string")
                    .role(BetaEasyInputMessage.Role.USER)
                    .phase(BetaEasyInputMessage.Phase.COMMENTARY)
                    .type(BetaEasyInputMessage.Type.MESSAGE)
                    .build()
            )

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
    }

    @Test
    fun ofMessage() {
        val message =
            BetaResponseInputItem.Message.builder()
                .addContent(
                    BetaResponseInputText.builder()
                        .text("text")
                        .promptCacheBreakpoint(
                            BetaResponseInputText.PromptCacheBreakpoint.builder().build()
                        )
                        .build()
                )
                .role(BetaResponseInputItem.Message.Role.USER)
                .agent(
                    BetaResponseInputItem.Message.Agent.builder().agentName("agent_name").build()
                )
                .status(BetaResponseInputItem.Message.Status.IN_PROGRESS)
                .type(BetaResponseInputItem.Message.Type.MESSAGE)
                .build()

        val betaResponseInputItem = BetaResponseInputItem.ofMessage(message)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).contains(message)
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofMessageRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofMessage(
                BetaResponseInputItem.Message.builder()
                    .addContent(
                        BetaResponseInputText.builder()
                            .text("text")
                            .promptCacheBreakpoint(
                                BetaResponseInputText.PromptCacheBreakpoint.builder().build()
                            )
                            .build()
                    )
                    .role(BetaResponseInputItem.Message.Role.USER)
                    .agent(
                        BetaResponseInputItem.Message.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .status(BetaResponseInputItem.Message.Status.IN_PROGRESS)
                    .type(BetaResponseInputItem.Message.Type.MESSAGE)
                    .build()
            )

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
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

        val betaResponseInputItem =
            BetaResponseInputItem.ofBetaResponseOutputMessage(betaResponseOutputMessage)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage())
            .contains(betaResponseOutputMessage)
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofBetaResponseOutputMessageRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofBetaResponseOutputMessage(
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

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
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

        val betaResponseInputItem = BetaResponseInputItem.ofFileSearchCall(fileSearchCall)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).contains(fileSearchCall)
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofFileSearchCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofFileSearchCall(
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

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
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

        val betaResponseInputItem = BetaResponseInputItem.ofComputerCall(computerCall)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).contains(computerCall)
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofComputerCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofComputerCall(
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

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
    }

    @Test
    fun ofComputerCallOutput() {
        val computerCallOutput =
            BetaResponseInputItem.ComputerCallOutput.builder()
                .callId("x")
                .output(
                    BetaResponseComputerToolCallOutputScreenshot.builder()
                        .fileId("file_id")
                        .imageUrl("https://example.com")
                        .build()
                )
                .id("cuo_123")
                .addAcknowledgedSafetyCheck(
                    BetaResponseInputItem.ComputerCallOutput.AcknowledgedSafetyCheck.builder()
                        .id("id")
                        .code("code")
                        .message("message")
                        .build()
                )
                .agent(
                    BetaResponseInputItem.ComputerCallOutput.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .status(BetaResponseInputItem.ComputerCallOutput.Status.IN_PROGRESS)
                .build()

        val betaResponseInputItem = BetaResponseInputItem.ofComputerCallOutput(computerCallOutput)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).contains(computerCallOutput)
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofComputerCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofComputerCallOutput(
                BetaResponseInputItem.ComputerCallOutput.builder()
                    .callId("x")
                    .output(
                        BetaResponseComputerToolCallOutputScreenshot.builder()
                            .fileId("file_id")
                            .imageUrl("https://example.com")
                            .build()
                    )
                    .id("cuo_123")
                    .addAcknowledgedSafetyCheck(
                        BetaResponseInputItem.ComputerCallOutput.AcknowledgedSafetyCheck.builder()
                            .id("id")
                            .code("code")
                            .message("message")
                            .build()
                    )
                    .agent(
                        BetaResponseInputItem.ComputerCallOutput.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .status(BetaResponseInputItem.ComputerCallOutput.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
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

        val betaResponseInputItem = BetaResponseInputItem.ofWebSearchCall(webSearchCall)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).contains(webSearchCall)
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofWebSearchCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofWebSearchCall(
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

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
    }

    @Test
    fun ofFunctionCall() {
        val functionCall =
            BetaResponseFunctionToolCall.builder()
                .arguments("arguments")
                .callId("call_id")
                .name("name")
                .id("id")
                .agent(BetaResponseFunctionToolCall.Agent.builder().agentName("agent_name").build())
                .callerDirect()
                .namespace("namespace")
                .status(BetaResponseFunctionToolCall.Status.IN_PROGRESS)
                .build()

        val betaResponseInputItem = BetaResponseInputItem.ofFunctionCall(functionCall)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).contains(functionCall)
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofFunctionCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofFunctionCall(
                BetaResponseFunctionToolCall.builder()
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
                    .build()
            )

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
    }

    @Test
    fun ofFunctionCallOutput() {
        val functionCallOutput =
            BetaResponseInputItem.FunctionCallOutput.builder()
                .callId("x")
                .output("string")
                .id("fc_123")
                .agent(
                    BetaResponseInputItem.FunctionCallOutput.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .callerDirect()
                .status(BetaResponseInputItem.FunctionCallOutput.Status.IN_PROGRESS)
                .build()

        val betaResponseInputItem = BetaResponseInputItem.ofFunctionCallOutput(functionCallOutput)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).contains(functionCallOutput)
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofFunctionCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofFunctionCallOutput(
                BetaResponseInputItem.FunctionCallOutput.builder()
                    .callId("x")
                    .output("string")
                    .id("fc_123")
                    .agent(
                        BetaResponseInputItem.FunctionCallOutput.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .callerDirect()
                    .status(BetaResponseInputItem.FunctionCallOutput.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
    }

    @Test
    fun ofAgentMessage() {
        val agentMessage =
            BetaResponseInputItem.AgentMessage.builder()
                .author("author")
                .addContent(
                    BetaResponseInputTextContent.builder()
                        .text("text")
                        .promptCacheBreakpoint(
                            BetaResponseInputTextContent.PromptCacheBreakpoint.builder().build()
                        )
                        .build()
                )
                .recipient("recipient")
                .id("amsg_123")
                .agent(
                    BetaResponseInputItem.AgentMessage.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val betaResponseInputItem = BetaResponseInputItem.ofAgentMessage(agentMessage)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).contains(agentMessage)
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofAgentMessageRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofAgentMessage(
                BetaResponseInputItem.AgentMessage.builder()
                    .author("author")
                    .addContent(
                        BetaResponseInputTextContent.builder()
                            .text("text")
                            .promptCacheBreakpoint(
                                BetaResponseInputTextContent.PromptCacheBreakpoint.builder().build()
                            )
                            .build()
                    )
                    .recipient("recipient")
                    .id("amsg_123")
                    .agent(
                        BetaResponseInputItem.AgentMessage.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
    }

    @Test
    fun ofMultiAgentCall() {
        val multiAgentCall =
            BetaResponseInputItem.MultiAgentCall.builder()
                .action(BetaResponseInputItem.MultiAgentCall.Action.SPAWN_AGENT)
                .arguments("arguments")
                .callId("x")
                .id("mac_123")
                .agent(
                    BetaResponseInputItem.MultiAgentCall.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val betaResponseInputItem = BetaResponseInputItem.ofMultiAgentCall(multiAgentCall)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).contains(multiAgentCall)
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofMultiAgentCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofMultiAgentCall(
                BetaResponseInputItem.MultiAgentCall.builder()
                    .action(BetaResponseInputItem.MultiAgentCall.Action.SPAWN_AGENT)
                    .arguments("arguments")
                    .callId("x")
                    .id("mac_123")
                    .agent(
                        BetaResponseInputItem.MultiAgentCall.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
    }

    @Test
    fun ofMultiAgentCallOutput() {
        val multiAgentCallOutput =
            BetaResponseInputItem.MultiAgentCallOutput.builder()
                .action(BetaResponseInputItem.MultiAgentCallOutput.Action.SPAWN_AGENT)
                .callId("x")
                .addOutput(
                    BetaResponseInputItem.MultiAgentCallOutput.Output.builder()
                        .text("text")
                        .addAnnotation(
                            BetaResponseInputItem.MultiAgentCallOutput.Output.Annotation
                                .FileCitation
                                .builder()
                                .fileId("file-123")
                                .filename("filename")
                                .index(0L)
                                .build()
                        )
                        .build()
                )
                .id("maco_123")
                .agent(
                    BetaResponseInputItem.MultiAgentCallOutput.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val betaResponseInputItem =
            BetaResponseInputItem.ofMultiAgentCallOutput(multiAgentCallOutput)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).contains(multiAgentCallOutput)
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofMultiAgentCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofMultiAgentCallOutput(
                BetaResponseInputItem.MultiAgentCallOutput.builder()
                    .action(BetaResponseInputItem.MultiAgentCallOutput.Action.SPAWN_AGENT)
                    .callId("x")
                    .addOutput(
                        BetaResponseInputItem.MultiAgentCallOutput.Output.builder()
                            .text("text")
                            .addAnnotation(
                                BetaResponseInputItem.MultiAgentCallOutput.Output.Annotation
                                    .FileCitation
                                    .builder()
                                    .fileId("file-123")
                                    .filename("filename")
                                    .index(0L)
                                    .build()
                            )
                            .build()
                    )
                    .id("maco_123")
                    .agent(
                        BetaResponseInputItem.MultiAgentCallOutput.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
    }

    @Test
    fun ofToolSearchCall() {
        val toolSearchCall =
            BetaResponseInputItem.ToolSearchCall.builder()
                .arguments(JsonValue.from(mapOf<String, Any>()))
                .id("tsc_123")
                .agent(
                    BetaResponseInputItem.ToolSearchCall.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .callId("x")
                .execution(BetaResponseInputItem.ToolSearchCall.Execution.SERVER)
                .status(BetaResponseInputItem.ToolSearchCall.Status.IN_PROGRESS)
                .build()

        val betaResponseInputItem = BetaResponseInputItem.ofToolSearchCall(toolSearchCall)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).contains(toolSearchCall)
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofToolSearchCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofToolSearchCall(
                BetaResponseInputItem.ToolSearchCall.builder()
                    .arguments(JsonValue.from(mapOf<String, Any>()))
                    .id("tsc_123")
                    .agent(
                        BetaResponseInputItem.ToolSearchCall.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .callId("x")
                    .execution(BetaResponseInputItem.ToolSearchCall.Execution.SERVER)
                    .status(BetaResponseInputItem.ToolSearchCall.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
    }

    @Test
    fun ofToolSearchOutput() {
        val toolSearchOutput =
            BetaResponseToolSearchOutputItemParam.builder()
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
                .id("tso_123")
                .agent(
                    BetaResponseToolSearchOutputItemParam.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .callId("x")
                .execution(BetaResponseToolSearchOutputItemParam.Execution.SERVER)
                .status(BetaResponseToolSearchOutputItemParam.Status.IN_PROGRESS)
                .build()

        val betaResponseInputItem = BetaResponseInputItem.ofToolSearchOutput(toolSearchOutput)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).contains(toolSearchOutput)
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofToolSearchOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofToolSearchOutput(
                BetaResponseToolSearchOutputItemParam.builder()
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
                    .id("tso_123")
                    .agent(
                        BetaResponseToolSearchOutputItemParam.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .callId("x")
                    .execution(BetaResponseToolSearchOutputItemParam.Execution.SERVER)
                    .status(BetaResponseToolSearchOutputItemParam.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
    }

    @Test
    fun ofAdditionalTools() {
        val additionalTools =
            BetaResponseInputItem.AdditionalTools.builder()
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
                .id("at_123")
                .agent(
                    BetaResponseInputItem.AdditionalTools.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val betaResponseInputItem = BetaResponseInputItem.ofAdditionalTools(additionalTools)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).contains(additionalTools)
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofAdditionalToolsRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofAdditionalTools(
                BetaResponseInputItem.AdditionalTools.builder()
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
                    .id("at_123")
                    .agent(
                        BetaResponseInputItem.AdditionalTools.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
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

        val betaResponseInputItem = BetaResponseInputItem.ofReasoning(reasoning)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).contains(reasoning)
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofReasoningRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofReasoning(
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

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
    }

    @Test
    fun ofCompaction() {
        val compaction =
            BetaResponseCompactionItemParam.builder()
                .encryptedContent("encrypted_content")
                .id("cmp_123")
                .agent(
                    BetaResponseCompactionItemParam.Agent.builder().agentName("agent_name").build()
                )
                .build()

        val betaResponseInputItem = BetaResponseInputItem.ofCompaction(compaction)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).contains(compaction)
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofCompactionRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofCompaction(
                BetaResponseCompactionItemParam.builder()
                    .encryptedContent("encrypted_content")
                    .id("cmp_123")
                    .agent(
                        BetaResponseCompactionItemParam.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
    }

    @Test
    fun ofImageGenerationCall() {
        val imageGenerationCall =
            BetaResponseInputItem.ImageGenerationCall.builder()
                .id("id")
                .result("result")
                .status(BetaResponseInputItem.ImageGenerationCall.Status.IN_PROGRESS)
                .agent(
                    BetaResponseInputItem.ImageGenerationCall.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val betaResponseInputItem = BetaResponseInputItem.ofImageGenerationCall(imageGenerationCall)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).contains(imageGenerationCall)
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofImageGenerationCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofImageGenerationCall(
                BetaResponseInputItem.ImageGenerationCall.builder()
                    .id("id")
                    .result("result")
                    .status(BetaResponseInputItem.ImageGenerationCall.Status.IN_PROGRESS)
                    .agent(
                        BetaResponseInputItem.ImageGenerationCall.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
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

        val betaResponseInputItem = BetaResponseInputItem.ofCodeInterpreterCall(codeInterpreterCall)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).contains(codeInterpreterCall)
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofCodeInterpreterCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofCodeInterpreterCall(
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

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
    }

    @Test
    fun ofLocalShellCall() {
        val localShellCall =
            BetaResponseInputItem.LocalShellCall.builder()
                .id("id")
                .action(
                    BetaResponseInputItem.LocalShellCall.Action.builder()
                        .addCommand("string")
                        .env(
                            BetaResponseInputItem.LocalShellCall.Action.Env.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .timeoutMs(0L)
                        .user("user")
                        .workingDirectory("working_directory")
                        .build()
                )
                .callId("call_id")
                .status(BetaResponseInputItem.LocalShellCall.Status.IN_PROGRESS)
                .agent(
                    BetaResponseInputItem.LocalShellCall.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val betaResponseInputItem = BetaResponseInputItem.ofLocalShellCall(localShellCall)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).contains(localShellCall)
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofLocalShellCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofLocalShellCall(
                BetaResponseInputItem.LocalShellCall.builder()
                    .id("id")
                    .action(
                        BetaResponseInputItem.LocalShellCall.Action.builder()
                            .addCommand("string")
                            .env(
                                BetaResponseInputItem.LocalShellCall.Action.Env.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .timeoutMs(0L)
                            .user("user")
                            .workingDirectory("working_directory")
                            .build()
                    )
                    .callId("call_id")
                    .status(BetaResponseInputItem.LocalShellCall.Status.IN_PROGRESS)
                    .agent(
                        BetaResponseInputItem.LocalShellCall.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
    }

    @Test
    fun ofLocalShellCallOutput() {
        val localShellCallOutput =
            BetaResponseInputItem.LocalShellCallOutput.builder()
                .id("id")
                .output("output")
                .agent(
                    BetaResponseInputItem.LocalShellCallOutput.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .status(BetaResponseInputItem.LocalShellCallOutput.Status.IN_PROGRESS)
                .build()

        val betaResponseInputItem =
            BetaResponseInputItem.ofLocalShellCallOutput(localShellCallOutput)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).contains(localShellCallOutput)
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofLocalShellCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofLocalShellCallOutput(
                BetaResponseInputItem.LocalShellCallOutput.builder()
                    .id("id")
                    .output("output")
                    .agent(
                        BetaResponseInputItem.LocalShellCallOutput.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .status(BetaResponseInputItem.LocalShellCallOutput.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
    }

    @Test
    fun ofShellCall() {
        val shellCall =
            BetaResponseInputItem.ShellCall.builder()
                .action(
                    BetaResponseInputItem.ShellCall.Action.builder()
                        .addCommand("string")
                        .maxOutputLength(0L)
                        .timeoutMs(0L)
                        .build()
                )
                .callId("x")
                .id("sh_123")
                .agent(
                    BetaResponseInputItem.ShellCall.Agent.builder().agentName("agent_name").build()
                )
                .callerDirect()
                .environment(
                    BetaLocalEnvironment.builder()
                        .addSkill(
                            BetaLocalSkill.builder()
                                .description("description")
                                .name("name")
                                .path("path")
                                .build()
                        )
                        .build()
                )
                .status(BetaResponseInputItem.ShellCall.Status.IN_PROGRESS)
                .build()

        val betaResponseInputItem = BetaResponseInputItem.ofShellCall(shellCall)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).contains(shellCall)
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofShellCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofShellCall(
                BetaResponseInputItem.ShellCall.builder()
                    .action(
                        BetaResponseInputItem.ShellCall.Action.builder()
                            .addCommand("string")
                            .maxOutputLength(0L)
                            .timeoutMs(0L)
                            .build()
                    )
                    .callId("x")
                    .id("sh_123")
                    .agent(
                        BetaResponseInputItem.ShellCall.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .callerDirect()
                    .environment(
                        BetaLocalEnvironment.builder()
                            .addSkill(
                                BetaLocalSkill.builder()
                                    .description("description")
                                    .name("name")
                                    .path("path")
                                    .build()
                            )
                            .build()
                    )
                    .status(BetaResponseInputItem.ShellCall.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
    }

    @Test
    fun ofShellCallOutput() {
        val shellCallOutput =
            BetaResponseInputItem.ShellCallOutput.builder()
                .callId("x")
                .addOutput(
                    BetaResponseFunctionShellCallOutputContent.builder()
                        .outcomeTimeout()
                        .stderr("stderr")
                        .stdout("stdout")
                        .build()
                )
                .id("sho_123")
                .agent(
                    BetaResponseInputItem.ShellCallOutput.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .callerDirect()
                .maxOutputLength(0L)
                .status(BetaResponseInputItem.ShellCallOutput.Status.IN_PROGRESS)
                .build()

        val betaResponseInputItem = BetaResponseInputItem.ofShellCallOutput(shellCallOutput)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).contains(shellCallOutput)
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofShellCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofShellCallOutput(
                BetaResponseInputItem.ShellCallOutput.builder()
                    .callId("x")
                    .addOutput(
                        BetaResponseFunctionShellCallOutputContent.builder()
                            .outcomeTimeout()
                            .stderr("stderr")
                            .stdout("stdout")
                            .build()
                    )
                    .id("sho_123")
                    .agent(
                        BetaResponseInputItem.ShellCallOutput.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .callerDirect()
                    .maxOutputLength(0L)
                    .status(BetaResponseInputItem.ShellCallOutput.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
    }

    @Test
    fun ofApplyPatchCall() {
        val applyPatchCall =
            BetaResponseInputItem.ApplyPatchCall.builder()
                .callId("x")
                .operation(
                    BetaResponseInputItem.ApplyPatchCall.Operation.CreateFile.builder()
                        .diff("diff")
                        .path("x")
                        .build()
                )
                .status(BetaResponseInputItem.ApplyPatchCall.Status.IN_PROGRESS)
                .id("apc_123")
                .agent(
                    BetaResponseInputItem.ApplyPatchCall.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .callerDirect()
                .build()

        val betaResponseInputItem = BetaResponseInputItem.ofApplyPatchCall(applyPatchCall)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).contains(applyPatchCall)
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofApplyPatchCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofApplyPatchCall(
                BetaResponseInputItem.ApplyPatchCall.builder()
                    .callId("x")
                    .operation(
                        BetaResponseInputItem.ApplyPatchCall.Operation.CreateFile.builder()
                            .diff("diff")
                            .path("x")
                            .build()
                    )
                    .status(BetaResponseInputItem.ApplyPatchCall.Status.IN_PROGRESS)
                    .id("apc_123")
                    .agent(
                        BetaResponseInputItem.ApplyPatchCall.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .callerDirect()
                    .build()
            )

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
    }

    @Test
    fun ofApplyPatchCallOutput() {
        val applyPatchCallOutput =
            BetaResponseInputItem.ApplyPatchCallOutput.builder()
                .callId("x")
                .status(BetaResponseInputItem.ApplyPatchCallOutput.Status.COMPLETED)
                .id("apco_123")
                .agent(
                    BetaResponseInputItem.ApplyPatchCallOutput.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .callerDirect()
                .output("output")
                .build()

        val betaResponseInputItem =
            BetaResponseInputItem.ofApplyPatchCallOutput(applyPatchCallOutput)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).contains(applyPatchCallOutput)
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofApplyPatchCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofApplyPatchCallOutput(
                BetaResponseInputItem.ApplyPatchCallOutput.builder()
                    .callId("x")
                    .status(BetaResponseInputItem.ApplyPatchCallOutput.Status.COMPLETED)
                    .id("apco_123")
                    .agent(
                        BetaResponseInputItem.ApplyPatchCallOutput.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .callerDirect()
                    .output("output")
                    .build()
            )

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
    }

    @Test
    fun ofMcpListTools() {
        val mcpListTools =
            BetaResponseInputItem.McpListTools.builder()
                .id("id")
                .serverLabel("server_label")
                .addTool(
                    BetaResponseInputItem.McpListTools.Tool.builder()
                        .inputSchema(JsonValue.from(mapOf<String, Any>()))
                        .name("name")
                        .annotations(JsonValue.from(mapOf<String, Any>()))
                        .description("description")
                        .build()
                )
                .agent(
                    BetaResponseInputItem.McpListTools.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .error("error")
                .build()

        val betaResponseInputItem = BetaResponseInputItem.ofMcpListTools(mcpListTools)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).contains(mcpListTools)
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofMcpListToolsRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofMcpListTools(
                BetaResponseInputItem.McpListTools.builder()
                    .id("id")
                    .serverLabel("server_label")
                    .addTool(
                        BetaResponseInputItem.McpListTools.Tool.builder()
                            .inputSchema(JsonValue.from(mapOf<String, Any>()))
                            .name("name")
                            .annotations(JsonValue.from(mapOf<String, Any>()))
                            .description("description")
                            .build()
                    )
                    .agent(
                        BetaResponseInputItem.McpListTools.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .error("error")
                    .build()
            )

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
    }

    @Test
    fun ofMcpApprovalRequest() {
        val mcpApprovalRequest =
            BetaResponseInputItem.McpApprovalRequest.builder()
                .id("id")
                .arguments("arguments")
                .name("name")
                .serverLabel("server_label")
                .agent(
                    BetaResponseInputItem.McpApprovalRequest.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val betaResponseInputItem = BetaResponseInputItem.ofMcpApprovalRequest(mcpApprovalRequest)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).contains(mcpApprovalRequest)
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofMcpApprovalRequestRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofMcpApprovalRequest(
                BetaResponseInputItem.McpApprovalRequest.builder()
                    .id("id")
                    .arguments("arguments")
                    .name("name")
                    .serverLabel("server_label")
                    .agent(
                        BetaResponseInputItem.McpApprovalRequest.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
    }

    @Test
    fun ofMcpApprovalResponse() {
        val mcpApprovalResponse =
            BetaResponseInputItem.McpApprovalResponse.builder()
                .approvalRequestId("approval_request_id")
                .approve(true)
                .id("id")
                .agent(
                    BetaResponseInputItem.McpApprovalResponse.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .reason("reason")
                .build()

        val betaResponseInputItem = BetaResponseInputItem.ofMcpApprovalResponse(mcpApprovalResponse)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).contains(mcpApprovalResponse)
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofMcpApprovalResponseRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofMcpApprovalResponse(
                BetaResponseInputItem.McpApprovalResponse.builder()
                    .approvalRequestId("approval_request_id")
                    .approve(true)
                    .id("id")
                    .agent(
                        BetaResponseInputItem.McpApprovalResponse.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .reason("reason")
                    .build()
            )

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
    }

    @Test
    fun ofMcpCall() {
        val mcpCall =
            BetaResponseInputItem.McpCall.builder()
                .id("id")
                .arguments("arguments")
                .name("name")
                .serverLabel("server_label")
                .agent(
                    BetaResponseInputItem.McpCall.Agent.builder().agentName("agent_name").build()
                )
                .approvalRequestId("approval_request_id")
                .error("error")
                .output("output")
                .status(BetaResponseInputItem.McpCall.Status.IN_PROGRESS)
                .build()

        val betaResponseInputItem = BetaResponseInputItem.ofMcpCall(mcpCall)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).contains(mcpCall)
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofMcpCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofMcpCall(
                BetaResponseInputItem.McpCall.builder()
                    .id("id")
                    .arguments("arguments")
                    .name("name")
                    .serverLabel("server_label")
                    .agent(
                        BetaResponseInputItem.McpCall.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .approvalRequestId("approval_request_id")
                    .error("error")
                    .output("output")
                    .status(BetaResponseInputItem.McpCall.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
    }

    @Test
    fun ofCustomToolCallOutput() {
        val customToolCallOutput =
            BetaResponseCustomToolCallOutput.builder()
                .callId("call_id")
                .output("string")
                .id("id")
                .agent(
                    BetaResponseCustomToolCallOutput.Agent.builder().agentName("agent_name").build()
                )
                .callerDirect()
                .build()

        val betaResponseInputItem =
            BetaResponseInputItem.ofCustomToolCallOutput(customToolCallOutput)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).contains(customToolCallOutput)
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofCustomToolCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofCustomToolCallOutput(
                BetaResponseCustomToolCallOutput.builder()
                    .callId("call_id")
                    .output("string")
                    .id("id")
                    .agent(
                        BetaResponseCustomToolCallOutput.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .callerDirect()
                    .build()
            )

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
    }

    @Test
    fun ofCustomToolCall() {
        val customToolCall =
            BetaResponseCustomToolCall.builder()
                .callId("call_id")
                .input("input")
                .name("name")
                .id("id")
                .agent(BetaResponseCustomToolCall.Agent.builder().agentName("agent_name").build())
                .callerDirect()
                .namespace("namespace")
                .build()

        val betaResponseInputItem = BetaResponseInputItem.ofCustomToolCall(customToolCall)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).contains(customToolCall)
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofCustomToolCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofCustomToolCall(
                BetaResponseCustomToolCall.builder()
                    .callId("call_id")
                    .input("input")
                    .name("name")
                    .id("id")
                    .agent(
                        BetaResponseCustomToolCall.Agent.builder().agentName("agent_name").build()
                    )
                    .callerDirect()
                    .namespace("namespace")
                    .build()
            )

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
    }

    @Test
    fun ofCompactionTrigger() {
        val compactionTrigger =
            BetaResponseInputItem.CompactionTrigger.builder()
                .agent(
                    BetaResponseInputItem.CompactionTrigger.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val betaResponseInputItem = BetaResponseInputItem.ofCompactionTrigger(compactionTrigger)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).contains(compactionTrigger)
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofCompactionTriggerRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofCompactionTrigger(
                BetaResponseInputItem.CompactionTrigger.builder()
                    .agent(
                        BetaResponseInputItem.CompactionTrigger.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
    }

    @Test
    fun ofItemReference() {
        val itemReference =
            BetaResponseInputItem.ItemReference.builder()
                .id("id")
                .agent(
                    BetaResponseInputItem.ItemReference.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .type(BetaResponseInputItem.ItemReference.Type.ITEM_REFERENCE)
                .build()

        val betaResponseInputItem = BetaResponseInputItem.ofItemReference(itemReference)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).contains(itemReference)
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofItemReferenceRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofItemReference(
                BetaResponseInputItem.ItemReference.builder()
                    .id("id")
                    .agent(
                        BetaResponseInputItem.ItemReference.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .type(BetaResponseInputItem.ItemReference.Type.ITEM_REFERENCE)
                    .build()
            )

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
    }

    @Test
    fun ofProgram() {
        val program =
            BetaResponseInputItem.Program.builder()
                .id("cm_123")
                .callId("x")
                .code("code")
                .fingerprint("fingerprint")
                .agent(
                    BetaResponseInputItem.Program.Agent.builder().agentName("agent_name").build()
                )
                .build()

        val betaResponseInputItem = BetaResponseInputItem.ofProgram(program)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).contains(program)
        assertThat(betaResponseInputItem.programOutput()).isEmpty
    }

    @Test
    fun ofProgramRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofProgram(
                BetaResponseInputItem.Program.builder()
                    .id("cm_123")
                    .callId("x")
                    .code("code")
                    .fingerprint("fingerprint")
                    .agent(
                        BetaResponseInputItem.Program.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
    }

    @Test
    fun ofProgramOutput() {
        val programOutput =
            BetaResponseInputItem.ProgramOutput.builder()
                .id("cmo_123")
                .callId("x")
                .result("result")
                .status(BetaResponseInputItem.ProgramOutput.Status.COMPLETED)
                .agent(
                    BetaResponseInputItem.ProgramOutput.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val betaResponseInputItem = BetaResponseInputItem.ofProgramOutput(programOutput)

        assertThat(betaResponseInputItem.betaEasyInputMessage()).isEmpty
        assertThat(betaResponseInputItem.message()).isEmpty
        assertThat(betaResponseInputItem.betaResponseOutputMessage()).isEmpty
        assertThat(betaResponseInputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseInputItem.computerCall()).isEmpty
        assertThat(betaResponseInputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseInputItem.webSearchCall()).isEmpty
        assertThat(betaResponseInputItem.functionCall()).isEmpty
        assertThat(betaResponseInputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseInputItem.agentMessage()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseInputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseInputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseInputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseInputItem.additionalTools()).isEmpty
        assertThat(betaResponseInputItem.reasoning()).isEmpty
        assertThat(betaResponseInputItem.compaction()).isEmpty
        assertThat(betaResponseInputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseInputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCall()).isEmpty
        assertThat(betaResponseInputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.shellCall()).isEmpty
        assertThat(betaResponseInputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseInputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseInputItem.mcpListTools()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseInputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseInputItem.mcpCall()).isEmpty
        assertThat(betaResponseInputItem.customToolCallOutput()).isEmpty
        assertThat(betaResponseInputItem.customToolCall()).isEmpty
        assertThat(betaResponseInputItem.compactionTrigger()).isEmpty
        assertThat(betaResponseInputItem.itemReference()).isEmpty
        assertThat(betaResponseInputItem.program()).isEmpty
        assertThat(betaResponseInputItem.programOutput()).contains(programOutput)
    }

    @Test
    fun ofProgramOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputItem =
            BetaResponseInputItem.ofProgramOutput(
                BetaResponseInputItem.ProgramOutput.builder()
                    .id("cmo_123")
                    .callId("x")
                    .result("result")
                    .status(BetaResponseInputItem.ProgramOutput.Status.COMPLETED)
                    .agent(
                        BetaResponseInputItem.ProgramOutput.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseInputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputItem),
                jacksonTypeRef<BetaResponseInputItem>(),
            )

        assertThat(roundtrippedBetaResponseInputItem).isEqualTo(betaResponseInputItem)
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
        val betaResponseInputItem =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<BetaResponseInputItem>())

        val e = assertThrows<OpenAIInvalidDataException> { betaResponseInputItem.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
