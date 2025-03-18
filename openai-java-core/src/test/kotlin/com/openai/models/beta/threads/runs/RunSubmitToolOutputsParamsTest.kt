// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs

import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RunSubmitToolOutputsParamsTest {

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
    fun pathParams() {
        val params =
            RunSubmitToolOutputsParams.builder()
                .threadId("thread_id")
                .runId("run_id")
                .addToolOutput(RunSubmitToolOutputsParams.ToolOutput.builder().build())
                .build()

        assertThat(params._pathParam(0)).isEqualTo("thread_id")
        assertThat(params._pathParam(1)).isEqualTo("run_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
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
            .containsExactly(
                RunSubmitToolOutputsParams.ToolOutput.builder()
                    .output("output")
                    .toolCallId("tool_call_id")
                    .build()
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
            .containsExactly(RunSubmitToolOutputsParams.ToolOutput.builder().build())
    }
}
