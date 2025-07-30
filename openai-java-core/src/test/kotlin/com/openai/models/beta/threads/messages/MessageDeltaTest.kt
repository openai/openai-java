// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageDeltaTest {

    @Test
    fun create() {
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

        assertThat(messageDelta.content().getOrNull())
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

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
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

        val roundtrippedMessageDelta =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageDelta),
                jacksonTypeRef<MessageDelta>(),
            )

        assertThat(roundtrippedMessageDelta).isEqualTo(messageDelta)
    }
}
