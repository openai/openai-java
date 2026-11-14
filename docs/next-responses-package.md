# Use the Responses package

In the next major release, applications that only call the stable Responses API can install the Responses client. Use the same SDK version for every OpenAI artifact on the classpath or module path.

For Gradle, import the BOM and choose the default OkHttp transport.

```kotlin
implementation(platform("com.openai:openai-java-bom:$openaiVersion"))
implementation("com.openai:openai-java-responses")
```

For Maven, import the BOM in the application's dependency management and add the Responses artifact.

```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>com.openai</groupId>
      <artifactId>openai-java-bom</artifactId>
      <version>${openai.version}</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>
<dependencies>
  <dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java-responses</artifactId>
  </dependency>
</dependencies>
```

Replace the full client factory in applications that use Responses.

```java
import com.openai.responses.OpenAIResponsesClient;
import com.openai.responses.okhttp.OpenAIResponsesOkHttpClient;

try (OpenAIResponsesClient client = OpenAIResponsesOkHttpClient.fromEnv()) {
    long tokens = client.responses().inputTokens().count(params).inputTokensOrThrow();
}
```

Responses models keep their existing imports. If you declare the service type explicitly, use
`com.openai.services.blocking.responses.ResponseService` for `client.responses()` and
`com.openai.services.async.responses.ResponseServiceAsync` for `client.async().responses()`.
Use `client.responses().withRawResponse()` to access the HTTP response. For streaming, import
`com.openai.responses.helpers.ResponseAccumulator`. The package also includes input-item pagination,
input-token counts, structured output and tool helpers.

## Custom transport

Replace `openai-java-responses` with `openai-java-responses-api` in the dependency declaration.
Supply a `com.openai.core.http.HttpClient` when building `ClientOptions`. This installation has
no OkHttp dependency. To use `client.responses().connect()`, the same transport must also
implement `com.openai.core.http.WebSocketClient`.

```java
import com.openai.core.ClientOptions;
import com.openai.responses.OpenAIResponsesClient;

ClientOptions options = ClientOptions.builder().fromEnv().httpClient(transport).build();
try (OpenAIResponsesClient client = new OpenAIResponsesClient(options)) {
    client.responses().create(request);
}
```

Closing the client closes the supplied transport.

## OkHttp and X.509 imports

| Installation | Factory | Package for `OkHttpClient`, `X509Transport` and `X509WorkloadIdentity` |
| --- | --- | --- |
| `openai-java-responses` | `com.openai.responses.okhttp.OpenAIResponsesOkHttpClient` | `com.openai.http.okhttp` (from `openai-java-http-okhttp`) |
| `openai-java` | `com.openai.client.okhttp.OpenAIOkHttpClient` or `OpenAIOkHttpClientAsync` | `com.openai.client.okhttp` (from `openai-java-client-okhttp`) |

The two packages define distinct Java types. When migrating an X.509 configuration, import
both `X509Transport` and `X509WorkloadIdentity` from the package for the chosen factory, then
pass that identity to the builder's `x509WorkloadIdentity(...)` method.

## Java module path

On Java 9 or later, declare the default Responses module in the application's `module-info.java`.

```java
module example.app {
    requires openai.java.responses;
}
```

For a custom transport, use `requires openai.java.responses.api;`. On Java 9 or later,
resolve the SDK's runtime dependencies when launching the application. Set `APP_MODULES` to
the application's module directory and `SDK_MODULES` to the runtime module path resolved by
Maven or Gradle.

```sh
roots=kotlin.stdlib,kotlin.reflect,com.fasterxml.jackson.databind,com.fasterxml.jackson.kotlin
roots=$roots,com.fasterxml.jackson.datatype.jdk8,com.fasterxml.jackson.datatype.jsr310
java --module-path "$APP_MODULES:$SDK_MODULES" --add-modules "$roots" \
  -m example.app/example.Main
```

The launch option resolves named dependencies such as Kotlin and Jackson that the SDK's
automatic module cannot declare. For structured output or tool schemas, also root
`com.github.victools.jsonschema.module.jackson` and open the application package containing the
reflected model classes. To use Swagger schema annotations, explicitly depend on one of
`swagger-annotations` or `swagger-annotations-jakarta` and also root
`com.github.victools.jsonschema.module.swagger.two`. Java 8 applications use the classpath.

## Full SDK

Keep `openai-java` for applications that use other APIs, including Chat Completions, Realtime,
Files, Batch or beta services. Full-client callers keep their existing service, accumulator and
factory imports. Replace explicit older SDK version pins before combining the packages. Check
dependencies compiled against v4 for v5 compatibility before aligning their versions. The BOM
aligns artifact versions. A dependency that calls a removed v4 method still needs migration.
