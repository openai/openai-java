// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta.responses

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.JsonValue
import com.openai.models.beta.responses.BetaFunctionTool
import com.openai.models.beta.responses.BetaToolChoiceOptions
import com.openai.models.beta.responses.inputtokens.InputTokenCountParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class InputTokenServiceAsyncTest {

    @Test
    fun count() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val inputTokenServiceAsync = client.beta().responses().inputTokens()

        val responseFuture =
            inputTokenServiceAsync.count(
                InputTokenCountParams.builder()
                    .addBeta(InputTokenCountParams.Beta.RESPONSES_MULTI_AGENT_V1)
                    .conversation("string")
                    .input("string")
                    .instructions("instructions")
                    .model("model")
                    .parallelToolCalls(true)
                    .personality(InputTokenCountParams.Personality.FRIENDLY)
                    .previousResponseId("resp_123")
                    .reasoning(
                        InputTokenCountParams.Reasoning.builder()
                            .context(InputTokenCountParams.Reasoning.Context.AUTO)
                            .effort(InputTokenCountParams.Reasoning.Effort.NONE)
                            .generateSummary(InputTokenCountParams.Reasoning.GenerateSummary.AUTO)
                            .mode(InputTokenCountParams.Reasoning.Mode.STANDARD)
                            .summary(InputTokenCountParams.Reasoning.Summary.AUTO)
                            .build()
                    )
                    .text(
                        InputTokenCountParams.Text.builder()
                            .formatText()
                            .verbosity(InputTokenCountParams.Text.Verbosity.LOW)
                            .build()
                    )
                    .toolChoice(BetaToolChoiceOptions.NONE)
                    .addTool(
                        BetaFunctionTool.builder()
                            .name("name")
                            .parameters(
                                BetaFunctionTool.Parameters.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .strict(true)
                            .addAllowedCaller(BetaFunctionTool.AllowedCaller.DIRECT)
                            .deferLoading(true)
                            .description("description")
                            .outputSchema(
                                BetaFunctionTool.OutputSchema.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .build()
                    )
                    .truncation(InputTokenCountParams.Truncation.AUTO)
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
