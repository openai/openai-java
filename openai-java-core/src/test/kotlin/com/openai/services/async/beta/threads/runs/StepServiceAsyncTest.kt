// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.threads.runs

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.findAll
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.reset
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.beta.threads.runs.steps.RunStepInclude
import com.openai.models.beta.threads.runs.steps.StepListParams
import com.openai.models.beta.threads.runs.steps.StepRetrieveParams
import java.util.concurrent.atomic.AtomicInteger
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.parallel.ResourceLock

@ExtendWith(TestServerExtension::class)
@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class StepServiceAsyncTest {

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val stepServiceAsync = client.beta().threads().runs().steps()

        val runStepFuture =
            stepServiceAsync.retrieve(
                StepRetrieveParams.builder()
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
    fun listStopsOnExplicitFalse(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        try {
            // A terminal page can still contain items and a cursor
            stubFor(
                get(anyUrl())
                    .willReturn(okJson("{\"data\":[{\"id\":\"item_1\"}],\"has_more\":false}"))
            )
            val page =
                client
                    .beta()
                    .threads()
                    .runs()
                    .steps()
                    .list(StepListParams.builder().threadId("thread_id").runId("run_id").build())
                    .get()
            assertThat(page.items()).hasSize(1)
            assertThat(page.hasNextPage()).isFalse()

            val count = AtomicInteger()
            page.autoPager().subscribe { count.incrementAndGet() }.onCompleteFuture().get()
            assertThat(count.get()).isEqualTo(1)

            assertThat(findAll(getRequestedFor(anyUrl()))).hasSize(1)
        } finally {
            client.close()
        }
    }

    @Test
    fun listContinuesUntilExplicitFalse(wmRuntimeInfo: WireMockRuntimeInfo) {
        // Both explicit true and a missing flag preserve normal cursor traversal.
        for (firstResponse in
            listOf(
                "{\"data\":[{\"id\":\"item_1\"}],\"has_more\":true}",
                "{\"data\":[{\"id\":\"item_1\"}]}",
            )) {
            reset()
            val client =
                OpenAIOkHttpClientAsync.builder()
                    .baseUrl(wmRuntimeInfo.httpBaseUrl)
                    .apiKey("My API Key")
                    .adminApiKey("My Admin API Key")
                    .build()
            try {
                stubFor(
                    get(anyUrl())
                        .inScenario("pagination")
                        .whenScenarioStateIs("Started")
                        .willReturn(okJson(firstResponse))
                        .willSetStateTo("terminal")
                )
                stubFor(
                    get(anyUrl())
                        .inScenario("pagination")
                        .whenScenarioStateIs("terminal")
                        .willReturn(okJson("{\"data\":[{\"id\":\"item_1\"}],\"has_more\":false}"))
                        .willSetStateTo("unexpected")
                )
                // Bound a regression to one extra request instead of an infinite loop.
                stubFor(
                    get(anyUrl())
                        .inScenario("pagination")
                        .whenScenarioStateIs("unexpected")
                        .willReturn(okJson("{}"))
                )
                val page =
                    client
                        .beta()
                        .threads()
                        .runs()
                        .steps()
                        .list(
                            StepListParams.builder().threadId("thread_id").runId("run_id").build()
                        )
                        .get()
                assertThat(page.hasNextPage()).isTrue()

                val count = AtomicInteger()
                page.autoPager().subscribe { count.incrementAndGet() }.onCompleteFuture().get()
                assertThat(count.get()).isEqualTo(2)

                assertThat(findAll(getRequestedFor(anyUrl()))).hasSize(2)
            } finally {
                client.close()
            }
        }
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val stepServiceAsync = client.beta().threads().runs().steps()

        val pageFuture =
            stepServiceAsync.list(
                StepListParams.builder().threadId("thread_id").runId("run_id").build()
            )

        val page = pageFuture.get()
        page.response().validate()
    }
}
