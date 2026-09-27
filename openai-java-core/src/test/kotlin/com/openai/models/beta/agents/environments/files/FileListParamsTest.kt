// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.environments.files

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileListParamsTest {

    @Test
    fun create() {
        FileListParams.builder()
            .environmentId("environment_id")
            .limit(1L)
            .order(FileListParams.Order.ASC)
            .page("page")
            .path("path")
            .build()
    }

    @Test
    fun pathParams() {
        val params = FileListParams.builder().environmentId("environment_id").build()

        assertThat(params._pathParam(0)).isEqualTo("environment_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            FileListParams.builder()
                .environmentId("environment_id")
                .limit(1L)
                .order(FileListParams.Order.ASC)
                .page("page")
                .path("path")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("limit", "1")
                    .put("order", "asc")
                    .put("page", "page")
                    .put("path", "path")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = FileListParams.builder().environmentId("environment_id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
