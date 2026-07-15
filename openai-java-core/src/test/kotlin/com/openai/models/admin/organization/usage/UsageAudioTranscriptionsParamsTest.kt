// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.usage

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UsageAudioTranscriptionsParamsTest {

    @Test
    fun create() {
        UsageAudioTranscriptionsParams.builder()
            .startTime(0L)
            .addApiKeyId("string")
            .bucketWidth(UsageAudioTranscriptionsParams.BucketWidth._1M)
            .endTime(0L)
            .addGroupBy(UsageAudioTranscriptionsParams.GroupBy.PROJECT_ID)
            .limit(0L)
            .addModel("string")
            .page("page")
            .addProjectId("string")
            .addUserId("string")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            UsageAudioTranscriptionsParams.builder()
                .startTime(0L)
                .addApiKeyId("string")
                .bucketWidth(UsageAudioTranscriptionsParams.BucketWidth._1M)
                .endTime(0L)
                .addGroupBy(UsageAudioTranscriptionsParams.GroupBy.PROJECT_ID)
                .limit(0L)
                .addModel("string")
                .page("page")
                .addProjectId("string")
                .addUserId("string")
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
                    .put("models[]", "string")
                    .put("page", "page")
                    .put("project_ids[]", "string")
                    .put("user_ids[]", "string")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = UsageAudioTranscriptionsParams.builder().startTime(0L).build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("start_time", "0").build())
    }
}
