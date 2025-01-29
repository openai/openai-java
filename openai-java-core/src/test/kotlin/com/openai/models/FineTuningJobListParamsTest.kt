// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FineTuningJobListParamsTest {

    @Test
    fun createFineTuningJobListParams() {
        FineTuningJobListParams.builder().after("after").limit(0L).build()
    }

    @Test
    fun queryParams() {
        val params = FineTuningJobListParams.builder().after("after").limit(0L).build()
        val expected = QueryParams.builder()
        expected.put("after", "after")
        expected.put("limit", "0")
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = FineTuningJobListParams.builder().build()
        val expected = QueryParams.builder()
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }
}
