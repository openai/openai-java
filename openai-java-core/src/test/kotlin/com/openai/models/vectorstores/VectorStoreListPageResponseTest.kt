// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VectorStoreListPageResponseTest {

    @Test
    fun create() {
        val vectorStoreListPageResponse =
            VectorStoreListPageResponse.builder()
                .addData(
                    VectorStore.builder()
                        .id("id")
                        .createdAt(0L)
                        .fileCounts(
                            VectorStore.FileCounts.builder()
                                .cancelled(0L)
                                .completed(0L)
                                .failed(0L)
                                .inProgress(0L)
                                .total(0L)
                                .build()
                        )
                        .lastActiveAt(0L)
                        .metadata(
                            VectorStore.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .name("name")
                        .status(VectorStore.Status.EXPIRED)
                        .usageBytes(0L)
                        .expiresAfter(VectorStore.ExpiresAfter.builder().days(1L).build())
                        .expiresAt(0L)
                        .build()
                )
                .firstId("vs_abc123")
                .hasMore(false)
                .lastId("vs_abc456")
                .object_("list")
                .build()

        assertThat(vectorStoreListPageResponse.data())
            .containsExactly(
                VectorStore.builder()
                    .id("id")
                    .createdAt(0L)
                    .fileCounts(
                        VectorStore.FileCounts.builder()
                            .cancelled(0L)
                            .completed(0L)
                            .failed(0L)
                            .inProgress(0L)
                            .total(0L)
                            .build()
                    )
                    .lastActiveAt(0L)
                    .metadata(
                        VectorStore.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .name("name")
                    .status(VectorStore.Status.EXPIRED)
                    .usageBytes(0L)
                    .expiresAfter(VectorStore.ExpiresAfter.builder().days(1L).build())
                    .expiresAt(0L)
                    .build()
            )
        assertThat(vectorStoreListPageResponse.firstId()).isEqualTo("vs_abc123")
        assertThat(vectorStoreListPageResponse.hasMore()).isEqualTo(false)
        assertThat(vectorStoreListPageResponse.lastId()).isEqualTo("vs_abc456")
        assertThat(vectorStoreListPageResponse.object_()).isEqualTo("list")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val vectorStoreListPageResponse =
            VectorStoreListPageResponse.builder()
                .addData(
                    VectorStore.builder()
                        .id("id")
                        .createdAt(0L)
                        .fileCounts(
                            VectorStore.FileCounts.builder()
                                .cancelled(0L)
                                .completed(0L)
                                .failed(0L)
                                .inProgress(0L)
                                .total(0L)
                                .build()
                        )
                        .lastActiveAt(0L)
                        .metadata(
                            VectorStore.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .name("name")
                        .status(VectorStore.Status.EXPIRED)
                        .usageBytes(0L)
                        .expiresAfter(VectorStore.ExpiresAfter.builder().days(1L).build())
                        .expiresAt(0L)
                        .build()
                )
                .firstId("vs_abc123")
                .hasMore(false)
                .lastId("vs_abc456")
                .object_("list")
                .build()

        val roundtrippedVectorStoreListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(vectorStoreListPageResponse),
                jacksonTypeRef<VectorStoreListPageResponse>(),
            )

        assertThat(roundtrippedVectorStoreListPageResponse).isEqualTo(vectorStoreListPageResponse)
    }
}
