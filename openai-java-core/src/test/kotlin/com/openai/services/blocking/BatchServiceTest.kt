// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.batches.BatchCancelParams
import com.openai.models.batches.BatchCreateParams
import com.openai.models.batches.BatchRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class BatchServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchService = client.batches()

        val batch =
            batchService.create(
                BatchCreateParams.builder()
                    .completionWindow(BatchCreateParams.CompletionWindow._24H)
                    .endpoint(BatchCreateParams.Endpoint.V1_RESPONSES)
                    .inputFileId("input_file_id")
                    .metadata(
                        BatchCreateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .build()
            )

        batch.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchService = client.batches()

        val batch = batchService.retrieve(BatchRetrieveParams.builder().batchId("batch_id").build())

        batch.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchService = client.batches()

        val page = batchService.list()

        page.response().validate()
    }

    @Test
    fun cancel() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchService = client.batches()

        val batch = batchService.cancel(BatchCancelParams.builder().batchId("batch_id").build())

        batch.validate()
    }
}
