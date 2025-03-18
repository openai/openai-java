// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.messages

import com.openai.core.JsonValue
import com.openai.models.Metadata
import com.openai.models.beta.assistants.CodeInterpreterTool
import kotlin.jvm.optionals.getOrNull
import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageCreateParamsTest {

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
    fun pathParams() {
        val params =
            MessageCreateParams.builder()
                .threadId("thread_id")
                .content("string")
                .role(MessageCreateParams.Role.USER)
                .build()

        assertThat(params._pathParam(0)).isEqualTo("thread_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
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
        assertThat(body.attachments().getOrNull())
            .containsExactly(
                MessageCreateParams.Attachment.builder()
                    .fileId("file_id")
                    .addTool(CodeInterpreterTool.builder().build())
                    .build()
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
}
