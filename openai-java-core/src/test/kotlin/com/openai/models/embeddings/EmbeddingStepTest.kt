package com.openai.models.embeddings

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/** Step-by-step trace test */
@DisplayName("Step Test")
class EmbeddingStepTest {

    @Test
    @DisplayName("Step 1: Check initial state")
    fun step1_checkInitialState() {
        println("===== Step 1: Check initial state =====")
        val params =
            EmbeddingCreateParams.builder().input("test").model("text-embedding-ada-002").build()
        val defaultFormat = params.encodingFormat().orElse(null)
        println("Default encodingFormat in params = $defaultFormat")
        println("EncodingFormat.BASE64 = ${EmbeddingCreateParams.EncodingFormat.BASE64}")
        println("EncodingFormat.FLOAT = ${EmbeddingCreateParams.EncodingFormat.FLOAT}")
        println(
            "Is default BASE64? ${defaultFormat == EmbeddingCreateParams.EncodingFormat.BASE64}"
        )
    }

    @Test
    @DisplayName("Step 2: Check builder creation")
    fun step2_checkBuilder() {
        println("===== Step 2: Check builder creation =====")
        val builder = EmbeddingCreateParams.builder().input("test").model("text-embedding-ada-002")
        println("Builder created")

        // Check state before build
        println("About to build...")
        val params = builder.build()
        println("Build completed")

        val encodingFormat = params.encodingFormat()
        println("encodingFormat() result: $encodingFormat")
        println("isPresent: ${encodingFormat.isPresent}")
        if (encodingFormat.isPresent) {
            println("Value: ${encodingFormat.get()}")
        }
    }

    @Test
    @DisplayName("Step 3: Explicit Base64 setting")
    fun step3_explicitBase64() {
        println("===== Step 3: Explicit Base64 setting =====")
        val params =
            EmbeddingCreateParams.builder()
                .input("test")
                .model("text-embedding-ada-002")
                .encodingFormat(EmbeddingCreateParams.EncodingFormat.BASE64)
                .build()

        val encodingFormat = params.encodingFormat()
        println("After explicit Base64 setting: $encodingFormat")
        if (encodingFormat.isPresent) {
            println("Value: ${encodingFormat.get()}")
        }
    }
}
