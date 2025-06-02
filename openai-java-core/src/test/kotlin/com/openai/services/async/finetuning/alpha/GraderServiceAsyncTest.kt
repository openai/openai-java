// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.finetuning.alpha

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.JsonValue
import com.openai.models.finetuning.alpha.graders.GraderRunParams
import com.openai.models.finetuning.alpha.graders.GraderValidateParams
import com.openai.models.graders.gradermodels.StringCheckGrader
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class GraderServiceAsyncTest {

    @Test
    fun run() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val graderServiceAsync = client.fineTuning().alpha().graders()

        val responseFuture =
            graderServiceAsync.run(
                GraderRunParams.builder()
                    .grader(
                        StringCheckGrader.builder()
                            .input("input")
                            .name("name")
                            .operation(StringCheckGrader.Operation.EQ)
                            .reference("reference")
                            .build()
                    )
                    .modelSample("model_sample")
                    .item(JsonValue.from(mapOf<String, Any>()))
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Test
    fun validate() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val graderServiceAsync = client.fineTuning().alpha().graders()

        val responseFuture =
            graderServiceAsync.validate(
                GraderValidateParams.builder()
                    .grader(
                        StringCheckGrader.builder()
                            .input("input")
                            .name("name")
                            .operation(StringCheckGrader.Operation.EQ)
                            .reference("reference")
                            .build()
                    )
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
