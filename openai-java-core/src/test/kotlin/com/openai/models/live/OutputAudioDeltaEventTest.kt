// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OutputAudioDeltaEventTest {

    @Test
    fun create() {
        val outputAudioDeltaEvent =
            OutputAudioDeltaEvent.builder()
                .delta("AACAAIAAAIAAAP9/AIAAgA==")
                .endMs(1200L)
                .startMs(1000L)
                .build()

        assertThat(outputAudioDeltaEvent.delta()).isEqualTo("AACAAIAAAIAAAP9/AIAAgA==")
        assertThat(outputAudioDeltaEvent.endMs()).contains(1200L)
        assertThat(outputAudioDeltaEvent.startMs()).contains(1000L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val outputAudioDeltaEvent =
            OutputAudioDeltaEvent.builder()
                .delta("AACAAIAAAIAAAP9/AIAAgA==")
                .endMs(1200L)
                .startMs(1000L)
                .build()

        val roundtrippedOutputAudioDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(outputAudioDeltaEvent),
                jacksonTypeRef<OutputAudioDeltaEvent>(),
            )

        assertThat(roundtrippedOutputAudioDeltaEvent).isEqualTo(outputAudioDeltaEvent)
    }
}
