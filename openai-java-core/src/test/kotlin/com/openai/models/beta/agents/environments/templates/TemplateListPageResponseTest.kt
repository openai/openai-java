// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.environments.templates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.beta.agents.HostedPlugin
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TemplateListPageResponseTest {

    @Test
    fun create() {
        val templateListPageResponse =
            TemplateListPageResponse.builder()
                .addData(
                    EnvironmentTemplate.builder()
                        .id("id")
                        .addCapabilityDirectory("string")
                        .createdAt(0L)
                        .addFile(
                            EnvironmentTemplate.File.FileId.builder()
                                .fileId("file_id")
                                .path("path")
                                .build()
                        )
                        .name("name")
                        .network(
                            EnvironmentTemplate.Network.builder()
                                .access(EnvironmentTemplate.Network.Access.ENABLED)
                                .addAllowedDomain("string")
                                .build()
                        )
                        .packages(
                            EnvironmentTemplate.Packages.builder()
                                .addNpm("string")
                                .addPython("string")
                                .addSystem("string")
                                .build()
                        )
                        .addPlugin(
                            HostedPlugin.builder().description("description").name("name").build()
                        )
                        .addSkill(
                            EnvironmentTemplate.Skill.SkillReference.builder()
                                .skillId("skill_id")
                                .version("version")
                                .build()
                        )
                        .updatedAt(0L)
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(templateListPageResponse.data())
            .containsExactly(
                EnvironmentTemplate.builder()
                    .id("id")
                    .addCapabilityDirectory("string")
                    .createdAt(0L)
                    .addFile(
                        EnvironmentTemplate.File.FileId.builder()
                            .fileId("file_id")
                            .path("path")
                            .build()
                    )
                    .name("name")
                    .network(
                        EnvironmentTemplate.Network.builder()
                            .access(EnvironmentTemplate.Network.Access.ENABLED)
                            .addAllowedDomain("string")
                            .build()
                    )
                    .packages(
                        EnvironmentTemplate.Packages.builder()
                            .addNpm("string")
                            .addPython("string")
                            .addSystem("string")
                            .build()
                    )
                    .addPlugin(
                        HostedPlugin.builder().description("description").name("name").build()
                    )
                    .addSkill(
                        EnvironmentTemplate.Skill.SkillReference.builder()
                            .skillId("skill_id")
                            .version("version")
                            .build()
                    )
                    .updatedAt(0L)
                    .build()
            )
        assertThat(templateListPageResponse.firstId()).contains("first_id")
        assertThat(templateListPageResponse.hasMore()).isEqualTo(true)
        assertThat(templateListPageResponse.lastId()).contains("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val templateListPageResponse =
            TemplateListPageResponse.builder()
                .addData(
                    EnvironmentTemplate.builder()
                        .id("id")
                        .addCapabilityDirectory("string")
                        .createdAt(0L)
                        .addFile(
                            EnvironmentTemplate.File.FileId.builder()
                                .fileId("file_id")
                                .path("path")
                                .build()
                        )
                        .name("name")
                        .network(
                            EnvironmentTemplate.Network.builder()
                                .access(EnvironmentTemplate.Network.Access.ENABLED)
                                .addAllowedDomain("string")
                                .build()
                        )
                        .packages(
                            EnvironmentTemplate.Packages.builder()
                                .addNpm("string")
                                .addPython("string")
                                .addSystem("string")
                                .build()
                        )
                        .addPlugin(
                            HostedPlugin.builder().description("description").name("name").build()
                        )
                        .addSkill(
                            EnvironmentTemplate.Skill.SkillReference.builder()
                                .skillId("skill_id")
                                .version("version")
                                .build()
                        )
                        .updatedAt(0L)
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        val roundtrippedTemplateListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(templateListPageResponse),
                jacksonTypeRef<TemplateListPageResponse>(),
            )

        assertThat(roundtrippedTemplateListPageResponse).isEqualTo(templateListPageResponse)
    }
}
