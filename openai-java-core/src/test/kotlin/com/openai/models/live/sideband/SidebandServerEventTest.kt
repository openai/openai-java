// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live.sideband

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.decisions.Decision
import com.openai.models.live.AudioFormat
import com.openai.models.live.BuiltInVoice
import com.openai.models.live.ClientConfig
import com.openai.models.live.ClientDelegation
import com.openai.models.live.CommentaryAppendedEvent
import com.openai.models.live.DataChannelConfig
import com.openai.models.live.DecisionEvent
import com.openai.models.live.DecisionItemCreatedEvent
import com.openai.models.live.DecisionItemDeletedEvent
import com.openai.models.live.DecisionTrigger
import com.openai.models.live.DelegationCreatedEvent
import com.openai.models.live.Error
import com.openai.models.live.ErrorEvent
import com.openai.models.live.InfoEvent
import com.openai.models.live.InputAudioMutedEvent
import com.openai.models.live.InputAudioUnmutedEvent
import com.openai.models.live.InputTranscriptDeltaEvent
import com.openai.models.live.InstructionsAppendedEvent
import com.openai.models.live.OutputAudioDeltaEvent
import com.openai.models.live.OutputAudioFixturePlayedEvent
import com.openai.models.live.OutputAudioFixturePlayingEvent
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

internal class SidebandServerEventTest {

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
                        .addTrigger(
                            DecisionTrigger.builder()
                                .decisions(
                                    DecisionTrigger.Decisions.builder()
                                        .addQuestion(
                                            DecisionTrigger.Decisions.Question.Predicate.builder()
                                                .instructions("instructions")
                                                .name("name")
                                                .build()
                                        )
                                        .build()
                                )
                                .eventType(DecisionTrigger.EventType.SESSION_INPUT_TRANSCRIPT_DELTA)
                                .build()
                        )
                        .build()
                )
                .clientEventId("evt_start_001")
                .build()

        val sidebandServerEvent = SidebandServerEvent.ofSessionStarted(sessionStarted)

        assertThat(sidebandServerEvent.sessionStarted()).contains(sessionStarted)
        assertThat(sidebandServerEvent.sessionUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlaying()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlayed()).isEmpty
        assertThat(sidebandServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionEvent()).isEmpty
        assertThat(sidebandServerEvent.decisionItemCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionItemDeleted()).isEmpty
        assertThat(sidebandServerEvent.responseEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionClosed()).isEmpty
        assertThat(sidebandServerEvent.errorEvent()).isEmpty
        assertThat(sidebandServerEvent.infoEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfReceived()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfSend()).isEmpty
        assertThat(sidebandServerEvent.transportRinging()).isEmpty
        assertThat(sidebandServerEvent.transportAnswered()).isEmpty
        assertThat(sidebandServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionStartedRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandServerEvent =
            SidebandServerEvent.ofSessionStarted(
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
                            .addTrigger(
                                DecisionTrigger.builder()
                                    .decisions(
                                        DecisionTrigger.Decisions.builder()
                                            .addQuestion(
                                                DecisionTrigger.Decisions.Question.Predicate
                                                    .builder()
                                                    .instructions("instructions")
                                                    .name("name")
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .eventType(
                                        DecisionTrigger.EventType.SESSION_INPUT_TRANSCRIPT_DELTA
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .clientEventId("evt_start_001")
                    .build()
            )

        val roundtrippedSidebandServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandServerEvent),
                jacksonTypeRef<SidebandServerEvent>(),
            )

        assertThat(roundtrippedSidebandServerEvent).isEqualTo(sidebandServerEvent)
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
                        .addTrigger(
                            DecisionTrigger.builder()
                                .decisions(
                                    DecisionTrigger.Decisions.builder()
                                        .addQuestion(
                                            DecisionTrigger.Decisions.Question.Predicate.builder()
                                                .instructions("instructions")
                                                .name("name")
                                                .build()
                                        )
                                        .build()
                                )
                                .eventType(DecisionTrigger.EventType.SESSION_INPUT_TRANSCRIPT_DELTA)
                                .build()
                        )
                        .build()
                )
                .clientEventId("evt_update_001")
                .build()

        val sidebandServerEvent = SidebandServerEvent.ofSessionUpdated(sessionUpdated)

        assertThat(sidebandServerEvent.sessionStarted()).isEmpty
        assertThat(sidebandServerEvent.sessionUpdated()).contains(sessionUpdated)
        assertThat(sidebandServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlaying()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlayed()).isEmpty
        assertThat(sidebandServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionEvent()).isEmpty
        assertThat(sidebandServerEvent.decisionItemCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionItemDeleted()).isEmpty
        assertThat(sidebandServerEvent.responseEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionClosed()).isEmpty
        assertThat(sidebandServerEvent.errorEvent()).isEmpty
        assertThat(sidebandServerEvent.infoEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfReceived()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfSend()).isEmpty
        assertThat(sidebandServerEvent.transportRinging()).isEmpty
        assertThat(sidebandServerEvent.transportAnswered()).isEmpty
        assertThat(sidebandServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionUpdatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandServerEvent =
            SidebandServerEvent.ofSessionUpdated(
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
                            .addTrigger(
                                DecisionTrigger.builder()
                                    .decisions(
                                        DecisionTrigger.Decisions.builder()
                                            .addQuestion(
                                                DecisionTrigger.Decisions.Question.Predicate
                                                    .builder()
                                                    .instructions("instructions")
                                                    .name("name")
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .eventType(
                                        DecisionTrigger.EventType.SESSION_INPUT_TRANSCRIPT_DELTA
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .clientEventId("evt_update_001")
                    .build()
            )

        val roundtrippedSidebandServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandServerEvent),
                jacksonTypeRef<SidebandServerEvent>(),
            )

        assertThat(roundtrippedSidebandServerEvent).isEqualTo(sidebandServerEvent)
    }

    @Test
    fun ofSessionInputAudioMuted() {
        val sessionInputAudioMuted =
            InputAudioMutedEvent.builder()
                .eventId("evt_muted_001")
                .clientEventId("evt_mute_001")
                .build()

        val sidebandServerEvent =
            SidebandServerEvent.ofSessionInputAudioMuted(sessionInputAudioMuted)

        assertThat(sidebandServerEvent.sessionStarted()).isEmpty
        assertThat(sidebandServerEvent.sessionUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioMuted()).contains(sessionInputAudioMuted)
        assertThat(sidebandServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlaying()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlayed()).isEmpty
        assertThat(sidebandServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionEvent()).isEmpty
        assertThat(sidebandServerEvent.decisionItemCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionItemDeleted()).isEmpty
        assertThat(sidebandServerEvent.responseEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionClosed()).isEmpty
        assertThat(sidebandServerEvent.errorEvent()).isEmpty
        assertThat(sidebandServerEvent.infoEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfReceived()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfSend()).isEmpty
        assertThat(sidebandServerEvent.transportRinging()).isEmpty
        assertThat(sidebandServerEvent.transportAnswered()).isEmpty
        assertThat(sidebandServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionInputAudioMutedRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandServerEvent =
            SidebandServerEvent.ofSessionInputAudioMuted(
                InputAudioMutedEvent.builder()
                    .eventId("evt_muted_001")
                    .clientEventId("evt_mute_001")
                    .build()
            )

        val roundtrippedSidebandServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandServerEvent),
                jacksonTypeRef<SidebandServerEvent>(),
            )

        assertThat(roundtrippedSidebandServerEvent).isEqualTo(sidebandServerEvent)
    }

    @Test
    fun ofSessionInputAudioUnmuted() {
        val sessionInputAudioUnmuted =
            InputAudioUnmutedEvent.builder()
                .eventId("evt_unmuted_001")
                .clientEventId("evt_unmute_001")
                .build()

        val sidebandServerEvent =
            SidebandServerEvent.ofSessionInputAudioUnmuted(sessionInputAudioUnmuted)

        assertThat(sidebandServerEvent.sessionStarted()).isEmpty
        assertThat(sidebandServerEvent.sessionUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioUnmuted())
            .contains(sessionInputAudioUnmuted)
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlaying()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlayed()).isEmpty
        assertThat(sidebandServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionEvent()).isEmpty
        assertThat(sidebandServerEvent.decisionItemCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionItemDeleted()).isEmpty
        assertThat(sidebandServerEvent.responseEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionClosed()).isEmpty
        assertThat(sidebandServerEvent.errorEvent()).isEmpty
        assertThat(sidebandServerEvent.infoEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfReceived()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfSend()).isEmpty
        assertThat(sidebandServerEvent.transportRinging()).isEmpty
        assertThat(sidebandServerEvent.transportAnswered()).isEmpty
        assertThat(sidebandServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionInputAudioUnmutedRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandServerEvent =
            SidebandServerEvent.ofSessionInputAudioUnmuted(
                InputAudioUnmutedEvent.builder()
                    .eventId("evt_unmuted_001")
                    .clientEventId("evt_unmute_001")
                    .build()
            )

        val roundtrippedSidebandServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandServerEvent),
                jacksonTypeRef<SidebandServerEvent>(),
            )

        assertThat(roundtrippedSidebandServerEvent).isEqualTo(sidebandServerEvent)
    }

    @Test
    fun ofSessionOutputAudioFixturePlaying() {
        val sessionOutputAudioFixturePlaying =
            OutputAudioFixturePlayingEvent.builder()
                .eventId("evt_playing_001")
                .clientEventId("evt_play_001")
                .build()

        val sidebandServerEvent =
            SidebandServerEvent.ofSessionOutputAudioFixturePlaying(sessionOutputAudioFixturePlaying)

        assertThat(sidebandServerEvent.sessionStarted()).isEmpty
        assertThat(sidebandServerEvent.sessionUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlaying())
            .contains(sessionOutputAudioFixturePlaying)
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlayed()).isEmpty
        assertThat(sidebandServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionEvent()).isEmpty
        assertThat(sidebandServerEvent.decisionItemCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionItemDeleted()).isEmpty
        assertThat(sidebandServerEvent.responseEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionClosed()).isEmpty
        assertThat(sidebandServerEvent.errorEvent()).isEmpty
        assertThat(sidebandServerEvent.infoEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfReceived()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfSend()).isEmpty
        assertThat(sidebandServerEvent.transportRinging()).isEmpty
        assertThat(sidebandServerEvent.transportAnswered()).isEmpty
        assertThat(sidebandServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionOutputAudioFixturePlayingRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandServerEvent =
            SidebandServerEvent.ofSessionOutputAudioFixturePlaying(
                OutputAudioFixturePlayingEvent.builder()
                    .eventId("evt_playing_001")
                    .clientEventId("evt_play_001")
                    .build()
            )

        val roundtrippedSidebandServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandServerEvent),
                jacksonTypeRef<SidebandServerEvent>(),
            )

        assertThat(roundtrippedSidebandServerEvent).isEqualTo(sidebandServerEvent)
    }

    @Test
    fun ofSessionOutputAudioFixturePlayed() {
        val sessionOutputAudioFixturePlayed =
            OutputAudioFixturePlayedEvent.builder()
                .eventId("evt_played_001")
                .clientEventId("evt_play_001")
                .build()

        val sidebandServerEvent =
            SidebandServerEvent.ofSessionOutputAudioFixturePlayed(sessionOutputAudioFixturePlayed)

        assertThat(sidebandServerEvent.sessionStarted()).isEmpty
        assertThat(sidebandServerEvent.sessionUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlaying()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlayed())
            .contains(sessionOutputAudioFixturePlayed)
        assertThat(sidebandServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionEvent()).isEmpty
        assertThat(sidebandServerEvent.decisionItemCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionItemDeleted()).isEmpty
        assertThat(sidebandServerEvent.responseEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionClosed()).isEmpty
        assertThat(sidebandServerEvent.errorEvent()).isEmpty
        assertThat(sidebandServerEvent.infoEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfReceived()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfSend()).isEmpty
        assertThat(sidebandServerEvent.transportRinging()).isEmpty
        assertThat(sidebandServerEvent.transportAnswered()).isEmpty
        assertThat(sidebandServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionOutputAudioFixturePlayedRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandServerEvent =
            SidebandServerEvent.ofSessionOutputAudioFixturePlayed(
                OutputAudioFixturePlayedEvent.builder()
                    .eventId("evt_played_001")
                    .clientEventId("evt_play_001")
                    .build()
            )

        val roundtrippedSidebandServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandServerEvent),
                jacksonTypeRef<SidebandServerEvent>(),
            )

        assertThat(roundtrippedSidebandServerEvent).isEqualTo(sidebandServerEvent)
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

        val sidebandServerEvent =
            SidebandServerEvent.ofSessionInstructionsAppended(sessionInstructionsAppended)

        assertThat(sidebandServerEvent.sessionStarted()).isEmpty
        assertThat(sidebandServerEvent.sessionUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlaying()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlayed()).isEmpty
        assertThat(sidebandServerEvent.sessionInstructionsAppended())
            .contains(sessionInstructionsAppended)
        assertThat(sidebandServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionEvent()).isEmpty
        assertThat(sidebandServerEvent.decisionItemCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionItemDeleted()).isEmpty
        assertThat(sidebandServerEvent.responseEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionClosed()).isEmpty
        assertThat(sidebandServerEvent.errorEvent()).isEmpty
        assertThat(sidebandServerEvent.infoEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfReceived()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfSend()).isEmpty
        assertThat(sidebandServerEvent.transportRinging()).isEmpty
        assertThat(sidebandServerEvent.transportAnswered()).isEmpty
        assertThat(sidebandServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionInstructionsAppendedRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandServerEvent =
            SidebandServerEvent.ofSessionInstructionsAppended(
                InstructionsAppendedEvent.builder()
                    .endMs(1400L)
                    .eventId("evt_instructions_002")
                    .startMs(1200L)
                    .clientEventId("evt_instructions_001")
                    .build()
            )

        val roundtrippedSidebandServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandServerEvent),
                jacksonTypeRef<SidebandServerEvent>(),
            )

        assertThat(roundtrippedSidebandServerEvent).isEqualTo(sidebandServerEvent)
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

        val sidebandServerEvent =
            SidebandServerEvent.ofSessionThinkingAppended(sessionThinkingAppended)

        assertThat(sidebandServerEvent.sessionStarted()).isEmpty
        assertThat(sidebandServerEvent.sessionUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlaying()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlayed()).isEmpty
        assertThat(sidebandServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionThinkingAppended()).contains(sessionThinkingAppended)
        assertThat(sidebandServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionEvent()).isEmpty
        assertThat(sidebandServerEvent.decisionItemCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionItemDeleted()).isEmpty
        assertThat(sidebandServerEvent.responseEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionClosed()).isEmpty
        assertThat(sidebandServerEvent.errorEvent()).isEmpty
        assertThat(sidebandServerEvent.infoEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfReceived()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfSend()).isEmpty
        assertThat(sidebandServerEvent.transportRinging()).isEmpty
        assertThat(sidebandServerEvent.transportAnswered()).isEmpty
        assertThat(sidebandServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionThinkingAppendedRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandServerEvent =
            SidebandServerEvent.ofSessionThinkingAppended(
                ThinkingAppendedEvent.builder()
                    .endMs(4800L)
                    .eventId("evt_thinking_002")
                    .startMs(4600L)
                    .clientEventId("evt_thinking_001")
                    .build()
            )

        val roundtrippedSidebandServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandServerEvent),
                jacksonTypeRef<SidebandServerEvent>(),
            )

        assertThat(roundtrippedSidebandServerEvent).isEqualTo(sidebandServerEvent)
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

        val sidebandServerEvent =
            SidebandServerEvent.ofSessionCommentaryAppended(sessionCommentaryAppended)

        assertThat(sidebandServerEvent.sessionStarted()).isEmpty
        assertThat(sidebandServerEvent.sessionUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlaying()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlayed()).isEmpty
        assertThat(sidebandServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionCommentaryAppended())
            .contains(sessionCommentaryAppended)
        assertThat(sidebandServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionEvent()).isEmpty
        assertThat(sidebandServerEvent.decisionItemCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionItemDeleted()).isEmpty
        assertThat(sidebandServerEvent.responseEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionClosed()).isEmpty
        assertThat(sidebandServerEvent.errorEvent()).isEmpty
        assertThat(sidebandServerEvent.infoEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfReceived()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfSend()).isEmpty
        assertThat(sidebandServerEvent.transportRinging()).isEmpty
        assertThat(sidebandServerEvent.transportAnswered()).isEmpty
        assertThat(sidebandServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionCommentaryAppendedRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandServerEvent =
            SidebandServerEvent.ofSessionCommentaryAppended(
                CommentaryAppendedEvent.builder()
                    .endMs(5400L)
                    .eventId("evt_commentary_002")
                    .startMs(5200L)
                    .clientEventId("evt_commentary_001")
                    .build()
            )

        val roundtrippedSidebandServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandServerEvent),
                jacksonTypeRef<SidebandServerEvent>(),
            )

        assertThat(roundtrippedSidebandServerEvent).isEqualTo(sidebandServerEvent)
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

        val sidebandServerEvent =
            SidebandServerEvent.ofSessionInputTranscriptDelta(sessionInputTranscriptDelta)

        assertThat(sidebandServerEvent.sessionStarted()).isEmpty
        assertThat(sidebandServerEvent.sessionUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlaying()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlayed()).isEmpty
        assertThat(sidebandServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionInputTranscriptDelta())
            .contains(sessionInputTranscriptDelta)
        assertThat(sidebandServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionEvent()).isEmpty
        assertThat(sidebandServerEvent.decisionItemCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionItemDeleted()).isEmpty
        assertThat(sidebandServerEvent.responseEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionClosed()).isEmpty
        assertThat(sidebandServerEvent.errorEvent()).isEmpty
        assertThat(sidebandServerEvent.infoEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfReceived()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfSend()).isEmpty
        assertThat(sidebandServerEvent.transportRinging()).isEmpty
        assertThat(sidebandServerEvent.transportAnswered()).isEmpty
        assertThat(sidebandServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionInputTranscriptDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandServerEvent =
            SidebandServerEvent.ofSessionInputTranscriptDelta(
                InputTranscriptDeltaEvent.builder()
                    .delta("A table for two at seven, please.")
                    .endMs(3400L)
                    .eventId("evt_input_transcript_001")
                    .startMs(1600L)
                    .clientEventId("client_event_id")
                    .build()
            )

        val roundtrippedSidebandServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandServerEvent),
                jacksonTypeRef<SidebandServerEvent>(),
            )

        assertThat(roundtrippedSidebandServerEvent).isEqualTo(sidebandServerEvent)
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

        val sidebandServerEvent =
            SidebandServerEvent.ofSessionOutputTranscriptDelta(sessionOutputTranscriptDelta)

        assertThat(sidebandServerEvent.sessionStarted()).isEmpty
        assertThat(sidebandServerEvent.sessionUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlaying()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlayed()).isEmpty
        assertThat(sidebandServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputTranscriptDelta())
            .contains(sessionOutputTranscriptDelta)
        assertThat(sidebandServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionEvent()).isEmpty
        assertThat(sidebandServerEvent.decisionItemCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionItemDeleted()).isEmpty
        assertThat(sidebandServerEvent.responseEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionClosed()).isEmpty
        assertThat(sidebandServerEvent.errorEvent()).isEmpty
        assertThat(sidebandServerEvent.infoEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfReceived()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfSend()).isEmpty
        assertThat(sidebandServerEvent.transportRinging()).isEmpty
        assertThat(sidebandServerEvent.transportAnswered()).isEmpty
        assertThat(sidebandServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionOutputTranscriptDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandServerEvent =
            SidebandServerEvent.ofSessionOutputTranscriptDelta(
                OutputTranscriptDeltaEvent.builder()
                    .delta("Would you like me to reserve that table?")
                    .endMs(7200L)
                    .eventId("evt_output_transcript_001")
                    .startMs(5400L)
                    .clientEventId("client_event_id")
                    .build()
            )

        val roundtrippedSidebandServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandServerEvent),
                jacksonTypeRef<SidebandServerEvent>(),
            )

        assertThat(roundtrippedSidebandServerEvent).isEqualTo(sidebandServerEvent)
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

        val sidebandServerEvent =
            SidebandServerEvent.ofSessionDelegationCreated(sessionDelegationCreated)

        assertThat(sidebandServerEvent.sessionStarted()).isEmpty
        assertThat(sidebandServerEvent.sessionUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlaying()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlayed()).isEmpty
        assertThat(sidebandServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionDelegationCreated())
            .contains(sessionDelegationCreated)
        assertThat(sidebandServerEvent.decisionEvent()).isEmpty
        assertThat(sidebandServerEvent.decisionItemCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionItemDeleted()).isEmpty
        assertThat(sidebandServerEvent.responseEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionClosed()).isEmpty
        assertThat(sidebandServerEvent.errorEvent()).isEmpty
        assertThat(sidebandServerEvent.infoEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfReceived()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfSend()).isEmpty
        assertThat(sidebandServerEvent.transportRinging()).isEmpty
        assertThat(sidebandServerEvent.transportAnswered()).isEmpty
        assertThat(sidebandServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionDelegationCreatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandServerEvent =
            SidebandServerEvent.ofSessionDelegationCreated(
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

        val roundtrippedSidebandServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandServerEvent),
                jacksonTypeRef<SidebandServerEvent>(),
            )

        assertThat(roundtrippedSidebandServerEvent).isEqualTo(sidebandServerEvent)
    }

    @Test
    fun ofDecisionEvent() {
        val decisionEvent =
            DecisionEvent.builder()
                .delegationId("del_abc123")
                .event(
                    DecisionEvent.Event.builder()
                        .decision(
                            Decision.builder()
                                .addAnswer(
                                    Decision.Answer.Predicate.builder()
                                        .name("damaged")
                                        .probability(0.95)
                                        .build()
                                )
                                .model("gpt-6-luna")
                                .usage(
                                    Decision.Usage.builder()
                                        .inputTokens(42L)
                                        .inputTokensDetails(
                                            Decision.Usage.InputTokensDetails.builder()
                                                .cacheWriteTokens(0L)
                                                .cachedTokens(0L)
                                                .build()
                                        )
                                        .outputTokens(0L)
                                        .outputTokensDetails(
                                            Decision.Usage.OutputTokensDetails.builder()
                                                .reasoningTokens(0L)
                                                .build()
                                        )
                                        .totalTokens(42L)
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .eventId("evt_decision_1")
                .sourceEventId(null)
                .sourceEventType(null)
                .triggerId(null)
                .build()

        val sidebandServerEvent = SidebandServerEvent.ofDecisionEvent(decisionEvent)

        assertThat(sidebandServerEvent.sessionStarted()).isEmpty
        assertThat(sidebandServerEvent.sessionUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlaying()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlayed()).isEmpty
        assertThat(sidebandServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionEvent()).contains(decisionEvent)
        assertThat(sidebandServerEvent.decisionItemCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionItemDeleted()).isEmpty
        assertThat(sidebandServerEvent.responseEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionClosed()).isEmpty
        assertThat(sidebandServerEvent.errorEvent()).isEmpty
        assertThat(sidebandServerEvent.infoEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfReceived()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfSend()).isEmpty
        assertThat(sidebandServerEvent.transportRinging()).isEmpty
        assertThat(sidebandServerEvent.transportAnswered()).isEmpty
        assertThat(sidebandServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofDecisionEventRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandServerEvent =
            SidebandServerEvent.ofDecisionEvent(
                DecisionEvent.builder()
                    .delegationId("del_abc123")
                    .event(
                        DecisionEvent.Event.builder()
                            .decision(
                                Decision.builder()
                                    .addAnswer(
                                        Decision.Answer.Predicate.builder()
                                            .name("damaged")
                                            .probability(0.95)
                                            .build()
                                    )
                                    .model("gpt-6-luna")
                                    .usage(
                                        Decision.Usage.builder()
                                            .inputTokens(42L)
                                            .inputTokensDetails(
                                                Decision.Usage.InputTokensDetails.builder()
                                                    .cacheWriteTokens(0L)
                                                    .cachedTokens(0L)
                                                    .build()
                                            )
                                            .outputTokens(0L)
                                            .outputTokensDetails(
                                                Decision.Usage.OutputTokensDetails.builder()
                                                    .reasoningTokens(0L)
                                                    .build()
                                            )
                                            .totalTokens(42L)
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .eventId("evt_decision_1")
                    .sourceEventId(null)
                    .sourceEventType(null)
                    .triggerId(null)
                    .build()
            )

        val roundtrippedSidebandServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandServerEvent),
                jacksonTypeRef<SidebandServerEvent>(),
            )

        assertThat(roundtrippedSidebandServerEvent).isEqualTo(sidebandServerEvent)
    }

    @Test
    fun ofDecisionItemCreated() {
        val decisionItemCreated =
            DecisionItemCreatedEvent.builder()
                .eventId("evt_item_1")
                .item(
                    DecisionItemCreatedEvent.Item.builder()
                        .id("msg_browser_1")
                        .content("string")
                        .type(DecisionItemCreatedEvent.Item.Type.MESSAGE)
                        .build()
                )
                .clientEventId("browser_1")
                .build()

        val sidebandServerEvent = SidebandServerEvent.ofDecisionItemCreated(decisionItemCreated)

        assertThat(sidebandServerEvent.sessionStarted()).isEmpty
        assertThat(sidebandServerEvent.sessionUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlaying()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlayed()).isEmpty
        assertThat(sidebandServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionEvent()).isEmpty
        assertThat(sidebandServerEvent.decisionItemCreated()).contains(decisionItemCreated)
        assertThat(sidebandServerEvent.decisionItemDeleted()).isEmpty
        assertThat(sidebandServerEvent.responseEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionClosed()).isEmpty
        assertThat(sidebandServerEvent.errorEvent()).isEmpty
        assertThat(sidebandServerEvent.infoEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfReceived()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfSend()).isEmpty
        assertThat(sidebandServerEvent.transportRinging()).isEmpty
        assertThat(sidebandServerEvent.transportAnswered()).isEmpty
        assertThat(sidebandServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofDecisionItemCreatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandServerEvent =
            SidebandServerEvent.ofDecisionItemCreated(
                DecisionItemCreatedEvent.builder()
                    .eventId("evt_item_1")
                    .item(
                        DecisionItemCreatedEvent.Item.builder()
                            .id("msg_browser_1")
                            .content("string")
                            .type(DecisionItemCreatedEvent.Item.Type.MESSAGE)
                            .build()
                    )
                    .clientEventId("browser_1")
                    .build()
            )

        val roundtrippedSidebandServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandServerEvent),
                jacksonTypeRef<SidebandServerEvent>(),
            )

        assertThat(roundtrippedSidebandServerEvent).isEqualTo(sidebandServerEvent)
    }

    @Test
    fun ofDecisionItemDeleted() {
        val decisionItemDeleted =
            DecisionItemDeletedEvent.builder()
                .eventId("evt_item_deleted_1")
                .itemId("msg_browser_1")
                .clientEventId("remove_browser_1")
                .build()

        val sidebandServerEvent = SidebandServerEvent.ofDecisionItemDeleted(decisionItemDeleted)

        assertThat(sidebandServerEvent.sessionStarted()).isEmpty
        assertThat(sidebandServerEvent.sessionUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlaying()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlayed()).isEmpty
        assertThat(sidebandServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionEvent()).isEmpty
        assertThat(sidebandServerEvent.decisionItemCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionItemDeleted()).contains(decisionItemDeleted)
        assertThat(sidebandServerEvent.responseEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionClosed()).isEmpty
        assertThat(sidebandServerEvent.errorEvent()).isEmpty
        assertThat(sidebandServerEvent.infoEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfReceived()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfSend()).isEmpty
        assertThat(sidebandServerEvent.transportRinging()).isEmpty
        assertThat(sidebandServerEvent.transportAnswered()).isEmpty
        assertThat(sidebandServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofDecisionItemDeletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandServerEvent =
            SidebandServerEvent.ofDecisionItemDeleted(
                DecisionItemDeletedEvent.builder()
                    .eventId("evt_item_deleted_1")
                    .itemId("msg_browser_1")
                    .clientEventId("remove_browser_1")
                    .build()
            )

        val roundtrippedSidebandServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandServerEvent),
                jacksonTypeRef<SidebandServerEvent>(),
            )

        assertThat(roundtrippedSidebandServerEvent).isEqualTo(sidebandServerEvent)
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

        val sidebandServerEvent = SidebandServerEvent.ofResponseEvent(responseEvent)

        assertThat(sidebandServerEvent.sessionStarted()).isEmpty
        assertThat(sidebandServerEvent.sessionUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlaying()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlayed()).isEmpty
        assertThat(sidebandServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionEvent()).isEmpty
        assertThat(sidebandServerEvent.decisionItemCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionItemDeleted()).isEmpty
        assertThat(sidebandServerEvent.responseEvent()).contains(responseEvent)
        assertThat(sidebandServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionClosed()).isEmpty
        assertThat(sidebandServerEvent.errorEvent()).isEmpty
        assertThat(sidebandServerEvent.infoEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfReceived()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfSend()).isEmpty
        assertThat(sidebandServerEvent.transportRinging()).isEmpty
        assertThat(sidebandServerEvent.transportAnswered()).isEmpty
        assertThat(sidebandServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofResponseEventRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandServerEvent =
            SidebandServerEvent.ofResponseEvent(
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

        val roundtrippedSidebandServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandServerEvent),
                jacksonTypeRef<SidebandServerEvent>(),
            )

        assertThat(roundtrippedSidebandServerEvent).isEqualTo(sidebandServerEvent)
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

        val sidebandServerEvent = SidebandServerEvent.ofSessionUsageUpdated(sessionUsageUpdated)

        assertThat(sidebandServerEvent.sessionStarted()).isEmpty
        assertThat(sidebandServerEvent.sessionUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlaying()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlayed()).isEmpty
        assertThat(sidebandServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionEvent()).isEmpty
        assertThat(sidebandServerEvent.decisionItemCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionItemDeleted()).isEmpty
        assertThat(sidebandServerEvent.responseEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionUsageUpdated()).contains(sessionUsageUpdated)
        assertThat(sidebandServerEvent.sessionClosed()).isEmpty
        assertThat(sidebandServerEvent.errorEvent()).isEmpty
        assertThat(sidebandServerEvent.infoEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfReceived()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfSend()).isEmpty
        assertThat(sidebandServerEvent.transportRinging()).isEmpty
        assertThat(sidebandServerEvent.transportAnswered()).isEmpty
        assertThat(sidebandServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionUsageUpdatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandServerEvent =
            SidebandServerEvent.ofSessionUsageUpdated(
                SessionUsageUpdatedEvent.builder()
                    .eventId("evt_usage_001")
                    .usage(SessionUsage.builder().seconds(32.5).build())
                    .clientEventId("client_event_id")
                    .contextWindow(
                        SessionUsageUpdatedEvent.ContextWindow.builder().usageRatio(0.12).build()
                    )
                    .build()
            )

        val roundtrippedSidebandServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandServerEvent),
                jacksonTypeRef<SidebandServerEvent>(),
            )

        assertThat(roundtrippedSidebandServerEvent).isEqualTo(sidebandServerEvent)
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
                        .addTrigger(
                            DecisionTrigger.builder()
                                .decisions(
                                    DecisionTrigger.Decisions.builder()
                                        .addQuestion(
                                            DecisionTrigger.Decisions.Question.Predicate.builder()
                                                .instructions("instructions")
                                                .name("name")
                                                .build()
                                        )
                                        .build()
                                )
                                .eventType(DecisionTrigger.EventType.SESSION_INPUT_TRANSCRIPT_DELTA)
                                .build()
                        )
                        .build()
                )
                .usage(SessionUsage.builder().seconds(45.8).build())
                .clientEventId("evt_close_001")
                .build()

        val sidebandServerEvent = SidebandServerEvent.ofSessionClosed(sessionClosed)

        assertThat(sidebandServerEvent.sessionStarted()).isEmpty
        assertThat(sidebandServerEvent.sessionUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlaying()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlayed()).isEmpty
        assertThat(sidebandServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionEvent()).isEmpty
        assertThat(sidebandServerEvent.decisionItemCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionItemDeleted()).isEmpty
        assertThat(sidebandServerEvent.responseEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionClosed()).contains(sessionClosed)
        assertThat(sidebandServerEvent.errorEvent()).isEmpty
        assertThat(sidebandServerEvent.infoEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfReceived()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfSend()).isEmpty
        assertThat(sidebandServerEvent.transportRinging()).isEmpty
        assertThat(sidebandServerEvent.transportAnswered()).isEmpty
        assertThat(sidebandServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionClosedRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandServerEvent =
            SidebandServerEvent.ofSessionClosed(
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
                            .addTrigger(
                                DecisionTrigger.builder()
                                    .decisions(
                                        DecisionTrigger.Decisions.builder()
                                            .addQuestion(
                                                DecisionTrigger.Decisions.Question.Predicate
                                                    .builder()
                                                    .instructions("instructions")
                                                    .name("name")
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .eventType(
                                        DecisionTrigger.EventType.SESSION_INPUT_TRANSCRIPT_DELTA
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .usage(SessionUsage.builder().seconds(45.8).build())
                    .clientEventId("evt_close_001")
                    .build()
            )

        val roundtrippedSidebandServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandServerEvent),
                jacksonTypeRef<SidebandServerEvent>(),
            )

        assertThat(roundtrippedSidebandServerEvent).isEqualTo(sidebandServerEvent)
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

        val sidebandServerEvent = SidebandServerEvent.ofErrorEvent(errorEvent)

        assertThat(sidebandServerEvent.sessionStarted()).isEmpty
        assertThat(sidebandServerEvent.sessionUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlaying()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlayed()).isEmpty
        assertThat(sidebandServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionEvent()).isEmpty
        assertThat(sidebandServerEvent.decisionItemCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionItemDeleted()).isEmpty
        assertThat(sidebandServerEvent.responseEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionClosed()).isEmpty
        assertThat(sidebandServerEvent.errorEvent()).contains(errorEvent)
        assertThat(sidebandServerEvent.infoEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfReceived()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfSend()).isEmpty
        assertThat(sidebandServerEvent.transportRinging()).isEmpty
        assertThat(sidebandServerEvent.transportAnswered()).isEmpty
        assertThat(sidebandServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofErrorEventRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandServerEvent =
            SidebandServerEvent.ofErrorEvent(
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

        val roundtrippedSidebandServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandServerEvent),
                jacksonTypeRef<SidebandServerEvent>(),
            )

        assertThat(roundtrippedSidebandServerEvent).isEqualTo(sidebandServerEvent)
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

        val sidebandServerEvent = SidebandServerEvent.ofInfoEvent(infoEvent)

        assertThat(sidebandServerEvent.sessionStarted()).isEmpty
        assertThat(sidebandServerEvent.sessionUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlaying()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlayed()).isEmpty
        assertThat(sidebandServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionEvent()).isEmpty
        assertThat(sidebandServerEvent.decisionItemCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionItemDeleted()).isEmpty
        assertThat(sidebandServerEvent.responseEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionClosed()).isEmpty
        assertThat(sidebandServerEvent.errorEvent()).isEmpty
        assertThat(sidebandServerEvent.infoEvent()).contains(infoEvent)
        assertThat(sidebandServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfReceived()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfSend()).isEmpty
        assertThat(sidebandServerEvent.transportRinging()).isEmpty
        assertThat(sidebandServerEvent.transportAnswered()).isEmpty
        assertThat(sidebandServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofInfoEventRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandServerEvent =
            SidebandServerEvent.ofInfoEvent(
                InfoEvent.builder()
                    .code("data_channel_permissions")
                    .eventId("evt_info_001")
                    .message(
                        "The frontend data channel is configured with restricted event permissions."
                    )
                    .clientEventId("client_event_id")
                    .build()
            )

        val roundtrippedSidebandServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandServerEvent),
                jacksonTypeRef<SidebandServerEvent>(),
            )

        assertThat(roundtrippedSidebandServerEvent).isEqualTo(sidebandServerEvent)
    }

    @Test
    fun ofSessionInputAudioAppend() {
        val sessionInputAudioAppend =
            SidebandServerEvent.SessionInputAudioAppend.builder().audio("audio").build()

        val sidebandServerEvent =
            SidebandServerEvent.ofSessionInputAudioAppend(sessionInputAudioAppend)

        assertThat(sidebandServerEvent.sessionStarted()).isEmpty
        assertThat(sidebandServerEvent.sessionUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlaying()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlayed()).isEmpty
        assertThat(sidebandServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionEvent()).isEmpty
        assertThat(sidebandServerEvent.decisionItemCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionItemDeleted()).isEmpty
        assertThat(sidebandServerEvent.responseEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionClosed()).isEmpty
        assertThat(sidebandServerEvent.errorEvent()).isEmpty
        assertThat(sidebandServerEvent.infoEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioAppend()).contains(sessionInputAudioAppend)
        assertThat(sidebandServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfReceived()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfSend()).isEmpty
        assertThat(sidebandServerEvent.transportRinging()).isEmpty
        assertThat(sidebandServerEvent.transportAnswered()).isEmpty
        assertThat(sidebandServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionInputAudioAppendRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandServerEvent =
            SidebandServerEvent.ofSessionInputAudioAppend(
                SidebandServerEvent.SessionInputAudioAppend.builder().audio("audio").build()
            )

        val roundtrippedSidebandServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandServerEvent),
                jacksonTypeRef<SidebandServerEvent>(),
            )

        assertThat(roundtrippedSidebandServerEvent).isEqualTo(sidebandServerEvent)
    }

    @Test
    fun ofSessionOutputAudioDelta() {
        val sessionOutputAudioDelta =
            OutputAudioDeltaEvent.builder()
                .delta("AACAAIAAAIAAAP9/AIAAgA==")
                .endMs(1200L)
                .startMs(1000L)
                .build()

        val sidebandServerEvent =
            SidebandServerEvent.ofSessionOutputAudioDelta(sessionOutputAudioDelta)

        assertThat(sidebandServerEvent.sessionStarted()).isEmpty
        assertThat(sidebandServerEvent.sessionUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlaying()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlayed()).isEmpty
        assertThat(sidebandServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionEvent()).isEmpty
        assertThat(sidebandServerEvent.decisionItemCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionItemDeleted()).isEmpty
        assertThat(sidebandServerEvent.responseEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionClosed()).isEmpty
        assertThat(sidebandServerEvent.errorEvent()).isEmpty
        assertThat(sidebandServerEvent.infoEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioDelta()).contains(sessionOutputAudioDelta)
        assertThat(sidebandServerEvent.transportDtmfReceived()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfSend()).isEmpty
        assertThat(sidebandServerEvent.transportRinging()).isEmpty
        assertThat(sidebandServerEvent.transportAnswered()).isEmpty
        assertThat(sidebandServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofSessionOutputAudioDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandServerEvent =
            SidebandServerEvent.ofSessionOutputAudioDelta(
                OutputAudioDeltaEvent.builder()
                    .delta("AACAAIAAAIAAAP9/AIAAgA==")
                    .endMs(1200L)
                    .startMs(1000L)
                    .build()
            )

        val roundtrippedSidebandServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandServerEvent),
                jacksonTypeRef<SidebandServerEvent>(),
            )

        assertThat(roundtrippedSidebandServerEvent).isEqualTo(sidebandServerEvent)
    }

    @Test
    fun ofTransportDtmfReceived() {
        val transportDtmfReceived =
            SidebandServerEvent.TransportDtmfReceived.builder()
                .event("#")
                .eventId("event_id")
                .build()

        val sidebandServerEvent = SidebandServerEvent.ofTransportDtmfReceived(transportDtmfReceived)

        assertThat(sidebandServerEvent.sessionStarted()).isEmpty
        assertThat(sidebandServerEvent.sessionUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlaying()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlayed()).isEmpty
        assertThat(sidebandServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionEvent()).isEmpty
        assertThat(sidebandServerEvent.decisionItemCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionItemDeleted()).isEmpty
        assertThat(sidebandServerEvent.responseEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionClosed()).isEmpty
        assertThat(sidebandServerEvent.errorEvent()).isEmpty
        assertThat(sidebandServerEvent.infoEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfReceived()).contains(transportDtmfReceived)
        assertThat(sidebandServerEvent.transportDtmfSend()).isEmpty
        assertThat(sidebandServerEvent.transportRinging()).isEmpty
        assertThat(sidebandServerEvent.transportAnswered()).isEmpty
        assertThat(sidebandServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofTransportDtmfReceivedRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandServerEvent =
            SidebandServerEvent.ofTransportDtmfReceived(
                SidebandServerEvent.TransportDtmfReceived.builder()
                    .event("#")
                    .eventId("event_id")
                    .build()
            )

        val roundtrippedSidebandServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandServerEvent),
                jacksonTypeRef<SidebandServerEvent>(),
            )

        assertThat(roundtrippedSidebandServerEvent).isEqualTo(sidebandServerEvent)
    }

    @Test
    fun ofTransportDtmfSend() {
        val transportDtmfSend =
            SidebandServerEvent.TransportDtmfSend.builder()
                .event("#")
                .eventId("event_id")
                .clientEventId("client_event_id")
                .build()

        val sidebandServerEvent = SidebandServerEvent.ofTransportDtmfSend(transportDtmfSend)

        assertThat(sidebandServerEvent.sessionStarted()).isEmpty
        assertThat(sidebandServerEvent.sessionUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlaying()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlayed()).isEmpty
        assertThat(sidebandServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionEvent()).isEmpty
        assertThat(sidebandServerEvent.decisionItemCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionItemDeleted()).isEmpty
        assertThat(sidebandServerEvent.responseEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionClosed()).isEmpty
        assertThat(sidebandServerEvent.errorEvent()).isEmpty
        assertThat(sidebandServerEvent.infoEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfReceived()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfSend()).contains(transportDtmfSend)
        assertThat(sidebandServerEvent.transportRinging()).isEmpty
        assertThat(sidebandServerEvent.transportAnswered()).isEmpty
        assertThat(sidebandServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofTransportDtmfSendRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandServerEvent =
            SidebandServerEvent.ofTransportDtmfSend(
                SidebandServerEvent.TransportDtmfSend.builder()
                    .event("#")
                    .eventId("event_id")
                    .clientEventId("client_event_id")
                    .build()
            )

        val roundtrippedSidebandServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandServerEvent),
                jacksonTypeRef<SidebandServerEvent>(),
            )

        assertThat(roundtrippedSidebandServerEvent).isEqualTo(sidebandServerEvent)
    }

    @Test
    fun ofTransportRinging() {
        val transportRinging =
            SidebandServerEvent.TransportRinging.builder()
                .eventId("event_id")
                .sessionId("session_id")
                .build()

        val sidebandServerEvent = SidebandServerEvent.ofTransportRinging(transportRinging)

        assertThat(sidebandServerEvent.sessionStarted()).isEmpty
        assertThat(sidebandServerEvent.sessionUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlaying()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlayed()).isEmpty
        assertThat(sidebandServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionEvent()).isEmpty
        assertThat(sidebandServerEvent.decisionItemCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionItemDeleted()).isEmpty
        assertThat(sidebandServerEvent.responseEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionClosed()).isEmpty
        assertThat(sidebandServerEvent.errorEvent()).isEmpty
        assertThat(sidebandServerEvent.infoEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfReceived()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfSend()).isEmpty
        assertThat(sidebandServerEvent.transportRinging()).contains(transportRinging)
        assertThat(sidebandServerEvent.transportAnswered()).isEmpty
        assertThat(sidebandServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofTransportRingingRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandServerEvent =
            SidebandServerEvent.ofTransportRinging(
                SidebandServerEvent.TransportRinging.builder()
                    .eventId("event_id")
                    .sessionId("session_id")
                    .build()
            )

        val roundtrippedSidebandServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandServerEvent),
                jacksonTypeRef<SidebandServerEvent>(),
            )

        assertThat(roundtrippedSidebandServerEvent).isEqualTo(sidebandServerEvent)
    }

    @Test
    fun ofTransportAnswered() {
        val transportAnswered =
            SidebandServerEvent.TransportAnswered.builder()
                .eventId("event_id")
                .sessionId("session_id")
                .build()

        val sidebandServerEvent = SidebandServerEvent.ofTransportAnswered(transportAnswered)

        assertThat(sidebandServerEvent.sessionStarted()).isEmpty
        assertThat(sidebandServerEvent.sessionUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlaying()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlayed()).isEmpty
        assertThat(sidebandServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionEvent()).isEmpty
        assertThat(sidebandServerEvent.decisionItemCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionItemDeleted()).isEmpty
        assertThat(sidebandServerEvent.responseEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionClosed()).isEmpty
        assertThat(sidebandServerEvent.errorEvent()).isEmpty
        assertThat(sidebandServerEvent.infoEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfReceived()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfSend()).isEmpty
        assertThat(sidebandServerEvent.transportRinging()).isEmpty
        assertThat(sidebandServerEvent.transportAnswered()).contains(transportAnswered)
        assertThat(sidebandServerEvent.transportFailed()).isEmpty
    }

    @Test
    fun ofTransportAnsweredRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandServerEvent =
            SidebandServerEvent.ofTransportAnswered(
                SidebandServerEvent.TransportAnswered.builder()
                    .eventId("event_id")
                    .sessionId("session_id")
                    .build()
            )

        val roundtrippedSidebandServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandServerEvent),
                jacksonTypeRef<SidebandServerEvent>(),
            )

        assertThat(roundtrippedSidebandServerEvent).isEqualTo(sidebandServerEvent)
    }

    @Test
    fun ofTransportFailed() {
        val transportFailed =
            SidebandServerEvent.TransportFailed.builder()
                .error(
                    SidebandServerEvent.TransportFailed.Error.builder()
                        .code("code")
                        .message("message")
                        .param("param")
                        .build()
                )
                .eventId("event_id")
                .sessionId("session_id")
                .build()

        val sidebandServerEvent = SidebandServerEvent.ofTransportFailed(transportFailed)

        assertThat(sidebandServerEvent.sessionStarted()).isEmpty
        assertThat(sidebandServerEvent.sessionUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioMuted()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioUnmuted()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlaying()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioFixturePlayed()).isEmpty
        assertThat(sidebandServerEvent.sessionInstructionsAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionThinkingAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionCommentaryAppended()).isEmpty
        assertThat(sidebandServerEvent.sessionInputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputTranscriptDelta()).isEmpty
        assertThat(sidebandServerEvent.sessionDelegationCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionEvent()).isEmpty
        assertThat(sidebandServerEvent.decisionItemCreated()).isEmpty
        assertThat(sidebandServerEvent.decisionItemDeleted()).isEmpty
        assertThat(sidebandServerEvent.responseEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionUsageUpdated()).isEmpty
        assertThat(sidebandServerEvent.sessionClosed()).isEmpty
        assertThat(sidebandServerEvent.errorEvent()).isEmpty
        assertThat(sidebandServerEvent.infoEvent()).isEmpty
        assertThat(sidebandServerEvent.sessionInputAudioAppend()).isEmpty
        assertThat(sidebandServerEvent.sessionOutputAudioDelta()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfReceived()).isEmpty
        assertThat(sidebandServerEvent.transportDtmfSend()).isEmpty
        assertThat(sidebandServerEvent.transportRinging()).isEmpty
        assertThat(sidebandServerEvent.transportAnswered()).isEmpty
        assertThat(sidebandServerEvent.transportFailed()).contains(transportFailed)
    }

    @Test
    fun ofTransportFailedRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandServerEvent =
            SidebandServerEvent.ofTransportFailed(
                SidebandServerEvent.TransportFailed.builder()
                    .error(
                        SidebandServerEvent.TransportFailed.Error.builder()
                            .code("code")
                            .message("message")
                            .param("param")
                            .build()
                    )
                    .eventId("event_id")
                    .sessionId("session_id")
                    .build()
            )

        val roundtrippedSidebandServerEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandServerEvent),
                jacksonTypeRef<SidebandServerEvent>(),
            )

        assertThat(roundtrippedSidebandServerEvent).isEqualTo(sidebandServerEvent)
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
        val sidebandServerEvent =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<SidebandServerEvent>())

        val e = assertThrows<OpenAIInvalidDataException> { sidebandServerEvent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
