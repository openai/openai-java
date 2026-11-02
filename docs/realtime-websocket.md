# Realtime WebSocket item references

Use `RealtimeConnection.sendResponseCreate` to mix ordinary input items with
references to existing items in the **same current Realtime session**. The
connection remains responsible for send admission and delivery. The
[Realtime WebSocket example](../openai-java-example/src/main/java/com/openai/example/RealtimeWebSocketExample.java)
shows how to open a connection and receive events.

For a function call already returned by that session, put its item reference
before its tool result. `functionCallItemId` is the conversation item's ID;
`callId` is the function call's call ID. Use the IDs from the received function
call, and supply your application's tool result:

```java
import com.openai.helpers.RealtimeConnection.ResponseInput;
import com.openai.models.realtime.ConversationItem;
import com.openai.models.realtime.RealtimeConversationItemFunctionCallOutput;
import com.openai.models.realtime.ResponseCreateEvent;
import java.util.Arrays;

connection.sendResponseCreate(
        ResponseCreateEvent.builder().build(),
        Arrays.asList(
                ResponseInput.ofReference(functionCallItemId),
                ResponseInput.ofItem(ConversationItem.ofFunctionCallOutput(
                        RealtimeConversationItemFunctionCallOutput.builder()
                                .callId(callId)
                                .output(toolResult)
                                .build()))));
```

Passing `Collections.emptyList()` sends `response.input: []`, replacing any input
in the supplied event. Other event and response fields remain unchanged. Existing
`List<ConversationItem>` inputs, conversation-item readers, and conversation-item
create events keep their existing types.

When reconnecting opens a new model session, the previous session's items are not
restored. Reference only item IDs valid in the connection's current session. See
[Realtime recovery](../README.md#reconnecting-to-realtime) for that separate
workflow.
