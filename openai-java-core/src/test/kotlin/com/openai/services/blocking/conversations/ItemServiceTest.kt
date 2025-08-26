// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.conversations

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.conversations.items.ItemCreateParams
import com.openai.models.conversations.items.ItemDeleteParams
import com.openai.models.conversations.items.ItemRetrieveParams
import com.openai.models.responses.EasyInputMessage
import com.openai.models.responses.ResponseIncludable
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ItemServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val itemService = client.conversations().items()

        val conversationItemList =
            itemService.create(
                ItemCreateParams.builder()
                    .conversationId("conv_123")
                    .addInclude(ResponseIncludable.CODE_INTERPRETER_CALL_OUTPUTS)
                    .addItem(
                        EasyInputMessage.builder()
                            .content("string")
                            .role(EasyInputMessage.Role.USER)
                            .type(EasyInputMessage.Type.MESSAGE)
                            .build()
                    )
                    .build()
            )

        conversationItemList.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val itemService = client.conversations().items()

        val conversationItem =
            itemService.retrieve(
                ItemRetrieveParams.builder()
                    .conversationId("conv_123")
                    .itemId("msg_abc")
                    .addInclude(ResponseIncludable.CODE_INTERPRETER_CALL_OUTPUTS)
                    .build()
            )

        conversationItem.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val itemService = client.conversations().items()

        val page = itemService.list("conv_123")

        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val itemService = client.conversations().items()

        val conversation =
            itemService.delete(
                ItemDeleteParams.builder().conversationId("conv_123").itemId("msg_abc").build()
            )

        conversation.validate()
    }
}
