// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents.environments

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.JsonValue
import com.openai.models.beta.agents.HostedEnvironmentFileParam
import com.openai.models.beta.agents.HostedPluginParam
import com.openai.models.beta.agents.HostedSkillParam
import com.openai.models.beta.agents.InlineCapabilitySourceParam
import com.openai.models.beta.agents.SetupCommandParam
import com.openai.models.beta.agents.environments.templates.TemplateCreateParams
import com.openai.models.beta.agents.environments.templates.TemplateUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class TemplateServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val templateServiceAsync = client.beta().agents().environments().templates()

        val environmentTemplateFuture =
            templateServiceAsync.create(
                TemplateCreateParams.builder()
                    .addCapabilityDirectory("string")
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

        val environmentTemplate = environmentTemplateFuture.get()
        environmentTemplate.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val templateServiceAsync = client.beta().agents().environments().templates()

        val environmentTemplateFuture = templateServiceAsync.retrieve("environment_template_id")

        val environmentTemplate = environmentTemplateFuture.get()
        environmentTemplate.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val templateServiceAsync = client.beta().agents().environments().templates()

        val environmentTemplateFuture =
            templateServiceAsync.update(
                TemplateUpdateParams.builder()
                    .environmentTemplateId("environment_template_id")
                    .addCapabilityDirectory("string")
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

        val environmentTemplate = environmentTemplateFuture.get()
        environmentTemplate.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val templateServiceAsync = client.beta().agents().environments().templates()

        val pageFuture = templateServiceAsync.list()

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
        val templateServiceAsync = client.beta().agents().environments().templates()

        val environmentTemplateDeletedFuture =
            templateServiceAsync.delete("environment_template_id")

        val environmentTemplateDeleted = environmentTemplateDeletedFuture.get()
        environmentTemplateDeleted.validate()
    }
}
