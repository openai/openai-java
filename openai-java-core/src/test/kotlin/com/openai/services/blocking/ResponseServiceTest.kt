// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.ChatModel
import com.openai.models.Reasoning
import com.openai.models.ReasoningEffort
import com.openai.models.ResponseFormatText
import com.openai.models.responses.FunctionTool
import com.openai.models.responses.ResponseCreateParams
import com.openai.models.responses.ResponseIncludable
import com.openai.models.responses.ResponsePrompt
import com.openai.models.responses.ResponseRetrieveParams
import com.openai.models.responses.ResponseTextConfig
import com.openai.models.responses.ToolChoiceOptions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ResponseServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val responseService = client.responses()

        val response =
            responseService.create(
                ResponseCreateParams.builder()
                    .background(true)
                    .addInclude(ResponseIncludable.CODE_INTERPRETER_CALL_OUTPUTS)
                    .input("string")
                    .instructions("instructions")
                    .maxOutputTokens(0L)
                    .maxToolCalls(0L)
                    .metadata(
                        ResponseCreateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .model(ChatModel.GPT_4O)
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
                    .reasoning(
                        Reasoning.builder()
                            .effort(ReasoningEffort.MINIMAL)
                            .generateSummary(Reasoning.GenerateSummary.AUTO)
                            .summary(Reasoning.Summary.AUTO)
                            .build()
                    )
                    .safetyIdentifier("safety-identifier-1234")
                    .serviceTier(ResponseCreateParams.ServiceTier.AUTO)
                    .store(true)
                    .streamOptions(
                        ResponseCreateParams.StreamOptions.builder()
                            .includeObfuscation(true)
                            .build()
                    )
                    .temperature(1.0)
                    .text(
                        ResponseTextConfig.builder()
                            .format(ResponseFormatText.builder().build())
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
                    .verbosity(ResponseCreateParams.Verbosity.LOW)
                    .build()
            )

        response.validate()
    }

    @Test
    fun createStreaming() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val responseService = client.responses()

        val responseStreamResponse =
            responseService.createStreaming(
                ResponseCreateParams.builder()
                    .background(true)
                    .addInclude(ResponseIncludable.CODE_INTERPRETER_CALL_OUTPUTS)
                    .input("string")
                    .instructions("instructions")
                    .maxOutputTokens(0L)
                    .maxToolCalls(0L)
                    .metadata(
                        ResponseCreateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .model(ChatModel.GPT_4O)
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
                    .reasoning(
                        Reasoning.builder()
                            .effort(ReasoningEffort.MINIMAL)
                            .generateSummary(Reasoning.GenerateSummary.AUTO)
                            .summary(Reasoning.Summary.AUTO)
                            .build()
                    )
                    .safetyIdentifier("safety-identifier-1234")
                    .serviceTier(ResponseCreateParams.ServiceTier.AUTO)
                    .store(true)
                    .streamOptions(
                        ResponseCreateParams.StreamOptions.builder()
                            .includeObfuscation(true)
                            .build()
                    )
                    .temperature(1.0)
                    .text(
                        ResponseTextConfig.builder()
                            .format(ResponseFormatText.builder().build())
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
                    .verbosity(ResponseCreateParams.Verbosity.LOW)
                    .build()
            )

        responseStreamResponse.use {
            responseStreamResponse.stream().forEach { response -> response.validate() }
        }
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val responseService = client.responses()

        val response =
            responseService.retrieve(
                ResponseRetrieveParams.builder()
                    .responseId("resp_677efb5139a88190b512bc3fef8e535d")
                    .addInclude(ResponseIncludable.CODE_INTERPRETER_CALL_OUTPUTS)
                    .includeObfuscation(true)
                    .startingAfter(0L)
                    .build()
            )

        response.validate()
    }

    @Test
    fun retrieveStreaming() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val responseService = client.responses()

        val responseStreamResponse =
            responseService.retrieveStreaming(
                ResponseRetrieveParams.builder()
                    .responseId("resp_677efb5139a88190b512bc3fef8e535d")
                    .addInclude(ResponseIncludable.CODE_INTERPRETER_CALL_OUTPUTS)
                    .includeObfuscation(true)
                    .startingAfter(0L)
                    .build()
            )

        responseStreamResponse.use {
            responseStreamResponse.stream().forEach { response -> response.validate() }
        }
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val responseService = client.responses()

        responseService.delete("resp_677efb5139a88190b512bc3fef8e535d")
    }

    @Test
    fun cancel() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val responseService = client.responses()

        val response = responseService.cancel("resp_677efb5139a88190b512bc3fef8e535d")

        response.validate()
    }
}
