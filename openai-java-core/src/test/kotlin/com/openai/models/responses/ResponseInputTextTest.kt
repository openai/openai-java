// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponseInputTextTest {

    @Test
    fun createResponseInputText() {
        val responseInputText = ResponseInputText.builder().text("text").build()
        assertThat(responseInputText).isNotNull
        assertThat(responseInputText.text()).isEqualTo("text")
    }
}
