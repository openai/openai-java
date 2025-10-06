// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit.sessions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionCancelParamsTest {

    @Test
    fun create() {
        SessionCancelParams.builder().sessionId("cksess_123").build()
    }

    @Test
    fun pathParams() {
        val params = SessionCancelParams.builder().sessionId("cksess_123").build()

        assertThat(params._pathParam(0)).isEqualTo("cksess_123")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
