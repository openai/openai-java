// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.beta.assistants.CodeInterpreterTool
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageTest {

    @Test
    fun create() {
        val message =
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

        assertThat(message.id()).isEqualTo("id")
        assertThat(message.assistantId()).contains("assistant_id")
        assertThat(message.attachments().getOrNull())
            .containsExactly(
                Message.Attachment.builder()
                    .fileId("file_id")
                    .addTool(CodeInterpreterTool.builder().build())
                    .build()
            )
        assertThat(message.completedAt()).contains(0L)
        assertThat(message.content())
            .containsExactly(
                MessageContent.ofImageFile(
                    ImageFileContentBlock.builder()
                        .imageFile(
                            ImageFile.builder()
                                .fileId("file_id")
                                .detail(ImageFile.Detail.AUTO)
                                .build()
                        )
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
        assertThat(message.metadata())
            .contains(
                Message.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(message.role()).isEqualTo(Message.Role.USER)
        assertThat(message.runId()).contains("run_id")
        assertThat(message.status()).isEqualTo(Message.Status.IN_PROGRESS)
        assertThat(message.threadId()).isEqualTo("thread_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val message =
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

        val roundtrippedMessage =
            jsonMapper.readValue(jsonMapper.writeValueAsString(message), jacksonTypeRef<Message>())

        assertThat(roundtrippedMessage).isEqualTo(message)
    }
}
