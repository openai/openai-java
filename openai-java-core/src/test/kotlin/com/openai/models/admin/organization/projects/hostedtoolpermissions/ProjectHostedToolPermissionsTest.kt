// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.projects.hostedtoolpermissions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProjectHostedToolPermissionsTest {

    @Test
    fun createAndRoundtrip() {
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
            .contains(ProjectHostedToolPermissions.CodeInterpreter.builder().enabled(true).build())
        assertThat(projectHostedToolPermissions.fileSearch())
            .contains(ProjectHostedToolPermissions.FileSearch.builder().enabled(true).build())
        assertThat(projectHostedToolPermissions.imageGeneration())
            .contains(ProjectHostedToolPermissions.ImageGeneration.builder().enabled(true).build())
        assertThat(projectHostedToolPermissions.mcp())
            .contains(ProjectHostedToolPermissions.Mcp.builder().enabled(true).build())
        assertThat(projectHostedToolPermissions.webSearch())
            .contains(ProjectHostedToolPermissions.WebSearch.builder().enabled(true).build())

        val jsonMapper = jsonMapper()

        val roundtrippedProjectHostedToolPermissions =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(projectHostedToolPermissions),
                jacksonTypeRef<ProjectHostedToolPermissions>(),
            )

        assertThat(roundtrippedProjectHostedToolPermissions).isEqualTo(projectHostedToolPermissions)
    }
}
