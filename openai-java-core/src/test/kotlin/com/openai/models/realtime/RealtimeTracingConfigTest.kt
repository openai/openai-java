// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class RealtimeTracingConfigTest {

    @Test
    fun ofAuto() {
        val realtimeTracingConfig = RealtimeTracingConfig.ofAuto()

        assertThat(realtimeTracingConfig.auto()).contains(JsonValue.from("auto"))
        assertThat(realtimeTracingConfig.tracingConfiguration()).isEmpty
    }

    @Test
    fun ofAutoRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTracingConfig = RealtimeTracingConfig.ofAuto()

        val roundtrippedRealtimeTracingConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTracingConfig),
                jacksonTypeRef<RealtimeTracingConfig>(),
            )

        assertThat(roundtrippedRealtimeTracingConfig).isEqualTo(realtimeTracingConfig)
    }

    @Test
    fun ofTracingConfiguration() {
        val tracingConfiguration =
            RealtimeTracingConfig.TracingConfiguration.builder()
                .groupId("group_id")
                .metadata(JsonValue.from(mapOf<String, Any>()))
                .workflowName("workflow_name")
                .build()

        val realtimeTracingConfig =
            RealtimeTracingConfig.ofTracingConfiguration(tracingConfiguration)

        assertThat(realtimeTracingConfig.auto()).isEmpty
        assertThat(realtimeTracingConfig.tracingConfiguration()).contains(tracingConfiguration)
    }

    @Test
    fun ofTracingConfigurationRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeTracingConfig =
            RealtimeTracingConfig.ofTracingConfiguration(
                RealtimeTracingConfig.TracingConfiguration.builder()
                    .groupId("group_id")
                    .metadata(JsonValue.from(mapOf<String, Any>()))
                    .workflowName("workflow_name")
                    .build()
            )

        val roundtrippedRealtimeTracingConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeTracingConfig),
                jacksonTypeRef<RealtimeTracingConfig>(),
            )

        assertThat(roundtrippedRealtimeTracingConfig).isEqualTo(realtimeTracingConfig)
    }

    @Test
    fun incompatibleJsonShapeDeserializesToUnknown() {
        val value = JsonValue.from(listOf("invalid", "array"))
        val realtimeTracingConfig =
            jsonMapper().convertValue(value, jacksonTypeRef<RealtimeTracingConfig>())

        val e = assertThrows<OpenAIInvalidDataException> { realtimeTracingConfig.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
