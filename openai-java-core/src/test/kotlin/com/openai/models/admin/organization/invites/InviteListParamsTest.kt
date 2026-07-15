// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.invites

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InviteListParamsTest {

    @Test
    fun create() {
        InviteListParams.builder().after("after").limit(0L).build()
    }

    @Test
    fun queryParams() {
        val params = InviteListParams.builder().after("after").limit(0L).build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("after", "after").put("limit", "0").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = InviteListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
