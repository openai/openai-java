// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ServerEventTest {

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
                                    SessionResource.Audio.Output.builder()
                                        .voice(BuiltInVoice.MARIN)
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

        val serverEvent = ServerEvent.ofSessionStarted(sessionStarted)

        assertThat(serverEvent.sessionStarted()).contains(sessionStarted)
        assertThat(serverEvent.sessionUpdated()).isEmpty
        assertThat(serverEvent.sessionInputAudioMuted()).isEmpty
        assertThat(serverEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(serverEvent.sessionInstructionsAppended()).isEmpty
        assertThat(serverEvent.sessionThinkingAppended()).isEmpty
        assertThat(serverEvent.sessionCommentaryAppended()).isEmpty
        assertThat(serverEvent.sessionInputAudioAppend()).isEmpty
        assertThat(serverEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(serverEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionDelegationCreated()).isEmpty
        assertThat(serverEvent.responseEvent()).isEmpty
        assertThat(serverEvent.sessionUsageUpdated()).isEmpty
        assertThat(serverEvent.sessionClosed()).isEmpty
        assertThat(serverEvent.errorEvent()).isEmpty
        assertThat(serverEvent.infoEvent()).isEmpty
        assertThat(serverEvent.transportDtmfReceived()).isEmpty
        assertThat(serverEvent.transportDtmfSend()).isEmpty
        assertThat(serverEvent.transportRinging()).isEmpty
        assertThat(serverEvent.transportAnswered()).isEmpty
        assertThat(serverEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionStartedRoundtrip() {
        val jsonMapper = jsonMapper()
        val serverEvent =
            ServerEvent.ofSessionStarted(
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
                                            .voice(BuiltInVoice.MARIN)
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

        val roundtrippedServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(serverEvent),
                jacksonTypeRef<ServerEvent>(),
            )

        assertThat(roundtrippedServerEvent).isEqualTo(serverEvent)
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
                                    SessionResource.Audio.Output.builder()
                                        .voice(BuiltInVoice.MARIN)
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

        val serverEvent = ServerEvent.ofSessionUpdated(sessionUpdated)

        assertThat(serverEvent.sessionStarted()).isEmpty
        assertThat(serverEvent.sessionUpdated()).contains(sessionUpdated)
        assertThat(serverEvent.sessionInputAudioMuted()).isEmpty
        assertThat(serverEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(serverEvent.sessionInstructionsAppended()).isEmpty
        assertThat(serverEvent.sessionThinkingAppended()).isEmpty
        assertThat(serverEvent.sessionCommentaryAppended()).isEmpty
        assertThat(serverEvent.sessionInputAudioAppend()).isEmpty
        assertThat(serverEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(serverEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionDelegationCreated()).isEmpty
        assertThat(serverEvent.responseEvent()).isEmpty
        assertThat(serverEvent.sessionUsageUpdated()).isEmpty
        assertThat(serverEvent.sessionClosed()).isEmpty
        assertThat(serverEvent.errorEvent()).isEmpty
        assertThat(serverEvent.infoEvent()).isEmpty
        assertThat(serverEvent.transportDtmfReceived()).isEmpty
        assertThat(serverEvent.transportDtmfSend()).isEmpty
        assertThat(serverEvent.transportRinging()).isEmpty
        assertThat(serverEvent.transportAnswered()).isEmpty
        assertThat(serverEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionUpdatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val serverEvent =
            ServerEvent.ofSessionUpdated(
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
                                            .voice(BuiltInVoice.MARIN)
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

        val roundtrippedServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(serverEvent),
                jacksonTypeRef<ServerEvent>(),
            )

        assertThat(roundtrippedServerEvent).isEqualTo(serverEvent)
    }

    @Test
    fun ofSessionInputAudioMuted() {
        val sessionInputAudioMuted =
            InputAudioMutedEvent.builder()
                .eventId("evt_muted_001")
                .clientEventId("evt_mute_001")
                .build()

        val serverEvent = ServerEvent.ofSessionInputAudioMuted(sessionInputAudioMuted)

        assertThat(serverEvent.sessionStarted()).isEmpty
        assertThat(serverEvent.sessionUpdated()).isEmpty
        assertThat(serverEvent.sessionInputAudioMuted()).contains(sessionInputAudioMuted)
        assertThat(serverEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(serverEvent.sessionInstructionsAppended()).isEmpty
        assertThat(serverEvent.sessionThinkingAppended()).isEmpty
        assertThat(serverEvent.sessionCommentaryAppended()).isEmpty
        assertThat(serverEvent.sessionInputAudioAppend()).isEmpty
        assertThat(serverEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(serverEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionDelegationCreated()).isEmpty
        assertThat(serverEvent.responseEvent()).isEmpty
        assertThat(serverEvent.sessionUsageUpdated()).isEmpty
        assertThat(serverEvent.sessionClosed()).isEmpty
        assertThat(serverEvent.errorEvent()).isEmpty
        assertThat(serverEvent.infoEvent()).isEmpty
        assertThat(serverEvent.transportDtmfReceived()).isEmpty
        assertThat(serverEvent.transportDtmfSend()).isEmpty
        assertThat(serverEvent.transportRinging()).isEmpty
        assertThat(serverEvent.transportAnswered()).isEmpty
        assertThat(serverEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionInputAudioMutedRoundtrip() {
        val jsonMapper = jsonMapper()
        val serverEvent =
            ServerEvent.ofSessionInputAudioMuted(
                InputAudioMutedEvent.builder()
                    .eventId("evt_muted_001")
                    .clientEventId("evt_mute_001")
                    .build()
            )

        val roundtrippedServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(serverEvent),
                jacksonTypeRef<ServerEvent>(),
            )

        assertThat(roundtrippedServerEvent).isEqualTo(serverEvent)
    }

    @Test
    fun ofSessionInputAudioUnmuted() {
        val sessionInputAudioUnmuted =
            InputAudioUnmutedEvent.builder()
                .eventId("evt_unmuted_001")
                .clientEventId("evt_unmute_001")
                .build()

        val serverEvent = ServerEvent.ofSessionInputAudioUnmuted(sessionInputAudioUnmuted)

        assertThat(serverEvent.sessionStarted()).isEmpty
        assertThat(serverEvent.sessionUpdated()).isEmpty
        assertThat(serverEvent.sessionInputAudioMuted()).isEmpty
        assertThat(serverEvent.sessionInputAudioUnmuted()).contains(sessionInputAudioUnmuted)
        assertThat(serverEvent.sessionInstructionsAppended()).isEmpty
        assertThat(serverEvent.sessionThinkingAppended()).isEmpty
        assertThat(serverEvent.sessionCommentaryAppended()).isEmpty
        assertThat(serverEvent.sessionInputAudioAppend()).isEmpty
        assertThat(serverEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(serverEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionDelegationCreated()).isEmpty
        assertThat(serverEvent.responseEvent()).isEmpty
        assertThat(serverEvent.sessionUsageUpdated()).isEmpty
        assertThat(serverEvent.sessionClosed()).isEmpty
        assertThat(serverEvent.errorEvent()).isEmpty
        assertThat(serverEvent.infoEvent()).isEmpty
        assertThat(serverEvent.transportDtmfReceived()).isEmpty
        assertThat(serverEvent.transportDtmfSend()).isEmpty
        assertThat(serverEvent.transportRinging()).isEmpty
        assertThat(serverEvent.transportAnswered()).isEmpty
        assertThat(serverEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionInputAudioUnmutedRoundtrip() {
        val jsonMapper = jsonMapper()
        val serverEvent =
            ServerEvent.ofSessionInputAudioUnmuted(
                InputAudioUnmutedEvent.builder()
                    .eventId("evt_unmuted_001")
                    .clientEventId("evt_unmute_001")
                    .build()
            )

        val roundtrippedServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(serverEvent),
                jacksonTypeRef<ServerEvent>(),
            )

        assertThat(roundtrippedServerEvent).isEqualTo(serverEvent)
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

        val serverEvent = ServerEvent.ofSessionInstructionsAppended(sessionInstructionsAppended)

        assertThat(serverEvent.sessionStarted()).isEmpty
        assertThat(serverEvent.sessionUpdated()).isEmpty
        assertThat(serverEvent.sessionInputAudioMuted()).isEmpty
        assertThat(serverEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(serverEvent.sessionInstructionsAppended()).contains(sessionInstructionsAppended)
        assertThat(serverEvent.sessionThinkingAppended()).isEmpty
        assertThat(serverEvent.sessionCommentaryAppended()).isEmpty
        assertThat(serverEvent.sessionInputAudioAppend()).isEmpty
        assertThat(serverEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(serverEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionDelegationCreated()).isEmpty
        assertThat(serverEvent.responseEvent()).isEmpty
        assertThat(serverEvent.sessionUsageUpdated()).isEmpty
        assertThat(serverEvent.sessionClosed()).isEmpty
        assertThat(serverEvent.errorEvent()).isEmpty
        assertThat(serverEvent.infoEvent()).isEmpty
        assertThat(serverEvent.transportDtmfReceived()).isEmpty
        assertThat(serverEvent.transportDtmfSend()).isEmpty
        assertThat(serverEvent.transportRinging()).isEmpty
        assertThat(serverEvent.transportAnswered()).isEmpty
        assertThat(serverEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionInstructionsAppendedRoundtrip() {
        val jsonMapper = jsonMapper()
        val serverEvent =
            ServerEvent.ofSessionInstructionsAppended(
                InstructionsAppendedEvent.builder()
                    .endMs(1400L)
                    .eventId("evt_instructions_002")
                    .startMs(1200L)
                    .clientEventId("evt_instructions_001")
                    .build()
            )

        val roundtrippedServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(serverEvent),
                jacksonTypeRef<ServerEvent>(),
            )

        assertThat(roundtrippedServerEvent).isEqualTo(serverEvent)
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

        val serverEvent = ServerEvent.ofSessionThinkingAppended(sessionThinkingAppended)

        assertThat(serverEvent.sessionStarted()).isEmpty
        assertThat(serverEvent.sessionUpdated()).isEmpty
        assertThat(serverEvent.sessionInputAudioMuted()).isEmpty
        assertThat(serverEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(serverEvent.sessionInstructionsAppended()).isEmpty
        assertThat(serverEvent.sessionThinkingAppended()).contains(sessionThinkingAppended)
        assertThat(serverEvent.sessionCommentaryAppended()).isEmpty
        assertThat(serverEvent.sessionInputAudioAppend()).isEmpty
        assertThat(serverEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(serverEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionDelegationCreated()).isEmpty
        assertThat(serverEvent.responseEvent()).isEmpty
        assertThat(serverEvent.sessionUsageUpdated()).isEmpty
        assertThat(serverEvent.sessionClosed()).isEmpty
        assertThat(serverEvent.errorEvent()).isEmpty
        assertThat(serverEvent.infoEvent()).isEmpty
        assertThat(serverEvent.transportDtmfReceived()).isEmpty
        assertThat(serverEvent.transportDtmfSend()).isEmpty
        assertThat(serverEvent.transportRinging()).isEmpty
        assertThat(serverEvent.transportAnswered()).isEmpty
        assertThat(serverEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionThinkingAppendedRoundtrip() {
        val jsonMapper = jsonMapper()
        val serverEvent =
            ServerEvent.ofSessionThinkingAppended(
                ThinkingAppendedEvent.builder()
                    .endMs(4800L)
                    .eventId("evt_thinking_002")
                    .startMs(4600L)
                    .clientEventId("evt_thinking_001")
                    .build()
            )

        val roundtrippedServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(serverEvent),
                jacksonTypeRef<ServerEvent>(),
            )

        assertThat(roundtrippedServerEvent).isEqualTo(serverEvent)
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

        val serverEvent = ServerEvent.ofSessionCommentaryAppended(sessionCommentaryAppended)

        assertThat(serverEvent.sessionStarted()).isEmpty
        assertThat(serverEvent.sessionUpdated()).isEmpty
        assertThat(serverEvent.sessionInputAudioMuted()).isEmpty
        assertThat(serverEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(serverEvent.sessionInstructionsAppended()).isEmpty
        assertThat(serverEvent.sessionThinkingAppended()).isEmpty
        assertThat(serverEvent.sessionCommentaryAppended()).contains(sessionCommentaryAppended)
        assertThat(serverEvent.sessionInputAudioAppend()).isEmpty
        assertThat(serverEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(serverEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionDelegationCreated()).isEmpty
        assertThat(serverEvent.responseEvent()).isEmpty
        assertThat(serverEvent.sessionUsageUpdated()).isEmpty
        assertThat(serverEvent.sessionClosed()).isEmpty
        assertThat(serverEvent.errorEvent()).isEmpty
        assertThat(serverEvent.infoEvent()).isEmpty
        assertThat(serverEvent.transportDtmfReceived()).isEmpty
        assertThat(serverEvent.transportDtmfSend()).isEmpty
        assertThat(serverEvent.transportRinging()).isEmpty
        assertThat(serverEvent.transportAnswered()).isEmpty
        assertThat(serverEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionCommentaryAppendedRoundtrip() {
        val jsonMapper = jsonMapper()
        val serverEvent =
            ServerEvent.ofSessionCommentaryAppended(
                CommentaryAppendedEvent.builder()
                    .endMs(5400L)
                    .eventId("evt_commentary_002")
                    .startMs(5200L)
                    .clientEventId("evt_commentary_001")
                    .build()
            )

        val roundtrippedServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(serverEvent),
                jacksonTypeRef<ServerEvent>(),
            )

        assertThat(roundtrippedServerEvent).isEqualTo(serverEvent)
    }

    @Test
    fun ofSessionInputAudioAppend() {
        val sessionInputAudioAppend =
            ServerEvent.SessionInputAudioAppend.builder().audio("audio").build()

        val serverEvent = ServerEvent.ofSessionInputAudioAppend(sessionInputAudioAppend)

        assertThat(serverEvent.sessionStarted()).isEmpty
        assertThat(serverEvent.sessionUpdated()).isEmpty
        assertThat(serverEvent.sessionInputAudioMuted()).isEmpty
        assertThat(serverEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(serverEvent.sessionInstructionsAppended()).isEmpty
        assertThat(serverEvent.sessionThinkingAppended()).isEmpty
        assertThat(serverEvent.sessionCommentaryAppended()).isEmpty
        assertThat(serverEvent.sessionInputAudioAppend()).contains(sessionInputAudioAppend)
        assertThat(serverEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(serverEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionDelegationCreated()).isEmpty
        assertThat(serverEvent.responseEvent()).isEmpty
        assertThat(serverEvent.sessionUsageUpdated()).isEmpty
        assertThat(serverEvent.sessionClosed()).isEmpty
        assertThat(serverEvent.errorEvent()).isEmpty
        assertThat(serverEvent.infoEvent()).isEmpty
        assertThat(serverEvent.transportDtmfReceived()).isEmpty
        assertThat(serverEvent.transportDtmfSend()).isEmpty
        assertThat(serverEvent.transportRinging()).isEmpty
        assertThat(serverEvent.transportAnswered()).isEmpty
        assertThat(serverEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionInputAudioAppendRoundtrip() {
        val jsonMapper = jsonMapper()
        val serverEvent =
            ServerEvent.ofSessionInputAudioAppend(
                ServerEvent.SessionInputAudioAppend.builder().audio("audio").build()
            )

        val roundtrippedServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(serverEvent),
                jacksonTypeRef<ServerEvent>(),
            )

        assertThat(roundtrippedServerEvent).isEqualTo(serverEvent)
    }

    @Test
    fun ofSessionOutputAudioDelta() {
        val sessionOutputAudioDelta =
            OutputAudioDeltaEvent.builder()
                .delta("AACAAIAAAIAAAP9/AIAAgA==")
                .endMs(1200L)
                .startMs(1000L)
                .build()

        val serverEvent = ServerEvent.ofSessionOutputAudioDelta(sessionOutputAudioDelta)

        assertThat(serverEvent.sessionStarted()).isEmpty
        assertThat(serverEvent.sessionUpdated()).isEmpty
        assertThat(serverEvent.sessionInputAudioMuted()).isEmpty
        assertThat(serverEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(serverEvent.sessionInstructionsAppended()).isEmpty
        assertThat(serverEvent.sessionThinkingAppended()).isEmpty
        assertThat(serverEvent.sessionCommentaryAppended()).isEmpty
        assertThat(serverEvent.sessionInputAudioAppend()).isEmpty
        assertThat(serverEvent.sessionOutputAudioDelta()).contains(sessionOutputAudioDelta)
        assertThat(serverEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionDelegationCreated()).isEmpty
        assertThat(serverEvent.responseEvent()).isEmpty
        assertThat(serverEvent.sessionUsageUpdated()).isEmpty
        assertThat(serverEvent.sessionClosed()).isEmpty
        assertThat(serverEvent.errorEvent()).isEmpty
        assertThat(serverEvent.infoEvent()).isEmpty
        assertThat(serverEvent.transportDtmfReceived()).isEmpty
        assertThat(serverEvent.transportDtmfSend()).isEmpty
        assertThat(serverEvent.transportRinging()).isEmpty
        assertThat(serverEvent.transportAnswered()).isEmpty
        assertThat(serverEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionOutputAudioDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val serverEvent =
            ServerEvent.ofSessionOutputAudioDelta(
                OutputAudioDeltaEvent.builder()
                    .delta("AACAAIAAAIAAAP9/AIAAgA==")
                    .endMs(1200L)
                    .startMs(1000L)
                    .build()
            )

        val roundtrippedServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(serverEvent),
                jacksonTypeRef<ServerEvent>(),
            )

        assertThat(roundtrippedServerEvent).isEqualTo(serverEvent)
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

        val serverEvent = ServerEvent.ofSessionInputTranscriptDelta(sessionInputTranscriptDelta)

        assertThat(serverEvent.sessionStarted()).isEmpty
        assertThat(serverEvent.sessionUpdated()).isEmpty
        assertThat(serverEvent.sessionInputAudioMuted()).isEmpty
        assertThat(serverEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(serverEvent.sessionInstructionsAppended()).isEmpty
        assertThat(serverEvent.sessionThinkingAppended()).isEmpty
        assertThat(serverEvent.sessionCommentaryAppended()).isEmpty
        assertThat(serverEvent.sessionInputAudioAppend()).isEmpty
        assertThat(serverEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(serverEvent.sessionInputTranscriptDelta()).contains(sessionInputTranscriptDelta)
        assertThat(serverEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionDelegationCreated()).isEmpty
        assertThat(serverEvent.responseEvent()).isEmpty
        assertThat(serverEvent.sessionUsageUpdated()).isEmpty
        assertThat(serverEvent.sessionClosed()).isEmpty
        assertThat(serverEvent.errorEvent()).isEmpty
        assertThat(serverEvent.infoEvent()).isEmpty
        assertThat(serverEvent.transportDtmfReceived()).isEmpty
        assertThat(serverEvent.transportDtmfSend()).isEmpty
        assertThat(serverEvent.transportRinging()).isEmpty
        assertThat(serverEvent.transportAnswered()).isEmpty
        assertThat(serverEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionInputTranscriptDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val serverEvent =
            ServerEvent.ofSessionInputTranscriptDelta(
                InputTranscriptDeltaEvent.builder()
                    .delta("A table for two at seven, please.")
                    .endMs(3400L)
                    .eventId("evt_input_transcript_001")
                    .startMs(1600L)
                    .clientEventId("client_event_id")
                    .build()
            )

        val roundtrippedServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(serverEvent),
                jacksonTypeRef<ServerEvent>(),
            )

        assertThat(roundtrippedServerEvent).isEqualTo(serverEvent)
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

        val serverEvent = ServerEvent.ofSessionOutputTranscriptDelta(sessionOutputTranscriptDelta)

        assertThat(serverEvent.sessionStarted()).isEmpty
        assertThat(serverEvent.sessionUpdated()).isEmpty
        assertThat(serverEvent.sessionInputAudioMuted()).isEmpty
        assertThat(serverEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(serverEvent.sessionInstructionsAppended()).isEmpty
        assertThat(serverEvent.sessionThinkingAppended()).isEmpty
        assertThat(serverEvent.sessionCommentaryAppended()).isEmpty
        assertThat(serverEvent.sessionInputAudioAppend()).isEmpty
        assertThat(serverEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(serverEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionOutputTranscriptDelta())
            .contains(sessionOutputTranscriptDelta)
        assertThat(serverEvent.sessionDelegationCreated()).isEmpty
        assertThat(serverEvent.responseEvent()).isEmpty
        assertThat(serverEvent.sessionUsageUpdated()).isEmpty
        assertThat(serverEvent.sessionClosed()).isEmpty
        assertThat(serverEvent.errorEvent()).isEmpty
        assertThat(serverEvent.infoEvent()).isEmpty
        assertThat(serverEvent.transportDtmfReceived()).isEmpty
        assertThat(serverEvent.transportDtmfSend()).isEmpty
        assertThat(serverEvent.transportRinging()).isEmpty
        assertThat(serverEvent.transportAnswered()).isEmpty
        assertThat(serverEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionOutputTranscriptDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val serverEvent =
            ServerEvent.ofSessionOutputTranscriptDelta(
                OutputTranscriptDeltaEvent.builder()
                    .delta("Would you like me to reserve that table?")
                    .endMs(7200L)
                    .eventId("evt_output_transcript_001")
                    .startMs(5400L)
                    .clientEventId("client_event_id")
                    .build()
            )

        val roundtrippedServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(serverEvent),
                jacksonTypeRef<ServerEvent>(),
            )

        assertThat(roundtrippedServerEvent).isEqualTo(serverEvent)
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

        val serverEvent = ServerEvent.ofSessionDelegationCreated(sessionDelegationCreated)

        assertThat(serverEvent.sessionStarted()).isEmpty
        assertThat(serverEvent.sessionUpdated()).isEmpty
        assertThat(serverEvent.sessionInputAudioMuted()).isEmpty
        assertThat(serverEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(serverEvent.sessionInstructionsAppended()).isEmpty
        assertThat(serverEvent.sessionThinkingAppended()).isEmpty
        assertThat(serverEvent.sessionCommentaryAppended()).isEmpty
        assertThat(serverEvent.sessionInputAudioAppend()).isEmpty
        assertThat(serverEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(serverEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionDelegationCreated()).contains(sessionDelegationCreated)
        assertThat(serverEvent.responseEvent()).isEmpty
        assertThat(serverEvent.sessionUsageUpdated()).isEmpty
        assertThat(serverEvent.sessionClosed()).isEmpty
        assertThat(serverEvent.errorEvent()).isEmpty
        assertThat(serverEvent.infoEvent()).isEmpty
        assertThat(serverEvent.transportDtmfReceived()).isEmpty
        assertThat(serverEvent.transportDtmfSend()).isEmpty
        assertThat(serverEvent.transportRinging()).isEmpty
        assertThat(serverEvent.transportAnswered()).isEmpty
        assertThat(serverEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionDelegationCreatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val serverEvent =
            ServerEvent.ofSessionDelegationCreated(
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

        val roundtrippedServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(serverEvent),
                jacksonTypeRef<ServerEvent>(),
            )

        assertThat(roundtrippedServerEvent).isEqualTo(serverEvent)
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

        val serverEvent = ServerEvent.ofResponseEvent(responseEvent)

        assertThat(serverEvent.sessionStarted()).isEmpty
        assertThat(serverEvent.sessionUpdated()).isEmpty
        assertThat(serverEvent.sessionInputAudioMuted()).isEmpty
        assertThat(serverEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(serverEvent.sessionInstructionsAppended()).isEmpty
        assertThat(serverEvent.sessionThinkingAppended()).isEmpty
        assertThat(serverEvent.sessionCommentaryAppended()).isEmpty
        assertThat(serverEvent.sessionInputAudioAppend()).isEmpty
        assertThat(serverEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(serverEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionDelegationCreated()).isEmpty
        assertThat(serverEvent.responseEvent()).contains(responseEvent)
        assertThat(serverEvent.sessionUsageUpdated()).isEmpty
        assertThat(serverEvent.sessionClosed()).isEmpty
        assertThat(serverEvent.errorEvent()).isEmpty
        assertThat(serverEvent.infoEvent()).isEmpty
        assertThat(serverEvent.transportDtmfReceived()).isEmpty
        assertThat(serverEvent.transportDtmfSend()).isEmpty
        assertThat(serverEvent.transportRinging()).isEmpty
        assertThat(serverEvent.transportAnswered()).isEmpty
        assertThat(serverEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofResponseEventRoundtrip() {
        val jsonMapper = jsonMapper()
        val serverEvent =
            ServerEvent.ofResponseEvent(
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

        val roundtrippedServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(serverEvent),
                jacksonTypeRef<ServerEvent>(),
            )

        assertThat(roundtrippedServerEvent).isEqualTo(serverEvent)
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

        val serverEvent = ServerEvent.ofSessionUsageUpdated(sessionUsageUpdated)

        assertThat(serverEvent.sessionStarted()).isEmpty
        assertThat(serverEvent.sessionUpdated()).isEmpty
        assertThat(serverEvent.sessionInputAudioMuted()).isEmpty
        assertThat(serverEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(serverEvent.sessionInstructionsAppended()).isEmpty
        assertThat(serverEvent.sessionThinkingAppended()).isEmpty
        assertThat(serverEvent.sessionCommentaryAppended()).isEmpty
        assertThat(serverEvent.sessionInputAudioAppend()).isEmpty
        assertThat(serverEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(serverEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionDelegationCreated()).isEmpty
        assertThat(serverEvent.responseEvent()).isEmpty
        assertThat(serverEvent.sessionUsageUpdated()).contains(sessionUsageUpdated)
        assertThat(serverEvent.sessionClosed()).isEmpty
        assertThat(serverEvent.errorEvent()).isEmpty
        assertThat(serverEvent.infoEvent()).isEmpty
        assertThat(serverEvent.transportDtmfReceived()).isEmpty
        assertThat(serverEvent.transportDtmfSend()).isEmpty
        assertThat(serverEvent.transportRinging()).isEmpty
        assertThat(serverEvent.transportAnswered()).isEmpty
        assertThat(serverEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionUsageUpdatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val serverEvent =
            ServerEvent.ofSessionUsageUpdated(
                SessionUsageUpdatedEvent.builder()
                    .eventId("evt_usage_001")
                    .usage(SessionUsage.builder().seconds(32.5).build())
                    .clientEventId("client_event_id")
                    .contextWindow(
                        SessionUsageUpdatedEvent.ContextWindow.builder().usageRatio(0.12).build()
                    )
                    .build()
            )

        val roundtrippedServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(serverEvent),
                jacksonTypeRef<ServerEvent>(),
            )

        assertThat(roundtrippedServerEvent).isEqualTo(serverEvent)
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
                                    SessionResource.Audio.Output.builder()
                                        .voice(BuiltInVoice.MARIN)
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

        val serverEvent = ServerEvent.ofSessionClosed(sessionClosed)

        assertThat(serverEvent.sessionStarted()).isEmpty
        assertThat(serverEvent.sessionUpdated()).isEmpty
        assertThat(serverEvent.sessionInputAudioMuted()).isEmpty
        assertThat(serverEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(serverEvent.sessionInstructionsAppended()).isEmpty
        assertThat(serverEvent.sessionThinkingAppended()).isEmpty
        assertThat(serverEvent.sessionCommentaryAppended()).isEmpty
        assertThat(serverEvent.sessionInputAudioAppend()).isEmpty
        assertThat(serverEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(serverEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionDelegationCreated()).isEmpty
        assertThat(serverEvent.responseEvent()).isEmpty
        assertThat(serverEvent.sessionUsageUpdated()).isEmpty
        assertThat(serverEvent.sessionClosed()).contains(sessionClosed)
        assertThat(serverEvent.errorEvent()).isEmpty
        assertThat(serverEvent.infoEvent()).isEmpty
        assertThat(serverEvent.transportDtmfReceived()).isEmpty
        assertThat(serverEvent.transportDtmfSend()).isEmpty
        assertThat(serverEvent.transportRinging()).isEmpty
        assertThat(serverEvent.transportAnswered()).isEmpty
        assertThat(serverEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionClosedRoundtrip() {
        val jsonMapper = jsonMapper()
        val serverEvent =
            ServerEvent.ofSessionClosed(
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
                                            .voice(BuiltInVoice.MARIN)
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

        val roundtrippedServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(serverEvent),
                jacksonTypeRef<ServerEvent>(),
            )

        assertThat(roundtrippedServerEvent).isEqualTo(serverEvent)
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

        val serverEvent = ServerEvent.ofErrorEvent(errorEvent)

        assertThat(serverEvent.sessionStarted()).isEmpty
        assertThat(serverEvent.sessionUpdated()).isEmpty
        assertThat(serverEvent.sessionInputAudioMuted()).isEmpty
        assertThat(serverEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(serverEvent.sessionInstructionsAppended()).isEmpty
        assertThat(serverEvent.sessionThinkingAppended()).isEmpty
        assertThat(serverEvent.sessionCommentaryAppended()).isEmpty
        assertThat(serverEvent.sessionInputAudioAppend()).isEmpty
        assertThat(serverEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(serverEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionDelegationCreated()).isEmpty
        assertThat(serverEvent.responseEvent()).isEmpty
        assertThat(serverEvent.sessionUsageUpdated()).isEmpty
        assertThat(serverEvent.sessionClosed()).isEmpty
        assertThat(serverEvent.errorEvent()).contains(errorEvent)
        assertThat(serverEvent.infoEvent()).isEmpty
        assertThat(serverEvent.transportDtmfReceived()).isEmpty
        assertThat(serverEvent.transportDtmfSend()).isEmpty
        assertThat(serverEvent.transportRinging()).isEmpty
        assertThat(serverEvent.transportAnswered()).isEmpty
        assertThat(serverEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofErrorEventRoundtrip() {
        val jsonMapper = jsonMapper()
        val serverEvent =
            ServerEvent.ofErrorEvent(
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

        val roundtrippedServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(serverEvent),
                jacksonTypeRef<ServerEvent>(),
            )

        assertThat(roundtrippedServerEvent).isEqualTo(serverEvent)
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

        val serverEvent = ServerEvent.ofInfoEvent(infoEvent)

        assertThat(serverEvent.sessionStarted()).isEmpty
        assertThat(serverEvent.sessionUpdated()).isEmpty
        assertThat(serverEvent.sessionInputAudioMuted()).isEmpty
        assertThat(serverEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(serverEvent.sessionInstructionsAppended()).isEmpty
        assertThat(serverEvent.sessionThinkingAppended()).isEmpty
        assertThat(serverEvent.sessionCommentaryAppended()).isEmpty
        assertThat(serverEvent.sessionInputAudioAppend()).isEmpty
        assertThat(serverEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(serverEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionDelegationCreated()).isEmpty
        assertThat(serverEvent.responseEvent()).isEmpty
        assertThat(serverEvent.sessionUsageUpdated()).isEmpty
        assertThat(serverEvent.sessionClosed()).isEmpty
        assertThat(serverEvent.errorEvent()).isEmpty
        assertThat(serverEvent.infoEvent()).contains(infoEvent)
        assertThat(serverEvent.transportDtmfReceived()).isEmpty
        assertThat(serverEvent.transportDtmfSend()).isEmpty
        assertThat(serverEvent.transportRinging()).isEmpty
        assertThat(serverEvent.transportAnswered()).isEmpty
        assertThat(serverEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofInfoEventRoundtrip() {
        val jsonMapper = jsonMapper()
        val serverEvent =
            ServerEvent.ofInfoEvent(
                InfoEvent.builder()
                    .code("data_channel_permissions")
                    .eventId("evt_info_001")
                    .message(
                        "The frontend data channel is configured with restricted event permissions."
                    )
                    .clientEventId("client_event_id")
                    .build()
            )

        val roundtrippedServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(serverEvent),
                jacksonTypeRef<ServerEvent>(),
            )

        assertThat(roundtrippedServerEvent).isEqualTo(serverEvent)
    }

    @Test
    fun ofTransportDtmfReceived() {
        val transportDtmfReceived =
            ServerEvent.TransportDtmfReceived.builder().event("#").eventId("event_id").build()

        val serverEvent = ServerEvent.ofTransportDtmfReceived(transportDtmfReceived)

        assertThat(serverEvent.sessionStarted()).isEmpty
        assertThat(serverEvent.sessionUpdated()).isEmpty
        assertThat(serverEvent.sessionInputAudioMuted()).isEmpty
        assertThat(serverEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(serverEvent.sessionInstructionsAppended()).isEmpty
        assertThat(serverEvent.sessionThinkingAppended()).isEmpty
        assertThat(serverEvent.sessionCommentaryAppended()).isEmpty
        assertThat(serverEvent.sessionInputAudioAppend()).isEmpty
        assertThat(serverEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(serverEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionDelegationCreated()).isEmpty
        assertThat(serverEvent.responseEvent()).isEmpty
        assertThat(serverEvent.sessionUsageUpdated()).isEmpty
        assertThat(serverEvent.sessionClosed()).isEmpty
        assertThat(serverEvent.errorEvent()).isEmpty
        assertThat(serverEvent.infoEvent()).isEmpty
        assertThat(serverEvent.transportDtmfReceived()).contains(transportDtmfReceived)
        assertThat(serverEvent.transportDtmfSend()).isEmpty
        assertThat(serverEvent.transportRinging()).isEmpty
        assertThat(serverEvent.transportAnswered()).isEmpty
        assertThat(serverEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofTransportDtmfReceivedRoundtrip() {
        val jsonMapper = jsonMapper()
        val serverEvent =
            ServerEvent.ofTransportDtmfReceived(
                ServerEvent.TransportDtmfReceived.builder().event("#").eventId("event_id").build()
            )

        val roundtrippedServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(serverEvent),
                jacksonTypeRef<ServerEvent>(),
            )

        assertThat(roundtrippedServerEvent).isEqualTo(serverEvent)
    }

    @Test
    fun ofTransportDtmfSend() {
        val transportDtmfSend =
            ServerEvent.TransportDtmfSend.builder().event("#").eventId("event_id").build()

        val serverEvent = ServerEvent.ofTransportDtmfSend(transportDtmfSend)

        assertThat(serverEvent.sessionStarted()).isEmpty
        assertThat(serverEvent.sessionUpdated()).isEmpty
        assertThat(serverEvent.sessionInputAudioMuted()).isEmpty
        assertThat(serverEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(serverEvent.sessionInstructionsAppended()).isEmpty
        assertThat(serverEvent.sessionThinkingAppended()).isEmpty
        assertThat(serverEvent.sessionCommentaryAppended()).isEmpty
        assertThat(serverEvent.sessionInputAudioAppend()).isEmpty
        assertThat(serverEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(serverEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionDelegationCreated()).isEmpty
        assertThat(serverEvent.responseEvent()).isEmpty
        assertThat(serverEvent.sessionUsageUpdated()).isEmpty
        assertThat(serverEvent.sessionClosed()).isEmpty
        assertThat(serverEvent.errorEvent()).isEmpty
        assertThat(serverEvent.infoEvent()).isEmpty
        assertThat(serverEvent.transportDtmfReceived()).isEmpty
        assertThat(serverEvent.transportDtmfSend()).contains(transportDtmfSend)
        assertThat(serverEvent.transportRinging()).isEmpty
        assertThat(serverEvent.transportAnswered()).isEmpty
        assertThat(serverEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofTransportDtmfSendRoundtrip() {
        val jsonMapper = jsonMapper()
        val serverEvent =
            ServerEvent.ofTransportDtmfSend(
                ServerEvent.TransportDtmfSend.builder().event("#").eventId("event_id").build()
            )

        val roundtrippedServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(serverEvent),
                jacksonTypeRef<ServerEvent>(),
            )

        assertThat(roundtrippedServerEvent).isEqualTo(serverEvent)
    }

    @Test
    fun ofTransportRinging() {
        val transportRinging =
            ServerEvent.TransportRinging.builder()
                .eventId("event_id")
                .sessionId("session_id")
                .build()

        val serverEvent = ServerEvent.ofTransportRinging(transportRinging)

        assertThat(serverEvent.sessionStarted()).isEmpty
        assertThat(serverEvent.sessionUpdated()).isEmpty
        assertThat(serverEvent.sessionInputAudioMuted()).isEmpty
        assertThat(serverEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(serverEvent.sessionInstructionsAppended()).isEmpty
        assertThat(serverEvent.sessionThinkingAppended()).isEmpty
        assertThat(serverEvent.sessionCommentaryAppended()).isEmpty
        assertThat(serverEvent.sessionInputAudioAppend()).isEmpty
        assertThat(serverEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(serverEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionDelegationCreated()).isEmpty
        assertThat(serverEvent.responseEvent()).isEmpty
        assertThat(serverEvent.sessionUsageUpdated()).isEmpty
        assertThat(serverEvent.sessionClosed()).isEmpty
        assertThat(serverEvent.errorEvent()).isEmpty
        assertThat(serverEvent.infoEvent()).isEmpty
        assertThat(serverEvent.transportDtmfReceived()).isEmpty
        assertThat(serverEvent.transportDtmfSend()).isEmpty
        assertThat(serverEvent.transportRinging()).contains(transportRinging)
        assertThat(serverEvent.transportAnswered()).isEmpty
        assertThat(serverEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofTransportRingingRoundtrip() {
        val jsonMapper = jsonMapper()
        val serverEvent =
            ServerEvent.ofTransportRinging(
                ServerEvent.TransportRinging.builder()
                    .eventId("event_id")
                    .sessionId("session_id")
                    .build()
            )

        val roundtrippedServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(serverEvent),
                jacksonTypeRef<ServerEvent>(),
            )

        assertThat(roundtrippedServerEvent).isEqualTo(serverEvent)
    }

    @Test
    fun ofTransportAnswered() {
        val transportAnswered =
            ServerEvent.TransportAnswered.builder()
                .eventId("event_id")
                .sessionId("session_id")
                .build()

        val serverEvent = ServerEvent.ofTransportAnswered(transportAnswered)

        assertThat(serverEvent.sessionStarted()).isEmpty
        assertThat(serverEvent.sessionUpdated()).isEmpty
        assertThat(serverEvent.sessionInputAudioMuted()).isEmpty
        assertThat(serverEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(serverEvent.sessionInstructionsAppended()).isEmpty
        assertThat(serverEvent.sessionThinkingAppended()).isEmpty
        assertThat(serverEvent.sessionCommentaryAppended()).isEmpty
        assertThat(serverEvent.sessionInputAudioAppend()).isEmpty
        assertThat(serverEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(serverEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionDelegationCreated()).isEmpty
        assertThat(serverEvent.responseEvent()).isEmpty
        assertThat(serverEvent.sessionUsageUpdated()).isEmpty
        assertThat(serverEvent.sessionClosed()).isEmpty
        assertThat(serverEvent.errorEvent()).isEmpty
        assertThat(serverEvent.infoEvent()).isEmpty
        assertThat(serverEvent.transportDtmfReceived()).isEmpty
        assertThat(serverEvent.transportDtmfSend()).isEmpty
        assertThat(serverEvent.transportRinging()).isEmpty
        assertThat(serverEvent.transportAnswered()).contains(transportAnswered)
        assertThat(serverEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofTransportAnsweredRoundtrip() {
        val jsonMapper = jsonMapper()
        val serverEvent =
            ServerEvent.ofTransportAnswered(
                ServerEvent.TransportAnswered.builder()
                    .eventId("event_id")
                    .sessionId("session_id")
                    .build()
            )

        val roundtrippedServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(serverEvent),
                jacksonTypeRef<ServerEvent>(),
            )

        assertThat(roundtrippedServerEvent).isEqualTo(serverEvent)
    }

    @Test
    fun ofTransportFailed() {
        val transportFailed =
            ServerEvent.TransportFailed.builder()
                .error(
                    ServerEvent.TransportFailed.Error.builder()
                        .code("code")
                        .message("message")
                        .param("param")
                        .build()
                )
                .eventId("event_id")
                .sessionId("session_id")
                .build()

        val serverEvent = ServerEvent.ofTransportFailed(transportFailed)

        assertThat(serverEvent.sessionStarted()).isEmpty
        assertThat(serverEvent.sessionUpdated()).isEmpty
        assertThat(serverEvent.sessionInputAudioMuted()).isEmpty
        assertThat(serverEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(serverEvent.sessionInstructionsAppended()).isEmpty
        assertThat(serverEvent.sessionThinkingAppended()).isEmpty
        assertThat(serverEvent.sessionCommentaryAppended()).isEmpty
        assertThat(serverEvent.sessionInputAudioAppend()).isEmpty
        assertThat(serverEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(serverEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(serverEvent.sessionDelegationCreated()).isEmpty
        assertThat(serverEvent.responseEvent()).isEmpty
        assertThat(serverEvent.sessionUsageUpdated()).isEmpty
        assertThat(serverEvent.sessionClosed()).isEmpty
        assertThat(serverEvent.errorEvent()).isEmpty
        assertThat(serverEvent.infoEvent()).isEmpty
        assertThat(serverEvent.transportDtmfReceived()).isEmpty
        assertThat(serverEvent.transportDtmfSend()).isEmpty
        assertThat(serverEvent.transportRinging()).isEmpty
        assertThat(serverEvent.transportAnswered()).isEmpty
        assertThat(serverEvent.transportFailed()).contains(transportFailed)
    }

    @Test
    fun ofTransportFailedRoundtrip() {
        val jsonMapper = jsonMapper()
        val serverEvent =
            ServerEvent.ofTransportFailed(
                ServerEvent.TransportFailed.builder()
                    .error(
                        ServerEvent.TransportFailed.Error.builder()
                            .code("code")
                            .message("message")
                            .param("param")
                            .build()
                    )
                    .eventId("event_id")
                    .sessionId("session_id")
                    .build()
            )

        val roundtrippedServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(serverEvent),
                jacksonTypeRef<ServerEvent>(),
            )

        assertThat(roundtrippedServerEvent).isEqualTo(serverEvent)
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
        val serverEvent = jsonMapper().convertValue(testCase.value, jacksonTypeRef<ServerEvent>())

        val e = assertThrows<OpenAIInvalidDataException> { serverEvent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
