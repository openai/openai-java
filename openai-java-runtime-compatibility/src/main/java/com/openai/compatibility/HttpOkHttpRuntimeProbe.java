package com.openai.compatibility;

import com.openai.core.http.HttpMethod;
import com.openai.core.http.HttpRequest;
import com.openai.core.http.HttpResponse;
import com.openai.http.okhttp.OkHttpClient;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.nio.charset.StandardCharsets;

public final class HttpOkHttpRuntimeProbe {
    private HttpOkHttpRuntimeProbe() {}

    public static void main(String[] args) throws IOException {
        RuntimeProbe.requireNoFullClient();
        RuntimeProbe.requireAbsent("com.openai.responses.OpenAIResponsesClient");
        RuntimeProbe.requireAbsent("com.openai.responses.okhttp.OpenAIResponsesOkHttpClient");

        try (LocalServer server = new LocalServer("GET", "/probe", "{}");
                OkHttpClient transport =
                        OkHttpClient.builder().proxy(Proxy.NO_PROXY).build()) {
            HttpRequest request = HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(server.baseUrl())
                    .addPathSegment("probe")
                    .build();
            try (HttpResponse response = transport.execute(request)) {
                if (response.statusCode() != 200
                        || !"probe-id".equals(response.requestId().orElse(""))) {
                    throw new IllegalStateException("OkHttp transport lost the fixture status or request ID");
                }
            }
        }

        System.out.printf("Exercised openai-java-http-okhttp on Java %s.%n", System.getProperty("java.version"));
    }

    static final class LocalServer implements AutoCloseable {
        private final HttpServer server;

        LocalServer(String method, String path, String json) throws IOException {
            server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
            byte[] body = json.getBytes(StandardCharsets.UTF_8);
            server.createContext(path, exchange -> {
                try {
                    if (!method.equals(exchange.getRequestMethod())
                            || !path.equals(exchange.getRequestURI().toString())) {
                        exchange.sendResponseHeaders(400, -1);
                        return;
                    }
                    exchange.getResponseHeaders().set("Content-Type", "application/json");
                    exchange.getResponseHeaders().set("x-request-id", "probe-id");
                    exchange.sendResponseHeaders(200, body.length);
                    exchange.getResponseBody().write(body);
                } finally {
                    exchange.close();
                }
            });
            server.start();
        }

        String baseUrl() {
            return "http://127.0.0.1:" + server.getAddress().getPort();
        }

        @Override
        public void close() {
            server.stop(0);
        }
    }
}
