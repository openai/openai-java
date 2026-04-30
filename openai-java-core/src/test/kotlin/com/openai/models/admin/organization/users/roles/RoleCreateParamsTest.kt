// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.users.roles

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoleCreateParamsTest {

    @Test
    fun create() {
        RoleCreateParams.builder().userId("user_id").roleId("role_id").build()
    }

    @Test
    fun pathParams() {
        val params = RoleCreateParams.builder().userId("user_id").roleId("role_id").build()

        assertThat(params._pathParam(0)).isEqualTo("user_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params = RoleCreateParams.builder().userId("user_id").roleId("role_id").build()

        val body = params._body()

        assertThat(body.roleId()).isEqualTo("role_id")
    }
}
