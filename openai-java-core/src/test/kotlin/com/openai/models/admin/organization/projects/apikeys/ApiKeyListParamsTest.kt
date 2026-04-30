// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.apikeys

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiKeyListParamsTest {

    @Test
    fun create() {
        ApiKeyListParams.builder().projectId("project_id").after("after").limit(0L).build()
    }

    @Test
    fun pathParams() {
        val params = ApiKeyListParams.builder().projectId("project_id").build()

        assertThat(params._pathParam(0)).isEqualTo("project_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            ApiKeyListParams.builder().projectId("project_id").after("after").limit(0L).build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("after", "after").put("limit", "0").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = ApiKeyListParams.builder().projectId("project_id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
