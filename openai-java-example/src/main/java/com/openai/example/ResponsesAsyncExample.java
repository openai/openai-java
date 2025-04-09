package com.openai.example;

import com.openai.client.OpenAIClientAsync;
import com.openai.client.okhttp.OpenAIOkHttpClientAsync;
import com.openai.models.ChatModel;
import com.openai.models.responses.ResponseCreateParams;

public final class ResponsesAsyncExample {
    private ResponsesAsyncExample() {}

    public static void main(String[] args) {
        // Configures using one of:
        // - The `OPENAI_API_KEY` environment variable
        // - The `OPENAI_BASE_URL` and `AZURE_OPENAI_KEY` environment variables
        OpenAIClientAsync client = OpenAIOkHttpClientAsync.fromEnv();

        ResponseCreateParams createParams = ResponseCreateParams.builder()
                .input("Tell me a story about building the best SDK!")
                .model(ChatModel.GPT_4O)
                .build();

        client.responses()
                .create(createParams)
                .thenAccept(response -> response.output().stream()
                        .flatMap(item -> item.message().stream())
                        .flatMap(message -> message.content().stream())
                        .flatMap(content -> content.outputText().stream())
                        .forEach(outputText -> System.out.println(outputText.text())))
                .join();
    }
}
