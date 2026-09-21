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

internal class AgentOutputItemTest {

    @Test
    fun ofMessage() {
        val message =
            AgentSessionAssistantMessage.builder()
                .id("id")
                .addContent(OutputText.builder().text("text").build())
                .phase(AgentSessionAssistantMessage.Phase.COMMENTARY)
                .status(AgentOutputItemStatus.IN_PROGRESS)
                .turnId("turn_id")
                .build()

        val agentOutputItem = AgentOutputItem.ofMessage(message)

        assertThat(agentOutputItem.message()).contains(message)
        assertThat(agentOutputItem.reasoning()).isEmpty
        assertThat(agentOutputItem.functionCall()).isEmpty
        assertThat(agentOutputItem.mcpCall()).isEmpty
        assertThat(agentOutputItem.webSearchCall()).isEmpty
        assertThat(agentOutputItem.commandExecution()).isEmpty
        assertThat(agentOutputItem.createSubagentCall()).isEmpty
        assertThat(agentOutputItem.sendSubagentInputCall()).isEmpty
        assertThat(agentOutputItem.resumeSubagentCall()).isEmpty
        assertThat(agentOutputItem.waitForSubagentsCall()).isEmpty
        assertThat(agentOutputItem.interruptSubagentCall()).isEmpty
        assertThat(agentOutputItem.closeSubagentCall()).isEmpty
    }

    @Test
    fun ofMessageRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentOutputItem =
            AgentOutputItem.ofMessage(
                AgentSessionAssistantMessage.builder()
                    .id("id")
                    .addContent(OutputText.builder().text("text").build())
                    .phase(AgentSessionAssistantMessage.Phase.COMMENTARY)
                    .status(AgentOutputItemStatus.IN_PROGRESS)
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentOutputItem),
                jacksonTypeRef<AgentOutputItem>(),
            )

        assertThat(roundtrippedAgentOutputItem).isEqualTo(agentOutputItem)
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

        val agentOutputItem = AgentOutputItem.ofReasoning(reasoning)

        assertThat(agentOutputItem.message()).isEmpty
        assertThat(agentOutputItem.reasoning()).contains(reasoning)
        assertThat(agentOutputItem.functionCall()).isEmpty
        assertThat(agentOutputItem.mcpCall()).isEmpty
        assertThat(agentOutputItem.webSearchCall()).isEmpty
        assertThat(agentOutputItem.commandExecution()).isEmpty
        assertThat(agentOutputItem.createSubagentCall()).isEmpty
        assertThat(agentOutputItem.sendSubagentInputCall()).isEmpty
        assertThat(agentOutputItem.resumeSubagentCall()).isEmpty
        assertThat(agentOutputItem.waitForSubagentsCall()).isEmpty
        assertThat(agentOutputItem.interruptSubagentCall()).isEmpty
        assertThat(agentOutputItem.closeSubagentCall()).isEmpty
    }

    @Test
    fun ofReasoningRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentOutputItem =
            AgentOutputItem.ofReasoning(
                AgentReasoningItem.builder()
                    .id("id")
                    .status(AgentOutputItemStatus.IN_PROGRESS)
                    .addSummary(SummaryText.builder().text("text").build())
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentOutputItem),
                jacksonTypeRef<AgentOutputItem>(),
            )

        assertThat(roundtrippedAgentOutputItem).isEqualTo(agentOutputItem)
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

        val agentOutputItem = AgentOutputItem.ofFunctionCall(functionCall)

        assertThat(agentOutputItem.message()).isEmpty
        assertThat(agentOutputItem.reasoning()).isEmpty
        assertThat(agentOutputItem.functionCall()).contains(functionCall)
        assertThat(agentOutputItem.mcpCall()).isEmpty
        assertThat(agentOutputItem.webSearchCall()).isEmpty
        assertThat(agentOutputItem.commandExecution()).isEmpty
        assertThat(agentOutputItem.createSubagentCall()).isEmpty
        assertThat(agentOutputItem.sendSubagentInputCall()).isEmpty
        assertThat(agentOutputItem.resumeSubagentCall()).isEmpty
        assertThat(agentOutputItem.waitForSubagentsCall()).isEmpty
        assertThat(agentOutputItem.interruptSubagentCall()).isEmpty
        assertThat(agentOutputItem.closeSubagentCall()).isEmpty
    }

    @Test
    fun ofFunctionCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentOutputItem =
            AgentOutputItem.ofFunctionCall(
                AgentFunctionCallItem.builder()
                    .id("id")
                    .arguments(JsonValue.from(mapOf<String, Any>()))
                    .callId("call_id")
                    .name("name")
                    .status(AgentFunctionCallStatus.IN_PROGRESS)
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentOutputItem),
                jacksonTypeRef<AgentOutputItem>(),
            )

        assertThat(roundtrippedAgentOutputItem).isEqualTo(agentOutputItem)
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

        val agentOutputItem = AgentOutputItem.ofMcpCall(mcpCall)

        assertThat(agentOutputItem.message()).isEmpty
        assertThat(agentOutputItem.reasoning()).isEmpty
        assertThat(agentOutputItem.functionCall()).isEmpty
        assertThat(agentOutputItem.mcpCall()).contains(mcpCall)
        assertThat(agentOutputItem.webSearchCall()).isEmpty
        assertThat(agentOutputItem.commandExecution()).isEmpty
        assertThat(agentOutputItem.createSubagentCall()).isEmpty
        assertThat(agentOutputItem.sendSubagentInputCall()).isEmpty
        assertThat(agentOutputItem.resumeSubagentCall()).isEmpty
        assertThat(agentOutputItem.waitForSubagentsCall()).isEmpty
        assertThat(agentOutputItem.interruptSubagentCall()).isEmpty
        assertThat(agentOutputItem.closeSubagentCall()).isEmpty
    }

    @Test
    fun ofMcpCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentOutputItem =
            AgentOutputItem.ofMcpCall(
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

        val roundtrippedAgentOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentOutputItem),
                jacksonTypeRef<AgentOutputItem>(),
            )

        assertThat(roundtrippedAgentOutputItem).isEqualTo(agentOutputItem)
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

        val agentOutputItem = AgentOutputItem.ofWebSearchCall(webSearchCall)

        assertThat(agentOutputItem.message()).isEmpty
        assertThat(agentOutputItem.reasoning()).isEmpty
        assertThat(agentOutputItem.functionCall()).isEmpty
        assertThat(agentOutputItem.mcpCall()).isEmpty
        assertThat(agentOutputItem.webSearchCall()).contains(webSearchCall)
        assertThat(agentOutputItem.commandExecution()).isEmpty
        assertThat(agentOutputItem.createSubagentCall()).isEmpty
        assertThat(agentOutputItem.sendSubagentInputCall()).isEmpty
        assertThat(agentOutputItem.resumeSubagentCall()).isEmpty
        assertThat(agentOutputItem.waitForSubagentsCall()).isEmpty
        assertThat(agentOutputItem.interruptSubagentCall()).isEmpty
        assertThat(agentOutputItem.closeSubagentCall()).isEmpty
    }

    @Test
    fun ofWebSearchCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentOutputItem =
            AgentOutputItem.ofWebSearchCall(
                AgentWebSearchCallItem.builder()
                    .id("id")
                    .action(
                        WebSearchAction.Search.builder().addQuery("string").query("query").build()
                    )
                    .status(AgentOutputItemStatus.IN_PROGRESS)
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentOutputItem),
                jacksonTypeRef<AgentOutputItem>(),
            )

        assertThat(roundtrippedAgentOutputItem).isEqualTo(agentOutputItem)
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

        val agentOutputItem = AgentOutputItem.ofCommandExecution(commandExecution)

        assertThat(agentOutputItem.message()).isEmpty
        assertThat(agentOutputItem.reasoning()).isEmpty
        assertThat(agentOutputItem.functionCall()).isEmpty
        assertThat(agentOutputItem.mcpCall()).isEmpty
        assertThat(agentOutputItem.webSearchCall()).isEmpty
        assertThat(agentOutputItem.commandExecution()).contains(commandExecution)
        assertThat(agentOutputItem.createSubagentCall()).isEmpty
        assertThat(agentOutputItem.sendSubagentInputCall()).isEmpty
        assertThat(agentOutputItem.resumeSubagentCall()).isEmpty
        assertThat(agentOutputItem.waitForSubagentsCall()).isEmpty
        assertThat(agentOutputItem.interruptSubagentCall()).isEmpty
        assertThat(agentOutputItem.closeSubagentCall()).isEmpty
    }

    @Test
    fun ofCommandExecutionRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentOutputItem =
            AgentOutputItem.ofCommandExecution(
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

        val roundtrippedAgentOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentOutputItem),
                jacksonTypeRef<AgentOutputItem>(),
            )

        assertThat(roundtrippedAgentOutputItem).isEqualTo(agentOutputItem)
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

        val agentOutputItem = AgentOutputItem.ofCreateSubagentCall(createSubagentCall)

        assertThat(agentOutputItem.message()).isEmpty
        assertThat(agentOutputItem.reasoning()).isEmpty
        assertThat(agentOutputItem.functionCall()).isEmpty
        assertThat(agentOutputItem.mcpCall()).isEmpty
        assertThat(agentOutputItem.webSearchCall()).isEmpty
        assertThat(agentOutputItem.commandExecution()).isEmpty
        assertThat(agentOutputItem.createSubagentCall()).contains(createSubagentCall)
        assertThat(agentOutputItem.sendSubagentInputCall()).isEmpty
        assertThat(agentOutputItem.resumeSubagentCall()).isEmpty
        assertThat(agentOutputItem.waitForSubagentsCall()).isEmpty
        assertThat(agentOutputItem.interruptSubagentCall()).isEmpty
        assertThat(agentOutputItem.closeSubagentCall()).isEmpty
    }

    @Test
    fun ofCreateSubagentCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentOutputItem =
            AgentOutputItem.ofCreateSubagentCall(
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

        val roundtrippedAgentOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentOutputItem),
                jacksonTypeRef<AgentOutputItem>(),
            )

        assertThat(roundtrippedAgentOutputItem).isEqualTo(agentOutputItem)
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

        val agentOutputItem = AgentOutputItem.ofSendSubagentInputCall(sendSubagentInputCall)

        assertThat(agentOutputItem.message()).isEmpty
        assertThat(agentOutputItem.reasoning()).isEmpty
        assertThat(agentOutputItem.functionCall()).isEmpty
        assertThat(agentOutputItem.mcpCall()).isEmpty
        assertThat(agentOutputItem.webSearchCall()).isEmpty
        assertThat(agentOutputItem.commandExecution()).isEmpty
        assertThat(agentOutputItem.createSubagentCall()).isEmpty
        assertThat(agentOutputItem.sendSubagentInputCall()).contains(sendSubagentInputCall)
        assertThat(agentOutputItem.resumeSubagentCall()).isEmpty
        assertThat(agentOutputItem.waitForSubagentsCall()).isEmpty
        assertThat(agentOutputItem.interruptSubagentCall()).isEmpty
        assertThat(agentOutputItem.closeSubagentCall()).isEmpty
    }

    @Test
    fun ofSendSubagentInputCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentOutputItem =
            AgentOutputItem.ofSendSubagentInputCall(
                AgentSendSubagentInputCallItem.builder()
                    .id("id")
                    .addOutputTextContent("text")
                    .recipientAgentId("recipient_agent_id")
                    .senderAgentId("sender_agent_id")
                    .status(AgentFunctionCallStatus.IN_PROGRESS)
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentOutputItem),
                jacksonTypeRef<AgentOutputItem>(),
            )

        assertThat(roundtrippedAgentOutputItem).isEqualTo(agentOutputItem)
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

        val agentOutputItem = AgentOutputItem.ofResumeSubagentCall(resumeSubagentCall)

        assertThat(agentOutputItem.message()).isEmpty
        assertThat(agentOutputItem.reasoning()).isEmpty
        assertThat(agentOutputItem.functionCall()).isEmpty
        assertThat(agentOutputItem.mcpCall()).isEmpty
        assertThat(agentOutputItem.webSearchCall()).isEmpty
        assertThat(agentOutputItem.commandExecution()).isEmpty
        assertThat(agentOutputItem.createSubagentCall()).isEmpty
        assertThat(agentOutputItem.sendSubagentInputCall()).isEmpty
        assertThat(agentOutputItem.resumeSubagentCall()).contains(resumeSubagentCall)
        assertThat(agentOutputItem.waitForSubagentsCall()).isEmpty
        assertThat(agentOutputItem.interruptSubagentCall()).isEmpty
        assertThat(agentOutputItem.closeSubagentCall()).isEmpty
    }

    @Test
    fun ofResumeSubagentCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentOutputItem =
            AgentOutputItem.ofResumeSubagentCall(
                AgentResumeSubagentCallItem.builder()
                    .id("id")
                    .recipientAgentId("recipient_agent_id")
                    .senderAgentId("sender_agent_id")
                    .status(AgentFunctionCallStatus.IN_PROGRESS)
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentOutputItem),
                jacksonTypeRef<AgentOutputItem>(),
            )

        assertThat(roundtrippedAgentOutputItem).isEqualTo(agentOutputItem)
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

        val agentOutputItem = AgentOutputItem.ofWaitForSubagentsCall(waitForSubagentsCall)

        assertThat(agentOutputItem.message()).isEmpty
        assertThat(agentOutputItem.reasoning()).isEmpty
        assertThat(agentOutputItem.functionCall()).isEmpty
        assertThat(agentOutputItem.mcpCall()).isEmpty
        assertThat(agentOutputItem.webSearchCall()).isEmpty
        assertThat(agentOutputItem.commandExecution()).isEmpty
        assertThat(agentOutputItem.createSubagentCall()).isEmpty
        assertThat(agentOutputItem.sendSubagentInputCall()).isEmpty
        assertThat(agentOutputItem.resumeSubagentCall()).isEmpty
        assertThat(agentOutputItem.waitForSubagentsCall()).contains(waitForSubagentsCall)
        assertThat(agentOutputItem.interruptSubagentCall()).isEmpty
        assertThat(agentOutputItem.closeSubagentCall()).isEmpty
    }

    @Test
    fun ofWaitForSubagentsCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentOutputItem =
            AgentOutputItem.ofWaitForSubagentsCall(
                AgentWaitForSubagentsCallItem.builder()
                    .id("id")
                    .addRecipientAgentId("string")
                    .senderAgentId("sender_agent_id")
                    .status(AgentFunctionCallStatus.IN_PROGRESS)
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentOutputItem),
                jacksonTypeRef<AgentOutputItem>(),
            )

        assertThat(roundtrippedAgentOutputItem).isEqualTo(agentOutputItem)
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

        val agentOutputItem = AgentOutputItem.ofInterruptSubagentCall(interruptSubagentCall)

        assertThat(agentOutputItem.message()).isEmpty
        assertThat(agentOutputItem.reasoning()).isEmpty
        assertThat(agentOutputItem.functionCall()).isEmpty
        assertThat(agentOutputItem.mcpCall()).isEmpty
        assertThat(agentOutputItem.webSearchCall()).isEmpty
        assertThat(agentOutputItem.commandExecution()).isEmpty
        assertThat(agentOutputItem.createSubagentCall()).isEmpty
        assertThat(agentOutputItem.sendSubagentInputCall()).isEmpty
        assertThat(agentOutputItem.resumeSubagentCall()).isEmpty
        assertThat(agentOutputItem.waitForSubagentsCall()).isEmpty
        assertThat(agentOutputItem.interruptSubagentCall()).contains(interruptSubagentCall)
        assertThat(agentOutputItem.closeSubagentCall()).isEmpty
    }

    @Test
    fun ofInterruptSubagentCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentOutputItem =
            AgentOutputItem.ofInterruptSubagentCall(
                AgentInterruptSubagentCallItem.builder()
                    .id("id")
                    .recipientAgentId("recipient_agent_id")
                    .senderAgentId("sender_agent_id")
                    .status(AgentFunctionCallStatus.IN_PROGRESS)
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentOutputItem),
                jacksonTypeRef<AgentOutputItem>(),
            )

        assertThat(roundtrippedAgentOutputItem).isEqualTo(agentOutputItem)
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

        val agentOutputItem = AgentOutputItem.ofCloseSubagentCall(closeSubagentCall)

        assertThat(agentOutputItem.message()).isEmpty
        assertThat(agentOutputItem.reasoning()).isEmpty
        assertThat(agentOutputItem.functionCall()).isEmpty
        assertThat(agentOutputItem.mcpCall()).isEmpty
        assertThat(agentOutputItem.webSearchCall()).isEmpty
        assertThat(agentOutputItem.commandExecution()).isEmpty
        assertThat(agentOutputItem.createSubagentCall()).isEmpty
        assertThat(agentOutputItem.sendSubagentInputCall()).isEmpty
        assertThat(agentOutputItem.resumeSubagentCall()).isEmpty
        assertThat(agentOutputItem.waitForSubagentsCall()).isEmpty
        assertThat(agentOutputItem.interruptSubagentCall()).isEmpty
        assertThat(agentOutputItem.closeSubagentCall()).contains(closeSubagentCall)
    }

    @Test
    fun ofCloseSubagentCallRoundtrip() {
        val jsonMapper = jsonMapper()
        val agentOutputItem =
            AgentOutputItem.ofCloseSubagentCall(
                AgentCloseSubagentCallItem.builder()
                    .id("id")
                    .recipientAgentId("recipient_agent_id")
                    .senderAgentId("sender_agent_id")
                    .status(AgentFunctionCallStatus.IN_PROGRESS)
                    .turnId("turn_id")
                    .build()
            )

        val roundtrippedAgentOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentOutputItem),
                jacksonTypeRef<AgentOutputItem>(),
            )

        assertThat(roundtrippedAgentOutputItem).isEqualTo(agentOutputItem)
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
        val agentOutputItem =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<AgentOutputItem>())

        val e = assertThrows<OpenAIInvalidDataException> { agentOutputItem.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
