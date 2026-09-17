// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MediaSessionForkConfigTest {

    @Test
    fun create() {
        val mediaSessionForkConfig =
            MediaSessionForkConfig.builder()
                .client(
                    ClientConfig.builder()
                        .dataChannel(
                            DataChannelConfig.builder()
                                .allowedClientEventsOfStrings(listOf("string"))
                                .allowedServerEventsAll()
                                .build()
                        )
                        .build()
                )
                .delegation(
                    MediaSessionForkConfig.Delegation.builder()
                        .responses(
                            ResponsesDelegationUpdateConfig.builder()
                                .instructions("instructions")
                                .maxOutputTokens(16L)
                                .model("model")
                                .parallelToolCalls(true)
                                .reasoning(
                                    ResponsesDelegationUpdateConfig.Reasoning.builder()
                                        .effort(
                                            ResponsesDelegationUpdateConfig.Reasoning.Effort.NONE
                                        )
                                        .summary(
                                            ResponsesDelegationUpdateConfig.Reasoning.Summary
                                                .CONCISE
                                        )
                                        .build()
                                )
                                .serviceTier(ResponsesDelegationUpdateConfig.ServiceTier.AUTO)
                                .text(
                                    ResponsesDelegationUpdateConfig.Text.builder()
                                        .verbosity(
                                            ResponsesDelegationUpdateConfig.Text.Verbosity.LOW
                                        )
                                        .build()
                                )
                                .toolChoice(
                                    ResponsesDelegationUpdateConfig.ToolChoice.LiveToolChoiceEnum
                                        .AUTO
                                )
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
                        )
                        .build()
                )
                .store(true)
                .build()

        assertThat(mediaSessionForkConfig.client())
            .contains(
                ClientConfig.builder()
                    .dataChannel(
                        DataChannelConfig.builder()
                            .allowedClientEventsOfStrings(listOf("string"))
                            .allowedServerEventsAll()
                            .build()
                    )
                    .build()
            )
        assertThat(mediaSessionForkConfig.delegation())
            .contains(
                MediaSessionForkConfig.Delegation.builder()
                    .responses(
                        ResponsesDelegationUpdateConfig.builder()
                            .instructions("instructions")
                            .maxOutputTokens(16L)
                            .model("model")
                            .parallelToolCalls(true)
                            .reasoning(
                                ResponsesDelegationUpdateConfig.Reasoning.builder()
                                    .effort(ResponsesDelegationUpdateConfig.Reasoning.Effort.NONE)
                                    .summary(
                                        ResponsesDelegationUpdateConfig.Reasoning.Summary.CONCISE
                                    )
                                    .build()
                            )
                            .serviceTier(ResponsesDelegationUpdateConfig.ServiceTier.AUTO)
                            .text(
                                ResponsesDelegationUpdateConfig.Text.builder()
                                    .verbosity(ResponsesDelegationUpdateConfig.Text.Verbosity.LOW)
                                    .build()
                            )
                            .toolChoice(
                                ResponsesDelegationUpdateConfig.ToolChoice.LiveToolChoiceEnum.AUTO
                            )
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
                    )
                    .build()
            )
        assertThat(mediaSessionForkConfig.store()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val mediaSessionForkConfig =
            MediaSessionForkConfig.builder()
                .client(
                    ClientConfig.builder()
                        .dataChannel(
                            DataChannelConfig.builder()
                                .allowedClientEventsOfStrings(listOf("string"))
                                .allowedServerEventsAll()
                                .build()
                        )
                        .build()
                )
                .delegation(
                    MediaSessionForkConfig.Delegation.builder()
                        .responses(
                            ResponsesDelegationUpdateConfig.builder()
                                .instructions("instructions")
                                .maxOutputTokens(16L)
                                .model("model")
                                .parallelToolCalls(true)
                                .reasoning(
                                    ResponsesDelegationUpdateConfig.Reasoning.builder()
                                        .effort(
                                            ResponsesDelegationUpdateConfig.Reasoning.Effort.NONE
                                        )
                                        .summary(
                                            ResponsesDelegationUpdateConfig.Reasoning.Summary
                                                .CONCISE
                                        )
                                        .build()
                                )
                                .serviceTier(ResponsesDelegationUpdateConfig.ServiceTier.AUTO)
                                .text(
                                    ResponsesDelegationUpdateConfig.Text.builder()
                                        .verbosity(
                                            ResponsesDelegationUpdateConfig.Text.Verbosity.LOW
                                        )
                                        .build()
                                )
                                .toolChoice(
                                    ResponsesDelegationUpdateConfig.ToolChoice.LiveToolChoiceEnum
                                        .AUTO
                                )
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
                        )
                        .build()
                )
                .store(true)
                .build()

        val roundtrippedMediaSessionForkConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mediaSessionForkConfig),
                jacksonTypeRef<MediaSessionForkConfig>(),
            )

        assertThat(roundtrippedMediaSessionForkConfig).isEqualTo(mediaSessionForkConfig)
    }
}
