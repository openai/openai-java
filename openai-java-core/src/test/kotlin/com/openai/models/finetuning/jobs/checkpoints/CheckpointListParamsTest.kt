// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.jobs.checkpoints

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CheckpointListParamsTest {

    @Test
    fun create() {
        CheckpointListParams.builder()
            .fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
            .after("after")
            .limit(0L)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            CheckpointListParams.builder()
                .fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
                .after("after")
                .limit(0L)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("after", "after").put("limit", "0").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            CheckpointListParams.builder().fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }

    @Test
    fun getPathParam() {
        val params =
            CheckpointListParams.builder().fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F").build()
        assertThat(params).isNotNull
        // path param "fineTuningJobId"
        assertThat(params.getPathParam(0)).isEqualTo("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
