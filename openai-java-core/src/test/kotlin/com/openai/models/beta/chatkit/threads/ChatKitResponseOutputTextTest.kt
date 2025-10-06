// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatKitResponseOutputTextTest {

    @Test
    fun create() {
        val chatkitResponseOutputText =
            ChatKitResponseOutputText.builder()
                .addFileAnnotation(
                    ChatKitResponseOutputText.Annotation.File.Source.builder()
                        .filename("filename")
                        .build()
                )
                .text("text")
                .build()

        assertThat(chatkitResponseOutputText.annotations())
            .containsExactly(
                ChatKitResponseOutputText.Annotation.ofFile(
                    ChatKitResponseOutputText.Annotation.File.builder()
                        .source(
                            ChatKitResponseOutputText.Annotation.File.Source.builder()
                                .filename("filename")
                                .build()
                        )
                        .build()
                )
            )
        assertThat(chatkitResponseOutputText.text()).isEqualTo("text")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val chatkitResponseOutputText =
            ChatKitResponseOutputText.builder()
                .addFileAnnotation(
                    ChatKitResponseOutputText.Annotation.File.Source.builder()
                        .filename("filename")
                        .build()
                )
                .text("text")
                .build()

        val roundtrippedChatKitResponseOutputText =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatkitResponseOutputText),
                jacksonTypeRef<ChatKitResponseOutputText>(),
            )

        assertThat(roundtrippedChatKitResponseOutputText).isEqualTo(chatkitResponseOutputText)
    }
}
