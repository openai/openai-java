// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaSkillReferenceTest {

    @Test
    fun create() {
        val betaSkillReference =
            BetaSkillReference.builder().skillId("x").version("version").build()

        assertThat(betaSkillReference.skillId()).isEqualTo("x")
        assertThat(betaSkillReference.version()).contains("version")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaSkillReference =
            BetaSkillReference.builder().skillId("x").version("version").build()

        val roundtrippedBetaSkillReference =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaSkillReference),
                jacksonTypeRef<BetaSkillReference>(),
            )

        assertThat(roundtrippedBetaSkillReference).isEqualTo(betaSkillReference)
    }
}
