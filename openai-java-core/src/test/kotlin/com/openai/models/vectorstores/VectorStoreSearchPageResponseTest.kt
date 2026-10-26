// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.vectorstores

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VectorStoreSearchPageResponseTest {

    @Test
    fun createAndRoundtrip() {
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

        val jsonMapper = jsonMapper()

        val roundtrippedVectorStoreSearchPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(vectorStoreSearchPageResponse),
                jacksonTypeRef<VectorStoreSearchPageResponse>(),
            )

        assertThat(roundtrippedVectorStoreSearchPageResponse)
            .isEqualTo(vectorStoreSearchPageResponse)
    }
}
