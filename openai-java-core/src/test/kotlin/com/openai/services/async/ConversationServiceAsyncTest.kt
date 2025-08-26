// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.JsonValue
import com.openai.models.conversations.ConversationCreateParams
import com.openai.models.conversations.ConversationUpdateParams
import com.openai.models.responses.EasyInputMessage
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ConversationServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val conversationServiceAsync = client.conversations()

        val conversationFuture =
            conversationServiceAsync.create(
                ConversationCreateParams.builder()
                    .addItem(
                        EasyInputMessage.builder()
                            .content("string")
                            .role(EasyInputMessage.Role.USER)
                            .type(EasyInputMessage.Type.MESSAGE)
                            .build()
                    )
                    .metadata(
                        ConversationCreateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .build()
            )

        val conversation = conversationFuture.get()
        conversation.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val conversationServiceAsync = client.conversations()

        val conversationFuture = conversationServiceAsync.retrieve("conv_123")

        val conversation = conversationFuture.get()
        conversation.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val conversationServiceAsync = client.conversations()

        val conversationFuture =
            conversationServiceAsync.update(
                ConversationUpdateParams.builder()
                    .conversationId("conv_123")
                    .metadata(
                        ConversationUpdateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .build()
            )

        val conversation = conversationFuture.get()
        conversation.validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val conversationServiceAsync = client.conversations()

        val conversationDeletedResourceFuture = conversationServiceAsync.delete("conv_123")

        val conversationDeletedResource = conversationDeletedResourceFuture.get()
        conversationDeletedResource.validate()
    }
}
