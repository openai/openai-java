// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FineTuningJobListEventsParamsTest {

    @Test
    fun createFineTuningJobListEventsParams() {
        FineTuningJobListEventsParams.builder()
            .fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
            .after("after")
            .limit(0L)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            FineTuningJobListEventsParams.builder()
                .fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
                .after("after")
                .limit(0L)
                .build()
        val expected = QueryParams.builder()
        expected.put("after", "after")
        expected.put("limit", "0")
        assertThat(params.getQueryParams()).isEqualTo(expected.build())
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params =
            FineTuningJobListEventsParams.builder()
                .fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
                .build()
        val expected = QueryParams.builder()
        assertThat(params.getQueryParams()).isEqualTo(expected.build())
    }

    @Test
    fun getPathParam() {
        val params =
            FineTuningJobListEventsParams.builder()
                .fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
                .build()
        assertThat(params).isNotNull
        // path param "fineTuningJobId"
        assertThat(params.getPathParam(0)).isEqualTo("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
