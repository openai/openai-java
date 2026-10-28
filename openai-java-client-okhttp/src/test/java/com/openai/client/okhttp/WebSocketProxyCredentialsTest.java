package com.openai.client.okhttp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import okhttp3.WebSocketListener;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.SocketPolicy;
import okhttp3.tls.HandshakeCertificates;
import okhttp3.tls.HeldCertificate;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

class WebSocketProxyCredentialsTest {
    private static MockResponse upgrade() {
        return new MockResponse().withWebSocketUpgrade(new WebSocketListener() {
            @Override
            public void onClosing(okhttp3.WebSocket socket, int code, String reason) {
                socket.close(code, reason);
            }
        });
    }

    @Test
    void explicitDirectWebSocketDoesNotForwardPreemptiveProxyCredentials() throws Exception {
        try (var origin = new MockWebServer()) {
            origin.enqueue(upgrade());
            var transport =
                    new okhttp3.OkHttpClient.Builder().proxy(Proxy.NO_PROXY).build();
            try {
                var sdk = OpenAIOkHttpClientAsync.builder()
                        .apiKey("fixture-sdk-auth")
                        .baseUrl(origin.url("/v1/").toString())
                        .putHeader("Proxy-Authorization", "Basic Zml4dHVyZTpmaXh0dXJl")
                        .okHttpClient(transport)
                        .build();
                try (var socket = sdk.responses().connect().get(5, TimeUnit.SECONDS)) {
                    var received = origin.takeRequest(5, TimeUnit.SECONDS);
                    assertThat(received.getHeader("Authorization") != null)
                            .as("SDK auth at origin")
                            .isTrue();
                    assertThat(received.getHeader("Proxy-Authorization"))
                            .as("proxy auth at origin")
                            .isNull();
                } finally {
                    sdk.close();
                }
            } finally {
                transport.dispatcher().executorService().shutdown();
                transport.connectionPool().evictAll();
            }
        }
    }

    @Test
    void explicitPlaintextHttpProxyReceivesPreemptiveCredentials() throws Exception {
        try (var proxy = new MockWebServer()) {
            proxy.enqueue(upgrade());
            proxy.start();
            var transport = new okhttp3.OkHttpClient.Builder()
                    .proxy(proxy.toProxyAddress())
                    .build();
            try {
                var sdk = OpenAIOkHttpClientAsync.builder()
                        .apiKey("fixture-sdk-auth")
                        .baseUrl("http://api.proxy-fixture.invalid/v1/")
                        .putHeader("Proxy-Authorization", "Basic Zml4dHVyZTpmaXh0dXJl")
                        .okHttpClient(transport)
                        .build();
                try (var socket = sdk.responses().connect().get(5, TimeUnit.SECONDS)) {
                    var received = proxy.takeRequest(5, TimeUnit.SECONDS);
                    assertThat(received).isNotNull();
                    assertThat(received.getMethod()).isEqualTo("GET");
                    assertThat(received.getHeader("Proxy-Authorization"))
                            .as("preemptive credentials reach the selected HTTP proxy")
                            .isEqualTo("Basic Zml4dHVyZTpmaXh0dXJl");
                } finally {
                    sdk.close();
                }
            } finally {
                transport.dispatcher().executorService().shutdown();
                transport.connectionPool().evictAll();
            }
        }
    }

    @TestFactory
    Stream<DynamicTest> credentialFreePlaintextSelectorsKeepTheirNativeRoutes() {
        return Stream.of(false, true)
                .map(http -> dynamicTest("HTTP proxy=" + http, () -> {
                    try (var peer = new MockWebServer()) {
                        peer.enqueue(upgrade());
                        peer.start();
                        var transport = new okhttp3.OkHttpClient.Builder()
                                .proxySelector(new ProxySelector() {
                                    @Override
                                    public List<Proxy> select(URI uri) {
                                        return List.of(http ? peer.toProxyAddress() : Proxy.NO_PROXY);
                                    }

                                    @Override
                                    public void connectFailed(URI uri, SocketAddress address, IOException failure) {}
                                })
                                .build();
                        try {
                            var sdk = OpenAIOkHttpClientAsync.builder()
                                    .apiKey("fixture-sdk-auth")
                                    .baseUrl(
                                            http
                                                    ? "http://api.proxy-fixture.invalid/v1/"
                                                    : peer.url("/v1/").toString())
                                    .okHttpClient(transport)
                                    .build();
                            try (var connection = sdk.responses().connect().get(5, TimeUnit.SECONDS)) {
                                var received = peer.takeRequest(5, TimeUnit.SECONDS);
                                assertThat(received).isNotNull();
                                assertThat(received.getHeader("Proxy-Authorization"))
                                        .isNull();
                            } finally {
                                sdk.close();
                            }
                        } finally {
                            transport.dispatcher().executorService().shutdown();
                            transport.connectionPool().evictAll();
                        }
                    }
                }));
    }

    @Test
    void automaticallySelectedPlaintextHttpProxyReceivesPreemptiveCredentials() throws Exception {
        try (var proxy = new MockWebServer()) {
            proxy.enqueue(upgrade());
            proxy.start();
            var transport = new okhttp3.OkHttpClient.Builder()
                    .proxySelector(new ProxySelector() {
                        @Override
                        public List<Proxy> select(URI uri) {
                            return List.of(proxy.toProxyAddress(), Proxy.NO_PROXY);
                        }

                        @Override
                        public void connectFailed(URI uri, SocketAddress address, IOException failure) {}
                    })
                    .build();
            try {
                var sdk = OpenAIOkHttpClientAsync.builder()
                        .apiKey("fixture-sdk-auth")
                        .baseUrl("http://api.proxy-fixture.invalid/v1/")
                        .putHeader("Proxy-Authorization", "Basic Zml4dHVyZTpmaXh0dXJl")
                        .okHttpClient(transport)
                        .build();
                try (var socket = sdk.responses().connect().get(5, TimeUnit.SECONDS)) {
                    var received = proxy.takeRequest(5, TimeUnit.SECONDS);
                    assertThat(received).isNotNull();
                    assertThat(received.getHeader("Proxy-Authorization"))
                            .as("preemptive credentials reach the selected HTTP proxy")
                            .isEqualTo("Basic Zml4dHVyZTpmaXh0dXJl");
                } finally {
                    sdk.close();
                }
            } finally {
                transport.dispatcher().executorService().shutdown();
                transport.connectionPool().evictAll();
            }
        }
    }

    @Test
    void secondInterceptorProceedOmitsProxyCredentialsOnExplicitDirectConnection() throws Exception {
        try (var origin = new MockWebServer()) {
            origin.enqueue(new MockResponse().setBody("retry"));
            origin.enqueue(upgrade());
            var transport = new okhttp3.OkHttpClient.Builder()
                    .proxy(Proxy.NO_PROXY)
                    .addInterceptor(chain -> {
                        var first = chain.proceed(chain.request());
                        first.close();
                        return chain.proceed(chain.request()
                                .newBuilder()
                                .header("Proxy-Authorization", "Basic Zml4dHVyZTpmaXh0dXJl")
                                .build());
                    })
                    .build();
            try {
                var sdk = OpenAIOkHttpClientAsync.builder()
                        .apiKey("fixture-sdk-auth")
                        .baseUrl(origin.url("/v1/").toString())
                        .okHttpClient(transport)
                        .build();
                try (var socket = sdk.responses().connect().get(5, TimeUnit.SECONDS)) {
                    var first = origin.takeRequest(5, TimeUnit.SECONDS);
                    var second = origin.takeRequest(5, TimeUnit.SECONDS);
                    assertThat(first).isNotNull();
                    assertThat(second).isNotNull();
                    assertThat(first.getHeader("Proxy-Authorization")).isNull();
                    assertThat(second.getHeader("Proxy-Authorization")).isNull();
                } finally {
                    sdk.close();
                }
            } finally {
                transport.dispatcher().executorService().shutdown();
                transport.connectionPool().evictAll();
            }
        }
    }

    @TestFactory
    Stream<DynamicTest> sdkProxyHeadersStayOutOfTheDirectAndTunneledTlsOrigin() {
        return Stream.of(false, true)
                .map(tunnel -> dynamicTest("CONNECT=" + tunnel, () -> {
                    var certificate = new HeldCertificate.Builder()
                            .commonName("localhost")
                            .addSubjectAlternativeName("localhost")
                            .build();
                    var serverCerts = new HandshakeCertificates.Builder()
                            .heldCertificate(certificate)
                            .build();
                    var clientCerts = new HandshakeCertificates.Builder()
                            .addTrustedCertificate(certificate.certificate())
                            .build();
                    try (var peer = new MockWebServer()) {
                        peer.useHttps(serverCerts.sslSocketFactory(), tunnel);
                        if (tunnel)
                            peer.enqueue(new MockResponse().setSocketPolicy(SocketPolicy.UPGRADE_TO_SSL_AT_END));
                        peer.enqueue(upgrade());
                        peer.start();
                        var transportBuilder = new okhttp3.OkHttpClient.Builder()
                                .sslSocketFactory(clientCerts.sslSocketFactory(), clientCerts.trustManager());
                        if (tunnel) transportBuilder.proxy(peer.toProxyAddress());
                        var transport = transportBuilder.build();
                        try {
                            var sdk = OpenAIOkHttpClientAsync.builder()
                                    .apiKey("fixture-sdk-auth")
                                    .baseUrl(peer.url("/v1/").toString())
                                    .putHeader("Proxy-Authorization", "Basic Zml4dHVyZTpmaXh0dXJl")
                                    .okHttpClient(transport)
                                    .build();
                            try (var connection = sdk.responses().connect().get(5, TimeUnit.SECONDS)) {
                                if (tunnel) {
                                    var connect = peer.takeRequest(5, TimeUnit.SECONDS);
                                    assertThat(connect.getMethod()).isEqualTo("CONNECT");
                                    assertThat(connect.getHeader("Authorization") != null)
                                            .as("SDK bearer at proxy")
                                            .isFalse();
                                }
                                var origin = peer.takeRequest(5, TimeUnit.SECONDS);
                                assertThat(origin).isNotNull();
                                assertThat(origin.getHeader("Authorization") != null)
                                        .as("SDK bearer at origin")
                                        .isTrue();
                                assertThat(origin.getHeader("Proxy-Authorization") != null)
                                        .as("proxy credentials at TLS origin")
                                        .isFalse();
                            } finally {
                                sdk.close();
                            }
                        } finally {
                            transport.dispatcher().executorService().shutdown();
                            transport.connectionPool().evictAll();
                        }
                    }
                }));
    }
}
