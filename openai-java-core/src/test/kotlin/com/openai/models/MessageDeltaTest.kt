// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageDeltaTest {

    @Test
    fun createMessageDelta() {
        val messageDelta =
            MessageDelta.builder()
                .content(
                    listOf(
                        MessageContentDelta.ofImageFileDeltaBlock(
                            ImageFileDeltaBlock.builder()
                                .index(0L)
                                .type(ImageFileDeltaBlock.Type.IMAGE_FILE)
                                .imageFile(
                                    ImageFileDelta.builder()
                                        .detail(ImageFileDelta.Detail.AUTO)
                                        .fileId("file_id")
                                        .build()
                                )
                                .build()
                        )
                    )
                )
                .role(MessageDelta.Role.USER)
                .build()
        assertThat(messageDelta).isNotNull
        assertThat(messageDelta.content().get())
            .containsExactly(
                MessageContentDelta.ofImageFileDeltaBlock(
                    ImageFileDeltaBlock.builder()
                        .index(0L)
                        .type(ImageFileDeltaBlock.Type.IMAGE_FILE)
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
