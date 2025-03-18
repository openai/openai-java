// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses.inputitems

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseItemListTest {

    @Test
    fun create() {
        val responseItemList =
            ResponseItemList.builder()
                .addData(
                    ResponseItemList.Data.Message.builder()
                        .id("id")
                        .addInputTextContent("text")
                        .role(ResponseItemList.Data.Message.Role.USER)
                        .status(ResponseItemList.Data.Message.Status.IN_PROGRESS)
                        .type(ResponseItemList.Data.Message.Type.MESSAGE)
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(responseItemList.data())
            .containsExactly(
                ResponseItemList.Data.ofMessage(
                    ResponseItemList.Data.Message.builder()
                        .id("id")
                        .addInputTextContent("text")
                        .role(ResponseItemList.Data.Message.Role.USER)
                        .status(ResponseItemList.Data.Message.Status.IN_PROGRESS)
                        .type(ResponseItemList.Data.Message.Type.MESSAGE)
                        .build()
                )
            )
        assertThat(responseItemList.firstId()).isEqualTo("first_id")
        assertThat(responseItemList.hasMore()).isEqualTo(true)
        assertThat(responseItemList.lastId()).isEqualTo("last_id")
    }
}
