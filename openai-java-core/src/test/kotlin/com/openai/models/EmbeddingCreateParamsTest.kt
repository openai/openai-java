// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EmbeddingCreateParamsTest {

    @Test
    fun createEmbeddingCreateParams() {
        EmbeddingCreateParams.builder()
            .input(
                EmbeddingCreateParams.Input.ofString("The quick brown fox jumped over the lazy dog")
            )
            .model(EmbeddingModel.TEXT_EMBEDDING_ADA_002)
            .dimensions(1L)
            .encodingFormat(EmbeddingCreateParams.EncodingFormat.FLOAT)
            .user("user-1234")
            .build()
    }

    @Test
    fun getBody() {
        val params =
            EmbeddingCreateParams.builder()
                .input(
                    EmbeddingCreateParams.Input.ofString(
                        "The quick brown fox jumped over the lazy dog"
                    )
                )
                .model(EmbeddingModel.TEXT_EMBEDDING_ADA_002)
                .dimensions(1L)
                .encodingFormat(EmbeddingCreateParams.EncodingFormat.FLOAT)
                .user("user-1234")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.input())
            .isEqualTo(
                EmbeddingCreateParams.Input.ofString("The quick brown fox jumped over the lazy dog")
            )
        assertThat(body.model()).isEqualTo(EmbeddingModel.TEXT_EMBEDDING_ADA_002)
        assertThat(body.dimensions()).isEqualTo(1L)
        assertThat(body.encodingFormat()).isEqualTo(EmbeddingCreateParams.EncodingFormat.FLOAT)
        assertThat(body.user()).isEqualTo("user-1234")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            EmbeddingCreateParams.builder()
                .input(
                    EmbeddingCreateParams.Input.ofString(
                        "The quick brown fox jumped over the lazy dog"
                    )
                )
                .model(EmbeddingModel.TEXT_EMBEDDING_ADA_002)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.input())
            .isEqualTo(
                EmbeddingCreateParams.Input.ofString("The quick brown fox jumped over the lazy dog")
            )
        assertThat(body.model()).isEqualTo(EmbeddingModel.TEXT_EMBEDDING_ADA_002)
    }
}
