// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BetaThreadRunUpdateParamsTest {

    @Test
    fun createBetaThreadRunUpdateParams() {
        BetaThreadRunUpdateParams.builder()
            .threadId("thread_id")
            .runId("run_id")
            .metadata(JsonValue.from(mapOf<String, Any>()))
            .build()
    }

    @Test
    fun getBody() {
        val params =
            BetaThreadRunUpdateParams.builder()
                .threadId("thread_id")
                .runId("run_id")
                .metadata(JsonValue.from(mapOf<String, Any>()))
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.metadata()).contains(JsonValue.from(mapOf<String, Any>()))
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            BetaThreadRunUpdateParams.builder().threadId("thread_id").runId("run_id").build()
        val body = params.getBody()
        assertThat(body).isNotNull
    }

    @Test
    fun getPathParam() {
        val params =
            BetaThreadRunUpdateParams.builder().threadId("thread_id").runId("run_id").build()
        assertThat(params).isNotNull
        // path param "threadId"
        assertThat(params.getPathParam(0)).isEqualTo("thread_id")
        // path param "runId"
        assertThat(params.getPathParam(1)).isEqualTo("run_id")
        // out-of-bound path param
        assertThat(params.getPathParam(2)).isEqualTo("")
    }
}
