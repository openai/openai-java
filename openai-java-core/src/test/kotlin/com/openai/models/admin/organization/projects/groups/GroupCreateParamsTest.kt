// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.groups

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GroupCreateParamsTest {

    @Test
    fun create() {
        GroupCreateParams.builder().projectId("project_id").groupId("group_id").role("role").build()
    }

    @Test
    fun pathParams() {
        val params =
            GroupCreateParams.builder()
                .projectId("project_id")
                .groupId("group_id")
                .role("role")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("project_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            GroupCreateParams.builder()
                .projectId("project_id")
                .groupId("group_id")
                .role("role")
                .build()

        val body = params._body()

        assertThat(body.groupId()).isEqualTo("group_id")
        assertThat(body.role()).isEqualTo("role")
    }
}
