// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.evals.EvalCreateParams
import com.openai.models.evals.EvalDeleteParams
import com.openai.models.evals.EvalRetrieveParams
import com.openai.models.evals.EvalUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class EvalServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val evalService = client.evals()

        val eval =
            evalService.create(
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
                    .build()
            )

        eval.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val evalService = client.evals()

        val eval = evalService.retrieve(EvalRetrieveParams.builder().evalId("eval_id").build())

        eval.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val evalService = client.evals()

        val eval =
            evalService.update(
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

        eval.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val evalService = client.evals()

        val page = evalService.list()

        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val evalService = client.evals()

        val eval = evalService.delete(EvalDeleteParams.builder().evalId("eval_id").build())

        eval.validate()
    }
}
