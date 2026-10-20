// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.decisions.DecisionCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class DecisionServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val decisionServiceAsync = client.decisions()

        val decisionFuture =
            decisionServiceAsync.create(
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

        val decision = decisionFuture.get()
        decision.validate()
    }
}
