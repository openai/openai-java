// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseReasoningItemTest {

    @Test
    fun create() {
        val responseReasoningItem =
            ResponseReasoningItem.builder()
                .id("id")
                .addSummary(ResponseReasoningItem.Summary.builder().text("text").build())
                .status(ResponseReasoningItem.Status.IN_PROGRESS)
                .build()

        assertThat(responseReasoningItem.id()).isEqualTo("id")
        assertThat(responseReasoningItem.summary())
            .containsExactly(ResponseReasoningItem.Summary.builder().text("text").build())
        assertThat(responseReasoningItem.status())
            .contains(ResponseReasoningItem.Status.IN_PROGRESS)
    }
}
