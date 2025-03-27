// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta.threads

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.beta.assistants.CodeInterpreterTool
import com.openai.models.beta.threads.messages.MessageCreateParams
import com.openai.models.beta.threads.messages.MessageDeleteParams
import com.openai.models.beta.threads.messages.MessageListParams
import com.openai.models.beta.threads.messages.MessageRetrieveParams
import com.openai.models.beta.threads.messages.MessageUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MessageServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageService = client.beta().threads().messages()

        val message =
            messageService.create(
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
                        MessageCreateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .build()
            )

        message.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageService = client.beta().threads().messages()

        val message =
            messageService.retrieve(
                MessageRetrieveParams.builder()
                    .threadId("thread_id")
                    .messageId("message_id")
                    .build()
            )

        message.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageService = client.beta().threads().messages()

        val message =
            messageService.update(
                MessageUpdateParams.builder()
                    .threadId("thread_id")
                    .messageId("message_id")
                    .metadata(
                        MessageUpdateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .build()
            )

        message.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageService = client.beta().threads().messages()

        val page = messageService.list(MessageListParams.builder().threadId("thread_id").build())

        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageService = client.beta().threads().messages()

        val messageDeleted =
            messageService.delete(
                MessageDeleteParams.builder().threadId("thread_id").messageId("message_id").build()
            )

        messageDeleted.validate()
    }
}
