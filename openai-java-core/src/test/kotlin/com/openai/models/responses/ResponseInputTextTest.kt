// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseInputTextTest {

    @Test
    fun create() {
        val responseInputText = ResponseInputText.builder().text("text").build()

        assertThat(responseInputText.text()).isEqualTo("text")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseInputText = ResponseInputText.builder().text("text").build()

        val roundtrippedResponseInputText =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseInputText),
                jacksonTypeRef<ResponseInputText>(),
            )

        assertThat(roundtrippedResponseInputText).isEqualTo(responseInputText)
    }
}
