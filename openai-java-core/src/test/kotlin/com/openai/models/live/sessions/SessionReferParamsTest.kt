// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live.sessions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionReferParamsTest {

    @Test
    fun create() {
        SessionReferParams.builder().sessionId("session_id").targetUri("tel:+14155550123").build()
    }

    @Test
    fun pathParams() {
        val params =
            SessionReferParams.builder()
                .sessionId("session_id")
                .targetUri("tel:+14155550123")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("session_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            SessionReferParams.builder()
                .sessionId("session_id")
                .targetUri("tel:+14155550123")
                .build()

        val body = params._body()

        assertThat(body.targetUri()).isEqualTo("tel:+14155550123")
    }
}
