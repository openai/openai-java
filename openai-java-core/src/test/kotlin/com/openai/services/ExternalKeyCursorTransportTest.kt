package com.openai.services

import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.reset
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.client.okhttp.OpenAIOkHttpClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.parallel.ResourceLock
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ExternalKeyCursorTransportTest {
    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun nullableCursorsSurvivePublicListMethod(async: Boolean, server: WireMockRuntimeInfo) {
        for (populated in listOf(true, false)) {
            reset()
            val first = if (populated) "\"ek_first_synthetic\"" else "null"
            val last = if (populated) "\"ek_last_synthetic\"" else "null"
            val data =
                if (populated) {
                    listOf("ek_first_synthetic", "ek_last_synthetic").joinToString(
                        prefix = "[",
                        postfix = "]",
                    ) { id ->
                        """{"object":"organization.external_key","id":"$id","type":"aws","name":"synthetic key","api_project_ids":[],"workspace_id":"org_synthetic","created_at":0}"""
                    }
                } else "[]"
            stubFor(
                get(urlPathEqualTo("/organization/external_keys"))
                    .willReturn(
                        okJson(
                            """{"object":"list","data":$data,"has_more":false,"first_id":$first,"last_id":$last}"""
                        )
                    )
            )
            val client =
                OpenAIOkHttpClient.builder()
                    .baseUrl(server.httpBaseUrl)
                    .apiKey("synthetic-regular-key")
                    .adminApiKey("synthetic-admin-key")
                    .responseValidation(true)
                    .build()
            try {
                val response =
                    if (async) {
                        client
                            .async()
                            .admin()
                            .organization()
                            .externalKeys()
                            .list()
                            .join()
                            .response()
                    } else {
                        client.admin().organization().externalKeys().list().response()
                    }
                assertThat(response.firstId().orElse(null))
                    .isEqualTo(if (populated) "ek_first_synthetic" else null)
                assertThat(response.lastId().orElse(null))
                    .isEqualTo(if (populated) "ek_last_synthetic" else null)
                assertThat(response.hasMore()).isFalse()
                verify(
                    1,
                    getRequestedFor(urlPathEqualTo("/organization/external_keys"))
                        .withHeader("Authorization", equalTo("Bearer synthetic-admin-key")),
                )
            } finally {
                client.close()
            }
        }
    }
}
