// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.users

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserUpdateParamsTest {

    @Test
    fun create() {
        UserUpdateParams.builder()
            .projectId("project_id")
            .userId("user_id")
            .role(UserUpdateParams.Role.OWNER)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            UserUpdateParams.builder()
                .projectId("project_id")
                .userId("user_id")
                .role(UserUpdateParams.Role.OWNER)
                .build()

        assertThat(params._pathParam(0)).isEqualTo("project_id")
        assertThat(params._pathParam(1)).isEqualTo("user_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            UserUpdateParams.builder()
                .projectId("project_id")
                .userId("user_id")
                .role(UserUpdateParams.Role.OWNER)
                .build()

        val body = params._body()

        assertThat(body.role()).isEqualTo(UserUpdateParams.Role.OWNER)
    }
}
