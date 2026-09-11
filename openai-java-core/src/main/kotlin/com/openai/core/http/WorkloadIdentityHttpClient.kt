package com.openai.core.http

import com.openai.auth.WorkloadIdentityAuth
import com.openai.core.RequestOptions
import com.openai.errors.OpenAIRetryableException
import java.util.concurrent.CompletableFuture

internal class WorkloadIdentityHttpClient(
    private val delegate: HttpClient,
    private val workloadIdentityAuth: WorkloadIdentityAuth?,
) : HttpClient {

    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse =
        execute(request) { delegate.execute(it, requestOptions) }

    override fun execute(
        request: HttpRequest,
        requestOptions: RequestOptions,
        observer: RequestObserver,
    ): HttpResponse = execute(request) { delegate.execute(it, requestOptions, observer) }

    private fun execute(
        request: HttpRequest,
        executeRequest: (HttpRequest) -> HttpResponse,
    ): HttpResponse {
        if (workloadIdentityAuth == null) {
            return executeRequest(request)
        }

        val token = workloadIdentityAuth.getToken()
        val requestWithAuth =
            request.toBuilder().replaceHeaders("Authorization", "Bearer $token").build()

        val response = executeRequest(requestWithAuth)

        if (response.statusCode() == 401) {
            response.close()
            workloadIdentityAuth.invalidateToken()
            throw OpenAIRetryableException("OAuth token is expired")
        }

        return response
    }

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> =
        executeAsync(request) { delegate.executeAsync(it, requestOptions) }

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
        observer: RequestObserver,
    ): CompletableFuture<HttpResponse> =
        executeAsync(request) { delegate.executeAsync(it, requestOptions, observer) }

    private fun executeAsync(
        request: HttpRequest,
        executeRequest: (HttpRequest) -> CompletableFuture<HttpResponse>,
    ): CompletableFuture<HttpResponse> {
        if (workloadIdentityAuth == null) {
            return executeRequest(request)
        }

        return workloadIdentityAuth.getTokenAsync().thenCompose { token ->
            val requestWithAuth =
                request.toBuilder().replaceHeaders("Authorization", "Bearer $token").build()

            executeRequest(requestWithAuth).thenApply { response ->
                if (response.statusCode() == 401) {
                    response.close()
                    workloadIdentityAuth.invalidateToken()
                    throw OpenAIRetryableException("OAuth token is expired")
                }

                response
            }
        }
    }

    override fun close() {
        workloadIdentityAuth?.close()
        delegate.close()
    }
}
