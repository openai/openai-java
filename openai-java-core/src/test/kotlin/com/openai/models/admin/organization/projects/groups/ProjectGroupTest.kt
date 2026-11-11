// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.projects.groups

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProjectGroupTest {

    @Test
    fun createAndRoundtrip() {
        val projectGroup =
            ProjectGroup.builder()
                .createdAt(0L)
                .groupId("group_id")
                .groupName("group_name")
                .groupType(ProjectGroup.GroupType.GROUP)
                .projectId("project_id")
                .build()

        assertThat(projectGroup.createdAt()).contains(0L)
        assertThat(projectGroup.groupId()).contains("group_id")
        assertThat(projectGroup.groupName()).contains("group_name")
        assertThat(projectGroup.groupType()).contains(ProjectGroup.GroupType.GROUP)
        assertThat(projectGroup.projectId()).contains("project_id")

        val jsonMapper = jsonMapper()

        val roundtrippedProjectGroup =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(projectGroup),
                jacksonTypeRef<ProjectGroup>(),
            )

        assertThat(roundtrippedProjectGroup).isEqualTo(projectGroup)
    }
}
