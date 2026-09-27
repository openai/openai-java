package com.openai.client.okhttp

import com.openai.core.http.ResponseWebSocketOptions
import com.openai.models.responses.ResponseStatus
import com.openai.models.responses.ResponsesClientEvent
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable

/** Explicit opt-in; ordinary unit and pull-request tests never use real credentials. */
@EnabledIfEnvironmentVariable(named = "OPENAI_RUN_WEBSOCKET_LIVE", matches = "true")
@Timeout(120)
class ResponsesWebSocketLiveTest {
    @Test
    fun `responses over a real authenticated websocket`() {
        val key = requireNotNull(System.getenv("OPENAI_API_KEY"))
        val model = System.getenv("OPENAI_TEST_MODEL") ?: "gpt-4o-mini"
        val client = OpenAIOkHttpClientAsync.builder().apiKey(key).build()
        try {
            client
                .responses()
                .connect(
                    ResponseWebSocketOptions.builder()
                        .putHeader("X-Client-Context", "java-websocket-integration")
                        .build()
                )
                .get(30, TimeUnit.SECONDS)
                .use { connection ->
                    connection.send(
                        ResponsesClientEvent.ofResponseCreate(
                            ResponsesClientEvent.ResponseCreate.builder()
                                .model(model)
                                .store(false)
                                .input("Reply with the single word hello.")
                                .build()
                        )
                    )
                    val first = connection.finalResponse().get(45, TimeUnit.SECONDS)
                    assertThat(first.status()).contains(ResponseStatus.COMPLETED)
                    assertThat(first.output()).isNotEmpty()
                    connection.send(
                        ResponsesClientEvent.ofResponseCreate(
                            ResponsesClientEvent.ResponseCreate.builder()
                                .model(model)
                                .store(false)
                                .previousResponseId(first.id())
                                .input("Reply with the single word goodbye.")
                                .build()
                        )
                    )
                    val second = connection.finalResponse().get(45, TimeUnit.SECONDS)
                    assertThat(second.status()).contains(ResponseStatus.COMPLETED)
                    assertThat(second.output()).isNotEmpty()
                    assertThat(second.id()).isNotEqualTo(first.id())
                }
        } finally {
            client.close()
        }
    }
}
