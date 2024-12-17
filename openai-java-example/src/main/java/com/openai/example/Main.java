package com.openai.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.core.http.StreamResponse;
import com.openai.models.*;

public final class Main {
    private Main() {}

    public static void main(String[] args) {
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();
        CompletionCreateParams completionCreateParams = CompletionCreateParams.builder()
                .model(CompletionCreateParams.Model.GPT_3_5_TURBO_INSTRUCT)
                .maxTokens(1024)
                .prompt("Tell me a story about building the best SDK!")
                .build();

        // Non-streaming example
        client.completions().create(completionCreateParams).choices()
                .forEach(choice -> System.out.println(choice.text()));

        System.out.println("\n-----------------------------------\n");

        // Streaming example
        try (StreamResponse<Completion> messageStreamResponse = client.completions().createStreaming(completionCreateParams)) {
            messageStreamResponse.stream()
                    .flatMap(completion -> completion.choices().stream())
                    .forEach(choice -> System.out.print(choice.text()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
