// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.groups

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GroupUpdateParamsTest {

    @Test
    fun create() {
        GroupUpdateParams.builder().groupId("group_id").name("x").build()
    }

    @Test
    fun pathParams() {
        val params = GroupUpdateParams.builder().groupId("group_id").name("x").build()

        assertThat(params._pathParam(0)).isEqualTo("group_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params = GroupUpdateParams.builder().groupId("group_id").name("x").build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("x")
    }
}
