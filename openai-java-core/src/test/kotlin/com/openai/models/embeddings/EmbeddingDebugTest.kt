// Simple debug test for Embedding
package com.openai.models.embeddings

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.junit.jupiter.api.Test

class EmbeddingDebugTest {

    @Test
    fun debugEmbeddingCreation() {
        println("=== Debug: Creating embedding with builder ===")

        val builder = Embedding.builder()
        println("Builder created: $builder")

        builder.addEmbedding(0.0f)
        println("After addEmbedding(0.0f): $builder")

        builder.index(0L)
        println("After index(0L): $builder")

        val embedding = builder.build()
        println("After build(): $embedding")

        try {
            val embeddingList = embedding.embedding()
            println("embedding.embedding(): $embeddingList")
            println("embedding.embedding().size: ${embeddingList.size}")
        } catch (e: Exception) {
            println("Error calling embedding(): ${e.message}")
            e.printStackTrace()
        }

        try {
            val index = embedding.index()
            println("embedding.index(): $index")
        } catch (e: Exception) {
            println("Error calling index(): ${e.message}")
        }

        // Test JSON serialization/deserialization
        try {
            val jsonMapper = jsonMapper()
            val jsonString = jsonMapper.writeValueAsString(embedding)
            println("JSON: $jsonString")

            val roundtrippedEmbedding =
                jsonMapper.readValue(jsonString, jacksonTypeRef<Embedding>())
            println("Roundtripped: $roundtrippedEmbedding")

            val roundtrippedList = roundtrippedEmbedding.embedding()
            println("Roundtripped embedding(): $roundtrippedList")
            println("Roundtripped size: ${roundtrippedList.size}")

            println("Original equals roundtripped: ${embedding == roundtrippedEmbedding}")
        } catch (e: Exception) {
            println("Error in JSON roundtrip: ${e.message}")
            e.printStackTrace()
        }
    }
}
