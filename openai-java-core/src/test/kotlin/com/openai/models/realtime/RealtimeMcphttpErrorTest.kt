// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeMcphttpErrorTest {

    @Test
    fun create() {
        val realtimeMcphttpError =
            RealtimeMcphttpError.builder().code(0L).message("message").build()

        assertThat(realtimeMcphttpError.code()).isEqualTo(0L)
        assertThat(realtimeMcphttpError.message()).isEqualTo("message")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeMcphttpError =
            RealtimeMcphttpError.builder().code(0L).message("message").build()

        val roundtrippedRealtimeMcphttpError =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeMcphttpError),
                jacksonTypeRef<RealtimeMcphttpError>(),
            )

        assertThat(roundtrippedRealtimeMcphttpError).isEqualTo(realtimeMcphttpError)
    }
}
