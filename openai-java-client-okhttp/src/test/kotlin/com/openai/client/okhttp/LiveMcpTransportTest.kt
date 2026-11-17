package com.openai.client.okhttp

import com.openai.core.ClientOptions
import com.openai.helpers.LiveConnection
import java.util.concurrent.TimeUnit
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout

@Timeout(25)
class LiveMcpTransportTest {
    @Test
    fun nullableMcpSettingsSurviveSyncAndAsyncReceive() {
        val tools =
            """[{"type":"mcp","server_label":"fixture","server_url":"https://example.test/mcp","server_description":"MCP response fixture","connector_id":"connector_dropbox","tunnel_id":"tunnel_aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","allowed_callers":["direct"],"defer_loading":false,"allowed_tools":{"tool_names":["lookup"],"read_only":true},"require_approval":{"always":{"tool_names":["write"],"read_only":false},"never":{"tool_names":["lookup"],"read_only":true}}},{"type":"mcp","server_url":null,"server_description":null,"connector_id":null,"tunnel_id":null,"allowed_callers":null,"defer_loading":null,"allowed_tools":null,"require_approval":null},{"type":"mcp"},{"type":"mcp","allowed_tools":{"tool_names":null,"read_only":null},"require_approval":{"always":null,"never":null}},{"type":"mcp","allowed_tools":{},"require_approval":{}}]"""
        for (async in listOf(false, true)) {
            MockWebServer().use { server ->
                server.enqueue(
                    MockResponse()
                        .withWebSocketUpgrade(
                            object : WebSocketListener() {
                                override fun onOpen(socket: WebSocket, response: Response) {
                                    for (kind in listOf("session.started", "session.updated")) {
                                        socket.send(
                                            """{"type":"$kind","event_id":"event_fixture","session":{"id":"live_fixture","model":"gpt-live-1","status":"active","expires_at":123,"delegation":{"type":"responses","responses":{"model":"model_fixture","tools":$tools}}}}"""
                                        )
                                    }
                                }

                                override fun onClosing(
                                    socket: WebSocket,
                                    code: Int,
                                    reason: String,
                                ) {
                                    socket.close(code, reason)
                                }
                            }
                        )
                )
                OkHttpClient.builder().build().use { http ->
                    val options =
                        ClientOptions.builder()
                            .httpClient(http)
                            .apiKey("fake-live-key")
                            .baseUrl(server.url("/v1").toString())
                            .build()
                    val live =
                        if (async) LiveConnection.connectAsync(options).get(8, TimeUnit.SECONDS)
                        else LiveConnection.connect(options)
                    live.use { connection ->
                        assertThat(server.takeRequest(8, TimeUnit.SECONDS)!!.path)
                            .isEqualTo("/v1/live/sessions")
                        repeat(2) { index ->
                            val event =
                                if (async) connection.receiveAsync().get(8, TimeUnit.SECONDS)
                                else connection.receive()
                            val session =
                                if (index == 0) event.asSessionStarted().session()
                                else event.asSessionUpdated().session()
                            val observed =
                                session.delegation().get().asResponses().responses().tools().get()
                            assertThat(observed).hasSize(5)
                            val tool = observed[0].asTypedMcp()
                            assertThat(tool.serverDescription()).contains("MCP response fixture")
                            assertThat(tool.serverLabel()).contains("fixture")
                            assertThat(tool.serverUrl()).contains("https://example.test/mcp")
                            assertThat(tool.connectorId()).contains("connector_dropbox")
                            assertThat(tool.tunnelId()).contains("tunnel_" + "a".repeat(32))
                            assertThat(tool.allowedCallers().get().map { it.toString() })
                                .containsExactly("direct")
                            assertThat(tool.deferLoading()).contains(false)
                            val filter = tool.allowedTools().get().asMcpToolFilter()
                            assertThat(filter.toolNames().get()).containsExactly("lookup")
                            assertThat(filter.readOnly()).contains(true)
                            val rules = tool.requireApproval().get().asMcpRequireApprovalFilter()
                            assertThat(rules.always().get().toolNames().get())
                                .containsExactly("write")
                            assertThat(rules.always().get().readOnly()).contains(false)
                            assertThat(rules.never().get().toolNames().get())
                                .containsExactly("lookup")
                            assertThat(rules.never().get().readOnly()).contains(true)
                            for (absent in observed.subList(1, 3).map { it.asTypedMcp() }) {
                                assertThat(absent.serverDescription()).isEmpty()
                                assertThat(absent.serverUrl()).isEmpty()
                                assertThat(absent.connectorId()).isEmpty()
                                assertThat(absent.tunnelId()).isEmpty()
                                assertThat(absent.allowedCallers()).isEmpty()
                                assertThat(absent.deferLoading()).isEmpty()
                                assertThat(absent.allowedTools()).isEmpty()
                                assertThat(absent.requireApproval()).isEmpty()
                            }
                            for (nested in observed.subList(3, 5).map { it.asTypedMcp() }) {
                                val nestedFilter = nested.allowedTools().get().asMcpToolFilter()
                                assertThat(nestedFilter.toolNames()).isEmpty()
                                assertThat(nestedFilter.readOnly()).isEmpty()
                                val nestedRules =
                                    nested.requireApproval().get().asMcpRequireApprovalFilter()
                                assertThat(nestedRules.always()).isEmpty()
                                assertThat(nestedRules.never()).isEmpty()
                            }
                        }
                    }
                }
            }
        }
    }
}
