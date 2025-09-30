// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseInputTextContentTest {

    @Test
    fun create() {
        val responseInputTextContent = ResponseInputTextContent.builder().text("text").build()

        assertThat(responseInputTextContent.text()).isEqualTo("text")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseInputTextContent = ResponseInputTextContent.builder().text("text").build()

        val roundtrippedResponseInputTextContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseInputTextContent),
                jacksonTypeRef<ResponseInputTextContent>(),
            )

        assertThat(roundtrippedResponseInputTextContent).isEqualTo(responseInputTextContent)
    }
}
