// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs

import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RunSubmitToolOutputsParamsTest {

    @Test
    fun create() {
        RunSubmitToolOutputsParams.builder()
            .threadId("thread_id")
            .runId("run_id")
            .addToolOutput(
                RunSubmitToolOutputsParams.ToolOutput.builder()
                    .output("output")
                    .toolCallId("tool_call_id")
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            RunSubmitToolOutputsParams.builder()
                .threadId("thread_id")
                .runId("run_id")
                .addToolOutput(
                    RunSubmitToolOutputsParams.ToolOutput.builder()
                        .output("output")
                        .toolCallId("tool_call_id")
                        .build()
                )
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.toolOutputs())
            .isEqualTo(
                listOf(
                    RunSubmitToolOutputsParams.ToolOutput.builder()
                        .output("output")
                        .toolCallId("tool_call_id")
                        .build()
                )
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            RunSubmitToolOutputsParams.builder()
                .threadId("thread_id")
                .runId("run_id")
                .addToolOutput(RunSubmitToolOutputsParams.ToolOutput.builder().build())
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.toolOutputs())
            .isEqualTo(listOf(RunSubmitToolOutputsParams.ToolOutput.builder().build()))
    }

    @Test
    fun getPathParam() {
        val params =
            RunSubmitToolOutputsParams.builder()
                .threadId("thread_id")
                .runId("run_id")
                .addToolOutput(RunSubmitToolOutputsParams.ToolOutput.builder().build())
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
