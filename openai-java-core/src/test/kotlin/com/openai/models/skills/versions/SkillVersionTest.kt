// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.skills.versions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SkillVersionTest {

    @Test
    fun createAndRoundtrip() {
        val skillVersion =
            SkillVersion.builder()
                .id("id")
                .createdAt(0L)
                .description("description")
                .name("name")
                .skillId("skill_id")
                .version("version")
                .build()

        assertThat(skillVersion.id()).contains("id")
        assertThat(skillVersion.createdAt()).contains(0L)
        assertThat(skillVersion.description()).contains("description")
        assertThat(skillVersion.name()).contains("name")
        assertThat(skillVersion.skillId()).contains("skill_id")
        assertThat(skillVersion.version()).contains("version")

        val jsonMapper = jsonMapper()

        val roundtrippedSkillVersion =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(skillVersion),
                jacksonTypeRef<SkillVersion>(),
            )

        assertThat(roundtrippedSkillVersion).isEqualTo(skillVersion)
    }
}
