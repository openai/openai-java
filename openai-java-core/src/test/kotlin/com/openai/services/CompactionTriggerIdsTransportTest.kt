package com.openai.services

import com.openai.client.OpenAIClientImpl
import com.openai.core.ClientOptions
import com.openai.core.JsonField
import com.openai.core.RequestOptions
import com.openai.core.http.Headers
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.jsonMapper
import com.openai.models.beta.responses.BetaResponseInputItem
import com.openai.models.beta.responses.ResponseCreateParams
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.util.concurrent.CompletableFuture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CompactionTriggerIdsTransportTest {
    @Test
    fun betaIdsSurviveActualResponseRetrieval() {
        for (wire in listOf(null, "null", "\"\"", "\"msg_transport_compat\"")) {
            val field = wire?.let { ",\"id\":$it" } ?: ""
            val payload =
                """{"id":"resp_compat","object":"response","instructions":[{"type":"compaction_trigger"$field,"agent":{"agent_name":"assistant"}}],"output":[]}"""
            val transport = FakeHttpClient(payload)
            val options =
                ClientOptions.builder()
                    .httpClient(transport)
                    .baseUrl("https://example.invalid/v1")
                    .apiKey("synthetic-key")
                    .build()
            try {
                val client = OpenAIClientImpl(options)
                val trigger =
                    client
                        .beta()
                        .responses()
                        .retrieve("resp_compat")
                        .instructions()
                        .get()
                        .asInputItemList()
                        .single()
                        .asCompactionTrigger()
                val expected =
                    when (wire) {
                        null,
                        "null" -> null
                        "\"\"" -> ""
                        else -> "msg_transport_compat"
                    }
                assertThat(trigger.id().orElse(null)).isEqualTo(expected)
                assertThat(trigger._id().isMissing()).isEqualTo(wire == null)
                assertThat(trigger._id().isNull()).isEqualTo(wire == "null")
                assertThat(trigger.agent().get().agentName()).isEqualTo("assistant")
                assertThat(transport.requests).hasSize(1)
                assertThat(transport.requests.single().url())
                    .isEqualTo("https://example.invalid/v1/responses/resp_compat?beta=true")
            } finally {
                options.close()
            }
        }
    }

    @Test
    fun betaConstructionPreservesExistingBuilderAndWireValues() {
        val mapper = jsonMapper()
        val legacy = BetaResponseInputItem.CompactionTrigger.builder().build()
        assertThat(mapper.readTree(mapper.writeValueAsString(legacy)).has("id")).isFalse()
        for (id in listOf(null, "", "msg_request_compat")) {
            val trigger =
                BetaResponseInputItem.CompactionTrigger.builder()
                    .id(JsonField.ofNullable(id))
                    .agent(
                        BetaResponseInputItem.CompactionTrigger.Agent.builder()
                            .agentName("assistant")
                            .build()
                    )
                    .build()
            val json = mapper.readTree(mapper.writeValueAsString(trigger))
            assertThat(json.get("type").asText()).isEqualTo("compaction_trigger")
            assertThat(json.get("id")).isEqualTo(mapper.readTree(mapper.writeValueAsString(id)))
            assertThat(json.get("agent").get("agent_name").asText()).isEqualTo("assistant")
            val transport =
                FakeHttpClient("""{"id":"resp_compat","object":"response","output":[]}""")
            val options =
                ClientOptions.builder()
                    .httpClient(transport)
                    .baseUrl("https://example.invalid/v1")
                    .apiKey("synthetic-key")
                    .build()
            try {
                OpenAIClientImpl(options)
                    .beta()
                    .responses()
                    .create(
                        ResponseCreateParams.builder()
                            .model("gpt-4o")
                            .inputOfBetaResponse(
                                listOf(BetaResponseInputItem.ofCompactionTrigger(trigger))
                            )
                            .build()
                    )
                assertThat(transport.requests.single().url())
                    .isEqualTo("https://example.invalid/v1/responses?beta=true")
                assertThat(mapper.readTree(transport.requestBodies.single()).get("input").get(0))
                    .isEqualTo(json)
            } finally {
                options.close()
            }
        }
    }

    private class FakeHttpClient(private val json: String) : HttpClient {
        val requests = mutableListOf<HttpRequest>()
        val requestBodies = mutableListOf<String>()

        override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
            requests.add(request)
            request.body?.let { body ->
                val bytes = ByteArrayOutputStream()
                body.writeTo(bytes)
                requestBodies.add(bytes.toString("UTF-8"))
            }
            return object : HttpResponse {
                override fun statusCode() = 200

                override fun headers() =
                    Headers.builder().put("Content-Type", "application/json").build()

                override fun body(): InputStream = json.byteInputStream()

                override fun close() {}
            }
        }

        override fun executeAsync(
            request: HttpRequest,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> =
            CompletableFuture.completedFuture(execute(request, requestOptions))

        override fun close() {}
    }
}
