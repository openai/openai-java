package com.openai.compatibility;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public final class OkHttpRuntimeProbe {
    private OkHttpRuntimeProbe() {}

    public static void main(String[] args) throws Exception {
        if (OkHttpRuntimeProbe.class.getResource("/com/google/auth/oauth2/GoogleCredentials.class") != null) {
            throw new IllegalStateException("Google authentication must remain in the optional Vertex artifact");
        }
        HttpServer server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        server.createContext("/v1/models", exchange -> {
            byte[] body = ("{\"object\":\"list\",\"data\":[{\"id\":\"probe\",\"object\":\"model\","
                            + "\"created\":1,\"owned_by\":\"fixture\"}]}")
                    .getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, body.length);
            try (OutputStream output = exchange.getResponseBody()) {
                output.write(body);
            }
        });
        server.start();
        try {
            exerciseClient("http://127.0.0.1:" + server.getAddress().getPort() + "/v1");
        } finally {
            server.stop(0);
        }

        ResponseStreamEvolutionProbe.main(args);
        System.out.printf("Exercised an OkHttp SDK client on Java %s.%n", System.getProperty("java.version"));
    }

    private static void exerciseClient(String baseUrl) throws Exception {
        OpenAIClient client = OpenAIOkHttpClient.builder()
                .apiKey("runtime-probe")
                .timeout(Duration.ofSeconds(10))
                .maxRetries(0)
                .baseUrl(baseUrl)
                .build();
        try {
            String syncId = client.models().list().dataOrThrow().get(0).idOrThrow();
            String asyncId = client.async()
                    .models()
                    .list()
                    .get(10, TimeUnit.SECONDS)
                    .dataOrThrow()
                    .get(0)
                    .idOrThrow();
            if (!"probe".equals(syncId) || !"probe".equals(asyncId)) {
                throw new IllegalStateException("Unexpected model from loopback transport");
            }
        } finally {
            client.close();
        }
    }
}
