// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.jobs

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class JobPauseParamsTest {

    @Test
    fun create() {
        JobPauseParams.builder().fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F").build()
    }

    @Test
    fun pathParams() {
        val params = JobPauseParams.builder().fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F").build()

        assertThat(params._pathParam(0)).isEqualTo("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
