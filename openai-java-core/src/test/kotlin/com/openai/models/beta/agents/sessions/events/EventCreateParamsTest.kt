// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.sessions.events

import com.openai.core.http.Headers
import com.openai.models.beta.agents.AgentBrowserAuthenticationSubmitParam
import com.openai.models.beta.agents.AgentSessionInputParam
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EventCreateParamsTest {

    @Test
    fun create() {
        EventCreateParams.builder()
            .sessionId("session_id")
            .idempotencyKey("x")
            .addEvent(
                AgentSessionInputParam.AgentSessionInputComputerUseApprovalRequestResult.builder()
                    .requestId("request_id")
                    .response(
                        AgentBrowserAuthenticationSubmitParam.builder()
                            .addField(
                                AgentBrowserAuthenticationSubmitParam.Field.builder()
                                    .fieldId("field_id")
                                    .value("value")
                                    .build()
                            )
                            .selectedOption("selected_option")
                            .build()
                    )
                    .build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            EventCreateParams.builder()
                .sessionId("session_id")
                .addEvent(
                    AgentSessionInputParam.AgentSessionInputComputerUseApprovalRequestResult
                        .builder()
                        .requestId("request_id")
                        .agentBrowserAuthenticationSubmitParamResponse(
                            listOf(
                                AgentBrowserAuthenticationSubmitParam.Field.builder()
                                    .fieldId("field_id")
                                    .value("value")
                                    .build()
                            )
                        )
                        .build()
                )
                .build()

        assertThat(params._pathParam(0)).isEqualTo("session_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            EventCreateParams.builder()
                .sessionId("session_id")
                .idempotencyKey("x")
                .addEvent(
                    AgentSessionInputParam.AgentSessionInputComputerUseApprovalRequestResult
                        .builder()
                        .requestId("request_id")
                        .response(
                            AgentBrowserAuthenticationSubmitParam.builder()
                                .addField(
                                    AgentBrowserAuthenticationSubmitParam.Field.builder()
                                        .fieldId("field_id")
                                        .value("value")
                                        .build()
                                )
                                .selectedOption("selected_option")
                                .build()
                        )
                        .build()
                )
                .build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().put("Idempotency-Key", "x").build())
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params =
            EventCreateParams.builder()
                .sessionId("session_id")
                .addEvent(
                    AgentSessionInputParam.AgentSessionInputComputerUseApprovalRequestResult
                        .builder()
                        .requestId("request_id")
                        .agentBrowserAuthenticationSubmitParamResponse(
                            listOf(
                                AgentBrowserAuthenticationSubmitParam.Field.builder()
                                    .fieldId("field_id")
                                    .value("value")
                                    .build()
                            )
                        )
                        .build()
                )
                .build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            EventCreateParams.builder()
                .sessionId("session_id")
                .idempotencyKey("x")
                .addEvent(
                    AgentSessionInputParam.AgentSessionInputComputerUseApprovalRequestResult
                        .builder()
                        .requestId("request_id")
                        .response(
                            AgentBrowserAuthenticationSubmitParam.builder()
                                .addField(
                                    AgentBrowserAuthenticationSubmitParam.Field.builder()
                                        .fieldId("field_id")
                                        .value("value")
                                        .build()
                                )
                                .selectedOption("selected_option")
                                .build()
                        )
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.events())
            .containsExactly(
                AgentSessionInputParam.ofAgentSessionInputComputerUseApprovalRequestResult(
                    AgentSessionInputParam.AgentSessionInputComputerUseApprovalRequestResult
                        .builder()
                        .requestId("request_id")
                        .response(
                            AgentBrowserAuthenticationSubmitParam.builder()
                                .addField(
                                    AgentBrowserAuthenticationSubmitParam.Field.builder()
                                        .fieldId("field_id")
                                        .value("value")
                                        .build()
                                )
                                .selectedOption("selected_option")
                                .build()
                        )
                        .build()
                )
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            EventCreateParams.builder()
                .sessionId("session_id")
                .addEvent(
                    AgentSessionInputParam.AgentSessionInputComputerUseApprovalRequestResult
                        .builder()
                        .requestId("request_id")
                        .agentBrowserAuthenticationSubmitParamResponse(
                            listOf(
                                AgentBrowserAuthenticationSubmitParam.Field.builder()
                                    .fieldId("field_id")
                                    .value("value")
                                    .build()
                            )
                        )
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.events())
            .containsExactly(
                AgentSessionInputParam.ofAgentSessionInputComputerUseApprovalRequestResult(
                    AgentSessionInputParam.AgentSessionInputComputerUseApprovalRequestResult
                        .builder()
                        .requestId("request_id")
                        .agentBrowserAuthenticationSubmitParamResponse(
                            listOf(
                                AgentBrowserAuthenticationSubmitParam.Field.builder()
                                    .fieldId("field_id")
                                    .value("value")
                                    .build()
                            )
                        )
                        .build()
                )
            )
    }
}
