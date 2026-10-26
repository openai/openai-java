// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.PromptCacheBreakpointTtl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseInputTextContentTest {

    @Test
    fun createAndRoundtrip() {
        val responseInputTextContent =
            ResponseInputTextContent.builder()
                .text("text")
                .promptCacheBreakpoint(
                    ResponseInputTextContent.PromptCacheBreakpoint.builder()
                        .ttl(PromptCacheBreakpointTtl._30M)
                        .build()
                )
                .build()

        assertThat(responseInputTextContent.text()).isEqualTo("text")
        assertThat(responseInputTextContent.promptCacheBreakpoint())
            .contains(
                ResponseInputTextContent.PromptCacheBreakpoint.builder()
                    .ttl(PromptCacheBreakpointTtl._30M)
                    .build()
            )

        val jsonMapper = jsonMapper()

        val roundtrippedResponseInputTextContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseInputTextContent),
                jacksonTypeRef<ResponseInputTextContent>(),
            )

        assertThat(roundtrippedResponseInputTextContent).isEqualTo(responseInputTextContent)
    }
}
