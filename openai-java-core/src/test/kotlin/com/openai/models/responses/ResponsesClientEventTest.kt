// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.ChatModel
import com.openai.models.Reasoning
import com.openai.models.ReasoningEffort
import com.openai.models.ResponseFormatText
import com.openai.models.ResponsesModel
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponsesClientEventTest {

    @Test
    fun create() {
        val responsesClientEvent =
            ResponsesClientEvent.builder()
                .background(true)
                .addContextManagement(
                    ResponsesClientEvent.ContextManagement.builder()
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
                    ResponsesClientEvent.Metadata.builder()
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
                .promptCacheRetention(ResponsesClientEvent.PromptCacheRetention.IN_MEMORY)
                .reasoning(
                    Reasoning.builder()
                        .effort(ReasoningEffort.NONE)
                        .generateSummary(Reasoning.GenerateSummary.AUTO)
                        .summary(Reasoning.Summary.AUTO)
                        .build()
                )
                .safetyIdentifier("safety-identifier-1234")
                .serviceTier(ResponsesClientEvent.ServiceTier.AUTO)
                .store(true)
                .stream(true)
                .streamOptions(
                    ResponsesClientEvent.StreamOptions.builder().includeObfuscation(true).build()
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
                .truncation(ResponsesClientEvent.Truncation.AUTO)
                .user("user-1234")
                .build()

        assertThat(responsesClientEvent.background()).contains(true)
        assertThat(responsesClientEvent.contextManagement().getOrNull())
            .containsExactly(
                ResponsesClientEvent.ContextManagement.builder()
                    .type("type")
                    .compactThreshold(1000L)
                    .build()
            )
        assertThat(responsesClientEvent.conversation())
            .contains(ResponsesClientEvent.Conversation.ofId("string"))
        assertThat(responsesClientEvent.include().getOrNull())
            .containsExactly(ResponseIncludable.FILE_SEARCH_CALL_RESULTS)
        assertThat(responsesClientEvent.input())
            .contains(ResponsesClientEvent.Input.ofText("string"))
        assertThat(responsesClientEvent.instructions()).contains("instructions")
        assertThat(responsesClientEvent.maxOutputTokens()).contains(0L)
        assertThat(responsesClientEvent.maxToolCalls()).contains(0L)
        assertThat(responsesClientEvent.metadata())
            .contains(
                ResponsesClientEvent.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(responsesClientEvent.model()).contains(ResponsesModel.ofChat(ChatModel.GPT_5_1))
        assertThat(responsesClientEvent.parallelToolCalls()).contains(true)
        assertThat(responsesClientEvent.previousResponseId()).contains("previous_response_id")
        assertThat(responsesClientEvent.prompt())
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
        assertThat(responsesClientEvent.promptCacheKey()).contains("prompt-cache-key-1234")
        assertThat(responsesClientEvent.promptCacheRetention())
            .contains(ResponsesClientEvent.PromptCacheRetention.IN_MEMORY)
        assertThat(responsesClientEvent.reasoning())
            .contains(
                Reasoning.builder()
                    .effort(ReasoningEffort.NONE)
                    .generateSummary(Reasoning.GenerateSummary.AUTO)
                    .summary(Reasoning.Summary.AUTO)
                    .build()
            )
        assertThat(responsesClientEvent.safetyIdentifier()).contains("safety-identifier-1234")
        assertThat(responsesClientEvent.serviceTier())
            .contains(ResponsesClientEvent.ServiceTier.AUTO)
        assertThat(responsesClientEvent.store()).contains(true)
        assertThat(responsesClientEvent.stream()).contains(true)
        assertThat(responsesClientEvent.streamOptions())
            .contains(ResponsesClientEvent.StreamOptions.builder().includeObfuscation(true).build())
        assertThat(responsesClientEvent.temperature()).contains(1.0)
        assertThat(responsesClientEvent.text())
            .contains(
                ResponseTextConfig.builder()
                    .format(ResponseFormatText.builder().build())
                    .verbosity(ResponseTextConfig.Verbosity.LOW)
                    .build()
            )
        assertThat(responsesClientEvent.toolChoice())
            .contains(ResponsesClientEvent.ToolChoice.ofOptions(ToolChoiceOptions.NONE))
        assertThat(responsesClientEvent.tools().getOrNull())
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
        assertThat(responsesClientEvent.topLogprobs()).contains(0L)
        assertThat(responsesClientEvent.topP()).contains(1.0)
        assertThat(responsesClientEvent.truncation()).contains(ResponsesClientEvent.Truncation.AUTO)
        assertThat(responsesClientEvent.user()).contains("user-1234")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responsesClientEvent =
            ResponsesClientEvent.builder()
                .background(true)
                .addContextManagement(
                    ResponsesClientEvent.ContextManagement.builder()
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
                    ResponsesClientEvent.Metadata.builder()
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
                .promptCacheRetention(ResponsesClientEvent.PromptCacheRetention.IN_MEMORY)
                .reasoning(
                    Reasoning.builder()
                        .effort(ReasoningEffort.NONE)
                        .generateSummary(Reasoning.GenerateSummary.AUTO)
                        .summary(Reasoning.Summary.AUTO)
                        .build()
                )
                .safetyIdentifier("safety-identifier-1234")
                .serviceTier(ResponsesClientEvent.ServiceTier.AUTO)
                .store(true)
                .stream(true)
                .streamOptions(
                    ResponsesClientEvent.StreamOptions.builder().includeObfuscation(true).build()
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
                .truncation(ResponsesClientEvent.Truncation.AUTO)
                .user("user-1234")
                .build()

        val roundtrippedResponsesClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesClientEvent),
                jacksonTypeRef<ResponsesClientEvent>(),
            )

        assertThat(roundtrippedResponsesClientEvent).isEqualTo(responsesClientEvent)
    }
}
