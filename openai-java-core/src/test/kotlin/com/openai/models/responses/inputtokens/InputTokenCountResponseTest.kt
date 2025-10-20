// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses.inputtokens

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InputTokenCountResponseTest {

    @Test
    fun create() {
        val inputTokenCountResponse = InputTokenCountResponse.builder().inputTokens(123L).build()

        assertThat(inputTokenCountResponse.inputTokens()).isEqualTo(123L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inputTokenCountResponse = InputTokenCountResponse.builder().inputTokens(123L).build()

        val roundtrippedInputTokenCountResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inputTokenCountResponse),
                jacksonTypeRef<InputTokenCountResponse>(),
            )

        assertThat(roundtrippedInputTokenCountResponse).isEqualTo(inputTokenCountResponse)
    }
}
