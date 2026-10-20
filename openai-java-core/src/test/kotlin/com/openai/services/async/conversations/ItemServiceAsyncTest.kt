// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.conversations

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.findAll
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.conversations.items.ItemCreateParams
import com.openai.models.conversations.items.ItemDeleteParams
import com.openai.models.conversations.items.ItemRetrieveParams
import com.openai.models.responses.EasyInputMessage
import com.openai.models.responses.ResponseIncludable
import java.util.concurrent.atomic.AtomicInteger
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.parallel.ResourceLock

@ExtendWith(TestServerExtension::class)
@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ItemServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
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
                .adminApiKey("My Admin API Key")
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
    fun listStopsOnExplicitFalse(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        try {
            // A terminal page can still contain items and a cursor
            stubFor(
                get(anyUrl())
                    .willReturn(
                        okJson(
                            "{\"data\":[{\"id\":\"item_1\"}],\"has_more\":false,\"last_id\":\"item_1\"}"
                        )
                    )
            )
            val page = client.conversations().items().list("conv_123").get()
            assertThat(page.items()).hasSize(1)
            assertThat(page.hasNextPage()).isFalse()

            val count = AtomicInteger()
            page.autoPager().subscribe { count.incrementAndGet() }.onCompleteFuture().get()
            assertThat(count.get()).isEqualTo(1)

            assertThat(findAll(getRequestedFor(anyUrl()))).hasSize(1)
        } finally {
            client.close()
        }
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
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
                .adminApiKey("My Admin API Key")
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
