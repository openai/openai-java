package com.openai.core

import com.openai.client.OpenAIClientImpl
import com.openai.core.http.Headers
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.models.beta.agents.automations.invocations.InvocationRetrieveParams
import java.io.ByteArrayInputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.argumentCaptor
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

internal class AutomationsTransportTest {
    @Test
    fun invocationNullableValuesSurviveTransport() {
        checkInvocation(false)
    }

    @Test
    fun invocationExplicitNullsSurviveTransport() {
        checkInvocation(true)
    }

    private fun checkInvocation(nulls: Boolean) {
        val nullableFields =
            if (nulls) {
                """"scheduled_at":null,"session_id":null,"skip_reason":null,"error":null"""
            } else {
                """"scheduled_at":1700000123,"session_id":"sess_preserved","skip_reason":"pending_delivery","error":{"code":"synthetic_failure","message":"distinctive explanation"}"""
            }
        val body =
            """{"id":"inv_test","automation_id":"auto_test","object":"agent.automation.invocation","created_at":1700000001,"status":"failed","source":{"type":"manual"},$nullableFields}"""
        val transport = mock<HttpClient>()
        val response = mock<HttpResponse>()
        whenever(response.statusCode()).thenReturn(200)
        whenever(response.headers())
            .thenReturn(Headers.builder().put("Content-Type", "application/json").build())
        whenever(response.body()).thenReturn(ByteArrayInputStream(body.toByteArray()))
        whenever(transport.execute(any(), any())).thenReturn(response)
        val client =
            OpenAIClientImpl(
                ClientOptions.builder()
                    .httpClient(transport)
                    .baseUrl("https://example.test")
                    .apiKey("test-key")
                    .build()
            )
        try {
            val invocation =
                client
                    .beta()
                    .agents()
                    .automations()
                    .invocations()
                    .retrieve(
                        InvocationRetrieveParams.builder()
                            .automationId("auto_test")
                            .invocationId("inv_test")
                            .build()
                    )
            if (nulls) {
                assertThat(invocation._scheduledAt().isNull()).isTrue()
                assertThat(invocation._sessionId().isNull()).isTrue()
                assertThat(invocation._skipReason().isNull()).isTrue()
                assertThat(invocation._error().isNull()).isTrue()
            } else {
                assertThat(invocation.scheduledAt()).contains(1700000123L)
                assertThat(invocation.sessionId()).contains("sess_preserved")
                assertThat(invocation.skipReason().get().toString()).isEqualTo("pending_delivery")
                assertThat(invocation.error().get().codeOrThrow()).isEqualTo("synthetic_failure")
                assertThat(invocation.error().get().messageOrThrow())
                    .isEqualTo("distinctive explanation")
            }
            val request = argumentCaptor<HttpRequest>()
            verify(transport).execute(request.capture(), any())
            assertThat(request.firstValue.method).isEqualTo(HttpMethod.GET)
            assertThat(request.firstValue.url())
                .isEqualTo("https://example.test/agents/automations/auto_test/invocations/inv_test")
        } finally {
            client.close()
        }
    }
}
