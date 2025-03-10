// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageDeltaTest {

    @Test
    fun createMessageDelta() {
        val messageDelta =
            MessageDelta.builder()
                .addContent(
                    ImageFileDeltaBlock.builder()
                        .index(0L)
                        .imageFile(
                            ImageFileDelta.builder()
                                .detail(ImageFileDelta.Detail.AUTO)
                                .fileId("file_id")
                                .build()
                        )
                        .build()
                )
                .role(MessageDelta.Role.USER)
                .build()
        assertThat(messageDelta).isNotNull
        assertThat(messageDelta.content().get())
            .containsExactly(
                MessageContentDelta.ofImageFile(
                    ImageFileDeltaBlock.builder()
                        .index(0L)
                        .imageFile(
                            ImageFileDelta.builder()
                                .detail(ImageFileDelta.Detail.AUTO)
                                .fileId("file_id")
                                .build()
                        )
                        .build()
                )
            )
        assertThat(messageDelta.role()).contains(MessageDelta.Role.USER)
    }
}
