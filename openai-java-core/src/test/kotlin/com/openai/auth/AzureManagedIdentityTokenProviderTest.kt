package com.openai.auth

import com.fasterxml.jackson.databind.json.JsonMapper
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.errors.SubjectTokenProviderException
import java.io.ByteArrayInputStream
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutionException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExtendWith(MockitoExtension::class)
internal class AzureManagedIdentityTokenProviderTest {

    private val jsonMapper = JsonMapper()

    private fun SubjectTokenProvider.getToken(
        httpClient: HttpClient,
        jsonMapper: JsonMapper,
        async: Boolean,
    ): String =
        if (async) getTokenAsync(httpClient, jsonMapper).get() else getToken(httpClient, jsonMapper)

    private fun assertThrowsProviderException(
        async: Boolean,
        block: () -> Unit,
    ): SubjectTokenProviderException {
        return if (async) {
            val thrown = assertThrows<ExecutionException>(block)
            thrown.cause as SubjectTokenProviderException
        } else {
            assertThrows<SubjectTokenProviderException>(block)
        }
    }

    private fun mockHttpClient(async: Boolean, response: HttpResponse): HttpClient {
        val httpClient = mock<HttpClient>()
        if (async) {
            whenever(httpClient.executeAsync(any<HttpRequest>()))
                .thenReturn(CompletableFuture.completedFuture(response))
        } else {
            whenever(httpClient.execute(any<HttpRequest>())).thenReturn(response)
        }
        return httpClient
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun getToken_success(async: Boolean) {
        val expectedToken = "test-azure-access-token"
        val responseBody =
            """{
            "access_token": "$expectedToken",
            "refresh_token": "",
            "expires_in": "3599",
            "expires_on": "1600003600",
            "not_before": "1600000000",
            "resource": "https://management.azure.com/",
            "token_type": "Bearer"
        }"""

        val httpClient = mockHttpClient(async, mockResponse(200, responseBody))
        val provider = AzureManagedIdentityTokenProvider.builder().build()
        val token = provider.getToken(httpClient, jsonMapper, async)

        assertThat(token).isEqualTo(expectedToken)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun getToken_customResource(async: Boolean) {
        val expectedToken = "test-azure-custom-resource-token"
        val responseBody =
            """{
            "access_token": "$expectedToken",
            "expires_in": "3599",
            "resource": "https://cognitiveservices.azure.com/",
            "token_type": "Bearer"
        }"""

        val httpClient = mockHttpClient(async, mockResponse(200, responseBody))
        val provider =
            AzureManagedIdentityTokenProvider.builder()
                .resource("https://cognitiveservices.azure.com/")
                .build()

        val token = provider.getToken(httpClient, jsonMapper, async)

        assertThat(token).isEqualTo(expectedToken)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun getToken_404NotFound(async: Boolean) {
        val httpClient = mockHttpClient(async, mockResponse(404, "Not Found"))
        val provider = AzureManagedIdentityTokenProvider.builder().build()
        val exception =
            assertThrowsProviderException(async) {
                provider.getToken(httpClient, jsonMapper, async)
            }

        assertThat(exception.provider).isEqualTo("azure-imds")
        assertThat(exception.message).contains("IMDS returned status 404")
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun getToken_500InternalServerError(async: Boolean) {
        val httpClient = mockHttpClient(async, mockResponse(500, "Internal Server Error"))
        val provider = AzureManagedIdentityTokenProvider.builder().build()
        val exception =
            assertThrowsProviderException(async) {
                provider.getToken(httpClient, jsonMapper, async)
            }

        assertThat(exception.provider).isEqualTo("azure-imds")
        assertThat(exception.message).contains("IMDS returned status 500")
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun getToken_missingAccessToken(async: Boolean) {
        val responseBody =
            """{
            "expires_in": "3599",
            "resource": "https://management.azure.com/",
            "token_type": "Bearer"
        }"""

        val httpClient = mockHttpClient(async, mockResponse(200, responseBody))
        val provider = AzureManagedIdentityTokenProvider.builder().build()
        val exception =
            assertThrowsProviderException(async) {
                provider.getToken(httpClient, jsonMapper, async)
            }

        assertThat(exception.provider).isEqualTo("azure-imds")
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun getToken_customApiVersion(async: Boolean) {
        val expectedToken = "test-token"
        val responseBody =
            """{
            "access_token": "$expectedToken",
            "expires_in": "3599",
            "resource": "https://management.azure.com/",
            "token_type": "Bearer"
        }"""

        val httpClient = mockHttpClient(async, mockResponse(200, responseBody))
        val provider =
            AzureManagedIdentityTokenProvider.builder()
                .resource("https://api.openai.com")
                .apiVersion("2019-08-01")
                .build()

        val token = provider.getToken(httpClient, jsonMapper, async)

        assertThat(token).isEqualTo(expectedToken)
    }

    @Test
    fun builder_withDefaultParameters() {
        val provider = AzureManagedIdentityTokenProvider.builder().build()

        assertThat(provider).isNotNull
        assertThat(provider.tokenType()).isEqualTo(SubjectTokenType.JWT)
    }

    @Test
    fun builder_withAllParameters() {
        val provider =
            AzureManagedIdentityTokenProvider.builder()
                .resource("https://management.azure.com/")
                .apiVersion("2019-08-01")
                .build()

        assertThat(provider).isNotNull
        assertThat(provider.tokenType()).isEqualTo(SubjectTokenType.JWT)
    }

    private fun mockResponse(statusCode: Int, body: String): HttpResponse {
        val response = mock<HttpResponse>()
        whenever(response.statusCode()).thenReturn(statusCode)
        Mockito.lenient()
            .`when`(response.body())
            .thenReturn(ByteArrayInputStream(body.toByteArray()))
        return response
    }
}
