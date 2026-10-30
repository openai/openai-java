package com.openai.core

import com.fasterxml.jackson.databind.JsonNode
import com.openai.models.beta.responses.BetaResponseConfigurationUpdateItem
import com.openai.models.beta.responses.BetaResponseConfigurationUpdateItemParam
import com.openai.models.responses.ResponseConfigurationUpdateItem
import com.openai.models.responses.ResponseConfigurationUpdateItemParam
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class ResponseConfigurationUpdateFormatTest {
    @ParameterizedTest
    @ValueSource(
        strings =
            [
                """{"type":"text"}""",
                """{"type":"json_schema","name":"answer","schema":{"type":"object"}}""",
                """{"type":"future_format","name":"answer","schema":{},"extra":[1,true]}""",
            ]
    )
    fun dispatchesByTypeAndPreservesUnknownFormats(json: String) {
        val mapper = jsonMapper()
        val expected = mapper.readTree(json)
        val type = expected["type"].asText()

        fun checkFormat(format: Any, isText: Boolean, isJsonSchema: Boolean) {
            assertThat(isText).isEqualTo(type == "text")
            assertThat(isJsonSchema).isEqualTo(type == "json_schema")
            assertThat(mapper.valueToTree<JsonNode>(format)).isEqualTo(expected)
        }

        mapper.readValue(json, ResponseConfigurationUpdateItem.Text.Format::class.java).run {
            checkFormat(this, isText(), isJsonSchema())
        }
        mapper.readValue(json, ResponseConfigurationUpdateItemParam.Text.Format::class.java).run {
            checkFormat(this, isText(), isJsonSchema())
        }
        mapper.readValue(json, BetaResponseConfigurationUpdateItem.Text.Format::class.java).run {
            checkFormat(this, isText(), isJsonSchema())
        }
        mapper
            .readValue(json, BetaResponseConfigurationUpdateItemParam.Text.Format::class.java)
            .run { checkFormat(this, isText(), isJsonSchema()) }
    }
}
