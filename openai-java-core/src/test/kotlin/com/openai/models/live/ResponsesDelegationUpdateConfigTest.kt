// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponsesDelegationUpdateConfigTest {

    @Test
    fun create() {
        val responsesDelegationUpdateConfig =
            ResponsesDelegationUpdateConfig.builder()
                .instructions("instructions")
                .maxOutputTokens(16L)
                .model("model")
                .parallelToolCalls(true)
                .reasoning(
                    ResponsesDelegationUpdateConfig.Reasoning.builder()
                        .effort(ResponsesDelegationUpdateConfig.Reasoning.Effort.NONE)
                        .summary(ResponsesDelegationUpdateConfig.Reasoning.Summary.CONCISE)
                        .build()
                )
                .serviceTier(ResponsesDelegationUpdateConfig.ServiceTier.AUTO)
                .text(
                    ResponsesDelegationUpdateConfig.Text.builder()
                        .verbosity(ResponsesDelegationUpdateConfig.Text.Verbosity.LOW)
                        .build()
                )
                .toolChoice(ResponsesDelegationUpdateConfig.ToolChoice.LiveToolChoiceEnum.AUTO)
                .addTool(
                    FunctionTool.builder()
                        .name("name")
                        .description("description")
                        .parameters(
                            FunctionTool.Parameters.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .strict(true)
                        .build()
                )
                .build()

        assertThat(responsesDelegationUpdateConfig.instructions()).contains("instructions")
        assertThat(responsesDelegationUpdateConfig.maxOutputTokens()).contains(16L)
        assertThat(responsesDelegationUpdateConfig.model()).contains("model")
        assertThat(responsesDelegationUpdateConfig.parallelToolCalls()).contains(true)
        assertThat(responsesDelegationUpdateConfig.reasoning())
            .contains(
                ResponsesDelegationUpdateConfig.Reasoning.builder()
                    .effort(ResponsesDelegationUpdateConfig.Reasoning.Effort.NONE)
                    .summary(ResponsesDelegationUpdateConfig.Reasoning.Summary.CONCISE)
                    .build()
            )
        assertThat(responsesDelegationUpdateConfig.serviceTier())
            .contains(ResponsesDelegationUpdateConfig.ServiceTier.AUTO)
        assertThat(responsesDelegationUpdateConfig.text())
            .contains(
                ResponsesDelegationUpdateConfig.Text.builder()
                    .verbosity(ResponsesDelegationUpdateConfig.Text.Verbosity.LOW)
                    .build()
            )
        assertThat(responsesDelegationUpdateConfig.toolChoice())
            .contains(
                ResponsesDelegationUpdateConfig.ToolChoice.ofLiveToolChoiceEnum(
                    ResponsesDelegationUpdateConfig.ToolChoice.LiveToolChoiceEnum.AUTO
                )
            )
        assertThat(responsesDelegationUpdateConfig.tools().getOrNull())
            .containsExactly(
                ResponsesDelegationUpdateConfig.Tool.ofFunction(
                    FunctionTool.builder()
                        .name("name")
                        .description("description")
                        .parameters(
                            FunctionTool.Parameters.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .strict(true)
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responsesDelegationUpdateConfig =
            ResponsesDelegationUpdateConfig.builder()
                .instructions("instructions")
                .maxOutputTokens(16L)
                .model("model")
                .parallelToolCalls(true)
                .reasoning(
                    ResponsesDelegationUpdateConfig.Reasoning.builder()
                        .effort(ResponsesDelegationUpdateConfig.Reasoning.Effort.NONE)
                        .summary(ResponsesDelegationUpdateConfig.Reasoning.Summary.CONCISE)
                        .build()
                )
                .serviceTier(ResponsesDelegationUpdateConfig.ServiceTier.AUTO)
                .text(
                    ResponsesDelegationUpdateConfig.Text.builder()
                        .verbosity(ResponsesDelegationUpdateConfig.Text.Verbosity.LOW)
                        .build()
                )
                .toolChoice(ResponsesDelegationUpdateConfig.ToolChoice.LiveToolChoiceEnum.AUTO)
                .addTool(
                    FunctionTool.builder()
                        .name("name")
                        .description("description")
                        .parameters(
                            FunctionTool.Parameters.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .strict(true)
                        .build()
                )
                .build()

        val roundtrippedResponsesDelegationUpdateConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesDelegationUpdateConfig),
                jacksonTypeRef<ResponsesDelegationUpdateConfig>(),
            )

        assertThat(roundtrippedResponsesDelegationUpdateConfig)
            .isEqualTo(responsesDelegationUpdateConfig)
    }
}
