// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseDeleteResponseTest {

    @Test
    fun createAndRoundtrip() {
        val betaResponseDeleteResponse =
            BetaResponseDeleteResponse.builder().id("id").deleted(true).build()

        assertThat(betaResponseDeleteResponse.id()).contains("id")
        assertThat(betaResponseDeleteResponse.deleted()).contains(true)

        val jsonMapper = jsonMapper()

        val roundtrippedBetaResponseDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseDeleteResponse),
                jacksonTypeRef<BetaResponseDeleteResponse>(),
            )

        assertThat(roundtrippedBetaResponseDeleteResponse).isEqualTo(betaResponseDeleteResponse)
    }
}
