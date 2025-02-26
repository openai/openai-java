// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta.threads.runs

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.BetaThreadRunStepListParams
import com.openai.models.BetaThreadRunStepRetrieveParams
import com.openai.models.RunStepInclude
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class StepServiceAsyncTest {

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val stepServiceAsync = client.beta().threads().runs().steps()

        val runStepFuture =
            stepServiceAsync.retrieve(
                BetaThreadRunStepRetrieveParams.builder()
                    .threadId("thread_id")
                    .runId("run_id")
                    .stepId("step_id")
                    .addInclude(RunStepInclude.STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT)
                    .build()
            )

        val runStep = runStepFuture.get()
        runStep.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val stepServiceAsync = client.beta().threads().runs().steps()

        val pageFuture =
            stepServiceAsync.list(
                BetaThreadRunStepListParams.builder().threadId("thread_id").runId("run_id").build()
            )

        val page = pageFuture.get()
        page.response().validate()
    }
}
