// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.evals

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.JsonValue
import com.openai.models.evals.runs.CreateEvalJsonlRunDataSource
import com.openai.models.evals.runs.RunCancelParams
import com.openai.models.evals.runs.RunCreateParams
import com.openai.models.evals.runs.RunDeleteParams
import com.openai.models.evals.runs.RunListParams
import com.openai.models.evals.runs.RunRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class RunServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val runServiceAsync = client.evals().runs()

        val runFuture =
            runServiceAsync.create(
                RunCreateParams.builder()
                    .evalId("eval_id")
                    .dataSource(
                        CreateEvalJsonlRunDataSource.builder()
                            .fileContentSource(
                                listOf(
                                    CreateEvalJsonlRunDataSource.Source.FileContent.Content
                                        .builder()
                                        .item(
                                            CreateEvalJsonlRunDataSource.Source.FileContent.Content
                                                .Item
                                                .builder()
                                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                                .build()
                                        )
                                        .sample(
                                            CreateEvalJsonlRunDataSource.Source.FileContent.Content
                                                .Sample
                                                .builder()
                                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                                .build()
                                        )
                                        .build()
                                )
                            )
                            .build()
                    )
                    .metadata(
                        RunCreateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .name("name")
                    .build()
            )

        val run = runFuture.get()
        run.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val runServiceAsync = client.evals().runs()

        val runFuture =
            runServiceAsync.retrieve(
                RunRetrieveParams.builder().evalId("eval_id").runId("run_id").build()
            )

        val run = runFuture.get()
        run.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val runServiceAsync = client.evals().runs()

        val pageFuture = runServiceAsync.list(RunListParams.builder().evalId("eval_id").build())

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val runServiceAsync = client.evals().runs()

        val runFuture =
            runServiceAsync.delete(
                RunDeleteParams.builder().evalId("eval_id").runId("run_id").build()
            )

        val run = runFuture.get()
        run.validate()
    }

    @Test
    fun cancel() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val runServiceAsync = client.evals().runs()

        val responseFuture =
            runServiceAsync.cancel(
                RunCancelParams.builder().evalId("eval_id").runId("run_id").build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
