// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses.inputtokens

import com.openai.core.JsonValue
import com.openai.core.http.Headers
import com.openai.models.beta.responses.BetaFunctionTool
import com.openai.models.beta.responses.BetaTool
import com.openai.models.beta.responses.BetaToolChoiceOptions
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InputTokenCountParamsTest {

    @Test
    fun create() {
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
    }

    @Test
    fun headers() {
        val params =
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

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("openai-beta", "responses_multi_agent=v1").build())
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params = InputTokenCountParams.builder().build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
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

        val body = params._body()

        assertThat(body.conversation()).contains(InputTokenCountParams.Conversation.ofId("string"))
        assertThat(body.input()).contains(InputTokenCountParams.Input.ofString("string"))
        assertThat(body.instructions()).contains("instructions")
        assertThat(body.model()).contains("model")
        assertThat(body.parallelToolCalls()).contains(true)
        assertThat(body.personality()).contains(InputTokenCountParams.Personality.FRIENDLY)
        assertThat(body.previousResponseId()).contains("resp_123")
        assertThat(body.reasoning())
            .contains(
                InputTokenCountParams.Reasoning.builder()
                    .context(InputTokenCountParams.Reasoning.Context.AUTO)
                    .effort(InputTokenCountParams.Reasoning.Effort.NONE)
                    .generateSummary(InputTokenCountParams.Reasoning.GenerateSummary.AUTO)
                    .mode(InputTokenCountParams.Reasoning.Mode.STANDARD)
                    .summary(InputTokenCountParams.Reasoning.Summary.AUTO)
                    .build()
            )
        assertThat(body.text())
            .contains(
                InputTokenCountParams.Text.builder()
                    .formatText()
                    .verbosity(InputTokenCountParams.Text.Verbosity.LOW)
                    .build()
            )
        assertThat(body.toolChoice())
            .contains(
                InputTokenCountParams.ToolChoice.ofBetaToolChoiceOptions(BetaToolChoiceOptions.NONE)
            )
        assertThat(body.tools().getOrNull())
            .containsExactly(
                BetaTool.ofFunction(
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
            )
        assertThat(body.truncation()).contains(InputTokenCountParams.Truncation.AUTO)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = InputTokenCountParams.builder().build()

        val body = params._body()
    }
}
