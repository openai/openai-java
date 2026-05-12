package com.openai.auth

import com.fasterxml.jackson.databind.json.JsonMapper
import com.openai.core.http.Headers
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.errors.BadRequestException
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.util.concurrent.CompletableFuture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoInteractions
import org.mockito.kotlin.whenever

@ExtendWith(MockitoExtension::class)
internal class WorkloadIdentityAuthTest {

    private val httpClient = mock<HttpClient>()

    @Test
    fun getToken_propagatesProviderFailure() {
        val failure = IllegalStateException("provider failed")
        val auth =
            WorkloadIdentityAuth(
                config =
                    WorkloadIdentity.builder()
                        .clientId("client-id")
                        .identityProviderId("provider-id")
                        .serviceAccountId("service-account-id")
                        .provider(
                            object : SubjectTokenProvider {
                                override fun tokenType() = SubjectTokenType.JWT

                                override fun getToken(
                                    httpClient: HttpClient,
                                    jsonMapper: JsonMapper,
                                ): String {
                                    throw failure
                                }

                                override fun getTokenAsync(
                                    httpClient: HttpClient,
                                    jsonMapper: JsonMapper,
                                ): CompletableFuture<String> =
                                    CompletableFuture<String>().also {
                                        it.completeExceptionally(failure)
                                    }
                            }
                        )
                        .build(),
                httpClient = httpClient,
                jsonMapper = JsonMapper(),
            )

        val thrown = assertThrows<IllegalStateException> { auth.getToken() }

        org.assertj.core.api.Assertions.assertThat(thrown).isSameAs(failure)
        verifyNoInteractions(httpClient)
    }

    @Test
    fun getToken_success() {
        val subjectToken = "subject-token"
        val accessToken = "test-access-token"
        val oauthResponse =
            """
            {
                "access_token": "$accessToken",
                "issued_token_type": "urn:ietf:params:oauth:token-type:access_token",
                "token_type": "Bearer",
                "expires_in": 3600
            }
        """
                .trimIndent()

        val provider =
            object : SubjectTokenProvider {
                override fun tokenType() = SubjectTokenType.JWT

                override fun getToken(httpClient: HttpClient, jsonMapper: JsonMapper): String =
                    subjectToken

                override fun getTokenAsync(
                    httpClient: HttpClient,
                    jsonMapper: JsonMapper,
                ): CompletableFuture<String> = CompletableFuture.completedFuture(subjectToken)
            }

        val httpClient = mock<HttpClient>()
        val response = mockResponse(200, oauthResponse)
        whenever(httpClient.execute(any<HttpRequest>())).thenReturn(response)

        val auth =
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

        val token = auth.getToken()

        assertThat(token).isEqualTo(accessToken)
        verify(httpClient, times(1)).execute(any<HttpRequest>())
    }

    @Test
    fun getToken_omitsClientIdFromTokenExchangeRequestWhenUnset() {
        val subjectToken = "subject-token"
        val accessToken = "test-access-token"
        val oauthResponse =
            """
            {
                "access_token": "$accessToken",
                "issued_token_type": "urn:ietf:params:oauth:token-type:access_token",
                "token_type": "Bearer",
                "expires_in": 3600
            }
        """
                .trimIndent()

        val provider =
            object : SubjectTokenProvider {
                override fun tokenType() = SubjectTokenType.JWT

                override fun getToken(httpClient: HttpClient, jsonMapper: JsonMapper): String =
                    subjectToken

                override fun getTokenAsync(
                    httpClient: HttpClient,
                    jsonMapper: JsonMapper,
                ): CompletableFuture<String> = CompletableFuture.completedFuture(subjectToken)
            }

        val httpClient = mock<HttpClient>()
        val response = mockResponse(200, oauthResponse)
        var capturedRequest: HttpRequest? = null
        whenever(httpClient.execute(any<HttpRequest>())).thenAnswer { invocation ->
            capturedRequest = invocation.getArgument(0)
            response
        }

        val auth =
            WorkloadIdentityAuth(
                config =
                    WorkloadIdentity.builder()
                        .identityProviderId("provider-id")
                        .serviceAccountId("service-account-id")
                        .provider(provider)
                        .build(),
                httpClient = httpClient,
                jsonMapper = JsonMapper(),
            )

        val token = auth.getToken()

        val requestJson = requestJson(checkNotNull(capturedRequest))
        assertThat(token).isEqualTo(accessToken)
        assertThat(requestJson.has("client_id")).isFalse()
        assertThat(requestJson.get("grant_type").asText())
            .isEqualTo("urn:ietf:params:oauth:grant-type:token-exchange")
        assertThat(requestJson.get("subject_token").asText()).isEqualTo(subjectToken)
        assertThat(requestJson.get("identity_provider_id").asText()).isEqualTo("provider-id")
        assertThat(requestJson.get("service_account_id").asText()).isEqualTo("service-account-id")
    }

    @Test
    fun getToken_includesClientIdInTokenExchangeRequestWhenSet() {
        val subjectToken = "subject-token"
        val accessToken = "test-access-token"
        val oauthResponse =
            """
            {
                "access_token": "$accessToken",
                "issued_token_type": "urn:ietf:params:oauth:token-type:access_token",
                "token_type": "Bearer",
                "expires_in": 3600
            }
        """
                .trimIndent()

        val provider =
            object : SubjectTokenProvider {
                override fun tokenType() = SubjectTokenType.JWT

                override fun getToken(httpClient: HttpClient, jsonMapper: JsonMapper): String =
                    subjectToken

                override fun getTokenAsync(
                    httpClient: HttpClient,
                    jsonMapper: JsonMapper,
                ): CompletableFuture<String> = CompletableFuture.completedFuture(subjectToken)
            }

        val httpClient = mock<HttpClient>()
        val response = mockResponse(200, oauthResponse)
        var capturedRequest: HttpRequest? = null
        whenever(httpClient.execute(any<HttpRequest>())).thenAnswer { invocation ->
            capturedRequest = invocation.getArgument(0)
            response
        }

        val auth =
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

        val token = auth.getToken()

        val requestJson = requestJson(checkNotNull(capturedRequest))
        assertThat(token).isEqualTo(accessToken)
        assertThat(requestJson.get("client_id").asText()).isEqualTo("client-id")
    }

    @Test
    fun getToken_cachesToken() {
        val subjectToken = "subject-token"
        val accessToken = "test-access-token"
        val oauthResponse =
            """
            {
                "access_token": "$accessToken",
                "issued_token_type": "urn:ietf:params:oauth:token-type:access_token",
                "token_type": "Bearer",
                "expires_in": 3600
            }
        """
                .trimIndent()

        val provider =
            object : SubjectTokenProvider {
                override fun tokenType() = SubjectTokenType.JWT

                override fun getToken(httpClient: HttpClient, jsonMapper: JsonMapper): String =
                    subjectToken

                override fun getTokenAsync(
                    httpClient: HttpClient,
                    jsonMapper: JsonMapper,
                ): CompletableFuture<String> = CompletableFuture.completedFuture(subjectToken)
            }

        val httpClient = mock<HttpClient>()
        val response = mockResponse(200, oauthResponse)
        whenever(httpClient.execute(any<HttpRequest>())).thenReturn(response)

        val auth =
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

        val token1 = auth.getToken()
        val token2 = auth.getToken()

        assertThat(token1).isEqualTo(accessToken)
        assertThat(token2).isEqualTo(accessToken)
        verify(httpClient, times(1)).execute(any<HttpRequest>())
    }

    @Test
    fun getToken_refreshesExpiredToken() {
        val subjectToken = "subject-token"
        val accessToken1 = "test-access-token-1"
        val accessToken2 = "test-access-token-2"
        val oauthResponse1 =
            """
            {
                "access_token": "$accessToken1",
                "issued_token_type": "urn:ietf:params:oauth:token-type:access_token",
                "token_type": "Bearer",
                "expires_in": 1
            }
        """
                .trimIndent()
        val oauthResponse2 =
            """
            {
                "access_token": "$accessToken2",
                "issued_token_type": "urn:ietf:params:oauth:token-type:access_token",
                "token_type": "Bearer",
                "expires_in": 3600
            }
        """
                .trimIndent()

        val provider =
            object : SubjectTokenProvider {
                override fun tokenType() = SubjectTokenType.JWT

                override fun getToken(httpClient: HttpClient, jsonMapper: JsonMapper): String =
                    subjectToken

                override fun getTokenAsync(
                    httpClient: HttpClient,
                    jsonMapper: JsonMapper,
                ): CompletableFuture<String> = CompletableFuture.completedFuture(subjectToken)
            }

        val httpClient = mock<HttpClient>()
        val response1 = mockResponse(200, oauthResponse1)
        val response2 = mockResponse(200, oauthResponse2)
        whenever(httpClient.execute(any<HttpRequest>())).thenReturn(response1).thenReturn(response2)

        val auth =
            WorkloadIdentityAuth(
                config =
                    WorkloadIdentity.builder()
                        .clientId("client-id")
                        .identityProviderId("provider-id")
                        .serviceAccountId("service-account-id")
                        .provider(provider)
                        .refreshBufferSeconds(0)
                        .build(),
                httpClient = httpClient,
                jsonMapper = JsonMapper(),
            )

        val token1 = auth.getToken()
        Thread.sleep(1100)
        val token2 = auth.getToken()

        assertThat(token1).isEqualTo(accessToken1)
        assertThat(token2).isEqualTo(accessToken2)
        verify(httpClient, times(2)).execute(any<HttpRequest>())
    }

    @Test
    fun getToken_handlesOAuthError() {
        val subjectToken = "subject-token"
        val oauthErrorResponse =
            """
            {
                "error": "invalid_grant",
                "error_description": "The grant is invalid"
            }
            """
                .trimIndent()

        val provider =
            object : SubjectTokenProvider {
                override fun tokenType() = SubjectTokenType.JWT

                override fun getToken(httpClient: HttpClient, jsonMapper: JsonMapper): String =
                    subjectToken

                override fun getTokenAsync(
                    httpClient: HttpClient,
                    jsonMapper: JsonMapper,
                ): CompletableFuture<String> = CompletableFuture.completedFuture(subjectToken)
            }

        val httpClient = mock<HttpClient>()
        val response = mockResponse(400, oauthErrorResponse, stubHeaders = true)
        whenever(httpClient.execute(any<HttpRequest>())).thenReturn(response)

        val auth =
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

        val thrown = assertThrows<BadRequestException> { auth.getToken() }

        assertThat(thrown.statusCode()).isEqualTo(400)
        assertThat(thrown.code().get()).isEqualTo("invalid_grant")
        assertThat(thrown.message).contains("The grant is invalid")
    }

    @Test
    fun getToken_usesDefaultExpiry() {
        val subjectToken = "subject-token"
        val accessToken = "test-access-token"
        val oauthResponse =
            """
            {
                "access_token": "$accessToken",
                "issued_token_type": "urn:ietf:params:oauth:token-type:access_token",
                "token_type": "Bearer"
            }
        """
                .trimIndent()

        val provider =
            object : SubjectTokenProvider {
                override fun tokenType() = SubjectTokenType.JWT

                override fun getToken(httpClient: HttpClient, jsonMapper: JsonMapper): String =
                    subjectToken

                override fun getTokenAsync(
                    httpClient: HttpClient,
                    jsonMapper: JsonMapper,
                ): CompletableFuture<String> = CompletableFuture.completedFuture(subjectToken)
            }

        val httpClient = mock<HttpClient>()
        val response = mockResponse(200, oauthResponse)
        whenever(httpClient.execute(any<HttpRequest>())).thenReturn(response)

        val auth =
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

        val token1 = auth.getToken()
        val token2 = auth.getToken()

        assertThat(token1).isEqualTo(accessToken)
        assertThat(token2).isEqualTo(accessToken)
        verify(httpClient, times(1)).execute(any<HttpRequest>())
    }

    @Test
    fun invalidateToken_clearsCache() {
        val subjectToken = "subject-token"
        val accessToken1 = "test-access-token-1"
        val accessToken2 = "test-access-token-2"
        val oauthResponse1 =
            """
            {
                "access_token": "$accessToken1",
                "issued_token_type": "urn:ietf:params:oauth:token-type:access_token",
                "token_type": "Bearer",
                "expires_in": 3600
            }
        """
                .trimIndent()
        val oauthResponse2 =
            """
            {
                "access_token": "$accessToken2",
                "issued_token_type": "urn:ietf:params:oauth:token-type:access_token",
                "token_type": "Bearer",
                "expires_in": 3600
            }
        """
                .trimIndent()

        val provider =
            object : SubjectTokenProvider {
                override fun tokenType() = SubjectTokenType.JWT

                override fun getToken(httpClient: HttpClient, jsonMapper: JsonMapper): String =
                    subjectToken

                override fun getTokenAsync(
                    httpClient: HttpClient,
                    jsonMapper: JsonMapper,
                ): CompletableFuture<String> = CompletableFuture.completedFuture(subjectToken)
            }

        val httpClient = mock<HttpClient>()
        val response1 = mockResponse(200, oauthResponse1)
        val response2 = mockResponse(200, oauthResponse2)
        whenever(httpClient.execute(any<HttpRequest>())).thenReturn(response1).thenReturn(response2)

        val auth =
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

        val token1 = auth.getToken()
        auth.invalidateToken()
        val token2 = auth.getToken()

        assertThat(token1).isEqualTo(accessToken1)
        assertThat(token2).isEqualTo(accessToken2)
        verify(httpClient, times(2)).execute(any<HttpRequest>())
    }

    private fun mockResponse(
        statusCode: Int,
        body: String,
        stubHeaders: Boolean = false,
    ): HttpResponse {
        val response = mock<HttpResponse>()
        whenever(response.statusCode()).thenReturn(statusCode)
        if (stubHeaders) whenever(response.headers()).thenReturn(Headers.builder().build())
        whenever(response.body()).thenReturn(ByteArrayInputStream(body.toByteArray()))
        return response
    }

    private fun requestJson(request: HttpRequest) =
        JsonMapper().readTree(ByteArrayInputStream(requestBodyBytes(request)))

    private fun requestBodyBytes(request: HttpRequest): ByteArray {
        val outputStream = ByteArrayOutputStream()
        checkNotNull(request.body).writeTo(outputStream)
        return outputStream.toByteArray()
    }
}
