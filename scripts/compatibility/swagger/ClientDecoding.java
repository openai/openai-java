import com.openai.client.OpenAIClientImpl;
import com.openai.core.ClientOptions;
import com.openai.core.RequestOptions;
import com.openai.core.http.Headers;
import com.openai.core.http.HttpClient;
import com.openai.core.http.HttpRequest;
import com.openai.core.http.HttpResponse;
import com.openai.core.http.StreamResponse;
import com.openai.models.chat.completions.ChatCompletionChunk;
import com.openai.models.chat.completions.ChatCompletionCreateParams;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

final class ClientDecoding implements HttpClient {
    private final String mediaType;
    private final String payload;

    private ClientDecoding(String mediaType, String payload) {
        this.mediaType = mediaType;
        this.payload = payload;
    }

    private OpenAIClientImpl client() {
        return new OpenAIClientImpl(
                ClientOptions.builder().apiKey("test").httpClient(this).build());
    }

    static void check() {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model("test")
                .addUserMessage("test")
                .build();
        OpenAIClientImpl jsonClient = new ClientDecoding("application/json", "{\"id\":\"completion\"}").client();
        try {
            if (!"completion"
                    .equals(jsonClient.chat().completions().create(params).idOrThrow())) {
                throw new AssertionError("Unexpected completion");
            }
        } finally {
            jsonClient.close();
        }
        String events = "data: {\"id\":\"chunk\"}\n\ndata: [DONE]\n\n";
        OpenAIClientImpl streamClient = new ClientDecoding("text/event-stream", events).client();
        try (StreamResponse<ChatCompletionChunk> response =
                streamClient.chat().completions().createStreaming(params)) {
            if (!response.stream()
                    .map(ChatCompletionChunk::idOrThrow)
                    .collect(Collectors.toList())
                    .equals(Collections.singletonList("chunk"))) {
                throw new AssertionError("Unexpected chat completion chunks");
            }
        } finally {
            streamClient.close();
        }
    }

    @Override
    public HttpResponse execute(HttpRequest request, RequestOptions options) {
        return new HttpResponse() {
            public int statusCode() {
                return 200;
            }

            public Headers headers() {
                return Headers.builder().put("Content-Type", mediaType).build();
            }

            public InputStream body() {
                return new ByteArrayInputStream(payload.getBytes(StandardCharsets.UTF_8));
            }

            public void close() {}
        };
    }

    @Override
    public CompletableFuture<HttpResponse> executeAsync(HttpRequest request, RequestOptions options) {
        throw new AssertionError("Unexpected async request");
    }

    @Override
    public void close() {}
}
