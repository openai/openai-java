package com.openai.client.okhttp

import com.openai.bedrock.BedrockEndpoint
import com.openai.client.OpenAIClient
import com.openai.models.chat.completions.ChatCompletionCreateParams
import com.openai.models.responses.ResponseCreateParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable

@EnabledIfEnvironmentVariable(named = "BEDROCK_LIVE_TEST", matches = "1")
internal class BedrockRuntimeLiveTest {

    @Test
    fun runtimeInferenceProfilesCompleteSelectedApiRequests() {
        val client = createClient()
        val api = environment("BEDROCK_LIVE_API") ?: "chat"
        val streaming = environment("BEDROCK_LIVE_STREAM") == "true"

        try {
            models().forEach { model ->
                when (api) {
                    "chat" -> verifyChat(client, model, streaming)
                    "responses" -> verifyResponse(client, model, streaming)
                    else -> error("BEDROCK_LIVE_API must be chat or responses.")
                }
            }
        } finally {
            client.close()
        }
    }

    private fun createClient(): OpenAIClient {
        val region = environment("AWS_REGION") ?: environment("AWS_DEFAULT_REGION") ?: "us-east-1"
        val builder =
            BedrockOpenAIOkHttpClient.builder().endpoint(BedrockEndpoint.RUNTIME).awsRegion(region)

        when (environment("BEDROCK_LIVE_AUTH") ?: "sigv4") {
            "bearer" ->
                builder.apiKey(
                    environment("AWS_BEARER_TOKEN_BEDROCK")
                        ?: error("Bearer live tests require AWS_BEARER_TOKEN_BEDROCK.")
                )
            "sigv4" -> {
                val profile = environment("AWS_PROFILE")
                if (profile != null) {
                    builder.awsProfile(profile)
                } else {
                    check(environment("AWS_BEARER_TOKEN_BEDROCK") == null) {
                        "Unset AWS_BEARER_TOKEN_BEDROCK or set AWS_PROFILE to use SigV4."
                    }
                }
            }
            else -> error("BEDROCK_LIVE_AUTH must be sigv4 or bearer.")
        }

        return builder.build()
    }

    private fun models(): List<String> =
        (environment("BEDROCK_LIVE_MODELS")
                ?: "us.openai.gpt-5.6-sol,us.openai.gpt-5.6-terra,us.openai.gpt-5.6-luna")
            .split(',')
            .map(String::trim)
            .filter(String::isNotEmpty)
            .also { check(it.isNotEmpty()) { "BEDROCK_LIVE_MODELS must not be empty." } }

    private fun verifyChat(client: OpenAIClient, model: String, streaming: Boolean) {
        val params =
            ChatCompletionCreateParams.builder()
                .model(model)
                .addUserMessage("Reply with one short greeting.")
                .build()

        if (streaming) {
            val chunks = mutableListOf<String>()
            client.chat().completions().createStreaming(params).use { stream ->
                stream.stream().forEach { chunk ->
                    chunk.choices().forEach { choice ->
                        choice.delta().content().ifPresent(chunks::add)
                    }
                }
            }
            assertThat(chunks)
                .describedAs("streaming Chat Completions output for %s", model)
                .isNotEmpty()
        } else {
            val completion = client.chat().completions().create(params)
            assertThat(completion.choices())
                .describedAs("Chat Completions output for %s", model)
                .isNotEmpty()
        }
    }

    private fun verifyResponse(client: OpenAIClient, model: String, streaming: Boolean) {
        val params =
            ResponseCreateParams.builder()
                .model(model)
                .input("Reply with one short greeting.")
                .build()

        if (streaming) {
            val chunks = mutableListOf<String>()
            client.responses().createStreaming(params).use { stream ->
                stream.stream().forEach { event ->
                    event.outputTextDelta().ifPresent { chunks.add(it.delta()) }
                }
            }
            assertThat(chunks).describedAs("streaming Responses output for %s", model).isNotEmpty()
        } else {
            val response = client.responses().create(params)
            assertThat(response.id()).describedAs("Responses identifier for %s", model).isNotBlank()
        }
    }

    private fun environment(name: String): String? =
        System.getenv(name)?.trim()?.takeIf(String::isNotEmpty)
}
