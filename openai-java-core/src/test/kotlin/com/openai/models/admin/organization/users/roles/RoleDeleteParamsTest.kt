// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.users.roles

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoleDeleteParamsTest {

    @Test
    fun create() {
        RoleDeleteParams.builder().userId("user_id").roleId("role_id").build()
    }

    @Test
    fun pathParams() {
        val params = RoleDeleteParams.builder().userId("user_id").roleId("role_id").build()

        assertThat(params._pathParam(0)).isEqualTo("user_id")
        assertThat(params._pathParam(1)).isEqualTo("role_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }
}
