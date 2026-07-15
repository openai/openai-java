// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.usage

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UsageFileSearchCallsParamsTest {

    @Test
    fun create() {
        UsageFileSearchCallsParams.builder()
            .startTime(0L)
            .addApiKeyId("string")
            .bucketWidth(UsageFileSearchCallsParams.BucketWidth._1M)
            .endTime(0L)
            .addGroupBy(UsageFileSearchCallsParams.GroupBy.PROJECT_ID)
            .limit(0L)
            .page("page")
            .addProjectId("string")
            .addUserId("string")
            .addVectorStoreId("string")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            UsageFileSearchCallsParams.builder()
                .startTime(0L)
                .addApiKeyId("string")
                .bucketWidth(UsageFileSearchCallsParams.BucketWidth._1M)
                .endTime(0L)
                .addGroupBy(UsageFileSearchCallsParams.GroupBy.PROJECT_ID)
                .limit(0L)
                .page("page")
                .addProjectId("string")
                .addUserId("string")
                .addVectorStoreId("string")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("start_time", "0")
                    .put("api_key_ids[]", "string")
                    .put("bucket_width", "1m")
                    .put("end_time", "0")
                    .put("group_by[]", "project_id")
                    .put("limit", "0")
                    .put("page", "page")
                    .put("project_ids[]", "string")
                    .put("user_ids[]", "string")
                    .put("vector_store_ids[]", "string")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = UsageFileSearchCallsParams.builder().startTime(0L).build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("start_time", "0").build())
    }
}
