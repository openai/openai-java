// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.openai.core.JsonValue
import com.openai.core.http.Headers
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCreateParamsTest {

    @Test
    fun create() {
        ResponseCreateParams.builder()
            .addBeta(ResponseCreateParams.Beta.RESPONSES_MULTI_AGENT_V1)
            .background(true)
            .addContextManagement(
                ResponseCreateParams.ContextManagement.builder()
                    .type("type")
                    .compactThreshold(1000L)
                    .build()
            )
            .conversation("string")
            .addInclude(BetaResponseIncludable.FILE_SEARCH_CALL_RESULTS)
            .input("string")
            .instructions("instructions")
            .maxOutputTokens(16L)
            .maxToolCalls(0L)
            .metadata(
                ResponseCreateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
            .model(ResponseCreateParams.Model.GPT_5_1)
            .moderation(
                ResponseCreateParams.Moderation.builder()
                    .model("model")
                    .policy(
                        ResponseCreateParams.Moderation.Policy.builder()
                            .input(
                                ResponseCreateParams.Moderation.Policy.Input.builder()
                                    .mode(ResponseCreateParams.Moderation.Policy.Input.Mode.SCORE)
                                    .build()
                            )
                            .output(
                                ResponseCreateParams.Moderation.Policy.Output.builder()
                                    .mode(ResponseCreateParams.Moderation.Policy.Output.Mode.SCORE)
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
            .multiAgent(
                ResponseCreateParams.MultiAgent.builder()
                    .enabled(true)
                    .maxConcurrentSubagents(1L)
                    .build()
            )
            .parallelToolCalls(true)
            .previousResponseId("previous_response_id")
            .prompt(
                BetaResponsePrompt.builder()
                    .id("id")
                    .variables(
                        BetaResponsePrompt.Variables.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .version("version")
                    .build()
            )
            .promptCacheKey("prompt-cache-key-1234")
            .promptCacheOptions(
                ResponseCreateParams.PromptCacheOptions.builder()
                    .mode(ResponseCreateParams.PromptCacheOptions.Mode.IMPLICIT)
                    .ttl(ResponseCreateParams.PromptCacheOptions.Ttl._30M)
                    .build()
            )
            .promptCacheRetention(ResponseCreateParams.PromptCacheRetention.IN_MEMORY)
            .reasoning(
                ResponseCreateParams.Reasoning.builder()
                    .context(ResponseCreateParams.Reasoning.Context.AUTO)
                    .effort(ResponseCreateParams.Reasoning.Effort.NONE)
                    .generateSummary(ResponseCreateParams.Reasoning.GenerateSummary.AUTO)
                    .mode(ResponseCreateParams.Reasoning.Mode.STANDARD)
                    .summary(ResponseCreateParams.Reasoning.Summary.AUTO)
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
                BetaResponseTextConfig.builder()
                    .formatText()
                    .verbosity(BetaResponseTextConfig.Verbosity.LOW)
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
            .topLogprobs(0L)
            .topP(1.0)
            .truncation(ResponseCreateParams.Truncation.AUTO)
            .user("user-1234")
            .build()
    }

    @Test
    fun headers() {
        val params =
            ResponseCreateParams.builder()
                .addBeta(ResponseCreateParams.Beta.RESPONSES_MULTI_AGENT_V1)
                .background(true)
                .addContextManagement(
                    ResponseCreateParams.ContextManagement.builder()
                        .type("type")
                        .compactThreshold(1000L)
                        .build()
                )
                .conversation("string")
                .addInclude(BetaResponseIncludable.FILE_SEARCH_CALL_RESULTS)
                .input("string")
                .instructions("instructions")
                .maxOutputTokens(16L)
                .maxToolCalls(0L)
                .metadata(
                    ResponseCreateParams.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .model(ResponseCreateParams.Model.GPT_5_1)
                .moderation(
                    ResponseCreateParams.Moderation.builder()
                        .model("model")
                        .policy(
                            ResponseCreateParams.Moderation.Policy.builder()
                                .input(
                                    ResponseCreateParams.Moderation.Policy.Input.builder()
                                        .mode(
                                            ResponseCreateParams.Moderation.Policy.Input.Mode.SCORE
                                        )
                                        .build()
                                )
                                .output(
                                    ResponseCreateParams.Moderation.Policy.Output.builder()
                                        .mode(
                                            ResponseCreateParams.Moderation.Policy.Output.Mode.SCORE
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .multiAgent(
                    ResponseCreateParams.MultiAgent.builder()
                        .enabled(true)
                        .maxConcurrentSubagents(1L)
                        .build()
                )
                .parallelToolCalls(true)
                .previousResponseId("previous_response_id")
                .prompt(
                    BetaResponsePrompt.builder()
                        .id("id")
                        .variables(
                            BetaResponsePrompt.Variables.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .version("version")
                        .build()
                )
                .promptCacheKey("prompt-cache-key-1234")
                .promptCacheOptions(
                    ResponseCreateParams.PromptCacheOptions.builder()
                        .mode(ResponseCreateParams.PromptCacheOptions.Mode.IMPLICIT)
                        .ttl(ResponseCreateParams.PromptCacheOptions.Ttl._30M)
                        .build()
                )
                .promptCacheRetention(ResponseCreateParams.PromptCacheRetention.IN_MEMORY)
                .reasoning(
                    ResponseCreateParams.Reasoning.builder()
                        .context(ResponseCreateParams.Reasoning.Context.AUTO)
                        .effort(ResponseCreateParams.Reasoning.Effort.NONE)
                        .generateSummary(ResponseCreateParams.Reasoning.GenerateSummary.AUTO)
                        .mode(ResponseCreateParams.Reasoning.Mode.STANDARD)
                        .summary(ResponseCreateParams.Reasoning.Summary.AUTO)
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
                    BetaResponseTextConfig.builder()
                        .formatText()
                        .verbosity(BetaResponseTextConfig.Verbosity.LOW)
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
                .topLogprobs(0L)
                .topP(1.0)
                .truncation(ResponseCreateParams.Truncation.AUTO)
                .user("user-1234")
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("openai-beta", "responses_multi_agent=v1").build())
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params = ResponseCreateParams.builder().build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            ResponseCreateParams.builder()
                .addBeta(ResponseCreateParams.Beta.RESPONSES_MULTI_AGENT_V1)
                .background(true)
                .addContextManagement(
                    ResponseCreateParams.ContextManagement.builder()
                        .type("type")
                        .compactThreshold(1000L)
                        .build()
                )
                .conversation("string")
                .addInclude(BetaResponseIncludable.FILE_SEARCH_CALL_RESULTS)
                .input("string")
                .instructions("instructions")
                .maxOutputTokens(16L)
                .maxToolCalls(0L)
                .metadata(
                    ResponseCreateParams.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .model(ResponseCreateParams.Model.GPT_5_1)
                .moderation(
                    ResponseCreateParams.Moderation.builder()
                        .model("model")
                        .policy(
                            ResponseCreateParams.Moderation.Policy.builder()
                                .input(
                                    ResponseCreateParams.Moderation.Policy.Input.builder()
                                        .mode(
                                            ResponseCreateParams.Moderation.Policy.Input.Mode.SCORE
                                        )
                                        .build()
                                )
                                .output(
                                    ResponseCreateParams.Moderation.Policy.Output.builder()
                                        .mode(
                                            ResponseCreateParams.Moderation.Policy.Output.Mode.SCORE
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .multiAgent(
                    ResponseCreateParams.MultiAgent.builder()
                        .enabled(true)
                        .maxConcurrentSubagents(1L)
                        .build()
                )
                .parallelToolCalls(true)
                .previousResponseId("previous_response_id")
                .prompt(
                    BetaResponsePrompt.builder()
                        .id("id")
                        .variables(
                            BetaResponsePrompt.Variables.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .version("version")
                        .build()
                )
                .promptCacheKey("prompt-cache-key-1234")
                .promptCacheOptions(
                    ResponseCreateParams.PromptCacheOptions.builder()
                        .mode(ResponseCreateParams.PromptCacheOptions.Mode.IMPLICIT)
                        .ttl(ResponseCreateParams.PromptCacheOptions.Ttl._30M)
                        .build()
                )
                .promptCacheRetention(ResponseCreateParams.PromptCacheRetention.IN_MEMORY)
                .reasoning(
                    ResponseCreateParams.Reasoning.builder()
                        .context(ResponseCreateParams.Reasoning.Context.AUTO)
                        .effort(ResponseCreateParams.Reasoning.Effort.NONE)
                        .generateSummary(ResponseCreateParams.Reasoning.GenerateSummary.AUTO)
                        .mode(ResponseCreateParams.Reasoning.Mode.STANDARD)
                        .summary(ResponseCreateParams.Reasoning.Summary.AUTO)
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
                    BetaResponseTextConfig.builder()
                        .formatText()
                        .verbosity(BetaResponseTextConfig.Verbosity.LOW)
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
            .containsExactly(BetaResponseIncludable.FILE_SEARCH_CALL_RESULTS)
        assertThat(body.input()).contains(ResponseCreateParams.Input.ofText("string"))
        assertThat(body.instructions()).contains("instructions")
        assertThat(body.maxOutputTokens()).contains(16L)
        assertThat(body.maxToolCalls()).contains(0L)
        assertThat(body.metadata())
            .contains(
                ResponseCreateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(body.model()).contains(ResponseCreateParams.Model.GPT_5_1)
        assertThat(body.moderation())
            .contains(
                ResponseCreateParams.Moderation.builder()
                    .model("model")
                    .policy(
                        ResponseCreateParams.Moderation.Policy.builder()
                            .input(
                                ResponseCreateParams.Moderation.Policy.Input.builder()
                                    .mode(ResponseCreateParams.Moderation.Policy.Input.Mode.SCORE)
                                    .build()
                            )
                            .output(
                                ResponseCreateParams.Moderation.Policy.Output.builder()
                                    .mode(ResponseCreateParams.Moderation.Policy.Output.Mode.SCORE)
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
        assertThat(body.multiAgent())
            .contains(
                ResponseCreateParams.MultiAgent.builder()
                    .enabled(true)
                    .maxConcurrentSubagents(1L)
                    .build()
            )
        assertThat(body.parallelToolCalls()).contains(true)
        assertThat(body.previousResponseId()).contains("previous_response_id")
        assertThat(body.prompt())
            .contains(
                BetaResponsePrompt.builder()
                    .id("id")
                    .variables(
                        BetaResponsePrompt.Variables.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .version("version")
                    .build()
            )
        assertThat(body.promptCacheKey()).contains("prompt-cache-key-1234")
        assertThat(body.promptCacheOptions())
            .contains(
                ResponseCreateParams.PromptCacheOptions.builder()
                    .mode(ResponseCreateParams.PromptCacheOptions.Mode.IMPLICIT)
                    .ttl(ResponseCreateParams.PromptCacheOptions.Ttl._30M)
                    .build()
            )
        assertThat(body.promptCacheRetention())
            .contains(ResponseCreateParams.PromptCacheRetention.IN_MEMORY)
        assertThat(body.reasoning())
            .contains(
                ResponseCreateParams.Reasoning.builder()
                    .context(ResponseCreateParams.Reasoning.Context.AUTO)
                    .effort(ResponseCreateParams.Reasoning.Effort.NONE)
                    .generateSummary(ResponseCreateParams.Reasoning.GenerateSummary.AUTO)
                    .mode(ResponseCreateParams.Reasoning.Mode.STANDARD)
                    .summary(ResponseCreateParams.Reasoning.Summary.AUTO)
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
                BetaResponseTextConfig.builder()
                    .formatText()
                    .verbosity(BetaResponseTextConfig.Verbosity.LOW)
                    .build()
            )
        assertThat(body.toolChoice())
            .contains(
                ResponseCreateParams.ToolChoice.ofBetaToolChoiceOptions(BetaToolChoiceOptions.NONE)
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
