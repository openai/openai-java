// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.environments

import com.openai.core.JsonValue
import com.openai.core.http.Headers
import com.openai.models.beta.agents.HostedEnvironmentFileParam
import com.openai.models.beta.agents.HostedPluginParam
import com.openai.models.beta.agents.HostedSkillParam
import com.openai.models.beta.agents.InlineCapabilitySourceParam
import com.openai.models.beta.agents.SetupCommandParam
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EnvironmentCreateParamsTest {

    @Test
    fun create() {
        EnvironmentCreateParams.builder()
            .idempotencyKey("x")
            .environment(
                EnvironmentCreateParams.Environment.builder()
                    .addCapabilityDirectory("string")
                    .desktop(
                        EnvironmentCreateParams.Environment.Desktop.builder().enabled(true).build()
                    )
                    .env(
                        EnvironmentCreateParams.Environment.Env.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .environmentTemplateId("environment_template_id")
                    .addFile(
                        HostedEnvironmentFileParam.FileId.builder().fileId("x").path("x").build()
                    )
                    .network(
                        EnvironmentCreateParams.Environment.Network.builder()
                            .access(EnvironmentCreateParams.Environment.Network.Access.ENABLED)
                            .addAllowedDomain("string")
                            .addBlockedDomain("string")
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
    }

    @Test
    fun headers() {
        val params =
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
                                .access(EnvironmentCreateParams.Environment.Network.Access.ENABLED)
                                .addAllowedDomain("string")
                                .addBlockedDomain("string")
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

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().put("Idempotency-Key", "x").build())
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params =
            EnvironmentCreateParams.builder()
                .environment(EnvironmentCreateParams.Environment.builder().build())
                .build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
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
                                .access(EnvironmentCreateParams.Environment.Network.Access.ENABLED)
                                .addAllowedDomain("string")
                                .addBlockedDomain("string")
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

        val body = params._body()

        assertThat(body.environment())
            .isEqualTo(
                EnvironmentCreateParams.Environment.builder()
                    .addCapabilityDirectory("string")
                    .desktop(
                        EnvironmentCreateParams.Environment.Desktop.builder().enabled(true).build()
                    )
                    .env(
                        EnvironmentCreateParams.Environment.Env.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .environmentTemplateId("environment_template_id")
                    .addFile(
                        HostedEnvironmentFileParam.FileId.builder().fileId("x").path("x").build()
                    )
                    .network(
                        EnvironmentCreateParams.Environment.Network.builder()
                            .access(EnvironmentCreateParams.Environment.Network.Access.ENABLED)
                            .addAllowedDomain("string")
                            .addBlockedDomain("string")
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
        assertThat(body.vaultIds().getOrNull()).containsExactly("string")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            EnvironmentCreateParams.builder()
                .environment(EnvironmentCreateParams.Environment.builder().build())
                .build()

        val body = params._body()

        assertThat(body.environment())
            .isEqualTo(EnvironmentCreateParams.Environment.builder().build())
    }
}
