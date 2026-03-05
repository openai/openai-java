// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseToolSearchOutputItemTest {

    @Test
    fun create() {
        val responseToolSearchOutputItem =
            ResponseToolSearchOutputItem.builder()
                .id("id")
                .callId("call_id")
                .execution(ResponseToolSearchOutputItem.Execution.SERVER)
                .status(ResponseToolSearchOutputItem.Status.IN_PROGRESS)
                .addTool(
                    FunctionTool.builder()
                        .name("name")
                        .parameters(
                            FunctionTool.Parameters.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .strict(true)
                        .deferLoading(true)
                        .description("description")
                        .build()
                )
                .createdBy("created_by")
                .build()

        assertThat(responseToolSearchOutputItem.id()).isEqualTo("id")
        assertThat(responseToolSearchOutputItem.callId()).contains("call_id")
        assertThat(responseToolSearchOutputItem.execution())
            .isEqualTo(ResponseToolSearchOutputItem.Execution.SERVER)
        assertThat(responseToolSearchOutputItem.status())
            .isEqualTo(ResponseToolSearchOutputItem.Status.IN_PROGRESS)
        assertThat(responseToolSearchOutputItem.tools())
            .containsExactly(
                Tool.ofFunction(
                    FunctionTool.builder()
                        .name("name")
                        .parameters(
                            FunctionTool.Parameters.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .strict(true)
                        .deferLoading(true)
                        .description("description")
                        .build()
                )
            )
        assertThat(responseToolSearchOutputItem.createdBy()).contains("created_by")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseToolSearchOutputItem =
            ResponseToolSearchOutputItem.builder()
                .id("id")
                .callId("call_id")
                .execution(ResponseToolSearchOutputItem.Execution.SERVER)
                .status(ResponseToolSearchOutputItem.Status.IN_PROGRESS)
                .addTool(
                    FunctionTool.builder()
                        .name("name")
                        .parameters(
                            FunctionTool.Parameters.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .strict(true)
                        .deferLoading(true)
                        .description("description")
                        .build()
                )
                .createdBy("created_by")
                .build()

        val roundtrippedResponseToolSearchOutputItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseToolSearchOutputItem),
                jacksonTypeRef<ResponseToolSearchOutputItem>(),
            )

        assertThat(roundtrippedResponseToolSearchOutputItem).isEqualTo(responseToolSearchOutputItem)
    }
}
