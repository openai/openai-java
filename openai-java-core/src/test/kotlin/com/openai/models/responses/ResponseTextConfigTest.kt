// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.ResponseFormatText
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseTextConfigTest {

    @Test
    fun create() {
        val responseTextConfig =
            ResponseTextConfig.builder().format(ResponseFormatText.builder().build()).build()

        assertThat(responseTextConfig.format())
            .contains(ResponseFormatTextConfig.ofText(ResponseFormatText.builder().build()))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseTextConfig =
            ResponseTextConfig.builder().format(ResponseFormatText.builder().build()).build()

        val roundtrippedResponseTextConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseTextConfig),
                jacksonTypeRef<ResponseTextConfig>(),
            )

        assertThat(roundtrippedResponseTextConfig).isEqualTo(responseTextConfig)
    }
}
