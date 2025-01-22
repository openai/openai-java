// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CreateEmbeddingResponseTest {

    @Test
    fun createCreateEmbeddingResponse() {
        val createEmbeddingResponse =
            CreateEmbeddingResponse.builder()
                .addData(Embedding.builder().addEmbedding(0.0).index(0L).build())
                .model("model")
                .usage(
                    CreateEmbeddingResponse.Usage.builder().promptTokens(0L).totalTokens(0L).build()
                )
                .build()
        assertThat(createEmbeddingResponse).isNotNull
        assertThat(createEmbeddingResponse.data())
            .containsExactly(Embedding.builder().addEmbedding(0.0).index(0L).build())
        assertThat(createEmbeddingResponse.model()).isEqualTo("model")
        assertThat(createEmbeddingResponse.usage())
            .isEqualTo(
                CreateEmbeddingResponse.Usage.builder().promptTokens(0L).totalTokens(0L).build()
            )
    }
}
