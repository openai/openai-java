// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.groups

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GroupDeleteParamsTest {

    @Test
    fun create() {
        GroupDeleteParams.builder().groupId("group_id").build()
    }

    @Test
    fun pathParams() {
        val params = GroupDeleteParams.builder().groupId("group_id").build()

        assertThat(params._pathParam(0)).isEqualTo("group_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
