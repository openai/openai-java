// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live.forks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.live.AudioFormat
import com.openai.models.live.ClientConfig
import com.openai.models.live.CommentaryAppendEvent
import com.openai.models.live.DataChannelConfig
import com.openai.models.live.ForkSessionConfig
import com.openai.models.live.ForkSessionStartEvent
import com.openai.models.live.FunctionTool
import com.openai.models.live.InputAudioAppendEvent
import com.openai.models.live.InputAudioMuteEvent
import com.openai.models.live.InputAudioUnmuteEvent
import com.openai.models.live.InstructionsAppendEvent
import com.openai.models.live.ResponseCreateEvent
import com.openai.models.live.ResponseItemCreateEvent
import com.openai.models.live.ResponsesDelegationUpdateConfig
import com.openai.models.live.SessionCloseEvent
import com.openai.models.live.SessionUpdateConfig
import com.openai.models.live.SessionUpdateEvent
import com.openai.models.live.ThinkingAppendEvent
import com.openai.models.responses.EasyInputMessage
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ForkClientEventTest {

    @Test
    fun ofSessionStart() {
        val sessionStart =
            ForkSessionStartEvent.builder()
                .session(
                    ForkSessionConfig.builder()
                        .audio(
                            ForkSessionConfig.Audio.builder()
                                .audioPcmFormat(AudioFormat.AudioPcm.Rate._16000)
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
                        .delegation(
                            ForkSessionConfig.Delegation.builder()
                                .responses(
                                    ResponsesDelegationUpdateConfig.builder()
                                        .instructions("instructions")
                                        .maxOutputTokens(16L)
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
                        .store(true)
                        .build()
                )
                .eventId("event_id")
                .build()

        val forkClientEvent = ForkClientEvent.ofSessionStart(sessionStart)

        assertThat(forkClientEvent.sessionStart()).contains(sessionStart)
        assertThat(forkClientEvent.sessionUpdate()).isEmpty
        assertThat(forkClientEvent.sessionInputAudioAppend()).isEmpty
        assertThat(forkClientEvent.sessionInputAudioMute()).isEmpty
        assertThat(forkClientEvent.sessionInputAudioUnmute()).isEmpty
        assertThat(forkClientEvent.sessionInstructionsAppend()).isEmpty
        assertThat(forkClientEvent.sessionThinkingAppend()).isEmpty
        assertThat(forkClientEvent.sessionCommentaryAppend()).isEmpty
        assertThat(forkClientEvent.responseItemCreate()).isEmpty
        assertThat(forkClientEvent.responseCreate()).isEmpty
        assertThat(forkClientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofSessionStartRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkClientEvent =
            ForkClientEvent.ofSessionStart(
                ForkSessionStartEvent.builder()
                    .session(
                        ForkSessionConfig.builder()
                            .audio(
                                ForkSessionConfig.Audio.builder()
                                    .audioPcmFormat(AudioFormat.AudioPcm.Rate._16000)
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
                            .delegation(
                                ForkSessionConfig.Delegation.builder()
                                    .responses(
                                        ResponsesDelegationUpdateConfig.builder()
                                            .instructions("instructions")
                                            .maxOutputTokens(16L)
                                            .model("model")
                                            .parallelToolCalls(true)
                                            .reasoning(
                                                ResponsesDelegationUpdateConfig.Reasoning.builder()
                                                    .effort(
                                                        ResponsesDelegationUpdateConfig.Reasoning
                                                            .Effort
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
                                                        ResponsesDelegationUpdateConfig.Text
                                                            .Verbosity
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
                            .store(true)
                            .build()
                    )
                    .eventId("event_id")
                    .build()
            )

        val roundtrippedForkClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkClientEvent),
                jacksonTypeRef<ForkClientEvent>(),
            )

        assertThat(roundtrippedForkClientEvent).isEqualTo(forkClientEvent)
    }

    @Test
    fun ofSessionUpdate() {
        val sessionUpdate =
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

        val forkClientEvent = ForkClientEvent.ofSessionUpdate(sessionUpdate)

        assertThat(forkClientEvent.sessionStart()).isEmpty
        assertThat(forkClientEvent.sessionUpdate()).contains(sessionUpdate)
        assertThat(forkClientEvent.sessionInputAudioAppend()).isEmpty
        assertThat(forkClientEvent.sessionInputAudioMute()).isEmpty
        assertThat(forkClientEvent.sessionInputAudioUnmute()).isEmpty
        assertThat(forkClientEvent.sessionInstructionsAppend()).isEmpty
        assertThat(forkClientEvent.sessionThinkingAppend()).isEmpty
        assertThat(forkClientEvent.sessionCommentaryAppend()).isEmpty
        assertThat(forkClientEvent.responseItemCreate()).isEmpty
        assertThat(forkClientEvent.responseCreate()).isEmpty
        assertThat(forkClientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofSessionUpdateRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkClientEvent =
            ForkClientEvent.ofSessionUpdate(
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
                                                        ResponsesDelegationUpdateConfig.Reasoning
                                                            .Effort
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
                                                        ResponsesDelegationUpdateConfig.Text
                                                            .Verbosity
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
            )

        val roundtrippedForkClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkClientEvent),
                jacksonTypeRef<ForkClientEvent>(),
            )

        assertThat(roundtrippedForkClientEvent).isEqualTo(forkClientEvent)
    }

    @Test
    fun ofSessionInputAudioAppend() {
        val sessionInputAudioAppend =
            InputAudioAppendEvent.builder()
                .audio("AACAAIAAAIAAAP9/AIAAgA==")
                .eventId("event_id")
                .build()

        val forkClientEvent = ForkClientEvent.ofSessionInputAudioAppend(sessionInputAudioAppend)

        assertThat(forkClientEvent.sessionStart()).isEmpty
        assertThat(forkClientEvent.sessionUpdate()).isEmpty
        assertThat(forkClientEvent.sessionInputAudioAppend()).contains(sessionInputAudioAppend)
        assertThat(forkClientEvent.sessionInputAudioMute()).isEmpty
        assertThat(forkClientEvent.sessionInputAudioUnmute()).isEmpty
        assertThat(forkClientEvent.sessionInstructionsAppend()).isEmpty
        assertThat(forkClientEvent.sessionThinkingAppend()).isEmpty
        assertThat(forkClientEvent.sessionCommentaryAppend()).isEmpty
        assertThat(forkClientEvent.responseItemCreate()).isEmpty
        assertThat(forkClientEvent.responseCreate()).isEmpty
        assertThat(forkClientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofSessionInputAudioAppendRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkClientEvent =
            ForkClientEvent.ofSessionInputAudioAppend(
                InputAudioAppendEvent.builder()
                    .audio("AACAAIAAAIAAAP9/AIAAgA==")
                    .eventId("event_id")
                    .build()
            )

        val roundtrippedForkClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkClientEvent),
                jacksonTypeRef<ForkClientEvent>(),
            )

        assertThat(roundtrippedForkClientEvent).isEqualTo(forkClientEvent)
    }

    @Test
    fun ofSessionInputAudioMute() {
        val sessionInputAudioMute = InputAudioMuteEvent.builder().eventId("evt_mute_001").build()

        val forkClientEvent = ForkClientEvent.ofSessionInputAudioMute(sessionInputAudioMute)

        assertThat(forkClientEvent.sessionStart()).isEmpty
        assertThat(forkClientEvent.sessionUpdate()).isEmpty
        assertThat(forkClientEvent.sessionInputAudioAppend()).isEmpty
        assertThat(forkClientEvent.sessionInputAudioMute()).contains(sessionInputAudioMute)
        assertThat(forkClientEvent.sessionInputAudioUnmute()).isEmpty
        assertThat(forkClientEvent.sessionInstructionsAppend()).isEmpty
        assertThat(forkClientEvent.sessionThinkingAppend()).isEmpty
        assertThat(forkClientEvent.sessionCommentaryAppend()).isEmpty
        assertThat(forkClientEvent.responseItemCreate()).isEmpty
        assertThat(forkClientEvent.responseCreate()).isEmpty
        assertThat(forkClientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofSessionInputAudioMuteRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkClientEvent =
            ForkClientEvent.ofSessionInputAudioMute(
                InputAudioMuteEvent.builder().eventId("evt_mute_001").build()
            )

        val roundtrippedForkClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkClientEvent),
                jacksonTypeRef<ForkClientEvent>(),
            )

        assertThat(roundtrippedForkClientEvent).isEqualTo(forkClientEvent)
    }

    @Test
    fun ofSessionInputAudioUnmute() {
        val sessionInputAudioUnmute =
            InputAudioUnmuteEvent.builder().eventId("evt_unmute_001").build()

        val forkClientEvent = ForkClientEvent.ofSessionInputAudioUnmute(sessionInputAudioUnmute)

        assertThat(forkClientEvent.sessionStart()).isEmpty
        assertThat(forkClientEvent.sessionUpdate()).isEmpty
        assertThat(forkClientEvent.sessionInputAudioAppend()).isEmpty
        assertThat(forkClientEvent.sessionInputAudioMute()).isEmpty
        assertThat(forkClientEvent.sessionInputAudioUnmute()).contains(sessionInputAudioUnmute)
        assertThat(forkClientEvent.sessionInstructionsAppend()).isEmpty
        assertThat(forkClientEvent.sessionThinkingAppend()).isEmpty
        assertThat(forkClientEvent.sessionCommentaryAppend()).isEmpty
        assertThat(forkClientEvent.responseItemCreate()).isEmpty
        assertThat(forkClientEvent.responseCreate()).isEmpty
        assertThat(forkClientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofSessionInputAudioUnmuteRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkClientEvent =
            ForkClientEvent.ofSessionInputAudioUnmute(
                InputAudioUnmuteEvent.builder().eventId("evt_unmute_001").build()
            )

        val roundtrippedForkClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkClientEvent),
                jacksonTypeRef<ForkClientEvent>(),
            )

        assertThat(roundtrippedForkClientEvent).isEqualTo(forkClientEvent)
    }

    @Test
    fun ofSessionInstructionsAppend() {
        val sessionInstructionsAppend =
            InstructionsAppendEvent.builder()
                .content("The caller prefers outdoor seating.")
                .delegationId(null)
                .eventId("evt_instructions_001")
                .build()

        val forkClientEvent = ForkClientEvent.ofSessionInstructionsAppend(sessionInstructionsAppend)

        assertThat(forkClientEvent.sessionStart()).isEmpty
        assertThat(forkClientEvent.sessionUpdate()).isEmpty
        assertThat(forkClientEvent.sessionInputAudioAppend()).isEmpty
        assertThat(forkClientEvent.sessionInputAudioMute()).isEmpty
        assertThat(forkClientEvent.sessionInputAudioUnmute()).isEmpty
        assertThat(forkClientEvent.sessionInstructionsAppend()).contains(sessionInstructionsAppend)
        assertThat(forkClientEvent.sessionThinkingAppend()).isEmpty
        assertThat(forkClientEvent.sessionCommentaryAppend()).isEmpty
        assertThat(forkClientEvent.responseItemCreate()).isEmpty
        assertThat(forkClientEvent.responseCreate()).isEmpty
        assertThat(forkClientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofSessionInstructionsAppendRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkClientEvent =
            ForkClientEvent.ofSessionInstructionsAppend(
                InstructionsAppendEvent.builder()
                    .content("The caller prefers outdoor seating.")
                    .delegationId(null)
                    .eventId("evt_instructions_001")
                    .build()
            )

        val roundtrippedForkClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkClientEvent),
                jacksonTypeRef<ForkClientEvent>(),
            )

        assertThat(roundtrippedForkClientEvent).isEqualTo(forkClientEvent)
    }

    @Test
    fun ofSessionThinkingAppend() {
        val sessionThinkingAppend =
            ThinkingAppendEvent.builder()
                .content("Checking availability for two guests at 7 PM.")
                .delegationId("del_abc123")
                .eventId("evt_thinking_001")
                .build()

        val forkClientEvent = ForkClientEvent.ofSessionThinkingAppend(sessionThinkingAppend)

        assertThat(forkClientEvent.sessionStart()).isEmpty
        assertThat(forkClientEvent.sessionUpdate()).isEmpty
        assertThat(forkClientEvent.sessionInputAudioAppend()).isEmpty
        assertThat(forkClientEvent.sessionInputAudioMute()).isEmpty
        assertThat(forkClientEvent.sessionInputAudioUnmute()).isEmpty
        assertThat(forkClientEvent.sessionInstructionsAppend()).isEmpty
        assertThat(forkClientEvent.sessionThinkingAppend()).contains(sessionThinkingAppend)
        assertThat(forkClientEvent.sessionCommentaryAppend()).isEmpty
        assertThat(forkClientEvent.responseItemCreate()).isEmpty
        assertThat(forkClientEvent.responseCreate()).isEmpty
        assertThat(forkClientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofSessionThinkingAppendRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkClientEvent =
            ForkClientEvent.ofSessionThinkingAppend(
                ThinkingAppendEvent.builder()
                    .content("Checking availability for two guests at 7 PM.")
                    .delegationId("del_abc123")
                    .eventId("evt_thinking_001")
                    .build()
            )

        val roundtrippedForkClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkClientEvent),
                jacksonTypeRef<ForkClientEvent>(),
            )

        assertThat(roundtrippedForkClientEvent).isEqualTo(forkClientEvent)
    }

    @Test
    fun ofSessionCommentaryAppend() {
        val sessionCommentaryAppend =
            CommentaryAppendEvent.builder()
                .content("There is an outdoor table for two at 7 PM. Ask whether to reserve it.")
                .delegationId("del_abc123")
                .eventId("evt_commentary_001")
                .build()

        val forkClientEvent = ForkClientEvent.ofSessionCommentaryAppend(sessionCommentaryAppend)

        assertThat(forkClientEvent.sessionStart()).isEmpty
        assertThat(forkClientEvent.sessionUpdate()).isEmpty
        assertThat(forkClientEvent.sessionInputAudioAppend()).isEmpty
        assertThat(forkClientEvent.sessionInputAudioMute()).isEmpty
        assertThat(forkClientEvent.sessionInputAudioUnmute()).isEmpty
        assertThat(forkClientEvent.sessionInstructionsAppend()).isEmpty
        assertThat(forkClientEvent.sessionThinkingAppend()).isEmpty
        assertThat(forkClientEvent.sessionCommentaryAppend()).contains(sessionCommentaryAppend)
        assertThat(forkClientEvent.responseItemCreate()).isEmpty
        assertThat(forkClientEvent.responseCreate()).isEmpty
        assertThat(forkClientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofSessionCommentaryAppendRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkClientEvent =
            ForkClientEvent.ofSessionCommentaryAppend(
                CommentaryAppendEvent.builder()
                    .content(
                        "There is an outdoor table for two at 7 PM. Ask whether to reserve it."
                    )
                    .delegationId("del_abc123")
                    .eventId("evt_commentary_001")
                    .build()
            )

        val roundtrippedForkClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkClientEvent),
                jacksonTypeRef<ForkClientEvent>(),
            )

        assertThat(roundtrippedForkClientEvent).isEqualTo(forkClientEvent)
    }

    @Test
    fun ofResponseItemCreate() {
        val responseItemCreate =
            ResponseItemCreateEvent.builder()
                .item(
                    EasyInputMessage.builder()
                        .content("string")
                        .role(EasyInputMessage.Role.USER)
                        .phase(EasyInputMessage.Phase.COMMENTARY)
                        .type(EasyInputMessage.Type.MESSAGE)
                        .build()
                )
                .eventId("evt_item_001")
                .build()

        val forkClientEvent = ForkClientEvent.ofResponseItemCreate(responseItemCreate)

        assertThat(forkClientEvent.sessionStart()).isEmpty
        assertThat(forkClientEvent.sessionUpdate()).isEmpty
        assertThat(forkClientEvent.sessionInputAudioAppend()).isEmpty
        assertThat(forkClientEvent.sessionInputAudioMute()).isEmpty
        assertThat(forkClientEvent.sessionInputAudioUnmute()).isEmpty
        assertThat(forkClientEvent.sessionInstructionsAppend()).isEmpty
        assertThat(forkClientEvent.sessionThinkingAppend()).isEmpty
        assertThat(forkClientEvent.sessionCommentaryAppend()).isEmpty
        assertThat(forkClientEvent.responseItemCreate()).contains(responseItemCreate)
        assertThat(forkClientEvent.responseCreate()).isEmpty
        assertThat(forkClientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofResponseItemCreateRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkClientEvent =
            ForkClientEvent.ofResponseItemCreate(
                ResponseItemCreateEvent.builder()
                    .item(
                        EasyInputMessage.builder()
                            .content("string")
                            .role(EasyInputMessage.Role.USER)
                            .phase(EasyInputMessage.Phase.COMMENTARY)
                            .type(EasyInputMessage.Type.MESSAGE)
                            .build()
                    )
                    .eventId("evt_item_001")
                    .build()
            )

        val roundtrippedForkClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkClientEvent),
                jacksonTypeRef<ForkClientEvent>(),
            )

        assertThat(roundtrippedForkClientEvent).isEqualTo(forkClientEvent)
    }

    @Test
    fun ofResponseCreate() {
        val responseCreate = ResponseCreateEvent.builder().eventId("evt_response_001").build()

        val forkClientEvent = ForkClientEvent.ofResponseCreate(responseCreate)

        assertThat(forkClientEvent.sessionStart()).isEmpty
        assertThat(forkClientEvent.sessionUpdate()).isEmpty
        assertThat(forkClientEvent.sessionInputAudioAppend()).isEmpty
        assertThat(forkClientEvent.sessionInputAudioMute()).isEmpty
        assertThat(forkClientEvent.sessionInputAudioUnmute()).isEmpty
        assertThat(forkClientEvent.sessionInstructionsAppend()).isEmpty
        assertThat(forkClientEvent.sessionThinkingAppend()).isEmpty
        assertThat(forkClientEvent.sessionCommentaryAppend()).isEmpty
        assertThat(forkClientEvent.responseItemCreate()).isEmpty
        assertThat(forkClientEvent.responseCreate()).contains(responseCreate)
        assertThat(forkClientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofResponseCreateRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkClientEvent =
            ForkClientEvent.ofResponseCreate(
                ResponseCreateEvent.builder().eventId("evt_response_001").build()
            )

        val roundtrippedForkClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkClientEvent),
                jacksonTypeRef<ForkClientEvent>(),
            )

        assertThat(roundtrippedForkClientEvent).isEqualTo(forkClientEvent)
    }

    @Test
    fun ofSessionClose() {
        val sessionClose = SessionCloseEvent.builder().eventId("evt_close_001").build()

        val forkClientEvent = ForkClientEvent.ofSessionClose(sessionClose)

        assertThat(forkClientEvent.sessionStart()).isEmpty
        assertThat(forkClientEvent.sessionUpdate()).isEmpty
        assertThat(forkClientEvent.sessionInputAudioAppend()).isEmpty
        assertThat(forkClientEvent.sessionInputAudioMute()).isEmpty
        assertThat(forkClientEvent.sessionInputAudioUnmute()).isEmpty
        assertThat(forkClientEvent.sessionInstructionsAppend()).isEmpty
        assertThat(forkClientEvent.sessionThinkingAppend()).isEmpty
        assertThat(forkClientEvent.sessionCommentaryAppend()).isEmpty
        assertThat(forkClientEvent.responseItemCreate()).isEmpty
        assertThat(forkClientEvent.responseCreate()).isEmpty
        assertThat(forkClientEvent.sessionClose()).contains(sessionClose)
    }

    @Test
    fun ofSessionCloseRoundtrip() {
        val jsonMapper = jsonMapper()
        val forkClientEvent =
            ForkClientEvent.ofSessionClose(
                SessionCloseEvent.builder().eventId("evt_close_001").build()
            )

        val roundtrippedForkClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(forkClientEvent),
                jacksonTypeRef<ForkClientEvent>(),
            )

        assertThat(roundtrippedForkClientEvent).isEqualTo(forkClientEvent)
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
        val forkClientEvent =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<ForkClientEvent>())

        val e = assertThrows<OpenAIInvalidDataException> { forkClientEvent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
