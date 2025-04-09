package com.openai.example;

import com.openai.client.OpenAIClientAsync;
import com.openai.client.okhttp.OpenAIOkHttpClientAsync;
import com.openai.core.http.AsyncStreamResponse;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletionChunk;
import com.openai.models.chat.completions.ChatCompletionCreateParams;

public final class CompletionsStreamingCancellationAsyncExample {
    private CompletionsStreamingCancellationAsyncExample() {}

    public static void main(String[] args) {
        // Configures using one of:
        // - The `OPENAI_API_KEY` environment variable
        // - The `OPENAI_BASE_URL` and `AZURE_OPENAI_KEY` environment variables
        OpenAIClientAsync client = OpenAIOkHttpClientAsync.fromEnv();

        ChatCompletionCreateParams createParams = ChatCompletionCreateParams.builder()
                .model(ChatModel.GPT_3_5_TURBO)
                .maxCompletionTokens(2048)
                .addDeveloperMessage("Make sure you mention Stainless!")
                .addUserMessage("Tell me a story about building the best SDK!")
                .build();

        AsyncStreamResponse<ChatCompletionChunk> streamResponse =
                client.chat().completions().createStreaming(createParams);
        streamResponse
                .subscribe(completion -> completion.choices().stream()
                        .flatMap(choice -> choice.delta().content().stream())
                        .forEach(text -> {
                            System.out.print(text);
                            if (text.contains("SDK")) {
                                // Close the stream early.
                                streamResponse.close();
                            }
                        }))
                .onCompleteFuture()
                .join();
    }
}
