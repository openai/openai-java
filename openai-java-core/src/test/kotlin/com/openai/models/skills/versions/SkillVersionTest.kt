// File generated from our OpenAPI spec by Stainless.

package com.openai.models.skills.versions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SkillVersionTest {

    @Test
    fun create() {
        val skillVersion =
            SkillVersion.builder()
                .id("id")
                .createdAt(0L)
                .description("description")
                .name("name")
                .skillId("skill_id")
                .version("version")
                .build()

        assertThat(skillVersion.id()).isEqualTo("id")
        assertThat(skillVersion.createdAt()).isEqualTo(0L)
        assertThat(skillVersion.description()).isEqualTo("description")
        assertThat(skillVersion.name()).isEqualTo("name")
        assertThat(skillVersion.skillId()).isEqualTo("skill_id")
        assertThat(skillVersion.version()).isEqualTo("version")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val skillVersion =
            SkillVersion.builder()
                .id("id")
                .createdAt(0L)
                .description("description")
                .name("name")
                .skillId("skill_id")
                .version("version")
                .build()

        val roundtrippedSkillVersion =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(skillVersion),
                jacksonTypeRef<SkillVersion>(),
            )

        assertThat(roundtrippedSkillVersion).isEqualTo(skillVersion)
    }
}
