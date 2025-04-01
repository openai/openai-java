// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses.inputitems

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.responses.ResponseInputMessageItem
import com.openai.models.responses.ResponseItem
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseItemListTest {

    @Test
    fun create() {
        val responseItemList =
            ResponseItemList.builder()
                .addData(
                    ResponseInputMessageItem.builder()
                        .id("id")
                        .addInputTextContent("text")
                        .role(ResponseInputMessageItem.Role.USER)
                        .status(ResponseInputMessageItem.Status.IN_PROGRESS)
                        .type(ResponseInputMessageItem.Type.MESSAGE)
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(responseItemList.data())
            .containsExactly(
                ResponseItem.ofResponseInputMessageItem(
                    ResponseInputMessageItem.builder()
                        .id("id")
                        .addInputTextContent("text")
                        .role(ResponseInputMessageItem.Role.USER)
                        .status(ResponseInputMessageItem.Status.IN_PROGRESS)
                        .type(ResponseInputMessageItem.Type.MESSAGE)
                        .build()
                )
            )
        assertThat(responseItemList.firstId()).isEqualTo("first_id")
        assertThat(responseItemList.hasMore()).isEqualTo(true)
        assertThat(responseItemList.lastId()).isEqualTo("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseItemList =
            ResponseItemList.builder()
                .addData(
                    ResponseInputMessageItem.builder()
                        .id("id")
                        .addInputTextContent("text")
                        .role(ResponseInputMessageItem.Role.USER)
                        .status(ResponseInputMessageItem.Status.IN_PROGRESS)
                        .type(ResponseInputMessageItem.Type.MESSAGE)
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        val roundtrippedResponseItemList =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseItemList),
                jacksonTypeRef<ResponseItemList>(),
            )

        assertThat(roundtrippedResponseItemList).isEqualTo(responseItemList)
    }
}
