// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.sessions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionDeleteParamsTest {

    @Test
    fun create() {
        SessionDeleteParams.builder().sessionId("session_id").build()
    }

    @Test
    fun pathParams() {
        val params = SessionDeleteParams.builder().sessionId("session_id").build()

        assertThat(params._pathParam(0)).isEqualTo("session_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
