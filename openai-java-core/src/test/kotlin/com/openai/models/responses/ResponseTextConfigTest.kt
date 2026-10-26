// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.ResponseFormatText
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseTextConfigTest {

    @Test
    fun createAndRoundtrip() {
        val responseTextConfig =
            ResponseTextConfig.builder()
                .format(ResponseFormatText.builder().build())
                .verbosity(ResponseTextConfig.Verbosity.LOW)
                .build()

        assertThat(responseTextConfig.format())
            .contains(ResponseFormatTextConfig.ofText(ResponseFormatText.builder().build()))
        assertThat(responseTextConfig.verbosity()).contains(ResponseTextConfig.Verbosity.LOW)

        val jsonMapper = jsonMapper()

        val roundtrippedResponseTextConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseTextConfig),
                jacksonTypeRef<ResponseTextConfig>(),
            )

        assertThat(roundtrippedResponseTextConfig).isEqualTo(responseTextConfig)
    }
}
