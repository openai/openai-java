package com.openai.models.beta.agents.environments

import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.beta.agents.HostedEnvironmentFileParam
import com.openai.models.beta.agents.HostedPluginParam
import com.openai.models.beta.agents.HostedSkillParam
import com.openai.models.beta.agents.InlineCapabilitySourceParam
import com.openai.models.beta.agents.SetupCommandParam
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EnvironmentCreateDiagnosticsTest {
    @Test
    fun hidesConfidentialConfigurationWithoutChangingTheRequest() {
        val environment =
            EnvironmentCreateParams.Environment.builder()
                .env(
                    EnvironmentCreateParams.Environment.Env.builder()
                        .putAdditionalProperty(
                            "SYNTHETIC_TOKEN",
                            JsonValue.from("synthetic-private-value"),
                        )
                        .build()
                )
                .addSetupCommand(
                    SetupCommandParam.builder().command("echo synthetic-private-command").build()
                )
                .addFile(
                    HostedEnvironmentFileParam.Inline.builder()
                        .path("/workspace/example")
                        .data("ZmlsZQ==")
                        .build()
                )
                .addPlugin(
                    HostedPluginParam.builder()
                        .name("example")
                        .description("synthetic description")
                        .source(InlineCapabilitySourceParam.builder().data("cGx1Z2lu").build())
                        .build()
                )
                .addSkill(
                    HostedSkillParam.Inline.builder()
                        .name("example")
                        .description("synthetic description")
                        .source(InlineCapabilitySourceParam.builder().data("c2tpbGw=").build())
                        .build()
                )
                .putAdditionalProperty("future_config", JsonValue.from("synthetic-future-secret"))
                .build()
        val params = EnvironmentCreateParams.builder().environment(environment).build()
        assertThat(params.toString())
            .doesNotContain(
                "synthetic-private-value",
                "synthetic-private-command",
                "ZmlsZQ==",
                "cGx1Z2lu",
                "c2tpbGw=",
                "synthetic-future-secret",
            )
        assertThat(environment.toString())
            .doesNotContain(
                "synthetic-private-value",
                "synthetic-private-command",
                "ZmlsZQ==",
                "cGx1Z2lu",
                "c2tpbGw=",
                "synthetic-future-secret",
            )
        val wire = jsonMapper().readTree(jsonMapper().writeValueAsString(params._body()))
        assertThat(wire["environment"]["files"][0]["data"].asText()).isEqualTo("ZmlsZQ==")
        assertThat(wire["environment"]["plugins"][0]["source"]["data"].asText())
            .isEqualTo("cGx1Z2lu")
        assertThat(wire["environment"]["skills"][0]["source"]["data"].asText())
            .isEqualTo("c2tpbGw=")
        assertThat(wire["environment"]["future_config"].asText())
            .isEqualTo("synthetic-future-secret")
        assertThat(wire["environment"]["env"]["SYNTHETIC_TOKEN"].asText())
            .isEqualTo("synthetic-private-value")
        assertThat(wire["environment"]["setup_commands"][0]["command"].asText())
            .isEqualTo("echo synthetic-private-command")
    }
}
