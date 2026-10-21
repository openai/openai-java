# Google Vertex AI

The optional `openai-java-vertex` artifact configures the standard OpenAI Java client to use the
Responses API with Google authentication. Add it using the same version as your other OpenAI Java
SDK artifacts:

```kotlin
implementation("com.openai:openai-java-vertex:YOUR_SDK_VERSION")
```

Configure Application Default Credentials for a Google Cloud project that can access your model,
then create a client:

```java
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.VertexOpenAIOkHttpClient;
import com.openai.models.responses.Response;
import com.openai.models.responses.ResponseCreateParams;

OpenAIClient client = VertexOpenAIOkHttpClient.builder()
        .projectId("your-project-id")
        .location("us-central1")
        .build();
try {
    Response response = client.responses().create(ResponseCreateParams.builder()
            .model("your-enabled-model")
            .input("Say hello")
            .store(false)
            .build());
    System.out.println(response.output());
} finally {
    client.close();
}
```

Project and location default to `GOOGLE_CLOUD_PROJECT` and `GOOGLE_CLOUD_LOCATION`. Model and
feature availability depend on your Vertex deployment. Use `client.async()` for asynchronous
requests; streaming, tools, timeouts, and retries use the ordinary SDK APIs.

You can pass an existing `GoogleCredentials` instance with `googleCredentials(...)`, or use
`tokenProvider(...)` when your application manages token caching and refresh. A token provider runs
before each request attempt and should respond to interruption when authentication times out or the
client closes. Cancelling a returned async future does not necessarily stop authentication or HTTP
dispatch. Google authentication dependencies are isolated to this optional artifact.

To use a custom endpoint, pass its complete API root before `/responses` to `baseUrl(...)`.
Credentials are sent only to that origin; use HTTPS to protect them in transit. Redirects are
disabled.
