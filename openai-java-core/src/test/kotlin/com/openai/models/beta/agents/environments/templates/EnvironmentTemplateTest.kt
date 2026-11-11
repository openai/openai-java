// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.environments.templates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.beta.agents.HostedPlugin
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EnvironmentTemplateTest {

    @Test
    fun createAndRoundtrip() {
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
                .desktop(EnvironmentTemplate.Desktop.builder().enabled(true).build())
                .build()

        assertThat(environmentTemplate.id()).contains("id")
        assertThat(environmentTemplate.capabilityDirectories().getOrNull())
            .containsExactly("string")
        assertThat(environmentTemplate.createdAt()).contains(0L)
        assertThat(environmentTemplate.files().getOrNull())
            .containsExactly(
                EnvironmentTemplate.File.ofId(
                    EnvironmentTemplate.File.FileId.builder().fileId("file_id").path("path").build()
                )
            )
        assertThat(environmentTemplate.name()).contains("name")
        assertThat(environmentTemplate.network())
            .contains(
                EnvironmentTemplate.Network.builder()
                    .access(EnvironmentTemplate.Network.Access.ENABLED)
                    .addAllowedDomain("string")
                    .build()
            )
        assertThat(environmentTemplate.packages())
            .contains(
                EnvironmentTemplate.Packages.builder()
                    .addNpm("string")
                    .addPython("string")
                    .addSystem("string")
                    .build()
            )
        assertThat(environmentTemplate.plugins().getOrNull())
            .containsExactly(HostedPlugin.builder().description("description").name("name").build())
        assertThat(environmentTemplate.skills().getOrNull())
            .containsExactly(
                EnvironmentTemplate.Skill.ofReference(
                    EnvironmentTemplate.Skill.SkillReference.builder()
                        .skillId("skill_id")
                        .version("version")
                        .build()
                )
            )
        assertThat(environmentTemplate.updatedAt()).contains(0L)
        assertThat(environmentTemplate.desktop())
            .contains(EnvironmentTemplate.Desktop.builder().enabled(true).build())

        val jsonMapper = jsonMapper()

        val roundtrippedEnvironmentTemplate =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(environmentTemplate),
                jacksonTypeRef<EnvironmentTemplate>(),
            )

        assertThat(roundtrippedEnvironmentTemplate).isEqualTo(environmentTemplate)
    }
}
