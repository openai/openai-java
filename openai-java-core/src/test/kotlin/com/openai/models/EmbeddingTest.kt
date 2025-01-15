// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EmbeddingTest {

    @Test
    fun createEmbedding() {
        val embedding =
            Embedding.builder()
                .addEmbedding(0.0)
                .index(0L)
                .object_(Embedding.Object.EMBEDDING)
                .build()
        assertThat(embedding).isNotNull
        assertThat(embedding.embedding()).containsExactly(0.0)
        assertThat(embedding.index()).isEqualTo(0L)
        assertThat(embedding.object_()).isEqualTo(Embedding.Object.EMBEDDING)
    }
}
