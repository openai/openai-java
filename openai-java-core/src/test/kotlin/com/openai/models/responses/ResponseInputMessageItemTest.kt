// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
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

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseInputMessageItem =
            ResponseInputMessageItem.builder()
                .id("id")
                .addInputTextContent("text")
                .role(ResponseInputMessageItem.Role.USER)
                .status(ResponseInputMessageItem.Status.IN_PROGRESS)
                .type(ResponseInputMessageItem.Type.MESSAGE)
                .build()

        val roundtrippedResponseInputMessageItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseInputMessageItem),
                jacksonTypeRef<ResponseInputMessageItem>(),
            )

        assertThat(roundtrippedResponseInputMessageItem).isEqualTo(responseInputMessageItem)
    }
}
