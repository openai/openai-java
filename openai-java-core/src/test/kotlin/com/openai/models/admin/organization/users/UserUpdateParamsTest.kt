// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.users

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserUpdateParamsTest {

    @Test
    fun create() {
        UserUpdateParams.builder()
            .userId("user_id")
            .developerPersona("developer_persona")
            .role("role")
            .roleId("role_id")
            .technicalLevel("technical_level")
            .build()
    }

    @Test
    fun pathParams() {
        val params = UserUpdateParams.builder().userId("user_id").build()

        assertThat(params._pathParam(0)).isEqualTo("user_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            UserUpdateParams.builder()
                .userId("user_id")
                .developerPersona("developer_persona")
                .role("role")
                .roleId("role_id")
                .technicalLevel("technical_level")
                .build()

        val body = params._body()

        assertThat(body.developerPersona()).contains("developer_persona")
        assertThat(body.role()).contains("role")
        assertThat(body.roleId()).contains("role_id")
        assertThat(body.technicalLevel()).contains("technical_level")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = UserUpdateParams.builder().userId("user_id").build()

        val body = params._body()
    }
}
