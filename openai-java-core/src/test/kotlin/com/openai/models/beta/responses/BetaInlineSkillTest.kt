// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaInlineSkillTest {

    @Test
    fun create() {
        val betaInlineSkill =
            BetaInlineSkill.builder()
                .description("description")
                .name("name")
                .source(BetaInlineSkillSource.builder().data("x").build())
                .build()

        assertThat(betaInlineSkill.description()).isEqualTo("description")
        assertThat(betaInlineSkill.name()).isEqualTo("name")
        assertThat(betaInlineSkill.source())
            .isEqualTo(BetaInlineSkillSource.builder().data("x").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaInlineSkill =
            BetaInlineSkill.builder()
                .description("description")
                .name("name")
                .source(BetaInlineSkillSource.builder().data("x").build())
                .build()

        val roundtrippedBetaInlineSkill =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaInlineSkill),
                jacksonTypeRef<BetaInlineSkill>(),
            )

        assertThat(roundtrippedBetaInlineSkill).isEqualTo(betaInlineSkill)
    }
}
