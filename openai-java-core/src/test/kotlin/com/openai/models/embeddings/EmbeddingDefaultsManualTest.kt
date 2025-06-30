package com.openai.models.embeddings

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/** Manual test for EmbeddingDefaults behavior */
@DisplayName("EmbeddingDefaults Manual Test")
class EmbeddingDefaultsManualTest {

    @Test
    @DisplayName("Manual test for global defaults")
    fun testGlobalDefaultsManually() {
        println("=== Manual Test ===")

        // Step 1: Check original default
        val originalDefault = EmbeddingDefaults.defaultEncodingFormat
        println("Original default: $originalDefault")

        // Step 2: Change to FLOAT
        EmbeddingDefaults.setDefaultEncodingFormat(EmbeddingCreateParams.EncodingFormat.FLOAT)
        val changedDefault = EmbeddingDefaults.defaultEncodingFormat
        println("Changed default: $changedDefault")

        // Step 3: Build params without explicit encoding
        val params =
            EmbeddingCreateParams.builder()
                .input("test input")
                .model("text-embedding-ada-002")
                .build()

        println("Params encoding format: ${params.encodingFormat()}")
        println("Is present: ${params.encodingFormat().isPresent}")
        if (params.encodingFormat().isPresent) {
            println("Value: ${params.encodingFormat().get()}")
        }

        // Step 4: Reset to defaults
        EmbeddingDefaults.resetToDefaults()
        val resetDefault = EmbeddingDefaults.defaultEncodingFormat
        println("Reset default: $resetDefault")

        // Assertions for verification
        assertThat(changedDefault).isEqualTo(EmbeddingCreateParams.EncodingFormat.FLOAT)
        assertThat(params.encodingFormat().get())
            .isEqualTo(EmbeddingCreateParams.EncodingFormat.FLOAT)
        assertThat(resetDefault).isEqualTo(EmbeddingCreateParams.EncodingFormat.BASE64)
    }
}
