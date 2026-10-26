// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class HostedPluginParamTest {

    @Test
    fun createAndRoundtrip() {
        val hostedPluginParam =
            HostedPluginParam.builder()
                .description("description")
                .name("x")
                .source(InlineCapabilitySourceParam.builder().data("x").build())
                .build()

        assertThat(hostedPluginParam.description()).isEqualTo("description")
        assertThat(hostedPluginParam.name()).isEqualTo("x")
        assertThat(hostedPluginParam.source())
            .isEqualTo(InlineCapabilitySourceParam.builder().data("x").build())

        val jsonMapper = jsonMapper()

        val roundtrippedHostedPluginParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(hostedPluginParam),
                jacksonTypeRef<HostedPluginParam>(),
            )

        assertThat(roundtrippedHostedPluginParam).isEqualTo(hostedPluginParam)
    }
}
