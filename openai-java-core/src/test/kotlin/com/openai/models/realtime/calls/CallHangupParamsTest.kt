// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime.calls

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CallHangupParamsTest {

    @Test
    fun create() {
        CallHangupParams.builder().callId("call_id").build()
    }

    @Test
    fun pathParams() {
        val params = CallHangupParams.builder().callId("call_id").build()

        assertThat(params._pathParam(0)).isEqualTo("call_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
