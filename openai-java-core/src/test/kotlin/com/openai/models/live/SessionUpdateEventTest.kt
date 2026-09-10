// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionUpdateEventTest {

    @Test
    fun create() {
        val sessionUpdateEvent =
            SessionUpdateEvent.builder()
                .session(
                    SessionUpdateConfig.builder()
                        .delegation(
                            SessionUpdateConfig.Delegation.Responses.builder()
                                .responses(
                                    ResponsesDelegationUpdateConfig.builder()
                                        .instructions(
                                            "Check restaurant availability. Ask before confirming a booking."
                                        )
                                        .maxOutputTokens(1024L)
                                        .model("model")
                                        .parallelToolCalls(true)
                                        .reasoning(
                                            ResponsesDelegationUpdateConfig.Reasoning.builder()
                                                .effort(
                                                    ResponsesDelegationUpdateConfig.Reasoning.Effort
                                                        .NONE
                                                )
                                                .summary(
                                                    ResponsesDelegationUpdateConfig.Reasoning
                                                        .Summary
                                                        .CONCISE
                                                )
                                                .build()
                                        )
                                        .serviceTier(
                                            ResponsesDelegationUpdateConfig.ServiceTier.AUTO
                                        )
                                        .text(
                                            ResponsesDelegationUpdateConfig.Text.builder()
                                                .verbosity(
                                                    ResponsesDelegationUpdateConfig.Text.Verbosity
                                                        .LOW
                                                )
                                                .build()
                                        )
                                        .toolChoice(
                                            ResponsesDelegationUpdateConfig.ToolChoice
                                                .LiveToolChoiceEnum
                                                .AUTO
                                        )
                                        .addTool(
                                            FunctionTool.builder()
                                                .name("name")
                                                .description("description")
                                                .parameters(
                                                    FunctionTool.Parameters.builder()
                                                        .putAdditionalProperty(
                                                            "foo",
                                                            JsonValue.from("bar"),
                                                        )
                                                        .build()
                                                )
                                                .strict(true)
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .eventId("evt_update_001")
                .build()

        assertThat(sessionUpdateEvent.session())
            .isEqualTo(
                SessionUpdateConfig.builder()
                    .delegation(
                        SessionUpdateConfig.Delegation.Responses.builder()
                            .responses(
                                ResponsesDelegationUpdateConfig.builder()
                                    .instructions(
                                        "Check restaurant availability. Ask before confirming a booking."
                                    )
                                    .maxOutputTokens(1024L)
                                    .model("model")
                                    .parallelToolCalls(true)
                                    .reasoning(
                                        ResponsesDelegationUpdateConfig.Reasoning.builder()
                                            .effort(
                                                ResponsesDelegationUpdateConfig.Reasoning.Effort
                                                    .NONE
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
                                        ResponsesDelegationUpdateConfig.ToolChoice
                                            .LiveToolChoiceEnum
                                            .AUTO
                                    )
                                    .addTool(
                                        FunctionTool.builder()
                                            .name("name")
                                            .description("description")
                                            .parameters(
                                                FunctionTool.Parameters.builder()
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from("bar"),
                                                    )
                                                    .build()
                                            )
                                            .strict(true)
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
        assertThat(sessionUpdateEvent.eventId()).contains("evt_update_001")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val sessionUpdateEvent =
            SessionUpdateEvent.builder()
                .session(
                    SessionUpdateConfig.builder()
                        .delegation(
                            SessionUpdateConfig.Delegation.Responses.builder()
                                .responses(
                                    ResponsesDelegationUpdateConfig.builder()
                                        .instructions(
                                            "Check restaurant availability. Ask before confirming a booking."
                                        )
                                        .maxOutputTokens(1024L)
                                        .model("model")
                                        .parallelToolCalls(true)
                                        .reasoning(
                                            ResponsesDelegationUpdateConfig.Reasoning.builder()
                                                .effort(
                                                    ResponsesDelegationUpdateConfig.Reasoning.Effort
                                                        .NONE
                                                )
                                                .summary(
                                                    ResponsesDelegationUpdateConfig.Reasoning
                                                        .Summary
                                                        .CONCISE
                                                )
                                                .build()
                                        )
                                        .serviceTier(
                                            ResponsesDelegationUpdateConfig.ServiceTier.AUTO
                                        )
                                        .text(
                                            ResponsesDelegationUpdateConfig.Text.builder()
                                                .verbosity(
                                                    ResponsesDelegationUpdateConfig.Text.Verbosity
                                                        .LOW
                                                )
                                                .build()
                                        )
                                        .toolChoice(
                                            ResponsesDelegationUpdateConfig.ToolChoice
                                                .LiveToolChoiceEnum
                                                .AUTO
                                        )
                                        .addTool(
                                            FunctionTool.builder()
                                                .name("name")
                                                .description("description")
                                                .parameters(
                                                    FunctionTool.Parameters.builder()
                                                        .putAdditionalProperty(
                                                            "foo",
                                                            JsonValue.from("bar"),
                                                        )
                                                        .build()
                                                )
                                                .strict(true)
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .eventId("evt_update_001")
                .build()

        val roundtrippedSessionUpdateEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sessionUpdateEvent),
                jacksonTypeRef<SessionUpdateEvent>(),
            )

        assertThat(roundtrippedSessionUpdateEvent).isEqualTo(sessionUpdateEvent)
    }
}
