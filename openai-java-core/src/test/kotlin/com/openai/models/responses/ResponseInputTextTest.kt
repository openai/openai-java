// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseInputTextTest {

    @Test
    fun createAndRoundtrip() {
        val responseInputText =
            ResponseInputText.builder()
                .text("text")
                .promptCacheBreakpoint(ResponseInputText.PromptCacheBreakpoint.builder().build())
                .build()

        assertThat(responseInputText.text()).isEqualTo("text")
        assertThat(responseInputText.promptCacheBreakpoint())
            .contains(ResponseInputText.PromptCacheBreakpoint.builder().build())

        val jsonMapper = jsonMapper()

        val roundtrippedResponseInputText =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseInputText),
                jacksonTypeRef<ResponseInputText>(),
            )

        assertThat(roundtrippedResponseInputText).isEqualTo(responseInputText)
    }
}
