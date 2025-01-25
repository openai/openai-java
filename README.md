# OpenAI Java API Library

> [!NOTE]  
> The OpenAI Java API Library is currently in _beta_.
>
> There may be frequent breaking changes.
>
> Have thoughts or feedback? [File an issue](https://github.com/openai/openai-java/issues/new) or comment on [this thread](https://community.openai.com/t/your-feedback-requested-java-sdk/1061029).

<!-- x-release-please-start-version -->

[![Maven Central](https://img.shields.io/maven-central/v/com.openai/openai-java)](https://central.sonatype.com/artifact/com.openai/openai-java/0.14.1)
[![javadoc](https://javadoc.io/badge2/com.openai/openai-java/0.14.1/javadoc.svg)](https://javadoc.io/doc/com.openai/openai-java/0.14.1)

<!-- x-release-please-end -->

The OpenAI Java SDK provides convenient access to the OpenAI REST API from applications written in Java.

The REST API documentation can be found on [platform.openai.com](https://platform.openai.com/docs). Javadocs are also available on [javadoc.io](https://javadoc.io/doc/com.openai/openai-java/0.0.1).

## Installation

<!-- x-release-please-start-version -->

### Gradle

```kotlin
implementation("com.openai:openai-java:0.14.1")
```

### Maven

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>0.14.1</version>
</dependency>
```

<!-- x-release-please-end -->

## Requirements

This library requires Java 8 or later.

## Usage

### Configure the client

Use `OpenAIOkHttpClient.builder()` to configure the client. At a minimum you need to set `.apiKey()`:

```java
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;

OpenAIClient client = OpenAIOkHttpClient.builder()
    .apiKey("My API Key")
    .build();
```

Alternately, set the environment with `OPENAI_API_KEY`, `OPENAI_ORG_ID` or `OPENAI_PROJECT_ID`, and use `OpenAIOkHttpClient.fromEnv()` to read from the environment.

```java
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;

OpenAIClient client = OpenAIOkHttpClient.fromEnv();

// Note: you can also call fromEnv() from the client builder, for example if you need to set additional properties
OpenAIClient client = OpenAIOkHttpClient.builder()
    .fromEnv()
    // ... set properties on the builder
    .build();
```

| Property     | Environment variable | Required | Default value |
| ------------ | -------------------- | -------- | ------------- |
| apiKey       | `OPENAI_API_KEY`     | true     | —             |
| organization | `OPENAI_ORG_ID`      | false    | —             |
| project      | `OPENAI_PROJECT_ID`  | false    | —             |

Read the documentation for more configuration options.

---

### Example: creating a resource

To create a new chat completion, first use the `ChatCompletionCreateParams` builder to specify attributes, then pass that to the `create` method of the `completions` service.

```java
import com.openai.models.ChatCompletion;
import com.openai.models.ChatCompletionCreateParams;
import com.openai.models.ChatCompletionUserMessageParam;
import com.openai.models.ChatModel;

ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
    .addMessage(ChatCompletionUserMessageParam.builder()
        .content("Say this is a test")
        .build())
    .model(ChatModel.O1)
    .build();
ChatCompletion chatCompletion = client.chat().completions().create(params);
```

### Example: listing resources

The OpenAI API provides a `list` method to get a paginated list of jobs. You can retrieve the first page by:

```java
import com.openai.models.FineTuningJob;
import com.openai.models.FineTuningJobListPage;

FineTuningJobListPage page = client.fineTuning().jobs().list();
for (FineTuningJob job : page.data()) {
    System.out.println(job);
}
```

Use the `FineTuningJobListParams` builder to set parameters:

```java
import com.openai.models.FineTuningJobListPage;
import com.openai.models.FineTuningJobListParams;

FineTuningJobListParams params = FineTuningJobListParams.builder()
    .after("after")
    .limit(20L)
    .build();
FineTuningJobListPage page1 = client.fineTuning().jobs().list(params);

// Using the `from` method of the builder you can reuse previous params values:
FineTuningJobListPage page2 = client.fineTuning().jobs().list(FineTuningJobListParams.builder()
    .from(params)
    .build());

// Or easily get params for the next page by using the helper `getNextPageParams`:
FineTuningJobListPage page3 = client.fineTuning().jobs().list(params.getNextPageParams(page2));
```

See [Pagination](#pagination) below for more information on transparently working with lists of objects without worrying about fetching each page.

---

## Requests

### Parameters and bodies

To make a request to the OpenAI API, you generally build an instance of the appropriate `Params` class.

In [Example: creating a resource](#example-creating-a-resource) above, we used the `ChatCompletionCreateParams.builder()` to pass to the `create` method of the `completions` service.

Sometimes, the API may support other properties that are not yet supported in the Java SDK types. In that case, you can attach them using the `putAdditionalProperty` method.

```java
import com.openai.core.JsonValue;
import com.openai.models.ChatCompletionCreateParams;

ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
    // ... normal properties
    .putAdditionalProperty("secret_param", JsonValue.from("4242"))
    .build();
```

## Responses

### Response validation

When receiving a response, the OpenAI Java SDK will deserialize it into instances of the typed model classes. In rare cases, the API may return a response property that doesn't match the expected Java type. If you directly access the mistaken property, the SDK will throw an unchecked `OpenAIInvalidDataException` at runtime. If you would prefer to check in advance that that response is completely well-typed, call `.validate()` on the returned model.

```java
import com.openai.models.ChatCompletion;

ChatCompletion chatCompletion = client.chat().completions().create().validate();
```

### Response properties as JSON

In rare cases, you may want to access the underlying JSON value for a response property rather than using the typed version provided by this SDK. Each model property has a corresponding JSON version, with an underscore before the method name, which returns a `JsonField` value.

```java
import com.openai.core.JsonField;
import java.util.Optional;

JsonField field = responseObj._field();

if (field.isMissing()) {
  // Value was not specified in the JSON response
} else if (field.isNull()) {
  // Value was provided as a literal null
} else {
  // See if value was provided as a string
  Optional<String> jsonString = field.asString();

  // If the value given by the API did not match the shape that the SDK expects
  // you can deserialise into a custom type
  MyClass myObj = responseObj._field().asUnknown().orElseThrow().convert(MyClass.class);
}
```

### Additional model properties

Sometimes, the server response may include additional properties that are not yet available in this library's types. You can access them using the model's `_additionalProperties` method:

```java
import com.openai.core.JsonValue;

JsonValue secret = errorObject._additionalProperties().get("secret_field");
```

---

## Pagination

For methods that return a paginated list of results, this library provides convenient ways access the results either one page at a time, or item-by-item across all pages.

### Auto-pagination

To iterate through all results across all pages, you can use `autoPager`, which automatically handles fetching more pages for you:

### Synchronous

```java
import com.openai.models.FineTuningJob;
import com.openai.models.FineTuningJobListPage;

// As an Iterable:
FineTuningJobListPage page = client.fineTuning().jobs().list(params);
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
import com.openai.models.FineTuningJob;
import com.openai.models.FineTuningJobListPage;

FineTuningJobListPage page = client.fineTuning().jobs().list(params);
while (page != null) {
    for (FineTuningJob job : page.data()) {
        System.out.println(job);
    }

    page = page.getNextPage().orElse(null);
}
```

---

## Error handling

This library throws exceptions in a single hierarchy for easy handling:

- **`OpenAIException`** - Base exception for all exceptions

- **`OpenAIServiceException`** - HTTP errors with a well-formed response body we were able to parse. The exception message and the `.debuggingRequestId()` will be set by the server.

  | 400    | BadRequestException           |
  | ------ | ----------------------------- |
  | 401    | AuthenticationException       |
  | 403    | PermissionDeniedException     |
  | 404    | NotFoundException             |
  | 422    | UnprocessableEntityException  |
  | 429    | RateLimitException            |
  | 5xx    | InternalServerException       |
  | others | UnexpectedStatusCodeException |

- **`OpenAIIoException`** - I/O networking errors
- **`OpenAIInvalidDataException`** - any other exceptions on the client side, e.g.:
  - We failed to serialize the request body
  - We failed to parse the response body (has access to response code and body)

## Microsoft Azure OpenAI

To use this library with [Azure OpenAI](https://learn.microsoft.com/azure/ai-services/openai/overview), use the same 
OpenAI client builder but with the Azure-specific configuration. 

```java
OpenAIOkHttpClient.Builder clientBuilder = OpenAIOkHttpClient.builder();

/* Azure-specific code starts here */
// You can either set 'endpoint' directly in the builder.
// or set the env var "AZURE_OPENAI_ENDPOINT" and use fromEnv() method instead
clientBuilder
    .baseUrl(System.getenv("AZURE_OPENAI_ENDPOINT"))
    .credential(BearerTokenCredential.create(
        AuthenticationUtil.getBearerTokenSupplier(
            new DefaultAzureCredentialBuilder().build(), "https://cognitiveservices.azure.com/.default")
    ));
/* Azure-specific code ends here */

OpenAIClient client = clientBuilder.build();

ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
    .addMessage(ChatCompletionMessageParam.ofChatCompletionUserMessageParam(
        ChatCompletionUserMessageParam.builder()
            .content(ChatCompletionUserMessageParam.Content.ofTextContent("Who won the world series in 2020?"))
            .build()))
    .model("gpt-4o")
    .build();

ChatCompletion chatCompletion = client.chat().completions().create(params);

List<ChatCompletion.Choice> choices = chatCompletion.choices();
for (ChatCompletion.Choice choice : choices) {
    System.out.println("Choice content: " + choice.message().content().get());
}
```

See the complete Azure OpenAI examples in the [Azure OpenAI example](https://github.com/openai/openai-java/tree/next/openai-azure-java-example/src/main/java/com.openai.azure.examples).

## Network options

### Retries

Requests that experience certain errors are automatically retried 2 times by default, with a short exponential backoff. Connection errors (for example, due to a network connectivity problem), 408 Request Timeout, 409 Conflict, 429 Rate Limit, and >=500 Internal errors will all be retried by default. You can provide a `maxRetries` on the client builder to configure this:

```java
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;

OpenAIClient client = OpenAIOkHttpClient.builder()
    .fromEnv()
    .maxRetries(4)
    .build();
```

### Timeouts

Requests time out after 10 minutes by default. You can configure this on the client builder:

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

Requests can be routed through a proxy. You can configure this on the client builder:

```java
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import java.net.InetSocketAddress;
import java.net.Proxy;

OpenAIClient client = OpenAIOkHttpClient.builder()
    .fromEnv()
    .proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("example.com", 8080)))
    .build();
```

## Making custom/undocumented requests

This library is typed for convenient access to the documented API. If you need to access undocumented params or response properties, the library can still be used.

### Undocumented request params

To make requests using undocumented parameters, you can provide or override parameters on the params object while building it.

```java
FooCreateParams address = FooCreateParams.builder()
    .id("my_id")
    .putAdditionalProperty("secret_prop", JsonValue.from("hello"))
    .build();
```

### Undocumented response properties

To access undocumented response properties, you can use `res._additionalProperties()` on a response object to get a map of untyped fields of type `Map<String, JsonValue>`. You can then access fields like `._additionalProperties().get("secret_prop").asString()` or use other helpers defined on the `JsonValue` class to extract it to a desired type.

## Logging

We use the standard [OkHttp logging interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor).

You can enable logging by setting the environment variable `OPENAI_LOG` to `info`.

```sh
$ export OPENAI_LOG=info
```

Or to `debug` for more verbose logging.

```sh
$ export OPENAI_LOG=debug
```

## Semantic versioning

This package generally follows [SemVer](https://semver.org/spec/v2.0.0.html) conventions, though certain backwards-incompatible changes may be released as minor versions:

1. Changes to library internals which are technically public but not intended or documented for external use. _(Please open a GitHub issue to let us know if you are relying on such internals.)_
2. Changes that we do not expect to impact the vast majority of users in practice.

We take backwards-compatibility seriously and work hard to ensure you can rely on a smooth upgrade experience.

We are keen for your feedback; please open an [issue](https://www.github.com/openai/openai-java/issues) with questions, bugs, or suggestions.
