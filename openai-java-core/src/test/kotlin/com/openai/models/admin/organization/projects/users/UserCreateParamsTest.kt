// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.users

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserCreateParamsTest {

    @Test
    fun create() {
        UserCreateParams.builder()
            .projectId("project_id")
            .role("role")
            .email("email")
            .userId("user_id")
            .build()
    }

    @Test
    fun pathParams() {
        val params = UserCreateParams.builder().projectId("project_id").role("role").build()

        assertThat(params._pathParam(0)).isEqualTo("project_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            UserCreateParams.builder()
                .projectId("project_id")
                .role("role")
                .email("email")
                .userId("user_id")
                .build()

        val body = params._body()

        assertThat(body.role()).isEqualTo("role")
        assertThat(body.email()).contains("email")
        assertThat(body.userId()).contains("user_id")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = UserCreateParams.builder().projectId("project_id").role("role").build()

        val body = params._body()

        assertThat(body.role()).isEqualTo("role")
    }
}
