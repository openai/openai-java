// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals.runs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RunDeleteResponseTest {

    @Test
    fun create() {
        val runDeleteResponse =
            RunDeleteResponse.builder()
                .deleted(true)
                .object_("eval.run.deleted")
                .runId("evalrun_677469f564d48190807532a852da3afb")
                .build()

        assertThat(runDeleteResponse.deleted()).contains(true)
        assertThat(runDeleteResponse.object_()).contains("eval.run.deleted")
        assertThat(runDeleteResponse.runId()).contains("evalrun_677469f564d48190807532a852da3afb")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val runDeleteResponse =
            RunDeleteResponse.builder()
                .deleted(true)
                .object_("eval.run.deleted")
                .runId("evalrun_677469f564d48190807532a852da3afb")
                .build()

        val roundtrippedRunDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(runDeleteResponse),
                jacksonTypeRef<RunDeleteResponse>(),
            )

        assertThat(roundtrippedRunDeleteResponse).isEqualTo(runDeleteResponse)
    }
}
