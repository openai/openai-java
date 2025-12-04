// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCompactParamsTest {

    @Test
    fun create() {
        ResponseCompactParams.builder()
            .input("string")
            .instructions("instructions")
            .model(ResponseCompactParams.Model.GPT_5_1)
            .previousResponseId("resp_123")
            .build()
    }

    @Test
    fun body() {
        val params =
            ResponseCompactParams.builder()
                .input("string")
                .instructions("instructions")
                .model(ResponseCompactParams.Model.GPT_5_1)
                .previousResponseId("resp_123")
                .build()

        val body = params._body()

        assertThat(body.input()).contains(ResponseCompactParams.Input.ofString("string"))
        assertThat(body.instructions()).contains("instructions")
        assertThat(body.model()).contains(ResponseCompactParams.Model.GPT_5_1)
        assertThat(body.previousResponseId()).contains("resp_123")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ResponseCompactParams.builder().build()

        val body = params._body()
    }
}
