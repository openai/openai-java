// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.evals

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.evals.runs.CreateEvalJsonlRunDataSource
import com.openai.models.evals.runs.EvalJsonlFileContentSource
import com.openai.models.evals.runs.RunCancelParams
import com.openai.models.evals.runs.RunCreateParams
import com.openai.models.evals.runs.RunDeleteParams
import com.openai.models.evals.runs.RunRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class RunServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val runService = client.evals().runs()

        val run =
            runService.create(
                RunCreateParams.builder()
                    .evalId("eval_id")
                    .dataSource(
                        CreateEvalJsonlRunDataSource.builder()
                            .fileContentSource(
                                listOf(
                                    EvalJsonlFileContentSource.Content.builder()
                                        .item(
                                            EvalJsonlFileContentSource.Content.Item.builder()
                                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                                .build()
                                        )
                                        .sample(
                                            EvalJsonlFileContentSource.Content.Sample.builder()
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

        run.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val runService = client.evals().runs()

        val run =
            runService.retrieve(
                RunRetrieveParams.builder().evalId("eval_id").runId("run_id").build()
            )

        run.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val runService = client.evals().runs()

        val page = runService.list("eval_id")

        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val runService = client.evals().runs()

        val run =
            runService.delete(RunDeleteParams.builder().evalId("eval_id").runId("run_id").build())

        run.validate()
    }

    @Test
    fun cancel() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val runService = client.evals().runs()

        val response =
            runService.cancel(RunCancelParams.builder().evalId("eval_id").runId("run_id").build())

        response.validate()
    }
}
