// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.environments

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.beta.agents.HostedEnvironmentFile
import com.openai.models.beta.agents.HostedEnvironmentFileId
import com.openai.models.beta.agents.HostedPlugin
import com.openai.models.beta.agents.HostedSkill
import com.openai.models.beta.agents.HostedSkillReference
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EnvironmentInfoTest {

    @Test
    fun create() {
        val environmentInfo =
            EnvironmentInfo.builder()
                .id("id")
                .addFile(
                    HostedEnvironmentFileId.builder()
                        .id("id")
                        .fileId("file_id")
                        .path("path")
                        .sizeBytes(0L)
                        .build()
                )
                .addPlugin(HostedPlugin.builder().description("description").name("name").build())
                .addSkill(
                    HostedSkillReference.builder()
                        .description("description")
                        .name("name")
                        .skillId("skill_id")
                        .version("version")
                        .build()
                )
                .status(EnvironmentInfo.Status.PENDING)
                .type(EnvironmentInfo.Type.OPENAI_HOSTED)
                .build()

        assertThat(environmentInfo.id()).isEqualTo("id")
        assertThat(environmentInfo.files())
            .containsExactly(
                HostedEnvironmentFile.ofFileId(
                    HostedEnvironmentFileId.builder()
                        .id("id")
                        .fileId("file_id")
                        .path("path")
                        .sizeBytes(0L)
                        .build()
                )
            )
        assertThat(environmentInfo.plugins())
            .containsExactly(HostedPlugin.builder().description("description").name("name").build())
        assertThat(environmentInfo.skills())
            .containsExactly(
                HostedSkill.ofSkillReference(
                    HostedSkillReference.builder()
                        .description("description")
                        .name("name")
                        .skillId("skill_id")
                        .version("version")
                        .build()
                )
            )
        assertThat(environmentInfo.status()).isEqualTo(EnvironmentInfo.Status.PENDING)
        assertThat(environmentInfo.type()).isEqualTo(EnvironmentInfo.Type.OPENAI_HOSTED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val environmentInfo =
            EnvironmentInfo.builder()
                .id("id")
                .addFile(
                    HostedEnvironmentFileId.builder()
                        .id("id")
                        .fileId("file_id")
                        .path("path")
                        .sizeBytes(0L)
                        .build()
                )
                .addPlugin(HostedPlugin.builder().description("description").name("name").build())
                .addSkill(
                    HostedSkillReference.builder()
                        .description("description")
                        .name("name")
                        .skillId("skill_id")
                        .version("version")
                        .build()
                )
                .status(EnvironmentInfo.Status.PENDING)
                .type(EnvironmentInfo.Type.OPENAI_HOSTED)
                .build()

        val roundtrippedEnvironmentInfo =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(environmentInfo),
                jacksonTypeRef<EnvironmentInfo>(),
            )

        assertThat(roundtrippedEnvironmentInfo).isEqualTo(environmentInfo)
    }
}
