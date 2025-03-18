// File generated from our OpenAPI spec by Stainless.

package com.openai.models.embeddings

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CreateEmbeddingResponseTest {

    @Test
    fun create() {
        val createEmbeddingResponse =
            CreateEmbeddingResponse.builder()
                .addData(Embedding.builder().addEmbedding(0.0).index(0L).build())
                .model("model")
                .usage(
                    CreateEmbeddingResponse.Usage.builder().promptTokens(0L).totalTokens(0L).build()
                )
                .build()

        assertThat(createEmbeddingResponse.data())
            .containsExactly(Embedding.builder().addEmbedding(0.0).index(0L).build())
        assertThat(createEmbeddingResponse.model()).isEqualTo("model")
        assertThat(createEmbeddingResponse.usage())
            .isEqualTo(
                CreateEmbeddingResponse.Usage.builder().promptTokens(0L).totalTokens(0L).build()
            )
    }
}
