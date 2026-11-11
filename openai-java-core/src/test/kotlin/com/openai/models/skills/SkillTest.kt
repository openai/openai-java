// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.skills

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SkillTest {

    @Test
    fun createAndRoundtrip() {
        val skill =
            Skill.builder()
                .id("id")
                .createdAt(0L)
                .defaultVersion("default_version")
                .description("description")
                .latestVersion("latest_version")
                .name("name")
                .build()

        assertThat(skill.id()).contains("id")
        assertThat(skill.createdAt()).contains(0L)
        assertThat(skill.defaultVersion()).contains("default_version")
        assertThat(skill.description()).contains("description")
        assertThat(skill.latestVersion()).contains("latest_version")
        assertThat(skill.name()).contains("name")

        val jsonMapper = jsonMapper()

        val roundtrippedSkill =
            jsonMapper.readValue(jsonMapper.writeValueAsString(skill), jacksonTypeRef<Skill>())

        assertThat(roundtrippedSkill).isEqualTo(skill)
    }
}
