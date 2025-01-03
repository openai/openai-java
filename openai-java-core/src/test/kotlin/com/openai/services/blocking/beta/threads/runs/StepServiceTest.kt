// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta.threads.runs

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.BetaThreadRunStepListParams
import com.openai.models.BetaThreadRunStepRetrieveParams
import com.openai.models.RunStepInclude
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class StepServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val stepService = client.beta().threads().runs().steps()
        val runStep =
            stepService.retrieve(
                BetaThreadRunStepRetrieveParams.builder()
                    .threadId("thread_id")
                    .runId("run_id")
                    .stepId("step_id")
                    .include(
                        listOf(RunStepInclude.STEP_DETAILS_TOOL_CALLS_FILE_SEARCH_RESULTS_CONTENT)
                    )
                    .build()
            )
        println(runStep)
        runStep.validate()
    }

    @Test
    fun callList() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val stepService = client.beta().threads().runs().steps()
        val listRunStepsResponse =
            stepService.list(
                BetaThreadRunStepListParams.builder().threadId("thread_id").runId("run_id").build()
            )
        println(listRunStepsResponse)
        listRunStepsResponse.data().forEach { it.validate() }
    }
}
