package com.openai.example;

import com.azure.identity.AuthenticationUtil;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.credential.BearerTokenCredential;
import com.openai.models.ChatCompletionCreateParams;
import com.openai.models.ChatCompletionDeveloperMessageParam;
import com.openai.models.ChatCompletionUserMessageParam;
import com.openai.models.ChatModel;

public final class AzureEntraIdExample {
    private AzureEntraIdExample() {}

    public static void main(String[] args) {
        OpenAIClient client = OpenAIOkHttpClient.builder()
                // Gets the API key from the `AZURE_OPENAI_KEY` environment variable
                .fromEnv()
                // Set the Azure Entra ID
                .credential(BearerTokenCredential.create(AuthenticationUtil.getBearerTokenSupplier(
                        new DefaultAzureCredentialBuilder().build(), "https://cognitiveservices.azure.com/.default")))
                .build();

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
