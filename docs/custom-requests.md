# Custom requests

Use `CustomRequests` for a path that does not yet have a generated service method.
It snapshots an existing `OpenAIClient` configuration through `withOptions`, preserving
its transport, credentials, provider authentication hook, headers, query defaults,
retry policy, and timeouts. Creating the helper does not send a request or close the client.

```java
CustomRequests custom = CustomRequests.from(client);
CustomRequests.Request request = CustomRequests.Request.builder()
        .method(HttpMethod.POST)
        .path("/experimental/widgets") // Illustrative endpoint.
        .putQueryParam("mode", "preview")
        .putHeader("X-Preview", "enabled")
        .body(JsonValue.from(Map.of("name", "example")))
        .build();

try (HttpResponse response = custom.execute(request)) {
    // Read response.body() using your chosen binary or JSON decoder.
}
```

These types are `com.openai.helpers.CustomRequests`, `com.openai.core.JsonValue`,
`com.openai.core.http.HttpMethod`, and `com.openai.core.http.HttpResponse`.
The helper is blocking. It supports JSON request bodies and raw response streams;
asynchronous dispatch, multipart uploads, and typed response decoding are outside this
helper's scope. Prefer generated services when available.

## Paths and configuration

Paths are unencoded resource paths relative to the configured base URL. A single leading
slash is optional and does not remove the base URL's path prefix. `/` targets that base
URL. Each segment is encoded by the normal SDK transport. Supply literal characters,
not percent-encoded strings: `%2F` represents the literal text `%2F`, not a slash.
Empty or dot segments, trailing slashes, absolute URLs, scheme-relative URLs, queries,
fragments, backslashes, and control characters are rejected. Use `putQueryParam` for
query values. Configure a different destination on the client, not in a request path.

Supported methods are GET, HEAD, POST, PUT, PATCH, DELETE, and OPTIONS. GET and HEAD
cannot have a body. Omit `body` for no body or use `JsonValue.from(null)` for JSON null.
There is no body-size limit added by this helper.

Request headers and query values replace client defaults of the same name; repeated
values within a request are retained. Credentials are resolved through the SDK's normal
request preparation and per-attempt authentication. Requests default to ordinary bearer
authentication. For an admin endpoint, explicitly select the configured admin key:

```java
.securityOptions(SecurityOptions.builder().adminApiKeyAuth(true).build())
```

`SecurityOptions` is in `com.openai.core`. The helper does not infer authentication from
the resource path or silently use an admin key for ordinary requests. `execute(request, requestOptions)`
accepts per-request timeouts. The configured client owns all transport resources.

Azure routing follows existing client configuration. On legacy Azure endpoints the SDK
adds `openai`; supply `deployments/<deployment>/...` in the resource path for a deployment
endpoint. The helper does not infer a deployment from an arbitrary JSON `model` field.
On Azure v1 endpoints, use paths relative to the configured `/openai/v1` base URL.

## Responses and errors

Successful responses are returned without reading or buffering the body. Always close
them, including when decoding fails. Streaming and binary responses use the same raw
`body()` stream; the helper does not parse SSE events or validate a response schema.
Non-2xx responses use standard SDK exceptions and are closed by the error handler.
The client's existing retry policy applies, including to retryable POST failures;
use the endpoint's idempotency contract when making requests with side effects.

The helper uses the configured client transport and options; overrides of individual
generated service methods are not involved. Request/response data and authentication
headers may be sensitive: retain normal SDK logging defaults.

See the [Java example](../openai-java-example/src/main/java/com/openai/example/CustomRequestsExample.java),
which demonstrates raw access to the existing `/models` endpoint.
