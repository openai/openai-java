// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live.sessions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionRejectParamsTest {

    @Test
    fun create() {
        SessionRejectParams.builder().sessionId("session_id").statusCode(486L).build()
    }

    @Test
    fun pathParams() {
        val params = SessionRejectParams.builder().sessionId("session_id").statusCode(486L).build()

        assertThat(params._pathParam(0)).isEqualTo("session_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params = SessionRejectParams.builder().sessionId("session_id").statusCode(486L).build()

        val body = params._body()

        assertThat(body.statusCode()).isEqualTo(486L)
    }
}
