# JSON property getters in the next Java SDK major

Use the primary getter when your code can handle a missing or null property. Use the throwing getter when your code needs a value.

**Before (v4)**

```java
String id = response.id();
```

**After (next)**

```java
String id = response.idOrThrow();
```

The same change applies to Kotlin callers and method references. For example, change `Response::id` to `Response::idOrThrow` when a function must return a string. Keep `Response::id` when it can return an `Optional<String>`.

| Accessor | Missing or JSON null | Value of the expected type | Unexpected JSON |
| --- | --- | --- | --- |
| `response.id()` | `Optional.empty()` | `Optional.of(value)` | Throws `OpenAIInvalidDataException` |
| `response.idOrThrow()` | Throws `OpenAIInvalidDataException` | Returns the value | Throws `OpenAIInvalidDataException` |
| `response._id()` | Distinguishes `isMissing()` and `isNull()` | Preserves the field | Preserves the JSON value |

The three method signatures stay the same when the API changes only whether a JSON property is required or nullable. The builder and validation still follow the request schema. For example, use `ApiKeyUpdateParams.Builder.expiresInSeconds(60L)` to send an expiry. Omit that setter to leave the expiry out of the request.

The standalone deprecated models in `com.openai.models.beta.realtime` keep their v4 getters. If you use those models, keep your existing getter calls. The current Realtime models in `com.openai.models.realtime` use the new getters.

## Moving from v4

Recompile callers for the new major. A previously compiled call to `Response.id(): String` has a different JVM descriptor from the new primary getter. The throwing getter retains primitive returns where applicable. For example, `expiresInSecondsOrThrow()` returns Java `long`. The API-key update's existing `expiresInSecondsOptional()` alias continues to work.

In Kotlin, give a method reference the return type your caller needs.

```kotlin
val requireId: (Response) -> String = Response::idOrThrow
val findId: (Response) -> Optional<String> = Response::id
```

For a list page, use `page.items()` to iterate with the existing empty-list fallback. Use `page.data()` to distinguish a missing collection from a present empty collection, or `page.dataOrThrow()` when a missing collection should fail.

Some v4 literal and free-form properties exposed only a raw `JsonValue` getter. For example, `response._object_()` now returns `JsonField<JsonValue>`. Use `response.object_OrThrow()` for the expected literal, or inspect the raw field to see the value the server sent. A throwing helper can have a trailing underscore when its preferred name is already a schema property's primary getter.

### Getter inventory

The migration inventory compares compiled model classes in v4.102.0 with the next-major preview. It counts each property once per class that exposes it, including request-body and pagination delegates.

| v4.102.0 primary getter | Properties in the preview | Caller change |
| --- | ---: | --- |
| Returned a value directly | 5,410 | Use the throwing getter. It retains the v4 return type for 5,408 properties. The two exceptions are scalar constants on `Subagent.object_()` and `Turn.object_()`, whose throwing getters return `JsonValue`. |
| Returned `Optional<T>` | 5,285 | The JVM return descriptor stays the same. For 63 scalar constants, the type inside `Optional` changes from a generated enum to `JsonValue`. |
| Exposed only a raw getter | 1,785 | Use the new optional or throwing getter for typed reads. Recompile raw reads that previously returned `JsonValue`. |

For example, the v4 getter for `DecisionItemCreatedEvent.Item.type()` returned `Optional<DecisionItemCreatedEvent.Item.Type>`. The next-major getter returns `Optional<JsonValue>`. Compare its value with `JsonValue.from("message")`. The builder still accepts `DecisionItemCreatedEvent.Item.Type.MESSAGE`. The raw getters for these 65 scalar constants also use `JsonValue` as the type inside `JsonField`.
