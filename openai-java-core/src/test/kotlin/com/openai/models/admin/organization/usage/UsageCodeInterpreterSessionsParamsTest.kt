// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.usage

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UsageCodeInterpreterSessionsParamsTest {

    @Test
    fun create() {
        UsageCodeInterpreterSessionsParams.builder()
            .startTime(0L)
            .bucketWidth(UsageCodeInterpreterSessionsParams.BucketWidth._1M)
            .endTime(0L)
            .addGroupBy(UsageCodeInterpreterSessionsParams.GroupBy.PROJECT_ID)
            .limit(0L)
            .page("page")
            .addProjectId("string")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            UsageCodeInterpreterSessionsParams.builder()
                .startTime(0L)
                .bucketWidth(UsageCodeInterpreterSessionsParams.BucketWidth._1M)
                .endTime(0L)
                .addGroupBy(UsageCodeInterpreterSessionsParams.GroupBy.PROJECT_ID)
                .limit(0L)
                .page("page")
                .addProjectId("string")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("start_time", "0")
                    .put("bucket_width", "1m")
                    .put("end_time", "0")
                    .put("group_by[]", "project_id")
                    .put("limit", "0")
                    .put("page", "page")
                    .put("project_ids[]", "string")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = UsageCodeInterpreterSessionsParams.builder().startTime(0L).build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("start_time", "0").build())
    }
}
