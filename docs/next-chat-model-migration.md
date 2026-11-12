# Migrate retired chat model constants

Java v5 removes three named model constants and their matching `Known` and
`Value` enum members from `ChatModel` and the surviving Responses model
types that exposed them.

| Removed constant | Model ID |
| --- | --- |
| `GPT_4_VISION_PREVIEW` | `gpt-4-vision-preview` |
| `GPT_3_5_TURBO_0613` | `gpt-3.5-turbo-0613` |
| `GPT_3_5_TURBO_16K_0613` | `gpt-3.5-turbo-16k-0613` |

Choose a supported model for your endpoint and deployment. Replace references
to the removed fields in Java and Kotlin, including enum comparisons and
switches, and recompile. An existing binary that reads a removed field can
throw `NoSuchFieldError`. See the [API deprecation record](https://developers.openai.com/api/docs/deprecations).

**Before**

```java
ChatModel model = ChatModel.GPT_4_VISION_PREVIEW;
```

**After**

```java
String modelId = Objects.requireNonNull(System.getenv("OPENAI_MODEL"), "Set OPENAI_MODEL");
ChatModel model = ChatModel.of(modelId);
```

Set `OPENAI_MODEL` to the ID you selected. `ChatModel.of(String)` also accepts
custom deployment names. Use `model.asString()` to read the original value,
including when you deserialize an older payload containing a retired ID.
For those IDs, the legacy `value()` method returns `Value._UNKNOWN`, and
`known()` throws `OpenAIInvalidDataException`.
