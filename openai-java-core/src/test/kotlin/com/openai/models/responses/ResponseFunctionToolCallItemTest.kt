// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFunctionToolCallItemTest {

    @Test
    fun create() {
        val responseFunctionToolCallItem =
            ResponseFunctionToolCallItem.builder()
                .arguments("arguments")
                .callId("call_id")
                .name("name")
                .id("id")
                .namespace("namespace")
                .status(ResponseFunctionToolCall.Status.IN_PROGRESS)
                .createdBy("created_by")
                .build()

        assertThat(responseFunctionToolCallItem.arguments()).isEqualTo("arguments")
        assertThat(responseFunctionToolCallItem.callId()).isEqualTo("call_id")
        assertThat(responseFunctionToolCallItem.name()).isEqualTo("name")
        assertThat(responseFunctionToolCallItem.id()).contains("id")
        assertThat(responseFunctionToolCallItem.namespace()).contains("namespace")
        assertThat(responseFunctionToolCallItem.status())
            .contains(ResponseFunctionToolCall.Status.IN_PROGRESS)
        assertThat(responseFunctionToolCallItem.createdBy()).contains("created_by")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseFunctionToolCallItem =
            ResponseFunctionToolCallItem.builder()
                .arguments("arguments")
                .callId("call_id")
                .name("name")
                .id("id")
                .namespace("namespace")
                .status(ResponseFunctionToolCall.Status.IN_PROGRESS)
                .createdBy("created_by")
                .build()

        val roundtrippedResponseFunctionToolCallItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFunctionToolCallItem),
                jacksonTypeRef<ResponseFunctionToolCallItem>(),
            )

        assertThat(roundtrippedResponseFunctionToolCallItem).isEqualTo(responseFunctionToolCallItem)
    }
}
