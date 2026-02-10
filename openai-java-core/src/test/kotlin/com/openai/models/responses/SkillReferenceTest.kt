// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SkillReferenceTest {

    @Test
    fun create() {
        val skillReference = SkillReference.builder().skillId("x").version("version").build()

        assertThat(skillReference.skillId()).isEqualTo("x")
        assertThat(skillReference.version()).contains("version")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val skillReference = SkillReference.builder().skillId("x").version("version").build()

        val roundtrippedSkillReference =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(skillReference),
                jacksonTypeRef<SkillReference>(),
            )

        assertThat(roundtrippedSkillReference).isEqualTo(skillReference)
    }
}
