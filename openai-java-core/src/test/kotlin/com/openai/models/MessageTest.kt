// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageTest {

    @Test
    fun createMessage() {
        val message =
            Message.builder()
                .id("id")
                .assistantId("assistant_id")
                .addAttachment(
                    Message.Attachment.builder()
                        .fileId("file_id")
                        .addTool(
                            CodeInterpreterTool.builder()
                                .type(CodeInterpreterTool.Type.CODE_INTERPRETER)
                                .build()
                        )
                        .build()
                )
                .completedAt(0L)
                .addContent(
                    ImageFileContentBlock.builder()
                        .imageFile(
                            ImageFile.builder()
                                .fileId("file_id")
                                .detail(ImageFile.Detail.AUTO)
                                .build()
                        )
                        .type(ImageFileContentBlock.Type.IMAGE_FILE)
                        .build()
                )
                .createdAt(0L)
                .incompleteAt(0L)
                .incompleteDetails(
                    Message.IncompleteDetails.builder()
                        .reason(Message.IncompleteDetails.Reason.CONTENT_FILTER)
                        .build()
                )
                .metadata(JsonValue.from(mapOf<String, Any>()))
                .object_(Message.Object.THREAD_MESSAGE)
                .role(Message.Role.USER)
                .runId("run_id")
                .status(Message.Status.IN_PROGRESS)
                .threadId("thread_id")
                .build()
        assertThat(message).isNotNull
        assertThat(message.id()).isEqualTo("id")
        assertThat(message.assistantId()).contains("assistant_id")
        assertThat(message.attachments().get())
            .containsExactly(
                Message.Attachment.builder()
                    .fileId("file_id")
                    .addTool(
                        CodeInterpreterTool.builder()
                            .type(CodeInterpreterTool.Type.CODE_INTERPRETER)
                            .build()
                    )
                    .build()
            )
        assertThat(message.completedAt()).contains(0L)
        assertThat(message.content())
            .containsExactly(
                MessageContent.ofImageFileContentBlock(
                    ImageFileContentBlock.builder()
                        .imageFile(
                            ImageFile.builder()
                                .fileId("file_id")
                                .detail(ImageFile.Detail.AUTO)
                                .build()
                        )
                        .type(ImageFileContentBlock.Type.IMAGE_FILE)
                        .build()
                )
            )
        assertThat(message.createdAt()).isEqualTo(0L)
        assertThat(message.incompleteAt()).contains(0L)
        assertThat(message.incompleteDetails())
            .contains(
                Message.IncompleteDetails.builder()
                    .reason(Message.IncompleteDetails.Reason.CONTENT_FILTER)
                    .build()
            )
        assertThat(message._metadata()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(message.object_()).isEqualTo(Message.Object.THREAD_MESSAGE)
        assertThat(message.role()).isEqualTo(Message.Role.USER)
        assertThat(message.runId()).contains("run_id")
        assertThat(message.status()).isEqualTo(Message.Status.IN_PROGRESS)
        assertThat(message.threadId()).isEqualTo("thread_id")
    }
}
