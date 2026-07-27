package com.openai.compatibility;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.BedrockOpenAIOkHttpClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.springboot.OpenAIClientAutoConfiguration;

public final class RuntimeCompatibilitySmokeTest {
    private RuntimeCompatibilitySmokeTest() {}

    public static void main(String[] args) {
        Class<?>[] publicEntryPoints = {
            OpenAIClient.class,
            OpenAIOkHttpClient.class,
            BedrockOpenAIOkHttpClient.class,
            OpenAIClientAutoConfiguration.class,
        };

        for (Class<?> entryPoint : publicEntryPoints) {
            entryPoint.getDeclaredMethods();
        }

        System.out.printf(
                "Loaded %d SDK entry points on Java %s.%n",
                publicEntryPoints.length, System.getProperty("java.version"));
    }
}
