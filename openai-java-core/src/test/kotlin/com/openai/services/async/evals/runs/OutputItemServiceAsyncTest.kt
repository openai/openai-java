// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.evals.runs

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.evals.runs.outputitems.OutputItemListParams
import com.openai.models.evals.runs.outputitems.OutputItemRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class OutputItemServiceAsyncTest {

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val outputItemServiceAsync = client.evals().runs().outputItems()

        val outputItemFuture =
            outputItemServiceAsync.retrieve(
                OutputItemRetrieveParams.builder()
                    .evalId("eval_id")
                    .runId("run_id")
                    .outputItemId("output_item_id")
                    .build()
            )

        val outputItem = outputItemFuture.get()
        outputItem.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val outputItemServiceAsync = client.evals().runs().outputItems()

        val pageFuture =
            outputItemServiceAsync.list(
                OutputItemListParams.builder().evalId("eval_id").runId("run_id").build()
            )

        val page = pageFuture.get()
        page.response().validate()
    }
}
