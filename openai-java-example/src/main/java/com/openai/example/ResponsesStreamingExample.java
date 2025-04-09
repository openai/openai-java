package com.openai.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.core.http.StreamResponse;
import com.openai.models.ChatModel;
import com.openai.models.responses.ResponseCreateParams;
import com.openai.models.responses.ResponseStreamEvent;

public final class ResponsesStreamingExample {
    private ResponsesStreamingExample() {}

    public static void main(String[] args) {
        // Configures using one of:
        // - The `OPENAI_API_KEY` environment variable
        // - The `OPENAI_BASE_URL` and `AZURE_OPENAI_KEY` environment variables
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();

        ResponseCreateParams createParams = ResponseCreateParams.builder()
                .input("Tell me a story about building the best SDK!")
                .model(ChatModel.GPT_4O)
                .build();

        try (StreamResponse<ResponseStreamEvent> streamResponse =
                client.responses().createStreaming(createParams)) {
            streamResponse.stream()
                    .flatMap(event -> event.outputTextDelta().stream())
                    .forEach(textEvent -> System.out.print(textEvent.delta()));
        }
    }
}
