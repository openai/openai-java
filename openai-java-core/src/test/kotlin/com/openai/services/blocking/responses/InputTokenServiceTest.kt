// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.responses

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.Reasoning
import com.openai.models.ReasoningEffort
import com.openai.models.ResponseFormatText
import com.openai.models.responses.FunctionTool
import com.openai.models.responses.ToolChoiceOptions
import com.openai.models.responses.inputtokens.InputTokenCountParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class InputTokenServiceTest {

    @Test
    fun count() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inputTokenService = client.responses().inputTokens()

        val response =
            inputTokenService.count(
                InputTokenCountParams.builder()
                    .conversation("string")
                    .input("string")
                    .instructions("instructions")
                    .model("model")
                    .parallelToolCalls(true)
                    .previousResponseId("resp_123")
                    .reasoning(
                        Reasoning.builder()
                            .effort(ReasoningEffort.NONE)
                            .generateSummary(Reasoning.GenerateSummary.AUTO)
                            .summary(Reasoning.Summary.AUTO)
                            .build()
                    )
                    .text(
                        InputTokenCountParams.Text.builder()
                            .format(ResponseFormatText.builder().build())
                            .verbosity(InputTokenCountParams.Text.Verbosity.LOW)
                            .build()
                    )
                    .toolChoice(ToolChoiceOptions.NONE)
                    .addTool(
                        FunctionTool.builder()
                            .name("name")
                            .parameters(
                                FunctionTool.Parameters.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .strict(true)
                            .description("description")
                            .build()
                    )
                    .truncation(InputTokenCountParams.Truncation.AUTO)
                    .build()
            )

        response.validate()
    }
}
