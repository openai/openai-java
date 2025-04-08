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
                                    .putAdditionalProperty("0", JsonValue.from("bar"))
                                    .putAdditionalProperty("1", JsonValue.from("bar"))
                                    .putAdditionalProperty("2", JsonValue.from("bar"))
                                    .putAdditionalProperty("3", JsonValue.from("bar"))
                                    .putAdditionalProperty("4", JsonValue.from("bar"))
                                    .putAdditionalProperty("5", JsonValue.from("bar"))
                                    .putAdditionalProperty("6", JsonValue.from("bar"))
                                    .putAdditionalProperty("7", JsonValue.from("bar"))
                                    .putAdditionalProperty("8", JsonValue.from("bar"))
                                    .putAdditionalProperty("9", JsonValue.from("bar"))
                                    .putAdditionalProperty("10", JsonValue.from("bar"))
                                    .putAdditionalProperty("11", JsonValue.from("bar"))
                                    .putAdditionalProperty("12", JsonValue.from("bar"))
                                    .putAdditionalProperty("13", JsonValue.from("bar"))
                                    .putAdditionalProperty("14", JsonValue.from("bar"))
                                    .putAdditionalProperty("15", JsonValue.from("bar"))
                                    .putAdditionalProperty("16", JsonValue.from("bar"))
                                    .putAdditionalProperty("17", JsonValue.from("bar"))
                                    .putAdditionalProperty("18", JsonValue.from("bar"))
                                    .putAdditionalProperty("19", JsonValue.from("bar"))
                                    .putAdditionalProperty("20", JsonValue.from("bar"))
                                    .putAdditionalProperty("21", JsonValue.from("bar"))
                                    .putAdditionalProperty("22", JsonValue.from("bar"))
                                    .putAdditionalProperty("23", JsonValue.from("bar"))
                                    .putAdditionalProperty("24", JsonValue.from("bar"))
                                    .putAdditionalProperty("25", JsonValue.from("bar"))
                                    .putAdditionalProperty("26", JsonValue.from("bar"))
                                    .putAdditionalProperty("27", JsonValue.from("bar"))
                                    .putAdditionalProperty("28", JsonValue.from("bar"))
                                    .putAdditionalProperty("29", JsonValue.from("bar"))
                                    .putAdditionalProperty("30", JsonValue.from("bar"))
                                    .putAdditionalProperty("31", JsonValue.from("bar"))
                                    .putAdditionalProperty("32", JsonValue.from("bar"))
                                    .putAdditionalProperty("33", JsonValue.from("bar"))
                                    .putAdditionalProperty("34", JsonValue.from("bar"))
                                    .putAdditionalProperty("35", JsonValue.from("bar"))
                                    .putAdditionalProperty("36", JsonValue.from("bar"))
                                    .putAdditionalProperty("37", JsonValue.from("bar"))
                                    .putAdditionalProperty("38", JsonValue.from("bar"))
                                    .putAdditionalProperty("39", JsonValue.from("bar"))
                                    .putAdditionalProperty("40", JsonValue.from("bar"))
                                    .putAdditionalProperty("41", JsonValue.from("bar"))
                                    .putAdditionalProperty("42", JsonValue.from("bar"))
                                    .putAdditionalProperty("43", JsonValue.from("bar"))
                                    .putAdditionalProperty("44", JsonValue.from("bar"))
                                    .putAdditionalProperty("45", JsonValue.from("bar"))
                                    .putAdditionalProperty("46", JsonValue.from("bar"))
                                    .putAdditionalProperty("47", JsonValue.from("bar"))
                                    .putAdditionalProperty("48", JsonValue.from("bar"))
                                    .putAdditionalProperty("49", JsonValue.from("bar"))
                                    .putAdditionalProperty("50", JsonValue.from("bar"))
                                    .putAdditionalProperty("51", JsonValue.from("bar"))
                                    .putAdditionalProperty("52", JsonValue.from("bar"))
                                    .putAdditionalProperty("53", JsonValue.from("bar"))
                                    .putAdditionalProperty("54", JsonValue.from("bar"))
                                    .putAdditionalProperty("55", JsonValue.from("bar"))
                                    .putAdditionalProperty("56", JsonValue.from("bar"))
                                    .putAdditionalProperty("57", JsonValue.from("bar"))
                                    .putAdditionalProperty("58", JsonValue.from("bar"))
                                    .putAdditionalProperty("59", JsonValue.from("bar"))
                                    .putAdditionalProperty("60", JsonValue.from("bar"))
                                    .putAdditionalProperty("61", JsonValue.from("bar"))
                                    .putAdditionalProperty("62", JsonValue.from("bar"))
                                    .putAdditionalProperty("63", JsonValue.from("bar"))
                                    .putAdditionalProperty("64", JsonValue.from("bar"))
                                    .putAdditionalProperty("65", JsonValue.from("bar"))
                                    .putAdditionalProperty("66", JsonValue.from("bar"))
                                    .putAdditionalProperty("67", JsonValue.from("bar"))
                                    .putAdditionalProperty("68", JsonValue.from("bar"))
                                    .putAdditionalProperty("69", JsonValue.from("bar"))
                                    .putAdditionalProperty("70", JsonValue.from("bar"))
                                    .putAdditionalProperty("71", JsonValue.from("bar"))
                                    .putAdditionalProperty("72", JsonValue.from("bar"))
                                    .putAdditionalProperty("73", JsonValue.from("bar"))
                                    .putAdditionalProperty("74", JsonValue.from("bar"))
                                    .putAdditionalProperty("75", JsonValue.from("bar"))
                                    .putAdditionalProperty("76", JsonValue.from("bar"))
                                    .putAdditionalProperty("77", JsonValue.from("bar"))
                                    .putAdditionalProperty("78", JsonValue.from("bar"))
                                    .putAdditionalProperty("79", JsonValue.from("bar"))
                                    .putAdditionalProperty("80", JsonValue.from("bar"))
                                    .putAdditionalProperty("81", JsonValue.from("bar"))
                                    .putAdditionalProperty("82", JsonValue.from("bar"))
                                    .putAdditionalProperty("83", JsonValue.from("bar"))
                                    .putAdditionalProperty("84", JsonValue.from("bar"))
                                    .putAdditionalProperty("85", JsonValue.from("bar"))
                                    .putAdditionalProperty("86", JsonValue.from("bar"))
                                    .putAdditionalProperty("87", JsonValue.from("bar"))
                                    .putAdditionalProperty("88", JsonValue.from("bar"))
                                    .putAdditionalProperty("89", JsonValue.from("bar"))
                                    .putAdditionalProperty("90", JsonValue.from("bar"))
                                    .putAdditionalProperty("91", JsonValue.from("bar"))
                                    .putAdditionalProperty("92", JsonValue.from("bar"))
                                    .putAdditionalProperty("93", JsonValue.from("bar"))
                                    .putAdditionalProperty("94", JsonValue.from("bar"))
                                    .putAdditionalProperty("95", JsonValue.from("bar"))
                                    .putAdditionalProperty("96", JsonValue.from("bar"))
                                    .putAdditionalProperty("97", JsonValue.from("bar"))
                                    .putAdditionalProperty("98", JsonValue.from("bar"))
                                    .putAdditionalProperty("99", JsonValue.from("bar"))
                                    .putAdditionalProperty("100", JsonValue.from("bar"))
                                    .putAdditionalProperty("101", JsonValue.from("bar"))
                                    .putAdditionalProperty("102", JsonValue.from("bar"))
                                    .putAdditionalProperty("103", JsonValue.from("bar"))
                                    .putAdditionalProperty("104", JsonValue.from("bar"))
                                    .putAdditionalProperty("105", JsonValue.from("bar"))
                                    .putAdditionalProperty("106", JsonValue.from("bar"))
                                    .putAdditionalProperty("107", JsonValue.from("bar"))
                                    .putAdditionalProperty("108", JsonValue.from("bar"))
                                    .putAdditionalProperty("109", JsonValue.from("bar"))
                                    .putAdditionalProperty("110", JsonValue.from("bar"))
                                    .putAdditionalProperty("111", JsonValue.from("bar"))
                                    .putAdditionalProperty("112", JsonValue.from("bar"))
                                    .putAdditionalProperty("113", JsonValue.from("bar"))
                                    .putAdditionalProperty("114", JsonValue.from("bar"))
                                    .putAdditionalProperty("115", JsonValue.from("bar"))
                                    .putAdditionalProperty("116", JsonValue.from("bar"))
                                    .putAdditionalProperty("117", JsonValue.from("bar"))
                                    .putAdditionalProperty("118", JsonValue.from("bar"))
                                    .putAdditionalProperty("119", JsonValue.from("bar"))
                                    .putAdditionalProperty("120", JsonValue.from("bar"))
                                    .putAdditionalProperty("121", JsonValue.from("bar"))
                                    .putAdditionalProperty("122", JsonValue.from("bar"))
                                    .putAdditionalProperty("123", JsonValue.from("bar"))
                                    .putAdditionalProperty("124", JsonValue.from("bar"))
                                    .putAdditionalProperty("125", JsonValue.from("bar"))
                                    .putAdditionalProperty("126", JsonValue.from("bar"))
                                    .putAdditionalProperty("127", JsonValue.from("bar"))
                                    .putAdditionalProperty("128", JsonValue.from("bar"))
                                    .putAdditionalProperty("129", JsonValue.from("bar"))
                                    .putAdditionalProperty("130", JsonValue.from("bar"))
                                    .putAdditionalProperty("131", JsonValue.from("bar"))
                                    .putAdditionalProperty("132", JsonValue.from("bar"))
                                    .putAdditionalProperty("133", JsonValue.from("bar"))
                                    .putAdditionalProperty("134", JsonValue.from("bar"))
                                    .putAdditionalProperty("135", JsonValue.from("bar"))
                                    .putAdditionalProperty("136", JsonValue.from("bar"))
                                    .putAdditionalProperty("137", JsonValue.from("bar"))
                                    .putAdditionalProperty("138", JsonValue.from("bar"))
                                    .putAdditionalProperty("139", JsonValue.from("bar"))
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
