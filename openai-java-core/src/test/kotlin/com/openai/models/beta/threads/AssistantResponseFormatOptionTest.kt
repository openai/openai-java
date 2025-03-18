// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads

import com.openai.core.JsonValue
import com.openai.models.ResponseFormatJsonObject
import com.openai.models.ResponseFormatJsonSchema
import com.openai.models.ResponseFormatText
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AssistantResponseFormatOptionTest {

    @Test
    fun ofJsonValue() {
        val assistantResponseFormatOption = AssistantResponseFormatOption.ofJsonValue()

        assertThat(assistantResponseFormatOption.jsonValue()).contains(JsonValue.from("auto"))
        assertThat(assistantResponseFormatOption.responseFormatText()).isEmpty
        assertThat(assistantResponseFormatOption.responseFormatJsonObject()).isEmpty
        assertThat(assistantResponseFormatOption.responseFormatJsonSchema()).isEmpty
    }

    @Test
    fun ofResponseFormatText() {
        val responseFormatText = ResponseFormatText.builder().build()

        val assistantResponseFormatOption =
            AssistantResponseFormatOption.ofResponseFormatText(responseFormatText)

        assertThat(assistantResponseFormatOption.jsonValue()).isEmpty
        assertThat(assistantResponseFormatOption.responseFormatText()).contains(responseFormatText)
        assertThat(assistantResponseFormatOption.responseFormatJsonObject()).isEmpty
        assertThat(assistantResponseFormatOption.responseFormatJsonSchema()).isEmpty
    }

    @Test
    fun ofResponseFormatJsonObject() {
        val responseFormatJsonObject = ResponseFormatJsonObject.builder().build()

        val assistantResponseFormatOption =
            AssistantResponseFormatOption.ofResponseFormatJsonObject(responseFormatJsonObject)

        assertThat(assistantResponseFormatOption.jsonValue()).isEmpty
        assertThat(assistantResponseFormatOption.responseFormatText()).isEmpty
        assertThat(assistantResponseFormatOption.responseFormatJsonObject())
            .contains(responseFormatJsonObject)
        assertThat(assistantResponseFormatOption.responseFormatJsonSchema()).isEmpty
    }

    @Test
    fun ofResponseFormatJsonSchema() {
        val responseFormatJsonSchema =
            ResponseFormatJsonSchema.builder()
                .jsonSchema(ResponseFormatJsonSchema.JsonSchema.builder().name("name").build())
                .build()

        val assistantResponseFormatOption =
            AssistantResponseFormatOption.ofResponseFormatJsonSchema(responseFormatJsonSchema)

        assertThat(assistantResponseFormatOption.jsonValue()).isEmpty
        assertThat(assistantResponseFormatOption.responseFormatText()).isEmpty
        assertThat(assistantResponseFormatOption.responseFormatJsonObject()).isEmpty
        assertThat(assistantResponseFormatOption.responseFormatJsonSchema())
            .contains(responseFormatJsonSchema)
    }
}
