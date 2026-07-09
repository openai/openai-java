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

internal class BetaResponseOutputItemTest {

    @Test
    fun ofMessage() {
        val message =
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

        val betaResponseOutputItem = BetaResponseOutputItem.ofMessage(message)

        assertThat(betaResponseOutputItem.message()).contains(message)
        assertThat(betaResponseOutputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.agentMessage()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.webSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.reasoning()).isEmpty
        assertThat(betaResponseOutputItem.program()).isEmpty
        assertThat(betaResponseOutputItem.programOutput()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseOutputItem.additionalTools()).isEmpty
        assertThat(betaResponseOutputItem.compaction()).isEmpty
        assertThat(betaResponseOutputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.shellCall()).isEmpty
        assertThat(betaResponseOutputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.mcpCall()).isEmpty
        assertThat(betaResponseOutputItem.mcpListTools()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseOutputItem.customToolCall()).isEmpty
        assertThat(betaResponseOutputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofMessageRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItem =
            BetaResponseOutputItem.ofMessage(
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

        val roundtrippedBetaResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItem),
                jacksonTypeRef<BetaResponseOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseOutputItem).isEqualTo(betaResponseOutputItem)
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

        val betaResponseOutputItem = BetaResponseOutputItem.ofFileSearchCall(fileSearchCall)

        assertThat(betaResponseOutputItem.message()).isEmpty
        assertThat(betaResponseOutputItem.fileSearchCall()).contains(fileSearchCall)
        assertThat(betaResponseOutputItem.functionCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.agentMessage()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.webSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.reasoning()).isEmpty
        assertThat(betaResponseOutputItem.program()).isEmpty
        assertThat(betaResponseOutputItem.programOutput()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseOutputItem.additionalTools()).isEmpty
        assertThat(betaResponseOutputItem.compaction()).isEmpty
        assertThat(betaResponseOutputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.shellCall()).isEmpty
        assertThat(betaResponseOutputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.mcpCall()).isEmpty
        assertThat(betaResponseOutputItem.mcpListTools()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseOutputItem.customToolCall()).isEmpty
        assertThat(betaResponseOutputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofFileSearchCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItem =
            BetaResponseOutputItem.ofFileSearchCall(
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

        val roundtrippedBetaResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItem),
                jacksonTypeRef<BetaResponseOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseOutputItem).isEqualTo(betaResponseOutputItem)
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

        val betaResponseOutputItem = BetaResponseOutputItem.ofFunctionCall(functionCall)

        assertThat(betaResponseOutputItem.message()).isEmpty
        assertThat(betaResponseOutputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCall()).contains(functionCall)
        assertThat(betaResponseOutputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.agentMessage()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.webSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.reasoning()).isEmpty
        assertThat(betaResponseOutputItem.program()).isEmpty
        assertThat(betaResponseOutputItem.programOutput()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseOutputItem.additionalTools()).isEmpty
        assertThat(betaResponseOutputItem.compaction()).isEmpty
        assertThat(betaResponseOutputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.shellCall()).isEmpty
        assertThat(betaResponseOutputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.mcpCall()).isEmpty
        assertThat(betaResponseOutputItem.mcpListTools()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseOutputItem.customToolCall()).isEmpty
        assertThat(betaResponseOutputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofFunctionCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItem =
            BetaResponseOutputItem.ofFunctionCall(
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

        val roundtrippedBetaResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItem),
                jacksonTypeRef<BetaResponseOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseOutputItem).isEqualTo(betaResponseOutputItem)
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

        val betaResponseOutputItem = BetaResponseOutputItem.ofFunctionCallOutput(functionCallOutput)

        assertThat(betaResponseOutputItem.message()).isEmpty
        assertThat(betaResponseOutputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCallOutput()).contains(functionCallOutput)
        assertThat(betaResponseOutputItem.agentMessage()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.webSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.reasoning()).isEmpty
        assertThat(betaResponseOutputItem.program()).isEmpty
        assertThat(betaResponseOutputItem.programOutput()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseOutputItem.additionalTools()).isEmpty
        assertThat(betaResponseOutputItem.compaction()).isEmpty
        assertThat(betaResponseOutputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.shellCall()).isEmpty
        assertThat(betaResponseOutputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.mcpCall()).isEmpty
        assertThat(betaResponseOutputItem.mcpListTools()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseOutputItem.customToolCall()).isEmpty
        assertThat(betaResponseOutputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofFunctionCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItem =
            BetaResponseOutputItem.ofFunctionCallOutput(
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

        val roundtrippedBetaResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItem),
                jacksonTypeRef<BetaResponseOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseOutputItem).isEqualTo(betaResponseOutputItem)
    }

    @Test
    fun ofAgentMessage() {
        val agentMessage =
            BetaResponseOutputItem.AgentMessage.builder()
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
                    BetaResponseOutputItem.AgentMessage.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val betaResponseOutputItem = BetaResponseOutputItem.ofAgentMessage(agentMessage)

        assertThat(betaResponseOutputItem.message()).isEmpty
        assertThat(betaResponseOutputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.agentMessage()).contains(agentMessage)
        assertThat(betaResponseOutputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.webSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.reasoning()).isEmpty
        assertThat(betaResponseOutputItem.program()).isEmpty
        assertThat(betaResponseOutputItem.programOutput()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseOutputItem.additionalTools()).isEmpty
        assertThat(betaResponseOutputItem.compaction()).isEmpty
        assertThat(betaResponseOutputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.shellCall()).isEmpty
        assertThat(betaResponseOutputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.mcpCall()).isEmpty
        assertThat(betaResponseOutputItem.mcpListTools()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseOutputItem.customToolCall()).isEmpty
        assertThat(betaResponseOutputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofAgentMessageRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItem =
            BetaResponseOutputItem.ofAgentMessage(
                BetaResponseOutputItem.AgentMessage.builder()
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
                        BetaResponseOutputItem.AgentMessage.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItem),
                jacksonTypeRef<BetaResponseOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseOutputItem).isEqualTo(betaResponseOutputItem)
    }

    @Test
    fun ofMultiAgentCall() {
        val multiAgentCall =
            BetaResponseOutputItem.MultiAgentCall.builder()
                .id("id")
                .action(BetaResponseOutputItem.MultiAgentCall.Action.SPAWN_AGENT)
                .arguments("arguments")
                .callId("call_id")
                .agent(
                    BetaResponseOutputItem.MultiAgentCall.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val betaResponseOutputItem = BetaResponseOutputItem.ofMultiAgentCall(multiAgentCall)

        assertThat(betaResponseOutputItem.message()).isEmpty
        assertThat(betaResponseOutputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.agentMessage()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCall()).contains(multiAgentCall)
        assertThat(betaResponseOutputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.webSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.reasoning()).isEmpty
        assertThat(betaResponseOutputItem.program()).isEmpty
        assertThat(betaResponseOutputItem.programOutput()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseOutputItem.additionalTools()).isEmpty
        assertThat(betaResponseOutputItem.compaction()).isEmpty
        assertThat(betaResponseOutputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.shellCall()).isEmpty
        assertThat(betaResponseOutputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.mcpCall()).isEmpty
        assertThat(betaResponseOutputItem.mcpListTools()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseOutputItem.customToolCall()).isEmpty
        assertThat(betaResponseOutputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofMultiAgentCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItem =
            BetaResponseOutputItem.ofMultiAgentCall(
                BetaResponseOutputItem.MultiAgentCall.builder()
                    .id("id")
                    .action(BetaResponseOutputItem.MultiAgentCall.Action.SPAWN_AGENT)
                    .arguments("arguments")
                    .callId("call_id")
                    .agent(
                        BetaResponseOutputItem.MultiAgentCall.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItem),
                jacksonTypeRef<BetaResponseOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseOutputItem).isEqualTo(betaResponseOutputItem)
    }

    @Test
    fun ofMultiAgentCallOutput() {
        val multiAgentCallOutput =
            BetaResponseOutputItem.MultiAgentCallOutput.builder()
                .id("id")
                .action(BetaResponseOutputItem.MultiAgentCallOutput.Action.SPAWN_AGENT)
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
                    BetaResponseOutputItem.MultiAgentCallOutput.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val betaResponseOutputItem =
            BetaResponseOutputItem.ofMultiAgentCallOutput(multiAgentCallOutput)

        assertThat(betaResponseOutputItem.message()).isEmpty
        assertThat(betaResponseOutputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.agentMessage()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCallOutput()).contains(multiAgentCallOutput)
        assertThat(betaResponseOutputItem.webSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.reasoning()).isEmpty
        assertThat(betaResponseOutputItem.program()).isEmpty
        assertThat(betaResponseOutputItem.programOutput()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseOutputItem.additionalTools()).isEmpty
        assertThat(betaResponseOutputItem.compaction()).isEmpty
        assertThat(betaResponseOutputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.shellCall()).isEmpty
        assertThat(betaResponseOutputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.mcpCall()).isEmpty
        assertThat(betaResponseOutputItem.mcpListTools()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseOutputItem.customToolCall()).isEmpty
        assertThat(betaResponseOutputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofMultiAgentCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItem =
            BetaResponseOutputItem.ofMultiAgentCallOutput(
                BetaResponseOutputItem.MultiAgentCallOutput.builder()
                    .id("id")
                    .action(BetaResponseOutputItem.MultiAgentCallOutput.Action.SPAWN_AGENT)
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
                        BetaResponseOutputItem.MultiAgentCallOutput.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItem),
                jacksonTypeRef<BetaResponseOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseOutputItem).isEqualTo(betaResponseOutputItem)
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

        val betaResponseOutputItem = BetaResponseOutputItem.ofWebSearchCall(webSearchCall)

        assertThat(betaResponseOutputItem.message()).isEmpty
        assertThat(betaResponseOutputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.agentMessage()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.webSearchCall()).contains(webSearchCall)
        assertThat(betaResponseOutputItem.computerCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.reasoning()).isEmpty
        assertThat(betaResponseOutputItem.program()).isEmpty
        assertThat(betaResponseOutputItem.programOutput()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseOutputItem.additionalTools()).isEmpty
        assertThat(betaResponseOutputItem.compaction()).isEmpty
        assertThat(betaResponseOutputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.shellCall()).isEmpty
        assertThat(betaResponseOutputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.mcpCall()).isEmpty
        assertThat(betaResponseOutputItem.mcpListTools()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseOutputItem.customToolCall()).isEmpty
        assertThat(betaResponseOutputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofWebSearchCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItem =
            BetaResponseOutputItem.ofWebSearchCall(
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

        val roundtrippedBetaResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItem),
                jacksonTypeRef<BetaResponseOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseOutputItem).isEqualTo(betaResponseOutputItem)
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

        val betaResponseOutputItem = BetaResponseOutputItem.ofComputerCall(computerCall)

        assertThat(betaResponseOutputItem.message()).isEmpty
        assertThat(betaResponseOutputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.agentMessage()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.webSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCall()).contains(computerCall)
        assertThat(betaResponseOutputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.reasoning()).isEmpty
        assertThat(betaResponseOutputItem.program()).isEmpty
        assertThat(betaResponseOutputItem.programOutput()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseOutputItem.additionalTools()).isEmpty
        assertThat(betaResponseOutputItem.compaction()).isEmpty
        assertThat(betaResponseOutputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.shellCall()).isEmpty
        assertThat(betaResponseOutputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.mcpCall()).isEmpty
        assertThat(betaResponseOutputItem.mcpListTools()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseOutputItem.customToolCall()).isEmpty
        assertThat(betaResponseOutputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofComputerCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItem =
            BetaResponseOutputItem.ofComputerCall(
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

        val roundtrippedBetaResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItem),
                jacksonTypeRef<BetaResponseOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseOutputItem).isEqualTo(betaResponseOutputItem)
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

        val betaResponseOutputItem = BetaResponseOutputItem.ofComputerCallOutput(computerCallOutput)

        assertThat(betaResponseOutputItem.message()).isEmpty
        assertThat(betaResponseOutputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.agentMessage()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.webSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCallOutput()).contains(computerCallOutput)
        assertThat(betaResponseOutputItem.reasoning()).isEmpty
        assertThat(betaResponseOutputItem.program()).isEmpty
        assertThat(betaResponseOutputItem.programOutput()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseOutputItem.additionalTools()).isEmpty
        assertThat(betaResponseOutputItem.compaction()).isEmpty
        assertThat(betaResponseOutputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.shellCall()).isEmpty
        assertThat(betaResponseOutputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.mcpCall()).isEmpty
        assertThat(betaResponseOutputItem.mcpListTools()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseOutputItem.customToolCall()).isEmpty
        assertThat(betaResponseOutputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofComputerCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItem =
            BetaResponseOutputItem.ofComputerCallOutput(
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

        val roundtrippedBetaResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItem),
                jacksonTypeRef<BetaResponseOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseOutputItem).isEqualTo(betaResponseOutputItem)
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

        val betaResponseOutputItem = BetaResponseOutputItem.ofReasoning(reasoning)

        assertThat(betaResponseOutputItem.message()).isEmpty
        assertThat(betaResponseOutputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.agentMessage()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.webSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.reasoning()).contains(reasoning)
        assertThat(betaResponseOutputItem.program()).isEmpty
        assertThat(betaResponseOutputItem.programOutput()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseOutputItem.additionalTools()).isEmpty
        assertThat(betaResponseOutputItem.compaction()).isEmpty
        assertThat(betaResponseOutputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.shellCall()).isEmpty
        assertThat(betaResponseOutputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.mcpCall()).isEmpty
        assertThat(betaResponseOutputItem.mcpListTools()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseOutputItem.customToolCall()).isEmpty
        assertThat(betaResponseOutputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofReasoningRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItem =
            BetaResponseOutputItem.ofReasoning(
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

        val roundtrippedBetaResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItem),
                jacksonTypeRef<BetaResponseOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseOutputItem).isEqualTo(betaResponseOutputItem)
    }

    @Test
    fun ofProgram() {
        val program =
            BetaResponseOutputItem.Program.builder()
                .id("id")
                .callId("call_id")
                .code("code")
                .fingerprint("fingerprint")
                .agent(
                    BetaResponseOutputItem.Program.Agent.builder().agentName("agent_name").build()
                )
                .build()

        val betaResponseOutputItem = BetaResponseOutputItem.ofProgram(program)

        assertThat(betaResponseOutputItem.message()).isEmpty
        assertThat(betaResponseOutputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.agentMessage()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.webSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.reasoning()).isEmpty
        assertThat(betaResponseOutputItem.program()).contains(program)
        assertThat(betaResponseOutputItem.programOutput()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseOutputItem.additionalTools()).isEmpty
        assertThat(betaResponseOutputItem.compaction()).isEmpty
        assertThat(betaResponseOutputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.shellCall()).isEmpty
        assertThat(betaResponseOutputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.mcpCall()).isEmpty
        assertThat(betaResponseOutputItem.mcpListTools()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseOutputItem.customToolCall()).isEmpty
        assertThat(betaResponseOutputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofProgramRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItem =
            BetaResponseOutputItem.ofProgram(
                BetaResponseOutputItem.Program.builder()
                    .id("id")
                    .callId("call_id")
                    .code("code")
                    .fingerprint("fingerprint")
                    .agent(
                        BetaResponseOutputItem.Program.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItem),
                jacksonTypeRef<BetaResponseOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseOutputItem).isEqualTo(betaResponseOutputItem)
    }

    @Test
    fun ofProgramOutput() {
        val programOutput =
            BetaResponseOutputItem.ProgramOutput.builder()
                .id("id")
                .callId("call_id")
                .result("result")
                .status(BetaResponseOutputItem.ProgramOutput.Status.COMPLETED)
                .agent(
                    BetaResponseOutputItem.ProgramOutput.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val betaResponseOutputItem = BetaResponseOutputItem.ofProgramOutput(programOutput)

        assertThat(betaResponseOutputItem.message()).isEmpty
        assertThat(betaResponseOutputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.agentMessage()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.webSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.reasoning()).isEmpty
        assertThat(betaResponseOutputItem.program()).isEmpty
        assertThat(betaResponseOutputItem.programOutput()).contains(programOutput)
        assertThat(betaResponseOutputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseOutputItem.additionalTools()).isEmpty
        assertThat(betaResponseOutputItem.compaction()).isEmpty
        assertThat(betaResponseOutputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.shellCall()).isEmpty
        assertThat(betaResponseOutputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.mcpCall()).isEmpty
        assertThat(betaResponseOutputItem.mcpListTools()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseOutputItem.customToolCall()).isEmpty
        assertThat(betaResponseOutputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofProgramOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItem =
            BetaResponseOutputItem.ofProgramOutput(
                BetaResponseOutputItem.ProgramOutput.builder()
                    .id("id")
                    .callId("call_id")
                    .result("result")
                    .status(BetaResponseOutputItem.ProgramOutput.Status.COMPLETED)
                    .agent(
                        BetaResponseOutputItem.ProgramOutput.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItem),
                jacksonTypeRef<BetaResponseOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseOutputItem).isEqualTo(betaResponseOutputItem)
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

        val betaResponseOutputItem = BetaResponseOutputItem.ofToolSearchCall(toolSearchCall)

        assertThat(betaResponseOutputItem.message()).isEmpty
        assertThat(betaResponseOutputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.agentMessage()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.webSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.reasoning()).isEmpty
        assertThat(betaResponseOutputItem.program()).isEmpty
        assertThat(betaResponseOutputItem.programOutput()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchCall()).contains(toolSearchCall)
        assertThat(betaResponseOutputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseOutputItem.additionalTools()).isEmpty
        assertThat(betaResponseOutputItem.compaction()).isEmpty
        assertThat(betaResponseOutputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.shellCall()).isEmpty
        assertThat(betaResponseOutputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.mcpCall()).isEmpty
        assertThat(betaResponseOutputItem.mcpListTools()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseOutputItem.customToolCall()).isEmpty
        assertThat(betaResponseOutputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofToolSearchCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItem =
            BetaResponseOutputItem.ofToolSearchCall(
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

        val roundtrippedBetaResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItem),
                jacksonTypeRef<BetaResponseOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseOutputItem).isEqualTo(betaResponseOutputItem)
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

        val betaResponseOutputItem = BetaResponseOutputItem.ofToolSearchOutput(toolSearchOutput)

        assertThat(betaResponseOutputItem.message()).isEmpty
        assertThat(betaResponseOutputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.agentMessage()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.webSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.reasoning()).isEmpty
        assertThat(betaResponseOutputItem.program()).isEmpty
        assertThat(betaResponseOutputItem.programOutput()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchOutput()).contains(toolSearchOutput)
        assertThat(betaResponseOutputItem.additionalTools()).isEmpty
        assertThat(betaResponseOutputItem.compaction()).isEmpty
        assertThat(betaResponseOutputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.shellCall()).isEmpty
        assertThat(betaResponseOutputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.mcpCall()).isEmpty
        assertThat(betaResponseOutputItem.mcpListTools()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseOutputItem.customToolCall()).isEmpty
        assertThat(betaResponseOutputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofToolSearchOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItem =
            BetaResponseOutputItem.ofToolSearchOutput(
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

        val roundtrippedBetaResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItem),
                jacksonTypeRef<BetaResponseOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseOutputItem).isEqualTo(betaResponseOutputItem)
    }

    @Test
    fun ofAdditionalTools() {
        val additionalTools =
            BetaResponseOutputItem.AdditionalTools.builder()
                .id("id")
                .role(BetaResponseOutputItem.AdditionalTools.Role.UNKNOWN)
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
                    BetaResponseOutputItem.AdditionalTools.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val betaResponseOutputItem = BetaResponseOutputItem.ofAdditionalTools(additionalTools)

        assertThat(betaResponseOutputItem.message()).isEmpty
        assertThat(betaResponseOutputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.agentMessage()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.webSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.reasoning()).isEmpty
        assertThat(betaResponseOutputItem.program()).isEmpty
        assertThat(betaResponseOutputItem.programOutput()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseOutputItem.additionalTools()).contains(additionalTools)
        assertThat(betaResponseOutputItem.compaction()).isEmpty
        assertThat(betaResponseOutputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.shellCall()).isEmpty
        assertThat(betaResponseOutputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.mcpCall()).isEmpty
        assertThat(betaResponseOutputItem.mcpListTools()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseOutputItem.customToolCall()).isEmpty
        assertThat(betaResponseOutputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofAdditionalToolsRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItem =
            BetaResponseOutputItem.ofAdditionalTools(
                BetaResponseOutputItem.AdditionalTools.builder()
                    .id("id")
                    .role(BetaResponseOutputItem.AdditionalTools.Role.UNKNOWN)
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
                        BetaResponseOutputItem.AdditionalTools.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItem),
                jacksonTypeRef<BetaResponseOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseOutputItem).isEqualTo(betaResponseOutputItem)
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

        val betaResponseOutputItem = BetaResponseOutputItem.ofCompaction(compaction)

        assertThat(betaResponseOutputItem.message()).isEmpty
        assertThat(betaResponseOutputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.agentMessage()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.webSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.reasoning()).isEmpty
        assertThat(betaResponseOutputItem.program()).isEmpty
        assertThat(betaResponseOutputItem.programOutput()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseOutputItem.additionalTools()).isEmpty
        assertThat(betaResponseOutputItem.compaction()).contains(compaction)
        assertThat(betaResponseOutputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.shellCall()).isEmpty
        assertThat(betaResponseOutputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.mcpCall()).isEmpty
        assertThat(betaResponseOutputItem.mcpListTools()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseOutputItem.customToolCall()).isEmpty
        assertThat(betaResponseOutputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofCompactionRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItem =
            BetaResponseOutputItem.ofCompaction(
                BetaResponseCompactionItem.builder()
                    .id("id")
                    .encryptedContent("encrypted_content")
                    .agent(
                        BetaResponseCompactionItem.Agent.builder().agentName("agent_name").build()
                    )
                    .createdBy("created_by")
                    .build()
            )

        val roundtrippedBetaResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItem),
                jacksonTypeRef<BetaResponseOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseOutputItem).isEqualTo(betaResponseOutputItem)
    }

    @Test
    fun ofImageGenerationCall() {
        val imageGenerationCall =
            BetaResponseOutputItem.ImageGenerationCall.builder()
                .id("id")
                .result("result")
                .status(BetaResponseOutputItem.ImageGenerationCall.Status.IN_PROGRESS)
                .agent(
                    BetaResponseOutputItem.ImageGenerationCall.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val betaResponseOutputItem =
            BetaResponseOutputItem.ofImageGenerationCall(imageGenerationCall)

        assertThat(betaResponseOutputItem.message()).isEmpty
        assertThat(betaResponseOutputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.agentMessage()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.webSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.reasoning()).isEmpty
        assertThat(betaResponseOutputItem.program()).isEmpty
        assertThat(betaResponseOutputItem.programOutput()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseOutputItem.additionalTools()).isEmpty
        assertThat(betaResponseOutputItem.compaction()).isEmpty
        assertThat(betaResponseOutputItem.imageGenerationCall()).contains(imageGenerationCall)
        assertThat(betaResponseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.shellCall()).isEmpty
        assertThat(betaResponseOutputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.mcpCall()).isEmpty
        assertThat(betaResponseOutputItem.mcpListTools()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseOutputItem.customToolCall()).isEmpty
        assertThat(betaResponseOutputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofImageGenerationCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItem =
            BetaResponseOutputItem.ofImageGenerationCall(
                BetaResponseOutputItem.ImageGenerationCall.builder()
                    .id("id")
                    .result("result")
                    .status(BetaResponseOutputItem.ImageGenerationCall.Status.IN_PROGRESS)
                    .agent(
                        BetaResponseOutputItem.ImageGenerationCall.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItem),
                jacksonTypeRef<BetaResponseOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseOutputItem).isEqualTo(betaResponseOutputItem)
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

        val betaResponseOutputItem =
            BetaResponseOutputItem.ofCodeInterpreterCall(codeInterpreterCall)

        assertThat(betaResponseOutputItem.message()).isEmpty
        assertThat(betaResponseOutputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.agentMessage()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.webSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.reasoning()).isEmpty
        assertThat(betaResponseOutputItem.program()).isEmpty
        assertThat(betaResponseOutputItem.programOutput()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseOutputItem.additionalTools()).isEmpty
        assertThat(betaResponseOutputItem.compaction()).isEmpty
        assertThat(betaResponseOutputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseOutputItem.codeInterpreterCall()).contains(codeInterpreterCall)
        assertThat(betaResponseOutputItem.localShellCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.shellCall()).isEmpty
        assertThat(betaResponseOutputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.mcpCall()).isEmpty
        assertThat(betaResponseOutputItem.mcpListTools()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseOutputItem.customToolCall()).isEmpty
        assertThat(betaResponseOutputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofCodeInterpreterCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItem =
            BetaResponseOutputItem.ofCodeInterpreterCall(
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

        val roundtrippedBetaResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItem),
                jacksonTypeRef<BetaResponseOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseOutputItem).isEqualTo(betaResponseOutputItem)
    }

    @Test
    fun ofLocalShellCall() {
        val localShellCall =
            BetaResponseOutputItem.LocalShellCall.builder()
                .id("id")
                .action(
                    BetaResponseOutputItem.LocalShellCall.Action.builder()
                        .addCommand("string")
                        .env(
                            BetaResponseOutputItem.LocalShellCall.Action.Env.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .timeoutMs(0L)
                        .user("user")
                        .workingDirectory("working_directory")
                        .build()
                )
                .callId("call_id")
                .status(BetaResponseOutputItem.LocalShellCall.Status.IN_PROGRESS)
                .agent(
                    BetaResponseOutputItem.LocalShellCall.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val betaResponseOutputItem = BetaResponseOutputItem.ofLocalShellCall(localShellCall)

        assertThat(betaResponseOutputItem.message()).isEmpty
        assertThat(betaResponseOutputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.agentMessage()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.webSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.reasoning()).isEmpty
        assertThat(betaResponseOutputItem.program()).isEmpty
        assertThat(betaResponseOutputItem.programOutput()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseOutputItem.additionalTools()).isEmpty
        assertThat(betaResponseOutputItem.compaction()).isEmpty
        assertThat(betaResponseOutputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCall()).contains(localShellCall)
        assertThat(betaResponseOutputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.shellCall()).isEmpty
        assertThat(betaResponseOutputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.mcpCall()).isEmpty
        assertThat(betaResponseOutputItem.mcpListTools()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseOutputItem.customToolCall()).isEmpty
        assertThat(betaResponseOutputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofLocalShellCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItem =
            BetaResponseOutputItem.ofLocalShellCall(
                BetaResponseOutputItem.LocalShellCall.builder()
                    .id("id")
                    .action(
                        BetaResponseOutputItem.LocalShellCall.Action.builder()
                            .addCommand("string")
                            .env(
                                BetaResponseOutputItem.LocalShellCall.Action.Env.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .timeoutMs(0L)
                            .user("user")
                            .workingDirectory("working_directory")
                            .build()
                    )
                    .callId("call_id")
                    .status(BetaResponseOutputItem.LocalShellCall.Status.IN_PROGRESS)
                    .agent(
                        BetaResponseOutputItem.LocalShellCall.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItem),
                jacksonTypeRef<BetaResponseOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseOutputItem).isEqualTo(betaResponseOutputItem)
    }

    @Test
    fun ofLocalShellCallOutput() {
        val localShellCallOutput =
            BetaResponseOutputItem.LocalShellCallOutput.builder()
                .id("id")
                .output("output")
                .agent(
                    BetaResponseOutputItem.LocalShellCallOutput.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .status(BetaResponseOutputItem.LocalShellCallOutput.Status.IN_PROGRESS)
                .build()

        val betaResponseOutputItem =
            BetaResponseOutputItem.ofLocalShellCallOutput(localShellCallOutput)

        assertThat(betaResponseOutputItem.message()).isEmpty
        assertThat(betaResponseOutputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.agentMessage()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.webSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.reasoning()).isEmpty
        assertThat(betaResponseOutputItem.program()).isEmpty
        assertThat(betaResponseOutputItem.programOutput()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseOutputItem.additionalTools()).isEmpty
        assertThat(betaResponseOutputItem.compaction()).isEmpty
        assertThat(betaResponseOutputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCallOutput()).contains(localShellCallOutput)
        assertThat(betaResponseOutputItem.shellCall()).isEmpty
        assertThat(betaResponseOutputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.mcpCall()).isEmpty
        assertThat(betaResponseOutputItem.mcpListTools()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseOutputItem.customToolCall()).isEmpty
        assertThat(betaResponseOutputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofLocalShellCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItem =
            BetaResponseOutputItem.ofLocalShellCallOutput(
                BetaResponseOutputItem.LocalShellCallOutput.builder()
                    .id("id")
                    .output("output")
                    .agent(
                        BetaResponseOutputItem.LocalShellCallOutput.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .status(BetaResponseOutputItem.LocalShellCallOutput.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedBetaResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItem),
                jacksonTypeRef<BetaResponseOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseOutputItem).isEqualTo(betaResponseOutputItem)
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

        val betaResponseOutputItem = BetaResponseOutputItem.ofShellCall(shellCall)

        assertThat(betaResponseOutputItem.message()).isEmpty
        assertThat(betaResponseOutputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.agentMessage()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.webSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.reasoning()).isEmpty
        assertThat(betaResponseOutputItem.program()).isEmpty
        assertThat(betaResponseOutputItem.programOutput()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseOutputItem.additionalTools()).isEmpty
        assertThat(betaResponseOutputItem.compaction()).isEmpty
        assertThat(betaResponseOutputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.shellCall()).contains(shellCall)
        assertThat(betaResponseOutputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.mcpCall()).isEmpty
        assertThat(betaResponseOutputItem.mcpListTools()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseOutputItem.customToolCall()).isEmpty
        assertThat(betaResponseOutputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofShellCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItem =
            BetaResponseOutputItem.ofShellCall(
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

        val roundtrippedBetaResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItem),
                jacksonTypeRef<BetaResponseOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseOutputItem).isEqualTo(betaResponseOutputItem)
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

        val betaResponseOutputItem = BetaResponseOutputItem.ofShellCallOutput(shellCallOutput)

        assertThat(betaResponseOutputItem.message()).isEmpty
        assertThat(betaResponseOutputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.agentMessage()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.webSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.reasoning()).isEmpty
        assertThat(betaResponseOutputItem.program()).isEmpty
        assertThat(betaResponseOutputItem.programOutput()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseOutputItem.additionalTools()).isEmpty
        assertThat(betaResponseOutputItem.compaction()).isEmpty
        assertThat(betaResponseOutputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.shellCall()).isEmpty
        assertThat(betaResponseOutputItem.shellCallOutput()).contains(shellCallOutput)
        assertThat(betaResponseOutputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.mcpCall()).isEmpty
        assertThat(betaResponseOutputItem.mcpListTools()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseOutputItem.customToolCall()).isEmpty
        assertThat(betaResponseOutputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofShellCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItem =
            BetaResponseOutputItem.ofShellCallOutput(
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

        val roundtrippedBetaResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItem),
                jacksonTypeRef<BetaResponseOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseOutputItem).isEqualTo(betaResponseOutputItem)
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

        val betaResponseOutputItem = BetaResponseOutputItem.ofApplyPatchCall(applyPatchCall)

        assertThat(betaResponseOutputItem.message()).isEmpty
        assertThat(betaResponseOutputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.agentMessage()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.webSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.reasoning()).isEmpty
        assertThat(betaResponseOutputItem.program()).isEmpty
        assertThat(betaResponseOutputItem.programOutput()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseOutputItem.additionalTools()).isEmpty
        assertThat(betaResponseOutputItem.compaction()).isEmpty
        assertThat(betaResponseOutputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.shellCall()).isEmpty
        assertThat(betaResponseOutputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCall()).contains(applyPatchCall)
        assertThat(betaResponseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.mcpCall()).isEmpty
        assertThat(betaResponseOutputItem.mcpListTools()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseOutputItem.customToolCall()).isEmpty
        assertThat(betaResponseOutputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofApplyPatchCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItem =
            BetaResponseOutputItem.ofApplyPatchCall(
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

        val roundtrippedBetaResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItem),
                jacksonTypeRef<BetaResponseOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseOutputItem).isEqualTo(betaResponseOutputItem)
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

        val betaResponseOutputItem =
            BetaResponseOutputItem.ofApplyPatchCallOutput(applyPatchCallOutput)

        assertThat(betaResponseOutputItem.message()).isEmpty
        assertThat(betaResponseOutputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.agentMessage()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.webSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.reasoning()).isEmpty
        assertThat(betaResponseOutputItem.program()).isEmpty
        assertThat(betaResponseOutputItem.programOutput()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseOutputItem.additionalTools()).isEmpty
        assertThat(betaResponseOutputItem.compaction()).isEmpty
        assertThat(betaResponseOutputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.shellCall()).isEmpty
        assertThat(betaResponseOutputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCallOutput()).contains(applyPatchCallOutput)
        assertThat(betaResponseOutputItem.mcpCall()).isEmpty
        assertThat(betaResponseOutputItem.mcpListTools()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseOutputItem.customToolCall()).isEmpty
        assertThat(betaResponseOutputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofApplyPatchCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItem =
            BetaResponseOutputItem.ofApplyPatchCallOutput(
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

        val roundtrippedBetaResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItem),
                jacksonTypeRef<BetaResponseOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseOutputItem).isEqualTo(betaResponseOutputItem)
    }

    @Test
    fun ofMcpCall() {
        val mcpCall =
            BetaResponseOutputItem.McpCall.builder()
                .id("id")
                .arguments("arguments")
                .name("name")
                .serverLabel("server_label")
                .agent(
                    BetaResponseOutputItem.McpCall.Agent.builder().agentName("agent_name").build()
                )
                .approvalRequestId("approval_request_id")
                .error("error")
                .output("output")
                .status(BetaResponseOutputItem.McpCall.Status.IN_PROGRESS)
                .build()

        val betaResponseOutputItem = BetaResponseOutputItem.ofMcpCall(mcpCall)

        assertThat(betaResponseOutputItem.message()).isEmpty
        assertThat(betaResponseOutputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.agentMessage()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.webSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.reasoning()).isEmpty
        assertThat(betaResponseOutputItem.program()).isEmpty
        assertThat(betaResponseOutputItem.programOutput()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseOutputItem.additionalTools()).isEmpty
        assertThat(betaResponseOutputItem.compaction()).isEmpty
        assertThat(betaResponseOutputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.shellCall()).isEmpty
        assertThat(betaResponseOutputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.mcpCall()).contains(mcpCall)
        assertThat(betaResponseOutputItem.mcpListTools()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseOutputItem.customToolCall()).isEmpty
        assertThat(betaResponseOutputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofMcpCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItem =
            BetaResponseOutputItem.ofMcpCall(
                BetaResponseOutputItem.McpCall.builder()
                    .id("id")
                    .arguments("arguments")
                    .name("name")
                    .serverLabel("server_label")
                    .agent(
                        BetaResponseOutputItem.McpCall.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .approvalRequestId("approval_request_id")
                    .error("error")
                    .output("output")
                    .status(BetaResponseOutputItem.McpCall.Status.IN_PROGRESS)
                    .build()
            )

        val roundtrippedBetaResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItem),
                jacksonTypeRef<BetaResponseOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseOutputItem).isEqualTo(betaResponseOutputItem)
    }

    @Test
    fun ofMcpListTools() {
        val mcpListTools =
            BetaResponseOutputItem.McpListTools.builder()
                .id("id")
                .serverLabel("server_label")
                .addTool(
                    BetaResponseOutputItem.McpListTools.Tool.builder()
                        .inputSchema(JsonValue.from(mapOf<String, Any>()))
                        .name("name")
                        .annotations(JsonValue.from(mapOf<String, Any>()))
                        .description("description")
                        .build()
                )
                .agent(
                    BetaResponseOutputItem.McpListTools.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .error("error")
                .build()

        val betaResponseOutputItem = BetaResponseOutputItem.ofMcpListTools(mcpListTools)

        assertThat(betaResponseOutputItem.message()).isEmpty
        assertThat(betaResponseOutputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.agentMessage()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.webSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.reasoning()).isEmpty
        assertThat(betaResponseOutputItem.program()).isEmpty
        assertThat(betaResponseOutputItem.programOutput()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseOutputItem.additionalTools()).isEmpty
        assertThat(betaResponseOutputItem.compaction()).isEmpty
        assertThat(betaResponseOutputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.shellCall()).isEmpty
        assertThat(betaResponseOutputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.mcpCall()).isEmpty
        assertThat(betaResponseOutputItem.mcpListTools()).contains(mcpListTools)
        assertThat(betaResponseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseOutputItem.customToolCall()).isEmpty
        assertThat(betaResponseOutputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofMcpListToolsRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItem =
            BetaResponseOutputItem.ofMcpListTools(
                BetaResponseOutputItem.McpListTools.builder()
                    .id("id")
                    .serverLabel("server_label")
                    .addTool(
                        BetaResponseOutputItem.McpListTools.Tool.builder()
                            .inputSchema(JsonValue.from(mapOf<String, Any>()))
                            .name("name")
                            .annotations(JsonValue.from(mapOf<String, Any>()))
                            .description("description")
                            .build()
                    )
                    .agent(
                        BetaResponseOutputItem.McpListTools.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .error("error")
                    .build()
            )

        val roundtrippedBetaResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItem),
                jacksonTypeRef<BetaResponseOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseOutputItem).isEqualTo(betaResponseOutputItem)
    }

    @Test
    fun ofMcpApprovalRequest() {
        val mcpApprovalRequest =
            BetaResponseOutputItem.McpApprovalRequest.builder()
                .id("id")
                .arguments("arguments")
                .name("name")
                .serverLabel("server_label")
                .agent(
                    BetaResponseOutputItem.McpApprovalRequest.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .build()

        val betaResponseOutputItem = BetaResponseOutputItem.ofMcpApprovalRequest(mcpApprovalRequest)

        assertThat(betaResponseOutputItem.message()).isEmpty
        assertThat(betaResponseOutputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.agentMessage()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.webSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.reasoning()).isEmpty
        assertThat(betaResponseOutputItem.program()).isEmpty
        assertThat(betaResponseOutputItem.programOutput()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseOutputItem.additionalTools()).isEmpty
        assertThat(betaResponseOutputItem.compaction()).isEmpty
        assertThat(betaResponseOutputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.shellCall()).isEmpty
        assertThat(betaResponseOutputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.mcpCall()).isEmpty
        assertThat(betaResponseOutputItem.mcpListTools()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalRequest()).contains(mcpApprovalRequest)
        assertThat(betaResponseOutputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseOutputItem.customToolCall()).isEmpty
        assertThat(betaResponseOutputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofMcpApprovalRequestRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItem =
            BetaResponseOutputItem.ofMcpApprovalRequest(
                BetaResponseOutputItem.McpApprovalRequest.builder()
                    .id("id")
                    .arguments("arguments")
                    .name("name")
                    .serverLabel("server_label")
                    .agent(
                        BetaResponseOutputItem.McpApprovalRequest.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .build()
            )

        val roundtrippedBetaResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItem),
                jacksonTypeRef<BetaResponseOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseOutputItem).isEqualTo(betaResponseOutputItem)
    }

    @Test
    fun ofMcpApprovalResponse() {
        val mcpApprovalResponse =
            BetaResponseOutputItem.McpApprovalResponse.builder()
                .id("id")
                .approvalRequestId("approval_request_id")
                .approve(true)
                .agent(
                    BetaResponseOutputItem.McpApprovalResponse.Agent.builder()
                        .agentName("agent_name")
                        .build()
                )
                .reason("reason")
                .build()

        val betaResponseOutputItem =
            BetaResponseOutputItem.ofMcpApprovalResponse(mcpApprovalResponse)

        assertThat(betaResponseOutputItem.message()).isEmpty
        assertThat(betaResponseOutputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.agentMessage()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.webSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.reasoning()).isEmpty
        assertThat(betaResponseOutputItem.program()).isEmpty
        assertThat(betaResponseOutputItem.programOutput()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseOutputItem.additionalTools()).isEmpty
        assertThat(betaResponseOutputItem.compaction()).isEmpty
        assertThat(betaResponseOutputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.shellCall()).isEmpty
        assertThat(betaResponseOutputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.mcpCall()).isEmpty
        assertThat(betaResponseOutputItem.mcpListTools()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalResponse()).contains(mcpApprovalResponse)
        assertThat(betaResponseOutputItem.customToolCall()).isEmpty
        assertThat(betaResponseOutputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofMcpApprovalResponseRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItem =
            BetaResponseOutputItem.ofMcpApprovalResponse(
                BetaResponseOutputItem.McpApprovalResponse.builder()
                    .id("id")
                    .approvalRequestId("approval_request_id")
                    .approve(true)
                    .agent(
                        BetaResponseOutputItem.McpApprovalResponse.Agent.builder()
                            .agentName("agent_name")
                            .build()
                    )
                    .reason("reason")
                    .build()
            )

        val roundtrippedBetaResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItem),
                jacksonTypeRef<BetaResponseOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseOutputItem).isEqualTo(betaResponseOutputItem)
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

        val betaResponseOutputItem = BetaResponseOutputItem.ofCustomToolCall(customToolCall)

        assertThat(betaResponseOutputItem.message()).isEmpty
        assertThat(betaResponseOutputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.agentMessage()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.webSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.reasoning()).isEmpty
        assertThat(betaResponseOutputItem.program()).isEmpty
        assertThat(betaResponseOutputItem.programOutput()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseOutputItem.additionalTools()).isEmpty
        assertThat(betaResponseOutputItem.compaction()).isEmpty
        assertThat(betaResponseOutputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.shellCall()).isEmpty
        assertThat(betaResponseOutputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.mcpCall()).isEmpty
        assertThat(betaResponseOutputItem.mcpListTools()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseOutputItem.customToolCall()).contains(customToolCall)
        assertThat(betaResponseOutputItem.customToolCallOutput()).isEmpty
    }

    @Test
    fun ofCustomToolCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItem =
            BetaResponseOutputItem.ofCustomToolCall(
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

        val roundtrippedBetaResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItem),
                jacksonTypeRef<BetaResponseOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseOutputItem).isEqualTo(betaResponseOutputItem)
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

        val betaResponseOutputItem =
            BetaResponseOutputItem.ofCustomToolCallOutput(customToolCallOutput)

        assertThat(betaResponseOutputItem.message()).isEmpty
        assertThat(betaResponseOutputItem.fileSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCall()).isEmpty
        assertThat(betaResponseOutputItem.functionCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.agentMessage()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCall()).isEmpty
        assertThat(betaResponseOutputItem.multiAgentCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.webSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCall()).isEmpty
        assertThat(betaResponseOutputItem.computerCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.reasoning()).isEmpty
        assertThat(betaResponseOutputItem.program()).isEmpty
        assertThat(betaResponseOutputItem.programOutput()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchCall()).isEmpty
        assertThat(betaResponseOutputItem.toolSearchOutput()).isEmpty
        assertThat(betaResponseOutputItem.additionalTools()).isEmpty
        assertThat(betaResponseOutputItem.compaction()).isEmpty
        assertThat(betaResponseOutputItem.imageGenerationCall()).isEmpty
        assertThat(betaResponseOutputItem.codeInterpreterCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCall()).isEmpty
        assertThat(betaResponseOutputItem.localShellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.shellCall()).isEmpty
        assertThat(betaResponseOutputItem.shellCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCall()).isEmpty
        assertThat(betaResponseOutputItem.applyPatchCallOutput()).isEmpty
        assertThat(betaResponseOutputItem.mcpCall()).isEmpty
        assertThat(betaResponseOutputItem.mcpListTools()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalRequest()).isEmpty
        assertThat(betaResponseOutputItem.mcpApprovalResponse()).isEmpty
        assertThat(betaResponseOutputItem.customToolCall()).isEmpty
        assertThat(betaResponseOutputItem.customToolCallOutput()).contains(customToolCallOutput)
    }

    @Test
    fun ofCustomToolCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputItem =
            BetaResponseOutputItem.ofCustomToolCallOutput(
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

        val roundtrippedBetaResponseOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputItem),
                jacksonTypeRef<BetaResponseOutputItem>(),
            )

        assertThat(roundtrippedBetaResponseOutputItem).isEqualTo(betaResponseOutputItem)
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
        val betaResponseOutputItem =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<BetaResponseOutputItem>())

        val e = assertThrows<OpenAIInvalidDataException> { betaResponseOutputItem.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
