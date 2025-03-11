// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import java.util.Optional
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EmbeddingTest {

    @Test
    fun createEmbedding() {
        val embedding =
            Embedding.builder()
                .addEmbedding(
                    EmbeddingValue(
                        floatEmbedding = Optional.of(mutableListOf(0.0)),
                        base64Embedding = Optional.empty(),
                    )
                )
                .build()
        assertThat(embedding).isNotNull
        //        assertThat(embedding.embedding()).containsExactly(0.0)
        assertThat(embedding.embedding().floatEmbedding).containsSame(mutableListOf(0.0))
        assertThat(embedding.index()).isEqualTo(0L)
    }
}
