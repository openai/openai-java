package com.openai.services

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig
import com.openai.client.OpenAIClient
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.jsonMapper
import com.openai.models.admin.organization.usage.UsageCompletionsParams
import com.openai.models.admin.organization.usage.UsageDecisionsParams
import java.util.Optional
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class UsageCacheWriteTest {
    private val server = WireMockServer(wireMockConfig().dynamicPort())
    private lateinit var client: OpenAIClient

    @BeforeEach
    fun setUp() {
        server.start()
        client =
            OpenAIOkHttpClient.builder()
                .baseUrl(server.baseUrl())
                .apiKey("fake-project-key")
                .adminApiKey("fake-admin-key")
                .maxRetries(0)
                .build()
    }

    @AfterEach
    fun tearDown() {
        try {
            client.close()
        } finally {
            server.stop()
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun cacheWriteCountersSurviveTransport(async: Boolean) {
        for (endpoint in listOf("completions", "decisions")) {
            for (value in listOf("73", "0", "null", null)) {
                server.resetAll()
                val row =
                    mutableMapOf<String, Any?>(
                        "object" to "organization.usage.$endpoint.result",
                        "input_tokens" to 200,
                        "output_tokens" to 20,
                        "num_model_requests" to 1,
                        "input_cache_write_tokens" to 17,
                        "input_cache_write_12h_tokens" to 19,
                    )
                if (value != null) row["input_cache_write_30m_tokens"] = value.toLongOrNull()
                val payload =
                    jsonMapper()
                        .writeValueAsString(
                            mapOf(
                                "object" to "page",
                                "data" to
                                    listOf(
                                        mapOf(
                                            "object" to "bucket",
                                            "start_time" to 0,
                                            "end_time" to 60,
                                            "results" to listOf(row),
                                        )
                                    ),
                                "has_more" to false,
                                "next_page" to null,
                            )
                        )
                val path = "/organization/usage/$endpoint?start_time=0"
                server.stubFor(get(urlEqualTo(path)).willReturn(okJson(payload)))
                val expected = value?.toLongOrNull()
                if (endpoint == "completions") {
                    val params = UsageCompletionsParams.builder().startTime(0L).build()
                    val response =
                        if (async)
                            client
                                .async()
                                .admin()
                                .organization()
                                .usage()
                                .completions(params)
                                .get(10, TimeUnit.SECONDS)
                        else client.admin().organization().usage().completions(params)
                    response.validate()
                    val result = response.data()[0].results()[0].asOrganizationUsageCompletions()
                    assertThat(result.inputCacheWrite30mTokens())
                        .isEqualTo(Optional.ofNullable(expected))
                    assertThat(result.inputCacheWriteTokens()).contains(17L)
                    assertThat(result.inputCacheWrite12hTokens()).contains(19L)
                } else {
                    val params = UsageDecisionsParams.builder().startTime(0L).build()
                    val response =
                        if (async)
                            client
                                .async()
                                .admin()
                                .organization()
                                .usage()
                                .decisions(params)
                                .get(10, TimeUnit.SECONDS)
                        else client.admin().organization().usage().decisions(params)
                    response.validate()
                    val result = response.data()[0].results()[0]
                    assertThat(result.inputCacheWrite30mTokens())
                        .isEqualTo(Optional.ofNullable(expected))
                    assertThat(result.inputCacheWriteTokens()).contains(17L)
                    assertThat(result.inputCacheWrite12hTokens()).contains(19L)
                }
                server.verify(1, getRequestedFor(urlEqualTo(path)))
                assertThat(server.allServeEvents).hasSize(1)
            }
        }
    }
}
