package com.openai.example;

import com.openai.azure.credential.AzureApiKeyCredential;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletionCreateParams;

public class AzureKeyCredentialExample {
    private AzureKeyCredentialExample() {}

    public static void main(String[] args) {
        OpenAIClient client = OpenAIOkHttpClient.builder()
                .baseUrl("{your-azure-openai-endpoint}")
                .credential(AzureApiKeyCredential.create("{your-azure-openai-key}"))
                .build();

        ChatCompletionCreateParams createParams = ChatCompletionCreateParams.builder()
                .model(ChatModel.GPT_4_1106_PREVIEW)
                .maxCompletionTokens(2048)
                .addSystemMessage("Make sure you mention Stainless!")
                .addUserMessage("Tell me a story about building the best SDK!")
                .build();

        client.chat().completions().create(createParams).choices().stream()
                .flatMap(choice -> choice.message().content().stream())
                .forEach(System.out::println);
    }
}
