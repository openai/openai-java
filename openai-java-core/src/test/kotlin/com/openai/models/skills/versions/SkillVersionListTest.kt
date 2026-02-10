// File generated from our OpenAPI spec by Stainless.

package com.openai.models.skills.versions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SkillVersionListTest {

    @Test
    fun create() {
        val skillVersionList =
            SkillVersionList.builder()
                .addData(
                    SkillVersion.builder()
                        .id("id")
                        .createdAt(0L)
                        .description("description")
                        .name("name")
                        .skillId("skill_id")
                        .version("version")
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(skillVersionList.data())
            .containsExactly(
                SkillVersion.builder()
                    .id("id")
                    .createdAt(0L)
                    .description("description")
                    .name("name")
                    .skillId("skill_id")
                    .version("version")
                    .build()
            )
        assertThat(skillVersionList.firstId()).contains("first_id")
        assertThat(skillVersionList.hasMore()).isEqualTo(true)
        assertThat(skillVersionList.lastId()).contains("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val skillVersionList =
            SkillVersionList.builder()
                .addData(
                    SkillVersion.builder()
                        .id("id")
                        .createdAt(0L)
                        .description("description")
                        .name("name")
                        .skillId("skill_id")
                        .version("version")
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        val roundtrippedSkillVersionList =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(skillVersionList),
                jacksonTypeRef<SkillVersionList>(),
            )

        assertThat(roundtrippedSkillVersionList).isEqualTo(skillVersionList)
    }
}
