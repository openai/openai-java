// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFormatJsonObjectTest {

    @Test
    fun create() {
        val responseFormatJsonObject = ResponseFormatJsonObject.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseFormatJsonObject = ResponseFormatJsonObject.builder().build()

        val roundtrippedResponseFormatJsonObject =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFormatJsonObject),
                jacksonTypeRef<ResponseFormatJsonObject>(),
            )

        assertThat(roundtrippedResponseFormatJsonObject).isEqualTo(responseFormatJsonObject)
    }
}
