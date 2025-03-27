// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta.threads

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
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
internal class MessageServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageServiceAsync = client.beta().threads().messages()

        val messageFuture =
            messageServiceAsync.create(
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

        val message = messageFuture.get()
        message.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageServiceAsync = client.beta().threads().messages()

        val messageFuture =
            messageServiceAsync.retrieve(
                MessageRetrieveParams.builder()
                    .threadId("thread_id")
                    .messageId("message_id")
                    .build()
            )

        val message = messageFuture.get()
        message.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageServiceAsync = client.beta().threads().messages()

        val messageFuture =
            messageServiceAsync.update(
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

        val message = messageFuture.get()
        message.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageServiceAsync = client.beta().threads().messages()

        val pageFuture =
            messageServiceAsync.list(MessageListParams.builder().threadId("thread_id").build())

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageServiceAsync = client.beta().threads().messages()

        val messageDeletedFuture =
            messageServiceAsync.delete(
                MessageDeleteParams.builder().threadId("thread_id").messageId("message_id").build()
            )

        val messageDeleted = messageDeletedFuture.get()
        messageDeleted.validate()
    }
}
