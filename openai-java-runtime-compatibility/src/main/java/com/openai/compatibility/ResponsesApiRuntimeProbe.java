package com.openai.compatibility;

import com.fasterxml.jackson.databind.JsonNode;
import com.openai.core.ClientOptions;
import com.openai.core.ObjectMappers;
import com.openai.core.RequestOptions;
import com.openai.core.http.Headers;
import com.openai.core.http.HttpClient;
import com.openai.core.http.HttpMethod;
import com.openai.core.http.HttpRequest;
import com.openai.core.http.HttpResponse;
import com.openai.models.responses.ResponseCreateParams;
import com.openai.responses.OpenAIResponsesClient;
import com.openai.services.async.responses.ResponseServiceAsync;
import com.openai.services.blocking.responses.ResponseService;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

public final class ResponsesApiRuntimeProbe {
    private static final String BASE_URL = "https://example.invalid/v1";

    private ResponsesApiRuntimeProbe() {}

    public static void main(String[] args) {
        RuntimeProbe.requireNoFullClient();
        RuntimeProbe.requireNoOkHttp();

        ProbeTransport transport = new ProbeTransport();
        ClientOptions options = ClientOptions.builder()
                .apiKey("runtime-probe")
                .baseUrl(BASE_URL)
                .httpClient(transport)
                .build();
        try (OpenAIResponsesClient client = new OpenAIResponsesClient(options)) {
            ResponseCreateParams params = ResponseCreateParams.builder()
                    .model("probe-model")
                    .input("hello")
                    .build();
            ResponseService responses = client.responses();
            String text = responses
                    .create(params)
                    .outputOrThrow()
                    .get(0)
                    .asMessage()
                    .contentOrThrow()
                    .get(0)
                    .asOutputText()
                    .textOrThrow();
            if (!"hello back".equals(text)) {
                throw new IllegalStateException("Unexpected Responses message");
            }
            if (responses.inputTokens().count().inputTokensOrThrow() != 7) {
                throw new IllegalStateException("Blocking token count failed");
            }
            ResponseServiceAsync asyncResponses = client.async().responses();
            if (asyncResponses.inputTokens().count().join().inputTokensOrThrow() != 7) {
                throw new IllegalStateException("Async token count failed");
            }
        }
        if (!transport.closed) {
            throw new IllegalStateException("Closing the Responses client must close the supplied transport");
        }

        System.out.printf("Exercised openai-java-responses-api on Java %s.%n", System.getProperty("java.version"));
    }

    private static final class ProbeTransport implements HttpClient {
        private boolean closed;

        @Override
        public HttpResponse execute(HttpRequest request, RequestOptions options) {
            if (request.method() != HttpMethod.POST) {
                throw new IllegalStateException("Unexpected request method");
            }
            if (!request.headers().values("Authorization").contains("Bearer runtime-probe")) {
                throw new IllegalStateException("Missing fixture authorization");
            }
            String json;
            if ((BASE_URL + "/responses").equals(request.url())) {
                try (InputStream input = request.body().content()) {
                    JsonNode body = ObjectMappers.jsonMapper().readTree(input);
                    if (!"hello".equals(body.path("input").asText())
                            || !"probe-model".equals(body.path("model").asText())) {
                        throw new IllegalStateException("Unexpected serialized Responses request");
                    }
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
                json = "{\"object\":\"response\",\"id\":\"resp_probe\",\"output\":[{\"type\":\"message\","
                        + "\"id\":\"msg_probe\",\"role\":\"assistant\",\"status\":\"completed\",\"content\":["
                        + "{\"type\":\"output_text\",\"text\":\"hello back\",\"annotations\":[]}]}]}";
            } else if ((BASE_URL + "/responses/input_tokens").equals(request.url())) {
                json = "{\"object\":\"response.input_tokens\",\"input_tokens\":7}";
            } else {
                throw new IllegalStateException("Unexpected Responses request URL");
            }
            return new HttpResponse() {
                private final InputStream body = new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8));

                @Override
                public int statusCode() {
                    return 200;
                }

                @Override
                public Headers headers() {
                    return Headers.builder()
                            .put("Content-Type", "application/json")
                            .build();
                }

                @Override
                public InputStream body() {
                    return body;
                }

                @Override
                public void close() {}
            };
        }

        @Override
        public CompletableFuture<HttpResponse> executeAsync(HttpRequest request, RequestOptions options) {
            return CompletableFuture.completedFuture(execute(request, options));
        }

        @Override
        public void close() {
            closed = true;
        }
    }
}
