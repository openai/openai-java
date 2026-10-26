// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaContainerReferenceTest {

    @Test
    fun createAndRoundtrip() {
        val betaContainerReference =
            BetaContainerReference.builder().containerId("cntr_123").build()

        assertThat(betaContainerReference.containerId()).isEqualTo("cntr_123")

        val jsonMapper = jsonMapper()

        val roundtrippedBetaContainerReference =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaContainerReference),
                jacksonTypeRef<BetaContainerReference>(),
            )

        assertThat(roundtrippedBetaContainerReference).isEqualTo(betaContainerReference)
    }
}
