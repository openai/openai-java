package com.openai.services.blocking.beta.agents.environments

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.beta.agents.environments.files.FileListParams
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class EnvironmentTokenPaginationTest {
    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun followsOpaqueTokenWithFilters(async: Boolean) {
        val token = "synthetic:token/+="
        val path = "/v1/agents/environments/env_test/files"
        val server = WireMockServer(wireMockConfig().dynamicPort())
        server.start()
        try {
            for (index in 0..1) {
                server.stubFor(
                    get(urlPathEqualTo(path))
                        .withQueryParam("page", if (index == 0) absent() else equalTo(token))
                        .willReturn(
                            okJson(
                                """{
                            "object":"page",
                            "data":[{"object":"agent.environment.file","environment_id":"env_test","path":"/workspace/test/$index.txt","size_bytes":1}],
                            "next":${if (index == 0) "\"$token\"" else "null"},
                            "has_more":${index == 0}
                        }"""
                            )
                        )
                )
            }
            OpenAIOkHttpClient.builder()
                .apiKey("synthetic")
                .baseUrl(server.baseUrl() + "/v1")
                .maxRetries(0)
                .build()
                .let { client ->
                    val params =
                        FileListParams.builder()
                            .environmentId("env_test")
                            .path("/workspace/test")
                            .order(FileListParams.Order.ASC)
                            .limit(1)
                            .putAdditionalHeader("x-pagination-test", "preserved")
                            .build()
                    val paths = mutableListOf<String>()
                    if (async) {
                        client
                            .async()
                            .beta()
                            .agents()
                            .environments()
                            .files()
                            .list(params)
                            .get(10, TimeUnit.SECONDS)
                            .autoPager()
                            .subscribe { file -> paths.add(file.path()) }
                            .onCompleteFuture()
                            .get(10, TimeUnit.SECONDS)
                    } else {
                        client
                            .beta()
                            .agents()
                            .environments()
                            .files()
                            .list(params)
                            .autoPager()
                            .forEach { file -> paths.add(file.path()) }
                    }
                    assertThat(paths)
                        .containsExactly("/workspace/test/0.txt", "/workspace/test/1.txt")
                }
            server.verify(
                2,
                getRequestedFor(urlPathEqualTo(path))
                    .withQueryParam("path", equalTo("/workspace/test"))
                    .withQueryParam("order", equalTo("asc"))
                    .withQueryParam("limit", equalTo("1"))
                    .withQueryParam("after", absent())
                    .withHeader("x-pagination-test", equalTo("preserved"))
                    .withHeader("OpenAI-Beta", equalTo("agents=v1")),
            )
            assertThat(server.allServeEvents).hasSize(2)
        } finally {
            server.stop()
        }
    }
}
