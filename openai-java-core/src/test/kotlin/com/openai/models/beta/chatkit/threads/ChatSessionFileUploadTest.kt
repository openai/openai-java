// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatSessionFileUploadTest {

    @Test
    fun create() {
        val chatSessionFileUpload =
            ChatSessionFileUpload.builder().enabled(true).maxFileSize(0L).maxFiles(0L).build()

        assertThat(chatSessionFileUpload.enabled()).isEqualTo(true)
        assertThat(chatSessionFileUpload.maxFileSize()).contains(0L)
        assertThat(chatSessionFileUpload.maxFiles()).contains(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatSessionFileUpload =
            ChatSessionFileUpload.builder().enabled(true).maxFileSize(0L).maxFiles(0L).build()

        val roundtrippedChatSessionFileUpload =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatSessionFileUpload),
                jacksonTypeRef<ChatSessionFileUpload>(),
            )

        assertThat(roundtrippedChatSessionFileUpload).isEqualTo(chatSessionFileUpload)
    }
}
