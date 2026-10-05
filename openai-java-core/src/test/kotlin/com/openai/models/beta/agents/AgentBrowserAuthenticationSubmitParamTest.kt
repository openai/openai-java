// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentBrowserAuthenticationSubmitParamTest {

    @Test
    fun create() {
        val agentBrowserAuthenticationSubmitParam =
            AgentBrowserAuthenticationSubmitParam.builder()
                .addField(
                    AgentBrowserAuthenticationSubmitParam.Field.builder()
                        .fieldId("field_id")
                        .value("value")
                        .build()
                )
                .selectedOption("selected_option")
                .build()

        assertThat(agentBrowserAuthenticationSubmitParam.fields())
            .containsExactly(
                AgentBrowserAuthenticationSubmitParam.Field.builder()
                    .fieldId("field_id")
                    .value("value")
                    .build()
            )
        assertThat(agentBrowserAuthenticationSubmitParam.selectedOption())
            .contains("selected_option")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentBrowserAuthenticationSubmitParam =
            AgentBrowserAuthenticationSubmitParam.builder()
                .addField(
                    AgentBrowserAuthenticationSubmitParam.Field.builder()
                        .fieldId("field_id")
                        .value("value")
                        .build()
                )
                .selectedOption("selected_option")
                .build()

        val roundtrippedAgentBrowserAuthenticationSubmitParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentBrowserAuthenticationSubmitParam),
                jacksonTypeRef<AgentBrowserAuthenticationSubmitParam>(),
            )

        assertThat(roundtrippedAgentBrowserAuthenticationSubmitParam)
            .isEqualTo(agentBrowserAuthenticationSubmitParam)
    }
}
