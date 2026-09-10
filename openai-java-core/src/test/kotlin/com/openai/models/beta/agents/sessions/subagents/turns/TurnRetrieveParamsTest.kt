// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.sessions.subagents.turns

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TurnRetrieveParamsTest {

    @Test
    fun create() {
        TurnRetrieveParams.builder()
            .sessionId("session_id")
            .subagentId("subagent_id")
            .turnId("turn_id")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            TurnRetrieveParams.builder()
                .sessionId("session_id")
                .subagentId("subagent_id")
                .turnId("turn_id")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("session_id")
        assertThat(params._pathParam(1)).isEqualTo("subagent_id")
        assertThat(params._pathParam(2)).isEqualTo("turn_id")
        // out-of-bound path param
        assertThat(params._pathParam(3)).isEqualTo("")
    }
}
