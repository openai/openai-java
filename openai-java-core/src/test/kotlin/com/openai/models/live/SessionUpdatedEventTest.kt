// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionUpdatedEventTest {

    @Test
    fun create() {
        val sessionUpdatedEvent =
            SessionUpdatedEvent.builder()
                .eventId("evt_updated_001")
                .session(
                    SessionResource.builder()
                        .id("live_def456")
                        .expiresAt(1788555600L)
                        .model(SessionResource.Model.GPT_LIVE_1)
                        .audio(
                            SessionResource.Audio.builder()
                                .audioPcmFormat(AudioFormat.AudioPcm.Rate._24000)
                                .output(
                                    SessionResource.Audio.Output.builder().voice("marin").build()
                                )
                                .build()
                        )
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
                        .responsesDelegation(
                            ResponsesDelegationConfig.builder()
                                .model("gpt-6-astra")
                                .instructions(
                                    "Check restaurant availability. Ask before confirming a booking."
                                )
                                .maxOutputTokens(1024L)
                                .parallelToolCalls(true)
                                .reasoning(
                                    ResponsesDelegationConfig.Reasoning.builder()
                                        .effort(ResponsesDelegationConfig.Reasoning.Effort.NONE)
                                        .summary(
                                            ResponsesDelegationConfig.Reasoning.Summary.CONCISE
                                        )
                                        .build()
                                )
                                .serviceTier(ResponsesDelegationConfig.ServiceTier.AUTO)
                                .text(
                                    ResponsesDelegationConfig.Text.builder()
                                        .verbosity(ResponsesDelegationConfig.Text.Verbosity.LOW)
                                        .build()
                                )
                                .toolChoice(
                                    ResponsesDelegationConfig.ToolChoice.LiveToolChoiceEnum.AUTO
                                )
                                .tools(listOf())
                                .build()
                        )
                        .input(listOf())
                        .instructions(
                            "Help the caller plan a restaurant reservation. Confirm details before booking."
                        )
                        .store(true)
                        .build()
                )
                .clientEventId("evt_update_001")
                .build()

        assertThat(sessionUpdatedEvent.eventId()).isEqualTo("evt_updated_001")
        assertThat(sessionUpdatedEvent.session())
            .isEqualTo(
                SessionResource.builder()
                    .id("live_def456")
                    .expiresAt(1788555600L)
                    .model(SessionResource.Model.GPT_LIVE_1)
                    .audio(
                        SessionResource.Audio.builder()
                            .audioPcmFormat(AudioFormat.AudioPcm.Rate._24000)
                            .output(SessionResource.Audio.Output.builder().voice("marin").build())
                            .build()
                    )
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
                    .responsesDelegation(
                        ResponsesDelegationConfig.builder()
                            .model("gpt-6-astra")
                            .instructions(
                                "Check restaurant availability. Ask before confirming a booking."
                            )
                            .maxOutputTokens(1024L)
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
                            .toolChoice(
                                ResponsesDelegationConfig.ToolChoice.LiveToolChoiceEnum.AUTO
                            )
                            .tools(listOf())
                            .build()
                    )
                    .input(listOf())
                    .instructions(
                        "Help the caller plan a restaurant reservation. Confirm details before booking."
                    )
                    .store(true)
                    .build()
            )
        assertThat(sessionUpdatedEvent.clientEventId()).contains("evt_update_001")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val sessionUpdatedEvent =
            SessionUpdatedEvent.builder()
                .eventId("evt_updated_001")
                .session(
                    SessionResource.builder()
                        .id("live_def456")
                        .expiresAt(1788555600L)
                        .model(SessionResource.Model.GPT_LIVE_1)
                        .audio(
                            SessionResource.Audio.builder()
                                .audioPcmFormat(AudioFormat.AudioPcm.Rate._24000)
                                .output(
                                    SessionResource.Audio.Output.builder().voice("marin").build()
                                )
                                .build()
                        )
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
                        .responsesDelegation(
                            ResponsesDelegationConfig.builder()
                                .model("gpt-6-astra")
                                .instructions(
                                    "Check restaurant availability. Ask before confirming a booking."
                                )
                                .maxOutputTokens(1024L)
                                .parallelToolCalls(true)
                                .reasoning(
                                    ResponsesDelegationConfig.Reasoning.builder()
                                        .effort(ResponsesDelegationConfig.Reasoning.Effort.NONE)
                                        .summary(
                                            ResponsesDelegationConfig.Reasoning.Summary.CONCISE
                                        )
                                        .build()
                                )
                                .serviceTier(ResponsesDelegationConfig.ServiceTier.AUTO)
                                .text(
                                    ResponsesDelegationConfig.Text.builder()
                                        .verbosity(ResponsesDelegationConfig.Text.Verbosity.LOW)
                                        .build()
                                )
                                .toolChoice(
                                    ResponsesDelegationConfig.ToolChoice.LiveToolChoiceEnum.AUTO
                                )
                                .tools(listOf())
                                .build()
                        )
                        .input(listOf())
                        .instructions(
                            "Help the caller plan a restaurant reservation. Confirm details before booking."
                        )
                        .store(true)
                        .build()
                )
                .clientEventId("evt_update_001")
                .build()

        val roundtrippedSessionUpdatedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sessionUpdatedEvent),
                jacksonTypeRef<SessionUpdatedEvent>(),
            )

        assertThat(roundtrippedSessionUpdatedEvent).isEqualTo(sessionUpdatedEvent)
    }
}
