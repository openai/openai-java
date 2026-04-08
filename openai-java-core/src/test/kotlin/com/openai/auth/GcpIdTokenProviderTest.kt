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
internal class GcpIdTokenProviderTest {

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
        val expectedToken = "test-gcp-id-token"

        val httpClient = mockHttpClient(async, mockResponse(200, expectedToken))
        val provider = GcpIdTokenProvider.builder().build()
        val token = provider.getToken(httpClient, jsonMapper, async)

        assertThat(token).isEqualTo(expectedToken)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun getToken_customAudience(async: Boolean) {
        val expectedToken = "test-gcp-custom-audience-token"

        val httpClient = mockHttpClient(async, mockResponse(200, expectedToken))
        val provider =
            GcpIdTokenProvider.builder().audience("https://custom-service.example.com").build()

        val token = provider.getToken(httpClient, jsonMapper, async)

        assertThat(token).isEqualTo(expectedToken)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun getToken_404NotFound(async: Boolean) {
        val httpClient = mockHttpClient(async, mockResponse(404, "Not Found"))
        val provider = GcpIdTokenProvider.builder().build()
        val exception =
            assertThrowsProviderException(async) {
                provider.getToken(httpClient, jsonMapper, async)
            }

        assertThat(exception.provider).isEqualTo("gcp-metadata")
        assertThat(exception.message).contains("metadata server returned status 404")
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun getToken_500InternalServerError(async: Boolean) {
        val httpClient = mockHttpClient(async, mockResponse(500, "Internal Server Error"))
        val provider = GcpIdTokenProvider.builder().build()
        val exception =
            assertThrowsProviderException(async) {
                provider.getToken(httpClient, jsonMapper, async)
            }

        assertThat(exception.provider).isEqualTo("gcp-metadata")
        assertThat(exception.message).contains("metadata server returned status 500")
    }

    @Test
    fun builder_withDefaultParameters() {
        val provider = GcpIdTokenProvider.builder().build()

        assertThat(provider).isNotNull
        assertThat(provider.tokenType()).isEqualTo(SubjectTokenType.ID)
    }

    @Test
    fun builder_withAllParameters() {
        val provider =
            GcpIdTokenProvider.builder().audience("https://custom-service.example.com").build()

        assertThat(provider).isNotNull
        assertThat(provider.tokenType()).isEqualTo(SubjectTokenType.ID)
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
