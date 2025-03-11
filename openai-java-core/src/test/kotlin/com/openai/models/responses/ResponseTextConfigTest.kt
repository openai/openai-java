// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.openai.models.ResponseFormatText
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponseTextConfigTest {

    @Test
    fun createResponseTextConfig() {
        val responseTextConfig =
            ResponseTextConfig.builder().format(ResponseFormatText.builder().build()).build()
        assertThat(responseTextConfig).isNotNull
        assertThat(responseTextConfig.format())
            .contains(ResponseFormatTextConfig.ofText(ResponseFormatText.builder().build()))
    }
}
