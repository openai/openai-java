// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FineTuningJobCheckpointListParamsTest {

    @Test
    fun createFineTuningJobCheckpointListParams() {
        FineTuningJobCheckpointListParams.builder()
            .fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
            .after("after")
            .limit(0L)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            FineTuningJobCheckpointListParams.builder()
                .fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
                .after("after")
                .limit(0L)
                .build()
        val expected = QueryParams.builder()
        expected.put("after", "after")
        expected.put("limit", "0")
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            FineTuningJobCheckpointListParams.builder()
                .fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
                .build()
        val expected = QueryParams.builder()
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun getPathParam() {
        val params =
            FineTuningJobCheckpointListParams.builder()
                .fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
                .build()
        assertThat(params).isNotNull
        // path param "fineTuningJobId"
        assertThat(params.getPathParam(0)).isEqualTo("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
