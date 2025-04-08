// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.evals.runs

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.evals.runs.outputitems.OutputItemListParams
import com.openai.models.evals.runs.outputitems.OutputItemRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class OutputItemServiceTest {

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val outputItemService = client.evals().runs().outputItems()

        val outputItem =
            outputItemService.retrieve(
                OutputItemRetrieveParams.builder()
                    .evalId("eval_id")
                    .runId("run_id")
                    .outputItemId("output_item_id")
                    .build()
            )

        outputItem.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val outputItemService = client.evals().runs().outputItems()

        val page =
            outputItemService.list(
                OutputItemListParams.builder().evalId("eval_id").runId("run_id").build()
            )

        page.response().validate()
    }
}
