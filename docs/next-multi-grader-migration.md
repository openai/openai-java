# MultiGrader migration

In the next Java major, each entry in `MultiGrader.graders` has a name and a
`MultiGrader.Graders` value. Use the entry name in `calculateOutput`. The
grader's own `name` may differ from the entry name.

**Before**

```java
builder.graders(exactMatch);
```

**After**

```java
Map<String, MultiGrader.Graders> graders = new LinkedHashMap<>();
graders.put("exact", MultiGrader.Graders.ofStringCheckGrader(exactMatch));
graders.put("similar", MultiGrader.Graders.ofTextSimilarityGrader(similarity));
MultiGrader combined = builder.graders(graders)
        .calculateOutput("0.5 * exact + 0.5 * similar")
        .build();

MultiGrader.Graders exact = combined.gradersOrThrow().get("exact");
```

The equivalent Kotlin call accepts a map built with `mapOf`.

```kotlin
val combined = builder
    .graders(
        mapOf(
            "exact" to MultiGrader.Graders.ofStringCheckGrader(exactMatch),
            "similar" to MultiGrader.Graders.ofTextSimilarityGrader(similarity),
        )
    )
    .calculateOutput("0.5 * exact + 0.5 * similar")
    .build()

val exact = combined.gradersOrThrow().getValue("exact")
```

`graders()` returns `Optional<Map<String, MultiGrader.Graders>>`.
`gradersOrThrow()` returns the map directly. Use `_graders()` to inspect the
raw `JsonField`. Recompile code that used the previous getter or single-grader
builder overloads.
