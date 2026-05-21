// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.groups

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GroupRetrieveParamsTest {

    @Test
    fun create() {
        GroupRetrieveParams.builder()
            .projectId("project_id")
            .groupId("group_id")
            .groupType(GroupRetrieveParams.GroupType.GROUP)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            GroupRetrieveParams.builder().projectId("project_id").groupId("group_id").build()

        assertThat(params._pathParam(0)).isEqualTo("project_id")
        assertThat(params._pathParam(1)).isEqualTo("group_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            GroupRetrieveParams.builder()
                .projectId("project_id")
                .groupId("group_id")
                .groupType(GroupRetrieveParams.GroupType.GROUP)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("group_type", "group").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            GroupRetrieveParams.builder().projectId("project_id").groupId("group_id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
