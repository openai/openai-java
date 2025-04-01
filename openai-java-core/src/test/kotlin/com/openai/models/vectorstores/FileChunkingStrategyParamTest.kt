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

internal class FileChunkingStrategyParamTest {

    @Test
    fun ofAuto() {
        val auto = AutoFileChunkingStrategyParam.builder().build()

        val fileChunkingStrategyParam = FileChunkingStrategyParam.ofAuto(auto)

        assertThat(fileChunkingStrategyParam.auto()).contains(auto)
        assertThat(fileChunkingStrategyParam.static_()).isEmpty
    }

    @Test
    fun ofAutoRoundtrip() {
        val jsonMapper = jsonMapper()
        val fileChunkingStrategyParam =
            FileChunkingStrategyParam.ofAuto(AutoFileChunkingStrategyParam.builder().build())

        val roundtrippedFileChunkingStrategyParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileChunkingStrategyParam),
                jacksonTypeRef<FileChunkingStrategyParam>(),
            )

        assertThat(roundtrippedFileChunkingStrategyParam).isEqualTo(fileChunkingStrategyParam)
    }

    @Test
    fun ofStatic() {
        val static_ =
            StaticFileChunkingStrategyObjectParam.builder()
                .static_(
                    StaticFileChunkingStrategy.builder()
                        .chunkOverlapTokens(0L)
                        .maxChunkSizeTokens(100L)
                        .build()
                )
                .build()

        val fileChunkingStrategyParam = FileChunkingStrategyParam.ofStatic(static_)

        assertThat(fileChunkingStrategyParam.auto()).isEmpty
        assertThat(fileChunkingStrategyParam.static_()).contains(static_)
    }

    @Test
    fun ofStaticRoundtrip() {
        val jsonMapper = jsonMapper()
        val fileChunkingStrategyParam =
            FileChunkingStrategyParam.ofStatic(
                StaticFileChunkingStrategyObjectParam.builder()
                    .static_(
                        StaticFileChunkingStrategy.builder()
                            .chunkOverlapTokens(0L)
                            .maxChunkSizeTokens(100L)
                            .build()
                    )
                    .build()
            )

        val roundtrippedFileChunkingStrategyParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileChunkingStrategyParam),
                jacksonTypeRef<FileChunkingStrategyParam>(),
            )

        assertThat(roundtrippedFileChunkingStrategyParam).isEqualTo(fileChunkingStrategyParam)
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
        val fileChunkingStrategyParam =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<FileChunkingStrategyParam>())

        val e = assertThrows<OpenAIInvalidDataException> { fileChunkingStrategyParam.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
