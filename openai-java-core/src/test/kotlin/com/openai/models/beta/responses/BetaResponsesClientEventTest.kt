// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class BetaResponsesClientEventTest {

    @Test
    fun ofResponseCreate() {
        val responseCreate =
            BetaResponsesClientEvent.ResponseCreate.builder()
                .background(true)
                .addContextManagement(
                    BetaResponsesClientEvent.ResponseCreate.ContextManagement.builder()
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
                    BetaResponsesClientEvent.ResponseCreate.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .model(BetaResponsesClientEvent.ResponseCreate.Model.GPT_5_1)
                .moderation(
                    BetaResponsesClientEvent.ResponseCreate.Moderation.builder()
                        .model("model")
                        .policy(
                            BetaResponsesClientEvent.ResponseCreate.Moderation.Policy.builder()
                                .input(
                                    BetaResponsesClientEvent.ResponseCreate.Moderation.Policy.Input
                                        .builder()
                                        .mode(
                                            BetaResponsesClientEvent.ResponseCreate.Moderation
                                                .Policy
                                                .Input
                                                .Mode
                                                .SCORE
                                        )
                                        .build()
                                )
                                .output(
                                    BetaResponsesClientEvent.ResponseCreate.Moderation.Policy.Output
                                        .builder()
                                        .mode(
                                            BetaResponsesClientEvent.ResponseCreate.Moderation
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
                .multiAgent(
                    BetaResponsesClientEvent.ResponseCreate.MultiAgent.builder()
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
                    BetaResponsesClientEvent.ResponseCreate.PromptCacheOptions.builder()
                        .mode(
                            BetaResponsesClientEvent.ResponseCreate.PromptCacheOptions.Mode.IMPLICIT
                        )
                        .ttl(BetaResponsesClientEvent.ResponseCreate.PromptCacheOptions.Ttl._30M)
                        .build()
                )
                .promptCacheRetention(
                    BetaResponsesClientEvent.ResponseCreate.PromptCacheRetention.IN_MEMORY
                )
                .reasoning(
                    BetaResponsesClientEvent.ResponseCreate.Reasoning.builder()
                        .context(BetaResponsesClientEvent.ResponseCreate.Reasoning.Context.AUTO)
                        .effort(BetaResponsesClientEvent.ResponseCreate.Reasoning.Effort.NONE)
                        .generateSummary(
                            BetaResponsesClientEvent.ResponseCreate.Reasoning.GenerateSummary.AUTO
                        )
                        .mode(BetaResponsesClientEvent.ResponseCreate.Reasoning.Mode.STANDARD)
                        .summary(BetaResponsesClientEvent.ResponseCreate.Reasoning.Summary.AUTO)
                        .build()
                )
                .safetyIdentifier("safety-identifier-1234")
                .serviceTier(BetaResponsesClientEvent.ResponseCreate.ServiceTier.AUTO)
                .store(true)
                .stream(true)
                .streamOptions(
                    BetaResponsesClientEvent.ResponseCreate.StreamOptions.builder()
                        .includeObfuscation(true)
                        .build()
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
                .truncation(BetaResponsesClientEvent.ResponseCreate.Truncation.AUTO)
                .user("user-1234")
                .build()

        val betaResponsesClientEvent = BetaResponsesClientEvent.ofResponseCreate(responseCreate)

        assertThat(betaResponsesClientEvent.responseCreate()).contains(responseCreate)
        assertThat(betaResponsesClientEvent.responseInject()).isEmpty
    }

    @Test
    fun ofResponseCreateRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponsesClientEvent =
            BetaResponsesClientEvent.ofResponseCreate(
                BetaResponsesClientEvent.ResponseCreate.builder()
                    .background(true)
                    .addContextManagement(
                        BetaResponsesClientEvent.ResponseCreate.ContextManagement.builder()
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
                        BetaResponsesClientEvent.ResponseCreate.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .model(BetaResponsesClientEvent.ResponseCreate.Model.GPT_5_1)
                    .moderation(
                        BetaResponsesClientEvent.ResponseCreate.Moderation.builder()
                            .model("model")
                            .policy(
                                BetaResponsesClientEvent.ResponseCreate.Moderation.Policy.builder()
                                    .input(
                                        BetaResponsesClientEvent.ResponseCreate.Moderation.Policy
                                            .Input
                                            .builder()
                                            .mode(
                                                BetaResponsesClientEvent.ResponseCreate.Moderation
                                                    .Policy
                                                    .Input
                                                    .Mode
                                                    .SCORE
                                            )
                                            .build()
                                    )
                                    .output(
                                        BetaResponsesClientEvent.ResponseCreate.Moderation.Policy
                                            .Output
                                            .builder()
                                            .mode(
                                                BetaResponsesClientEvent.ResponseCreate.Moderation
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
                    .multiAgent(
                        BetaResponsesClientEvent.ResponseCreate.MultiAgent.builder()
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
                        BetaResponsesClientEvent.ResponseCreate.PromptCacheOptions.builder()
                            .mode(
                                BetaResponsesClientEvent.ResponseCreate.PromptCacheOptions.Mode
                                    .IMPLICIT
                            )
                            .ttl(
                                BetaResponsesClientEvent.ResponseCreate.PromptCacheOptions.Ttl._30M
                            )
                            .build()
                    )
                    .promptCacheRetention(
                        BetaResponsesClientEvent.ResponseCreate.PromptCacheRetention.IN_MEMORY
                    )
                    .reasoning(
                        BetaResponsesClientEvent.ResponseCreate.Reasoning.builder()
                            .context(BetaResponsesClientEvent.ResponseCreate.Reasoning.Context.AUTO)
                            .effort(BetaResponsesClientEvent.ResponseCreate.Reasoning.Effort.NONE)
                            .generateSummary(
                                BetaResponsesClientEvent.ResponseCreate.Reasoning.GenerateSummary
                                    .AUTO
                            )
                            .mode(BetaResponsesClientEvent.ResponseCreate.Reasoning.Mode.STANDARD)
                            .summary(BetaResponsesClientEvent.ResponseCreate.Reasoning.Summary.AUTO)
                            .build()
                    )
                    .safetyIdentifier("safety-identifier-1234")
                    .serviceTier(BetaResponsesClientEvent.ResponseCreate.ServiceTier.AUTO)
                    .store(true)
                    .stream(true)
                    .streamOptions(
                        BetaResponsesClientEvent.ResponseCreate.StreamOptions.builder()
                            .includeObfuscation(true)
                            .build()
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
                    .truncation(BetaResponsesClientEvent.ResponseCreate.Truncation.AUTO)
                    .user("user-1234")
                    .build()
            )

        val roundtrippedBetaResponsesClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponsesClientEvent),
                jacksonTypeRef<BetaResponsesClientEvent>(),
            )

        assertThat(roundtrippedBetaResponsesClientEvent).isEqualTo(betaResponsesClientEvent)
    }

    @Test
    fun ofResponseInject() {
        val responseInject =
            BetaResponseInjectEvent.builder()
                .addInput(
                    BetaEasyInputMessage.builder()
                        .content("string")
                        .role(BetaEasyInputMessage.Role.USER)
                        .phase(BetaEasyInputMessage.Phase.COMMENTARY)
                        .type(BetaEasyInputMessage.Type.MESSAGE)
                        .build()
                )
                .responseId("response_id")
                .build()

        val betaResponsesClientEvent = BetaResponsesClientEvent.ofResponseInject(responseInject)

        assertThat(betaResponsesClientEvent.responseCreate()).isEmpty
        assertThat(betaResponsesClientEvent.responseInject()).contains(responseInject)
    }

    @Test
    fun ofResponseInjectRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponsesClientEvent =
            BetaResponsesClientEvent.ofResponseInject(
                BetaResponseInjectEvent.builder()
                    .addInput(
                        BetaEasyInputMessage.builder()
                            .content("string")
                            .role(BetaEasyInputMessage.Role.USER)
                            .phase(BetaEasyInputMessage.Phase.COMMENTARY)
                            .type(BetaEasyInputMessage.Type.MESSAGE)
                            .build()
                    )
                    .responseId("response_id")
                    .build()
            )

        val roundtrippedBetaResponsesClientEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponsesClientEvent),
                jacksonTypeRef<BetaResponsesClientEvent>(),
            )

        assertThat(roundtrippedBetaResponsesClientEvent).isEqualTo(betaResponsesClientEvent)
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
        val betaResponsesClientEvent =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<BetaResponsesClientEvent>())

        val e = assertThrows<OpenAIInvalidDataException> { betaResponsesClientEvent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
