// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime.calls

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CallRejectParamsTest {

    @Test
    fun create() {
        CallRejectParams.builder().callId("call_id").statusCode(486L).build()
    }

    @Test
    fun pathParams() {
        val params = CallRejectParams.builder().callId("call_id").build()

        assertThat(params._pathParam(0)).isEqualTo("call_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params = CallRejectParams.builder().callId("call_id").statusCode(486L).build()

        val body = params._body()

        assertThat(body.statusCode()).contains(486L)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = CallRejectParams.builder().callId("call_id").build()

        val body = params._body()
    }
}
