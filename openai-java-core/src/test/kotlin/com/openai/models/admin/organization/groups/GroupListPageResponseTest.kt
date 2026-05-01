// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.groups

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
                    Group.builder()
                        .id("id")
                        .createdAt(0L)
                        .groupType("group_type")
                        .isScimManaged(true)
                        .name("name")
                        .build()
                )
                .hasMore(true)
                .next("next")
                .build()

        assertThat(groupListPageResponse.data())
            .containsExactly(
                Group.builder()
                    .id("id")
                    .createdAt(0L)
                    .groupType("group_type")
                    .isScimManaged(true)
                    .name("name")
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
                    Group.builder()
                        .id("id")
                        .createdAt(0L)
                        .groupType("group_type")
                        .isScimManaged(true)
                        .name("name")
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
