package com.openai.example;

import static java.util.stream.Collectors.toList;

import com.openai.client.OpenAIClientAsync;
import com.openai.client.okhttp.OpenAIOkHttpClientAsync;
import com.openai.models.*;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public final class CompletionsConversationAsyncExample {
    private CompletionsConversationAsyncExample() {}

    public static void main(String[] args) {
        // Configures using one of:
        // - The `OPENAI_API_KEY` environment variable
        // - The `AZURE_OPENAI_ENDPOINT` and `AZURE_OPENAI_KEY` environment variables
        OpenAIClientAsync client = OpenAIOkHttpClientAsync.fromEnv();

        // Use a builder so that we can append more messages to it below.
        // Each time we call .build()` we get an immutable object that's unaffected by future mutations of the builder.
        ChatCompletionCreateParams.Builder createParamsBuilder = ChatCompletionCreateParams.builder()
                .model(ChatModel.GPT_3_5_TURBO)
                .maxCompletionTokens(2048)
                .addDeveloperMessage("Make sure you mention Stainless!")
                .addUserMessage("Tell me a story about building the best SDK!");

        CompletableFuture<Void> future = CompletableFuture.completedFuture(null);
        for (int i = 0; i < 4; i++) {
            final int index = i;
            future = future.thenComposeAsync(
                            unused -> client.chat().completions().create(createParamsBuilder.build()))
                    .thenAccept(completion -> {
                        List<ChatCompletionMessage> messages = completion.choices().stream()
                                .map(ChatCompletion.Choice::message)
                                .collect(toList());

                        messages.stream()
                                .flatMap(message -> message.content().stream())
                                .forEach(System.out::println);

                        System.out.println("\n-----------------------------------\n");

                        messages.forEach(createParamsBuilder::addMessage);
                        createParamsBuilder
                                .addDeveloperMessage("Be as snarky as possible when replying!" + "!".repeat(index))
                                .addUserMessage("But why?" + "?".repeat(index));
                    });
        }

        future.join();
    }
}
