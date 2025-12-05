// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCompactionItemParamTest {

    @Test
    fun create() {
        val responseCompactionItemParam =
            ResponseCompactionItemParam.builder()
                .encryptedContent("encrypted_content")
                .id("cmp_123")
                .build()

        assertThat(responseCompactionItemParam.encryptedContent()).isEqualTo("encrypted_content")
        assertThat(responseCompactionItemParam.id()).contains("cmp_123")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseCompactionItemParam =
            ResponseCompactionItemParam.builder()
                .encryptedContent("encrypted_content")
                .id("cmp_123")
                .build()

        val roundtrippedResponseCompactionItemParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseCompactionItemParam),
                jacksonTypeRef<ResponseCompactionItemParam>(),
            )

        assertThat(roundtrippedResponseCompactionItemParam).isEqualTo(responseCompactionItemParam)
    }
}
