package com.openai.example;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.helpers.ChatCompletionToolRunner;
import com.openai.models.chat.completions.ChatCompletionCreateParams;
import java.util.Collections;

public final class ChatCompletionToolRunnerExample {
    private ChatCompletionToolRunnerExample() {}

    @JsonClassDescription("Looks up a product price in the example catalog.")
    public static class LookupPrice {
        public String product;
    }

    public static void main(String[] args) {
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();
        try {
            ChatCompletionToolRunner runner = ChatCompletionToolRunner.builder()
                    .client(client)
                    .maxTurns(8)
                    .addTool(LookupPrice.class, query -> {
                        // Validate model-supplied arguments before accessing application resources.
                        if (!"blue notebook".equalsIgnoreCase(query.product)) {
                            return Collections.singletonMap("error", "Unknown product");
                        }
                        return Collections.singletonMap("price_usd", 5);
                    })
                    .build();
            ChatCompletionToolRunner.Result result = runner.run(ChatCompletionCreateParams.builder()
                    .model("gpt-4.1")
                    .addUserMessage("What does the blue notebook cost?")
                    .build());
            result.completion().choices().get(0).message().content().ifPresent(System.out::println);
        } finally {
            client.close();
        }
    }
}
