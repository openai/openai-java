package com.openai.core.http

import com.openai.auth.WorkloadIdentityAuth
import com.openai.core.RequestOptions
import com.openai.errors.OpenAIRetryableException
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutionException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.argThat
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExtendWith(MockitoExtension::class)
internal class WorkloadIdentityHttpClientTest {

    @Test
    fun execute_injectsBearerToken() {
        val token = "test-token"
        val workloadIdentityAuth = mock<WorkloadIdentityAuth>()
        whenever(workloadIdentityAuth.getToken()).thenReturn(token)

        val delegateHttpClient = mock<HttpClient>()
        val response = mockResponse(200, "success")
        whenever(delegateHttpClient.execute(any(), any())).thenReturn(response)

        val client = WorkloadIdentityHttpClient(delegateHttpClient, workloadIdentityAuth)

        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl("https://api.openai.com/v1/models")
                .build()

        val result = client.execute(request, RequestOptions.none())

        assertThat(result.statusCode()).isEqualTo(200)
        verify(delegateHttpClient)
            .execute(
                argThat { req -> req.headers.values("Authorization").contains("Bearer $token") },
                any(),
            )
    }

    @Test
    fun execute_on401_invalidatesTokenAndThrowsRetryableException() {
        val token = "test-token"
        val workloadIdentityAuth = mock<WorkloadIdentityAuth>()
        whenever(workloadIdentityAuth.getToken()).thenReturn(token)

        val delegateHttpClient = mock<HttpClient>()
        val response401 = mockResponse(401, "Unauthorized")
        whenever(delegateHttpClient.execute(any(), any())).thenReturn(response401)

        val client = WorkloadIdentityHttpClient(delegateHttpClient, workloadIdentityAuth)

        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl("https://api.openai.com/v1/models")
                .build()

        assertThatThrownBy { client.execute(request, RequestOptions.none()) }
            .isInstanceOf(OpenAIRetryableException::class.java)
            .hasMessage("OAuth token is expired")

        verify(workloadIdentityAuth).invalidateToken()
    }

    @Test
    fun executeAsync_on401_invalidatesTokenAndThrowsRetryableException() {
        val token = "test-token"
        val workloadIdentityAuth = mock<WorkloadIdentityAuth>()
        whenever(workloadIdentityAuth.getTokenAsync())
            .thenReturn(CompletableFuture.completedFuture(token))

        val delegateHttpClient = mock<HttpClient>()
        val response401 = mockResponse(401, "Unauthorized")
        whenever(delegateHttpClient.executeAsync(any(), any()))
            .thenReturn(CompletableFuture.completedFuture(response401))

        val client = WorkloadIdentityHttpClient(delegateHttpClient, workloadIdentityAuth)

        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl("https://api.openai.com/v1/models")
                .build()

        assertThatThrownBy { client.executeAsync(request, RequestOptions.none()).get() }
            .isInstanceOf(ExecutionException::class.java)
            .hasCauseInstanceOf(OpenAIRetryableException::class.java)
            .cause()
            .hasMessage("OAuth token is expired")

        verify(workloadIdentityAuth).invalidateToken()
    }

    @Test
    fun executeAsync_injectsBearerToken() {
        val token = "test-token"
        val workloadIdentityAuth = mock<WorkloadIdentityAuth>()
        whenever(workloadIdentityAuth.getTokenAsync())
            .thenReturn(CompletableFuture.completedFuture(token))

        val delegateHttpClient = mock<HttpClient>()
        val response = mockResponse(200, "success")
        whenever(delegateHttpClient.executeAsync(any(), any()))
            .thenReturn(CompletableFuture.completedFuture(response))

        val client = WorkloadIdentityHttpClient(delegateHttpClient, workloadIdentityAuth)

        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl("https://api.openai.com/v1/models")
                .build()

        val resultFuture = client.executeAsync(request, RequestOptions.none())
        val result = resultFuture.get()

        assertThat(result.statusCode()).isEqualTo(200)
        verify(delegateHttpClient)
            .executeAsync(
                argThat { req -> req.headers.values("Authorization").contains("Bearer $token") },
                any(),
            )
    }

    private fun mockResponse(statusCode: Int, body: String): HttpResponse {
        return object : HttpResponse {
            override fun statusCode() = statusCode

            override fun headers() = Headers.builder().build()

            override fun body(): InputStream = ByteArrayInputStream(body.toByteArray())

            override fun close() {}
        }
    }
}
