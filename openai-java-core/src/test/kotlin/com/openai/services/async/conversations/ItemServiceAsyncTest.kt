// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.conversations

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.conversations.items.ItemCreateParams
import com.openai.models.conversations.items.ItemDeleteParams
import com.openai.models.conversations.items.ItemRetrieveParams
import com.openai.models.responses.EasyInputMessage
import com.openai.models.responses.ResponseIncludable
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ItemServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val itemServiceAsync = client.conversations().items()

        val conversationItemListFuture =
            itemServiceAsync.create(
                ItemCreateParams.builder()
                    .conversationId("conv_123")
                    .addInclude(ResponseIncludable.FILE_SEARCH_CALL_RESULTS)
                    .addItem(
                        EasyInputMessage.builder()
                            .content("string")
                            .role(EasyInputMessage.Role.USER)
                            .phase(EasyInputMessage.Phase.COMMENTARY)
                            .type(EasyInputMessage.Type.MESSAGE)
                            .build()
                    )
                    .build()
            )

        val conversationItemList = conversationItemListFuture.get()
        conversationItemList.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val itemServiceAsync = client.conversations().items()

        val conversationItemFuture =
            itemServiceAsync.retrieve(
                ItemRetrieveParams.builder()
                    .conversationId("conv_123")
                    .itemId("msg_abc")
                    .addInclude(ResponseIncludable.FILE_SEARCH_CALL_RESULTS)
                    .build()
            )

        val conversationItem = conversationItemFuture.get()
        conversationItem.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val itemServiceAsync = client.conversations().items()

        val pageFuture = itemServiceAsync.list("conv_123")

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
        val itemServiceAsync = client.conversations().items()

        val conversationFuture =
            itemServiceAsync.delete(
                ItemDeleteParams.builder().conversationId("conv_123").itemId("msg_abc").build()
            )

        val conversation = conversationFuture.get()
        conversation.validate()
    }
}
