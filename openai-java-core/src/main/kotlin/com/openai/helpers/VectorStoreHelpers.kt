package com.openai.helpers

import com.openai.client.OpenAIClient
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.files.FilePurpose
import com.openai.models.vectorstores.filebatches.FileBatchCreateParams
import com.openai.models.vectorstores.filebatches.FileBatchRetrieveParams
import com.openai.models.vectorstores.filebatches.VectorStoreFileBatch
import com.openai.models.vectorstores.files.FileCreateParams
import com.openai.models.vectorstores.files.FileRetrieveParams
import com.openai.models.vectorstores.files.VectorStoreFile
import java.nio.file.Path
import java.time.Duration
import java.util.Collections
import java.util.concurrent.CancellationException
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutionException
import java.util.concurrent.ExecutorCompletionService
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.concurrent.FutureTask
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException
import java.util.function.Supplier

/**
 * Optional vector-store workflows over the existing client. The caller owns the client.
 *
 * Polling returns every known terminal state, including failed/cancelled; callers must inspect
 * status and batch file counts. Unknown states fail rather than being mistaken for success. The
 * timeout is a monotonic workflow budget checked between requests and while waiting. In-flight
 * calls retain the client/request timeout and retry policy and may finish after this budget. No new
 * call starts after expiry.
 *
 * Interrupting a blocking call stops local work. This does not cancel server-side ingestion or
 * delete uploaded files. The asynchronous methods use a caller-owned worker executor; these are
 * blocking-worker adapters, not a nonblocking HTTP API.
 */
class VectorStoreHelpers private constructor(builder: Builder) {
    private val client = checkNotNull(builder.client) { "client is required" }
    private val interval = builder.pollInterval
    private val timeout = builder.timeout
    private val concurrency = builder.maxConcurrency
    private val requestOptions = builder.requestOptions

    companion object {
        @JvmStatic fun builder() = Builder()

        /**
         * Run a blocking workflow on a caller-owned executor. cancel(true) interrupts the worker.
         * Do not use the same bounded executor for work on which this operation itself waits.
         */
        private fun <T> submit(
            executor: ExecutorService,
            operation: Supplier<T>,
        ): CompletableFuture<T> {
            var task: FutureTask<T>? = null
            val result =
                object : CompletableFuture<T>() {
                    override fun cancel(mayInterruptIfRunning: Boolean): Boolean {
                        if (isDone) return isCancelled
                        // Interrupt before notifying dependent callbacks, which may wait for
                        // cleanup.
                        return if (task!!.cancel(mayInterruptIfRunning)) {
                            super.cancel(mayInterruptIfRunning)
                        } else isCancelled
                    }
                }
            task =
                object : FutureTask<T>({ operation.get() }) {
                    override fun done() {
                        if (isCancelled) {
                            result.completeExceptionally(CancellationException())
                        } else {
                            try {
                                result.complete(get())
                            } catch (e: ExecutionException) {
                                result.completeExceptionally(e.cause ?: e)
                            } catch (e: InterruptedException) {
                                Thread.currentThread().interrupt()
                                result.completeExceptionally(e)
                            }
                        }
                    }
                }
            try {
                executor.execute(task)
            } catch (e: RuntimeException) {
                result.completeExceptionally(e)
            }
            return result
        }
    }

    /** Blocking-worker adapter; the caller owns [executor]. */
    fun pollFileAsync(
        params: FileRetrieveParams,
        executor: ExecutorService,
    ): CompletableFuture<VectorStoreFile> = submit(executor) { pollFile(params) }

    /** Blocking-worker adapter; cancel(true) interrupts local polling. */
    fun createFileAndPollAsync(
        params: FileCreateParams,
        executor: ExecutorService,
    ): CompletableFuture<VectorStoreFile> = submit(executor) { createFileAndPoll(params) }

    /** Blocking-worker adapter; the caller owns [executor]. */
    fun pollBatchAsync(
        params: FileBatchRetrieveParams,
        executor: ExecutorService,
    ): CompletableFuture<VectorStoreFileBatch> = submit(executor) { pollBatch(params) }

    /** Blocking-worker adapter; cancel(true) interrupts local polling. */
    fun createBatchAndPollAsync(
        params: FileBatchCreateParams,
        executor: ExecutorService,
    ): CompletableFuture<VectorStoreFileBatch> = submit(executor) { createBatchAndPoll(params) }

    /** Blocking-worker adapter; snapshots the path list before scheduling. */
    fun uploadAndPollAsync(
        params: FileBatchCreateParams,
        paths: List<Path>,
        executor: ExecutorService,
    ): CompletableFuture<VectorStoreFileBatch> {
        val inputs = paths.toList()
        return submit(executor) { uploadAndPoll(params, inputs) }
    }

    class Builder internal constructor() {
        internal var client: OpenAIClient? = null
        internal var pollInterval: Duration = Duration.ofSeconds(1)
        internal var timeout: Duration = Duration.ofMinutes(30)
        internal var maxConcurrency: Int = 5
        internal var requestOptions: RequestOptions = RequestOptions.none()

        fun client(client: OpenAIClient) = apply { this.client = client }

        fun pollInterval(interval: Duration) = apply {
            require(!interval.isNegative && !interval.isZero) { "pollInterval must be positive" }
            interval.toNanos()
            pollInterval = interval
        }

        fun timeout(timeout: Duration) = apply {
            require(!timeout.isNegative && !timeout.isZero) { "timeout must be positive" }
            timeout.toNanos()
            this.timeout = timeout
        }

        fun maxConcurrency(maxConcurrency: Int) = apply {
            require(maxConcurrency > 0) { "maxConcurrency must be positive" }
            this.maxConcurrency = maxConcurrency
        }

        fun requestOptions(requestOptions: RequestOptions) = apply {
            this.requestOptions = requestOptions
        }

        fun build() = VectorStoreHelpers(this)
    }

    @Throws(InterruptedException::class, TimeoutException::class)
    fun pollFile(params: FileRetrieveParams): VectorStoreFile = pollFile(params, Budget())

    @Throws(InterruptedException::class, TimeoutException::class)
    fun createFileAndPoll(params: FileCreateParams): VectorStoreFile {
        val budget = Budget()
        val file = client.vectorStores().files().create(params, budget.options())
        budget.remaining()
        if (terminal(file.status().toString())) return file
        return pollFile(
            FileRetrieveParams.builder()
                .vectorStoreId(
                    params.vectorStoreId().orElseThrow {
                        IllegalArgumentException("vectorStoreId is required")
                    }
                )
                .fileId(file.id())
                .additionalHeaders(params._additionalHeaders())
                .additionalQueryParams(params._additionalQueryParams())
                .build(),
            budget,
        )
    }

    @Throws(InterruptedException::class, TimeoutException::class)
    fun pollBatch(params: FileBatchRetrieveParams): VectorStoreFileBatch =
        pollBatch(params, Budget())

    @Throws(InterruptedException::class, TimeoutException::class)
    fun createBatchAndPoll(params: FileBatchCreateParams): VectorStoreFileBatch =
        createBatchAndPoll(params, Budget())

    /**
     * Upload local paths with bounded concurrency, attach their IDs with any existing fileIds, then
     * wait for the batch. Attributes/chunking options in [params] are preserved. The alternate
     * per-file `files` form is not accepted here; use createBatchAndPoll for that form.
     *
     * Streams opened by this helper are closed when their upload call exits, including errors.
     * Successful remote uploads are never deleted automatically. [UploadException.uploadedFileIds]
     * exposes acknowledged uploads after an upload failure; timed-out/interrupted HTTP writes may
     * also have created unacknowledged remote files. On failure no batch is created. On polling
     * failure the batch may already exist.
     */
    @Throws(InterruptedException::class, TimeoutException::class)
    fun uploadAndPoll(params: FileBatchCreateParams, paths: List<Path>): VectorStoreFileBatch {
        require(params.vectorStoreId().isPresent) { "vectorStoreId is required" }
        require(!params.files().isPresent) { "Use fileIds, not files, with uploadAndPoll" }
        val inputs = paths.toList()
        require(inputs.isNotEmpty()) { "paths must not be empty" }
        val existingIds = params.fileIds().orElse(emptyList())
        // Match the FileBatchCreateParams contract before creating any remote files.
        require(existingIds.size.toLong() + inputs.size <= 2000) {
            "A vector-store batch may contain at most 2000 files"
        }
        if (inputs.size > 1) {
            client.withOptions {
                require(it.build().headers.values("Idempotency-Key").isEmpty()) {
                    "A multi-file upload cannot reuse an Idempotency-Key"
                }
            }
        }
        val budget = Budget()
        budget.remaining()
        val pool =
            Executors.newFixedThreadPool(minOf(concurrency, inputs.size)) { task ->
                Thread(task, "openai-vector-store-upload").apply { isDaemon = true }
            }
        val completions = ExecutorCompletionService<Pair<Int, String>>(pool)
        val pending = mutableListOf<Future<Pair<Int, String>>>()
        val uploaded = arrayOfNulls<String>(inputs.size)
        var next = 0
        var active = 0
        var failure: Throwable? = null
        fun launch() {
            budget.remaining()
            val index = next++
            pending.add(
                completions.submit {
                    budget.remaining()
                    val upload =
                        com.openai.models.files.FileCreateParams.builder()
                            .file(inputs[index])
                            .purpose(FilePurpose.ASSISTANTS)
                            .build()
                    upload.file().use {
                        val file = client.files().create(upload, budget.options())
                        index to file.id()
                    }
                }
            )
            active++
        }
        try {
            repeat(minOf(concurrency, inputs.size)) { launch() }
            while (active > 0) {
                val done =
                    completions.poll(budget.remaining(), TimeUnit.NANOSECONDS)
                        ?: throw TimeoutException("Vector-store workflow timed out")
                active--
                try {
                    val (index, id) = done.get()
                    uploaded[index] = id
                } catch (e: ExecutionException) {
                    if (failure == null) failure = e.cause ?: e
                }
                // Drain already-started uploads after failure so their acknowledged IDs are
                // retained.
                if (failure == null && next < inputs.size) launch()
            }
            failure?.let { throw UploadException(uploaded.filterNotNull(), it) }
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
            throw UploadException(uploaded.filterNotNull(), e)
        } catch (e: TimeoutException) {
            throw UploadException(uploaded.filterNotNull(), e)
        } finally {
            pending.forEach { if (!it.isDone) it.cancel(true) }
            pool.shutdownNow()
        }
        return createBatchAndPoll(
            params.toBuilder().fileIds(existingIds + uploaded.filterNotNull()).build(),
            budget,
        )
    }

    class UploadException internal constructor(ids: List<String>, cause: Throwable) :
        RuntimeException("Vector-store upload failed; acknowledged files were retained", cause) {
        private val ids = Collections.unmodifiableList(ArrayList(ids))

        fun uploadedFileIds(): List<String> = ids
    }

    private fun createBatchAndPoll(
        params: FileBatchCreateParams,
        budget: Budget,
    ): VectorStoreFileBatch {
        val batch = client.vectorStores().fileBatches().create(params, budget.options())
        budget.remaining()
        if (terminal(batch.status().toString())) return batch
        return pollBatch(
            FileBatchRetrieveParams.builder()
                .vectorStoreId(
                    params.vectorStoreId().orElseThrow {
                        IllegalArgumentException("vectorStoreId is required")
                    }
                )
                .batchId(batch.id())
                .additionalHeaders(params._additionalHeaders())
                .additionalQueryParams(params._additionalQueryParams())
                .build(),
            budget,
        )
    }

    private fun pollFile(params: FileRetrieveParams, budget: Budget): VectorStoreFile =
        poll(budget, { client.vectorStores().files().withRawResponse().retrieve(params, it) }) {
            it.status().toString()
        }

    private fun pollBatch(params: FileBatchRetrieveParams, budget: Budget): VectorStoreFileBatch =
        poll(
            budget,
            { client.vectorStores().fileBatches().withRawResponse().retrieve(params, it) },
        ) {
            it.status().toString()
        }

    private fun <T> poll(
        budget: Budget,
        retrieve: (RequestOptions) -> HttpResponseFor<T>,
        status: (T) -> String,
    ): T {
        while (true) {
            val (value, delay) =
                retrieve(budget.options()).use { response ->
                    val hint =
                        response
                            .headers()
                            .values("openai-poll-after-ms")
                            .firstOrNull()
                            ?.toLongOrNull()
                    val delay =
                        hint
                            ?.takeIf { it > 0 && it <= Long.MAX_VALUE / 1_000_000 }
                            ?.let { TimeUnit.MILLISECONDS.toNanos(it) } ?: interval.toNanos()
                    response.parse() to delay
                }
            budget.remaining()
            if (terminal(status(value))) return value
            try {
                TimeUnit.NANOSECONDS.sleep(minOf(delay, budget.remaining()))
            } catch (e: InterruptedException) {
                Thread.currentThread().interrupt()
                throw e
            }
        }
    }

    private fun terminal(status: String): Boolean =
        when (status) {
            "in_progress" -> false
            "completed",
            "failed",
            "cancelled" -> true
            else -> throw IllegalStateException("Unknown vector-store processing status")
        }

    private inner class Budget {
        private val started = System.nanoTime()

        fun remaining(): Long {
            if (Thread.currentThread().isInterrupted)
                throw InterruptedException("Vector-store workflow interrupted")
            val remaining = timeout.toNanos() - (System.nanoTime() - started)
            if (remaining <= 0) throw TimeoutException("Vector-store workflow timed out")
            return remaining
        }

        fun options(): RequestOptions {
            remaining()
            return requestOptions
        }
    }
}
