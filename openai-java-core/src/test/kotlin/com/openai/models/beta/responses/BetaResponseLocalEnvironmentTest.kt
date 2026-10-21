// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseLocalEnvironmentTest {

    @Test
    fun createAndRoundtrip() {
        val betaResponseLocalEnvironment = BetaResponseLocalEnvironment.builder().build()

        val jsonMapper = jsonMapper()

        val roundtrippedBetaResponseLocalEnvironment =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseLocalEnvironment),
                jacksonTypeRef<BetaResponseLocalEnvironment>(),
            )

        assertThat(roundtrippedBetaResponseLocalEnvironment).isEqualTo(betaResponseLocalEnvironment)
    }
}
