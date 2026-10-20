// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.externalstorage

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExternalStorageListParamsTest {

    @Test
    fun create() {
        ExternalStorageListParams.builder()
            .after("after")
            .limit(1L)
            .order(ExternalStorageListParams.Order.ASC)
            .projectId("proj_123")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            ExternalStorageListParams.builder()
                .after("after")
                .limit(1L)
                .order(ExternalStorageListParams.Order.ASC)
                .projectId("proj_123")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("limit", "1")
                    .put("order", "asc")
                    .put("project_id", "proj_123")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = ExternalStorageListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
