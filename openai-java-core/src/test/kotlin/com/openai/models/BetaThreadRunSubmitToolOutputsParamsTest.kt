// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BetaThreadRunSubmitToolOutputsParamsTest {

    @Test
    fun createBetaThreadRunSubmitToolOutputsParams() {
        BetaThreadRunSubmitToolOutputsParams.builder()
            .threadId("thread_id")
            .runId("run_id")
            .toolOutputs(
                listOf(
                    BetaThreadRunSubmitToolOutputsParams.ToolOutput.builder()
                        .output("output")
                        .toolCallId("tool_call_id")
                        .build()
                )
            )
            .build()
    }

    @Test
    fun getBody() {
        val params =
            BetaThreadRunSubmitToolOutputsParams.builder()
                .threadId("thread_id")
                .runId("run_id")
                .toolOutputs(
                    listOf(
                        BetaThreadRunSubmitToolOutputsParams.ToolOutput.builder()
                            .output("output")
                            .toolCallId("tool_call_id")
                            .build()
                    )
                )
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.toolOutputs())
            .isEqualTo(
                listOf(
                    BetaThreadRunSubmitToolOutputsParams.ToolOutput.builder()
                        .output("output")
                        .toolCallId("tool_call_id")
                        .build()
                )
            )
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            BetaThreadRunSubmitToolOutputsParams.builder()
                .threadId("thread_id")
                .runId("run_id")
                .toolOutputs(
                    listOf(BetaThreadRunSubmitToolOutputsParams.ToolOutput.builder().build())
                )
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.toolOutputs())
            .isEqualTo(listOf(BetaThreadRunSubmitToolOutputsParams.ToolOutput.builder().build()))
    }

    @Test
    fun getPathParam() {
        val params =
            BetaThreadRunSubmitToolOutputsParams.builder()
                .threadId("thread_id")
                .runId("run_id")
                .toolOutputs(
                    listOf(BetaThreadRunSubmitToolOutputsParams.ToolOutput.builder().build())
                )
                .build()
        assertThat(params).isNotNull
        // path param "threadId"
        assertThat(params.getPathParam(0)).isEqualTo("thread_id")
        // path param "runId"
        assertThat(params.getPathParam(1)).isEqualTo("run_id")
        // out-of-bound path param
        assertThat(params.getPathParam(2)).isEqualTo("")
    }
}
