// File generated from our OpenAPI spec by Stainless.

package com.openai.models.skills

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SkillTest {

    @Test
    fun create() {
        val skill =
            Skill.builder()
                .id("id")
                .createdAt(0L)
                .defaultVersion("default_version")
                .description("description")
                .latestVersion("latest_version")
                .name("name")
                .build()

        assertThat(skill.id()).isEqualTo("id")
        assertThat(skill.createdAt()).isEqualTo(0L)
        assertThat(skill.defaultVersion()).isEqualTo("default_version")
        assertThat(skill.description()).isEqualTo("description")
        assertThat(skill.latestVersion()).isEqualTo("latest_version")
        assertThat(skill.name()).isEqualTo("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val skill =
            Skill.builder()
                .id("id")
                .createdAt(0L)
                .defaultVersion("default_version")
                .description("description")
                .latestVersion("latest_version")
                .name("name")
                .build()

        val roundtrippedSkill =
            jsonMapper.readValue(jsonMapper.writeValueAsString(skill), jacksonTypeRef<Skill>())

        assertThat(roundtrippedSkill).isEqualTo(skill)
    }
}
