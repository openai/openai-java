// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.vectorstores

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.findAll
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.reset
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.JsonValue
import com.openai.models.vectorstores.AutoFileChunkingStrategyParam
import com.openai.models.vectorstores.filebatches.FileBatchCancelParams
import com.openai.models.vectorstores.filebatches.FileBatchCreateParams
import com.openai.models.vectorstores.filebatches.FileBatchListFilesParams
import com.openai.models.vectorstores.filebatches.FileBatchRetrieveParams
import java.util.concurrent.atomic.AtomicInteger
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.parallel.ResourceLock

@ExtendWith(TestServerExtension::class)
@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class FileBatchServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val fileBatchServiceAsync = client.vectorStores().fileBatches()

        val vectorStoreFileBatchFuture =
            fileBatchServiceAsync.create(
                FileBatchCreateParams.builder()
                    .vectorStoreId("vs_abc123")
                    .attributes(
                        FileBatchCreateParams.Attributes.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .chunkingStrategy(AutoFileChunkingStrategyParam.builder().build())
                    .addFileId("string")
                    .addFile(
                        FileBatchCreateParams.File.builder()
                            .fileId("file_id")
                            .attributes(
                                FileBatchCreateParams.File.Attributes.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .chunkingStrategy(AutoFileChunkingStrategyParam.builder().build())
                            .build()
                    )
                    .build()
            )

        val vectorStoreFileBatch = vectorStoreFileBatchFuture.get()
        vectorStoreFileBatch.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val fileBatchServiceAsync = client.vectorStores().fileBatches()

        val vectorStoreFileBatchFuture =
            fileBatchServiceAsync.retrieve(
                FileBatchRetrieveParams.builder()
                    .vectorStoreId("vs_abc123")
                    .batchId("vsfb_abc123")
                    .build()
            )

        val vectorStoreFileBatch = vectorStoreFileBatchFuture.get()
        vectorStoreFileBatch.validate()
    }

    @Test
    fun cancel() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val fileBatchServiceAsync = client.vectorStores().fileBatches()

        val vectorStoreFileBatchFuture =
            fileBatchServiceAsync.cancel(
                FileBatchCancelParams.builder()
                    .vectorStoreId("vector_store_id")
                    .batchId("batch_id")
                    .build()
            )

        val vectorStoreFileBatch = vectorStoreFileBatchFuture.get()
        vectorStoreFileBatch.validate()
    }

    @Test
    fun listFilesStopsOnExplicitFalse(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        try {
            // A terminal page can still contain items and a cursor
            stubFor(
                get(anyUrl())
                    .willReturn(okJson("{\"data\":[{\"id\":\"item_1\"}],\"has_more\":false}"))
            )
            val page =
                client
                    .vectorStores()
                    .fileBatches()
                    .listFiles(
                        FileBatchListFilesParams.builder()
                            .vectorStoreId("vector_store_id")
                            .batchId("batch_id")
                            .build()
                    )
                    .get()
            assertThat(page.items()).hasSize(1)
            assertThat(page.hasNextPage()).isFalse()

            val count = AtomicInteger()
            page.autoPager().subscribe { count.incrementAndGet() }.onCompleteFuture().get()
            assertThat(count.get()).isEqualTo(1)

            assertThat(findAll(getRequestedFor(anyUrl()))).hasSize(1)
        } finally {
            client.close()
        }
    }

    @Test
    fun listFilesContinuesUntilExplicitFalse(wmRuntimeInfo: WireMockRuntimeInfo) {
        // Both explicit true and a missing flag preserve normal cursor traversal.
        for (firstResponse in
            listOf(
                "{\"data\":[{\"id\":\"item_1\"}],\"has_more\":true}",
                "{\"data\":[{\"id\":\"item_1\"}]}",
            )) {
            reset()
            val client =
                OpenAIOkHttpClientAsync.builder()
                    .baseUrl(wmRuntimeInfo.httpBaseUrl)
                    .apiKey("My API Key")
                    .adminApiKey("My Admin API Key")
                    .build()
            try {
                stubFor(
                    get(anyUrl())
                        .inScenario("pagination")
                        .whenScenarioStateIs("Started")
                        .willReturn(okJson(firstResponse))
                        .willSetStateTo("terminal")
                )
                stubFor(
                    get(anyUrl())
                        .inScenario("pagination")
                        .whenScenarioStateIs("terminal")
                        .willReturn(okJson("{\"data\":[{\"id\":\"item_1\"}],\"has_more\":false}"))
                        .willSetStateTo("unexpected")
                )
                // Bound a regression to one extra request instead of an infinite loop.
                stubFor(
                    get(anyUrl())
                        .inScenario("pagination")
                        .whenScenarioStateIs("unexpected")
                        .willReturn(okJson("{}"))
                )
                val page =
                    client
                        .vectorStores()
                        .fileBatches()
                        .listFiles(
                            FileBatchListFilesParams.builder()
                                .vectorStoreId("vector_store_id")
                                .batchId("batch_id")
                                .build()
                        )
                        .get()
                assertThat(page.hasNextPage()).isTrue()

                val count = AtomicInteger()
                page.autoPager().subscribe { count.incrementAndGet() }.onCompleteFuture().get()
                assertThat(count.get()).isEqualTo(2)

                assertThat(findAll(getRequestedFor(anyUrl()))).hasSize(2)
            } finally {
                client.close()
            }
        }
    }

    @Test
    fun listFiles() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val fileBatchServiceAsync = client.vectorStores().fileBatches()

        val pageFuture =
            fileBatchServiceAsync.listFiles(
                FileBatchListFilesParams.builder()
                    .vectorStoreId("vector_store_id")
                    .batchId("batch_id")
                    .build()
            )

        val page = pageFuture.get()
        page.response().validate()
    }
}
