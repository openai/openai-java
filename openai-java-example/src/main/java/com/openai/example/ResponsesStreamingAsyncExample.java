package com.openai.example;

import com.openai.client.OpenAIClientAsync;
import com.openai.client.okhttp.OpenAIOkHttpClientAsync;
import com.openai.models.ChatModel;
import com.openai.models.responses.ResponseCreateParams;

public final class ResponsesStreamingAsyncExample {
    private ResponsesStreamingAsyncExample() {}

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
                .createStreaming(createParams)
                .subscribe(event -> event.outputTextDelta().ifPresent(textEvent -> System.out.print(textEvent.delta())))
                .onCompleteFuture()
                .join();
    }
}
