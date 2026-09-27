// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.environments.templates

import com.openai.core.JsonValue
import com.openai.models.beta.agents.HostedEnvironmentFileParam
import com.openai.models.beta.agents.HostedPluginParam
import com.openai.models.beta.agents.HostedSkillParam
import com.openai.models.beta.agents.InlineCapabilitySourceParam
import com.openai.models.beta.agents.SetupCommandParam
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TemplateCreateParamsTest {

    @Test
    fun create() {
        TemplateCreateParams.builder()
            .addCapabilityDirectory("string")
            .env(
                TemplateCreateParams.Env.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
            .addFile(HostedEnvironmentFileParam.FileId.builder().fileId("x").path("x").build())
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
            .addSetupCommand(SetupCommandParam.builder().command("command").cwd("cwd").build())
            .addSkill(
                HostedSkillParam.SkillReference.builder().skillId("x").version("version").build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            TemplateCreateParams.builder()
                .addCapabilityDirectory("string")
                .env(
                    TemplateCreateParams.Env.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .addFile(HostedEnvironmentFileParam.FileId.builder().fileId("x").path("x").build())
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
                .addSetupCommand(SetupCommandParam.builder().command("command").cwd("cwd").build())
                .addSkill(
                    HostedSkillParam.SkillReference.builder()
                        .skillId("x")
                        .version("version")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.capabilityDirectories().getOrNull()).containsExactly("string")
        assertThat(body.env())
            .contains(
                TemplateCreateParams.Env.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(body.files().getOrNull())
            .containsExactly(
                HostedEnvironmentFileParam.ofFileId(
                    HostedEnvironmentFileParam.FileId.builder().fileId("x").path("x").build()
                )
            )
        assertThat(body.name()).contains("x")
        assertThat(body.network())
            .contains(
                TemplateCreateParams.Network.builder()
                    .access(TemplateCreateParams.Network.Access.ENABLED)
                    .addAllowedDomain("string")
                    .build()
            )
        assertThat(body.packages())
            .contains(
                TemplateCreateParams.Packages.builder()
                    .addNpm("string")
                    .addPython("string")
                    .addSystem("string")
                    .build()
            )
        assertThat(body.plugins().getOrNull())
            .containsExactly(
                HostedPluginParam.builder()
                    .description("description")
                    .name("x")
                    .source(InlineCapabilitySourceParam.builder().data("x").build())
                    .build()
            )
        assertThat(body.setupCommands().getOrNull())
            .containsExactly(SetupCommandParam.builder().command("command").cwd("cwd").build())
        assertThat(body.skills().getOrNull())
            .containsExactly(
                HostedSkillParam.ofSkillReference(
                    HostedSkillParam.SkillReference.builder()
                        .skillId("x")
                        .version("version")
                        .build()
                )
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = TemplateCreateParams.builder().build()

        val body = params._body()
    }
}
