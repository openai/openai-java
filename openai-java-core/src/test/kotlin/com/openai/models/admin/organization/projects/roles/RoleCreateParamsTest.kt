// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.roles

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoleCreateParamsTest {

    @Test
    fun create() {
        RoleCreateParams.builder()
            .projectId("project_id")
            .addPermission("string")
            .roleName("role_name")
            .description("description")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            RoleCreateParams.builder()
                .projectId("project_id")
                .addPermission("string")
                .roleName("role_name")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("project_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            RoleCreateParams.builder()
                .projectId("project_id")
                .addPermission("string")
                .roleName("role_name")
                .description("description")
                .build()

        val body = params._body()

        assertThat(body.permissions()).containsExactly("string")
        assertThat(body.roleName()).isEqualTo("role_name")
        assertThat(body.description()).contains("description")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            RoleCreateParams.builder()
                .projectId("project_id")
                .addPermission("string")
                .roleName("role_name")
                .build()

        val body = params._body()

        assertThat(body.permissions()).containsExactly("string")
        assertThat(body.roleName()).isEqualTo("role_name")
    }
}
