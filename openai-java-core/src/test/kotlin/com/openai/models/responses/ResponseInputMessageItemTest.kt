// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseInputMessageItemTest {

    @Test
    fun create() {
        val responseInputMessageItem =
            ResponseInputMessageItem.builder()
                .id("id")
                .addInputTextContent("text")
                .role(ResponseInputMessageItem.Role.USER)
                .status(ResponseInputMessageItem.Status.IN_PROGRESS)
                .type(ResponseInputMessageItem.Type.MESSAGE)
                .build()

        assertThat(responseInputMessageItem.id()).isEqualTo("id")
        assertThat(responseInputMessageItem.content())
            .containsExactly(
                ResponseInputContent.ofInputText(ResponseInputText.builder().text("text").build())
            )
        assertThat(responseInputMessageItem.role()).isEqualTo(ResponseInputMessageItem.Role.USER)
        assertThat(responseInputMessageItem.status())
            .contains(ResponseInputMessageItem.Status.IN_PROGRESS)
        assertThat(responseInputMessageItem.type()).contains(ResponseInputMessageItem.Type.MESSAGE)
    }
}
