// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live.sessions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionDownloadRecordingParamsTest {

    @Test
    fun create() {
        SessionDownloadRecordingParams.builder().sessionId("live_SQ").build()
    }

    @Test
    fun pathParams() {
        val params = SessionDownloadRecordingParams.builder().sessionId("live_SQ").build()

        assertThat(params._pathParam(0)).isEqualTo("live_SQ")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
