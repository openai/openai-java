// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.decisions.DecisionCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class DecisionServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val decisionService = client.decisions()

        val decision =
            decisionService.create(
                DecisionCreateParams.builder()
                    .input("string")
                    .model("model")
                    .addQuestion(
                        DecisionCreateParams.Question.Predicate.builder()
                            .instructions("instructions")
                            .name("name")
                            .build()
                    )
                    .safetyIdentifier("safety_identifier")
                    .build()
            )

        decision.validate()
    }
}
