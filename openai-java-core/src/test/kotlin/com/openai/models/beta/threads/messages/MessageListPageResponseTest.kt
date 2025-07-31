// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.beta.assistants.CodeInterpreterTool
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageListPageResponseTest {

    @Test
    fun create() {
        val messageListPageResponse =
            MessageListPageResponse.builder()
                .addData(
                    Message.builder()
                        .id("id")
                        .assistantId("assistant_id")
                        .addAttachment(
                            Message.Attachment.builder()
                                .fileId("file_id")
                                .addTool(CodeInterpreterTool.builder().build())
                                .build()
                        )
                        .completedAt(0L)
                        .addImageFileContent(
                            ImageFile.builder()
                                .fileId("file_id")
                                .detail(ImageFile.Detail.AUTO)
                                .build()
                        )
                        .createdAt(0L)
                        .incompleteAt(0L)
                        .incompleteDetails(
                            Message.IncompleteDetails.builder()
                                .reason(Message.IncompleteDetails.Reason.CONTENT_FILTER)
                                .build()
                        )
                        .metadata(
                            Message.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .role(Message.Role.USER)
                        .runId("run_id")
                        .status(Message.Status.IN_PROGRESS)
                        .threadId("thread_id")
                        .build()
                )
                .firstId("msg_abc123")
                .hasMore(false)
                .lastId("msg_abc123")
                .object_("list")
                .build()

        assertThat(messageListPageResponse.data())
            .containsExactly(
                Message.builder()
                    .id("id")
                    .assistantId("assistant_id")
                    .addAttachment(
                        Message.Attachment.builder()
                            .fileId("file_id")
                            .addTool(CodeInterpreterTool.builder().build())
                            .build()
                    )
                    .completedAt(0L)
                    .addImageFileContent(
                        ImageFile.builder().fileId("file_id").detail(ImageFile.Detail.AUTO).build()
                    )
                    .createdAt(0L)
                    .incompleteAt(0L)
                    .incompleteDetails(
                        Message.IncompleteDetails.builder()
                            .reason(Message.IncompleteDetails.Reason.CONTENT_FILTER)
                            .build()
                    )
                    .metadata(
                        Message.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .role(Message.Role.USER)
                    .runId("run_id")
                    .status(Message.Status.IN_PROGRESS)
                    .threadId("thread_id")
                    .build()
            )
        assertThat(messageListPageResponse.firstId()).isEqualTo("msg_abc123")
        assertThat(messageListPageResponse.hasMore()).isEqualTo(false)
        assertThat(messageListPageResponse.lastId()).isEqualTo("msg_abc123")
        assertThat(messageListPageResponse.object_()).isEqualTo("list")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageListPageResponse =
            MessageListPageResponse.builder()
                .addData(
                    Message.builder()
                        .id("id")
                        .assistantId("assistant_id")
                        .addAttachment(
                            Message.Attachment.builder()
                                .fileId("file_id")
                                .addTool(CodeInterpreterTool.builder().build())
                                .build()
                        )
                        .completedAt(0L)
                        .addImageFileContent(
                            ImageFile.builder()
                                .fileId("file_id")
                                .detail(ImageFile.Detail.AUTO)
                                .build()
                        )
                        .createdAt(0L)
                        .incompleteAt(0L)
                        .incompleteDetails(
                            Message.IncompleteDetails.builder()
                                .reason(Message.IncompleteDetails.Reason.CONTENT_FILTER)
                                .build()
                        )
                        .metadata(
                            Message.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .role(Message.Role.USER)
                        .runId("run_id")
                        .status(Message.Status.IN_PROGRESS)
                        .threadId("thread_id")
                        .build()
                )
                .firstId("msg_abc123")
                .hasMore(false)
                .lastId("msg_abc123")
                .object_("list")
                .build()

        val roundtrippedMessageListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageListPageResponse),
                jacksonTypeRef<MessageListPageResponse>(),
            )

        assertThat(roundtrippedMessageListPageResponse).isEqualTo(messageListPageResponse)
    }
}
