// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionDeletedTest {

    @Test
    fun createAndRoundtrip() {
        val agentSessionDeleted = AgentSessionDeleted.builder().id("id").deleted(true).build()

        assertThat(agentSessionDeleted.id()).contains("id")
        assertThat(agentSessionDeleted.deleted()).contains(true)

        val jsonMapper = jsonMapper()

        val roundtrippedAgentSessionDeleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentSessionDeleted),
                jacksonTypeRef<AgentSessionDeleted>(),
            )

        assertThat(roundtrippedAgentSessionDeleted).isEqualTo(agentSessionDeleted)
    }
}
