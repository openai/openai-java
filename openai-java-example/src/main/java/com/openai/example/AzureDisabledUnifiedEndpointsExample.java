package com.openai.example;

import com.openai.azure.AzureOpenAIServiceVersion;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletionCreateParams;

public final class AzureDisabledUnifiedEndpointsExample {
    private AzureDisabledUnifiedEndpointsExample() {}

    public static void main(String[] args) {
        OpenAIClient client = OpenAIOkHttpClient.builder()
                // Gets the API key from the `AZURE_OPENAI_KEY` environment variable
                .fromEnv()
                .azureServiceVersion(AzureOpenAIServiceVersion.getV2024_05_01_PREVIEW())
                // Disabling unified endpoints will result in the deployment name being passed as a path parameter
                .unifiedAzureRoutes(false)
                .build();

        ChatCompletionCreateParams createParams = ChatCompletionCreateParams.builder()
                .model(ChatModel.of("DeepSeek-R1"))
                .maxCompletionTokens(2048)
                .addSystemMessage("Make sure you mention Stainless!") // Developer doesn't work
                .addUserMessage("Tell me a story about building the best SDK!")
                .build();

        client.chat().completions().create(createParams).choices().stream()
                .flatMap(choice -> choice.message().content().stream())
                .forEach(System.out::println);
    }
}