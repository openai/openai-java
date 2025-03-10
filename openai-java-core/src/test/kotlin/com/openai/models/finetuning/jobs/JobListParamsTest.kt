// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.jobs

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class JobListParamsTest {

    @Test
    fun create() {
        JobListParams.builder()
            .after("after")
            .limit(0L)
            .metadata(
                JobListParams.Metadata.builder().putAdditionalProperty("foo", "string").build()
            )
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            JobListParams.builder()
                .after("after")
                .limit(0L)
                .metadata(
                    JobListParams.Metadata.builder().putAdditionalProperty("foo", "string").build()
                )
                .build()
        val expected = QueryParams.builder()
        expected.put("after", "after")
        expected.put("limit", "0")
        JobListParams.Metadata.builder()
            .putAdditionalProperty("foo", "string")
            .build()
            .forEachQueryParam { key, values -> expected.put("metadata[$key]", values) }
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = JobListParams.builder().build()
        val expected = QueryParams.builder()
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }
}
