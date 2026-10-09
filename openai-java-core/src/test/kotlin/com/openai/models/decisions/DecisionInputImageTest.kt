// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.decisions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionInputImageTest {

    @Test
    fun create() {
        val decisionInputImage =
            DecisionInputImage.builder()
                .imageUrl("https://")
                .detail(DecisionInputImage.Detail.LOW)
                .build()

        assertThat(decisionInputImage.imageUrl()).isEqualTo("https://")
        assertThat(decisionInputImage.detail()).contains(DecisionInputImage.Detail.LOW)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val decisionInputImage =
            DecisionInputImage.builder()
                .imageUrl("https://")
                .detail(DecisionInputImage.Detail.LOW)
                .build()

        val roundtrippedDecisionInputImage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionInputImage),
                jacksonTypeRef<DecisionInputImage>(),
            )

        assertThat(roundtrippedDecisionInputImage).isEqualTo(decisionInputImage)
    }
}
