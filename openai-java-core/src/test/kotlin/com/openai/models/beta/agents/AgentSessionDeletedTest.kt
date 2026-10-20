// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionDeletedTest {

    @Test
    fun create() {
        val agentSessionDeleted = AgentSessionDeleted.builder().id("id").deleted(true).build()

        assertThat(agentSessionDeleted.id()).isEqualTo("id")
        assertThat(agentSessionDeleted.deleted()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentSessionDeleted = AgentSessionDeleted.builder().id("id").deleted(true).build()

        val roundtrippedAgentSessionDeleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionDeleted),
                jacksonTypeRef<AgentSessionDeleted>(),
            )

        assertThat(roundtrippedAgentSessionDeleted).isEqualTo(agentSessionDeleted)
    }
}
