// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OutputAudioFixturePlayingEventTest {

    @Test
    fun createAndRoundtrip() {
        val outputAudioFixturePlayingEvent =
            OutputAudioFixturePlayingEvent.builder()
                .eventId("evt_playing_001")
                .clientEventId("evt_play_001")
                .build()

        assertThat(outputAudioFixturePlayingEvent.eventId()).isEqualTo("evt_playing_001")
        assertThat(outputAudioFixturePlayingEvent.clientEventId()).contains("evt_play_001")

        val jsonMapper = jsonMapper()

        val roundtrippedOutputAudioFixturePlayingEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(outputAudioFixturePlayingEvent),
                jacksonTypeRef<OutputAudioFixturePlayingEvent>(),
            )

        assertThat(roundtrippedOutputAudioFixturePlayingEvent)
            .isEqualTo(outputAudioFixturePlayingEvent)
    }
}
