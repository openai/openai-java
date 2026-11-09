package com.openai.models.beta.realtime

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeErrorCompatibilityTest {
    @Test
    fun typedMessageWinsLegacyBuilderCollisionWithoutDuplicateJson() {
        // Reject duplicate keys if the compatibility view leaks into serialization.
        val mapper = jsonMapper().copy().enable(JsonParser.Feature.STRICT_DUPLICATE_DETECTION)
        val json = """{"message":"message","other":true}"""
        val error = mapper.readValue(json, jacksonTypeRef<RealtimeResponseStatus.Error>())

        assertThat(error.message()).contains("message")

        val withLegacyEntry =
            error.toBuilder().putAdditionalProperty("message", JsonValue.from("legacy")).build()

        assertThat(withLegacyEntry.message()).contains("message")
        assertThat(mapper.readTree(mapper.writeValueAsString(withLegacyEntry)))
            .isEqualTo(mapper.readTree(json))
    }
}
