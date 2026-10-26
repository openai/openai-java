// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeMcphttpErrorTest {

    @Test
    fun createAndRoundtrip() {
        val realtimeMcphttpError =
            RealtimeMcphttpError.builder().code(0L).message("message").build()

        assertThat(realtimeMcphttpError.code()).isEqualTo(0L)
        assertThat(realtimeMcphttpError.message()).isEqualTo("message")

        val jsonMapper = jsonMapper()

        val roundtrippedRealtimeMcphttpError =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeMcphttpError),
                jacksonTypeRef<RealtimeMcphttpError>(),
            )

        assertThat(roundtrippedRealtimeMcphttpError).isEqualTo(realtimeMcphttpError)
    }
}
