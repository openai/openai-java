// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class TextFormatParamTest {

    @Test
    fun ofText() {
        val textFormatParam = TextFormatParam.ofText()

        assertThat(textFormatParam.text()).contains(JsonValue.from(mapOf("type" to "text")))
        assertThat(textFormatParam.jsonSchema()).isEmpty
    }

    @Test
    fun ofTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val textFormatParam = TextFormatParam.ofText()

        val roundtrippedTextFormatParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(textFormatParam),
                jacksonTypeRef<TextFormatParam>(),
            )

        assertThat(roundtrippedTextFormatParam).isEqualTo(textFormatParam)
    }

    @Test
    fun ofJsonSchema() {
        val jsonSchema =
            TextFormatParam.JsonSchema.builder()
                .schema(
                    TextFormatParam.JsonSchema.Schema.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .build()

        val textFormatParam = TextFormatParam.ofJsonSchema(jsonSchema)

        assertThat(textFormatParam.text()).isEmpty
        assertThat(textFormatParam.jsonSchema()).contains(jsonSchema)
    }

    @Test
    fun ofJsonSchemaRoundtrip() {
        val jsonMapper = jsonMapper()
        val textFormatParam =
            TextFormatParam.ofJsonSchema(
                TextFormatParam.JsonSchema.builder()
                    .schema(
                        TextFormatParam.JsonSchema.Schema.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .build()
            )

        val roundtrippedTextFormatParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(textFormatParam),
                jacksonTypeRef<TextFormatParam>(),
            )

        assertThat(roundtrippedTextFormatParam).isEqualTo(textFormatParam)
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
        val textFormatParam =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<TextFormatParam>())

        val e = assertThrows<OpenAIInvalidDataException> { textFormatParam.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
