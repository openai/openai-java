# Reading evolving API responses in Java

## Streaming events

A Responses stream can carry a new event type before you update the SDK. With
the default response validation setting, your consumer can read the raw JSON
and continue to the following event. With `responseValidation(true)`, an
unrecognized type other than `keepalive` raises `OpenAIInvalidDataException`
during iteration.

```java
stream.stream().forEach(event -> {
    if (event.isOutputTextDelta()) {
        appendText(event.asOutputTextDelta()._delta().asStringOrThrow());
    } else {
        event._json().ifPresent(this::handleUnhandledEvent);
    }
});
```

The fallback receives the wire JSON for both unknown events and recognized
events without a branch in this application.
For Live delegation tools, a handler's `onDefault` receives both unregistered
known variants and unknown ones. See the [Live migration guide](next-live-migration.md).

## Object properties

Use `_allProperties()` to inspect JSON keys, including keys introduced after
the SDK was generated. The map uses wire names. It omits absent keys and keeps
explicit JSON nulls. If a declared property and an additional property have
the same key, the present declared property takes precedence in the map.
Use the declared builder setter for that wire key. Supplying the key again
through `putAdditionalProperty` can serialize two entries with the same name.

```java
Map<String, JsonValue> fields = event.asOutputTextDelta()._allProperties();
if (fields.containsKey("future_field")) {
    handleValue(fields.get("future_field"));
}
```

An array can contain objects whose keys differ only in case or punctuation.
Preserve those keys when forwarding raw values. Renaming them can overwrite
one of the original entries.

## Changes to typed getters

A wire-compatible value can require a Java migration. Suppose a generated
getter returned `String` and now returns a union with string and integer arms.
An old binary calling the string-returning getter can throw
`NoSuchMethodError`. Source that called string methods on the result also
needs an edit. Inspect the union arm before using its value and recompile.

A change from one variant to two can also move a builder. For example,
`ResponsesClientEvent` gained a second variant in 4.57.0. Both versions
round-trip the same `response.create` JSON. A caller compiled against the
4.56.0 builder fails to link with the 4.57.0 JAR.

**4.56.0**

```java
ResponsesClientEvent event = ResponsesClientEvent.builder().build();
```

**4.57.0**

```java
ResponsesClientEvent event = ResponsesClientEvent.ofResponseCreate(
        ResponsesClientEvent.ResponseCreate.builder().build());
```

Build the concrete variant, wrap it with its factory, and recompile the caller.
