// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCompactionItemTest {

    @Test
    fun create() {
        val responseCompactionItem =
            ResponseCompactionItem.builder()
                .id("id")
                .encryptedContent("encrypted_content")
                .createdBy("created_by")
                .build()

        assertThat(responseCompactionItem.id()).isEqualTo("id")
        assertThat(responseCompactionItem.encryptedContent()).isEqualTo("encrypted_content")
        assertThat(responseCompactionItem.createdBy()).contains("created_by")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseCompactionItem =
            ResponseCompactionItem.builder()
                .id("id")
                .encryptedContent("encrypted_content")
                .createdBy("created_by")
                .build()

        val roundtrippedResponseCompactionItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseCompactionItem),
                jacksonTypeRef<ResponseCompactionItem>(),
            )

        assertThat(roundtrippedResponseCompactionItem).isEqualTo(responseCompactionItem)
    }
}
