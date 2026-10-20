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
import com.openai.models.vectorstores.files.FileContentParams
import com.openai.models.vectorstores.files.FileCreateParams
import com.openai.models.vectorstores.files.FileDeleteParams
import com.openai.models.vectorstores.files.FileRetrieveParams
import com.openai.models.vectorstores.files.FileUpdateParams
import java.util.concurrent.atomic.AtomicInteger
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.parallel.ResourceLock

@ExtendWith(TestServerExtension::class)
@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class FileServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val fileServiceAsync = client.vectorStores().files()

        val vectorStoreFileFuture =
            fileServiceAsync.create(
                FileCreateParams.builder()
                    .vectorStoreId("vs_abc123")
                    .fileId("file_id")
                    .attributes(
                        FileCreateParams.Attributes.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .chunkingStrategy(AutoFileChunkingStrategyParam.builder().build())
                    .build()
            )

        val vectorStoreFile = vectorStoreFileFuture.get()
        vectorStoreFile.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val fileServiceAsync = client.vectorStores().files()

        val vectorStoreFileFuture =
            fileServiceAsync.retrieve(
                FileRetrieveParams.builder()
                    .vectorStoreId("vs_abc123")
                    .fileId("file-abc123")
                    .build()
            )

        val vectorStoreFile = vectorStoreFileFuture.get()
        vectorStoreFile.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val fileServiceAsync = client.vectorStores().files()

        val vectorStoreFileFuture =
            fileServiceAsync.update(
                FileUpdateParams.builder()
                    .vectorStoreId("vs_abc123")
                    .fileId("file-abc123")
                    .attributes(
                        FileUpdateParams.Attributes.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .build()
            )

        val vectorStoreFile = vectorStoreFileFuture.get()
        vectorStoreFile.validate()
    }

    @Test
    fun listStopsOnExplicitFalse(wmRuntimeInfo: WireMockRuntimeInfo) {
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
            val page = client.vectorStores().files().list("vector_store_id").get()
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
    fun listContinuesUntilExplicitFalse(wmRuntimeInfo: WireMockRuntimeInfo) {
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
                val page = client.vectorStores().files().list("vector_store_id").get()
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
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val fileServiceAsync = client.vectorStores().files()

        val pageFuture = fileServiceAsync.list("vector_store_id")

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val fileServiceAsync = client.vectorStores().files()

        val vectorStoreFileDeletedFuture =
            fileServiceAsync.delete(
                FileDeleteParams.builder()
                    .vectorStoreId("vector_store_id")
                    .fileId("file_id")
                    .build()
            )

        val vectorStoreFileDeleted = vectorStoreFileDeletedFuture.get()
        vectorStoreFileDeleted.validate()
    }

    @Test
    fun content() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val fileServiceAsync = client.vectorStores().files()

        val pageFuture =
            fileServiceAsync.content(
                FileContentParams.builder().vectorStoreId("vs_abc123").fileId("file-abc123").build()
            )

        val page = pageFuture.get()
        page.response().validate()
    }
}
