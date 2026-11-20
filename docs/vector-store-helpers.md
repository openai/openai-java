# Vector-store polling and bulk uploads

`com.openai.helpers.VectorStoreHelpers` is an optional handwritten helper over the existing SDK
services. It ships in `openai-java-core` and is available through `openai-java`.

```java
VectorStoreHelpers helpers = VectorStoreHelpers.builder()
    .client(client)
    .pollInterval(Duration.ofSeconds(1))
    .timeout(Duration.ofMinutes(10))
    .maxConcurrency(3)
    .build();

VectorStoreFile file = helpers.createFileAndPoll(
    FileCreateParams.builder().vectorStoreId(storeId).fileId(fileId).build());

VectorStoreFileBatch batch = helpers.uploadAndPoll(
    FileBatchCreateParams.builder().vectorStoreId(storeId).build(),
    Arrays.asList(Paths.get("handbook.pdf"), Paths.get("faq.txt")));
```

Here `FileCreateParams` is from `com.openai.models.vectorstores.files`, and `FileBatchCreateParams`
is from `com.openai.models.vectorstores.filebatches`. These fragments use an existing client,
store ID and file ID. See `VectorStorePollingExample` for a runnable bulk-upload example.

- `pollFile(FileRetrieveParams)` and `pollBatch(FileBatchRetrieveParams)` wait on existing resources.
- `createFileAndPoll(FileCreateParams)` attaches an existing File and waits for ingestion.
- `createBatchAndPoll(FileBatchCreateParams)` creates and polls a batch, including the API's per-file
  attributes/chunking configuration form.
- `uploadAndPoll(FileBatchCreateParams, List<Path>)` uploads local files with bounded concurrency,
  adds their IDs to any supplied `fileIds` in input order, then creates and polls a batch. Batch
  configuration is preserved. The alternate `files` form is rejected before uploading.
  Combined existing and uploaded files must fit the API's 2,000-file batch limit. Multi-file
  uploads reject a client-level `Idempotency-Key` so distinct upload bodies cannot reuse a key.
  These checks run before any streams are opened or requests are sent.

All known terminal states are returned, including `failed` and `cancelled`. Inspect the returned
status, per-file error or batch counts before declaring success. Unknown states throw instead of
silently succeeding. API/transport errors are propagated. Polling respects a positive
`openai-poll-after-ms` response header, falling back to the configured interval for invalid values.
Responses are closed before sleeping.

The default workflow timeout is 30 minutes. It covers creation, uploading and polling using a
monotonic clock and prevents new calls after expiry. In-flight calls retain the configured client
timeout and retry policy and may finish after the workflow budget. Poll sleeps and bulk-upload
waits are bounded by the remaining budget. Use
`requestOptions(...)` to configure per-call behavior, and configure retries on your client.

Uploads open streams only for active workers and close each when its request exits. On an upload
failure, no batch is created; already-started uploads are drained within the remaining budget.
`UploadException.uploadedFileIds()` reports acknowledged files collected before the failure.
Successful remote files are retained, never deleted automatically. Timeout or interruption may
leave additional server-side uploads whose responses were not received; the ID list is not proof
of rollback. A failure during subsequent batch creation/polling can also leave a remote batch.
The helper never deletes caller files or cancels server-side ingestion.

Each workflow also has an `Async` method taking a caller-owned `ExecutorService`. These are explicit
blocking-worker adapters, suitable for a dedicated executor; they are not nonblocking HTTP helpers.
For example:

```java
CompletableFuture<VectorStoreFileBatch> pending =
    helpers.uploadAndPollAsync(batchParams, paths, workerExecutor);
// When needed: pending.cancel(true) interrupts the local worker and its outstanding uploads.
// Shut down workerExecutor when the application no longer needs it; the helper does not own it.
```

Blocking methods preserve interruption. Cancelling local work does not undo remote side effects.
No new runtime dependencies are required, and the helper uses Java 8-compatible APIs.
