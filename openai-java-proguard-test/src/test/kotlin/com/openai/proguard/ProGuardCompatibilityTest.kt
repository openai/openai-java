// File generated from our OpenAPI spec by Stainless.

package com.openai.proguard

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.jsonMapper
import com.openai.models.chat.completions.ChatCompletion
import com.openai.models.chat.completions.ChatCompletionAudio
import com.openai.models.chat.completions.ChatCompletionContentPart
import com.openai.models.chat.completions.ChatCompletionContentPartText
import com.openai.models.chat.completions.ChatCompletionMessage
import com.openai.models.chat.completions.ChatCompletionMessageFunctionToolCall
import com.openai.models.chat.completions.ChatCompletionModality
import com.openai.models.chat.completions.ChatCompletionTokenLogprob
import com.openai.models.completions.CompletionUsage
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.jvm.javaMethod
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProGuardCompatibilityTest {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            // To debug that we're using the right JAR.
            val jarPath = this::class.java.getProtectionDomain().codeSource.location
            println("JAR being used: $jarPath")

            // We have to manually run the test methods instead of using the JUnit runner because it
            // seems impossible to get working with R8.
            val test = ProGuardCompatibilityTest()
            test::class
                .memberFunctions
                .asSequence()
                .filter { function ->
                    function.javaMethod?.isAnnotationPresent(Test::class.java) == true
                }
                .forEach { it.call(test) }
        }
    }

    @Test
    fun proguardRules() {
        val rulesFile =
            javaClass.classLoader.getResourceAsStream("META-INF/proguard/openai-java-core.pro")

        assertThat(rulesFile).isNotNull()
    }

    @Test
    fun client() {
        val client = OpenAIOkHttpClient.builder().apiKey("My API Key").build()

        assertThat(client).isNotNull()
        assertThat(client.completions()).isNotNull()
        assertThat(client.chat()).isNotNull()
        assertThat(client.embeddings()).isNotNull()
        assertThat(client.files()).isNotNull()
        assertThat(client.images()).isNotNull()
        assertThat(client.audio()).isNotNull()
        assertThat(client.moderations()).isNotNull()
        assertThat(client.models()).isNotNull()
        assertThat(client.fineTuning()).isNotNull()
        assertThat(client.graders()).isNotNull()
        assertThat(client.vectorStores()).isNotNull()
        assertThat(client.webhooks()).isNotNull()
        assertThat(client.beta()).isNotNull()
        assertThat(client.batches()).isNotNull()
        assertThat(client.uploads()).isNotNull()
        assertThat(client.responses()).isNotNull()
        assertThat(client.realtime()).isNotNull()
        assertThat(client.conversations()).isNotNull()
        assertThat(client.evals()).isNotNull()
        assertThat(client.containers()).isNotNull()
        assertThat(client.skills()).isNotNull()
        assertThat(client.videos()).isNotNull()
    }

    @Test
    fun chatCompletionRoundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletion =
            ChatCompletion.builder()
                .id("id")
                .addChoice(
                    ChatCompletion.Choice.builder()
                        .finishReason(ChatCompletion.Choice.FinishReason.STOP)
                        .index(0L)
                        .logprobs(
                            ChatCompletion.Choice.Logprobs.builder()
                                .addContent(
                                    ChatCompletionTokenLogprob.builder()
                                        .token("token")
                                        .addByte(0L)
                                        .logprob(0.0)
                                        .addTopLogprob(
                                            ChatCompletionTokenLogprob.TopLogprob.builder()
                                                .token("token")
                                                .addByte(0L)
                                                .logprob(0.0)
                                                .build()
                                        )
                                        .build()
                                )
                                .addRefusal(
                                    ChatCompletionTokenLogprob.builder()
                                        .token("token")
                                        .addByte(0L)
                                        .logprob(0.0)
                                        .addTopLogprob(
                                            ChatCompletionTokenLogprob.TopLogprob.builder()
                                                .token("token")
                                                .addByte(0L)
                                                .logprob(0.0)
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .message(
                            ChatCompletionMessage.builder()
                                .content("content")
                                .refusal("refusal")
                                .addAnnotation(
                                    ChatCompletionMessage.Annotation.builder()
                                        .urlCitation(
                                            ChatCompletionMessage.Annotation.UrlCitation.builder()
                                                .endIndex(0L)
                                                .startIndex(0L)
                                                .title("title")
                                                .url("url")
                                                .build()
                                        )
                                        .build()
                                )
                                .audio(
                                    ChatCompletionAudio.builder()
                                        .id("id")
                                        .data("data")
                                        .expiresAt(0L)
                                        .transcript("transcript")
                                        .build()
                                )
                                .functionCall(
                                    ChatCompletionMessage.FunctionCall.builder()
                                        .arguments("arguments")
                                        .name("name")
                                        .build()
                                )
                                .addToolCall(
                                    ChatCompletionMessageFunctionToolCall.builder()
                                        .id("id")
                                        .function(
                                            ChatCompletionMessageFunctionToolCall.Function.builder()
                                                .arguments("arguments")
                                                .name("name")
                                                .build()
                                        )
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .created(0L)
                .model("model")
                .serviceTier(ChatCompletion.ServiceTier.AUTO)
                .systemFingerprint("system_fingerprint")
                .usage(
                    CompletionUsage.builder()
                        .completionTokens(0L)
                        .promptTokens(0L)
                        .totalTokens(0L)
                        .completionTokensDetails(
                            CompletionUsage.CompletionTokensDetails.builder()
                                .acceptedPredictionTokens(0L)
                                .audioTokens(0L)
                                .reasoningTokens(0L)
                                .rejectedPredictionTokens(0L)
                                .build()
                        )
                        .promptTokensDetails(
                            CompletionUsage.PromptTokensDetails.builder()
                                .audioTokens(0L)
                                .cachedTokens(0L)
                                .build()
                        )
                        .build()
                )
                .build()

        val roundtrippedChatCompletion =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletion),
                jacksonTypeRef<ChatCompletion>(),
            )

        assertThat(roundtrippedChatCompletion).isEqualTo(chatCompletion)
    }

    @Test
    fun chatCompletionContentPartRoundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionContentPart =
            ChatCompletionContentPart.ofText(
                ChatCompletionContentPartText.builder().text("text").build()
            )

        val roundtrippedChatCompletionContentPart =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionContentPart),
                jacksonTypeRef<ChatCompletionContentPart>(),
            )

        assertThat(roundtrippedChatCompletionContentPart).isEqualTo(chatCompletionContentPart)
    }

    @Test
    fun chatCompletionModalityRoundtrip() {
        val jsonMapper = jsonMapper()
        val chatCompletionModality = ChatCompletionModality.TEXT

        val roundtrippedChatCompletionModality =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatCompletionModality),
                jacksonTypeRef<ChatCompletionModality>(),
            )

        assertThat(roundtrippedChatCompletionModality).isEqualTo(chatCompletionModality)
    }
}
