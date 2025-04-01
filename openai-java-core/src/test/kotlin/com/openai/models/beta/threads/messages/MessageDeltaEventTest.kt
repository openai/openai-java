// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageDeltaEventTest {

    @Test
    fun create() {
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

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
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

        val roundtrippedMessageDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageDeltaEvent),
                jacksonTypeRef<MessageDeltaEvent>(),
            )

        assertThat(roundtrippedMessageDeltaEvent).isEqualTo(messageDeltaEvent)
    }
}
