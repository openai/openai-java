package com.openai.example;

import com.openai.client.OpenAIClientAsync;
import com.openai.client.okhttp.OpenAIOkHttpClientAsync;
import com.openai.core.http.AsyncStreamResponse;
import com.openai.models.*;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public final class CompletionsStreamingAsyncExample {
    private CompletionsStreamingAsyncExample() {}

    public static void main(String[] args) throws Exception {
        // Configures using one of:
        // - The `OPENAI_API_KEY` environment variable
        // - The `AZURE_OPENAI_ENDPOINT` and `AZURE_OPENAI_KEY` environment variables
        OpenAIClientAsync client = OpenAIOkHttpClientAsync.fromEnv();

        ChatCompletionCreateParams createParams = ChatCompletionCreateParams.builder()
                .model(ChatModel.GPT_3_5_TURBO)
                .maxCompletionTokens(2048)
                .addDeveloperMessage("Make sure you mention Stainless!")
                .addUserMessage("Tell me a story about building the best SDK!")
                .build();

        CompletableFuture<Void> onCompleteFuture = new CompletableFuture<>();

        // TODO: Update this example once we support expose an `onCompleteFuture()` method.
        client.chat().completions().createStreaming(createParams).subscribe(new AsyncStreamResponse.Handler<>() {
            @Override
            public void onNext(ChatCompletionChunk completion) {
                completion.choices().stream()
                        .flatMap(choice -> choice.delta().content().stream())
                        .forEach(System.out::print);
            }

            @Override
            public void onComplete(Optional<Throwable> error) {
                onCompleteFuture.complete(null);
            }
        });

        onCompleteFuture.join();
    }
}
