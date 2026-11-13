package com.openai.services.blocking

import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.client.OpenAIClient
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ResponseCompatibilityClientTest {

    private lateinit var client: OpenAIClient

    @BeforeEach
    fun setUp(server: WireMockRuntimeInfo) {
        client =
            OpenAIOkHttpClient.builder()
                .baseUrl(server.httpBaseUrl)
                .apiKey("test-key")
                .maxRetries(0)
                .responseValidation(true)
                .build()
    }

    @AfterEach fun tearDown() = client.close()

    @Test
    fun listStoredChatsStopsAfterAnEmptyPage() {
        val path = "/chat/completions"
        val chat =
            """{"id":"chat_1","object":"chat.completion","model":"test","choices":[],"created":1}"""
        stubFor(get(path).willReturn(okJson(page(chat, "chat_1"))))
        stubFor(get("$path?after=chat_1").willReturn(okJson(emptyPage(hasMore = true))))

        val first = client.chat().completions().list()
        assertThat(first.response().firstId()).contains("chat_1")
        assertThat(first.response().lastId()).contains("chat_1")
        assertThat(first.autoPager().take(2).map { it.idOrThrow() }).containsExactly("chat_1")
        verify(2, getRequestedFor(urlPathEqualTo(path)))
    }

    @Test
    fun listStoredMessagesStopsAfterAnEmptyPage() {
        val path = "/chat/completions/chat_1/messages"
        val message = """{"id":"msg_1","role":"assistant","content":"hello"}"""
        stubFor(get(path).willReturn(okJson(page(message, "msg_1"))))
        stubFor(get("$path?after=msg_1").willReturn(okJson(emptyPage(hasMore = true))))

        val first = client.chat().completions().messages().list("chat_1")
        assertThat(first.response().firstId()).contains("msg_1")
        assertThat(first.response().lastId()).contains("msg_1")
        assertThat(first.autoPager().take(2).map { it.content().get() }).containsExactly("hello")
        verify(2, getRequestedFor(urlPathEqualTo(path)))
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun emptyListsExposeAbsentCursorsAndMakeNoFollowUpRequests(hasMore: Boolean) {
        val chats = "/chat/completions"
        val messages = "$chats/chat_1/messages"
        stubFor(get(chats).willReturn(okJson(emptyPage(hasMore))))
        stubFor(get(messages).willReturn(okJson(emptyPage(hasMore))))

        val completions = client.chat().completions()
        val chatPage = completions.list()
        assertThat(chatPage.response().firstId()).isEmpty
        assertThat(chatPage.response().lastId()).isEmpty
        assertThat(chatPage.hasNextPage()).isFalse
        assertThat(chatPage.autoPager().iterator().hasNext()).isFalse

        val messagePage = completions.messages().list("chat_1")
        assertThat(messagePage.response().firstId()).isEmpty
        assertThat(messagePage.response().lastId()).isEmpty
        assertThat(messagePage.hasNextPage()).isFalse
        assertThat(messagePage.autoPager().iterator().hasNext()).isFalse
        verify(1, getRequestedFor(urlPathEqualTo(chats)))
        verify(1, getRequestedFor(urlPathEqualTo(messages)))
    }

    @ParameterizedTest
    @ValueSource(strings = ["first_id", "last_id"])
    fun strictListsRejectMalformedCursors(field: String) {
        val malformed = emptyPage(hasMore = false).replace(""""$field":null""", """"$field":[]""")
        stubFor(get("/chat/completions").willReturn(okJson(malformed)))
        stubFor(get("/chat/completions/chat_1/messages").willReturn(okJson(malformed)))

        val completions = client.chat().completions()
        assertThatThrownBy { completions.list() }
            .isInstanceOf(OpenAIInvalidDataException::class.java)
            .hasMessageContaining(field)
        assertThatThrownBy { completions.messages().list("chat_1") }
            .isInstanceOf(OpenAIInvalidDataException::class.java)
            .hasMessageContaining(field)
    }

    @Test
    fun webSearchWithoutActionSurvivesStrictItemListDecoding() {
        val call = """{"id":"ws_1","type":"web_search_call","status":"completed"}"""
        val path = "/responses/resp_1/input_items"
        stubFor(get(path).willReturn(okJson(page(call, "ws_1"))))
        stubFor(get("$path?beta=true").willReturn(okJson(page(call, "ws_1"))))

        val ga = client.responses().inputItems().list("resp_1").items().single()
        val beta = client.beta().responses().inputItems().list("resp_1").items().single()
        assertThat(ga.asWebSearchCall().action()).isEmpty
        assertThat(beta.asWebSearchCall().action()).isEmpty
    }

    @Test
    fun retrieveConversationReadsStringMetadata() {
        val path = "/conversations/conv_1"
        val body =
            """{"id":"conv_1","object":"conversation","created_at":1,"metadata":{"team":"sdk"}}"""
        stubFor(get(path).willReturn(okJson(body)))

        val metadata = client.conversations().retrieve("conv_1").metadataOrThrow()
        assertThat(metadata._allProperties().getValue("team").asString()).contains("sdk")
    }

    private fun page(item: String, id: String) =
        """{"object":"list","data":[$item],"has_more":true,"first_id":"$id","last_id":"$id"}"""

    private fun emptyPage(hasMore: Boolean) =
        """{"object":"list","data":[],"has_more":$hasMore,"first_id":null,"last_id":null}"""
}
