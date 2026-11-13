# Read response headers from SDK exceptions in Java 5

When the SDK throws an `OpenAIException` while handling an API response, catch it to read
headers from HTTP errors, response parsing and validation failures, and stream failures. Its `headers()` method returns `Optional<Headers>`.
The optional is empty if the request failed before the SDK received a response. A response
with zero headers returns a present, empty `Headers`.

Existing calls to `OpenAIServiceException.headers()` and its subclass overrides must handle
the optional. The following examples read all request IDs and return an empty list when none
are available.

**Java before**

```java
List<String> ids = e.headers().values("x-request-id");
```

**Java after**

```java
List<String> ids = e.headers().map(h -> h.values("x-request-id")).orElse(Collections.emptyList());
```

**Kotlin before**

```kotlin
val ids = e.headers().values("x-request-id")
```

**Kotlin after**

```kotlin
val ids = e.headers().map { it.values("x-request-id") }.orElse(emptyList())
```

The JVM return descriptor for service exceptions changes from
`()Lcom/openai/core/http/Headers;` to `()Ljava/util/Optional;`. Recompile callers after updating
their source. Previously compiled callers can throw `NoSuchMethodError` with version 5 of the SDK.
