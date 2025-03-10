// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

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
                )
                .build()
        assertThat(messageDeltaEvent).isNotNull
        assertThat(messageDeltaEvent.id()).isEqualTo("id")
        assertThat(messageDeltaEvent.delta())
            .isEqualTo(
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
            )
    }
}
