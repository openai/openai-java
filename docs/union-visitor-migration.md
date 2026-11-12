# Union visitors in version 5 of the Java SDK

When the SDK adds a union variant, an existing visitor can handle it through
`unknown`. Keep any `visit…` overrides that need variant-specific behavior.
A typed override still takes precedence. The default fallback throws
`OpenAIInvalidDataException`.

This Java 8 visitor handles image edits supplied as a single upload or a list
of uploads. It also provides a fallback for unrecognized JSON variants.

```java
import com.openai.core.JsonValue;
import com.openai.models.images.ImageEditParams;

ImageEditParams.Image.Visitor<String> label =
        new ImageEditParams.Image.Visitor<String>() {
            @Override
            public String unknown(JsonValue json) {
                return "JSON image";
            }

            @Override
            public String unknown(Object upload) {
                return "binary upload";
            }
        };
```

Kotlin uses the same overloads.

```kotlin
import com.openai.core.JsonValue
import com.openai.models.images.ImageEditParams

val label = object : ImageEditParams.Image.Visitor<String> {
    override fun unknown(json: JsonValue?) = "JSON image"
    override fun unknown(value: Any?) = "binary upload"
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
