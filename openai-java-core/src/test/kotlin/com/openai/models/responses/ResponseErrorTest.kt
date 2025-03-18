// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseErrorTest {

    @Test
    fun create() {
        val responseError =
            ResponseError.builder().code(ResponseError.Code.SERVER_ERROR).message("message").build()

        assertThat(responseError.code()).isEqualTo(ResponseError.Code.SERVER_ERROR)
        assertThat(responseError.message()).isEqualTo("message")
    }
}
