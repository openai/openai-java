package com.openai.core.http

import com.openai.auth.WorkloadIdentityAuth
import com.openai.core.RequestOptions
import com.openai.errors.OpenAIRetryableException
import java.util.concurrent.CompletableFuture

internal class WorkloadIdentityHttpClient(
    private val delegate: HttpClient,
    private val workloadIdentityAuth: WorkloadIdentityAuth?,
    private val authorizationRemoved: Boolean = false,
) : HttpClient {

    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
        if (workloadIdentityAuth == null || authorizationRemoved) {
            return delegate.execute(request, requestOptions)
        }

        val token = workloadIdentityAuth.getToken()
        val requestWithAuth =
            request.toBuilder().replaceHeaders("Authorization", "Bearer $token").build()

        return checkResponse(
            delegate.execute(requestWithAuth, requestOptions),
            workloadIdentityAuth,
        )
    }

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> {
        if (workloadIdentityAuth == null || authorizationRemoved) {
            return delegate.executeAsync(request, requestOptions)
        }

        return workloadIdentityAuth.getTokenAsync().thenCompose { token ->
            val requestWithAuth =
                request.toBuilder().replaceHeaders("Authorization", "Bearer $token").build()

            request.body
                .beforeMultipartTransport { delegate.executeAsync(requestWithAuth, requestOptions) }
                .thenApply { response -> checkResponse(response, workloadIdentityAuth) }
        }
    }

    private fun checkResponse(response: HttpResponse, auth: WorkloadIdentityAuth): HttpResponse {
        if (response.statusCode() != 401) return response

        val headers = response.use { it.headers() }
        auth.invalidateToken()
        throw OpenAIRetryableException("OAuth token is expired").apply { attachHeaders(headers) }
    }

    override fun close() {
        try {
            workloadIdentityAuth?.close()
        } catch (authFailure: Throwable) {
            try {
                delegate.close()
            } catch (delegateFailure: Throwable) {
                if (delegateFailure !== authFailure) {
                    authFailure.addSuppressed(delegateFailure)
                }
            }
            throw authFailure
        }
        delegate.close()
    }
}
