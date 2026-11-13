# Java response contracts in the next major

Container, container-file, Responses and beta Responses delete methods return the server's typed deletion result. The raw response exposes the same result through `parse()`. Recompile callers, including callers that ignored the old return value. For async code that explicitly returns `CompletableFuture<Void>`, map the result to null.

```java
boolean deleted = client.responses().delete(responseId).deletedOrThrow();
CompletableFuture<Void> completed =
        client.async().responses().delete(responseId).thenApply(ignored -> null);
```

New vector-store file batches serialize the object discriminator as `vector_store.file_batch`. Strict reads accept this spelling and the historical `vector_store.files_batch`. Serializing a decoded batch preserves the spelling received. Use `batch.object_OrThrow()` for the validated literal and `batch._object_()` for the raw field.

Stored-chat completion and message pages can have null first and last IDs. Use `page.response().lastId()` when reading a cursor from an empty page. GA and beta web-search calls can omit the outer action. Check `call.action()` before accessing an action variant.

Batch output and error file IDs and the in-progress, expiry deadline, finalizing and completed timestamps can be null. Fine-tuning jobs can return a null seed. Eval runs can omit error details and return null model, name or usage statistics. An output-item sample can have a null error after success. Use the optional getters when these values are unavailable, and raw getters when a caller needs to distinguish an omitted field from explicit JSON null.

Conversation response metadata exposes a map of properties. For example, read `conversation.metadataOrThrow()._allProperties().get(key)` and check the returned value before calling `asStringOrThrow()`.

A grader run returns structured token usage or null. Read the total with `metadata.tokenUsage().map(usage -> usage.totalTokensOrThrow())`. For an archived response containing an integer, read `metadata._tokenUsage().asNumber()` before strict validation.
