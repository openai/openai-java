package com.openai.client.okhttp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import com.openai.client.OpenAIClient;
import com.openai.client.OpenAIClientAsync;
import com.openai.core.RequestOptions;
import com.openai.core.Timeout;
import com.openai.core.http.Headers;
import com.openai.core.http.HttpResponse;
import java.net.InetAddress;
import java.net.Proxy;
import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.io.TempDir;

class OkHttpConfigurationTest {
    @TempDir
    Path temporaryDirectory;

    @TestFactory
    Stream<DynamicTest> nativeConfigurationAndResourcesSurviveSdkClose() {
        return Stream.of(false, true)
                .map(async -> dynamicTest("async=" + async, () -> {
                    List<String> events = Collections.synchronizedList(new ArrayList<>());
                    AtomicInteger dnsCalls = new AtomicInteger();
                    AtomicInteger starts = new AtomicInteger();
                    try (MockWebServer server = new MockWebServer();
                            Cache cache = new Cache(
                                    temporaryDirectory.resolve("cache-" + async).toFile(), 1024 * 1024)) {
                        server.enqueue(modelsResponse());
                        server.enqueue(modelsResponse());
                        okhttp3.OkHttpClient nativeClient = new okhttp3.OkHttpClient.Builder()
                                .cache(cache)
                                .dns(host -> {
                                    assertThat(host).isEqualTo("sdk.test");
                                    dnsCalls.incrementAndGet();
                                    return Collections.singletonList(InetAddress.getByName("127.0.0.1"));
                                })
                                .eventListener(new EventListener() {
                                    @Override
                                    public void callStart(Call call) {
                                        starts.incrementAndGet();
                                    }
                                })
                                .addInterceptor(chain -> {
                                    events.add("native");
                                    return chain.proceed(chain.request());
                                })
                                .build();
                        nativeClient.dispatcher().setMaxRequests(7);
                        nativeClient.dispatcher().setMaxRequestsPerHost(2);
                        try {
                            String baseUrl = server.url("/")
                                    .newBuilder()
                                    .host("sdk.test")
                                    .build()
                                    .toString();
                            request(async, nativeClient, baseUrl, null, RequestOptions.none(), chain -> {
                                events.add("sdk");
                                return chain.proceed(chain.request());
                            });
                            assertThat(events).containsExactly("native", "sdk");
                            assertThat(dnsCalls).hasValue(1);
                            assertThat(starts).hasValue(1);
                            assertThat(nativeClient.dispatcher().getMaxRequests())
                                    .isEqualTo(7);
                            assertThat(nativeClient.dispatcher().getMaxRequestsPerHost())
                                    .isEqualTo(2);
                            assertThat(nativeClient
                                            .dispatcher()
                                            .executorService()
                                            .isShutdown())
                                    .isFalse();
                            assertThat(nativeClient.connectionPool().idleConnectionCount())
                                    .isEqualTo(1);
                            assertThat(cache.isClosed()).isFalse();
                            assertThat(nativeClient.interceptors()).hasSize(1);
                            assertThat(nativeClient.networkInterceptors()).isEmpty();
                            assertThat(nativeClient.retryOnConnectionFailure()).isTrue();
                            // The caller can still use the same client after SDK close, including its cache.
                            try (Response response = nativeClient
                                    .newCall(new Request.Builder().url(baseUrl).build())
                                    .execute()) {
                                assertThat(response.code()).isEqualTo(200);
                                response.body().string();
                            }
                            assertThat(starts).hasValue(2);
                        } finally {
                            release(nativeClient);
                        }
                    }
                }));
    }

    @TestFactory
    Stream<DynamicTest> timeoutPrecedence() {
        return Stream.of(false, true)
                .map(async -> dynamicTest("async=" + async, () -> {
                    okhttp3.OkHttpClient nativeClient = new okhttp3.OkHttpClient.Builder()
                            .connectTimeout(Duration.ofSeconds(11))
                            .readTimeout(Duration.ofSeconds(12))
                            .writeTimeout(Duration.ofSeconds(13))
                            .callTimeout(Duration.ofSeconds(14))
                            .addInterceptor(chain -> new Response.Builder()
                                    .request(chain.request())
                                    .protocol(okhttp3.Protocol.HTTP_1_1)
                                    .code(200)
                                    .message("OK")
                                    .body(okhttp3.ResponseBody.create("", okhttp3.MediaType.get("application/json")))
                                    .header(
                                            "timeouts",
                                            chain.connectTimeoutMillis() + "," + chain.readTimeoutMillis() + ","
                                                    + chain.writeTimeoutMillis() + ","
                                                    + chain.call().timeout().timeoutNanos())
                                    .build())
                            .build();
                    try {
                        assertThat(request(async, nativeClient, "http://localhost/", null, RequestOptions.none(), null)
                                        .values("timeouts"))
                                .containsExactly("11000,12000,13000,14000000000");
                        Timeout sdk = Timeout.builder()
                                .connect(Duration.ofSeconds(21))
                                .read(Duration.ofSeconds(22))
                                .write(Duration.ofSeconds(23))
                                .request(Duration.ofSeconds(24))
                                .build();
                        assertThat(request(async, nativeClient, "http://localhost/", sdk, RequestOptions.none(), null)
                                        .values("timeouts"))
                                .containsExactly("21000,22000,23000,24000000000");
                        RequestOptions perRequest = RequestOptions.builder()
                                .timeout(Timeout.builder()
                                        .read(Duration.ofSeconds(32))
                                        .build())
                                .build();
                        assertThat(request(async, nativeClient, "http://localhost/", sdk, perRequest, null)
                                        .values("timeouts"))
                                .containsExactly("21000,32000,23000,24000000000");
                    } finally {
                        release(nativeClient);
                    }
                }));
    }

    @Test
    void customDispatcherLimitsAsyncConcurrency() throws Exception {
        CountDownLatch entered = new CountDownLatch(1);
        CountDownLatch proceed = new CountDownLatch(1);
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(4);
        dispatcher.setMaxRequestsPerHost(1);
        okhttp3.OkHttpClient nativeClient = new okhttp3.OkHttpClient.Builder()
                .dispatcher(dispatcher)
                .addInterceptor(chain -> {
                    entered.countDown();
                    try {
                        if (!proceed.await(15, TimeUnit.SECONDS)) throw new java.io.IOException("test timed out");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new java.io.IOException(e);
                    }
                    return chain.proceed(chain.request());
                })
                .build();
        try (MockWebServer server = new MockWebServer()) {
            server.enqueue(modelsResponse());
            server.enqueue(modelsResponse());
            OpenAIClientAsync client = OpenAIOkHttpClientAsync.builder()
                    .apiKey("fake-api-key")
                    .baseUrl(server.url("/").toString())
                    .okHttpClient(nativeClient)
                    .maxRetries(0)
                    .build();
            try {
                var first = client.models().list();
                assertThat(entered.await(5, TimeUnit.SECONDS)).isTrue();
                var second = client.models().list();
                // The SDK submits requests asynchronously; wait until the second reaches OkHttp.
                long deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(5);
                while (dispatcher.queuedCallsCount() == 0 && !second.isDone() && System.nanoTime() < deadline) {
                    Thread.sleep(1);
                }
                assertThat(dispatcher.runningCallsCount()).isEqualTo(1);
                assertThat(dispatcher.queuedCallsCount()).isEqualTo(1);
                proceed.countDown();
                first.get(5, TimeUnit.SECONDS);
                second.get(5, TimeUnit.SECONDS);
            } finally {
                proceed.countDown();
                client.close();
            }
        } finally {
            release(nativeClient);
        }
    }

    @TestFactory
    Stream<DynamicTest> nativeNetworkInterceptorsRetainRedirectProtectionAndSdkRetries() {
        return Stream.of(false, true)
                .map(async -> dynamicTest("async=" + async, () -> {
                    AtomicInteger attempts = new AtomicInteger();
                    okhttp3.OkHttpClient nativeClient = new okhttp3.OkHttpClient.Builder()
                            .addInterceptor(chain -> {
                                attempts.incrementAndGet();
                                return chain.proceed(chain.request());
                            })
                            .addNetworkInterceptor(chain -> chain.proceed(chain.request()
                                    .newBuilder()
                                    .header("api-key", "fake-azure-key")
                                    .header("Authorization", "Bearer fake-hook-key")
                                    .build()))
                            .build();
                    try (MockWebServer origin = new MockWebServer();
                            MockWebServer destination = new MockWebServer()) {
                        origin.enqueue(new MockResponse().setResponseCode(500).setHeader("retry-after-ms", "1"));
                        origin.enqueue(new MockResponse()
                                .setResponseCode(302)
                                .setHeader("Location", destination.url("/models")));
                        destination.enqueue(modelsResponse());
                        request(async, nativeClient, origin.url("/").toString(), null, RequestOptions.none(), null);
                        assertThat(attempts).hasValue(2);
                        for (int i = 0; i < 2; i++) {
                            RecordedRequest initial = origin.takeRequest(5, TimeUnit.SECONDS);
                            assertThat(initial.getHeader("api-key")).isEqualTo("fake-azure-key");
                            assertThat(initial.getHeader("Authorization")).isEqualTo("Bearer fake-hook-key");
                        }
                        RecordedRequest redirected = destination.takeRequest(5, TimeUnit.SECONDS);
                        assertThat(redirected.getHeader("api-key")).isNull();
                        assertThat(redirected.getHeader("Authorization")).isNull();
                    } finally {
                        release(nativeClient);
                    }
                }));
    }

    @TestFactory
    Stream<DynamicTest> applicationUrlRewriteStripsCredentials() {
        return Stream.of(false, true)
                .map(async -> dynamicTest("async=" + async, () -> {
                    try (MockWebServer origin = new MockWebServer();
                            MockWebServer destination = new MockWebServer()) {
                        destination.enqueue(modelsResponse());
                        okhttp3.OkHttpClient nativeClient = new okhttp3.OkHttpClient.Builder()
                                .addInterceptor(chain -> chain.proceed(chain.request()
                                        .newBuilder()
                                        .url(destination.url("/models"))
                                        .build()))
                                .build();
                        try {
                            if (async) {
                                OpenAIClientAsync client = OpenAIOkHttpClientAsync.builder()
                                        .apiKey("fake-api-key")
                                        .putHeader("api-key", "fake-azure-key")
                                        .baseUrl(origin.url("/").toString())
                                        .okHttpClient(nativeClient)
                                        .build();
                                try {
                                    client.models().list().get(5, TimeUnit.SECONDS);
                                } finally {
                                    client.close();
                                }
                            } else {
                                OpenAIClient client = OpenAIOkHttpClient.builder()
                                        .apiKey("fake-api-key")
                                        .putHeader("api-key", "fake-azure-key")
                                        .baseUrl(origin.url("/").toString())
                                        .okHttpClient(nativeClient)
                                        .build();
                                try {
                                    client.models().list();
                                } finally {
                                    client.close();
                                }
                            }
                            RecordedRequest rewritten = destination.takeRequest(5, TimeUnit.SECONDS);
                            assertThat(rewritten.getHeader("Authorization")).isNull();
                            assertThat(rewritten.getHeader("api-key")).isNull();
                            assertThat(origin.getRequestCount()).isZero();
                        } finally {
                            release(nativeClient);
                        }
                    }
                }));
    }

    @TestFactory
    Stream<DynamicTest> borrowedWebSocketConfigurationIsCheckedAtConnect() {
        return Stream.of("default", "network", "authenticator", "proxyAuthenticator")
                .map(setting -> dynamicTest(setting, () -> {
                    okhttp3.OkHttpClient.Builder nativeBuilder = new okhttp3.OkHttpClient.Builder();
                    if (setting.equals("network"))
                        nativeBuilder.addNetworkInterceptor(chain -> chain.proceed(chain.request()));
                    if (setting.equals("authenticator")) nativeBuilder.authenticator((route, response) -> null);
                    if (setting.equals("proxyAuthenticator"))
                        nativeBuilder.proxyAuthenticator((route, response) -> null);
                    okhttp3.OkHttpClient nativeClient = nativeBuilder.build();
                    try (MockWebServer server = new MockWebServer()) {
                        server.enqueue(new MockResponse().withWebSocketUpgrade(new okhttp3.WebSocketListener() {
                            @Override
                            public void onClosing(okhttp3.WebSocket socket, int code, String reason) {
                                socket.close(code, reason);
                            }
                        }));
                        OpenAIClientAsync client = OpenAIOkHttpClientAsync.builder()
                                .apiKey("fake-api-key")
                                .baseUrl(server.url("/v1").toString())
                                .okHttpClient(nativeClient)
                                .addInterceptor(chain -> chain.proceed(chain.request()
                                        .newBuilder()
                                        .header("X-Application", "test")
                                        .build()))
                                .build();
                        try {
                            if (setting.equals("default")) {
                                try (var connection =
                                        client.responses().connect().get(5, TimeUnit.SECONDS)) {
                                    assertThat(server.takeRequest(5, TimeUnit.SECONDS)
                                                    .getHeader("X-Application"))
                                            .isEqualTo("test");
                                }
                            } else {
                                assertThatThrownBy(() ->
                                                client.responses().connect().get(5, TimeUnit.SECONDS))
                                        .hasRootCauseInstanceOf(IllegalArgumentException.class)
                                        .hasMessageContaining("WebSockets do not support OkHttp");
                                assertThat(server.getRequestCount()).isZero();
                            }
                        } finally {
                            client.close();
                        }
                    } finally {
                        release(nativeClient);
                    }
                }));
    }

    @Test
    void rejectsConflictingTransportSettingsInEitherOrder() {
        okhttp3.OkHttpClient nativeClient = new okhttp3.OkHttpClient();
        try {
            assertThatThrownBy(() -> OpenAIOkHttpClient.builder()
                            .apiKey("fake-api-key")
                            .proxy(Proxy.NO_PROXY)
                            .okHttpClient(nativeClient)
                            .build())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("supplied okHttpClient");
            assertThatThrownBy(() -> OpenAIOkHttpClientAsync.builder()
                            .apiKey("fake-api-key")
                            .okHttpClient(nativeClient)
                            .proxy(Proxy.NO_PROXY)
                            .build())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("supplied okHttpClient");
            assertThatThrownBy(() -> OpenAIOkHttpClient.builder()
                            .apiKey("fake-api-key")
                            .okHttpClient(nativeClient)
                            .followRedirects(true)
                            .build())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("supplied okHttpClient");
        } finally {
            release(nativeClient);
        }
    }

    @Test
    void closingOneSdkClientLeavesAnotherUsable() throws Exception {
        okhttp3.OkHttpClient nativeClient = new okhttp3.OkHttpClient();
        try (MockWebServer server = new MockWebServer()) {
            server.enqueue(modelsResponse());
            OpenAIOkHttpClient.Builder builder = OpenAIOkHttpClient.builder()
                    .apiKey("fake-api-key")
                    .baseUrl(server.url("/").toString())
                    .okHttpClient(nativeClient)
                    .maxRetries(0);
            OpenAIClient first = builder.build();
            OpenAIClient second = builder.build();
            first.close();
            try {
                assertThatThrownBy(() -> first.models().list()).isInstanceOf(IllegalStateException.class);
                assertThat(second.models().list().data()).isEmpty();
            } finally {
                second.close();
            }
        } finally {
            release(nativeClient);
        }
    }

    @TestFactory
    Stream<DynamicTest> preservesNativeRedirectPolicy() {
        return Stream.of(false, true)
                .map(async -> dynamicTest("async=" + async, () -> {
                    okhttp3.OkHttpClient nativeClient = new okhttp3.OkHttpClient.Builder()
                            .followRedirects(false)
                            .build();
                    try (MockWebServer origin = new MockWebServer();
                            MockWebServer destination = new MockWebServer()) {
                        origin.enqueue(new MockResponse()
                                .setResponseCode(302)
                                .setHeader("Location", destination.url("/models")));
                        if (async) {
                            OpenAIClientAsync client = OpenAIOkHttpClientAsync.builder()
                                    .apiKey("fake-api-key")
                                    .baseUrl(origin.url("/").toString())
                                    .okHttpClient(nativeClient)
                                    .build();
                            try {
                                assertThatThrownBy(() -> client.models().list().get(5, TimeUnit.SECONDS))
                                        .hasCauseInstanceOf(com.openai.errors.UnexpectedStatusCodeException.class)
                                        .hasMessageContaining("302");
                            } finally {
                                client.close();
                            }
                        } else {
                            OpenAIClient client = OpenAIOkHttpClient.builder()
                                    .apiKey("fake-api-key")
                                    .baseUrl(origin.url("/").toString())
                                    .okHttpClient(nativeClient)
                                    .build();
                            try {
                                assertThatThrownBy(() -> client.models().list())
                                        .isInstanceOf(com.openai.errors.UnexpectedStatusCodeException.class)
                                        .hasMessageContaining("302");
                            } finally {
                                client.close();
                            }
                        }
                        assertThat(destination.getRequestCount()).isZero();
                    } finally {
                        release(nativeClient);
                    }
                }));
    }

    @Test
    void sdkCreatedTransportStillOwnsItsExecutor() {
        var executor = java.util.concurrent.Executors.newSingleThreadExecutor();
        try {
            OpenAIClient client = OpenAIOkHttpClient.builder()
                    .apiKey("fake-api-key")
                    .dispatcherExecutorService(executor)
                    .build();
            client.close();
            assertThat(executor.isShutdown()).isTrue();
        } finally {
            executor.shutdownNow();
        }
    }

    private static Headers request(
            boolean async,
            okhttp3.OkHttpClient nativeClient,
            String baseUrl,
            Timeout timeout,
            RequestOptions options,
            Interceptor extra)
            throws Exception {
        if (async) {
            OpenAIOkHttpClientAsync.Builder builder = OpenAIOkHttpClientAsync.builder()
                    .apiKey("fake-api-key")
                    .baseUrl(baseUrl)
                    .maxRetries(1)
                    .okHttpClient(nativeClient);
            if (timeout != null) builder.timeout(timeout);
            if (extra != null) builder.addInterceptor(extra);
            OpenAIClientAsync client = builder.build();
            try (HttpResponse response =
                    client.withRawResponse().models().list(options).get(5, TimeUnit.SECONDS)) {
                assertThat(response.statusCode()).isEqualTo(200);
                response.body().readAllBytes();
                return response.headers();
            } finally {
                client.close();
            }
        }
        OpenAIOkHttpClient.Builder builder = OpenAIOkHttpClient.builder()
                .apiKey("fake-api-key")
                .baseUrl(baseUrl)
                .maxRetries(1);
        if (timeout != null) builder.timeout(timeout);
        builder.okHttpClient(nativeClient);
        if (extra != null) builder.addInterceptor(extra);
        OpenAIClient client = builder.build();
        try (HttpResponse response = client.withRawResponse().models().list(options)) {
            assertThat(response.statusCode()).isEqualTo(200);
            response.body().readAllBytes();
            return response.headers();
        } finally {
            client.close();
        }
    }

    private static MockResponse modelsResponse() {
        return new MockResponse()
                .setHeader("Content-Type", "application/json")
                .setBody("{\"object\":\"list\",\"data\":[]}");
    }

    private static void release(okhttp3.OkHttpClient client) {
        client.dispatcher().executorService().shutdown();
        client.connectionPool().evictAll();
    }
}
