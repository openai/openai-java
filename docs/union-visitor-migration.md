# Union visitors in version 5 of the Java SDK

When the SDK adds a union variant, an existing visitor can handle it through
`unknown`. Keep any `visit…` overrides that need variant-specific behavior.
A typed override still takes precedence. The default fallback throws
`OpenAIInvalidDataException`.

For example, this Java 8 visitor handles a video reference supplied as either
JSON or a binary upload. It also handles new JSON variants without recompilation.

```java
import com.openai.core.JsonValue;
import com.openai.models.videos.VideoCreateParams;

VideoCreateParams.InputReference.Visitor<String> label =
        new VideoCreateParams.InputReference.Visitor<String>() {
            @Override
            public String unknown(JsonValue json) {
                return "JSON reference";
            }

            @Override
            public String unknown(Object upload) {
                return "binary reference";
            }
        };
```

Kotlin uses the same overloads.

```kotlin
val label = object : VideoCreateParams.InputReference.Visitor<String> {
    override fun unknown(json: JsonValue?) = "JSON reference"
    override fun unknown(value: Any?) = "binary reference"
}
```

An unhandled known JSON variant passes its value through `JsonValue.from`.
An unrecognized wire variant passes its stored JSON to `unknown(JsonValue)`.
To inspect the original JSON of a deserialized union, use the union's `_json()`
accessor. A union that carries a binary upload also exposes `unknown(Object)`.
This overload receives the original upload value, including any streams. The
visitor decides whether to read or close them.

If your class implements two visitor interfaces and both add a default method
with the same signature, override that method once on the class. For a JSON
variant, the override can call `unknown(JsonValue.from(value))`. Recompile the
combined visitor before running it with the newer SDK. An already compiled
class with conflicting inherited defaults can fail when that method is called.

The deprecated storage-provider visitors in `ExternalStorageConfiguration`,
`ExternalStorageCreateParams`, and
`AuditLogListResponse.ExternalStorageRegistered.Data` keep their AWS and Azure
methods. Implement both when using those visitors. Their `accept` methods
already send providers added after those two to `unknown(JsonValue)`.

Callers using `Handler.builder()` and `match` can continue to use their existing
handlers.
