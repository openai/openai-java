package com.openai.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatCompletionCreateParams;
import com.openai.models.ChatCompletionDeveloperMessageParam;
import com.openai.models.ChatCompletionUserMessageParam;
import com.openai.models.ChatModel;

public final class CompletionsExample {
    private CompletionsExample() {}

    public static void main(String[] args) {
        // Configures using one of:
        // - The `OPENAI_API_KEY` environment variable
        // - The `AZURE_OPENAI_ENDPOINT` and `AZURE_OPENAI_KEY` environment variables
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();

        ChatCompletionCreateParams createParams = ChatCompletionCreateParams.builder()
                .model(ChatModel.GPT_3_5_TURBO)
                .maxCompletionTokens(2048)
                .addMessage(ChatCompletionDeveloperMessageParam.builder()
                        .content("Make sure you mention Stainless!")
                        .build())
                .addMessage(ChatCompletionUserMessageParam.builder()
                        .content("Tell me a story about building the best SDK!")
                        .build())
                .build();

        client.chat().completions().create(createParams).choices().stream()
                .flatMap(choice -> choice.message().content().stream())
                .forEach(System.out::println);
    }
}
