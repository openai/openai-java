// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.openai.core.JsonValue
import com.openai.models.ResponseFormatJsonObject
import com.openai.models.ResponseFormatText
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

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
    fun ofJsonSchema() {
        val jsonSchema =
            ResponseFormatTextJsonSchemaConfig.builder()
                .schema(
                    ResponseFormatTextJsonSchemaConfig.Schema.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .build()

        val responseFormatTextConfig = ResponseFormatTextConfig.ofJsonSchema(jsonSchema)

        assertThat(responseFormatTextConfig.text()).isEmpty
        assertThat(responseFormatTextConfig.jsonSchema()).contains(jsonSchema)
        assertThat(responseFormatTextConfig.jsonObject()).isEmpty
    }

    @Test
    fun ofJsonObject() {
        val jsonObject = ResponseFormatJsonObject.builder().build()

        val responseFormatTextConfig = ResponseFormatTextConfig.ofJsonObject(jsonObject)

        assertThat(responseFormatTextConfig.text()).isEmpty
        assertThat(responseFormatTextConfig.jsonSchema()).isEmpty
        assertThat(responseFormatTextConfig.jsonObject()).contains(jsonObject)
    }
}
