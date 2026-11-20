package com.openai.helpers

import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.github.tomakehurst.wiremock.stubbing.Scenario.STARTED
import com.openai.client.OpenAIClient
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.vectorstores.filebatches.FileBatchCreateParams
import com.openai.models.vectorstores.filebatches.FileBatchRetrieveParams
import com.openai.models.vectorstores.files.FileCreateParams
import com.openai.models.vectorstores.files.FileRetrieveParams
import java.nio.file.Files
import java.nio.file.Path
import java.time.Duration
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import org.junit.jupiter.api.parallel.ResourceLock
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class VectorStoreHelpersTest {
    private inline fun <T> OpenAIClient.use(block: (OpenAIClient) -> T): T =
        try {
            block(this)
        } finally {
            close()
        }

    private val filePath = "/vector_stores/vs_test/files/file_test"
    private val batchPath = "/vector_stores/vs_test/file_batches/batch_test"

    private fun file(status: String) =
        """{"id":"file_test","object":"vector_store.file","status":"$status","created_at":1,"last_error":null,"usage_bytes":0,"vector_store_id":"vs_test"}"""

    private fun batch(status: String) =
        """{"id":"batch_test","object":"vector_store.files_batch","status":"$status","created_at":1,"vector_store_id":"vs_test","file_counts":{"cancelled":0,"completed":1,"failed":0,"in_progress":0,"total":1}}"""

    private fun client(server: WireMockRuntimeInfo) =
        OpenAIOkHttpClient.builder()
            .baseUrl(server.httpBaseUrl)
            .apiKey("test-key")
            .maxRetries(0)
            .build()

    private fun retrieve() =
        FileRetrieveParams.builder().vectorStoreId("vs_test").fileId("file_test").build()

    private fun createBatch() =
        FileBatchCreateParams.builder().vectorStoreId("vs_test").addFileId("existing").build()

    @ParameterizedTest
    @ValueSource(strings = ["completed", "failed", "cancelled"])
    fun pollsUntilKnownTerminalState(status: String, server: WireMockRuntimeInfo) {
        stubFor(
            get(urlEqualTo(filePath))
                .inScenario("file")
                .whenScenarioStateIs(STARTED)
                .willReturn(okJson(file("in_progress")))
                .willSetStateTo("ready")
        )
        stubFor(
            get(urlEqualTo(filePath))
                .inScenario("file")
                .whenScenarioStateIs("ready")
                .willReturn(okJson(file(status)))
        )
        client(server).use { client ->
            val helper =
                VectorStoreHelpers.builder()
                    .client(client)
                    .pollInterval(Duration.ofMillis(1))
                    .build()
            assertThat(helper.pollFile(retrieve()).status().toString()).isEqualTo(status)
        }
        verify(2, getRequestedFor(urlEqualTo(filePath)))
    }

    @Test
    fun createPreservesAttributesAndPollHeaders(server: WireMockRuntimeInfo) {
        stubFor(
            post(urlEqualTo("/vector_stores/vs_test/files")).willReturn(okJson(file("in_progress")))
        )
        stubFor(get(urlEqualTo(filePath)).willReturn(okJson(file("completed"))))
        client(server).use { client ->
            val helper = VectorStoreHelpers.builder().client(client).build()
            val params =
                FileCreateParams.builder()
                    .vectorStoreId("vs_test")
                    .fileId("file_test")
                    .attributes(
                        FileCreateParams.Attributes.builder()
                            .putAdditionalProperty("source", JsonValue.from("test"))
                            .build()
                    )
                    .putAdditionalHeader("X-Test", "retained")
                    .build()
            assertThat(helper.createFileAndPoll(params).status().toString()).isEqualTo("completed")
        }
        verify(
            postRequestedFor(urlEqualTo("/vector_stores/vs_test/files"))
                .withRequestBody(matchingJsonPath("$.file_id", equalTo("file_test")))
                .withRequestBody(matchingJsonPath("$.attributes.source", equalTo("test")))
        )
        verify(getRequestedFor(urlEqualTo(filePath)).withHeader("X-Test", equalTo("retained")))
    }

    @Test
    fun completedCreateDoesNotPoll(server: WireMockRuntimeInfo) {
        stubFor(
            post(urlEqualTo("/vector_stores/vs_test/file_batches"))
                .willReturn(okJson(batch("completed")))
        )
        client(server).use { client ->
            val result =
                VectorStoreHelpers.builder()
                    .client(client)
                    .build()
                    .createBatchAndPoll(createBatch())
            assertThat(result.status().toString()).isEqualTo("completed")
        }
        verify(0, getRequestedFor(urlMatching(".*")))
    }

    @Test
    fun batchPollPreservesFailedOutcome(server: WireMockRuntimeInfo) {
        stubFor(get(urlEqualTo(batchPath)).willReturn(okJson(batch("failed"))))
        client(server).use { client ->
            val result =
                VectorStoreHelpers.builder()
                    .client(client)
                    .build()
                    .pollBatch(
                        FileBatchRetrieveParams.builder()
                            .vectorStoreId("vs_test")
                            .batchId("batch_test")
                            .build()
                    )
            assertThat(result.status().toString()).isEqualTo("failed")
        }
    }

    @Test
    fun unknownStatusIsNotSuccess(server: WireMockRuntimeInfo) {
        stubFor(get(urlEqualTo(filePath)).willReturn(okJson(file("future_state"))))
        client(server).use { client ->
            assertThatThrownBy {
                    VectorStoreHelpers.builder().client(client).build().pollFile(retrieve())
                }
                .isInstanceOf(IllegalStateException::class.java)
        }
        verify(1, getRequestedFor(urlEqualTo(filePath)))
    }

    @Test
    fun serverPollHintIsBoundedByWorkflowTimeout(server: WireMockRuntimeInfo) {
        stubFor(
            get(urlEqualTo(filePath))
                .willReturn(okJson(file("in_progress")).withHeader("openai-poll-after-ms", "60000"))
        )
        client(server).use { client ->
            val helper =
                VectorStoreHelpers.builder()
                    .client(client)
                    .timeout(Duration.ofSeconds(1))
                    .pollInterval(Duration.ofMillis(1))
                    .build()
            assertThatThrownBy { helper.pollFile(retrieve()) }
                .isInstanceOf(TimeoutException::class.java)
        }
        verify(1, getRequestedFor(urlEqualTo(filePath)))
    }

    @Test
    fun invalidHintFallsBackToConfiguredInterval(server: WireMockRuntimeInfo) {
        stubFor(
            get(urlEqualTo(filePath))
                .inScenario("hint")
                .whenScenarioStateIs(STARTED)
                .willReturn(
                    okJson(file("in_progress")).withHeader("openai-poll-after-ms", "not-a-number")
                )
                .willSetStateTo("ready")
        )
        stubFor(
            get(urlEqualTo(filePath))
                .inScenario("hint")
                .whenScenarioStateIs("ready")
                .willReturn(okJson(file("completed")))
        )
        client(server).use { client ->
            assertThat(
                    VectorStoreHelpers.builder()
                        .client(client)
                        .pollInterval(Duration.ofMillis(1))
                        .build()
                        .pollFile(retrieve())
                        .status()
                        .toString()
                )
                .isEqualTo("completed")
        }
    }

    @Test
    fun bulkUploadsPreserveInputOrderAndExistingIds(
        server: WireMockRuntimeInfo,
        @TempDir dir: Path,
    ) {
        val paths =
            listOf("first", "second").map { Files.write(dir.resolve("$it.txt"), it.toByteArray()) }
        for (name in listOf("first", "second")) {
            stubFor(
                post(urlEqualTo("/files"))
                    .withRequestBody(containing("filename=\"$name.txt\""))
                    .willReturn(
                        okJson("""{"id":"file_$name"}""")
                            .withFixedDelay(if (name == "first") 50 else 0)
                    )
            )
        }
        stubFor(
            post(urlEqualTo("/vector_stores/vs_test/file_batches"))
                .willReturn(okJson(batch("in_progress")))
        )
        stubFor(get(urlEqualTo(batchPath)).willReturn(okJson(batch("completed"))))
        client(server).use { client ->
            val result =
                VectorStoreHelpers.builder()
                    .client(client)
                    .maxConcurrency(2)
                    .build()
                    .uploadAndPoll(createBatch(), paths)
            assertThat(result.status().toString()).isEqualTo("completed")
        }
        verify(2, postRequestedFor(urlEqualTo("/files")))
        verify(
            postRequestedFor(urlEqualTo("/vector_stores/vs_test/file_batches"))
                .withRequestBody(
                    equalToJson("""{"file_ids":["existing","file_first","file_second"]}""")
                )
        )
        paths.forEach { Files.delete(it) }
    }

    @Test
    fun uploadFailureRetainsIdsAndDoesNotCreateBatch(
        server: WireMockRuntimeInfo,
        @TempDir dir: Path,
    ) {
        val good = Files.write(dir.resolve("good.txt"), byteArrayOf(1))
        stubFor(post(urlEqualTo("/files")).willReturn(okJson("""{"id":"uploaded"}""")))
        client(server).use { client ->
            val helper = VectorStoreHelpers.builder().client(client).maxConcurrency(1).build()
            val error = catchThrowable {
                helper.uploadAndPoll(createBatch(), listOf(good, dir.resolve("missing"), good))
            }
            assertThat(error).isInstanceOf(VectorStoreHelpers.UploadException::class.java)
            assertThat((error as VectorStoreHelpers.UploadException).uploadedFileIds())
                .containsExactly("uploaded")
        }
        verify(1, postRequestedFor(urlEqualTo("/files")))
        verify(0, postRequestedFor(urlEqualTo("/vector_stores/vs_test/file_batches")))
        verify(0, deleteRequestedFor(urlMatching(".*")))
    }

    @Test
    fun asyncAdapterDoesNotOwnExecutor(server: WireMockRuntimeInfo) {
        stubFor(get(urlEqualTo(filePath)).willReturn(okJson(file("completed"))))
        val executor = Executors.newSingleThreadExecutor()
        try {
            client(server).use { client ->
                val result =
                    VectorStoreHelpers.builder()
                        .client(client)
                        .build()
                        .pollFileAsync(retrieve(), executor)
                        .get(5, TimeUnit.SECONDS)
                assertThat(result.status().toString()).isEqualTo("completed")
            }
            assertThat(executor.isShutdown).isFalse()
        } finally {
            executor.shutdownNow()
        }
    }

    @Test
    fun interruptedCallerMakesNoRequests(server: WireMockRuntimeInfo, @TempDir dir: Path) {
        client(server).use { client ->
            Thread.currentThread().interrupt()
            try {
                assertThatThrownBy {
                        VectorStoreHelpers.builder().client(client).build().pollFile(retrieve())
                    }
                    .isInstanceOf(InterruptedException::class.java)
                assertThatThrownBy {
                        VectorStoreHelpers.builder()
                            .client(client)
                            .build()
                            .uploadAndPoll(createBatch(), listOf(dir.resolve("unopened.txt")))
                    }
                    .isInstanceOf(InterruptedException::class.java)
                assertThat(Thread.currentThread().isInterrupted).isTrue()
            } finally {
                Thread.interrupted()
            }
        }
        verify(0, getRequestedFor(urlMatching(".*")))
        verify(0, postRequestedFor(urlMatching(".*")))
    }

    @Test
    fun validatesOptions() {
        assertThatThrownBy { VectorStoreHelpers.builder().maxConcurrency(0) }
            .isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { VectorStoreHelpers.builder().timeout(Duration.ZERO) }
            .isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { VectorStoreHelpers.builder().pollInterval(Duration.ofSeconds(-1)) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun oversizedCombinedBatchIsRejectedBeforeAnyUploads(
        async: Boolean,
        server: WireMockRuntimeInfo,
        @TempDir dir: Path,
    ) {
        val executor = Executors.newSingleThreadExecutor()
        try {
            client(server).use { client ->
                val helper = VectorStoreHelpers.builder().client(client).build()
                val params =
                    createBatch().toBuilder().fileIds((1..2000).map { "existing_$it" }).build()
                val error = catchThrowable {
                    if (async)
                        helper
                            .uploadAndPollAsync(params, listOf(dir.resolve("unopened")), executor)
                            .get(5, TimeUnit.SECONDS)
                    else helper.uploadAndPoll(params, listOf(dir.resolve("unopened")))
                }
                assertThat(if (async) error.cause else error)
                    .isInstanceOf(IllegalArgumentException::class.java)
                assertThatThrownBy {
                        helper.uploadAndPoll(createBatch(), List(2001) { dir.resolve("unopened") })
                    }
                    .isInstanceOf(IllegalArgumentException::class.java)
            }
        } finally {
            executor.shutdownNow()
        }
        verify(0, postRequestedFor(urlMatching(".*")))
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun sharedIdempotencyKeyIsRejectedBeforeAnyUploads(
        async: Boolean,
        server: WireMockRuntimeInfo,
        @TempDir dir: Path,
    ) {
        val executor = Executors.newSingleThreadExecutor()
        try {
            client(server).use { base ->
                val client = base.withOptions { it.putHeader("iDeMpOtEnCy-KeY", "synthetic-key") }
                val helper = VectorStoreHelpers.builder().client(client).build()
                val paths = listOf(dir.resolve("unopened-a"), dir.resolve("unopened-b"))
                val error = catchThrowable {
                    if (async)
                        helper
                            .uploadAndPollAsync(createBatch(), paths, executor)
                            .get(5, TimeUnit.SECONDS)
                    else helper.uploadAndPoll(createBatch(), paths)
                }
                assertThat(if (async) error.cause else error)
                    .isInstanceOf(IllegalArgumentException::class.java)
                client.withOptions {
                    assertThat(it.build().headers.values("Idempotency-Key"))
                        .containsExactly("synthetic-key")
                }
            }
        } finally {
            executor.shutdownNow()
        }
        verify(0, postRequestedFor(urlMatching(".*")))
    }

    @Test
    fun exactBatchLimitStillWorks(server: WireMockRuntimeInfo, @TempDir dir: Path) {
        stubFor(post(urlEqualTo("/files")).willReturn(okJson("""{"id":"new_file"}""")))
        stubFor(
            post(urlEqualTo("/vector_stores/vs_test/file_batches"))
                .willReturn(okJson(batch("completed")))
        )
        val path = Files.write(dir.resolve("one.txt"), byteArrayOf(1))
        client(server).use { client ->
            val params = createBatch().toBuilder().fileIds((1..1999).map { "existing_$it" }).build()
            val result =
                VectorStoreHelpers.builder()
                    .client(client)
                    .build()
                    .uploadAndPoll(params, listOf(path))
            assertThat(result.status().toString()).isEqualTo("completed")
        }
        verify(1, postRequestedFor(urlEqualTo("/files")))
        verify(
            postRequestedFor(urlEqualTo("/vector_stores/vs_test/file_batches"))
                .withRequestBody(matchingJsonPath("$.file_ids[1999]", equalTo("new_file")))
        )
    }

    @Test
    fun invalidBulkInputIsRejectedWithoutSideEffects(
        server: WireMockRuntimeInfo,
        @TempDir dir: Path,
    ) {
        client(server).use { client ->
            val helper = VectorStoreHelpers.builder().client(client).build()
            assertThatThrownBy { helper.uploadAndPoll(createBatch(), emptyList()) }
                .isInstanceOf(IllegalArgumentException::class.java)
            assertThatThrownBy {
                    helper.uploadAndPoll(
                        FileBatchCreateParams.none(),
                        listOf(dir.resolve("unopened")),
                    )
                }
                .isInstanceOf(IllegalArgumentException::class.java)
            val params =
                createBatch()
                    .toBuilder()
                    .files(listOf(FileBatchCreateParams.File.builder().fileId("file_test").build()))
                    .build()
            assertThatThrownBy { helper.uploadAndPoll(params, listOf(dir.resolve("unopened"))) }
                .isInstanceOf(IllegalArgumentException::class.java)
        }
        verify(0, postRequestedFor(urlMatching(".*")))
    }
}
