// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
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
internal class AutomationServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val automationServiceAsync = client.beta().agents().automations()

        val automationFuture =
            automationServiceAsync.create(
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

        val automation = automationFuture.get()
        automation.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val automationServiceAsync = client.beta().agents().automations()

        val automationFuture = automationServiceAsync.retrieve("automation_id")

        val automation = automationFuture.get()
        automation.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val automationServiceAsync = client.beta().agents().automations()

        val automationFuture =
            automationServiceAsync.update(
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

        val automation = automationFuture.get()
        automation.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val automationServiceAsync = client.beta().agents().automations()

        val pageFuture = automationServiceAsync.list()

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val automationServiceAsync = client.beta().agents().automations()

        val automationDeletedFuture = automationServiceAsync.delete("automation_id")

        val automationDeleted = automationDeletedFuture.get()
        automationDeleted.validate()
    }

    @Test
    fun pause() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val automationServiceAsync = client.beta().agents().automations()

        val automationFuture = automationServiceAsync.pause("automation_id")

        val automation = automationFuture.get()
        automation.validate()
    }

    @Test
    fun resume() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val automationServiceAsync = client.beta().agents().automations()

        val automationFuture = automationServiceAsync.resume("automation_id")

        val automation = automationFuture.get()
        automation.validate()
    }
}
