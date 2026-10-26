// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionInputJsonTest {

    @Test
    fun createAndRoundtrip() {
        val decisionInputJson =
            DecisionInputJson.builder()
                .data(DecisionInputJson.Data.UnionMember0.builder().build())
                .build()

        assertThat(decisionInputJson.data())
            .isEqualTo(
                DecisionInputJson.Data.ofUnionMember0(
                    DecisionInputJson.Data.UnionMember0.builder().build()
                )
            )

        val jsonMapper = jsonMapper()

        val roundtrippedDecisionInputJson =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionInputJson),
                jacksonTypeRef<DecisionInputJson>(),
            )

        assertThat(roundtrippedDecisionInputJson).isEqualTo(decisionInputJson)
    }
}
