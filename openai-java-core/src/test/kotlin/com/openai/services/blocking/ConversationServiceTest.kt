// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.conversations.ConversationCreateParams
import com.openai.models.conversations.ConversationUpdateParams
import com.openai.models.responses.EasyInputMessage
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ConversationServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val conversationService = client.conversations()

        val conversation =
            conversationService.create(
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

        conversation.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val conversationService = client.conversations()

        val conversation = conversationService.retrieve("conv_123")

        conversation.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val conversationService = client.conversations()

        val conversation =
            conversationService.update(
                ConversationUpdateParams.builder()
                    .conversationId("conv_123")
                    .metadata(
                        ConversationUpdateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .build()
            )

        conversation.validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val conversationService = client.conversations()

        val conversationDeletedResource = conversationService.delete("conv_123")

        conversationDeletedResource.validate()
    }
}
