// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TopLogProbTest {

    @Test
    fun create() {
        val topLogProb = TopLogProb.builder().token("token").addByte(0L).logprob(0.0).build()

        assertThat(topLogProb.token()).isEqualTo("token")
        assertThat(topLogProb.bytes()).containsExactly(0L)
        assertThat(topLogProb.logprob()).isEqualTo(0.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val topLogProb = TopLogProb.builder().token("token").addByte(0L).logprob(0.0).build()

        val roundtrippedTopLogProb =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(topLogProb),
                jacksonTypeRef<TopLogProb>(),
            )

        assertThat(roundtrippedTopLogProb).isEqualTo(topLogProb)
    }
}
