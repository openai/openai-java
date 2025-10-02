// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime.calls

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CallReferParamsTest {

    @Test
    fun create() {
        CallReferParams.builder().callId("call_id").targetUri("tel:+14155550123").build()
    }

    @Test
    fun pathParams() {
        val params =
            CallReferParams.builder().callId("call_id").targetUri("tel:+14155550123").build()

        assertThat(params._pathParam(0)).isEqualTo("call_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            CallReferParams.builder().callId("call_id").targetUri("tel:+14155550123").build()

        val body = params._body()

        assertThat(body.targetUri()).isEqualTo("tel:+14155550123")
    }
}
