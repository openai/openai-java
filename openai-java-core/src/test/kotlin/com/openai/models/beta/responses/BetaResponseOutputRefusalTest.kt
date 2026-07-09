// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseOutputRefusalTest {

    @Test
    fun create() {
        val betaResponseOutputRefusal =
            BetaResponseOutputRefusal.builder().refusal("refusal").build()

        assertThat(betaResponseOutputRefusal.refusal()).isEqualTo("refusal")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseOutputRefusal =
            BetaResponseOutputRefusal.builder().refusal("refusal").build()

        val roundtrippedBetaResponseOutputRefusal =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseOutputRefusal),
                jacksonTypeRef<BetaResponseOutputRefusal>(),
            )

        assertThat(roundtrippedBetaResponseOutputRefusal).isEqualTo(betaResponseOutputRefusal)
    }
}
