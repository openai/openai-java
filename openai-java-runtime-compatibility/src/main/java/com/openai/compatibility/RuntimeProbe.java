package com.openai.compatibility;

import com.openai.core.JsonValue;
import java.util.Collections;
import java.util.Map;

public final class RuntimeProbe {
    private RuntimeProbe() {}

    public static void main(String[] args) {
        requireNoFullClient();
        requireNoOkHttp();
        requireAbsent("com.openai.responses.OpenAIResponsesClient");

        Map<String, String> input = Collections.singletonMap("probe", "runtime");
        if (!input.equals(JsonValue.from(input).convert(Map.class))) {
            throw new IllegalStateException("Runtime JSON round trip failed");
        }

        System.out.printf("Exercised openai-java-runtime on Java %s.%n", System.getProperty("java.version"));
    }

    static void requireNoFullClient() {
        requireAbsent("com.openai.client.OpenAIClient");
        requireAbsent("com.openai.client.okhttp.OpenAIOkHttpClient");
        requireAbsent("com.openai.client.okhttp.OkHttpClient");
        requireAbsent("com.openai.client.okhttp.X509WorkloadIdentity");
        requireAbsent("com.openai.services.blocking.ResponseService");
        requireAbsent("com.openai.services.async.ResponseServiceAsync");
        requireAbsent("com.openai.helpers.ResponseAccumulator");
        requireAbsent("com.openai.models.chat.completions.ChatCompletion");
    }

    static void requireNoOkHttp() {
        requireAbsent("com.openai.http.okhttp.OkHttpClient");
        requireAbsent("com.openai.responses.okhttp.OpenAIResponsesOkHttpClient");
        requireAbsent("okhttp3.OkHttpClient");
    }

    static void requireAbsent(String className) {
        if (RuntimeProbe.class.getResource("/" + className.replace('.', '/') + ".class") != null) {
            throw new IllegalStateException("Unexpected class on isolated runtime classpath: " + className);
        }
    }
}
