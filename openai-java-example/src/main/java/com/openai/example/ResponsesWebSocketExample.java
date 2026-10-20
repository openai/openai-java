package com.openai.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.core.http.ResponseConnection;
import com.openai.models.responses.Response;
import com.openai.models.responses.ResponsesClientEvent;

/** Run with: ./gradlew :openai-java-example:run -Pexample=ResponsesWebSocket */
public final class ResponsesWebSocketExample {
    private ResponsesWebSocketExample() {}

    public static void main(String[] args) {
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();
        try (ResponseConnection connection = client.responses().connect()) {
            connection.send(ResponsesClientEvent.ofResponseCreate(ResponsesClientEvent.ResponseCreate.builder()
                    .model("gpt-4o-mini")
                    .store(false)
                    .input("Say hello in one short sentence.")
                    .build()));
            Response first = connection.finalResponse();
            System.out.println("First response: " + first.status());

            // Continue on the same socket; the service can use its in-connection cache.
            connection.send(ResponsesClientEvent.ofResponseCreate(ResponsesClientEvent.ResponseCreate.builder()
                    .model("gpt-4o-mini")
                    .store(false)
                    .previousResponseId(first.id())
                    .input("Now say goodbye in one short sentence.")
                    .build()));
            Response second = connection.finalResponse();
            System.out.println("Second response: " + second.status());
        } finally {
            client.close();
        }
    }
}
