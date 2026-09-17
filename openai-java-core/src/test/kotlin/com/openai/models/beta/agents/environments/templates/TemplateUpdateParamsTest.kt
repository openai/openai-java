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

internal class TemplateUpdateParamsTest {

    @Test
    fun create() {
        TemplateUpdateParams.builder()
            .environmentTemplateId("environment_template_id")
            .addCapabilityDirectory("string")
            .env(
                TemplateUpdateParams.Env.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
            .addFile(HostedEnvironmentFileParam.FileId.builder().fileId("x").path("x").build())
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
            .addSetupCommand(SetupCommandParam.builder().command("command").cwd("cwd").build())
            .addSkill(
                HostedSkillParam.SkillReference.builder().skillId("x").version("version").build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            TemplateUpdateParams.builder().environmentTemplateId("environment_template_id").build()

        assertThat(params._pathParam(0)).isEqualTo("environment_template_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            TemplateUpdateParams.builder()
                .environmentTemplateId("environment_template_id")
                .addCapabilityDirectory("string")
                .env(
                    TemplateUpdateParams.Env.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .addFile(HostedEnvironmentFileParam.FileId.builder().fileId("x").path("x").build())
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
                TemplateUpdateParams.Env.builder()
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
                TemplateUpdateParams.Network.builder()
                    .access(TemplateUpdateParams.Network.Access.ENABLED)
                    .addAllowedDomain("string")
                    .build()
            )
        assertThat(body.packages())
            .contains(
                TemplateUpdateParams.Packages.builder()
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
        val params =
            TemplateUpdateParams.builder().environmentTemplateId("environment_template_id").build()

        val body = params._body()
    }
}
