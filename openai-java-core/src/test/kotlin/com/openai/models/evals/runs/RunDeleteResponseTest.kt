// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.evals.runs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RunDeleteResponseTest {

    @Test
    fun createAndRoundtrip() {
        val runDeleteResponse =
            RunDeleteResponse.builder()
                .deleted(true)
                .object_("eval.run.deleted")
                .runId("evalrun_677469f564d48190807532a852da3afb")
                .build()

        assertThat(runDeleteResponse.deleted()).contains(true)
        assertThat(runDeleteResponse.object_()).contains("eval.run.deleted")
        assertThat(runDeleteResponse.runId()).contains("evalrun_677469f564d48190807532a852da3afb")

        val jsonMapper = jsonMapper()

        val roundtrippedRunDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(runDeleteResponse),
                jacksonTypeRef<RunDeleteResponse>(),
            )

        assertThat(roundtrippedRunDeleteResponse).isEqualTo(runDeleteResponse)
    }
}
