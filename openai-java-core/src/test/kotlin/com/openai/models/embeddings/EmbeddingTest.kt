// File generated from our OpenAPI spec by Stainless.

package com.openai.models.embeddings

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmbeddingTest {

    @Test
    fun create() {
        val embedding = Embedding.builder().addEmbedding(0.0).index(0L).build()

        assertThat(embedding.embedding()).containsExactly(0.0)
        assertThat(embedding.index()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val embedding = Embedding.builder().addEmbedding(0.0).index(0L).build()

        val roundtrippedEmbedding =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(embedding),
                jacksonTypeRef<Embedding>(),
            )

        assertThat(roundtrippedEmbedding).isEqualTo(embedding)
    }
}
