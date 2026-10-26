// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OutputAudioFixturePlayedEventTest {

    @Test
    fun createAndRoundtrip() {
        val outputAudioFixturePlayedEvent =
            OutputAudioFixturePlayedEvent.builder()
                .eventId("evt_played_001")
                .clientEventId("evt_play_001")
                .build()

        assertThat(outputAudioFixturePlayedEvent.eventId()).isEqualTo("evt_played_001")
        assertThat(outputAudioFixturePlayedEvent.clientEventId()).contains("evt_play_001")

        val jsonMapper = jsonMapper()

        val roundtrippedOutputAudioFixturePlayedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(outputAudioFixturePlayedEvent),
                jacksonTypeRef<OutputAudioFixturePlayedEvent>(),
            )

        assertThat(roundtrippedOutputAudioFixturePlayedEvent)
            .isEqualTo(outputAudioFixturePlayedEvent)
    }
}
