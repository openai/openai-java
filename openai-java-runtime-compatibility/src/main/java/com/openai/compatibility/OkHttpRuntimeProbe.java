package com.openai.compatibility;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;

public final class OkHttpRuntimeProbe {
    private OkHttpRuntimeProbe() {}

    public static void main(String[] args) {
        OpenAIClient client =
                OpenAIOkHttpClient.builder().apiKey("runtime-probe").build();
        try {
            if (client.models() == null) {
                throw new IllegalStateException("OkHttp client did not create its model service");
            }
        } finally {
            client.close();
        }

        System.out.printf("Exercised an OkHttp SDK client on Java %s.%n", System.getProperty("java.version"));
    }
}
