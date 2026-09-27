// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.core

import com.openai.azure.AzureOpenAIServiceVersion
import com.openai.azure.AzureUrlPathMode
import com.openai.azure.credential.AzureApiKeyCredential
import com.openai.client.OpenAIClientImpl
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpRequestAuthenticator
import java.util.Optional
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.kotlin.mock

internal class DataResidencyContractTest {
    private val httpClient = mock<HttpClient>()

    private fun builder() = ClientOptions.builder().httpClient(httpClient).apiKey("test-api-key")

    @Test
    fun mappings() {
        val expected =
            mapOf(
                DataResidency.GLOBAL to "https://api.openai.com/v1",
                DataResidency.US to "https://us.api.openai.com/v1",
                DataResidency.EU to "https://eu.api.openai.com/v1",
                DataResidency.AE to "https://ae.api.openai.com/v1",
            )
        expected.forEach { (residency, url) ->
            assertThat(builder().dataResidency(residency).build().baseUrl()).isEqualTo(url)
            assertThat(DataResidency.of(residency.value())).isEqualTo(residency)
        }
        for (value in listOf("", "other", "GLOBAL")) {
            assertThrows<IllegalArgumentException> { DataResidency.of(value) }
        }
    }

    @Test
    fun explicitUrlConflictsInEitherOrder() {
        for (initial in listOf(builder(), builder().build().toBuilder())) {
            val thrown =
                assertThrows<IllegalArgumentException> {
                    initial.baseUrl("https://example.com/v1").dataResidency(DataResidency.EU)
                }
            assertThat(thrown.message).contains("mutually exclusive")
        }
        for (initial in listOf(builder(), builder().build().toBuilder())) {
            val thrown =
                assertThrows<IllegalArgumentException> {
                    initial.dataResidency(DataResidency.EU).baseUrl("https://example.com/v1")
                }
            assertThat(thrown.message).contains("mutually exclusive")
        }
    }

    @Test
    fun explicitNullUrlStillConflictsInEitherOrder() {
        assertThrows<IllegalArgumentException> {
            builder().baseUrl(null as String?).dataResidency(DataResidency.EU)
        }
        assertThrows<IllegalArgumentException> {
            builder().dataResidency(DataResidency.EU).baseUrl(null as String?)
        }
    }

    @Test
    fun copiesOnlyRetainTheResolvedUrl() {
        val original = builder().baseUrl("https://example.com/v1").build()
        val eu = original.toBuilder().dataResidency(DataResidency.EU).build()
        val us = eu.toBuilder().dataResidency(DataResidency.US).build()
        val global = us.toBuilder().dataResidency(DataResidency.GLOBAL).build()
        assertThat(original.baseUrl()).isEqualTo("https://example.com/v1")
        assertThat(eu.baseUrl()).isEqualTo("https://eu.api.openai.com/v1")
        assertThat(us.baseUrl()).isEqualTo("https://us.api.openai.com/v1")
        assertThat(global.baseUrl()).isEqualTo("https://api.openai.com/v1")
        assertThat(eu.toBuilder().baseUrl("https://other.example/v1").build().baseUrl())
            .isEqualTo("https://other.example/v1")
        assertThat(eu.toBuilder().dataResidency(null as DataResidency?).build().baseUrl())
            .isEqualTo(eu.baseUrl())
        assertThat(eu.toBuilder().dataResidency(Optional.empty()).build().baseUrl())
            .isEqualTo(eu.baseUrl())
        assertThat(
                builder()
                    .dataResidency(null as DataResidency?)
                    .baseUrl("https://example.com")
                    .build()
                    .baseUrl()
            )
            .isEqualTo("https://example.com")
    }

    @Test
    fun environmentUrlIsInheritedAndDoesNotOverrideResidency() {
        withBaseUrlProperty("https://example.com/v1") {
            assertThat(builder().fromEnv().dataResidency(DataResidency.EU).build().baseUrl())
                .isEqualTo("https://eu.api.openai.com/v1")
            assertThat(builder().dataResidency(DataResidency.EU).fromEnv().build().baseUrl())
                .isEqualTo("https://eu.api.openai.com/v1")
            assertThrows<IllegalArgumentException> {
                builder().baseUrl("https://other.example").fromEnv().dataResidency(DataResidency.EU)
            }
        }
    }

    @Test
    fun rejectsThirdPartyProviderConfiguration() {
        val authenticator =
            object : HttpRequestAuthenticator {
                override fun authenticate(request: HttpRequest): HttpRequest = request
            }
        val providers =
            listOf<(ClientOptions.Builder) -> Unit>(
                { it.credential(AzureApiKeyCredential.create("test-azure-key")) },
                { it.azureServiceVersion(AzureOpenAIServiceVersion.latestStableVersion()) },
                { it.azureUrlPathMode(AzureUrlPathMode.UNIFIED) },
                { it.apiKey(null as String?).httpRequestAuthenticator(authenticator) },
            )
        for (provider in providers) {
            for (first in listOf(true, false)) {
                val options = builder()
                if (first) options.dataResidency(DataResidency.EU)
                provider(options)
                if (!first) options.dataResidency(DataResidency.EU)
                val thrown = assertThrows<IllegalArgumentException> { options.build() }
                assertThat(thrown.message).contains("third-party provider")
            }
        }
        val azure = builder().baseUrl("https://example.openai.azure.com/openai/v1").build()
        assertThrows<IllegalArgumentException> {
            azure.toBuilder().dataResidency(DataResidency.EU).build()
        }
        val bedrock =
            builder().apiKey(null as String?).httpRequestAuthenticator(authenticator).build()
        assertThrows<IllegalArgumentException> {
            bedrock.toBuilder().dataResidency(DataResidency.EU).build()
        }
        withBaseUrlProperty("https://example.openai.azure.com/openai/v1") {
            assertThrows<IllegalArgumentException> {
                builder().fromEnv().dataResidency(DataResidency.EU).build()
            }
            assertThat(builder().dataResidency(DataResidency.EU).fromEnv().build().baseUrl())
                .isEqualTo("https://eu.api.openai.com/v1")
        }
    }

    @Test
    fun copiedResidencyRejectsNewProviderConfiguration() {
        val authenticator =
            object : HttpRequestAuthenticator {
                override fun authenticate(request: HttpRequest): HttpRequest = request
            }
        val providers =
            listOf<(ClientOptions.Builder) -> Unit>(
                { it.credential(AzureApiKeyCredential.create("test-azure-key")) },
                { it.azureServiceVersion(AzureOpenAIServiceVersion.latestStableVersion()) },
                { it.azureUrlPathMode(AzureUrlPathMode.LEGACY) },
                { it.apiKey(null as String?).httpRequestAuthenticator(authenticator) },
            )
        val eu = builder().dataResidency(DataResidency.EU).build().toBuilder().build()
        for (provider in providers) {
            assertThrows<IllegalArgumentException> { eu.toBuilder().apply(provider).build() }
            for (baseUrlFirst in listOf(true, false)) {
                val replacement = eu.toBuilder()
                if (baseUrlFirst) replacement.baseUrl("https://example.openai.azure.com/openai/v1")
                provider(replacement)
                if (!baseUrlFirst) replacement.baseUrl("https://example.openai.azure.com/openai/v1")
                assertThat(replacement.build().baseUrl())
                    .isEqualTo("https://example.openai.azure.com/openai/v1")
            }
        }
        val client = OpenAIClientImpl(eu)
        assertThrows<IllegalArgumentException> {
            client.withOptions { it.credential(AzureApiKeyCredential.create("test-azure-key")) }
        }
        assertThrows<IllegalArgumentException> {
            client.async().withOptions { it.azureUrlPathMode(AzureUrlPathMode.UNIFIED) }
        }
        withBaseUrlProperty("https://example.openai.azure.com/openai/v1") {
            assertThat(eu.toBuilder().fromEnv().build().baseUrl()).isEqualTo(eu.baseUrl())
            assertThrows<IllegalArgumentException> {
                eu.toBuilder()
                    .fromEnv()
                    .credential(AzureApiKeyCredential.create("test-azure-key"))
                    .build()
            }
            assertThat(builder().fromEnv().build().baseUrl())
                .isEqualTo("https://example.openai.azure.com/openai/v1")
        }
    }

    private fun withBaseUrlProperty(url: String, block: () -> Unit) {
        val previous = System.getProperty("openai.baseUrl")
        System.setProperty("openai.baseUrl", url)
        try {
            block()
        } finally {
            if (previous == null) System.clearProperty("openai.baseUrl")
            else System.setProperty("openai.baseUrl", previous)
        }
    }
}
