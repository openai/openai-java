// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.finetuning.alpha

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.finetuning.alpha.graders.GraderRunParams
import com.openai.models.finetuning.alpha.graders.GraderValidateParams
import com.openai.models.graders.gradermodels.StringCheckGrader
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class GraderServiceTest {

    @Test
    fun run() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val graderService = client.fineTuning().alpha().graders()

        val response =
            graderService.run(
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
                    .referenceAnswer("string")
                    .build()
            )

        response.validate()
    }

    @Test
    fun validate() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val graderService = client.fineTuning().alpha().graders()

        val response =
            graderService.validate(
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

        response.validate()
    }
}
