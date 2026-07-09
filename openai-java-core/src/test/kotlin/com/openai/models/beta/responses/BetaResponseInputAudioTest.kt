// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseInputAudioTest {

    @Test
    fun create() {
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
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseInputAudio =
            BetaResponseInputAudio.builder()
                .inputAudio(
                    BetaResponseInputAudio.InputAudio.builder()
                        .data("data")
                        .format(BetaResponseInputAudio.InputAudio.Format.MP3)
                        .build()
                )
                .build()

        val roundtrippedBetaResponseInputAudio =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseInputAudio),
                jacksonTypeRef<BetaResponseInputAudio>(),
            )

        assertThat(roundtrippedBetaResponseInputAudio).isEqualTo(betaResponseInputAudio)
    }
}
