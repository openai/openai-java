// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.sessions.events

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EventStreamParamsTest {

    @Test
    fun create() {
        EventStreamParams.builder().sessionId("session_id").includeObfuscation(true).build()
    }

    @Test
    fun pathParams() {
        val params = EventStreamParams.builder().sessionId("session_id").build()

        assertThat(params._pathParam(0)).isEqualTo("session_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            EventStreamParams.builder().sessionId("session_id").includeObfuscation(true).build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("include_obfuscation", "true").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = EventStreamParams.builder().sessionId("session_id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
