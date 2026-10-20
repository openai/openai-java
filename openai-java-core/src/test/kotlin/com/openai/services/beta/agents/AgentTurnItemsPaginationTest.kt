package com.openai.services.beta.agents

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.models.beta.agents.AgentSessionItem
import com.openai.models.beta.agents.sessions.turns.items.ItemListParams
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class AgentTurnItemsPaginationTest {

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun listsPastUnknownLastItemAndStopsOnPopulatedFinalPage(async: Boolean) {
        val path = "/v1/agents/sessions/session_test/turns/turn_test/items"
        val server = WireMockServer(wireMockConfig().dynamicPort())
        server.start()
        try {
            server.stubFor(
                get(urlPathEqualTo(path))
                    .withQueryParam("after", absent())
                    .willReturn(
                        okJson(
                            """{
                                "object":"list",
                                "data":[
                                    {"type":"message","id":"item_first","role":"assistant","status":"completed","content":[]},
                                    {"type":"future_item","id":"item_future","payload":{"value":7}}
                                ],
                                "has_more":true,"first_id":"item_first","last_id":"item_future"
                            }"""
                        )
                    )
            )
            server.stubFor(
                get(urlPathEqualTo(path))
                    .withQueryParam("after", equalTo("item_future"))
                    .willReturn(
                        okJson(
                            """{
                                "object":"list",
                                "data":[{"type":"message","id":"item_last","role":"assistant","status":"completed","content":[]}],
                                "has_more":false,"first_id":"item_last","last_id":"item_last"
                            }"""
                        )
                    )
            )
            val client =
                OpenAIOkHttpClient.builder()
                    .apiKey("synthetic")
                    .baseUrl(server.baseUrl() + "/v1")
                    .maxRetries(0)
                    .build()
            try {
                val params =
                    ItemListParams.builder()
                        .sessionId("session_test")
                        .turnId("turn_test")
                        .limit(2)
                        .order(ItemListParams.Order.ASC)
                        .putAdditionalHeader("x-pagination-test", "preserved")
                        .build()
                val items = mutableListOf<AgentSessionItem>()
                if (async) {
                    client
                        .async()
                        .beta()
                        .agents()
                        .sessions()
                        .turns()
                        .items()
                        .list(params)
                        .get(30, TimeUnit.SECONDS)
                        .autoPager()
                        .subscribe { item -> items.add(item) }
                        .onCompleteFuture()
                        .get(30, TimeUnit.SECONDS)
                } else {
                    client
                        .beta()
                        .agents()
                        .sessions()
                        .turns()
                        .items()
                        .list(params)
                        .autoPager()
                        .forEach { item -> items.add(item) }
                }
                assertThat(items).hasSize(3)
                assertThat(items[0].asMessage().id()).contains("item_first")
                assertThat(items[1]._json())
                    .contains(
                        JsonValue.from(
                            mapOf(
                                "type" to "future_item",
                                "id" to "item_future",
                                "payload" to mapOf("value" to 7),
                            )
                        )
                    )
                assertThat(items[2].asMessage().id()).contains("item_last")
            } finally {
                client.close()
            }
            server.verify(
                1,
                getRequestedFor(urlPathEqualTo(path)).withQueryParam("after", absent()),
            )
            server.verify(
                1,
                getRequestedFor(urlPathEqualTo(path))
                    .withQueryParam("after", equalTo("item_future")),
            )
            server.verify(
                2,
                getRequestedFor(urlPathEqualTo(path))
                    .withQueryParam("limit", equalTo("2"))
                    .withQueryParam("order", equalTo("asc"))
                    .withHeader("x-pagination-test", equalTo("preserved")),
            )
            assertThat(server.allServeEvents).hasSize(2)
        } finally {
            server.stop()
        }
    }
}
