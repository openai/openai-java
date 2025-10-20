// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses.inputtokens

import com.openai.core.JsonValue
import com.openai.models.Reasoning
import com.openai.models.ReasoningEffort
import com.openai.models.ResponseFormatText
import com.openai.models.responses.FunctionTool
import com.openai.models.responses.Tool
import com.openai.models.responses.ToolChoiceOptions
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InputTokenCountParamsTest {

    @Test
    fun create() {
        InputTokenCountParams.builder()
            .conversation("string")
            .input("string")
            .instructions("instructions")
            .model("model")
            .parallelToolCalls(true)
            .previousResponseId("resp_123")
            .reasoning(
                Reasoning.builder()
                    .effort(ReasoningEffort.MINIMAL)
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
    }

    @Test
    fun body() {
        val params =
            InputTokenCountParams.builder()
                .conversation("string")
                .input("string")
                .instructions("instructions")
                .model("model")
                .parallelToolCalls(true)
                .previousResponseId("resp_123")
                .reasoning(
                    Reasoning.builder()
                        .effort(ReasoningEffort.MINIMAL)
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

        val body = params._body()

        assertThat(body.conversation()).contains(InputTokenCountParams.Conversation.ofId("string"))
        assertThat(body.input()).contains(InputTokenCountParams.Input.ofString("string"))
        assertThat(body.instructions()).contains("instructions")
        assertThat(body.model()).contains("model")
        assertThat(body.parallelToolCalls()).contains(true)
        assertThat(body.previousResponseId()).contains("resp_123")
        assertThat(body.reasoning())
            .contains(
                Reasoning.builder()
                    .effort(ReasoningEffort.MINIMAL)
                    .generateSummary(Reasoning.GenerateSummary.AUTO)
                    .summary(Reasoning.Summary.AUTO)
                    .build()
            )
        assertThat(body.text())
            .contains(
                InputTokenCountParams.Text.builder()
                    .format(ResponseFormatText.builder().build())
                    .verbosity(InputTokenCountParams.Text.Verbosity.LOW)
                    .build()
            )
        assertThat(body.toolChoice())
            .contains(InputTokenCountParams.ToolChoice.ofOptions(ToolChoiceOptions.NONE))
        assertThat(body.tools().getOrNull())
            .containsExactly(
                Tool.ofFunction(
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
            )
        assertThat(body.truncation()).contains(InputTokenCountParams.Truncation.AUTO)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = InputTokenCountParams.builder().build()

        val body = params._body()
    }
}
