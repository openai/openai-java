// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponsesDelegationConfigTest {

    @Test
    fun create() {
        val responsesDelegationConfig =
            ResponsesDelegationConfig.builder()
                .model("model")
                .instructions("instructions")
                .maxOutputTokens(16L)
                .parallelToolCalls(true)
                .reasoning(
                    ResponsesDelegationConfig.Reasoning.builder()
                        .effort(ResponsesDelegationConfig.Reasoning.Effort.NONE)
                        .summary(ResponsesDelegationConfig.Reasoning.Summary.CONCISE)
                        .build()
                )
                .serviceTier(ResponsesDelegationConfig.ServiceTier.AUTO)
                .text(
                    ResponsesDelegationConfig.Text.builder()
                        .verbosity(ResponsesDelegationConfig.Text.Verbosity.LOW)
                        .build()
                )
                .toolChoice(ResponsesDelegationConfig.ToolChoice.LiveToolChoiceEnum.AUTO)
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

        assertThat(responsesDelegationConfig.model()).isEqualTo("model")
        assertThat(responsesDelegationConfig.instructions()).contains("instructions")
        assertThat(responsesDelegationConfig.maxOutputTokens()).contains(16L)
        assertThat(responsesDelegationConfig.parallelToolCalls()).contains(true)
        assertThat(responsesDelegationConfig.reasoning())
            .contains(
                ResponsesDelegationConfig.Reasoning.builder()
                    .effort(ResponsesDelegationConfig.Reasoning.Effort.NONE)
                    .summary(ResponsesDelegationConfig.Reasoning.Summary.CONCISE)
                    .build()
            )
        assertThat(responsesDelegationConfig.serviceTier())
            .contains(ResponsesDelegationConfig.ServiceTier.AUTO)
        assertThat(responsesDelegationConfig.text())
            .contains(
                ResponsesDelegationConfig.Text.builder()
                    .verbosity(ResponsesDelegationConfig.Text.Verbosity.LOW)
                    .build()
            )
        assertThat(responsesDelegationConfig.toolChoice())
            .contains(
                ResponsesDelegationConfig.ToolChoice.ofLiveToolChoiceEnum(
                    ResponsesDelegationConfig.ToolChoice.LiveToolChoiceEnum.AUTO
                )
            )
        assertThat(responsesDelegationConfig.tools().getOrNull())
            .containsExactly(
                ResponsesDelegationConfig.Tool.ofFunction(
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
        val responsesDelegationConfig =
            ResponsesDelegationConfig.builder()
                .model("model")
                .instructions("instructions")
                .maxOutputTokens(16L)
                .parallelToolCalls(true)
                .reasoning(
                    ResponsesDelegationConfig.Reasoning.builder()
                        .effort(ResponsesDelegationConfig.Reasoning.Effort.NONE)
                        .summary(ResponsesDelegationConfig.Reasoning.Summary.CONCISE)
                        .build()
                )
                .serviceTier(ResponsesDelegationConfig.ServiceTier.AUTO)
                .text(
                    ResponsesDelegationConfig.Text.builder()
                        .verbosity(ResponsesDelegationConfig.Text.Verbosity.LOW)
                        .build()
                )
                .toolChoice(ResponsesDelegationConfig.ToolChoice.LiveToolChoiceEnum.AUTO)
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

        val roundtrippedResponsesDelegationConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesDelegationConfig),
                jacksonTypeRef<ResponsesDelegationConfig>(),
            )

        assertThat(roundtrippedResponsesDelegationConfig).isEqualTo(responsesDelegationConfig)
    }
}
