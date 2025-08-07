// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class CustomToolInputFormatTest {

    @Test
    fun ofText() {
        val customToolInputFormat = CustomToolInputFormat.ofText()

        assertThat(customToolInputFormat.text()).contains(JsonValue.from(mapOf("type" to "text")))
        assertThat(customToolInputFormat.grammar()).isEmpty
    }

    @Test
    fun ofTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val customToolInputFormat = CustomToolInputFormat.ofText()

        val roundtrippedCustomToolInputFormat =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(customToolInputFormat),
                jacksonTypeRef<CustomToolInputFormat>(),
            )

        assertThat(roundtrippedCustomToolInputFormat).isEqualTo(customToolInputFormat)
    }

    @Test
    fun ofGrammar() {
        val grammar =
            CustomToolInputFormat.Grammar.builder()
                .definition("definition")
                .syntax(CustomToolInputFormat.Grammar.Syntax.LARK)
                .build()

        val customToolInputFormat = CustomToolInputFormat.ofGrammar(grammar)

        assertThat(customToolInputFormat.text()).isEmpty
        assertThat(customToolInputFormat.grammar()).contains(grammar)
    }

    @Test
    fun ofGrammarRoundtrip() {
        val jsonMapper = jsonMapper()
        val customToolInputFormat =
            CustomToolInputFormat.ofGrammar(
                CustomToolInputFormat.Grammar.builder()
                    .definition("definition")
                    .syntax(CustomToolInputFormat.Grammar.Syntax.LARK)
                    .build()
            )

        val roundtrippedCustomToolInputFormat =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(customToolInputFormat),
                jacksonTypeRef<CustomToolInputFormat>(),
            )

        assertThat(roundtrippedCustomToolInputFormat).isEqualTo(customToolInputFormat)
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
        val customToolInputFormat =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<CustomToolInputFormat>())

        val e = assertThrows<OpenAIInvalidDataException> { customToolInputFormat.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
