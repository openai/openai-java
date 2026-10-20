package com.openai.services.blocking.beta.agents.environments

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig
import com.github.tomakehurst.wiremock.stubbing.Scenario.STARTED
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.beta.agents.environments.EnvironmentCreateParams
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class EnvironmentCreateRetryTest {
    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun retriesKeepOneKeyPerLogicalCreate(async: Boolean) {
        val server = WireMockServer(wireMockConfig().dynamicPort())
        server.start()
        try {
            server.stubFor(
                post(urlEqualTo("/agents/environments"))
                    .inScenario("retry")
                    .whenScenarioStateIs(STARTED)
                    .willReturn(aResponse().withStatus(500).withHeader("retry-after", "0"))
                    .willSetStateTo("retry")
            )
            server.stubFor(
                post(urlEqualTo("/agents/environments"))
                    .inScenario("retry")
                    .whenScenarioStateIs("retry")
                    .willReturn(okJson("""{"id":"env_test","object":"agent.environment"}"""))
                    .willSetStateTo(STARTED)
            )
            val client =
                OpenAIOkHttpClient.builder()
                    .apiKey("synthetic")
                    .baseUrl(server.baseUrl())
                    .maxRetries(1)
                    .build()
            try {
                for (explicit in listOf(false, false, true)) {
                    val params =
                        EnvironmentCreateParams.builder()
                            .environment(EnvironmentCreateParams.Environment.builder().build())
                            .apply { if (explicit) idempotencyKey("caller-key") }
                            .build()
                    if (async)
                        client
                            .async()
                            .beta()
                            .agents()
                            .environments()
                            .create(params)
                            .get(30, TimeUnit.SECONDS)
                    else client.beta().agents().environments().create(params)
                }
                val requests = server.findAll(postRequestedFor(urlEqualTo("/agents/environments")))
                assertThat(requests).hasSize(6)
                val keys = requests.map { it.getHeader("Idempotency-Key") }
                assertThat(keys).allSatisfy { assertThat(it).isNotBlank() }
                assertThat(keys[0]).isEqualTo(keys[1]).isNotEqualTo(keys[2])
                assertThat(keys[2]).isEqualTo(keys[3])
                assertThat(keys.takeLast(2)).containsOnly("caller-key")
            } finally {
                client.close()
            }
        } finally {
            server.stop()
        }
    }
}
