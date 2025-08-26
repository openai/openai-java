// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LobProbTest {

    @Test
    fun create() {
        val lobProb =
            LobProb.builder()
                .token("token")
                .addByte(0L)
                .logprob(0.0)
                .addTopLogprob(TopLogProb.builder().token("token").addByte(0L).logprob(0.0).build())
                .build()

        assertThat(lobProb.token()).isEqualTo("token")
        assertThat(lobProb.bytes()).containsExactly(0L)
        assertThat(lobProb.logprob()).isEqualTo(0.0)
        assertThat(lobProb.topLogprobs())
            .containsExactly(TopLogProb.builder().token("token").addByte(0L).logprob(0.0).build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val lobProb =
            LobProb.builder()
                .token("token")
                .addByte(0L)
                .logprob(0.0)
                .addTopLogprob(TopLogProb.builder().token("token").addByte(0L).logprob(0.0).build())
                .build()

        val roundtrippedLobProb =
            jsonMapper.readValue(jsonMapper.writeValueAsString(lobProb), jacksonTypeRef<LobProb>())

        assertThat(roundtrippedLobProb).isEqualTo(lobProb)
    }
}
