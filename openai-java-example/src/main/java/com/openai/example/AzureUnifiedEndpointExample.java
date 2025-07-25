package com.openai.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletionCreateParams;

public final class AzureUnifiedEndpointExample {
    private AzureUnifiedEndpointExample() {}

    public static void main(String[] args) {
        OpenAIClient client = OpenAIOkHttpClient.builder()
                // Gets the API key from the `AZURE_OPENAI_KEY` environment variable
                .fromEnv()
                .build();

        ChatCompletionCreateParams createParams = ChatCompletionCreateParams.builder()
                .model(ChatModel.GPT_4_1106_PREVIEW)
                .maxCompletionTokens(2048)
                .addSystemMessage("Make sure you mention Stainless!") // Developer doesn't work
                .addUserMessage("Tell me a story about building the best SDK!")
                .build();

        client.chat().completions().create(createParams).choices().stream()
                .flatMap(choice -> choice.message().content().stream())
                .forEach(System.out::println);
    }
}