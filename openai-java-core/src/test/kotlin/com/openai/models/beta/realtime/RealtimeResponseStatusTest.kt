package com.openai.models.beta.realtime

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeResponseStatusTest {

    @Test
    fun preservesLegacyErrorMessageLookupWithoutDuplicateJson() {
        // Reject duplicate keys if the compatibility view leaks into serialization.
        val mapper = jsonMapper().copy().enable(JsonParser.Feature.STRICT_DUPLICATE_DETECTION)
        val json = """{"message":"message","other":true}"""
        val error = mapper.readValue(json, jacksonTypeRef<RealtimeResponseStatus.Error>())

        assertThat(error._additionalProperties()["message"]).isEqualTo(JsonValue.from("message"))

        val withLegacyEntry =
            error.toBuilder().putAdditionalProperty("message", JsonValue.from("legacy")).build()

        assertThat(withLegacyEntry._additionalProperties()["message"])
            .isEqualTo(JsonValue.from("message"))
        assertThat(mapper.readTree(mapper.writeValueAsString(withLegacyEntry)))
            .isEqualTo(mapper.readTree(json))
    }

    @Test
    fun create() {
        val realtimeResponseStatus =
            RealtimeResponseStatus.builder()
                .error(RealtimeResponseStatus.Error.builder().code("code").type("type").build())
                .reason(RealtimeResponseStatus.Reason.TURN_DETECTED)
                .type(RealtimeResponseStatus.Type.COMPLETED)
                .build()

        assertThat(realtimeResponseStatus.error())
            .contains(RealtimeResponseStatus.Error.builder().code("code").type("type").build())
        assertThat(realtimeResponseStatus.reason())
            .contains(RealtimeResponseStatus.Reason.TURN_DETECTED)
        assertThat(realtimeResponseStatus.type()).contains(RealtimeResponseStatus.Type.COMPLETED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeResponseStatus =
            RealtimeResponseStatus.builder()
                .error(RealtimeResponseStatus.Error.builder().code("code").type("type").build())
                .reason(RealtimeResponseStatus.Reason.TURN_DETECTED)
                .type(RealtimeResponseStatus.Type.COMPLETED)
                .build()

        val roundtrippedRealtimeResponseStatus =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeResponseStatus),
                jacksonTypeRef<RealtimeResponseStatus>(),
            )

        assertThat(roundtrippedRealtimeResponseStatus).isEqualTo(realtimeResponseStatus)
    }
}
