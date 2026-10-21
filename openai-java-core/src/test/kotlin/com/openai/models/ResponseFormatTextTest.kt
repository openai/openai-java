// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFormatTextTest {

    @Test
    fun createAndRoundtrip() {
        val responseFormatText = ResponseFormatText.builder().build()

        val jsonMapper = jsonMapper()

        val roundtrippedResponseFormatText =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFormatText),
                jacksonTypeRef<ResponseFormatText>(),
            )

        assertThat(roundtrippedResponseFormatText).isEqualTo(responseFormatText)
    }
}
