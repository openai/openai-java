# Extensible string values in Java v5

A string such as a model ID can reach your application before you update the
SDK. Use the wrapper's named constants for values you recognize. Use
`asString()` to read any string the server sends, and include a fallback when
your application branches on that value.

## Java

Before

```java
boolean selected = model.value() == ChatModel.Value.GPT_4O;
```

After

```java
boolean selected = model.asString().equals(ChatModel.GPT_4O.asString());
```

To send a value introduced after your installed SDK, use
`ChatModel.of("example-future-model")`. It serializes as the string you supplied.

## Kotlin

```kotlin
fun label(model: ChatModel): String =
    when (model.asString()) {
        ChatModel.GPT_4O.asString() -> "GPT-4o"
        else -> model.asString()
    }
```

If a response contains a different JSON type, `asString()` throws
`OpenAIInvalidDataException`. Read `_value()` to inspect the original JSON.

## Existing projections

Java v5 deprecates the published `Known` and `Value` enums and their
`known()` and `value()` accessors on extensible string wrappers. During the
transition, `value()` returns `Value._UNKNOWN` for an unrecognized value.
`known()` throws for that value. Existing wrappers retain their named
constants, `of(String)`, equality, and serialization.

If a grandfathered type's values change, the SDK may retire its deprecated
projections in the minor release that makes that change. For example, a later
minor release that adds a model ID to `ChatModel` may add its wrapper constant
and remove `ChatModel.Known`, `ChatModel.Value`, `known()`, and `value()`.
Migrate code that references those types or methods before updating to that
release. Binaries that reference a removed symbol also need recompilation
after migration.

New extensible string wrappers expose the string API directly. Their
`validate()` accepts any string. Types that the API declares as fixed retain
their closed projections and reject unrecognized values during validation.
