package com.openai.client.okhttp

import com.openai.client.OpenAIClient
import com.openai.core.JsonValue
import com.openai.models.beta.agents.sessions.turns.TurnRetrieveParams
import java.util.concurrent.TimeUnit
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentSessionResponseTest {
    @Test
    fun readsPromptCacheOptionsOnSessionsAndTurns() = withClient { client, server ->
        for ((cacheField, expectedTtl) in
            listOf(
                """, "prompt_cache_options": {"ttl": "12h"}""" to "12h",
                """, "prompt_cache_options": null""" to null,
                "" to null,
            )) {
            server.enqueue(jsonResponse(sessionJson(cacheField)))
            val session = client.beta().agents().sessions().retrieve("session-probe")
            session.validate()
            assertThat(session.promptCacheOptions().map { it.ttl().asString() }.orElse(null))
                .isEqualTo(expectedTtl)
            assertThat(server.takeRequest(1, TimeUnit.SECONDS)?.path)
                .isEqualTo("/agents/sessions/session-probe")

            server.enqueue(
                jsonResponse(
                    """
                    {
                      "id": "turn-probe",
                      "object": "agent.session.turn",
                      "session_id": "session-probe",
                      "agent_id": "agent-probe",
                      "subagent_id": null,
                      "status": "queued",
                      "created_at": 0,
                      "started_at": null,
                      "completed_at": null,
                      "error": null,
                      "usage": null
                      $cacheField
                    }
                    """
                        .trimIndent()
                )
            )
            val turn =
                client
                    .beta()
                    .agents()
                    .sessions()
                    .turns()
                    .retrieve(
                        "turn-probe",
                        TurnRetrieveParams.builder().sessionId("session-probe").build(),
                    )
            turn.validate()
            assertThat(turn.promptCacheOptions().map { it.ttl().asString() }.orElse(null))
                .isEqualTo(expectedTtl)
            assertThat(server.takeRequest(1, TimeUnit.SECONDS)?.path)
                .isEqualTo("/agents/sessions/session-probe/turns/turn-probe")
        }
    }

    @Test
    fun readsMcpApprovalRequestNameAndArguments() = withClient { client, server ->
        for ((fields, expectedName, expectedArguments) in
            listOf(
                Triple(
                    """"name": "probe-mcp-tool", "arguments": {"probe": "argument-value"}""",
                    "probe-mcp-tool",
                    JsonValue.from(mapOf("probe" to "argument-value")),
                ),
                Triple(""""name": null, "arguments": null""", null, JsonValue.from(null)),
            )) {
            val actions =
                """
                [{
                  "type": "mcp_approval_request",
                  "turn_id": "turn-probe",
                  "request_id": "request-probe",
                  "request": {
                    "type": "mcp_tool_call",
                    "server_label": "server-probe",
                    "message": "Approval required",
                    $fields
                  }
                }]
                """
                    .trimIndent()
            server.enqueue(jsonResponse(sessionJson(requiredActions = actions)))
            val session = client.beta().agents().sessions().retrieve("session-probe")
            session.validate()
            val request = session.requiredActions().single().asMcpApprovalRequest().request()
            assertThat(request.name().orElse(null)).isEqualTo(expectedName)
            assertThat(request._arguments()).isEqualTo(expectedArguments)
            assertThat(server.takeRequest(1, TimeUnit.SECONDS)?.path)
                .isEqualTo("/agents/sessions/session-probe")
        }
    }

    private fun sessionJson(cacheField: String = "", requiredActions: String = "[]") =
        """
        {
          "metadata": {},
          "id": "session-probe",
          "object": "agent.session",
          "created_at": 0,
          "last_active_at": 0,
          "status": "idle",
          "required_actions": $requiredActions,
          "error": null,
          "agent": {
            "id": "agent-probe",
            "name": null,
            "model": "model-probe",
            "reasoning": {"effort": null, "summary": null},
            "text": {"format": {"type": "text"}, "verbosity": "low"},
            "service_tier": "auto",
            "instructions": null,
            "tools": [],
            "multi_agent": {"enabled": false, "max_concurrent_subagents": null}
          },
          "environment": {"type": "none"},
          "vault_ids": [],
          "usage": null
          $cacheField
        }
        """
            .trimIndent()

    private fun jsonResponse(body: String) =
        MockResponse().setHeader("Content-Type", "application/json").setBody(body)

    private fun withClient(test: (OpenAIClient, MockWebServer) -> Unit) {
        MockWebServer().use { server ->
            val client =
                OpenAIOkHttpClient.builder()
                    .apiKey("test-key")
                    .baseUrl(server.url("/").toString())
                    .maxRetries(0)
                    .build()
            try {
                test(client, server)
            } finally {
                client.close()
            }
        }
    }
}
