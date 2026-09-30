// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class HostedPluginTest {

    @Test
    fun create() {
        val hostedPlugin = HostedPlugin.builder().description("description").name("name").build()

        assertThat(hostedPlugin.description()).isEqualTo("description")
        assertThat(hostedPlugin.name()).isEqualTo("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val hostedPlugin = HostedPlugin.builder().description("description").name("name").build()

        val roundtrippedHostedPlugin =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(hostedPlugin),
                jacksonTypeRef<HostedPlugin>(),
            )

        assertThat(roundtrippedHostedPlugin).isEqualTo(hostedPlugin)
    }
}
