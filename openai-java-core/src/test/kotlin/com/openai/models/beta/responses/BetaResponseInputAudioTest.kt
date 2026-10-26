// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseInputAudioTest {

    @Test
    fun createAndRoundtrip() {
        val betaResponseInputAudio =
            BetaResponseInputAudio.builder()
                .inputAudio(
                    BetaResponseInputAudio.InputAudio.builder()
                        .data("data")
                        .format(BetaResponseInputAudio.InputAudio.Format.MP3)
                        .build()
                )
                .build()

        assertThat(betaResponseInputAudio.inputAudio())
            .isEqualTo(
                BetaResponseInputAudio.InputAudio.builder()
                    .data("data")
                    .format(BetaResponseInputAudio.InputAudio.Format.MP3)
                    .build()
            )

        val jsonMapper = jsonMapper()

        val roundtrippedBetaResponseInputAudio =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputAudio),
                jacksonTypeRef<BetaResponseInputAudio>(),
            )

        assertThat(roundtrippedBetaResponseInputAudio).isEqualTo(betaResponseInputAudio)
    }
}
