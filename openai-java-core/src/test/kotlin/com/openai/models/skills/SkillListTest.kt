// File generated from our OpenAPI spec by Stainless.

package com.openai.models.skills

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SkillListTest {

    @Test
    fun create() {
        val skillList =
            SkillList.builder()
                .addData(
                    Skill.builder()
                        .id("id")
                        .createdAt(0L)
                        .defaultVersion("default_version")
                        .description("description")
                        .latestVersion("latest_version")
                        .name("name")
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(skillList.data())
            .containsExactly(
                Skill.builder()
                    .id("id")
                    .createdAt(0L)
                    .defaultVersion("default_version")
                    .description("description")
                    .latestVersion("latest_version")
                    .name("name")
                    .build()
            )
        assertThat(skillList.firstId()).contains("first_id")
        assertThat(skillList.hasMore()).isEqualTo(true)
        assertThat(skillList.lastId()).contains("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val skillList =
            SkillList.builder()
                .addData(
                    Skill.builder()
                        .id("id")
                        .createdAt(0L)
                        .defaultVersion("default_version")
                        .description("description")
                        .latestVersion("latest_version")
                        .name("name")
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        val roundtrippedSkillList =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(skillList),
                jacksonTypeRef<SkillList>(),
            )

        assertThat(roundtrippedSkillList).isEqualTo(skillList)
    }
}
