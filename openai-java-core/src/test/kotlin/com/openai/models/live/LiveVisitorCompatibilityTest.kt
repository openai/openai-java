package com.openai.models.live

import com.openai.core.JsonValue
import com.openai.models.live.forks.ForkClientEvent
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LiveVisitorCompatibilityTest {
    @Test
    fun visitorWrittenBeforeFixturePlaybackHandlesFixtureAsUnknown() {
        val visitor =
            object : ClientEvent.Visitor<JsonValue?> {
                override fun visitSessionStart(sessionStart: SessionStartEvent) = null

                override fun visitSessionUpdate(sessionUpdate: SessionUpdateEvent) = null

                override fun visitSessionInputAudioAppend(
                    sessionInputAudioAppend: InputAudioAppendEvent
                ) = null

                override fun visitSessionInputAudioMute(
                    sessionInputAudioMute: InputAudioMuteEvent
                ) = null

                override fun visitSessionInputAudioUnmute(
                    sessionInputAudioUnmute: InputAudioUnmuteEvent
                ) = null

                override fun visitSessionInstructionsAppend(
                    sessionInstructionsAppend: InstructionsAppendEvent
                ) = null

                override fun visitSessionThinkingAppend(
                    sessionThinkingAppend: ThinkingAppendEvent
                ) = null

                override fun visitSessionCommentaryAppend(
                    sessionCommentaryAppend: CommentaryAppendEvent
                ) = null

                override fun visitResponseItemCreate(responseItemCreate: ResponseItemCreateEvent) =
                    null

                override fun visitResponseCreate(responseCreate: ResponseCreateEvent) = null

                override fun visitSessionClose(sessionClose: SessionCloseEvent) = null

                override fun unknown(json: JsonValue?) = json
            }
        val fixture = OutputAudioFixturePlayEvent.builder().audio("AAABAA==").build()

        assertThat(ClientEvent.ofSessionOutputAudioFixturePlay(fixture).accept(visitor))
            .isEqualTo(JsonValue.from(fixture))
    }

    @Test
    fun fixtureVisitorMethodsAreJvmDefaults() {
        for ((visitor, method, event) in
            listOf(
                Triple(
                    ClientEvent.Visitor::class.java,
                    "visitSessionOutputAudioFixturePlay",
                    OutputAudioFixturePlayEvent::class.java,
                ),
                Triple(
                    ForkClientEvent.Visitor::class.java,
                    "visitSessionOutputAudioFixturePlay",
                    OutputAudioFixturePlayEvent::class.java,
                ),
                Triple(
                    ServerEvent.Visitor::class.java,
                    "visitSessionOutputAudioFixturePlaying",
                    OutputAudioFixturePlayingEvent::class.java,
                ),
                Triple(
                    ServerEvent.Visitor::class.java,
                    "visitSessionOutputAudioFixturePlayed",
                    OutputAudioFixturePlayedEvent::class.java,
                ),
            )) {
            assertThat(visitor.getMethod(method, event).isDefault)
                .describedAs("%s.%s is a JVM default method", visitor.name, method)
                .isTrue()
        }
    }
}
