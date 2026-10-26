// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.beta.agents.HostedEnvironmentFileParam
import com.openai.models.beta.agents.HostedPluginParam
import com.openai.models.beta.agents.HostedSkillParam
import com.openai.models.beta.agents.InlineCapabilitySourceParam
import com.openai.models.beta.agents.SetupCommandParam
import com.openai.models.beta.agents.environments.EnvironmentCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class EnvironmentServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val environmentService = client.beta().agents().environments()

        val environmentInfo =
            environmentService.create(
                EnvironmentCreateParams.builder()
                    .idempotencyKey("x")
                    .environment(
                        EnvironmentCreateParams.Environment.builder()
                            .addCapabilityDirectory("string")
                            .desktop(
                                EnvironmentCreateParams.Environment.Desktop.builder()
                                    .enabled(true)
                                    .build()
                            )
                            .env(
                                EnvironmentCreateParams.Environment.Env.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .environmentTemplateId("environment_template_id")
                            .addFile(
                                HostedEnvironmentFileParam.FileId.builder()
                                    .fileId("x")
                                    .path("x")
                                    .build()
                            )
                            .network(
                                EnvironmentCreateParams.Environment.Network.builder()
                                    .access(
                                        EnvironmentCreateParams.Environment.Network.Access
                                            .RESTRICTED
                                    )
                                    .addAllowedDomain("example.com")
                                    .blockedDomains(listOf())
                                    .build()
                            )
                            .packages(
                                EnvironmentCreateParams.Environment.Packages.builder()
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
                    .addVaultId("string")
                    .build()
            )

        environmentInfo.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val environmentService = client.beta().agents().environments()

        val environmentInfo = environmentService.retrieve("environment_id")

        environmentInfo.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val environmentService = client.beta().agents().environments()

        val page = environmentService.list()

        page.response().validate()
    }
}
