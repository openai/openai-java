// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponseUsageTest {

    @Test
    fun createResponseUsage() {
        val responseUsage =
            ResponseUsage.builder()
                .inputTokens(0L)
                .outputTokens(0L)
                .outputTokensDetails(
                    ResponseUsage.OutputTokensDetails.builder().reasoningTokens(0L).build()
                )
                .totalTokens(0L)
                .build()
        assertThat(responseUsage).isNotNull
        assertThat(responseUsage.inputTokens()).isEqualTo(0L)
        assertThat(responseUsage.outputTokens()).isEqualTo(0L)
        assertThat(responseUsage.outputTokensDetails())
            .isEqualTo(ResponseUsage.OutputTokensDetails.builder().reasoningTokens(0L).build())
        assertThat(responseUsage.totalTokens()).isEqualTo(0L)
    }
}
