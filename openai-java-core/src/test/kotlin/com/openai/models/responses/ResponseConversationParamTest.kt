// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseConversationParamTest {

    @Test
    fun create() {
        val responseConversationParam = ResponseConversationParam.builder().id("id").build()

        assertThat(responseConversationParam.id()).isEqualTo("id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseConversationParam = ResponseConversationParam.builder().id("id").build()

        val roundtrippedResponseConversationParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseConversationParam),
                jacksonTypeRef<ResponseConversationParam>(),
            )

        assertThat(roundtrippedResponseConversationParam).isEqualTo(responseConversationParam)
    }
}
