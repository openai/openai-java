// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaInlineSkillSourceTest {

    @Test
    fun create() {
        val betaInlineSkillSource = BetaInlineSkillSource.builder().data("x").build()

        assertThat(betaInlineSkillSource.data()).isEqualTo("x")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaInlineSkillSource = BetaInlineSkillSource.builder().data("x").build()

        val roundtrippedBetaInlineSkillSource =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaInlineSkillSource),
                jacksonTypeRef<BetaInlineSkillSource>(),
            )

        assertThat(roundtrippedBetaInlineSkillSource).isEqualTo(betaInlineSkillSource)
    }
}
