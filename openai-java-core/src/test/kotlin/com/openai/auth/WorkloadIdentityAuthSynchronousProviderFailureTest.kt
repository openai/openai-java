package com.openai.auth

import com.fasterxml.jackson.databind.json.JsonMapper
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import java.io.ByteArrayInputStream
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoInteractions
import org.mockito.kotlin.whenever

internal class WorkloadIdentityAuthSynchronousProviderFailureTest {

    @Test
    fun getTokenAsync_clearsForegroundRefreshAfterSynchronousProviderFailure() {
        val failure = IllegalStateException("provider failed")
        var providerCalls = 0
        val provider =
            object : SubjectTokenProvider {
                override fun tokenType() = SubjectTokenType.JWT

                override fun getToken(httpClient: HttpClient, jsonMapper: JsonMapper): String =
                    error("not used")

                override fun getTokenAsync(
                    httpClient: HttpClient,
                    jsonMapper: JsonMapper,
                ): CompletableFuture<String> {
                    providerCalls++
                    throw failure
                }
            }
        val httpClient = mock<HttpClient>()
        val auth = createAuth(provider, httpClient)

        val firstFailure = assertThrows<CompletionException> { auth.getTokenAsync().join() }
        val secondFailure = assertThrows<CompletionException> { auth.getTokenAsync().join() }

        assertThat(firstFailure.cause).isSameAs(failure)
        assertThat(secondFailure.cause).isSameAs(failure)
        assertThat(providerCalls).isEqualTo(2)
        verifyNoInteractions(httpClient)
    }

    @Test
    fun getTokenAsync_keepsCachedTokenAndAllowsAnotherBackgroundRefreshAfterSynchronousFailure() {
        val subjectToken = "subject-token"
        val accessToken = "access-token"
        val failure = IllegalStateException("provider failed")
        var asyncProviderCalls = 0
        val provider =
            object : SubjectTokenProvider {
                override fun tokenType() = SubjectTokenType.JWT

                override fun getToken(httpClient: HttpClient, jsonMapper: JsonMapper): String =
                    subjectToken

                override fun getTokenAsync(
                    httpClient: HttpClient,
                    jsonMapper: JsonMapper,
                ): CompletableFuture<String> {
                    asyncProviderCalls++
                    throw failure
                }
            }
        val httpClient = mock<HttpClient>()
        val response =
            mockResponse(
                200,
                """
                {
                    "access_token": "$accessToken",
                    "issued_token_type": "urn:ietf:params:oauth:token-type:access_token",
                    "token_type": "Bearer",
                    "expires_in": 60
                }
                """
                    .trimIndent(),
            )
        whenever(httpClient.execute(any<HttpRequest>())).thenReturn(response)
        val auth = createAuth(provider, httpClient)

        assertThat(auth.getToken()).isEqualTo(accessToken)
        assertThat(auth.getTokenAsync().join()).isEqualTo(accessToken)
        assertThat(auth.getTokenAsync().join()).isEqualTo(accessToken)

        assertThat(asyncProviderCalls).isEqualTo(2)
        verify(httpClient, times(1)).execute(any<HttpRequest>())
    }

    private fun createAuth(
        provider: SubjectTokenProvider,
        httpClient: HttpClient,
    ): WorkloadIdentityAuth =
        WorkloadIdentityAuth(
            config =
                WorkloadIdentity.builder()
                    .clientId("client-id")
                    .identityProviderId("provider-id")
                    .serviceAccountId("service-account-id")
                    .provider(provider)
                    .build(),
            httpClient = httpClient,
            jsonMapper = JsonMapper(),
        )

    private fun mockResponse(statusCode: Int, body: String): HttpResponse {
        val response = mock<HttpResponse>()
        whenever(response.statusCode()).thenReturn(statusCode)
        whenever(response.body()).thenAnswer { ByteArrayInputStream(body.toByteArray()) }
        return response
    }
}
