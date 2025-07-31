// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta.threads.runs

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.beta.threads.runs.steps.RunStepInclude
import com.openai.models.beta.threads.runs.steps.StepListParams
import com.openai.models.beta.threads.runs.steps.StepRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class StepServiceTest {

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val stepService = client.beta().threads().runs().steps()

        val runStep =
            stepService.retrieve(
                StepRetrieveParams.builder()
                    .threadId("thread_id")
                    .runId("run_id")
                    .stepId("step_id")
                    .addInclude(RunStepInclude.STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT)
                    .build()
            )

        runStep.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val stepService = client.beta().threads().runs().steps()

        val page =
            stepService.list(StepListParams.builder().threadId("thread_id").runId("run_id").build())

        page.response().validate()
    }
}
