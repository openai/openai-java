// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.hostedtoolpermissions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProjectHostedToolPermissionsTest {

    @Test
    fun create() {
        val projectHostedToolPermissions =
            ProjectHostedToolPermissions.builder()
                .codeInterpreter(
                    ProjectHostedToolPermissions.CodeInterpreter.builder().enabled(true).build()
                )
                .fileSearch(ProjectHostedToolPermissions.FileSearch.builder().enabled(true).build())
                .imageGeneration(
                    ProjectHostedToolPermissions.ImageGeneration.builder().enabled(true).build()
                )
                .mcp(ProjectHostedToolPermissions.Mcp.builder().enabled(true).build())
                .webSearch(ProjectHostedToolPermissions.WebSearch.builder().enabled(true).build())
                .build()

        assertThat(projectHostedToolPermissions.codeInterpreter())
            .isEqualTo(ProjectHostedToolPermissions.CodeInterpreter.builder().enabled(true).build())
        assertThat(projectHostedToolPermissions.fileSearch())
            .isEqualTo(ProjectHostedToolPermissions.FileSearch.builder().enabled(true).build())
        assertThat(projectHostedToolPermissions.imageGeneration())
            .isEqualTo(ProjectHostedToolPermissions.ImageGeneration.builder().enabled(true).build())
        assertThat(projectHostedToolPermissions.mcp())
            .isEqualTo(ProjectHostedToolPermissions.Mcp.builder().enabled(true).build())
        assertThat(projectHostedToolPermissions.webSearch())
            .isEqualTo(ProjectHostedToolPermissions.WebSearch.builder().enabled(true).build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val projectHostedToolPermissions =
            ProjectHostedToolPermissions.builder()
                .codeInterpreter(
                    ProjectHostedToolPermissions.CodeInterpreter.builder().enabled(true).build()
                )
                .fileSearch(ProjectHostedToolPermissions.FileSearch.builder().enabled(true).build())
                .imageGeneration(
                    ProjectHostedToolPermissions.ImageGeneration.builder().enabled(true).build()
                )
                .mcp(ProjectHostedToolPermissions.Mcp.builder().enabled(true).build())
                .webSearch(ProjectHostedToolPermissions.WebSearch.builder().enabled(true).build())
                .build()

        val roundtrippedProjectHostedToolPermissions =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(projectHostedToolPermissions),
                jacksonTypeRef<ProjectHostedToolPermissions>(),
            )

        assertThat(roundtrippedProjectHostedToolPermissions).isEqualTo(projectHostedToolPermissions)
    }
}
