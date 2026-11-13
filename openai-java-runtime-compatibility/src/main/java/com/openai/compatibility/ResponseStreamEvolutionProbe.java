package com.openai.compatibility;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.core.JsonArray;
import com.openai.core.JsonObject;
import com.openai.core.JsonValue;
import com.openai.core.http.StreamResponse;
import com.openai.models.responses.ResponseCreateParams;
import com.openai.models.responses.ResponseStreamEvent;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class ResponseStreamEvolutionProbe {
    private ResponseStreamEvolutionProbe() {}

    public static void main(String[] args) throws IOException {
        if (ResponseStreamEvolutionProbe.class.getResource("/com/google/auth/oauth2/GoogleCredentials.class") != null) {
            throw new IllegalStateException("Google authentication must remain in the optional Vertex artifact");
        }
        HttpServer server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        String events = "data: {\"type\":\"response.future\",\"details\":[{\"key_name\":1,\"keyName\":2}]}\n\n"
                + "data: {\"type\":\"response.output_text.delta\",\"item_id\":\"m\",\"sequence_number\":1,"
                + "\"content_index\":0,\"output_index\":0,\"delta\":\"hello\",\"future_field\":true}\n\n"
                + "data: [DONE]\n\n";
        byte[] body = events.getBytes(StandardCharsets.UTF_8);
        server.createContext("/responses", exchange -> {
            try {
                exchange.getResponseHeaders().set("Content-Type", "text/event-stream");
                exchange.sendResponseHeaders(200, body.length);
                try (OutputStream output = exchange.getResponseBody()) {
                    output.write(body);
                }
            } finally {
                exchange.close();
            }
        });
        OpenAIClient client = OpenAIOkHttpClient.builder()
                .apiKey("runtime-probe")
                .baseUrl("http://127.0.0.1:" + server.getAddress().getPort())
                .build();
        try {
            server.start();
            if (client.models() == null) {
                throw new IllegalStateException("OkHttp client did not create its model service");
            }
            ResponseCreateParams params =
                    ResponseCreateParams.builder().model("test").input("test").build();
            try (StreamResponse<ResponseStreamEvent> response =
                    client.responses().createStreaming(params)) {
                List<String> received =
                        response.stream().map(ResponseStreamEvolutionProbe::readEvent).collect(Collectors.toList());
                if (!received.equals(Arrays.asList("response.future", "hello"))) {
                    throw new AssertionError("Unexpected event sequence: " + received);
                }
            }
        } finally {
            server.stop(0);
            client.close();
        }

        System.out.printf("Exercised an OkHttp SDK client on Java %s.%n", System.getProperty("java.version"));
    }

    private static String readEvent(ResponseStreamEvent event) {
        if (event.isOutputTextDelta()) {
            if (!JsonValue.from(true)
                    .equals(event.asOutputTextDelta()._allProperties().get("future_field"))) {
                throw new AssertionError("Known event lost its additional property");
            }
            return event.asOutputTextDelta()._delta().asStringOrThrow();
        }
        Map<String, JsonValue> raw = ((JsonObject) event._json().get()).values();
        JsonArray entries = (JsonArray) raw.get("details");
        Map<String, JsonValue> details = ((JsonObject) entries.values().get(0)).values();
        if (details.get("key_name").convert(Integer.class) != 1
                || details.get("keyName").convert(Integer.class) != 2) {
            throw new AssertionError("Unknown event lost distinct JSON keys");
        }
        return raw.get("type").asStringOrThrow();
    }
}
