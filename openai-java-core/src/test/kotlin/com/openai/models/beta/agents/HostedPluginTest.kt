// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class HostedPluginTest {

    @Test
    fun createAndRoundtrip() {
        val hostedPlugin = HostedPlugin.builder().description("description").name("name").build()

        assertThat(hostedPlugin.description()).contains("description")
        assertThat(hostedPlugin.name()).contains("name")

        val jsonMapper = jsonMapper()

        val roundtrippedHostedPlugin =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(hostedPlugin),
                jacksonTypeRef<HostedPlugin>(),
            )

        assertThat(roundtrippedHostedPlugin).isEqualTo(hostedPlugin)
    }
}
