package com.openai.client.okhttp

import com.github.tomakehurst.wiremock.client.WireMock.findAll
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.serviceUnavailable
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.temporaryRedirect
import com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.github.tomakehurst.wiremock.stubbing.Scenario
import com.openai.core.LogLevel
import com.openai.core.Sleeper
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.time.Clock
import java.time.Duration
import java.time.Instant
import java.time.ZoneOffset
import java.util.concurrent.CompletableFuture
import java.util.concurrent.atomic.AtomicInteger
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class BedrockOpenAIOkHttpClientTest {

    @Test
    fun retriesResolveFreshCredentialsAndSignAgain(wmRuntimeInfo: WireMockRuntimeInfo) {
        stubRetryingModelsResponse()
        val providerCalls = AtomicInteger()
        val provider = rotatingProvider(providerCalls)
        val client = client(wmRuntimeInfo.httpBaseUrl, provider)

        val models = client.models().list()

        assertThat(models.data()).isEmpty()
        assertThat(providerCalls).hasValue(2)
        verify(2, getRequestedFor(urlPathEqualTo("/models")))
        val requests = findAll(getRequestedFor(urlPathEqualTo("/models")))
        assertThat(requests[0].getHeader("Authorization")).contains("Credential=FIRSTACCESSKEY/")
        assertThat(requests[1].getHeader("Authorization")).contains("Credential=SECONDACCESSKEY/")
        client.close()
    }

    @Test
    fun asyncClientUsesTheSamePerAttemptSigningPath(wmRuntimeInfo: WireMockRuntimeInfo) {
        stubRetryingModelsResponse()
        val providerCalls = AtomicInteger()
        val client = client(wmRuntimeInfo.httpBaseUrl, rotatingProvider(providerCalls)).async()

        val models = client.models().list().join()

        assertThat(models.data()).isEmpty()
        assertThat(providerCalls).hasValue(2)
        verify(2, getRequestedFor(urlPathEqualTo("/models")))
        client.close()
    }

    @Test
    fun bearerProviderResolvesFreshTokenOnEveryRetry(wmRuntimeInfo: WireMockRuntimeInfo) {
        stubRetryingModelsResponse()
        val providerCalls = AtomicInteger()
        val client =
            BedrockOpenAIOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .bedrockTokenProvider { "token-${providerCalls.incrementAndGet()}" }
                .sleeper(NoopSleeper)
                .maxRetries(1)
                .build()

        val models = client.models().list()

        assertThat(models.data()).isEmpty()
        assertThat(providerCalls).hasValue(2)
        val requests = findAll(getRequestedFor(urlPathEqualTo("/models")))
        assertThat(requests.map { it.getHeader("Authorization") })
            .containsExactly("Bearer token-1", "Bearer token-2")
        client.close()
    }

    @Test
    fun skipAuthSendsUnsignedRequests(wmRuntimeInfo: WireMockRuntimeInfo) {
        stubFor(
            get(urlPathEqualTo("/models")).willReturn(okJson("{\"object\":\"list\",\"data\":[]}"))
        )
        val client =
            BedrockOpenAIOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .skipAuth(true)
                .maxRetries(0)
                .build()

        val models = client.models().list()

        assertThat(models.data()).isEmpty()
        assertThat(
                findAll(getRequestedFor(urlPathEqualTo("/models")))
                    .single()
                    .getHeader("Authorization")
            )
            .isNull()
        client.close()
    }

    @Test
    fun signedRequestsDoNotFollowRedirects(wmRuntimeInfo: WireMockRuntimeInfo) {
        stubFor(get(urlPathEqualTo("/models")).willReturn(temporaryRedirect("/redirected-models")))
        stubFor(
            get(urlPathEqualTo("/redirected-models"))
                .willReturn(okJson("{\"object\":\"list\",\"data\":[]}"))
        )
        val client =
            client(
                wmRuntimeInfo.httpBaseUrl,
                AwsCredentialsProvider {
                    AwsBasicCredentials.create("ACCESSKEY", "fixture-secret-access-key")
                },
            )

        assertThatThrownBy { client.models().list() }.isInstanceOf(RuntimeException::class.java)
        verify(1, getRequestedFor(urlPathEqualTo("/models")))
        verify(0, getRequestedFor(urlPathEqualTo("/redirected-models")))
        client.close()
    }

    @Test
    @ResourceLock("System.err")
    fun debugLogsRedactAwsAuthorizationAndSessionToken(wmRuntimeInfo: WireMockRuntimeInfo) {
        stubFor(
            get(urlPathEqualTo("/models")).willReturn(okJson("{\"object\":\"list\",\"data\":[]}"))
        )
        val originalError = System.err
        val logOutput = ByteArrayOutputStream()
        System.setErr(PrintStream(logOutput))

        try {
            val client =
                BedrockOpenAIOkHttpClient.builder()
                    .baseUrl(wmRuntimeInfo.httpBaseUrl)
                    .awsRegion("us-east-1")
                    .awsAccessKeyId("LOGACCESSKEY")
                    .awsSecretAccessKey("log-secret-access-key")
                    .awsSessionToken("log-session-token")
                    .logLevel(LogLevel.DEBUG)
                    .maxRetries(0)
                    .build()

            client.models().list()
            client.close()
        } finally {
            System.setErr(originalError)
        }

        val logs = logOutput.toString("UTF-8")
        assertThat(logs).contains("Authorization: ██")
        assertThat(logs).contains("X-Amz-Security-Token: ██")
        assertThat(logs).doesNotContain("LOGACCESSKEY")
        assertThat(logs).doesNotContain("log-secret-access-key")
        assertThat(logs).doesNotContain("log-session-token")
    }

    private fun client(baseUrl: String, provider: AwsCredentialsProvider) =
        BedrockOpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)
            .awsRegion("us-east-1")
            .awsCredentialsProvider(provider)
            .clock(Clock.fixed(Instant.parse("2026-06-01T12:34:56Z"), ZoneOffset.UTC))
            .sleeper(NoopSleeper)
            .maxRetries(1)
            .build()

    private fun rotatingProvider(providerCalls: AtomicInteger) = AwsCredentialsProvider {
        val accessKey =
            if (providerCalls.getAndIncrement() == 0) "FIRSTACCESSKEY" else "SECONDACCESSKEY"
        AwsBasicCredentials.create(accessKey, "fixture-secret-access-key")
    }

    private fun stubRetryingModelsResponse() {
        stubFor(
            get(urlPathEqualTo("/models"))
                .inScenario("retry")
                .whenScenarioStateIs(Scenario.STARTED)
                .willReturn(serviceUnavailable())
                .willSetStateTo("success")
        )
        stubFor(
            get(urlPathEqualTo("/models"))
                .inScenario("retry")
                .whenScenarioStateIs("success")
                .willReturn(okJson("{\"object\":\"list\",\"data\":[]}"))
        )
    }

    private object NoopSleeper : Sleeper {
        override fun sleep(duration: Duration) {}

        override fun sleepAsync(duration: Duration): CompletableFuture<Void> =
            CompletableFuture.completedFuture(null)

        override fun close() {}
    }
}
