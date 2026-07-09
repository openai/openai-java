// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaResponseContainerReferenceTest {

    @Test
    fun create() {
        val betaResponseContainerReference =
            BetaResponseContainerReference.builder().containerId("container_id").build()

        assertThat(betaResponseContainerReference.containerId()).isEqualTo("container_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseContainerReference =
            BetaResponseContainerReference.builder().containerId("container_id").build()

        val roundtrippedBetaResponseContainerReference =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseContainerReference),
                jacksonTypeRef<BetaResponseContainerReference>(),
            )

        assertThat(roundtrippedBetaResponseContainerReference)
            .isEqualTo(betaResponseContainerReference)
    }
}
