// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.JsonValue
import com.openai.models.evals.EvalCreateParams
import com.openai.models.evals.EvalDeleteParams
import com.openai.models.evals.EvalRetrieveParams
import com.openai.models.evals.EvalUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class EvalServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val evalServiceAsync = client.evals()

        val evalFuture =
            evalServiceAsync.create(
                EvalCreateParams.builder()
                    .dataSourceConfig(
                        EvalCreateParams.DataSourceConfig.Custom.builder()
                            .itemSchema(
                                EvalCreateParams.DataSourceConfig.Custom.ItemSchema.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .includeSampleSchema(true)
                            .build()
                    )
                    .addTestingCriterion(
                        EvalCreateParams.TestingCriterion.LabelModel.builder()
                            .addInput(
                                EvalCreateParams.TestingCriterion.LabelModel.Input
                                    .SimpleInputMessage
                                    .builder()
                                    .content("content")
                                    .role("role")
                                    .build()
                            )
                            .addLabel("string")
                            .model("model")
                            .name("name")
                            .addPassingLabel("string")
                            .build()
                    )
                    .metadata(
                        EvalCreateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .name("name")
                    .shareWithOpenAI(true)
                    .build()
            )

        val eval = evalFuture.get()
        eval.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val evalServiceAsync = client.evals()

        val evalFuture =
            evalServiceAsync.retrieve(EvalRetrieveParams.builder().evalId("eval_id").build())

        val eval = evalFuture.get()
        eval.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val evalServiceAsync = client.evals()

        val evalFuture =
            evalServiceAsync.update(
                EvalUpdateParams.builder()
                    .evalId("eval_id")
                    .metadata(
                        EvalUpdateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .name("name")
                    .build()
            )

        val eval = evalFuture.get()
        eval.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val evalServiceAsync = client.evals()

        val pageFuture = evalServiceAsync.list()

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
        val evalServiceAsync = client.evals()

        val evalFuture =
            evalServiceAsync.delete(EvalDeleteParams.builder().evalId("eval_id").build())

        val eval = evalFuture.get()
        eval.validate()
    }
}
