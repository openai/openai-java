# Migrate Assistants calls to Responses and Conversations

Java v5 removes `client.beta().assistants()` and `client.beta().threads()`,
including their async and raw-response variants. The removed services include
thread messages, runs, and run steps. Recompile callers that imported models
from `com.openai.models.beta.assistants` or `com.openai.models.beta.threads`
and their subpackages.

Create a conversation to keep state across turns. Pass its ID to each Responses
request. Supply the model, instructions, and tools your application needs, or use
a saved prompt. Store the new conversation ID in your application. An existing
Assistant or Thread ID cannot serve as a conversation ID.

## Java

With an initialized `OpenAIClient client`, send the first turn as follows.

```java
import com.openai.models.responses.ResponseCreateParams;

String conversationId = client.conversations().create().idOrThrow();
String responseId = client.responses().create(ResponseCreateParams.builder()
        .model("gpt-4.1")
        .instructions("Answer in one sentence.")
        .conversation(conversationId)
        .input("What is a solar eclipse?")
        .build()).idOrThrow();
```

## Kotlin

```kotlin
import com.openai.models.responses.ResponseCreateParams

val conversationId = client.conversations().create().idOrThrow()
val responseId = client.responses().create(
    ResponseCreateParams.builder()
        .model("gpt-4.1")
        .instructions("Answer in one sentence.")
        .conversation(conversationId)
        .input("What is a solar eclipse?")
        .build()
).idOrThrow()
```

For a follow-up, reuse `conversationId` with the new input. For applications
that streamed run events, switch the event handlers to Responses streaming.
The [Assistants migration guide](https://developers.openai.com/api/docs/assistants/migration)
covers prompts, tools, and moving conversation history.
