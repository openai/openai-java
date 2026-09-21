package com.openai.services

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig
import com.openai.client.OpenAIClient
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.jsonMapper
import com.openai.models.safety.cases.CaseRetrieveParams
import com.openai.models.safety.cases.SafetyCase
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class SafetyCasesTest {
    private val server = WireMockServer(wireMockConfig().dynamicPort())
    private lateinit var client: OpenAIClient

    @BeforeEach
    fun setUp() {
        server.start()
        client = clientBuilder().build()
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
    fun retrievesKnownNoticesWithNullableReasonAndOrdinaryAuth(async: Boolean) {
        val params =
            CaseRetrieveParams.builder()
                .id(CASE_ID)
                .putAdditionalHeader("X-Case-Trace", "caller-owned")
                .putAdditionalQueryParam("trace", "contract")
                .build()
        for (notice in listOf("warning", "deactivation")) {
            for (reason in listOf(null, "synthetic reason")) {
                val payload = safetyCase(notice, reason)
                server.stubFor(
                    get(urlEqualTo(CASE_PATH + "?trace=contract")).willReturn(okJson(payload))
                )

                val result = retrieve(params, async)

                result.validate()
                assertThat(result.id()).isEqualTo(CASE_ID)
                assertThat(result.createdAt()).isEqualTo(123L)
                assertThat(result.entityIdentifier()).isEqualTo("synthetic-entity")
                assertThat(result.reason().orElse(null)).isEqualTo(reason)
                assertThat(result.notice().type().asString()).isEqualTo(notice)
                assertThat(jsonMapper().readTree(jsonMapper().writeValueAsString(result)))
                    .isEqualTo(jsonMapper().readTree(payload))
            }
        }
        server.verify(
            4,
            getRequestedFor(urlEqualTo(CASE_PATH + "?trace=contract"))
                .withHeader("Authorization", equalTo(PROJECT_AUTH))
                .withHeader("X-Case-Trace", equalTo("caller-owned"))
                .withRequestBody(absent()),
        )
        assertThat(server.allServeEvents).hasSize(4)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun preservesFutureNoticeAndFields(async: Boolean) {
        val payload = safetyCase("future-notice", null)
        server.stubFor(get(urlEqualTo(CASE_PATH)).willReturn(okJson(payload)))

        val result = retrieve(CaseRetrieveParams.builder().id(CASE_ID).build(), async)

        assertThat(result.notice().type().asString()).isEqualTo("future-notice")
        assertThat(jsonMapper().readTree(jsonMapper().writeValueAsString(result)))
            .isEqualTo(jsonMapper().readTree(payload))
        server.verify(
            1,
            getRequestedFor(urlEqualTo(CASE_PATH))
                .withHeader("Authorization", equalTo(PROJECT_AUTH))
                .withRequestBody(absent()),
        )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun neverUsesAdminKeyAsOrdinaryKeyFallback(async: Boolean) {
        val adminOnly = clientBuilder().apiKey(null as String?).build()
        try {
            assertThatThrownBy {
                    if (async) {
                        adminOnly
                            .async()
                            .safety()
                            .cases()
                            .retrieve(CASE_ID)
                            .get(TIMEOUT_SECONDS, TimeUnit.SECONDS)
                    } else {
                        adminOnly.safety().cases().retrieve(CASE_ID)
                    }
                }
                .isInstanceOf(IllegalStateException::class.java)
                .hasMessageContaining("requires apiKey")
            assertThat(server.allServeEvents).isEmpty()
        } finally {
            adminOnly.close()
        }
    }

    private fun retrieve(params: CaseRetrieveParams, async: Boolean): SafetyCase =
        if (async) {
            client.async().safety().cases().retrieve(params).get(TIMEOUT_SECONDS, TimeUnit.SECONDS)
        } else {
            client.safety().cases().retrieve(params)
        }

    private fun clientBuilder() =
        OpenAIOkHttpClient.builder()
            .baseUrl(server.baseUrl() + "/v1")
            .apiKey("fake-project-key")
            .adminApiKey("fake-admin-key")
            .maxRetries(0)

    private fun safetyCase(notice: String, reason: String?) =
        jsonMapper()
            .writeValueAsString(
                mapOf(
                    "id" to CASE_ID,
                    "object" to "safety.case",
                    "created_at" to 123,
                    "entity_identifier" to "synthetic-entity",
                    "reason" to reason,
                    "notice" to mapOf("type" to notice, "future_notice_field" to true),
                    "future_case_field" to true,
                )
            )

    private companion object {
        const val CASE_ID = "case/with ?#%"
        const val CASE_PATH = "/v1/safety/cases/case%2Fwith%20%3F%23%25"
        const val PROJECT_AUTH = "Bearer fake-project-key"
        const val TIMEOUT_SECONDS = 30L
    }
}
