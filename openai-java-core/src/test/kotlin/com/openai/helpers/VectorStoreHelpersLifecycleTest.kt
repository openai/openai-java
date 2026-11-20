package com.openai.helpers

import com.openai.client.OpenAIClient
import com.openai.core.RequestOptions
import com.openai.core.http.Headers
import com.openai.core.http.HttpResponseFor
import com.openai.core.jsonMapper
import com.openai.models.files.FileObject
import com.openai.models.vectorstores.filebatches.FileBatchCreateParams
import com.openai.models.vectorstores.filebatches.VectorStoreFileBatch
import com.openai.models.vectorstores.files.FileRetrieveParams
import com.openai.models.vectorstores.files.VectorStoreFile
import java.io.InputStream
import java.nio.file.Files
import java.nio.file.Path
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.Semaphore
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import org.mockito.Answers.RETURNS_DEEP_STUBS
import org.mockito.kotlin.any
import org.mockito.kotlin.eq
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

internal class VectorStoreHelpersLifecycleTest {
    private fun batch() = FileBatchCreateParams.builder().vectorStoreId("vs_test").build()

    private fun file(id: String) =
        jsonMapper().readValue("""{"id":"$id"}""", FileObject::class.java)

    @Test
    fun boundedUploadsAndCallerExecutorOwnership(@TempDir dir: Path) {
        val client = mock<OpenAIClient>(defaultAnswer = RETURNS_DEEP_STUBS)
        val started = CountDownLatch(2)
        val permit = Semaphore(0)
        val active = AtomicInteger()
        val peak = AtomicInteger()
        val calls = AtomicInteger()
        val files = client.files()
        whenever(
                files.create(any<com.openai.models.files.FileCreateParams>(), any<RequestOptions>())
            )
            .thenAnswer {
                val index = calls.incrementAndGet()
                val count = active.incrementAndGet()
                peak.accumulateAndGet(count, Math::max)
                started.countDown()
                try {
                    check(permit.tryAcquire(5, TimeUnit.SECONDS))
                    file("file_$index")
                } finally {
                    active.decrementAndGet()
                }
            }
        whenever(
                client
                    .vectorStores()
                    .fileBatches()
                    .create(any<FileBatchCreateParams>(), any<RequestOptions>())
            )
            .thenReturn(
                jsonMapper()
                    .readValue("""{"status":"completed"}""", VectorStoreFileBatch::class.java)
            )
        val paths = (1..3).map { Files.write(dir.resolve("$it.txt"), byteArrayOf(1)) }
        val executor = Executors.newSingleThreadExecutor()
        try {
            val future =
                VectorStoreHelpers.builder()
                    .client(client)
                    .maxConcurrency(2)
                    .build()
                    .uploadAndPollAsync(batch(), paths, executor)
            assertThat(started.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(calls.get()).isEqualTo(2)
            permit.release(3)
            assertThat(future.get(5, TimeUnit.SECONDS).status().toString()).isEqualTo("completed")
            assertThat(calls.get()).isEqualTo(3)
            assertThat(peak.get()).isEqualTo(2)
            assertThat(executor.isShutdown).isFalse()
        } finally {
            permit.release(3)
            executor.shutdownNow()
        }
    }

    @Test
    fun uploadStreamClosesOnClientFailure(@TempDir dir: Path) {
        val client = mock<OpenAIClient>(defaultAnswer = RETURNS_DEEP_STUBS)
        var stream: InputStream? = null
        whenever(
                client
                    .files()
                    .create(any<com.openai.models.files.FileCreateParams>(), any<RequestOptions>())
            )
            .thenAnswer {
                stream = it.getArgument<com.openai.models.files.FileCreateParams>(0).file()
                throw IllegalStateException("synthetic failure")
            }
        val path = Files.write(dir.resolve("test.txt"), byteArrayOf(1))
        assertThatThrownBy {
                VectorStoreHelpers.builder()
                    .client(client)
                    .build()
                    .uploadAndPoll(batch(), listOf(path))
            }
            .isInstanceOf(VectorStoreHelpers.UploadException::class.java)
        assertThat(stream).isNotNull()
        assertThatThrownBy { stream!!.read() }.isInstanceOf(java.io.IOException::class.java)
    }

    @Test
    fun cancellationInterruptsPollingAndClosesResponse() {
        val client = mock<OpenAIClient>(defaultAnswer = RETURNS_DEEP_STUBS)
        val response = mock<HttpResponseFor<VectorStoreFile>>()
        val closed = CountDownLatch(1)
        whenever(response.headers())
            .thenReturn(Headers.builder().put("openai-poll-after-ms", "60000").build())
        whenever(response.parse())
            .thenReturn(
                jsonMapper().readValue("""{"status":"in_progress"}""", VectorStoreFile::class.java)
            )
        org.mockito.kotlin
            .doAnswer {
                closed.countDown()
                null
            }
            .whenever(response)
            .close()
        val raw = client.vectorStores().files().withRawResponse()
        whenever(raw.retrieve(any<FileRetrieveParams>(), any<RequestOptions>()))
            .thenReturn(response)
        val executor = Executors.newSingleThreadExecutor()
        try {
            val params =
                FileRetrieveParams.builder().vectorStoreId("vs_test").fileId("file_test").build()
            val options =
                RequestOptions.builder()
                    .responseValidation(false)
                    .timeout(java.time.Duration.ofSeconds(2))
                    .build()
            val future =
                VectorStoreHelpers.builder()
                    .client(client)
                    .requestOptions(options)
                    .build()
                    .pollFileAsync(params, executor)
            assertThat(closed.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(future.cancel(true)).isTrue()
            // A subsequent task proves the cancelled worker left its minute-long poll wait.
            executor.submit {}.get(5, TimeUnit.SECONDS)
            verify(raw, times(1)).retrieve(any<FileRetrieveParams>(), eq(options))
            verify(response, times(1)).close()
        } finally {
            executor.shutdownNow()
        }
    }

    @Test
    fun cancellationInterruptsBeforeNotifyingDependentCallbacks() {
        val client = mock<OpenAIClient>(defaultAnswer = RETURNS_DEEP_STUBS)
        val entered = CountDownLatch(1)
        val stopped = CountDownLatch(1)
        val observed = java.util.concurrent.atomic.AtomicBoolean()
        val raw = client.vectorStores().files().withRawResponse()
        whenever(raw.retrieve(any<FileRetrieveParams>(), any<RequestOptions>())).thenAnswer {
            entered.countDown()
            try {
                TimeUnit.MINUTES.sleep(1)
                throw AssertionError("Expected interruption")
            } finally {
                stopped.countDown()
            }
        }
        val executor = Executors.newSingleThreadExecutor()
        try {
            val params =
                FileRetrieveParams.builder().vectorStoreId("vs_test").fileId("file_test").build()
            val future =
                VectorStoreHelpers.builder().client(client).build().pollFileAsync(params, executor)
            assertThat(entered.await(5, TimeUnit.SECONDS)).isTrue()
            future.whenComplete { _, _ -> observed.set(stopped.await(3, TimeUnit.SECONDS)) }
            assertThat(future.cancel(true)).isTrue()
            assertThat(observed.get()).isTrue()
            assertThat(future.isCancelled).isTrue()
        } finally {
            executor.shutdownNow()
        }
    }

    @Test
    fun concurrentFailureDrainsAcknowledgedUploads(@TempDir dir: Path) {
        val client = mock<OpenAIClient>(defaultAnswer = RETURNS_DEEP_STUBS)
        val entered = CountDownLatch(2)
        val release = CountDownLatch(1)
        val streams = java.util.concurrent.CopyOnWriteArrayList<InputStream>()
        whenever(
                client
                    .files()
                    .create(any<com.openai.models.files.FileCreateParams>(), any<RequestOptions>())
            )
            .thenAnswer {
                val stream = it.getArgument<com.openai.models.files.FileCreateParams>(0).file()
                streams.add(stream)
                val first = stream.read() == 1
                entered.countDown()
                check(entered.await(5, TimeUnit.SECONDS))
                if (first) throw IllegalStateException("synthetic upload failure")
                check(release.await(5, TimeUnit.SECONDS))
                file("acknowledged")
            }
        val paths = (1..2).map { Files.write(dir.resolve("$it.txt"), byteArrayOf(it.toByte())) }
        val executor = Executors.newSingleThreadExecutor()
        try {
            val future =
                VectorStoreHelpers.builder()
                    .client(client)
                    .maxConcurrency(2)
                    .build()
                    .uploadAndPollAsync(batch(), paths, executor)
            assertThat(entered.await(5, TimeUnit.SECONDS)).isTrue()
            release.countDown()
            val error = catchThrowable { future.get(5, TimeUnit.SECONDS) }.cause
            assertThat(error).isInstanceOf(VectorStoreHelpers.UploadException::class.java)
            val uploadError = error as VectorStoreHelpers.UploadException
            assertThat(uploadError.uploadedFileIds()).containsExactly("acknowledged")
            assertThat(uploadError.cause).isInstanceOf(IllegalStateException::class.java)
            assertThatThrownBy {
                    (uploadError.uploadedFileIds() as MutableList<String>).add("mutation")
                }
                .isInstanceOf(UnsupportedOperationException::class.java)
            streams.forEach { stream ->
                assertThatThrownBy { stream.read() }.isInstanceOf(java.io.IOException::class.java)
            }
            verify(client.vectorStores().fileBatches(), org.mockito.kotlin.never())
                .create(any<FileBatchCreateParams>(), any<RequestOptions>())
        } finally {
            release.countDown()
            executor.shutdownNow()
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.ValueSource(booleans = [false, true])
    fun timeoutOrCancellationStopsActiveUploads(cancel: Boolean, @TempDir dir: Path) {
        val client = mock<OpenAIClient>(defaultAnswer = RETURNS_DEEP_STUBS)
        val entered = CountDownLatch(2)
        val stopped = CountDownLatch(2)
        val streams = java.util.concurrent.CopyOnWriteArrayList<InputStream>()
        whenever(
                client
                    .files()
                    .create(any<com.openai.models.files.FileCreateParams>(), any<RequestOptions>())
            )
            .thenAnswer {
                streams.add(it.getArgument<com.openai.models.files.FileCreateParams>(0).file())
                entered.countDown()
                try {
                    TimeUnit.MINUTES.sleep(1)
                    file("unexpected")
                } finally {
                    stopped.countDown()
                }
            }
        val paths = (1..3).map { Files.write(dir.resolve("$it.txt"), byteArrayOf(1)) }
        val executor = Executors.newSingleThreadExecutor()
        try {
            val helper =
                VectorStoreHelpers.builder()
                    .client(client)
                    .maxConcurrency(2)
                    .timeout(java.time.Duration.ofSeconds(if (cancel) 30 else 2))
                    .build()
            val future = helper.uploadAndPollAsync(batch(), paths, executor)
            assertThat(entered.await(5, TimeUnit.SECONDS)).isTrue()
            if (cancel) {
                assertThat(future.cancel(true)).isTrue()
                executor.submit {}.get(5, TimeUnit.SECONDS)
            } else {
                val error = catchThrowable { future.get(5, TimeUnit.SECONDS) }.cause
                assertThat(error).isInstanceOf(VectorStoreHelpers.UploadException::class.java)
                assertThat(error?.cause)
                    .isInstanceOf(java.util.concurrent.TimeoutException::class.java)
            }
            assertThat(stopped.await(5, TimeUnit.SECONDS)).isTrue()
            // Transport interruption precedes use{} cleanup by a few instructions.
            for (stream in streams) {
                val deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(5)
                var closed = false
                while (!closed && System.nanoTime() < deadline) {
                    try {
                        stream.read()
                        Thread.yield()
                    } catch (_: java.io.IOException) {
                        closed = true
                    }
                }
                assertThat(closed).isTrue()
            }
            verify(client.files(), times(2))
                .create(any<com.openai.models.files.FileCreateParams>(), any<RequestOptions>())
            verify(client.vectorStores().fileBatches(), org.mockito.kotlin.never())
                .create(any<FileBatchCreateParams>(), any<RequestOptions>())
        } finally {
            executor.shutdownNow()
        }
    }

    @Test
    fun parseFailureClosesResponseAndPreservesCause() {
        val client = mock<OpenAIClient>(defaultAnswer = RETURNS_DEEP_STUBS)
        val response = mock<HttpResponseFor<VectorStoreFile>>()
        val failure = IllegalStateException("synthetic parse failure")
        whenever(response.headers()).thenReturn(Headers.builder().build())
        whenever(response.parse()).thenThrow(failure)
        whenever(
                client
                    .vectorStores()
                    .files()
                    .withRawResponse()
                    .retrieve(any<FileRetrieveParams>(), any<RequestOptions>())
            )
            .thenReturn(response)
        val params =
            FileRetrieveParams.builder().vectorStoreId("vs_test").fileId("file_test").build()
        assertThat(
                catchThrowable {
                    VectorStoreHelpers.builder().client(client).build().pollFile(params)
                }
            )
            .isSameAs(failure)
        verify(response).close()
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.ValueSource(booleans = [false, true])
    fun queuedUploadResultsSurviveTimeoutOrInterruption(interrupt: Boolean, @TempDir dir: Path) {
        val client = mock<OpenAIClient>(defaultAnswer = RETURNS_DEEP_STUBS)
        val first = file("first")
        val second = file("second")
        whenever(
                client
                    .files()
                    .create(any<com.openai.models.files.FileCreateParams>(), any<RequestOptions>())
            )
            .thenReturn(first, second)
        val paths = (1..2).map { Files.write(dir.resolve("$it.txt"), byteArrayOf(1)) }
        val pool = mock<java.util.concurrent.ExecutorService>()
        var submitted = 0
        org.mockito.kotlin
            .doAnswer {
                // Finish and enqueue both uploads before allowing the coordinator to poll.
                it.getArgument<Runnable>(0).run()
                if (++submitted == 2) {
                    if (interrupt) Thread.currentThread().interrupt()
                    else TimeUnit.MILLISECONDS.sleep(2100)
                }
                null
            }
            .whenever(pool)
            .execute(any())
        org.mockito.Mockito.mockStatic(Executors::class.java) { invocation ->
                if (invocation.method.name == "newFixedThreadPool") pool
                else invocation.callRealMethod()
            }
            .use {
                try {
                    val error = catchThrowable {
                        VectorStoreHelpers.builder()
                            .client(client)
                            .maxConcurrency(2)
                            .timeout(java.time.Duration.ofSeconds(2))
                            .build()
                            .uploadAndPoll(batch(), paths)
                    }
                    assertThat(error).isInstanceOf(VectorStoreHelpers.UploadException::class.java)
                    assertThat((error as VectorStoreHelpers.UploadException).uploadedFileIds())
                        .containsExactly("first", "second")
                    assertThat(error.cause)
                        .isInstanceOf(
                            if (interrupt) InterruptedException::class.java
                            else java.util.concurrent.TimeoutException::class.java
                        )
                    assertThat(Thread.currentThread().isInterrupted).isEqualTo(interrupt)
                    verify(pool).shutdownNow()
                    verify(client.vectorStores().fileBatches(), org.mockito.kotlin.never())
                        .create(any<FileBatchCreateParams>(), any<RequestOptions>())
                } finally {
                    Thread.interrupted()
                }
            }
    }

    @Test
    fun rejectedExecutorAndQueuedCancellationMakeNoRequests() {
        val client = mock<OpenAIClient>(defaultAnswer = RETURNS_DEEP_STUBS)
        val helper = VectorStoreHelpers.builder().client(client).build()
        val params =
            FileRetrieveParams.builder().vectorStoreId("vs_test").fileId("file_test").build()
        val executor = Executors.newSingleThreadExecutor()
        val occupied = CountDownLatch(1)
        val release = CountDownLatch(1)
        try {
            executor.submit {
                occupied.countDown()
                release.await()
            }
            check(occupied.await(5, TimeUnit.SECONDS))
            val queued = helper.pollFileAsync(params, executor)
            assertThat(queued.cancel(false)).isTrue()
            release.countDown()
            executor.submit {}.get(5, TimeUnit.SECONDS)
            executor.shutdown()
            val rejected = helper.pollFileAsync(params, executor)
            assertThat(catchThrowable { rejected.get(5, TimeUnit.SECONDS) }.cause)
                .isInstanceOf(java.util.concurrent.RejectedExecutionException::class.java)
            org.mockito.kotlin.verifyNoInteractions(client)
        } finally {
            release.countDown()
            executor.shutdownNow()
        }
    }
}
