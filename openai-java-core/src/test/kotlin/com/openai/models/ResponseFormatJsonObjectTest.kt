// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFormatJsonObjectTest {

    @Test
    fun createAndRoundtrip() {
        val responseFormatJsonObject = ResponseFormatJsonObject.builder().build()

        val jsonMapper = jsonMapper()

        val roundtrippedResponseFormatJsonObject =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFormatJsonObject),
                jacksonTypeRef<ResponseFormatJsonObject>(),
            )

        assertThat(roundtrippedResponseFormatJsonObject).isEqualTo(responseFormatJsonObject)
    }
}
