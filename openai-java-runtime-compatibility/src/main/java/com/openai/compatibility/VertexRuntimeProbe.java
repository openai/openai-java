package com.openai.compatibility;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.VertexOpenAIOkHttpClient;

public final class VertexRuntimeProbe {
    private VertexRuntimeProbe() {}

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.google.auth.oauth2.GoogleCredentials");
        OpenAIClient client = VertexOpenAIOkHttpClient.builder()
                .projectId("runtime-probe")
                .location("global")
                .tokenProvider(() -> "runtime-probe")
                .build();
        try {
            if (client.responses() == null) {
                throw new IllegalStateException("Vertex client did not create its response service");
            }
        } finally {
            client.close();
        }

        System.out.printf("Exercised openai-java-vertex on Java %s.%n", System.getProperty("java.version"));
    }
}
