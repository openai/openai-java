# Realtime request sessions in Java 5

A session update uses the nested session's `type` to select a
`RealtimeSessionCreateRequest` (`realtime`) or a
`RealtimeTranscriptionSessionCreateRequest` (`transcription`). A known tag
selects its model even if the payload includes fields from the other model.
Missing, null, or unrecognized tags leave the nested object available through
`SessionUpdateEvent.Session._json()`. You can also handle it in
`SessionUpdateEvent.Session.Visitor.unknown`.

## Constructing an update

Java and Kotlin callers can pass either request model directly to the builder.

```java
var session = RealtimeSessionCreateRequest.builder().instructions("Speak slowly").build();
var event = SessionUpdateEvent.builder().session(session).build();
```

```kotlin
val session = RealtimeTranscriptionSessionCreateRequest.builder().build()
val event = SessionUpdateEvent.builder().session(session).build()
```

The Java signatures of these two builder overloads stay the same. Kotlin callers
using named arguments should use `realtime =` or `transcription =`, or pass the
model positionally.

## Reading an update or constructing its union explicitly

The methods on `SessionUpdateEvent.Session` now use the wire tag in their names.

| Java 4 | Java 5 |
| --- | --- |
| `ofRealtimeSessionCreateRequest` | `ofRealtime` |
| `ofRealtimeTranscriptionSessionCreateRequest` | `ofTranscription` |
| `realtimeSessionCreateRequest`, `isRealtimeSessionCreateRequest`, `asRealtimeSessionCreateRequest` | `realtime`, `isRealtime`, `asRealtime` |
| `realtimeTranscriptionSessionCreateRequest`, `isRealtimeTranscriptionSessionCreateRequest`, `asRealtimeTranscriptionSessionCreateRequest` | `transcription`, `isTranscription`, `asTranscription` |
| `Visitor.visitRealtimeSessionCreateRequest` | `Visitor.visitRealtime` |
| `Visitor.visitRealtimeTranscriptionSessionCreateRequest` | `Visitor.visitTranscription` |

Update and recompile callers and visitor implementations that reference the old
JVM method names. A session update still requires a session. Client-secret
creation still allows you to omit the session, and its factories and accessors
already use `realtime` and `transcription`.
