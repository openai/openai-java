// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents.environments

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
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.beta.agents.HostedEnvironmentFileParam
import com.openai.models.beta.agents.HostedPluginParam
import com.openai.models.beta.agents.HostedSkillParam
import com.openai.models.beta.agents.InlineCapabilitySourceParam
import com.openai.models.beta.agents.SetupCommandParam
import com.openai.models.beta.agents.environments.templates.TemplateCreateParams
import com.openai.models.beta.agents.environments.templates.TemplateUpdateParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.parallel.ResourceLock

@ExtendWith(TestServerExtension::class)
@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class TemplateServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val templateService = client.beta().agents().environments().templates()

        val environmentTemplate =
            templateService.create(
                TemplateCreateParams.builder()
                    .addCapabilityDirectory("string")
                    .desktop(TemplateCreateParams.Desktop.builder().enabled(true).build())
                    .env(
                        TemplateCreateParams.Env.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .addFile(
                        HostedEnvironmentFileParam.FileId.builder().fileId("x").path("x").build()
                    )
                    .name("x")
                    .network(
                        TemplateCreateParams.Network.builder()
                            .access(TemplateCreateParams.Network.Access.ENABLED)
                            .addAllowedDomain("string")
                            .addBlockedDomain("string")
                            .build()
                    )
                    .packages(
                        TemplateCreateParams.Packages.builder()
                            .addNpm("string")
                            .addPython("string")
                            .addSystem("string")
                            .build()
                    )
                    .addPlugin(
                        HostedPluginParam.builder()
                            .description("description")
                            .name("x")
                            .source(InlineCapabilitySourceParam.builder().data("x").build())
                            .build()
                    )
                    .addSetupCommand(
                        SetupCommandParam.builder().command("command").cwd("cwd").build()
                    )
                    .addSkill(
                        HostedSkillParam.SkillReference.builder()
                            .skillId("x")
                            .version("version")
                            .build()
                    )
                    .build()
            )

        environmentTemplate.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val templateService = client.beta().agents().environments().templates()

        val environmentTemplate = templateService.retrieve("environment_template_id")

        environmentTemplate.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val templateService = client.beta().agents().environments().templates()

        val environmentTemplate =
            templateService.update(
                TemplateUpdateParams.builder()
                    .environmentTemplateId("environment_template_id")
                    .addCapabilityDirectory("string")
                    .desktop(TemplateUpdateParams.Desktop.builder().enabled(true).build())
                    .env(
                        TemplateUpdateParams.Env.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .addFile(
                        HostedEnvironmentFileParam.FileId.builder().fileId("x").path("x").build()
                    )
                    .name("x")
                    .network(
                        TemplateUpdateParams.Network.builder()
                            .access(TemplateUpdateParams.Network.Access.ENABLED)
                            .addAllowedDomain("string")
                            .addBlockedDomain("string")
                            .build()
                    )
                    .packages(
                        TemplateUpdateParams.Packages.builder()
                            .addNpm("string")
                            .addPython("string")
                            .addSystem("string")
                            .build()
                    )
                    .addPlugin(
                        HostedPluginParam.builder()
                            .description("description")
                            .name("x")
                            .source(InlineCapabilitySourceParam.builder().data("x").build())
                            .build()
                    )
                    .addSetupCommand(
                        SetupCommandParam.builder().command("command").cwd("cwd").build()
                    )
                    .addSkill(
                        HostedSkillParam.SkillReference.builder()
                            .skillId("x")
                            .version("version")
                            .build()
                    )
                    .build()
            )

        environmentTemplate.validate()
    }

    @Test
    fun listStopsOnExplicitFalse(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            OpenAIOkHttpClient.builder()
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
            val page = client.beta().agents().environments().templates().list()
            assertThat(page.items()).hasSize(1)
            assertThat(page.hasNextPage()).isFalse()

            assertThat(page.autoPager().toList()).hasSize(1)

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
                OpenAIOkHttpClient.builder()
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
                val page = client.beta().agents().environments().templates().list()
                assertThat(page.hasNextPage()).isTrue()

                assertThat(page.autoPager().toList()).hasSize(2)

                assertThat(findAll(getRequestedFor(anyUrl()))).hasSize(2)
            } finally {
                client.close()
            }
        }
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val templateService = client.beta().agents().environments().templates()

        val page = templateService.list()

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
        val templateService = client.beta().agents().environments().templates()

        val environmentTemplateDeleted = templateService.delete("environment_template_id")

        environmentTemplateDeleted.validate()
    }
}
