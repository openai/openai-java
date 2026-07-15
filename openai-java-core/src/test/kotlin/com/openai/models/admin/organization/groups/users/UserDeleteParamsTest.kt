// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.groups.users

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserDeleteParamsTest {

    @Test
    fun create() {
        UserDeleteParams.builder().groupId("group_id").userId("user_id").build()
    }

    @Test
    fun pathParams() {
        val params = UserDeleteParams.builder().groupId("group_id").userId("user_id").build()

        assertThat(params._pathParam(0)).isEqualTo("group_id")
        assertThat(params._pathParam(1)).isEqualTo("user_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }
}
