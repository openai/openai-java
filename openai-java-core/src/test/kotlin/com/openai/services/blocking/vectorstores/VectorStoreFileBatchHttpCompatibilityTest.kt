package com.openai.services.blocking.vectorstores

import com.github.tomakehurst.wiremock.client.WireMock.any
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.vectorstores.filebatches.FileBatchCancelParams
import com.openai.models.vectorstores.filebatches.FileBatchCreateParams
import com.openai.models.vectorstores.filebatches.FileBatchRetrieveParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.parallel.ResourceLock
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class VectorStoreFileBatchHttpCompatibilityTest {

    private fun payload(value: String): String =
        """{
            "id": "vsfb_test", "object": "$value", "created_at": 123,
            "file_counts": {"cancelled": 0, "completed": 1, "failed": 0, "in_progress": 0, "total": 1},
            "status": "completed", "vector_store_id": "vs_test",
            "future_field": {"preserved": true}
        }"""

    @ParameterizedTest
    @ValueSource(strings = ["vector_store.file_batch", "vector_store.files_batch"])
    fun strictClientsAcceptKnownSpellings(value: String, server: WireMockRuntimeInfo) {
        stubFor(any(anyUrl()).willReturn(okJson(payload(value))))
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(server.httpBaseUrl)
                .apiKey("test-key")
                .responseValidation(true)
                .build()
        try {
            val batches = client.vectorStores().fileBatches()
            val retrieve =
                FileBatchRetrieveParams.builder()
                    .vectorStoreId("vs_test")
                    .batchId("vsfb_test")
                    .build()
            val create =
                FileBatchCreateParams.builder()
                    .vectorStoreId("vs_test")
                    .addFileId("file_test")
                    .build()
            val cancel =
                FileBatchCancelParams.builder()
                    .vectorStoreId("vs_test")
                    .batchId("vsfb_test")
                    .build()
            val asyncBatches = client.async().vectorStores().fileBatches()
            val results =
                listOf(
                    batches.retrieve(retrieve),
                    batches.create(create),
                    batches.cancel(cancel),
                    asyncBatches.retrieve(retrieve).join(),
                    asyncBatches.create(create).join(),
                    asyncBatches.cancel(cancel).join(),
                )
            results.forEach { assertThat(it._object_()).isEqualTo(JsonValue.from(value)) }
        } finally {
            client.close()
        }
    }
}
