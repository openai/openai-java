// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseReasoningItemTest {

    @Test
    fun create() {
        val responseReasoningItem =
            ResponseReasoningItem.builder()
                .id("id")
                .addSummary(ResponseReasoningItem.Summary.builder().text("text").build())
                .encryptedContent("encrypted_content")
                .status(ResponseReasoningItem.Status.IN_PROGRESS)
                .build()

        assertThat(responseReasoningItem.id()).isEqualTo("id")
        assertThat(responseReasoningItem.summary())
            .containsExactly(ResponseReasoningItem.Summary.builder().text("text").build())
        assertThat(responseReasoningItem.encryptedContent()).contains("encrypted_content")
        assertThat(responseReasoningItem.status())
            .contains(ResponseReasoningItem.Status.IN_PROGRESS)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseReasoningItem =
            ResponseReasoningItem.builder()
                .id("id")
                .addSummary(ResponseReasoningItem.Summary.builder().text("text").build())
                .encryptedContent("encrypted_content")
                .status(ResponseReasoningItem.Status.IN_PROGRESS)
                .build()

        val roundtrippedResponseReasoningItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseReasoningItem),
                jacksonTypeRef<ResponseReasoningItem>(),
            )

        assertThat(roundtrippedResponseReasoningItem).isEqualTo(responseReasoningItem)
    }
}
