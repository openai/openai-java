// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VectorStoreSearchPageResponseTest {

    @Test
    fun create() {
        val vectorStoreSearchPageResponse =
            VectorStoreSearchPageResponse.builder()
                .addData(
                    VectorStoreSearchResponse.builder()
                        .attributes(
                            VectorStoreSearchResponse.Attributes.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .addContent(
                            VectorStoreSearchResponse.Content.builder()
                                .text("text")
                                .type(VectorStoreSearchResponse.Content.Type.TEXT)
                                .build()
                        )
                        .fileId("file_id")
                        .filename("filename")
                        .score(0.0)
                        .build()
                )
                .hasMore(true)
                .nextPage("next_page")
                .addSearchQuery("string")
                .build()

        assertThat(vectorStoreSearchPageResponse.data())
            .containsExactly(
                VectorStoreSearchResponse.builder()
                    .attributes(
                        VectorStoreSearchResponse.Attributes.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .addContent(
                        VectorStoreSearchResponse.Content.builder()
                            .text("text")
                            .type(VectorStoreSearchResponse.Content.Type.TEXT)
                            .build()
                    )
                    .fileId("file_id")
                    .filename("filename")
                    .score(0.0)
                    .build()
            )
        assertThat(vectorStoreSearchPageResponse.hasMore()).isEqualTo(true)
        assertThat(vectorStoreSearchPageResponse.nextPage()).contains("next_page")
        assertThat(vectorStoreSearchPageResponse.searchQuery()).containsExactly("string")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val vectorStoreSearchPageResponse =
            VectorStoreSearchPageResponse.builder()
                .addData(
                    VectorStoreSearchResponse.builder()
                        .attributes(
                            VectorStoreSearchResponse.Attributes.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .addContent(
                            VectorStoreSearchResponse.Content.builder()
                                .text("text")
                                .type(VectorStoreSearchResponse.Content.Type.TEXT)
                                .build()
                        )
                        .fileId("file_id")
                        .filename("filename")
                        .score(0.0)
                        .build()
                )
                .hasMore(true)
                .nextPage("next_page")
                .addSearchQuery("string")
                .build()

        val roundtrippedVectorStoreSearchPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(vectorStoreSearchPageResponse),
                jacksonTypeRef<VectorStoreSearchPageResponse>(),
            )

        assertThat(roundtrippedVectorStoreSearchPageResponse)
            .isEqualTo(vectorStoreSearchPageResponse)
    }
}
