// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeMcpToolExecutionErrorTest {

    @Test
    fun create() {
        val realtimeMcpToolExecutionError =
            RealtimeMcpToolExecutionError.builder().message("message").build()

        assertThat(realtimeMcpToolExecutionError.message()).isEqualTo("message")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeMcpToolExecutionError =
            RealtimeMcpToolExecutionError.builder().message("message").build()

        val roundtrippedRealtimeMcpToolExecutionError =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeMcpToolExecutionError),
                jacksonTypeRef<RealtimeMcpToolExecutionError>(),
            )

        assertThat(roundtrippedRealtimeMcpToolExecutionError)
            .isEqualTo(realtimeMcpToolExecutionError)
    }
}
