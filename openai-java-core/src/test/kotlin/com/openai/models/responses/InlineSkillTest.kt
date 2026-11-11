// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InlineSkillTest {

    @Test
    fun createAndRoundtrip() {
        val inlineSkill =
            InlineSkill.builder()
                .description("description")
                .name("name")
                .source(InlineSkillSource.builder().data("x").build())
                .build()

        assertThat(inlineSkill.description()).contains("description")
        assertThat(inlineSkill.name()).contains("name")
        assertThat(inlineSkill.source()).contains(InlineSkillSource.builder().data("x").build())

        val jsonMapper = jsonMapper()

        val roundtrippedInlineSkill =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inlineSkill),
                jacksonTypeRef<InlineSkill>(),
            )

        assertThat(roundtrippedInlineSkill).isEqualTo(inlineSkill)
    }
}
