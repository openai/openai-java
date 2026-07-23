package com.openai.example;

import com.openai.client.OpenAIClientAsync;
import com.openai.client.okhttp.BedrockOpenAIOkHttpClient;
import com.openai.models.responses.ResponseCreateParams;

public final class BedrockResponsesStreamingAsyncExample {
    private BedrockResponsesStreamingAsyncExample() {}

    public static void main(String[] args) {
        OpenAIClientAsync client = BedrockOpenAIOkHttpClient.builder()
                .awsRegion("us-east-1")
                .build()
                .async();

        ResponseCreateParams params = ResponseCreateParams.builder()
                .input("Count to five")
                .model("openai.gpt-5.5")
                .build();

        client.responses()
                .createStreaming(params)
                .subscribe(event -> event.outputTextDelta().ifPresent(delta -> System.out.print(delta.delta())))
                .onCompleteFuture()
                .join();
    }
}
