// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InlineSkillTest {

    @Test
    fun create() {
        val inlineSkill =
            InlineSkill.builder()
                .description("description")
                .name("name")
                .source(InlineSkillSource.builder().data("x").build())
                .build()

        assertThat(inlineSkill.description()).isEqualTo("description")
        assertThat(inlineSkill.name()).isEqualTo("name")
        assertThat(inlineSkill.source()).isEqualTo(InlineSkillSource.builder().data("x").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inlineSkill =
            InlineSkill.builder()
                .description("description")
                .name("name")
                .source(InlineSkillSource.builder().data("x").build())
                .build()

        val roundtrippedInlineSkill =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inlineSkill),
                jacksonTypeRef<InlineSkill>(),
            )

        assertThat(roundtrippedInlineSkill).isEqualTo(inlineSkill)
    }
}
