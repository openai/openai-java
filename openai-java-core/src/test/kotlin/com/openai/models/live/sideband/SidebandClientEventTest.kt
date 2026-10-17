// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live.sideband

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.live.CommentaryAppendEvent
import com.openai.models.live.DecisionCreateEvent
import com.openai.models.live.DecisionItemCreateEvent
import com.openai.models.live.DecisionItemDeleteEvent
import com.openai.models.live.DecisionTrigger
import com.openai.models.live.FunctionTool
import com.openai.models.live.InputAudioMuteEvent
import com.openai.models.live.InputAudioUnmuteEvent
import com.openai.models.live.InstructionsAppendEvent
import com.openai.models.live.OutputAudioFixturePlayEvent
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

internal class SidebandClientEventTest {

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
                .eventId("evt_update_001")
                .build()

        val sidebandClientEvent = SidebandClientEvent.ofSessionUpdate(sessionUpdate)

        assertThat(sidebandClientEvent.sessionUpdate()).contains(sessionUpdate)
        assertThat(sidebandClientEvent.sessionInputAudioMute()).isEmpty
        assertThat(sidebandClientEvent.sessionInputAudioUnmute()).isEmpty
        assertThat(sidebandClientEvent.sessionOutputAudioFixturePlay()).isEmpty
        assertThat(sidebandClientEvent.sessionInstructionsAppend()).isEmpty
        assertThat(sidebandClientEvent.sessionThinkingAppend()).isEmpty
        assertThat(sidebandClientEvent.sessionCommentaryAppend()).isEmpty
        assertThat(sidebandClientEvent.decisionCreate()).isEmpty
        assertThat(sidebandClientEvent.decisionItemCreate()).isEmpty
        assertThat(sidebandClientEvent.decisionItemDelete()).isEmpty
        assertThat(sidebandClientEvent.responseItemCreate()).isEmpty
        assertThat(sidebandClientEvent.responseCreate()).isEmpty
        assertThat(sidebandClientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofSessionUpdateRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandClientEvent =
            SidebandClientEvent.ofSessionUpdate(
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
                    .eventId("evt_update_001")
                    .build()
            )

        val roundtrippedSidebandClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandClientEvent),
                jacksonTypeRef<SidebandClientEvent>(),
            )

        assertThat(roundtrippedSidebandClientEvent).isEqualTo(sidebandClientEvent)
    }

    @Test
    fun ofSessionInputAudioMute() {
        val sessionInputAudioMute = InputAudioMuteEvent.builder().eventId("evt_mute_001").build()

        val sidebandClientEvent = SidebandClientEvent.ofSessionInputAudioMute(sessionInputAudioMute)

        assertThat(sidebandClientEvent.sessionUpdate()).isEmpty
        assertThat(sidebandClientEvent.sessionInputAudioMute()).contains(sessionInputAudioMute)
        assertThat(sidebandClientEvent.sessionInputAudioUnmute()).isEmpty
        assertThat(sidebandClientEvent.sessionOutputAudioFixturePlay()).isEmpty
        assertThat(sidebandClientEvent.sessionInstructionsAppend()).isEmpty
        assertThat(sidebandClientEvent.sessionThinkingAppend()).isEmpty
        assertThat(sidebandClientEvent.sessionCommentaryAppend()).isEmpty
        assertThat(sidebandClientEvent.decisionCreate()).isEmpty
        assertThat(sidebandClientEvent.decisionItemCreate()).isEmpty
        assertThat(sidebandClientEvent.decisionItemDelete()).isEmpty
        assertThat(sidebandClientEvent.responseItemCreate()).isEmpty
        assertThat(sidebandClientEvent.responseCreate()).isEmpty
        assertThat(sidebandClientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofSessionInputAudioMuteRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandClientEvent =
            SidebandClientEvent.ofSessionInputAudioMute(
                InputAudioMuteEvent.builder().eventId("evt_mute_001").build()
            )

        val roundtrippedSidebandClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandClientEvent),
                jacksonTypeRef<SidebandClientEvent>(),
            )

        assertThat(roundtrippedSidebandClientEvent).isEqualTo(sidebandClientEvent)
    }

    @Test
    fun ofSessionInputAudioUnmute() {
        val sessionInputAudioUnmute =
            InputAudioUnmuteEvent.builder().eventId("evt_unmute_001").build()

        val sidebandClientEvent =
            SidebandClientEvent.ofSessionInputAudioUnmute(sessionInputAudioUnmute)

        assertThat(sidebandClientEvent.sessionUpdate()).isEmpty
        assertThat(sidebandClientEvent.sessionInputAudioMute()).isEmpty
        assertThat(sidebandClientEvent.sessionInputAudioUnmute()).contains(sessionInputAudioUnmute)
        assertThat(sidebandClientEvent.sessionOutputAudioFixturePlay()).isEmpty
        assertThat(sidebandClientEvent.sessionInstructionsAppend()).isEmpty
        assertThat(sidebandClientEvent.sessionThinkingAppend()).isEmpty
        assertThat(sidebandClientEvent.sessionCommentaryAppend()).isEmpty
        assertThat(sidebandClientEvent.decisionCreate()).isEmpty
        assertThat(sidebandClientEvent.decisionItemCreate()).isEmpty
        assertThat(sidebandClientEvent.decisionItemDelete()).isEmpty
        assertThat(sidebandClientEvent.responseItemCreate()).isEmpty
        assertThat(sidebandClientEvent.responseCreate()).isEmpty
        assertThat(sidebandClientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofSessionInputAudioUnmuteRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandClientEvent =
            SidebandClientEvent.ofSessionInputAudioUnmute(
                InputAudioUnmuteEvent.builder().eventId("evt_unmute_001").build()
            )

        val roundtrippedSidebandClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandClientEvent),
                jacksonTypeRef<SidebandClientEvent>(),
            )

        assertThat(roundtrippedSidebandClientEvent).isEqualTo(sidebandClientEvent)
    }

    @Test
    fun ofSessionOutputAudioFixturePlay() {
        val sessionOutputAudioFixturePlay =
            OutputAudioFixturePlayEvent.builder().audio("AAAAAA==").eventId("evt_play_001").build()

        val sidebandClientEvent =
            SidebandClientEvent.ofSessionOutputAudioFixturePlay(sessionOutputAudioFixturePlay)

        assertThat(sidebandClientEvent.sessionUpdate()).isEmpty
        assertThat(sidebandClientEvent.sessionInputAudioMute()).isEmpty
        assertThat(sidebandClientEvent.sessionInputAudioUnmute()).isEmpty
        assertThat(sidebandClientEvent.sessionOutputAudioFixturePlay())
            .contains(sessionOutputAudioFixturePlay)
        assertThat(sidebandClientEvent.sessionInstructionsAppend()).isEmpty
        assertThat(sidebandClientEvent.sessionThinkingAppend()).isEmpty
        assertThat(sidebandClientEvent.sessionCommentaryAppend()).isEmpty
        assertThat(sidebandClientEvent.decisionCreate()).isEmpty
        assertThat(sidebandClientEvent.decisionItemCreate()).isEmpty
        assertThat(sidebandClientEvent.decisionItemDelete()).isEmpty
        assertThat(sidebandClientEvent.responseItemCreate()).isEmpty
        assertThat(sidebandClientEvent.responseCreate()).isEmpty
        assertThat(sidebandClientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofSessionOutputAudioFixturePlayRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandClientEvent =
            SidebandClientEvent.ofSessionOutputAudioFixturePlay(
                OutputAudioFixturePlayEvent.builder()
                    .audio("AAAAAA==")
                    .eventId("evt_play_001")
                    .build()
            )

        val roundtrippedSidebandClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandClientEvent),
                jacksonTypeRef<SidebandClientEvent>(),
            )

        assertThat(roundtrippedSidebandClientEvent).isEqualTo(sidebandClientEvent)
    }

    @Test
    fun ofSessionInstructionsAppend() {
        val sessionInstructionsAppend =
            InstructionsAppendEvent.builder()
                .content("The caller prefers outdoor seating.")
                .delegationId(null)
                .eventId("evt_instructions_001")
                .build()

        val sidebandClientEvent =
            SidebandClientEvent.ofSessionInstructionsAppend(sessionInstructionsAppend)

        assertThat(sidebandClientEvent.sessionUpdate()).isEmpty
        assertThat(sidebandClientEvent.sessionInputAudioMute()).isEmpty
        assertThat(sidebandClientEvent.sessionInputAudioUnmute()).isEmpty
        assertThat(sidebandClientEvent.sessionOutputAudioFixturePlay()).isEmpty
        assertThat(sidebandClientEvent.sessionInstructionsAppend())
            .contains(sessionInstructionsAppend)
        assertThat(sidebandClientEvent.sessionThinkingAppend()).isEmpty
        assertThat(sidebandClientEvent.sessionCommentaryAppend()).isEmpty
        assertThat(sidebandClientEvent.decisionCreate()).isEmpty
        assertThat(sidebandClientEvent.decisionItemCreate()).isEmpty
        assertThat(sidebandClientEvent.decisionItemDelete()).isEmpty
        assertThat(sidebandClientEvent.responseItemCreate()).isEmpty
        assertThat(sidebandClientEvent.responseCreate()).isEmpty
        assertThat(sidebandClientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofSessionInstructionsAppendRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandClientEvent =
            SidebandClientEvent.ofSessionInstructionsAppend(
                InstructionsAppendEvent.builder()
                    .content("The caller prefers outdoor seating.")
                    .delegationId(null)
                    .eventId("evt_instructions_001")
                    .build()
            )

        val roundtrippedSidebandClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandClientEvent),
                jacksonTypeRef<SidebandClientEvent>(),
            )

        assertThat(roundtrippedSidebandClientEvent).isEqualTo(sidebandClientEvent)
    }

    @Test
    fun ofSessionThinkingAppend() {
        val sessionThinkingAppend =
            ThinkingAppendEvent.builder()
                .content("Checking availability for two guests at 7 PM.")
                .delegationId("del_abc123")
                .eventId("evt_thinking_001")
                .build()

        val sidebandClientEvent = SidebandClientEvent.ofSessionThinkingAppend(sessionThinkingAppend)

        assertThat(sidebandClientEvent.sessionUpdate()).isEmpty
        assertThat(sidebandClientEvent.sessionInputAudioMute()).isEmpty
        assertThat(sidebandClientEvent.sessionInputAudioUnmute()).isEmpty
        assertThat(sidebandClientEvent.sessionOutputAudioFixturePlay()).isEmpty
        assertThat(sidebandClientEvent.sessionInstructionsAppend()).isEmpty
        assertThat(sidebandClientEvent.sessionThinkingAppend()).contains(sessionThinkingAppend)
        assertThat(sidebandClientEvent.sessionCommentaryAppend()).isEmpty
        assertThat(sidebandClientEvent.decisionCreate()).isEmpty
        assertThat(sidebandClientEvent.decisionItemCreate()).isEmpty
        assertThat(sidebandClientEvent.decisionItemDelete()).isEmpty
        assertThat(sidebandClientEvent.responseItemCreate()).isEmpty
        assertThat(sidebandClientEvent.responseCreate()).isEmpty
        assertThat(sidebandClientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofSessionThinkingAppendRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandClientEvent =
            SidebandClientEvent.ofSessionThinkingAppend(
                ThinkingAppendEvent.builder()
                    .content("Checking availability for two guests at 7 PM.")
                    .delegationId("del_abc123")
                    .eventId("evt_thinking_001")
                    .build()
            )

        val roundtrippedSidebandClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandClientEvent),
                jacksonTypeRef<SidebandClientEvent>(),
            )

        assertThat(roundtrippedSidebandClientEvent).isEqualTo(sidebandClientEvent)
    }

    @Test
    fun ofSessionCommentaryAppend() {
        val sessionCommentaryAppend =
            CommentaryAppendEvent.builder()
                .content("There is an outdoor table for two at 7 PM. Ask whether to reserve it.")
                .delegationId("del_abc123")
                .eventId("evt_commentary_001")
                .build()

        val sidebandClientEvent =
            SidebandClientEvent.ofSessionCommentaryAppend(sessionCommentaryAppend)

        assertThat(sidebandClientEvent.sessionUpdate()).isEmpty
        assertThat(sidebandClientEvent.sessionInputAudioMute()).isEmpty
        assertThat(sidebandClientEvent.sessionInputAudioUnmute()).isEmpty
        assertThat(sidebandClientEvent.sessionOutputAudioFixturePlay()).isEmpty
        assertThat(sidebandClientEvent.sessionInstructionsAppend()).isEmpty
        assertThat(sidebandClientEvent.sessionThinkingAppend()).isEmpty
        assertThat(sidebandClientEvent.sessionCommentaryAppend()).contains(sessionCommentaryAppend)
        assertThat(sidebandClientEvent.decisionCreate()).isEmpty
        assertThat(sidebandClientEvent.decisionItemCreate()).isEmpty
        assertThat(sidebandClientEvent.decisionItemDelete()).isEmpty
        assertThat(sidebandClientEvent.responseItemCreate()).isEmpty
        assertThat(sidebandClientEvent.responseCreate()).isEmpty
        assertThat(sidebandClientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofSessionCommentaryAppendRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandClientEvent =
            SidebandClientEvent.ofSessionCommentaryAppend(
                CommentaryAppendEvent.builder()
                    .content(
                        "There is an outdoor table for two at 7 PM. Ask whether to reserve it."
                    )
                    .delegationId("del_abc123")
                    .eventId("evt_commentary_001")
                    .build()
            )

        val roundtrippedSidebandClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandClientEvent),
                jacksonTypeRef<SidebandClientEvent>(),
            )

        assertThat(roundtrippedSidebandClientEvent).isEqualTo(sidebandClientEvent)
    }

    @Test
    fun ofDecisionCreate() {
        val decisionCreate = DecisionCreateEvent.builder().eventId("decision_1").build()

        val sidebandClientEvent = SidebandClientEvent.ofDecisionCreate(decisionCreate)

        assertThat(sidebandClientEvent.sessionUpdate()).isEmpty
        assertThat(sidebandClientEvent.sessionInputAudioMute()).isEmpty
        assertThat(sidebandClientEvent.sessionInputAudioUnmute()).isEmpty
        assertThat(sidebandClientEvent.sessionOutputAudioFixturePlay()).isEmpty
        assertThat(sidebandClientEvent.sessionInstructionsAppend()).isEmpty
        assertThat(sidebandClientEvent.sessionThinkingAppend()).isEmpty
        assertThat(sidebandClientEvent.sessionCommentaryAppend()).isEmpty
        assertThat(sidebandClientEvent.decisionCreate()).contains(decisionCreate)
        assertThat(sidebandClientEvent.decisionItemCreate()).isEmpty
        assertThat(sidebandClientEvent.decisionItemDelete()).isEmpty
        assertThat(sidebandClientEvent.responseItemCreate()).isEmpty
        assertThat(sidebandClientEvent.responseCreate()).isEmpty
        assertThat(sidebandClientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofDecisionCreateRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandClientEvent =
            SidebandClientEvent.ofDecisionCreate(
                DecisionCreateEvent.builder().eventId("decision_1").build()
            )

        val roundtrippedSidebandClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandClientEvent),
                jacksonTypeRef<SidebandClientEvent>(),
            )

        assertThat(roundtrippedSidebandClientEvent).isEqualTo(sidebandClientEvent)
    }

    @Test
    fun ofDecisionItemCreate() {
        val decisionItemCreate =
            DecisionItemCreateEvent.builder()
                .item(
                    DecisionItemCreateEvent.Item.builder()
                        .content("string")
                        .id("id")
                        .type(DecisionItemCreateEvent.Item.Type.MESSAGE)
                        .build()
                )
                .eventId("browser_1")
                .build()

        val sidebandClientEvent = SidebandClientEvent.ofDecisionItemCreate(decisionItemCreate)

        assertThat(sidebandClientEvent.sessionUpdate()).isEmpty
        assertThat(sidebandClientEvent.sessionInputAudioMute()).isEmpty
        assertThat(sidebandClientEvent.sessionInputAudioUnmute()).isEmpty
        assertThat(sidebandClientEvent.sessionOutputAudioFixturePlay()).isEmpty
        assertThat(sidebandClientEvent.sessionInstructionsAppend()).isEmpty
        assertThat(sidebandClientEvent.sessionThinkingAppend()).isEmpty
        assertThat(sidebandClientEvent.sessionCommentaryAppend()).isEmpty
        assertThat(sidebandClientEvent.decisionCreate()).isEmpty
        assertThat(sidebandClientEvent.decisionItemCreate()).contains(decisionItemCreate)
        assertThat(sidebandClientEvent.decisionItemDelete()).isEmpty
        assertThat(sidebandClientEvent.responseItemCreate()).isEmpty
        assertThat(sidebandClientEvent.responseCreate()).isEmpty
        assertThat(sidebandClientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofDecisionItemCreateRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandClientEvent =
            SidebandClientEvent.ofDecisionItemCreate(
                DecisionItemCreateEvent.builder()
                    .item(
                        DecisionItemCreateEvent.Item.builder()
                            .content("string")
                            .id("id")
                            .type(DecisionItemCreateEvent.Item.Type.MESSAGE)
                            .build()
                    )
                    .eventId("browser_1")
                    .build()
            )

        val roundtrippedSidebandClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandClientEvent),
                jacksonTypeRef<SidebandClientEvent>(),
            )

        assertThat(roundtrippedSidebandClientEvent).isEqualTo(sidebandClientEvent)
    }

    @Test
    fun ofDecisionItemDelete() {
        val decisionItemDelete =
            DecisionItemDeleteEvent.builder()
                .itemId("msg_browser_1")
                .eventId("remove_browser_1")
                .build()

        val sidebandClientEvent = SidebandClientEvent.ofDecisionItemDelete(decisionItemDelete)

        assertThat(sidebandClientEvent.sessionUpdate()).isEmpty
        assertThat(sidebandClientEvent.sessionInputAudioMute()).isEmpty
        assertThat(sidebandClientEvent.sessionInputAudioUnmute()).isEmpty
        assertThat(sidebandClientEvent.sessionOutputAudioFixturePlay()).isEmpty
        assertThat(sidebandClientEvent.sessionInstructionsAppend()).isEmpty
        assertThat(sidebandClientEvent.sessionThinkingAppend()).isEmpty
        assertThat(sidebandClientEvent.sessionCommentaryAppend()).isEmpty
        assertThat(sidebandClientEvent.decisionCreate()).isEmpty
        assertThat(sidebandClientEvent.decisionItemCreate()).isEmpty
        assertThat(sidebandClientEvent.decisionItemDelete()).contains(decisionItemDelete)
        assertThat(sidebandClientEvent.responseItemCreate()).isEmpty
        assertThat(sidebandClientEvent.responseCreate()).isEmpty
        assertThat(sidebandClientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofDecisionItemDeleteRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandClientEvent =
            SidebandClientEvent.ofDecisionItemDelete(
                DecisionItemDeleteEvent.builder()
                    .itemId("msg_browser_1")
                    .eventId("remove_browser_1")
                    .build()
            )

        val roundtrippedSidebandClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandClientEvent),
                jacksonTypeRef<SidebandClientEvent>(),
            )

        assertThat(roundtrippedSidebandClientEvent).isEqualTo(sidebandClientEvent)
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

        val sidebandClientEvent = SidebandClientEvent.ofResponseItemCreate(responseItemCreate)

        assertThat(sidebandClientEvent.sessionUpdate()).isEmpty
        assertThat(sidebandClientEvent.sessionInputAudioMute()).isEmpty
        assertThat(sidebandClientEvent.sessionInputAudioUnmute()).isEmpty
        assertThat(sidebandClientEvent.sessionOutputAudioFixturePlay()).isEmpty
        assertThat(sidebandClientEvent.sessionInstructionsAppend()).isEmpty
        assertThat(sidebandClientEvent.sessionThinkingAppend()).isEmpty
        assertThat(sidebandClientEvent.sessionCommentaryAppend()).isEmpty
        assertThat(sidebandClientEvent.decisionCreate()).isEmpty
        assertThat(sidebandClientEvent.decisionItemCreate()).isEmpty
        assertThat(sidebandClientEvent.decisionItemDelete()).isEmpty
        assertThat(sidebandClientEvent.responseItemCreate()).contains(responseItemCreate)
        assertThat(sidebandClientEvent.responseCreate()).isEmpty
        assertThat(sidebandClientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofResponseItemCreateRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandClientEvent =
            SidebandClientEvent.ofResponseItemCreate(
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

        val roundtrippedSidebandClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandClientEvent),
                jacksonTypeRef<SidebandClientEvent>(),
            )

        assertThat(roundtrippedSidebandClientEvent).isEqualTo(sidebandClientEvent)
    }

    @Test
    fun ofResponseCreate() {
        val responseCreate = ResponseCreateEvent.builder().eventId("evt_response_001").build()

        val sidebandClientEvent = SidebandClientEvent.ofResponseCreate(responseCreate)

        assertThat(sidebandClientEvent.sessionUpdate()).isEmpty
        assertThat(sidebandClientEvent.sessionInputAudioMute()).isEmpty
        assertThat(sidebandClientEvent.sessionInputAudioUnmute()).isEmpty
        assertThat(sidebandClientEvent.sessionOutputAudioFixturePlay()).isEmpty
        assertThat(sidebandClientEvent.sessionInstructionsAppend()).isEmpty
        assertThat(sidebandClientEvent.sessionThinkingAppend()).isEmpty
        assertThat(sidebandClientEvent.sessionCommentaryAppend()).isEmpty
        assertThat(sidebandClientEvent.decisionCreate()).isEmpty
        assertThat(sidebandClientEvent.decisionItemCreate()).isEmpty
        assertThat(sidebandClientEvent.decisionItemDelete()).isEmpty
        assertThat(sidebandClientEvent.responseItemCreate()).isEmpty
        assertThat(sidebandClientEvent.responseCreate()).contains(responseCreate)
        assertThat(sidebandClientEvent.sessionClose()).isEmpty
    }

    @Test
    fun ofResponseCreateRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandClientEvent =
            SidebandClientEvent.ofResponseCreate(
                ResponseCreateEvent.builder().eventId("evt_response_001").build()
            )

        val roundtrippedSidebandClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandClientEvent),
                jacksonTypeRef<SidebandClientEvent>(),
            )

        assertThat(roundtrippedSidebandClientEvent).isEqualTo(sidebandClientEvent)
    }

    @Test
    fun ofSessionClose() {
        val sessionClose = SessionCloseEvent.builder().eventId("evt_close_001").build()

        val sidebandClientEvent = SidebandClientEvent.ofSessionClose(sessionClose)

        assertThat(sidebandClientEvent.sessionUpdate()).isEmpty
        assertThat(sidebandClientEvent.sessionInputAudioMute()).isEmpty
        assertThat(sidebandClientEvent.sessionInputAudioUnmute()).isEmpty
        assertThat(sidebandClientEvent.sessionOutputAudioFixturePlay()).isEmpty
        assertThat(sidebandClientEvent.sessionInstructionsAppend()).isEmpty
        assertThat(sidebandClientEvent.sessionThinkingAppend()).isEmpty
        assertThat(sidebandClientEvent.sessionCommentaryAppend()).isEmpty
        assertThat(sidebandClientEvent.decisionCreate()).isEmpty
        assertThat(sidebandClientEvent.decisionItemCreate()).isEmpty
        assertThat(sidebandClientEvent.decisionItemDelete()).isEmpty
        assertThat(sidebandClientEvent.responseItemCreate()).isEmpty
        assertThat(sidebandClientEvent.responseCreate()).isEmpty
        assertThat(sidebandClientEvent.sessionClose()).contains(sessionClose)
    }

    @Test
    fun ofSessionCloseRoundtrip() {
        val jsonMapper = jsonMapper()
        val sidebandClientEvent =
            SidebandClientEvent.ofSessionClose(
                SessionCloseEvent.builder().eventId("evt_close_001").build()
            )

        val roundtrippedSidebandClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sidebandClientEvent),
                jacksonTypeRef<SidebandClientEvent>(),
            )

        assertThat(roundtrippedSidebandClientEvent).isEqualTo(sidebandClientEvent)
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
        val sidebandClientEvent =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<SidebandClientEvent>())

        val e = assertThrows<OpenAIInvalidDataException> { sidebandClientEvent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
