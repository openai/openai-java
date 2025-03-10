// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import com.openai.core.JsonValue
import com.openai.models.Metadata
import com.openai.models.beta.assistants.CodeInterpreterTool
import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageCreateParamsTest {

    @Test
    fun create() {
        MessageCreateParams.builder()
            .threadId("thread_id")
            .content("string")
            .role(MessageCreateParams.Role.USER)
            .addAttachment(
                MessageCreateParams.Attachment.builder()
                    .fileId("file_id")
                    .addTool(CodeInterpreterTool.builder().build())
                    .build()
            )
            .metadata(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            MessageCreateParams.builder()
                .threadId("thread_id")
                .content("string")
                .role(MessageCreateParams.Role.USER)
                .addAttachment(
                    MessageCreateParams.Attachment.builder()
                        .fileId("file_id")
                        .addTool(CodeInterpreterTool.builder().build())
                        .build()
                )
                .metadata(
                    Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.content()).isEqualTo(MessageCreateParams.Content.ofText("string"))
        assertThat(body.role()).isEqualTo(MessageCreateParams.Role.USER)
        assertThat(body.attachments())
            .contains(
                listOf(
                    MessageCreateParams.Attachment.builder()
                        .fileId("file_id")
                        .addTool(CodeInterpreterTool.builder().build())
                        .build()
                )
            )
        assertThat(body.metadata())
            .contains(
                Metadata.builder().putAdditionalProperty("foo", JsonValue.from("string")).build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            MessageCreateParams.builder()
                .threadId("thread_id")
                .content("string")
                .role(MessageCreateParams.Role.USER)
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.content()).isEqualTo(MessageCreateParams.Content.ofText("string"))
        assertThat(body.role()).isEqualTo(MessageCreateParams.Role.USER)
    }

    @Test
    fun getPathParam() {
        val params =
            MessageCreateParams.builder()
                .threadId("thread_id")
                .content("string")
                .role(MessageCreateParams.Role.USER)
                .build()
        assertThat(params).isNotNull
        // path param "threadId"
        assertThat(params.getPathParam(0)).isEqualTo("thread_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
