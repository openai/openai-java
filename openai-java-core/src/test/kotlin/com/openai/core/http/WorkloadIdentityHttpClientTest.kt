package com.openai.core.http

import com.openai.auth.WorkloadIdentityAuth
import com.openai.core.RequestOptions
import com.openai.errors.OpenAIRetryableException
import java.io.ByteArrayInputStream
import java.io.IOException
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
import org.mockito.kotlin.times
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
        whenever(workloadIdentityAuth.getTokenAsync(null))
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
        whenever(workloadIdentityAuth.getTokenAsync(null))
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

    @Test
    fun throwingCloseStillInvalidatesRejectedBearerSynchronously() =
        throwingCloseStillInvalidatesRejectedBearer(async = false)

    @Test
    fun throwingCloseStillInvalidatesRejectedBearerAsynchronously() =
        throwingCloseStillInvalidatesRejectedBearer(async = true)

    private fun throwingCloseStillInvalidatesRejectedBearer(async: Boolean) {
        val auth = mock<WorkloadIdentityAuth>()
        if (async) {
            whenever(auth.getTokenAsync(null))
                .thenReturn(
                    CompletableFuture.completedFuture("rejected"),
                    CompletableFuture.completedFuture("fresh"),
                )
        } else {
            whenever(auth.getToken()).thenReturn("rejected", "fresh")
        }
        val rejected =
            object : HttpResponse {
                override fun statusCode() = 401

                override fun headers() = Headers.builder().put("Retry-After", "1").build()

                override fun body(): InputStream = ByteArrayInputStream(byteArrayOf())

                override fun close() {
                    throw IOException("synthetic close failure")
                }
            }
        val seen = mutableListOf<String>()
        val delegate =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse {
                    seen += request.headers.values("Authorization").single()
                    return if (seen.size == 1) rejected else mockResponse(200, "success")
                }

                override fun executeAsync(request: HttpRequest, requestOptions: RequestOptions) =
                    CompletableFuture.completedFuture(execute(request, requestOptions))

                override fun close() {}
            }
        val client = WorkloadIdentityHttpClient(delegate, auth)
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl("https://api.openai.com/v1/models")
                .build()

        val failure =
            runCatching {
                    if (async) client.executeAsync(request, RequestOptions.none()).get()
                    else client.execute(request, RequestOptions.none())
                }
                .exceptionOrNull()
        if (async) assertThat(failure).isInstanceOf(ExecutionException::class.java)
        val error = if (failure is ExecutionException) failure.cause else failure
        assertThat(error).isInstanceOf(OpenAIRetryableException::class.java)
        assertThat(retryAfterHeaders(checkNotNull(error))?.values("Retry-After"))
            .containsExactly("1")
        assertThat(error.suppressed).hasSize(1)
        assertThat(error.suppressed.single()).isInstanceOf(IOException::class.java)
        verify(auth).invalidateToken()
        val successful =
            if (async) client.executeAsync(request, RequestOptions.none()).get()
            else client.execute(request, RequestOptions.none())
        assertThat(successful.statusCode()).isEqualTo(200)
        successful.close()
        assertThat(seen).containsExactly("Bearer rejected", "Bearer fresh")
        verify(auth, times(1)).invalidateToken()
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
