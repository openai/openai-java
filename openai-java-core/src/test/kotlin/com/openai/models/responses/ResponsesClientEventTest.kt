// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.ChatModel
import com.openai.models.Reasoning
import com.openai.models.ReasoningEffort
import com.openai.models.ResponseFormatText
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ResponsesClientEventTest {

    @Test
    fun ofResponseCreate() {
        val responseCreate =
            ResponsesClientEvent.ResponseCreate.builder()
                .background(true)
                .addContextManagement(
                    ResponsesClientEvent.ResponseCreate.ContextManagement.builder()
                        .type("type")
                        .compactThreshold(1000L)
                        .build()
                )
                .conversation("string")
                .addInclude(ResponseIncludable.FILE_SEARCH_CALL_RESULTS)
                .input("string")
                .instructions("instructions")
                .maxOutputTokens(16L)
                .maxToolCalls(0L)
                .metadata(
                    ResponsesClientEvent.ResponseCreate.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .model(ChatModel.GPT_6_ASTRA)
                .moderation(
                    ResponsesClientEvent.ResponseCreate.Moderation.builder()
                        .model("model")
                        .policy(
                            ResponsesClientEvent.ResponseCreate.Moderation.Policy.builder()
                                .input(
                                    ResponsesClientEvent.ResponseCreate.Moderation.Policy.Input
                                        .builder()
                                        .mode(
                                            ResponsesClientEvent.ResponseCreate.Moderation.Policy
                                                .Input
                                                .Mode
                                                .SCORE
                                        )
                                        .build()
                                )
                                .output(
                                    ResponsesClientEvent.ResponseCreate.Moderation.Policy.Output
                                        .builder()
                                        .mode(
                                            ResponsesClientEvent.ResponseCreate.Moderation.Policy
                                                .Output
                                                .Mode
                                                .SCORE
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
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
                .promptCacheOptions(
                    ResponsesClientEvent.ResponseCreate.PromptCacheOptions.builder()
                        .mode(ResponsesClientEvent.ResponseCreate.PromptCacheOptions.Mode.IMPLICIT)
                        .ttl(ResponsesClientEvent.ResponseCreate.PromptCacheOptions.Ttl._30M)
                        .build()
                )
                .promptCacheRetention(
                    ResponsesClientEvent.ResponseCreate.PromptCacheRetention.IN_MEMORY
                )
                .reasoning(
                    Reasoning.builder()
                        .context(Reasoning.Context.AUTO)
                        .effort(ReasoningEffort.NONE)
                        .generateSummary(Reasoning.GenerateSummary.AUTO)
                        .mode(Reasoning.Mode.STANDARD)
                        .summary(Reasoning.Summary.AUTO)
                        .build()
                )
                .safetyIdentifier("safety-identifier-1234")
                .serviceTier(ResponsesClientEvent.ResponseCreate.ServiceTier.AUTO)
                .store(true)
                .stream(true)
                .streamId("stream_id")
                .streamOptions(
                    ResponsesClientEvent.ResponseCreate.StreamOptions.builder()
                        .includeObfuscation(true)
                        .build()
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
                        .addAllowedCaller(FunctionTool.AllowedCaller.DIRECT)
                        .async(true)
                        .deferLoading(true)
                        .description("description")
                        .outputSchema(
                            FunctionTool.OutputSchema.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
                .topLogprobs(0L)
                .topP(1.0)
                .truncation(ResponsesClientEvent.ResponseCreate.Truncation.AUTO)
                .user("user-1234")
                .build()

        val responsesClientEvent = ResponsesClientEvent.ofResponseCreate(responseCreate)

        assertThat(responsesClientEvent.responseCreate()).contains(responseCreate)
        assertThat(responsesClientEvent.responseSteer()).isEmpty
    }

    @Test
    fun ofResponseCreateRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesClientEvent =
            ResponsesClientEvent.ofResponseCreate(
                ResponsesClientEvent.ResponseCreate.builder()
                    .background(true)
                    .addContextManagement(
                        ResponsesClientEvent.ResponseCreate.ContextManagement.builder()
                            .type("type")
                            .compactThreshold(1000L)
                            .build()
                    )
                    .conversation("string")
                    .addInclude(ResponseIncludable.FILE_SEARCH_CALL_RESULTS)
                    .input("string")
                    .instructions("instructions")
                    .maxOutputTokens(16L)
                    .maxToolCalls(0L)
                    .metadata(
                        ResponsesClientEvent.ResponseCreate.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .model(ChatModel.GPT_6_ASTRA)
                    .moderation(
                        ResponsesClientEvent.ResponseCreate.Moderation.builder()
                            .model("model")
                            .policy(
                                ResponsesClientEvent.ResponseCreate.Moderation.Policy.builder()
                                    .input(
                                        ResponsesClientEvent.ResponseCreate.Moderation.Policy.Input
                                            .builder()
                                            .mode(
                                                ResponsesClientEvent.ResponseCreate.Moderation
                                                    .Policy
                                                    .Input
                                                    .Mode
                                                    .SCORE
                                            )
                                            .build()
                                    )
                                    .output(
                                        ResponsesClientEvent.ResponseCreate.Moderation.Policy.Output
                                            .builder()
                                            .mode(
                                                ResponsesClientEvent.ResponseCreate.Moderation
                                                    .Policy
                                                    .Output
                                                    .Mode
                                                    .SCORE
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
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
                    .promptCacheOptions(
                        ResponsesClientEvent.ResponseCreate.PromptCacheOptions.builder()
                            .mode(
                                ResponsesClientEvent.ResponseCreate.PromptCacheOptions.Mode.IMPLICIT
                            )
                            .ttl(ResponsesClientEvent.ResponseCreate.PromptCacheOptions.Ttl._30M)
                            .build()
                    )
                    .promptCacheRetention(
                        ResponsesClientEvent.ResponseCreate.PromptCacheRetention.IN_MEMORY
                    )
                    .reasoning(
                        Reasoning.builder()
                            .context(Reasoning.Context.AUTO)
                            .effort(ReasoningEffort.NONE)
                            .generateSummary(Reasoning.GenerateSummary.AUTO)
                            .mode(Reasoning.Mode.STANDARD)
                            .summary(Reasoning.Summary.AUTO)
                            .build()
                    )
                    .safetyIdentifier("safety-identifier-1234")
                    .serviceTier(ResponsesClientEvent.ResponseCreate.ServiceTier.AUTO)
                    .store(true)
                    .stream(true)
                    .streamId("stream_id")
                    .streamOptions(
                        ResponsesClientEvent.ResponseCreate.StreamOptions.builder()
                            .includeObfuscation(true)
                            .build()
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
                            .addAllowedCaller(FunctionTool.AllowedCaller.DIRECT)
                            .async(true)
                            .deferLoading(true)
                            .description("description")
                            .outputSchema(
                                FunctionTool.OutputSchema.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .build()
                    )
                    .topLogprobs(0L)
                    .topP(1.0)
                    .truncation(ResponsesClientEvent.ResponseCreate.Truncation.AUTO)
                    .user("user-1234")
                    .build()
            )

        val roundtrippedResponsesClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesClientEvent),
                jacksonTypeRef<ResponsesClientEvent>(),
            )

        assertThat(roundtrippedResponsesClientEvent).isEqualTo(responsesClientEvent)
    }

    @Test
    fun ofResponseSteer() {
        val responseSteer =
            ResponseSteerEvent.builder()
                .input("string")
                .previousResponseId("previous_response_id")
                .build()

        val responsesClientEvent = ResponsesClientEvent.ofResponseSteer(responseSteer)

        assertThat(responsesClientEvent.responseCreate()).isEmpty
        assertThat(responsesClientEvent.responseSteer()).contains(responseSteer)
    }

    @Test
    fun ofResponseSteerRoundtrip() {
        val jsonMapper = jsonMapper()
        val responsesClientEvent =
            ResponsesClientEvent.ofResponseSteer(
                ResponseSteerEvent.builder()
                    .input("string")
                    .previousResponseId("previous_response_id")
                    .build()
            )

        val roundtrippedResponsesClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responsesClientEvent),
                jacksonTypeRef<ResponsesClientEvent>(),
            )

        assertThat(roundtrippedResponsesClientEvent).isEqualTo(responsesClientEvent)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val responsesClientEvent =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<ResponsesClientEvent>())

        val e = assertThrows<OpenAIInvalidDataException> { responsesClientEvent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
