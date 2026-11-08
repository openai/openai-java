// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.beta.agents.AgentReasoningParam
import com.openai.models.beta.agents.AgentSessionInputMessageParam
import com.openai.models.beta.agents.AgentTextParam
import com.openai.models.beta.agents.AgentToolParam
import com.openai.models.beta.agents.MultiAgentConfigParam
import com.openai.models.beta.agents.automations.AutomationScheduleParam
import com.openai.models.beta.agents.automations.AutomationTargetParam
import com.openai.models.beta.agents.automations.AutomationUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class AutomationServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val automationService = client.beta().agents().automations()

        val automation =
            automationService.create(
                AutomationScheduleParam.ofPeriodic(
                    AutomationScheduleParam.Periodic.builder()
                        .expression("x")
                        .name("x")
                        .target(
                            AutomationTargetParam.NewSession.builder()
                                .environmentNone()
                                .addInput(
                                    AgentSessionInputMessageParam.builder()
                                        .addInputTextContent("text")
                                        .type(AgentSessionInputMessageParam.Type.MESSAGE)
                                        .build()
                                )
                                .agent(
                                    AutomationTargetParam.NewSession.Agent.builder()
                                        .compaction(
                                            AutomationTargetParam.NewSession.Agent.Compaction
                                                .builder()
                                                .async(true)
                                                .build()
                                        )
                                        .experimental(
                                            AutomationTargetParam.NewSession.Agent.Experimental
                                                .builder()
                                                .timeAwareness(true)
                                                .build()
                                        )
                                        .instructions("instructions")
                                        .model("model")
                                        .multiAgent(
                                            MultiAgentConfigParam.builder()
                                                .enabled(true)
                                                .maxConcurrentSubagents(1L)
                                                .build()
                                        )
                                        .reasoning(
                                            AgentReasoningParam.builder()
                                                .effort(AgentReasoningParam.Effort.NONE)
                                                .summary(AgentReasoningParam.Summary.CONCISE)
                                                .build()
                                        )
                                        .serviceTier(
                                            AutomationTargetParam.NewSession.Agent.ServiceTier.AUTO
                                        )
                                        .text(
                                            AgentTextParam.builder()
                                                .formatText()
                                                .verbosity(AgentTextParam.Verbosity.LOW)
                                                .build()
                                        )
                                        .addTool(
                                            AgentToolParam.Function.builder()
                                                .description("description")
                                                .name("name")
                                                .parameters(
                                                    AgentToolParam.Function.Parameters.builder()
                                                        .putAdditionalProperty(
                                                            "foo",
                                                            JsonValue.from("bar"),
                                                        )
                                                        .build()
                                                )
                                                .deferLoading(true)
                                                .build()
                                        )
                                        .build()
                                )
                                .agentId("agent_id")
                                .metadata(
                                    AutomationTargetParam.NewSession.Metadata.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("string"))
                                        .build()
                                )
                                .addVaultId("string")
                                .build()
                        )
                        .timezone("x")
                        .metadata(
                            AutomationScheduleParam.Periodic.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .build()
                )
            )

        automation.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val automationService = client.beta().agents().automations()

        val automation = automationService.retrieve("automation_id")

        automation.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val automationService = client.beta().agents().automations()

        val automation =
            automationService.update(
                AutomationUpdateParams.builder()
                    .automationId("automation_id")
                    .expression("x")
                    .metadata(
                        AutomationUpdateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .name("x")
                    .runAt(0L)
                    .target(
                        AutomationTargetParam.NewSession.builder()
                            .environmentNone()
                            .addInput(
                                AgentSessionInputMessageParam.builder()
                                    .addInputTextContent("text")
                                    .type(AgentSessionInputMessageParam.Type.MESSAGE)
                                    .build()
                            )
                            .agent(
                                AutomationTargetParam.NewSession.Agent.builder()
                                    .compaction(
                                        AutomationTargetParam.NewSession.Agent.Compaction.builder()
                                            .async(true)
                                            .build()
                                    )
                                    .experimental(
                                        AutomationTargetParam.NewSession.Agent.Experimental
                                            .builder()
                                            .timeAwareness(true)
                                            .build()
                                    )
                                    .instructions("instructions")
                                    .model("model")
                                    .multiAgent(
                                        MultiAgentConfigParam.builder()
                                            .enabled(true)
                                            .maxConcurrentSubagents(1L)
                                            .build()
                                    )
                                    .reasoning(
                                        AgentReasoningParam.builder()
                                            .effort(AgentReasoningParam.Effort.NONE)
                                            .summary(AgentReasoningParam.Summary.CONCISE)
                                            .build()
                                    )
                                    .serviceTier(
                                        AutomationTargetParam.NewSession.Agent.ServiceTier.AUTO
                                    )
                                    .text(
                                        AgentTextParam.builder()
                                            .formatText()
                                            .verbosity(AgentTextParam.Verbosity.LOW)
                                            .build()
                                    )
                                    .addTool(
                                        AgentToolParam.Function.builder()
                                            .description("description")
                                            .name("name")
                                            .parameters(
                                                AgentToolParam.Function.Parameters.builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from("bar"),
                                                    )
                                                    .build()
                                            )
                                            .deferLoading(true)
                                            .build()
                                    )
                                    .build()
                            )
                            .agentId("agent_id")
                            .metadata(
                                AutomationTargetParam.NewSession.Metadata.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .addVaultId("string")
                            .build()
                    )
                    .timezone("x")
                    .build()
            )

        automation.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val automationService = client.beta().agents().automations()

        val page = automationService.list()

        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val automationService = client.beta().agents().automations()

        val automationDeleted = automationService.delete("automation_id")

        automationDeleted.validate()
    }

    @Test
    fun pause() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val automationService = client.beta().agents().automations()

        val automation = automationService.pause("automation_id")

        automation.validate()
    }

    @Test
    fun resume() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val automationService = client.beta().agents().automations()

        val automation = automationService.resume("automation_id")

        automation.validate()
    }
}
