// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeMcpProtocolErrorTest {

    @Test
    fun create() {
        val realtimeMcpProtocolError =
            RealtimeMcpProtocolError.builder().code(0L).message("message").build()

        assertThat(realtimeMcpProtocolError.code()).isEqualTo(0L)
        assertThat(realtimeMcpProtocolError.message()).isEqualTo("message")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeMcpProtocolError =
            RealtimeMcpProtocolError.builder().code(0L).message("message").build()

        val roundtrippedRealtimeMcpProtocolError =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeMcpProtocolError),
                jacksonTypeRef<RealtimeMcpProtocolError>(),
            )

        assertThat(roundtrippedRealtimeMcpProtocolError).isEqualTo(realtimeMcpProtocolError)
    }
}
