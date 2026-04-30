// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.users

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserListParamsTest {

    @Test
    fun create() {
        UserListParams.builder().after("after").addEmail("string").limit(0L).build()
    }

    @Test
    fun queryParams() {
        val params = UserListParams.builder().after("after").addEmail("string").limit(0L).build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("emails[]", "string")
                    .put("limit", "0")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = UserListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
