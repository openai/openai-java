package fixture;
import com.openai.client.OpenAIClientImpl;
import com.openai.core.ClientOptions;
import com.openai.core.RequestOptions;
import com.openai.core.http.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

public final class InstalledConsumer {
    static final class Transport implements HttpClient {
        boolean closed;
        int requests;
        public HttpResponse execute(HttpRequest request) { return execute(request, RequestOptions.none()); }
        public HttpResponse execute(HttpRequest request, RequestOptions options) {
            if (!request.url().equals("https://example.invalid/v1/responses/input_tokens")) throw new AssertionError(request.url());
            if (!request.headers().values("Authorization").contains("Bearer synthetic")) throw new AssertionError("authorization");
            requests++;
            return new HttpResponse() {
                public int statusCode() { return 200; }
                public Headers headers() { return Headers.builder().put("Content-Type", "application/json").build(); }
                public java.util.Optional<String> requestId() { return java.util.Optional.empty(); }
                public InputStream body() { return new ByteArrayInputStream("{\"object\":\"response.input_tokens\",\"input_tokens\":7}".getBytes(StandardCharsets.UTF_8)); }
                public void close() {}
            };
        }
        public CompletableFuture<HttpResponse> executeAsync(HttpRequest request, RequestOptions options) {
            return CompletableFuture.completedFuture(execute(request, options));
        }
        public CompletableFuture<HttpResponse> executeAsync(HttpRequest request) { return executeAsync(request, RequestOptions.none()); }
        public void close() { closed = true; }
    }
    public static void main(String[] args) {
        Transport transport = new Transport();
        ClientOptions options = ClientOptions.builder().apiKey("synthetic").baseUrl("https://example.invalid/v1").httpClient(transport).build();
        com.openai.client.OpenAIClient client = new OpenAIClientImpl(options); try {
            client.chat().completions();
            if (client.responses().inputTokens().count()._inputTokens().asKnown().get() != 7) throw new AssertionError("sync");
            if (client.async().responses().inputTokens().count().join()._inputTokens().asKnown().get() != 7) throw new AssertionError("async");
            try (HttpResponseFor<?> raw = client.responses().withRawResponse().inputTokens().count()) {
                if (raw.statusCode() != 200 || raw.parse() == null) throw new AssertionError("raw");
            }
            client.responses().inputItems();
        }
        finally { client.close(); }
        if (transport.requests != 3) throw new AssertionError("request count");
        System.out.println("Three authenticated Requests passed through the custom transport");
    }
}
