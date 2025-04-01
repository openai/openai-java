// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class FileChunkingStrategyTest {

    @Test
    fun ofStatic() {
        val static_ =
            StaticFileChunkingStrategyObject.builder()
                .static_(
                    StaticFileChunkingStrategy.builder()
                        .chunkOverlapTokens(0L)
                        .maxChunkSizeTokens(100L)
                        .build()
                )
                .build()

        val fileChunkingStrategy = FileChunkingStrategy.ofStatic(static_)

        assertThat(fileChunkingStrategy.static_()).contains(static_)
        assertThat(fileChunkingStrategy.other()).isEmpty
    }

    @Test
    fun ofStaticRoundtrip() {
        val jsonMapper = jsonMapper()
        val fileChunkingStrategy =
            FileChunkingStrategy.ofStatic(
                StaticFileChunkingStrategyObject.builder()
                    .static_(
                        StaticFileChunkingStrategy.builder()
                            .chunkOverlapTokens(0L)
                            .maxChunkSizeTokens(100L)
                            .build()
                    )
                    .build()
            )

        val roundtrippedFileChunkingStrategy =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileChunkingStrategy),
                jacksonTypeRef<FileChunkingStrategy>(),
            )

        assertThat(roundtrippedFileChunkingStrategy).isEqualTo(fileChunkingStrategy)
    }

    @Test
    fun ofOther() {
        val other = OtherFileChunkingStrategyObject.builder().build()

        val fileChunkingStrategy = FileChunkingStrategy.ofOther(other)

        assertThat(fileChunkingStrategy.static_()).isEmpty
        assertThat(fileChunkingStrategy.other()).contains(other)
    }

    @Test
    fun ofOtherRoundtrip() {
        val jsonMapper = jsonMapper()
        val fileChunkingStrategy =
            FileChunkingStrategy.ofOther(OtherFileChunkingStrategyObject.builder().build())

        val roundtrippedFileChunkingStrategy =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileChunkingStrategy),
                jacksonTypeRef<FileChunkingStrategy>(),
            )

        assertThat(roundtrippedFileChunkingStrategy).isEqualTo(fileChunkingStrategy)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val fileChunkingStrategy =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<FileChunkingStrategy>())

        val e = assertThrows<OpenAIInvalidDataException> { fileChunkingStrategy.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
