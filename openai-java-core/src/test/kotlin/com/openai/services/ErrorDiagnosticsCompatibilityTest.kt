package com.openai.services

import com.fasterxml.jackson.core.JsonParser
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.beta.responses.BetaResponseError
import com.openai.models.responses.ResponseError
import com.openai.models.videos.VideoCreateError
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class ErrorDiagnosticsCompatibilityTest {
    @Test
    fun response() =
        verify(
            ResponseError::class.java,
            { it._additionalProperties() },
            {
                it.toBuilder()
                    .putAdditionalProperty("type", JsonValue.from("legacy"))
                    .putAdditionalProperty("param", JsonValue.from("legacy"))
                    .build()
            },
        )

    @Test
    fun betaResponse() =
        verify(
            BetaResponseError::class.java,
            { it._additionalProperties() },
            {
                it.toBuilder()
                    .putAdditionalProperty("type", JsonValue.from("legacy"))
                    .putAdditionalProperty("param", JsonValue.from("legacy"))
                    .build()
            },
        )

    @Test
    fun video() =
        verify(
            VideoCreateError::class.java,
            { it._additionalProperties() },
            {
                it.toBuilder()
                    .putAdditionalProperty("type", JsonValue.from("legacy"))
                    .putAdditionalProperty("param", JsonValue.from("legacy"))
                    .build()
            },
        )

    private fun <T : Any> verify(
        clazz: Class<T>,
        extras: (T) -> Map<String, JsonValue>,
        stale: (T) -> T,
    ) {
        val mapper = jsonMapper().copy().enable(JsonParser.Feature.STRICT_DUPLICATE_DETECTION)
        for (fields in
            listOf(
                "",
                """, "type":"synthetic", "param":"input[0]"""",
                """, "type":null, "param":null""",
                """, "type":42, "param":{"future":true}""",
            )) {
            val raw = """{"code":"server_error","message":"synthetic","other":true$fields}"""
            val expected = mapper.readTree(raw) as com.fasterxml.jackson.databind.node.ObjectNode
            val error = mapper.readValue(raw, clazz)
            val properties = extras(error)
            assertThat(properties["other"]).isEqualTo(JsonValue.from(true))
            for (key in listOf("type", "param")) {
                assertThat(properties.containsKey(key)).isEqualTo(expected.has(key))
                if (expected.has(key)) {
                    assertThat(mapper.readTree(mapper.writeValueAsString(properties[key])))
                        .isEqualTo(expected.get(key))
                }
            }
            assertThatThrownBy {
                    (properties as MutableMap<String, JsonValue>)["added"] = JsonValue.from(true)
                }
                .isInstanceOf(UnsupportedOperationException::class.java)
            assertThat(mapper.readTree(mapper.writeValueAsString(error))).isEqualTo(expected)
            val withLegacyEntries = stale(error)
            if (fields.isEmpty()) {
                expected.put("type", "legacy")
                expected.put("param", "legacy")
            }
            for (key in listOf("type", "param")) {
                assertThat(
                        mapper.readTree(mapper.writeValueAsString(extras(withLegacyEntries)[key]))
                    )
                    .isEqualTo(expected.get(key))
            }
            assertThat(mapper.readTree(mapper.writeValueAsString(withLegacyEntries)))
                .isEqualTo(expected)
        }
    }
}
