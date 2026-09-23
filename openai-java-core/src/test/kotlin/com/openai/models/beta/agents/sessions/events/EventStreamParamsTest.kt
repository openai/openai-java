// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.sessions.events

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EventStreamParamsTest {

    @Test
    fun create() {
        EventStreamParams.builder().sessionId("session_id").build()
    }

    @Test
    fun pathParams() {
        val params = EventStreamParams.builder().sessionId("session_id").build()

        assertThat(params._pathParam(0)).isEqualTo("session_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
