// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CreateEmbeddingResponseTest {

    @Test
    fun createCreateEmbeddingResponse() {
        val createEmbeddingResponse =
            CreateEmbeddingResponse.builder()
                .data(
                    listOf(
                        Embedding.builder()
                            .embedding(listOf(0.0))
                            .index(0L)
                            .object_(Embedding.Object.EMBEDDING)
                            .build()
                    )
                )
                .model("model")
                .object_(CreateEmbeddingResponse.Object.LIST)
                .usage(
                    CreateEmbeddingResponse.Usage.builder().promptTokens(0L).totalTokens(0L).build()
                )
                .build()
        assertThat(createEmbeddingResponse).isNotNull
        assertThat(createEmbeddingResponse.data())
            .containsExactly(
                Embedding.builder()
                    .embedding(listOf(0.0))
                    .index(0L)
                    .object_(Embedding.Object.EMBEDDING)
                    .build()
            )
        assertThat(createEmbeddingResponse.model()).isEqualTo("model")
        assertThat(createEmbeddingResponse.object_()).isEqualTo(CreateEmbeddingResponse.Object.LIST)
        assertThat(createEmbeddingResponse.usage())
            .isEqualTo(
                CreateEmbeddingResponse.Usage.builder().promptTokens(0L).totalTokens(0L).build()
            )
    }
}