// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecisionJsonObjectTest {

    @Test
    fun createAndRoundtrip() {
        val decisionJsonObject =
            DecisionJsonObject.builder().putAdditionalProperty("foo", JsonValue.from("bar")).build()

        val jsonMapper = jsonMapper()

        val roundtrippedDecisionJsonObject =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decisionJsonObject),
                jacksonTypeRef<DecisionJsonObject>(),
            )

        assertThat(roundtrippedDecisionJsonObject).isEqualTo(decisionJsonObject)
    }
}
