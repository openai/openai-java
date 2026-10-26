// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OutputAudioFixturePlayEventTest {

    @Test
    fun createAndRoundtrip() {
        val outputAudioFixturePlayEvent =
            OutputAudioFixturePlayEvent.builder().audio("AAAAAA==").eventId("evt_play_001").build()

        assertThat(outputAudioFixturePlayEvent.audio()).isEqualTo("AAAAAA==")
        assertThat(outputAudioFixturePlayEvent.eventId()).contains("evt_play_001")

        val jsonMapper = jsonMapper()

        val roundtrippedOutputAudioFixturePlayEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(outputAudioFixturePlayEvent),
                jacksonTypeRef<OutputAudioFixturePlayEvent>(),
            )

        assertThat(roundtrippedOutputAudioFixturePlayEvent).isEqualTo(outputAudioFixturePlayEvent)
    }
}
