package com.openai.compatibility;

import com.openai.core.ClientOptions;
import com.openai.core.JsonValue;
import com.openai.core.RequestOptions;
import com.openai.core.http.HttpClient;
import com.openai.core.http.HttpRequest;
import com.openai.core.http.HttpResponse;
import com.openai.models.chat.completions.ChatCompletionCreateParams;
import com.openai.models.chat.completions.StructuredChatCompletionCreateParams;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public final class CoreRuntimeProbe {
    private CoreRuntimeProbe() {}

    public static void main(String[] args) {
        Map<String, String> input = Collections.singletonMap("probe", "runtime");
        Map<?, ?> converted = JsonValue.from(input).convert(Map.class);

        if (converted == null || !"runtime".equals(converted.get("probe"))) {
            throw new IllegalStateException("Core JSON round trip failed");
        }

        StructuredChatCompletionCreateParams<RuntimeResponse> params = ChatCompletionCreateParams.builder()
                .addUserMessage("runtime probe")
                .model("runtime-probe")
                .responseFormat(RuntimeResponse.class)
                .build();
        if (!params.rawParams().responseFormat().isPresent()) {
            throw new IllegalStateException("Core structured-output schema generation failed");
        }

        verifyClientCleanup();

        System.out.printf("Exercised openai-java-core on Java %s.%n", System.getProperty("java.version"));
    }

    private static void verifyClientCleanup() {
        AtomicInteger closeCalls = new AtomicInteger();
        HttpClient transport = new HttpClient() {
            @Override
            public HttpResponse execute(HttpRequest request, RequestOptions options) {
                throw new AssertionError("Cleanup must not send requests");
            }

            @Override
            public CompletableFuture<HttpResponse> executeAsync(HttpRequest request, RequestOptions options) {
                throw new AssertionError("Cleanup must not send requests");
            }

            @Override
            public void close() {
                closeCalls.incrementAndGet();
            }
        };
        ClientOptions options =
                ClientOptions.builder().apiKey("test-key").httpClient(transport).build();
        if (closeCalls.get() != 0) {
            throw new IllegalStateException("Client construction closed its transport");
        }
        options.close();
        options.close();
        if (closeCalls.get() != 1) {
            throw new IllegalStateException("Client transport cleanup must run once");
        }
    }

    public static final class RuntimeResponse {
        public String value;
    }
}
