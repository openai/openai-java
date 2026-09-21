// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.responses.EasyInputMessage
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ClientEventTest {

    @Test
    fun ofSessionStart() {
        val sessionStart =
            SessionStartEvent.builder()
                .session(
                    SessionConfig.builder()
                        .model(SessionConfig.Model.GPT_LIVE_1)
                        .audio(
                            SessionConfig.Audio.builder()
                                .audioPcmFormat(AudioFormat.AudioPcm.Rate._24000)
                                .output(
                                    SessionConfig.Audio.Output.builder()
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
                        .addInput(
                            InitialItem.Developer.builder()
                                .addContent(
                                    InitialItem.Developer.Content.builder()
                                        .text("text")
                                        .type(InitialItem.Developer.Content.Type.INPUT_TEXT)
                                        .build()
                                )
                                .id("id")
                                .status(InitialItem.Developer.Status.INCOMPLETE)
                                .type(InitialItem.Developer.Type.MESSAGE)
                                .build()
                        )
                        .instructions(
                            "Help the caller plan a restaurant reservation. Confirm details before booking."
                        )
                        .store(true)
                        .build()
                )
                .eventId("evt_start_001")
                .build()

        val clientEvent = ClientEvent.ofSessionStart(sessionStart)

        assertThat(clientEvent.sessionStart()).contains(sessionStart)
        assertThat(clientEvent.sessionUpdate()).isEmpty
        assertThat(clientEvent.sessionInputAudioAppend()).isEmpty
        assertThat(clientEvent.sessionInputAudioMute()).isEmpty
        assertThat(clientEvent.sessionInputAudioUnmute()).isEmpty
        assertThat(clientEvent.sessionInstructionsAppend()).isEmpty
        assertThat(clientEvent.sessionThinkingAppend()).isEmpty
        assertThat(clientEvent.sessionCommentaryAppend()).isEmpty
        assertThat(clientEvent.responseItemCreate()).isEmpty
        assertThat(clientEvent.responseCreate()).isEmpty
        assertThat(clientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofSessionStartRoundtrip() {
        val jsonMapper = jsonMapper()
        val clientEvent =
            ClientEvent.ofSessionStart(
                SessionStartEvent.builder()
                    .session(
                        SessionConfig.builder()
                            .model(SessionConfig.Model.GPT_LIVE_1)
                            .audio(
                                SessionConfig.Audio.builder()
                                    .audioPcmFormat(AudioFormat.AudioPcm.Rate._24000)
                                    .output(
                                        SessionConfig.Audio.Output.builder()
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
                            .addInput(
                                InitialItem.Developer.builder()
                                    .addContent(
                                        InitialItem.Developer.Content.builder()
                                            .text("text")
                                            .type(InitialItem.Developer.Content.Type.INPUT_TEXT)
                                            .build()
                                    )
                                    .id("id")
                                    .status(InitialItem.Developer.Status.INCOMPLETE)
                                    .type(InitialItem.Developer.Type.MESSAGE)
                                    .build()
                            )
                            .instructions(
                                "Help the caller plan a restaurant reservation. Confirm details before booking."
                            )
                            .store(true)
                            .build()
                    )
                    .eventId("evt_start_001")
                    .build()
            )

        val roundtrippedClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(clientEvent),
                jacksonTypeRef<ClientEvent>(),
            )

        assertThat(roundtrippedClientEvent).isEqualTo(clientEvent)
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

        val clientEvent = ClientEvent.ofSessionUpdate(sessionUpdate)

        assertThat(clientEvent.sessionStart()).isEmpty
        assertThat(clientEvent.sessionUpdate()).contains(sessionUpdate)
        assertThat(clientEvent.sessionInputAudioAppend()).isEmpty
        assertThat(clientEvent.sessionInputAudioMute()).isEmpty
        assertThat(clientEvent.sessionInputAudioUnmute()).isEmpty
        assertThat(clientEvent.sessionInstructionsAppend()).isEmpty
        assertThat(clientEvent.sessionThinkingAppend()).isEmpty
        assertThat(clientEvent.sessionCommentaryAppend()).isEmpty
        assertThat(clientEvent.responseItemCreate()).isEmpty
        assertThat(clientEvent.responseCreate()).isEmpty
        assertThat(clientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofSessionUpdateRoundtrip() {
        val jsonMapper = jsonMapper()
        val clientEvent =
            ClientEvent.ofSessionUpdate(
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

        val roundtrippedClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(clientEvent),
                jacksonTypeRef<ClientEvent>(),
            )

        assertThat(roundtrippedClientEvent).isEqualTo(clientEvent)
    }

    @Test
    fun ofSessionInputAudioAppend() {
        val sessionInputAudioAppend =
            InputAudioAppendEvent.builder()
                .audio("AACAAIAAAIAAAP9/AIAAgA==")
                .eventId("event_id")
                .build()

        val clientEvent = ClientEvent.ofSessionInputAudioAppend(sessionInputAudioAppend)

        assertThat(clientEvent.sessionStart()).isEmpty
        assertThat(clientEvent.sessionUpdate()).isEmpty
        assertThat(clientEvent.sessionInputAudioAppend()).contains(sessionInputAudioAppend)
        assertThat(clientEvent.sessionInputAudioMute()).isEmpty
        assertThat(clientEvent.sessionInputAudioUnmute()).isEmpty
        assertThat(clientEvent.sessionInstructionsAppend()).isEmpty
        assertThat(clientEvent.sessionThinkingAppend()).isEmpty
        assertThat(clientEvent.sessionCommentaryAppend()).isEmpty
        assertThat(clientEvent.responseItemCreate()).isEmpty
        assertThat(clientEvent.responseCreate()).isEmpty
        assertThat(clientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofSessionInputAudioAppendRoundtrip() {
        val jsonMapper = jsonMapper()
        val clientEvent =
            ClientEvent.ofSessionInputAudioAppend(
                InputAudioAppendEvent.builder()
                    .audio("AACAAIAAAIAAAP9/AIAAgA==")
                    .eventId("event_id")
                    .build()
            )

        val roundtrippedClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(clientEvent),
                jacksonTypeRef<ClientEvent>(),
            )

        assertThat(roundtrippedClientEvent).isEqualTo(clientEvent)
    }

    @Test
    fun ofSessionInputAudioMute() {
        val sessionInputAudioMute = InputAudioMuteEvent.builder().eventId("evt_mute_001").build()

        val clientEvent = ClientEvent.ofSessionInputAudioMute(sessionInputAudioMute)

        assertThat(clientEvent.sessionStart()).isEmpty
        assertThat(clientEvent.sessionUpdate()).isEmpty
        assertThat(clientEvent.sessionInputAudioAppend()).isEmpty
        assertThat(clientEvent.sessionInputAudioMute()).contains(sessionInputAudioMute)
        assertThat(clientEvent.sessionInputAudioUnmute()).isEmpty
        assertThat(clientEvent.sessionInstructionsAppend()).isEmpty
        assertThat(clientEvent.sessionThinkingAppend()).isEmpty
        assertThat(clientEvent.sessionCommentaryAppend()).isEmpty
        assertThat(clientEvent.responseItemCreate()).isEmpty
        assertThat(clientEvent.responseCreate()).isEmpty
        assertThat(clientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofSessionInputAudioMuteRoundtrip() {
        val jsonMapper = jsonMapper()
        val clientEvent =
            ClientEvent.ofSessionInputAudioMute(
                InputAudioMuteEvent.builder().eventId("evt_mute_001").build()
            )

        val roundtrippedClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(clientEvent),
                jacksonTypeRef<ClientEvent>(),
            )

        assertThat(roundtrippedClientEvent).isEqualTo(clientEvent)
    }

    @Test
    fun ofSessionInputAudioUnmute() {
        val sessionInputAudioUnmute =
            InputAudioUnmuteEvent.builder().eventId("evt_unmute_001").build()

        val clientEvent = ClientEvent.ofSessionInputAudioUnmute(sessionInputAudioUnmute)

        assertThat(clientEvent.sessionStart()).isEmpty
        assertThat(clientEvent.sessionUpdate()).isEmpty
        assertThat(clientEvent.sessionInputAudioAppend()).isEmpty
        assertThat(clientEvent.sessionInputAudioMute()).isEmpty
        assertThat(clientEvent.sessionInputAudioUnmute()).contains(sessionInputAudioUnmute)
        assertThat(clientEvent.sessionInstructionsAppend()).isEmpty
        assertThat(clientEvent.sessionThinkingAppend()).isEmpty
        assertThat(clientEvent.sessionCommentaryAppend()).isEmpty
        assertThat(clientEvent.responseItemCreate()).isEmpty
        assertThat(clientEvent.responseCreate()).isEmpty
        assertThat(clientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofSessionInputAudioUnmuteRoundtrip() {
        val jsonMapper = jsonMapper()
        val clientEvent =
            ClientEvent.ofSessionInputAudioUnmute(
                InputAudioUnmuteEvent.builder().eventId("evt_unmute_001").build()
            )

        val roundtrippedClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(clientEvent),
                jacksonTypeRef<ClientEvent>(),
            )

        assertThat(roundtrippedClientEvent).isEqualTo(clientEvent)
    }

    @Test
    fun ofSessionInstructionsAppend() {
        val sessionInstructionsAppend =
            InstructionsAppendEvent.builder()
                .content("The caller prefers outdoor seating.")
                .delegationId(null)
                .eventId("evt_instructions_001")
                .build()

        val clientEvent = ClientEvent.ofSessionInstructionsAppend(sessionInstructionsAppend)

        assertThat(clientEvent.sessionStart()).isEmpty
        assertThat(clientEvent.sessionUpdate()).isEmpty
        assertThat(clientEvent.sessionInputAudioAppend()).isEmpty
        assertThat(clientEvent.sessionInputAudioMute()).isEmpty
        assertThat(clientEvent.sessionInputAudioUnmute()).isEmpty
        assertThat(clientEvent.sessionInstructionsAppend()).contains(sessionInstructionsAppend)
        assertThat(clientEvent.sessionThinkingAppend()).isEmpty
        assertThat(clientEvent.sessionCommentaryAppend()).isEmpty
        assertThat(clientEvent.responseItemCreate()).isEmpty
        assertThat(clientEvent.responseCreate()).isEmpty
        assertThat(clientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofSessionInstructionsAppendRoundtrip() {
        val jsonMapper = jsonMapper()
        val clientEvent =
            ClientEvent.ofSessionInstructionsAppend(
                InstructionsAppendEvent.builder()
                    .content("The caller prefers outdoor seating.")
                    .delegationId(null)
                    .eventId("evt_instructions_001")
                    .build()
            )

        val roundtrippedClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(clientEvent),
                jacksonTypeRef<ClientEvent>(),
            )

        assertThat(roundtrippedClientEvent).isEqualTo(clientEvent)
    }

    @Test
    fun ofSessionThinkingAppend() {
        val sessionThinkingAppend =
            ThinkingAppendEvent.builder()
                .content("Checking availability for two guests at 7 PM.")
                .delegationId("del_abc123")
                .eventId("evt_thinking_001")
                .build()

        val clientEvent = ClientEvent.ofSessionThinkingAppend(sessionThinkingAppend)

        assertThat(clientEvent.sessionStart()).isEmpty
        assertThat(clientEvent.sessionUpdate()).isEmpty
        assertThat(clientEvent.sessionInputAudioAppend()).isEmpty
        assertThat(clientEvent.sessionInputAudioMute()).isEmpty
        assertThat(clientEvent.sessionInputAudioUnmute()).isEmpty
        assertThat(clientEvent.sessionInstructionsAppend()).isEmpty
        assertThat(clientEvent.sessionThinkingAppend()).contains(sessionThinkingAppend)
        assertThat(clientEvent.sessionCommentaryAppend()).isEmpty
        assertThat(clientEvent.responseItemCreate()).isEmpty
        assertThat(clientEvent.responseCreate()).isEmpty
        assertThat(clientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofSessionThinkingAppendRoundtrip() {
        val jsonMapper = jsonMapper()
        val clientEvent =
            ClientEvent.ofSessionThinkingAppend(
                ThinkingAppendEvent.builder()
                    .content("Checking availability for two guests at 7 PM.")
                    .delegationId("del_abc123")
                    .eventId("evt_thinking_001")
                    .build()
            )

        val roundtrippedClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(clientEvent),
                jacksonTypeRef<ClientEvent>(),
            )

        assertThat(roundtrippedClientEvent).isEqualTo(clientEvent)
    }

    @Test
    fun ofSessionCommentaryAppend() {
        val sessionCommentaryAppend =
            CommentaryAppendEvent.builder()
                .content("There is an outdoor table for two at 7 PM. Ask whether to reserve it.")
                .delegationId("del_abc123")
                .eventId("evt_commentary_001")
                .build()

        val clientEvent = ClientEvent.ofSessionCommentaryAppend(sessionCommentaryAppend)

        assertThat(clientEvent.sessionStart()).isEmpty
        assertThat(clientEvent.sessionUpdate()).isEmpty
        assertThat(clientEvent.sessionInputAudioAppend()).isEmpty
        assertThat(clientEvent.sessionInputAudioMute()).isEmpty
        assertThat(clientEvent.sessionInputAudioUnmute()).isEmpty
        assertThat(clientEvent.sessionInstructionsAppend()).isEmpty
        assertThat(clientEvent.sessionThinkingAppend()).isEmpty
        assertThat(clientEvent.sessionCommentaryAppend()).contains(sessionCommentaryAppend)
        assertThat(clientEvent.responseItemCreate()).isEmpty
        assertThat(clientEvent.responseCreate()).isEmpty
        assertThat(clientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofSessionCommentaryAppendRoundtrip() {
        val jsonMapper = jsonMapper()
        val clientEvent =
            ClientEvent.ofSessionCommentaryAppend(
                CommentaryAppendEvent.builder()
                    .content(
                        "There is an outdoor table for two at 7 PM. Ask whether to reserve it."
                    )
                    .delegationId("del_abc123")
                    .eventId("evt_commentary_001")
                    .build()
            )

        val roundtrippedClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(clientEvent),
                jacksonTypeRef<ClientEvent>(),
            )

        assertThat(roundtrippedClientEvent).isEqualTo(clientEvent)
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

        val clientEvent = ClientEvent.ofResponseItemCreate(responseItemCreate)

        assertThat(clientEvent.sessionStart()).isEmpty
        assertThat(clientEvent.sessionUpdate()).isEmpty
        assertThat(clientEvent.sessionInputAudioAppend()).isEmpty
        assertThat(clientEvent.sessionInputAudioMute()).isEmpty
        assertThat(clientEvent.sessionInputAudioUnmute()).isEmpty
        assertThat(clientEvent.sessionInstructionsAppend()).isEmpty
        assertThat(clientEvent.sessionThinkingAppend()).isEmpty
        assertThat(clientEvent.sessionCommentaryAppend()).isEmpty
        assertThat(clientEvent.responseItemCreate()).contains(responseItemCreate)
        assertThat(clientEvent.responseCreate()).isEmpty
        assertThat(clientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofResponseItemCreateRoundtrip() {
        val jsonMapper = jsonMapper()
        val clientEvent =
            ClientEvent.ofResponseItemCreate(
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

        val roundtrippedClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(clientEvent),
                jacksonTypeRef<ClientEvent>(),
            )

        assertThat(roundtrippedClientEvent).isEqualTo(clientEvent)
    }

    @Test
    fun ofResponseCreate() {
        val responseCreate = ResponseCreateEvent.builder().eventId("evt_response_001").build()

        val clientEvent = ClientEvent.ofResponseCreate(responseCreate)

        assertThat(clientEvent.sessionStart()).isEmpty
        assertThat(clientEvent.sessionUpdate()).isEmpty
        assertThat(clientEvent.sessionInputAudioAppend()).isEmpty
        assertThat(clientEvent.sessionInputAudioMute()).isEmpty
        assertThat(clientEvent.sessionInputAudioUnmute()).isEmpty
        assertThat(clientEvent.sessionInstructionsAppend()).isEmpty
        assertThat(clientEvent.sessionThinkingAppend()).isEmpty
        assertThat(clientEvent.sessionCommentaryAppend()).isEmpty
        assertThat(clientEvent.responseItemCreate()).isEmpty
        assertThat(clientEvent.responseCreate()).contains(responseCreate)
        assertThat(clientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofResponseCreateRoundtrip() {
        val jsonMapper = jsonMapper()
        val clientEvent =
            ClientEvent.ofResponseCreate(
                ResponseCreateEvent.builder().eventId("evt_response_001").build()
            )

        val roundtrippedClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(clientEvent),
                jacksonTypeRef<ClientEvent>(),
            )

        assertThat(roundtrippedClientEvent).isEqualTo(clientEvent)
    }

    @Test
    fun ofSessionClose() {
        val sessionClose = SessionCloseEvent.builder().eventId("evt_close_001").build()

        val clientEvent = ClientEvent.ofSessionClose(sessionClose)

        assertThat(clientEvent.sessionStart()).isEmpty
        assertThat(clientEvent.sessionUpdate()).isEmpty
        assertThat(clientEvent.sessionInputAudioAppend()).isEmpty
        assertThat(clientEvent.sessionInputAudioMute()).isEmpty
        assertThat(clientEvent.sessionInputAudioUnmute()).isEmpty
        assertThat(clientEvent.sessionInstructionsAppend()).isEmpty
        assertThat(clientEvent.sessionThinkingAppend()).isEmpty
        assertThat(clientEvent.sessionCommentaryAppend()).isEmpty
        assertThat(clientEvent.responseItemCreate()).isEmpty
        assertThat(clientEvent.responseCreate()).isEmpty
        assertThat(clientEvent.sessionClose()).contains(sessionClose)
    }

    @Test
    fun ofSessionCloseRoundtrip() {
        val jsonMapper = jsonMapper()
        val clientEvent =
            ClientEvent.ofSessionClose(SessionCloseEvent.builder().eventId("evt_close_001").build())

        val roundtrippedClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(clientEvent),
                jacksonTypeRef<ClientEvent>(),
            )

        assertThat(roundtrippedClientEvent).isEqualTo(clientEvent)
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
        val clientEvent = jsonMapper().convertValue(testCase.value, jacksonTypeRef<ClientEvent>())

        val e = assertThrows<OpenAIInvalidDataException> { clientEvent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
