// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.environments

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.beta.agents.HostedEnvironmentFile
import com.openai.models.beta.agents.HostedEnvironmentFileId
import com.openai.models.beta.agents.HostedPlugin
import com.openai.models.beta.agents.HostedSkill
import com.openai.models.beta.agents.HostedSkillReference
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EnvironmentInfoTest {

    @Test
    fun createAndRoundtrip() {
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

        assertThat(environmentInfo.id()).contains("id")
        assertThat(environmentInfo.files().getOrNull())
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
        assertThat(environmentInfo.plugins().getOrNull())
            .containsExactly(HostedPlugin.builder().description("description").name("name").build())
        assertThat(environmentInfo.skills().getOrNull())
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
        assertThat(environmentInfo.status()).contains(EnvironmentInfo.Status.PENDING)
        assertThat(environmentInfo.type()).contains(EnvironmentInfo.Type.OPENAI_HOSTED)

        val jsonMapper = jsonMapper()

        val roundtrippedEnvironmentInfo =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(environmentInfo),
                jacksonTypeRef<EnvironmentInfo>(),
            )

        assertThat(roundtrippedEnvironmentInfo).isEqualTo(environmentInfo)
    }
}
