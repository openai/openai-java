// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.users.roles

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoleListParamsTest {

    @Test
    fun create() {
        RoleListParams.builder()
            .userId("user_id")
            .after("after")
            .limit(0L)
            .order(RoleListParams.Order.ASC)
            .build()
    }

    @Test
    fun pathParams() {
        val params = RoleListParams.builder().userId("user_id").build()

        assertThat(params._pathParam(0)).isEqualTo("user_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            RoleListParams.builder()
                .userId("user_id")
                .after("after")
                .limit(0L)
                .order(RoleListParams.Order.ASC)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("limit", "0")
                    .put("order", "asc")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = RoleListParams.builder().userId("user_id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
