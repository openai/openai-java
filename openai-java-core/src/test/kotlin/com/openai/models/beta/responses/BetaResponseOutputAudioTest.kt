// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseOutputAudioTest {

    @Test
    fun create() {
        val betaResponseOutputAudio =
            BetaResponseOutputAudio.builder().data("data").transcript("transcript").build()

        assertThat(betaResponseOutputAudio.data()).isEqualTo("data")
        assertThat(betaResponseOutputAudio.transcript()).isEqualTo("transcript")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputAudio =
            BetaResponseOutputAudio.builder().data("data").transcript("transcript").build()

        val roundtrippedBetaResponseOutputAudio =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputAudio),
                jacksonTypeRef<BetaResponseOutputAudio>(),
            )

        assertThat(roundtrippedBetaResponseOutputAudio).isEqualTo(betaResponseOutputAudio)
    }
}
