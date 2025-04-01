// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.ResponseFormatJsonObject
import com.openai.models.ResponseFormatText
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ResponseFormatTextConfigTest {

    @Test
    fun ofText() {
        val text = ResponseFormatText.builder().build()

        val responseFormatTextConfig = ResponseFormatTextConfig.ofText(text)

        assertThat(responseFormatTextConfig.text()).contains(text)
        assertThat(responseFormatTextConfig.jsonSchema()).isEmpty
        assertThat(responseFormatTextConfig.jsonObject()).isEmpty
    }

    @Test
    fun ofTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseFormatTextConfig =
            ResponseFormatTextConfig.ofText(ResponseFormatText.builder().build())

        val roundtrippedResponseFormatTextConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFormatTextConfig),
                jacksonTypeRef<ResponseFormatTextConfig>(),
            )

        assertThat(roundtrippedResponseFormatTextConfig).isEqualTo(responseFormatTextConfig)
    }

    @Test
    fun ofJsonSchema() {
        val jsonSchema =
            ResponseFormatTextJsonSchemaConfig.builder()
                .name("name")
                .schema(
                    ResponseFormatTextJsonSchemaConfig.Schema.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .description("description")
                .strict(true)
                .build()

        val responseFormatTextConfig = ResponseFormatTextConfig.ofJsonSchema(jsonSchema)

        assertThat(responseFormatTextConfig.text()).isEmpty
        assertThat(responseFormatTextConfig.jsonSchema()).contains(jsonSchema)
        assertThat(responseFormatTextConfig.jsonObject()).isEmpty
    }

    @Test
    fun ofJsonSchemaRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseFormatTextConfig =
            ResponseFormatTextConfig.ofJsonSchema(
                ResponseFormatTextJsonSchemaConfig.builder()
                    .name("name")
                    .schema(
                        ResponseFormatTextJsonSchemaConfig.Schema.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .description("description")
                    .strict(true)
                    .build()
            )

        val roundtrippedResponseFormatTextConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFormatTextConfig),
                jacksonTypeRef<ResponseFormatTextConfig>(),
            )

        assertThat(roundtrippedResponseFormatTextConfig).isEqualTo(responseFormatTextConfig)
    }

    @Test
    fun ofJsonObject() {
        val jsonObject = ResponseFormatJsonObject.builder().build()

        val responseFormatTextConfig = ResponseFormatTextConfig.ofJsonObject(jsonObject)

        assertThat(responseFormatTextConfig.text()).isEmpty
        assertThat(responseFormatTextConfig.jsonSchema()).isEmpty
        assertThat(responseFormatTextConfig.jsonObject()).contains(jsonObject)
    }

    @Test
    fun ofJsonObjectRoundtrip() {
        val jsonMapper = jsonMapper()
        val responseFormatTextConfig =
            ResponseFormatTextConfig.ofJsonObject(ResponseFormatJsonObject.builder().build())

        val roundtrippedResponseFormatTextConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFormatTextConfig),
                jacksonTypeRef<ResponseFormatTextConfig>(),
            )

        assertThat(roundtrippedResponseFormatTextConfig).isEqualTo(responseFormatTextConfig)
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
        val responseFormatTextConfig =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<ResponseFormatTextConfig>())

        val e = assertThrows<OpenAIInvalidDataException> { responseFormatTextConfig.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
