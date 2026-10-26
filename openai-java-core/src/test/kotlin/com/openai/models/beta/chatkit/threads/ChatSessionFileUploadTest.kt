// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.chatkit.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatSessionFileUploadTest {

    @Test
    fun createAndRoundtrip() {
        val chatSessionFileUpload =
            ChatSessionFileUpload.builder().enabled(true).maxFileSize(0L).maxFiles(0L).build()

        assertThat(chatSessionFileUpload.enabled()).isEqualTo(true)
        assertThat(chatSessionFileUpload.maxFileSize()).contains(0L)
        assertThat(chatSessionFileUpload.maxFiles()).contains(0L)

        val jsonMapper = jsonMapper()

        val roundtrippedChatSessionFileUpload =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatSessionFileUpload),
                jacksonTypeRef<ChatSessionFileUpload>(),
            )

        assertThat(roundtrippedChatSessionFileUpload).isEqualTo(chatSessionFileUpload)
    }
}
