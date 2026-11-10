package com.openai.models.beta.realtime

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class RealtimeErrorCompatibilityTest {
    @Test
    fun completeViewPreservesDeclaredMessageWithoutDuplicateJson() {
        // Reject duplicate keys if the complete view leaks into serialization.
        val mapper = jsonMapper().copy().enable(JsonParser.Feature.STRICT_DUPLICATE_DETECTION)
        val json = """{"message":"message","other":true}"""
        val error = mapper.readValue(json, jacksonTypeRef<RealtimeResponseStatus.Error>())

        assertThat(error._allProperties()["message"]).isEqualTo(JsonValue.from("message"))

        val withLegacyEntry =
            error.toBuilder().putAdditionalProperty("message", JsonValue.from("legacy")).build()

        assertThat(withLegacyEntry._allProperties()["message"]).isEqualTo(JsonValue.from("message"))
        assertThat(mapper.readTree(mapper.writeValueAsString(withLegacyEntry)))
            .isEqualTo(mapper.readTree(json))
    }

    @Test
    fun readsNestedRawPropertiesAndOmitsMissingKeys() {
        val mapper = jsonMapper().copy().enable(JsonParser.Feature.STRICT_DUPLICATE_DETECTION)
        val json = """{"error":{"type":"future","message":{"raw":1},"code":null,"extra":true}}"""
        val status = mapper.readValue(json, RealtimeResponseStatus::class.java)
        val error = status.error().get()
        val type: JsonValue? = error._allProperties()["type"]
        assertThat(type).isEqualTo(JsonValue.from("future"))
        assertThat(error._allProperties())
            .containsEntry("message", JsonValue.from(mapOf("raw" to 1)))
            .containsEntry("code", JsonValue.from(null))
            .containsEntry("extra", JsonValue.from(true))
        assertThat(status._allProperties().keys).containsExactly("error")
        assertThatThrownBy {
                (error._allProperties() as MutableMap<String, JsonValue>).remove("message")
            }
            .isInstanceOf(UnsupportedOperationException::class.java)
        assertThat(mapper.readTree(mapper.writeValueAsString(status)))
            .isEqualTo(mapper.readTree(json))
    }
}
