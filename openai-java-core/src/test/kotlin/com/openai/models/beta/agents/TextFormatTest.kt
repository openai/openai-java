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

internal class TextFormatTest {

    @Test
    fun ofText() {
        val textFormat = TextFormat.ofText()

        assertThat(textFormat.text()).contains(JsonValue.from(mapOf("type" to "text")))
        assertThat(textFormat.jsonSchema()).isEmpty
    }

    @Test
    fun ofTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val textFormat = TextFormat.ofText()

        val roundtrippedTextFormat =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(textFormat),
                jacksonTypeRef<TextFormat>(),
            )

        assertThat(roundtrippedTextFormat).isEqualTo(textFormat)
    }

    @Test
    fun ofJsonSchema() {
        val jsonSchema =
            TextFormat.JsonSchema.builder()
                .schema(
                    TextFormat.JsonSchema.Schema.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .build()

        val textFormat = TextFormat.ofJsonSchema(jsonSchema)

        assertThat(textFormat.text()).isEmpty
        assertThat(textFormat.jsonSchema()).contains(jsonSchema)
    }

    @Test
    fun ofJsonSchemaRoundtrip() {
        val jsonMapper = jsonMapper()
        val textFormat =
            TextFormat.ofJsonSchema(
                TextFormat.JsonSchema.builder()
                    .schema(
                        TextFormat.JsonSchema.Schema.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .build()
            )

        val roundtrippedTextFormat =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(textFormat),
                jacksonTypeRef<TextFormat>(),
            )

        assertThat(roundtrippedTextFormat).isEqualTo(textFormat)
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
        val textFormat = jsonMapper().convertValue(testCase.value, jacksonTypeRef<TextFormat>())

        val e = assertThrows<OpenAIInvalidDataException> { textFormat.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
