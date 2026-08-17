package com.openai.core.http

import com.openai.auth.WorkloadIdentityAuth
import com.openai.core.RequestOptions
import com.openai.errors.OpenAIRetryableException
import java.net.URI
import java.net.URISyntaxException
import java.util.concurrent.CompletableFuture
import java.util.concurrent.atomic.AtomicInteger

internal class WorkloadIdentityHttpClient(
    private val delegate: HttpClient,
    private val workloadIdentityAuth: WorkloadIdentityAuth?,
    allowedApiBaseUrl: String,
) : HttpClient {

    private val allowedApiOrigin =
        requireNotNull(secureHttpsUri(allowedApiBaseUrl)) {
            "X.509 workload identity requires an absolute HTTPS base URL"
        }

    constructor(
        delegate: HttpClient,
        workloadIdentityAuth: WorkloadIdentityAuth?,
    ) : this(delegate, workloadIdentityAuth, "https://mtls.api.openai.com/v1")

    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
        val auth = workloadIdentityAuth ?: return delegate.execute(request, requestOptions)
        if (!auth.isX509) {
            return executeLegacy(request, requestOptions, auth)
        }

        requireAllowedApiOrigin(request)
        val retries = AtomicInteger()
        val attempt = executeWithToken(request, requestOptions, retries, auth)
        if (attempt.response.statusCode() != 401) {
            return attempt.response
        }

        auth.invalidateToken(attempt.token)
        if (!isReplayable(request)) {
            return attempt.response
        }

        attempt.response.close()
        return executeWithToken(request, requestOptions, retries, auth).let { retry ->
            if (retry.response.statusCode() == 401) {
                auth.invalidateToken(retry.token)
            }
            retry.response
        }
    }

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> {
        val auth = workloadIdentityAuth ?: return delegate.executeAsync(request, requestOptions)
        if (!auth.isX509) {
            return executeLegacyAsync(request, requestOptions, auth)
        }

        requireAllowedApiOrigin(request)
        val retries = AtomicInteger()
        val firstAttempt = executeWithTokenAsync(request, requestOptions, retries, auth)
        return firstAttempt.thenCompose { attempt ->
            if (attempt.response.statusCode() != 401) {
                CompletableFuture.completedFuture(attempt.response)
            } else {
                auth.invalidateToken(attempt.token)
                if (!isReplayable(request)) {
                    CompletableFuture.completedFuture(attempt.response)
                } else {
                    attempt.response.close()
                    val refreshedAttempt =
                        executeWithTokenAsync(request, requestOptions, retries, auth)
                    refreshedAttempt.thenApply { retry ->
                        if (retry.response.statusCode() == 401) {
                            auth.invalidateToken(retry.token)
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

    private fun executeLegacy(
        request: HttpRequest,
        requestOptions: RequestOptions,
        auth: WorkloadIdentityAuth,
    ): HttpResponse {
        val response =
            delegate.execute(authenticate(request, auth.getToken(), auth), requestOptions)
        if (response.statusCode() == 401) {
            response.close()
            auth.invalidateToken()
            throw OpenAIRetryableException("OAuth token is expired")
        }
        return response
    }

    private fun executeLegacyAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
        auth: WorkloadIdentityAuth,
    ): CompletableFuture<HttpResponse> =
        auth
            .getTokenAsync()
            .thenCompose { token ->
                delegate.executeAsync(authenticate(request, token, auth), requestOptions)
            }
            .thenApply { response ->
                if (response.statusCode() == 401) {
                    response.close()
                    auth.invalidateToken()
                    throw OpenAIRetryableException("OAuth token is expired")
                }
                response
            }

    private fun executeWithToken(
        request: HttpRequest,
        requestOptions: RequestOptions,
        retries: AtomicInteger,
        auth: WorkloadIdentityAuth,
    ): AuthenticatedResponse {
        val token = auth.getTokenLease()
        val authenticatedRequest = authenticate(request, token.value, auth)
        requireAllowedApiOrigin(authenticatedRequest)
        val response =
            if (delegate is RetryingHttpClient) {
                delegate.execute(authenticatedRequest, requestOptions, retries)
            } else {
                delegate.execute(authenticatedRequest, requestOptions)
            }
        return AuthenticatedResponse(token, response)
    }

    private fun executeWithTokenAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
        retries: AtomicInteger,
        auth: WorkloadIdentityAuth,
    ): CompletableFuture<AuthenticatedResponse> =
        auth.getTokenLeaseAsync().thenCompose { token ->
            val authenticatedRequest = authenticate(request, token.value, auth)
            requireAllowedApiOrigin(authenticatedRequest)
            val response =
                if (delegate is RetryingHttpClient) {
                    delegate.executeAsync(authenticatedRequest, requestOptions, retries)
                } else {
                    delegate.executeAsync(authenticatedRequest, requestOptions)
                }
            response.thenApply { AuthenticatedResponse(token, it) }
        }

    private fun authenticate(
        request: HttpRequest,
        token: String,
        auth: WorkloadIdentityAuth,
    ): HttpRequest =
        request
            .toBuilder()
            .replaceHeaders("Authorization", "Bearer $token")
            .apply {
                if (auth.isX509) {
                    // X.509 transports present a client certificate, and bearer tokens must never
                    // be forwarded to a redirect target.
                    followRedirects(false)
                }
            }
            .build()

    private fun requireAllowedApiOrigin(request: HttpRequest) {
        val destination = secureHttpsUri(request.url())
        require(
            destination != null &&
                allowedApiOrigin.host.equals(destination.host, ignoreCase = true) &&
                effectivePort(allowedApiOrigin) == effectivePort(destination)
        ) {
            "X.509 workload identity requests must remain on the configured HTTPS origin"
        }
    }

    private fun secureHttpsUri(value: String): URI? =
        try {
            URI.create(value).parseServerAuthority().takeIf { uri ->
                uri.isAbsolute &&
                    !uri.isOpaque &&
                    uri.scheme.equals("https", ignoreCase = true) &&
                    uri.host != null &&
                    uri.rawUserInfo == null &&
                    (uri.port == -1 || uri.port in 1..65535)
            }
        } catch (_: IllegalArgumentException) {
            null
        } catch (_: URISyntaxException) {
            null
        }

    private fun effectivePort(uri: URI): Int = if (uri.port == -1) 443 else uri.port

    private fun isReplayable(request: HttpRequest): Boolean = request.body?.repeatable() ?: true

    override fun close() {
        workloadIdentityAuth?.close()
        delegate.close()
    }
}
