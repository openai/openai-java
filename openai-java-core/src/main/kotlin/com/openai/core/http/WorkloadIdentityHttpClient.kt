package com.openai.core.http

import com.openai.auth.WorkloadIdentityAuth
import com.openai.core.RequestOptions
import com.openai.errors.OpenAIRetryableException
import java.util.concurrent.CompletableFuture

internal class WorkloadIdentityHttpClient(
    private val delegate: HttpClient,
    private val workloadIdentityAuth: WorkloadIdentityAuth?,
) : HttpClient {

    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
        if (workloadIdentityAuth == null) {
            return delegate.execute(request, requestOptions)
        }

        val token = workloadIdentityAuth.getToken()
        val requestWithAuth =
            request.toBuilder().replaceHeaders("Authorization", "Bearer $token").build()

        val response = delegate.execute(requestWithAuth, requestOptions)

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
    ): CompletableFuture<HttpResponse> {
        if (workloadIdentityAuth == null) {
            return delegate.executeAsync(request, requestOptions)
        }

        return workloadIdentityAuth.getTokenAsync().thenCompose { token ->
            val requestWithAuth =
                request.toBuilder().replaceHeaders("Authorization", "Bearer $token").build()

            delegate.executeAsync(requestWithAuth, requestOptions).thenApply { response ->
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
