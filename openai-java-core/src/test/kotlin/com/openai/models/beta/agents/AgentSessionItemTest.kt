// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class AgentSessionItemTest {

    @Test
    fun ofMessage() {
        val message =
            AgentSessionMessage.builder()
                .id("id")
                .addInputTextContent("text")
                .phase(AgentSessionMessage.Phase.COMMENTARY)
                .role(AgentSessionMessage.Role.USER)
                .status(AgentOutputItemStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        val agentSessionItem = AgentSessionItem.ofMessage(message)

        assertThat(agentSessionItem.message()).contains(message)
        assertThat(agentSessionItem.reasoning()).isEmpty
        assertThat(agentSessionItem.functionCall()).isEmpty
        assertThat(agentSessionItem.functionCallOutput()).isEmpty
        assertThat(agentSessionItem.agentMessage()).isEmpty
        assertThat(agentSessionItem.mcpCall()).isEmpty
        assertThat(agentSessionItem.webSearchCall()).isEmpty
        assertThat(agentSessionItem.commandExecution()).isEmpty
        assertThat(agentSessionItem.createSubagentCall()).isEmpty
        assertThat(agentSessionItem.sendSubagentInputCall()).isEmpty
        assertThat(agentSessionItem.resumeSubagentCall()).isEmpty
        assertThat(agentSessionItem.waitForSubagentsCall()).isEmpty
        assertThat(agentSessionItem.interruptSubagentCall()).isEmpty
        assertThat(agentSessionItem.closeSubagentCall()).isEmpty
    }

    @Test
    fun ofMessageRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionItem =
            AgentSessionItem.ofMessage(
                AgentSessionMessage.builder()
                    .id("id")
                    .addInputTextContent("text")
                    .phase(AgentSessionMessage.Phase.COMMENTARY)
                    .role(AgentSessionMessage.Role.USER)
                    .status(AgentOutputItemStatus.IN_PROGRESS)
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentSessionItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionItem),
                jacksonTypeRef<AgentSessionItem>(),
            )

        assertThat(roundtrippedAgentSessionItem).isEqualTo(agentSessionItem)
    }

    @Test
    fun ofReasoning() {
        val reasoning =
            AgentReasoningItem.builder()
                .id("id")
                .status(AgentOutputItemStatus.IN_PROGRESS)
                .addSummary(SummaryText.builder().text("text").build())
                .turnId("turn_id")
                .build()

        val agentSessionItem = AgentSessionItem.ofReasoning(reasoning)

        assertThat(agentSessionItem.message()).isEmpty
        assertThat(agentSessionItem.reasoning()).contains(reasoning)
        assertThat(agentSessionItem.functionCall()).isEmpty
        assertThat(agentSessionItem.functionCallOutput()).isEmpty
        assertThat(agentSessionItem.agentMessage()).isEmpty
        assertThat(agentSessionItem.mcpCall()).isEmpty
        assertThat(agentSessionItem.webSearchCall()).isEmpty
        assertThat(agentSessionItem.commandExecution()).isEmpty
        assertThat(agentSessionItem.createSubagentCall()).isEmpty
        assertThat(agentSessionItem.sendSubagentInputCall()).isEmpty
        assertThat(agentSessionItem.resumeSubagentCall()).isEmpty
        assertThat(agentSessionItem.waitForSubagentsCall()).isEmpty
        assertThat(agentSessionItem.interruptSubagentCall()).isEmpty
        assertThat(agentSessionItem.closeSubagentCall()).isEmpty
    }

    @Test
    fun ofReasoningRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionItem =
            AgentSessionItem.ofReasoning(
                AgentReasoningItem.builder()
                    .id("id")
                    .status(AgentOutputItemStatus.IN_PROGRESS)
                    .addSummary(SummaryText.builder().text("text").build())
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentSessionItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionItem),
                jacksonTypeRef<AgentSessionItem>(),
            )

        assertThat(roundtrippedAgentSessionItem).isEqualTo(agentSessionItem)
    }

    @Test
    fun ofFunctionCall() {
        val functionCall =
            AgentFunctionCallItem.builder()
                .id("id")
                .arguments(JsonValue.from(mapOf<String, Any>()))
                .callId("call_id")
                .name("name")
                .status(AgentFunctionCallStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        val agentSessionItem = AgentSessionItem.ofFunctionCall(functionCall)

        assertThat(agentSessionItem.message()).isEmpty
        assertThat(agentSessionItem.reasoning()).isEmpty
        assertThat(agentSessionItem.functionCall()).contains(functionCall)
        assertThat(agentSessionItem.functionCallOutput()).isEmpty
        assertThat(agentSessionItem.agentMessage()).isEmpty
        assertThat(agentSessionItem.mcpCall()).isEmpty
        assertThat(agentSessionItem.webSearchCall()).isEmpty
        assertThat(agentSessionItem.commandExecution()).isEmpty
        assertThat(agentSessionItem.createSubagentCall()).isEmpty
        assertThat(agentSessionItem.sendSubagentInputCall()).isEmpty
        assertThat(agentSessionItem.resumeSubagentCall()).isEmpty
        assertThat(agentSessionItem.waitForSubagentsCall()).isEmpty
        assertThat(agentSessionItem.interruptSubagentCall()).isEmpty
        assertThat(agentSessionItem.closeSubagentCall()).isEmpty
    }

    @Test
    fun ofFunctionCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionItem =
            AgentSessionItem.ofFunctionCall(
                AgentFunctionCallItem.builder()
                    .id("id")
                    .arguments(JsonValue.from(mapOf<String, Any>()))
                    .callId("call_id")
                    .name("name")
                    .status(AgentFunctionCallStatus.IN_PROGRESS)
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentSessionItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionItem),
                jacksonTypeRef<AgentSessionItem>(),
            )

        assertThat(roundtrippedAgentSessionItem).isEqualTo(agentSessionItem)
    }

    @Test
    fun ofFunctionCallOutput() {
        val functionCallOutput =
            AgentSessionItem.FunctionCallOutput.builder()
                .id("id")
                .callId("call_id")
                .error("error")
                .output("string")
                .status(AgentFunctionCallStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        val agentSessionItem = AgentSessionItem.ofFunctionCallOutput(functionCallOutput)

        assertThat(agentSessionItem.message()).isEmpty
        assertThat(agentSessionItem.reasoning()).isEmpty
        assertThat(agentSessionItem.functionCall()).isEmpty
        assertThat(agentSessionItem.functionCallOutput()).contains(functionCallOutput)
        assertThat(agentSessionItem.agentMessage()).isEmpty
        assertThat(agentSessionItem.mcpCall()).isEmpty
        assertThat(agentSessionItem.webSearchCall()).isEmpty
        assertThat(agentSessionItem.commandExecution()).isEmpty
        assertThat(agentSessionItem.createSubagentCall()).isEmpty
        assertThat(agentSessionItem.sendSubagentInputCall()).isEmpty
        assertThat(agentSessionItem.resumeSubagentCall()).isEmpty
        assertThat(agentSessionItem.waitForSubagentsCall()).isEmpty
        assertThat(agentSessionItem.interruptSubagentCall()).isEmpty
        assertThat(agentSessionItem.closeSubagentCall()).isEmpty
    }

    @Test
    fun ofFunctionCallOutputRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionItem =
            AgentSessionItem.ofFunctionCallOutput(
                AgentSessionItem.FunctionCallOutput.builder()
                    .id("id")
                    .callId("call_id")
                    .error("error")
                    .output("string")
                    .status(AgentFunctionCallStatus.IN_PROGRESS)
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentSessionItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionItem),
                jacksonTypeRef<AgentSessionItem>(),
            )

        assertThat(roundtrippedAgentSessionItem).isEqualTo(agentSessionItem)
    }

    @Test
    fun ofAgentMessage() {
        val agentMessage =
            AgentSessionItem.AgentMessage.builder()
                .id("id")
                .addOutputTextContent("text")
                .recipientAgentId("recipient_agent_id")
                .senderAgentId("sender_agent_id")
                .turnId("turn_id")
                .build()

        val agentSessionItem = AgentSessionItem.ofAgentMessage(agentMessage)

        assertThat(agentSessionItem.message()).isEmpty
        assertThat(agentSessionItem.reasoning()).isEmpty
        assertThat(agentSessionItem.functionCall()).isEmpty
        assertThat(agentSessionItem.functionCallOutput()).isEmpty
        assertThat(agentSessionItem.agentMessage()).contains(agentMessage)
        assertThat(agentSessionItem.mcpCall()).isEmpty
        assertThat(agentSessionItem.webSearchCall()).isEmpty
        assertThat(agentSessionItem.commandExecution()).isEmpty
        assertThat(agentSessionItem.createSubagentCall()).isEmpty
        assertThat(agentSessionItem.sendSubagentInputCall()).isEmpty
        assertThat(agentSessionItem.resumeSubagentCall()).isEmpty
        assertThat(agentSessionItem.waitForSubagentsCall()).isEmpty
        assertThat(agentSessionItem.interruptSubagentCall()).isEmpty
        assertThat(agentSessionItem.closeSubagentCall()).isEmpty
    }

    @Test
    fun ofAgentMessageRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionItem =
            AgentSessionItem.ofAgentMessage(
                AgentSessionItem.AgentMessage.builder()
                    .id("id")
                    .addOutputTextContent("text")
                    .recipientAgentId("recipient_agent_id")
                    .senderAgentId("sender_agent_id")
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentSessionItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionItem),
                jacksonTypeRef<AgentSessionItem>(),
            )

        assertThat(roundtrippedAgentSessionItem).isEqualTo(agentSessionItem)
    }

    @Test
    fun ofMcpCall() {
        val mcpCall =
            AgentMcpCallItem.builder()
                .id("id")
                .arguments(JsonValue.from(mapOf<String, Any>()))
                .error(JsonValue.from(mapOf<String, Any>()))
                .name("name")
                .output(JsonValue.from(mapOf<String, Any>()))
                .serverLabel("server_label")
                .status(AgentFunctionCallStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        val agentSessionItem = AgentSessionItem.ofMcpCall(mcpCall)

        assertThat(agentSessionItem.message()).isEmpty
        assertThat(agentSessionItem.reasoning()).isEmpty
        assertThat(agentSessionItem.functionCall()).isEmpty
        assertThat(agentSessionItem.functionCallOutput()).isEmpty
        assertThat(agentSessionItem.agentMessage()).isEmpty
        assertThat(agentSessionItem.mcpCall()).contains(mcpCall)
        assertThat(agentSessionItem.webSearchCall()).isEmpty
        assertThat(agentSessionItem.commandExecution()).isEmpty
        assertThat(agentSessionItem.createSubagentCall()).isEmpty
        assertThat(agentSessionItem.sendSubagentInputCall()).isEmpty
        assertThat(agentSessionItem.resumeSubagentCall()).isEmpty
        assertThat(agentSessionItem.waitForSubagentsCall()).isEmpty
        assertThat(agentSessionItem.interruptSubagentCall()).isEmpty
        assertThat(agentSessionItem.closeSubagentCall()).isEmpty
    }

    @Test
    fun ofMcpCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionItem =
            AgentSessionItem.ofMcpCall(
                AgentMcpCallItem.builder()
                    .id("id")
                    .arguments(JsonValue.from(mapOf<String, Any>()))
                    .error(JsonValue.from(mapOf<String, Any>()))
                    .name("name")
                    .output(JsonValue.from(mapOf<String, Any>()))
                    .serverLabel("server_label")
                    .status(AgentFunctionCallStatus.IN_PROGRESS)
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentSessionItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionItem),
                jacksonTypeRef<AgentSessionItem>(),
            )

        assertThat(roundtrippedAgentSessionItem).isEqualTo(agentSessionItem)
    }

    @Test
    fun ofWebSearchCall() {
        val webSearchCall =
            AgentWebSearchCallItem.builder()
                .id("id")
                .action(WebSearchAction.Search.builder().addQuery("string").query("query").build())
                .status(AgentOutputItemStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        val agentSessionItem = AgentSessionItem.ofWebSearchCall(webSearchCall)

        assertThat(agentSessionItem.message()).isEmpty
        assertThat(agentSessionItem.reasoning()).isEmpty
        assertThat(agentSessionItem.functionCall()).isEmpty
        assertThat(agentSessionItem.functionCallOutput()).isEmpty
        assertThat(agentSessionItem.agentMessage()).isEmpty
        assertThat(agentSessionItem.mcpCall()).isEmpty
        assertThat(agentSessionItem.webSearchCall()).contains(webSearchCall)
        assertThat(agentSessionItem.commandExecution()).isEmpty
        assertThat(agentSessionItem.createSubagentCall()).isEmpty
        assertThat(agentSessionItem.sendSubagentInputCall()).isEmpty
        assertThat(agentSessionItem.resumeSubagentCall()).isEmpty
        assertThat(agentSessionItem.waitForSubagentsCall()).isEmpty
        assertThat(agentSessionItem.interruptSubagentCall()).isEmpty
        assertThat(agentSessionItem.closeSubagentCall()).isEmpty
    }

    @Test
    fun ofWebSearchCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionItem =
            AgentSessionItem.ofWebSearchCall(
                AgentWebSearchCallItem.builder()
                    .id("id")
                    .action(
                        WebSearchAction.Search.builder().addQuery("string").query("query").build()
                    )
                    .status(AgentOutputItemStatus.IN_PROGRESS)
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentSessionItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionItem),
                jacksonTypeRef<AgentSessionItem>(),
            )

        assertThat(roundtrippedAgentSessionItem).isEqualTo(agentSessionItem)
    }

    @Test
    fun ofCommandExecution() {
        val commandExecution =
            AgentCommandExecutionItem.builder()
                .id("id")
                .command("command")
                .cwd("cwd")
                .durationMs(0L)
                .exitCode(0L)
                .output("output")
                .status(AgentFunctionCallStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        val agentSessionItem = AgentSessionItem.ofCommandExecution(commandExecution)

        assertThat(agentSessionItem.message()).isEmpty
        assertThat(agentSessionItem.reasoning()).isEmpty
        assertThat(agentSessionItem.functionCall()).isEmpty
        assertThat(agentSessionItem.functionCallOutput()).isEmpty
        assertThat(agentSessionItem.agentMessage()).isEmpty
        assertThat(agentSessionItem.mcpCall()).isEmpty
        assertThat(agentSessionItem.webSearchCall()).isEmpty
        assertThat(agentSessionItem.commandExecution()).contains(commandExecution)
        assertThat(agentSessionItem.createSubagentCall()).isEmpty
        assertThat(agentSessionItem.sendSubagentInputCall()).isEmpty
        assertThat(agentSessionItem.resumeSubagentCall()).isEmpty
        assertThat(agentSessionItem.waitForSubagentsCall()).isEmpty
        assertThat(agentSessionItem.interruptSubagentCall()).isEmpty
        assertThat(agentSessionItem.closeSubagentCall()).isEmpty
    }

    @Test
    fun ofCommandExecutionRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionItem =
            AgentSessionItem.ofCommandExecution(
                AgentCommandExecutionItem.builder()
                    .id("id")
                    .command("command")
                    .cwd("cwd")
                    .durationMs(0L)
                    .exitCode(0L)
                    .output("output")
                    .status(AgentFunctionCallStatus.IN_PROGRESS)
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentSessionItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionItem),
                jacksonTypeRef<AgentSessionItem>(),
            )

        assertThat(roundtrippedAgentSessionItem).isEqualTo(agentSessionItem)
    }

    @Test
    fun ofCreateSubagentCall() {
        val createSubagentCall =
            AgentCreateSubagentCallItem.builder()
                .id("id")
                .agentId("agent_id")
                .addOutputTextContent("text")
                .model("model")
                .reasoningEffort("reasoning_effort")
                .status(AgentFunctionCallStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        val agentSessionItem = AgentSessionItem.ofCreateSubagentCall(createSubagentCall)

        assertThat(agentSessionItem.message()).isEmpty
        assertThat(agentSessionItem.reasoning()).isEmpty
        assertThat(agentSessionItem.functionCall()).isEmpty
        assertThat(agentSessionItem.functionCallOutput()).isEmpty
        assertThat(agentSessionItem.agentMessage()).isEmpty
        assertThat(agentSessionItem.mcpCall()).isEmpty
        assertThat(agentSessionItem.webSearchCall()).isEmpty
        assertThat(agentSessionItem.commandExecution()).isEmpty
        assertThat(agentSessionItem.createSubagentCall()).contains(createSubagentCall)
        assertThat(agentSessionItem.sendSubagentInputCall()).isEmpty
        assertThat(agentSessionItem.resumeSubagentCall()).isEmpty
        assertThat(agentSessionItem.waitForSubagentsCall()).isEmpty
        assertThat(agentSessionItem.interruptSubagentCall()).isEmpty
        assertThat(agentSessionItem.closeSubagentCall()).isEmpty
    }

    @Test
    fun ofCreateSubagentCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionItem =
            AgentSessionItem.ofCreateSubagentCall(
                AgentCreateSubagentCallItem.builder()
                    .id("id")
                    .agentId("agent_id")
                    .addOutputTextContent("text")
                    .model("model")
                    .reasoningEffort("reasoning_effort")
                    .status(AgentFunctionCallStatus.IN_PROGRESS)
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentSessionItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionItem),
                jacksonTypeRef<AgentSessionItem>(),
            )

        assertThat(roundtrippedAgentSessionItem).isEqualTo(agentSessionItem)
    }

    @Test
    fun ofSendSubagentInputCall() {
        val sendSubagentInputCall =
            AgentSendSubagentInputCallItem.builder()
                .id("id")
                .addOutputTextContent("text")
                .recipientAgentId("recipient_agent_id")
                .senderAgentId("sender_agent_id")
                .status(AgentFunctionCallStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        val agentSessionItem = AgentSessionItem.ofSendSubagentInputCall(sendSubagentInputCall)

        assertThat(agentSessionItem.message()).isEmpty
        assertThat(agentSessionItem.reasoning()).isEmpty
        assertThat(agentSessionItem.functionCall()).isEmpty
        assertThat(agentSessionItem.functionCallOutput()).isEmpty
        assertThat(agentSessionItem.agentMessage()).isEmpty
        assertThat(agentSessionItem.mcpCall()).isEmpty
        assertThat(agentSessionItem.webSearchCall()).isEmpty
        assertThat(agentSessionItem.commandExecution()).isEmpty
        assertThat(agentSessionItem.createSubagentCall()).isEmpty
        assertThat(agentSessionItem.sendSubagentInputCall()).contains(sendSubagentInputCall)
        assertThat(agentSessionItem.resumeSubagentCall()).isEmpty
        assertThat(agentSessionItem.waitForSubagentsCall()).isEmpty
        assertThat(agentSessionItem.interruptSubagentCall()).isEmpty
        assertThat(agentSessionItem.closeSubagentCall()).isEmpty
    }

    @Test
    fun ofSendSubagentInputCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionItem =
            AgentSessionItem.ofSendSubagentInputCall(
                AgentSendSubagentInputCallItem.builder()
                    .id("id")
                    .addOutputTextContent("text")
                    .recipientAgentId("recipient_agent_id")
                    .senderAgentId("sender_agent_id")
                    .status(AgentFunctionCallStatus.IN_PROGRESS)
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentSessionItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionItem),
                jacksonTypeRef<AgentSessionItem>(),
            )

        assertThat(roundtrippedAgentSessionItem).isEqualTo(agentSessionItem)
    }

    @Test
    fun ofResumeSubagentCall() {
        val resumeSubagentCall =
            AgentResumeSubagentCallItem.builder()
                .id("id")
                .recipientAgentId("recipient_agent_id")
                .senderAgentId("sender_agent_id")
                .status(AgentFunctionCallStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        val agentSessionItem = AgentSessionItem.ofResumeSubagentCall(resumeSubagentCall)

        assertThat(agentSessionItem.message()).isEmpty
        assertThat(agentSessionItem.reasoning()).isEmpty
        assertThat(agentSessionItem.functionCall()).isEmpty
        assertThat(agentSessionItem.functionCallOutput()).isEmpty
        assertThat(agentSessionItem.agentMessage()).isEmpty
        assertThat(agentSessionItem.mcpCall()).isEmpty
        assertThat(agentSessionItem.webSearchCall()).isEmpty
        assertThat(agentSessionItem.commandExecution()).isEmpty
        assertThat(agentSessionItem.createSubagentCall()).isEmpty
        assertThat(agentSessionItem.sendSubagentInputCall()).isEmpty
        assertThat(agentSessionItem.resumeSubagentCall()).contains(resumeSubagentCall)
        assertThat(agentSessionItem.waitForSubagentsCall()).isEmpty
        assertThat(agentSessionItem.interruptSubagentCall()).isEmpty
        assertThat(agentSessionItem.closeSubagentCall()).isEmpty
    }

    @Test
    fun ofResumeSubagentCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionItem =
            AgentSessionItem.ofResumeSubagentCall(
                AgentResumeSubagentCallItem.builder()
                    .id("id")
                    .recipientAgentId("recipient_agent_id")
                    .senderAgentId("sender_agent_id")
                    .status(AgentFunctionCallStatus.IN_PROGRESS)
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentSessionItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionItem),
                jacksonTypeRef<AgentSessionItem>(),
            )

        assertThat(roundtrippedAgentSessionItem).isEqualTo(agentSessionItem)
    }

    @Test
    fun ofWaitForSubagentsCall() {
        val waitForSubagentsCall =
            AgentWaitForSubagentsCallItem.builder()
                .id("id")
                .addRecipientAgentId("string")
                .senderAgentId("sender_agent_id")
                .status(AgentFunctionCallStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        val agentSessionItem = AgentSessionItem.ofWaitForSubagentsCall(waitForSubagentsCall)

        assertThat(agentSessionItem.message()).isEmpty
        assertThat(agentSessionItem.reasoning()).isEmpty
        assertThat(agentSessionItem.functionCall()).isEmpty
        assertThat(agentSessionItem.functionCallOutput()).isEmpty
        assertThat(agentSessionItem.agentMessage()).isEmpty
        assertThat(agentSessionItem.mcpCall()).isEmpty
        assertThat(agentSessionItem.webSearchCall()).isEmpty
        assertThat(agentSessionItem.commandExecution()).isEmpty
        assertThat(agentSessionItem.createSubagentCall()).isEmpty
        assertThat(agentSessionItem.sendSubagentInputCall()).isEmpty
        assertThat(agentSessionItem.resumeSubagentCall()).isEmpty
        assertThat(agentSessionItem.waitForSubagentsCall()).contains(waitForSubagentsCall)
        assertThat(agentSessionItem.interruptSubagentCall()).isEmpty
        assertThat(agentSessionItem.closeSubagentCall()).isEmpty
    }

    @Test
    fun ofWaitForSubagentsCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionItem =
            AgentSessionItem.ofWaitForSubagentsCall(
                AgentWaitForSubagentsCallItem.builder()
                    .id("id")
                    .addRecipientAgentId("string")
                    .senderAgentId("sender_agent_id")
                    .status(AgentFunctionCallStatus.IN_PROGRESS)
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentSessionItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionItem),
                jacksonTypeRef<AgentSessionItem>(),
            )

        assertThat(roundtrippedAgentSessionItem).isEqualTo(agentSessionItem)
    }

    @Test
    fun ofInterruptSubagentCall() {
        val interruptSubagentCall =
            AgentInterruptSubagentCallItem.builder()
                .id("id")
                .recipientAgentId("recipient_agent_id")
                .senderAgentId("sender_agent_id")
                .status(AgentFunctionCallStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        val agentSessionItem = AgentSessionItem.ofInterruptSubagentCall(interruptSubagentCall)

        assertThat(agentSessionItem.message()).isEmpty
        assertThat(agentSessionItem.reasoning()).isEmpty
        assertThat(agentSessionItem.functionCall()).isEmpty
        assertThat(agentSessionItem.functionCallOutput()).isEmpty
        assertThat(agentSessionItem.agentMessage()).isEmpty
        assertThat(agentSessionItem.mcpCall()).isEmpty
        assertThat(agentSessionItem.webSearchCall()).isEmpty
        assertThat(agentSessionItem.commandExecution()).isEmpty
        assertThat(agentSessionItem.createSubagentCall()).isEmpty
        assertThat(agentSessionItem.sendSubagentInputCall()).isEmpty
        assertThat(agentSessionItem.resumeSubagentCall()).isEmpty
        assertThat(agentSessionItem.waitForSubagentsCall()).isEmpty
        assertThat(agentSessionItem.interruptSubagentCall()).contains(interruptSubagentCall)
        assertThat(agentSessionItem.closeSubagentCall()).isEmpty
    }

    @Test
    fun ofInterruptSubagentCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionItem =
            AgentSessionItem.ofInterruptSubagentCall(
                AgentInterruptSubagentCallItem.builder()
                    .id("id")
                    .recipientAgentId("recipient_agent_id")
                    .senderAgentId("sender_agent_id")
                    .status(AgentFunctionCallStatus.IN_PROGRESS)
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentSessionItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionItem),
                jacksonTypeRef<AgentSessionItem>(),
            )

        assertThat(roundtrippedAgentSessionItem).isEqualTo(agentSessionItem)
    }

    @Test
    fun ofCloseSubagentCall() {
        val closeSubagentCall =
            AgentCloseSubagentCallItem.builder()
                .id("id")
                .recipientAgentId("recipient_agent_id")
                .senderAgentId("sender_agent_id")
                .status(AgentFunctionCallStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        val agentSessionItem = AgentSessionItem.ofCloseSubagentCall(closeSubagentCall)

        assertThat(agentSessionItem.message()).isEmpty
        assertThat(agentSessionItem.reasoning()).isEmpty
        assertThat(agentSessionItem.functionCall()).isEmpty
        assertThat(agentSessionItem.functionCallOutput()).isEmpty
        assertThat(agentSessionItem.agentMessage()).isEmpty
        assertThat(agentSessionItem.mcpCall()).isEmpty
        assertThat(agentSessionItem.webSearchCall()).isEmpty
        assertThat(agentSessionItem.commandExecution()).isEmpty
        assertThat(agentSessionItem.createSubagentCall()).isEmpty
        assertThat(agentSessionItem.sendSubagentInputCall()).isEmpty
        assertThat(agentSessionItem.resumeSubagentCall()).isEmpty
        assertThat(agentSessionItem.waitForSubagentsCall()).isEmpty
        assertThat(agentSessionItem.interruptSubagentCall()).isEmpty
        assertThat(agentSessionItem.closeSubagentCall()).contains(closeSubagentCall)
    }

    @Test
    fun ofCloseSubagentCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionItem =
            AgentSessionItem.ofCloseSubagentCall(
                AgentCloseSubagentCallItem.builder()
                    .id("id")
                    .recipientAgentId("recipient_agent_id")
                    .senderAgentId("sender_agent_id")
                    .status(AgentFunctionCallStatus.IN_PROGRESS)
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentSessionItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionItem),
                jacksonTypeRef<AgentSessionItem>(),
            )

        assertThat(roundtrippedAgentSessionItem).isEqualTo(agentSessionItem)
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
        val agentSessionItem =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<AgentSessionItem>())

        val e = assertThrows<OpenAIInvalidDataException> { agentSessionItem.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
