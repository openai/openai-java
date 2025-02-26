// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta.threads

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.JsonValue
import com.openai.models.BetaThreadMessageCreateParams
import com.openai.models.BetaThreadMessageDeleteParams
import com.openai.models.BetaThreadMessageListParams
import com.openai.models.BetaThreadMessageRetrieveParams
import com.openai.models.BetaThreadMessageUpdateParams
import com.openai.models.CodeInterpreterTool
import com.openai.models.Metadata
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class MessageServiceAsyncTest {

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
                BetaThreadMessageCreateParams.builder()
                    .threadId("thread_id")
                    .content("string")
                    .role(BetaThreadMessageCreateParams.Role.USER)
                    .addAttachment(
                        BetaThreadMessageCreateParams.Attachment.builder()
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
                BetaThreadMessageRetrieveParams.builder()
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
                BetaThreadMessageUpdateParams.builder()
                    .threadId("thread_id")
                    .messageId("message_id")
                    .metadata(
                        Metadata.builder()
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
            messageServiceAsync.list(
                BetaThreadMessageListParams.builder().threadId("thread_id").build()
            )

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
                BetaThreadMessageDeleteParams.builder()
                    .threadId("thread_id")
                    .messageId("message_id")
                    .build()
            )

        val messageDeleted = messageDeletedFuture.get()
        messageDeleted.validate()
    }
}
