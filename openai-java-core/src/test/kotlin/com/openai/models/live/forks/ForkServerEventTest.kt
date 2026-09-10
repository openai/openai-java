// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live.forks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.live.AudioFormat
import com.openai.models.live.ClientConfig
import com.openai.models.live.ClientDelegation
import com.openai.models.live.CommentaryAppendedEvent
import com.openai.models.live.DataChannelConfig
import com.openai.models.live.DelegationCreatedEvent
import com.openai.models.live.Error
import com.openai.models.live.ErrorEvent
import com.openai.models.live.InfoEvent
import com.openai.models.live.InputAudioMutedEvent
import com.openai.models.live.InputAudioUnmutedEvent
import com.openai.models.live.InputTranscriptDeltaEvent
import com.openai.models.live.InstructionsAppendedEvent
import com.openai.models.live.OutputAudioDeltaEvent
import com.openai.models.live.OutputTranscriptDeltaEvent
import com.openai.models.live.ResponseEvent
import com.openai.models.live.ResponsesDelegationConfig
import com.openai.models.live.SessionClosedEvent
import com.openai.models.live.SessionResource
import com.openai.models.live.SessionStartedEvent
import com.openai.models.live.SessionUpdatedEvent
import com.openai.models.live.SessionUsage
import com.openai.models.live.SessionUsageUpdatedEvent
import com.openai.models.live.ThinkingAppendedEvent
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ForkServerEventTest {

    @Test
    fun ofSessionStarted() {
        val sessionStarted =
            SessionStartedEvent.builder()
                .eventId("evt_started_001")
                .session(
                    SessionResource.builder()
                        .id("live_abc123")
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
                        .delegation(ClientDelegation.builder().build())
                        .input(listOf())
                        .instructions(
                            "Help the caller plan a restaurant reservation. Confirm details before booking."
                        )
                        .store(true)
                        .build()
                )
                .clientEventId("evt_start_001")
                .build()

        val forkServerEvent = ForkServerEvent.ofSessionStarted(sessionStarted)

        assertThat(forkServerEvent.sessionStarted()).contains(sessionStarted)
        assertThat(forkServerEvent.sessionUpdated()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(forkServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(forkServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(forkServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(forkServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(forkServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(forkServerEvent.responseEvent()).isEmpty
        assertThat(forkServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(forkServerEvent.sessionClosed()).isEmpty
        assertThat(forkServerEvent.errorEvent()).isEmpty
        assertThat(forkServerEvent.infoEvent()).isEmpty
        assertThat(forkServerEvent.transportDtmfReceived()).isEmpty
        assertThat(forkServerEvent.transportDtmfSend()).isEmpty
        assertThat(forkServerEvent.transportRinging()).isEmpty
        assertThat(forkServerEvent.transportAnswered()).isEmpty
        assertThat(forkServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionStartedRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkServerEvent =
            ForkServerEvent.ofSessionStarted(
                SessionStartedEvent.builder()
                    .eventId("evt_started_001")
                    .session(
                        SessionResource.builder()
                            .id("live_abc123")
                            .expiresAt(1788555600L)
                            .model(SessionResource.Model.GPT_LIVE_1)
                            .audio(
                                SessionResource.Audio.builder()
                                    .audioPcmFormat(AudioFormat.AudioPcm.Rate._24000)
                                    .output(
                                        SessionResource.Audio.Output.builder()
                                            .voice("marin")
                                            .build()
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
                            .delegation(ClientDelegation.builder().build())
                            .input(listOf())
                            .instructions(
                                "Help the caller plan a restaurant reservation. Confirm details before booking."
                            )
                            .store(true)
                            .build()
                    )
                    .clientEventId("evt_start_001")
                    .build()
            )

        val roundtrippedForkServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkServerEvent),
                jacksonTypeRef<ForkServerEvent>(),
            )

        assertThat(roundtrippedForkServerEvent).isEqualTo(forkServerEvent)
    }

    @Test
    fun ofSessionUpdated() {
        val sessionUpdated =
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

        val forkServerEvent = ForkServerEvent.ofSessionUpdated(sessionUpdated)

        assertThat(forkServerEvent.sessionStarted()).isEmpty
        assertThat(forkServerEvent.sessionUpdated()).contains(sessionUpdated)
        assertThat(forkServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(forkServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(forkServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(forkServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(forkServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(forkServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(forkServerEvent.responseEvent()).isEmpty
        assertThat(forkServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(forkServerEvent.sessionClosed()).isEmpty
        assertThat(forkServerEvent.errorEvent()).isEmpty
        assertThat(forkServerEvent.infoEvent()).isEmpty
        assertThat(forkServerEvent.transportDtmfReceived()).isEmpty
        assertThat(forkServerEvent.transportDtmfSend()).isEmpty
        assertThat(forkServerEvent.transportRinging()).isEmpty
        assertThat(forkServerEvent.transportAnswered()).isEmpty
        assertThat(forkServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionUpdatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkServerEvent =
            ForkServerEvent.ofSessionUpdated(
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
                                        SessionResource.Audio.Output.builder()
                                            .voice("marin")
                                            .build()
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
            )

        val roundtrippedForkServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkServerEvent),
                jacksonTypeRef<ForkServerEvent>(),
            )

        assertThat(roundtrippedForkServerEvent).isEqualTo(forkServerEvent)
    }

    @Test
    fun ofSessionInputAudioMuted() {
        val sessionInputAudioMuted =
            InputAudioMutedEvent.builder()
                .eventId("evt_muted_001")
                .clientEventId("evt_mute_001")
                .build()

        val forkServerEvent = ForkServerEvent.ofSessionInputAudioMuted(sessionInputAudioMuted)

        assertThat(forkServerEvent.sessionStarted()).isEmpty
        assertThat(forkServerEvent.sessionUpdated()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioMuted()).contains(sessionInputAudioMuted)
        assertThat(forkServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(forkServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(forkServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(forkServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(forkServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(forkServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(forkServerEvent.responseEvent()).isEmpty
        assertThat(forkServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(forkServerEvent.sessionClosed()).isEmpty
        assertThat(forkServerEvent.errorEvent()).isEmpty
        assertThat(forkServerEvent.infoEvent()).isEmpty
        assertThat(forkServerEvent.transportDtmfReceived()).isEmpty
        assertThat(forkServerEvent.transportDtmfSend()).isEmpty
        assertThat(forkServerEvent.transportRinging()).isEmpty
        assertThat(forkServerEvent.transportAnswered()).isEmpty
        assertThat(forkServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionInputAudioMutedRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkServerEvent =
            ForkServerEvent.ofSessionInputAudioMuted(
                InputAudioMutedEvent.builder()
                    .eventId("evt_muted_001")
                    .clientEventId("evt_mute_001")
                    .build()
            )

        val roundtrippedForkServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkServerEvent),
                jacksonTypeRef<ForkServerEvent>(),
            )

        assertThat(roundtrippedForkServerEvent).isEqualTo(forkServerEvent)
    }

    @Test
    fun ofSessionInputAudioUnmuted() {
        val sessionInputAudioUnmuted =
            InputAudioUnmutedEvent.builder()
                .eventId("evt_unmuted_001")
                .clientEventId("evt_unmute_001")
                .build()

        val forkServerEvent = ForkServerEvent.ofSessionInputAudioUnmuted(sessionInputAudioUnmuted)

        assertThat(forkServerEvent.sessionStarted()).isEmpty
        assertThat(forkServerEvent.sessionUpdated()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioUnmuted()).contains(sessionInputAudioUnmuted)
        assertThat(forkServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(forkServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(forkServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(forkServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(forkServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(forkServerEvent.responseEvent()).isEmpty
        assertThat(forkServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(forkServerEvent.sessionClosed()).isEmpty
        assertThat(forkServerEvent.errorEvent()).isEmpty
        assertThat(forkServerEvent.infoEvent()).isEmpty
        assertThat(forkServerEvent.transportDtmfReceived()).isEmpty
        assertThat(forkServerEvent.transportDtmfSend()).isEmpty
        assertThat(forkServerEvent.transportRinging()).isEmpty
        assertThat(forkServerEvent.transportAnswered()).isEmpty
        assertThat(forkServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionInputAudioUnmutedRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkServerEvent =
            ForkServerEvent.ofSessionInputAudioUnmuted(
                InputAudioUnmutedEvent.builder()
                    .eventId("evt_unmuted_001")
                    .clientEventId("evt_unmute_001")
                    .build()
            )

        val roundtrippedForkServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkServerEvent),
                jacksonTypeRef<ForkServerEvent>(),
            )

        assertThat(roundtrippedForkServerEvent).isEqualTo(forkServerEvent)
    }

    @Test
    fun ofSessionInstructionsAppended() {
        val sessionInstructionsAppended =
            InstructionsAppendedEvent.builder()
                .endMs(1400L)
                .eventId("evt_instructions_002")
                .startMs(1200L)
                .clientEventId("evt_instructions_001")
                .build()

        val forkServerEvent =
            ForkServerEvent.ofSessionInstructionsAppended(sessionInstructionsAppended)

        assertThat(forkServerEvent.sessionStarted()).isEmpty
        assertThat(forkServerEvent.sessionUpdated()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(forkServerEvent.sessionInstructionsAppended())
            .contains(sessionInstructionsAppended)
        assertThat(forkServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(forkServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(forkServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(forkServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(forkServerEvent.responseEvent()).isEmpty
        assertThat(forkServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(forkServerEvent.sessionClosed()).isEmpty
        assertThat(forkServerEvent.errorEvent()).isEmpty
        assertThat(forkServerEvent.infoEvent()).isEmpty
        assertThat(forkServerEvent.transportDtmfReceived()).isEmpty
        assertThat(forkServerEvent.transportDtmfSend()).isEmpty
        assertThat(forkServerEvent.transportRinging()).isEmpty
        assertThat(forkServerEvent.transportAnswered()).isEmpty
        assertThat(forkServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionInstructionsAppendedRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkServerEvent =
            ForkServerEvent.ofSessionInstructionsAppended(
                InstructionsAppendedEvent.builder()
                    .endMs(1400L)
                    .eventId("evt_instructions_002")
                    .startMs(1200L)
                    .clientEventId("evt_instructions_001")
                    .build()
            )

        val roundtrippedForkServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkServerEvent),
                jacksonTypeRef<ForkServerEvent>(),
            )

        assertThat(roundtrippedForkServerEvent).isEqualTo(forkServerEvent)
    }

    @Test
    fun ofSessionThinkingAppended() {
        val sessionThinkingAppended =
            ThinkingAppendedEvent.builder()
                .endMs(4800L)
                .eventId("evt_thinking_002")
                .startMs(4600L)
                .clientEventId("evt_thinking_001")
                .build()

        val forkServerEvent = ForkServerEvent.ofSessionThinkingAppended(sessionThinkingAppended)

        assertThat(forkServerEvent.sessionStarted()).isEmpty
        assertThat(forkServerEvent.sessionUpdated()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(forkServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(forkServerEvent.sessionThinkingAppended()).contains(sessionThinkingAppended)
        assertThat(forkServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(forkServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(forkServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(forkServerEvent.responseEvent()).isEmpty
        assertThat(forkServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(forkServerEvent.sessionClosed()).isEmpty
        assertThat(forkServerEvent.errorEvent()).isEmpty
        assertThat(forkServerEvent.infoEvent()).isEmpty
        assertThat(forkServerEvent.transportDtmfReceived()).isEmpty
        assertThat(forkServerEvent.transportDtmfSend()).isEmpty
        assertThat(forkServerEvent.transportRinging()).isEmpty
        assertThat(forkServerEvent.transportAnswered()).isEmpty
        assertThat(forkServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionThinkingAppendedRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkServerEvent =
            ForkServerEvent.ofSessionThinkingAppended(
                ThinkingAppendedEvent.builder()
                    .endMs(4800L)
                    .eventId("evt_thinking_002")
                    .startMs(4600L)
                    .clientEventId("evt_thinking_001")
                    .build()
            )

        val roundtrippedForkServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkServerEvent),
                jacksonTypeRef<ForkServerEvent>(),
            )

        assertThat(roundtrippedForkServerEvent).isEqualTo(forkServerEvent)
    }

    @Test
    fun ofSessionCommentaryAppended() {
        val sessionCommentaryAppended =
            CommentaryAppendedEvent.builder()
                .endMs(5400L)
                .eventId("evt_commentary_002")
                .startMs(5200L)
                .clientEventId("evt_commentary_001")
                .build()

        val forkServerEvent = ForkServerEvent.ofSessionCommentaryAppended(sessionCommentaryAppended)

        assertThat(forkServerEvent.sessionStarted()).isEmpty
        assertThat(forkServerEvent.sessionUpdated()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(forkServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(forkServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(forkServerEvent.sessionCommentaryAppended()).contains(sessionCommentaryAppended)
        assertThat(forkServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(forkServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(forkServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(forkServerEvent.responseEvent()).isEmpty
        assertThat(forkServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(forkServerEvent.sessionClosed()).isEmpty
        assertThat(forkServerEvent.errorEvent()).isEmpty
        assertThat(forkServerEvent.infoEvent()).isEmpty
        assertThat(forkServerEvent.transportDtmfReceived()).isEmpty
        assertThat(forkServerEvent.transportDtmfSend()).isEmpty
        assertThat(forkServerEvent.transportRinging()).isEmpty
        assertThat(forkServerEvent.transportAnswered()).isEmpty
        assertThat(forkServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionCommentaryAppendedRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkServerEvent =
            ForkServerEvent.ofSessionCommentaryAppended(
                CommentaryAppendedEvent.builder()
                    .endMs(5400L)
                    .eventId("evt_commentary_002")
                    .startMs(5200L)
                    .clientEventId("evt_commentary_001")
                    .build()
            )

        val roundtrippedForkServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkServerEvent),
                jacksonTypeRef<ForkServerEvent>(),
            )

        assertThat(roundtrippedForkServerEvent).isEqualTo(forkServerEvent)
    }

    @Test
    fun ofSessionInputAudioAppend() {
        val sessionInputAudioAppend =
            ForkServerEvent.SessionInputAudioAppend.builder().audio("audio").build()

        val forkServerEvent = ForkServerEvent.ofSessionInputAudioAppend(sessionInputAudioAppend)

        assertThat(forkServerEvent.sessionStarted()).isEmpty
        assertThat(forkServerEvent.sessionUpdated()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(forkServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(forkServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(forkServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioAppend()).contains(sessionInputAudioAppend)
        assertThat(forkServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(forkServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(forkServerEvent.responseEvent()).isEmpty
        assertThat(forkServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(forkServerEvent.sessionClosed()).isEmpty
        assertThat(forkServerEvent.errorEvent()).isEmpty
        assertThat(forkServerEvent.infoEvent()).isEmpty
        assertThat(forkServerEvent.transportDtmfReceived()).isEmpty
        assertThat(forkServerEvent.transportDtmfSend()).isEmpty
        assertThat(forkServerEvent.transportRinging()).isEmpty
        assertThat(forkServerEvent.transportAnswered()).isEmpty
        assertThat(forkServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionInputAudioAppendRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkServerEvent =
            ForkServerEvent.ofSessionInputAudioAppend(
                ForkServerEvent.SessionInputAudioAppend.builder().audio("audio").build()
            )

        val roundtrippedForkServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkServerEvent),
                jacksonTypeRef<ForkServerEvent>(),
            )

        assertThat(roundtrippedForkServerEvent).isEqualTo(forkServerEvent)
    }

    @Test
    fun ofSessionOutputAudioDelta() {
        val sessionOutputAudioDelta =
            OutputAudioDeltaEvent.builder()
                .delta("AACAAIAAAIAAAP9/AIAAgA==")
                .endMs(1200L)
                .startMs(1000L)
                .build()

        val forkServerEvent = ForkServerEvent.ofSessionOutputAudioDelta(sessionOutputAudioDelta)

        assertThat(forkServerEvent.sessionStarted()).isEmpty
        assertThat(forkServerEvent.sessionUpdated()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(forkServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(forkServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(forkServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(forkServerEvent.sessionOutputAudioDelta()).contains(sessionOutputAudioDelta)
        assertThat(forkServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(forkServerEvent.responseEvent()).isEmpty
        assertThat(forkServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(forkServerEvent.sessionClosed()).isEmpty
        assertThat(forkServerEvent.errorEvent()).isEmpty
        assertThat(forkServerEvent.infoEvent()).isEmpty
        assertThat(forkServerEvent.transportDtmfReceived()).isEmpty
        assertThat(forkServerEvent.transportDtmfSend()).isEmpty
        assertThat(forkServerEvent.transportRinging()).isEmpty
        assertThat(forkServerEvent.transportAnswered()).isEmpty
        assertThat(forkServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionOutputAudioDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkServerEvent =
            ForkServerEvent.ofSessionOutputAudioDelta(
                OutputAudioDeltaEvent.builder()
                    .delta("AACAAIAAAIAAAP9/AIAAgA==")
                    .endMs(1200L)
                    .startMs(1000L)
                    .build()
            )

        val roundtrippedForkServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkServerEvent),
                jacksonTypeRef<ForkServerEvent>(),
            )

        assertThat(roundtrippedForkServerEvent).isEqualTo(forkServerEvent)
    }

    @Test
    fun ofSessionInputTranscriptDelta() {
        val sessionInputTranscriptDelta =
            InputTranscriptDeltaEvent.builder()
                .delta("A table for two at seven, please.")
                .endMs(3400L)
                .eventId("evt_input_transcript_001")
                .startMs(1600L)
                .clientEventId("client_event_id")
                .build()

        val forkServerEvent =
            ForkServerEvent.ofSessionInputTranscriptDelta(sessionInputTranscriptDelta)

        assertThat(forkServerEvent.sessionStarted()).isEmpty
        assertThat(forkServerEvent.sessionUpdated()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(forkServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(forkServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(forkServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(forkServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(forkServerEvent.sessionInputTranscriptDelta())
            .contains(sessionInputTranscriptDelta)
        assertThat(forkServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(forkServerEvent.responseEvent()).isEmpty
        assertThat(forkServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(forkServerEvent.sessionClosed()).isEmpty
        assertThat(forkServerEvent.errorEvent()).isEmpty
        assertThat(forkServerEvent.infoEvent()).isEmpty
        assertThat(forkServerEvent.transportDtmfReceived()).isEmpty
        assertThat(forkServerEvent.transportDtmfSend()).isEmpty
        assertThat(forkServerEvent.transportRinging()).isEmpty
        assertThat(forkServerEvent.transportAnswered()).isEmpty
        assertThat(forkServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionInputTranscriptDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkServerEvent =
            ForkServerEvent.ofSessionInputTranscriptDelta(
                InputTranscriptDeltaEvent.builder()
                    .delta("A table for two at seven, please.")
                    .endMs(3400L)
                    .eventId("evt_input_transcript_001")
                    .startMs(1600L)
                    .clientEventId("client_event_id")
                    .build()
            )

        val roundtrippedForkServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkServerEvent),
                jacksonTypeRef<ForkServerEvent>(),
            )

        assertThat(roundtrippedForkServerEvent).isEqualTo(forkServerEvent)
    }

    @Test
    fun ofSessionOutputTranscriptDelta() {
        val sessionOutputTranscriptDelta =
            OutputTranscriptDeltaEvent.builder()
                .delta("Would you like me to reserve that table?")
                .endMs(7200L)
                .eventId("evt_output_transcript_001")
                .startMs(5400L)
                .clientEventId("client_event_id")
                .build()

        val forkServerEvent =
            ForkServerEvent.ofSessionOutputTranscriptDelta(sessionOutputTranscriptDelta)

        assertThat(forkServerEvent.sessionStarted()).isEmpty
        assertThat(forkServerEvent.sessionUpdated()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(forkServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(forkServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(forkServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(forkServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(forkServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionOutputTranscriptDelta())
            .contains(sessionOutputTranscriptDelta)
        assertThat(forkServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(forkServerEvent.responseEvent()).isEmpty
        assertThat(forkServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(forkServerEvent.sessionClosed()).isEmpty
        assertThat(forkServerEvent.errorEvent()).isEmpty
        assertThat(forkServerEvent.infoEvent()).isEmpty
        assertThat(forkServerEvent.transportDtmfReceived()).isEmpty
        assertThat(forkServerEvent.transportDtmfSend()).isEmpty
        assertThat(forkServerEvent.transportRinging()).isEmpty
        assertThat(forkServerEvent.transportAnswered()).isEmpty
        assertThat(forkServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionOutputTranscriptDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkServerEvent =
            ForkServerEvent.ofSessionOutputTranscriptDelta(
                OutputTranscriptDeltaEvent.builder()
                    .delta("Would you like me to reserve that table?")
                    .endMs(7200L)
                    .eventId("evt_output_transcript_001")
                    .startMs(5400L)
                    .clientEventId("client_event_id")
                    .build()
            )

        val roundtrippedForkServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkServerEvent),
                jacksonTypeRef<ForkServerEvent>(),
            )

        assertThat(roundtrippedForkServerEvent).isEqualTo(forkServerEvent)
    }

    @Test
    fun ofSessionDelegationCreated() {
        val sessionDelegationCreated =
            DelegationCreatedEvent.builder()
                .delegation(
                    DelegationCreatedEvent.Delegation.builder()
                        .id("del_abc123")
                        .target(DelegationCreatedEvent.Delegation.Target.CLIENT)
                        .responseId("response_id")
                        .build()
                )
                .eventId("evt_delegation_001")
                .offsetMs(3600L)
                .clientEventId("client_event_id")
                .build()

        val forkServerEvent = ForkServerEvent.ofSessionDelegationCreated(sessionDelegationCreated)

        assertThat(forkServerEvent.sessionStarted()).isEmpty
        assertThat(forkServerEvent.sessionUpdated()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(forkServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(forkServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(forkServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(forkServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(forkServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionDelegationCreated()).contains(sessionDelegationCreated)
        assertThat(forkServerEvent.responseEvent()).isEmpty
        assertThat(forkServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(forkServerEvent.sessionClosed()).isEmpty
        assertThat(forkServerEvent.errorEvent()).isEmpty
        assertThat(forkServerEvent.infoEvent()).isEmpty
        assertThat(forkServerEvent.transportDtmfReceived()).isEmpty
        assertThat(forkServerEvent.transportDtmfSend()).isEmpty
        assertThat(forkServerEvent.transportRinging()).isEmpty
        assertThat(forkServerEvent.transportAnswered()).isEmpty
        assertThat(forkServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionDelegationCreatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkServerEvent =
            ForkServerEvent.ofSessionDelegationCreated(
                DelegationCreatedEvent.builder()
                    .delegation(
                        DelegationCreatedEvent.Delegation.builder()
                            .id("del_abc123")
                            .target(DelegationCreatedEvent.Delegation.Target.CLIENT)
                            .responseId("response_id")
                            .build()
                    )
                    .eventId("evt_delegation_001")
                    .offsetMs(3600L)
                    .clientEventId("client_event_id")
                    .build()
            )

        val roundtrippedForkServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkServerEvent),
                jacksonTypeRef<ForkServerEvent>(),
            )

        assertThat(roundtrippedForkServerEvent).isEqualTo(forkServerEvent)
    }

    @Test
    fun ofResponseEvent() {
        val responseEvent =
            ResponseEvent.builder()
                .event(
                    ResponseEvent.Event.builder()
                        .putAdditionalProperty("type", JsonValue.from("response.output_text.delta"))
                        .putAdditionalProperty("item_id", JsonValue.from("msg_abc123"))
                        .putAdditionalProperty("output_index", JsonValue.from(0))
                        .putAdditionalProperty("content_index", JsonValue.from(0))
                        .putAdditionalProperty(
                            "delta",
                            JsonValue.from("An outdoor table is available at 7 PM."),
                        )
                        .putAdditionalProperty("sequence_number", JsonValue.from(3))
                        .putAdditionalProperty("logprobs", JsonValue.from(listOf<Any?>()))
                        .build()
                )
                .eventId("evt_response_002")
                .clientEventId("client_event_id")
                .delegationId("del_responses123")
                .build()

        val forkServerEvent = ForkServerEvent.ofResponseEvent(responseEvent)

        assertThat(forkServerEvent.sessionStarted()).isEmpty
        assertThat(forkServerEvent.sessionUpdated()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(forkServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(forkServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(forkServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(forkServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(forkServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(forkServerEvent.responseEvent()).contains(responseEvent)
        assertThat(forkServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(forkServerEvent.sessionClosed()).isEmpty
        assertThat(forkServerEvent.errorEvent()).isEmpty
        assertThat(forkServerEvent.infoEvent()).isEmpty
        assertThat(forkServerEvent.transportDtmfReceived()).isEmpty
        assertThat(forkServerEvent.transportDtmfSend()).isEmpty
        assertThat(forkServerEvent.transportRinging()).isEmpty
        assertThat(forkServerEvent.transportAnswered()).isEmpty
        assertThat(forkServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofResponseEventRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkServerEvent =
            ForkServerEvent.ofResponseEvent(
                ResponseEvent.builder()
                    .event(
                        ResponseEvent.Event.builder()
                            .putAdditionalProperty(
                                "type",
                                JsonValue.from("response.output_text.delta"),
                            )
                            .putAdditionalProperty("item_id", JsonValue.from("msg_abc123"))
                            .putAdditionalProperty("output_index", JsonValue.from(0))
                            .putAdditionalProperty("content_index", JsonValue.from(0))
                            .putAdditionalProperty(
                                "delta",
                                JsonValue.from("An outdoor table is available at 7 PM."),
                            )
                            .putAdditionalProperty("sequence_number", JsonValue.from(3))
                            .putAdditionalProperty("logprobs", JsonValue.from(listOf<Any?>()))
                            .build()
                    )
                    .eventId("evt_response_002")
                    .clientEventId("client_event_id")
                    .delegationId("del_responses123")
                    .build()
            )

        val roundtrippedForkServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkServerEvent),
                jacksonTypeRef<ForkServerEvent>(),
            )

        assertThat(roundtrippedForkServerEvent).isEqualTo(forkServerEvent)
    }

    @Test
    fun ofSessionUsageUpdated() {
        val sessionUsageUpdated =
            SessionUsageUpdatedEvent.builder()
                .eventId("evt_usage_001")
                .usage(SessionUsage.builder().seconds(32.5).build())
                .clientEventId("client_event_id")
                .contextWindow(
                    SessionUsageUpdatedEvent.ContextWindow.builder().usageRatio(0.12).build()
                )
                .build()

        val forkServerEvent = ForkServerEvent.ofSessionUsageUpdated(sessionUsageUpdated)

        assertThat(forkServerEvent.sessionStarted()).isEmpty
        assertThat(forkServerEvent.sessionUpdated()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(forkServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(forkServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(forkServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(forkServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(forkServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(forkServerEvent.responseEvent()).isEmpty
        assertThat(forkServerEvent.sessionUsageUpdated()).contains(sessionUsageUpdated)
        assertThat(forkServerEvent.sessionClosed()).isEmpty
        assertThat(forkServerEvent.errorEvent()).isEmpty
        assertThat(forkServerEvent.infoEvent()).isEmpty
        assertThat(forkServerEvent.transportDtmfReceived()).isEmpty
        assertThat(forkServerEvent.transportDtmfSend()).isEmpty
        assertThat(forkServerEvent.transportRinging()).isEmpty
        assertThat(forkServerEvent.transportAnswered()).isEmpty
        assertThat(forkServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionUsageUpdatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkServerEvent =
            ForkServerEvent.ofSessionUsageUpdated(
                SessionUsageUpdatedEvent.builder()
                    .eventId("evt_usage_001")
                    .usage(SessionUsage.builder().seconds(32.5).build())
                    .clientEventId("client_event_id")
                    .contextWindow(
                        SessionUsageUpdatedEvent.ContextWindow.builder().usageRatio(0.12).build()
                    )
                    .build()
            )

        val roundtrippedForkServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkServerEvent),
                jacksonTypeRef<ForkServerEvent>(),
            )

        assertThat(roundtrippedForkServerEvent).isEqualTo(forkServerEvent)
    }

    @Test
    fun ofSessionClosed() {
        val sessionClosed =
            SessionClosedEvent.builder()
                .eventId("evt_closed_001")
                .reason(SessionClosedEvent.Reason.CLOSE_REQUESTED)
                .session(
                    SessionResource.builder()
                        .id("live_abc123")
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
                        .delegation(ClientDelegation.builder().build())
                        .input(listOf())
                        .instructions(
                            "Help the caller plan a restaurant reservation. Confirm details before booking."
                        )
                        .store(true)
                        .build()
                )
                .usage(SessionUsage.builder().seconds(45.8).build())
                .clientEventId("evt_close_001")
                .build()

        val forkServerEvent = ForkServerEvent.ofSessionClosed(sessionClosed)

        assertThat(forkServerEvent.sessionStarted()).isEmpty
        assertThat(forkServerEvent.sessionUpdated()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(forkServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(forkServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(forkServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(forkServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(forkServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(forkServerEvent.responseEvent()).isEmpty
        assertThat(forkServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(forkServerEvent.sessionClosed()).contains(sessionClosed)
        assertThat(forkServerEvent.errorEvent()).isEmpty
        assertThat(forkServerEvent.infoEvent()).isEmpty
        assertThat(forkServerEvent.transportDtmfReceived()).isEmpty
        assertThat(forkServerEvent.transportDtmfSend()).isEmpty
        assertThat(forkServerEvent.transportRinging()).isEmpty
        assertThat(forkServerEvent.transportAnswered()).isEmpty
        assertThat(forkServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionClosedRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkServerEvent =
            ForkServerEvent.ofSessionClosed(
                SessionClosedEvent.builder()
                    .eventId("evt_closed_001")
                    .reason(SessionClosedEvent.Reason.CLOSE_REQUESTED)
                    .session(
                        SessionResource.builder()
                            .id("live_abc123")
                            .expiresAt(1788555600L)
                            .model(SessionResource.Model.GPT_LIVE_1)
                            .audio(
                                SessionResource.Audio.builder()
                                    .audioPcmFormat(AudioFormat.AudioPcm.Rate._24000)
                                    .output(
                                        SessionResource.Audio.Output.builder()
                                            .voice("marin")
                                            .build()
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
                            .delegation(ClientDelegation.builder().build())
                            .input(listOf())
                            .instructions(
                                "Help the caller plan a restaurant reservation. Confirm details before booking."
                            )
                            .store(true)
                            .build()
                    )
                    .usage(SessionUsage.builder().seconds(45.8).build())
                    .clientEventId("evt_close_001")
                    .build()
            )

        val roundtrippedForkServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkServerEvent),
                jacksonTypeRef<ForkServerEvent>(),
            )

        assertThat(roundtrippedForkServerEvent).isEqualTo(forkServerEvent)
    }

    @Test
    fun ofErrorEvent() {
        val errorEvent =
            ErrorEvent.builder()
                .error(
                    Error.builder()
                        .code("unknown_parameter")
                        .message("Unknown parameter: 'session.voice'.")
                        .type("invalid_request_error")
                        .clientEventId("evt_invalid_001")
                        .param("session.voice")
                        .build()
                )
                .eventId("evt_error_001")
                .clientEventId("client_event_id")
                .build()

        val forkServerEvent = ForkServerEvent.ofErrorEvent(errorEvent)

        assertThat(forkServerEvent.sessionStarted()).isEmpty
        assertThat(forkServerEvent.sessionUpdated()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(forkServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(forkServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(forkServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(forkServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(forkServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(forkServerEvent.responseEvent()).isEmpty
        assertThat(forkServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(forkServerEvent.sessionClosed()).isEmpty
        assertThat(forkServerEvent.errorEvent()).contains(errorEvent)
        assertThat(forkServerEvent.infoEvent()).isEmpty
        assertThat(forkServerEvent.transportDtmfReceived()).isEmpty
        assertThat(forkServerEvent.transportDtmfSend()).isEmpty
        assertThat(forkServerEvent.transportRinging()).isEmpty
        assertThat(forkServerEvent.transportAnswered()).isEmpty
        assertThat(forkServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofErrorEventRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkServerEvent =
            ForkServerEvent.ofErrorEvent(
                ErrorEvent.builder()
                    .error(
                        Error.builder()
                            .code("unknown_parameter")
                            .message("Unknown parameter: 'session.voice'.")
                            .type("invalid_request_error")
                            .clientEventId("evt_invalid_001")
                            .param("session.voice")
                            .build()
                    )
                    .eventId("evt_error_001")
                    .clientEventId("client_event_id")
                    .build()
            )

        val roundtrippedForkServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkServerEvent),
                jacksonTypeRef<ForkServerEvent>(),
            )

        assertThat(roundtrippedForkServerEvent).isEqualTo(forkServerEvent)
    }

    @Test
    fun ofInfoEvent() {
        val infoEvent =
            InfoEvent.builder()
                .code("data_channel_permissions")
                .eventId("evt_info_001")
                .message(
                    "The frontend data channel is configured with restricted event permissions."
                )
                .clientEventId("client_event_id")
                .build()

        val forkServerEvent = ForkServerEvent.ofInfoEvent(infoEvent)

        assertThat(forkServerEvent.sessionStarted()).isEmpty
        assertThat(forkServerEvent.sessionUpdated()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(forkServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(forkServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(forkServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(forkServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(forkServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(forkServerEvent.responseEvent()).isEmpty
        assertThat(forkServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(forkServerEvent.sessionClosed()).isEmpty
        assertThat(forkServerEvent.errorEvent()).isEmpty
        assertThat(forkServerEvent.infoEvent()).contains(infoEvent)
        assertThat(forkServerEvent.transportDtmfReceived()).isEmpty
        assertThat(forkServerEvent.transportDtmfSend()).isEmpty
        assertThat(forkServerEvent.transportRinging()).isEmpty
        assertThat(forkServerEvent.transportAnswered()).isEmpty
        assertThat(forkServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofInfoEventRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkServerEvent =
            ForkServerEvent.ofInfoEvent(
                InfoEvent.builder()
                    .code("data_channel_permissions")
                    .eventId("evt_info_001")
                    .message(
                        "The frontend data channel is configured with restricted event permissions."
                    )
                    .clientEventId("client_event_id")
                    .build()
            )

        val roundtrippedForkServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkServerEvent),
                jacksonTypeRef<ForkServerEvent>(),
            )

        assertThat(roundtrippedForkServerEvent).isEqualTo(forkServerEvent)
    }

    @Test
    fun ofTransportDtmfReceived() {
        val transportDtmfReceived =
            ForkServerEvent.TransportDtmfReceived.builder().event("#").eventId("event_id").build()

        val forkServerEvent = ForkServerEvent.ofTransportDtmfReceived(transportDtmfReceived)

        assertThat(forkServerEvent.sessionStarted()).isEmpty
        assertThat(forkServerEvent.sessionUpdated()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(forkServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(forkServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(forkServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(forkServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(forkServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(forkServerEvent.responseEvent()).isEmpty
        assertThat(forkServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(forkServerEvent.sessionClosed()).isEmpty
        assertThat(forkServerEvent.errorEvent()).isEmpty
        assertThat(forkServerEvent.infoEvent()).isEmpty
        assertThat(forkServerEvent.transportDtmfReceived()).contains(transportDtmfReceived)
        assertThat(forkServerEvent.transportDtmfSend()).isEmpty
        assertThat(forkServerEvent.transportRinging()).isEmpty
        assertThat(forkServerEvent.transportAnswered()).isEmpty
        assertThat(forkServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofTransportDtmfReceivedRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkServerEvent =
            ForkServerEvent.ofTransportDtmfReceived(
                ForkServerEvent.TransportDtmfReceived.builder()
                    .event("#")
                    .eventId("event_id")
                    .build()
            )

        val roundtrippedForkServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkServerEvent),
                jacksonTypeRef<ForkServerEvent>(),
            )

        assertThat(roundtrippedForkServerEvent).isEqualTo(forkServerEvent)
    }

    @Test
    fun ofTransportDtmfSend() {
        val transportDtmfSend =
            ForkServerEvent.TransportDtmfSend.builder().event("#").eventId("event_id").build()

        val forkServerEvent = ForkServerEvent.ofTransportDtmfSend(transportDtmfSend)

        assertThat(forkServerEvent.sessionStarted()).isEmpty
        assertThat(forkServerEvent.sessionUpdated()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(forkServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(forkServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(forkServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(forkServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(forkServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(forkServerEvent.responseEvent()).isEmpty
        assertThat(forkServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(forkServerEvent.sessionClosed()).isEmpty
        assertThat(forkServerEvent.errorEvent()).isEmpty
        assertThat(forkServerEvent.infoEvent()).isEmpty
        assertThat(forkServerEvent.transportDtmfReceived()).isEmpty
        assertThat(forkServerEvent.transportDtmfSend()).contains(transportDtmfSend)
        assertThat(forkServerEvent.transportRinging()).isEmpty
        assertThat(forkServerEvent.transportAnswered()).isEmpty
        assertThat(forkServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofTransportDtmfSendRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkServerEvent =
            ForkServerEvent.ofTransportDtmfSend(
                ForkServerEvent.TransportDtmfSend.builder().event("#").eventId("event_id").build()
            )

        val roundtrippedForkServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkServerEvent),
                jacksonTypeRef<ForkServerEvent>(),
            )

        assertThat(roundtrippedForkServerEvent).isEqualTo(forkServerEvent)
    }

    @Test
    fun ofTransportRinging() {
        val transportRinging =
            ForkServerEvent.TransportRinging.builder()
                .eventId("event_id")
                .sessionId("session_id")
                .build()

        val forkServerEvent = ForkServerEvent.ofTransportRinging(transportRinging)

        assertThat(forkServerEvent.sessionStarted()).isEmpty
        assertThat(forkServerEvent.sessionUpdated()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(forkServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(forkServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(forkServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(forkServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(forkServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(forkServerEvent.responseEvent()).isEmpty
        assertThat(forkServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(forkServerEvent.sessionClosed()).isEmpty
        assertThat(forkServerEvent.errorEvent()).isEmpty
        assertThat(forkServerEvent.infoEvent()).isEmpty
        assertThat(forkServerEvent.transportDtmfReceived()).isEmpty
        assertThat(forkServerEvent.transportDtmfSend()).isEmpty
        assertThat(forkServerEvent.transportRinging()).contains(transportRinging)
        assertThat(forkServerEvent.transportAnswered()).isEmpty
        assertThat(forkServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofTransportRingingRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkServerEvent =
            ForkServerEvent.ofTransportRinging(
                ForkServerEvent.TransportRinging.builder()
                    .eventId("event_id")
                    .sessionId("session_id")
                    .build()
            )

        val roundtrippedForkServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkServerEvent),
                jacksonTypeRef<ForkServerEvent>(),
            )

        assertThat(roundtrippedForkServerEvent).isEqualTo(forkServerEvent)
    }

    @Test
    fun ofTransportAnswered() {
        val transportAnswered =
            ForkServerEvent.TransportAnswered.builder()
                .eventId("event_id")
                .sessionId("session_id")
                .build()

        val forkServerEvent = ForkServerEvent.ofTransportAnswered(transportAnswered)

        assertThat(forkServerEvent.sessionStarted()).isEmpty
        assertThat(forkServerEvent.sessionUpdated()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(forkServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(forkServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(forkServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(forkServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(forkServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(forkServerEvent.responseEvent()).isEmpty
        assertThat(forkServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(forkServerEvent.sessionClosed()).isEmpty
        assertThat(forkServerEvent.errorEvent()).isEmpty
        assertThat(forkServerEvent.infoEvent()).isEmpty
        assertThat(forkServerEvent.transportDtmfReceived()).isEmpty
        assertThat(forkServerEvent.transportDtmfSend()).isEmpty
        assertThat(forkServerEvent.transportRinging()).isEmpty
        assertThat(forkServerEvent.transportAnswered()).contains(transportAnswered)
        assertThat(forkServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofTransportAnsweredRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkServerEvent =
            ForkServerEvent.ofTransportAnswered(
                ForkServerEvent.TransportAnswered.builder()
                    .eventId("event_id")
                    .sessionId("session_id")
                    .build()
            )

        val roundtrippedForkServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkServerEvent),
                jacksonTypeRef<ForkServerEvent>(),
            )

        assertThat(roundtrippedForkServerEvent).isEqualTo(forkServerEvent)
    }

    @Test
    fun ofTransportFailed() {
        val transportFailed =
            ForkServerEvent.TransportFailed.builder()
                .error(
                    ForkServerEvent.TransportFailed.Error.builder()
                        .code("code")
                        .message("message")
                        .param("param")
                        .build()
                )
                .eventId("event_id")
                .sessionId("session_id")
                .build()

        val forkServerEvent = ForkServerEvent.ofTransportFailed(transportFailed)

        assertThat(forkServerEvent.sessionStarted()).isEmpty
        assertThat(forkServerEvent.sessionUpdated()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(forkServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(forkServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(forkServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(forkServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(forkServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(forkServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(forkServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(forkServerEvent.responseEvent()).isEmpty
        assertThat(forkServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(forkServerEvent.sessionClosed()).isEmpty
        assertThat(forkServerEvent.errorEvent()).isEmpty
        assertThat(forkServerEvent.infoEvent()).isEmpty
        assertThat(forkServerEvent.transportDtmfReceived()).isEmpty
        assertThat(forkServerEvent.transportDtmfSend()).isEmpty
        assertThat(forkServerEvent.transportRinging()).isEmpty
        assertThat(forkServerEvent.transportAnswered()).isEmpty
        assertThat(forkServerEvent.transportFailed()).contains(transportFailed)
    }

    @Test
    fun ofTransportFailedRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkServerEvent =
            ForkServerEvent.ofTransportFailed(
                ForkServerEvent.TransportFailed.builder()
                    .error(
                        ForkServerEvent.TransportFailed.Error.builder()
                            .code("code")
                            .message("message")
                            .param("param")
                            .build()
                    )
                    .eventId("event_id")
                    .sessionId("session_id")
                    .build()
            )

        val roundtrippedForkServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkServerEvent),
                jacksonTypeRef<ForkServerEvent>(),
            )

        assertThat(roundtrippedForkServerEvent).isEqualTo(forkServerEvent)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val forkServerEvent =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<ForkServerEvent>())

        val e = assertThrows<OpenAIInvalidDataException> { forkServerEvent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
