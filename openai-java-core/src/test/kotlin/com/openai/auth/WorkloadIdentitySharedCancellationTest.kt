package com.openai.auth

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonMapperBuilder
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.Headers
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class WorkloadIdentitySharedCancellationTest {
    private class Fixture(val pauseProvider: Boolean, val pauseIssuerOn: Int = 1) :
        HttpClient, SubjectTokenProvider {
        val provider = CompletableFuture<String>()
        val issuer = CompletableFuture<HttpResponse>()
        var providerCalls = 0
        var issuerCalls = 0
        var apiCalls = 0

        override fun tokenType() = SubjectTokenType.JWT

        override fun getToken(httpClient: HttpClient, jsonMapper: JsonMapper) = "synthetic-subject"

        override fun getTokenAsync(
            httpClient: HttpClient,
            jsonMapper: JsonMapper,
        ): CompletableFuture<String> {
            providerCalls++
            return if (pauseProvider) provider
            else CompletableFuture.completedFuture("synthetic-subject")
        }

        fun tokenResponse() =
            response(
                """{"access_token":"synthetic-issued","token_type":"Bearer","issued_token_type":"urn:ietf:params:oauth:token-type:access_token","expires_in":3600}"""
            )

        private fun response(body: String) =
            object : HttpResponse {
                override fun statusCode() = 200

                override fun headers() =
                    Headers.builder().put("Content-Type", "application/json").build()

                override fun body() = body.byteInputStream()

                override fun close() {}
            }

        override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse =
            error("async only")

        override fun executeAsync(
            request: HttpRequest,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            if (request.baseUrl.contains("auth.openai.com")) {
                issuerCalls++
                return if (!pauseProvider && issuerCalls == pauseIssuerOn) issuer
                else CompletableFuture.completedFuture(tokenResponse())
            }
            apiCalls++
            return CompletableFuture.completedFuture(
                response(
                    """{"id":"synthetic-model","created":0,"object":"model","owned_by":"synthetic"}"""
                )
            )
        }

        fun config() =
            WorkloadIdentity.builder()
                .identityProviderId("synthetic-idp")
                .serviceAccountId("synthetic-sa")
                .provider(this)
                .refreshBufferSeconds(7200)
                .build()

        fun options() =
            ClientOptions.builder()
                .baseUrl("https://sdk235.invalid")
                .workloadIdentity(config())
                .httpClient(this)
                .maxRetries(0)
                .build()

        fun active(): CompletableFuture<*> = if (pauseProvider) provider else issuer

        fun complete() {
            if (pauseProvider) provider.complete("synthetic-subject")
            else issuer.complete(tokenResponse())
        }

        override fun close() {}
    }

    @ParameterizedTest
    @ValueSource(booleans = [true, false])
    fun cancelingFirstHttpCallerKeepsSharedRefreshForSecond(pauseProvider: Boolean) {
        val fixture = Fixture(pauseProvider)
        val options = fixture.options()
        try {
            val first = options.httpClient.executeAsync(request(), RequestOptions.none())
            val second = options.httpClient.executeAsync(request(), RequestOptions.none())
            assertThat(first.cancel(true)).isTrue()
            assertThat(first.isCancelled).isTrue()
            assertThat(second.isDone).isFalse()
            assertThat(fixture.active().isCancelled).isFalse()
            fixture.complete()
            second.get(5, TimeUnit.SECONDS).use { assertThat(it.statusCode()).isEqualTo(200) }
            assertThat(fixture.providerCalls).isEqualTo(1)
            assertThat(fixture.issuerCalls).isEqualTo(1)
            assertThat(fixture.apiCalls).isEqualTo(1)
        } finally {
            options.close()
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [true, false])
    fun lastHttpWaiterCancellationStopsUnderlyingRefresh(pauseProvider: Boolean) {
        val fixture = Fixture(pauseProvider)
        val options = fixture.options()
        try {
            val first = options.httpClient.executeAsync(request(), RequestOptions.none())
            val second = options.httpClient.executeAsync(request(), RequestOptions.none())
            first.cancel(true)
            assertThat(fixture.active().isCancelled).isFalse()
            second.cancel(true)
            assertThat(fixture.active().isCancelled).isTrue()
            assertThat(fixture.apiCalls).isZero()
        } finally {
            options.close()
        }
    }

    private fun request() =
        HttpRequest.builder()
            .method(HttpMethod.GET)
            .baseUrl("https://sdk235.invalid")
            .addPathSegments("models", "synthetic-model")
            .build()

    @Test
    fun canceledWaiterDoesNotCancelCacheOwnedBackgroundRefresh() {
        val fixture = Fixture(pauseProvider = false, pauseIssuerOn = 2)
        val auth = WorkloadIdentityAuth(fixture.config(), fixture, jacksonMapperBuilder().build())
        try {
            assertThat(auth.getTokenAsync().get(5, TimeUnit.SECONDS)).isEqualTo("synthetic-issued")
            assertThat(auth.getTokenAsync().get(5, TimeUnit.SECONDS)).isEqualTo("synthetic-issued")
            auth.invalidateToken()
            val waiter = auth.getTokenAsync()
            assertThat(waiter.isDone).isFalse()
            waiter.cancel(true)
            assertThat(fixture.issuer.isCancelled).isFalse()
            fixture.issuer.complete(fixture.tokenResponse())
            assertThat(auth.getTokenAsync().get(5, TimeUnit.SECONDS)).isEqualTo("synthetic-issued")
        } finally {
            auth.close()
        }
    }
}
