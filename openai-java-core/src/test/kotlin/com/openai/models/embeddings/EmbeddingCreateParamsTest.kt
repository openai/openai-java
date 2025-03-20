// File generated from our OpenAPI spec by Stainless.

package com.openai.models.embeddings

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmbeddingCreateParamsTest {

    @Test
    fun create() {
        EmbeddingCreateParams.builder()
            .input("The quick brown fox jumped over the lazy dog")
            .model(EmbeddingModel.TEXT_EMBEDDING_ADA_002)
            .dimensions(1L)
            .encodingFormat(EmbeddingCreateParams.EncodingFormat.FLOAT)
            .user("user-1234")
            .build()
    }

    @Test
    fun body() {
        val params =
            EmbeddingCreateParams.builder()
                .input("The quick brown fox jumped over the lazy dog")
                .model(EmbeddingModel.TEXT_EMBEDDING_ADA_002)
                .dimensions(1L)
                .encodingFormat(EmbeddingCreateParams.EncodingFormat.FLOAT)
                .user("user-1234")
                .build()

        val body = params._body()

        assertThat(body.input())
            .isEqualTo(
                EmbeddingCreateParams.Input.ofString("The quick brown fox jumped over the lazy dog")
            )
        assertThat(body.model()).isEqualTo(EmbeddingModel.TEXT_EMBEDDING_ADA_002)
        assertThat(body.dimensions()).contains(1L)
        assertThat(body.encodingFormat()).contains(EmbeddingCreateParams.EncodingFormat.FLOAT)
        assertThat(body.user()).contains("user-1234")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            EmbeddingCreateParams.builder()
                .input("The quick brown fox jumped over the lazy dog")
                .model(EmbeddingModel.TEXT_EMBEDDING_ADA_002)
                .build()

        val body = params._body()

        assertThat(body.input())
            .isEqualTo(
                EmbeddingCreateParams.Input.ofString("The quick brown fox jumped over the lazy dog")
            )
        assertThat(body.model()).isEqualTo(EmbeddingModel.TEXT_EMBEDDING_ADA_002)
    }
}
