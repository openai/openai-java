// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.vectorstores

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VectorStoreSearchResponseTest {

    @Test
    fun createAndRoundtrip() {
        val vectorStoreSearchResponse =
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

        assertThat(vectorStoreSearchResponse.attributes())
            .contains(
                VectorStoreSearchResponse.Attributes.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(vectorStoreSearchResponse.content())
            .containsExactly(
                VectorStoreSearchResponse.Content.builder()
                    .text("text")
                    .type(VectorStoreSearchResponse.Content.Type.TEXT)
                    .build()
            )
        assertThat(vectorStoreSearchResponse.fileId()).isEqualTo("file_id")
        assertThat(vectorStoreSearchResponse.filename()).isEqualTo("filename")
        assertThat(vectorStoreSearchResponse.score()).isEqualTo(0.0)

        val jsonMapper = jsonMapper()

        val roundtrippedVectorStoreSearchResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(vectorStoreSearchResponse),
                jacksonTypeRef<VectorStoreSearchResponse>(),
            )

        assertThat(roundtrippedVectorStoreSearchResponse).isEqualTo(vectorStoreSearchResponse)
    }
}
