// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseUsageTest {

    @Test
    fun create() {
        val responseUsage =
            ResponseUsage.builder()
                .inputTokens(0L)
                .inputTokensDetails(
                    ResponseUsage.InputTokensDetails.builder().cachedTokens(0L).build()
                )
                .outputTokens(0L)
                .outputTokensDetails(
                    ResponseUsage.OutputTokensDetails.builder().reasoningTokens(0L).build()
                )
                .totalTokens(0L)
                .build()

        assertThat(responseUsage.inputTokens()).isEqualTo(0L)
        assertThat(responseUsage.inputTokensDetails())
            .isEqualTo(ResponseUsage.InputTokensDetails.builder().cachedTokens(0L).build())
        assertThat(responseUsage.outputTokens()).isEqualTo(0L)
        assertThat(responseUsage.outputTokensDetails())
            .isEqualTo(ResponseUsage.OutputTokensDetails.builder().reasoningTokens(0L).build())
        assertThat(responseUsage.totalTokens()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseUsage =
            ResponseUsage.builder()
                .inputTokens(0L)
                .inputTokensDetails(
                    ResponseUsage.InputTokensDetails.builder().cachedTokens(0L).build()
                )
                .outputTokens(0L)
                .outputTokensDetails(
                    ResponseUsage.OutputTokensDetails.builder().reasoningTokens(0L).build()
                )
                .totalTokens(0L)
                .build()

        val roundtrippedResponseUsage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseUsage),
                jacksonTypeRef<ResponseUsage>(),
            )

        assertThat(roundtrippedResponseUsage).isEqualTo(responseUsage)
    }
}
