// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InlineSkillSourceTest {

    @Test
    fun createAndRoundtrip() {
        val inlineSkillSource = InlineSkillSource.builder().data("x").build()

        assertThat(inlineSkillSource.data()).isEqualTo("x")

        val jsonMapper = jsonMapper()

        val roundtrippedInlineSkillSource =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inlineSkillSource),
                jacksonTypeRef<InlineSkillSource>(),
            )

        assertThat(roundtrippedInlineSkillSource).isEqualTo(inlineSkillSource)
    }
}
