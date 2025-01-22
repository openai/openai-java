package com.openai.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.core.http.StreamResponse;
import com.openai.models.*;

public final class Main {
    private Main() {}

    public static void main(String[] args) {
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();
        ChatCompletionCreateParams completionCreateParams = ChatCompletionCreateParams.builder()
                .model(ChatModel.GPT_3_5_TURBO)
                .maxTokens(1024)
                .addMessage(ChatCompletionMessageParam.ofChatCompletionUserMessageParam(
                        ChatCompletionUserMessageParam.builder()
                                .content(ChatCompletionUserMessageParam.Content.ofTextContent(
                                        "Tell me a story about building the best SDK!"))
                                .build()))
                .build();

        // Non-streaming example
        client.chat().completions().create(completionCreateParams).choices().stream()
                .flatMap(choice -> choice.message().content().stream())
                .forEach(System.out::println);

        System.out.println("\n-----------------------------------\n");

        // Streaming example
        try (StreamResponse<ChatCompletionChunk> messageStreamResponse =
                client.chat().completions().createStreaming(completionCreateParams)) {
            messageStreamResponse.stream()
                    .flatMap(completion -> completion.choices().stream())
                    .flatMap(choice -> choice.delta().content().stream())
                    .forEach(System.out::print);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
