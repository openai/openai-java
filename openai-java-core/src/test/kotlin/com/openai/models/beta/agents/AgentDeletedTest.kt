// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentDeletedTest {

    @Test
    fun createAndRoundtrip() {
        val agentDeleted = AgentDeleted.builder().id("id").deleted(true).build()

        assertThat(agentDeleted.id()).isEqualTo("id")
        assertThat(agentDeleted.deleted()).isEqualTo(true)

        val jsonMapper = jsonMapper()

        val roundtrippedAgentDeleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentDeleted),
                jacksonTypeRef<AgentDeleted>(),
            )

        assertThat(roundtrippedAgentDeleted).isEqualTo(agentDeleted)
    }
}
