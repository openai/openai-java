package com.openai.compatibility;

import com.openai.compatibility.HttpOkHttpRuntimeProbe.LocalServer;
import com.openai.responses.OpenAIResponsesClient;
import com.openai.responses.okhttp.OpenAIResponsesOkHttpClient;
import java.io.IOException;
import java.net.Proxy;

public final class ResponsesRuntimeProbe {
    private ResponsesRuntimeProbe() {}

    public static void main(String[] args) throws IOException {
        RuntimeProbe.requireNoFullClient();

        String json = "{\"object\":\"response.input_tokens\",\"input_tokens\":13}";
        try (LocalServer server = new LocalServer("POST", "/v1/responses/input_tokens", json);
                OpenAIResponsesClient client = OpenAIResponsesOkHttpClient.builder()
                        .apiKey("runtime-probe")
                        .baseUrl(server.baseUrl() + "/v1")
                        .proxy(Proxy.NO_PROXY)
                        .maxRetries(0)
                        .build()) {
            if (client.responses().inputTokens().count().inputTokensOrThrow() != 13) {
                throw new IllegalStateException("Responses OkHttp client returned the wrong token count");
            }
        }

        System.out.printf("Exercised openai-java-responses on Java %s.%n", System.getProperty("java.version"));
    }
}
