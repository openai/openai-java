package com.openai.models.embeddings

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmbeddingValueTest {

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
    fun ofFloats() {
        val floats = listOf(1.0f, 2.0f, 3.0f, 4.0f)

        val embeddingValue = EmbeddingValue.ofFloats(floats)

        assertThat(embeddingValue.isFloats()).isTrue()
        assertThat(embeddingValue.isBase64()).isFalse()
        assertThat(embeddingValue.floats()).hasValue(floats)
        assertThat(embeddingValue.base64()).isEmpty
        assertThat(embeddingValue.asFloats()).isEqualTo(floats)
        assertThat(embeddingValue.asBase64()).isEqualTo("AACAPwAAAEAAAEBAAACAQA==")
    }

    @Test
    fun ofBase64() {
        val base64 = "AACAPwAAAEAAAEBAAACAQA=="

        val embeddingValue = EmbeddingValue.ofBase64(base64)

        assertThat(embeddingValue.isFloats()).isFalse()
        assertThat(embeddingValue.isBase64()).isTrue()
        assertThat(embeddingValue.floats()).isEmpty
        assertThat(embeddingValue.base64()).hasValue(base64)
        assertThat(embeddingValue.asFloats()).containsExactly(1.0f, 2.0f, 3.0f, 4.0f)
        assertThat(embeddingValue.asBase64()).isEqualTo(base64)
    }
}
