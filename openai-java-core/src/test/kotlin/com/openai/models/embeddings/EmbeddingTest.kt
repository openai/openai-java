// File generated from our OpenAPI spec by Stainless.

package com.openai.models.embeddings

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmbeddingTest {

    @Test
    fun create() {
        val embedding = Embedding.builder().addEmbedding(0.0f).index(0L).build()

        assertThat(embedding.embedding()).containsExactly(0.0f)
        assertThat(embedding.index()).isEqualTo(0L)
    }

    @Test
    fun create_setThenAdd() {
        val embedding =
            Embedding.builder()
                .embedding(EmbeddingValue.ofFloats(listOf(1.0f, 2.0f)))
                .addEmbedding(3.0f)
                .index(0L)
                .build()

        assertThat(embedding.embedding()).containsExactly(1.0f, 2.0f, 3.0f)
        assertThat(embedding.index()).isEqualTo(0L)
    }

    @Test
    fun create_addThenSet() {
        val embedding =
            Embedding.builder()
                .addEmbedding(3.0f)
                .embedding(EmbeddingValue.ofFloats(listOf(1.0f, 2.0f)))
                .index(0L)
                .build()

        assertThat(embedding.embedding()).containsExactly(1.0f, 2.0f)
        assertThat(embedding.index()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val embedding = Embedding.builder().addEmbedding(0.0f).index(0L).build()

        val roundtrippedEmbedding =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(embedding),
                jacksonTypeRef<Embedding>(),
            )

        assertThat(roundtrippedEmbedding).isEqualTo(embedding)
    }
}
