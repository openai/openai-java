package com.openai.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.core.http.HttpMethod;
import com.openai.core.http.HttpResponse;
import com.openai.helpers.CustomRequests;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public final class CustomRequestsExample {
    private CustomRequestsExample() {}

    public static void main(String[] args) {
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();
        try {
            CustomRequests custom = CustomRequests.from(client);
            // Use the known /models endpoint for this example. Custom API paths use the same helper.
            CustomRequests.Request request = CustomRequests.Request.builder()
                    .method(HttpMethod.GET)
                    .path("/models")
                    .build();
            try (HttpResponse response = custom.execute(request)) {
                new BufferedReader(new InputStreamReader(response.body(), StandardCharsets.UTF_8))
                        .lines()
                        .forEach(System.out::println);
            }
        } finally {
            client.close();
        }
    }
}
