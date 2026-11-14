# Migrate from OpenAI Java 4 to 5

Recompile applications and libraries that call the changed APIs. Java source can still compile after a getter change when an assertion accepts any object. Check those comparisons explicitly. A string and an `Optional<String>` containing that string compare unequal.

## Structured outputs with Swagger annotations

If your application imports `@Schema` or `@ArraySchema` and relies on the SDK to
bring in those classes, declare an annotation dependency in the application.
Choose the variant your framework uses. Make it available both during
compilation and at runtime so structured output can read the annotations.

For standard Swagger annotations, add this Gradle dependency:

```kotlin
implementation("io.swagger.core.v3:swagger-annotations:2.2.31")
```

For Maven:

```xml
<dependency>
  <groupId>io.swagger.core.v3</groupId>
  <artifactId>swagger-annotations</artifactId>
  <version>2.2.31</version>
</dependency>
```

Jakarta applications can use `swagger-annotations-jakarta` in the same dependency
declaration. On the classpath, applications using only plain classes or Jackson
annotations can omit the Swagger annotations dependency.

On the module path, this also holds if your application does not resolve the
VicTools Swagger module (`com.github.victools.jsonschema.module.swagger.two`).
If your application resolves that module, choose either
`swagger-annotations:2.2.31` or `swagger-annotations-jakarta:2.2.31`.
Both provide the module `io.swagger.v3.oas.annotations`.
`--add-modules ALL-MODULE-PATH` resolves the VicTools Swagger module whenever
it is on the module path. For explicit roots, see the
[Responses module-path example](next-responses-package.md#java-module-path).

## Responses delegation tools and tool choices

The next major removes the nested `Visitor` interface and `accept(Visitor)` method from these types in `com.openai.models.live`:

- `ResponsesDelegationConfig.Tool`
- `ResponsesDelegationConfig.ToolChoice`
- `ResponsesDelegationUpdateConfig.Tool`
- `ResponsesDelegationUpdateConfig.ToolChoice`

Replace each visitor with a handler and recompile callers that reference a removed symbol. A binary compiled against one of the removed interfaces or methods can fail to link on the next major. An existing handler can continue to use `match`.

These examples use `com.openai.models.live.ResponsesDelegationConfig.Tool`. The old visitor also uses `com.openai.models.live.FunctionTool` and `com.openai.core.JsonValue`.

**Before**

```java
static String kind(Tool tool) {
    return tool.accept(new Tool.Visitor<String>() {
        @Override public String visitFunction(FunctionTool function) { return "function"; }
        @Override public String visitWebSearch(JsonValue webSearch) { return "web_search"; }
        @Override public String unknown(JsonValue json) { return "other"; }
    });
}
```

**After**

```java
static String kind(Tool tool) {
    return tool.match(Tool.Handler.<String>builder()
            .onFunction(function -> "function")
            .onWebSearch(webSearch -> "web_search")
            .onDefault(value -> "other")
            .build());
}
```

`onDefault` receives the union for an unregistered or unknown variant. Without an applicable callback, `match` throws `OpenAIInvalidDataException`. For an unknown JSON payload, the fallback can inspect `value._json()`.

For a Kotlin shell-tool handler that returns a required container ID, use
`Tool.Handler.builder<String>().onShell { it.environment().get().asContainerReference().containerIdOrThrow() }.build()`.

## Choose a client dependency

Keep `com.openai:openai-java` to use the full SDK with its existing client names. For an application that only calls Responses, select `com.openai:openai-java-responses` and import the SDK BOM. Use the same Java 5 version for every SDK dependency.

```kotlin
implementation(platform("com.openai:openai-java-bom:$sdkVersion"))
implementation("com.openai:openai-java-responses")
```

In Maven, import `com.openai:openai-java-bom` at the chosen SDK version in dependencyManagement with type `pom` and scope `import`. Declare the client dependency without a version. An application using both the full and Responses clients should use the same BOM for both. Upgrade libraries compiled against removed v4 APIs before combining them with v5. Version alignment cannot repair those binary references.

The Responses entry points are `com.openai.responses.OpenAIResponsesClient` and `com.openai.responses.okhttp.OpenAIResponsesOkHttpClient`. For a custom HTTP transport, select `openai-java-responses-api`, supply your transport through `ClientOptions`, and construct `new OpenAIResponsesClient(options)`. The neutral runtime is provided by `openai-java-runtime`. The `openai-java-http-okhttp` artifact supplies the optional adapter. Existing full SDK callers keep their supported service and OkHttp entry points. The Responses API owns the blocking and async Responses services. Its accumulator helpers live in `com.openai.responses.helpers`. The neutral OkHttp adapter uses `com.openai.http.okhttp`. On the module path, keep the full client’s existing module names and align the SDK modules with the BOM. A custom Responses client depends on the API and runtime and can omit OkHttp. See [Responses client setup](next-responses-package.md) for Maven and Gradle examples.

For Bedrock or Vertex, keep the corresponding `openai-java-bedrock` or `openai-java-vertex` dependency. Each brings in the full OkHttp client and its SDK runtime dependencies.

If your application directly references undocumented SDK classes for OkHttp or X.509, those references can fail to link after upgrading. The SDK’s [semantic versioning policy](../README.md#semantic-versioning) explains how compatibility applies to internals. Create the full client with `OpenAIOkHttpClient.builder()` or `OpenAIOkHttpClientAsync.builder()`. For client certificate authentication, configure `X509Transport` and pass it to `X509WorkloadIdentity`, as shown in the [X.509 setup example](../README.md#x509-client-certificate-authentication).

## Java and Kotlin dependencies

The minimum runtime is Java 8. The SDK targets Kotlin language/API 2.0 with compiler, standard library and reflection 2.4.21. Plan to compile Kotlin applications with at least Kotlin 2.3.0. Older Kotlin compilers can reject the standard library metadata even when the Java bytecode target is compatible.

The SDK uses OkHttp 4.12.1, Okio 3.6.0 and Jackson 2.21.8 with Jackson annotations 2.21. Applications using Jackson 3 can exchange JSON bytes with the SDK's Jackson 2 mapper. For minified applications, use R8 9.1.31 or ProGuard 7.10.0 with the consumer rules from the SDK and its dependencies. Exercise reflection and Kotlin constructor defaults in your minified application.

## Read a model property

For a required response ID, change `String id = response.id();` to
`String id = response.idOrThrow();`. Use `Optional<String> id = response.id();`
when the caller can proceed without it. In Kotlin a required method reference
becomes `Response::idOrThrow`. The primary getter returns empty on missing or
explicit null. Both typed getters reject an unexpected JSON type. Inspect
`response._id()` for the original field and distinguish `isMissing()` from
`isNull()`. Standalone deprecated beta Realtime models retain their v4 getters.

For a page, `items()` keeps the empty-list fallback. Use `dataOrThrow()` if
an absent list should fail.

For a received Live Decision item, compare the projected discriminator with the
item’s typed constant. This example imports
`com.openai.models.live.DecisionItemCreatedEvent.Item` and `java.util.Optional`.

```java
static boolean isMessage(Item item) {
    Optional<Item.Type> type = item.type();
    return type.filter(Item.Type.MESSAGE::equals).isPresent();
}
```

On that item, `typeOrThrow()` returns `Item.Type` and `_type()` exposes the
underlying `JsonField<Item.Type>`. The create-event counterpart,
`com.openai.models.live.DecisionItemCreateEvent.Item`, uses its own nested
`Type`. Once you select a leaf, use that leaf’s signature. For example,
`com.openai.models.live.DecisionStoredUserMessage.typeOrThrow()` returns
the wire constant as a `JsonValue`, which you can compare with
`JsonValue.from("message")`.

Replace `error._additionalProperties().get("type")` with
`error._allProperties().get("type")`. This immutable view includes declared
fields and extras. A declared value wins a collision, even for JSON null.
A missing key returns Java null. Copy only the extension keys you intend to
forward. Builders still support `putAdditionalProperty`.

## Handle new enum and union values

Change `model.value() == ChatModel.Value.GPT_4O` to
`model.asString().equals(ChatModel.GPT_4O.asString())`. Use
`ChatModel.of(wireId)` for a new model ID and handle unfamiliar strings in
switches. The deprecated `Known` and `Value` projections on extensible types
can be retired when that type's values change. Fixed enums keep their validation.

On evolving union visitors keep the typed overrides you use and implement
`unknown(JsonValue)` for other JSON variants. Binary-capable unions can also
dispatch to `unknown(Object)` with the original upload. Override a conflicting
default explicitly if one class implements two visitor interfaces. The three
deprecated storage-provider visitors still require their AWS and Azure methods.
For the four Live delegation unions above, use the handler API.

### Streaming compatibility

During Responses streaming, keep a fallback for unfamiliar events. With default
validation you can inspect `event._json()` and continue reading. With strict
response validation, an unknown non-keepalive event can fail during iteration. A scalar becoming a union, or a single variant gaining a second one, can change the Java type or builder. Build the concrete variant, wrap it with its factory and recompile.

## Migrate retired services and model constants

Replace `client.beta().assistants()` and `client.beta().threads()` calls,
including messages, runs and steps, with Responses requests. To keep state,
create a Conversation and pass its ID on subsequent turns. Supply the model,
instructions and tools on the request or use a saved prompt. Store the new
Conversation ID separately from historical Thread and Assistant IDs.

Remove `videos()`, `com.openai.models.videos` imports and batch requests to
`/v1/videos`. Sora video generation has no one-to-one replacement. These
removals affect blocking, async and raw clients.

Replace references to `GPT_4_VISION_PREVIEW`, `GPT_3_5_TURBO_0613` and
`GPT_3_5_TURBO_16K_0613`, including their nested enum members. Select a
supported model for new requests. When reading historical data the respective
wire IDs are `gpt-4-vision-preview`, `gpt-3.5-turbo-0613` and
`gpt-3.5-turbo-16k-0613`.

## Live delegation and Decision items

MCP tool choices require a server label and allow an omitted name.
`addMcpTool(serverLabel)` selects a server. In both the create and update
delegation configurations, read `name()` as an optional on the MCP tool choice
and its allowed-tools MCP entry. A function choice still requires its name.

Construct the role-specific message or tool item and pass it to the Decision
event builder. The legacy `Item.builder()` still builds a user message.
For a created event, select the stored variant. Inspect the variant before
reading its fields. Preserve unknown items with `_json()`. Use
`DecisionAssistantMessageContent` for create and stored assistant content,
`DecisionToolOutput` for function and custom tool output, and
`DecisionToolOutputContentPart` for list elements. Use `DecisionQuestion` in
delegation create, update and trigger lists. Import
`com.openai.models.decisions.DecisionChoiceOption` for choice builders.

## Responses history and tool calls

Read compacted GA history with `outputOrThrow()` as `List<ResponseItem>`.
Beta uses `List<BetaResponseItem>`. Handle retained input messages as well
as assistant output and compaction records. Preserve order and all fields on
replay. Ordinary create/retrieve responses still contain output items.
Update `ResponseInputItem.Visitor.visitCompactionTrigger` to accept
`ResponseInputItem.CompactionTrigger`. Construct a typed trigger and pass it
to `addItem(trigger)` or `item(trigger)` in place of the old no-argument
compaction shortcut.

When constructing a returned local-shell output, set both `id(outputItemId)`
and `callId(originalToolCallId)`. The output item's ID and the ID used to
correlate the tool call serve different purposes. Use the typed setter in
place of an extra property named `call_id`.

## Realtime sessions

On `SessionUpdateEvent.Session`, change `ofRealtimeSessionCreateRequest` to
`ofRealtime` and `ofRealtimeTranscriptionSessionCreateRequest` to
`ofTranscription`. Use the corresponding `asRealtime`, `asTranscription`,
predicate and visitor names. Read a required update session with
`sessionOrThrow()`. The nested wire tag selects the model. Missing, null and
unknown tags preserve the nested JSON. A session update requires a session.
Client-secret creation permits omission. Kotlin callers using named builder arguments should use
`realtime =` or `transcription =`. See [Realtime request sessions](next-realtime-request-sessions.md) for the factory, accessor and visitor names.

## Read response headers from exceptions

In Java 5, `OpenAIException.headers()` returns `Optional<Headers>`. Use it to
inspect HTTP errors and failures during response parsing, validation, or streaming.
The optional is empty when the request fails before a response arrives. A
response with zero headers has a present, empty `Headers`.

For an `OpenAIServiceException`, change `e.headers().values("x-request-id")` to
`e.headers().map(h -> h.values("x-request-id")).orElse(Collections.emptyList())`.
Recompile callers that used the v4 service-exception accessor. Its JVM return
type changed, so existing binaries can throw `NoSuchMethodError`. Select
individual safe values when logging.

## Graders, deletion results and response shapes

Pass a map of entry names to `MultiGrader.Graders` values to `graders(...)`.
Read the keyed map directly with `gradersOrThrow()` or handle absence with `graders()`. Use the map keys in `calculateOutput`. A grader's display name can differ
from its key. Read structured grader token usage as an object. When reading archived integer usage, inspect `_tokenUsage().asNumber()` before using the typed getter.

Container, container-file, GA Responses and beta Responses deletes return typed
results. For an async wrapper returning `CompletableFuture<Void>`, use
`.thenApply(result -> null)`. Raw deletes return `HttpResponseFor<T>`.
Update vector-store file-batch fixtures to expect `vector_store.file_batch`
from the builder. Decoding also accepts the older spelling
`vector_store.files_batch` and preserves it on serialization.

Treat stored-chat first/last cursors, the outer web-search action and fine-tuning
seed as optional. For conversation metadata, read the typed metadata object and look up a key in its `_allProperties()` map. Convert a present JSON value with `asStringOrThrow()`.
Handle null batch file IDs and lifecycle timestamps, and absent Eval error,
model/name or usage/statistics data according to the result state.

For Managed Agents function tools, use the optional Boolean `async()` on the
`Function` variant of `AgentTool`, `AgentToolParam`, `PersistedAgentTool`
and `PersistedAgentToolParam`. Use the builder’s `async(boolean)` setter
when sending an explicit value.

## Further examples

- [Structured outputs with JSON schemas](../README.md#structured-outputs-with-json-schemas)
- [Extensible enums](next-enum-migration.md)
- [Union visitors](union-visitor-migration.md)
- [Model property accessors](next-json-property-getters.md#moving-from-v4)
- [Complete property views](next-property-reads.md)
- [Kotlin consumers](next-kotlin-migration.md)
- [Transport dependencies](okhttp-dependencies.md)
- [JVM and Jackson compatibility](version-support-policy.md#jackson-in-v5)
- [Live delegation and Decision variants](next-live-migration.md)
- [Assistants and Threads](assistants-migration.md)
- [Videos](next-videos-migration.md)
- [Retired model constants](next-chat-model-migration.md)
- [Compacted history](next-compaction-migration.md)
- [Local shell output IDs](next-local-shell-output.md)
- [Response contracts and token usage](next-response-contracts.md)
- [Named graders](next-multi-grader-migration.md)
- [Reading evolving responses](api-evolution.md)
- [Exception headers in Java and Kotlin](next-exception-headers.md)
