// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseLocalEnvironmentTest {

    @Test
    fun create() {
        val betaResponseLocalEnvironment = BetaResponseLocalEnvironment.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseLocalEnvironment = BetaResponseLocalEnvironment.builder().build()

        val roundtrippedBetaResponseLocalEnvironment =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseLocalEnvironment),
                jacksonTypeRef<BetaResponseLocalEnvironment>(),
            )

        assertThat(roundtrippedBetaResponseLocalEnvironment).isEqualTo(betaResponseLocalEnvironment)
    }
}
