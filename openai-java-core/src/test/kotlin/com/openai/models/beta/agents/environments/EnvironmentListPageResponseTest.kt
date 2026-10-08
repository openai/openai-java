// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.environments

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.beta.agents.HostedEnvironmentFileId
import com.openai.models.beta.agents.HostedPlugin
import com.openai.models.beta.agents.HostedSkillReference
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EnvironmentListPageResponseTest {

    @Test
    fun create() {
        val environmentListPageResponse =
            EnvironmentListPageResponse.builder()
                .addData(
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
                        .addPlugin(
                            HostedPlugin.builder().description("description").name("name").build()
                        )
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
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(environmentListPageResponse.data())
            .containsExactly(
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
                    .addPlugin(
                        HostedPlugin.builder().description("description").name("name").build()
                    )
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
            )
        assertThat(environmentListPageResponse.firstId()).contains("first_id")
        assertThat(environmentListPageResponse.hasMore()).isEqualTo(true)
        assertThat(environmentListPageResponse.lastId()).contains("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val environmentListPageResponse =
            EnvironmentListPageResponse.builder()
                .addData(
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
                        .addPlugin(
                            HostedPlugin.builder().description("description").name("name").build()
                        )
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
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        val roundtrippedEnvironmentListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(environmentListPageResponse),
                jacksonTypeRef<EnvironmentListPageResponse>(),
            )

        assertThat(roundtrippedEnvironmentListPageResponse).isEqualTo(environmentListPageResponse)
    }
}
