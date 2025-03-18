// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseInputTextTest {

    @Test
    fun create() {
        val responseInputText = ResponseInputText.builder().text("text").build()

        assertThat(responseInputText.text()).isEqualTo("text")
    }
}
