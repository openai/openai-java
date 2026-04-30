// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.groups

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProjectGroupTest {

    @Test
    fun create() {
        val projectGroup =
            ProjectGroup.builder()
                .createdAt(0L)
                .groupId("group_id")
                .groupName("group_name")
                .projectId("project_id")
                .build()

        assertThat(projectGroup.createdAt()).isEqualTo(0L)
        assertThat(projectGroup.groupId()).isEqualTo("group_id")
        assertThat(projectGroup.groupName()).isEqualTo("group_name")
        assertThat(projectGroup.projectId()).isEqualTo("project_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val projectGroup =
            ProjectGroup.builder()
                .createdAt(0L)
                .groupId("group_id")
                .groupName("group_name")
                .projectId("project_id")
                .build()

        val roundtrippedProjectGroup =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(projectGroup),
                jacksonTypeRef<ProjectGroup>(),
            )

        assertThat(roundtrippedProjectGroup).isEqualTo(projectGroup)
    }
}
