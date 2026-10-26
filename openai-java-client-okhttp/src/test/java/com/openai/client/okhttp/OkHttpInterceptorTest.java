package com.openai.client.okhttp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import com.openai.client.OpenAIClient;
import com.openai.client.OpenAIClientAsync;
import com.openai.core.RequestOptions;
import com.openai.core.http.Headers;
import com.openai.core.http.HttpMethod;
import com.openai.core.http.HttpRequest;
import com.openai.core.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

class OkHttpInterceptorTest {
    @TestFactory
    Stream<DynamicTest> applicationInterceptorsRunInOrderForEachSdkRetry() {
        return Stream.of(false, true)
                .map(async -> dynamicTest("async=" + async, () -> {
                    List<String> events = Collections.synchronizedList(new ArrayList<>());
                    Interceptor first = chain -> {
                        events.add("first request");
                        Response response = chain.proceed(chain.request()
                                .newBuilder()
                                .header("X-Application", "first")
                                .build());
                        events.add("first response");
                        assertThat(response.header("X-Response")).isEqualTo("second");
                        return response.newBuilder()
                                .header("X-Response", "first")
                                .build();
                    };
                    Interceptor second = chain -> {
                        events.add("second request");
                        assertThat(chain.request().header("X-Application")).isEqualTo("first");
                        Response response = chain.proceed(chain.request()
                                .newBuilder()
                                .header("X-Application", "second")
                                .build());
                        events.add("second response");
                        return response.newBuilder()
                                .header("X-Response", "second")
                                .build();
                    };
                    try (MockWebServer server = new MockWebServer()) {
                        server.enqueue(new MockResponse().setResponseCode(500).setHeader("retry-after-ms", "1"));
                        server.enqueue(modelsResponse());
                        Headers headers = request(async, server.url("/").toString(), Arrays.asList(first, second));
                        assertThat(headers.values("X-Response")).containsExactly("first");
                        for (int i = 0; i < 2; i++) {
                            RecordedRequest recorded = server.takeRequest(5, TimeUnit.SECONDS);
                            assertThat(recorded).isNotNull();
                            assertThat(recorded.getHeader("X-Application")).isEqualTo("second");
                            assertThat(recorded.getHeader("Authorization")).isEqualTo("Bearer fake-api-key");
                        }
                        assertThat(events)
                                .containsExactly(
                                        "first request",
                                        "second request",
                                        "second response",
                                        "first response",
                                        "first request",
                                        "second request",
                                        "second response",
                                        "first response");
                    }
                }));
    }

    @TestFactory
    Stream<DynamicTest> applicationInterceptorsPreserveCrossOriginRedirectCredentialProtection() {
        return Stream.of(false, true)
                .map(async -> dynamicTest("async=" + async, () -> {
                    List<String> invocations = Collections.synchronizedList(new ArrayList<>());
                    Interceptor interceptor = chain -> {
                        invocations.add(chain.request().url().toString());
                        return chain.proceed(chain.request()
                                .newBuilder()
                                .header("api-key", "fake-azure-key")
                                .header("X-Application", "example")
                                .build());
                    };
                    try (MockWebServer origin = new MockWebServer();
                            MockWebServer destination = new MockWebServer()) {
                        destination.enqueue(modelsResponse());
                        origin.enqueue(new MockResponse()
                                .setResponseCode(302)
                                .setHeader("Location", destination.url("/models")));
                        request(async, origin.url("/").toString(), Collections.singletonList(interceptor));
                        RecordedRequest initial = origin.takeRequest(5, TimeUnit.SECONDS);
                        RecordedRequest redirected = destination.takeRequest(5, TimeUnit.SECONDS);
                        assertThat(initial).isNotNull();
                        assertThat(redirected).isNotNull();
                        assertThat(initial.getHeader("Authorization")).isEqualTo("Bearer fake-api-key");
                        assertThat(initial.getHeader("api-key")).isEqualTo("fake-azure-key");
                        assertThat(redirected.getHeader("Authorization")).isNull();
                        assertThat(redirected.getHeader("api-key")).isNull();
                        assertThat(redirected.getHeader("X-Application")).isEqualTo("example");
                        assertThat(invocations).hasSize(1);
                    }
                }));
    }

    @Test
    void syncBuilderChangesDoNotChangeExistingClients() throws Exception {
        try (MockWebServer server = new MockWebServer()) {
            server.enqueue(modelsResponse());
            server.enqueue(modelsResponse());
            OpenAIOkHttpClient.Builder builder = OpenAIOkHttpClient.builder()
                    .apiKey("fake-api-key")
                    .baseUrl(server.url("/").toString())
                    .addInterceptor(marker("first"));
            OpenAIClient first = builder.build();
            OpenAIClient second = builder.addInterceptor(marker("second")).build();
            try {
                assertThat(headers(first).values("X-Marker")).containsExactly("first");
                assertThat(headers(second).values("X-Marker")).containsExactly("second", "first");
            } finally {
                first.close();
                second.close();
            }
        }
    }

    @Test
    void asyncBuilderChangesDoNotChangeExistingClients() throws Exception {
        try (MockWebServer server = new MockWebServer()) {
            server.enqueue(modelsResponse());
            server.enqueue(modelsResponse());
            OpenAIOkHttpClientAsync.Builder builder = OpenAIOkHttpClientAsync.builder()
                    .apiKey("fake-api-key")
                    .baseUrl(server.url("/").toString())
                    .addInterceptor(marker("first"));
            OpenAIClientAsync first = builder.build();
            OpenAIClientAsync second = builder.addInterceptor(marker("second")).build();
            try {
                assertThat(headers(first).values("X-Marker")).containsExactly("first");
                assertThat(headers(second).values("X-Marker")).containsExactly("second", "first");
            } finally {
                first.close();
                second.close();
            }
        }
    }

    @Test
    void transportBuilderChangesDoNotChangeExistingClients() throws Exception {
        try (MockWebServer server = new MockWebServer()) {
            server.enqueue(modelsResponse());
            server.enqueue(modelsResponse());
            OkHttpClient.Builder builder = OkHttpClient.builder().addInterceptor(marker("first"));
            HttpRequest request = HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(server.url("/").toString())
                    .build();
            try (OkHttpClient first = builder.build();
                    OkHttpClient second =
                            builder.addInterceptor(marker("second")).build();
                    HttpResponse firstResponse = first.execute(request, RequestOptions.none());
                    HttpResponse secondResponse = second.execute(request, RequestOptions.none())) {
                assertThat(firstResponse.headers().values("X-Marker")).containsExactly("first");
                assertThat(secondResponse.headers().values("X-Marker")).containsExactly("second", "first");
            }
        }
    }

    private static Interceptor marker(String value) {
        return chain -> chain.proceed(chain.request())
                .newBuilder()
                .addHeader("X-Marker", value)
                .build();
    }

    private static Headers request(boolean async, String baseUrl, List<Interceptor> interceptors) throws Exception {
        if (async) {
            OpenAIOkHttpClientAsync.Builder builder = OpenAIOkHttpClientAsync.builder()
                    .apiKey("fake-api-key")
                    .baseUrl(baseUrl)
                    .maxRetries(1);
            interceptors.forEach(builder::addInterceptor);
            OpenAIClientAsync client = builder.build();
            try {
                return headers(client);
            } finally {
                client.close();
            }
        }
        OpenAIOkHttpClient.Builder builder = OpenAIOkHttpClient.builder()
                .apiKey("fake-api-key")
                .baseUrl(baseUrl)
                .maxRetries(1);
        interceptors.forEach(builder::addInterceptor);
        OpenAIClient client = builder.build();
        try {
            return headers(client);
        } finally {
            client.close();
        }
    }

    private static Headers headers(OpenAIClient client) {
        try (HttpResponse response = client.withRawResponse().models().list()) {
            assertThat(response.statusCode()).isEqualTo(200);
            return response.headers();
        }
    }

    private static Headers headers(OpenAIClientAsync client) throws Exception {
        try (HttpResponse response = client.withRawResponse().models().list().get(5, TimeUnit.SECONDS)) {
            assertThat(response.statusCode()).isEqualTo(200);
            return response.headers();
        }
    }

    private static MockResponse modelsResponse() {
        return new MockResponse()
                .setHeader("Content-Type", "application/json")
                .setBody("{\"object\":\"list\",\"data\":[]}");
    }
}
