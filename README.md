# OpenAI Java API Library

> [!NOTE]  
> The OpenAI Java API Library is currently in _beta_.
>
> There may be minor breaking changes.
>
> Have thoughts or feedback? [File an issue](https://github.com/openai/openai-java/issues/new) or comment on [this thread](https://community.openai.com/t/your-feedback-requested-java-sdk/1061029).

<!-- x-release-please-start-version -->

[![Maven Central](https://img.shields.io/maven-central/v/com.openai/openai-java)](https://central.sonatype.com/artifact/com.openai/openai-java/0.42.0)
[![javadoc](https://javadoc.io/badge2/com.openai/openai-java/0.42.0/javadoc.svg)](https://javadoc.io/doc/com.openai/openai-java/0.42.0)

<!-- x-release-please-end -->

The OpenAI Java SDK provides convenient access to the [OpenAI REST API](https://platform.openai.com/docs) from applications written in Java.

<!-- x-release-please-start-version -->

The REST API documentation can be found on [platform.openai.com](https://platform.openai.com/docs). Javadocs are also available on [javadoc.io](https://javadoc.io/doc/com.openai/openai-java/0.42.0).

<!-- x-release-please-end -->

## Installation

<!-- x-release-please-start-version -->

### Gradle

```kotlin
implementation("com.openai:openai-java:0.42.0")
```

### Maven

```xml
<dependency>
  <groupId>com.openai</groupId>
  <artifactId>openai-java</artifactId>
  <version>0.42.0</version>
</dependency>
```

<!-- x-release-please-end -->

## Requirements

This library requires Java 8 or later.

## Usage

See the [`openai-java-example`](openai-java-example/src/main/java/com/openai/example) directory for complete and runnable examples.

The primary API for interacting with OpenAI models is the [Responses API](https://platform.openai.com/docs/api-reference/responses). You can generate text from the model with the code below.

```java
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.responses.Response;
import com.openai.models.responses.ResponseCreateParams;

// Configures using the `OPENAI_API_KEY`, `OPENAI_ORG_ID` and `OPENAI_PROJECT_ID` environment variables
OpenAIClient client = OpenAIOkHttpClient.fromEnv();

ResponseCreateParams params = ResponseCreateParams.builder()
        .input("Say this is a test")
        .model(ChatModel.GPT_4O)
        .build();
Response response = client.responses().create(params);
```

The previous standard (supported indefinitely) for generating text is the [Chat Completions API](https://platform.openai.com/docs/api-reference/chat). You can use that API to generate text from the model with the code below.

```java
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionCreateParams;

// Configures using the `OPENAI_API_KEY`, `OPENAI_ORG_ID` and `OPENAI_PROJECT_ID` environment variables
OpenAIClient client = OpenAIOkHttpClient.fromEnv();

ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
    .addUserMessage("Say this is a test")
    .model(ChatModel.O3_MINI)
    .build();
ChatCompletion chatCompletion = client.chat().completions().create(params);
```

## Client configuration

Configure the client using environment variables:

```java
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;

// Configures using the `OPENAI_API_KEY`, `OPENAI_ORG_ID` and `OPENAI_PROJECT_ID` environment variables
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
    // Configures using the `OPENAI_API_KEY`, `OPENAI_ORG_ID` and `OPENAI_PROJECT_ID` environment variables
    .fromEnv()
    .apiKey("My API Key")
    .build();
```

See this table for the available options:

| Setter         | Environment variable | Required | Default value |
| -------------- | -------------------- | -------- | ------------- |
| `apiKey`       | `OPENAI_API_KEY`     | true     | -             |
| `organization` | `OPENAI_ORG_ID`      | false    | -             |
| `project`      | `OPENAI_PROJECT_ID`  | false    | -             |

> [!TIP]
> Don't create more than one client in the same application. Each client has a connection pool and
> thread pools, which are more efficient to share between requests.

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

// Configures using the `OPENAI_API_KEY`, `OPENAI_ORG_ID` and `OPENAI_PROJECT_ID` environment variables
OpenAIClient client = OpenAIOkHttpClient.fromEnv();

ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
    .addUserMessage("Say this is a test")
    .model(ChatModel.O3_MINI)
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

// Configures using the `OPENAI_API_KEY`, `OPENAI_ORG_ID` and `OPENAI_PROJECT_ID` environment variables
OpenAIClientAsync client = OpenAIOkHttpClientAsync.fromEnv();

ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
    .addUserMessage("Say this is a test")
    .model(ChatModel.O3_MINI)
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

### Streaming helpers

The SDK provides conveniences for streamed chat completions. A
[`ChatCompletionAccumulator`](openai-java-core/src/main/kotlin/com/openai/helpers/ChatCompletionAccumulator.kt)
can record the stream of chat completion chunks in the response as they are processed and accumulate 
a [`ChatCompletion`](openai-java-core/src/main/kotlin/com/openai/models/chat/completions/ChatCompletion.kt)
object similar to that which would have been returned by the non-streaming API.

For a synchronous response add a
[`Stream.peek()`](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#peek-java.util.function.Consumer-)
call to the stream pipeline to accumulate each chunk:

```java
import com.openai.core.http.StreamResponse;
import com.openai.helpers.ChatCompletionAccumulator;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionChunk;

ChatCompletionAccumulator chatCompletionAccumulator = ChatCompletionAccumulator.create();

try (StreamResponse<ChatCompletionChunk> streamResponse =
        client.chat().completions().createStreaming(createParams)) {
    streamResponse.stream()
            .peek(chatCompletionAccumulator::accumulate)
            .flatMap(completion -> completion.choices().stream())
            .flatMap(choice -> choice.delta().content().stream())
            .forEach(System.out::print);
}

ChatCompletion chatCompletion = chatCompletionAccumulator.chatCompletion();
```

For an asynchronous response, add the `ChatCompletionAccumulator` to the `subscribe()` call:

```java
import com.openai.helpers.ChatCompletionAccumulator;
import com.openai.models.chat.completions.ChatCompletion;

ChatCompletionAccumulator chatCompletionAccumulator = ChatCompletionAccumulator.create();

client.chat()
        .completions()
        .createStreaming(createParams)
        .subscribe(chunk -> chatCompletionAccumulator.accumulate(chunk).choices().stream()
                .flatMap(choice -> choice.delta().content().stream())
                .forEach(System.out::print))
        .onCompleteFuture()
        .join();

ChatCompletion chatCompletion = chatCompletionAccumulator.chatCompletion();
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

FileContentParams params = FileContentParams.builder()
    .fileId("file_id")
    .build();
HttpResponse response = client.files().content(params);
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
    .model(ChatModel.O3_MINI)
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

### Request IDs

> For more information on debugging requests, see [the API docs](https://platform.openai.com/docs/api-reference/debugging-requests).

When using raw responses, you can access the `x-request-id` response header using the `requestId()` method:

```java
import com.openai.core.http.HttpResponseFor;
import com.openai.models.chat.completions.ChatCompletion;
import java.util.Optional;

HttpResponseFor<ChatCompletion> chatCompletion = client.chat().completions().withRawResponse().create(params);
Optional<String> requestId = chatCompletion.requestId();
```

This can be used to quickly log failing requests and report them back to OpenAI.

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

- [`OpenAIInvalidDataException`](openai-java-core/src/main/kotlin/com/openai/errors/OpenAIInvalidDataException.kt): Failure to interpret successfully parsed data. For example, when accessing a property that's supposed to be required, but the API unexpectedly omitted it from the response.

- [`OpenAIException`](openai-java-core/src/main/kotlin/com/openai/errors/OpenAIException.kt): Base class for all exceptions. Most errors will result in one of the previously mentioned ones, but completely generic errors may be thrown using the base class.

## Pagination

For methods that return a paginated list of results, this library provides convenient ways access the results either one page at a time, or item-by-item across all pages.

### Auto-pagination

To iterate through all results across all pages, you can use `autoPager`, which automatically handles fetching more pages for you:

### Synchronous

```java
import com.openai.models.finetuning.jobs.FineTuningJob;
import com.openai.models.finetuning.jobs.JobListPage;

// As an Iterable:
JobListPage page = client.fineTuning().jobs().list(params);
for (FineTuningJob job : page.autoPager()) {
    System.out.println(job);
};

// As a Stream:
client.fineTuning().jobs().list(params).autoPager().stream()
    .limit(50)
    .forEach(job -> System.out.println(job));
```

### Asynchronous

```java
// Using forEach, which returns CompletableFuture<Void>:
asyncClient.fineTuning().jobs().list(params).autoPager()
    .forEach(job -> System.out.println(job), executor);
```

### Manual pagination

If none of the above helpers meet your needs, you can also manually request pages one-by-one. A page of results has a `data()` method to fetch the list of objects, as well as top-level `response` and other methods to fetch top-level data about the page. It also has methods `hasNextPage`, `getNextPage`, and `getNextPageParams` methods to help with pagination.

```java
import com.openai.models.finetuning.jobs.FineTuningJob;
import com.openai.models.finetuning.jobs.JobListPage;

JobListPage page = client.fineTuning().jobs().list(params);
while (page != null) {
    for (FineTuningJob job : page.data()) {
        System.out.println(job);
    }

    page = page.getNextPage().orElse(null);
}
```

## Logging

The SDK uses the standard [OkHttp logging interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor).

Enable logging by setting the `OPENAI_LOG` environment variable to `info`:

```sh
$ export OPENAI_LOG=info
```

Or to `debug` for more verbose logging:

```sh
$ export OPENAI_LOG=debug
```

## Microsoft Azure

To use this library with [Azure OpenAI](https://learn.microsoft.com/azure/ai-services/openai/overview), use the same 
OpenAI client builder but with the Azure-specific configuration.

```java
OpenAIClient client = OpenAIOkHttpClient.builder()
        // Gets the API key from the `AZURE_OPENAI_KEY` environment variable
        .fromEnv()
        // Set the Azure Entra ID
        .credential(BearerTokenCredential.create(AuthenticationUtil.getBearerTokenSupplier(
                new DefaultAzureCredentialBuilder().build(), "https://cognitiveservices.azure.com/.default")))
        .build();
```

See the complete Azure OpenAI example in the [`openai-java-example`](openai-java-example/src/main/java/com/openai/example/AzureEntraIdExample.java) directory. The other examples in the directory also work with Azure as long as the client is configured to use it.  

## Network options

### Retries

The SDK automatically retries 2 times by default, with a short exponential backoff.

Only the following error types are retried:

- Connection errors (for example, due to a network connectivity problem)
- 408 Request Timeout
- 409 Conflict
- 429 Rate Limit
- 5xx Internal

The API may also explicitly instruct the SDK to retry or not retry a response.

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
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionCreateParams;

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
import com.openai.models.chat.completions.ChatCompletionCreateParams;

ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
    .addUserMessage("Say this is a test")
    .model(JsonValue.from(42))
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
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionCreateParams;

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
