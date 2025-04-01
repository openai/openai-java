// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.ResponseFormatJsonObject
import com.openai.models.ResponseFormatJsonSchema
import com.openai.models.ResponseFormatText
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class AssistantResponseFormatOptionTest {

    @Test
    fun ofAuto() {
        val assistantResponseFormatOption = AssistantResponseFormatOption.ofAuto()

        assertThat(assistantResponseFormatOption.auto()).contains(JsonValue.from("auto"))
        assertThat(assistantResponseFormatOption.responseFormatText()).isEmpty
        assertThat(assistantResponseFormatOption.responseFormatJsonObject()).isEmpty
        assertThat(assistantResponseFormatOption.responseFormatJsonSchema()).isEmpty
    }

    @Test
    fun ofAutoRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantResponseFormatOption = AssistantResponseFormatOption.ofAuto()

        val roundtrippedAssistantResponseFormatOption =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantResponseFormatOption),
                jacksonTypeRef<AssistantResponseFormatOption>(),
            )

        assertThat(roundtrippedAssistantResponseFormatOption)
            .isEqualTo(assistantResponseFormatOption)
    }

    @Test
    fun ofResponseFormatText() {
        val responseFormatText = ResponseFormatText.builder().build()

        val assistantResponseFormatOption =
            AssistantResponseFormatOption.ofResponseFormatText(responseFormatText)

        assertThat(assistantResponseFormatOption.auto()).isEmpty
        assertThat(assistantResponseFormatOption.responseFormatText()).contains(responseFormatText)
        assertThat(assistantResponseFormatOption.responseFormatJsonObject()).isEmpty
        assertThat(assistantResponseFormatOption.responseFormatJsonSchema()).isEmpty
    }

    @Test
    fun ofResponseFormatTextRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantResponseFormatOption =
            AssistantResponseFormatOption.ofResponseFormatText(ResponseFormatText.builder().build())

        val roundtrippedAssistantResponseFormatOption =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantResponseFormatOption),
                jacksonTypeRef<AssistantResponseFormatOption>(),
            )

        assertThat(roundtrippedAssistantResponseFormatOption)
            .isEqualTo(assistantResponseFormatOption)
    }

    @Test
    fun ofResponseFormatJsonObject() {
        val responseFormatJsonObject = ResponseFormatJsonObject.builder().build()

        val assistantResponseFormatOption =
            AssistantResponseFormatOption.ofResponseFormatJsonObject(responseFormatJsonObject)

        assertThat(assistantResponseFormatOption.auto()).isEmpty
        assertThat(assistantResponseFormatOption.responseFormatText()).isEmpty
        assertThat(assistantResponseFormatOption.responseFormatJsonObject())
            .contains(responseFormatJsonObject)
        assertThat(assistantResponseFormatOption.responseFormatJsonSchema()).isEmpty
    }

    @Test
    fun ofResponseFormatJsonObjectRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantResponseFormatOption =
            AssistantResponseFormatOption.ofResponseFormatJsonObject(
                ResponseFormatJsonObject.builder().build()
            )

        val roundtrippedAssistantResponseFormatOption =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantResponseFormatOption),
                jacksonTypeRef<AssistantResponseFormatOption>(),
            )

        assertThat(roundtrippedAssistantResponseFormatOption)
            .isEqualTo(assistantResponseFormatOption)
    }

    @Test
    fun ofResponseFormatJsonSchema() {
        val responseFormatJsonSchema =
            ResponseFormatJsonSchema.builder()
                .jsonSchema(
                    ResponseFormatJsonSchema.JsonSchema.builder()
                        .name("name")
                        .description("description")
                        .schema(
                            ResponseFormatJsonSchema.JsonSchema.Schema.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .strict(true)
                        .build()
                )
                .build()

        val assistantResponseFormatOption =
            AssistantResponseFormatOption.ofResponseFormatJsonSchema(responseFormatJsonSchema)

        assertThat(assistantResponseFormatOption.auto()).isEmpty
        assertThat(assistantResponseFormatOption.responseFormatText()).isEmpty
        assertThat(assistantResponseFormatOption.responseFormatJsonObject()).isEmpty
        assertThat(assistantResponseFormatOption.responseFormatJsonSchema())
            .contains(responseFormatJsonSchema)
    }

    @Test
    fun ofResponseFormatJsonSchemaRoundtrip() {
        val jsonMapper = jsonMapper()
        val assistantResponseFormatOption =
            AssistantResponseFormatOption.ofResponseFormatJsonSchema(
                ResponseFormatJsonSchema.builder()
                    .jsonSchema(
                        ResponseFormatJsonSchema.JsonSchema.builder()
                            .name("name")
                            .description("description")
                            .schema(
                                ResponseFormatJsonSchema.JsonSchema.Schema.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .strict(true)
                            .build()
                    )
                    .build()
            )

        val roundtrippedAssistantResponseFormatOption =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(assistantResponseFormatOption),
                jacksonTypeRef<AssistantResponseFormatOption>(),
            )

        assertThat(roundtrippedAssistantResponseFormatOption)
            .isEqualTo(assistantResponseFormatOption)
    }

    @Test
    fun incompatibleJsonShapeDeserializesToUnknown() {
        val value = JsonValue.from(listOf("invalid", "array"))
        val assistantResponseFormatOption =
            jsonMapper().convertValue(value, jacksonTypeRef<AssistantResponseFormatOption>())

        val e =
            assertThrows<OpenAIInvalidDataException> { assistantResponseFormatOption.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
