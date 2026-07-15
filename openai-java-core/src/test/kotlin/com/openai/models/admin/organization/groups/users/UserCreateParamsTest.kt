// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.groups.users

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserCreateParamsTest {

    @Test
    fun create() {
        UserCreateParams.builder().groupId("group_id").userId("user_id").build()
    }

    @Test
    fun pathParams() {
        val params = UserCreateParams.builder().groupId("group_id").userId("user_id").build()

        assertThat(params._pathParam(0)).isEqualTo("group_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params = UserCreateParams.builder().groupId("group_id").userId("user_id").build()

        val body = params._body()

        assertThat(body.userId()).isEqualTo("user_id")
    }
}
