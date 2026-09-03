// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFunctionToolCallOutputItemTest {

    @Test
    fun create() {
        val responseFunctionToolCallOutputItem =
            ResponseFunctionToolCallOutputItem.builder()
                .id("id")
                .output("string")
                .status(ResponseFunctionToolCallOutputItem.Status.IN_PROGRESS)
                .callId("call_id")
                .callerDirect()
                .createdBy("created_by")
                .name("name")
                .namespace("namespace")
                .build()

        assertThat(responseFunctionToolCallOutputItem.id()).isEqualTo("id")
        assertThat(responseFunctionToolCallOutputItem.output())
            .isEqualTo(ResponseFunctionToolCallOutputItem.Output.ofString("string"))
        assertThat(responseFunctionToolCallOutputItem.status())
            .isEqualTo(ResponseFunctionToolCallOutputItem.Status.IN_PROGRESS)
        assertThat(responseFunctionToolCallOutputItem.callId()).contains("call_id")
        assertThat(responseFunctionToolCallOutputItem.caller())
            .contains(ResponseFunctionToolCallOutputItem.Caller.ofDirect())
        assertThat(responseFunctionToolCallOutputItem.createdBy()).contains("created_by")
        assertThat(responseFunctionToolCallOutputItem.name()).contains("name")
        assertThat(responseFunctionToolCallOutputItem.namespace()).contains("namespace")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseFunctionToolCallOutputItem =
            ResponseFunctionToolCallOutputItem.builder()
                .id("id")
                .output("string")
                .status(ResponseFunctionToolCallOutputItem.Status.IN_PROGRESS)
                .callId("call_id")
                .callerDirect()
                .createdBy("created_by")
                .name("name")
                .namespace("namespace")
                .build()

        val roundtrippedResponseFunctionToolCallOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFunctionToolCallOutputItem),
                jacksonTypeRef<ResponseFunctionToolCallOutputItem>(),
            )

        assertThat(roundtrippedResponseFunctionToolCallOutputItem)
            .isEqualTo(responseFunctionToolCallOutputItem)
    }
}
