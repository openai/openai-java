// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InlineSkillSourceTest {

    @Test
    fun create() {
        val inlineSkillSource = InlineSkillSource.builder().data("x").build()

        assertThat(inlineSkillSource.data()).isEqualTo("x")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inlineSkillSource = InlineSkillSource.builder().data("x").build()

        val roundtrippedInlineSkillSource =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inlineSkillSource),
                jacksonTypeRef<InlineSkillSource>(),
            )

        assertThat(roundtrippedInlineSkillSource).isEqualTo(inlineSkillSource)
    }
}
