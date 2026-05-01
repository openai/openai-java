// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.groups

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GroupListPageResponseTest {

    @Test
    fun create() {
        val groupListPageResponse =
            GroupListPageResponse.builder()
                .addData(
                    ProjectGroup.builder()
                        .createdAt(0L)
                        .groupId("group_id")
                        .groupName("group_name")
                        .groupType("group_type")
                        .projectId("project_id")
                        .build()
                )
                .hasMore(true)
                .next("next")
                .build()

        assertThat(groupListPageResponse.data())
            .containsExactly(
                ProjectGroup.builder()
                    .createdAt(0L)
                    .groupId("group_id")
                    .groupName("group_name")
                    .groupType("group_type")
                    .projectId("project_id")
                    .build()
            )
        assertThat(groupListPageResponse.hasMore()).isEqualTo(true)
        assertThat(groupListPageResponse.next()).contains("next")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val groupListPageResponse =
            GroupListPageResponse.builder()
                .addData(
                    ProjectGroup.builder()
                        .createdAt(0L)
                        .groupId("group_id")
                        .groupName("group_name")
                        .groupType("group_type")
                        .projectId("project_id")
                        .build()
                )
                .hasMore(true)
                .next("next")
                .build()

        val roundtrippedGroupListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(groupListPageResponse),
                jacksonTypeRef<GroupListPageResponse>(),
            )

        assertThat(roundtrippedGroupListPageResponse).isEqualTo(groupListPageResponse)
    }
}
