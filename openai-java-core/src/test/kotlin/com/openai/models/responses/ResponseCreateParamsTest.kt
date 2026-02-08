// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.openai.core.JsonValue
import com.openai.models.ChatModel
import com.openai.models.Reasoning
import com.openai.models.ReasoningEffort
import com.openai.models.ResponseFormatText
import com.openai.models.ResponsesModel
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCreateParamsTest {

    @Test
    fun create() {
        ResponseCreateParams.builder()
            .background(true)
            .addContextManagement(
                ResponseCreateParams.ContextManagement.builder()
                    .type("type")
                    .compactThreshold(1000L)
                    .build()
            )
            .conversation("string")
            .addInclude(ResponseIncludable.FILE_SEARCH_CALL_RESULTS)
            .input("string")
            .instructions("instructions")
            .maxOutputTokens(0L)
            .maxToolCalls(0L)
            .metadata(
                ResponseCreateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
            .model(ChatModel.GPT_5_1)
            .parallelToolCalls(true)
            .previousResponseId("previous_response_id")
            .prompt(
                ResponsePrompt.builder()
                    .id("id")
                    .variables(
                        ResponsePrompt.Variables.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .version("version")
                    .build()
            )
            .promptCacheKey("prompt-cache-key-1234")
            .promptCacheRetention(ResponseCreateParams.PromptCacheRetention.IN_MEMORY)
            .reasoning(
                Reasoning.builder()
                    .effort(ReasoningEffort.NONE)
                    .generateSummary(Reasoning.GenerateSummary.AUTO)
                    .summary(Reasoning.Summary.AUTO)
                    .build()
            )
            .safetyIdentifier("safety-identifier-1234")
            .serviceTier(ResponseCreateParams.ServiceTier.AUTO)
            .store(true)
            .streamOptions(
                ResponseCreateParams.StreamOptions.builder().includeObfuscation(true).build()
            )
            .temperature(1.0)
            .text(
                ResponseTextConfig.builder()
                    .format(ResponseFormatText.builder().build())
                    .verbosity(ResponseTextConfig.Verbosity.LOW)
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
            .topLogprobs(0L)
            .topP(1.0)
            .truncation(ResponseCreateParams.Truncation.AUTO)
            .user("user-1234")
            .build()
    }

    @Test
    fun body() {
        val params =
            ResponseCreateParams.builder()
                .background(true)
                .addContextManagement(
                    ResponseCreateParams.ContextManagement.builder()
                        .type("type")
                        .compactThreshold(1000L)
                        .build()
                )
                .conversation("string")
                .addInclude(ResponseIncludable.FILE_SEARCH_CALL_RESULTS)
                .input("string")
                .instructions("instructions")
                .maxOutputTokens(0L)
                .maxToolCalls(0L)
                .metadata(
                    ResponseCreateParams.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .model(ChatModel.GPT_5_1)
                .parallelToolCalls(true)
                .previousResponseId("previous_response_id")
                .prompt(
                    ResponsePrompt.builder()
                        .id("id")
                        .variables(
                            ResponsePrompt.Variables.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .version("version")
                        .build()
                )
                .promptCacheKey("prompt-cache-key-1234")
                .promptCacheRetention(ResponseCreateParams.PromptCacheRetention.IN_MEMORY)
                .reasoning(
                    Reasoning.builder()
                        .effort(ReasoningEffort.NONE)
                        .generateSummary(Reasoning.GenerateSummary.AUTO)
                        .summary(Reasoning.Summary.AUTO)
                        .build()
                )
                .safetyIdentifier("safety-identifier-1234")
                .serviceTier(ResponseCreateParams.ServiceTier.AUTO)
                .store(true)
                .streamOptions(
                    ResponseCreateParams.StreamOptions.builder().includeObfuscation(true).build()
                )
                .temperature(1.0)
                .text(
                    ResponseTextConfig.builder()
                        .format(ResponseFormatText.builder().build())
                        .verbosity(ResponseTextConfig.Verbosity.LOW)
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
                .topLogprobs(0L)
                .topP(1.0)
                .truncation(ResponseCreateParams.Truncation.AUTO)
                .user("user-1234")
                .build()

        val body = params._body()

        assertThat(body.background()).contains(true)
        assertThat(body.contextManagement().getOrNull())
            .containsExactly(
                ResponseCreateParams.ContextManagement.builder()
                    .type("type")
                    .compactThreshold(1000L)
                    .build()
            )
        assertThat(body.conversation()).contains(ResponseCreateParams.Conversation.ofId("string"))
        assertThat(body.include().getOrNull())
            .containsExactly(ResponseIncludable.FILE_SEARCH_CALL_RESULTS)
        assertThat(body.input()).contains(ResponseCreateParams.Input.ofText("string"))
        assertThat(body.instructions()).contains("instructions")
        assertThat(body.maxOutputTokens()).contains(0L)
        assertThat(body.maxToolCalls()).contains(0L)
        assertThat(body.metadata())
            .contains(
                ResponseCreateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(body.model()).contains(ResponsesModel.ofChat(ChatModel.GPT_5_1))
        assertThat(body.parallelToolCalls()).contains(true)
        assertThat(body.previousResponseId()).contains("previous_response_id")
        assertThat(body.prompt())
            .contains(
                ResponsePrompt.builder()
                    .id("id")
                    .variables(
                        ResponsePrompt.Variables.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .version("version")
                    .build()
            )
        assertThat(body.promptCacheKey()).contains("prompt-cache-key-1234")
        assertThat(body.promptCacheRetention())
            .contains(ResponseCreateParams.PromptCacheRetention.IN_MEMORY)
        assertThat(body.reasoning())
            .contains(
                Reasoning.builder()
                    .effort(ReasoningEffort.NONE)
                    .generateSummary(Reasoning.GenerateSummary.AUTO)
                    .summary(Reasoning.Summary.AUTO)
                    .build()
            )
        assertThat(body.safetyIdentifier()).contains("safety-identifier-1234")
        assertThat(body.serviceTier()).contains(ResponseCreateParams.ServiceTier.AUTO)
        assertThat(body.store()).contains(true)
        assertThat(body.streamOptions())
            .contains(ResponseCreateParams.StreamOptions.builder().includeObfuscation(true).build())
        assertThat(body.temperature()).contains(1.0)
        assertThat(body.text())
            .contains(
                ResponseTextConfig.builder()
                    .format(ResponseFormatText.builder().build())
                    .verbosity(ResponseTextConfig.Verbosity.LOW)
                    .build()
            )
        assertThat(body.toolChoice())
            .contains(ResponseCreateParams.ToolChoice.ofOptions(ToolChoiceOptions.NONE))
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
        assertThat(body.topLogprobs()).contains(0L)
        assertThat(body.topP()).contains(1.0)
        assertThat(body.truncation()).contains(ResponseCreateParams.Truncation.AUTO)
        assertThat(body.user()).contains("user-1234")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ResponseCreateParams.builder().build()

        val body = params._body()
    }
}
