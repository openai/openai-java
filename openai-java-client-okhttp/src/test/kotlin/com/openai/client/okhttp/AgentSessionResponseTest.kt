package com.openai.client.okhttp

import com.openai.client.OpenAIClient
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.beta.agents.AgentSession
import com.openai.models.beta.agents.sessions.SessionCreateParams
import com.openai.models.beta.agents.sessions.SessionUpdateParams
import com.openai.models.beta.agents.sessions.turns.TurnRetrieveParams
import java.util.Optional
import java.util.concurrent.TimeUnit
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class AgentSessionResponseTest {
    @Test
    fun preservesSessionBuilderWithoutSpendControl() {
        val original = jsonMapper().readValue(sessionJson(), AgentSession::class.java)
        val session =
            AgentSession.builder()
                .agent(original.agent())
                .createdAt(original.createdAt())
                .environment(original.environment())
                .id(original.id())
                .lastActiveAt(original.lastActiveAt())
                .metadata(original.metadata())
                .requiredActions(original.requiredActions())
                .status(original.status())
                .vaultIds(original.vaultIds())
                .build()
                .validate()

        assertThat(session.spendControl().limit()).isEmpty()
        assertThat(session.spendControl().consumed()).isEmpty()
        assertThrows<OpenAIInvalidDataException> {
            session.toBuilder().spendControl(JsonMissing.of()).build().validate()
        }
    }

    @Test
    fun readsRequiredNullableSpendControl() = withClient { client, server ->
        for ((limit, consumed) in listOf(12345L to 6789L, null to 1000L, null to null)) {
            server.enqueue(
                jsonResponse(
                    sessionJson(spendControl = """{"limit":$limit,"consumed":$consumed}""")
                )
            )
            val session = client.beta().agents().sessions().retrieve("session-probe")
            session.validate()
            assertThat(session.spendControl().limit()).isEqualTo(Optional.ofNullable(limit))
            assertThat(session.spendControl().consumed()).isEqualTo(Optional.ofNullable(consumed))
            assertThat(server.takeRequest(1, TimeUnit.SECONDS)?.path)
                .isEqualTo("/agents/sessions/session-probe")
        }
    }

    @Test
    fun rejectsMissingSpendControlKeys() = withClient { client, server ->
        for (spendControl in listOf("{}", """{"limit":null}""", """{"consumed":null}""")) {
            server.enqueue(jsonResponse(sessionJson(spendControl = spendControl)))
            val session = client.beta().agents().sessions().retrieve("session-probe")
            assertThrows<OpenAIInvalidDataException> { session.validate() }
            server.takeRequest(1, TimeUnit.SECONDS)
        }
        server.enqueue(
            jsonResponse(
                sessionJson().replace("\"spend_control\": {\"limit\":null,\"consumed\":null},", "")
            )
        )
        val session = client.beta().agents().sessions().retrieve("session-probe")
        assertThrows<OpenAIInvalidDataException> { session.validate() }
        server.takeRequest(1, TimeUnit.SECONDS)
    }

    @Test
    fun serializesSpendControlOnCreateAndUpdate() = withClient { client, server ->
        val mapper = jsonMapper()
        for (spendControl in
            listOf(
                JsonValue.from(mapOf("limit" to 43210L)),
                JsonValue.from(mapOf("limit" to null)),
                JsonValue.from(null),
                JsonMissing.of(),
            )) {
            server.enqueue(jsonResponse(sessionJson()))
            client
                .beta()
                .agents()
                .sessions()
                .create(
                    SessionCreateParams.builder()
                        .agentId("agent-probe")
                        .environmentNone()
                        .input("Question")
                        .spendControl(spendControl)
                        .build()
                )
            val create = server.takeRequest(1, TimeUnit.SECONDS)!!
            assertThat(create.method).isEqualTo("POST")
            assertThat(create.path).isEqualTo("/agents/sessions")
            val createBody = mapper.readTree(create.body.readUtf8())
            if (spendControl.isMissing()) assertThat(createBody.has("spend_control")).isFalse()
            else
                assertThat(createBody.path("spend_control"))
                    .isEqualTo(mapper.readTree(mapper.writeValueAsString(spendControl)))

            server.enqueue(jsonResponse(sessionJson()))
            client
                .beta()
                .agents()
                .sessions()
                .update(
                    SessionUpdateParams.builder()
                        .sessionId("session-probe")
                        .spendControl(spendControl)
                        .build()
                )
            val update = server.takeRequest(1, TimeUnit.SECONDS)!!
            assertThat(update.method).isEqualTo("POST")
            assertThat(update.path).isEqualTo("/agents/sessions/session-probe")
            val updateBody = mapper.readTree(update.body.readUtf8())
            if (spendControl.isMissing()) assertThat(updateBody.has("spend_control")).isFalse()
            else
                assertThat(updateBody.path("spend_control"))
                    .isEqualTo(mapper.readTree(mapper.writeValueAsString(spendControl)))
        }
    }

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

    private fun sessionJson(
        cacheField: String = "",
        requiredActions: String = "[]",
        spendControl: String = """{"limit":null,"consumed":null}""",
    ) =
        """
        {
          "metadata": {},
          "spend_control": $spendControl,
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
