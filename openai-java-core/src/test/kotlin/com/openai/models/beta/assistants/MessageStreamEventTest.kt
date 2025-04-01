// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.assistants

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.beta.threads.messages.ImageFile
import com.openai.models.beta.threads.messages.ImageFileDelta
import com.openai.models.beta.threads.messages.ImageFileDeltaBlock
import com.openai.models.beta.threads.messages.Message
import com.openai.models.beta.threads.messages.MessageDelta
import com.openai.models.beta.threads.messages.MessageDeltaEvent
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class MessageStreamEventTest {

    @Test
    fun ofThreadMessageCreated() {
        val threadMessageCreated =
            MessageStreamEvent.ThreadMessageCreated.builder()
                .data(
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
                .build()

        val messageStreamEvent = MessageStreamEvent.ofThreadMessageCreated(threadMessageCreated)

        assertThat(messageStreamEvent.threadMessageCreated()).contains(threadMessageCreated)
        assertThat(messageStreamEvent.threadMessageInProgress()).isEmpty
        assertThat(messageStreamEvent.threadMessageDelta()).isEmpty
        assertThat(messageStreamEvent.threadMessageCompleted()).isEmpty
        assertThat(messageStreamEvent.threadMessageIncomplete()).isEmpty
    }

    @Test
    fun ofThreadMessageCreatedRoundtrip() {
        val jsonMapper = jsonMapper()
        val messageStreamEvent =
            MessageStreamEvent.ofThreadMessageCreated(
                MessageStreamEvent.ThreadMessageCreated.builder()
                    .data(
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
                    .build()
            )

        val roundtrippedMessageStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageStreamEvent),
                jacksonTypeRef<MessageStreamEvent>(),
            )

        assertThat(roundtrippedMessageStreamEvent).isEqualTo(messageStreamEvent)
    }

    @Test
    fun ofThreadMessageInProgress() {
        val threadMessageInProgress =
            MessageStreamEvent.ThreadMessageInProgress.builder()
                .data(
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
                .build()

        val messageStreamEvent =
            MessageStreamEvent.ofThreadMessageInProgress(threadMessageInProgress)

        assertThat(messageStreamEvent.threadMessageCreated()).isEmpty
        assertThat(messageStreamEvent.threadMessageInProgress()).contains(threadMessageInProgress)
        assertThat(messageStreamEvent.threadMessageDelta()).isEmpty
        assertThat(messageStreamEvent.threadMessageCompleted()).isEmpty
        assertThat(messageStreamEvent.threadMessageIncomplete()).isEmpty
    }

    @Test
    fun ofThreadMessageInProgressRoundtrip() {
        val jsonMapper = jsonMapper()
        val messageStreamEvent =
            MessageStreamEvent.ofThreadMessageInProgress(
                MessageStreamEvent.ThreadMessageInProgress.builder()
                    .data(
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
                    .build()
            )

        val roundtrippedMessageStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageStreamEvent),
                jacksonTypeRef<MessageStreamEvent>(),
            )

        assertThat(roundtrippedMessageStreamEvent).isEqualTo(messageStreamEvent)
    }

    @Test
    fun ofThreadMessageDelta() {
        val threadMessageDelta =
            MessageStreamEvent.ThreadMessageDelta.builder()
                .data(
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
                )
                .build()

        val messageStreamEvent = MessageStreamEvent.ofThreadMessageDelta(threadMessageDelta)

        assertThat(messageStreamEvent.threadMessageCreated()).isEmpty
        assertThat(messageStreamEvent.threadMessageInProgress()).isEmpty
        assertThat(messageStreamEvent.threadMessageDelta()).contains(threadMessageDelta)
        assertThat(messageStreamEvent.threadMessageCompleted()).isEmpty
        assertThat(messageStreamEvent.threadMessageIncomplete()).isEmpty
    }

    @Test
    fun ofThreadMessageDeltaRoundtrip() {
        val jsonMapper = jsonMapper()
        val messageStreamEvent =
            MessageStreamEvent.ofThreadMessageDelta(
                MessageStreamEvent.ThreadMessageDelta.builder()
                    .data(
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
                    )
                    .build()
            )

        val roundtrippedMessageStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageStreamEvent),
                jacksonTypeRef<MessageStreamEvent>(),
            )

        assertThat(roundtrippedMessageStreamEvent).isEqualTo(messageStreamEvent)
    }

    @Test
    fun ofThreadMessageCompleted() {
        val threadMessageCompleted =
            MessageStreamEvent.ThreadMessageCompleted.builder()
                .data(
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
                .build()

        val messageStreamEvent = MessageStreamEvent.ofThreadMessageCompleted(threadMessageCompleted)

        assertThat(messageStreamEvent.threadMessageCreated()).isEmpty
        assertThat(messageStreamEvent.threadMessageInProgress()).isEmpty
        assertThat(messageStreamEvent.threadMessageDelta()).isEmpty
        assertThat(messageStreamEvent.threadMessageCompleted()).contains(threadMessageCompleted)
        assertThat(messageStreamEvent.threadMessageIncomplete()).isEmpty
    }

    @Test
    fun ofThreadMessageCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val messageStreamEvent =
            MessageStreamEvent.ofThreadMessageCompleted(
                MessageStreamEvent.ThreadMessageCompleted.builder()
                    .data(
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
                    .build()
            )

        val roundtrippedMessageStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageStreamEvent),
                jacksonTypeRef<MessageStreamEvent>(),
            )

        assertThat(roundtrippedMessageStreamEvent).isEqualTo(messageStreamEvent)
    }

    @Test
    fun ofThreadMessageIncomplete() {
        val threadMessageIncomplete =
            MessageStreamEvent.ThreadMessageIncomplete.builder()
                .data(
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
                .build()

        val messageStreamEvent =
            MessageStreamEvent.ofThreadMessageIncomplete(threadMessageIncomplete)

        assertThat(messageStreamEvent.threadMessageCreated()).isEmpty
        assertThat(messageStreamEvent.threadMessageInProgress()).isEmpty
        assertThat(messageStreamEvent.threadMessageDelta()).isEmpty
        assertThat(messageStreamEvent.threadMessageCompleted()).isEmpty
        assertThat(messageStreamEvent.threadMessageIncomplete()).contains(threadMessageIncomplete)
    }

    @Test
    fun ofThreadMessageIncompleteRoundtrip() {
        val jsonMapper = jsonMapper()
        val messageStreamEvent =
            MessageStreamEvent.ofThreadMessageIncomplete(
                MessageStreamEvent.ThreadMessageIncomplete.builder()
                    .data(
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
                    .build()
            )

        val roundtrippedMessageStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageStreamEvent),
                jacksonTypeRef<MessageStreamEvent>(),
            )

        assertThat(roundtrippedMessageStreamEvent).isEqualTo(messageStreamEvent)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val messageStreamEvent =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<MessageStreamEvent>())

        val e = assertThrows<OpenAIInvalidDataException> { messageStreamEvent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
