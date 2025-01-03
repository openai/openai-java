// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageDeltaEventTest {

    @Test
    fun createMessageDeltaEvent() {
        val messageDeltaEvent =
            MessageDeltaEvent.builder()
                .id("id")
                .delta(
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
                )
                .object_(MessageDeltaEvent.Object.THREAD_MESSAGE_DELTA)
                .build()
        assertThat(messageDeltaEvent).isNotNull
        assertThat(messageDeltaEvent.id()).isEqualTo("id")
        assertThat(messageDeltaEvent.delta())
            .isEqualTo(
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
            )
        assertThat(messageDeltaEvent.object_())
            .isEqualTo(MessageDeltaEvent.Object.THREAD_MESSAGE_DELTA)
    }
}
