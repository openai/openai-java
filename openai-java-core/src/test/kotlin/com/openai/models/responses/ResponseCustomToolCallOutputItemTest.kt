// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCustomToolCallOutputItemTest {

    @Test
    fun create() {
        val responseCustomToolCallOutputItem =
            ResponseCustomToolCallOutputItem.builder()
                .callId("call_id")
                .output("string")
                .id("id")
                .status(ResponseCustomToolCallOutputItem.Status.IN_PROGRESS)
                .createdBy("created_by")
                .build()

        assertThat(responseCustomToolCallOutputItem.callId()).isEqualTo("call_id")
        assertThat(responseCustomToolCallOutputItem.output())
            .isEqualTo(ResponseCustomToolCallOutput.Output.ofString("string"))
        assertThat(responseCustomToolCallOutputItem.id()).contains("id")
        assertThat(responseCustomToolCallOutputItem.status())
            .isEqualTo(ResponseCustomToolCallOutputItem.Status.IN_PROGRESS)
        assertThat(responseCustomToolCallOutputItem.createdBy()).contains("created_by")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseCustomToolCallOutputItem =
            ResponseCustomToolCallOutputItem.builder()
                .callId("call_id")
                .output("string")
                .id("id")
                .status(ResponseCustomToolCallOutputItem.Status.IN_PROGRESS)
                .createdBy("created_by")
                .build()

        val roundtrippedResponseCustomToolCallOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseCustomToolCallOutputItem),
                jacksonTypeRef<ResponseCustomToolCallOutputItem>(),
            )

        assertThat(roundtrippedResponseCustomToolCallOutputItem)
            .isEqualTo(responseCustomToolCallOutputItem)
    }
}
