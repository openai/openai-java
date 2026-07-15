// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.roles

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoleUpdateParamsTest {

    @Test
    fun create() {
        RoleUpdateParams.builder()
            .projectId("project_id")
            .roleId("role_id")
            .description("description")
            .addPermission("string")
            .roleName("role_name")
            .build()
    }

    @Test
    fun pathParams() {
        val params = RoleUpdateParams.builder().projectId("project_id").roleId("role_id").build()

        assertThat(params._pathParam(0)).isEqualTo("project_id")
        assertThat(params._pathParam(1)).isEqualTo("role_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            RoleUpdateParams.builder()
                .projectId("project_id")
                .roleId("role_id")
                .description("description")
                .addPermission("string")
                .roleName("role_name")
                .build()

        val body = params._body()

        assertThat(body.description()).contains("description")
        assertThat(body.permissions().getOrNull()).containsExactly("string")
        assertThat(body.roleName()).contains("role_name")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = RoleUpdateParams.builder().projectId("project_id").roleId("role_id").build()

        val body = params._body()
    }
}
