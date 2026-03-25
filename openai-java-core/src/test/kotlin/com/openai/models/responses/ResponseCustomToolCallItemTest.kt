// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCustomToolCallItemTest {

    @Test
    fun create() {
        val responseCustomToolCallItem =
            ResponseCustomToolCallItem.builder()
                .callId("call_id")
                .input("input")
                .name("name")
                .id("id")
                .namespace("namespace")
                .status(ResponseCustomToolCallItem.Status.IN_PROGRESS)
                .createdBy("created_by")
                .build()

        assertThat(responseCustomToolCallItem.callId()).isEqualTo("call_id")
        assertThat(responseCustomToolCallItem.input()).isEqualTo("input")
        assertThat(responseCustomToolCallItem.name()).isEqualTo("name")
        assertThat(responseCustomToolCallItem.id()).contains("id")
        assertThat(responseCustomToolCallItem.namespace()).contains("namespace")
        assertThat(responseCustomToolCallItem.status())
            .isEqualTo(ResponseCustomToolCallItem.Status.IN_PROGRESS)
        assertThat(responseCustomToolCallItem.createdBy()).contains("created_by")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseCustomToolCallItem =
            ResponseCustomToolCallItem.builder()
                .callId("call_id")
                .input("input")
                .name("name")
                .id("id")
                .namespace("namespace")
                .status(ResponseCustomToolCallItem.Status.IN_PROGRESS)
                .createdBy("created_by")
                .build()

        val roundtrippedResponseCustomToolCallItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseCustomToolCallItem),
                jacksonTypeRef<ResponseCustomToolCallItem>(),
            )

        assertThat(roundtrippedResponseCustomToolCallItem).isEqualTo(responseCustomToolCallItem)
    }
}
