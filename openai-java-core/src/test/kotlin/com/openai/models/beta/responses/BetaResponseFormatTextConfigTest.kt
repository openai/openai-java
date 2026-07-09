// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class BetaResponseFormatTextConfigTest {

    @Test
    fun ofText() {
        val betaResponseFormatTextConfig = BetaResponseFormatTextConfig.ofText()

        assertThat(betaResponseFormatTextConfig.text())
            .contains(JsonValue.from(mapOf("type" to "text")))
        assertThat(betaResponseFormatTextConfig.jsonSchema()).isEmpty
        assertThat(betaResponseFormatTextConfig.jsonObject()).isEmpty
    }

    @Test
    fun ofTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseFormatTextConfig = BetaResponseFormatTextConfig.ofText()

        val roundtrippedBetaResponseFormatTextConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseFormatTextConfig),
                jacksonTypeRef<BetaResponseFormatTextConfig>(),
            )

        assertThat(roundtrippedBetaResponseFormatTextConfig).isEqualTo(betaResponseFormatTextConfig)
    }

    @Test
    fun ofJsonSchema() {
        val jsonSchema =
            BetaResponseFormatTextJsonSchemaConfig.builder()
                .name("name")
                .schema(
                    BetaResponseFormatTextJsonSchemaConfig.Schema.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .description("description")
                .strict(true)
                .build()

        val betaResponseFormatTextConfig = BetaResponseFormatTextConfig.ofJsonSchema(jsonSchema)

        assertThat(betaResponseFormatTextConfig.text()).isEmpty
        assertThat(betaResponseFormatTextConfig.jsonSchema()).contains(jsonSchema)
        assertThat(betaResponseFormatTextConfig.jsonObject()).isEmpty
    }

    @Test
    fun ofJsonSchemaRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseFormatTextConfig =
            BetaResponseFormatTextConfig.ofJsonSchema(
                BetaResponseFormatTextJsonSchemaConfig.builder()
                    .name("name")
                    .schema(
                        BetaResponseFormatTextJsonSchemaConfig.Schema.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .description("description")
                    .strict(true)
                    .build()
            )

        val roundtrippedBetaResponseFormatTextConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseFormatTextConfig),
                jacksonTypeRef<BetaResponseFormatTextConfig>(),
            )

        assertThat(roundtrippedBetaResponseFormatTextConfig).isEqualTo(betaResponseFormatTextConfig)
    }

    @Test
    fun ofJsonObject() {
        val betaResponseFormatTextConfig = BetaResponseFormatTextConfig.ofJsonObject()

        assertThat(betaResponseFormatTextConfig.text()).isEmpty
        assertThat(betaResponseFormatTextConfig.jsonSchema()).isEmpty
        assertThat(betaResponseFormatTextConfig.jsonObject())
            .contains(JsonValue.from(mapOf("type" to "json_object")))
    }

    @Test
    fun ofJsonObjectRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaResponseFormatTextConfig = BetaResponseFormatTextConfig.ofJsonObject()

        val roundtrippedBetaResponseFormatTextConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaResponseFormatTextConfig),
                jacksonTypeRef<BetaResponseFormatTextConfig>(),
            )

        assertThat(roundtrippedBetaResponseFormatTextConfig).isEqualTo(betaResponseFormatTextConfig)
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
        val betaResponseFormatTextConfig =
            jsonMapper()
                .convertValue(testCase.value, jacksonTypeRef<BetaResponseFormatTextConfig>())

        val e = assertThrows<OpenAIInvalidDataException> { betaResponseFormatTextConfig.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
