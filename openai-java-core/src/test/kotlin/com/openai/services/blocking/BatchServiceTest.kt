// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.BatchCancelParams
import com.openai.models.BatchCreateParams
import com.openai.models.BatchListParams
import com.openai.models.BatchRetrieveParams
import com.openai.models.Metadata
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class BatchServiceTest {

    @Test
    fun callCreate() {
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
                    .endpoint(BatchCreateParams.Endpoint.V1_CHAT_COMPLETIONS)
                    .inputFileId("input_file_id")
                    .metadata(
                        Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .build()
            )
        println(batch)
        batch.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchService = client.batches()
        val batch = batchService.retrieve(BatchRetrieveParams.builder().batchId("batch_id").build())
        println(batch)
        batch.validate()
    }

    @Test
    fun callList() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchService = client.batches()
        val listBatchesResponse = batchService.list(BatchListParams.builder().build())
        println(listBatchesResponse)
        listBatchesResponse.data().forEach { it.validate() }
    }

    @Test
    fun callCancel() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchService = client.batches()
        val batch = batchService.cancel(BatchCancelParams.builder().batchId("batch_id").build())
        println(batch)
        batch.validate()
    }
}
