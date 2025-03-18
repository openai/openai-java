// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ErrorObjectTest {

    @Test
    fun create() {
        val errorObject =
            ErrorObject.builder()
                .code("code")
                .message("message")
                .param("param")
                .type("type")
                .build()

        assertThat(errorObject.code()).contains("code")
        assertThat(errorObject.message()).isEqualTo("message")
        assertThat(errorObject.param()).contains("param")
        assertThat(errorObject.type()).isEqualTo("type")
    }
}
