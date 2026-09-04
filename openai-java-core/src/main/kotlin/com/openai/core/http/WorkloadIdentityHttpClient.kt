package com.openai.core.http

import com.openai.auth.WorkloadIdentityAuth
import com.openai.core.CancellableFuture
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
            throw expiredToken(response.headers())
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

        return CancellableFuture.wrap(workloadIdentityAuth.getTokenAsync()).thenCompose { token ->
            val requestWithAuth =
                request.toBuilder().replaceHeaders("Authorization", "Bearer $token").build()

            CancellableFuture.wrap(delegate.executeAsync(requestWithAuth, requestOptions))
                .thenApply { response ->
                    if (response.statusCode() == 401) {
                        response.close()
                        workloadIdentityAuth.invalidateToken()
                        throw expiredToken(response.headers())
                    }

                    response
                }
        }
    }

    private fun expiredToken(headers: Headers): OpenAIRetryableException =
        OpenAIRetryableException("OAuth token is expired", WorkloadIdentityRetryHeaders(headers))

    override fun close() {
        workloadIdentityAuth?.close()
        delegate.close()
    }
}

/** Retry metadata retained after the rejected token response has been closed. */
internal class WorkloadIdentityRetryHeaders(val headers: Headers) :
    RuntimeException("Retry headers from an expired token response")
