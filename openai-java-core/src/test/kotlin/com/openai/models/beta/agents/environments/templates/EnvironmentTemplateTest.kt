// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.environments.templates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.beta.agents.HostedPlugin
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EnvironmentTemplateTest {

    @Test
    fun create() {
        val environmentTemplate =
            EnvironmentTemplate.builder()
                .id("id")
                .addCapabilityDirectory("string")
                .createdAt(0L)
                .addFile(
                    EnvironmentTemplate.File.FileId.builder().fileId("file_id").path("path").build()
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
                .addPlugin(HostedPlugin.builder().description("description").name("name").build())
                .addSkill(
                    EnvironmentTemplate.Skill.SkillReference.builder()
                        .skillId("skill_id")
                        .version("version")
                        .build()
                )
                .updatedAt(0L)
                .build()

        assertThat(environmentTemplate.id()).isEqualTo("id")
        assertThat(environmentTemplate.capabilityDirectories()).containsExactly("string")
        assertThat(environmentTemplate.createdAt()).isEqualTo(0L)
        assertThat(environmentTemplate.files())
            .containsExactly(
                EnvironmentTemplate.File.ofId(
                    EnvironmentTemplate.File.FileId.builder().fileId("file_id").path("path").build()
                )
            )
        assertThat(environmentTemplate.name()).contains("name")
        assertThat(environmentTemplate.network())
            .isEqualTo(
                EnvironmentTemplate.Network.builder()
                    .access(EnvironmentTemplate.Network.Access.ENABLED)
                    .addAllowedDomain("string")
                    .build()
            )
        assertThat(environmentTemplate.packages())
            .isEqualTo(
                EnvironmentTemplate.Packages.builder()
                    .addNpm("string")
                    .addPython("string")
                    .addSystem("string")
                    .build()
            )
        assertThat(environmentTemplate.plugins())
            .containsExactly(HostedPlugin.builder().description("description").name("name").build())
        assertThat(environmentTemplate.skills())
            .containsExactly(
                EnvironmentTemplate.Skill.ofReference(
                    EnvironmentTemplate.Skill.SkillReference.builder()
                        .skillId("skill_id")
                        .version("version")
                        .build()
                )
            )
        assertThat(environmentTemplate.updatedAt()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val environmentTemplate =
            EnvironmentTemplate.builder()
                .id("id")
                .addCapabilityDirectory("string")
                .createdAt(0L)
                .addFile(
                    EnvironmentTemplate.File.FileId.builder().fileId("file_id").path("path").build()
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
                .addPlugin(HostedPlugin.builder().description("description").name("name").build())
                .addSkill(
                    EnvironmentTemplate.Skill.SkillReference.builder()
                        .skillId("skill_id")
                        .version("version")
                        .build()
                )
                .updatedAt(0L)
                .build()

        val roundtrippedEnvironmentTemplate =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(environmentTemplate),
                jacksonTypeRef<EnvironmentTemplate>(),
            )

        assertThat(roundtrippedEnvironmentTemplate).isEqualTo(environmentTemplate)
    }
}
