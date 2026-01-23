# OpenAI Java API Library

<!-- x-release-please-start-version -->

[![Maven Central](https://img.shields.io/maven-central/v/com.openai/openai-java)](https://central.sonatype.com/artifact/com.openai/openai-java/4.16.1)
[![javadoc](https://javadoc.io/badge2/com.openai/openai-java/4.16.1/javadoc.svg)](https://javadoc.io/doc/com.openai/openai-java/4.16.1)

<!-- x-release-please-end -->

The OpenAI Java SDK provides convenient access to the [OpenAI REST API](https://platform.openai.com/docs) from applications written in Java.

<!-- x-release-please-start-version -->

The REST API documentation can be found on [platform.openai.com](https://platform.openai.com/docs). Javadocs are available on [javadoc.io](https://javadoc.io/doc/com.openai/openai-java/4.16.1).

<!-- x-release-please-end -->

## Installation

<!-- x-release-please-start-version -->

[_Try `openai-java-spring-boot-starter` if you're using Spring Boot!_](#spring-boot)

### Gradle

```kotlin
implementation("com.openai:openai-java:4.16.1")
```

### Maven

```xml
<dependency>
  <groupId>com.openai</groupId>
  <artifactId>openai-java</artifactId>
  <version>4.16.1</version>
</dependency>
```

<!-- x-release-please-end -->

## Requirements

This library requires Java 8 or later.

## Usage

```java
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionCreateParams;

// Configures using the `openai.apiKey`, `openai.orgId`, `openai.projectId`, `openai.webhookSecret` and `openai.baseUrl` system properties
// Or configures using the `OPENAI_API_KEY`, `OPENAI_ORG_ID`, `OPENAI_PROJECT_ID`, `OPENAI_WEBHOOK_SECRET` and `OPENAI_BASE_URL` environment variables
OpenAIClient client = OpenAIOkHttpClient.fromEnv();

ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
    .addUserMessage("Say this is a test")
    .model(ChatModel.GPT_4O)
    .build();
ChatCompletion chatCompletion = client.chat().completions().create(params);
```

## Client configuration

Configure the client using system properties or environment variables:

```java
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;

// Configures using the `openai.apiKey`, `openai.orgId`, `openai.projectId`, `openai.webhookSecret` and `openai.baseUrl` system properties
// Or configures using the `OPENAI_API_KEY`, `OPENAI_ORG_ID`, `OPENAI_PROJECT_ID`, `OPENAI_WEBHOOK_SECRET` and `OPENAI_BASE_URL` environment variables
OpenAIClient client = OpenAIOkHttpClient.fromEnv();
```

Or manually:

```java
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;

OpenAIClient client = OpenAIOkHttpClient.builder()
    .apiKey("My API Key")
    .build();
```

Or using a combination of the two approaches:

```java
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;

OpenAIClient client = OpenAIOkHttpClient.builder()
    // Configures using the `openai.apiKey`, `openai.orgId`, `openai.projectId`, `openai.webhookSecret` and `openai.baseUrl` system properties
    // Or configures using the `OPENAI_API_KEY`, `OPENAI_ORG_ID`, `OPENAI_PROJECT_ID`, `OPENAI_WEBHOOK_SECRET` and `OPENAI_BASE_URL` environment variables
    .fromEnv()
    .apiKey("My API Key")
    .build();
```

See this table for the available options:

| Setter          | System property        | Environment variable    | Required | Default value                 |
| --------------- | ---------------------- | ----------------------- | -------- | ----------------------------- |
| `apiKey`        | `openai.apiKey`        | `OPENAI_API_KEY`        | true     | -                             |
| `organization`  | `openai.orgId`         | `OPENAI_ORG_ID`         | false    | -                             |
| `project`       | `openai.projectId`     | `OPENAI_PROJECT_ID`     | false    | -                             |
| `webhookSecret` | `openai.webhookSecret` | `OPENAI_WEBHOOK_SECRET` | false    | -                             |
| `baseUrl`       | `openai.baseUrl`       | `OPENAI_BASE_URL`       | true     | `"https://api.openai.com/v1"` |

System properties take precedence over environment variables.

> [!TIP]
> Don't create more than one client in the same application. Each client has a connection pool and
> thread pools, which are more efficient to share between requests.

### Modifying configuration

To temporarily use a modified client configuration, while reusing the same connection and thread pools, call `withOptions()` on any client or service:

```java
import com.openai.client.OpenAIClient;

OpenAIClient clientWithOptions = client.withOptions(optionsBuilder -> {
    optionsBuilder.baseUrl("https://example.com");
    optionsBuilder.maxRetries(42);
});
```

The `withOptions()` method does not affect the original client or service.

## Requests and responses

To send a request to the OpenAI API, build an instance of some `Params` class and pass it to the corresponding client method. When the response is received, it will be deserialized into an instance of a Java class.

For example, `client.chat().completions().create(...)` should be called with an instance of `ChatCompletionCreateParams`, and it will return an instance of `ChatCompletion`.

## Immutability

Each class in the SDK has an associated [builder](https://blogs.oracle.com/javamagazine/post/exploring-joshua-blochs-builder-design-pattern-in-java) or factory method for constructing it.

Each class is [immutable](https://docs.oracle.com/javase/tutorial/essential/concurrency/immutable.html) once constructed. If the class has an associated builder, then it has a `toBuilder()` method, which can be used to convert it back to a builder for making a modified copy.

Because each class is immutable, builder modification will _never_ affect already built class instances.

## Asynchronous execution

The default client is synchronous. To switch to asynchronous execution, call the `async()` method:

```java
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionCreateParams;
import java.util.concurrent.CompletableFuture;

// Configures using the `openai.apiKey`, `openai.orgId`, `openai.projectId`, `openai.webhookSecret` and `openai.baseUrl` system properties
// Or configures using the `OPENAI_API_KEY`, `OPENAI_ORG_ID`, `OPENAI_PROJECT_ID`, `OPENAI_WEBHOOK_SECRET` and `OPENAI_BASE_URL` environment variables
OpenAIClient client = OpenAIOkHttpClient.fromEnv();

ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
    .addUserMessage("Say this is a test")
    .model(ChatModel.GPT_4O)
    .build();
CompletableFuture<ChatCompletion> chatCompletion = client.async().chat().completions().create(params);
```

Or create an asynchronous client from the beginning:

```java
import com.openai.client.OpenAIClientAsync;
import com.openai.client.okhttp.OpenAIOkHttpClientAsync;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionCreateParams;
import java.util.concurrent.CompletableFuture;

// Configures using the `openai.apiKey`, `openai.orgId`, `openai.projectId`, `openai.webhookSecret` and `openai.baseUrl` system properties
// Or configures using the `OPENAI_API_KEY`, `OPENAI_ORG_ID`, `OPENAI_PROJECT_ID`, `OPENAI_WEBHOOK_SECRET` and `OPENAI_BASE_URL` environment variables
OpenAIClientAsync client = OpenAIOkHttpClientAsync.fromEnv();

ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
    .addUserMessage("Say this is a test")
    .model(ChatModel.GPT_4O)
    .build();
CompletableFuture<ChatCompletion> chatCompletion = client.chat().completions().create(params);
```

The asynchronous client supports the same options as the synchronous one, except most methods return `CompletableFuture`s.

## Streaming

The SDK defines methods that return response "chunk" streams, where each chunk can be individually processed as soon as it arrives instead of waiting on the full response. Streaming methods generally correspond to [SSE](https://developer.mozilla.org/en-US/docs/Web/API/Server-sent_events) or [JSONL](https://jsonlines.org) responses.

Some of these methods may have streaming and non-streaming variants, but a streaming method will always have a `Streaming` suffix in its name, even if it doesn't have a non-streaming variant.

These streaming methods return [`StreamResponse`](openai-java-core/src/main/kotlin/com/openai/core/http/StreamResponse.kt) for synchronous clients:

```java
import com.openai.core.http.StreamResponse;
import com.openai.models.chat.completions.ChatCompletionChunk;

try (StreamResponse<ChatCompletionChunk> streamResponse = client.chat().completions().createStreaming(params)) {
    streamResponse.stream().forEach(chunk -> {
        System.out.println(chunk);
    });
    System.out.println("No more chunks!");
}
```

Or [`AsyncStreamResponse`](openai-java-core/src/main/kotlin/com/openai/core/http/AsyncStreamResponse.kt) for asynchronous clients:

```java
import com.openai.core.http.AsyncStreamResponse;
import com.openai.models.chat.completions.ChatCompletionChunk;
import java.util.Optional;

client.async().chat().completions().createStreaming(params).subscribe(chunk -> {
    System.out.println(chunk);
});

// If you need to handle errors or completion of the stream
client.async().chat().completions().createStreaming(params).subscribe(new AsyncStreamResponse.Handler<>() {
    @Override
    public void onNext(ChatCompletionChunk chunk) {
        System.out.println(chunk);
    }

    @Override
    public void onComplete(Optional<Throwable> error) {
        if (error.isPresent()) {
            System.out.println("Something went wrong!");
            throw new RuntimeException(error.get());
        } else {
            System.out.println("No more chunks!");
        }
    }
});

// Or use futures
client.async().chat().completions().createStreaming(params)
    .subscribe(chunk -> {
        System.out.println(chunk);
    })
    .onCompleteFuture();
    .whenComplete((unused, error) -> {
        if (error != null) {
            System.out.println("Something went wrong!");
            throw new RuntimeException(error);
        } else {
            System.out.println("No more chunks!");
        }
    });
```

Async streaming uses a dedicated per-client cached thread pool [`Executor`](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Executor.html) to stream without blocking the current thread. This default is suitable for most purposes.

To use a different `Executor`, configure the subscription using the `executor` parameter:

```java
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

Executor executor = Executors.newFixedThreadPool(4);
client.async().chat().completions().createStreaming(params).subscribe(
    chunk -> System.out.println(chunk), executor
);
```

Or configure the client globally using the `streamHandlerExecutor` method:

```java
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import java.util.concurrent.Executors;

OpenAIClient client = OpenAIOkHttpClient.builder()
    .fromEnv()
    .streamHandlerExecutor(Executors.newFixedThreadPool(4))
    .build();
```

## File uploads

The SDK defines methods that accept files.

To upload a file, pass a [`Path`](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Path.html):

```java
import com.openai.models.files.FileCreateParams;
import com.openai.models.files.FileObject;
import com.openai.models.files.FilePurpose;
import java.nio.file.Paths;

FileCreateParams params = FileCreateParams.builder()
    .purpose(FilePurpose.FINE_TUNE)
    .file(Paths.get("input.jsonl"))
    .build();
FileObject fileObject = client.files().create(params);
```

Or an arbitrary [`InputStream`](https://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html):

```java
import com.openai.models.files.FileCreateParams;
import com.openai.models.files.FileObject;
import com.openai.models.files.FilePurpose;
import java.net.URL;

FileCreateParams params = FileCreateParams.builder()
    .purpose(FilePurpose.FINE_TUNE)
    .file(new URL("https://example.com/input.jsonl").openStream())
    .build();
FileObject fileObject = client.files().create(params);
```

Or a `byte[]` array:

```java
import com.openai.models.files.FileCreateParams;
import com.openai.models.files.FileObject;
import com.openai.models.files.FilePurpose;

FileCreateParams params = FileCreateParams.builder()
    .purpose(FilePurpose.FINE_TUNE)
    .file("content".getBytes())
    .build();
FileObject fileObject = client.files().create(params);
```

Note that when passing a non-`Path` its filename is unknown so it will not be included in the request. To manually set a filename, pass a [`MultipartField`](openai-java-core/src/main/kotlin/com/openai/core/Values.kt):

```java
import com.openai.core.MultipartField;
import com.openai.models.files.FileCreateParams;
import com.openai.models.files.FileObject;
import com.openai.models.files.FilePurpose;
import java.io.InputStream;
import java.net.URL;

FileCreateParams params = FileCreateParams.builder()
    .purpose(FilePurpose.FINE_TUNE)
    .file(MultipartField.<InputStream>builder()
        .value(new URL("https://example.com/input.jsonl").openStream())
        .filename("input.jsonl")
        .build())
    .build();
FileObject fileObject = client.files().create(params);
```

## Binary responses

The SDK defines methods that return binary responses, which are used for API responses that shouldn't necessarily be parsed, like non-JSON data.

These methods return [`HttpResponse`](openai-java-core/src/main/kotlin/com/openai/core/http/HttpResponse.kt):

```java
import com.openai.core.http.HttpResponse;
import com.openai.models.files.FileContentParams;

HttpResponse response = client.files().content("file_id");
```

To save the response content to a file, use the [`Files.copy(...)`](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html#copy-java.io.InputStream-java.nio.file.Path-java.nio.file.CopyOption...-) method:

```java
import com.openai.core.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

try (HttpResponse response = client.files().content(params)) {
    Files.copy(
        response.body(),
        Paths.get(path),
        StandardCopyOption.REPLACE_EXISTING
    );
} catch (Exception e) {
    System.out.println("Something went wrong!");
    throw new RuntimeException(e);
}
```

Or transfer the response content to any [`OutputStream`](https://docs.oracle.com/javase/8/docs/api/java/io/OutputStream.html):

```java
import com.openai.core.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;

try (HttpResponse response = client.files().content(params)) {
    response.body().transferTo(Files.newOutputStream(Paths.get(path)));
} catch (Exception e) {
    System.out.println("Something went wrong!");
    throw new RuntimeException(e);
}
```

## Raw responses

The SDK defines methods that deserialize responses into instances of Java classes. However, these methods don't provide access to the response headers, status code, or the raw response body.

To access this data, prefix any HTTP method call on a client or service with `withRawResponse()`:

```java
import com.openai.core.http.Headers;
import com.openai.core.http.HttpResponseFor;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionCreateParams;

ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
    .addUserMessage("Say this is a test")
    .model(ChatModel.GPT_4O)
    .build();
HttpResponseFor<ChatCompletion> chatCompletion = client.chat().completions().withRawResponse().create(params);

int statusCode = chatCompletion.statusCode();
Headers headers = chatCompletion.headers();
```

You can still deserialize the response into an instance of a Java class if needed:

```java
import com.openai.models.chat.completions.ChatCompletion;

ChatCompletion parsedChatCompletion = chatCompletion.parse();
```

## Error handling

The SDK throws custom unchecked exception types:

- [`OpenAIServiceException`](openai-java-core/src/main/kotlin/com/openai/errors/OpenAIServiceException.kt): Base class for HTTP errors. See this table for which exception subclass is thrown for each HTTP status code:

  | Status | Exception                                                                                                              |
  | ------ | ---------------------------------------------------------------------------------------------------------------------- |
  | 400    | [`BadRequestException`](openai-java-core/src/main/kotlin/com/openai/errors/BadRequestException.kt)                     |
  | 401    | [`UnauthorizedException`](openai-java-core/src/main/kotlin/com/openai/errors/UnauthorizedException.kt)                 |
  | 403    | [`PermissionDeniedException`](openai-java-core/src/main/kotlin/com/openai/errors/PermissionDeniedException.kt)         |
  | 404    | [`NotFoundException`](openai-java-core/src/main/kotlin/com/openai/errors/NotFoundException.kt)                         |
  | 422    | [`UnprocessableEntityException`](openai-java-core/src/main/kotlin/com/openai/errors/UnprocessableEntityException.kt)   |
  | 429    | [`RateLimitException`](openai-java-core/src/main/kotlin/com/openai/errors/RateLimitException.kt)                       |
  | 5xx    | [`InternalServerException`](openai-java-core/src/main/kotlin/com/openai/errors/InternalServerException.kt)             |
  | others | [`UnexpectedStatusCodeException`](openai-java-core/src/main/kotlin/com/openai/errors/UnexpectedStatusCodeException.kt) |

  [`SseException`](openai-java-core/src/main/kotlin/com/openai/errors/SseException.kt) is thrown for errors encountered during [SSE streaming](https://developer.mozilla.org/en-US/docs/Web/API/Server-sent_events) after a successful initial HTTP response.

- [`OpenAIIoException`](openai-java-core/src/main/kotlin/com/openai/errors/OpenAIIoException.kt): I/O networking errors.

- [`OpenAIRetryableException`](openai-java-core/src/main/kotlin/com/openai/errors/OpenAIRetryableException.kt): Generic error indicating a failure that could be retried by the client.

- [`OpenAIInvalidDataException`](openai-java-core/src/main/kotlin/com/openai/errors/OpenAIInvalidDataException.kt): Failure to interpret successfully parsed data. For example, when accessing a property that's supposed to be required, but the API unexpectedly omitted it from the response.

- [`OpenAIException`](openai-java-core/src/main/kotlin/com/openai/errors/OpenAIException.kt): Base class for all exceptions. Most errors will result in one of the previously mentioned ones, but completely generic errors may be thrown using the base class.

## Pagination

The SDK defines methods that return a paginated lists of results. It provides convenient ways to access the results either one page at a time or item-by-item across all pages.

### Auto-pagination

To iterate through all results across all pages, use the `autoPager()` method, which automatically fetches more pages as needed.

When using the synchronous client, the method returns an [`Iterable`](https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html)

```java
import com.openai.models.finetuning.jobs.FineTuningJob;
import com.openai.models.finetuning.jobs.JobListPage;

JobListPage page = client.fineTuning().jobs().list();

// Process as an Iterable
for (FineTuningJob job : page.autoPager()) {
    System.out.println(job);
}

// Process as a Stream
page.autoPager()
    .stream()
    .limit(50)
    .forEach(job -> System.out.println(job));
```

When using the asynchronous client, the method returns an [`AsyncStreamResponse`](openai-java-core/src/main/kotlin/com/openai/core/http/AsyncStreamResponse.kt):

```java
import com.openai.core.http.AsyncStreamResponse;
import com.openai.models.finetuning.jobs.FineTuningJob;
import com.openai.models.finetuning.jobs.JobListPageAsync;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

CompletableFuture<JobListPageAsync> pageFuture = client.async().fineTuning().jobs().list();

pageFuture.thenRun(page -> page.autoPager().subscribe(job -> {
    System.out.println(job);
}));

// If you need to handle errors or completion of the stream
pageFuture.thenRun(page -> page.autoPager().subscribe(new AsyncStreamResponse.Handler<>() {
    @Override
    public void onNext(FineTuningJob job) {
        System.out.println(job);
    }

    @Override
    public void onComplete(Optional<Throwable> error) {
        if (error.isPresent()) {
            System.out.println("Something went wrong!");
            throw new RuntimeException(error.get());
        } else {
            System.out.println("No more!");
        }
    }
}));

// Or use futures
pageFuture.thenRun(page -> page.autoPager()
    .subscribe(job -> {
        System.out.println(job);
    })
    .onCompleteFuture()
    .whenComplete((unused, error) -> {
        if (error != null) {
            System.out.println("Something went wrong!");
            throw new RuntimeException(error);
        } else {
            System.out.println("No more!");
        }
    }));
```

### Manual pagination

To access individual page items and manually request the next page, use the `items()`,
`hasNextPage()`, and `nextPage()` methods:

```java
import com.openai.models.finetuning.jobs.FineTuningJob;
import com.openai.models.finetuning.jobs.JobListPage;

JobListPage page = client.fineTuning().jobs().list();
while (true) {
    for (FineTuningJob job : page.items()) {
        System.out.println(job);
    }

    if (!page.hasNextPage()) {
        break;
    }

    page = page.nextPage();
}
```

## Logging

The SDK uses the standard [OkHttp logging interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor).

Enable logging by setting the `OPENAI_LOG` environment variable to `info`:

```sh
export OPENAI_LOG=info
```

Or to `debug` for more verbose logging:

```sh
export OPENAI_LOG=debug
```

## ProGuard and R8

Although the SDK uses reflection, it is still usable with [ProGuard](https://github.com/Guardsquare/proguard) and [R8](https://developer.android.com/topic/performance/app-optimization/enable-app-optimization) because `openai-java-core` is published with a [configuration file](openai-java-core/src/main/resources/META-INF/proguard/openai-java-core.pro) containing [keep rules](https://www.guardsquare.com/manual/configuration/usage).

ProGuard and R8 should automatically detect and use the published rules, but you can also manually copy the keep rules if necessary.

## GraalVM

Although the SDK uses reflection, it is still usable in [GraalVM](https://www.graalvm.org) because `openai-java-core` is published with [reachability metadata](https://www.graalvm.org/latest/reference-manual/native-image/metadata/).

GraalVM should automatically detect and use the published metadata, but [manual configuration](https://www.graalvm.org/jdk24/reference-manual/native-image/overview/BuildConfiguration/) is also available.

## Spring Boot

If you're using Spring Boot, then you can use the SDK's [Spring Boot starter](https://docs.spring.io/spring-boot/docs/2.7.18/reference/htmlsingle/#using.build-systems.starters) to simplify configuration and get set up quickly.

### Installation

<!-- x-release-please-start-version -->

#### Gradle

```kotlin
implementation("com.openai:openai-java-spring-boot-starter:4.16.1")
```

#### Maven

```xml
<dependency>
  <groupId>com.openai</groupId>
  <artifactId>openai-java-spring-boot-starter</artifactId>
  <version>4.16.1</version>
</dependency>
```

<!-- x-release-please-end -->

### Configuration

The [client's environment variable options](#client-configuration) can be configured in [`application.properties` or `application.yml`](https://docs.spring.io/spring-boot/how-to/properties-and-configuration.html).

#### `application.properties`

```properties
openai.base-url=https://api.openai.com/v1
openai.api-key=My API Key
openai.org-id=My Organization
openai.project-id=My Project
openai.webhook-secret=My Webhook Secret
```

#### `application.yml`

```yaml
openai:
  base-url: https://api.openai.com/v1
  api-key: My API Key
  org-id: My Organization
  project-id: My Project
  webhook-secret: My Webhook Secret
```

#### Other configuration

Configure any other client option by providing one or more instances of [`OpenAIClientCustomizer`](openai-java-spring-boot-starter/src/main/kotlin/com/openai/springboot/OpenAIClientCustomizer.kt). For example, here's how you'd set [`maxRetries`](#retries):

```java
import com.openai.springboot.OpenAIClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAIConfig {
    @Bean
    public OpenAIClientCustomizer customizer() {
        return builder -> builder.maxRetries(3);
    }
}
```

### Usage

[Inject](https://docs.spring.io/spring-framework/reference/core/beans/dependencies/factory-collaborators.html) [`OpenAIClient`](openai-java-core/src/main/kotlin/com/openai/client/OpenAIClient.kt) anywhere and start using it!

## Jackson

The SDK depends on [Jackson](https://github.com/FasterXML/jackson) for JSON serialization/deserialization. It is compatible with version 2.13.4 or higher, but depends on version 2.18.2 by default.

The SDK throws an exception if it detects an incompatible Jackson version at runtime (e.g. if the default version was overridden in your Maven or Gradle config).

If the SDK threw an exception, but you're _certain_ the version is compatible, then disable the version check using the `checkJacksonVersionCompatibility` on [`OpenAIOkHttpClient`](openai-java-client-okhttp/src/main/kotlin/com/openai/client/okhttp/OpenAIOkHttpClient.kt) or [`OpenAIOkHttpClientAsync`](openai-java-client-okhttp/src/main/kotlin/com/openai/client/okhttp/OpenAIOkHttpClientAsync.kt).

> [!CAUTION]
> We make no guarantee that the SDK works correctly when the Jackson version check is disabled.

Also note that there are bugs in older Jackson versions that can affect the SDK. We don't work around all Jackson bugs ([example](https://github.com/FasterXML/jackson-databind/issues/3240)) and expect users to upgrade Jackson for those instead.

## Network options

### Retries

The SDK automatically retries 2 times by default, with a short exponential backoff between requests.

Only the following error types are retried:

- Connection errors (for example, due to a network connectivity problem)
- 408 Request Timeout
- 409 Conflict
- 429 Rate Limit
- 5xx Internal

The API may also explicitly instruct the SDK to retry or not retry a request.

To set a custom number of retries, configure the client using the `maxRetries` method:

```java
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;

OpenAIClient client = OpenAIOkHttpClient.builder()
    .fromEnv()
    .maxRetries(4)
    .build();
```

### Timeouts

Requests time out after 10 minutes by default.

To set a custom timeout, configure the method call using the `timeout` method:

```java
import com.openai.models.chat.completions.ChatCompletion;

ChatCompletion chatCompletion = client.chat().completions().create(
  params, RequestOptions.builder().timeout(Duration.ofSeconds(30)).build()
);
```

Or configure the default for all method calls at the client level:

```java
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import java.time.Duration;

OpenAIClient client = OpenAIOkHttpClient.builder()
    .fromEnv()
    .timeout(Duration.ofSeconds(30))
    .build();
```

### Proxies

To route requests through a proxy, configure the client using the `proxy` method:

```java
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import java.net.InetSocketAddress;
import java.net.Proxy;

OpenAIClient client = OpenAIOkHttpClient.builder()
    .fromEnv()
    .proxy(new Proxy(
      Proxy.Type.HTTP, new InetSocketAddress(
        "https://example.com", 8080
      )
    ))
    .build();
```

### HTTPS

> [!NOTE]
> Most applications should not call these methods, and instead use the system defaults. The defaults include
> special optimizations that can be lost if the implementations are modified.

To configure how HTTPS connections are secured, configure the client using the `sslSocketFactory`, `trustManager`, and `hostnameVerifier` methods:

```java
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;

OpenAIClient client = OpenAIOkHttpClient.builder()
    .fromEnv()
    // If `sslSocketFactory` is set, then `trustManager` must be set, and vice versa.
    .sslSocketFactory(yourSSLSocketFactory)
    .trustManager(yourTrustManager)
    .hostnameVerifier(yourHostnameVerifier)
    .build();
```

### Custom HTTP client

The SDK consists of three artifacts:

- `openai-java-core`
  - Contains core SDK logic
  - Does not depend on [OkHttp](https://square.github.io/okhttp)
  - Exposes [`OpenAIClient`](openai-java-core/src/main/kotlin/com/openai/client/OpenAIClient.kt), [`OpenAIClientAsync`](openai-java-core/src/main/kotlin/com/openai/client/OpenAIClientAsync.kt), [`OpenAIClientImpl`](openai-java-core/src/main/kotlin/com/openai/client/OpenAIClientImpl.kt), and [`OpenAIClientAsyncImpl`](openai-java-core/src/main/kotlin/com/openai/client/OpenAIClientAsyncImpl.kt), all of which can work with any HTTP client
- `openai-java-client-okhttp`
  - Depends on [OkHttp](https://square.github.io/okhttp)
  - Exposes [`OpenAIOkHttpClient`](openai-java-client-okhttp/src/main/kotlin/com/openai/client/okhttp/OpenAIOkHttpClient.kt) and [`OpenAIOkHttpClientAsync`](openai-java-client-okhttp/src/main/kotlin/com/openai/client/okhttp/OpenAIOkHttpClientAsync.kt), which provide a way to construct [`OpenAIClientImpl`](openai-java-core/src/main/kotlin/com/openai/client/OpenAIClientImpl.kt) and [`OpenAIClientAsyncImpl`](openai-java-core/src/main/kotlin/com/openai/client/OpenAIClientAsyncImpl.kt), respectively, using OkHttp
- `openai-java`
  - Depends on and exposes the APIs of both `openai-java-core` and `openai-java-client-okhttp`
  - Does not have its own logic

This structure allows replacing the SDK's default HTTP client without pulling in unnecessary dependencies.

#### Customized [`OkHttpClient`](https://square.github.io/okhttp/3.x/okhttp/okhttp3/OkHttpClient.html)

> [!TIP]
> Try the available [network options](#network-options) before replacing the default client.

To use a customized `OkHttpClient`:

1. Replace your [`openai-java` dependency](#installation) with `openai-java-core`
2. Copy `openai-java-client-okhttp`'s [`OkHttpClient`](openai-java-client-okhttp/src/main/kotlin/com/openai/client/okhttp/OkHttpClient.kt) class into your code and customize it
3. Construct [`OpenAIClientImpl`](openai-java-core/src/main/kotlin/com/openai/client/OpenAIClientImpl.kt) or [`OpenAIClientAsyncImpl`](openai-java-core/src/main/kotlin/com/openai/client/OpenAIClientAsyncImpl.kt), similarly to [`OpenAIOkHttpClient`](openai-java-client-okhttp/src/main/kotlin/com/openai/client/okhttp/OpenAIOkHttpClient.kt) or [`OpenAIOkHttpClientAsync`](openai-java-client-okhttp/src/main/kotlin/com/openai/client/okhttp/OpenAIOkHttpClientAsync.kt), using your customized client

### Completely custom HTTP client

To use a completely custom HTTP client:

1. Replace your [`openai-java` dependency](#installation) with `openai-java-core`
2. Write a class that implements the [`HttpClient`](openai-java-core/src/main/kotlin/com/openai/core/http/HttpClient.kt) interface
3. Construct [`OpenAIClientImpl`](openai-java-core/src/main/kotlin/com/openai/client/OpenAIClientImpl.kt) or [`OpenAIClientAsyncImpl`](openai-java-core/src/main/kotlin/com/openai/client/OpenAIClientAsyncImpl.kt), similarly to [`OpenAIOkHttpClient`](openai-java-client-okhttp/src/main/kotlin/com/openai/client/okhttp/OpenAIOkHttpClient.kt) or [`OpenAIOkHttpClientAsync`](openai-java-client-okhttp/src/main/kotlin/com/openai/client/okhttp/OpenAIOkHttpClientAsync.kt), using your new client class

## Undocumented API functionality

The SDK is typed for convenient usage of the documented API. However, it also supports working with undocumented or not yet supported parts of the API.

### Parameters

To set undocumented parameters, call the `putAdditionalHeader`, `putAdditionalQueryParam`, or `putAdditionalBodyProperty` methods on any `Params` class:

```java
import com.openai.core.JsonValue;
import com.openai.models.chat.completions.ChatCompletionCreateParams;

ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
    .putAdditionalHeader("Secret-Header", "42")
    .putAdditionalQueryParam("secret_query_param", "42")
    .putAdditionalBodyProperty("secretProperty", JsonValue.from("42"))
    .build();
```

These can be accessed on the built object later using the `_additionalHeaders()`, `_additionalQueryParams()`, and `_additionalBodyProperties()` methods.

To set undocumented parameters on _nested_ headers, query params, or body classes, call the `putAdditionalProperty` method on the nested class:

```java
import com.openai.core.JsonValue;
import com.openai.models.chat.completions.ChatCompletionCreateParams;

ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
    .responseFormat(ChatCompletionCreateParams.ResponseFormat.builder()
        .putAdditionalProperty("secretProperty", JsonValue.from("42"))
        .build())
    .build();
```

These properties can be accessed on the nested built object later using the `_additionalProperties()` method.

To set a documented parameter or property to an undocumented or not yet supported _value_, pass a [`JsonValue`](openai-java-core/src/main/kotlin/com/openai/core/Values.kt) object to its setter:

```java
import com.openai.core.JsonValue;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletionCreateParams;

ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
    .messages(JsonValue.from(42))
    .model(ChatModel.GPT_4O)
    .build();
```

The most straightforward way to create a [`JsonValue`](openai-java-core/src/main/kotlin/com/openai/core/Values.kt) is using its `from(...)` method:

```java
import com.openai.core.JsonValue;
import java.util.List;
import java.util.Map;

// Create primitive JSON values
JsonValue nullValue = JsonValue.from(null);
JsonValue booleanValue = JsonValue.from(true);
JsonValue numberValue = JsonValue.from(42);
JsonValue stringValue = JsonValue.from("Hello World!");

// Create a JSON array value equivalent to `["Hello", "World"]`
JsonValue arrayValue = JsonValue.from(List.of(
  "Hello", "World"
));

// Create a JSON object value equivalent to `{ "a": 1, "b": 2 }`
JsonValue objectValue = JsonValue.from(Map.of(
  "a", 1,
  "b", 2
));

// Create an arbitrarily nested JSON equivalent to:
// {
//   "a": [1, 2],
//   "b": [3, 4]
// }
JsonValue complexValue = JsonValue.from(Map.of(
  "a", List.of(
    1, 2
  ),
  "b", List.of(
    3, 4
  )
));
```

Normally a `Builder` class's `build` method will throw [`IllegalStateException`](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalStateException.html) if any required parameter or property is unset.

To forcibly omit a required parameter or property, pass [`JsonMissing`](openai-java-core/src/main/kotlin/com/openai/core/Values.kt):

```java
import com.openai.core.JsonMissing;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletionCreateParams;

ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
    .model(ChatModel.GPT_4O)
    .messages(JsonMissing.of())
    .build();
```

### Response properties

To access undocumented response properties, call the `_additionalProperties()` method:

```java
import com.openai.core.JsonValue;
import java.util.Map;

Map<String, JsonValue> additionalProperties = client.chat().completions().create(params)._additionalProperties();
JsonValue secretPropertyValue = additionalProperties.get("secretProperty");

String result = secretPropertyValue.accept(new JsonValue.Visitor<>() {
    @Override
    public String visitNull() {
        return "It's null!";
    }

    @Override
    public String visitBoolean(boolean value) {
        return "It's a boolean!";
    }

    @Override
    public String visitNumber(Number value) {
        return "It's a number!";
    }

    // Other methods include `visitMissing`, `visitString`, `visitArray`, and `visitObject`
    // The default implementation of each unimplemented method delegates to `visitDefault`, which throws by default, but can also be overridden
});
```

To access a property's raw JSON value, which may be undocumented, call its `_` prefixed method:

```java
import com.openai.core.JsonField;
import com.openai.models.chat.completions.ChatCompletionMessageParam;
import java.util.Optional;

JsonField<List<ChatCompletionMessageParam>> messages = client.chat().completions().create(params)._messages();

if (messages.isMissing()) {
  // The property is absent from the JSON response
} else if (messages.isNull()) {
  // The property was set to literal null
} else {
  // Check if value was provided as a string
  // Other methods include `asNumber()`, `asBoolean()`, etc.
  Optional<String> jsonString = messages.asString();

  // Try to deserialize into a custom type
  MyClass myObject = messages.asUnknown().orElseThrow().convert(MyClass.class);
}
```

### Response validation

In rare cases, the API may return a response that doesn't match the expected type. For example, the SDK may expect a property to contain a `String`, but the API could return something else.

By default, the SDK will not throw an exception in this case. It will throw [`OpenAIInvalidDataException`](openai-java-core/src/main/kotlin/com/openai/errors/OpenAIInvalidDataException.kt) only if you directly access the property.

If you would prefer to check that the response is completely well-typed upfront, then either call `validate()`:

```java
import com.openai.models.chat.completions.ChatCompletion;

ChatCompletion chatCompletion = client.chat().completions().create(params).validate();
```

Or configure the method call to validate the response using the `responseValidation` method:

```java
import com.openai.models.chat.completions.ChatCompletion;

ChatCompletion chatCompletion = client.chat().completions().create(
  params, RequestOptions.builder().responseValidation(true).build()
);
```

Or configure the default for all method calls at the client level:

```java
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;

OpenAIClient client = OpenAIOkHttpClient.builder()
    .fromEnv()
    .responseValidation(true)
    .build();
```

## FAQ

### Why don't you use plain `enum` classes?

Java `enum` classes are not trivially [forwards compatible](https://www.stainless.com/blog/making-java-enums-forwards-compatible). Using them in the SDK could cause runtime exceptions if the API is updated to respond with a new enum value.

### Why do you represent fields using `JsonField<T>` instead of just plain `T`?

Using `JsonField<T>` enables a few features:

- Allowing usage of [undocumented API functionality](#undocumented-api-functionality)
- Lazily [validating the API response against the expected shape](#response-validation)
- Representing absent vs explicitly null values

### Why don't you use [`data` classes](https://kotlinlang.org/docs/data-classes.html)?

It is not [backwards compatible to add new fields to a data class](https://kotlinlang.org/docs/api-guidelines-backward-compatibility.html#avoid-using-data-classes-in-your-api) and we don't want to introduce a breaking change every time we add a field to a class.

### Why don't you use checked exceptions?

Checked exceptions are widely considered a mistake in the Java programming language. In fact, they were omitted from Kotlin for this reason.

Checked exceptions:

- Are verbose to handle
- Encourage error handling at the wrong level of abstraction, where nothing can be done about the error
- Are tedious to propagate due to the [function coloring problem](https://journal.stuffwithstuff.com/2015/02/01/what-color-is-your-function)
- Don't play well with lambdas (also due to the function coloring problem)

## Semantic versioning

This package generally follows [SemVer](https://semver.org/spec/v2.0.0.html) conventions, though certain backwards-incompatible changes may be released as minor versions:

1. Changes to library internals which are technically public but not intended or documented for external use. _(Please open a GitHub issue to let us know if you are relying on such internals.)_
2. Changes that we do not expect to impact the vast majority of users in practice.

We take backwards-compatibility seriously and work hard to ensure you can rely on a smooth upgrade experience.

We are keen for your feedback; please open an [issue](https://www.github.com/openai/openai-java/issues) with questions, bugs, or suggestions.
