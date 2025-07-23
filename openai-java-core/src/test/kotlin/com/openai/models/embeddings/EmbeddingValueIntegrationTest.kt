package com.openai.models.embeddings

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * Integration test to verify Base64 default functionality and backward compatibility of
 * EmbeddingValue. Ensures that both existing List<Float> usage and new Base64 format work
 * correctly.
 */
@DisplayName("EmbeddingValue Integration Test")
class EmbeddingValueIntegrationTest {

    private var originalDefault: EmbeddingCreateParams.EncodingFormat? = null

    @BeforeEach
    fun setUp() {
        // Save default settings before test
        originalDefault = EmbeddingDefaults.defaultEncodingFormat
    }

    @AfterEach
    fun tearDown() {
        // Restore default settings after test
        originalDefault?.let { EmbeddingDefaults.setDefaultEncodingFormat(it) }
    }

    /**
     * Test to confirm that the default encoding format is Base64. In the new implementation, Base64
     * becomes the default for performance improvements.
     */
    @Test
    @DisplayName("Confirm that default encoding format is Base64")
    fun testDefaultEncodingFormatIsBase64() {
        assertThat(EmbeddingDefaults.defaultEncodingFormat)
            .describedAs("Default encoding format must be Base64")
            .isEqualTo(EmbeddingCreateParams.EncodingFormat.BASE64)
    }

    /**
     * Test EmbeddingValue creation and format conversion functionality.
     * - Creating EmbeddingValue from Float array
     * - Converting to Base64 string
     * - Creating EmbeddingValue from Base64 string
     * - Auto-decode functionality (Base64 → List<Float>)
     */
    @Test
    @DisplayName("Test EmbeddingValue creation and format conversion")
    fun testEmbeddingValueCreationAndConversion() {
        val floats = listOf(1.0f, 2.0f, 3.0f, 4.0f)

        // Create EmbeddingValue from Float array
        val embeddingFromFloat = EmbeddingValue.ofFloatList(floats)
        assertThat(embeddingFromFloat.isFloatList())
            .describedAs("EmbeddingValue created from Float array must be in Float format")
            .isTrue()
        assertThat(embeddingFromFloat.asFloatList())
            .describedAs("Float array contents must match")
            .isEqualTo(floats)

        // Test conversion to Base64
        val base64 = embeddingFromFloat.asBase64String()
        assertThat(base64).describedAs("Base64 string must not be empty").isNotEmpty()

        // Create EmbeddingValue from Base64 string
        val embeddingFromBase64 = EmbeddingValue.ofBase64String(base64String)
        assertThat(embeddingFromBase64.isBase64String())
            .describedAs("EmbeddingValue created from Base64 string must be in Base64 format")
            .isTrue()
        assertThat(embeddingFromBase64.base64String())
            .describedAs("Base64 string contents must match")
            .isEqualTo(base64)

        // Test auto-decode: Base64 → List<Float>
        val decodedFloats = embeddingFromBase64.asFloatList()
        assertThat(decodedFloats)
            .describedAs("Decoded Float array must match the original array")
            .isEqualTo(floats)
    }

    /**
     * Test explicit Base64 encoding specification in EmbeddingCreateParams.Builder. Confirm that
     * Base64 format can be explicitly specified using the encodingFormat() method.
     */
    @Test
    @DisplayName("Test explicit Base64 encoding specification in EmbeddingCreateParams")
    fun testEmbeddingCreateParamsBuilderWithBase64Encoding() {
        val params =
            EmbeddingCreateParams.builder()
                .input("test input")
                .model("text-embedding-ada-002")
                .encodingFormat(encodingFormat = EmbeddingCreateParams.EncodingFormat.BASE64)
                .build()

        assertThat(params.encodingFormat()).describedAs("Encoding format must be set").isPresent()
        assertThat(params.encodingFormat().get())
            .describedAs("Explicitly specified encoding format must be Base64")
            .isEqualTo(EmbeddingCreateParams.EncodingFormat.BASE64)
    }

    /**
     * Test default behavior of EmbeddingCreateParams. Confirm that Base64 is used by default when
     * encoding format is not explicitly specified.
     */
    @Test
    @DisplayName("Test EmbeddingCreateParams default behavior")
    fun testEmbeddingCreateParamsDefaultBehavior() {
        val params =
            EmbeddingCreateParams.builder()
                .input("test input")
                .model("text-embedding-ada-002")
                .build() // Do not explicitly specify encoding format

        assertThat(params.encodingFormat())
            .describedAs("Encoding format must be set by default")
            .isPresent()
        assertThat(params.encodingFormat().get())
            .describedAs("Default encoding format must be Base64")
            .isEqualTo(EmbeddingCreateParams.EncodingFormat.BASE64)
    }

    /**
     * Test explicit Float format specification for backward compatibility. Confirm that the
     * traditional Float format can be explicitly specified using the encodingFormat() method.
     */
    @Test
    @DisplayName("Test explicit Float format specification for backward compatibility")
    fun testEmbeddingCreateParamsFloatCompatibility() {
        val params =
            EmbeddingCreateParams.builder()
                .input("test input")
                .model("text-embedding-ada-002")
                .encodingFormat(encodingFormat = EmbeddingCreateParams.EncodingFormat.FLOAT)
                .build()

        assertThat(params.encodingFormat()).describedAs("Encoding format must be set").isPresent()
        assertThat(params.encodingFormat().get())
            .describedAs(
                "Explicitly specified encoding format for backward compatibility must be Float"
            )
            .isEqualTo(EmbeddingCreateParams.EncodingFormat.FLOAT)
    }

    /**
     * Test EmbeddingDefaults global configuration change functionality.
     * - Change default setting to Float
     * - Confirm that new default setting is applied
     * - Confirm that settings can be reset
     */
    @Test
    @DisplayName("Test EmbeddingDefaults global configuration change")
    fun testEmbeddingDefaultsCanBeChanged() {
        val originalDefault = EmbeddingDefaults.defaultEncodingFormat

        try {
            // Change default to FLOAT
            EmbeddingDefaults.setDefaultEncodingFormat(EmbeddingCreateParams.EncodingFormat.FLOAT)
            assertThat(EmbeddingDefaults.defaultEncodingFormat)
                .describedAs("Default setting must be changed to FLOAT")
                .isEqualTo(EmbeddingCreateParams.EncodingFormat.FLOAT)

            // Test that new instances use the new default
            val params =
                EmbeddingCreateParams.builder()
                    .input("test input")
                    .model("text-embedding-ada-002")
                    .build()

            // Debug information
            println(
                "EmbeddingDefaults.defaultEncodingFormat = ${EmbeddingDefaults.defaultEncodingFormat}"
            )
            println("params.encodingFormat() = ${params.encodingFormat()}")
            println("params.encodingFormat().isPresent = ${params.encodingFormat().isPresent}")
            if (params.encodingFormat().isPresent) {
                println("params.encodingFormat().get() = ${params.encodingFormat().get()}")
            }

            assertThat(params.encodingFormat().get())
                .describedAs("New instances must use the changed default setting")
                .isEqualTo(EmbeddingCreateParams.EncodingFormat.FLOAT)

            // Test default reset functionality
            EmbeddingDefaults.resetToDefaults()
            assertThat(EmbeddingDefaults.defaultEncodingFormat)
                .describedAs("After reset, Base64 must be returned as default")
                .isEqualTo(EmbeddingCreateParams.EncodingFormat.BASE64)
        } finally {
            // Restore original default setting
            EmbeddingDefaults.setDefaultEncodingFormat(originalDefault)
        }
    }

    /**
     * Test EmbeddingValue validation functionality.
     * - Validation failure with empty Float array
     * - Validation failure with invalid Base64 string
     */
    @Test
    @DisplayName("Test EmbeddingValue validation functionality")
    fun testEmbeddingValueValidation() {
        // Test validation success with valid data
        val validFloats = listOf(1.0f, 2.0f, 3.0f)
        val validEmbedding = EmbeddingValue.ofFloatList(validFloats)

        assertThat(validEmbedding.validate())
            .describedAs("Validation with valid data must succeed")
            .isNotNull()
            .isEqualTo(validEmbedding)
    }

    /**
     * Test EmbeddingValue visitor pattern implementation.
     * - Visitor call for Float array case
     * - Visitor call for Base64 string case
     */
    @Test
    @DisplayName("Test EmbeddingValue visitor pattern")
    fun testEmbeddingValueVisitorPattern() {
        val floats = listOf(1.0f, 2.0f, 3.0f)
        val embeddingFromFloat = EmbeddingValue.ofFloatList(floats)

        // Visitor for Float array case
        val floatResult =
            embeddingFromFloat.accept(
                object : EmbeddingValue.Visitor<String> {
                    override fun visitFloatList(floats: List<Float>): String = "float_visited"

                    override fun visitBase64String(base64: String): String = "base64_visited"

                    override fun unknown(json: com.openai.core.JsonValue?): String =
                        "unknown_visited"
                }
            )

        assertThat(floatResult)
            .describedAs("For Float array case, visitFloatList must be called")
            .isEqualTo("float_visited")

        // Visitor for Base64 case
        val base64 = embeddingFromFloat.asBase64String()
        val embeddingFromBase64 = EmbeddingValue.ofBase64String(base64)

        val base64Result =
            embeddingFromBase64.accept(
                object : EmbeddingValue.Visitor<String> {
                    override fun visitFloatList(floats: List<Float>): String = "float_visited"

                    override fun visitBase64String(base64String: String): String = "base64_visited"

                    override fun unknown(json: com.openai.core.JsonValue?): String =
                        "unknown_visited"
                }
            )

        assertThat(base64Result)
            .describedAs("For Base64 string case, visitBase64String must be called")
            .isEqualTo("base64_visited")
    }
}
