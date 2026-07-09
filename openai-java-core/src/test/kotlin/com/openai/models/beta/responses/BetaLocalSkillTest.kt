// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaLocalSkillTest {

    @Test
    fun create() {
        val betaLocalSkill =
            BetaLocalSkill.builder().description("description").name("name").path("path").build()

        assertThat(betaLocalSkill.description()).isEqualTo("description")
        assertThat(betaLocalSkill.name()).isEqualTo("name")
        assertThat(betaLocalSkill.path()).isEqualTo("path")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaLocalSkill =
            BetaLocalSkill.builder().description("description").name("name").path("path").build()

        val roundtrippedBetaLocalSkill =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaLocalSkill),
                jacksonTypeRef<BetaLocalSkill>(),
            )

        assertThat(roundtrippedBetaLocalSkill).isEqualTo(betaLocalSkill)
    }
}
