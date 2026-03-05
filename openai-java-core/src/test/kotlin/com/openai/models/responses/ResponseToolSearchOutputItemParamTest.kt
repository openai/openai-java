// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseToolSearchOutputItemParamTest {

    @Test
    fun create() {
        val responseToolSearchOutputItemParam =
            ResponseToolSearchOutputItemParam.builder()
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
                .id("tso_123")
                .callId("x")
                .execution(ResponseToolSearchOutputItemParam.Execution.SERVER)
                .status(ResponseToolSearchOutputItemParam.Status.IN_PROGRESS)
                .build()

        assertThat(responseToolSearchOutputItemParam.tools())
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
        assertThat(responseToolSearchOutputItemParam.id()).contains("tso_123")
        assertThat(responseToolSearchOutputItemParam.callId()).contains("x")
        assertThat(responseToolSearchOutputItemParam.execution())
            .contains(ResponseToolSearchOutputItemParam.Execution.SERVER)
        assertThat(responseToolSearchOutputItemParam.status())
            .contains(ResponseToolSearchOutputItemParam.Status.IN_PROGRESS)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseToolSearchOutputItemParam =
            ResponseToolSearchOutputItemParam.builder()
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
                .id("tso_123")
                .callId("x")
                .execution(ResponseToolSearchOutputItemParam.Execution.SERVER)
                .status(ResponseToolSearchOutputItemParam.Status.IN_PROGRESS)
                .build()

        val roundtrippedResponseToolSearchOutputItemParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseToolSearchOutputItemParam),
                jacksonTypeRef<ResponseToolSearchOutputItemParam>(),
            )

        assertThat(roundtrippedResponseToolSearchOutputItemParam)
            .isEqualTo(responseToolSearchOutputItemParam)
    }
}
