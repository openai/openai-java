// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

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

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val realtimeTracingConfig =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<RealtimeTracingConfig>())

        val e = assertThrows<OpenAIInvalidDataException> { realtimeTracingConfig.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
