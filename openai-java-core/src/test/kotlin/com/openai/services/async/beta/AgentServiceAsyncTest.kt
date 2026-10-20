// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.findAll
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.reset
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.JsonValue
import com.openai.models.beta.agents.AgentCreateParams
import com.openai.models.beta.agents.AgentReasoningParam
import com.openai.models.beta.agents.AgentTextParam
import com.openai.models.beta.agents.AgentUpdateParams
import com.openai.models.beta.agents.MultiAgentConfigParam
import com.openai.models.beta.agents.PersistedAgentToolParam
import java.util.concurrent.atomic.AtomicInteger
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.parallel.ResourceLock

@ExtendWith(TestServerExtension::class)
@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class AgentServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val agentServiceAsync = client.beta().agents()

        val agentFuture =
            agentServiceAsync.create(
                AgentCreateParams.builder()
                    .model("model")
                    .instructions("instructions")
                    .metadata(
                        AgentCreateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .multiAgent(
                        MultiAgentConfigParam.builder()
                            .enabled(true)
                            .maxConcurrentSubagents(1L)
                            .build()
                    )
                    .name("name")
                    .reasoning(
                        AgentReasoningParam.builder()
                            .effort(AgentReasoningParam.Effort.NONE)
                            .summary(AgentReasoningParam.Summary.CONCISE)
                            .build()
                    )
                    .serviceTier(AgentCreateParams.ServiceTier.AUTO)
                    .text(
                        AgentTextParam.builder()
                            .formatText()
                            .verbosity(AgentTextParam.Verbosity.LOW)
                            .build()
                    )
                    .addTool(
                        PersistedAgentToolParam.Function.builder()
                            .description("description")
                            .name("name")
                            .parameters(
                                PersistedAgentToolParam.Function.Parameters.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .deferLoading(true)
                            .build()
                    )
                    .build()
            )

        val agent = agentFuture.get()
        agent.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val agentServiceAsync = client.beta().agents()

        val agentFuture = agentServiceAsync.retrieve("agent_id")

        val agent = agentFuture.get()
        agent.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val agentServiceAsync = client.beta().agents()

        val agentFuture =
            agentServiceAsync.update(
                AgentUpdateParams.builder()
                    .agentId("agent_id")
                    .instructions("instructions")
                    .metadata(
                        AgentUpdateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .model("model")
                    .multiAgent(
                        MultiAgentConfigParam.builder()
                            .enabled(true)
                            .maxConcurrentSubagents(1L)
                            .build()
                    )
                    .name("name")
                    .reasoning(
                        AgentReasoningParam.builder()
                            .effort(AgentReasoningParam.Effort.NONE)
                            .summary(AgentReasoningParam.Summary.CONCISE)
                            .build()
                    )
                    .serviceTier(AgentUpdateParams.ServiceTier.AUTO)
                    .text(
                        AgentTextParam.builder()
                            .formatText()
                            .verbosity(AgentTextParam.Verbosity.LOW)
                            .build()
                    )
                    .addTool(
                        PersistedAgentToolParam.Function.builder()
                            .description("description")
                            .name("name")
                            .parameters(
                                PersistedAgentToolParam.Function.Parameters.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .deferLoading(true)
                            .build()
                    )
                    .build()
            )

        val agent = agentFuture.get()
        agent.validate()
    }

    @Test
    fun listStopsOnExplicitFalse(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        try {
            // A terminal page can still contain items and a cursor
            stubFor(
                get(anyUrl())
                    .willReturn(okJson("{\"data\":[{\"id\":\"item_1\"}],\"has_more\":false}"))
            )
            val page = client.beta().agents().list().get()
            assertThat(page.items()).hasSize(1)
            assertThat(page.hasNextPage()).isFalse()

            val count = AtomicInteger()
            page.autoPager().subscribe { count.incrementAndGet() }.onCompleteFuture().get()
            assertThat(count.get()).isEqualTo(1)

            assertThat(findAll(getRequestedFor(anyUrl()))).hasSize(1)
        } finally {
            client.close()
        }
    }

    @Test
    fun listContinuesUntilExplicitFalse(wmRuntimeInfo: WireMockRuntimeInfo) {
        // Both explicit true and a missing flag preserve normal cursor traversal.
        for (firstResponse in
            listOf(
                "{\"data\":[{\"id\":\"item_1\"}],\"has_more\":true}",
                "{\"data\":[{\"id\":\"item_1\"}]}",
            )) {
            reset()
            val client =
                OpenAIOkHttpClientAsync.builder()
                    .baseUrl(wmRuntimeInfo.httpBaseUrl)
                    .apiKey("My API Key")
                    .adminApiKey("My Admin API Key")
                    .build()
            try {
                stubFor(
                    get(anyUrl())
                        .inScenario("pagination")
                        .whenScenarioStateIs("Started")
                        .willReturn(okJson(firstResponse))
                        .willSetStateTo("terminal")
                )
                stubFor(
                    get(anyUrl())
                        .inScenario("pagination")
                        .whenScenarioStateIs("terminal")
                        .willReturn(okJson("{\"data\":[{\"id\":\"item_1\"}],\"has_more\":false}"))
                        .willSetStateTo("unexpected")
                )
                // Bound a regression to one extra request instead of an infinite loop.
                stubFor(
                    get(anyUrl())
                        .inScenario("pagination")
                        .whenScenarioStateIs("unexpected")
                        .willReturn(okJson("{}"))
                )
                val page = client.beta().agents().list().get()
                assertThat(page.hasNextPage()).isTrue()

                val count = AtomicInteger()
                page.autoPager().subscribe { count.incrementAndGet() }.onCompleteFuture().get()
                assertThat(count.get()).isEqualTo(2)

                assertThat(findAll(getRequestedFor(anyUrl()))).hasSize(2)
            } finally {
                client.close()
            }
        }
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val agentServiceAsync = client.beta().agents()

        val pageFuture = agentServiceAsync.list()

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
        val agentServiceAsync = client.beta().agents()

        val agentDeletedFuture = agentServiceAsync.delete("agent_id")

        val agentDeleted = agentDeletedFuture.get()
        agentDeleted.validate()
    }
}
