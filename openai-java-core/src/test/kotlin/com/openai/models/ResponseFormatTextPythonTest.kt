// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFormatTextPythonTest {

    @Test
    fun create() {
        val responseFormatTextPython = ResponseFormatTextPython.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseFormatTextPython = ResponseFormatTextPython.builder().build()

        val roundtrippedResponseFormatTextPython =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFormatTextPython),
                jacksonTypeRef<ResponseFormatTextPython>(),
            )

        assertThat(roundtrippedResponseFormatTextPython).isEqualTo(responseFormatTextPython)
    }
}
