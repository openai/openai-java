package com.openai.core.http

import com.openai.auth.WorkloadIdentityAuth
import com.openai.core.RequestOptions
import com.openai.errors.OpenAIRetryableException
import java.util.concurrent.CompletableFuture

internal class WorkloadIdentityHttpClient(
    private val delegate: HttpClient,
    private val workloadIdentityAuth: WorkloadIdentityAuth,
) : HttpClient {

    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
        if (!workloadIdentityAuth.isX509) {
            return executeLegacy(request, requestOptions)
        }

        val attempt = executeWithToken(request, requestOptions)
        if (attempt.response.statusCode() != 401) {
            return attempt.response
        }

        workloadIdentityAuth.invalidateToken(attempt.token)
        if (!isReplayable(request)) {
            return attempt.response
        }

        attempt.response.close()
        return executeWithToken(request, requestOptions).let { retry ->
            if (retry.response.statusCode() == 401) {
                workloadIdentityAuth.invalidateToken(retry.token)
            }
            retry.response
        }
    }

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> {
        if (!workloadIdentityAuth.isX509) {
            return executeLegacyAsync(request, requestOptions)
        }

        return executeWithTokenAsync(request, requestOptions).thenCompose { attempt ->
            if (attempt.response.statusCode() != 401) {
                CompletableFuture.completedFuture(attempt.response)
            } else {
                workloadIdentityAuth.invalidateToken(attempt.token)
                if (!isReplayable(request)) {
                    CompletableFuture.completedFuture(attempt.response)
                } else {
                    attempt.response.close()
                    executeWithTokenAsync(request, requestOptions).thenApply { retry ->
                        if (retry.response.statusCode() == 401) {
                            workloadIdentityAuth.invalidateToken(retry.token)
                        }
                        retry.response
                    }
                }
            }
        }
    }

    private class AuthenticatedResponse(
        val token: WorkloadIdentityAuth.TokenLease,
        val response: HttpResponse,
    )

    private fun executeLegacy(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
        val response =
            delegate.execute(authenticate(request, workloadIdentityAuth.getToken()), requestOptions)
        if (response.statusCode() == 401) {
            response.close()
            workloadIdentityAuth.invalidateToken()
            throw OpenAIRetryableException("OAuth token is expired")
        }
        return response
    }

    private fun executeLegacyAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> =
        workloadIdentityAuth
            .getTokenAsync()
            .thenCompose { token ->
                delegate.executeAsync(authenticate(request, token), requestOptions)
            }
            .thenApply { response ->
                if (response.statusCode() == 401) {
                    response.close()
                    workloadIdentityAuth.invalidateToken()
                    throw OpenAIRetryableException("OAuth token is expired")
                }
                response
            }

    private fun executeWithToken(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): AuthenticatedResponse {
        val token = workloadIdentityAuth.getTokenLease()
        return AuthenticatedResponse(
            token,
            delegate.execute(authenticate(request, token.value), requestOptions),
        )
    }

    private fun executeWithTokenAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<AuthenticatedResponse> =
        workloadIdentityAuth.getTokenLeaseAsync().thenCompose { token ->
            delegate.executeAsync(authenticate(request, token.value), requestOptions).thenApply {
                response ->
                AuthenticatedResponse(token, response)
            }
        }

    private fun authenticate(request: HttpRequest, token: String): HttpRequest =
        request
            .toBuilder()
            .replaceHeaders("Authorization", "Bearer $token")
            .apply {
                if (workloadIdentityAuth.isX509) {
                    // X.509 transports present a client certificate, and bearer tokens must never
                    // be forwarded to a redirect target.
                    followRedirects(false)
                }
            }
            .build()

    private fun isReplayable(request: HttpRequest): Boolean = request.body?.repeatable() ?: true

    override fun close() {
        workloadIdentityAuth.close()
        delegate.close()
    }
}
