// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.responses.ToolChoiceFunction
import com.openai.models.responses.ToolChoiceMcp
import com.openai.models.responses.ToolChoiceOptions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class RealtimeToolChoiceConfigTest {

    @Test
    fun ofToolChoiceOptions() {
        val toolChoiceOptions = ToolChoiceOptions.NONE

        val realtimeToolChoiceConfig =
            RealtimeToolChoiceConfig.ofToolChoiceOptions(toolChoiceOptions)

        assertThat(realtimeToolChoiceConfig.toolChoiceOptions()).contains(toolChoiceOptions)
        assertThat(realtimeToolChoiceConfig.toolChoiceFunction()).isEmpty
        assertThat(realtimeToolChoiceConfig.toolChoiceMcp()).isEmpty
    }

    @Test
    fun ofToolChoiceOptionsRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeToolChoiceConfig =
            RealtimeToolChoiceConfig.ofToolChoiceOptions(ToolChoiceOptions.NONE)

        val roundtrippedRealtimeToolChoiceConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeToolChoiceConfig),
                jacksonTypeRef<RealtimeToolChoiceConfig>(),
            )

        assertThat(roundtrippedRealtimeToolChoiceConfig).isEqualTo(realtimeToolChoiceConfig)
    }

    @Test
    fun ofToolChoiceFunction() {
        val toolChoiceFunction = ToolChoiceFunction.builder().name("name").build()

        val realtimeToolChoiceConfig =
            RealtimeToolChoiceConfig.ofToolChoiceFunction(toolChoiceFunction)

        assertThat(realtimeToolChoiceConfig.toolChoiceOptions()).isEmpty
        assertThat(realtimeToolChoiceConfig.toolChoiceFunction()).contains(toolChoiceFunction)
        assertThat(realtimeToolChoiceConfig.toolChoiceMcp()).isEmpty
    }

    @Test
    fun ofToolChoiceFunctionRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeToolChoiceConfig =
            RealtimeToolChoiceConfig.ofToolChoiceFunction(
                ToolChoiceFunction.builder().name("name").build()
            )

        val roundtrippedRealtimeToolChoiceConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeToolChoiceConfig),
                jacksonTypeRef<RealtimeToolChoiceConfig>(),
            )

        assertThat(roundtrippedRealtimeToolChoiceConfig).isEqualTo(realtimeToolChoiceConfig)
    }

    @Test
    fun ofToolChoiceMcp() {
        val toolChoiceMcp = ToolChoiceMcp.builder().serverLabel("server_label").name("name").build()

        val realtimeToolChoiceConfig = RealtimeToolChoiceConfig.ofToolChoiceMcp(toolChoiceMcp)

        assertThat(realtimeToolChoiceConfig.toolChoiceOptions()).isEmpty
        assertThat(realtimeToolChoiceConfig.toolChoiceFunction()).isEmpty
        assertThat(realtimeToolChoiceConfig.toolChoiceMcp()).contains(toolChoiceMcp)
    }

    @Test
    fun ofToolChoiceMcpRoundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeToolChoiceConfig =
            RealtimeToolChoiceConfig.ofToolChoiceMcp(
                ToolChoiceMcp.builder().serverLabel("server_label").name("name").build()
            )

        val roundtrippedRealtimeToolChoiceConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeToolChoiceConfig),
                jacksonTypeRef<RealtimeToolChoiceConfig>(),
            )

        assertThat(roundtrippedRealtimeToolChoiceConfig).isEqualTo(realtimeToolChoiceConfig)
    }

    @Test
    fun incompatibleJsonShapeDeserializesToUnknown() {
        val value = JsonValue.from(listOf("invalid", "array"))
        val realtimeToolChoiceConfig =
            jsonMapper().convertValue(value, jacksonTypeRef<RealtimeToolChoiceConfig>())

        val e = assertThrows<OpenAIInvalidDataException> { realtimeToolChoiceConfig.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
