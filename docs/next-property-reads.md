# Read JSON properties on Java `next`

Use `_allProperties()` to look up a field by its JSON name. The same lookup works before and after the SDK declares that field. Recompile callers that used `_additionalProperties()` on JSON models, request bodies, Structured Outputs wrappers, or deprecated beta Realtime models.

Given a `RealtimeResponseStatus.Error`, change the Java lookup from

```java
JsonValue type = error._additionalProperties().get("type");
```

to

```java
JsonValue type = error._allProperties().get("type");
```

In Kotlin, change `error._additionalProperties()["type"]` to

```kotlin
val type: JsonValue? = error._allProperties()["type"]
```

A missing key returns `null`. An explicit JSON null is a present `JsonValue` whose `isNull()` returns `true`. A present declared field wins a collision with an extra, including when the declared value is null or has an unexpected JSON type. If the declared field is missing, the map retains an extra with that name. The returned map is immutable.

When iterating the map, expect declared fields as well as extras. Copying every entry into another model's `putAllAdditionalProperties()` can also copy fields such as `id` and `type`. If you own a set of extension keys, look those keys up individually. The complete view does not identify which entries were unknown to the SDK. Builders still accept `putAdditionalProperty()` for writing extras.
