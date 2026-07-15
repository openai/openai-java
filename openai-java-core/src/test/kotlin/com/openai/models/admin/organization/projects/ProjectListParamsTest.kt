// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProjectListParamsTest {

    @Test
    fun create() {
        ProjectListParams.builder().after("after").includeArchived(true).limit(0L).build()
    }

    @Test
    fun queryParams() {
        val params =
            ProjectListParams.builder().after("after").includeArchived(true).limit(0L).build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("include_archived", "true")
                    .put("limit", "0")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = ProjectListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
