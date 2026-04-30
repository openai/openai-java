// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.roles

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoleCreateParamsTest {

    @Test
    fun create() {
        RoleCreateParams.builder()
            .addPermission("string")
            .roleName("role_name")
            .description("description")
            .build()
    }

    @Test
    fun body() {
        val params =
            RoleCreateParams.builder()
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
            RoleCreateParams.builder().addPermission("string").roleName("role_name").build()

        val body = params._body()

        assertThat(body.permissions()).containsExactly("string")
        assertThat(body.roleName()).isEqualTo("role_name")
    }
}
